# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Modelado de Amenazas STRIDE para API de Pagos**.

| | |
|---|---|
| Tema | Mitigación de riesgos de seguridad en arquitecturas: Identificación, gestión y tácticas |
| Nivel | advanced-l3 |
| Chapter | Arquitectura |
| Especialidad | Soluciones |
| Stack | Markdown / STRIDE + OWASP Top 10 |
| Patron arquitectonico | Modelado de amenazas C4 + ADR + Plan de gestión de riesgos |
| Tiempo estimado | 180 minutos |

## Receta del stack

Esqueleto obligatorio:

- `adr/`
- `arquitectura.md`
- `diagramas/*.mmd`
- `atributos-de-calidad.md`
- `rubrica-autoevaluacion.md`
- `poc/ (opcional)`

Dependencias:

- Mermaid.js n/a
- PlantUML n/a
- Spring Boot Starter Security 3.2.0
- jjwt-api 0.12.3
- OWASP ZAP n/a

## Tu tarea

Dejar este conjunto de artefactos en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `python3 -c "import glob,sys; assert glob.glob('adr/*.md') and glob.glob('diagramas/*.mmd'), 'faltan ADRs o diagramas'"` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `python3 -c "import glob,sys; assert glob.glob('adr/*.md') and glob.glob('diagramas/*.mmd'), 'faltan ADRs o diagramas'"` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Análisis de Riesgos**: Lista de riesgos identificados categorizados por STRIDE
- **Fase 2 — Propuesta de Mitigación**: Documento con tácticas de mitigación propuestas
- **Fase 3 — Plan de Gestión de Riesgos**: Plan de gestión de riesgos documentado
- **Fase 4 — Revisión y Validación**: Documento revisado y validado

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `poc/security-spike.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `adr/001-modelado-amenazas-stride.md` — El topic pide decisiones de arquitectura: el ADR es el ejercicio.
- [ ] `adr/002-tacticas-mitigacion.md` — El topic pide decisiones de arquitectura: el ADR es el ejercicio.

## Lo que falta y tenes que completar

### 1. Referencias colgando (5)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `poc/security-spike.java` — `TransaccionRequest.getToken`
      Se invoca `getToken` sobre `TransaccionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `poc/security-spike.java` — `TransaccionRequest.getMonto`
      Se invoca `getMonto` sobre `TransaccionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `poc/security-spike.java` — `TransaccionRequest.getUsuarioId`
      Se invoca `getUsuarioId` sobre `TransaccionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `poc/security-spike.java` — `TransaccionRequest.getCuentaOrigen`
      Se invoca `getCuentaOrigen` sobre `TransaccionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `poc/security-spike.java` — `TransaccionRequest.getCuentaDestino`
      Se invoca `getCuentaDestino` sobre `TransaccionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (10)

- `poc/pom.xml`
- `README.md`
- `atributos-de-calidad.md`
- `arquitectura.md`
- `rubrica-autoevaluacion.md`
- `adr/001-modelado-amenazas-stride.md`
- `adr/002-tacticas-mitigacion.md`
- `diagramas/contexto.mmd`
- `poc/security-spike.java`
- `poc/README.md`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `adr`
- `diagramas`
- `riesgos`
- `poc`

## Verificacion

```bash
python3 -c "import glob,sys; assert glob.glob('adr/*.md') and glob.glob('diagramas/*.mmd'), 'faltan ADRs o diagramas'"
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **Modelado de amenazas C4 + ADR + Plan de gestión de riesgos**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Arquitectura, Especialidad Soluciones, Tecnología Arquitectura, Advanced
- Brecha que el reto ataca: Ha diseñado arquitecturas que mitiguen los riesgos de seguridad a los que se enfrenta (al menos los más importantes OWASP Top 10 y STRIDE) y ha usado tácticas para minimizarlos en la arquitectura de solución y aplicación. Identifica los riesgos y los gestiona de manera oportuna.
- Mision: Candidato con experiencia en diseño de arquitecturas empresariales

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
