import java.util.Scanner;
import java.util.InputMismatchException;
import java.time.LocalDate;
import java.time.DateTimeException;

class InsertOperation {
    
    // private Employee emp;
    private static int id = 0;

    public InsertOperation() {
        // emp = new Employee();
    }
    
    public Employee service() {
        Employee emp = new Employee();
        emp.setId(++id);
        emp.setCode(fillCode());
        emp.setName(fillName());
        emp.setAddress(fillAddress());
        emp.setMobileNo(fillMobileNo());
        emp.setEmail(fillEmail());
        emp.setGender(fillGender());
        emp.setDesignation(fillDesignation());
        emp.setDateOfBirth(fillDateOfBirth());
        emp.setIsActive(fillIsActive());
        return emp;
    }

    protected String fillCode() {
        Scanner sc = new Scanner(System.in);
        String code;
        boolean flg;
        System.out.println("\nEnter Code (A-Z / 0-9 & Maximun 15 Character).");
        do {
            code = sc.next();
            flg = codeValidation(code);
            sc.nextLine();
        } while(!flg);
        return code;
    }

    private boolean codeValidation(String code) {
        int len = code.length();
        if(len > 15) {
            System.out.println("\nEnter valid Code !");
            return false;
        }
        for(int i = 0; i < len; i++) {
            char ch = code.charAt(i);
            if((ch < 65 || ch > 90) && (ch < 48 || ch > 57)) {
                System.out.println("\nEnter valid Code !");
                return false;
            }
        }
        return true;
    }

    protected String fillName() {
        Scanner sc = new Scanner(System.in);
        String name = null;
        boolean flg;
        System.out.println("\nEnter Name (A-Z / a-z Minimum Character 3 & Maximum Character 25).");
        do {
            name = sc.nextLine();
            flg = nameValidation(name);
        } while(!flg);
        return name;
    }

    private boolean nameValidation(String name) {
        int len = name.length();
        if(len < 3 || len > 25) {
            System.out.println("\nEnter valid name !");
            return false;
        }
        String str = name.toUpperCase();
        for(int i=0; i < len; i++) {
            char ch = str.charAt(i);
            if((ch < 65 || ch > 90) && ch != ' ') {
                System.out.println("\nEnter valid name !");
                return false;
            }
        }
        return true;
    }

    protected String fillAddress() {
        String address = null;
        boolean flg;
        System.out.println("\nEnter Address.");
        Scanner sc = new Scanner(System.in);
        do {
            address = sc.nextLine();
            address = address.trim();
            flg = addressValidation(address);
        } while(!flg);
        return address;
    }

    private boolean addressValidation(String address) {
        if(address.length()==0)
            return false;
        return true;
    }

    protected String fillMobileNo() {
        Scanner sc = new Scanner(System.in);
        String mobileNo = null;
        boolean flg;
        System.out.println("\nEnter Mobile Number.");
        do {
            mobileNo = sc.next();
            flg = mobileValidation(mobileNo);
            sc.nextLine();
        } while(!flg);
        return mobileNo;
    }

    private boolean mobileValidation(String mobileNo) {
        int len = mobileNo.length();
        if(len != 10) {
            System.out.println("\nEnter valid mobile number !");
            return false;
        }
        for(int i = 0; i < len; i++) {
            char ch = mobileNo.charAt(i);
            if(ch < 48 || ch > 57) {
                System.out.println("\nEnter vaid mobile number !");
                return false;
            }
        }
        return true;
    }

    protected String fillEmail() {
        Scanner sc = new Scanner(System.in);
        String email;
        boolean flg;
        System.out.println("\nEnter Email-Id (Valid Characters : a-z / - / 0-9).");
        do {
            email = sc.next();
            flg = emailValidation(email);
            sc.nextLine();
        }while(!flg);
        return email;
    }

    private boolean emailValidation(String email) {
        try {
            if(email.length() > 40)
                throw new StringIndexOutOfBoundsException();
            String userName = email.substring(0,email.indexOf('@'));
            String domainName = email.substring(email.indexOf('@'));
            if(!(userNameValidation(userName) && domainNameValidation(domainName))) {
                System.out.println("\nEnter valid email-id !");
                return false;
            }
        }
        catch(StringIndexOutOfBoundsException ex) {
            System.out.println("\nEnter valid Email-id !");
            return false;
        }
        return true;
    }

    private boolean domainNameValidation(String domainName) {
        if(!(domainName.contains("@gmail.com") || domainName.contains("@yahoo.com") || domainName.contains("@outlook.com")))
            return false;
        return true;
    }

    private boolean userNameValidation(String userName) {
        int len = userName.length();
        if(userName.contains("..") || userName.contains("--"))
            return false;
        for(int i = 0; i < len; i++) {
            char ch = userName.charAt(i);
            if((ch < 97 || ch > 122) && (ch < 45 || ch > 57))
                return false;
        }
        return true;
    }

    protected String fillGender() {
        String gender;
        boolean flg;
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Gender (Male / Female).");
        do {
            gender = sc.next();
            gender = gender.toUpperCase();
            flg = genderValidation(gender);
            sc.nextLine();
        } while(!flg);
        return gender;
    }   

    private boolean genderValidation(String gender) {
        if(!(gender.equals("MALE") || gender.equals("FEMALE"))) {
            System.out.println("\nEnter valid gender !");
            return false;
        }
        return true;
    }

    protected String fillDesignation() {
        String designation;
        boolean flg;
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Designation (Manager/Senior-Developer/Junior-Developer).");
        do {
            designation = sc.next();
            designation = designation.toUpperCase();
            flg = designationValidation(designation);
            sc.nextLine();
        }while(!flg);
        return designation;
    }

    private boolean designationValidation(String designation) {
        if(!(designation.equals("MANAGER") || designation.equals("SENIOR-DEVELOPER") || designation.equals("JUNIOR-DEVELOPER"))) {
            System.out.println("\nEnter valid designation !");
            return false;
        }
        return true;
    }

    protected LocalDate fillDateOfBirth() {
        String dob;
        LocalDate DateOfBirth = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Date Of Birth.(DD-MM-YYYY)");
        do {
            dob = sc.next();
            DateOfBirth = dateOfBirthValidation(dob);
            sc.nextLine();
        } while(DateOfBirth == null);
        return DateOfBirth;
    }

    
    private LocalDate dateOfBirthValidation(String dob) {
        LocalDate DateOfBirth = null;
        if(dob.length() != 10) {
            System.out.println("\nEnter valid date of birth !");
            return null;
        }
        if(!(dob.charAt(2)=='-' || dob.charAt(5)=='-')) {
            System.out.println("\nEnter valid date of birth !");
            return null;
        }
        try {
            int day = Integer.parseInt(dob.substring(0,2));
            int month = Integer.parseInt(dob.substring(3,5));
            int year = Integer.parseInt(dob.substring(6));
            DateOfBirth = LocalDate.of(year,month,day);
        }
        catch(NumberFormatException ex) {
            System.out.println("\nEnter valid date of birth !");
            return null;
        }
        catch(DateTimeException ex) {
            System.out.println("\nEnter valid Date of birth !");
            return null;
        }
        return DateOfBirth;
    }

    protected boolean fillIsActive() {
        boolean isActive;
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter 'True' OR 'False' for Is Active field.");
        try {
            isActive = sc.nextBoolean();
            sc.nextLine();
        }
        catch(InputMismatchException ex) {
            sc.nextLine();
            System.out.println("\nEnter valid value !");
            isActive =  fillIsActive();
        }
        return isActive;
    }

}