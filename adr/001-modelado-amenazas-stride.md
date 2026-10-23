# ADR 001: Modelado de Amenazas Usando STRIDE

Estado: Propuesto
Fecha: 2024-MM-DD

## Contexto
La API de pagos del banco digital procesa transacciones en tiempo real para clientes y socios comerciales. La arquitectura actual expone endpoints REST que manejan datos sensibles (ej. números de tarjeta, montos de transacciones) y está sujeta a regulaciones como PCI-DSS y GDPR. El equipo de seguridad ha identificado la necesidad de realizar un modelado de amenazas formal para:

1. **Identificar vectores de ataque** en componentes críticos (ej. servicio de autenticación, procesador de pagos, cola de eventos).
2. **Categorizar riesgos** usando STRIDE (Spoofing, Tampering, Repudiation, Information Disclosure, DoS, Elevation of Privilege).
3. **Priorizar mitigaciones** basadas en impacto y probabilidad, alineadas con OWASP Top 10.

**ASRs (Requisitos Arquitectónicamente Significativos):**
- **Disponibilidad**: 99.95% uptime (máximo 21.9 minutos de downtime/mes).
- **Seguridad**: Cero fugas de datos sensibles en los últimos 12 meses.
- **Rendimiento**: p99 < 150ms para transacciones de alto volumen (25,000 TPS).
- **Conformidad**: Cumplimiento con PCI-DSS v4.0 y GDPR.

## Fuerzas
- **Exposición pública**: La API es accesible desde internet, aumentando la superficie de ataque.
- **Datos sensibles**: Maneja información financiera regulada (PCI-DSS), lo que exige controles estrictos.
- **Alto volumen**: 25,000 transacciones por segundo en horas pico, lo que dificulta la detección de ataques en tiempo real.
- **Integración con terceros**: Socios comerciales acceden a la API mediante tokens JWT, lo que introduce riesgos de suplantación (Spoofing).
- **Legado técnico**: Algunos componentes internos (ej. servicio de autenticación) usan tecnologías obsoletas sin soporte para cifrado moderno.

## Opciones consideradas
> Preguntas guía:
> 1. ¿Qué metodologías de modelado de amenazas (STRIDE, DREAD, PASTA) son más adecuadas para este dominio? ¿Por qué STRIDE es la mejor opción aquí?
> 2. ¿Cómo categorizarías los vectores de amenaza identificados según STRIDE? Proporciona ejemplos concretos para cada categoría.
> 3. ¿Qué herramientas (OWASP ZAP, Threat Dragon, Microsoft Threat Modeling Tool) recomendarías para automatizar el modelado? Justifica tu elección.
> 4. ¿Qué métricas usarías para priorizar los riesgos identificados (ej. impacto vs. probabilidad, matriz de riesgo)?

(En blanco: El candidato lista y analiza las opciones)

## Decisión
> Preguntas guía:
> 1. ¿Qué categorías de STRIDE presentan los mayores riesgos para la API de pagos? Justifica con datos del dominio.
> 2. ¿Cómo alineas las tácticas de mitigación propuestas con los ASRs (ej. disponibilidad, seguridad)?
> 3. ¿Qué decisiones tomarías para mitigar los riesgos de **Spoofing** y **Tampering** en el flujo de autenticación (JWT)?

(En blanco)

## Consecuencias
> Preguntas guía:
> 1. ¿Qué impacto tendrá la implementación de las mitigaciones en los ASRs (ej. rendimiento, costo)?
> 2. ¿Qué riesgos residuales quedarán después de aplicar las tácticas propuestas? ¿Cómo los gestionarías?
> 3. ¿Cómo validarías que las mitigaciones son efectivas (ej. pruebas de penetración, monitoreo)?

(En blanco)