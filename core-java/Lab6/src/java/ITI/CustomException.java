package ITI;
class MyCustomException extends Exception{
	public MyCustomException(){
		super();
	}
	public MyCustomException(String message){
		super(message);
	}
}

class ThrowingClass{
	public void methodOne() throws MyCustomException {
		throw new MyCustomException("Exception from method one");
	}
	public void methodTwo() throws MyCustomException{
		throw new MyCustomException("Exception from method two");
	}
	public void methodThree() throws MyCustomException{
		throw new MyCustomException("Exception from method three");
	}

}

public class CustomException{
	public static void main(String args[]){
		ThrowingClass test = new ThrowingClass();
		try{
			test.methodOne();
			test.methodTwo();
			test.methodThree();
		}	
		catch( MyCustomException e){
			System.out.println(e.getMessage());
		}
		finally{
			System.out.println("Finally block executed");
		}
	}	

}