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
	@Column(name="username",length=30)
	private String username; 
	
	@NotNull
	@Column(name="password",length=30)
	private String password;
	
	@NotNull
	@Column(name="ph_no",length=15)
	private Long number;
	
	@NotNull
	@Column(name="Email")
	private String email;
	
	@Column(name="Role")
	private String role="customer";
	
	@Column(name="Status")
	private String Status="In-Active";
	
	@JsonIgnore
	@OneToOne(mappedBy="user",cascade=CascadeType.ALL)
	private Cart cart;
	

	
	

}
