import java.util.Scanner;
public class Main
    {            
        static int i,j,k;
                                                     //LOWER_LEFT_TRIANGE
        static void llt(int n)
        {
            for(i=1;i<=n;i++)
            {
                for( j=1;j<=i;j++)
               { System.out.print("*");}
               System.out.print("\n");
            }
        }
        static void llt_rec (int n)                     //LOWER_LEFT_TRIANGE_BY_RECURSION 
        {
            if(n>0)
            {
                llt_rec(n-1);
                for(i=1;i<=n;i++)
                {System.out.print( "*");}
            }    
            System.out.println();
        }
        static void ult(int n)                          //UPPER_LEFT_TRIANGE
        {
            for( i=n;i>=1;i--)
            {
                for(j=1;j<=i;j++)
               { System.out.print("*");}
               System.out.print("\n");
            }
        }
        static void ult_rec(int n)                          //UPPER LEFT TRIANGLE BY RECURSION
        {
            if (n>0)
            {
                for(i=1;i<=n;i++)
                {
                    System.out.print( "*");
                }
                System.out.println();
                ult_rec(n-1);
            }
        }
        static void lrt_1(int n)                              //LOWER_RIGHT_TRIANGE_BY USING THIRD SPACING LOOP
        {
            for (i=1;i<=n;i++)
            {
                for(k=1;k<=n-i;k++)
                {
                    System.out.print(" ");
                }
                for(j=1;j<=i;j++)
                {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        static void lrt_2(int n )                           //LOWER_RIGHT_TRIANGLE_BY USING IF-ELSE
        {
            for(i=n;i>=1;i--)  
            {
                for(j=1;j<=n;j++)
                {
                   if(j<i)
                   System.out.print(" ");
                   else
                   System.out.print("*");
                }
                System.out.println();
            }
        }
        static void urt(int n)                          //UPPER_RIGHT_TRIANGLE_BY USING IF-ELSE
        {
            for(i=n;i>=1;i--)
            {
                for(j=n;j>=1;j--)
                {
                    if(j>i)
                    System.out.print(" ");
                    else
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        static void border(int n)                                   //BORDER
        {
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                   if(i==0 || i==n-1) 
                   System.out.print("*");
                   else
                   {  
                       if(j==0 || j==n-1)
                       System.out.print("*");
                       else
                       System.out.print(" ");
                   }
                }
                System.out.println();
            }
        }
        static void x(int n)                // X shape
        {
            for(i=1;i<=n;i++)
            {
                for(j=1;j<=n;j++)
               {
                  if(i==j || j==n-i+1)
                  System.out.print("*");
                  else
                  System.out.print(" ");
                } 
                System.out.println();
            }
            
        }
        static void pyr_1(int n)                //PYRAMID BY IF-ELSE
        {
            k=n*2-1;
            for(i=1;i<=n;i++)
            {
                for(j=1;j<=k;j++)
                {
                    if((j>=n-i+1) && (j<n+i))
                    System.out.print("*");
                    else 
                    System.out.print(" ");
                }
            System.out.println();
            }
        }
    static void pyr_2 (int n)                   //PYRAMID BY K-LOOP
    {
        for (i = 1; i <= n; ++i) 
        {
            for (k = 1; k <= n - i; ++k) 
            {
                 System.out.print(" ");
            }

            for (j=0 ; j <= 2*i-1 ; j++) 
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
        static void inv_pyr(int n)                      //INVERTED PYRAMID
        {
            for(i=1;i<=5;i++)
            {
                for(k=1;k<i;k++)
                {
                    System.out.print(" ");
                }
                for(j=i;j<=n*2-i;j++)
                {
                    System.out.print("*");
                }
            System.out.println();
            } 
        }
        static void spaced_pyr(int n)                   //SPACED PYRAMID 
        {
            for(i=1;i<=n;i++)
            {
                for(j=1;j<=n-i;j++)
                {
                    System.out.print(" ");
                }
                for(j=1;j<=i;j++)
                {
                    System.out.print("* ");
                }
            System.out.println();
            }
        }
        static void exp_pyr(int n)
        {
            for(i=1;i<=n;i++)
            {
                for(j=1;j<=n-i;j++)
                {
                    System.out.print(" ");
                }
                for(k=1;k<i;k++)
                {
                    System.out.print("*!");
                }
            System.out.println("*");
            }
        }
        static void left_pyr(int n)
        {
            for(i=1;i<=n*2-1;i++)
            {
                if(i<=n)                        //lower left pyramid
                {
                    for(j=1;j<=i ;j++)
                    {
                        System.out.print("*");
                    }
                }
                else
                {
                    for(j=1;j<=n*2-i;j++)
                    {
                    System.out.print("*");
                    }
                }
                System.out.println();
            }
        }
        static void right_pyr(int n)
        {
            for(i=1;i<=n*2-1;i++)
            {
                if(i<=n)
                {
                     for(k=n-i;k>=1;k--)
                     {
                        System.out.print(" ") ;
                     }
                     for(j=1;j<=i;j++)
                     {
                        System.out.print("*");
                     }
                     System.out.println();
                }
                else
                {
                    for(k=i-n;k>=1;k--)
                     {
                        System.out.print(" ") ;
                     }
                     for(j=1;j<=n*2-i;j++)
                     {
                        System.out.print("*");
                     }
                     System.out.println();
                }
            }
        }
        static void right_pointed(int n)                         //RIGHT_POINTED
        {
            for(i=1;i<=n*2-1;i++)
            {
                if(i<=n)
                {
                    for(k=1;k<i;k++)
                    {
                        System.out.print("  ");
                    }
                    for(j=1;j<=n-i+1;j++)
                    {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                else
                {
                    for(k=n*2-i;k>1;k--)
                    {
                        System.out.print("  ");
                    }
                    for(j=i-n+1;j>=1;j--)
                    {
                        System.out.print("*");
                    }
                System.out.println();
                }
            }
        }
        static void left_pointed(int n)                     //LEFT_POINTED
        {
            for(i=1;i<=n*2-1;i++)
            {
                if(i<=n)
                {
                    for(k=i;k<n;k++)
                    {System.out.print(" ");}
                    for(j=0;j<=n-i;j++)
                    {System.out.print("*");}
                    System.out.println();
                }
                else
                {
                    for(k=1;k<=i-n;k++)
                    {System.out.print(" ");}
                    for(j=0;j<=i-n;j++)
                    {System.out.print("*");}
                    System.out.println();
                }
                
            }
        }
        public static void main(String args[])
        {
            int n=5;
        //   llt(n);
        //     llt_rec( n);
        //     ult(n);
        //     ult_rec(n);
        //     lrt_1(n);
        //     lrt_2(n);
        //      urt(n);
        //     urt_shift(n);
        //     border(n);
        //     x(n); 
        //     pyr_1(n);
        //     pyr_2(n); 
        //      inv_pyr(n);
        //      spaced_pyr(n);
            //  exp_pyr(n);
            //  left_pyr(n);
            //  right_pyr(n);  
             right_pointed(n); 
        //      left_pointed(n);
        }
    }
