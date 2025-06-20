package br.com.maestro.backend.service;

import br.com.maestro.backend.dto.BandaDTO;
import br.com.maestro.backend.dto.MusicoDTO;
import br.com.maestro.backend.entity.Banda;
import br.com.maestro.backend.exception.ResourceNotFoundException;
import br.com.maestro.backend.repository.BandaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BandaService {
    @Autowired
    private BandaRepository repository;

    public List<BandaDTO> listarTodos() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public BandaDTO buscarPorId(Long id) {
        Banda banda = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Banda não encontrada."));
        return toDTO(banda);
    }

    public BandaDTO salvar(BandaDTO bandaDTO) {
        Banda banda = toEntity(bandaDTO);
        return toDTO(repository.save(banda));
    }

    public BandaDTO atualizar(Long id, BandaDTO bandaDTO) {
        Banda banda = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Banda não encontrada."));
        banda.setNome(bandaDTO.getNome());
        banda.setGenero(bandaDTO.getGenero());
        banda.setAnoFormacao(bandaDTO.getAnoFormacao());
        return toDTO(repository.save(banda));
    }

    public void deletar(Long id) {
        Banda banda = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Banda não encontrada."));
        repository.delete(banda);
    }

    private BandaDTO toDTO(Banda banda) {
        List<MusicoDTO> musicos = null;
        if (banda.getMusicos() != null) {
            musicos = banda.getMusicos().stream().map(m -> {
                MusicoDTO mdto = new MusicoDTO();
                mdto.setNome(m.getNome());
                mdto.setInstrumento(m.getInstrumento());
                mdto.setNacionalidade(m.getNacionalidade());
                mdto.setDataNascimento(m.getDataNascimento());
                mdto.setIdBanda(banda.getId());
                return mdto;
            }).collect(Collectors.toList());
        }
        return new BandaDTO(banda.getNome(), banda.getGenero(), banda.getAnoFormacao(), musicos);
    }

    private Banda toEntity(BandaDTO dto) {
        Banda banda = new Banda();
        banda.setNome(dto.getNome());
        banda.setGenero(dto.getGenero());
        banda.setAnoFormacao(dto.getAnoFormacao());
        return banda;
    }
}
