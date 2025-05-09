import java.util.Scanner;
import java.util.InputMismatchException;
class UpdateOperation extends InsertOperation {
    public void service(Employee emp) {
        boolean flg = false;
        System.out.print("\n-----> Want to update Code : "+emp.getCode()+" (Yes / No) ? <----- ");
        if(getChoice()) {
            flg = true;
            emp.setCode(fillCode());
        }
        System.out.print("\n-----> Want to update name : "+emp.getName()+" (Yes / No) ? <----- ");
        if(getChoice()) {
            flg = true;
            emp.setName(fillName());
        }
        System.out.print("\n-----> Want to update Address : "+emp.getAddress()+" (Yes / No) ? <----- ");
        if(getChoice()) {
            flg = true;
            emp.setAddress(fillAddress());
        }
        System.out.print("\n-----> Want to update Mobile Number : "+emp.getMobileNo()+" (Yes / No) ? <----- ");
        if(getChoice()) {
            flg = true;
            emp.setMobileNo(fillMobileNo());
        }
        System.out.print("\n-----> Want to update Email-Id : "+emp.getEmail()+" (Yes / No) ? <----- ");
        if(getChoice()) {
            flg = true;
            emp.setEmail(fillEmail());
        }
        System.out.print("\n-----> Want to update Gender : "+emp.getGender()+" (Yes / No) ? <----- ");
        if(getChoice()) {
            flg = true;
            emp.setGender(fillGender());
        }
        System.out.print("\n-----> Want to update Designation : "+emp.getDesignation()+" (Yes / No) ? <----- ");
        if(getChoice()) {
            flg = true;
            emp.setDesignation(fillDesignation());
        }
        System.out.print("\n-----> Want to update Date of Birth : "+emp.getDateOfBirth()+" (Yes / No) ? <----- ");
        if(getChoice()) {
            flg = true;
            emp.setDateOfBirth(fillDateOfBirth());
        }
        System.out.print("\n-----> Want to update Is Active value : "+emp.getIsActive()+" (Yes / No) ? <----- ");
        if(getChoice()) {
            flg = true;
            emp.setIsActive(fillIsActive());
        }
        if(flg)
            System.out.println("\n--------> Record Updated <--------");
    }

    private boolean getChoice() {
        Scanner sc = new Scanner(System.in);
        String choice;
        try {
            choice = sc.next();
            sc.nextLine();
            if(!(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("no")))
                throw new InputMismatchException();
            else
            {
                if(choice.equalsIgnoreCase("yes"))
                    return true;
                else
                    return false;
            }
        }
        catch(InputMismatchException ex) {
            sc.nextLine();
            System.out.println("Enter valid choice !\n");
            return getChoice();
        }
        
    }
}