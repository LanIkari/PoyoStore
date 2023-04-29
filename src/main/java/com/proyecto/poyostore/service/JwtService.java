package com.proyecto.poyostore.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;
import java.util.function.Function;

/*
Clase que contiene la logica para la generacion, validacion y manejo de informacion de JSON Web Token (JWT) para la
autenticacion de usuarios.
 */
@Service
public class JwtService {
    //Declaramos la key para encriptar en 512bit. Esta llave determinara el nivel de nuestra seguridad.
    //Puedes generar tu propia llave en: https://www.allkeysgenerator.com/Random/Security-Encryption-Key-Generator.aspx
    private static final String LLAVE_MAESTRA = "3979244226452948404D635166546A576E5A7234743777217A25432A462D4A61";

    //Metodo para obtener el correo 
    public String extraerCorreo(String token) {
        //El Subject es el dato que estamos utilizando como identificador unico para la autentixacion. En este caso el
        //Subject(Sub en JSON) es el correo y lo declaramos asi en el modelado de la tabla Usuario. getSubject lo que
        //hace es retornar el correo llamando el metodo getUserName declarado en la clase Usuario
        return extraerAtributo(token, Claims::getSubject);
    }

    //Clase que sirve para extraer un atributo en específico del token ya en formato JSON
    public <T> T extraerAtributo(String token, Function<Claims, T> claimsResolver) {
        //En nuestra variable guardamos toda la informacion del Token con nuestro metodo "extraerAllAtributos"
        final Claims atributos = extraerAllAtributos(token);
        //Una vez que tenemos todos los atributos, utilizamos el metodo claimsResolver para extraer un atributo en especifico
        return claimsResolver.apply(atributos);
    }

    /*De esta forma le proporcionamos toda la informacion necesaria a nuestro metodo para generar el Token y ejecutamos
    la logica para generar el token en el metodo llamado de la misma forma.
     */
    public String generarToken(UserDetails userDetails) {
        return generarToken(new HashMap<>(), userDetails);
    }

    //Logica para generar un token JWT
    public String generarToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        //Le otorgamos al token generado el atributo de "Rol".De esta forma en la decodificacion podremos ver atributo rol.
        extraClaims.put("authorities", (Set<SimpleGrantedAuthority>) userDetails.getAuthorities());
        //Retornamos el token generado con la libreria Jwts.
        return Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername()).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24)).signWith(getLlaveFirma(), SignatureAlgorithm.HS256).compact();
    }

    //Validacion de token
    public boolean isTokenValid(String token, UserDetails userDetails) {
        //Extraemos el correo del token
        final String correo = extraerCorreo(token);
        //Retonramos True si el correo del token es igual al correo del usuario y si el token no ha expirado
        return (correo.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    //Validacion de expiracion de token
    private boolean isTokenExpired(String token) {
        //Dado que cada toquen tiene asociada una hora de creacion (IAT) y una hora de expiracion (EXP), validamos que
        //la hora actual sea menor a la hora de expiracion
        return extraerExpiracion(token).before(new Date());
    }

    //Extraccion de la fecha de expiracion del token
    private Date extraerExpiracion(String token) {
        return extraerAtributo(token, Claims::getExpiration);
    }

    //Este metodo nos permite extraer los datos del usuario a partir del token
    private Claims extraerAllAtributos(String token) {
        //La libreria Jwts tiene sus metodos para trabajar con tokens. parserBuilder nos permite dado un token
        //convertirlo a informacion JSON(getBody), pero no sin antes validar que la firma sea correcta (getLlaveFirma)
        //
        return Jwts.parserBuilder().setSigningKey(getLlaveFirma()).build().parseClaimsJws(token).getBody();

    }

    //Metodo para decodificar la key una vez que se valido que es correcta.
    private Key getLlaveFirma() {
        //Decodificamos la llave maestra en bytes
        byte[] llaveBytes = Decoders.BASE64.decode(LLAVE_MAESTRA);
        //Devuelve la key en forma de bites
        return Keys.hmacShaKeyFor(llaveBytes);
    }
}