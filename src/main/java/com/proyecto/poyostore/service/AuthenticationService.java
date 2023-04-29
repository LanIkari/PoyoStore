package com.proyecto.poyostore.service;

import com.proyecto.poyostore.auth.AuthenticationRequest;
import com.proyecto.poyostore.auth.AuthenticationResponse;
import com.proyecto.poyostore.auth.RegisterRequest;
import com.proyecto.poyostore.model.Rol;
import com.proyecto.poyostore.model.Usuario;
import com.proyecto.poyostore.repository.mdbUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
//Clase para construir un usuario con seguridad
public class AuthenticationService {

    private final mdbUsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var usuario= Usuario.builder()
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .correo(request.getCorreo())
                .contrasena(passwordEncoder.encode(request.getContrasena()))
                .telefono(request.getTelefono())
                .fondos(request.getFondos())
                .rol(Rol.USUARIO)
                .build();
        usuarioRepository.save(usuario);
        var jwtToken=jwtService.generarToken(usuario);
        //Generacion de Token
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getCorreo(),request.getContrasena()));
        var usuario=usuarioRepository.findByCorreo(request.getCorreo()).orElseThrow();
        var jwtToken=jwtService.generarToken(usuario);
        //Generacion de Token
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
