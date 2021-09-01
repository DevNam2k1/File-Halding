package baitap.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		int a,b;
		int t , h, tich;
		float thuong;
		a=NhapSoNguyen("Nhap canh a : ");
		b=NhapSoNguyen("Nhap canh b : ");
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		File myObj = new File("D:\\bkd02k111000.txt");
		try {
			if(myObj.exists()) {			
				if(!myObj.createNewFile()) {
					throw new Exception("File đã tồn tại");
				}
				}
			
			} catch (IOException e) {
				e.printStackTrace();
			}		@SuppressWarnings("resource")
		FileWriter writerFile = new FileWriter(myObj, true);
		do {
			System.out.println("MENU");
			System.out.println("1.Tính tổng");
			System.out.println("2.Tính hiệu");
			System.out.println("3.Tính tích");
			System.out.println("4.Tính thương");
			System.out.println("5.Xem kết quả");
			System.out.println("6.Reset file kết quả");
			System.out.println("7.Thoát");
			String line = scanner.nextLine();
			
			switch(line) {
			       

			       case "1" :{
			    	   t=tong(a,b);
			    	   System.out.println("Tổng:" + t );
                       writerFile.write("Tổng :" + t + "\n");
                       writerFile.flush();
			    	   break;
			       }
			       case "2" :{
			    	   h=hieu(a,b);
			    	   System.out.println("Hiệu:" + h);
			    	   writerFile.write("Hiệu :" + h + "\n");
			    	   writerFile.flush();
			    	   break;
			       }
			       case "3" :{
			    	   tich=tich(a,b);
			    	   System.out.println("Tích:" + tich);
			    	   writerFile.write("Tích :" + tich + "\n");
			    	   writerFile.flush();
			    	   break;
			       }
			       case "4" :{
			    	   thuong=thuong(a,b);
			    	   System.out.println("Thương:" + thuong);
			    	   writerFile.write("Thương :" + thuong + "\n");
			    	   writerFile.flush();
			    	   break;
			       }
			       case "5" :{
			    	   try {
							 Scanner myReader = new Scanner(myObj);
						      while (myReader.hasNextLine()) {
						        String data = myReader.nextLine();
						        System.out.println(data);
						      }  
						} catch (FileNotFoundException e) {
							System.out.println("không thấy file");
						      e.printStackTrace();
						}
						break;
			       }
			       case "6" :{
			    	   try {
			               File file = new File("D:\\bkd02k111000.txt");
			               if (file.delete()) {
			                   System.out.println(file.getName() + " is deleted!");
			               } else {
			                   System.out.println("Delete operation is failed.");
			               }
			           } catch (Exception e) {
			               e.printStackTrace();
			           }
						break;
			       }   
			}
		} while (true);

	}

	private static int NhapSoNguyen(String string) {
		int x;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println(string);
		x=sc.nextInt();
		if (x == 0 ) 
		throw new InputMismatchException("Giá trị không đưowjc bằng 0.");
		return x;
	}

	private static float thuong(int a, int b) {
		float Thuong = (float) a / b;
		return Thuong;
	}

	private static int tich(int a, int b) {
		int Tich = a * b;
		return Tich;
	}

	private static int hieu(int a, int b) {
		int Hieu = a - b;
		return Hieu;
	}

	private static int tong(int a, int b) {
		int Tong = a + b;
		return Tong;
	}

}
