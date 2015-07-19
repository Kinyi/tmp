package kinyi;

public class AbstractFactoryModel {
	
	public interface Plant{
		
	}
	
	public class PlantA implements Plant{
		
		public PlantA(){
			System.out.println("create plantA");
		}
		
		public void dosomething(){
			System.out.println("plantA do something");
		}
	}
	
	public class PlantB implements Plant{

		public PlantB(){
			System.out.println("create plantB");
		}
		
		public void dosomething(){
			System.out.println("plantB do something");
		}
	}
	
	public interface Fruit{
		
	}
	
	public class FruitA implements Fruit{
		
		public FruitA(){
			System.out.println("create fruitA");
		}
		
		public void dosomething(){
			System.out.println("fruitA do something");
		}
	}
	
	public class FruitB implements Fruit{
		
		public FruitB(){
			System.out.println("create fruitB");
		}
		
		public void dosomething(){
			System.out.println("fruitB do something");
		}
	}
	
	public interface AbstractFactory{
		public Plant createPlant();
		public Fruit createFruit();
	}
	
	public class FactoryA implements AbstractFactory{

		@Override
		public Plant createPlant() {
			return new PlantA();
		}

		@Override
		public Fruit createFruit() {
			return new FruitA();
		}
	}
	
	public class FactoryB implements AbstractFactory{

		@Override
		public Plant createPlant() {
			return new PlantB();
		}

		@Override
		public Fruit createFruit() {
			return new FruitB();
		}
	}
	
	public static void main(String[] args) {
		Plant plant = new AbstractFactoryModel().new FactoryA().createPlant();
		((PlantA)plant).dosomething();
	}
}
