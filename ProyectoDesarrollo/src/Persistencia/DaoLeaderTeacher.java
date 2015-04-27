/** 
 * Nombre del Archivo: LeaderTeacherJpaController.java 
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
import Logica.GradoEscolarida;
import java.util.ArrayList;
import java.util.List;
import Logica.Matricula;
import Logica.LtNivelEscolaridad;
import Logica.LtEtnoeducacion;
import Logica.Tarea;
import Logica.AreaFormacion;
import Logica.LeaderTeacher;
import Logica.LtEnfasis;
import Persistencia.exceptions.IllegalOrphanException;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class DaoLeaderTeacher implements Serializable {

    public DaoLeaderTeacher(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(LeaderTeacher leaderTeacher) throws PreexistingEntityException, Exception {
        if (leaderTeacher.getGradoEscolaridaList() == null) {
            leaderTeacher.setGradoEscolaridaList(new ArrayList<GradoEscolarida>());
        }
        if (leaderTeacher.getMatriculaList() == null) {
            leaderTeacher.setMatriculaList(new ArrayList<Matricula>());
        }
        if (leaderTeacher.getLtNivelEscolaridadList() == null) {
            leaderTeacher.setLtNivelEscolaridadList(new ArrayList<LtNivelEscolaridad>());
        }
        if (leaderTeacher.getLtEtnoeducacionList() == null) {
            leaderTeacher.setLtEtnoeducacionList(new ArrayList<LtEtnoeducacion>());
        }
        if (leaderTeacher.getTareaList() == null) {
            leaderTeacher.setTareaList(new ArrayList<Tarea>());
        }
        if (leaderTeacher.getAreaFormacionList() == null) {
            leaderTeacher.setAreaFormacionList(new ArrayList<AreaFormacion>());
        }
        if (leaderTeacher.getLtEnfasisList() == null) {
            leaderTeacher.setLtEnfasisList(new ArrayList<LtEnfasis>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<GradoEscolarida> attachedGradoEscolaridaList = new ArrayList<GradoEscolarida>();
            for (GradoEscolarida gradoEscolaridaListGradoEscolaridaToAttach : leaderTeacher.getGradoEscolaridaList()) {
                gradoEscolaridaListGradoEscolaridaToAttach = em.getReference(gradoEscolaridaListGradoEscolaridaToAttach.getClass(), gradoEscolaridaListGradoEscolaridaToAttach.getGradoEscolaridaPK());
                attachedGradoEscolaridaList.add(gradoEscolaridaListGradoEscolaridaToAttach);
            }
            leaderTeacher.setGradoEscolaridaList(attachedGradoEscolaridaList);
            List<Matricula> attachedMatriculaList = new ArrayList<Matricula>();
            for (Matricula matriculaListMatriculaToAttach : leaderTeacher.getMatriculaList()) {
                matriculaListMatriculaToAttach = em.getReference(matriculaListMatriculaToAttach.getClass(), matriculaListMatriculaToAttach.getMatriculaPK());
                attachedMatriculaList.add(matriculaListMatriculaToAttach);
            }
            leaderTeacher.setMatriculaList(attachedMatriculaList);
            List<LtNivelEscolaridad> attachedLtNivelEscolaridadList = new ArrayList<LtNivelEscolaridad>();
            for (LtNivelEscolaridad ltNivelEscolaridadListLtNivelEscolaridadToAttach : leaderTeacher.getLtNivelEscolaridadList()) {
                ltNivelEscolaridadListLtNivelEscolaridadToAttach = em.getReference(ltNivelEscolaridadListLtNivelEscolaridadToAttach.getClass(), ltNivelEscolaridadListLtNivelEscolaridadToAttach.getLtNivelEscolaridadPK());
                attachedLtNivelEscolaridadList.add(ltNivelEscolaridadListLtNivelEscolaridadToAttach);
            }
            leaderTeacher.setLtNivelEscolaridadList(attachedLtNivelEscolaridadList);
            List<LtEtnoeducacion> attachedLtEtnoeducacionList = new ArrayList<LtEtnoeducacion>();
            for (LtEtnoeducacion ltEtnoeducacionListLtEtnoeducacionToAttach : leaderTeacher.getLtEtnoeducacionList()) {
                ltEtnoeducacionListLtEtnoeducacionToAttach = em.getReference(ltEtnoeducacionListLtEtnoeducacionToAttach.getClass(), ltEtnoeducacionListLtEtnoeducacionToAttach.getLtEtnoeducacionPK());
                attachedLtEtnoeducacionList.add(ltEtnoeducacionListLtEtnoeducacionToAttach);
            }
            leaderTeacher.setLtEtnoeducacionList(attachedLtEtnoeducacionList);
            List<Tarea> attachedTareaList = new ArrayList<Tarea>();
            for (Tarea tareaListTareaToAttach : leaderTeacher.getTareaList()) {
                tareaListTareaToAttach = em.getReference(tareaListTareaToAttach.getClass(), tareaListTareaToAttach.getTareaPK());
                attachedTareaList.add(tareaListTareaToAttach);
            }
            leaderTeacher.setTareaList(attachedTareaList);
            List<AreaFormacion> attachedAreaFormacionList = new ArrayList<AreaFormacion>();
            for (AreaFormacion areaFormacionListAreaFormacionToAttach : leaderTeacher.getAreaFormacionList()) {
                areaFormacionListAreaFormacionToAttach = em.getReference(areaFormacionListAreaFormacionToAttach.getClass(), areaFormacionListAreaFormacionToAttach.getAreaFormacionPK());
                attachedAreaFormacionList.add(areaFormacionListAreaFormacionToAttach);
            }
            leaderTeacher.setAreaFormacionList(attachedAreaFormacionList);
            List<LtEnfasis> attachedLtEnfasisList = new ArrayList<LtEnfasis>();
            for (LtEnfasis ltEnfasisListLtEnfasisToAttach : leaderTeacher.getLtEnfasisList()) {
                ltEnfasisListLtEnfasisToAttach = em.getReference(ltEnfasisListLtEnfasisToAttach.getClass(), ltEnfasisListLtEnfasisToAttach.getLtEnfasisPK());
                attachedLtEnfasisList.add(ltEnfasisListLtEnfasisToAttach);
            }
            leaderTeacher.setLtEnfasisList(attachedLtEnfasisList);
            em.persist(leaderTeacher);
            for (GradoEscolarida gradoEscolaridaListGradoEscolarida : leaderTeacher.getGradoEscolaridaList()) {
                LeaderTeacher oldLeaderTeacherOfGradoEscolaridaListGradoEscolarida = gradoEscolaridaListGradoEscolarida.getLeaderTeacher();
                gradoEscolaridaListGradoEscolarida.setLeaderTeacher(leaderTeacher);
                gradoEscolaridaListGradoEscolarida = em.merge(gradoEscolaridaListGradoEscolarida);
                if (oldLeaderTeacherOfGradoEscolaridaListGradoEscolarida != null) {
                    oldLeaderTeacherOfGradoEscolaridaListGradoEscolarida.getGradoEscolaridaList().remove(gradoEscolaridaListGradoEscolarida);
                    oldLeaderTeacherOfGradoEscolaridaListGradoEscolarida = em.merge(oldLeaderTeacherOfGradoEscolaridaListGradoEscolarida);
                }
            }
            for (Matricula matriculaListMatricula : leaderTeacher.getMatriculaList()) {
                LeaderTeacher oldLeaderTeacherOfMatriculaListMatricula = matriculaListMatricula.getLeaderTeacher();
                matriculaListMatricula.setLeaderTeacher(leaderTeacher);
                matriculaListMatricula = em.merge(matriculaListMatricula);
                if (oldLeaderTeacherOfMatriculaListMatricula != null) {
                    oldLeaderTeacherOfMatriculaListMatricula.getMatriculaList().remove(matriculaListMatricula);
                    oldLeaderTeacherOfMatriculaListMatricula = em.merge(oldLeaderTeacherOfMatriculaListMatricula);
                }
            }
            for (LtNivelEscolaridad ltNivelEscolaridadListLtNivelEscolaridad : leaderTeacher.getLtNivelEscolaridadList()) {
                LeaderTeacher oldLeaderTeacherOfLtNivelEscolaridadListLtNivelEscolaridad = ltNivelEscolaridadListLtNivelEscolaridad.getLeaderTeacher();
                ltNivelEscolaridadListLtNivelEscolaridad.setLeaderTeacher(leaderTeacher);
                ltNivelEscolaridadListLtNivelEscolaridad = em.merge(ltNivelEscolaridadListLtNivelEscolaridad);
                if (oldLeaderTeacherOfLtNivelEscolaridadListLtNivelEscolaridad != null) {
                    oldLeaderTeacherOfLtNivelEscolaridadListLtNivelEscolaridad.getLtNivelEscolaridadList().remove(ltNivelEscolaridadListLtNivelEscolaridad);
                    oldLeaderTeacherOfLtNivelEscolaridadListLtNivelEscolaridad = em.merge(oldLeaderTeacherOfLtNivelEscolaridadListLtNivelEscolaridad);
                }
            }
            for (LtEtnoeducacion ltEtnoeducacionListLtEtnoeducacion : leaderTeacher.getLtEtnoeducacionList()) {
                LeaderTeacher oldLeaderTeacherOfLtEtnoeducacionListLtEtnoeducacion = ltEtnoeducacionListLtEtnoeducacion.getLeaderTeacher();
                ltEtnoeducacionListLtEtnoeducacion.setLeaderTeacher(leaderTeacher);
                ltEtnoeducacionListLtEtnoeducacion = em.merge(ltEtnoeducacionListLtEtnoeducacion);
                if (oldLeaderTeacherOfLtEtnoeducacionListLtEtnoeducacion != null) {
                    oldLeaderTeacherOfLtEtnoeducacionListLtEtnoeducacion.getLtEtnoeducacionList().remove(ltEtnoeducacionListLtEtnoeducacion);
                    oldLeaderTeacherOfLtEtnoeducacionListLtEtnoeducacion = em.merge(oldLeaderTeacherOfLtEtnoeducacionListLtEtnoeducacion);
                }
            }
            for (Tarea tareaListTarea : leaderTeacher.getTareaList()) {
                LeaderTeacher oldLeaderTeacherOfTareaListTarea = tareaListTarea.getLeaderTeacher();
                tareaListTarea.setLeaderTeacher(leaderTeacher);
                tareaListTarea = em.merge(tareaListTarea);
                if (oldLeaderTeacherOfTareaListTarea != null) {
                    oldLeaderTeacherOfTareaListTarea.getTareaList().remove(tareaListTarea);
                    oldLeaderTeacherOfTareaListTarea = em.merge(oldLeaderTeacherOfTareaListTarea);
                }
            }
            for (AreaFormacion areaFormacionListAreaFormacion : leaderTeacher.getAreaFormacionList()) {
                LeaderTeacher oldLeaderTeacherOfAreaFormacionListAreaFormacion = areaFormacionListAreaFormacion.getLeaderTeacher();
                areaFormacionListAreaFormacion.setLeaderTeacher(leaderTeacher);
                areaFormacionListAreaFormacion = em.merge(areaFormacionListAreaFormacion);
                if (oldLeaderTeacherOfAreaFormacionListAreaFormacion != null) {
                    oldLeaderTeacherOfAreaFormacionListAreaFormacion.getAreaFormacionList().remove(areaFormacionListAreaFormacion);
                    oldLeaderTeacherOfAreaFormacionListAreaFormacion = em.merge(oldLeaderTeacherOfAreaFormacionListAreaFormacion);
                }
            }
            for (LtEnfasis ltEnfasisListLtEnfasis : leaderTeacher.getLtEnfasisList()) {
                LeaderTeacher oldLeaderTeacherOfLtEnfasisListLtEnfasis = ltEnfasisListLtEnfasis.getLeaderTeacher();
                ltEnfasisListLtEnfasis.setLeaderTeacher(leaderTeacher);
                ltEnfasisListLtEnfasis = em.merge(ltEnfasisListLtEnfasis);
                if (oldLeaderTeacherOfLtEnfasisListLtEnfasis != null) {
                    oldLeaderTeacherOfLtEnfasisListLtEnfasis.getLtEnfasisList().remove(ltEnfasisListLtEnfasis);
                    oldLeaderTeacherOfLtEnfasisListLtEnfasis = em.merge(oldLeaderTeacherOfLtEnfasisListLtEnfasis);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLeaderTeacher(leaderTeacher.getCedula()) != null) {
                throw new PreexistingEntityException("LeaderTeacher " + leaderTeacher + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(LeaderTeacher leaderTeacher) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LeaderTeacher persistentLeaderTeacher = em.find(LeaderTeacher.class, leaderTeacher.getCedula());
            List<GradoEscolarida> gradoEscolaridaListOld = persistentLeaderTeacher.getGradoEscolaridaList();
            List<GradoEscolarida> gradoEscolaridaListNew = leaderTeacher.getGradoEscolaridaList();
            List<Matricula> matriculaListOld = persistentLeaderTeacher.getMatriculaList();
            List<Matricula> matriculaListNew = leaderTeacher.getMatriculaList();
            List<LtNivelEscolaridad> ltNivelEscolaridadListOld = persistentLeaderTeacher.getLtNivelEscolaridadList();
            List<LtNivelEscolaridad> ltNivelEscolaridadListNew = leaderTeacher.getLtNivelEscolaridadList();
            List<LtEtnoeducacion> ltEtnoeducacionListOld = persistentLeaderTeacher.getLtEtnoeducacionList();
            List<LtEtnoeducacion> ltEtnoeducacionListNew = leaderTeacher.getLtEtnoeducacionList();
            List<Tarea> tareaListOld = persistentLeaderTeacher.getTareaList();
            List<Tarea> tareaListNew = leaderTeacher.getTareaList();
            List<AreaFormacion> areaFormacionListOld = persistentLeaderTeacher.getAreaFormacionList();
            List<AreaFormacion> areaFormacionListNew = leaderTeacher.getAreaFormacionList();
            List<LtEnfasis> ltEnfasisListOld = persistentLeaderTeacher.getLtEnfasisList();
            List<LtEnfasis> ltEnfasisListNew = leaderTeacher.getLtEnfasisList();
            List<String> illegalOrphanMessages = null;
            for (GradoEscolarida gradoEscolaridaListOldGradoEscolarida : gradoEscolaridaListOld) {
                if (!gradoEscolaridaListNew.contains(gradoEscolaridaListOldGradoEscolarida)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain GradoEscolarida " + gradoEscolaridaListOldGradoEscolarida + " since its leaderTeacher field is not nullable.");
                }
            }
            for (Matricula matriculaListOldMatricula : matriculaListOld) {
                if (!matriculaListNew.contains(matriculaListOldMatricula)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Matricula " + matriculaListOldMatricula + " since its leaderTeacher field is not nullable.");
                }
            }
            for (LtNivelEscolaridad ltNivelEscolaridadListOldLtNivelEscolaridad : ltNivelEscolaridadListOld) {
                if (!ltNivelEscolaridadListNew.contains(ltNivelEscolaridadListOldLtNivelEscolaridad)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain LtNivelEscolaridad " + ltNivelEscolaridadListOldLtNivelEscolaridad + " since its leaderTeacher field is not nullable.");
                }
            }
            for (LtEtnoeducacion ltEtnoeducacionListOldLtEtnoeducacion : ltEtnoeducacionListOld) {
                if (!ltEtnoeducacionListNew.contains(ltEtnoeducacionListOldLtEtnoeducacion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain LtEtnoeducacion " + ltEtnoeducacionListOldLtEtnoeducacion + " since its leaderTeacher field is not nullable.");
                }
            }
            for (Tarea tareaListOldTarea : tareaListOld) {
                if (!tareaListNew.contains(tareaListOldTarea)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Tarea " + tareaListOldTarea + " since its leaderTeacher field is not nullable.");
                }
            }
            for (AreaFormacion areaFormacionListOldAreaFormacion : areaFormacionListOld) {
                if (!areaFormacionListNew.contains(areaFormacionListOldAreaFormacion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain AreaFormacion " + areaFormacionListOldAreaFormacion + " since its leaderTeacher field is not nullable.");
                }
            }
            for (LtEnfasis ltEnfasisListOldLtEnfasis : ltEnfasisListOld) {
                if (!ltEnfasisListNew.contains(ltEnfasisListOldLtEnfasis)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain LtEnfasis " + ltEnfasisListOldLtEnfasis + " since its leaderTeacher field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<GradoEscolarida> attachedGradoEscolaridaListNew = new ArrayList<GradoEscolarida>();
            for (GradoEscolarida gradoEscolaridaListNewGradoEscolaridaToAttach : gradoEscolaridaListNew) {
                gradoEscolaridaListNewGradoEscolaridaToAttach = em.getReference(gradoEscolaridaListNewGradoEscolaridaToAttach.getClass(), gradoEscolaridaListNewGradoEscolaridaToAttach.getGradoEscolaridaPK());
                attachedGradoEscolaridaListNew.add(gradoEscolaridaListNewGradoEscolaridaToAttach);
            }
            gradoEscolaridaListNew = attachedGradoEscolaridaListNew;
            leaderTeacher.setGradoEscolaridaList(gradoEscolaridaListNew);
            List<Matricula> attachedMatriculaListNew = new ArrayList<Matricula>();
            for (Matricula matriculaListNewMatriculaToAttach : matriculaListNew) {
                matriculaListNewMatriculaToAttach = em.getReference(matriculaListNewMatriculaToAttach.getClass(), matriculaListNewMatriculaToAttach.getMatriculaPK());
                attachedMatriculaListNew.add(matriculaListNewMatriculaToAttach);
            }
            matriculaListNew = attachedMatriculaListNew;
            leaderTeacher.setMatriculaList(matriculaListNew);
            List<LtNivelEscolaridad> attachedLtNivelEscolaridadListNew = new ArrayList<LtNivelEscolaridad>();
            for (LtNivelEscolaridad ltNivelEscolaridadListNewLtNivelEscolaridadToAttach : ltNivelEscolaridadListNew) {
                ltNivelEscolaridadListNewLtNivelEscolaridadToAttach = em.getReference(ltNivelEscolaridadListNewLtNivelEscolaridadToAttach.getClass(), ltNivelEscolaridadListNewLtNivelEscolaridadToAttach.getLtNivelEscolaridadPK());
                attachedLtNivelEscolaridadListNew.add(ltNivelEscolaridadListNewLtNivelEscolaridadToAttach);
            }
            ltNivelEscolaridadListNew = attachedLtNivelEscolaridadListNew;
            leaderTeacher.setLtNivelEscolaridadList(ltNivelEscolaridadListNew);
            List<LtEtnoeducacion> attachedLtEtnoeducacionListNew = new ArrayList<LtEtnoeducacion>();
            for (LtEtnoeducacion ltEtnoeducacionListNewLtEtnoeducacionToAttach : ltEtnoeducacionListNew) {
                ltEtnoeducacionListNewLtEtnoeducacionToAttach = em.getReference(ltEtnoeducacionListNewLtEtnoeducacionToAttach.getClass(), ltEtnoeducacionListNewLtEtnoeducacionToAttach.getLtEtnoeducacionPK());
                attachedLtEtnoeducacionListNew.add(ltEtnoeducacionListNewLtEtnoeducacionToAttach);
            }
            ltEtnoeducacionListNew = attachedLtEtnoeducacionListNew;
            leaderTeacher.setLtEtnoeducacionList(ltEtnoeducacionListNew);
            List<Tarea> attachedTareaListNew = new ArrayList<Tarea>();
            for (Tarea tareaListNewTareaToAttach : tareaListNew) {
                tareaListNewTareaToAttach = em.getReference(tareaListNewTareaToAttach.getClass(), tareaListNewTareaToAttach.getTareaPK());
                attachedTareaListNew.add(tareaListNewTareaToAttach);
            }
            tareaListNew = attachedTareaListNew;
            leaderTeacher.setTareaList(tareaListNew);
            List<AreaFormacion> attachedAreaFormacionListNew = new ArrayList<AreaFormacion>();
            for (AreaFormacion areaFormacionListNewAreaFormacionToAttach : areaFormacionListNew) {
                areaFormacionListNewAreaFormacionToAttach = em.getReference(areaFormacionListNewAreaFormacionToAttach.getClass(), areaFormacionListNewAreaFormacionToAttach.getAreaFormacionPK());
                attachedAreaFormacionListNew.add(areaFormacionListNewAreaFormacionToAttach);
            }
            areaFormacionListNew = attachedAreaFormacionListNew;
            leaderTeacher.setAreaFormacionList(areaFormacionListNew);
            List<LtEnfasis> attachedLtEnfasisListNew = new ArrayList<LtEnfasis>();
            for (LtEnfasis ltEnfasisListNewLtEnfasisToAttach : ltEnfasisListNew) {
                ltEnfasisListNewLtEnfasisToAttach = em.getReference(ltEnfasisListNewLtEnfasisToAttach.getClass(), ltEnfasisListNewLtEnfasisToAttach.getLtEnfasisPK());
                attachedLtEnfasisListNew.add(ltEnfasisListNewLtEnfasisToAttach);
            }
            ltEnfasisListNew = attachedLtEnfasisListNew;
            leaderTeacher.setLtEnfasisList(ltEnfasisListNew);
            leaderTeacher = em.merge(leaderTeacher);
            for (GradoEscolarida gradoEscolaridaListNewGradoEscolarida : gradoEscolaridaListNew) {
                if (!gradoEscolaridaListOld.contains(gradoEscolaridaListNewGradoEscolarida)) {
                    LeaderTeacher oldLeaderTeacherOfGradoEscolaridaListNewGradoEscolarida = gradoEscolaridaListNewGradoEscolarida.getLeaderTeacher();
                    gradoEscolaridaListNewGradoEscolarida.setLeaderTeacher(leaderTeacher);
                    gradoEscolaridaListNewGradoEscolarida = em.merge(gradoEscolaridaListNewGradoEscolarida);
                    if (oldLeaderTeacherOfGradoEscolaridaListNewGradoEscolarida != null && !oldLeaderTeacherOfGradoEscolaridaListNewGradoEscolarida.equals(leaderTeacher)) {
                        oldLeaderTeacherOfGradoEscolaridaListNewGradoEscolarida.getGradoEscolaridaList().remove(gradoEscolaridaListNewGradoEscolarida);
                        oldLeaderTeacherOfGradoEscolaridaListNewGradoEscolarida = em.merge(oldLeaderTeacherOfGradoEscolaridaListNewGradoEscolarida);
                    }
                }
            }
            for (Matricula matriculaListNewMatricula : matriculaListNew) {
                if (!matriculaListOld.contains(matriculaListNewMatricula)) {
                    LeaderTeacher oldLeaderTeacherOfMatriculaListNewMatricula = matriculaListNewMatricula.getLeaderTeacher();
                    matriculaListNewMatricula.setLeaderTeacher(leaderTeacher);
                    matriculaListNewMatricula = em.merge(matriculaListNewMatricula);
                    if (oldLeaderTeacherOfMatriculaListNewMatricula != null && !oldLeaderTeacherOfMatriculaListNewMatricula.equals(leaderTeacher)) {
                        oldLeaderTeacherOfMatriculaListNewMatricula.getMatriculaList().remove(matriculaListNewMatricula);
                        oldLeaderTeacherOfMatriculaListNewMatricula = em.merge(oldLeaderTeacherOfMatriculaListNewMatricula);
                    }
                }
            }
            for (LtNivelEscolaridad ltNivelEscolaridadListNewLtNivelEscolaridad : ltNivelEscolaridadListNew) {
                if (!ltNivelEscolaridadListOld.contains(ltNivelEscolaridadListNewLtNivelEscolaridad)) {
                    LeaderTeacher oldLeaderTeacherOfLtNivelEscolaridadListNewLtNivelEscolaridad = ltNivelEscolaridadListNewLtNivelEscolaridad.getLeaderTeacher();
                    ltNivelEscolaridadListNewLtNivelEscolaridad.setLeaderTeacher(leaderTeacher);
                    ltNivelEscolaridadListNewLtNivelEscolaridad = em.merge(ltNivelEscolaridadListNewLtNivelEscolaridad);
                    if (oldLeaderTeacherOfLtNivelEscolaridadListNewLtNivelEscolaridad != null && !oldLeaderTeacherOfLtNivelEscolaridadListNewLtNivelEscolaridad.equals(leaderTeacher)) {
                        oldLeaderTeacherOfLtNivelEscolaridadListNewLtNivelEscolaridad.getLtNivelEscolaridadList().remove(ltNivelEscolaridadListNewLtNivelEscolaridad);
                        oldLeaderTeacherOfLtNivelEscolaridadListNewLtNivelEscolaridad = em.merge(oldLeaderTeacherOfLtNivelEscolaridadListNewLtNivelEscolaridad);
                    }
                }
            }
            for (LtEtnoeducacion ltEtnoeducacionListNewLtEtnoeducacion : ltEtnoeducacionListNew) {
                if (!ltEtnoeducacionListOld.contains(ltEtnoeducacionListNewLtEtnoeducacion)) {
                    LeaderTeacher oldLeaderTeacherOfLtEtnoeducacionListNewLtEtnoeducacion = ltEtnoeducacionListNewLtEtnoeducacion.getLeaderTeacher();
                    ltEtnoeducacionListNewLtEtnoeducacion.setLeaderTeacher(leaderTeacher);
                    ltEtnoeducacionListNewLtEtnoeducacion = em.merge(ltEtnoeducacionListNewLtEtnoeducacion);
                    if (oldLeaderTeacherOfLtEtnoeducacionListNewLtEtnoeducacion != null && !oldLeaderTeacherOfLtEtnoeducacionListNewLtEtnoeducacion.equals(leaderTeacher)) {
                        oldLeaderTeacherOfLtEtnoeducacionListNewLtEtnoeducacion.getLtEtnoeducacionList().remove(ltEtnoeducacionListNewLtEtnoeducacion);
                        oldLeaderTeacherOfLtEtnoeducacionListNewLtEtnoeducacion = em.merge(oldLeaderTeacherOfLtEtnoeducacionListNewLtEtnoeducacion);
                    }
                }
            }
            for (Tarea tareaListNewTarea : tareaListNew) {
                if (!tareaListOld.contains(tareaListNewTarea)) {
                    LeaderTeacher oldLeaderTeacherOfTareaListNewTarea = tareaListNewTarea.getLeaderTeacher();
                    tareaListNewTarea.setLeaderTeacher(leaderTeacher);
                    tareaListNewTarea = em.merge(tareaListNewTarea);
                    if (oldLeaderTeacherOfTareaListNewTarea != null && !oldLeaderTeacherOfTareaListNewTarea.equals(leaderTeacher)) {
                        oldLeaderTeacherOfTareaListNewTarea.getTareaList().remove(tareaListNewTarea);
                        oldLeaderTeacherOfTareaListNewTarea = em.merge(oldLeaderTeacherOfTareaListNewTarea);
                    }
                }
            }
            for (AreaFormacion areaFormacionListNewAreaFormacion : areaFormacionListNew) {
                if (!areaFormacionListOld.contains(areaFormacionListNewAreaFormacion)) {
                    LeaderTeacher oldLeaderTeacherOfAreaFormacionListNewAreaFormacion = areaFormacionListNewAreaFormacion.getLeaderTeacher();
                    areaFormacionListNewAreaFormacion.setLeaderTeacher(leaderTeacher);
                    areaFormacionListNewAreaFormacion = em.merge(areaFormacionListNewAreaFormacion);
                    if (oldLeaderTeacherOfAreaFormacionListNewAreaFormacion != null && !oldLeaderTeacherOfAreaFormacionListNewAreaFormacion.equals(leaderTeacher)) {
                        oldLeaderTeacherOfAreaFormacionListNewAreaFormacion.getAreaFormacionList().remove(areaFormacionListNewAreaFormacion);
                        oldLeaderTeacherOfAreaFormacionListNewAreaFormacion = em.merge(oldLeaderTeacherOfAreaFormacionListNewAreaFormacion);
                    }
                }
            }
            for (LtEnfasis ltEnfasisListNewLtEnfasis : ltEnfasisListNew) {
                if (!ltEnfasisListOld.contains(ltEnfasisListNewLtEnfasis)) {
                    LeaderTeacher oldLeaderTeacherOfLtEnfasisListNewLtEnfasis = ltEnfasisListNewLtEnfasis.getLeaderTeacher();
                    ltEnfasisListNewLtEnfasis.setLeaderTeacher(leaderTeacher);
                    ltEnfasisListNewLtEnfasis = em.merge(ltEnfasisListNewLtEnfasis);
                    if (oldLeaderTeacherOfLtEnfasisListNewLtEnfasis != null && !oldLeaderTeacherOfLtEnfasisListNewLtEnfasis.equals(leaderTeacher)) {
                        oldLeaderTeacherOfLtEnfasisListNewLtEnfasis.getLtEnfasisList().remove(ltEnfasisListNewLtEnfasis);
                        oldLeaderTeacherOfLtEnfasisListNewLtEnfasis = em.merge(oldLeaderTeacherOfLtEnfasisListNewLtEnfasis);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = leaderTeacher.getCedula();
                if (findLeaderTeacher(id) == null) {
                    throw new NonexistentEntityException("The leaderTeacher with id " + id + " no longer exists.");
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
            LeaderTeacher leaderTeacher;
            try {
                leaderTeacher = em.getReference(LeaderTeacher.class, id);
                leaderTeacher.getCedula();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The leaderTeacher with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<GradoEscolarida> gradoEscolaridaListOrphanCheck = leaderTeacher.getGradoEscolaridaList();
            for (GradoEscolarida gradoEscolaridaListOrphanCheckGradoEscolarida : gradoEscolaridaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This LeaderTeacher (" + leaderTeacher + ") cannot be destroyed since the GradoEscolarida " + gradoEscolaridaListOrphanCheckGradoEscolarida + " in its gradoEscolaridaList field has a non-nullable leaderTeacher field.");
            }
            List<Matricula> matriculaListOrphanCheck = leaderTeacher.getMatriculaList();
            for (Matricula matriculaListOrphanCheckMatricula : matriculaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This LeaderTeacher (" + leaderTeacher + ") cannot be destroyed since the Matricula " + matriculaListOrphanCheckMatricula + " in its matriculaList field has a non-nullable leaderTeacher field.");
            }
            List<LtNivelEscolaridad> ltNivelEscolaridadListOrphanCheck = leaderTeacher.getLtNivelEscolaridadList();
            for (LtNivelEscolaridad ltNivelEscolaridadListOrphanCheckLtNivelEscolaridad : ltNivelEscolaridadListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This LeaderTeacher (" + leaderTeacher + ") cannot be destroyed since the LtNivelEscolaridad " + ltNivelEscolaridadListOrphanCheckLtNivelEscolaridad + " in its ltNivelEscolaridadList field has a non-nullable leaderTeacher field.");
            }
            List<LtEtnoeducacion> ltEtnoeducacionListOrphanCheck = leaderTeacher.getLtEtnoeducacionList();
            for (LtEtnoeducacion ltEtnoeducacionListOrphanCheckLtEtnoeducacion : ltEtnoeducacionListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This LeaderTeacher (" + leaderTeacher + ") cannot be destroyed since the LtEtnoeducacion " + ltEtnoeducacionListOrphanCheckLtEtnoeducacion + " in its ltEtnoeducacionList field has a non-nullable leaderTeacher field.");
            }
            List<Tarea> tareaListOrphanCheck = leaderTeacher.getTareaList();
            for (Tarea tareaListOrphanCheckTarea : tareaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This LeaderTeacher (" + leaderTeacher + ") cannot be destroyed since the Tarea " + tareaListOrphanCheckTarea + " in its tareaList field has a non-nullable leaderTeacher field.");
            }
            List<AreaFormacion> areaFormacionListOrphanCheck = leaderTeacher.getAreaFormacionList();
            for (AreaFormacion areaFormacionListOrphanCheckAreaFormacion : areaFormacionListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This LeaderTeacher (" + leaderTeacher + ") cannot be destroyed since the AreaFormacion " + areaFormacionListOrphanCheckAreaFormacion + " in its areaFormacionList field has a non-nullable leaderTeacher field.");
            }
            List<LtEnfasis> ltEnfasisListOrphanCheck = leaderTeacher.getLtEnfasisList();
            for (LtEnfasis ltEnfasisListOrphanCheckLtEnfasis : ltEnfasisListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This LeaderTeacher (" + leaderTeacher + ") cannot be destroyed since the LtEnfasis " + ltEnfasisListOrphanCheckLtEnfasis + " in its ltEnfasisList field has a non-nullable leaderTeacher field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(leaderTeacher);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<LeaderTeacher> findLeaderTeacherEntities() {
        return findLeaderTeacherEntities(true, -1, -1);
    }

    public List<LeaderTeacher> findLeaderTeacherEntities(int maxResults, int firstResult) {
        return findLeaderTeacherEntities(false, maxResults, firstResult);
    }

    private List<LeaderTeacher> findLeaderTeacherEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(LeaderTeacher.class));
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

    public LeaderTeacher findLeaderTeacher(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(LeaderTeacher.class, id);
        } finally {
            em.close();
        }
    }

    public int getLeaderTeacherCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<LeaderTeacher> rt = cq.from(LeaderTeacher.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

} // Fin de la clase DaoLeaderTeacher
