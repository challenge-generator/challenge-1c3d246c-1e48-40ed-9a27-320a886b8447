# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `poc/security-spike.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `adr/001-modelado-amenazas-stride.md` — El topic pide decisiones de arquitectura: el ADR es el ejercicio.
- `adr/002-tacticas-mitigacion.md` — El topic pide decisiones de arquitectura: el ADR es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `poc/security-spike.java` — `TransaccionRequest.getToken`: Se invoca `getToken` sobre `TransaccionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `poc/security-spike.java` — `TransaccionRequest.getMonto`: Se invoca `getMonto` sobre `TransaccionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `poc/security-spike.java` — `TransaccionRequest.getUsuarioId`: Se invoca `getUsuarioId` sobre `TransaccionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `poc/security-spike.java` — `TransaccionRequest.getCuentaOrigen`: Se invoca `getCuentaOrigen` sobre `TransaccionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `poc/security-spike.java` — `TransaccionRequest.getCuentaDestino`: Se invoca `getCuentaDestino` sobre `TransaccionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
python3 -c "import glob,sys; assert glob.glob('adr/*.md') and glob.glob('diagramas/*.mmd'), 'faltan ADRs o diagramas'"
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Arquitectura, Especialidad Soluciones, Tecnología Arquitectura, Advanced

### Brecha de conocimiento
Ha diseñado arquitecturas que mitiguen los riesgos de seguridad a los que se enfrenta (al menos los más importantes OWASP Top 10 y STRIDE) y ha usado tácticas para minimizarlos en la arquitectura de solución y aplicación. Identifica los riesgos y los gestiona de manera oportuna.

### Misión / candidato
Candidato con experiencia en diseño de arquitecturas empresariales

### Reto
- Tema: Mitigación de riesgos de seguridad en arquitecturas: Identificación, gestión y tácticas
- Seniority: advanced-l3
- Tipo: practical
- Título: Modelado de Amenazas STRIDE para API de Pagos
- Tiempo estimado: 180 minutos

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Análisis de Riesgos — objetivo: Identificar y categorizar los riesgos de seguridad de la API de pagos — entregable (NO resolver): Lista de riesgos identificados categorizados por STRIDE
- Fase 2: Propuesta de Mitigación — objetivo: Proponer tácticas de mitigación para los riesgos identificados — entregable (NO resolver): Documento con tácticas de mitigación propuestas
- Fase 3: Plan de Gestión de Riesgos — objetivo: Documentar el plan de gestión de riesgos para la API de pagos — entregable (NO resolver): Plan de gestión de riesgos documentado
- Fase 4: Revisión y Validación — objetivo: Revisar y validar el diseño de mitigación de riesgos — entregable (NO resolver): Documento revisado y validado

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: poc/pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.2.0</version>
        <relativePath/>
    </parent>

    <groupId>com.banco.digital</groupId>
    <artifactId>security-spike</artifactId>
    <version>1.0.0</version>
    <name>security-spike</name>
    <description>Spike de seguridad para modelado de amenazas STRIDE en API de pagos</description>

    <properties>
        <java.version>17</java.version>
        <maven.compiler.source>${java.version}</maven.compiler.source>
        <maven.compiler.target>${java.version}</maven.compiler.target>
    </properties>

    <dependencies>
        <!-- Spring Boot Starter Security -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>

        <!-- JWT API -->
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-api</artifactId>
            <version>0.12.3</version>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-impl</artifactId>
            <version>0.12.3</version>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-jackson</artifactId>
            <version>0.12.3</version>
            <scope>runtime</scope>
        </dependency>

        <!-- Spring Boot Starter Web para exponer endpoints -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- Lombok para reducir boilerplate -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: README.md ===
# Modelado de Amenazas STRIDE para API de Pagos

## Contexto del Negocio

La API de pagos es un componente crítico del banco digital **BancoXYZ**, que procesa transacciones en tiempo real para más de 5 millones de usuarios activos. La API expone endpoints para:

- Transferencias entre cuentas (`POST /transfers`)
- Consulta de saldo (`GET /accounts/{id}/balance`)
- Historial de transacciones (`GET /accounts/{id}/transactions`)
- Pagos a terceros (`POST /payments`)

**Actores del sistema:**
- **Usuarios finales:** Clientes del banco que realizan transacciones desde la app móvil o web.
- **Sistema de autenticación:** Servidor OAuth2 que emite tokens JWT para autenticación.
- **Sistema de fraudes:** Servicio externo que evalúa transacciones sospechosas.
- **Sistema de liquidación:** Servicio interno que procesa las transferencias entre bancos.
- **Base de datos transaccional:** Almacena los registros de transacciones y saldos.

## Restricciones y Requisitos No Funcionales

### Restricciones de Seguridad (OWASP Top 10)
1. **A1: Broken Access Control**
   - Solo usuarios autenticados pueden acceder a los endpoints.
   - Los tokens JWT deben expirar en **15 minutos** para operaciones sensibles (transferencias/pagos).

2. **A2: Cryptographic Failures**
   - Todos los datos en tránsito deben usar TLS 1.3.
   - Los datos sensibles (números de cuenta, montos) deben cifrarse en reposo con AES-256.

3. **A3: Injection**
   - Validar y sanitizar todos los parámetros de entrada.
   - Usar prepared statements para consultas SQL.

4. **A6: Vulnerable and Outdated Components**
   - Todas las dependencias deben estar actualizadas a versiones sin CVEs conocidos.

5. **A7: Identification and Authentication Failures**
   - Implementar autenticación multifactor (MFA) para transacciones superiores a $1,000 USD.

### Requisitos Arquitectónicamente Significativos (ASRs)
| ASR                  | Valor Medible                          |
|----------------------|----------------------------------------|
| Disponibilidad       | 99.99% (máximo 52.56 minutos de downtime anual) |
| Latencia             | p99 < 100ms para consultas de saldo    |
| Integridad           | 0 transacciones alteradas en repositorio |
| Confidencialidad     | 0 fugas de datos sensibles en logs     |
| Capacidad            | 5,000 TPS con crecimiento del 20% anual |

## Amenazas Identificadas (Marco STRIDE)
El modelado inicial ha identificado las siguientes categorías de amenazas:
- **Suplantación (Spoofing):** Tokens JWT robados o credenciales débiles.
- **Alteración (Tampering):** Modificación de datos en tránsito o en reposo.
- **Repudio (Repudiation):** Usuarios niegan haber realizado transacciones.
- **Divulgación de Información (Information Disclosure):** Exposición de datos sensibles.
- **Denegación de Servicio (DoS):** Ataques que saturan la API.
- **Elevación de Privilegios (EoP):** Acceso no autorizado a endpoints.

## Entregables del Reto
Para completar este reto, debes entregar los siguientes artefactos:

1. **`atributos-de-calidad.md`**
   - Completar los escenarios de calidad para cada ASR identificado.

2. **`arquitectura.md`**
   - Definir la vista de contexto y contenedores del sistema, incluyendo flujos de seguridad.
   - Describir el sistema actual (as-is) y proponer mejoras (to-be) para mitigar riesgos.

3. **`adr/001-modelado-amenazas-stride.md`**
   - Analizar opciones de mitigación para las amenazas STRIDE.
   - Documentar la decisión tomada y sus consecuencias.

4. **`adr/002-tacticas-mitigacion.md`**
   - Proponer tácticas concretas (ej. WAF, cifrado, firmas digitales) y su alineación con OWASP Top 10.

5. **`diagramas/contexto.mmd`**
   - Actualizar el diagrama de contexto con los actores y flujos de seguridad.

6. **`riesgos-y-mitigaciones.md`** (no incluido en este lote)
   - Matriz de riesgos priorizados con acciones de mitigación.

7. **Spike de Seguridad (`poc/`)**
   - Implementar un prototipo mínimo que demuestre las tácticas de mitigación propuestas.

## Instrucciones para Entregar
1. Clona este repositorio y trabaja en una rama con tu nombre (`git checkout -b feature/<tu-nombre>`).
2. Completa los archivos marcados como **VACÍOS** o con preguntas guía.
3. Actualiza el diagrama `diagramas/contexto.mmd` usando Mermaid.
4. Genera un ZIP con tu solución y súbelo a la plataforma de evaluación.

## Herramientas Recomendadas
- **Modelado:** Mermaid.js (para diagramas C4), PlantUML.
- **Análisis de Riesgos:** OWASP ZAP, STRIDE.
- **Prototipado:** Spring Boot (para el spike de seguridad).

## Criterios de Evaluación
| Criterio                          | Excelente (5)                          | Aceptable (3)                        | Insuficiente (1)                     |
|----------------------------------|----------------------------------------|--------------------------------------|--------------------------------------|
| **Alineación con ASRs**          | Todos los ASRs cubiertos con métricas  | Algunos ASRs cubiertos               | ASRs no cubiertos o sin métricas     |
| **Uso de Patrones de Seguridad**  | Tacticas alineadas con OWASP Top 10   | Algunas tácticas alineadas           | Tácticas no alineadas               |
| **Calidad de Diagramas**          | Diagramas claros con contratos        | Diagramas con información incompleta | Diagramas ausentes o incorrectos     |
| **ADRs Completos**                | Opciones analizadas y decisión clara  | Opciones parciales                   | ADRs incompletos                    |
| **Viabilidad Técnica**            | Solución implementable y escalable    | Solución con limitaciones            | Solución inviable                    |

---

// === ARCHIVO: atributos-de-calidad.md ===
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

// === ARCHIVO: arquitectura.md ===
# Arquitectura del Sistema de Pagos

## Vista de Contexto (C4 Model)

> **Preguntas guía para completar el diagrama `diagramas/contexto.mmd`:**
> - ¿Qué actores externos interactúan con la API de pagos?
> - ¿Qué protocolos de comunicación se usan en cada frontera? (ej. REST + JWT, gRPC)
> - ¿Qué datos fluyen entre los actores y la API?

El sistema actual (as-is) opera en un entorno **monolítico** con las siguientes características:

- **Frontend:** Aplicación móvil y web desarrollada en React Native y Angular.
- **API Gateway:** Expone los endpoints de la API de pagos y enruta las peticiones.
- **Servicio de Autenticación:** Emite tokens JWT para autenticar usuarios.
- **Servicio de Pagos:** Procesa transacciones y se comunica con:
  - **Sistema de Fraudes:** Servicio externo para evaluar transacciones sospechosas.
  - **Sistema de Liquidación:** Servicio interno para procesar transferencias interbancarias.
  - **Base de Datos:** Almacena transacciones y saldos.

**Diagrama de contexto actual (as-is):**
```mermaid
C4Context
    title Contexto del Sistema de Pagos (as-is)
    System(apigateway, "API Gateway", "Expone endpoints REST")
    System(frontend, "Frontend", "React Native/Angular")
    System(auth, "Servicio de Autenticación", "Emite tokens JWT")
    System(fraudes, "Sistema de Fraudes", "Servicio externo")
    System(liquidacion, "Sistema de Liquidación", "Servicio interno")
    SystemDb(db, "Base de Datos", "PostgreSQL")
    System(pagos, "Servicio de Pagos", "Procesa transacciones")

    Rel(frontend, apigateway, "HTTPS", "JSON")
    Rel(apigateway, auth, "OAuth2", "JWT")
    Rel(apigateway, pagos, "REST", "JSON")
    Rel(pagos, fraudes, "gRPC", "Protobuf")
    Rel(pagos, liquidacion, "REST", "JSON")
    Rel(pagos, db, "JDBC", "SQL")
```

## Vista de Contenedores

> **Preguntas guía para completar la vista de contenedores:**
> - ¿Qué contenedores componen el sistema? (ej. API Gateway, Servicio de Pagos, Base de Datos)
> - ¿Qué tecnologías se usan en cada contenedor? (ej. Spring Boot, PostgreSQL)
> - ¿Cómo se comunican los contenedores? (ej. REST, gRPC, mensajería)
> - ¿Qué medidas de seguridad se implementan en cada frontera? (ej. TLS, JWT, WAF)

El sistema actual está compuesto por los siguientes contenedores:

| Contenedor            | Tecnología          | Responsabilidad                                                                 | Protocolos de Comunicación               |
|----------------------|---------------------|---------------------------------------------------------------------------------|------------------------------------------|
| API Gateway          | Kong                | Enrutamiento de peticiones, rate limiting, autenticación básica                | HTTPS, REST                              |
| Servicio de Autenticación | Spring Boot      | Emisión y validación de tokens JWT                                              | OAuth2, JWT                              |
| Servicio de Pagos    | Spring Boot         | Lógica de negocio para procesar transacciones                                  | REST, gRPC, JDBC                         |
| Sistema de Fraudes   | Python (FastAPI)    | Evaluación de transacciones sospechosas                                        | gRPC                                     |
| Sistema de Liquidación | Java (Quarkus)   | Procesamiento de transferencias interbancarias                                  | REST                                     |
| Base de Datos        | PostgreSQL          | Almacenamiento de transacciones y saldos                                        | JDBC                                     |

**Diagrama de contenedores actual (as-is):**
```mermaid
C4Container
    title Contenedores del Sistema de Pagos (as-is)
    Container(api, "API Gateway", "Kong", "Enruta peticiones")
    Container(auth, "Servicio de Autenticación", "Spring Boot", "Emite tokens JWT")
    Container(pagos, "Servicio de Pagos", "Spring Boot", "Procesa transacciones")
    Container(fraudes, "Sistema de Fraudes", "Python (FastAPI)", "Evalúa transacciones")
    Container(liquidacion, "Sistema de Liquidación", "Java (Quarkus)", "Procesa transferencias")
    ContainerDb(db, "Base de Datos", "PostgreSQL", "Almacena datos")

    Rel(frontend, api, "HTTPS", "JSON")
    Rel(api, auth, "OAuth2", "JWT")
    Rel(api, pagos, "REST", "JSON")
    Rel(pagos, fraudes, "gRPC", "Protobuf")
    Rel(pagos, liquidacion, "REST", "JSON")
    Rel(pagos, db, "JDBC", "SQL")
```

## Flujos Críticos de Seguridad

### Flujo de Autenticación
1. El frontend envía credenciales al **Servicio de Autenticación**.
2. El servicio valida las credenciales y emite un **token JWT** con claims (ej. `user_id`, `roles`).
3. El frontend incluye el token en las peticiones a la **API Gateway**.
4. La **API Gateway** valida el token y enruta la petición al **Servicio de Pagos**.

> **Preguntas guía para mejorar el flujo:**
> - ¿Qué medidas adicionales se pueden implementar para prevenir ataques de **suplantación**?
> - ¿Cómo se maneja la **expiración de tokens** para transacciones de larga duración?

### Flujo de Transferencias
1. El frontend envía una petición `POST /transfers` con el token JWT y los datos de la transferencia.
2. El **Servicio de Pagos** valida:
   - La firma del token.
   - El saldo disponible.
   - La integridad de los datos.
3. El servicio envía la transacción al **Sistema de Fraudes** para evaluación.
4. Si la transacción es aprobada, se actualiza la base de datos y se notifica al **Sistema de Liquidación**.

> **Preguntas guía para mejorar el flujo:**
> - ¿Qué tácticas se pueden usar para prevenir **alteración** de datos en tránsito?
> - ¿Cómo se garantiza el **no repudio** de las transacciones?
> - ¿Qué medidas se implementan para mitigar **denegación de servicio**?

## Sistema Propuesto (to-be)

> **Preguntas guía para definir el sistema to-be:**
> - ¿Qué componentes se añaden o modifican para mitigar las amenazas STRIDE?
> - ¿Qué patrones de seguridad se implementan? (ej. WAF, cifrado, firmas digitales)
> - ¿Cómo se distribuyen las responsabilidades de seguridad entre los contenedores?
> - ¿Qué métricas se usan para validar el cumplimiento de los ASRs?

**Cambios propuestos para el sistema to-be:**
1. **API Gateway:**
   - Implementar **WAF (Web Application Firewall)** para filtrar ataques OWASP Top 10.
   - Añadir **rate limiting** por IP y usuario.

2. **Servicio de Autenticación:**
   - Implementar **MFA (Autenticación Multifactor)** para transacciones sensibles.
   - Rotar claves de firma JWT cada **24 horas**.

3. **Servicio de Pagos:**
   - Cifrar datos sensibles en reposo con **AES-256**.
   - Firmar digitalmente las transacciones para garantizar integridad.
   - Implementar **idempotencia** para evitar duplicados.

4. **Base de Datos:**
   - Encriptar columnas sensibles (ej. números de cuenta, montos).
   - Implementar **auditoría de cambios** para detectar alteraciones.

5. **Monitoreo y Respuesta:**
   - Implementar **SIEM (Security Information and Event Management)** para correlacionar eventos.
   - Definir **runbooks** para incidentes de seguridad.

// === ARCHIVO: rubrica-autoevaluacion.md ===
# Rúbrica de Autoevaluación: Modelado de Amenazas STRIDE para API de Pagos

| Criterio                                      | Excelente (5)                                                                 | Aceptable (3)                                                                | Insuficiente (1)                                                          |
|-----------------------------------------------|------------------------------------------------------------------------------|------------------------------------------------------------------------------|---------------------------------------------------------------------------|
| **Alineación con OWASP Top 10**               | Todos los riesgos identificados están mapeados a OWASP Top 10 con ejemplos concretos y métricas cuantificables (ej. "A1: Broken Access Control → 3 vectores identificados"). | Riesgos mapeados a OWASP Top 10 sin ejemplos concretos o métricas.          | No hay mapeo claro a OWASP Top 10 o los riesgos identificados son genéricos. |
| **Uso de STRIDE**                             | Cada categoría de STRIDE (Spoofing, Tampering, Repudiation, Information Disclosure, DoS, Elevation of Privilege) tiene al menos 2 vectores de amenaza detallados con datos del dominio (ej. "Tampering: Modificación de payloads JWT en tránsito"). | Categorías de STRIDE cubiertas pero con ejemplos genéricos o sin datos del dominio. | Menos de 4 categorías de STRIDE cubiertas o ejemplos irrelevantes.        |
| **Calidad de los ADRs**                       | ADRs completos con contexto, fuerzas, opciones consideradas (mínimo 3 por ADR), decisión justificada con criterios medibles y consecuencias detalladas. | ADRs con contexto y fuerzas, pero opciones consideradas o decisión incompletas. | ADRs incompletos (falta contexto, fuerzas o decisión).                   |
| **Viabilidad del Plan de Gestión de Riesgos** | Plan incluye pasos concretos para incidentes (ej. "Aislar nodo comprometido en <5 minutos"), métricas de monitoreo (ej. "Alertas en tiempo real para intentos de DoS") y responsabilidades claras. | Plan con pasos genéricos o sin métricas de monitoreo.                      | Plan inexistente o con pasos irrelevantes para el dominio.                |
| **Uso de Herramientas y Patrones**           | Herramientas seleccionadas (WAF, cifrado, firmas) están justificadas frente a los ASRs y alineadas con estándares (ej. "WAF para mitigar A3: Injection"). Diagramas C4 muestran contratos en fronteras. | Herramientas mencionadas pero sin justificación clara frente a los ASRs.   | Herramientas seleccionadas no alineadas con OWASP Top 10 o STRIDE.         |
| **Diagramas y Documentación**                | Diagramas C4 (Mermaid) completos con actores, sistemas externos, contratos en fronteras (ej. "API REST + JWT") y justificación textual clara. Documentación técnica detallada. | Diagramas presentes pero con errores o falta de detalles en contratos.     | Diagramas ausentes o irrelevantes para el modelo de amenazas.            |

### Instrucciones para la Autoevaluación:
1. **Excelente**: Cumple TODOS los criterios de la columna con ejemplos concretos y métricas.
2. **Aceptable**: Cumple la mayoría de criterios, pero con lagunas en ejemplos o métricas.
3. **Insuficiente**: No cumple con los criterios mínimos o los ejemplos son irrelevantes.

> **Nota**: Esta rúbrica evalúa la calidad técnica y la alineación con los estándares de seguridad. Los entregables deben ser autoexplicativos y justificados con datos del dominio.

// === ARCHIVO: adr/001-modelado-amenazas-stride.md ===
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

// === ARCHIVO: adr/002-tacticas-mitigacion.md ===
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

// === ARCHIVO: diagramas/contexto.mmd ===
```mermaid
C4Context
    title Diagrama de Contexto - API de Pagos del Banco Digital
    
    Person(usuario, "Usuario", "Cliente del banco digital")
    Person(soporte, "Soporte Técnico", "Equipo de soporte del banco")
    System_Boundary(c1, "Banco Digital") {
        System(apiPagos, "API de Pagos", "Procesa transacciones en tiempo real")
        System(sistemaAutorizacion, "Sistema de Autorización", "Valida permisos y roles")
        System(monitorizacion, "Sistema de Monitorización", "Supervisa transacciones y alertas")
    }
    
    System_Ext(proveedorServicios, "Proveedor de Servicios Externos", "Procesador de pagos tercerizado")
    System_Ext(redInterbancaria, "Red Interbancaria", "Facilita transferencias entre bancos")
    
    Rel(usuario, apiPagos, "Realiza transacciones", "HTTPS")
    Rel(soporte, monitorizacion, "Supervisa alertas", "HTTPS")
    Rel(apiPagos, sistemaAutorizacion, "Valida permisos", "gRPC")
    Rel(apiPagos, proveedorServicios, "Procesa pagos", "REST")
    Rel(apiPagos, redInterbancaria, "Transferencias", "SOAP")
    Rel(monitorizacion, apiPagos, "Monitorea transacciones", "Prometheus")

    UpdateLayoutConfig($c4ShapeInRow="3", $c4BoundaryInRow="1")
```

---

> **Preguntas guía para completar el diagrama:**
> 1. ¿Qué otros actores externos interactúan con la API de pagos? Ejemplos: auditoría externa, proveedores de identidad.
> 2. ¿Qué protocolos de comunicación se utilizan en cada frontera? ¿Son seguros?
> 3. ¿Existen relaciones de confianza implícitas entre sistemas que deban documentarse?
> 4. ¿Cómo afectaría un ataque de suplantación (Spoofing) en cada una de estas relaciones?
> 5. ¿Qué medidas de protección existen actualmente en cada frontera?

// === ARCHIVO: poc/security-spike.java ===
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

// === ARCHIVO: poc/README.md ===
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
```
