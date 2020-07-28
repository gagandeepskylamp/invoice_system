package File;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
 


public class FileWordSearch
{
   public void wordsearch(String unqcode , customer cus) throws IOException 
   {
      File f1=new File("input.txt"); //Creation of File Descriptor for input file
      
      FileReader fr = new FileReader(f1);  //Creation of File Reader object
      BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
      String s;     
      String input=unqcode;   // Input word to be searched
      int count=0;   //Intialize the word to zero
      while((s=br.readLine())!=null)   //Reading Content from the file
      { 
         
         String[] temp;
         String delimiter = "-"; // setting delimiter

         temp = s.split(delimiter);
         if(temp[0].equals(input)){ 
         count++;  
         cus.unqcode = temp[0];    
         cus.name=temp[1]; 
         cus.rate=temp[2];
         cus.count=count;
         break;
         }
      
                 
         
      }
      if(count==0)
      {
         System.out.println("The given product is not present in the file");
      }
      
         fr.close();
   }


}
