class Railway{
	
	static int totalSeats = 110;
	String stationName;

	Railway(String stationName){
		this.stationName = stationName;
	}
	synchronized static void bookSeats(String name, String stationName, int seats) {
		
		if (totalSeats >= seats) {
			
			System.out.println(name +" your "+ seats + " seats sucessfully booked at " +stationName);
			totalSeats -= seats;
			System.out.println("Rmaining seats is: " + totalSeats);
			
		}
		else {
			System.out.println(name +" you can't book " + seats+ " seats at " + stationName + ". Because remaining seates is: "+ totalSeats);
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
		railway.bookSeats(name, railway.stationName, seats);
	}
	
}

public class RailwayTicketBooking {

	
	public static void main(String[] args) {
		
		Railway delhiStation = new Railway("Delhi Junction");
		Railway ujjainStation = new Railway("Ujjain Junction");
		Railway indoreStation = new Railway("Indore Junction");
		
		BookTicket p1 = new BookTicket(delhiStation, "kashilal", 25);
		BookTicket p2 = new BookTicket(ujjainStation, "kaalnath", 20);
		BookTicket p3 = new BookTicket(indoreStation, "haru",15);
		BookTicket p4 = new BookTicket(indoreStation, "hari", 25);
		BookTicket p5 = new BookTicket(ujjainStation, "har", 30);
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
	}
}
