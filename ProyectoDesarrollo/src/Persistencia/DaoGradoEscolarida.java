/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.GradoEscolarida;
import Logica.GradoEscolaridaPK;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica.LeaderTeacher;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author cristian
 */
public class DaoGradoEscolarida implements Serializable {

    public DaoGradoEscolarida(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(GradoEscolarida gradoEscolarida) throws PreexistingEntityException, Exception {
        if (gradoEscolarida.getGradoEscolaridaPK() == null) {
            gradoEscolarida.setGradoEscolaridaPK(new GradoEscolaridaPK());
        }
        gradoEscolarida.getGradoEscolaridaPK().setCedulaLt(gradoEscolarida.getLeaderTeacher().getCedula());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LeaderTeacher leaderTeacher = gradoEscolarida.getLeaderTeacher();
            if (leaderTeacher != null) {
                leaderTeacher = em.getReference(leaderTeacher.getClass(), leaderTeacher.getCedula());
                gradoEscolarida.setLeaderTeacher(leaderTeacher);
            }
            em.persist(gradoEscolarida);
            if (leaderTeacher != null) {
                leaderTeacher.getGradoEscolaridaList().add(gradoEscolarida);
                leaderTeacher = em.merge(leaderTeacher);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findGradoEscolarida(gradoEscolarida.getGradoEscolaridaPK()) != null) {
                throw new PreexistingEntityException("GradoEscolarida " + gradoEscolarida + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(GradoEscolarida gradoEscolarida) throws NonexistentEntityException, Exception {
        gradoEscolarida.getGradoEscolaridaPK().setCedulaLt(gradoEscolarida.getLeaderTeacher().getCedula());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            GradoEscolarida persistentGradoEscolarida = em.find(GradoEscolarida.class, gradoEscolarida.getGradoEscolaridaPK());
            LeaderTeacher leaderTeacherOld = persistentGradoEscolarida.getLeaderTeacher();
            LeaderTeacher leaderTeacherNew = gradoEscolarida.getLeaderTeacher();
            if (leaderTeacherNew != null) {
                leaderTeacherNew = em.getReference(leaderTeacherNew.getClass(), leaderTeacherNew.getCedula());
                gradoEscolarida.setLeaderTeacher(leaderTeacherNew);
            }
            gradoEscolarida = em.merge(gradoEscolarida);
            if (leaderTeacherOld != null && !leaderTeacherOld.equals(leaderTeacherNew)) {
                leaderTeacherOld.getGradoEscolaridaList().remove(gradoEscolarida);
                leaderTeacherOld = em.merge(leaderTeacherOld);
            }
            if (leaderTeacherNew != null && !leaderTeacherNew.equals(leaderTeacherOld)) {
                leaderTeacherNew.getGradoEscolaridaList().add(gradoEscolarida);
                leaderTeacherNew = em.merge(leaderTeacherNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                GradoEscolaridaPK id = gradoEscolarida.getGradoEscolaridaPK();
                if (findGradoEscolarida(id) == null) {
                    throw new NonexistentEntityException("The gradoEscolarida with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(GradoEscolaridaPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            GradoEscolarida gradoEscolarida;
            try {
                gradoEscolarida = em.getReference(GradoEscolarida.class, id);
                gradoEscolarida.getGradoEscolaridaPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The gradoEscolarida with id " + id + " no longer exists.", enfe);
            }
            LeaderTeacher leaderTeacher = gradoEscolarida.getLeaderTeacher();
            if (leaderTeacher != null) {
                leaderTeacher.getGradoEscolaridaList().remove(gradoEscolarida);
                leaderTeacher = em.merge(leaderTeacher);
            }
            em.remove(gradoEscolarida);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<GradoEscolarida> findGradoEscolaridaEntities() {
        return findGradoEscolaridaEntities(true, -1, -1);
    }

    public List<GradoEscolarida> findGradoEscolaridaEntities(int maxResults, int firstResult) {
        return findGradoEscolaridaEntities(false, maxResults, firstResult);
    }

    private List<GradoEscolarida> findGradoEscolaridaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(GradoEscolarida.class));
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

    public GradoEscolarida findGradoEscolarida(GradoEscolaridaPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(GradoEscolarida.class, id);
        } finally {
            em.close();
        }
    }

    public int getGradoEscolaridaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<GradoEscolarida> rt = cq.from(GradoEscolarida.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
