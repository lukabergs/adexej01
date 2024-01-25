package dam.birt.eus;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Ejercicio1 {
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Por favor, introduce el nombre del fichero cuyas vocales quieres cambiar por números: ");
        String rutaFicheroEntrada = teclado.next();
        String[] fragmentosRuta = rutaFicheroEntrada.split("\\.(?=[^.]*$)");
        String rutaFicheroSalida = fragmentosRuta[0] + "_num." + fragmentosRuta[1];
        try (
            FileReader leerFichero = new FileReader(
                rutaFicheroEntrada,
                StandardCharsets.UTF_8
            );
            FileWriter escribirFichero = new FileWriter(
                rutaFicheroSalida,
                StandardCharsets.UTF_8
            );
        ) {
            StringBuilder contenidoFichero = new StringBuilder();
            char letra;
            while (leerFichero.ready()) {
                letra = (char) leerFichero.read();
                switch (letra) {
                    case 'a':
                        letra = '1';
                        break;
                    case 'e':
                        letra = '2';
                        break;
                    case 'i':
                        letra = '3';
                        break;
                    case 'o':
                        letra = '4';
                        break;
                    case 'u':
                        letra = '5';
                        break;
                }
                contenidoFichero.append(letra);
            }
            escribirFichero.write(contenidoFichero.toString());
            // System.out.println("Contenido del fichero " + rutaFicheroEntrada + " modificado con éxito, resultado guardado en " + rutaFicheroSalida + ".");
            System.out.println("Éste es el fichero con las vocales cambiadas por números:\n" + contenidoFichero.toString());
        } catch (IOException e) {
            System.err.println("El fichero " + rutaFicheroEntrada + " no existe, es un directorio o no se puede abrir en modo lectura.");
        }
        teclado.close();
    }
}
