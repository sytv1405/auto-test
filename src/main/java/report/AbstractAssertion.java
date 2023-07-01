package report;

import helper.HTMLReportHelper;

import java.io.IOException;
import java.util.List;

public class AbstractAssertion {
    public static final String FAIL_MESSAGE_FORMAT = "<br/> <i> &emsp;&emsp; + Expected Result: %s <i/> <br/>" +
            "<i/>&emsp;&emsp; + Actual Result: %s<i/>";
    public static final String ASSERT_BOOLEAN_MESSAGE_FORMAT = "%s";
    public static final String PASS_MESSAGE_FORMAT = "<i> &emsp;&emsp; + %s : %s </i>";


    public static String formatPassMessage(String description, String expected){
        return String.format(PASS_MESSAGE_FORMAT,description, expected);
    }

    public static String formatFailMessage(String expected, String actual){
        return String.format(FAIL_MESSAGE_FORMAT, expected, actual);
    }

    public static void assertTrue(final boolean condition, final String description, final boolean isHard) throws IOException {
        String message = String.format(ASSERT_BOOLEAN_MESSAGE_FORMAT, description);
        if (condition) {
            HTMLReportHelper.logPass(message);
        } else {
            HTMLReportHelper.logFail(message);
            if (isHard) {
                throw new AssertionError();
            }
        }
    }


    public static void assertFalse(final boolean condition, final String description, final boolean isHard) throws IOException {
        String message = String.format(ASSERT_BOOLEAN_MESSAGE_FORMAT, description);
        if (!condition) {
            HTMLReportHelper.logPass(message);
        } else {
            HTMLReportHelper.logFail(message);
            if (isHard) {
                throw new AssertionError();
            }
        }
    }


    public static void assertEquals(final float actual, final float expected, final String description, final boolean isHard){
        if (actual == expected) {
            String message = formatPassMessage(description, String.valueOf(expected));
            HTMLReportHelper.logPass(message);
        } else {
            String message = description + ":" + formatFailMessage(String.valueOf(expected), String.valueOf(actual));
            HTMLReportHelper.logFail(message);
            if (isHard) {
                throw new AssertionError();
            }
        }
    }


    public static void assertEquals(final int actual, final int expected, final String description, final boolean isHard){
        if (actual == expected) {
            String message = formatPassMessage(description, String.valueOf(expected));
            HTMLReportHelper.logPass(message);
        } else {
            String message = description + ":" + formatFailMessage(String.valueOf(expected), String.valueOf(actual));
            HTMLReportHelper.logFail(message);
            if (isHard) {
                throw new AssertionError();
            }
        }
    }



    public static void assertEquals(final String actual, final String expected, final String description, final boolean isHard){
        if(actual.trim().equalsIgnoreCase(expected)){
            String message = formatPassMessage(description, expected);
            HTMLReportHelper.logPass(message);
        }else{
            String message = description+ ":" + formatFailMessage(expected, actual);
            HTMLReportHelper.logFail(message);
            if(isHard) {
                throw new AssertionError();
            }
        }
    }


    public static void assertContains(final String actual, final String expected, final String description, final boolean isHard){
        if(actual.trim().contains(expected.toLowerCase())){
            String message = formatPassMessage(description, expected);
            HTMLReportHelper.logPass(message);
        }else{
            String message = description+ ":" + formatFailMessage(expected, actual);
            HTMLReportHelper.logFail(message);
            if(isHard){
                throw new AssertionError();
            }
        }
    }


    public static void assertEquals(final List<String> actual, final List<String> expected, final String description, final boolean isHard){
        for(int i= 0; i<actual.size(); i++) {
            if (actual.get(i).trim().equalsIgnoreCase(expected.get(i))) {
                String message = formatPassMessage(description, expected.get(i));
                HTMLReportHelper.logPass(message);
            } else {
                String message = description+ ":" + formatFailMessage(expected.get(i), actual.get(i));
                HTMLReportHelper.logFail(message);
                if (isHard) {
                    throw new AssertionError();
                }
            }
        }
    }
}
