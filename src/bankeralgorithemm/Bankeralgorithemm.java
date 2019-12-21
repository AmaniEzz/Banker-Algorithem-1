package bankeralgorithemm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author amany
 */
public class Bankeralgorithemm {
       static int     P,R;
        int     max[][];
        int     allocation[][];
        int     need[][];
        int     available[];
        int     request[];
        boolean finish[];
        int[] sequance;
        int     work[];
        
void Enter(){  
        Scanner in = new Scanner (System.in);
        
        System.out.println("Processes: ");
           P=in.nextInt();
           
        System.out.println("Resources: ");
           R=in.nextInt();
           
           max = new int[P][R];
           allocation = new int[P][R];
           available = new int[R];
           sequance= new int[P];
          
        System.out.println("Enter allocation Matrix");
        for (int i = 0; i < P; i++) {
          for (int j = 0; j < R; j++) {
           allocation[i][j] = in.nextInt();
          }}
                
        System.out.println("Enter Max Matrix");
        for(int i = 0; i < P; i++) {
           for (int j = 0; j < R; j++) {
                max[i][j] = in.nextInt();
           }}
        
        System.out.println("Enter Available matrix");
        for(int i = 0; i < R; i++) {
            available[i]=in.nextInt();
        }
        System.out.println("Enter a sequance to check");
           for(int i = 0; i < P; i++) {
            sequance[i]=in.nextInt();
       
       
}}
public boolean check(int p){
       for(int i=0;i<R;i++){
         if(need[p][i]>available[i]){
            return false;
            }}
            return true; 
            }

void need(){
     need= new int[P][R];
          for (int i = 0; i < P; i++) {
          for (int j = 0; j < R; j++) {
          need[i][j]=max[i][j]-allocation[i][j];
          }}
          }

void BankerAlgorithem(){
           Scanner in = new Scanner (System.in);
           System.out.println("Is there is any Requests through this sequance?" +'\n'+"choose 1 for yes and 0 for no");
            int choose = in.nextInt(P);
            if(choose==1){
            request= new int[R]; 
            System.out.println("WHich process?? ");
            int p = in.nextInt(); 
           System.out.println("Enter the request amount to be allocated to p"+p);
           for (int i = 0; i < R; i++) {
            request[i] =in.nextInt();
             if(checkAvaliable(p)&& checkRequest(p)){
             for (int m = 0; m < R; m++){
                 available[m]=available[m]-request[m];
                 allocation[p][m]=allocation[p][m]+request[m];
                 need[p][m]=need[p][m]-request[m]; }
            }}}
             else if(choose==0);
      need();  
      work= new int[R];  
      work=available;
      finish = new boolean[P]; //all are not finish false at the beginig
      boolean allocated;  // to record who has been allocated and who is waiting
         int count=0;    
          //two loops one for checking who is left and one for currunt process to allocate
         for ( count = 0;  count< P; count ++) {
          allocated=false;//updated every iteration
          //iteration throgth process
             for (int i = 0; i < P; i++) 
              if(!finish[sequance[i]] && check(sequance[i])){ 
                  for (int j = 0; j < R; j++) 
                  work[j]=allocation[sequance[i]][j]+work[j]; //try to allocate if it not finidshed and its check is true
                  allocated=finish[sequance[i]]=true; //mark it as finished and allocated
                } 
              else break;
              //if it passed the frist conditon the !allocation will became true then it will break the second loop
              if(!allocated) break; }
             // continouing the rest of the processes bake to frist loop
             if(checkFinish()){
                     System.out.println('\n'+"System is in Safe state");}
              else
             System.out.println("Not in Safe states , cant be allocated");

}
boolean checkFinish(){
         for (int i = 0; i < P; i++) {
           if(finish[i]==true){     
             return true;}}
             return false;}  
         
boolean checkRequest(int p){  
   
    need();
    for(int j = 0; j < R; j++) {
       if(request[j]>need[p][j]){
         return false;
        }}
         return true;
        }

boolean checkAvaliable(int p){
       for (int i = 0; i < R; i++) {
        if(available[i]<request[i]){
            return false;
          }}
            return true;
} 
// void printArr(int a[]) 
//    { 
//        for (int i=0; i<a.length; i++) 
//            System.out.print(a[i] + " "); 
//        System.out.println(); 
//    } 
//  
// void heapPermutation(int a[], int size, int n) 
// {
//        if (size == 1) 
//            BankerAlgorithem(a);
//      
//        for (int i=0; i<size; i++) 
//        { 
//            heapPermutation(a, size-1, n); 
//  
//            // if size is odd, swap first and last 
//            // element 
//            if (size % 2 == 1) 
//            {  
//                int temp = a[0]; 
//                a[0] = a[size-1]; 
//                a[size-1] = temp; 
//            } 
//  
//            // If size is even, swap ith and last 
//            // element 
//            else
//            { 
//                int temp = a[i]; 
//                a[i] = a[size-1]; 
//                a[size-1] = temp; 
//            } 
//        } }
 public static void main(String[] args) {
     
      Bankeralgorithemm obj = new Bankeralgorithemm();
      obj.Enter();    
      obj.BankerAlgorithem();
      
     }
 }