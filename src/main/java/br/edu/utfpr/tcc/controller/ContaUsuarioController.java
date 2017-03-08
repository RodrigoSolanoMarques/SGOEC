package br.edu.utfpr.tcc.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.utfpr.tcc.enumerator.ERole;
import br.edu.utfpr.tcc.model.ContaUsuario;
import br.edu.utfpr.tcc.model.Permissao;
import br.edu.utfpr.tcc.repository.ContaUsuarioRepository;
import br.edu.utfpr.tcc.repository.PermissaoRepository;



@RestController
@RequestMapping(value = "/empresa/contaUsuario")
@MultipartConfig(fileSizeThreshold = 20971520)
public class ContaUsuarioController {

	@Autowired
	ContaUsuarioRepository contaUsuarioRepository;

	@Autowired
	private PermissaoRepository permissaoRepository;
	
	static final String PATH = "/imagens/";

	@GetMapping(value = "/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView model = new ModelAndView("");
		return model;
	}

	@GetMapping("/alterar")
	public ContaUsuario alterar(@RequestParam(value = "id", required = true) Long id) {
		ContaUsuario contaUsuario = contaUsuarioRepository.findOne(id);
		contaUsuario.setSenha("");
		return contaUsuario;
	}

	// Salvar Admin
	@PostMapping("/salvar/admin")
	public ContaUsuario salvarAdmin(MultipartFile imagem, ContaUsuario contaUsuario, BindingResult erros, Model model,
			RedirectAttributes redirect) {
		System.out.println(imagem.getOriginalFilename());
		// salvar(contaUsuario, ERole.ROLE_ADMIN);

		return contaUsuario;// "redirect:/login";
	}

	// Salvar Candidato
	@PostMapping("/salvar/candidato")
	public ContaUsuario salvarCandidato(ContaUsuario contaUsuario, BindingResult erros, Model model,
			RedirectAttributes redirect) {
		//(contaUsuario, ERole.ROLE_CANDIDATO);

		return contaUsuario;// "redirect:/login";
	}

	// Salvar Empregador
	@PostMapping("/salvar/empregador")
	public ResponseEntity salvarEmpregador(ContaUsuario contaUsuario, String compararSenha, Boolean trocarSenha, @RequestParam("foto") MultipartFile foto, HttpServletRequest request) {
		
		Map<String, Object> data = new HashMap<>();
		
		if(trocarSenha){
			if(!contaUsuario.getSenha().equals(compararSenha)){
				data.put("msg", "As senhas não são iguais!");
				return new ResponseEntity(data, HttpStatus.NOT_ACCEPTABLE);
			}
		}
		
		return salvar(contaUsuario, ERole.ROLE_EMPREGADOR, request, foto, trocarSenha);
	}

	// Salvar Generico para os tipos de Roles
	public ResponseEntity salvar(ContaUsuario contaUsuario, ERole role, HttpServletRequest request, MultipartFile foto, Boolean trocarSenha) {
		
		Map<String, Object> data = new HashMap<>();
		ContaUsuario contaUsuarioSalvar = new ContaUsuario();
		
		/* Se a cona já estiver cadastrada busca as informaçoes dela */
		if(contaUsuario.getId() == null){
			contaUsuarioSalvar = contaUsuario;
		}else{
			contaUsuarioSalvar = contaUsuarioRepository.findOne(contaUsuario.getId());
		}
		
		if(trocarSenha){
			String encodedPassword = contaUsuario.getEncodedPassword(contaUsuario.getPassword());
			contaUsuarioSalvar.setSenha(encodedPassword);
		}
		
		if ((!foto.isEmpty())  && ((ERole.ROLE_ADMIN == role) || (ERole.ROLE_CANDIDATO == role) || (ERole.ROLE_EMPREGADOR == role))) {
			String caminho = prepararAnexo(request, contaUsuario.getId(), foto);
			contaUsuarioSalvar.setPathImagem(caminho);
		}
		contaUsuarioSalvar.addPermissao(getPermissao(role));
		
		contaUsuarioRepository.save(contaUsuarioSalvar);
		
		data.put("msg", "Conta de usuário salva com sucesso!");
		data.put("contaUsuario", contaUsuarioSalvar);
		return new ResponseEntity(data, HttpStatus.OK);
	}

	// Obter a permissão
	private Permissao getPermissao(ERole role) {

		Permissao permissao = permissaoRepository.findById(role.getValor());
		if (permissao == null) {
			permissao = new Permissao();
			permissao.setPermissao("ROLE_USER");
			permissaoRepository.save(permissao);
		}

		/*
		 * Permissao permissao =
		 * permissaoRepository.findByPermissao("ROLE_USER"); if (permissao ==
		 * null){ permissao = new Permissao();
		 * permissao.setPermissao("ROLE_USER");
		 * permissaoRepository.save(permissao); }
		 */
		return permissao;
	}
	
	private String prepararAnexo(HttpServletRequest request, Long idContaUsuario, MultipartFile foto){
		
		File dir = new File(
				request.getServletContext().getRealPath(PATH + idContaUsuario));
		if (!dir.exists()) {
			dir.mkdirs();
		}

		String caminhoAnexo = request.getServletContext()
				.getRealPath(PATH + idContaUsuario+"/");

		String extensao = foto.getOriginalFilename().substring(foto.getOriginalFilename().lastIndexOf("."),
				foto.getOriginalFilename().length());

		String nomeArquivo = idContaUsuario + extensao;

		try {
			salvarAnexoDisco(caminhoAnexo + nomeArquivo, foto.getBytes(), request);
		} catch (Exception e) {
			// Erro ao fazer upload da imagem:
			e.printStackTrace();
		}

		// Para varios arquivos upload
		/*int i = 1;
		for (MultipartFile a : anexos) {
			extensao = a.getOriginalFilename().substring(a.getOriginalFilename().lastIndexOf("."),
					a.getOriginalFilename().length());

			nomeArquivo = produto.getId() + "_" + i + extensao;
			salvarAnexoDisco(caminhoAnexo + nomeArquivo, a.getBytes(), request);
			i++;
		}*/
		
		return PATH + idContaUsuario + "/" + nomeArquivo;
	}
	
	private void salvarAnexoDisco(String caminho, byte[] bytes, HttpServletRequest request) throws Exception {
		try {
			FileOutputStream fileout = new FileOutputStream(new File(caminho));
			BufferedOutputStream stream = new BufferedOutputStream(fileout);
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao fazer upload da imagem:" + e.getMessage());
		}
	}
}
