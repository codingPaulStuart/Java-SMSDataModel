// Updated Version of SMSDataModelling using List instead of Array
// Author - Paul Stuart
// 5JAM GroupSMS Assessment Part 2
// May 2021

package SMSDataModelling;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class SMSDataModelList implements Serializable, SMSDataModelling_LIST_Interface {

    @Serial
    private static final long serialVersionUID = 1L;
    private String message;
    private ArrayList<String> phoneNumbersList = new ArrayList<String>();
    private int maxPhoneNumbers;
    private boolean setMaximum;

    // Constructor using the maxPhone Variable to pre-set the number of entries + message ---------------------------
    public SMSDataModelList(String message, int maxPhoneNumbers) {
        this.message = message;
        this.maxPhoneNumbers = maxPhoneNumbers;
        this.setMaximum = true;
    }

    // Constructor using the maxPhone Variable ONLY to pre-set the number of entries ---------------------------
    public SMSDataModelList(int maxPhoneNumbers) {
        this.maxPhoneNumbers = maxPhoneNumbers;
        this.setMaximum = true;
    }

    // Message only Constructor ---------------------------
    public SMSDataModelList(String message) {
        this.message = message;
    }

    // No-Args Constructor ---------------------------
    public SMSDataModelList() {
        this.message = "MESSAGE";
    }

    // --------------------------- New List<String> Functions for Manipulation of the Data --------------------------- //

    @Override
    public String addPhoneNumber(String newPhoneNumber) throws SMSDataModel_PhoneException {
        // Check if there is a limit set
        if (this.isMaxLimit()) {
            // Check if the limit has been reached
            if (this.maxPhoneNumbers == this.phoneNumbersList.size()) {
                throw new SMSDataModel_PhoneException(newPhoneNumber);
            } else {
                // Check if already exists
                boolean exists;
                exists = findPhoneNumberIndex(newPhoneNumber) != -1;
                if (exists) {
                    throw new SMSDataModel_PhoneException(newPhoneNumber);
                    // Otherwise Number can be added to ArrayList
                } else {
                    this.phoneNumbersList.add(newPhoneNumber);
                    return newPhoneNumber;
                }
            }
            // If no max Limit is set then check it doesn't already exist, otherwise add it
        } else {
            // Check if already exists
            boolean exists;
            exists = findPhoneNumberIndex(newPhoneNumber) != -1;
            if (exists) {
                throw new SMSDataModel_PhoneException(newPhoneNumber);
                // Otherwise Number can be added to ArrayList
            } else {
                this.phoneNumbersList.add(newPhoneNumber);
                return newPhoneNumber;
            }
        }

    }

    @Override
    public int findPhoneNumberIndex(String targetNumber) {
        if (this.phoneNumbersList.contains(targetNumber)) {
            return this.phoneNumbersList.indexOf(targetNumber);
        } else {
            return -1;
        }
    }

    @Override
    public void updatePhoneNumber(String newPhoneNumber, int i) throws SMSDataModel_IndexException {
        // Check that the index given is inside the current range first
        if (i < 0 || i > this.phoneNumbersList.size()) {
            throw new SMSDataModel_IndexException(i);
        } else {
            this.phoneNumbersList.set(i, newPhoneNumber);
        }
    }

    @Override
    public String getPhoneNumberByIndex(int i) throws SMSDataModel_IndexException {
        // Check that the index given is inside the current range first
        String found;
        if (i < 0 || i > this.phoneNumbersList.size()) {
            throw new SMSDataModel_IndexException(i);
        } else {
            found = this.phoneNumbersList.get(i);
            return found;
        }
    }

    @Override
    public void deleteNumberByIndex(int i) throws SMSDataModel_IndexException {
        // Check that the index given is inside the current range first
        if (i < 0 || i > this.phoneNumbersList.size()) {
            throw new SMSDataModel_IndexException(i);
        } else {
            String delete = this.phoneNumbersList.get(i);
            this.phoneNumbersList.remove(delete);
        }
    }

    @Override
    public void deleteNumberByString(String numDelete) throws SMSDataModel_PhoneException {
        // Check the number is in the arrayList First
        if (!this.phoneNumbersList.contains(numDelete)) {
            throw new SMSDataModel_PhoneException(numDelete);
        } else {
            this.phoneNumbersList.remove(numDelete);
        }
    }

    @Override
    public boolean isMaxLimit() {
        return this.setMaximum;
    }

    @Override
    public boolean setMaxLimit(boolean max) {
        this.setMaximum = max;
        return max;
    }

    @Override
    public int getMaxLimitNumberOfPhones() {
        return this.maxPhoneNumbers;
    }

    @Override
    public ArrayList<String> getPhoneNumbers() {
        return this.phoneNumbersList;
    }

    @Override
    public int getAmountOfNumbers() {
        int numberOfPhoneNum;
        numberOfPhoneNum = this.phoneNumbersList.size();
        return numberOfPhoneNum;
    }

    @Override
    public String getMessage() {
        String message;
        message = this.message;
        return message;
    }

    @Override
    public void setMessage(String mMessage) {
        this.message = mMessage;
    }

    @Override
    public void sortNumbers() {
        this.phoneNumbersList.sort(Comparator.naturalOrder());
    }

    @Override
    public String toString() {
        return "SMSDataModelList{" +
                "message='" + message + '\'' +
                ", phoneNumbersList=" + phoneNumbersList +
                ", maxPhoneNumbers=" + maxPhoneNumbers +
                '}';
    }
}
