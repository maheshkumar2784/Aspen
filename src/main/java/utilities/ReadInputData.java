package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

public class ReadInputData {

	@Test
	public void readInputFile() throws IOException {
		FileInputStream ipFile1=new FileInputStream("C:\\Trainings\\Arun_Gopi\\filesDemo.txt"); 
		int i=0;
		String s = "";
		while((i=ipFile1.read())!=-1) {
			 s=s+(char)i;
				}
		
		System.out.println("String: "+s);
		ipFile1.close();
	}
}
