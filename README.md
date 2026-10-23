# Modelado de Amenazas STRIDE para API de Pagos

Como arquitecto de soluciones, debes realizar el modelado de amenazas sobre una API de pagos utilizando el marco STRIDE. La API de pagos es utilizada por un banco digital para procesar transacciones en tiempo real. Debes identificar vectores de suplantación, alteración y denegación de servicio, proponer tácticas de mitigación (WAF, cifrado, firmas) y documentar el plan de gestión del riesgo. La arquitectura debe cumplir con los estándares de seguridad OWASP Top 10 y STRIDE.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Mitigación de riesgos de seguridad en arquitecturas: Identificación, gestión y tácticas |
| **Nivel** | advanced-l3 |
| **Tipo** | practical |
| **Tiempo estimado** | 180 minutos |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Análisis de Riesgos

**Objetivo:** Identificar y categorizar los riesgos de seguridad de la API de pagos

**Tiempo estimado:** 30 minutos

**Instrucciones:**

- Identifica los vectores de ataque utilizando el marco STRIDE.
- Clasifica los riesgos según su impacto y probabilidad.

**Entregable:** Lista de riesgos identificados categorizados por STRIDE

<details>
<summary>Pistas de conocimiento</summary>

- Considera los OWASP Top 10 y las tácticas de STRIDE.
- Piensa en los posibles atacantes y sus motivaciones.

</details>

### Fase 2: Propuesta de Mitigación

**Objetivo:** Proponer tácticas de mitigación para los riesgos identificados

**Tiempo estimado:** 60 minutos

**Instrucciones:**

- Propón tácticas de mitigación para cada riesgo identificado.
- Evalúa las opciones disponibles y selecciona las más adecuadas.

**Entregable:** Documento con tácticas de mitigación propuestas

<details>
<summary>Pistas de conocimiento</summary>

- Considera el uso de WAF, cifrado y firmas digitales.
- Evalúa los pros y contras de cada opción.

</details>

### Fase 3: Plan de Gestión de Riesgos

**Objetivo:** Documentar el plan de gestión de riesgos para la API de pagos

**Tiempo estimado:** 60 minutos

**Instrucciones:**

- Documenta el plan de gestión de riesgos para la API de pagos.
- Incluye las tácticas de mitigación propuestas y los pasos a seguir en caso de incidente.

**Entregable:** Plan de gestión de riesgos documentado

<details>
<summary>Pistas de conocimiento</summary>

- Considera la documentación formal y la comunicación con los stakeholders.
- Piensa en los pasos a seguir en caso de incidente.

</details>

### Fase 4: Revisión y Validación

**Objetivo:** Revisar y validar el diseño de mitigación de riesgos

**Tiempo estimado:** 30 minutos

**Instrucciones:**

- Revisa y valida el diseño de mitigación de riesgos.
- Identifica posibles mejoras y ajustes necesarios.

**Entregable:** Documento revisado y validado

<details>
<summary>Pistas de conocimiento</summary>

- Considera la retroalimentación de los stakeholders.
- Piensa en posibles mejoras y ajustes.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es el modelado de amenazas y por qué es importante en la arquitectura de soluciones?
- **paraQueSirve**: ¿Para qué sirve el marco STRIDE en el modelado de amenazas?
- **comoSeUsa**: ¿Cómo se utilizan las tácticas de mitigación propuestas en la protección de la API de pagos?
- **erroresComunes**: ¿Cuáles son los errores comunes al identificar y mitigar riesgos de seguridad en arquitecturas?
- **queDecisionesImplica**: ¿Qué decisiones implica el diseño de un plan de gestión de riesgos para la API de pagos?

## Criterios de Evaluacion

- Alineación del diseño con los estándares OWASP Top 10 y STRIDE.
- Propuesta de tácticas de mitigación efectivas y justificadas.
- Documentación clara y completa del plan de gestión de riesgos.
- Revisión y validación del diseño con retroalimentación de stakeholders.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
python3 -c "import glob,sys; assert glob.glob('adr/*.md') and glob.glob('diagramas/*.mmd'), 'faltan ADRs o diagramas'"
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
