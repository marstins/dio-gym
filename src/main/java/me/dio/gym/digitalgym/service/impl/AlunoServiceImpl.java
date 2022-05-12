package me.dio.gym.digitalgym.service.impl;

import me.dio.gym.digitalgym.entity.Aluno;
import me.dio.gym.digitalgym.entity.AvaliacaoFisica;
import me.dio.gym.digitalgym.entity.form.AlunoForm;
import me.dio.gym.digitalgym.entity.form.AlunoUpdateForm;
import me.dio.gym.digitalgym.infra.utils.JavaTimeUtils;
import me.dio.gym.digitalgym.repository.AlunoRepository;
import me.dio.gym.digitalgym.service.IAlunoService;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoServiceImpl implements IAlunoService {
  
  @Autowired
  private AlunoRepository repository;

  @Override
  public Aluno create(AlunoForm form) {
    Aluno aluno  = new Aluno();
    aluno.setNome(form.getNome());
    aluno.setCpf(form.getCpf());
    aluno.setBairro(form.getBairro());
    aluno.setDataDeNascimento(form.getDataDeNascimento());

    return repository.save(aluno);
  }

  @Override
  public Aluno get(Long id) {
    return null;
  }

  @Override
  public List<Aluno> getAll(String dataDeNascimento) {
    
    if(dataDeNascimento == null) {
      return repository.findAll();
    } else {
      LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
      return repository.findByDataDeNascimento(localDate);
    }
    
  }

  @Override
  public Aluno update(Long id, AlunoUpdateForm formUpdate) {
    return null;
  }

  @Override
  public void delete(Long id) {
  }

  @Override
  public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {
    Aluno aluno = repository.findById(id).get();

    return aluno.getAvaliacoes();
  }
}
