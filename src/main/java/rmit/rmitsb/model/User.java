package rmit.rmitsb.model;



import javax.persistence.*;

@Entity
@Table(name = "admin", uniqueConstraints = {@UniqueConstraint(columnNames = {"adminId"})})
public class User {
    @SequenceGenerator(
            name = "user_sequence_generator",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;
    @Column
    private String adminName;
    @Column
    private String adminPass;

    public User(Long adminId, String adminName, String adminPass) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPass = adminPass;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }

    public User(){

    }


}