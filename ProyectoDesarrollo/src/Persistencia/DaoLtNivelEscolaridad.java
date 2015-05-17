package Persistencia;

import Logica.LtNivelEscolaridad;
import Logica.LtNivelEscolaridadPK;
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
 * Nombre del Archivo: DaoLtNivelEscolaridad.java
 Fecha de Creacion: 6/05/2015
 Autor: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750)  
 */

public class DaoLtNivelEscolaridad implements Serializable {

    public DaoLtNivelEscolaridad(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(LtNivelEscolaridad ltNivelEscolaridad) throws PreexistingEntityException, Exception {
        if (ltNivelEscolaridad.getLtNivelEscolaridadPK() == null) {
            ltNivelEscolaridad.setLtNivelEscolaridadPK(new LtNivelEscolaridadPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ltNivelEscolaridad);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLtNivelEscolaridad(ltNivelEscolaridad.getLtNivelEscolaridadPK()) != null) {
                throw new PreexistingEntityException("LtNivelEscolaridad " + ltNivelEscolaridad + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(LtNivelEscolaridad ltNivelEscolaridad) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ltNivelEscolaridad = em.merge(ltNivelEscolaridad);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                LtNivelEscolaridadPK id = ltNivelEscolaridad.getLtNivelEscolaridadPK();
                if (findLtNivelEscolaridad(id) == null) {
                    throw new NonexistentEntityException("The ltNivelEscolaridad with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(LtNivelEscolaridadPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LtNivelEscolaridad ltNivelEscolaridad;
            try {
                ltNivelEscolaridad = em.getReference(LtNivelEscolaridad.class, id);
                ltNivelEscolaridad.getLtNivelEscolaridadPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ltNivelEscolaridad with id " + id + " no longer exists.", enfe);
            }
            em.remove(ltNivelEscolaridad);
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
            Query query = em.createNativeQuery("DELETE FROM lt_nivel_escolaridad WHERE cedula_lt =" 
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

    public List<LtNivelEscolaridad> findLtNivelEscolaridadEntities() {
        return findLtNivelEscolaridadEntities(true, -1, -1);
    }

    public List<LtNivelEscolaridad> findLtNivelEscolaridadEntities(int maxResults, int firstResult) {
        return findLtNivelEscolaridadEntities(false, maxResults, firstResult);
    }

    private List<LtNivelEscolaridad> findLtNivelEscolaridadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(LtNivelEscolaridad.class));
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

    public LtNivelEscolaridad findLtNivelEscolaridad(LtNivelEscolaridadPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(LtNivelEscolaridad.class, id);
        } finally {
            em.close();
        }
    }

        public List<LtNivelEscolaridad> findLtNivelEscolaridadAll(String id) {
        EntityManager em = getEntityManager();
        List<LtNivelEscolaridad> results = null;
        try {
            results = (List<LtNivelEscolaridad>) em.createNamedQuery("LtNivelEscolaridad.findByCedulaLt").setParameter("cedulaLt", id).getResultList();
            
        }catch(NoResultException noResultException) {        
//             Esta excepcion se lanza cuando no encuentra ningun registro que responda 
//             a la consulta
        }  finally {
            em.close();
        }
        return results;
    }  
    
    public int getLtNivelEscolaridadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<LtNivelEscolaridad> rt = cq.from(LtNivelEscolaridad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

} // Fin de la clase DaoLtNivelEscolaridad
