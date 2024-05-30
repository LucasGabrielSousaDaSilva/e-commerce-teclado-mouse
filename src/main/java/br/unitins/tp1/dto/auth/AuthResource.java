package br.unitins.tp1.dto.auth;

import br.unitins.tp1.dto.pessoa.UsuarioResponseDTO;
import br.unitins.tp1.service.hash.HashService;
import br.unitins.tp1.service.jwt.JwtService;
import br.unitins.tp1.service.pessoa.ClienteService;
import br.unitins.tp1.service.pessoa.FuncionarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/auth")
public class AuthResource {

    @Inject
    public FuncionarioService funcionarioService;

    @Inject
    public ClienteService clienteService;

    @Inject
    public HashService hashService;

    @Inject
    public JwtService jwtService;

    @POST
    public Response login(AuthUsuarioDTO dto) {
        String hash = hashService.getHashSenha(dto.senha());

        UsuarioResponseDTO usuario = null;
        // perfil 1
        if (dto.perfil() == 1) {
            usuario = funcionarioService.login(dto.username(), hash);
        } else if (dto.perfil() == 2) { // perfil 2
            usuario = clienteService.login(dto.username(), hash);
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.ok(usuario)
            .header("Authorization", jwtService.generateJwt(usuario, dto.perfil()))
            .build();
    }
    
}
