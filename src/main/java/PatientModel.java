import org.jetbrains.annotations.NotNull;
import org.mindrot.jbcrypt.BCrypt;

public class PatientModel {
    String firstName, lastName, nextOfKinName;
    int phoneNumber;
    int nextOfKinPhoneNumber;
    int age, uniqueID;

    PatientModel(){

    }

    PatientModel(int id){
        setId(id);
    }

    // This is for authenticating a user
    PatientModel(String name, String password, String hashedPassword) {
        setFirstName(name);
        if(!name.isEmpty() || !name.isBlank()){
            BCrypt.checkpw(password, hashedPassword);
        }
    }

    /**
     * @param id
     * @param age
     * @param phoneNumber
     * @param nextOfKinPhoneNumber
     * @param firstName
     * @param lastName
     * @param nextOfKinName
     * */
    PatientModel(@NotNull int id,int age, int phoneNumber, int nextOfKinPhoneNumber,
                 String firstName, String lastName, String nextOfKinName ){
        setAge(age);
        setFirstName(firstName);
        setLastName(lastName);
        setId(id);
        setNextOfKinName(nextOfKinName);
        setNextOfKinPhoneNumber(nextOfKinPhoneNumber);
        setPhoneNumber(phoneNumber);
    }



    public int getUniqueID() {
        return uniqueID;
    }

    public void setId(int id) {
        this.uniqueID = id;
    }


    public String getFirstName() {
        return firstName;
    }
    /**
     * @param firstName
     * */
    public void setFirstName(@NotNull String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNextOfKinName() {
        return nextOfKinName;
    }

    public void setNextOfKinName(String nextOfKinName) {
        this.nextOfKinName = nextOfKinName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getNextOfKinPhoneNumber() {
        return nextOfKinPhoneNumber;
    }

    public void setNextOfKinPhoneNumber(int nextOfKinPhoneNumber) {
        this.nextOfKinPhoneNumber = nextOfKinPhoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    int generateID(){
        return (int) Math.floor(Math.random() * (50 + 10000000) * 50);
    }

}
