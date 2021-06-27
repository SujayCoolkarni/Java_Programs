package packageP1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamEx {

	static volatile int k=1;
	static transient int j=12; 
	public static void main(String[] args) {

		int i;
		FileInputStreamEx ob =new FileInputStreamEx();
		System.out.println(ob instanceof Object);
		FileInputStream fin=null;
		FileOutputStream fout=null;

		if(args.length!=2) {
			System.out.println("Enter filename in arguments");

		}

		try {
			fin=new FileInputStream(args[0]);
			fout=new FileOutputStream(args[1]);
		}catch(FileNotFoundException e) {
			System.out.println("Can't Open File");
			return;
		}
		/*
		 * 		try(FileInputStream finp=new FileInputStream(args[0]);
		 * 		FileOutputStream foutp=new FileOutputStream(args[1])){
		 * 		do {
					i=finp.read();
					if(i!=1)
					foutp.write(i);
				}while(i!=-1);
			}catch(IOException e) {
				System.out.println("Error closing file!");
		}
		 */


		try {
			do {
				i=fin.read();
				if(i!=1)
					fout.write(i);
			}while(i!=-1);
		}catch(IOException e) {
			System.out.println("Error closing file!");
		}

		try {
			if(fin!=null)
				fin.close();
			if(fout!=null)
				fout.close();
		}catch(IOException e) {
			System.out.println("Can't close file!");
		}


	}

}