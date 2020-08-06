/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sap;

import java.util.Scanner;

/**
 *
 * @author Cnu
 */
public class SAP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Scanner scan= new Scanner(System.in);
        int w27[]={84,94,102,114,129,146,161,178,194,217,235,258,281,307,336,368,539};
        int w24[]={55,62,68,76,84,94,103,104,117,131,146,162,176,192,207,229,250,279,306,335,370};
        int w14[]={22,26,30,34,38,43,48,53,61,63,74,82,90,99,109,120,132,141,145,159,176,193,211,233,257,283,311,342,370,398,426,455,500,550,605,665,730,808};
        //first apply on  w14  next on  w24 and next on w 27 
        //w14  beams  w27 inner columns  w24 outer columns
        System.out.println("enter the intial accepted structure values");
        System.out.println("enter the accepted beam value");
        int beam = scan.nextInt();
        System.out.println("enter the accepted  inner column value");
        int in_col=scan.nextInt();
        System.out.println("enter the accepted  outer column value");
        int out_col=scan.nextInt();
        int count=0;
        int[] record = new int[1000];
        int[] record1 = new int[1000];
        int[] record2  = new int[1000];
        int array_code=0;
        int[] accepted = new int[3];
        int[] accepted1 = new int[3];
        int[] accepted2 = new int[3];
        
                
        int value=SAP.decrease(w14,beam);
        beam=value;
        while(count!=3)
        {
             System.out.println("did"+" "+out_col+" "+in_col+" "+beam+" "+" passs SAP ANALYSIS");
             int status=scan.nextInt();
             if(status==1)
             {
                 record[array_code]=beam;
                 record1[array_code]=in_col;
                 record2[array_code]=out_col;
                 array_code=array_code+1;
                 if(array_code==1)
                 {
                     beam=SAP.decrease(w14,beam);
                 }
                 else if(array_code==2)
                 {
                     beam=SAP.decrease(w14,beam);
                 }
                 else
                 {
                     int temporary_count=0;
                                    for(int i=0;i<=array_code-1;i++)
                                 {
                                     if(record[i]==beam)   
                                     {
                                         //System.out.println("checking for temporary count");
                                         temporary_count=temporary_count+1;
                                          //System.out.println(temporary_count);


                                     }
                                 }
                     if(temporary_count==3)
                   {
                       count=3;
                       accepted[0]=beam;
                       accepted1[0]=in_col;
                       accepted2[0]=out_col;
                   }
                   else
                   {
                      beam=SAP.decrease(w14,beam);
                   }
                 }
                 
                 
             }
             else
             {
                 beam=SAP.increase(w14, beam);
             }
             
            
            
        }
        for(int i=0;i<=array_code-1;i++)
        {
                 record[array_code]=0;
                 record1[array_code]=0;
                 record2[array_code]=0;
            
        }
        array_code=0;
        count=0;
        value=SAP.decrease(w27,in_col);
        in_col=value;
        while(count!=3)
        {
            System.out.println("i am here");
             System.out.println("did"+" "+out_col+" "+in_col+" "+beam+" "+" passs SAP ANALYSIS");
             int status=scan.nextInt();
             if(status==1)
             {
                 record[array_code]=beam;
                 record1[array_code]=in_col;
                 record2[array_code]=out_col;
                 array_code=array_code+1;
                 if(array_code==1)
                 {
                     in_col=SAP.decrease(w27,in_col);
                     System.out.println(in_col);
                 }
                 else if(array_code==2)
                 {
                     in_col=SAP.decrease(w27,in_col);
                 }
                 else
                 {
                     int temporary_count=0;
                                    for(int i=0;i<=array_code-1;i++)
                                 {
                                     if(record1[i]==in_col)   
                                     {
                                         //System.out.println("checking for temporary count");
                                         temporary_count=temporary_count+1;
                                          //System.out.println(temporary_count);


                                     }
                                 }
                     if(temporary_count==3)
                   {
                       count=3;
                       accepted[1]=beam;
                       accepted1[1]=in_col;
                       accepted2[1]=out_col;
                   }
                   else
                   {
                      in_col=SAP.decrease(w27,in_col);
                   }
                 }
                 
                 
             }
             else
             {
                 in_col=SAP.increase(w27, in_col);
             }
             
            
            
        }
        
         for(int i=0;i<=array_code-1;i++)
        {
                 record[array_code]=0;
                 record1[array_code]=0;
                 record2[array_code]=0;
            
        }
        array_code=0;
        count=0;
        value=SAP.decrease(w24,out_col);
        out_col=value;
        while(count!=3)
        {
            System.out.println("i am here");
             System.out.println("did"+" "+out_col+" "+in_col+" "+beam+" "+" passs SAP ANALYSIS");
             int status=scan.nextInt();
             if(status==1)
             {
                 record[array_code]=beam;
                 record1[array_code]=in_col;
                 record2[array_code]=out_col;
                 array_code=array_code+1;
                 if(array_code==1)
                 {
                     out_col=SAP.decrease(w24,out_col);
                     System.out.println(in_col);
                 }
                 else if(array_code==2)
                 {
                     out_col=SAP.decrease(w24,out_col);
                 }
                 else
                 {
                     int temporary_count=0;
                                    for(int i=0;i<=array_code-1;i++)
                                 {
                                     if(record2[i]==out_col)   
                                     {
                                         //System.out.println("checking for temporary count");
                                         temporary_count=temporary_count+1;
                                          //System.out.println(temporary_count);


                                     }
                                 }
                     if(temporary_count==3)
                   {
                       count=3;
                       accepted[2]=beam;
                       accepted1[2]=in_col;
                       accepted2[2]=out_col;
                   }
                   else
                   {
                      out_col=SAP.decrease(w24,out_col);
                   }
                 }
                 
                 
             }
             else
             {
                 out_col=SAP.increase(w24,out_col);
             }
             
            
            
        }
        
        
        
        
        
                
    }
    public static int decrease(int[] arr,int beam)
    {
        int temp=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>=beam)
              {
                     temp=i;

                                  //System.out.println(a[i]);
                          break;
                 }
        }
       
      int new_beam=arr[temp-1];
        return new_beam;
    }
    public static int increase(int [] arr,int beam)
            {
                int temp=0;
                for(int i=0;i<arr.length;i++)
                  {
                      if(arr[i]>=beam)
                          {
                             if(arr[i]>beam)
                             {
                                 temp=i;
                                 
                                 break;
                             }
                             else
                             {
                                 temp=i+1;
                                 break;
                             }
                                     
                           }
                     }
                
                return arr[temp];
                
                
            }
    
}
