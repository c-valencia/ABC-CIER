package Persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica.Practica;
import Logica.Tarea;
import Logica.TareaPK;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Nombre del Archivo: DaoTarea.java
 Fecha de Creacion: 6/05/2015
 Autor: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750)  
 */

public class DaoTarea implements Serializable {

    public DaoTarea(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    
    
    public List <Tarea> buscarTareas(String curso, String cohorte, String Cedula_lt){
        EntityManager em = getEntityManager();
        //Tarea aspi = new Tarea();
        try {
            //em.getTransaction().begin();
              
            Query query = em.createNativeQuery("SELECT t.id_practica,t.cedula_lt, t.nota "
                    + "FROM matricula m NATURAL JOIN curso c , fases f NATURAL JOIN practica p NATURAL JOIN tarea t "
                    + "WHERE  m.cedula_lt = '" + Cedula_lt 
                       + "' AND m.id_cohorte = '" + cohorte 
                       + "' AND c.id_curso = '" + curso
                       + "' AND f.id_curso = c.id_curso;", Tarea.class);
            
            return query.getResultList();

        } finally {
            em.close();
        }
    }
    

    public void create(Tarea tarea) throws PreexistingEntityException, Exception {
        if (tarea.getTareaPK() == null) {
            tarea.setTareaPK(new TareaPK());
        }
        tarea.getTareaPK().setIdPractica(tarea.getPractica().getIdPractica());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Practica practica = tarea.getPractica();
            if (practica != null) {
                practica = em.getReference(practica.getClass(), practica.getIdPractica());
                tarea.setPractica(practica);
            }
            em.persist(tarea);
            if (practica != null) {
                practica.getTareaList().add(tarea);
                practica = em.merge(practica);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTarea(tarea.getTareaPK()) != null) {
                throw new PreexistingEntityException("Tarea " + tarea + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tarea tarea) throws NonexistentEntityException, Exception {
        tarea.getTareaPK().setIdPractica(tarea.getPractica().getIdPractica());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tarea persistentTarea = em.find(Tarea.class, tarea.getTareaPK());
            Practica practicaOld = persistentTarea.getPractica();
            Practica practicaNew = tarea.getPractica();
            if (practicaNew != null) {
                practicaNew = em.getReference(practicaNew.getClass(), practicaNew.getIdPractica());
                tarea.setPractica(practicaNew);
            }
            tarea = em.merge(tarea);
            if (practicaOld != null && !practicaOld.equals(practicaNew)) {
                practicaOld.getTareaList().remove(tarea);
                practicaOld = em.merge(practicaOld);
            }
            if (practicaNew != null && !practicaNew.equals(practicaOld)) {
                practicaNew.getTareaList().add(tarea);
                practicaNew = em.merge(practicaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                TareaPK id = tarea.getTareaPK();
                if (findTarea(id) == null) {
                    throw new NonexistentEntityException("The tarea with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(TareaPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tarea tarea;
            try {
                tarea = em.getReference(Tarea.class, id);
                tarea.getTareaPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tarea with id " + id + " no longer exists.", enfe);
            }
            Practica practica = tarea.getPractica();
            if (practica != null) {
                practica.getTareaList().remove(tarea);
                practica = em.merge(practica);
            }
            em.remove(tarea);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tarea> findTareaEntities() {
        return findTareaEntities(true, -1, -1);
    }

    public List<Tarea> findTareaEntities(int maxResults, int firstResult) {
        return findTareaEntities(false, maxResults, firstResult);
    }

    private List<Tarea> findTareaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tarea.class));
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

    public Tarea findTarea(TareaPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tarea.class, id);
        } finally {
            em.close();
        }
    }

    public int getTareaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tarea> rt = cq.from(Tarea.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

} // Fin de la clase DaoTarea
