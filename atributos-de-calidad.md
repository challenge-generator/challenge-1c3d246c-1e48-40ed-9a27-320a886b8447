# Atributos de Calidad para la API de Pagos

## Requisitos Arquitectónicamente Significativos (ASRs)

| ASR                  | Descripción                                                                 | Valor Medible                          |
|----------------------|-----------------------------------------------------------------------------|----------------------------------------|
| Disponibilidad       | La API debe estar disponible para procesar transacciones en todo momento.   | 99.99% (máximo 52.56 minutos de downtime anual) |
| Latencia             | Los endpoints críticos deben responder rápidamente.                        | p99 < 100ms para consultas de saldo    |
| Integridad           | Los datos de transacciones no deben ser alterados.                          | 0 transacciones alteradas en repositorio |
| Confidencialidad     | Los datos sensibles no deben ser expuestos.                                | 0 fugas de datos sensibles en logs     |
| Capacidad            | La API debe manejar un alto volumen de transacciones.                       | 5,000 TPS con crecimiento del 20% anual |

## Escenarios de Calidad

Los escenarios de calidad siguen el formato **ISO 25010** (fuente, estímulo, artefacto, entorno, respuesta, medida). Completa cada escenario para los ASRs identificados.

### Disponibilidad

| Fuente               | Estímulo                          | Artefacto               | Entorno                     | Respuesta                                                                 | Medida                          |
|----------------------|------------------------------------|-------------------------------|-----------------------------|--------------------------------------------------------------------------------|----------------------------------|
| Usuario final        | Intento de acceso durante pico     | Endpoint `/transfers`          | Producción, carga alta       |                                                                                 |                                  |
| Sistema de monitoreo | Detección de fallo en nodo         | Servicio de autenticación       | Producción                   |                                                                                 | Tiempo de recuperación < 5 min   |

### Latencia

| Fuente               | Estímulo                          | Artefacto               | Entorno                     | Respuesta                                                                 | Medida                          |
|----------------------|------------------------------------|-------------------------------|-----------------------------|--------------------------------------------------------------------------------|----------------------------------|
| Usuario final        | Consulta de saldo                  | Endpoint `/accounts/{id}/balance` | Producción                  |                                                                                 | p99 < 100ms                      |

### Integridad

| Fuente               | Estímulo                          | Artefacto               | Entorno                     | Respuesta                                                                 | Medida                          |
|----------------------|------------------------------------|-------------------------------|-----------------------------|--------------------------------------------------------------------------------|----------------------------------|
| Sistema de fraudes   | Detección de transacción alterada  | Base de datos transaccional     | Producción                   |                                                                                 | 0 transacciones alteradas        |

### Confidencialidad

| Fuente               | Estímulo                          | Artefacto               | Entorno                     | Respuesta                                                                 | Medida                          |
|----------------------|------------------------------------|-------------------------------|-----------------------------|--------------------------------------------------------------------------------|----------------------------------|
| Auditoría            | Revisión de logs                   | Logs de la API                  | Producción                   |                                                                                 | 0 datos sensibles en logs        |

### Capacidad

| Fuente               | Estímulo                          | Artefacto               | Entorno                     | Respuesta                                                                 | Medida                          |
|----------------------|------------------------------------|-------------------------------|-----------------------------|--------------------------------------------------------------------------------|----------------------------------|
| Sistema de carga     | 5,000 TPS                          | Endpoint `/payments`            | Producción                   |                                                                                 | Latencia p99 < 200ms             |

## Preguntas Guía para Completar Escenarios
1. **Fuente:** ¿Quién o qué desencadena el escenario? (ej. usuario, sistema externo, cron job)
2. **Estímulo:** ¿Qué evento o condición dispara el escenario? (ej. pico de tráfico, intento de ataque)
3. **Artefacto:** ¿Qué componente del sistema se ve afectado? (ej. endpoint, base de datos, servicio)
4. **Entorno:** ¿En qué condiciones ocurre el escenario? (ej. producción, carga alta, mantenimiento)
5. **Respuesta:** ¿Qué debe hacer el sistema ante el estímulo? (ej. rechazar transacción, alertar, escalar)
6. **Medida:** ¿Cómo se cuantifica el éxito de la respuesta? (ej. tiempo de recuperación, tasa de errores)

---