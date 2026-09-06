package com.appointment.main;

import java.util.Scanner;

import com.appointment.model.Appointment;
import com.appointment.service.AppointmentService;

public class AppointmentMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AppointmentService service = new AppointmentService();

        int choice;

        do {

            System.out.println("\n===== ONLINE APPOINTMENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Appointment");
            System.out.println("2. View Appointments");
            System.out.println("3. Update Appointment");
            System.out.println("4. Delete Appointment");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

            case 1:

                System.out.print("Enter Patient Name: ");
                String patientName = sc.nextLine();

                System.out.print("Enter Doctor Name: ");
                String doctorName = sc.nextLine();

                System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
                String appointmentDate = sc.nextLine();

                System.out.print("Enter Appointment Time: ");
                String appointmentTime = sc.nextLine();

                Appointment appointment = new Appointment();

                appointment.setPatientName(patientName);
                appointment.setDoctorName(doctorName);
                appointment.setAppointmentDate(appointmentDate);
                appointment.setAppointmentTime(appointmentTime);

                service.addAppointment(appointment);

                break;

            case 2:

                service.viewAppointments();

                break;

            case 3:

                System.out.print("Enter Appointment ID to update: ");
                int appointmentId = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter new Doctor Name: ");
                String newDoctorName = sc.nextLine();

                System.out.print("Enter new Appointment Date (YYYY-MM-DD): ");
                String newDate = sc.nextLine();

                System.out.print("Enter new Appointment Time: ");
                String newTime = sc.nextLine();

                Appointment updatedAppointment = new Appointment();

                updatedAppointment.setAppointmentId(appointmentId);
                updatedAppointment.setDoctorName(newDoctorName);
                updatedAppointment.setAppointmentDate(newDate);
                updatedAppointment.setAppointmentTime(newTime);

                service.updateAppointment(updatedAppointment);

                break;

            case 4:

                System.out.print("Enter Appointment ID to delete: ");
                int deleteId = sc.nextInt();

                service.deleteAppointment(deleteId);

                break;

            case 5:

                System.out.println("Thank you for using the system!");

                break;

            default:

                System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}