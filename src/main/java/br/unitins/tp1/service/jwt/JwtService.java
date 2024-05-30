package br.unitins.tp1.service.jwt;

import br.unitins.tp1.dto.pessoa.UsuarioResponseDTO;

public interface JwtService {
    String generateJwt(UsuarioResponseDTO dto, int perfil);
}
