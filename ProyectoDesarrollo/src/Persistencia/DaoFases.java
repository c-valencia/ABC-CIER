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
import Logica.Curso;
import Logica.Fases;
import Logica.Practica;
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
public class DaoFases implements Serializable {

    public DaoFases(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Fases fases) throws PreexistingEntityException, Exception {
        if (fases.getPracticaList() == null) {
            fases.setPracticaList(new ArrayList<Practica>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Curso idCurso = fases.getIdCurso();
            if (idCurso != null) {
                idCurso = em.getReference(idCurso.getClass(), idCurso.getIdCurso());
                fases.setIdCurso(idCurso);
            }
            List<Practica> attachedPracticaList = new ArrayList<Practica>();
            for (Practica practicaListPracticaToAttach : fases.getPracticaList()) {
                practicaListPracticaToAttach = em.getReference(practicaListPracticaToAttach.getClass(), practicaListPracticaToAttach.getIdPractica());
                attachedPracticaList.add(practicaListPracticaToAttach);
            }
            fases.setPracticaList(attachedPracticaList);
            em.persist(fases);
            if (idCurso != null) {
                idCurso.getFasesList().add(fases);
                idCurso = em.merge(idCurso);
            }
            for (Practica practicaListPractica : fases.getPracticaList()) {
                Fases oldIdFaseOfPracticaListPractica = practicaListPractica.getIdFase();
                practicaListPractica.setIdFase(fases);
                practicaListPractica = em.merge(practicaListPractica);
                if (oldIdFaseOfPracticaListPractica != null) {
                    oldIdFaseOfPracticaListPractica.getPracticaList().remove(practicaListPractica);
                    oldIdFaseOfPracticaListPractica = em.merge(oldIdFaseOfPracticaListPractica);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFases(fases.getIdFase()) != null) {
                throw new PreexistingEntityException("Fases " + fases + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Fases fases) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Fases persistentFases = em.find(Fases.class, fases.getIdFase());
            Curso idCursoOld = persistentFases.getIdCurso();
            Curso idCursoNew = fases.getIdCurso();
            List<Practica> practicaListOld = persistentFases.getPracticaList();
            List<Practica> practicaListNew = fases.getPracticaList();
            if (idCursoNew != null) {
                idCursoNew = em.getReference(idCursoNew.getClass(), idCursoNew.getIdCurso());
                fases.setIdCurso(idCursoNew);
            }
            List<Practica> attachedPracticaListNew = new ArrayList<Practica>();
            for (Practica practicaListNewPracticaToAttach : practicaListNew) {
                practicaListNewPracticaToAttach = em.getReference(practicaListNewPracticaToAttach.getClass(), practicaListNewPracticaToAttach.getIdPractica());
                attachedPracticaListNew.add(practicaListNewPracticaToAttach);
            }
            practicaListNew = attachedPracticaListNew;
            fases.setPracticaList(practicaListNew);
            fases = em.merge(fases);
            if (idCursoOld != null && !idCursoOld.equals(idCursoNew)) {
                idCursoOld.getFasesList().remove(fases);
                idCursoOld = em.merge(idCursoOld);
            }
            if (idCursoNew != null && !idCursoNew.equals(idCursoOld)) {
                idCursoNew.getFasesList().add(fases);
                idCursoNew = em.merge(idCursoNew);
            }
            for (Practica practicaListOldPractica : practicaListOld) {
                if (!practicaListNew.contains(practicaListOldPractica)) {
                    practicaListOldPractica.setIdFase(null);
                    practicaListOldPractica = em.merge(practicaListOldPractica);
                }
            }
            for (Practica practicaListNewPractica : practicaListNew) {
                if (!practicaListOld.contains(practicaListNewPractica)) {
                    Fases oldIdFaseOfPracticaListNewPractica = practicaListNewPractica.getIdFase();
                    practicaListNewPractica.setIdFase(fases);
                    practicaListNewPractica = em.merge(practicaListNewPractica);
                    if (oldIdFaseOfPracticaListNewPractica != null && !oldIdFaseOfPracticaListNewPractica.equals(fases)) {
                        oldIdFaseOfPracticaListNewPractica.getPracticaList().remove(practicaListNewPractica);
                        oldIdFaseOfPracticaListNewPractica = em.merge(oldIdFaseOfPracticaListNewPractica);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = fases.getIdFase();
                if (findFases(id) == null) {
                    throw new NonexistentEntityException("The fases with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Fases fases;
            try {
                fases = em.getReference(Fases.class, id);
                fases.getIdFase();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The fases with id " + id + " no longer exists.", enfe);
            }
            Curso idCurso = fases.getIdCurso();
            if (idCurso != null) {
                idCurso.getFasesList().remove(fases);
                idCurso = em.merge(idCurso);
            }
            List<Practica> practicaList = fases.getPracticaList();
            for (Practica practicaListPractica : practicaList) {
                practicaListPractica.setIdFase(null);
                practicaListPractica = em.merge(practicaListPractica);
            }
            em.remove(fases);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Fases> findFasesEntities() {
        return findFasesEntities(true, -1, -1);
    }

    public List<Fases> findFasesEntities(int maxResults, int firstResult) {
        return findFasesEntities(false, maxResults, firstResult);
    }

    private List<Fases> findFasesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Fases.class));
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

    public Fases findFases(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Fases.class, id);
        } finally {
            em.close();
        }
    }

    public int getFasesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Fases> rt = cq.from(Fases.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
