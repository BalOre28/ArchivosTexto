/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testmyfile;

/**
 *
 * @author Balto
 */
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestMyFile {

    static MyFile mf = new MyFile();
    static Scanner leer = new Scanner(System.in);

    public static void main(String args[]) {
        int opcion = 0;
        do {
            System.out.println("\nMENU\n");
            System.out.println("1- Set el archivo / folder.");
            System.out.println("2- Ver información.");
            System.out.println("3- Crear un archivo.");
            System.out.println("4- Crear un folder.");
            System.out.println("5- Borrar.");
            System.out.println("6- CMD - DIR.");
            System.out.println("7- Tree.");
            System.out.println("8- Escribir y reemplazar.");
            System.out.println("9- Escribir y mantener.");
            System.out.println("10- Leer");
            System.out.println("11- Salir.");
            System.out.println("Escoja una opción");
            try {
                opcion = leer.nextInt();
                switch (opcion) {
                    case 1:
                        set();
                        break;

                    case 2:
                        mf.Info();
                        break;
                    case 3:
                        mf.crearFile();
                        break;
                    case 4:
                        mf.crearFolder();
                        break;
                    case 5:
                        mf.Borrar();
                        break;
                    case 6:
                        mf.dir();
                        break;
                    case 7:
                        mf.tree();
                        break;    
                    case 8:
                        mf.escribir();
                        break;
                    case 9:
                        mf.mantener();
                        break;
                    case 10: 
                        mf.leer();
                        break;
                        
                }
            } catch (InputMismatchException e) {
                leer.nextLine();
                System.out.println("Por favor escoger una de las opciones en pantalla");

            } catch (NullPointerException e) {
                System.out.println("Para iniciar debe de escoger la opcion 1");

            } catch (IOException e) {
                System.out.println("Error :" + e.getMessage());
            }

        } while (opcion !=11);

    }

    private static void set() {
        System.out.println(" Dirección: ");
        mf.setFile(leer.next());

    }

}
