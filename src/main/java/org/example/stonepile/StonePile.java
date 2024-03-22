package org.example.stonepile;

import java.util.Arrays;
import java.util.Scanner;

public class StonePile {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese el número de piedras:");
    int numPiedras = sc.nextInt();


    int[] piedras = new int[numPiedras];

    for (int i = 0; i < numPiedras; i++) {
      System.out.println("Piedra " + (i + 1) + ":");
      piedras[i] = sc.nextInt();
    }

    System.out.println("El número de piedras es: " + numPiedras);


    Arrays.sort(piedras);

    int pilaPiedras1 = 0;
    int pilaPiedras2 = 0;


    for (int i = numPiedras - 1; i >= 0; i--) {
      if (pilaPiedras1 <= pilaPiedras2) {
        pilaPiedras1 += piedras[i];
      } else {
        pilaPiedras2 += piedras[i];
      }
    }


    System.out.println("La diferencia entre las dos pilas es: " + Math.abs(pilaPiedras1 - pilaPiedras2));
  }
}
