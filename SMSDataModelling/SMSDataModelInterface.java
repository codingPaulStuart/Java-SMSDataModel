package SMSDataModelling;

public interface SMSDataModelInterface {


    public void addPhoneNumber(String newPhoneNumber) throws SMSDataModel_PhoneException;
    public int findPhoneNumberIndex(String targetNumber);
    public String updatePhoneNumber(String newPhoneNumber, int i) throws SMSDataModel_PhoneException, SMSDataModel_IndexException;
    public String getPhoneNumber(int i) throws SMSDataModel_IndexException;
    public String deleteNumber(int i) throws SMSDataModel_IndexException;
    public boolean isFull();
    public String[] getPhoneNumbers();
    public int getNumPhoneNumbers();
    public String getMessage();
    public void setMessage(String mMessage);

}
