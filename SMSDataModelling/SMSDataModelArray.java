package SMSDataModelling;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;

public class SMSDataModelArray implements SMSDataModelInterface, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private static final int DEFAULT_MAX_NUM_PHONE_NUMBERS = 20;
    public static final String FULL = "FULL";
    public static final String DUPLICATE = "DUPLICATE";

    private String message;			//The SMS message
    private String[] phoneNumbers;	//The collection of phone numbers
    private int numPhoneNumbers;	//How many phone numbers there are

    public SMSDataModelArray(String message) {
        this(message, DEFAULT_MAX_NUM_PHONE_NUMBERS);
    }

    public SMSDataModelArray() {
        this("", DEFAULT_MAX_NUM_PHONE_NUMBERS);
    }

    public SMSDataModelArray(String initialMessage, int maxNumPhoneNumbers) {
        this.message = initialMessage;
        this.phoneNumbers = new String[maxNumPhoneNumbers];
        this.numPhoneNumbers = 0;
    }


    public void addPhoneNumber(String newPhoneNumber) throws SMSDataModel_PhoneException {
        String result;

        if (numPhoneNumbers == phoneNumbers.length)
            throw new SMSDataModel_PhoneException(newPhoneNumber);
        else {
            boolean exists;
            exists = findPhoneNumberIndex(newPhoneNumber) != -1;
            if (exists) {
                throw new SMSDataModel_PhoneException(newPhoneNumber);
            } else {
                phoneNumbers[numPhoneNumbers] = newPhoneNumber;
                numPhoneNumbers++;
                result = newPhoneNumber;
            }
        }
    }

    public int findPhoneNumberIndex(String targetNumber) {
        int i = 0;
        for (i = 0; i < this.numPhoneNumbers; i++) {
            if (this.phoneNumbers[i].equals(targetNumber)) {
                return i;
            }
        }
        return -1;
    }


    public String updatePhoneNumber(String newPhoneNumber, int i) throws SMSDataModel_IndexException {
        String result;

        if (i < 0 || i >= numPhoneNumbers)
            throw new SMSDataModel_IndexException(i);
        else {
            result = phoneNumbers[i];
            phoneNumbers[i] = newPhoneNumber;
        }
        return result;
    }

    public String getPhoneNumber(int i) throws SMSDataModel_IndexException {
        String result;

        if (i < 0 || i >= numPhoneNumbers)
            throw new SMSDataModel_IndexException(i);
        else {
            result = phoneNumbers[i];
        }
        return result;
    }

    public String deleteNumber(int i) throws SMSDataModel_IndexException {
        String result;
        if (i < 0 || i >= numPhoneNumbers)
            throw new SMSDataModel_IndexException(i);
        else {
            result = phoneNumbers[i];
            if (i != this.numPhoneNumbers - 1) {
                System.arraycopy(phoneNumbers, i + 1, phoneNumbers, i,this.numPhoneNumbers - i - 1);
            }
            this.numPhoneNumbers--;
        }
        return result;
    }

    public int getMaxNumPhoneNumbers() {
        return this.phoneNumbers.length;
    }

    public boolean isFull() {
        return this.numPhoneNumbers == this.phoneNumbers.length;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String mMessage) {
        this.message = mMessage;
    }

    public String[] getPhoneNumbers() {
        return phoneNumbers;
    }

    public int getNumPhoneNumbers() {
        return numPhoneNumbers;
    }

    @Override
    public String toString() {
        return "SMSDataModel [message=" + message + ", phoneNumbers="
                + Arrays.toString(phoneNumbers) + ", numPhoneNumbers="
                + numPhoneNumbers + "]";
    }


}
