package Users;

import Employee.City;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import javax.sound.midi.Sequence;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")

public class Users {
    @Id
    @Column (name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreationTimestamp
    @Column (name = "date_time_of_creation", updatable = false)
    private Instant creationTime;

    @UpdateTimestamp
    @Column (name = "date_and_time_of_modification")
    private Instant modificationTime;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="users_roles",
            joinColumns = @JoinColumn (name = "user_id"),
            inverseJoinColumns = @JoinColumn (name = "role_id")
 )
    private Set<Roles> roles = new HashSet<>();

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    @Column (name = "user_name")
    private String userName;

    @Column (name = "user_login")
    private String userLogin;

    @Column (name= "user_password")
    private String userPassword;


    public Users () {
    }

    public Users(String userName, String userLogin, String userPassword) {
        this.userName = userName;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.creationTime= Instant.now();
        this.modificationTime = Instant.now();
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
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Instant getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Instant creationTime) {
        this.creationTime = creationTime;
    }

    public Instant getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(Instant modificationTime) {
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

}
