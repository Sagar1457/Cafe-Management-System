package project.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long user_id;
	
	@NotNull
	@Column(name="fullname")
	private String Fullname;
	
	@NotNull
	@Column(name="username",length=30, unique=true)
	private String username; 
	
	@NotNull
	@Column(name="password",length=30)
	private String password;
	
	@NotNull
	@Column(name="ph_no",length=15, unique=true)
	private Long number;
	
	@NotNull
	@Column(name="Email", unique=true)
	private String email;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="Role")
	private String role="customer";
	
	@Column(name="Status")
	private String Status="Active";
	
	@JsonIgnore
	@OneToOne(mappedBy="user",cascade=CascadeType.ALL)
	private Cart cart;
	

	
	

}
