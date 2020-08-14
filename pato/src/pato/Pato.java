/*
Crear un juego de disparar al pato
el pato tene 16 paso, esl jugador puede disparar hasta 6 veces para poder arle 
al pato, si acierta antes de los 6 tiros el jugador puede continuar hasta terminar
la cantidad solicitada. Al final se debe indicar la cantidad de puntos obtenidos.
 */
package pato;
import java.util.Scanner;
import java.util.Random;
/* @author Axel */
public class Pato {
    public static void main(String[] args) 
    {
       int n=16, rnd=0, ptos=0, nrta=0, modo=0, i=0, pos=0, vidas=0;
       Scanner rta = new Scanner (System.in);
       int[] vec = new int[n];
       Random ran  = new Random();
       System.out.println ("Elija modo de juego:");
       System.out.println ("1) Tiro random");
       System.out.println ("2) Elegir posicion y pato está en luagar Random (3 vidas)");
       System.out.println ("3) Salir");
       do 
       {
            modo = rta.nextInt();
            switch (modo)
            {
                case 1:   
                System.out.print ("Presione 1 para disparar.");
                for (i=0; i<=n; i++)
                    {
                        nrta = rta.nextInt();
                        if (nrta==1)
                        {
                            rnd = (int)(ran.nextDouble() *n);
                            if (i==rnd)
                            {
                                System.out.println ("Cuack!");
                                ptos++;
                            }
                        }       
                    }
                System.out.println ("Game over");
                System.out.println ("Puntos Obtenidos:" + ptos);
                System.out.println ("");
                System.out.println ("Elija modo de juego:");
                System.out.println ("1) Tiro random");
                System.out.println ("2) Elegir posicion y pato está en luagar Random (3 vidas)");
                System.out.println ("3) Salir");
                break;
            
                case 2:
                    vidas=3;
                    i=(int) (ran.nextDouble()*n);
                    System.out.print("Escriba un numero del 0 al 15.");
                    do 
                    {
                        pos = rta.nextInt();
                        if (i==pos)
                        {
                            ptos++;
                            i=(int) (ran.nextDouble()*n);
                            System.out.println ("Cuack!");
                        }
                        vidas--;
                    } while (vidas!=0);
                System.out.println ("Game over");
                System.out.println ("Puntos Obtenidos:" + ptos);
                System.out.println ();   
                System.out.println ("Elija modo de juego:");
                System.out.println ("1) Tiro random");
                System.out.println ("2) Elegir posicion y pato está en luagar Random (3 vidas)");
                System.out.println ("3) Salir");                    
                break;
                
                case 3:
                break;
                
                default:
                System.out.println("Seleccione una opción correcta.");
                break;
            }
       } while (modo!=3);
       System.out.println ("Puntos Obtenidos:" + ptos);
    }
    
}
