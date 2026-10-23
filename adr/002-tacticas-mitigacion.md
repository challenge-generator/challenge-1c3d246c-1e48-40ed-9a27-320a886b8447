# ADR 002: Tácticas de Mitigación para Riesgos de Seguridad en API de Pagos

Estado: Propuesto
Fecha: 2024-MM-DD

## Contexto
Tras realizar el modelado de amenazas con STRIDE (ADR 001), se identificaron los siguientes riesgos prioritarios para la API de pagos:

1. **Spoofing**: Suplantación de identidad en endpoints de autenticación (ej. `/auth/token`).
2. **Tampering**: Alteración de payloads en tránsito (ej. montos de transacciones).
3. **Information Disclosure**: Exposición de datos sensibles en logs o respuestas de error.
4. **DoS**: Ataques de denegación de servicio en endpoints de alto tráfico (ej. `/payments`).
5. **Elevation of Privilege**: Escalada de privilegios mediante tokens JWT manipulados.

El equipo debe proponer tácticas de mitigación que:
- **Cumplan con OWASP Top 10** (ej. A1: Broken Access Control, A3: Injection).
- **Sean viables técnicamente** dentro del stack actual (Spring Boot 3.2.0, JWT, REST).
- **No degraden el rendimiento** más allá de los umbrales establecidos (p99 < 150ms).
- **Sean escalables** para manejar 25,000 TPS.

**Restricciones:**
- **Costo**: Presupuesto limitado para herramientas comerciales (ej. WAF de terceros).
- **Tiempo**: Implementación en < 4 semanas.
- **Regulatorio**: Cumplimiento con PCI-DSS v4.0 (requiere cifrado de datos en tránsito y reposo).

## Fuerzas
- **JWT como mecanismo de autenticación**: Los tokens son vulnerables a ataques si no se firman correctamente o si se usan algoritmos débiles (ej. `none`).
- **Comunicación con terceros**: Los socios comerciales acceden a la API mediante tokens, lo que aumenta el riesgo de Spoofing.
- **Alto volumen de transacciones**: Las tácticas de mitigación deben minimizar la latencia (ej. validación de firmas JWT debe ser < 5ms).
- **Legado técnico**: Algunos servicios internos no soportan TLS 1.3, lo que limita las opciones de cifrado.
- **Logs y monitoreo**: La falta de centralización dificulta la detección de ataques en tiempo real.

## Opciones consideradas
> Preguntas guía:
> 1. Para **Spoofing**: ¿Qué mecanismos de autenticación recomendarías (JWT con firmas robustas, OAuth 2.0, certificados X.509)? Compara pros/contras frente a los ASRs.
> 2. Para **Tampering**: ¿Qué técnicas de integridad de datos usarías (firmas digitales, HMAC, TLS 1.3)? ¿Cómo implementarlas sin afectar el rendimiento?
> 3. Para **Information Disclosure**: ¿Cómo protegerías los datos sensibles en logs y respuestas de error? ¿Qué herramientas usarías (masking, cifrado de logs)?
> 4. Para **DoS**: ¿Qué estrategias de mitigación propondrías (rate limiting, WAF, circuit breakers)? ¿Cómo escalarían para 25,000 TPS?
> 5. Para **Elevation of Privilege**: ¿Cómo validarías los tokens JWT para evitar escalada de privilegios (claims, scopes, RBAC)?

(En blanco: El candidato lista y analiza las opciones)

## Decisión
> Preguntas guía:
> 1. ¿Qué combinación de tácticas seleccionarías para mitigar los riesgos de **Spoofing** y **Tampering**? Justifica con datos del dominio.
> 2. ¿Cómo garantizarías que las tácticas elegidas no violan los ASRs (ej. rendimiento, disponibilidad)?
> 3. ¿Qué herramientas o librerías usarías para implementar las tácticas (ej. Spring Security, WAF open-source, librerías de cifrado)?

(En blanco)

## Consecuencias
> Preguntas guía:
> 1. ¿Qué impacto tendrán las tácticas seleccionadas en el rendimiento (ej. latencia, throughput)?
> 2. ¿Qué costos operativos introducirán (ej. mantenimiento de WAF, rotación de claves)?
> 3. ¿Cómo validarías la efectividad de las mitigaciones (ej. pruebas de penetración, monitoreo de métricas)?
> 4. ¿Qué riesgos residuales quedarán y cómo los gestionarías?

(En blanco)