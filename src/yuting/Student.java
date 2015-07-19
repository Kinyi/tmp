package yuting;

public class Student {
	private String name;
	private double score;
	
	public Student() {
		
	}
	
	public Student(String name, double score) {
		super();
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
	public void print(){
		System.out.println("name: "+this.name+",score: "+this.score);
//		System.out.println("name: "+this.getName()+",score: "+this.getScore());
	}

	
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setName("Alan");
		s1.setScore(90);
		s1.print();
		
		Student s2 = new Student("Tom", 100);
		s2.print();
	}

}
