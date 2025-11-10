package medicalCenter.model;

import java.time.LocalDateTime;

    public class Patient extends person {

        private Doctor doctor;
        private LocalDateTime registerDateTime;

        public Patient(String id, String name, String surname, String phone, Doctor doctor, LocalDateTime registerDateTime) {
            super(id, name, surname, phone);
            this.doctor = doctor;
            this.registerDateTime = registerDateTime;
        }

        public Patient() {
        }

        public Doctor getDoctor() {
            return doctor;
        }

        public void setDoctor(Doctor doctor) {
            this.doctor = doctor;
        }

        public LocalDateTime getRegisterDateTime() {
            return registerDateTime;
        }

        public void setRegisterDateTime(LocalDateTime registerDateTime) {
            this.registerDateTime = registerDateTime;
        }

        @Override
        public String toString() {
            return "Patient{" +
                    super.toString() +
                    ", doctor=" + doctor.getName() + " " + doctor.getSurname() +
                    ", registerDateTime=" + registerDateTime +
                    '}';
        }
    }

