package Persistencia;

import Logica.LeaderTeacher;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Nombre del Archivo: DaoLeaderTeacher.java
 Fecha de Creacion: 6/05/2015
 Autor: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750)  
 */

public class DaoLeaderTeacher implements Serializable {

    public DaoLeaderTeacher(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(LeaderTeacher leaderTeacher) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(leaderTeacher);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLeaderTeacher(leaderTeacher.getCedula()) != null) {
                throw new PreexistingEntityException("LeaderTeacher " + leaderTeacher + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(LeaderTeacher leaderTeacher) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            leaderTeacher = em.merge(leaderTeacher);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = leaderTeacher.getCedula();
                if (findLeaderTeacher(id) == null) {
                    throw new NonexistentEntityException("The leaderTeacher with id " + id + " no longer exists.");
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
            LeaderTeacher leaderTeacher;
            try {
                leaderTeacher = em.getReference(LeaderTeacher.class, id);
                leaderTeacher.getCedula();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The leaderTeacher with id " + id + " no longer exists.", enfe);
            }
            em.remove(leaderTeacher);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }    

    public List<LeaderTeacher> findLeaderTeacherEntities() {
        return findLeaderTeacherEntities(true, -1, -1);
    }

    public List<LeaderTeacher> findLeaderTeacherEntities(int maxResults, int firstResult) {
        return findLeaderTeacherEntities(false, maxResults, firstResult);
    }

    private List<LeaderTeacher> findLeaderTeacherEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(LeaderTeacher.class));
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

    public LeaderTeacher findLeaderTeacher(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(LeaderTeacher.class, id);
        } finally {
            em.close();
        }
    }

    public LeaderTeacher findLeaderTeacherCorreo(String correo){
        EntityManager em = getEntityManager();
        LeaderTeacher objLeaderTeacher = null;
        try {
            objLeaderTeacher = (LeaderTeacher) em.createNamedQuery("LeaderTeacher.findByCorreo").setParameter("correo", correo).getSingleResult();
        } catch(NoResultException noResultException) {        
            // Esta excepcion se lanza cuando no encuentra ningun registro que responda 
            // a la consulta
        } finally {
            em.close();
        }
        return objLeaderTeacher;        
    } // Fin del metodo findLeaderTeacherCorreo    
    
    
    public int updateStatus (String id, String status) {
        EntityManager em = getEntityManager();
        int result = -1;
        try {          
            em.getTransaction().begin();
            Query query = em.createNativeQuery("UPDATE leader_teacher SET estado ='"   + status +  "'"
                    +  " WHERE cedula ='"+ id + "'");
            query.executeUpdate();
            em.getTransaction().commit();
            result = 1;
        } catch (Exception ex){
            System.err.print(ex.getMessage());
        }finally {
            if (em != null) {
                em.close();
            }
        }    
        return result;
    } // Fin del metodo updateStatus
    
    public int getLeaderTeacherCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<LeaderTeacher> rt = cq.from(LeaderTeacher.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

} // Fin de la clase DaoLeaderTeacher
