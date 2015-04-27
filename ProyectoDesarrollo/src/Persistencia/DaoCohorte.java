/** 
 * Nombre del Archivo: CohorteJpaController.java 
 * Fecha de Creacion: 27/04/2015 
 * Autores: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750) 
 */

package Persistencia;

import Logica.Cohorte;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica.Matricula;
import Persistencia.exceptions.IllegalOrphanException;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class DaoCohorte implements Serializable {

    public DaoCohorte(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cohorte cohorte) throws PreexistingEntityException, Exception {
        if (cohorte.getMatriculaList() == null) {
            cohorte.setMatriculaList(new ArrayList<Matricula>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Matricula> attachedMatriculaList = new ArrayList<Matricula>();
            for (Matricula matriculaListMatriculaToAttach : cohorte.getMatriculaList()) {
                matriculaListMatriculaToAttach = em.getReference(matriculaListMatriculaToAttach.getClass(), matriculaListMatriculaToAttach.getMatriculaPK());
                attachedMatriculaList.add(matriculaListMatriculaToAttach);
            }
            cohorte.setMatriculaList(attachedMatriculaList);
            em.persist(cohorte);
            for (Matricula matriculaListMatricula : cohorte.getMatriculaList()) {
                Cohorte oldCohorteOfMatriculaListMatricula = matriculaListMatricula.getCohorte();
                matriculaListMatricula.setCohorte(cohorte);
                matriculaListMatricula = em.merge(matriculaListMatricula);
                if (oldCohorteOfMatriculaListMatricula != null) {
                    oldCohorteOfMatriculaListMatricula.getMatriculaList().remove(matriculaListMatricula);
                    oldCohorteOfMatriculaListMatricula = em.merge(oldCohorteOfMatriculaListMatricula);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCohorte(cohorte.getIdCohorte()) != null) {
                throw new PreexistingEntityException("Cohorte " + cohorte + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cohorte cohorte) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cohorte persistentCohorte = em.find(Cohorte.class, cohorte.getIdCohorte());
            List<Matricula> matriculaListOld = persistentCohorte.getMatriculaList();
            List<Matricula> matriculaListNew = cohorte.getMatriculaList();
            List<String> illegalOrphanMessages = null;
            for (Matricula matriculaListOldMatricula : matriculaListOld) {
                if (!matriculaListNew.contains(matriculaListOldMatricula)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Matricula " + matriculaListOldMatricula + " since its cohorte field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Matricula> attachedMatriculaListNew = new ArrayList<Matricula>();
            for (Matricula matriculaListNewMatriculaToAttach : matriculaListNew) {
                matriculaListNewMatriculaToAttach = em.getReference(matriculaListNewMatriculaToAttach.getClass(), matriculaListNewMatriculaToAttach.getMatriculaPK());
                attachedMatriculaListNew.add(matriculaListNewMatriculaToAttach);
            }
            matriculaListNew = attachedMatriculaListNew;
            cohorte.setMatriculaList(matriculaListNew);
            cohorte = em.merge(cohorte);
            for (Matricula matriculaListNewMatricula : matriculaListNew) {
                if (!matriculaListOld.contains(matriculaListNewMatricula)) {
                    Cohorte oldCohorteOfMatriculaListNewMatricula = matriculaListNewMatricula.getCohorte();
                    matriculaListNewMatricula.setCohorte(cohorte);
                    matriculaListNewMatricula = em.merge(matriculaListNewMatricula);
                    if (oldCohorteOfMatriculaListNewMatricula != null && !oldCohorteOfMatriculaListNewMatricula.equals(cohorte)) {
                        oldCohorteOfMatriculaListNewMatricula.getMatriculaList().remove(matriculaListNewMatricula);
                        oldCohorteOfMatriculaListNewMatricula = em.merge(oldCohorteOfMatriculaListNewMatricula);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = cohorte.getIdCohorte();
                if (findCohorte(id) == null) {
                    throw new NonexistentEntityException("The cohorte with id " + id + " no longer exists.");
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
            Cohorte cohorte;
            try {
                cohorte = em.getReference(Cohorte.class, id);
                cohorte.getIdCohorte();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cohorte with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Matricula> matriculaListOrphanCheck = cohorte.getMatriculaList();
            for (Matricula matriculaListOrphanCheckMatricula : matriculaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cohorte (" + cohorte + ") cannot be destroyed since the Matricula " + matriculaListOrphanCheckMatricula + " in its matriculaList field has a non-nullable cohorte field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(cohorte);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cohorte> findCohorteEntities() {
        return findCohorteEntities(true, -1, -1);
    }

    public List<Cohorte> findCohorteEntities(int maxResults, int firstResult) {
        return findCohorteEntities(false, maxResults, firstResult);
    }

    private List<Cohorte> findCohorteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cohorte.class));
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

    public Cohorte findCohorte(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cohorte.class, id);
        } finally {
            em.close();
        }
    }

    public int getCohorteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cohorte> rt = cq.from(Cohorte.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

} // Fin de la clase DaoCohorte
