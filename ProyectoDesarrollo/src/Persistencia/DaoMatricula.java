/** 
 * Nombre del Archivo: MatriculaJpaController.java 
 * Fecha de Creacion: 27/04/2015 
 * Autores: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750) 
 */

package Persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica.LeaderTeacher;
import Logica.Curso;
import Logica.Cohorte;
import Logica.Matricula;
import Logica.MatriculaPK;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


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
        matricula.getMatriculaPK().setCedulaLt(matricula.getLeaderTeacher().getCedula());
        matricula.getMatriculaPK().setIdCurso(matricula.getCurso().getIdCurso());
        matricula.getMatriculaPK().setIdCohorte(matricula.getCohorte().getIdCohorte());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LeaderTeacher leaderTeacher = matricula.getLeaderTeacher();
            if (leaderTeacher != null) {
                leaderTeacher = em.getReference(leaderTeacher.getClass(), leaderTeacher.getCedula());
                matricula.setLeaderTeacher(leaderTeacher);
            }
            Curso curso = matricula.getCurso();
            if (curso != null) {
                curso = em.getReference(curso.getClass(), curso.getIdCurso());
                matricula.setCurso(curso);
            }
            Cohorte cohorte = matricula.getCohorte();
            if (cohorte != null) {
                cohorte = em.getReference(cohorte.getClass(), cohorte.getIdCohorte());
                matricula.setCohorte(cohorte);
            }
            em.persist(matricula);
            if (leaderTeacher != null) {
                leaderTeacher.getMatriculaList().add(matricula);
                leaderTeacher = em.merge(leaderTeacher);
            }
            if (curso != null) {
                curso.getMatriculaList().add(matricula);
                curso = em.merge(curso);
            }
            if (cohorte != null) {
                cohorte.getMatriculaList().add(matricula);
                cohorte = em.merge(cohorte);
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
        matricula.getMatriculaPK().setCedulaLt(matricula.getLeaderTeacher().getCedula());
        matricula.getMatriculaPK().setIdCurso(matricula.getCurso().getIdCurso());
        matricula.getMatriculaPK().setIdCohorte(matricula.getCohorte().getIdCohorte());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Matricula persistentMatricula = em.find(Matricula.class, matricula.getMatriculaPK());
            LeaderTeacher leaderTeacherOld = persistentMatricula.getLeaderTeacher();
            LeaderTeacher leaderTeacherNew = matricula.getLeaderTeacher();
            Curso cursoOld = persistentMatricula.getCurso();
            Curso cursoNew = matricula.getCurso();
            Cohorte cohorteOld = persistentMatricula.getCohorte();
            Cohorte cohorteNew = matricula.getCohorte();
            if (leaderTeacherNew != null) {
                leaderTeacherNew = em.getReference(leaderTeacherNew.getClass(), leaderTeacherNew.getCedula());
                matricula.setLeaderTeacher(leaderTeacherNew);
            }
            if (cursoNew != null) {
                cursoNew = em.getReference(cursoNew.getClass(), cursoNew.getIdCurso());
                matricula.setCurso(cursoNew);
            }
            if (cohorteNew != null) {
                cohorteNew = em.getReference(cohorteNew.getClass(), cohorteNew.getIdCohorte());
                matricula.setCohorte(cohorteNew);
            }
            matricula = em.merge(matricula);
            if (leaderTeacherOld != null && !leaderTeacherOld.equals(leaderTeacherNew)) {
                leaderTeacherOld.getMatriculaList().remove(matricula);
                leaderTeacherOld = em.merge(leaderTeacherOld);
            }
            if (leaderTeacherNew != null && !leaderTeacherNew.equals(leaderTeacherOld)) {
                leaderTeacherNew.getMatriculaList().add(matricula);
                leaderTeacherNew = em.merge(leaderTeacherNew);
            }
            if (cursoOld != null && !cursoOld.equals(cursoNew)) {
                cursoOld.getMatriculaList().remove(matricula);
                cursoOld = em.merge(cursoOld);
            }
            if (cursoNew != null && !cursoNew.equals(cursoOld)) {
                cursoNew.getMatriculaList().add(matricula);
                cursoNew = em.merge(cursoNew);
            }
            if (cohorteOld != null && !cohorteOld.equals(cohorteNew)) {
                cohorteOld.getMatriculaList().remove(matricula);
                cohorteOld = em.merge(cohorteOld);
            }
            if (cohorteNew != null && !cohorteNew.equals(cohorteOld)) {
                cohorteNew.getMatriculaList().add(matricula);
                cohorteNew = em.merge(cohorteNew);
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
            LeaderTeacher leaderTeacher = matricula.getLeaderTeacher();
            if (leaderTeacher != null) {
                leaderTeacher.getMatriculaList().remove(matricula);
                leaderTeacher = em.merge(leaderTeacher);
            }
            Curso curso = matricula.getCurso();
            if (curso != null) {
                curso.getMatriculaList().remove(matricula);
                curso = em.merge(curso);
            }
            Cohorte cohorte = matricula.getCohorte();
            if (cohorte != null) {
                cohorte.getMatriculaList().remove(matricula);
                cohorte = em.merge(cohorte);
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

} // Fin de la clase DaoMatricula
