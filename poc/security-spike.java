package com.banco.digital.securityspike;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/api/pagos")
public class SecuritySpike {

    // Clave secreta hardcodeada (vulnerabilidad: debería estar en un vault)
    private static final String SECRET_KEY = "mi-clave-secreta-insegura-123456";

    // Simulación de base de datos en memoria
    private static final Map<String, Transaccion> transacciones = new HashMap<>();
    
    public static void main(String[] args) {
        SpringApplication.run(SecuritySpike.class, args);
    }

    @PostMapping("/transaccion")
    public ResponseEntity<String> crearTransaccion(@RequestBody TransaccionRequest request) {
        // Vulnerabilidad: No se valida el JWT (Spoofing)
        String token = request.getToken();
        
        // Vulnerabilidad: No se valida la firma del JWT (Tampering)
        if (token != null && !token.isEmpty()) {
            try {
                Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY.getBytes())
                    .build()
                    .parseClaimsJws(token);
            } catch (Exception e) {
                // Vulnerabilidad: Mensaje de error detallado (Information Disclosure)
                return ResponseEntity.badRequest().body("Token inválido: " + e.getMessage());
            }
        }
        
        // Vulnerabilidad: No se valida el monto de la transacción (Tampering)
        if (request.getMonto() <= 0) {
            return ResponseEntity.badRequest().body("Monto inválido");
        }
        
        // Vulnerabilidad: No se verifica el saldo del usuario (Repudiation)
        String idTransaccion = "TX-" + System.currentTimeMillis();
        Transaccion transaccion = new Transaccion(
            idTransaccion,
            request.getUsuarioId(),
            request.getCuentaOrigen(),
            request.getCuentaDestino(),
            request.getMonto(),
            "PENDIENTE"
        );
        transacciones.put(idTransaccion, transaccion);
        
        // Vulnerabilidad: No se firma la transacción (Repudiation)
        return ResponseEntity.ok("Transacción creada: " + idTransaccion);
    }

    @GetMapping("/transaccion/{id}")
    public ResponseEntity<Transaccion> consultarTransaccion(@PathVariable String id) {
        // Vulnerabilidad: No se valida el JWT en consulta (Information Disclosure)
        Transaccion transaccion = transacciones.get(id);
        if (transaccion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(transaccion);
    }

    @GetMapping("/generar-token")
    public ResponseEntity<String> generarToken(@RequestParam String usuarioId) {
        // Vulnerabilidad: Token sin claims de seguridad (Spoofing)
        SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
        
        String token = Jwts.builder()
            .setSubject(usuarioId)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hora
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();
        
        return ResponseEntity.ok(token);
    }

    @Data
    public static class TransaccionRequest {
        private String token;
        private String usuarioId;
        private String cuentaOrigen;
        private String cuentaDestino;
        private double monto;
    }

    @Data
    public static class Transaccion {
        private final String id;
        private final String usuarioId;
        private final String cuentaOrigen;
        private final String cuentaDestino;
        private final double monto;
        private String estado;
    }
}