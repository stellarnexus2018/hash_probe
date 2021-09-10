package ru.master.hashinfr;

import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ivgrigorev
 */
public class HashFile {

  /**
   * Считаем хэш файла из потока
   *
   * @param insFile Поток на файл
   * @param algName Используемый алгоритм
   * @return Строка HEX-представления хэша файла
   */
  public static String ComputeDigestHexString(InputStream insFile, String algName) throws Exception {
    final MessageDigest messDigest = MessageDigest.getInstance(algName);

    final DigestInputStream digestStream = new DigestInputStream(insFile, messDigest);

    byte[] readBuffer = new byte[1024];

    while (digestStream.read(readBuffer) != -1) {
    }

    byte[] digestArray = messDigest.digest();

    return HashToHexString(digestArray);
  }


  /**
   * Формирование HEX-строка представления хэша
   *
   * @param digestArray Массив расчитанного хэша
   * @return HEX-строка хэша
   */
  public static String HashToHexString(byte[] digestArray) {
    final char[] hex_chars =
        {'0',
         '1',
         '2',
         '3',
         '4',
         '5',
         '6',
         '7',
         '8',
         '9',
         'A',
         'B',
         'C',
         'D',
         'E',
         'F'};

    StringBuilder sbResult = new StringBuilder(digestArray.length * 3);

    for (byte b : digestArray) {
      sbResult.append(' ');
      sbResult.append(hex_chars[(b >>> 4) & 0xf]);
      sbResult.append(hex_chars[b & 0xf]);
    }

    return sbResult.toString();
  }

  public static void getAlgList(){
    List<?> algorithms = Arrays.stream(Security.getProviders())
        .flatMap(provider -> provider.getServices().stream())
        .filter(service -> "Cipher".equals(service.getType()))
        .map(Provider.Service::getAlgorithm)
        .collect(Collectors.toList());
    algorithms.forEach(System.out::println);
  }



  /**
   * Считаем хэш файла из потока
   *
   * @param insFile Поток на файл
   * @param algName Используемый алгоритм
   * @return Строка HEX-представления хэша файла
   */
  public static String ComputeDigestHexBase64(InputStream insFile, String algName) throws Exception {
    final MessageDigest messDigest = MessageDigest.getInstance(algName);
    final DigestInputStream digestStream = new DigestInputStream(insFile, messDigest);
    byte[] readBuffer = new byte[1024];
    while (digestStream.read(readBuffer) != -1) {
    }
    byte[] digestArray = messDigest.digest();
    return Base64.getEncoder().encodeToString(digestArray);
  }


}