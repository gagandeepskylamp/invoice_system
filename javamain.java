
import java.util.*;
import java.io.*;
import File.FileWordSearch;
import File.customer;

class test{
public static void main(String args[]){

Scanner in =new Scanner(System.in);
String unqcode,quantity;
try{
File file =new File("output.txt");
       if(!file.exists()){
    	   file.createNewFile();
    	}
       FileWriter fw = new FileWriter(file,true);
       BufferedWriter out = new BufferedWriter(fw);
       out.write("-----------------------------------INVOICE---------------------------------------");
       out.write("\n");
       out.write("productID------productname-----------------------rate----------quantity--------totalrate----");
       out.write("\n");
       out.close();
    
System.out.println("Enter the unique product code and quantity of the product");      
while(true){
unqcode=in.nextLine(); 
quantity=in.nextLine();
if(unqcode.equals("")){
break;
}

 FileWordSearch  obj = new FileWordSearch();
 customer objcustomer = new customer();

  obj.wordsearch( unqcode, objcustomer); 

objcustomer.addquantity(quantity);
if(objcustomer.count!=0){
objcustomer.printconsole();

 try{
  objcustomer.cal();
 }
 catch( NumberFormatException e) {
  e.printStackTrace();
 }
 
  objcustomer.printtofile();
 

}
}
 
 customer objcustomer = new customer();
File file1 =new File("output.txt");
       if(!file1.exists()){
    	   file1.createNewFile();
    	}
       FileWriter fw1 = new FileWriter(file1,true);
       BufferedWriter out1 = new BufferedWriter(fw1); 
       out1 .write("\n");
       out1.write("                                                                        ");
       out1.write("total :");
       String total = String.valueOf(objcustomer.total);
       out1.write(total);
       out1.write("\n");
       out1.close();
       
       
} 
catch(IOException e) {
  e.printStackTrace();
}

}
}