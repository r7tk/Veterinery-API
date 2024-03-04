package dev.patika.VeterineryManagementSystem.business.concretes;

import dev.patika.VeterineryManagementSystem.dao.IAnimalRepo;
import dev.patika.VeterineryManagementSystem.dao.IAppointmentRepo;
import dev.patika.VeterineryManagementSystem.dao.IDoctorRepo;
import dev.patika.VeterineryManagementSystem.entities.Appointment;
import dev.patika.VeterineryManagementSystem.entities.AvailableDate;
import dev.patika.VeterineryManagementSystem.business.abstracts.IAppointmentService;
import dev.patika.VeterineryManagementSystem.dto.AppointmentFilterByAnimalDTO;
import dev.patika.VeterineryManagementSystem.dto.AppointmentFilterByDoctorDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class AppointmentManager implements IAppointmentService {
    private final IAppointmentRepo appointmentRepo;
    private final IDoctorRepo doctorRepo;

    private final IAnimalRepo animalRepo;
    private final EntityManager entityManager;


    public AppointmentManager(IAppointmentRepo appointmentRepo, IDoctorRepo doctorRepo, IAnimalRepo animalRepo, EntityManager entityManager) {
        this.appointmentRepo = appointmentRepo;
        this.doctorRepo = doctorRepo;
        this.animalRepo = animalRepo;
        this.entityManager = entityManager;
    }

    @Override
    //Randevu kaydı oluştururken doktorun girilen tarihte müsait günü olup olmadığı eğer ki müsait günü varsa randevu kayıtlarında girilen saatte başka bir randevusu olup olmadığı kontrol edilmelidir.
    public Appointment save(Appointment appointment) {

        LocalTime appointmentTime = appointment.getAppointmentDate().toLocalTime();
        if (appointmentTime.getMinute() != 0 || appointmentTime.getSecond() != 0) {
            throw new RuntimeException("Randevu sadece tam saatlerde alınabilir."); //Hayvanların her türlü muayenesi için doktorlardan uygun tarihlerde ve saatlerde randevu oluşturulmalıdır. Her doktor için sadece saat başı randevu oluşturulabilir. Bir muayenenin sabit olarak bir saat süreceğini kabul edin.
        }

        List<AvailableDate> availableDates = checkAvailableDatesByDoctor(appointment);
        if (availableDates.size() != 0) {
            List<Appointment> appointments = checkAppointmentsDatesByDoctor(appointment);
            if (appointments.size() == 0) {
                return this.appointmentRepo.save(appointment);
            } else {
                throw new RuntimeException("Doktorun bu satte başka bir randevusu mevcuttur");
            }
        } else {
            throw new RuntimeException("Doktorun girilen gün için müsaitliği bulunmamaktadır.");
        }
    }

    @Override
    public Appointment update(Appointment appointment) {
        getById(appointment.getId());
        return this.appointmentRepo.save(appointment);

    }

    @Override
    public Appointment getById(Long id) {

        Appointment appointment = this.appointmentRepo.findById(id).orElse(null);
        if (appointment == null) {
            throw new RuntimeException(id + " id’li kayıt sistemde bulunamadı.");
        } else {
            return appointment;
        }
    }

    @Override
    public void delete(Long id) {
        getById(id);
        this.appointmentRepo.deleteById(id);
    }


    @Override
    public List<Appointment> findAll() {
        return this.appointmentRepo.findAll();
    }


    public List<AvailableDate> checkAvailableDatesByDoctor(Appointment appointment) {
        String queryString = "SELECT a FROM AvailableDate a WHERE a.doctor.id = :doctor_id AND a.availableDateDate = :available_date";

        Query query = entityManager.createQuery(queryString);
        query.setParameter("doctor_id", appointment.getDoctor().getId());
        query.setParameter("available_date", appointment.getAppointmentDate().toLocalDate());

        return query.getResultList();
    }

    public List<Appointment> checkAppointmentsDatesByDoctor(Appointment appointment) {
        String queryString = "SELECT a FROM Appointment a WHERE a.doctor.id = :doctor_id AND a.appointmentDate = :appointmentDate";

        Query query = entityManager.createQuery(queryString);
        query.setParameter("doctor_id", appointment.getDoctor().getId());
        query.setParameter("appointmentDate", appointment.getAppointmentDate());

        return query.getResultList();
    }

    @Override // HATA VAR
    public List<Appointment> filterbyDoctor(Long doctorId, LocalDateTime startDate, LocalDateTime endDate) {
        AppointmentFilterByDoctorDTO appointmentFilterByDoctorDTO = new AppointmentFilterByDoctorDTO();
        appointmentFilterByDoctorDTO.setDoctorId(doctorId);
        appointmentFilterByDoctorDTO.setStartDate(startDate);
        appointmentFilterByDoctorDTO.setEndDate(endDate);

        String queryString = "SELECT a FROM Appointment a WHERE a.doctor.id = :doctor_id AND a.appointmentDate >= :startDate AND a.appointmentDate <= :endDate";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("doctor_id", appointmentFilterByDoctorDTO.getDoctorId());
        query.setParameter("startDate", appointmentFilterByDoctorDTO.getStartDate());
        query.setParameter("endDate", appointmentFilterByDoctorDTO.getEndDate());

        if (appointmentFilterByDoctorDTO.getEndDate().isAfter(appointmentFilterByDoctorDTO.getStartDate())) {
            return query.getResultList();
        } else {
            throw new RuntimeException("Giridiğiniz aralıktaki bitiş tarihi  başlangıç tarihinden küçük olamaz.");
        }


    }

    @Override  // HATA VAR DÜZELTİLMESİ LAZIM
    public List<Appointment> filterbyAnimal(Long animalId, LocalDateTime startDate, LocalDateTime endDate) {

        AppointmentFilterByAnimalDTO appointmentFilterByAnimalDTO = new AppointmentFilterByAnimalDTO();
        appointmentFilterByAnimalDTO.setAnimalId(animalId);
        appointmentFilterByAnimalDTO.setStartDate(startDate);
        appointmentFilterByAnimalDTO.setEndDate(endDate);

        if (!appointmentFilterByAnimalDTO.getEndDate().isAfter(appointmentFilterByAnimalDTO.getStartDate())) {
            throw new RuntimeException("Giridiğiniz aralıktaki bitiş tarihi  başlangıç tarihinden küçük olamaz.");
        }


        String queryString = "SELECT a FROM Appointment a WHERE a.animal.id = :animal_id AND a.appointmentDate >= :startDate AND a.appointmentDate <= :endDate";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("animal_id", appointmentFilterByAnimalDTO.getAnimalId());
        query.setParameter("startDate", appointmentFilterByAnimalDTO.getStartDate());
        query.setParameter("endDate", appointmentFilterByAnimalDTO.getEndDate());

        return query.getResultList();
    }

}

