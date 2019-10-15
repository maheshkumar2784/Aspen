package utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.testng.annotations.Test;

public class WriteDatatoNotepad {

	@Test
	public void writeData() throws IOException {
		FileOutputStream fileOut=new FileOutputStream("C:\\Trainings\\Arun_Gopi\\filesDemo.txt");
		fileOut.write(66);
		String str="This is files Demo";
		byte b[]=str.getBytes();
		fileOut.write(b);
		
		fileOut.close();
	}
}
