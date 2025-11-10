package medicalCenter;


import medicalCenter.model.Doctor;
import medicalCenter.model.Patient;
import medicalCenter.storage.MedicalCenterStorage;
import medicalCenter.util.DateUtil;

import java.time.LocalDateTime;
import java.util.Scanner;

public class MedicalCenterDemo {
    static Scanner scanner = new Scanner(System.in);
    static MedicalCenterStorage storage = new MedicalCenterStorage();

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case "0":
                    run = false;
                    break;
                case "1":
                    addDoctor();
                    break;
                case "2":
                    searchDoctorByProfession();
                    break;
                case "3":
                    deleteDoctorById();
                    break;
                case "4":
                    changeDoctorById();
                    break;
                case "5":
                    addPatient();
                    break;
                case "6":
                    printPatientsByDoctor();
                    break;
                case "7":
                    storage.printAllPatients();
                    break;
                default:
                    System.out.println("Invalid command!");
            }
        }
    }

    private static void printCommands() {
        System.out.println("""
                0 - Exit
                1 - Add doctor
                2 - Search doctor by profession
                3 - Delete doctor by id
                4 - Change doctor by id
                5 - Add patient
                6 - Print all patients by doctor
                7 - Print all patients
                """);
    }

    private static void addDoctor() {
        System.out.println("Enter doctor data: id,name,surname,phone,email,profession");
        String[] data = scanner.nextLine().split(",");
        Doctor doctor = new Doctor(data[0], data[1], data[2], data[3], data[4], data[5]);
        storage.addDoctor(doctor);
        System.out.println("Doctor added!");
    }

    private static void searchDoctorByProfession() {
        System.out.println("Enter profession:");
        String profession = scanner.nextLine();
        storage.searchDoctorByProfession(profession);
    }

    private static void deleteDoctorById() {
        System.out.println("Enter doctor id:");
        String id = scanner.nextLine();
        storage.deleteDoctorById(id);
        System.out.println("Doctor deleted if existed.");
    }

    private static void changeDoctorById() {
        System.out.println("Enter doctor id:");
        String id = scanner.nextLine();
        Doctor doctor = storage.getDoctorById(id);
        if (doctor != null) {
            System.out.println("Enter new data (name,surname,phone,email,profession):");
            String[] data = scanner.nextLine().split(",");
            doctor.setName(data[0]);
            doctor.setSurname(data[1]);
            doctor.setPhoneNumber(data[2]);
            doctor.setEmail(data[3]);
            doctor.setProfession(data[4]);
            System.out.println("Doctor data updated!");
        } else {
            System.out.println("Doctor not found!");
        }
    }

    private static void addPatient() {
        if (storage.getDoctors().isEmpty()) {
            System.out.println("No doctors available!");
            return;
        }

        System.out.println("Choose doctor by id:");
        storage.printAllDoctors();
        String docId = scanner.nextLine();
        Doctor doctor = storage.getDoctorById(docId);
        if (doctor == null) {
            System.out.println("Invalid doctor id!");
            return;
        }

        System.out.println("Enter patient data: id,name,surname,phone,registerDateTime(dd-MM-yyyy HH:mm)");
        String[] data = scanner.nextLine().split(",");
        LocalDateTime dateTime = DateUtil.parse(data[4]);
        Patient patient = new Patient(data[0], data[1], data[2], data[3], doctor, dateTime);
        storage.addPatient(patient);
        System.out.println("Patient added!");
    }

    private static void printPatientsByDoctor() {
        storage.printAllDoctors();
        System.out.println("Enter doctor id:");
        String id = scanner.nextLine();
        Doctor doctor = storage.getDoctorById(id);
        if (doctor != null) {
            storage.printPatientsByDoctor(doctor);
        } else {
            System.out.println("Doctor not found!");
        }
    }
}
