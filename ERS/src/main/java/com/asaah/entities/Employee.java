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
        super(id, username, password, firstName, lastName);

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
