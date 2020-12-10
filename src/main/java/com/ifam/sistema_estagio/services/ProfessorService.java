package com.ifam.sistema_estagio.services;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifam.sistema_estagio.entity.Professor;
import com.ifam.sistema_estagio.repository.ProfessorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService extends GenericService<Professor, ProfessorRepository> {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> encontrarPorNome(String nome){
        return professorRepository.findByNomeContainingIgnoreCase(nome);
    }
    public List<Professor> encontrarPorMatricula(String matricula){
        return professorRepository.findByMatriculaContainingIgnoreCase(matricula);
    }

    @Override
    public Professor salvar(Professor professor) throws Exception {
        val professorOptional = encontrarPorCpf(professor.getCpf());
        if(professorOptional.isPresent()){
            return professorOptional.get();
        }
        return super.salvar(professor);
    }

    public Optional<Professor> encontrarPorCpf(String cpf){
        return professorRepository.findByCpf(cpf);
    }
}
