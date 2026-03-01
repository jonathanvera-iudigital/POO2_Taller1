# Gestión de Empleados y Empresas (Java)

Aplicación en Java (JOptionPane) para gestionar empresas y empleados usando POO:
herencia, polimorfismo, abstracción y encapsulamiento.

---

## Requisitos previos

- Java JDK 17 o superior → https://www.oracle.com/java/technologies/downloads/

Verifica que esté instalado:

```bash
java -version
javac -version
```

Debes ver algo como `javac 17.x.x`. Si no, instala el JDK antes de continuar.

---

## Estructura del proyecto

```
Taller1/
├── README.md
├── Main.java
├── modelos/
│   ├── Empleado.java
│   ├── Desarrollador.java
│   ├── GestorProyectos.java
│   ├── Admin.java
│   ├── Empresa.java
│   └── EmpresaDesarrollo.java
└── operaciones/
    ├── IOperacionEmpleado.java
    ├── IOperacionEmpresa.java
    ├── OperacionEmpleado.java
    └── OperacionEmpresa.java
```

---

## Compilar y ejecutar

### Windows (PowerShell o CMD)

```powershell
# 1. Entra a la carpeta POO2_Taller1
cd POO2_Taller1

# 2. Compila todas las clases
javac modelos\*.java operaciones\*.java Main.java

# 3. Ejecuta
java Main
```

### Linux / macOS

```bash
# 1. Entra a la carpeta POO2_Taller1
cd POO2_Taller1

# 2. Compila todas las clases
javac modelos/*.java operaciones/*.java Main.java

# 3. Ejecuta
java Main
```

> El programa abre ventanas gráficas (JOptionPane). Asegúrate de tener
> entorno gráfico disponible (no funciona en servidores sin GUI).

---

## Uso básico

Al ejecutar aparece un menú en ventana con las siguientes opciones:

```
╔══════════════════════════════╗
║     GESTIÓN DE EMPLEADOS     ║
╠══════════════════════════════╣
║  1. Registrar empresa        ║
║  2. Listar empresas          ║
║  3. Registrar empleado       ║
║  4. Listar empleados         ║
║  5. Buscar empleado por doc  ║
║  6. Calcular sueldo          ║
║  7. Contar empls. en empresa ║
║  0. Salir                    ║
╚══════════════════════════════╝
```

**Flujo recomendado:**
1. Registra al menos una empresa (opción `1`) antes de crear empleados.
2. Registra empleados asignándoles una empresa por NIT (opción `3`).
3. Usa las demás opciones para consultar, buscar y calcular sueldos.

---

## Notas importantes

- Los datos se almacenan en memoria (ArrayList); al cerrar el programa se pierden.
- El documento de cada empleado debe ser único; el sistema rechaza duplicados.
- Para cerrar el programa usa la opción `0` del menú.

---

## Solución de errores comunes

| Error | Causa | Solución |
|---|---|---|
| `javac: command not found` | JDK no instalado o no en el PATH | Instala JDK 17+ y agrega al PATH |
| `error: package modelos does not exist` | Compilando desde la carpeta incorrecta | Asegúrate de estar dentro de `src/` al compilar |
| `Could not initialize class javax.swing` | Sin entorno gráfico | Ejecuta en un sistema con GUI (Windows/macOS/Linux de escritorio) |

---

## Autor

Jonathan Raúl Vera Gómez

Ingeniería de Sistemas y Ciencia de Datos — Semestre 4
