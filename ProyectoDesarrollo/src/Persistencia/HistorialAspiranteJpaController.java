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
import Logica.Aspirante;
import Logica.HistorialAspirante;
import Logica.HistorialAspirantePK;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author julian
 */
public class HistorialAspiranteJpaController implements Serializable {

    public HistorialAspiranteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(HistorialAspirante historialAspirante) throws PreexistingEntityException, Exception {
        if (historialAspirante.getHistorialAspirantePK() == null) {
            historialAspirante.setHistorialAspirantePK(new HistorialAspirantePK());
        }
        historialAspirante.getHistorialAspirantePK().setIdCurso(historialAspirante.getCurso().getIdCurso());
        historialAspirante.getHistorialAspirantePK().setCedulaAs(historialAspirante.getAspirante().getCedula());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Aspirante aspirante = historialAspirante.getAspirante();
            if (aspirante != null) {
                aspirante = em.getReference(aspirante.getClass(), aspirante.getCedula());
                historialAspirante.setAspirante(aspirante);
            }
            em.persist(historialAspirante);
            if (aspirante != null) {
                aspirante.getHistorialAspiranteCollection().add(historialAspirante);
                aspirante = em.merge(aspirante);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findHistorialAspirante(historialAspirante.getHistorialAspirantePK()) != null) {
                throw new PreexistingEntityException("HistorialAspirante " + historialAspirante + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HistorialAspirante historialAspirante) throws NonexistentEntityException, Exception {
        historialAspirante.getHistorialAspirantePK().setIdCurso(historialAspirante.getCurso().getIdCurso());
        historialAspirante.getHistorialAspirantePK().setCedulaAs(historialAspirante.getAspirante().getCedula());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HistorialAspirante persistentHistorialAspirante = em.find(HistorialAspirante.class, historialAspirante.getHistorialAspirantePK());
            Aspirante aspiranteOld = persistentHistorialAspirante.getAspirante();
            Aspirante aspiranteNew = historialAspirante.getAspirante();
            if (aspiranteNew != null) {
                aspiranteNew = em.getReference(aspiranteNew.getClass(), aspiranteNew.getCedula());
                historialAspirante.setAspirante(aspiranteNew);
            }
            historialAspirante = em.merge(historialAspirante);
            if (aspiranteOld != null && !aspiranteOld.equals(aspiranteNew)) {
                aspiranteOld.getHistorialAspiranteCollection().remove(historialAspirante);
                aspiranteOld = em.merge(aspiranteOld);
            }
            if (aspiranteNew != null && !aspiranteNew.equals(aspiranteOld)) {
                aspiranteNew.getHistorialAspiranteCollection().add(historialAspirante);
                aspiranteNew = em.merge(aspiranteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                HistorialAspirantePK id = historialAspirante.getHistorialAspirantePK();
                if (findHistorialAspirante(id) == null) {
                    throw new NonexistentEntityException("The historialAspirante with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(HistorialAspirantePK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HistorialAspirante historialAspirante;
            try {
                historialAspirante = em.getReference(HistorialAspirante.class, id);
                historialAspirante.getHistorialAspirantePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The historialAspirante with id " + id + " no longer exists.", enfe);
            }
            Aspirante aspirante = historialAspirante.getAspirante();
            if (aspirante != null) {
                aspirante.getHistorialAspiranteCollection().remove(historialAspirante);
                aspirante = em.merge(aspirante);
            }
            em.remove(historialAspirante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HistorialAspirante> findHistorialAspiranteEntities() {
        return findHistorialAspiranteEntities(true, -1, -1);
    }

    public List<HistorialAspirante> findHistorialAspiranteEntities(int maxResults, int firstResult) {
        return findHistorialAspiranteEntities(false, maxResults, firstResult);
    }

    private List<HistorialAspirante> findHistorialAspiranteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HistorialAspirante.class));
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

    public HistorialAspirante findHistorialAspirante(HistorialAspirantePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HistorialAspirante.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistorialAspiranteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HistorialAspirante> rt = cq.from(HistorialAspirante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
