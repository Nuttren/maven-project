package Users;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")

public class Users {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "user_id")
    private UUID id;

    @Column (name = "date_time_of_creation")
    private LocalDateTime creationTime;

    @Column (name = "date_and_time_of_modification")
    private LocalDateTime modificationTime;

    @Column (name = "user_name")
    private String userName;

    @Column (name = "user_login")
    private String userLogin;

    @Column (name= "user_password")
    private String userPassword;

    @Column (name = "role_analyst")
    private boolean roleAnalyst;

    @Column (name = "role_designer")
    private boolean roleDesigner;

    @Column (name = "role_developer")
    private boolean roleDeveloper;

    @Column (name = "role_qa")
    private boolean roleQA;

    @Column (name = "role_manager")
    private boolean roleManager;

    @Column (name = "role_default")
    private boolean roleDefault;

    public Users () {
    }

    public Users(String userName, String userLogin, String userPassword) {
        this.id = UUID.randomUUID();
        this.userName = userName;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.creationTime= LocalDateTime.now();
        this.modificationTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", creationTime=" + creationTime +
                ", modificationTime=" + modificationTime +
                ", userName='" + userName + '\'' +
                ", userLogin='" + userLogin + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", roleAnalyst=" + roleAnalyst +
                ", roleDesigner=" + roleDesigner +
                ", roleDeveloper=" + roleDeveloper +
                ", roleQA=" + roleQA +
                ", roleManager=" + roleManager +
                ", roleDefault=" + roleDefault +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public LocalDateTime getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(LocalDateTime modificationTime) {
        this.modificationTime = modificationTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public boolean isRoleAnalyst() {
        return roleAnalyst;
    }

    public void setRoleAnalyst(boolean roleAnalyst) {
        this.roleAnalyst = roleAnalyst;
    }

    public boolean isRoleDesigner() {
        return roleDesigner;
    }

    public void setRoleDesigner(boolean roleDesigner) {
        this.roleDesigner = roleDesigner;
    }

    public boolean isRoleDeveloper() {
        return roleDeveloper;
    }

    public void setRoleDeveloper(boolean roleDeveloper) {
        this.roleDeveloper = roleDeveloper;
    }

    public boolean isRoleQA() {
        return roleQA;
    }

    public void setRoleQA(boolean roleQA) {
        this.roleQA = roleQA;
    }

    public boolean isRoleManager() {
        return roleManager;
    }

    public void setRoleManager(boolean roleManager) {
        this.roleManager = roleManager;
    }

    public boolean isRoleDefault() {
        return roleDefault;
    }

    public void setRoleDefault(boolean roleDefault) {
        this.roleDefault = roleDefault;
    }
}
