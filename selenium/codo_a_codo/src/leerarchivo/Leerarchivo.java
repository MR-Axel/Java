package leerarchivo;

import java.io.IOException;


public class Leerarchivo {

    
    public static void main(String[] args) throws IOException, InterruptedException  {
            Metodos Sele = new Metodos();
            Sele.cargardriver("chromedriver.exe");
            Sele.llamarpagina("http://ifts20.com.ar/");
            Sele.leerarchivo("finales.txt");
            Sele.escribirarchivo("resultados.txt");
            Sele.recorrerarchivo();
            Sele.cartelito("Prueba terminada");
            Sele.cerrardriver();
            Sele.cerrararchivo();
            
            
   
      
    }
}
