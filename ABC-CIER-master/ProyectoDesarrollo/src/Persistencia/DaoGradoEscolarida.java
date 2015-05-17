package Persistencia;

import Logica.GradoEscolarida;
import Logica.GradoEscolaridaPK;
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
 * Nombre del Archivo: DaoGradoEscolarida.java
 Fecha de Creacion: 6/05/2015
 Autor: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750)  
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
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(gradoEscolarida);
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
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            gradoEscolarida = em.merge(gradoEscolarida);
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
            em.remove(gradoEscolarida);
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
            Query query = em.createNativeQuery("DELETE FROM grado_escolarida WHERE cedula_lt = " 
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
    
    
    public List<GradoEscolarida> findGradoEscolaridaAll(String id) {
        EntityManager em = getEntityManager();
        List<GradoEscolarida> results = null;
        try {
            results = (List<GradoEscolarida>) em.createNamedQuery("GradoEscolarida.findByCedulaLt").setParameter("cedulaLt", id).getResultList();
            
        }catch(NoResultException noResultException) {        
//             Esta excepcion se lanza cuando no encuentra ningun registro que responda 
//             a la consulta
        }  finally {
            em.close();
        }
        return results;
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

} // Fin de la clase DaoGradoEscolarida
