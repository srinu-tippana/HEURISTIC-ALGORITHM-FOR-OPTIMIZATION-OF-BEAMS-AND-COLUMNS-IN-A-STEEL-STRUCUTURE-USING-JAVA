/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sap2000algorithm;

import java.util.Scanner;

/**
 *
 * @author Cnu
 */
public class SAP2000ALGORITHM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        int beamer[]  ={35,40,46,50,55,60,65,71,76,86,97,106,119,130,143,158,175};
        int col[] = {12,15,17,19,22,26,30,33,29,45,49,54,60,68,77,88,100,112};
        
        //System.out.println(a.length);
       // System.out.println(b.length);
        System.out.println("enter the intial sizes");
        System.out.println("enter the intial accepted beam size");
        System.out.println("enter the accepted inital beam size");
        int beam=scan.nextInt();
        System.out.println("enter the accepted inital outer column  size");
        int outer_column=scan.nextInt();
        System.out.println("enter the accepted inital inner column  size");
        int inner_column=scan.nextInt();
        int temp=0;
        

        
        boolean set=true;
        int count=0;
        int[] se = SAP2000ALGORITHM.decrease(beam,outer_column,inner_column);
        //System.out.println(se[0]+" "+se[1]+" "+se[2]);
        int[] record = new int[1000];
        int[] record1 = new int[1000];
        int[] record2  = new int[1000];
        int array_code=0;
        
       
      
        
        while(count!=3)
        {
            int value1 =se[0],value2=se[1],value3=se[2];
            System.out.println("did"+" "+value1+" "+value2+" "+value3+" "+" passs SAP ANALYSIS");
            int status =scan.nextInt();
            if(status==1)
            {
                
                System.out.println(value1);
                record[array_code]=value1;
                record1[array_code]=value2;
                record2[array_code]=value3;
                array_code=array_code+1;
                
                
                 System.out.println("these  are arraay elemtns");
                   
               
                 System.out.println("there are "+" "+array_code+" elements in the array");
                  for(int i=0;i<=array_code-1;i++)
                    {
                       
                        System.out.println(record[i]);
                    }
                if(array_code==1)// this means one element is present 
                {
                    
                    se=SAP2000ALGORITHM.decrease(value1,value2,value3);
                }
                else if(array_code==2)
                {
                    se=SAP2000ALGORITHM.decrease(value1,value2,value3);
                }
             
                else 
                {
                    System.out.println("in else condition");
                     System.out.println("these  are arraay elemtns");
                    for(int i=0;i<array_code-1;i++)
                    {
                       
                        System.out.println(record[i]);
                    }
                    int temporary_count=0;
                    System.out.println(value1);
                   for(int i=0;i<=array_code-1;i++)
                   {
                       if(record[i]==value1)   
                       {
                           System.out.println("checking for temporary count");
                           temporary_count=temporary_count+1;
                            System.out.println(temporary_count);
                           
                          
                       }
                   }
                   
                   if(temporary_count==3)
                   {
                       count=3;
                       
                   }
                   else
                   {
                      se=SAP2000ALGORITHM.decrease(value1,value2,value3);
                   }
                    
                }
                
                
            }
            else
            {
                
               se=SAP2000ALGORITHM.increase(value1,value2,value3); 
                
            }
                
   
            
        }
                 
           
                     
        
        
        
        
        
       
        
       
    }

    public static int[] decrease(int beam,int outer_column,int inner_column)
    {
        
         int beamer[]  ={35,40,46,50,55,60,65,71,76,86,97,106,119,130,143,158,175};
         int col[] = {12,15,17,19,22,26,30,33,39,45,49,54,60,68,77,88,100,112};
         int temp=0;
                                   // this code is for  finding the forward beam values
          for(int i=0;i<beamer.length;i++)
                  {
                      if(beamer[i]>=beam)
                          {
                             temp=i;

                                  //System.out.println(a[i]);
                               break;
                           }
                     }

                         int new_beam =beamer[temp-1];
                         //System.out.println(new_beam);
                         temp=0;
                          for(int i=0;i<col.length;i++)
                         {
                             if(col[i]>=outer_column)
                             {
                                 temp=i;

                                 //System.out.println(a[i]);
                                 break;
                             }
                         }
                          int new_out=col[temp-1];
                          temp=0;
                         for(int i=0;i<col.length;i++)
                         {
                             if(col[i]>=inner_column)
                             {
                                 temp=i;

                                 //System.out.println(a[i]);
                                 break;
                             }
                         }
                            int new_in=col[temp-1];
                 int[] new_sizes = new int[3];
                 new_sizes[0]=new_beam;
                 new_sizes[1]=new_out;
                 new_sizes[2]=new_in;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return new_sizes;
    }
    
   public static int[] increase(int beam,int outer_column,int inner_column)
   {
       
       int beamer[]  ={35,40,46,50,55,60,65,71,76,86,97,106,119,130,143,158,175};
       int col[] = {12,15,17,19,22,26,30,33,39,45,49,54,60,68,77,88,100,112};
       int temp=0;
                 for(int i=0;i<beamer.length;i++)
                  {
                      if(beamer[i]>=beam)
                          {
                             if(beamer[i]>beam)
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
                 

                         int new_beam =beamer[temp];
                         //System.out.println(new_beam);
                         temp=0;
                          for(int i=0;i<col.length;i++)
                         {
                             if(col[i]>=outer_column)
                             {
                                    if(col[i]>outer_column)
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
                          int new_out=col[temp];
                          temp=0;
                         for(int i=0;i<col.length;i++)
                         {
                             if(col[i]>=inner_column)
                             {
                                  if(col[i]>inner_column)
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
                            int new_in=col[temp];
                 int[] new_sizes = new int[3];
                 new_sizes[0]=new_beam;
                 new_sizes[1]=new_out;
                 new_sizes[2]=new_in;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return new_sizes;
      
       
       
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates
   }
    
}
