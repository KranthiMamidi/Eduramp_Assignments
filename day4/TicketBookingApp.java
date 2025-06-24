package com.day4;

class BookMyShow {
	int totalSeats = 10;

	synchronized void bookSeats(String user, int seatsToBook) {
		System.out.println(user + " is trying to book " + seatsToBook + " seat(s).");

		if (seatsToBook <= totalSeats) {
			System.out.println("Seats available. Booking in progress for " + user + "...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			totalSeats -= seatsToBook;
			System.out.println(user + " successfully booked " + seatsToBook + " seat(s).");
			System.out.println("Remaining seats: " + totalSeats);
		} else {
			System.out.println("Sorry " + user + ", not enough seats available. Available seats: " + totalSeats);
		}

		System.out.println("-------------------------------------------------");
	}
}

class BookingThread extends Thread {
	BookMyShow bookMyShow;
	int seatsToBook;
	String user;

	BookingThread(BookMyShow bookMyShow, int seatsToBook, String user) {
		this.bookMyShow = bookMyShow;
		this.seatsToBook = seatsToBook;
		this.user = user;
	}

	public void run() {
		bookMyShow.bookSeats(user, seatsToBook);
	}
}

//Main class
public class TicketBookingApp {
	public static void main(String[] args) {
		BookMyShow theater = new BookMyShow();

		// Two users trying to book tickets simultaneously
		BookingThread user1 = new BookingThread(theater, 7, "User1");
		BookingThread user2 = new BookingThread(theater, 6, "User2");

		user1.start();
		user2.start();
	}
}
