package airlinepackage;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class project {
	
	public static void Admin(Connection connection) throws SQLException, ParseException{
		//input message
		 String choice1 = JOptionPane.showInputDialog(null,"Enter: "+"\n"+"1 if you want to View All Flights "+"\n"+" 2 if you want to View all Customers"
	     +"\n"+" 3 if you want to view all Enquiries"+"\n"+" 4 if you want to add a flight"+"\n"+" 5 if you want to cancel a flight"+"\n"+"What's your Choice?" );
         //chosen function
		 Integer choice = Integer.parseInt( choice1 );
	     switch (choice)  {
	      
	      case 1 :  //views all flights
	    	  
						  String chosenarea = JOptionPane.showInputDialog(null, "Kindly Enter \n 1 if you want to view local flights \n  2 if you want to view international flights");
						  Integer chosenarea1 = Integer.parseInt( chosenarea );
					      switch (chosenarea1)  {
							      
							      case 1:
							    	  
							    	  AdminView.DisplaylocTable(connection);
							    	     break;
							      case 2:
							    	  AdminView.DisplayintTable(connection);
							    	  
							    	     break;
							      default : 
								         System.out.println("Invalid input");
								      }	     
		    	      
	  	         break;
	  	         
	      case 2 : //Displays All Customers
	    	  
	    	  AdminView.Display_passengers(connection);
	    	  
	           	break;
	           	
	      case 3: //Displays All Enquiry
	    	  
	    	  AdminView.Display_Enquiry(connection);

	    	  
	      case 4 : //Adds a new flight
				    	  String chosentable = JOptionPane.showInputDialog(null, "Kindly Enter \n 1 if you want to add a local flight \n  2 if you want to add an international flight");
						  Integer chosentable1 = Integer.parseInt( chosentable );
					      switch (chosentable1)  {
					      case 1:
					    	  JTextField d1 = new JTextField();//int
					    	  JTextField d2 = new JTextField();//int
					    	  JTextField d3 = new JTextField();//int
					    	  JTextField d4 = new JTextField();//str
					    	  JTextField d5 = new JTextField();//time
					    	  JTextField d6 = new JTextField();//time
					    	  JTextField d7 = new JTextField();//str
					    	  	           Object [] ADDF = {
					    	  		               "Enter your flight ID:", d1,"Enter your Airport Code:", d2,
					    	  		               "Enter your Passengers number:", d3,"Enter your plane type:", d4,
					    	  		               "Enter your time from:", d5,"Enter your time to:",d6,
					    	  		               	"Enter your destination city:", d7};
					    	  	           JOptionPane.showConfirmDialog(null,ADDF," Add Local Flights",JOptionPane.OK_CANCEL_OPTION);
					    	  	           
					    	  	           Integer da1 =Integer.parseInt(d1.getText());//int
					    	  	           Integer da2 =Integer.parseInt(d2.getText());//int
					    	  	           Integer da3 =Integer.parseInt(d3.getText());//int
					    	  	           String da4=d4.getText().toString();//str
					    	  	           String da5=d5.getText().toString();//time
					    	  	           String da6=d6.getText().toString();//time
					    	  	           String da7=d7.getText().toString();//str
					    	  	           

					    	  	           SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
					    	  	           long ms = sdf.parse(da5).getTime();
					    	  	           Time daa5 = new Time(ms);
					    	  	           
					    	  	           long ms1 = sdf.parse(da6).getTime();
					    	  	           Time daa6= new Time(ms1);

					 
					    	  	           String daa4=da4.toUpperCase();
					    	  		       String daa7=da7.toUpperCase();
					    	  		       
					           AdminView.AddlocFlight( connection, da1,da2,da3,daa4,daa5,daa6,daa7);
			
					    	     break;
					      case 2:
					    	  			    		   
					    		  JTextField d11 = new JTextField();//int
					    	 	  JTextField d22 = new JTextField();//int
					    	 	  JTextField d33 = new JTextField();//int
					    	 	  JTextField d44 = new JTextField();//str
					    	 	  JTextField d55 = new JTextField();//time
					    	 	  JTextField d66 = new JTextField();//time
					    	 	  JTextField d77 = new JTextField();//str
					    	   	  JTextField d88 = new JTextField();//bool

					    	 	  
					    	 	  	           Object [] ADDDF = {
					    	 	  		               "Enter your flight ID:", d11,"Enter your Airport Code:", d22,
					    	 	  		               "Enter your Passengers number:", d33,"Enter your plane type:", d44,
					    	 	  		               "Enter your time from:", d55,"Enter your time to:",d66,
					    	 	  		               	"Enter your destination_Country:", d77,"Passengers_Vaccinated:",d88};
					    	 	  	           JOptionPane.showConfirmDialog(null,ADDDF," Add International Flights",JOptionPane.OK_CANCEL_OPTION);
					    	 	  	           
					    	 	  	           Integer da11 =Integer.parseInt(d11.getText());//int
					    	 	  	           Integer da22 =Integer.parseInt(d22.getText());//int
					    	 	  	           Integer da33 =Integer.parseInt(d33.getText());//int
					    	 	  	           String da44=d44.getText().toString();//str
					    	 	  	           String da55=d55.getText().toString();//time
					    	 	  	           String da66=d66.getText().toString();//time
					    	 	  	           String da77=d77.getText().toString();//str
					    	 	  	           String da88=d88.getText().toString();//bool
					    	 	  	           
					    	 	  	           
						    	  	           SimpleDateFormat sdf1 = new SimpleDateFormat("hh:mm:ss");
						    	  	           long ms11 = sdf1.parse(da55).getTime();
						    	  	           Time daa55 = new Time(ms11);
						    	  	           
						    	  	           long ms12 = sdf1.parse(da66).getTime();
						    	  	           Time daa66= new Time(ms12);
					    	 	               

					    	 	  	           String daa44=da44.toUpperCase();
					    	 	  		       String daa77=da77.toUpperCase();
					    	 	  		       boolean bool = Boolean.parseBoolean(da88);
					    	 	  		       
					           AdminView.AddIntFlight( connection,  da11, da22,  da33, daa44, daa55, daa66,daa77,bool);
			
					    	     break;
					      default : 
						         System.out.println("Invalid input");
					      }	     
				    	      
			         break;
	         
	      case 5 : //Cancels a flight 
		    	  String flight_id = JOptionPane.showInputDialog(null, "Kindly Enter the id of the flight you want to delete");
				  Integer Flight_id = Integer.parseInt( flight_id );

			         AdminView.Cancelflight(connection,Flight_id);

	         break;

	      default : 
		         System.out.println("Invalid input");
		      }
		
	}
	
	
	public static void Customer(Connection connection) throws SQLException{
		 String choice1 = JOptionPane.showInputDialog(null, "Enter 1 if you want to book a flight "+"\n"+"2 if you want to submit a complain enquiry"+
	      "\n"+"3 if you want to cancel a reservation"+"\n"+"4 if you are a new customer"+"\n"+"What's your Choice?");
         Integer choice = Integer.parseInt( choice1 );
	      switch (choice)  {
	      
	      case 1 : 
			    	  
					  String chosenarea = JOptionPane.showInputDialog(null, "Kindly Enter \n 1 if you want to book local flights \n  2 if you want to book international flights");
					  Integer chosenarea1 = Integer.parseInt( chosenarea );
				      switch (chosenarea1)  {
						      
						      case 1:
						    	   JTextField f1 = new JTextField();
						           Object [] fields = {
							               "Enter your destination city:", f1  };
						           
						           JOptionPane.showConfirmDialog(null,fields,"Local Flights",JOptionPane.OK_CANCEL_OPTION);
						           
						           String df1=f1.getText().toString();
						           df1=df1.toUpperCase();
							       
						    	   CustomerView.DisplayLocalFlightTimes( connection, df1 );
			   ///////!!!!!!!!!
						    	   JTextField i1 = new JTextField();
						           JTextField i2 = new JTextField();
						           Object [] ids = {
							               "Enter your passport number:", i1,
							               "Enter your flight id", i2};
						           
						           JOptionPane.showConfirmDialog(null,ids,"Booking",JOptionPane.OK_CANCEL_OPTION);
						           
						           int passportno1 = Integer.parseInt(i1.getText());
						           int flightid2 = Integer.parseInt(i2.getText());
						           
						           CustomerView.AddReservation(connection,passportno1,flightid2,df1);
						           
						           JOptionPane.showMessageDialog( null, "Reservation successful", "Confirmation", JOptionPane.PLAIN_MESSAGE );
		
		
						    	     break;
						      case 2:
						    	   JTextField f3 = new JTextField();
						           
						           Object [] fields2 = {
							               "Enter your destination country:", f3};
						           
						           JOptionPane.showConfirmDialog(null,fields2,"International Flights",JOptionPane.OK_CANCEL_OPTION);
						           
						           String df3=f3.getText().toString();
						           
						           df3=df3.toUpperCase();
							       
							       CustomerView.DisplayIntFlightTimes(  connection, df3 );
						     ////	!!!!!!!!!!
						    	   JTextField i3 = new JTextField();
						           JTextField i4 = new JTextField();
						           Object [] ids2 = {
							               "Enter your passport number:", i3,
							               "Enter your flight id", i4};
						           
						           JOptionPane.showConfirmDialog(null,ids2,"Booking",JOptionPane.OK_CANCEL_OPTION);
						           
						           int passportno3 = Integer.parseInt(i3.getText());
						           int flightid4 = Integer.parseInt(i4.getText());
						           
						           CustomerView.AddReservation(connection,passportno3,flightid4,df3);
		
						    	  
						    	     break;
						      default : 
							         System.out.println("Invalid input");
							      }	   
			  	         break;
	  	         
	      case 2 :
	    	  //submit enquiry
	    	     String pass_no = JOptionPane.showInputDialog(null, "Kindly enter your passport id:");
	    	     Integer passport_no = Integer.parseInt( pass_no );
	    	     
	    	     
					JTextField e1 = new JTextField();
					JTextField e2 = new JTextField();
					JTextField e3 = new JTextField();
					JTextField e4 = new JTextField();
					JTextField e5 = new JTextField();
					
					Object [] enquiry = {
					        "Enter your Enquiry Id:", e1,
					        "Enter your Enquiry Date DD-MM-YYYY", e2,
					        "Enter your Enquiry Description",e3,
					        "Enter your Enquiry Title",e4,
					        "Enter your Enquiry Type",e5};
					
					
					JOptionPane.showConfirmDialog(null,enquiry,"Enquiry",JOptionPane.OK_CANCEL_OPTION);
	    	     
					int e11 = Integer.parseInt(e1.getText());
					String e22=e2.getText().toString();
					String e33=e3.getText().toString();
					String e44=e4.getText().toString();
					String e55=e5.getText().toString();
					
					
					SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date date;
			try {
				date = sdf1.parse(e22);
				java.sql.Date e222 = new java.sql.Date(date.getTime());  

				
				CustomerView.AddEnquiry(  connection,  e11, e222,  e33,  e44,  e55, passport_no); 
            
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	           
	           	break;
	      case 3 :
	    	  //cancel reservation   
	    	     String Passport_No = JOptionPane.showInputDialog(null, "Kindly enter your passport id:");
	             Integer Passport_No1 = Integer.parseInt( Passport_No );
	             CustomerView.CancelReservation(connection,Passport_No1);  	
	           
	           	break;
	      case 4 :
	    	//add new passenger data

				JTextField g1 = new JTextField();
				JTextField g2 = new JTextField();
				JTextField g3 = new JTextField();
				JTextField g4 = new JTextField();
				JTextField g5 = new JTextField();
				
				Object [] fields2 = {
				        "Enter your Passport Number:", g1,
				        "Enter your Boarding ID",g2,
				        "Enter your First Name", g3,
				        "Enter your Last Name",g4,
				        "Enter 1 if vaccinated 0 if not",g5};
				
				JOptionPane.showConfirmDialog(null,fields2,"New Passenger Details",JOptionPane.OK_CANCEL_OPTION);
				

				int g11 = Integer.parseInt(g1.getText());
				int g22 = Integer.parseInt(g2.getText());
				String g33=g3.getText().toString();
				String g44=g4.getText().toString();
				int g55 = Integer.parseInt(g5.getText());
				
//				g33=g33.toUpperCase();
//				g44=g44.toUpperCase();
				
				boolean bool = (g55 != 0);
		    	  
				CustomerView.new_passenger_acc(  connection, g11,g22, g33, g44, bool );

	           	break;
	           	

	         
	      default : 
		         System.out.println("Invalid input");
		      }
	}
	
	
   static String x;

		public static void main(String[] args) throws ParseException {
			
		  try {
			  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinesystem", "root", "P@ss00597P@ss00597");//Establishing connection
			  
			  // prompt the user to enter his choice
	
			  String[] optionsToChoose = {"Customer ", "Admin"};
			           JFrame jFrame = new JFrame();

			           JComboBox<String> jComboBox = new JComboBox<>(optionsToChoose);
			           jComboBox.setBounds(80, 50, 140, 20);

			           JButton jButton = new JButton("Done");
			           jButton.setBounds(100, 100, 90, 20);

			           JLabel jLabel = new JLabel();
			           jLabel.setBounds(90, 100, 400, 100);
			           jFrame.add(jButton);
			           jFrame.add(jComboBox);
			           jFrame.add(jLabel);
			           
			           jFrame.setLayout(null);
			           jFrame.setSize(350, 250);
			           jFrame.setVisible(true);
	
			           jButton.addActionListener(new ActionListener() {
			               @Override
			               public void actionPerformed(ActionEvent e) {
			                   String selectedFruit = "You selected " + jComboBox.getItemAt(jComboBox.getSelectedIndex());
			                   jLabel.setText(selectedFruit);
			                final  String  x= jComboBox.getItemAt(jComboBox.getSelectedIndex());
			                
			               
			            	if(x==optionsToChoose[0])
			               	{
			               	
									try {
										Customer(connection);
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
					
			               	}
			               	else if (x==optionsToChoose[1])
			               	{
									try {
										Admin(connection);
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (ParseException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}}
			           });
			           }
			 catch (SQLException e) {
			System.out.println("Error while connecting to the database");}}}