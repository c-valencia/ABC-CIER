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
import Logica.Practica;
import Logica.LeaderTeacher;
import Logica.Tarea;
import Logica.TareaPK;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author cristian
 */
public class DaoTarea implements Serializable {

    public DaoTarea(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tarea tarea) throws PreexistingEntityException, Exception {
        if (tarea.getTareaPK() == null) {
            tarea.setTareaPK(new TareaPK());
        }
        tarea.getTareaPK().setIdPractica(tarea.getPractica().getIdPractica());
        tarea.getTareaPK().setCedulaLt(tarea.getLeaderTeacher().getCedula());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Practica practica = tarea.getPractica();
            if (practica != null) {
                practica = em.getReference(practica.getClass(), practica.getIdPractica());
                tarea.setPractica(practica);
            }
            LeaderTeacher leaderTeacher = tarea.getLeaderTeacher();
            if (leaderTeacher != null) {
                leaderTeacher = em.getReference(leaderTeacher.getClass(), leaderTeacher.getCedula());
                tarea.setLeaderTeacher(leaderTeacher);
            }
            em.persist(tarea);
            if (practica != null) {
                practica.getTareaList().add(tarea);
                practica = em.merge(practica);
            }
            if (leaderTeacher != null) {
                leaderTeacher.getTareaList().add(tarea);
                leaderTeacher = em.merge(leaderTeacher);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTarea(tarea.getTareaPK()) != null) {
                throw new PreexistingEntityException("Tarea " + tarea + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tarea tarea) throws NonexistentEntityException, Exception {
        tarea.getTareaPK().setIdPractica(tarea.getPractica().getIdPractica());
        tarea.getTareaPK().setCedulaLt(tarea.getLeaderTeacher().getCedula());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tarea persistentTarea = em.find(Tarea.class, tarea.getTareaPK());
            Practica practicaOld = persistentTarea.getPractica();
            Practica practicaNew = tarea.getPractica();
            LeaderTeacher leaderTeacherOld = persistentTarea.getLeaderTeacher();
            LeaderTeacher leaderTeacherNew = tarea.getLeaderTeacher();
            if (practicaNew != null) {
                practicaNew = em.getReference(practicaNew.getClass(), practicaNew.getIdPractica());
                tarea.setPractica(practicaNew);
            }
            if (leaderTeacherNew != null) {
                leaderTeacherNew = em.getReference(leaderTeacherNew.getClass(), leaderTeacherNew.getCedula());
                tarea.setLeaderTeacher(leaderTeacherNew);
            }
            tarea = em.merge(tarea);
            if (practicaOld != null && !practicaOld.equals(practicaNew)) {
                practicaOld.getTareaList().remove(tarea);
                practicaOld = em.merge(practicaOld);
            }
            if (practicaNew != null && !practicaNew.equals(practicaOld)) {
                practicaNew.getTareaList().add(tarea);
                practicaNew = em.merge(practicaNew);
            }
            if (leaderTeacherOld != null && !leaderTeacherOld.equals(leaderTeacherNew)) {
                leaderTeacherOld.getTareaList().remove(tarea);
                leaderTeacherOld = em.merge(leaderTeacherOld);
            }
            if (leaderTeacherNew != null && !leaderTeacherNew.equals(leaderTeacherOld)) {
                leaderTeacherNew.getTareaList().add(tarea);
                leaderTeacherNew = em.merge(leaderTeacherNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                TareaPK id = tarea.getTareaPK();
                if (findTarea(id) == null) {
                    throw new NonexistentEntityException("The tarea with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(TareaPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tarea tarea;
            try {
                tarea = em.getReference(Tarea.class, id);
                tarea.getTareaPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tarea with id " + id + " no longer exists.", enfe);
            }
            Practica practica = tarea.getPractica();
            if (practica != null) {
                practica.getTareaList().remove(tarea);
                practica = em.merge(practica);
            }
            LeaderTeacher leaderTeacher = tarea.getLeaderTeacher();
            if (leaderTeacher != null) {
                leaderTeacher.getTareaList().remove(tarea);
                leaderTeacher = em.merge(leaderTeacher);
            }
            em.remove(tarea);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tarea> findTareaEntities() {
        return findTareaEntities(true, -1, -1);
    }

    public List<Tarea> findTareaEntities(int maxResults, int firstResult) {
        return findTareaEntities(false, maxResults, firstResult);
    }

    private List<Tarea> findTareaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tarea.class));
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

    public Tarea findTarea(TareaPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tarea.class, id);
        } finally {
            em.close();
        }
    }

    public int getTareaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tarea> rt = cq.from(Tarea.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
