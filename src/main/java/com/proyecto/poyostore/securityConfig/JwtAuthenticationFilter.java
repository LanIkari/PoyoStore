package com.proyecto.poyostore.securityConfig;

import com.proyecto.poyostore.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

//Alojaremos todos los filtros por los que tendra que pasar los datos del usuario para la implementacion de la Seguridad
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    //Inicializacion del JWT Service (JSON WEB TOKEN)
    private final JwtService jwtService;
    //Este metodo se auto-autogenera ya que nuestra clase extiende a OncePerRequestFilter.
    @Override
    //El primer filtro consiste en no perminitir que las respuesta del HTML ninguna sea Nula.
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        final String authHeader=request.getHeader("Authorization");//Guardamos en un String que la respuesta empiece con Authorization
        final String jwt; //Inicializacion del JWT para guardar el token del usuario
        final String correo; //Inicializacion del JWT para guardar el correo del usuario
        //Indicamos que si nuestra respuesta no contiene Authorization, y Baerer se ejecute en bucle hasta que los contenga
        if(authHeader==null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }
        /*Dado que el authHeader contiene el token del usuario, guardamos en una variable ese token a partir del septimo caracter
         esto por los 7 caracteres del "Bearer ".
         EJEMPLO DE FORMATO:
         "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJ"
         jwt="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJ"
        */
        jwt=authHeader.substring(7);
        // Guardamos el correo del usuario en una variable, este se extrae a través de jwtService del método extraerCorreo dandole el jwtoken
        correo= jwtService.extraerCorreo(jwt);
    }
}
