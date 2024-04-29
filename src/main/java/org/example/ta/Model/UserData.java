package org.example.ta.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserData {

    @Id
    private String firstName;
    private String lastName;
    private String middleName;
    private String gender;
    private String phoneNumber;
    private String z_value;
    private String email;
    private String dateOfBirth;
    private String courses;
    private String previouslyTa;
    private String taStartDate;
    private String taEndDate;
    private String resume;
    private String gpa;
    private String status1;
    private String assignTask;
    private String assignTaskDone;
    private String status2;
    private String status3;
    private String commentedByInstructor;
    private String selectedOrRejected;
    private String acceptOrRejectOffer;

    @Override
    public String toString() {
        return "UserData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", zValue='" + z_value + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", courses='" + courses + '\'' +
                ", previouslyTa='" + previouslyTa + '\'' +
                ", taStartDate='" + taStartDate + '\'' +
                ", taEndDate='" + taEndDate + '\'' +
                ", resume='" + resume + '\'' +
                ", gpa='" + gpa + '\'' +
                ", status1='" + status1 + '\'' +
                ", assignTask='" + assignTask + '\'' +
                ", assignTaskDone='" + assignTaskDone + '\'' +
                ", status2='" + status2 + '\'' +
                ", status3='" + status3 + '\'' +
                ", commentedByInstructor='" + commentedByInstructor + '\'' +
                ", selectedOrRejected='" + selectedOrRejected + '\'' +
                ", acceptOrRejectOffer='" + acceptOrRejectOffer + '\'' +
                '}';
    }
}
