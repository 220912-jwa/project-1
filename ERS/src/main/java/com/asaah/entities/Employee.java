package com.asaah.entities;


public class Employee extends User{

      private int id;
      private String username;
      private String password;
      private String firstName;
        private String lastName;
    private String isManager;
    int availableReimbursement;

    public Employee() {

    }

    public Employee(int id, String username, String password, String firstName, String lastName, String isManager,
                    int availableReimbursement) {
//        super(id, username, password, firstName, lastName);

        this.id = id;
          this.username = username;
          this.password = password;
          this.firstName = firstName;
          this.lastName = lastName;
        this.isManager = isManager;
        this.availableReimbursement = availableReimbursement;
    }
    public Employee (int id, String username, String password, String firstName, String lastName, String isManager) {
        super(id, username, password, firstName, lastName);
        this.id = id;
          this.username = username;
          this.password = password;
          this.firstName = firstName;
          this.lastName = lastName;
          this.isManager = isManager;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getIsManager() {
        return isManager;
    }

    public void setIsManager(String isManager) {
        this.isManager = isManager;
    }

    public int getAvailableReimbursement() {
        return availableReimbursement;
    }

    public void setAvailableReimbursement(int availableReimbursement) {
        this.availableReimbursement = availableReimbursement;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + this.getId() +
                ", username='" + this.getUsername() + '\'' +
                ", password='" + this.getPassword() + '\'' +
                ", firstName='" + this.getFirstName() + '\'' +
                ", lastName='" + this.getLastName() + '\'' +
                ", isManager='" + this.getIsManager() + '\'' +
                ", availableReimbursement=" + availableReimbursement +
                '}';

    }


}
