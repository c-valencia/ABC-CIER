/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Aspirante;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica.HistorialAspirante;
import Persistencia.exceptions.IllegalOrphanException;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ubuntu
 */
public class DaoAspirante implements Serializable {

    public DaoAspirante(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Aspirante aspirante) throws PreexistingEntityException, Exception {
        if (aspirante.getHistorialAspiranteCollection() == null) {
            aspirante.setHistorialAspiranteCollection(new ArrayList<HistorialAspirante>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<HistorialAspirante> attachedHistorialAspiranteCollection = new ArrayList<HistorialAspirante>();
            for (HistorialAspirante historialAspiranteCollectionHistorialAspiranteToAttach : aspirante.getHistorialAspiranteCollection()) {
                historialAspiranteCollectionHistorialAspiranteToAttach = em.getReference(historialAspiranteCollectionHistorialAspiranteToAttach.getClass(), historialAspiranteCollectionHistorialAspiranteToAttach.getHistorialAspirantePK());
                attachedHistorialAspiranteCollection.add(historialAspiranteCollectionHistorialAspiranteToAttach);
            }
            aspirante.setHistorialAspiranteCollection(attachedHistorialAspiranteCollection);
            em.persist(aspirante);
            for (HistorialAspirante historialAspiranteCollectionHistorialAspirante : aspirante.getHistorialAspiranteCollection()) {
                Aspirante oldAspiranteOfHistorialAspiranteCollectionHistorialAspirante = historialAspiranteCollectionHistorialAspirante.getAspirante();
                historialAspiranteCollectionHistorialAspirante.setAspirante(aspirante);
                historialAspiranteCollectionHistorialAspirante = em.merge(historialAspiranteCollectionHistorialAspirante);
                if (oldAspiranteOfHistorialAspiranteCollectionHistorialAspirante != null) {
                    oldAspiranteOfHistorialAspiranteCollectionHistorialAspirante.getHistorialAspiranteCollection().remove(historialAspiranteCollectionHistorialAspirante);
                    oldAspiranteOfHistorialAspiranteCollectionHistorialAspirante = em.merge(oldAspiranteOfHistorialAspiranteCollectionHistorialAspirante);
                }
            }
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

    public void edit(Aspirante aspirante) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Aspirante persistentAspirante = em.find(Aspirante.class, aspirante.getCedula());
            Collection<HistorialAspirante> historialAspiranteCollectionOld = persistentAspirante.getHistorialAspiranteCollection();
            Collection<HistorialAspirante> historialAspiranteCollectionNew = aspirante.getHistorialAspiranteCollection();
            List<String> illegalOrphanMessages = null;
            for (HistorialAspirante historialAspiranteCollectionOldHistorialAspirante : historialAspiranteCollectionOld) {
                if (!historialAspiranteCollectionNew.contains(historialAspiranteCollectionOldHistorialAspirante)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistorialAspirante " + historialAspiranteCollectionOldHistorialAspirante + " since its aspirante field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<HistorialAspirante> attachedHistorialAspiranteCollectionNew = new ArrayList<HistorialAspirante>();
            for (HistorialAspirante historialAspiranteCollectionNewHistorialAspiranteToAttach : historialAspiranteCollectionNew) {
                historialAspiranteCollectionNewHistorialAspiranteToAttach = em.getReference(historialAspiranteCollectionNewHistorialAspiranteToAttach.getClass(), historialAspiranteCollectionNewHistorialAspiranteToAttach.getHistorialAspirantePK());
                attachedHistorialAspiranteCollectionNew.add(historialAspiranteCollectionNewHistorialAspiranteToAttach);
            }
            historialAspiranteCollectionNew = attachedHistorialAspiranteCollectionNew;
            aspirante.setHistorialAspiranteCollection(historialAspiranteCollectionNew);
            aspirante = em.merge(aspirante);
            for (HistorialAspirante historialAspiranteCollectionNewHistorialAspirante : historialAspiranteCollectionNew) {
                if (!historialAspiranteCollectionOld.contains(historialAspiranteCollectionNewHistorialAspirante)) {
                    Aspirante oldAspiranteOfHistorialAspiranteCollectionNewHistorialAspirante = historialAspiranteCollectionNewHistorialAspirante.getAspirante();
                    historialAspiranteCollectionNewHistorialAspirante.setAspirante(aspirante);
                    historialAspiranteCollectionNewHistorialAspirante = em.merge(historialAspiranteCollectionNewHistorialAspirante);
                    if (oldAspiranteOfHistorialAspiranteCollectionNewHistorialAspirante != null && !oldAspiranteOfHistorialAspiranteCollectionNewHistorialAspirante.equals(aspirante)) {
                        oldAspiranteOfHistorialAspiranteCollectionNewHistorialAspirante.getHistorialAspiranteCollection().remove(historialAspiranteCollectionNewHistorialAspirante);
                        oldAspiranteOfHistorialAspiranteCollectionNewHistorialAspirante = em.merge(oldAspiranteOfHistorialAspiranteCollectionNewHistorialAspirante);
                    }
                }
            }
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

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
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
            List<String> illegalOrphanMessages = null;
            Collection<HistorialAspirante> historialAspiranteCollectionOrphanCheck = aspirante.getHistorialAspiranteCollection();
            for (HistorialAspirante historialAspiranteCollectionOrphanCheckHistorialAspirante : historialAspiranteCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Aspirante (" + aspirante + ") cannot be destroyed since the HistorialAspirante " + historialAspiranteCollectionOrphanCheckHistorialAspirante + " in its historialAspiranteCollection field has a non-nullable aspirante field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
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
    
    public List <Aspirante> buscarAspirantes(String area, String departamento){
        EntityManager em = getEntityManager();
        String buscar = new String();
        try {
            em.getTransaction().begin();
            buscar = "SELECT a.cedula, a.nombres, a.apellidos, a.correo, a.celular, a.direccion, a.sede_pertenece, " +
                     "a.intitucion, a.codigo_dane_intitucion, a.grado, a.secretaria_educacion, a.municipio, " +
                     "a.departamento, a.area_inscripcion, a.tutor_pta, a.usuario_colombia_aprende, a.estado " +
                     " FROM aspirante AS a JOIN historial_aspirante AS ha ON a.cedula = ha.cedula_as " +
                     " WHERE ha.id_curso = '" + area +"' AND ha.estado = true AND a.secretaria_educacion = '" + departamento +"';";
            Query query = em.createNativeQuery(buscar, Aspirante.class);
            
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
}