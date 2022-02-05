package SMSDataModelling;

public class SMSDataModel_PhoneException extends Exception {

    public SMSDataModel_PhoneException(String thePhoneNumber) {
        super(thePhoneNumber + " Does not exist or you could be adding a pre-existing number");
    }

}
