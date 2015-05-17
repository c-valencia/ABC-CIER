package Persistencia;

import Logica.LtEtnoeducacion;
import Logica.LtEtnoeducacionPK;
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
 * Nombre del Archivo: DaoLtEtnoeducacion.java
 Fecha de Creacion: 6/05/2015
 Autor: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750)  
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
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ltEtnoeducacion);
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
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ltEtnoeducacion = em.merge(ltEtnoeducacion);
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
            em.remove(ltEtnoeducacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroyAll(String cedula){
        EntityManager em  = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Query query = em.createNativeQuery("DELETE FROM lt_etnoeducacion WHERE cedula_lt = " 
                    + "'" + cedula + "'");
            query.executeUpdate();
             em.getTransaction().commit();
        } catch (Exception ex){
            System.err.print(ex.getMessage());
        }  finally {
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

    public List<LtEtnoeducacion> findLtEtnoeducacionAll(String id) {
        EntityManager em = getEntityManager();
        List<LtEtnoeducacion> results = null;
        try {
            results = (List<LtEtnoeducacion>) em.createNamedQuery("LtEtnoeducacion.findByCedulaLt").setParameter("cedulaLt", id).getResultList();
            
        }catch(NoResultException noResultException) {        
//             Esta excepcion se lanza cuando no encuentra ningun registro que responda 
//             a la consulta
        }  finally {
            em.close();
        }
        return results;
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

} // Fin de la clase DaoLtEtnoeducacion
