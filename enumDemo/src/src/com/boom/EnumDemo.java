package src.com.boom;

public class EnumDemo {

	public static void main(String[] args) {

		// This is a demo to show you how you can make use of the 'Superhero'
		// Enum

		// By default toString() method will be converting the enum variable
		// into String and displaying it, a case similar to Superman, who is not
		// interested in revealing his ID
		String selectedHero = Superhero.SUPERMAN.name();
		System.out.println("You selected - " + selectedHero);
		String realName = Superhero.SUPERMAN.toString();
		System.out.println("Real Name - " + realName + "\n");

		// While with Batman, it's not always the case, remember the Spoof "Do
		// you want to know my secret identity ??" ?, Hence a separate method
		// for such scenarios ;)
		String selectedHero2 = Superhero.BATMAN.name();
		System.out.println("You selected - " + selectedHero2);
		String realName2 = Superhero.BATMAN.toStringRevealRealName();
		System.out.println("Real Name - " + realName2);
		Superhero verify = Superhero.fromValue(realName2);
		System.out.println("ID verified, it's - " + verify.name() + "\n");

		// Now what is the advantage of using Enum? As you can see we have kind
		// of restricted the users with a given set of Superheroes, that means
		// Deadpool is not invited to the party... Check this out -
		String uninvitedGuest = "Wade Wilson";
		verify = Superhero.fromValue(uninvitedGuest);
		try {
			System.out.println("What do we get ? " + verify.name());
		} catch (Exception e) {
			System.out.println("Wade Wilson AKA Deadpool trying to sneak in...");
			System.out.println("Entry Allowed? "+ e.getMessage());
		}
	}

}

enum Superhero {
	BATMAN("Bruce Wayne"), SUPERMAN("Clark Kent"), IRONMAN("Tony Stark"), SPIDERMAN("Peter Parker");

	private String value;

	Superhero(String value) {
		this.value = value;
	}

	public static Superhero fromValue(String str) {
		for (Superhero s : Superhero.values()) {
			if (String.valueOf(s.value).equalsIgnoreCase(str)) {
				return s;
			}
		}
		return null;
	}

	public String toStringRevealRealName() {
		return value;
	}

}
