
package central;

import java.util.Scanner;
import java.util.Stack;

public class App {

    public static void main(String[] args) {
        
         //----------------------------
         
        Stack<Integer> number = new Stack<Integer>();
        Stack<String> operation = new Stack<String>();
       Scanner in = new Scanner(System.in);
       
       System.out.println("enter the equation like 5+4 +(5 +4), ");
       System.out.println("dont need to be separated by space: ");

       String str1 = in.nextLine();
       Scanner line = new Scanner(str1);
       line.useDelimiter("");
       boolean flag = false;
       boolean flagNum = false;
       String contNum = "";
       
       while(line.hasNext()){//populate the operation stack
           //populate the number stack
           
           String str = line.next();
           if(Character.isDigit(str.charAt(0))){
               flagNum = true;
               contNum = contNum +str;
               while(line.hasNext()&& !flag){
                   str = line.next();
                   if(Character.isDigit(str.charAt(0))){
                       contNum = contNum + str;
                   }
                   else{
                       flag = true;
                   }
                }
            }
           if(flagNum){
               
               if(number.empty()&&!operation.empty()){
                   contNum = operation.pop()+ contNum;
                   number.push(Integer.parseInt(contNum));
               }
               else{
                   number.push(Integer.parseInt(contNum));
               }
              
                if(str.equals("+")){
                   operation.push(str);
                   
               }
               else if(str.equals("-")){
                   operation.push(str);
               }
               else if(str.equals("(")){
                   operation.push(str);
               }
               else if(str.equals(")")){
                   operation.push(str);
               }
               
           }
           else{
               
               if(str.equals(" ")){}
               
               else{
                   operation.push(str);
               }
           }
           //initialize variables again
           contNum = "";
           flag = false;
           flagNum = false;
    
        }//end of while
       //process all the stack
      while(!operation.empty()){
          String str2 = operation.pop();
          if(str2.equals(")")){
              if(!operation.empty()){
                  String str3 = operation.pop();
                  
                   if(str3.equals("+")){
                      number.push(number.pop()+number.pop());
                  }
                  else if(str3.equals("-")){
                      number.push(number.pop()-number.pop());
                  }
              }
          }
          
          else if(str2.equals("+")){
              number.push(number.pop()+number.pop());
          }
          else if(str2.equals("-")){
              number.push(number.pop()-number.pop());
          }
          
      }
      System.out.println(number.pop());
    

         //--------------------------
       
       
    }
    
}
