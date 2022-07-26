package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.ArgentinaTaxService;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Enter Rental Data");
		System.out.print("Car model: ");
		String carModel = "Civic";//sc.nextLine();
		System.out.print("Pickup (dd/MM/yyyy HH:ss): ");
		Date start = sdf.parse("25/06/2018 10:30"/*sc.nextLine()*/);
		System.out.print("Return (dd/MM/yyyy HH:ss): ");
		Date finish = sdf.parse("27/06/2018 11:40"/*sc.nextLine()*/);
		
		CarRental crBrazil = new CarRental(start, finish, new Vehicle(carModel));
		CarRental crArgentina = new CarRental(start, finish, new Vehicle(carModel));
		
		
		System.out.print("Enter price per hour: ");
		double pricePerHour = 10;//sc.nextDouble();
		System.out.print("Enter price per day: ");
		double pricePerDay = 130;//sc.nextDouble();
		
		RentalService rentalServiceBrazil = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
		RentalService rentalServiceArgentina = new RentalService(pricePerHour, pricePerDay, new ArgentinaTaxService());

		
		rentalServiceBrazil.processInvoice(crBrazil);
		rentalServiceArgentina.processInvoice(crArgentina);
		
		System.out.println("INVOICE BRAZIL");
		System.out.println("Basic payment: " + String.format("%.2f", crBrazil.getInvoice().getBasicPayment()));
		System.out.println("Tax: " + String.format("%.2f", crBrazil.getInvoice().getTax()));
		System.out.println("Total payment: " + String.format("%.2f", crBrazil.getInvoice().getTotalPayment()));
		
		System.out.println("");
		
		System.out.println("INVOICE ARGENTINA");
		System.out.println("Basic payment: " + String.format("%.2f", crArgentina.getInvoice().getBasicPayment()));
		System.out.println("Tax: " + String.format("%.2f", crArgentina.getInvoice().getTax()));
		System.out.println("Total payment: " + String.format("%.2f", crArgentina.getInvoice().getTotalPayment()));
		
		sc.close();
	}

}
