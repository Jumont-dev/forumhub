package com.forumhub.service;

import com.forumhub.forumhub.Topico;
import com.forumhub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public List<Topico> listarTodos() {
        return topicoRepository.findAll();
    }

    public Optional<Topico> buscarPorId(Long id) {
        return topicoRepository.findById(id);
    }

    public Topico criarTopico(Topico topico) {
        return topicoRepository.save(topico);
    }

    public Topico atualizarTopico(Long id, Topico topicoAtualizado) {
        return topicoRepository.findById(id).map(topico -> {
            topico.setTitulo(topicoAtualizado.getTitulo());
            topico.setMensagem(topicoAtualizado.getMensagem());
            return topicoRepository.save(topico);
        }).orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
    }

    public void deletarTopico(Long id) {
        topicoRepository.deleteById(id);
    }
}
