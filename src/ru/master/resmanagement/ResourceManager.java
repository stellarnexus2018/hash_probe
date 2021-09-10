package ru.master.resmanagement;

import java.io.InputStream;

public class ResourceManager {
  private static final String TEST_DATA = "pdf/test.pdf";

  public ResourceManager() {

  }

  public static InputStream getDataAsStream() {
    return ResourceManager.class.getClassLoader().getResourceAsStream(TEST_DATA);
  }
}