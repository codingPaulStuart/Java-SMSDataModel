package SMSDataModelling;

public class SMSDataModel_IndexException extends Exception {

    public SMSDataModel_IndexException(int index) {
        super("Index = " + index + ", is out of Range or Max Limit Reached");
    }

}




