package Persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica.Curso;
import Logica.Cohorte;
import Logica.CursoCohorte;
import Logica.CursoCohortePK;
import Logica.Matricula;
import Persistencia.exceptions.IllegalOrphanException;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

/**
 * Nombre del Archivo: DaoCursoCohorte.java
 Fecha de Creacion: 6/05/2015
 Autor: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750)  
 */

public class DaoCursoCohorte implements Serializable {

    public DaoCursoCohorte(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CursoCohorte cursoCohorte) throws PreexistingEntityException, Exception {
        if (cursoCohorte.getCursoCohortePK() == null) {
            cursoCohorte.setCursoCohortePK(new CursoCohortePK());
        }
        if (cursoCohorte.getMatriculaList() == null) {
            cursoCohorte.setMatriculaList(new ArrayList<Matricula>());
        }
        cursoCohorte.getCursoCohortePK().setIdCurso(cursoCohorte.getCurso().getIdCurso());
        cursoCohorte.getCursoCohortePK().setIdCohorte(cursoCohorte.getCohorte().getIdCohorte());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Curso curso = cursoCohorte.getCurso();
            if (curso != null) {
                curso = em.getReference(curso.getClass(), curso.getIdCurso());
                cursoCohorte.setCurso(curso);
            }
            Cohorte cohorte = cursoCohorte.getCohorte();
            if (cohorte != null) {
                cohorte = em.getReference(cohorte.getClass(), cohorte.getIdCohorte());
                cursoCohorte.setCohorte(cohorte);
            }
            List<Matricula> attachedMatriculaList = new ArrayList<Matricula>();
            for (Matricula matriculaListMatriculaToAttach : cursoCohorte.getMatriculaList()) {
                matriculaListMatriculaToAttach = em.getReference(matriculaListMatriculaToAttach.getClass(), matriculaListMatriculaToAttach.getMatriculaPK());
                attachedMatriculaList.add(matriculaListMatriculaToAttach);
            }
            cursoCohorte.setMatriculaList(attachedMatriculaList);
            em.persist(cursoCohorte);
            if (curso != null) {
                curso.getCursoCohorteList().add(cursoCohorte);
                curso = em.merge(curso);
            }
            if (cohorte != null) {
                cohorte.getCursoCohorteList().add(cursoCohorte);
                cohorte = em.merge(cohorte);
            }
            for (Matricula matriculaListMatricula : cursoCohorte.getMatriculaList()) {
                CursoCohorte oldCursoCohorteOfMatriculaListMatricula = matriculaListMatricula.getCursoCohorte();
                matriculaListMatricula.setCursoCohorte(cursoCohorte);
                matriculaListMatricula = em.merge(matriculaListMatricula);
                if (oldCursoCohorteOfMatriculaListMatricula != null) {
                    oldCursoCohorteOfMatriculaListMatricula.getMatriculaList().remove(matriculaListMatricula);
                    oldCursoCohorteOfMatriculaListMatricula = em.merge(oldCursoCohorteOfMatriculaListMatricula);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCursoCohorte(cursoCohorte.getCursoCohortePK()) != null) {
                throw new PreexistingEntityException("CursoCohorte " + cursoCohorte + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CursoCohorte cursoCohorte) throws IllegalOrphanException, NonexistentEntityException, Exception {
        cursoCohorte.getCursoCohortePK().setIdCurso(cursoCohorte.getCurso().getIdCurso());
        cursoCohorte.getCursoCohortePK().setIdCohorte(cursoCohorte.getCohorte().getIdCohorte());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CursoCohorte persistentCursoCohorte = em.find(CursoCohorte.class, cursoCohorte.getCursoCohortePK());
            Curso cursoOld = persistentCursoCohorte.getCurso();
            Curso cursoNew = cursoCohorte.getCurso();
            Cohorte cohorteOld = persistentCursoCohorte.getCohorte();
            Cohorte cohorteNew = cursoCohorte.getCohorte();
            List<Matricula> matriculaListOld = persistentCursoCohorte.getMatriculaList();
            List<Matricula> matriculaListNew = cursoCohorte.getMatriculaList();
            List<String> illegalOrphanMessages = null;
            for (Matricula matriculaListOldMatricula : matriculaListOld) {
                if (!matriculaListNew.contains(matriculaListOldMatricula)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Matricula " + matriculaListOldMatricula + " since its cursoCohorte field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (cursoNew != null) {
                cursoNew = em.getReference(cursoNew.getClass(), cursoNew.getIdCurso());
                cursoCohorte.setCurso(cursoNew);
            }
            if (cohorteNew != null) {
                cohorteNew = em.getReference(cohorteNew.getClass(), cohorteNew.getIdCohorte());
                cursoCohorte.setCohorte(cohorteNew);
            }
            List<Matricula> attachedMatriculaListNew = new ArrayList<Matricula>();
            for (Matricula matriculaListNewMatriculaToAttach : matriculaListNew) {
                matriculaListNewMatriculaToAttach = em.getReference(matriculaListNewMatriculaToAttach.getClass(), matriculaListNewMatriculaToAttach.getMatriculaPK());
                attachedMatriculaListNew.add(matriculaListNewMatriculaToAttach);
            }
            matriculaListNew = attachedMatriculaListNew;
            cursoCohorte.setMatriculaList(matriculaListNew);
            cursoCohorte = em.merge(cursoCohorte);
            if (cursoOld != null && !cursoOld.equals(cursoNew)) {
                cursoOld.getCursoCohorteList().remove(cursoCohorte);
                cursoOld = em.merge(cursoOld);
            }
            if (cursoNew != null && !cursoNew.equals(cursoOld)) {
                cursoNew.getCursoCohorteList().add(cursoCohorte);
                cursoNew = em.merge(cursoNew);
            }
            if (cohorteOld != null && !cohorteOld.equals(cohorteNew)) {
                cohorteOld.getCursoCohorteList().remove(cursoCohorte);
                cohorteOld = em.merge(cohorteOld);
            }
            if (cohorteNew != null && !cohorteNew.equals(cohorteOld)) {
                cohorteNew.getCursoCohorteList().add(cursoCohorte);
                cohorteNew = em.merge(cohorteNew);
            }
            for (Matricula matriculaListNewMatricula : matriculaListNew) {
                if (!matriculaListOld.contains(matriculaListNewMatricula)) {
                    CursoCohorte oldCursoCohorteOfMatriculaListNewMatricula = matriculaListNewMatricula.getCursoCohorte();
                    matriculaListNewMatricula.setCursoCohorte(cursoCohorte);
                    matriculaListNewMatricula = em.merge(matriculaListNewMatricula);
                    if (oldCursoCohorteOfMatriculaListNewMatricula != null && !oldCursoCohorteOfMatriculaListNewMatricula.equals(cursoCohorte)) {
                        oldCursoCohorteOfMatriculaListNewMatricula.getMatriculaList().remove(matriculaListNewMatricula);
                        oldCursoCohorteOfMatriculaListNewMatricula = em.merge(oldCursoCohorteOfMatriculaListNewMatricula);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                CursoCohortePK id = cursoCohorte.getCursoCohortePK();
                if (findCursoCohorte(id) == null) {
                    throw new NonexistentEntityException("The cursoCohorte with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(CursoCohortePK id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CursoCohorte cursoCohorte;
            try {
                cursoCohorte = em.getReference(CursoCohorte.class, id);
                cursoCohorte.getCursoCohortePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cursoCohorte with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Matricula> matriculaListOrphanCheck = cursoCohorte.getMatriculaList();
            for (Matricula matriculaListOrphanCheckMatricula : matriculaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This CursoCohorte (" + cursoCohorte + ") cannot be destroyed since the Matricula " + matriculaListOrphanCheckMatricula + " in its matriculaList field has a non-nullable cursoCohorte field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Curso curso = cursoCohorte.getCurso();
            if (curso != null) {
                curso.getCursoCohorteList().remove(cursoCohorte);
                curso = em.merge(curso);
            }
            Cohorte cohorte = cursoCohorte.getCohorte();
            if (cohorte != null) {
                cohorte.getCursoCohorteList().remove(cursoCohorte);
                cohorte = em.merge(cohorte);
            }
            em.remove(cursoCohorte);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CursoCohorte> findCursoCohorteEntities() {
        return findCursoCohorteEntities(true, -1, -1);
    }

    public List<CursoCohorte> findCursoCohorteEntities(int maxResults, int firstResult) {
        return findCursoCohorteEntities(false, maxResults, firstResult);
    }

    private List<CursoCohorte> findCursoCohorteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CursoCohorte.class));
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

    public CursoCohorte findCursoCohorte(CursoCohortePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CursoCohorte.class, id);
        } finally {
            em.close();
        }
    }

    public int getCursoCohorteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CursoCohorte> rt = cq.from(CursoCohorte.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public Vector<CursoCohorte> buscarCursoCohorte(String idCohorte){
        EntityManager em = getEntityManager();
        Vector <CursoCohorte> lista = new Vector<>();
        try {
            em.getTransaction().begin();
            Query query = em.createNativeQuery("SELECT cc.id_cohorte, cc.id_curso, num_estudiantes FROM curso_cohorte cc  WHERE  cc.id_cohorte = '" + idCohorte + "' ;", CursoCohorte.class);
            
            em.getTransaction().commit(); // OSCAR
            return (Vector<CursoCohorte>) query.getResultList();
        } catch(NoResultException nre){
            return lista;
        }finally {
            if (em != null) {
                em.close();
            }
        }
    }

} // Fin de la clase DaoCursoCohorte
