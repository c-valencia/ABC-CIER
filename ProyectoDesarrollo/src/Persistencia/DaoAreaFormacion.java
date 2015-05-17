package Persistencia;

import Logica.AreaFormacion;
import Logica.AreaFormacionPK;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Nombre del Archivo: DaoAreaFormacion.java
 Fecha de Creacion: 6/05/2015
 Autor: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750)  
 */

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
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(areaFormacion);
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
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            areaFormacion = em.merge(areaFormacion);
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
            em.remove(areaFormacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void destroyAll(String cedula){
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Query query = em.createNativeQuery("DELETE FROM area_formacion WHERE cedula_lt = " 
                    + "'" + cedula + "'");
            query.executeUpdate();
             em.getTransaction().commit();
        } catch (Exception ex){
            System.err.print(ex.getMessage());
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

    
    public List<AreaFormacion> findAreaFormacionAll(String id) {
        EntityManager em = getEntityManager();
        List<AreaFormacion> results = null;
        try {
            results = (List<AreaFormacion>) em.createNamedQuery("AreaFormacion.findByCedulaLt").setParameter("cedulaLt", id).getResultList();
            
        }catch(NoResultException noResultException) {        
//             Esta excepcion se lanza cuando no encuentra ningun registro que responda 
//             a la consulta
        }  finally {
            em.close();
        }
        return results;
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
