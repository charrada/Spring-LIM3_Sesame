package tn.projetdemo.demo.entities;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	private  String firstname;
	private String lastname;
	private String email;
	private String username;
	private String password;
	private String address;


}
