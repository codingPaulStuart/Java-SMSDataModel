// Updated Version of SMSDataModelling Testing JUnit using List instead of Array
// Author - Paul Stuart
// 5JAM GroupSMS Assessment Part 2
// May 2021

package Testing_SMSDataModelling;

import SMSDataModelling.SMSDataModelList;
import SMSDataModelling.SMSDataModel_IndexException;
import SMSDataModelling.SMSDataModel_PhoneException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;


public class SMSDataModellingList_TESTCLASS {

    // Test the Index Exception Handling ----------------------------------------------
    @Test(expected = SMSDataModel_IndexException.class)
    public void testIndexException() throws SMSDataModel_PhoneException, SMSDataModel_IndexException {
        SMSDataModelList SMSTest_1 = new SMSDataModelList();
        SMSTest_1.addPhoneNumber("12345678");

        // Throw Exception when Index is out of range
        SMSTest_1.getPhoneNumberByIndex(4);
    }

    // Test the String Exception Handling ----------------------------------------------
    @Test(expected = SMSDataModel_PhoneException.class)
    public void testStringException() throws SMSDataModel_PhoneException, SMSDataModel_IndexException {
        SMSDataModelList SMSTest_1 = new SMSDataModelList();
        SMSTest_1.addPhoneNumber("12345678");

        // Throws Exception when adding an already existing number
        SMSTest_1.addPhoneNumber("12345678");
    }

    @Test // Testing for the Adding Number to the List Function. ----------------------------------------------
    public void testAddingNumber() throws SMSDataModel_PhoneException {
        SMSDataModelList SMSTest_1 = new SMSDataModelList();

        // Add number Method to test
        String test = SMSTest_1.addPhoneNumber("12345678");
        String expected = "12345678";
        Assert.assertEquals(expected, test);
    }

    @Test // Testing for finding a phone Numbers Index in the List ----------------------------------------------
    public void testFindingNumIndex() throws SMSDataModel_PhoneException {
        SMSDataModelList SMSTest_1 = new SMSDataModelList();
        SMSTest_1.addPhoneNumber("22222222");
        SMSTest_1.addPhoneNumber("33333333");
        SMSTest_1.addPhoneNumber("44444444");
        SMSTest_1.addPhoneNumber("12345678");

        // Find Number Method to Test
        int test = SMSTest_1.findPhoneNumberIndex("12345678");
        int expected = 3;
        Assert.assertEquals(expected, test);
    }

    @Test // Test for updating Number by entering new number and the index to change --------------------------
    public void testUpdateNumber() throws SMSDataModel_IndexException, SMSDataModel_PhoneException {
        SMSDataModelList SMSTest_1 = new SMSDataModelList();
        SMSTest_1.addPhoneNumber("22222222");
        SMSTest_1.addPhoneNumber("33333333");
        SMSTest_1.addPhoneNumber("44444444");

        // List to Compare with the Test Case
        ArrayList<String> testList = new ArrayList<>();
        testList.add("22222222");
        testList.add("33333333");
        testList.add("55555555");

        // Update Number method to test
        SMSTest_1.updatePhoneNumber("55555555", 2);
        String expect = testList.toString();
        String test = SMSTest_1.getPhoneNumbers().toString();
        Assert.assertEquals(expect, test);
    }

    @Test // Test the retrieval of a phone number by index search ----------------------------------------------
    public void testGetPhoneByIndex() throws SMSDataModel_PhoneException, SMSDataModel_IndexException {
        SMSDataModelList SMSTest_1 = new SMSDataModelList();
        SMSTest_1.addPhoneNumber("22222222");
        SMSTest_1.addPhoneNumber("33333333");
        SMSTest_1.addPhoneNumber("44444444");

        // Get Phone By Index Method to Test
        String test = SMSTest_1.getPhoneNumberByIndex(2);
        String expect = "44444444";
        Assert.assertEquals(expect, test);
    }

    @Test // Delete By Index Search ----------------------------------------------
    public void testDeletePhoneByIndex() throws SMSDataModel_PhoneException, SMSDataModel_IndexException {
        SMSDataModelList SMSTest_1 = new SMSDataModelList();
        SMSTest_1.addPhoneNumber("22222222");
        SMSTest_1.addPhoneNumber("33333333");
        SMSTest_1.addPhoneNumber("44444444");

        // List to Compare with the Test Case
        ArrayList<String> testList = new ArrayList<>();
        testList.add("22222222");
        testList.add("33333333");

        // Delete Phone Method to Test using Index Search
        SMSTest_1.deleteNumberByIndex(2);
        String expect = testList.toString();
        String test = SMSTest_1.getPhoneNumbers().toString();
        Assert.assertEquals(expect, test);
    }

    @Test // Delete By String Search ----------------------------------------------
    public void testDeletePhoneByString() throws SMSDataModel_PhoneException, SMSDataModel_IndexException {
        SMSDataModelList SMSTest_1 = new SMSDataModelList();
        SMSTest_1.addPhoneNumber("22222222");
        SMSTest_1.addPhoneNumber("33333333");
        SMSTest_1.addPhoneNumber("44444444");

        // List to Compare with the Test Case
        ArrayList<String> testList = new ArrayList<>();
        testList.add("22222222");
        testList.add("33333333");

        // Delete By String Phone Number Method to test
        SMSTest_1.deleteNumberByString("44444444");
        String expect = testList.toString();
        String test = SMSTest_1.getPhoneNumbers().toString();
    }

    @Test // Setting Test Limit and by doing so switching the boolean value also to True ---------------------
    public void testMaxLimit() {
        SMSDataModelList SMSTest_1 = new SMSDataModelList(10);
        int test = SMSTest_1.getMaxLimitNumberOfPhones();
        int expect = 10;
        Assert.assertEquals(expect, test);
    }

    @Test // Test the setting of the boolean when the max limit constructor is set, by default its False
    public void testIsMax() {
        SMSDataModelList SMSTest_1 = new SMSDataModelList(10);

        // Test the isMaxLimit Boolean via the constructor/getter
        boolean test = SMSTest_1.isMaxLimit();
        Assert.assertTrue(test);
    }

    @Test // Test the direct setting of the Boolean for MaxLimit ----------------------------------------------
    public void testSetMaxSwitch() {
        SMSDataModelList SMSTest_1 = new SMSDataModelList();

        // Test the isMaxLimit Boolean via the setter
        boolean test = SMSTest_1.setMaxLimit(true);
        Assert.assertTrue(test);
    }

    @Test // Test the retrieval number of phones (Will work regardless of isMax True/False using List.size() method
    public void testGetNumberOfPhones() throws SMSDataModel_PhoneException {
        SMSDataModelList SMSTest_1 = new SMSDataModelList();
        SMSTest_1.addPhoneNumber("22222222");
        SMSTest_1.addPhoneNumber("33333333");
        SMSTest_1.addPhoneNumber("44444444");

        // Test the getAmount of Stored Numbers, should be 3
        int test = SMSTest_1.getAmountOfNumbers();
        int expected = 3;
        Assert.assertEquals(expected, test);
    }

    @Test // Retrieval of the message once set via constructor/getter ----------------------------------------
    public void testMessage() {
        SMSDataModelList SMSTest_1 = new SMSDataModelList("Test Message");

        // Test the message retrieval
        String expect = SMSTest_1.getMessage();
        String test = "Test Message";
        Assert.assertEquals(expect, test);
    }

    @Test // Test Direct Testing of the Message via Setter ----------------------------------------------
    public void testMessageSet() {
        SMSDataModelList SMSTest_1 = new SMSDataModelList();

        // Test the setting of message
        String test = "This was set via setter";
        String expect = "This was set via setter";
        SMSTest_1.setMessage(test);
        Assert.assertEquals(expect, test);
    }

    @Test // Numerical Sorting via the List.Sort() function ----------------------------------------------
    public void testSortList() throws SMSDataModel_PhoneException {
        SMSDataModelList SMSTest_1 = new SMSDataModelList();
        SMSTest_1.addPhoneNumber("22222222");
        SMSTest_1.addPhoneNumber("99999999");
        SMSTest_1.addPhoneNumber("33333333");
        SMSTest_1.addPhoneNumber("77777777");
        SMSTest_1.addPhoneNumber("11111111");
        SMSTest_1.addPhoneNumber("55555555");
        SMSTest_1.addPhoneNumber("44444444");
        SMSTest_1.addPhoneNumber("88888888");
        SMSTest_1.addPhoneNumber("66666666");

        // Custom Function set up that uses List.Sort() inside
        SMSTest_1.sortNumbers();
        String test = SMSTest_1.getPhoneNumbers().toString();

        // List to Compare with the Test Case
        ArrayList<String> testList = new ArrayList<>();
        testList.add("22222222");
        testList.add("33333333");
        testList.add("44444444");
        testList.add("55555555");
        testList.add("66666666");
        testList.add("77777777");
        testList.add("88888888");
        testList.add("11111111");
        testList.add("99999999");
        testList.sort(Comparator.naturalOrder());
        String expect = testList.toString();
    }

}