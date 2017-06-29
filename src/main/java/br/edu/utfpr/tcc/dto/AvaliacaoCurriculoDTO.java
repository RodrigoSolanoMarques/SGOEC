package br.edu.utfpr.tcc.dto;

import java.util.Date;

import br.edu.utfpr.tcc.enumerator.EStatusCurriculo;
import br.edu.utfpr.tcc.model.AvaliacaoCurriculo;
import br.edu.utfpr.tcc.model.OportunidadeEmprego;
import lombok.Data;

@Data
public class AvaliacaoCurriculoDTO {
	private Long id;
    private OportunidadeEmprego oportunidadeEmprego;
    private EStatusCurriculo status;
    private Boolean favorito;
    private Boolean isAceitaEntrevista;
    private Date dataCurriculoEnviado;
    private Date dataEntrevista;
    private Date dataEncerramento;
    
    public AvaliacaoCurriculoDTO converterAvaliacaoCurriculo(AvaliacaoCurriculo avaliacaoCurriculo){
    	
    	AvaliacaoCurriculoDTO avaliacaoCurriculoDTO = new AvaliacaoCurriculoDTO();
    	
    	avaliacaoCurriculoDTO.setId(avaliacaoCurriculo.getId());
    	avaliacaoCurriculoDTO.setStatus(avaliacaoCurriculo.getStatus());
    	avaliacaoCurriculoDTO.setOportunidadeEmprego(avaliacaoCurriculo.getOportunidadeEmprego());
    	avaliacaoCurriculoDTO.setFavorito(avaliacaoCurriculo.getFavorito());
    	avaliacaoCurriculoDTO.setIsAceitaEntrevista(avaliacaoCurriculo.getIsAceitaEntrevista());
//    	avaliacaoCurriculoDTO.setDataCurriculoEnviado(
//    			avaliacaoCurriculo.getDataCurriculoEnviado() != null 
//    			? new Date(avaliacaoCurriculo.getDataCurriculoEnviado().getTime())
//    			: null);
//    	avaliacaoCurriculoDTO.setDataEncerramento(
//    			avaliacaoCurriculo.getDataEncerramento() != null 
//    			? new Date(avaliacaoCurriculo.getDataEncerramento().getTime())
//    			: null);
//    	avaliacaoCurriculoDTO.setDataEncerramento(
//    			avaliacaoCurriculo.getDataEncerramento() != null 
//    			? new Date(avaliacaoCurriculo.getDataEncerramento().getTime())
//    			: null);
    	
    	return avaliacaoCurriculoDTO;
    }
}
