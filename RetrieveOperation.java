public class RetrieveOperation {

    public void service(Employee e,int n) {
        displayAsTable(e, n);
    }

    private void displayAsTable(Employee e,int n) {
        System.out.println();
        printLeft("-");
        printRight("-");
        printLeft("Record Number");
        printRight(String.valueOf(n));
        printLeft("-");
        printRight("-");
        printLeft("Employee ID");
        printRight(String.valueOf(e.getId()));
        printLeft("Employee Code");
        printRight(e.getCode());
        printLeft("Employee Name");
        printRight(e.getName());
        printLeft("Employee Address");
        printRight(e.getAddress());
        printLeft("Employee Mobile Number");
        printRight(e.getMobileNo());
        printLeft("Employee Email-ID");
        printRight(e.getEmail());
        printLeft("Employee Gender");
        printRight(e.getGender());
        printLeft("Employee Designation");
        printRight(e.getDesignation());
        printLeft("Employee Date Of Birth");
        printRight(e.getDateOfBirth().toString());
        printLeft("Is Employee Activer ?");
        printRight(String.valueOf(e.getIsActive()));
        printLeft("-");
        printRight("-");
        System.out.println();
    }

    private void printLeft(String str) {
        if(str.equals("-")) {
            System.out.print("+");
            for(int i = 1; i < 28; i++) 
                System.out.print("-");
            System.out.print("+");
        }
        else
        {
            System.out.print("| "+str);
            int len = 27 - str.length();
            for(int i = 1; i < len; i++)
                System.out.print(".");
            System.out.print("| ");
        }
    }

    private void printRight(String str) {
        if(str.equals("-")) {
            for(int i = 1; i < 101; i++)
                System.out.print(str);
            System.out.print("+\n");
        }
        else
        {
            System.out.print(str);
            int len = 99 - str.length();
            for(int i = 1; i <= len; i++) {
                System.out.print(" ");
            }
            System.out.println("|");
        }
    }
}
