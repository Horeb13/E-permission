package ci.sndi.e_permission.security.service;


import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ci.sndi.e_permission.models.Utilisateur;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPrinciple implements UserDetails {

	private Long id;

	private String name;

	private String email;

	private Collection<? extends GrantedAuthority> authorities;

	@JsonIgnore
	private String password;

	public UserPrinciple(long id, String name, String username, List<GrantedAuthority> authorities, String password) {
		this.id = id;
		this.name = name;
		this.email = username;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserDetails build(Utilisateur user) {
		List<GrantedAuthority> authorities = Stream.of(user.getRoles())
				.map(role -> new SimpleGrantedAuthority(role.toString()))
				.collect(Collectors.toList());

		String name = user.getNom() + " " + user.getPrenom();
		return new UserPrinciple(user.getId(), name, user.getEmail(), authorities,
				user.getMotDePasse());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		UserPrinciple user = (UserPrinciple) o;

		return Objects.equals(id, user.id);

	}

	//

}
