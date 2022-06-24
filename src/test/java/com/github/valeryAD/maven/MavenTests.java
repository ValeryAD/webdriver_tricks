package com.github.valeryAD.maven;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MavenTests {

  @Test
  public void checkIfSystemPropertyAddedFromPom(){
    System.out.println("good.user=" + System.getProperty("good.user"));
    Assert.assertTrue(System.getProperty("good.user") != null, "webdriver property is null!!!!");
  }

}
