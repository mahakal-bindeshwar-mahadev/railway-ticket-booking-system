
class Railway{
	
	static int totalSeats = 50;
	
	synchronized static void bookSeats(String name, int seats) {
		
		if (totalSeats >= seats) {
			
			System.out.println(name +" your "+ seats + " seats sucessfully booked");
			totalSeats -= seats;
			System.out.println("Rmaining seats is: " + totalSeats);
			
		}
		else {
			System.out.println(name +" you can't book " + seats+ " seats. Because remaining seates is: "+ totalSeats);
		}
	}
}

class BookTicket extends Thread{
	
	Railway railway;
	int seats;
   	String name;
	public BookTicket(Railway railway , String name, int seats) {
		this.railway = railway;
		this.seats = seats;
		this.name = name;
	}
	
	public void run() {
		railway.bookSeats(name, seats);
	}
	
}

public class RailwayTicketBooking {

	
	public static void main(String[] args) {
		
		Railway delhiStation = new Railway();
		Railway ujjainStation = new Railway();
		Railway indoreStation = new Railway();
		
		BookTicket p1 = new BookTicket(delhiStation, "kashilal", 25);
		BookTicket p2 = new BookTicket(ujjainStation, "kaalnath", 20);
		BookTicket p3 = new BookTicket(indoreStation, "haru",10);
		BookTicket p4 = new BookTicket(indoreStation, "hari", 15);
		p1.start();
		p2.start();
		p3.start();
		p4.start();
	}
}
