package medicalCenter.storage;


import medicalCenter.model.Doctor;
import medicalCenter.model.Patient;
import java.util.ArrayList;
import java.util.List;

public class MedicalCenterStorage {
    private List<Doctor> doctors = new ArrayList<>();
    private List<Patient> patients = new ArrayList<>();

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void printAllDoctors() {
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    public Doctor getDoctorById(String id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId().equals(id)) {
                return doctor;
            }
        }
        return null;
    }

    public void deleteDoctorById(String id) {
        doctors.removeIf(doctor -> doctor.getId().equals(id));
    }

    public void searchDoctorByProfession(String profession) {
        for (Doctor doctor : doctors) {
            if (doctor.getProfession().equalsIgnoreCase(profession)) {
                System.out.println(doctor);
            }
        }
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void printAllPatients() {
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    public void printPatientsByDoctor(Doctor doctor) {
        for (Patient patient : patients) {
            if (patient.getDoctor().equals(doctor)) {
                System.out.println(patient);
            }
        }
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }
}

