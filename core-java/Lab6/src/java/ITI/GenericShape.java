package ITI;
import java.util.ArrayList;

abstract class Shape{
	abstract public void draw();
}

class Rectangle extends Shape{
	@Override
	public void draw(){
		System.out.println("Drawing Rectangle");
	}
}

class Circle extends Shape{
		@Override
		public void draw(){
			System.out.println("Drawing Circle"); 
		}
}

public class GenericShape{
		public void drawShape(ArrayList<? extends Shape> shapeList){
			for(Shape s : shapeList ) s.draw();
		}
		public static void main(String []args){
			ArrayList<Rectangle> rectangleList = new ArrayList<>();
			rectangleList.add(new Rectangle());
			rectangleList.add(new Rectangle());

			ArrayList<Shape> shapeList = new ArrayList<>();
			shapeList.add(new Rectangle());
			shapeList.add(new Circle());
			
			GenericShape test = new GenericShape();
			test.drawShape(rectangleList);
			System.out.println();
			test.drawShape(shapeList);
		}
}