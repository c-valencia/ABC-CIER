package Persistencia;

import Logica.Cohorte;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica.CursoCohorte;
import Persistencia.exceptions.IllegalOrphanException;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Nombre del Archivo: DaoCohorte.java
 Fecha de Creacion: 6/05/2015
 Autor: 	JULIAN GARCIA RICO (1225435)
		DIEGO FERNANDO BEDOYA (1327749)
		CRISTIAN ALEXANDER VALENCIA TORRES (1329454)
		OSCAR STEVEN ROMERO BERON (1326750)  
 */

public class DaoCohorte implements Serializable {

    public DaoCohorte(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cohorte cohorte) throws PreexistingEntityException, Exception {
        if (cohorte.getCursoCohorteList() == null) {
            cohorte.setCursoCohorteList(new ArrayList<CursoCohorte>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<CursoCohorte> attachedCursoCohorteList = new ArrayList<CursoCohorte>();
            for (CursoCohorte cursoCohorteListCursoCohorteToAttach : cohorte.getCursoCohorteList()) {
                cursoCohorteListCursoCohorteToAttach = em.getReference(cursoCohorteListCursoCohorteToAttach.getClass(), cursoCohorteListCursoCohorteToAttach.getCursoCohortePK());
                attachedCursoCohorteList.add(cursoCohorteListCursoCohorteToAttach);
            }
            cohorte.setCursoCohorteList(attachedCursoCohorteList);
            em.persist(cohorte);
            for (CursoCohorte cursoCohorteListCursoCohorte : cohorte.getCursoCohorteList()) {
                Cohorte oldCohorteOfCursoCohorteListCursoCohorte = cursoCohorteListCursoCohorte.getCohorte();
                cursoCohorteListCursoCohorte.setCohorte(cohorte);
                cursoCohorteListCursoCohorte = em.merge(cursoCohorteListCursoCohorte);
                if (oldCohorteOfCursoCohorteListCursoCohorte != null) {
                    oldCohorteOfCursoCohorteListCursoCohorte.getCursoCohorteList().remove(cursoCohorteListCursoCohorte);
                    oldCohorteOfCursoCohorteListCursoCohorte = em.merge(oldCohorteOfCursoCohorteListCursoCohorte);
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
            List<CursoCohorte> cursoCohorteListOld = persistentCohorte.getCursoCohorteList();
            List<CursoCohorte> cursoCohorteListNew = cohorte.getCursoCohorteList();
            List<String> illegalOrphanMessages = null;
            for (CursoCohorte cursoCohorteListOldCursoCohorte : cursoCohorteListOld) {
                if (!cursoCohorteListNew.contains(cursoCohorteListOldCursoCohorte)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain CursoCohorte " + cursoCohorteListOldCursoCohorte + " since its cohorte field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<CursoCohorte> attachedCursoCohorteListNew = new ArrayList<CursoCohorte>();
            for (CursoCohorte cursoCohorteListNewCursoCohorteToAttach : cursoCohorteListNew) {
                cursoCohorteListNewCursoCohorteToAttach = em.getReference(cursoCohorteListNewCursoCohorteToAttach.getClass(), cursoCohorteListNewCursoCohorteToAttach.getCursoCohortePK());
                attachedCursoCohorteListNew.add(cursoCohorteListNewCursoCohorteToAttach);
            }
            cursoCohorteListNew = attachedCursoCohorteListNew;
            cohorte.setCursoCohorteList(cursoCohorteListNew);
            cohorte = em.merge(cohorte);
            for (CursoCohorte cursoCohorteListNewCursoCohorte : cursoCohorteListNew) {
                if (!cursoCohorteListOld.contains(cursoCohorteListNewCursoCohorte)) {
                    Cohorte oldCohorteOfCursoCohorteListNewCursoCohorte = cursoCohorteListNewCursoCohorte.getCohorte();
                    cursoCohorteListNewCursoCohorte.setCohorte(cohorte);
                    cursoCohorteListNewCursoCohorte = em.merge(cursoCohorteListNewCursoCohorte);
                    if (oldCohorteOfCursoCohorteListNewCursoCohorte != null && !oldCohorteOfCursoCohorteListNewCursoCohorte.equals(cohorte)) {
                        oldCohorteOfCursoCohorteListNewCursoCohorte.getCursoCohorteList().remove(cursoCohorteListNewCursoCohorte);
                        oldCohorteOfCursoCohorteListNewCursoCohorte = em.merge(oldCohorteOfCursoCohorteListNewCursoCohorte);
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
            List<CursoCohorte> cursoCohorteListOrphanCheck = cohorte.getCursoCohorteList();
            for (CursoCohorte cursoCohorteListOrphanCheckCursoCohorte : cursoCohorteListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cohorte (" + cohorte + ") cannot be destroyed since the CursoCohorte " + cursoCohorteListOrphanCheckCursoCohorte + " in its cursoCohorteList field has a non-nullable cohorte field.");
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
            if (em != null) {
                em.close();
            }
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
            if (em != null) {
                em.close();
            }
        }
    }
    
    public boolean insertCohorte(Cohorte cohorte){
        EntityManager em  = getEntityManager();
        try{           
            em.getTransaction().begin();
            Query query = em.createNativeQuery("INSERT INTO cohorte (fecha_inicio, fecha_fin, estado)" + 
                    "VALUES ('" + cohorte.getFechaInicio() + "', '" + cohorte.getFechaFin() + "', " + cohorte.getEstado() + ");");
            query.executeUpdate();
            em.getTransaction().commit();
            return true;
        }catch (Exception ex){
            System.err.print(ex.getMessage());
        }finally {
            if (em != null) {
                em.close();
            }
        }
        
        return false;
    }
    
    public Cohorte buscarCohorte(Cohorte cohorte) {
        EntityManager em = getEntityManager();
        Cohorte newcohorte = new Cohorte();
        try {
            em.getTransaction().begin();
            Query query = em.createNativeQuery("SELECT id_cohorte FROM cohorte  WHERE  fecha_inicio = '" + new Date(cohorte.getFechaInicio().getTime()) + "' AND fecha_fin ='" + new Date(cohorte.getFechaFin().getTime()) + "';");
            newcohorte.setIdCohorte(query.getSingleResult().toString());
            em.getTransaction().commit(); // OSCAR
            return newcohorte;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    

} // Fin de la clase DaoCohorte
