package greatExercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class testMain {
	int j=0;
	String u=" sdfsgdf";
	boolean tr=true;
	
	public static void main(String[] args) {
	
		File f= new File("F:\\pasword.txt");
		try {
			FileReader fr= new FileReader(f);
			BufferedReader br= new BufferedReader(fr);
			
			String line ="";
			int i=0;
			while((line=br.readLine())!= null){
				System.out.println(++i+": "+line);
			}
			br.close();
			fr.close();
			
		} catch(FileNotFoundException ex) {
				Logger.getLogger(testMain.class.getName()).log(Level.SEVERE, null, ex);
			
		} catch (IOException e) {
			
		}
	}
}
