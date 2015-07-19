package yuting;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class HouseMovingCompany implements Runnable {
	List<Employee> eps;
	List<Contract> cts;
	private Semaphore semaphore;

	public HouseMovingCompany(List<Employee> eps, List<Contract> cts) {
		super();
		this.eps = eps;
		this.cts = cts;
	}

	public HouseMovingCompany() {
	}

	public List<Employee> getEps() {
		return eps;
	}

	public void setEps(List<Employee> eps) {
		this.eps = eps;
	}

	public List<Contract> getCts() {
		return cts;
	}

	public void setCts(List<Contract> cts) {
		this.cts = cts;
	}

	public static void main(String[] args) {
		Employee e1 = new Employee("sb01", "张三");
		Employee e2 = new Employee("sb02", "李四");
		Employee e3 = new Employee("sb03", "王五");

		List<Employee> eps = new ArrayList<HouseMovingCompany.Employee>();
		eps.add(e1);
		eps.add(e2);
		eps.add(e3);

		Contract c1 = new Contract("from1", "to1", 500d);
		Contract c2 = new Contract("from2", "to2", 700d);
		Contract c3 = new Contract("from3", "to3", 900d);
		List<Contract> cts = new ArrayList<HouseMovingCompany.Contract>();

		cts.add(c1);
		cts.add(c2);
		cts.add(c3);
		HouseMovingCompany houseMovingCompany = new HouseMovingCompany(eps, cts);
		for (Employee employee : eps) {
			Thread t = new Thread(houseMovingCompany, employee.getName());
			t.start();
		}

	}

	@Override
	public void run() {
//		 housemove();
//		housemove2();
//		housemove21();
		 housemove3();
	}

	private void housemove() {
		while (cts.size() > 0) {
			Contract contract = cts.get(0);
			String from = contract.getFrom();
			String to = contract.getTo();
			Double fee = contract.getFee();
			try {
				Thread.sleep(3000);
				System.out.println(Thread.currentThread().getName() + " from "
						+ from + " to " + to);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("赚取" + fee + "元");
			cts.remove(0);
		}
	}

	private synchronized void housemove2() {
		while (cts.size() > 0) {
			Contract contract = cts.get(0);
			String from = contract.getFrom();
			String to = contract.getTo();
			Double fee = contract.getFee();
			try {
				Thread.sleep(3000);
				System.out.println(Thread.currentThread().getName() + " from "
						+ from + " to " + to);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("赚取" + fee + "元");
			cts.remove(0);
		}
	}

	private void housemove21() {
		while (cts.size() > 0) {
			Contract contract = null;
			synchronized (cts) {
				contract = cts.get(0);
				cts.remove(0);
			} 

			String from = contract.getFrom();
			String to = contract.getTo();
			Double fee = contract.getFee();
			try {
				Thread.sleep(3000);
				System.out.println(Thread.currentThread().getName() + " from "
						+ from + " to " + to);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"赚取" + fee + "元");

		}
	}

	private void housemove3() {
		while (cts.size() > 0) {
			semaphore = new Semaphore(1);
			try {
				semaphore.acquire();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			Contract contract = cts.get(0);
			cts.remove(0);
			semaphore.release();

			String from = contract.getFrom();
			String to = contract.getTo();
			Double fee = contract.getFee();
			try {
				Thread.sleep(3000);
				System.out.println(Thread.currentThread().getName() + " from "
						+ from + " to " + to);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "赚取" + fee + "元");

		}
	}

	static class Employee {
		private String id;
		private String name;

		public Employee() {
		}

		public Employee(String id, String name) {
			super();
			this.id = id;
			this.name = name;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	static class Contract {
		private String from;
		private String to;
		private double fee;

		public Contract(String from, String to, double fee) {
			super();
			this.from = from;
			this.to = to;
			this.fee = fee;
		}

		public Contract() {
		}

		public String getFrom() {
			return from;
		}

		public void setFrom(String from) {
			this.from = from;
		}

		public String getTo() {
			return to;
		}

		public void setTo(String to) {
			this.to = to;
		}

		public double getFee() {
			return fee;
		}

		public void setFee(double fee) {
			this.fee = fee;
		}
	}

}