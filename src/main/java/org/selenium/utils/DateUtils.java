/**
 * @author Rajat Verma
 * https://www.linkedin.com/in/rajat-v-3b0685128/
 * https://github.com/rajatt95
 * https://rajatt95.github.io/
 *
 * Course: Selenium Java Test Framework & Best Practices - Masterclass (https://www.udemy.com/course/selenium-java-test-framework/)
 * Tutor: Omprakash Chavan (https://www.udemy.com/user/omprakash-chavan/)
 */

/***************************************************/

package org.selenium.utils;

import java.util.Date;

//final -> We do not want any class to extend this class
public final class DateUtils {

    //private -> We do not want anyone to create the object of this class
    // Private constructor to avoid external instantiation
    private DateUtils() {
    }

    public static String getCurrentDate() {
        Date date = new Date();
        return date.toString().replace(":", "_").replace(" ", "_");
    }

}
