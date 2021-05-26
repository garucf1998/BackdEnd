package enity;

import java.io.Serializable;
import java.util.Objects;

public class TaiKhoan implements Serializable {
	private String username;
	private String password;


	private Role role;

	

	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TaiKhoan taiKhoan = (TaiKhoan) o;
		return Objects.equals(username, taiKhoan.username);
	}

	@Override
	public int hashCode() {
		return Objects.hash(username);
	}

	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
