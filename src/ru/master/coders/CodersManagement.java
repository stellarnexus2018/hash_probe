package ru.master.coders;

import java.util.Base64;

public class CodersManagement {

  public static void encodeArray() {
    byte[] encoded = Base64.getEncoder().encode("Hello".getBytes());
    System.out.println(new String(encoded));

  }

  public static void decodeArray() {
    byte[] encoded = Base64.getEncoder().encode("Hello".getBytes());
    byte[] decoded = Base64.getDecoder().decode(encoded);
    System.out.println(new String(decoded));

  }


  /*String encoded = Base64.getEncoder().encodeToString("Hello".getBytes());
  println(encoded);   // Outputs "SGVsbG8="

  String decoded = new String(Base64.getDecoder().decode(encoded.getBytes()));
  println(decoded)    // Outputs "Hello"v
*/



}
