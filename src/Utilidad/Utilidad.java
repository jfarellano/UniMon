package Utilidad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Utilidad {

    public static String loadFileAsString(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                builder.append(line + "\n");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static int parseInt(String numero) {
        try {
            return Integer.parseInt(numero);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static float parseFloat(String numero) {
        try {
            return Float.parseFloat(numero);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void escribirArchivo(int[] lista, int tamano, String nombre) throws IOException {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nombre), "utf-8"))) {
            for (int i = 0; i < tamano; i++) {
                writer.write(lista[i] + " ");
            }
            writer.close();
        }
    }
}
