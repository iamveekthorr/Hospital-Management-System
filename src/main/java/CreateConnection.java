import java.sql.*;

public class CreateConnection {
    static final String URL_STRING = "jdbc:mysql://localhost:3306/hospitaldb";
    // Time Zone for mysql to work properly
    static final String TIMEZONE = "?useUnicode=true&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static String PASSWORD;
    static final String USER = "root";
    static java.sql.Connection conn;

    public static String getUrlString() {
        return URL_STRING;
    }

    public static String getTIMEZONE() {
        return TIMEZONE;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static void setPASSWORD(String PASSWORD) {
        CreateConnection.PASSWORD = PASSWORD;
    }

    public static String getUSER() {
        return USER;
    }

    public static Connection getConn() {
        return conn;
    }

    public static void setConn(Connection conn) {
        CreateConnection.conn = conn;
    }

    // Create Tables When Program begins execution
    // if table exists then it doesn't create it anymore
    CreateConnection(){
        setPASSWORD("They-Say-The-JokerIs-a-Wanted-Man");
        try{
            setConn(DriverManager.getConnection(getUrlString().concat(getTIMEZONE()), getUSER(), getPASSWORD()));
            Connection dbConnection = getConn();
            String createPatientTableStatement = PatientQueries.createPatientTable();
            String createDoctorsTableStatement = DoctorQueries.createDoctorTable();
            PreparedStatement createDoctorsTable = dbConnection.prepareStatement(createDoctorsTableStatement);
            PreparedStatement createPatientsTable = dbConnection.prepareStatement(createPatientTableStatement);
            createDoctorsTable.execute();
            createPatientsTable.execute();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
}
