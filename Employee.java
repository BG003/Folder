import java.time.LocalDate;
public class Employee {

    private int id;
    private String code;
    private String name, address, mobileNo, email, gender, designation;
    private LocalDate dob;
    private boolean isActive;

    // Setters.

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setDateOfBirth(LocalDate dob) {
        this.dob = dob;
    } 

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    // Getter.
    
    public int getId() {
        return this.id;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getMobileNo() {
        return this.mobileNo;
    }

    public String getEmail() {
        return this.email;
    }

    public String getGender() {
        return this.gender;
    }

    public String getDesignation() {
        return this.designation;
    }

    public LocalDate getDateOfBirth() { 
        return this.dob;
    }

    public boolean getIsActive() {
        return this.isActive;
    }
}
