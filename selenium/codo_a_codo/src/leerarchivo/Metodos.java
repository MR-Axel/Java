
package leerarchivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author balbi
 */
public class Metodos {
    private static WebDriver driver = null; 
    public String texto;
    public String asercion;
    public int cuenta=0;
    FileWriter escritura;
    FileReader lector;
    BufferedReader contenido;
    String DNI;
    String Nombre;
    String Apellido;
    String Email;
    String Movil;
    String Carrera;
    String Materia;

    public void leerarchivo(String archivo) throws IOException{
        lector = new FileReader(archivo); 
        contenido =  new BufferedReader(lector);     
    }
    
    public void escribirarchivo(String escarchivo) throws IOException{
    File archivo = new File(escarchivo); 
    archivo.delete();
    escritura = new FileWriter(archivo,true);  
    }
    
    public void recorrerarchivo() throws IOException, InterruptedException{
     //////////   Bucle que lee hasta el final del archivo
    while((texto=contenido.readLine())!=null){  
     DNI=datoarray(0);
     Apellido=datoarray(1);
     Nombre=datoarray(2);
     Email=datoarray(3);
     Movil=datoarray(4);
     Carrera=datoarray(5);
     Materia=datoarray(6);
    cuenta++; 
    ejecutaselenium();
        }
    }
    
 public void nuevalinea() throws IOException{
    texto=contenido.readLine();     
    cuenta++; 
    Materia=datoarray(6);      
    }
    
    public String datoarray(int i){
        String []Datos = texto.split(",");
//        System.out.println("El dato es:" +Datos[i]);
        return Datos[i];
    }
    
    public void cargardriver(String nombredriver){
    driver = new ChromeDriver();   
    System.setProperty("webdriver.chrome.driver",nombredriver);
  
    }
    
       public void llamarpagina(String nombreWeb){ 
               driver.get(nombreWeb); 
                // | Redimensionar la pantalla a  1382x744 píxeles 
                driver.manage().window().setSize(new Dimension(1382, 744));
       }
       
       
       public void ejecutaselenium() throws IOException, InterruptedException{

   if(!"0".equals(DNI)){
     
    driver.findElement(By.name("carreras")).click();
    {
      WebElement dropdown = driver.findElement(By.name("carreras"));
      dropdown.findElement(By.cssSelector("*[value='" + datoarray(5) + "']")).click();
    }
    driver.findElement(By.name("carreras")).click(); 
    driver.findElement(By.id("DNI")).click();
    driver.findElement(By.id("DNI")).sendKeys(datoarray(0));
    driver.findElement(By.name("Apellido")).sendKeys(datoarray(1));
    driver.findElement(By.name("Nombre")).sendKeys(datoarray(2));
    driver.findElement(By.name("Email")).sendKeys(datoarray(3));
    driver.findElement(By.name("Telefono")).sendKeys(datoarray(4));
    Thread.sleep(2000);
    // 12 | click | Botón Inscripción |  | 
    driver.findElement(By.name("B1")).click();
    driver.findElement(By.name("renglon1")).click();
    {
      WebElement dropdown = driver.findElement(By.name("renglon1"));
      dropdown.findElement(By.cssSelector("*[value='" + datoarray(6) + "']")).click();
    }
    driver.findElement(By.name("renglon1")).click();
 }else{
//    nuevalinea();    
    driver.findElement(By.name("renglon2")).click(); 
    {
      WebElement dropdown = driver.findElement(By.name("renglon2"));
      dropdown.findElement(By.cssSelector("*[value='" + datoarray(6) + "']")).click();
    }
    driver.findElement(By.name("renglon2")).click();
    nuevalinea();
    driver.findElement(By.name("renglon3")).click();
    {
      WebElement dropdown = driver.findElement(By.name("renglon3"));
      dropdown.findElement(By.cssSelector("*[value='" + datoarray(6) + "']")).click();
    }
    driver.findElement(By.name("renglon3")).click();
    nuevalinea();
    driver.findElement(By.name("renglon4")).click();
    {
      WebElement dropdown = driver.findElement(By.name("renglon4"));
      dropdown.findElement(By.cssSelector("*[value='" + datoarray(6) + "']")).click();
    }
    driver.findElement(By.name("renglon4")).click();
 
          Thread.sleep(2000);
    driver.findElement(By.name("B1")).click();
    asercion = driver.getPageSource();
    leeasercion(asercion);
        Thread.sleep(2000);
    driver.findElement(By.cssSelector("a > img")).click();
  }      
    }  
       
    public void leeasercion(String asercion) throws IOException{
        //cartelito(asercion);
        if (asercion.indexOf("Felic") >= 0){
               escritura.write(DNI+","+Apellido+","+Nombre+","+Email+","+Movil+","+Carrera+","+Materia+"\r\n");    
        }else{
            escritura.write("Error en línea: " + cuenta +"\r\n");     
        }  
    }
       
    public void cartelito(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
        
    }
    
      public void cerrardriver(){
            driver.close();

        }
      public void cerrararchivo() throws IOException{
             escritura.close();  
      }
      
    
}
