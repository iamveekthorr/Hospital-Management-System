import org.mindrot.jbcrypt.BCrypt;

public class DoctorModel {
    String password, firstName, lastName, phoneNumber, age;
    int id;

    DoctorModel(){

    }
    DoctorModel(int id){
        setId(id);
    }


    DoctorModel(int id, String age, String phoneNumber,
                 String firstName, String lastName, String password){
        setAge(age);
        setFirstName(firstName);
        setLastName(lastName);
        setId(id);
        setPhoneNumber(phoneNumber);
        setPassword(password);
    }

    public String getPassword() {
        return password;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public void setPassword(String password) {
        // salt of 12
        this.password = password;
        System.out.println("password is" + password);
    }


}
