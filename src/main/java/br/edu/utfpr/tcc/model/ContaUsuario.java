package br.edu.utfpr.tcc.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.Data;

@Entity
@Data
public class ContaUsuario implements UserDetails{
	private static final long serialVersionUID = 1L;
	
	private static final BCryptPasswordEncoder bCry = 
			new BCryptPasswordEncoder();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=255, nullable=false)
	private String username;
	
	@Column(length=255, nullable=false)
	private String senha;
	
	@Column(length=255, nullable=false)
	private String email;
	
	@Column(length=255, nullable=true)
	private String pathImagem;
	
	@ManyToMany(cascade = CascadeType.ALL, 
			fetch = FetchType.EAGER)
	private Set<Permissao> permissoes;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auto = new ArrayList<>();
		auto.addAll(getPermissoes());
		
		return auto;
	}

	public void addPermissao(Permissao permissao){
		if (permissoes == null){
			permissoes = new HashSet<>();
		}
		permissoes.add(permissao);
	}
	
	public String getEncodedPassword(String pass){
		if (StringUtils.isNotEmpty(pass)){
			return bCry.encode(pass);
		}
		return pass;
	}
	@Override
	public String getPassword() {
		return this.senha;
	}
	
	@Override
	public String getUsername() {
		return this.username;
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
	
	
	
	
	
	
}
