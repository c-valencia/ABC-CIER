/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Asistencia;
import Logica.AsistenciaPK;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica.Matricula;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author cristian
 */
public class DaoAsistencia implements Serializable {

    public DaoAsistencia(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List <Asistencia> buscarAsistencia (String Cedula_lt, String curso,String cohorte){
        EntityManager em = getEntityManager();
        //Tarea aspi = new Tarea();
        try {
            //em.getTransaction().begin();
              
            Query query = em.createNativeQuery("SELECT * "
                    + "FROM asistencia "
                    + "WHERE cedula_lt = '" + Cedula_lt 
                       + "' AND id_curso = '" + curso
                       + "' AND id_cohorte = '" + cohorte + "';"
                       , Asistencia.class);
            
            return query.getResultList();

        } finally {
            em.close();
        }
    }
    
    public void create(Asistencia asistencia) throws PreexistingEntityException, Exception {
        if (asistencia.getAsistenciaPK() == null) {
            asistencia.setAsistenciaPK(new AsistenciaPK());
        }
        asistencia.getAsistenciaPK().setIdCohorte(asistencia.getMatricula().getMatriculaPK().getIdCohorte());
        asistencia.getAsistenciaPK().setCedulaLt(asistencia.getMatricula().getMatriculaPK().getCedulaLt());
        asistencia.getAsistenciaPK().setIdCurso(asistencia.getMatricula().getMatriculaPK().getIdCurso());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Matricula matricula = asistencia.getMatricula();
            if (matricula != null) {
                matricula = em.getReference(matricula.getClass(), matricula.getMatriculaPK());
                asistencia.setMatricula(matricula);
            }
            em.persist(asistencia);
            if (matricula != null) {
                matricula.getAsistenciaCollection().add(asistencia);
                matricula = em.merge(matricula);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAsistencia(asistencia.getAsistenciaPK()) != null) {
                throw new PreexistingEntityException("Asistencia " + asistencia + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Asistencia asistencia) throws NonexistentEntityException, Exception {
        asistencia.getAsistenciaPK().setIdCohorte(asistencia.getMatricula().getMatriculaPK().getIdCohorte());
        asistencia.getAsistenciaPK().setCedulaLt(asistencia.getMatricula().getMatriculaPK().getCedulaLt());
        asistencia.getAsistenciaPK().setIdCurso(asistencia.getMatricula().getMatriculaPK().getIdCurso());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Asistencia persistentAsistencia = em.find(Asistencia.class, asistencia.getAsistenciaPK());
            Matricula matriculaOld = persistentAsistencia.getMatricula();
            Matricula matriculaNew = asistencia.getMatricula();
            if (matriculaNew != null) {
                matriculaNew = em.getReference(matriculaNew.getClass(), matriculaNew.getMatriculaPK());
                asistencia.setMatricula(matriculaNew);
            }
            asistencia = em.merge(asistencia);
            if (matriculaOld != null && !matriculaOld.equals(matriculaNew)) {
                matriculaOld.getAsistenciaCollection().remove(asistencia);
                matriculaOld = em.merge(matriculaOld);
            }
            if (matriculaNew != null && !matriculaNew.equals(matriculaOld)) {
                matriculaNew.getAsistenciaCollection().add(asistencia);
                matriculaNew = em.merge(matriculaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                AsistenciaPK id = asistencia.getAsistenciaPK();
                if (findAsistencia(id) == null) {
                    throw new NonexistentEntityException("The asistencia with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(AsistenciaPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Asistencia asistencia;
            try {
                asistencia = em.getReference(Asistencia.class, id);
                asistencia.getAsistenciaPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The asistencia with id " + id + " no longer exists.", enfe);
            }
            Matricula matricula = asistencia.getMatricula();
            if (matricula != null) {
                matricula.getAsistenciaCollection().remove(asistencia);
                matricula = em.merge(matricula);
            }
            em.remove(asistencia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Asistencia> findAsistenciaEntities() {
        return findAsistenciaEntities(true, -1, -1);
    }

    public List<Asistencia> findAsistenciaEntities(int maxResults, int firstResult) {
        return findAsistenciaEntities(false, maxResults, firstResult);
    }

    private List<Asistencia> findAsistenciaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Asistencia.class));
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

    public Asistencia findAsistencia(AsistenciaPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Asistencia.class, id);
        } finally {
            em.close();
        }
    }

    public int getAsistenciaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Asistencia> rt = cq.from(Asistencia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public boolean crearAsistencia(Asistencia asistencia){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createNativeQuery("INSERT INTO asistencia (cedula_lt, id_cohorte, id_curso,fecha,asistio) " + 
                    "VALUES ('" 
                             + asistencia.getAsistenciaPK().getCedulaLt() + "', '" 
                             + asistencia.getAsistenciaPK().getIdCohorte() + "', '" 
                             + asistencia.getAsistenciaPK().getIdCurso() + "', '" 
                             + asistencia.getAsistenciaPK().getFecha() + "', " 
                             + asistencia.getAsistio() + " );");
        
        query.executeUpdate();
        em.getTransaction().commit();
        return true;
    }
}
