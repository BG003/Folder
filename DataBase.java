import java.util.ArrayList;
public class DataBase {

    private ArrayList<Employee> empList;
    private InsertOperation insertOper;
    private UpdateOperation updateOper;
    private RetrieveOperation retrieveOper;
    
    public DataBase() {
        empList = new ArrayList<>();
        insertOper = new InsertOperation();
        updateOper = new UpdateOperation();
        retrieveOper = new RetrieveOperation();
    }

    public void insert() {
        empList.add(insertOper.service());
        System.out.println("\n-----> Recored Inserted  <-----");
    }

    public void update(String code) {
        int index = isElement(code);
        if(index > -1) {
            updateOper.service(empList.get(index));
        }
        else
            System.out.println("-----> No Record found with code : "+code+" ! <-----");
    }

    public void delete(String code) {
        int index = isElement(code);
        if(index > -1) {
            empList.remove(index);
            System.out.println("\n-----> Record Deleted <-----");
        }
        else
            System.out.println("\n-----> No Record Found with Code : "+code+" ! <-----");
    }

    public void show() {
        int len = getElementSize();
        for(int i = 0; i < len; i++) 
            retrieveOper.service(empList.get(i),i+1);
        System.out.println("\n-----> All Records Displayed | Total Records : "+getElementSize()+" <-----");
    }

    public void show(String code) {
        if(getElementSize() > 0) {
            int index = isElement(code);
            if(index > -1) {
                retrieveOper.service(empList.get(index),1);
            }
            else
                System.out.println("\n-----> No Record Found with Code : "+code+" ! <-----");
            
        }
        else
            System.out.println("\n-----> No Record in DataBase ! <-----");
    }

    
/*
    ("+----------------------------+-------------------------------------------------------+");
    ("| Record Number..............| "+empList.size()+"                                    |");
    ("+----------------------------+-------------------------------------------------------+");
    ("| Employee ID................| "+empList.getId()+"                                   |");
    ("| Employee Code..............| "+empList.getCode()+"                                 |");
    ("| Employee Name..............| "+empList.getName()+"                                 |");
    ("| Employee Address...........| "+empList.getAddress()+"                              |");
    ("| Employee Mobile Number.....| "+empList.getMobileNo()+"                             |");
    ("| Employee Emaid ID..........| "+empList.getEmail()+"                                |");
    ("| Employee Gender............| "+empList.getGender()+"                               |");
    ("| Employee Designation.......| "+empList.getDesignation()+"                          |");
    ("| Employee Date Of Birth.....| "+empList.getDateOfBirth()+"                          |");
    ("| Is Employee Active ?.......| "+empList.getIsActive()+"                             |");
    ("+----------------------------+-------------------------------------------------------+");

    */

    public int getElementSize() {
        return empList.size();
    }

    private int isElement(String code) {
        int len = empList.size();
        for(int i = 0; i < len; i++) {
            if(empList.get(i).getCode().equals(code))
                return i;
        }
        return -1;
    }

}
