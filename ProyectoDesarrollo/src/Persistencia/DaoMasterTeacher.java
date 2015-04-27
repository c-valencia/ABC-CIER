/** 
 * Nombre del Archivo: MasterTeacherJpaController.java 
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
import Logica.Curso;
import Logica.MasterTeacher;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class DaoMasterTeacher implements Serializable {

    public DaoMasterTeacher(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MasterTeacher masterTeacher) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Curso idCurso = masterTeacher.getIdCurso();
            if (idCurso != null) {
                idCurso = em.getReference(idCurso.getClass(), idCurso.getIdCurso());
                masterTeacher.setIdCurso(idCurso);
            }
            em.persist(masterTeacher);
            if (idCurso != null) {
                idCurso.getMasterTeacherList().add(masterTeacher);
                idCurso = em.merge(idCurso);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMasterTeacher(masterTeacher.getCedula()) != null) {
                throw new PreexistingEntityException("MasterTeacher " + masterTeacher + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MasterTeacher masterTeacher) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            MasterTeacher persistentMasterTeacher = em.find(MasterTeacher.class, masterTeacher.getCedula());
            Curso idCursoOld = persistentMasterTeacher.getIdCurso();
            Curso idCursoNew = masterTeacher.getIdCurso();
            if (idCursoNew != null) {
                idCursoNew = em.getReference(idCursoNew.getClass(), idCursoNew.getIdCurso());
                masterTeacher.setIdCurso(idCursoNew);
            }
            masterTeacher = em.merge(masterTeacher);
            if (idCursoOld != null && !idCursoOld.equals(idCursoNew)) {
                idCursoOld.getMasterTeacherList().remove(masterTeacher);
                idCursoOld = em.merge(idCursoOld);
            }
            if (idCursoNew != null && !idCursoNew.equals(idCursoOld)) {
                idCursoNew.getMasterTeacherList().add(masterTeacher);
                idCursoNew = em.merge(idCursoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = masterTeacher.getCedula();
                if (findMasterTeacher(id) == null) {
                    throw new NonexistentEntityException("The masterTeacher with id " + id + " no longer exists.");
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
            MasterTeacher masterTeacher;
            try {
                masterTeacher = em.getReference(MasterTeacher.class, id);
                masterTeacher.getCedula();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The masterTeacher with id " + id + " no longer exists.", enfe);
            }
            Curso idCurso = masterTeacher.getIdCurso();
            if (idCurso != null) {
                idCurso.getMasterTeacherList().remove(masterTeacher);
                idCurso = em.merge(idCurso);
            }
            em.remove(masterTeacher);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MasterTeacher> findMasterTeacherEntities() {
        return findMasterTeacherEntities(true, -1, -1);
    }

    public List<MasterTeacher> findMasterTeacherEntities(int maxResults, int firstResult) {
        return findMasterTeacherEntities(false, maxResults, firstResult);
    }

    private List<MasterTeacher> findMasterTeacherEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MasterTeacher.class));
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

    public MasterTeacher findMasterTeacher(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MasterTeacher.class, id);
        } finally {
            em.close();
        }
    }

    public int getMasterTeacherCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MasterTeacher> rt = cq.from(MasterTeacher.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

} // Fin de la clase DaoMasterTeacher
