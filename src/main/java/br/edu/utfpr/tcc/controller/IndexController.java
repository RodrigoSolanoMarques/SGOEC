package br.edu.utfpr.tcc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.edu.utfpr.tcc.dto.RegistroDTO;
import br.edu.utfpr.tcc.enumerator.ERole;
import br.edu.utfpr.tcc.model.ContaUsuario;
import br.edu.utfpr.tcc.model.Empregador;
import br.edu.utfpr.tcc.model.Empresa;
import br.edu.utfpr.tcc.model.Estado;
import br.edu.utfpr.tcc.model.Permissao;
import br.edu.utfpr.tcc.model.Pessoa;
import br.edu.utfpr.tcc.repository.CidadeRepository;
import br.edu.utfpr.tcc.repository.ContaUsuarioRepository;
import br.edu.utfpr.tcc.repository.EmpregadorRepository;
import br.edu.utfpr.tcc.repository.EmpresaRepository;
import br.edu.utfpr.tcc.repository.EstadoRepository;
import br.edu.utfpr.tcc.repository.PermissaoRepository;

@RestController
@RequestMapping(value="/")
public class IndexController {
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	ContaUsuarioRepository contaUsuarioRepository;
	
	@Autowired
	EmpregadorRepository empregadorRepository;
	
	@Autowired
	EmpresaRepository empresaRepository;

	@Autowired
	PermissaoRepository permissaoRepository;
	
	@RequestMapping("index")
	public String home(){
		return "index";
	}
	
	@RequestMapping("login")
	public ModelAndView login(){
		
		ModelAndView model = new ModelAndView("login");
		
		model.addObject("listaEstado", estadoRepository.findAll());
		model.addObject("listaCidade", cidadeRepository.findByEstado(new Estado(1L)));
		return model;
	}
	
	@RequestMapping("teste")
	public String teste(){
		return "teste";
	}
	
	@PostMapping("registrar")
	public ResponseEntity registrar(RegistroDTO registroDto){
		
		Map<String, Object> data = new HashMap<>();	
		
		if(registroDto.getRazaoSocial().isEmpty()){
			data.put("msg", "Preencha o campo Razão Social!");
			return new ResponseEntity<>(data, HttpStatus.NOT_ACCEPTABLE);
		}
		if(registroDto.getNomeFantasia().isEmpty()){
			data.put("msg", "Preencha o campo Nome Fantasia!");
			return new ResponseEntity<>(data, HttpStatus.NOT_ACCEPTABLE);
		}
		if(registroDto.getCpfCnpj().isEmpty()){
			data.put("msg", "Preencha o campo CPF/CNPJ!");
			return new ResponseEntity<>(data, HttpStatus.NOT_ACCEPTABLE);
		}
		if(registroDto.getIsPessoaJuridica() == null){
			data.put("msg", "Selecione o Tipo da pessoa!");
			return new ResponseEntity<>(data, HttpStatus.NOT_ACCEPTABLE);
		}
		if(registroDto.getCidade() == null){
			data.put("msg", "Selecione uma cidade!");
			return new ResponseEntity<>(data, HttpStatus.NOT_ACCEPTABLE);
		}
		
		if(registroDto.getNome().isEmpty()){
			data.put("msg", "Preencha o campo Nome!");
			return new ResponseEntity<>(data, HttpStatus.NOT_ACCEPTABLE);
		}
		
		if(registroDto.getSobrenome().isEmpty()){
			data.put("msg", "Preencha o campo Sobrenome!");
			return new ResponseEntity<>(data, HttpStatus.NOT_ACCEPTABLE);
		}
		
		if(registroDto.getUsername().isEmpty()){
			data.put("msg", "Preencha o campo Nome de Usuário!");
			return new ResponseEntity<>(data, HttpStatus.NOT_ACCEPTABLE);
		}
		
		if(contaUsuarioRepository.findByUsername(registroDto.getUsername()) != null){
			data.put("msg", "Já existe esse Nome de Usuário!");
			return new ResponseEntity<>(data, HttpStatus.NOT_ACCEPTABLE);
		}
		
		if(registroDto.getEmail().isEmpty()){
			data.put("msg", "Preencha o campo E-mail!");
			return new ResponseEntity<>(data, HttpStatus.NOT_ACCEPTABLE);
		}
		
		if(registroDto.getSenha().isEmpty()){
			data.put("msg", "Preencha o campo Senha!");
			return new ResponseEntity<>(data, HttpStatus.NOT_ACCEPTABLE);
		}
		
		if(!registroDto.getSenha().equals(registroDto.getCompararSenha())){
			data.put("msg", "As senhas não são iguais!");
			return new ResponseEntity<>(data, HttpStatus.NOT_ACCEPTABLE);
		}

		/* Faz o cadastro */
		
		ContaUsuario contaUsuario = new ContaUsuario();
		contaUsuario.setUsername( registroDto.getUsername() );
		contaUsuario.setEmail( registroDto.getEmail() );
		contaUsuario.setSenha( contaUsuario.getEncodedPassword( registroDto.getSenha() ) );
		
		Permissao permissao = permissaoRepository.findById( ERole.ROLE_ADMIN.getValor() );
		contaUsuario.addPermissao( permissao );
		
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial( registroDto.getRazaoSocial() );
		empresa.setNomeFantasia( registroDto.getNomeFantasia() );
		empresa.setCpfCnpj( registroDto.getCpfCnpj() );
		empresa.setIsPessoaJuridica( registroDto.getIsPessoaJuridica() );
		empresa.setCidade( registroDto.getCidade() );
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome( registroDto.getNome() );
		pessoa.setSobrenome( registroDto.getSobrenome() );
		
		Empregador empregador = new Empregador();
		empregador.setPessoa( pessoa );
		empregador.setContaUsuario( contaUsuario );
		
		try {
			contaUsuarioRepository.save( contaUsuario );
			empresaRepository.save( empresa );
			empregadorRepository.save( empregador );
			
			data.put( "msg", "Contra Criada com Sucesso!" );
			return new ResponseEntity<>( data, HttpStatus.OK );
		} catch (Exception e) {
			data.put( "msg", "Não foi possível criar conta!" );
			return new ResponseEntity<>( data, HttpStatus.NOT_ACCEPTABLE );
		}
				
		
	}
}
