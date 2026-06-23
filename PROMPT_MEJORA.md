# Prompt para Mejorar el Codigo Base

Copia y pega el siguiente contenido completo en un asistente de IA (Claude, ChatGPT, etc.)
para obtener un ZIP con el proyecto corregido y listo para compilar.

---

```
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
Si la cadena contiene solo documentación o descripciones sin código, genera los archivos
correspondientes sin aplicar análisis de compilación
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:
// === ARCHIVO: src/main/java/com/pragma/library/model/Book.java ===
package com.pragma.library.model;

public record Book(String title, String author, int publicationYear, boolean available) {}

// === ARCHIVO: src/main/java/com/pragma/library/model/User.java ===
package com.pragma.library.model;

public record User(String name, int membershipNumber) {}

// === ARCHIVO: src/main/java/com/pragma/library/model/Loan.java ===
package com.pragma.library.model;

import java.time.LocalDate;

public record Loan(Book book, User user, LocalDate expectedReturnDate) {}

// === ARCHIVO: src/main/java/com/pragma/library/service/BookService.java ===
package com.pragma.library.service;

import com.pragma.library.model.Book;
import com.pragma.library.model.Loan;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book findBookByTitle(String title) {
        return books.stream()
               .filter(book -> book.title().equals(title))
               .findFirst()
               .orElse(null);
    }
}

// === ARCHIVO: src/main/java/com/pragma/library/service/UserService.java ===
package com.pragma.library.service;

import com.pragma.library.model.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public User findUserByMembershipNumber(int membershipNumber) {
        return users.stream()
               .filter(user -> user.membershipNumber() == membershipNumber)
               .findFirst()
               .orElse(null);
    }
}

// === ARCHIVO: src/main/java/com/pragma/library/service/LoanService.java ===
package com.pragma.library.service;

import com.pragma.library.model.Book;
import com.pragma.library.model.Loan;
import com.pragma.library.model.User;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {
    private final List<Loan> loans = new ArrayList<>();
    private final BookService bookService;
    private final UserService userService;

    public LoanService(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    public void loanBook(Book book, User user, LocalDate expectedReturnDate) {
        if (book.available() && user.loans().size() < 3) {
            book.setAvailable(false);
            loans.add(new Loan(book, user, expectedReturnDate));
        } else {
            throw new RuntimeException("No se puede prestar el libro.");
        }
    }

    public void returnBook(Loan loan) {
        loan.book().setAvailable(true);
        loans.remove(loan);
    }

    public List<Loan> getLoans() {
        return loans;
    }
}

// === ARCHIVO: src/main/java/com/pragma/library/controller/LibraryController.java ===
package com.pragma.library.controller;

import com.pragma.library.model.Book;
import com.pragma.library.model.User;
import com.pragma.library.service.BookService;
import com.pragma.library.service.LoanService;
import com.pragma.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {
    private final BookService bookService;
    private final UserService userService;
    private final LoanService loanService;

    @Autowired
    public LibraryController(BookService bookService, UserService userService, LoanService loanService) {
        this.bookService = bookService;
        this.userService = userService;
        this.loanService = loanService;
    }

    @PostMapping("/books")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @DeleteMapping("/books/{title}")
    public void removeBook(@PathVariable String title) {
        Book book = bookService.findBookByTitle(title);
        if (book!= null) {
            bookService.removeBook(book);
        }
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @DeleteMapping("/users/{membershipNumber}")
    public void removeUser(@PathVariable int membershipNumber) {
        User user = userService.findUserByMembershipNumber(membershipNumber);
        if (user!= null) {
            userService.removeUser(user);
        }
    }

    @PostMapping("/loans")
    public void loanBook(@RequestParam String bookTitle, @RequestParam int userMembershipNumber, @RequestParam LocalDate expectedReturnDate) {
        Book book = bookService.findBookByTitle(bookTitle);
        User user = userService.findUserByMembershipNumber(userMembershipNumber);
        if (book!= null && user!= null) {
            loanService.loanBook(book, user, expectedReturnDate);
        }
    }

    @DeleteMapping("/loans/{bookTitle}")
    public void returnBook(@PathVariable String bookTitle) {
        Loan loan = loanService.getLoans().stream()
               .filter(l -> l.book().title().equals(bookTitle))
               .findFirst()
               .orElse(null);
        if (loan!= null) {
            loanService.returnBook(loan);
        }
    }
}

// === ARCHIVO: src/main/resources/application.properties ===
server.port=8080

// === ARCHIVO: src/main/java/com/pragma/library/LibraryApplication.java ===
package com.pragma.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication {
    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }
}

// === ARCHIVO: pom.xml ===
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.pragma</groupId>
    <artifactId>library</artifactId>
    <version>1.0-SNAPSHOT</version>
    <properties>
        <java.version>21</java.version>
        <spring-boot.version>3.2.0</spring-boot.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <version>${spring-boot.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
            <version>${spring-boot.version}</version>
        </dependency>
    </dependencies>
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <version>${spring-boot.version}</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>repackage</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>
```
