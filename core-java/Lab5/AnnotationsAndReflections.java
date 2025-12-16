import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.CONSTRUCTOR,ElementType.FIELD})
@interface Author{
	String name();
	String email();
	String description();		
}


@Author(
	name="adham",
	email="adhamkhaled312@gmail.com",
	description="This is a test class for author annotation on classes"
)
class Service{
	@Author(
		name="mohamed",
		email="mohamed@gmail.com",
		description="This is a test field for author annotation on fields"
	)
	public int x;

	@Author(
		name="ahmed",
		email="ahmed@gmail.com",
		description="This is a test constructor for author annotation on constructors"
	)
	public Service(int x) {
		this.x=x;
	}
	@Author(
		name="mostafa",
		email="mostafa@gmail.com",
		description="This is a test method for author annotation on methods"
	)
	public int getX(){
 		return this.x;
	}
}

public class AnnotationsAndReflections{
	public static void main(String args[]) throws NoSuchMethodException, NoSuchFieldException {
		Class<Service>cls=Service.class;
		if(cls.isAnnotationPresent(Author.class)){
			Author author=cls.getAnnotation(Author.class);
			System.out.println("Author annotation on class");
			System.out.println("Name: "+author.name());
			System.out.println("email :"+author.email());
			System.out.println("description :"+author.description());
		}
		System.out.println();
		Method methodGetX = cls.getMethod("getX");
		if(methodGetX.isAnnotationPresent(Author.class)){
			Author author=methodGetX.getAnnotation(Author.class);
			System.out.println("Author annotation on method");
			System.out.println("Name: "+author.name());
			System.out.println("email :"+author.email());
			System.out.println("description :"+author.description());
		}
		System.out.println();
		Field fieldX = cls.getField("x");
		if(fieldX.isAnnotationPresent(Author.class)){
			Author author=fieldX.getAnnotation(Author.class);
			System.out.println("Author annotation on field");
			System.out.println("Name: "+author.name());
			System.out.println("email :"+author.email());
			System.out.println("description :"+author.description());
		}
		System.out.println();

		Constructor<Service> constructor = cls.getDeclaredConstructor(int.class);
		if(constructor.isAnnotationPresent(Author.class)){
			Author author=constructor .getAnnotation(Author.class);
			System.out.println("Author annotation on constructor");
			System.out.println("Name: "+author.name());
			System.out.println("email :"+author.email());
			System.out.println("description :"+author.description());
		}
	}
}