package br.com.maestro.backend.service;

import br.com.maestro.backend.dto.MusicoDTO;
import br.com.maestro.backend.entity.Banda;
import br.com.maestro.backend.entity.Musico;
import br.com.maestro.backend.exception.ResourceNotFoundException;
import br.com.maestro.backend.repository.BandaRepository;
import br.com.maestro.backend.repository.MusicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MusicoService {
    @Autowired
    private MusicoRepository musicoRepository;

    @Autowired
    private BandaRepository bandaRepository;

    public List<MusicoDTO> listarTodos() {
        return musicoRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public MusicoDTO buscarPorId(Long id) {
        Musico musico = musicoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Músico não encontrado."));
        return toDTO(musico);
    }

    public MusicoDTO salvar(MusicoDTO dto) {
        Musico musico = toEntity(dto);
        return toDTO(musicoRepository.save(musico));
    }

    public MusicoDTO atualizar(Long id, MusicoDTO dto) {
        Musico musico = musicoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Músico não encontrado."));
        musico.setNome(dto.getNome());
        musico.setInstrumento(dto.getInstrumento());
        musico.setNacionalidade(dto.getNacionalidade());
        musico.setDataNascimento(dto.getDataNascimento());
        if (dto.getIdBanda() != null) {
            Banda banda = bandaRepository.findById(dto.getIdBanda()).orElseThrow(() -> new ResourceNotFoundException("Banda não encontrada."));
            musico.setBanda(banda);
        }
        musico = musicoRepository.save(musico);
        return toDTO(musico);
    }

    public void deletar(Long id) {
        Musico musico = musicoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Músico não encontrado."));
        musicoRepository.delete(musico);
    }

    private MusicoDTO toDTO(Musico musico) {
        Long bandaId = musico.getBanda() != null ? musico.getBanda().getId() : null;
        return new MusicoDTO(musico.getNome(), musico.getInstrumento(), musico.getNacionalidade(), musico.getDataNascimento(), bandaId);
    }

    private Musico toEntity(MusicoDTO dto) {
        Musico musico = new Musico();
        musico.setNome(dto.getNome());
        musico.setInstrumento(dto.getInstrumento());
        musico.setNacionalidade(dto.getNacionalidade());
        musico.setDataNascimento(dto.getDataNascimento());
        if (dto.getIdBanda() != null) {
            Banda banda = bandaRepository.findById(dto.getIdBanda()).orElseThrow(() -> new ResourceNotFoundException("Banda não encontrada."));
            musico.setBanda(banda);
        }
        return musico;
    }
}
