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
import Logica.LeaderTeacher;
import Logica.LtEtnoeducacion;
import Logica.LtEtnoeducacionPK;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author cristian
 */
public class DaoLtEtnoeducacion implements Serializable {

    public DaoLtEtnoeducacion(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(LtEtnoeducacion ltEtnoeducacion) throws PreexistingEntityException, Exception {
        if (ltEtnoeducacion.getLtEtnoeducacionPK() == null) {
            ltEtnoeducacion.setLtEtnoeducacionPK(new LtEtnoeducacionPK());
        }
        ltEtnoeducacion.getLtEtnoeducacionPK().setCedulaLt(ltEtnoeducacion.getLeaderTeacher().getCedula());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LeaderTeacher leaderTeacher = ltEtnoeducacion.getLeaderTeacher();
            if (leaderTeacher != null) {
                leaderTeacher = em.getReference(leaderTeacher.getClass(), leaderTeacher.getCedula());
                ltEtnoeducacion.setLeaderTeacher(leaderTeacher);
            }
            em.persist(ltEtnoeducacion);
            if (leaderTeacher != null) {
                leaderTeacher.getLtEtnoeducacionList().add(ltEtnoeducacion);
                leaderTeacher = em.merge(leaderTeacher);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLtEtnoeducacion(ltEtnoeducacion.getLtEtnoeducacionPK()) != null) {
                throw new PreexistingEntityException("LtEtnoeducacion " + ltEtnoeducacion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(LtEtnoeducacion ltEtnoeducacion) throws NonexistentEntityException, Exception {
        ltEtnoeducacion.getLtEtnoeducacionPK().setCedulaLt(ltEtnoeducacion.getLeaderTeacher().getCedula());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LtEtnoeducacion persistentLtEtnoeducacion = em.find(LtEtnoeducacion.class, ltEtnoeducacion.getLtEtnoeducacionPK());
            LeaderTeacher leaderTeacherOld = persistentLtEtnoeducacion.getLeaderTeacher();
            LeaderTeacher leaderTeacherNew = ltEtnoeducacion.getLeaderTeacher();
            if (leaderTeacherNew != null) {
                leaderTeacherNew = em.getReference(leaderTeacherNew.getClass(), leaderTeacherNew.getCedula());
                ltEtnoeducacion.setLeaderTeacher(leaderTeacherNew);
            }
            ltEtnoeducacion = em.merge(ltEtnoeducacion);
            if (leaderTeacherOld != null && !leaderTeacherOld.equals(leaderTeacherNew)) {
                leaderTeacherOld.getLtEtnoeducacionList().remove(ltEtnoeducacion);
                leaderTeacherOld = em.merge(leaderTeacherOld);
            }
            if (leaderTeacherNew != null && !leaderTeacherNew.equals(leaderTeacherOld)) {
                leaderTeacherNew.getLtEtnoeducacionList().add(ltEtnoeducacion);
                leaderTeacherNew = em.merge(leaderTeacherNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                LtEtnoeducacionPK id = ltEtnoeducacion.getLtEtnoeducacionPK();
                if (findLtEtnoeducacion(id) == null) {
                    throw new NonexistentEntityException("The ltEtnoeducacion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(LtEtnoeducacionPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LtEtnoeducacion ltEtnoeducacion;
            try {
                ltEtnoeducacion = em.getReference(LtEtnoeducacion.class, id);
                ltEtnoeducacion.getLtEtnoeducacionPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ltEtnoeducacion with id " + id + " no longer exists.", enfe);
            }
            LeaderTeacher leaderTeacher = ltEtnoeducacion.getLeaderTeacher();
            if (leaderTeacher != null) {
                leaderTeacher.getLtEtnoeducacionList().remove(ltEtnoeducacion);
                leaderTeacher = em.merge(leaderTeacher);
            }
            em.remove(ltEtnoeducacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<LtEtnoeducacion> findLtEtnoeducacionEntities() {
        return findLtEtnoeducacionEntities(true, -1, -1);
    }

    public List<LtEtnoeducacion> findLtEtnoeducacionEntities(int maxResults, int firstResult) {
        return findLtEtnoeducacionEntities(false, maxResults, firstResult);
    }

    private List<LtEtnoeducacion> findLtEtnoeducacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(LtEtnoeducacion.class));
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

    public LtEtnoeducacion findLtEtnoeducacion(LtEtnoeducacionPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(LtEtnoeducacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getLtEtnoeducacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<LtEtnoeducacion> rt = cq.from(LtEtnoeducacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
