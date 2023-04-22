import org.testng.annotations.Test;

public class MyClass {
	
	public static void main() {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println(methodName); // prints "main"
	}
	
	@Test
	public void callmain() {
		main();
	}
}