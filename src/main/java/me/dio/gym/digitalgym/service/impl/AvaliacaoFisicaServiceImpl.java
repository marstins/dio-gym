package me.dio.gym.digitalgym.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.gym.digitalgym.entity.Aluno;
import me.dio.gym.digitalgym.entity.AvaliacaoFisica;
import me.dio.gym.digitalgym.entity.form.AvaliacaoFisicaForm;
import me.dio.gym.digitalgym.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.gym.digitalgym.repository.AlunoRepository;
import me.dio.gym.digitalgym.repository.AvaliacaoFisicaRepository;
import me.dio.gym.digitalgym.service.IAvaliacaoFisicaService;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

  @Autowired
  private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

  @Autowired
  private AlunoRepository alunoRepository;

  @Override
  public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
    AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
    Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

    avaliacaoFisica.setAluno(aluno);
    avaliacaoFisica.setPeso(form.getPeso());
    avaliacaoFisica.setAltura(form.getAltura());

    return avaliacaoFisicaRepository.save(avaliacaoFisica);
  }

  @Override
  public AvaliacaoFisica get(Long id) {
    return null;
  }

  @Override
  public List<AvaliacaoFisica> getAll() {
    return null;
  }

  @Override
  public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
    return null;
  }

  @Override
  public void delete(Long id) {
    
  }
  
}
