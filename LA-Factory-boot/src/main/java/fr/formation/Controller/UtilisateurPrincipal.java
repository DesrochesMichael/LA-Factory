package fr.formation.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import fr.formation.model.Utilisateur;

public class UtilisateurPrincipal implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	private Utilisateur utilisateur;

	@Override
	public String getPassword() {
		return this.utilisateur.getPassword();
	}

	@Override
	public String getUsername() {
		return this.utilisateur.getMail();
	}
	
	public String getRole() {
		return this.utilisateur.getRole();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public UtilisateurPrincipal(Utilisateur utilisateur) {
		if(utilisateur == null) {
			throw new UsernameNotFoundException("L'utilisateur n'existe pas");
		}
		this.utilisateur = utilisateur;
	}
		
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> myAuthorities = new ArrayList<GrantedAuthority>();
		if(this.getRole().equals("ADMIN")) {
			myAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		else {
			myAuthorities.add(new SimpleGrantedAuthority("ROLE_TECH"));
		}
		return myAuthorities;
	}

}
