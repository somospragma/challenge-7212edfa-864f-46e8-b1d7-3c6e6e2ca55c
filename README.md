# Implementación de un Sistema de Gestión de Biblioteca con OOP

El sistema de gestión de biblioteca necesita registrar libros, usuarios y préstamos. Cada libro tiene título, autor, año de publicación y disponibilidad. Cada usuario tiene nombre y número de membresía. Los préstamos registran qué libro ha sido prestado a qué usuario y la fecha de devolución esperada. El sistema debe asegurar que los libros no se presten si no están disponibles y que los usuarios no puedan prestar más de tres libros a la vez.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Desarrollo de Software con OOP |
| **Nivel** | junior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 3-4 horas |

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

### Fase 1: Modelado de Entidades

**Objetivo:** Definir las clases básicas para libros, usuarios y préstamos.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Identifica los atributos necesarios para cada entidad.
- Define las relaciones entre las entidades.

**Entregable:** Clases básicas de Libro, Usuario y Préstamo.

<details>
<summary>Pistas de conocimiento</summary>

- Recuerda que cada entidad debe tener atributos que la describan completamente.
- Las relaciones entre entidades pueden ser representadas como atributos de las clases.

</details>

### Fase 2: Implementación de Métodos

**Objetivo:** Agregar métodos para realizar operaciones básicas en el sistema.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Implementa métodos para agregar y eliminar libros, usuarios y préstamos.
- Asegura que los métodos respeten las reglas de negocio definidas.

**Entregable:** Métodos para operaciones básicas en Libro, Usuario y Préstamo.

<details>
<summary>Pistas de conocimiento</summary>

- Recuerda que los métodos deben reflejar las acciones que se pueden realizar con las entidades.
- Las reglas de negocio, como la disponibilidad de libros y el límite de préstamos por usuario, deben ser respetadas.

</details>

### Fase 3: Gestión de Préstamos

**Objetivo:** Implementar la lógica para gestionar préstamos, incluyendo validaciones y restricciones.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Implementa la lógica para prestar y devolver libros.
- Asegura que el sistema no permita préstamos si el libro no está disponible o si el usuario ya ha alcanzado el límite de préstamos.

**Entregable:** Lógica completa para gestionar préstamos.

<details>
<summary>Pistas de conocimiento</summary>

- Recuerda que la disponibilidad de un libro y el límite de préstamos por usuario son restricciones importantes.
- Piensa en cómo manejarías los casos en los que un usuario intenta prestar más libros de los permitidos.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué representa la clase Libro en nuestro sistema?
- **paraQueSirve**: ¿Para qué sirve el método para agregar un libro en la clase Biblioteca?
- **comoSeUsa**: ¿Cómo se usa la relación entre un préstamo y un libro en nuestro sistema?
- **erroresComunes**: ¿Qué error común podrías encontrar al intentar prestar un libro no disponible?
- **queDecisionesImplica**: ¿Qué decisiones debes tomar al implementar la lógica para devolver un libro?

## Criterios de Evaluacion

- Definición de clases Libro, Usuario y Préstamo.
- Implementación de métodos para operaciones básicas.
- Lógica para gestionar préstamos con validaciones y restricciones.

---

*Reto generado automaticamente por Challenge Generator - Pragma*
