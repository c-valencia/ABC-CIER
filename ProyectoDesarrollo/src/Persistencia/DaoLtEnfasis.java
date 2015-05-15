package Persistencia;

import Logica.LtEnfasis;
import Logica.LtEnfasisPK;
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
 * Nombre del Archivo: DaoLtEnfasis.java
 Fecha de Creacion: 6/05/2015
 Autor: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750)  
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
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ltEnfasis);
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
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ltEnfasis = em.merge(ltEnfasis);
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
            em.remove(ltEnfasis);
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
            Query query = em.createNativeQuery("DELETE FROM lt_enfasis WHERE cedula_lt = " 
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
    

    public List<LtEnfasis> findLtEnfasisaAll(String id) {
        EntityManager em = getEntityManager();
        List<LtEnfasis> results = null;
        try {
            results = (List<LtEnfasis>) em.createNamedQuery("LtEnfasis.findByCedulaLt").setParameter("cedulaLt", id).getResultList();
            
        }catch(NoResultException noResultException) {        
//             Esta excepcion se lanza cuando no encuentra ningun registro que responda 
//             a la consulta
        }  finally {
            em.close();
        }
        return results;
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

} // Fin de la clase DaoLtEnfasis
