package airlinepackage;

import java.sql.*;
import javax.swing.*;


public class AdminView extends project{

	public static void DisplayintTable(Connection connection) throws SQLException{
	 PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM flights as F NATURAL JOIN international_flight as I");
     //Creating Java ResultSet object
     ResultSet resultSet=preparedStatement.executeQuery();
     String x="";
     while(resultSet.next()){
          int FLIGHT_ID=resultSet.getInt("FLIGHT_ID");
          String DESTINATION_Country=resultSet.getString("Destination_Country");
          boolean Passengers_Vaccinated=resultSet.getBoolean("Passengers_Vaccinated");
          int Airport_Code=resultSet.getInt("Airport_Code");
          int Passengers_No=resultSet.getInt("Passengers_No");
          String Plane_Type=resultSet.getString("Plane_Type");
          Time TIME_FROM=resultSet. getTime("TIME_FROM");
          Time TIME_TO=resultSet. getTime("TIME_TO");         

          x=x+FLIGHT_ID+" "+DESTINATION_Country+" "+Passengers_Vaccinated+" "+Airport_Code+" "+ Passengers_No+" "+Plane_Type+" "+TIME_FROM+" "+ TIME_TO+"\n";}
          //Printing Results
          JOptionPane.showMessageDialog( null, x, "All Flights", JOptionPane.PLAIN_MESSAGE );}

	
	public static void DisplaylocTable(Connection connection) throws SQLException{
		 PreparedStatement preparedStatement1=connection.prepareStatement("SELECT * FROM flights as F NATURAL JOIN local_flight as L");
		 //Creating Java ResultSet object
	    ResultSet resultSet=preparedStatement1.executeQuery();
	    String x="";
	    while(resultSet.next()){
	         int FLIGHT_ID=resultSet.getInt("FLIGHT_ID");
	         String DESTINATION_City=resultSet.getString("Destination_City");
	         int Airport_Code=resultSet.getInt("Airport_Code");
	         int Passengers_No=resultSet.getInt("Passengers_No");
	         String Plane_Type=resultSet.getString("Plane_Type");
	         Time TIME_FROM=resultSet. getTime("TIME_FROM");
	         Time TIME_TO=resultSet. getTime("TIME_TO");          
	         x=x+FLIGHT_ID+" "+DESTINATION_City+" "+Airport_Code+" "+ Passengers_No+" "+Plane_Type+" "+TIME_FROM+" "+ TIME_TO+"\n";}
	         //Printing Results
	         JOptionPane.showMessageDialog( null, x, "All Flights", JOptionPane.PLAIN_MESSAGE );}
	
		
	
	public static void Display_passengers(Connection connection) throws SQLException{
		 PreparedStatement preparedStatement2=connection.prepareStatement("select * from passengers");
	     //Creating Java ResultSet object
	     ResultSet resultSet=preparedStatement2.executeQuery();
	     String x="";
	     while(resultSet.next()){
	          int Passport_No=resultSet.getInt("Passport_No");
	          int Boarding_ID=resultSet.getInt("Boarding_ID");
	          int En_ID=resultSet.getInt("En_ID");
	          int Ticket_Id=resultSet. getInt("Ticket_Id");
	          int FLIGHT_ID=resultSet. getInt("FLIGHT_ID");
	          String First_Name=resultSet.getString("First_Name");
	          String Last_Name=resultSet.getString("Last_Name");
	          Boolean Vaccinated=resultSet.getBoolean("Vaccinated");
	          x= x +Passport_No+" "+ Boarding_ID+ " "+ En_ID+ " " +Ticket_Id+ " "+ FLIGHT_ID+ " "+First_Name+" "+" "+Last_Name+" "+ Vaccinated+"\n";}
	          //Printing Results
	          JOptionPane.showMessageDialog( null, x, "All passengers", JOptionPane.PLAIN_MESSAGE );}

	
	public static void Display_Enquiry(Connection connection) throws SQLException{
		 PreparedStatement preparedStatement3=connection.prepareStatement("select * from airline_enquiry");
	     //Creating Java ResultSet object
	     ResultSet resultSet=preparedStatement3.executeQuery();
	     String x="";
	     while(resultSet.next()){
	          int En_ID=resultSet.getInt("En_ID");
	          Date En_Date=resultSet.getDate("En_Date");
	          String En_Description=resultSet.getString("En_Description");
	          String En_Title=resultSet. getString("En_Title");
	          String En_Type=resultSet. getString("En_Type");

	          x= x +En_ID+" "+ En_Date+ " "+ En_Description+ " " +En_Title+ " "+ En_Type+"\n";}
	          //Printing Results
	          JOptionPane.showMessageDialog( null, x, "All Enquirys", JOptionPane.PLAIN_MESSAGE );	}
	

	public static void AddlocFlight( Connection connection, Integer FLIGHT_ID, Integer Airport_Code, Integer Passengers_No, String Plane_Type, Time TIME_FROM, Time TIME_TO,String Destination_City ) throws SQLException{
		PreparedStatement preparedStatement2=connection.prepareStatement("insert into flights values(?,?,?,?,?,?)");
		PreparedStatement preparedStatement3=connection.prepareStatement("insert into local_flight values(?, ?)");
		  //Setting values for Each Parameter
		  preparedStatement2.setInt(1,FLIGHT_ID);
		  preparedStatement2.setInt(2,Airport_Code);
		  preparedStatement2.setInt(3,Passengers_No);
		  preparedStatement2.setString(4, Plane_Type);
		  preparedStatement2.setTime(5, TIME_FROM);
		  preparedStatement2.setTime(6, TIME_TO);
		  
		  preparedStatement3.setString(1, Destination_City);
		  preparedStatement3.setInt(2,FLIGHT_ID);
		  
		  preparedStatement2.executeUpdate();
		  preparedStatement3.executeUpdate();
	      JOptionPane.showMessageDialog( null, "Flight Added to database succesfully", "Confirmation", JOptionPane.PLAIN_MESSAGE );
		  }

	
	public static void AddIntFlight( Connection connection, Integer FLIGHT_ID, Integer Airport_Code, Integer Passengers_No, String Plane_Type, Time TIME_FROM, Time TIME_TO,String Destination_Country, Boolean Passengers_Vaccinated ) throws SQLException{
		PreparedStatement preparedStatement2=connection.prepareStatement("insert into flights values(?,?,?,?,?,?)");
		PreparedStatement preparedStatement3=connection.prepareStatement("insert into international_flight values(?,?,?)");
		  //Setting values for Each Parameter
		  preparedStatement2.setInt(1,FLIGHT_ID);
		  preparedStatement2.setInt(2,Airport_Code);
		  preparedStatement2.setInt(3,Passengers_No);
		  preparedStatement2.setString(4, Plane_Type);
		  preparedStatement2.setTime(5, TIME_FROM);
		  preparedStatement2.setTime(6, TIME_TO);
		  
		  preparedStatement3.setString(1, Destination_Country);
		  preparedStatement3.setBoolean(2, Passengers_Vaccinated);
		  preparedStatement3.setInt(3,FLIGHT_ID);
		  
		  preparedStatement2.executeUpdate(); 
		  preparedStatement3.executeUpdate();
	      JOptionPane.showMessageDialog( null, "Flight Added to database succesfully", "Confirmation", JOptionPane.PLAIN_MESSAGE );
		  }
	
	
	////
	public static void Cancelflight( Connection connection, Integer FLIGHT_ID) throws SQLException{
	    PreparedStatement preparedStatement1=connection.prepareStatement("delete from Flights where FLIGHT_ID=?");
	    preparedStatement1.setInt(1,FLIGHT_ID);
	    preparedStatement1.executeUpdate();
	    JOptionPane.showMessageDialog( null, "Flight deleted from database Successfully", "Confirmation", JOptionPane.PLAIN_MESSAGE );}
	
                                                                                                                                  
	
  
}
