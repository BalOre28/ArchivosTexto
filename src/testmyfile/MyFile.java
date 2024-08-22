/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testmyfile;

/**
 *
 * @author Balto
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import static testmyfile.TestMyFile.leer;

public class MyFile {

    private File mf = null;

    public void setFile(String dir) {
        mf = new File(dir);
    }

    public void Info() {
        if (mf.exists()) {
            System.out.print("\nSI EXISTE:\n -----------");
            System.out.println("Nombre: " + mf.getName());
            System.out.println("Path: " + mf.getPath());
            System.out.println("Absoluta: " + mf.getAbsolutePath());
            System.out.println("Padre: " + mf.getAbsoluteFile().getParentFile().getName());
            System.out.println("Bytes: " + mf.length());
            if (mf.isFile()) {
                System.out.println("ES UN ARCHIVO");
            } else if (mf.isDirectory()) {
                System.out.print("ES UN FOLDER");
                System.out.print("ULTIMA MODIFICACIÓN: " + new Date(mf.lastModified()));
            } else {
                System.out.print("Aun no existe");
            }
        }
    }

    /*
    Para llamar las exception
    1- throws: SOLO PERMITE SER USADO EN FUNCIONES O EN EL CONSTRUCTOR.
    2- throw: Permite ser llamada en una estructura if, usado el cmd new.
     */
    public void crearFile() throws IOException {
        if (mf.createNewFile()) {
            System.out.println("Se a creado de manera exitosa");
        } else {
            System.out.println("Lo sentimos pero no se a creado correctamente");
        }
    }

    public void crearFolder() {
        if (mf.mkdirs()) {
             System.out.println("Se a creado de manera exitosa");
        } else {
            System.out.println("Lo sentimos pero no se a creado correctamente");
        }
    }

    private boolean antidoto(File file) {
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                antidoto(child);
            }
        }
        return file.delete();
    }

    public void Borrar() {
        if (antidoto(mf)) {
            System.out.println("Se a logrado eliminar");
        } else {
            System.out.println("No se logro eliminar");
        }
    }

    public void dir() {
        if (mf.isDirectory()) {
            System.out.println("DIRECTRIO DE: " + mf.getAbsolutePath());
            System.out.println("");
            int cfiles = 0, cdirs = 0, tbytes = 0;

            for (File child : mf.listFiles()) {
                if (!child.isHidden()) {
                    //Fecha Ultima modificación
                    Date ultima = new Date(child.lastModified());
                    System.out.print(ultima + "\t");
                    //Si es File o Folder
                    if (child.isDirectory()) {
                        cdirs++;
                        System.out.print("<DIR>\t\t");
                    } else {
                        //Si es un archivo
                        cfiles++;
                        tbytes += child.length();
                        System.out.print("     \t" + child.length() + "\t");
                    }
                    System.out.println(child.getName());
                }
            }
            System.out.println(cfiles + " archivos\t" + tbytes + " bytes" + "\n" + cdirs + " dirs");
        }
    }

    public void tree() {
        tree(mf, "-");
    }

    private void tree(File dir, String tab) {
        if (dir.isDirectory()) {
            System.out.println(tab + dir.getName());
            //Recorrer el contenido
            for (File child : dir.listFiles()) {
                if (!child.isHidden()) {
                    tree(child, tab + "--");
                }
            }
        }
    }
     public void archivo(){
       // Solicita al usuario los datos a guardar en el archivo
        System.out.println("Ingrese su nombre: ");
        String nombre = leer.nextLine();

        System.out.println("Ingrese su edad: ");
        String edad = leer.nextLine();

        System.out.println("Ingrese su email: ");
        String email = leer.nextLine();

        
        
    }


}// Fin de la clase myfile
