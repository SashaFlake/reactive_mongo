package ru.attest.reactive_mongo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.BSONEncoder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.management.relation.Role;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Document
@Data
@Getter
@Setter
public class User implements Serializable, UserDetails {
	@Id
	private String id;
	private String password;
	private boolean enabled;
	private List<Group> groups;
	private List<Role> roles;

	public User(String id) {
		this.id = id;
		this.password="test";
	}

	public User(String id, String password, List<Group> groups) {
		this.id = id;
		this.password = password;
		this.groups = groups;
	}

	public User() {
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles.stream()
				.map(authority ->
					new SimpleGrantedAuthority(authority.getRoleName()))
						.collect(Collectors.toList());
	}

	@Override
	public String getUsername() {
		return id;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}
	@JsonIgnore
	@Override
	public String getPassword() {
		return password;
	}
	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}
}
