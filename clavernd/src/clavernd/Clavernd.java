/*
 Generar una clave random de 3 letras y 2 numeros
 */
package clavernd;
import java.util.Random;
import java.util.Scanner;
/*
 * @author Axel
 */
public class Clavernd 
{ 
    public static void main(String[] args)
    {
        int rn, i=0, cantnum=0, cantlet=0, cinco, opc=0;
        char letra;
        int[] vec = new int [5];
        Scanner s = new Scanner (System.in);
        Random rnd = new Random();
        System.out.println ("Presione 1 para generar clave.");
        System.out.println ("Presione 2 para salir.");
        do
        {
            opc = s.nextInt();
            switch (opc)
            {
            case 1:
            cinco = 0;
            cantnum = 0;
            cantlet = 0;
            i=0;
            do
            {
                rn = (int) (rnd.nextDouble()*122);
                if ((rn>=48) && (rn<=57) && (cantnum<2))
                {
                    vec[i] = rn;
                    i++;
                    cantnum++;
                }
                if ((rn>=97) && (rn<=122) && (cantlet<3))
                {
                    vec[i] = rn;
                    i++;
                    cantlet++;
                }
            cinco = cantlet + cantnum;
            } while (cinco!=5);
            System.out.println ("La clave es:");
            for (i=0; i<5;i++)
            {   
                letra = (char) (vec[i]);            
                System.out.print (letra);                
            }
            System.out.println ();
            break;
            
            case 2:
            break;
            
            default:
                System.out.println ("Seleccione una opcion correcta.");
            break;
            
            }
        } while (opc!=2);
    }
}
