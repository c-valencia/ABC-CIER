/** 
 * Nombre del Archivo: AreaFormacionJpaController.java 
 * Fecha de Creacion: 27/04/2015 
 * Autores: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750) 
 */

package Persistencia;

import Logica.AreaFormacion;
import Logica.AreaFormacionPK;
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


public class DaoAreaFormacion implements Serializable {

    public DaoAreaFormacion(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AreaFormacion areaFormacion) throws PreexistingEntityException, Exception {
        if (areaFormacion.getAreaFormacionPK() == null) {
            areaFormacion.setAreaFormacionPK(new AreaFormacionPK());
        }
        areaFormacion.getAreaFormacionPK().setCedulaLt(areaFormacion.getLeaderTeacher().getCedula());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LeaderTeacher leaderTeacher = areaFormacion.getLeaderTeacher();
            if (leaderTeacher != null) {
                leaderTeacher = em.getReference(leaderTeacher.getClass(), leaderTeacher.getCedula());
                areaFormacion.setLeaderTeacher(leaderTeacher);
            }
            em.persist(areaFormacion);
            if (leaderTeacher != null) {
                leaderTeacher.getAreaFormacionList().add(areaFormacion);
                leaderTeacher = em.merge(leaderTeacher);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAreaFormacion(areaFormacion.getAreaFormacionPK()) != null) {
                throw new PreexistingEntityException("AreaFormacion " + areaFormacion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AreaFormacion areaFormacion) throws NonexistentEntityException, Exception {
        areaFormacion.getAreaFormacionPK().setCedulaLt(areaFormacion.getLeaderTeacher().getCedula());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AreaFormacion persistentAreaFormacion = em.find(AreaFormacion.class, areaFormacion.getAreaFormacionPK());
            LeaderTeacher leaderTeacherOld = persistentAreaFormacion.getLeaderTeacher();
            LeaderTeacher leaderTeacherNew = areaFormacion.getLeaderTeacher();
            if (leaderTeacherNew != null) {
                leaderTeacherNew = em.getReference(leaderTeacherNew.getClass(), leaderTeacherNew.getCedula());
                areaFormacion.setLeaderTeacher(leaderTeacherNew);
            }
            areaFormacion = em.merge(areaFormacion);
            if (leaderTeacherOld != null && !leaderTeacherOld.equals(leaderTeacherNew)) {
                leaderTeacherOld.getAreaFormacionList().remove(areaFormacion);
                leaderTeacherOld = em.merge(leaderTeacherOld);
            }
            if (leaderTeacherNew != null && !leaderTeacherNew.equals(leaderTeacherOld)) {
                leaderTeacherNew.getAreaFormacionList().add(areaFormacion);
                leaderTeacherNew = em.merge(leaderTeacherNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                AreaFormacionPK id = areaFormacion.getAreaFormacionPK();
                if (findAreaFormacion(id) == null) {
                    throw new NonexistentEntityException("The areaFormacion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(AreaFormacionPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AreaFormacion areaFormacion;
            try {
                areaFormacion = em.getReference(AreaFormacion.class, id);
                areaFormacion.getAreaFormacionPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The areaFormacion with id " + id + " no longer exists.", enfe);
            }
            LeaderTeacher leaderTeacher = areaFormacion.getLeaderTeacher();
            if (leaderTeacher != null) {
                leaderTeacher.getAreaFormacionList().remove(areaFormacion);
                leaderTeacher = em.merge(leaderTeacher);
            }
            em.remove(areaFormacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AreaFormacion> findAreaFormacionEntities() {
        return findAreaFormacionEntities(true, -1, -1);
    }

    public List<AreaFormacion> findAreaFormacionEntities(int maxResults, int firstResult) {
        return findAreaFormacionEntities(false, maxResults, firstResult);
    }

    private List<AreaFormacion> findAreaFormacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AreaFormacion.class));
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

    public AreaFormacion findAreaFormacion(AreaFormacionPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AreaFormacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getAreaFormacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AreaFormacion> rt = cq.from(AreaFormacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

} // Fin de la clase DaoAreaFormacion
