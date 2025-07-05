package com.Entity;

import java.time.Instant;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.Enums.KycStatusEnum;
import com.Enums.UserStatusEnum;
import com.Security.CustomUserService;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Slf4j
@ToString
public class User implements CustomUserService {
	
//	id , username , email , firstName , middleName , lastName , lastName , 
//  mobileNumber , password , kycstatus , userstatus , createdAt , updatedAt.
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long id;
	
	@Column(name = "User_Name" , nullable = false)
	private String username;
	
	@Column(name = "Email_id", nullable = false,unique = true)
	private String email;
	
	@Column(name = "firstname" , nullable = false, length = 100)
	private String firstname;
	
	@Column(name = "middlename" , nullable = false, length = 100)
	private String middlename;
	
	@Column(name = "lastname" , nullable = false, length = 100)
	private String lastname;
	
	@Column(name = "Mobile_No" , nullable = false, length = 20)
	private String mobileNumber;
	
	@Column(name = "password")
	private String password;
	
	@ToString.Exclude
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "Role_Id", referencedColumnName = "id", nullable = false)
	private Role role;
	
	@Enumerated(EnumType.STRING)
	private KycStatusEnum kycstatus;
	
	@Enumerated(EnumType.STRING)
	private UserStatusEnum userStatus;
	
	@CreationTimestamp
	@Column(name = "Created_At", updatable = false, nullable = false)
	private Instant createdAt;
	
	@UpdateTimestamp
	@Column(name = "Updated_At", updatable = false, nullable = false)
	private Instant updatedAt;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		log.debug("getAuthorities()");
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE :  "+role.getName().toString() );
		
		return Collections.singletonList(authority);
	}

	@Override
	public boolean isAccountNonExpired() {
		
		log.debug("isAccountNonExpired()");
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		log.debug("isAccountNonLocked()");
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		log.debug("isCredentialsNonExpired()");
		return true;
	}

	@Override
	public boolean isEnabled() {
		log.debug("isEnabled()");
		return true;
	}
	
	

}
