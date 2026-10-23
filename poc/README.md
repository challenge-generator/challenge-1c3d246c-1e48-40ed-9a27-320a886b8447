# Spike de Seguridad - API de Pagos

## Descripción
Este spike simula una API de pagos con vulnerabilidades de seguridad **intencionales** para que el candidato:
1. Identifique los riesgos usando el marco STRIDE.
2. Proponga tácticas de mitigación alineadas con OWASP Top 10.
3. Implemente las soluciones en el código.

## Vulnerabilidades Incluidas
| Tipo STRIDE       | Vulnerabilidad                          | Ubicación en Código                     |
|-------------------|----------------------------------------|-----------------------------------------|
| **Spoofing**      | JWT sin validación                      | `POST /api/pagos/transaccion`           |
| **Tampering**     | Monto de transacción sin validación    | `TransaccionRequest`                    |
| **Repudiation**   | Transacciones sin firma digital         | `crearTransaccion()`                    |
| **Information Disclosure** | Mensajes de error detallados      | `catch` en validación de JWT            |
| **Denial of Service** | Sin límites de tasa                | Todos los endpoints                     |

## Instrucciones para Ejecutar
1. **Requisitos**:
   - Java 17+
   - Maven 3.8+

2. **Compilar y ejecutar**:
   ```bash
   cd poc
   mvn spring-boot:run
   ```

3. **Endpoints disponibles**:
   - `POST /api/pagos/transaccion` - Crea una transacción
   - `GET /api/pagos/transaccion/{id}` - Consulta una transacción
   - `GET /api/pagos/generar-token?usuarioId=123` - Genera un JWT

## Qué se Espera que el Candidato Resuelva
1. **Modelado de amenazas**: Documentar en `adr/001-modelado-amenazas-stride.md` los riesgos identificados.
2. **Mitigación**: Implementar en el código:
   - Validación de JWT con claims requeridos (ej. `roles`, `expiration`).
   - Firma digital para transacciones.
   - Límites de tasa en endpoints.
   - Cifrado de datos sensibles.
3. **Plan de gestión**: Documentar en `adr/002-tacticas-mitigacion.md` el plan de respuesta a incidentes.

## Ejemplo de Request Vulnerable
```bash
curl -X POST http://localhost:8080/api/pagos/transaccion \
  -H "Content-Type: application/json" \
  -d '{"token":"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMjMifQ.invalid-signature", "usuarioId":"123", "cuentaOrigen":"ACC1", "cuentaDestino":"ACC2", "monto":100.50}'
```

> **Nota**: El token en este ejemplo es inválido, pero la API lo acepta si no se valida correctamente.