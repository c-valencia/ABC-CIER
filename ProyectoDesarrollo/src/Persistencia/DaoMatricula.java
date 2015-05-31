package Persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica.CursoCohorte;
import Logica.Matricula;
import Logica.MatriculaPK;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Nombre del Archivo: DaoMatricula.java
 Fecha de Creacion: 6/05/2015
 Autor: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750)  
 */

public class DaoMatricula implements Serializable {

    public DaoMatricula(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Matricula matricula) throws PreexistingEntityException, Exception {
        if (matricula.getMatriculaPK() == null) {
            matricula.setMatriculaPK(new MatriculaPK());
        }
        matricula.getMatriculaPK().setIdCohorte(matricula.getCursoCohorte().getCursoCohortePK().getIdCohorte());
        matricula.getMatriculaPK().setIdCurso(matricula.getCursoCohorte().getCursoCohortePK().getIdCurso());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CursoCohorte cursoCohorte = matricula.getCursoCohorte();
            if (cursoCohorte != null) {
                cursoCohorte = em.getReference(cursoCohorte.getClass(), cursoCohorte.getCursoCohortePK());
                matricula.setCursoCohorte(cursoCohorte);
            }
            em.persist(matricula);
            if (cursoCohorte != null) {
                cursoCohorte.getMatriculaList().add(matricula);
                cursoCohorte = em.merge(cursoCohorte);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMatricula(matricula.getMatriculaPK()) != null) {
                throw new PreexistingEntityException("Matricula " + matricula + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Matricula matricula) throws NonexistentEntityException, Exception {
        matricula.getMatriculaPK().setIdCohorte(matricula.getCursoCohorte().getCursoCohortePK().getIdCohorte());
        matricula.getMatriculaPK().setIdCurso(matricula.getCursoCohorte().getCursoCohortePK().getIdCurso());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Matricula persistentMatricula = em.find(Matricula.class, matricula.getMatriculaPK());
            CursoCohorte cursoCohorteOld = persistentMatricula.getCursoCohorte();
            CursoCohorte cursoCohorteNew = matricula.getCursoCohorte();
            if (cursoCohorteNew != null) {
                cursoCohorteNew = em.getReference(cursoCohorteNew.getClass(), cursoCohorteNew.getCursoCohortePK());
                matricula.setCursoCohorte(cursoCohorteNew);
            }
            matricula = em.merge(matricula);
            if (cursoCohorteOld != null && !cursoCohorteOld.equals(cursoCohorteNew)) {
                cursoCohorteOld.getMatriculaList().remove(matricula);
                cursoCohorteOld = em.merge(cursoCohorteOld);
            }
            if (cursoCohorteNew != null && !cursoCohorteNew.equals(cursoCohorteOld)) {
                cursoCohorteNew.getMatriculaList().add(matricula);
                cursoCohorteNew = em.merge(cursoCohorteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                MatriculaPK id = matricula.getMatriculaPK();
                if (findMatricula(id) == null) {
                    throw new NonexistentEntityException("The matricula with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(MatriculaPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Matricula matricula;
            try {
                matricula = em.getReference(Matricula.class, id);
                matricula.getMatriculaPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The matricula with id " + id + " no longer exists.", enfe);
            }
            CursoCohorte cursoCohorte = matricula.getCursoCohorte();
            if (cursoCohorte != null) {
                cursoCohorte.getMatriculaList().remove(matricula);
                cursoCohorte = em.merge(cursoCohorte);
            }
            em.remove(matricula);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Matricula> findMatriculaEntities() {
        return findMatriculaEntities(true, -1, -1);
    }

    public List<Matricula> findMatriculaEntities(int maxResults, int firstResult) {
        return findMatriculaEntities(false, maxResults, firstResult);
    }

    private List<Matricula> findMatriculaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Matricula.class));
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

    public Matricula findMatricula(MatriculaPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Matricula.class, id);
        } finally {
            em.close();
        }
    }

    public int getMatriculaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Matricula> rt = cq.from(Matricula.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    public boolean ingresarMatricula(String cohorte, String curso, String idLT){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createNativeQuery("INSERT INTO matricula (cedula_lt, id_cohorte, id_curso, nota)" + 
                    "VALUES ('" + idLT + "', '" + cohorte + "', '" + curso + "', 0);");
        
        query.executeUpdate();
        em.getTransaction().commit();
        return true;
    }

    
} // Fin de la clase DaoMatricula
