/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Steven.TokenSeprator;

/**
 *
 * @author steve
 */

 
import java.util.Arrays;
import java.util.Scanner;

public class SimpleTokenSeprator {
  public static   Scanner k = new Scanner(System.in);
        public static  String[] line = new String[3];       //to take line input
        public static  int count = 1;
        
        //public static  String keyword[] = {"int", "char", "float"};
        public static  char[] identifier = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'};
        public static  char[] operator= {'+','-','*','/','%','='};
        public static  char[] Symbol = {',',';'};
        public static  char[] numbers = {'0','1','2','3','4','5','6','7','8','9'};
        

    public static void main(String[] args) {
        Arrays.sort(operator);
        Arrays.sort(identifier);
        //Arrays.sort(keyword);
        Arrays.sort(Symbol);
        
        StringBuilder st = new StringBuilder();
        
        
            for(int i=0;i<line.length;i++){
                line[i] = k.nextLine(); //to read line
            }
        
      for (String line1 : line) {
          //line[i] = k.nextLine(); //to read line
          char[] ch = line1.toCharArray(); //to convert each line to array
          //for operators
          for(int a=0;a<ch.length;a++){   //reading characters in each line
              
              if(Arrays.binarySearch(operator, ch[a]) > -1){
                  System.out.println("<op,"+ch[a]+">");
                  //ch[a]=-1;
              }
              
              else if(Arrays.binarySearch(Symbol, ch[a]) > -1){
                  System.out.println("<punctuation,"+ch[a]+">");
              }
              
              else if(ch[a]=='i' && ch[a+1]=='n' && ch[a+2]=='t' && ch[a+3]==' '){
                  System.out.println("<keyword,int>");
                  a+=3;
              }
              else if(ch[a]=='f' && ch[a+1]=='l' && ch[a+2]=='o' && ch[a+3]=='a' && ch[a+4]=='t' && ch[a+5]==' '){
                  System.out.println("<keyword,float>");
                  a+=5;
              }
              else if(ch[a]=='c' && ch[a+1]=='h' && ch[a+2]=='a' && ch[a+3]=='r' && ch[a+4]==' '){
                  System.out.println("<keyword,char>");
                  a+=4;
              }
              else if (ch[a]=='0'||ch[a]=='1'||ch[a]=='2'||ch[a]=='3'||ch[a]=='4'||ch[a]=='5'||ch[a]=='6'||ch[a]=='7'||ch[a]=='8'||ch[a]=='9'){
                  
                  boolean isSingleDigit = true;
                  int charcount=0;
                  for(int j = a; j<ch.length;j++)
                      
                  {
                      if(Arrays.binarySearch(numbers, ch[a]) > -1){
                          
                          for(int num = 0;num<numbers.length;num++){
                              if(ch[j] == numbers[num]){
                                  st.append(ch[j]);
                                  charcount++;
                                  a++;
                              }
                          }
                      }
                      if(charcount<1){
                          break;
                      }
                      
                      if(charcount>=1){
                          isSingleDigit = false;
                      }
                  }
                  if(isSingleDigit == false){
                      System.out.println("<num,"+st+">");
                      a--;
                  }else{
                      System.out.println("<num,"+ch[a]+">");
                  }
                  st = new StringBuilder();
              }
              
//                    else if(ch[a]==' ')
//                        continue;
              
              else {
                  boolean isSingleDigit = true;
                  int counts=0;
                  for(int j = a; j<ch.length;j++)
                      
                  {
                      if(Arrays.binarySearch(identifier, ch[a]) > -1){
                          
                          for(int id=0;id<identifier.length;id++){
                              if(ch[j] == identifier[id]){
                                  st.append(ch[j]);
                                  counts++;
                                  a++;
                              }
                          }
                      }
                      if(count<1){
                          break;
                      }
                      
                      if(counts>=1){
                          isSingleDigit = false;
                      }
                  }
                  if(isSingleDigit == false){
                      System.out.println("<id,"+st+">");
                      a--;
                  }
                  
                  
                  else{
                      System.out.println("<id,"+ch[a]+">");
                  }
                  st = new StringBuilder();
              }
          }
      }
    }
}
        