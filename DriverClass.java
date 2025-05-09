import java.util.Scanner;
import java.util.InputMismatchException;
public class DriverClass {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String args[]) {
        DataBase db = new DataBase();
        boolean isIterate = true, ch = true;
        int choice = 0;
        while(isIterate) {
            if(ch) {
                showOptions();
                choice = getIntegerChoice();
            }
            switch(choice) {
                
                case 1:
                    db.insert();
                    System.out.print("\n-----> Want to insert another record (Yes / No) ? <----- ");
                    if(getBooleanChoice()) {
                        ch = false;
                        choice = 1;
                    }
                    else
                        ch = true;
                    break;
                    
                case 2:
                    db.show();
                    break;

                case 3:
                    System.out.println("\n-----> Enter Employee Code to show record. <----- ");
                    String code = takeCode();
                    db.show(code);
                    break;

                case 4:
                    if(db.getElementSize() > 0) {
                        System.out.print("\n-----> Enter Employee Code to update record <----- ");
                        String updateCode = takeCode();
                        System.out.println("\nUpdate Code : "+updateCode);
                        db.update(updateCode);
                        System.out.print("\n-----> Want to update another record (Yes / No) ? <----- ");
                        if(getBooleanChoice()) {
                            ch = false;
                            choice = 4;
                        }
                        else
                            ch = true;
                    }
                    else
                        System.out.println("\n-----> No Record in DataBase ! <-----");
                    break;

                case 5:
                    if(db.getElementSize() > 0) {
                        System.out.print("\n-----> Enter Employee Code to delete record <----- ");
                        String deleteCode = takeCode();
                        System.out.println("\nDelete Code :"+deleteCode);
                        db.delete(deleteCode);
                        if(db.getElementSize() > 0) {
                            System.out.print("\n-----> Want to delete another record (Yes / No) ? <----- ");
                            if(getBooleanChoice()) {
                                ch = false;   
                                choice = 5;
                            }
                            else
                                ch = true;
                        }
                    }
                    else
                        System.out.println("\n-----> No Record in DataBase ! <-----");
                    break;
                case 6:
                    isIterate = false;
            }
        }
        sc.close();
    }

    private static void showOptions() {
        System.out.println("\n+----+-------------------------+");
        System.out.println("| 1. | Insert New Record.      |");
        System.out.println("| 2. | Show All Records.       |");
        System.out.println("| 3. | Show Selected Records.  |");
        System.out.println("| 4. | Update Recored.         |");
        System.out.println("| 5. | Delete Record.          |");
        System.out.println("| 6. | Exit.                   |");
        System.out.println("+----+-------------------------+");
        System.out.print("----------> Enter Your Choice (1-6) <---------- ");
    }

    private static int getIntegerChoice() {
        int choice;
        try {
            choice = sc.nextInt();
            if(choice < 1 || choice > 6)
                throw new InputMismatchException();
        }
        catch(InputMismatchException ex) {
            sc.nextLine();
            System.out.print("-----> Enter valid choice ! <----- ");
            choice = getIntegerChoice();
        }
        return choice;
    }


    private static boolean getBooleanChoice() {
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
            System.out.println("-----> Enter valid choice ! <------");
            return getBooleanChoice();
        }
    }

    private static String takeCode() {
        String code = sc.next();
        sc.nextLine();
        return code;
    }
}
