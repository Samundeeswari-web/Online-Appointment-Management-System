package com.appointment.service;

import com.appointment.dao.AppointmentDAO;
import com.appointment.model.Appointment;

public class AppointmentService {

    private AppointmentDAO appointmentDAO = new AppointmentDAO();

    public void addAppointment(Appointment appointment) {

        appointmentDAO.addAppointment(appointment);

    }
    public void viewAppointments() {

        appointmentDAO.viewAppointments();

    }
    public void updateAppointment(Appointment appointment) {

        appointmentDAO.updateAppointment(appointment);

    }
    public void deleteAppointment(int appointmentId) {

        appointmentDAO.deleteAppointment(appointmentId);

    }
}
