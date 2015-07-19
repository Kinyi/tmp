package yuting;

public class InterfaceDemo {
	public static void main(String[] args) {
		Triangle t = new Triangle();
		Rectangle rt = new Rectangle();
		t.computeArea(10, 2);
		rt.computeArea(2, 3);
		System.out.println(rt.computeArea(2, 3)); 
		System.out.println(t.computeArea(10, 2));

	}
}

interface Shape { // 接口是一个特殊的抽象类
	public double computeArea(double a, double b); // 所有的方法都是抽象方法
}

class Triangle implements Shape {

	@Override
	public double computeArea(double a, double b) {
		float Area = 0;
		Area = (float) ((a * b) / 2); // 求面积
		return Area;
	}
}

class Rectangle implements Shape {

	@Override
	public double computeArea(double a, double b) {
		float Area = 0;
		Area = (float) (a * b);
		return Area;
	}

}
