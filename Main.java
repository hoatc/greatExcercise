package greatExercise;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;


public class Main {
	public Main(){
		
	
	}


	public static void main(String[] args) {
		Main box= new Main();
		
		Class x = testMain.class;
		Name(x);
		ClassModifier(x);
		Constructor(x);
		System.out.println("");
		ListOfMethods(x);
		System.out.println("");
		InstanceVariables(x);
		
	}
	/**
	 * return name of package and name of class.
	 * @param reflectClass
	 */
	static void Name(Class example) {
		String name= example.getName();
		System.out.println("Name of package:"+name.substring(0,name.indexOf(".")));
		System.out.println("Name of class:"+ name.substring(name.indexOf(".")+1));
	}
	/**
	 * return modifier of class: public or package or protected or private.
	 * @param reflectClass
	 */
	
	static void ClassModifier(Class example) {
		int mod = example.getModifiers();
		
		if(Modifier.isPrivate(mod)) {
			System.out.println("Class Modifier: Private");
		}
		if(Modifier.isProtected(mod)) {
			System.out.println("Class Modifier: Protected");
		}
		if(Modifier.isPublic(mod)) {
			System.out.println("Class Modifier: Public");
		}
		else System.out.println("Class Modifier: Package(Default");
				
	}
	/**
	 * Information of constructors: number, param.
	 * @param reflectClass
	 */
	static void Constructor(Class example) {
		Constructor[] con = example.getConstructors();
		
		if(con.length==1) {
			System.out.println("\nHave one constructor in this class");
		} else {
			int a= con.length;
			System.out.println("\nHave "+a+" constructors in class");
		}
		
		int i=1;
		for(Constructor v: con) {
			System.out.println("Constructor "+i+" infomation:");
			Class[] param = v.getParameterTypes();
			System.out.println("Number of parameter:"+param.length);
			System.out.print("Type of parameter:");
			for(Class u: param) {
				System.out.print(" "+u.getName().substring(u.getName().lastIndexOf(".")+1));
			}
			System.out.println("");
			i++;
		}
		
	}
	/**
	 * List of method: name, type, returntype.
	 * @param reflectClass
	 */
	static void ListOfMethods(Class example) {
		Method[] med = example.getMethods();
		System.out.println("List of method:");
		
		for(Method m: med) {
			System.out.print("Name of method: "+ m.getName());
			if(m.getName().startsWith("set")) {
				System.out.print("-Setter Method");
			}
			else if(m.getName().startsWith("get")) {
				System.out.print("-Getter Method");
			} else {
				System.out.print("-Normal Method");
			}
			
			if(m.getReturnType().toString().equals("class java.lang.String")) {
				System.out.println("-Return type of method : String");
			}else if(m.getReturnType().toString().equals("class java.lang.Class")) {
				System.out.println("-Return type of method : CLass");
			} else {
				System.out.println("-Return type of method : "+m.getReturnType());
			}
			System.out.println("");
		}
	}
	/**
	 * Information of variable
	 * @param reflectClass
	 */
	
	static void InstanceVariables(Class example) {
		Field[] fi= example.getDeclaredFields();
		
		if(fi.length == 1) {
			System.out.println("Have one variable");
		} else {
			System.out.println("Have "+fi.length+" variables");
		}
		
		int i=0;
		
		for(Field fil: fi) {
			i++;
			System.out.print("Variable "+i+", name of variable: "+fil.getName()+", type of data: ");
			
			if(fil.getType().toString().equals("class java.lang.String")) {
				System.out.print("String");
			} else System.out.print(fil.getType());
			
			int inMo = fil.getModifiers();
			if(Modifier.isPublic(inMo)) {
				System.out.print(", Modifier of variable: Public");
			}
			else if(Modifier.isProtected(inMo)) {
				System.out.print(", Modifier of variable: Public");
			}
			else if(Modifier.isPrivate(inMo)) {
				System.out.print(", Modifier of variable: Public");
			}
			else {
				System.out.print(", Modifier of variable: Package(Default)");
			}
			System.out.println("");
		}
	}
	
}
	

