package yuting;

public class WageDemo {
	public static void main(String[] args) {
		CEO ceo = new CEO();
		ceo.wage(20, 20);
		DimmissionedEmployess de = new DimmissionedEmployess();
		de.wage(33, 15);
		PiecedEmployee pe = new PiecedEmployee();
		pe.wage(12, 26);
		System.out.println(ceo.wage(20, 20) + " " + de.wage(33, 15) + " "
				+ pe.wage(12, 26));
	}
}

abstract class Wage {
	private long mount;
	private long money;

	public abstract long wage(long mount, long money);
}

class CEO extends Wage {

	@Override
	public long wage(long mount, long money) {
		long wage = 0;
		wage = mount * money;
		return wage;
	}

}

class DimmissionedEmployess extends Wage {

	@Override
	public long wage(long mount, long money) {
		long wage = 0;
		wage = mount * money;
		return wage;
	}

}

class PiecedEmployee extends Wage {

	@Override
	public long wage(long mount, long money) {
		long wage = 0;
		wage = mount * money;
		return wage;
	}

}
