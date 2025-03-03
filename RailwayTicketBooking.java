
class Railway{
	
	static int totalSeats = 50;
	
	synchronized static void bookSeats(int seats) {
		
		if (totalSeats >= seats) {
			
			System.out.println(seats + " Sucessfully booked");
			totalSeats -= seats;
			System.out.println("Rmaining seats is: " + totalSeats);
			
		}
		else {
			System.out.println("you can't book " + seats+ " seats because remaining seates is: "+ totalSeats);
		}
	}
}

class BookTicket extends Thread{
	
	Railway railway;
	int seats;
	
	public BookTicket(Railway railway , int seats) {
		this.railway = railway;
		this.seats = seats;
	}
	
	public void run() {
		railway.bookSeats(seats);
	}
	
}

public class RailwayTicketBooking {

	
	public static void main(String[] args) {
		
		Railway delhiStation = new Railway();
		Railway ujjainStation = new Railway();
		Railway indoreStation = new Railway();
		
		BookTicket kashilal = new BookTicket(delhiStation, 25);
		BookTicket kaalnath = new BookTicket(ujjainStation, 20);
		BookTicket haru = new BookTicket(indoreStation, 10);
 		
		kashilal.start();
		kaalnath.start();
		haru.start();
		
	}
}
