/** 
 * Nombre del Archivo: CursoJpaController.java 
 * Fecha de Creacion: 27/04/2015 
 * Autores: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750) 
 */

package Persistencia;

import Logica.Curso;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica.Fases;
import java.util.ArrayList;
import java.util.List;
import Logica.Matricula;
import Logica.MasterTeacher;
import Persistencia.exceptions.IllegalOrphanException;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class DaoCurso implements Serializable {

    public DaoCurso(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Curso curso) throws PreexistingEntityException, Exception {
        if (curso.getFasesList() == null) {
            curso.setFasesList(new ArrayList<Fases>());
        }
        if (curso.getMatriculaList() == null) {
            curso.setMatriculaList(new ArrayList<Matricula>());
        }
        if (curso.getMasterTeacherList() == null) {
            curso.setMasterTeacherList(new ArrayList<MasterTeacher>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Fases> attachedFasesList = new ArrayList<Fases>();
            for (Fases fasesListFasesToAttach : curso.getFasesList()) {
                fasesListFasesToAttach = em.getReference(fasesListFasesToAttach.getClass(), fasesListFasesToAttach.getIdFase());
                attachedFasesList.add(fasesListFasesToAttach);
            }
            curso.setFasesList(attachedFasesList);
            List<Matricula> attachedMatriculaList = new ArrayList<Matricula>();
            for (Matricula matriculaListMatriculaToAttach : curso.getMatriculaList()) {
                matriculaListMatriculaToAttach = em.getReference(matriculaListMatriculaToAttach.getClass(), matriculaListMatriculaToAttach.getMatriculaPK());
                attachedMatriculaList.add(matriculaListMatriculaToAttach);
            }
            curso.setMatriculaList(attachedMatriculaList);
            List<MasterTeacher> attachedMasterTeacherList = new ArrayList<MasterTeacher>();
            for (MasterTeacher masterTeacherListMasterTeacherToAttach : curso.getMasterTeacherList()) {
                masterTeacherListMasterTeacherToAttach = em.getReference(masterTeacherListMasterTeacherToAttach.getClass(), masterTeacherListMasterTeacherToAttach.getCedula());
                attachedMasterTeacherList.add(masterTeacherListMasterTeacherToAttach);
            }
            curso.setMasterTeacherList(attachedMasterTeacherList);
            em.persist(curso);
            for (Fases fasesListFases : curso.getFasesList()) {
                Curso oldIdCursoOfFasesListFases = fasesListFases.getIdCurso();
                fasesListFases.setIdCurso(curso);
                fasesListFases = em.merge(fasesListFases);
                if (oldIdCursoOfFasesListFases != null) {
                    oldIdCursoOfFasesListFases.getFasesList().remove(fasesListFases);
                    oldIdCursoOfFasesListFases = em.merge(oldIdCursoOfFasesListFases);
                }
            }
            for (Matricula matriculaListMatricula : curso.getMatriculaList()) {
                Curso oldCursoOfMatriculaListMatricula = matriculaListMatricula.getCurso();
                matriculaListMatricula.setCurso(curso);
                matriculaListMatricula = em.merge(matriculaListMatricula);
                if (oldCursoOfMatriculaListMatricula != null) {
                    oldCursoOfMatriculaListMatricula.getMatriculaList().remove(matriculaListMatricula);
                    oldCursoOfMatriculaListMatricula = em.merge(oldCursoOfMatriculaListMatricula);
                }
            }
            for (MasterTeacher masterTeacherListMasterTeacher : curso.getMasterTeacherList()) {
                Curso oldIdCursoOfMasterTeacherListMasterTeacher = masterTeacherListMasterTeacher.getIdCurso();
                masterTeacherListMasterTeacher.setIdCurso(curso);
                masterTeacherListMasterTeacher = em.merge(masterTeacherListMasterTeacher);
                if (oldIdCursoOfMasterTeacherListMasterTeacher != null) {
                    oldIdCursoOfMasterTeacherListMasterTeacher.getMasterTeacherList().remove(masterTeacherListMasterTeacher);
                    oldIdCursoOfMasterTeacherListMasterTeacher = em.merge(oldIdCursoOfMasterTeacherListMasterTeacher);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCurso(curso.getIdCurso()) != null) {
                throw new PreexistingEntityException("Curso " + curso + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Curso curso) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Curso persistentCurso = em.find(Curso.class, curso.getIdCurso());
            List<Fases> fasesListOld = persistentCurso.getFasesList();
            List<Fases> fasesListNew = curso.getFasesList();
            List<Matricula> matriculaListOld = persistentCurso.getMatriculaList();
            List<Matricula> matriculaListNew = curso.getMatriculaList();
            List<MasterTeacher> masterTeacherListOld = persistentCurso.getMasterTeacherList();
            List<MasterTeacher> masterTeacherListNew = curso.getMasterTeacherList();
            List<String> illegalOrphanMessages = null;
            for (Matricula matriculaListOldMatricula : matriculaListOld) {
                if (!matriculaListNew.contains(matriculaListOldMatricula)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Matricula " + matriculaListOldMatricula + " since its curso field is not nullable.");
                }
            }
            for (MasterTeacher masterTeacherListOldMasterTeacher : masterTeacherListOld) {
                if (!masterTeacherListNew.contains(masterTeacherListOldMasterTeacher)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain MasterTeacher " + masterTeacherListOldMasterTeacher + " since its idCurso field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Fases> attachedFasesListNew = new ArrayList<Fases>();
            for (Fases fasesListNewFasesToAttach : fasesListNew) {
                fasesListNewFasesToAttach = em.getReference(fasesListNewFasesToAttach.getClass(), fasesListNewFasesToAttach.getIdFase());
                attachedFasesListNew.add(fasesListNewFasesToAttach);
            }
            fasesListNew = attachedFasesListNew;
            curso.setFasesList(fasesListNew);
            List<Matricula> attachedMatriculaListNew = new ArrayList<Matricula>();
            for (Matricula matriculaListNewMatriculaToAttach : matriculaListNew) {
                matriculaListNewMatriculaToAttach = em.getReference(matriculaListNewMatriculaToAttach.getClass(), matriculaListNewMatriculaToAttach.getMatriculaPK());
                attachedMatriculaListNew.add(matriculaListNewMatriculaToAttach);
            }
            matriculaListNew = attachedMatriculaListNew;
            curso.setMatriculaList(matriculaListNew);
            List<MasterTeacher> attachedMasterTeacherListNew = new ArrayList<MasterTeacher>();
            for (MasterTeacher masterTeacherListNewMasterTeacherToAttach : masterTeacherListNew) {
                masterTeacherListNewMasterTeacherToAttach = em.getReference(masterTeacherListNewMasterTeacherToAttach.getClass(), masterTeacherListNewMasterTeacherToAttach.getCedula());
                attachedMasterTeacherListNew.add(masterTeacherListNewMasterTeacherToAttach);
            }
            masterTeacherListNew = attachedMasterTeacherListNew;
            curso.setMasterTeacherList(masterTeacherListNew);
            curso = em.merge(curso);
            for (Fases fasesListOldFases : fasesListOld) {
                if (!fasesListNew.contains(fasesListOldFases)) {
                    fasesListOldFases.setIdCurso(null);
                    fasesListOldFases = em.merge(fasesListOldFases);
                }
            }
            for (Fases fasesListNewFases : fasesListNew) {
                if (!fasesListOld.contains(fasesListNewFases)) {
                    Curso oldIdCursoOfFasesListNewFases = fasesListNewFases.getIdCurso();
                    fasesListNewFases.setIdCurso(curso);
                    fasesListNewFases = em.merge(fasesListNewFases);
                    if (oldIdCursoOfFasesListNewFases != null && !oldIdCursoOfFasesListNewFases.equals(curso)) {
                        oldIdCursoOfFasesListNewFases.getFasesList().remove(fasesListNewFases);
                        oldIdCursoOfFasesListNewFases = em.merge(oldIdCursoOfFasesListNewFases);
                    }
                }
            }
            for (Matricula matriculaListNewMatricula : matriculaListNew) {
                if (!matriculaListOld.contains(matriculaListNewMatricula)) {
                    Curso oldCursoOfMatriculaListNewMatricula = matriculaListNewMatricula.getCurso();
                    matriculaListNewMatricula.setCurso(curso);
                    matriculaListNewMatricula = em.merge(matriculaListNewMatricula);
                    if (oldCursoOfMatriculaListNewMatricula != null && !oldCursoOfMatriculaListNewMatricula.equals(curso)) {
                        oldCursoOfMatriculaListNewMatricula.getMatriculaList().remove(matriculaListNewMatricula);
                        oldCursoOfMatriculaListNewMatricula = em.merge(oldCursoOfMatriculaListNewMatricula);
                    }
                }
            }
            for (MasterTeacher masterTeacherListNewMasterTeacher : masterTeacherListNew) {
                if (!masterTeacherListOld.contains(masterTeacherListNewMasterTeacher)) {
                    Curso oldIdCursoOfMasterTeacherListNewMasterTeacher = masterTeacherListNewMasterTeacher.getIdCurso();
                    masterTeacherListNewMasterTeacher.setIdCurso(curso);
                    masterTeacherListNewMasterTeacher = em.merge(masterTeacherListNewMasterTeacher);
                    if (oldIdCursoOfMasterTeacherListNewMasterTeacher != null && !oldIdCursoOfMasterTeacherListNewMasterTeacher.equals(curso)) {
                        oldIdCursoOfMasterTeacherListNewMasterTeacher.getMasterTeacherList().remove(masterTeacherListNewMasterTeacher);
                        oldIdCursoOfMasterTeacherListNewMasterTeacher = em.merge(oldIdCursoOfMasterTeacherListNewMasterTeacher);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = curso.getIdCurso();
                if (findCurso(id) == null) {
                    throw new NonexistentEntityException("The curso with id " + id + " no longer exists.");
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
            Curso curso;
            try {
                curso = em.getReference(Curso.class, id);
                curso.getIdCurso();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The curso with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Matricula> matriculaListOrphanCheck = curso.getMatriculaList();
            for (Matricula matriculaListOrphanCheckMatricula : matriculaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Curso (" + curso + ") cannot be destroyed since the Matricula " + matriculaListOrphanCheckMatricula + " in its matriculaList field has a non-nullable curso field.");
            }
            List<MasterTeacher> masterTeacherListOrphanCheck = curso.getMasterTeacherList();
            for (MasterTeacher masterTeacherListOrphanCheckMasterTeacher : masterTeacherListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Curso (" + curso + ") cannot be destroyed since the MasterTeacher " + masterTeacherListOrphanCheckMasterTeacher + " in its masterTeacherList field has a non-nullable idCurso field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Fases> fasesList = curso.getFasesList();
            for (Fases fasesListFases : fasesList) {
                fasesListFases.setIdCurso(null);
                fasesListFases = em.merge(fasesListFases);
            }
            em.remove(curso);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Curso> findCursoEntities() {
        return findCursoEntities(true, -1, -1);
    }

    public List<Curso> findCursoEntities(int maxResults, int firstResult) {
        return findCursoEntities(false, maxResults, firstResult);
    }

    private List<Curso> findCursoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Curso.class));
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

    public Curso findCurso(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Curso.class, id);
        } finally {
            em.close();
        }
    }

    public int getCursoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Curso> rt = cq.from(Curso.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

} // Fin de la clase DaoCurso
