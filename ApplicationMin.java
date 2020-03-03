package volodymyr;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ApplicationMin {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		
		Class test = TestClass.class;
		
		System.out.println("Package - "+ test.getPackage());
		System.out.println("SuperClass - "+ test.getSuperclass());
		System.out.println("Name - "+ test.getName());
		System.out.println("SimpleName - "+ test.getSimpleName());
		
		int modifi = test.getModifiers();
		String modifierText = Modifier.toString(modifi);
		System.out.println("Modifier " + modifierText + " int = " + modifi);
		System.out.println("Modifier - "+ Modifier.toString(test.getModifiers()));
		
		Class[] interfaces = test.getInterfaces();
		System.out.println("Interfaces " + Arrays.toString(interfaces));
		System.out.println("Interfaces - "+ Arrays.toString(test.getInterfaces()));
		
		Constructor<TestClass>[] testConstructor = test.getConstructors();
		for (Constructor<TestClass> constructor : testConstructor) {
			System.out.println("Constructors " + constructor);
		}
		System.out.println("Constructor - "+ Arrays.toString(test.getConstructors()));
		
		System.out.println("Fields - "+ Arrays.toString(test.getFields()));
		System.out.println("Declarated fields - "+ Arrays.toString(test.getDeclaredFields()));
		System.out.println("Methods - "+ Arrays.toString(test.getMethods()));
			
		//max
						
		Constructor<TestClass> constructor = test.getConstructor(String.class, int.class, String.class, double.class);
		TestClass newIstanceTest = constructor.newInstance("FirstTest", 40, "LastPosition", 2.0);
		System.out.println("Create newInstance - " + newIstanceTest);
		
		Field field = test.getField("lastName");
		field.set(newIstanceTest, "NewText");
		System.out.println("New test Name - "+ newIstanceTest);
	
		Constructor<TestClass> constructor2 = test.getConstructor(String.class, int.class, String.class, double.class);
		TestClass newInstanceTest2 = constructor2.newInstance("OtherTest", 50, "SecondPosition", 1.5);
		System.out.println("Declared Methods - "+ Arrays.toString(test.getDeclaredMethods()));
		
		Method declaredMethod1 = newInstanceTest2.getClass().getDeclaredMethod("myMethod", String.class, int.class);
		Method declaredMethod2 = newInstanceTest2.getClass().getDeclaredMethod("myMethod", String.class);
		System.out.println("Declared myMethod - " +declaredMethod1 + " declared myMethod - " +declaredMethod2);
		
		declaredMethod1.setAccessible(true);
		declaredMethod1.invoke(newIstanceTest, "new", 1);
		
		declaredMethod2.setAccessible(true);
		declaredMethod2.invoke(newInstanceTest2, "old");
	}
}
