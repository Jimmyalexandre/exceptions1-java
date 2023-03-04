package application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		//Solução ruim - tratamento de erros no main
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Room number: ");
		int number = sc.nextInt();
		System.out.println("Check-in date (dd/mm/yyyy)");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check-Out date (dd/mm/yyyy)");
		Date checkOut = sdf.parse(sc.next());
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date.");
		}else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: "+ reservation);
			String error = " ";
			while(error != null) {
				System.out.println();
				System.out.println("Enter data to update the reservation: ");
				System.out.println("Check-in date (dd/mm/yyyy)");
				checkIn = sdf.parse(sc.next());
				System.out.println("Check-Out date (dd/mm/yyyy)");
				checkOut = sdf.parse(sc.next());

				error = reservation.updateDates(checkIn, checkOut);
				if(error != null) {
					System.out.println("Error in reservation: "+ error);
				}else {
					System.out.println("Reservation: "+ reservation);
				}
				sc.nextLine();
			}
			

		}

		sc.close();
	}

}
