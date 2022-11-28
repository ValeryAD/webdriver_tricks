package com.github.valeryAD.framework.listeners;

import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

public class AlterSuiteListener implements IAlterSuiteListener {
    @Override
    public void alter(List<XmlSuite> suites) {
        //suites.clear();
        XmlSuite suite = new XmlSuite();
        suite.setSuiteFiles(Arrays.asList("src/test/resources/maven_tests.xml"));
        suites.add(suite);
        System.err.println("I was Invoked");
    }
}
