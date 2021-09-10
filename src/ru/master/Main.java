package ru.master;

import ru.master.coders.CodersManagement;
import ru.master.hashinfr.HashFile;
import ru.master.resmanagement.ResourceManager;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.Provider;
import java.security.Security;
import java.util.Base64;

public class Main {
  public static void main(String[] args) {
    //HashFile.getAlgList();

    /*for (Provider provider : Security.getProviders()) {
      for (Provider.Service service : provider.getServices()) {
        String algorithm = service.getAlgorithm();
        System.out.println(algorithm);
      }
    }*/




    String algName = "SHA-256";
    InputStream insData = ResourceManager.getDataAsStream();
    try {
      String dataStr1 = HashFile.ComputeDigestHexString(insData, algName);
      System.out.println(dataStr1);
      String dataStr2 = HashFile.ComputeDigestHexBase64(insData, algName);
      System.out.println(dataStr2);
      String dataStr3 = new String(Base64.getDecoder().decode(dataStr2.getBytes()));
      System.out.println(dataStr3);




    } catch (Exception exception) {
      exception.printStackTrace();
    }


    /*CodersManagement.encodeArray();
    CodersManagement.decodeArray();*/




  }
}