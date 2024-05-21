package br.unitins.tp1.service;

import br.unitins.tp1.dto.UsuarioResponseDTO;

public interface JwtService {
    String generateJwt(UsuarioResponseDTO dto);
}
