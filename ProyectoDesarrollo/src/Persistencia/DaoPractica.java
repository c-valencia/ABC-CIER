/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica.Fases;
import Logica.Practica;
import Logica.Tarea;
import Persistencia.exceptions.IllegalOrphanException;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author cristian
 */
public class DaoPractica implements Serializable {

    public DaoPractica(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Practica practica) throws PreexistingEntityException, Exception {
        if (practica.getTareaList() == null) {
            practica.setTareaList(new ArrayList<Tarea>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Fases idFase = practica.getIdFase();
            if (idFase != null) {
                idFase = em.getReference(idFase.getClass(), idFase.getIdFase());
                practica.setIdFase(idFase);
            }
            List<Tarea> attachedTareaList = new ArrayList<Tarea>();
            for (Tarea tareaListTareaToAttach : practica.getTareaList()) {
                tareaListTareaToAttach = em.getReference(tareaListTareaToAttach.getClass(), tareaListTareaToAttach.getTareaPK());
                attachedTareaList.add(tareaListTareaToAttach);
            }
            practica.setTareaList(attachedTareaList);
            em.persist(practica);
            if (idFase != null) {
                idFase.getPracticaList().add(practica);
                idFase = em.merge(idFase);
            }
            for (Tarea tareaListTarea : practica.getTareaList()) {
                Practica oldPracticaOfTareaListTarea = tareaListTarea.getPractica();
                tareaListTarea.setPractica(practica);
                tareaListTarea = em.merge(tareaListTarea);
                if (oldPracticaOfTareaListTarea != null) {
                    oldPracticaOfTareaListTarea.getTareaList().remove(tareaListTarea);
                    oldPracticaOfTareaListTarea = em.merge(oldPracticaOfTareaListTarea);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPractica(practica.getIdPractica()) != null) {
                throw new PreexistingEntityException("Practica " + practica + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Practica practica) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Practica persistentPractica = em.find(Practica.class, practica.getIdPractica());
            Fases idFaseOld = persistentPractica.getIdFase();
            Fases idFaseNew = practica.getIdFase();
            List<Tarea> tareaListOld = persistentPractica.getTareaList();
            List<Tarea> tareaListNew = practica.getTareaList();
            List<String> illegalOrphanMessages = null;
            for (Tarea tareaListOldTarea : tareaListOld) {
                if (!tareaListNew.contains(tareaListOldTarea)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Tarea " + tareaListOldTarea + " since its practica field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idFaseNew != null) {
                idFaseNew = em.getReference(idFaseNew.getClass(), idFaseNew.getIdFase());
                practica.setIdFase(idFaseNew);
            }
            List<Tarea> attachedTareaListNew = new ArrayList<Tarea>();
            for (Tarea tareaListNewTareaToAttach : tareaListNew) {
                tareaListNewTareaToAttach = em.getReference(tareaListNewTareaToAttach.getClass(), tareaListNewTareaToAttach.getTareaPK());
                attachedTareaListNew.add(tareaListNewTareaToAttach);
            }
            tareaListNew = attachedTareaListNew;
            practica.setTareaList(tareaListNew);
            practica = em.merge(practica);
            if (idFaseOld != null && !idFaseOld.equals(idFaseNew)) {
                idFaseOld.getPracticaList().remove(practica);
                idFaseOld = em.merge(idFaseOld);
            }
            if (idFaseNew != null && !idFaseNew.equals(idFaseOld)) {
                idFaseNew.getPracticaList().add(practica);
                idFaseNew = em.merge(idFaseNew);
            }
            for (Tarea tareaListNewTarea : tareaListNew) {
                if (!tareaListOld.contains(tareaListNewTarea)) {
                    Practica oldPracticaOfTareaListNewTarea = tareaListNewTarea.getPractica();
                    tareaListNewTarea.setPractica(practica);
                    tareaListNewTarea = em.merge(tareaListNewTarea);
                    if (oldPracticaOfTareaListNewTarea != null && !oldPracticaOfTareaListNewTarea.equals(practica)) {
                        oldPracticaOfTareaListNewTarea.getTareaList().remove(tareaListNewTarea);
                        oldPracticaOfTareaListNewTarea = em.merge(oldPracticaOfTareaListNewTarea);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = practica.getIdPractica();
                if (findPractica(id) == null) {
                    throw new NonexistentEntityException("The practica with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Practica practica;
            try {
                practica = em.getReference(Practica.class, id);
                practica.getIdPractica();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The practica with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Tarea> tareaListOrphanCheck = practica.getTareaList();
            for (Tarea tareaListOrphanCheckTarea : tareaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Practica (" + practica + ") cannot be destroyed since the Tarea " + tareaListOrphanCheckTarea + " in its tareaList field has a non-nullable practica field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Fases idFase = practica.getIdFase();
            if (idFase != null) {
                idFase.getPracticaList().remove(practica);
                idFase = em.merge(idFase);
            }
            em.remove(practica);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Practica> findPracticaEntities() {
        return findPracticaEntities(true, -1, -1);
    }

    public List<Practica> findPracticaEntities(int maxResults, int firstResult) {
        return findPracticaEntities(false, maxResults, firstResult);
    }

    private List<Practica> findPracticaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Practica.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Practica findPractica(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Practica.class, id);
        } finally {
            em.close();
        }
    }

    public int getPracticaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Practica> rt = cq.from(Practica.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
