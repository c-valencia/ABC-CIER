/** 
 * Nombre del Archivo: AspiranteJpaController.java 
 * Fecha de Creacion: 27/04/2015 
 * Autores: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750) 
 */

package Persistencia;

import Logica.Aspirante;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class DaoAspirante implements Serializable {

    public DaoAspirante(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Aspirante aspirante) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(aspirante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAspirante(aspirante.getCedula()) != null) {
                throw new PreexistingEntityException("Aspirante " + aspirante + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Aspirante aspirante) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            aspirante = em.merge(aspirante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = aspirante.getCedula();
                if (findAspirante(id) == null) {
                    throw new NonexistentEntityException("The aspirante with id " + id + " no longer exists.");
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
            Aspirante aspirante;
            try {
                aspirante = em.getReference(Aspirante.class, id);
                aspirante.getCedula();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The aspirante with id " + id + " no longer exists.", enfe);
            }
            em.remove(aspirante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Aspirante> findAspiranteEntities() {
        return findAspiranteEntities(true, -1, -1);
    }

    public List<Aspirante> findAspiranteEntities(int maxResults, int firstResult) {
        return findAspiranteEntities(false, maxResults, firstResult);
    }

    private List<Aspirante> findAspiranteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Aspirante.class));
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

    public Aspirante findAspirante(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Aspirante.class, id);
        } finally {
            em.close();
        }
    }

    public int getAspiranteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Aspirante> rt = cq.from(Aspirante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

} // Fin de la clase DaoAspirante
