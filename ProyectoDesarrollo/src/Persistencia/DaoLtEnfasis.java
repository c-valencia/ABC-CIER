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
import Logica.LtEnfasis;
import Logica.LtEnfasisPK;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author cristian
 */
public class DaoLtEnfasis implements Serializable {

    public DaoLtEnfasis(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(LtEnfasis ltEnfasis) throws PreexistingEntityException, Exception {
        if (ltEnfasis.getLtEnfasisPK() == null) {
            ltEnfasis.setLtEnfasisPK(new LtEnfasisPK());
        }
        ltEnfasis.getLtEnfasisPK().setCedulaLt(ltEnfasis.getLeaderTeacher().getCedula());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LeaderTeacher leaderTeacher = ltEnfasis.getLeaderTeacher();
            if (leaderTeacher != null) {
                leaderTeacher = em.getReference(leaderTeacher.getClass(), leaderTeacher.getCedula());
                ltEnfasis.setLeaderTeacher(leaderTeacher);
            }
            em.persist(ltEnfasis);
            if (leaderTeacher != null) {
                leaderTeacher.getLtEnfasisList().add(ltEnfasis);
                leaderTeacher = em.merge(leaderTeacher);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLtEnfasis(ltEnfasis.getLtEnfasisPK()) != null) {
                throw new PreexistingEntityException("LtEnfasis " + ltEnfasis + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(LtEnfasis ltEnfasis) throws NonexistentEntityException, Exception {
        ltEnfasis.getLtEnfasisPK().setCedulaLt(ltEnfasis.getLeaderTeacher().getCedula());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LtEnfasis persistentLtEnfasis = em.find(LtEnfasis.class, ltEnfasis.getLtEnfasisPK());
            LeaderTeacher leaderTeacherOld = persistentLtEnfasis.getLeaderTeacher();
            LeaderTeacher leaderTeacherNew = ltEnfasis.getLeaderTeacher();
            if (leaderTeacherNew != null) {
                leaderTeacherNew = em.getReference(leaderTeacherNew.getClass(), leaderTeacherNew.getCedula());
                ltEnfasis.setLeaderTeacher(leaderTeacherNew);
            }
            ltEnfasis = em.merge(ltEnfasis);
            if (leaderTeacherOld != null && !leaderTeacherOld.equals(leaderTeacherNew)) {
                leaderTeacherOld.getLtEnfasisList().remove(ltEnfasis);
                leaderTeacherOld = em.merge(leaderTeacherOld);
            }
            if (leaderTeacherNew != null && !leaderTeacherNew.equals(leaderTeacherOld)) {
                leaderTeacherNew.getLtEnfasisList().add(ltEnfasis);
                leaderTeacherNew = em.merge(leaderTeacherNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                LtEnfasisPK id = ltEnfasis.getLtEnfasisPK();
                if (findLtEnfasis(id) == null) {
                    throw new NonexistentEntityException("The ltEnfasis with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(LtEnfasisPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LtEnfasis ltEnfasis;
            try {
                ltEnfasis = em.getReference(LtEnfasis.class, id);
                ltEnfasis.getLtEnfasisPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ltEnfasis with id " + id + " no longer exists.", enfe);
            }
            LeaderTeacher leaderTeacher = ltEnfasis.getLeaderTeacher();
            if (leaderTeacher != null) {
                leaderTeacher.getLtEnfasisList().remove(ltEnfasis);
                leaderTeacher = em.merge(leaderTeacher);
            }
            em.remove(ltEnfasis);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<LtEnfasis> findLtEnfasisEntities() {
        return findLtEnfasisEntities(true, -1, -1);
    }

    public List<LtEnfasis> findLtEnfasisEntities(int maxResults, int firstResult) {
        return findLtEnfasisEntities(false, maxResults, firstResult);
    }

    private List<LtEnfasis> findLtEnfasisEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(LtEnfasis.class));
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

    public LtEnfasis findLtEnfasis(LtEnfasisPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(LtEnfasis.class, id);
        } finally {
            em.close();
        }
    }

    public int getLtEnfasisCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<LtEnfasis> rt = cq.from(LtEnfasis.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
