// Updated Version of SMSDataModelling Interface using List instead of Array
// Author - Paul Stuart
// 5JAM GroupSMS Assessment Part 2
// May 2021

package SMSDataModelling;

import java.util.*;

public interface SMSDataModelling_LIST_Interface {

    public String addPhoneNumber(String newPhoneNumber) throws SMSDataModel_PhoneException;
    public int findPhoneNumberIndex(String targetNumber);
    public void updatePhoneNumber(String newPhoneNumber, int i) throws SMSDataModel_IndexException;
    public String getPhoneNumberByIndex(int i) throws SMSDataModel_IndexException;
    public void deleteNumberByIndex(int i) throws SMSDataModel_IndexException;
    public void deleteNumberByString(String numDelete) throws SMSDataModel_PhoneException;
    public boolean isMaxLimit();
    public boolean setMaxLimit(boolean max);
    public int getMaxLimitNumberOfPhones();
    public ArrayList<String> getPhoneNumbers();
    public int getAmountOfNumbers();
    public String getMessage();
    public void setMessage(String mMessage);
    public void sortNumbers();

}
