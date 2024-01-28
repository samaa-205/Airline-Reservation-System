package airlinepackage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class CustomerView extends project{
	
	public static void AddEnquiry( Connection connection, Integer En_ID,Date En_Date, String En_Description, String En_Title, String En_Type,Integer Passport_No) throws SQLException{
		  PreparedStatement preparedStatement1=connection.prepareStatement("insert into airline_enquiry values(?,?,?,?,?)");
		  PreparedStatement preparedStatement2=connection.prepareStatement("update passengers set En_ID=? where Passport_No=?");
		  
		  //Setting values for Each Parameter
		  preparedStatement1.setInt(1,En_ID);
		  preparedStatement1.setDate(2,En_Date);
		  preparedStatement1.setString(3, En_Description);
		  preparedStatement1.setString(4, En_Title);
		  preparedStatement1.setString(5, En_Type);
		  
		  preparedStatement2.setInt(1,En_ID);
		  preparedStatement2.setInt(2, Passport_No);
		  
		  preparedStatement1.executeUpdate();
		  preparedStatement2.executeUpdate();
	   JOptionPane.showMessageDialog( null, "Inquiry Submitted to database succesfully", "Confirmation", JOptionPane.PLAIN_MESSAGE );
		  }
	 
	
	public static void new_passenger_acc( Connection connection, Integer Passport_No,Integer Boarding_ID,String First_Name, String Last_Name,Boolean Vaccinated) throws SQLException{
		  PreparedStatement preparedStatement2=connection.prepareStatement("insert into passengers values(?,?,NULL,NULL,NULL,?,?,?)");
		  //Setting values for Each Parameter
		  preparedStatement2.setInt(1,Passport_No);
		  preparedStatement2.setInt(2, Boarding_ID);
		  preparedStatement2.setString(3,First_Name);
		  preparedStatement2.setString(4, Last_Name);
		  preparedStatement2.setBoolean(5,Vaccinated);
		  preparedStatement2.executeUpdate();
	   JOptionPane.showMessageDialog( null, "Customer Added to database succesfully", "Confirmation", JOptionPane.PLAIN_MESSAGE );
		  }
	 
	
	
	
	public static void CancelReservation( Connection connection,  Integer Passport_No) throws SQLException{
		   PreparedStatement preparedStatement3=connection.prepareStatement("update passengers set FLIGHT_ID=NULL where Passport_No=?");
		   preparedStatement3.setInt(1 ,Passport_No);
		   preparedStatement3.executeUpdate();
	       JOptionPane.showMessageDialog( null, "Reservation canceled successfully", "Confirmation", JOptionPane.PLAIN_MESSAGE );
}
	
	
	public static void AddReservation( Connection connection,  Integer Passportnumber,Integer FLIGHT_ID ,String destination) throws SQLException{
   PreparedStatement preparedStatement3=connection.prepareStatement("update passengers set FLIGHT_ID=? where Passport_No=?");
   PreparedStatement preparedStatement4=connection.prepareStatement("update flights set Passengers_No=Passengers_No+1 where FLIGHT_ID=?");
   PreparedStatement preparedStatement5=connection.prepareStatement("insert into tickets values(NULL,?,?,?)");
   LocalDate Date1=  java.time.LocalDate.now();
   Date date = java.sql.Date.valueOf(Date1);
   preparedStatement3.setInt(1 ,FLIGHT_ID);
   preparedStatement3.setInt(2,Passportnumber);
   
   preparedStatement4.setInt(1,FLIGHT_ID);
   
   preparedStatement5.setInt(1 ,FLIGHT_ID);
   preparedStatement5.setDate(2,date);
   preparedStatement5.setString(3,destination);
   
   preparedStatement5.executeUpdate();
   preparedStatement4.executeUpdate();
   preparedStatement3.executeUpdate();
   JOptionPane.showMessageDialog( null, "Reservation successful", "Confirmation", JOptionPane.PLAIN_MESSAGE );

}
	
	public static void DisplayLocalFlightTimes( Connection connection,  String DESTINATION_TO ) throws SQLException{
		
	         PreparedStatement preparedStatement=connection.prepareStatement("select *  from flights natural join local_flight where local_flight.Destination_City='"+ DESTINATION_TO  +"'");
	         //Creating Java ResultSet object
	         ResultSet resultSet=preparedStatement.executeQuery();
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
		         JOptionPane.showMessageDialog( null, x, "Available Local Flights", JOptionPane.PLAIN_MESSAGE );}	     
	

	public static void DisplayIntFlightTimes( Connection connection,  String DESTINATION_TO ) throws SQLException{
		
	         PreparedStatement preparedStatement=connection.prepareStatement("select *  from flights natural join international_flight where international_flight.Destination_Country='"+ DESTINATION_TO  +"'");
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
	              JOptionPane.showMessageDialog( null, x, "Availble international Flights", JOptionPane.PLAIN_MESSAGE );}
	
}
