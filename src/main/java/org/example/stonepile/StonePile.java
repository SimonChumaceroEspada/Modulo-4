package org.example.stonepile;

import java.util.Arrays;
import java.util.Scanner;

public class StonePile {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese el número de piedras:");
    int numPiedras = sc.nextInt();

    // Un array que almacena el número de piedras
    int[] piedras = new int[numPiedras];
    // Un bucle que almacena el número de piedras
    for (int i = 0; i < numPiedras; i++) {
      System.out.println("Piedra " + (i + 1) + ":");
      piedras[i] = sc.nextInt();
    }

    System.out.println("El número de piedras es: " + numPiedras);

    // Ordenamos el array de piedras de mayor a menor
    Arrays.sort(piedras);
    // Inicializamos las sumas de las dos pilas
    int pilaPiedras1 = 0;
    int pilaPiedras2 = 0;

    // Un bucle for que distribuye las piedras entre las dos pilas
    for (int i = numPiedras - 1; i >= 0; i--) {
      if (pilaPiedras1 <= pilaPiedras2) {
        pilaPiedras1 += piedras[i];
      } else {
        pilaPiedras2 += piedras[i];
      }
    }

    // Imprime el resultado
    System.out.println("La diferencia entre las dos pilas es: " + Math.abs(pilaPiedras1 - pilaPiedras2));
  }
}
