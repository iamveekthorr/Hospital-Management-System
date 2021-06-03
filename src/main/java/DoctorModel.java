import org.mindrot.jbcrypt.BCrypt;

public class DoctorModel {
    String password;
    String firstName, lastName;
    int phoneNumber;
    int age, id;

    DoctorModel(){

    }
    DoctorModel(int id){
        setId(id);
    }


    DoctorModel(int id, int age, int phoneNumber,
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void setPassword(String password) {
        // salt of 12
        this.password = BCrypt.hashpw(password, BCrypt.gensalt(12));
    }


}
