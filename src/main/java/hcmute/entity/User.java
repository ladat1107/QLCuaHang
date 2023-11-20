package hcmute.entity;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
@Table(name="user")
@NamedQuery(name="User.login", query="SELECT u from User u where u.userName = :username and u.password = :password")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private int isAdmin;

	private String password;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userID;

	private String userName;

	public User() {
	}

	public int getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserID() {
		return this.userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}