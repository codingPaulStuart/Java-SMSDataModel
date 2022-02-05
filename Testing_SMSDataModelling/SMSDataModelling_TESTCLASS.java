package Testing_SMSDataModelling;

import SMSDataModelling.SMSDataModelArray;
import SMSDataModelling.SMSDataModel_IndexException;
import SMSDataModelling.SMSDataModel_PhoneException;
import org.junit.Assert;
import org.junit.Test;


public class SMSDataModelling_TESTCLASS {

    // Testing Object Instance -----------------------------
    SMSDataModelArray testDataModel = new SMSDataModelArray();

    @Test
    public void testAddPhone() throws SMSDataModel_PhoneException, SMSDataModel_IndexException {
        testDataModel.addPhoneNumber("12345678");
        testDataModel.addPhoneNumber("23456789");
        String test = testDataModel.getPhoneNumber(1);
        String expected = "23456789";
        Assert.assertEquals(expected, test);
    }

    @Test
    public void testFindPhoneNumberIndex() throws SMSDataModel_PhoneException {
        SMSDataModelArray testDataModel = new SMSDataModelArray();
        testDataModel.addPhoneNumber("87654321");
        testDataModel.addPhoneNumber("23456789");
        testDataModel.addPhoneNumber("94876521");
        testDataModel.addPhoneNumber("12378945");
        String target = "12378945";
        int test = testDataModel.findPhoneNumberIndex(target);
        int expected = 3;
        Assert.assertEquals(expected, test);
    }

    @Test
    public void testUpdatePhoneNo() throws SMSDataModel_PhoneException {
        // This is the bug method to be fixed
    }

    @Test
    public void testGetPhoneNumber() throws SMSDataModel_PhoneException, SMSDataModel_IndexException {
        SMSDataModelArray testDataModel = new SMSDataModelArray();
        testDataModel.addPhoneNumber("87654321");
        testDataModel.addPhoneNumber("23456789");
        testDataModel.addPhoneNumber("94876521");
        String expected = "23456789";
        String test = testDataModel.getPhoneNumber(1);
        Assert.assertEquals(expected, test);

    }

    @Test
    public void testDeleteNumber() throws SMSDataModel_PhoneException, SMSDataModel_IndexException {
        SMSDataModelArray testDataModel = new SMSDataModelArray();
        testDataModel.addPhoneNumber("87654321");
        testDataModel.addPhoneNumber("23456789");
        testDataModel.addPhoneNumber("94876521");
        String deletedNumber = "23456789";
        String test = testDataModel.deleteNumber(1);
        Assert.assertEquals(deletedNumber, test);

    }

}
