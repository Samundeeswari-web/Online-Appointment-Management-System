package com.appointment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.appointment.model.Appointment;
import com.appointment.util.DBConnection;

public class AppointmentDAO {
	public void addAppointment(Appointment appointment) {

	    String sql = "INSERT INTO appointments "
	               + "(patient_name, doctor_name, appointment_date, appointment_time) "
	               + "VALUES (?, ?, ?, ?)";

	    try {

	        Connection con = DBConnection.getConnection();

	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setString(1, appointment.getPatientName());
	        ps.setString(2, appointment.getDoctorName());
	        ps.setString(3, appointment.getAppointmentDate());
	        ps.setString(4, appointment.getAppointmentTime());

	        ps.executeUpdate();

	        System.out.println("Appointment added successfully!");

	        ps.close();
	        con.close();

	    } catch (Exception e) {

	        e.printStackTrace();
	    }
	}
	public void viewAppointments() {

	    String sql = "SELECT * FROM appointments";

	    try {

	        Connection con = DBConnection.getConnection();

	        PreparedStatement ps = con.prepareStatement(sql);

	        java.sql.ResultSet rs = ps.executeQuery();

	        System.out.println("\n===== APPOINTMENT LIST =====");

	        while (rs.next()) {

	            System.out.println("Appointment ID: " + rs.getInt("appointment_id"));
	            System.out.println("Patient Name: " + rs.getString("patient_name"));
	            System.out.println("Doctor Name: " + rs.getString("doctor_name"));
	            System.out.println("Appointment Date: " + rs.getString("appointment_date"));
	            System.out.println("Appointment Time: " + rs.getString("appointment_time"));
	            System.out.println("----------------------------");
	        }

	        rs.close();
	        ps.close();
	        con.close();

	    } catch (Exception e) {

	        e.printStackTrace();
	    }
	}
	public void updateAppointment(Appointment appointment) {

	    String sql = "UPDATE appointments SET doctor_name=?, "
	               + "appointment_date=?, appointment_time=? "
	               + "WHERE appointment_id=?";

	    try {

	        Connection con = DBConnection.getConnection();

	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setString(1, appointment.getDoctorName());
	        ps.setString(2, appointment.getAppointmentDate());
	        ps.setString(3, appointment.getAppointmentTime());
	        ps.setInt(4, appointment.getAppointmentId());

	        int rows = ps.executeUpdate();

	        if (rows > 0) {
	            System.out.println("Appointment updated successfully!");
	        } else {
	            System.out.println("Appointment ID not found!");
	        }

	        ps.close();
	        con.close();

	    } catch (Exception e) {

	        e.printStackTrace();
	    }
	}
	public void deleteAppointment(int appointmentId) {

	    String sql = "DELETE FROM appointments WHERE appointment_id=?";

	    try {

	        Connection con = DBConnection.getConnection();

	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setInt(1, appointmentId);

	        int rows = ps.executeUpdate();

	        if (rows > 0) {
	            System.out.println("Appointment deleted successfully!");
	        } else {
	            System.out.println("Appointment ID not found!");
	        }

	        ps.close();
	        con.close();

	    } catch (Exception e) {

	        e.printStackTrace();
	    }
	}
}