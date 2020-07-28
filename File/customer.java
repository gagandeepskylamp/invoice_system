package File;
import java.util.*;
import java.io.*;

public class customer{
 String unqcode,name,rate,quantity, totalrate;
 public static double total;
  public int count;
 public void addquantity(String q){
 quantity=q;
 }
 
  public void printconsole(){
  System.out.println("unique productcode :" + unqcode);
  System.out.println("product name:" +name);
  System.out.println("product rate:" +rate);
  System.out.println("quantity :" +quantity);
  }
  
  public void cal()throws NumberFormatException{
   int inum = Integer.parseInt(rate);
   int quant = Integer.parseInt(quantity);
   double totalrated = inum*quant;
   totalrate=String.valueOf(totalrated);
   total+=totalrated; 
   }
   
   
   interface myInterface { 
        abstract void printspace(int a,String b); 
    }
   
   public void printtofile()throws IOException {
        
              
       File file =new File("output.txt");
       if(!file.exists()){
    	   file.createNewFile();
    	}
       FileWriter fw = new FileWriter(file,true);
       BufferedWriter out = new BufferedWriter(fw);
        myInterface r = new myInterface(){ 
            public void printspace(int a, String b){
              int i,l;
              l =a-b.length();
              String u=" ";
              for(i=0;i<l;i++)
              try{
               out.write(u);
               }
               catch(IOException e) {
                 e.printStackTrace();
              }
            };
        };    
        
        
        out.write(unqcode);
        r.printspace(15,unqcode);
        
        
        out.write(name);
        r.printspace(34,name);
        
        out.write(rate);
        r.printspace(15,rate);
        out.write(quantity);
        r.printspace(15,quantity);        
        out.write(totalrate);
        out.write("\n");
        out.close();
   
   }
  }