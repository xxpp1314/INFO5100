import java.util.Enumeration;
import java.util.Scanner;
import java.util.Random;


public class Email {

    private String firstName;
    private String lastName;
    private String departmentCode;
    private StringBuilder emailAddress;
    private String alternativeEmail;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String companySuffix = "aeycompany.com";

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.print("New Worker: " + firstName + " " + lastName +". ");
        this.departmentCode = SetDepartment();
        emailAddress = new StringBuilder(firstName.toLowerCase() + "." + lastName.toLowerCase() + "@");
        if(!this.departmentCode.equals(""))
            emailAddress.append(this.departmentCode + ".");
        emailAddress.append(companySuffix);
    }

    // Ask for the department
    private String SetDepartment() {
        System.out.println("Department Codes:\n"
                + "1 for Sales\n"
                + "2 for Development\n"
                + "3 for Accounting\n"
                + "0 for none\n"
                + "Enter department code:");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        switch(num){
            case 1:
                return "sal";
            case 2:
                return "dev";
            case 3:
                return "acc";

            case 0:
                return "";
        }
        return "";
    }

    public void setDefaultPasswordLength(int defaultPasswordLength){
        this.defaultPasswordLength = defaultPasswordLength;
    }

    public void changePassword(int defaultPasswordLength){
        randomPassword(defaultPasswordLength);
    }

    public void setMailboxCapacity(int mailboxCapacity){
        this.mailboxCapacity = mailboxCapacity;
    }

    public void setCompanySuffix(String companySuffix){
        this.companySuffix = companySuffix;
    }

    public void setAlternativeEmail(String alternativeEmail){
        this.alternativeEmail = alternativeEmail;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public int getMailboxCapacity(){
        return mailboxCapacity;
    }

    // Generate a random password
    private String randomPassword(int length) {
        final int maxNum = 41;
        int i;
        int count = 0;
        char[] str = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
                'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3',
                '4', '5', '6', '7', '8', '9', '!', '@', '#', '$', '%'};
        StringBuffer pwd = new StringBuffer("");
        Random r = new Random();
        while (count < length) {
            i = Math.abs(r.nextInt(maxNum));
            if (i >= 0 && i < str.length) {
                pwd.append(str[i]);
                count++;
            }
        }
        return pwd.toString();
    }

    public String showInfo(){
        StringBuilder print = new StringBuilder();
        print.append("DISPLAY NAME: " + getFirstName() + " " + getLastName() + "\n");
        print.append("DEPARTMENT: " + departmentCode + "\n");
        print.append("COMPANY EMAIL: " + emailAddress + "\n");
        print.append("PASSWORD: " + randomPassword(defaultPasswordLength) + "\n");
        print.append("MAILBOX CAPACITY: " + getMailboxCapacity() + "mb\n");
        return print.toString();
    }
}
//Output:
//New Worker: John Smith. Department Codes:
//        1 for Sales
//        2 for Development
//        3 for Accounting
//        0 for none
//        Enter department code:
//        2
//        DISPLAY NAME: John Smith
//        DEPARTMENT: dev
//        COMPANY EMAIL: john.smith@dev.aeycompany.com
//        PASSWORD: 76G0Y4BXOJ
//        MAILBOX CAPACITY: 500mb
