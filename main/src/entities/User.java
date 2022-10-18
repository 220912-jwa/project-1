package entities;

public class User {

    private int id;
    private boolean isManager;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int managerID;
    private int pending;
    private int awarded;

    public User() {

    }

    public User(int id, String username, String password, String firstName, String lastName,
                 int managerID, boolean iM, int pending, int awarded) {
        //gonna need to set user manually cause daos
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.managerID = managerID;
        this.isManager = iM;
        this.pending = pending;
        this.awarded = awarded;
    }

    public int getManager(){ return managerID; }
    public void setManager(int m){ this.managerID = m;}

    public int getPending(){ return pending; }
    public void setPending(int p){ this.pending = p; }
    public void changePending(int change){
        this.pending += change;
    }

    public int getAwarded(){ return awarded; }
    public void setAwarded(int a){ this.awarded = a;}
    public void changeAwarded(int change){
        this.awarded += change;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Boolean getIsManager(){ return this.isManager; }

    public void setIsManager(boolean im){ this.isManager = im; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", manager id='");

        if(managerID != 0){
            sb.append(managerID + '\'');
        }else{
            sb.append("no manager set + '\'");
        }
        sb.append(", reimbursement awarded='" + awarded + '\'' +
                ", reimbursement pending='" + pending + '\'' +
                '}');

        return sb.toString();
    }
}
