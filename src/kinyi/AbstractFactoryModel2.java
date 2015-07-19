package kinyi;

public class AbstractFactoryModel2 {
	
	public interface Plant{
		void dosomething();
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
	
	public class Factory{

		public Plant createPlant(String type) {
			if ("A".equals(type)) {
				return new PlantA();
			}else if ("B".equals(type)) {
				return new PlantB();
			}else {
				return null;
			}
		}

		public Fruit createFruit(String type) {
			if ("A".equals(type)) {
				return new FruitA();
			}else if ("B".equals(type)) {
				return new FruitB();
			}else {
				return null;
			}
		}
	}
	
	public static void main(String[] args) {
		Plant plant = new AbstractFactoryModel2().new Factory().createPlant("A");
		plant.dosomething();
	}
}
