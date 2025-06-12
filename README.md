# 🧪 Prueba Técnica Siigo - Automatización Backend

Este proyecto fue desarrollado como parte de una **prueba técnica** para validar servicios backend utilizando **Serenity BDD, Cucumber y JUnit**. 
Implementa una arquitectura clara basada en BDD y está orientado a la ejecución de pruebas automatizadas de servicios REST.

---

## 🚀 Tecnologías Utilizadas

- **Lenguaje:** Java 11
- **Frameworks:** Serenity BDD, Cucumber, JUnit
- **Estilo de pruebas:** BDD (Gherkin)
- **Gestor de dependencias:** Maven
- **Reportes:** Serenity Reports

---

## 📁 Estructura del Proyecto

src/test/java/
├── features/ # Escenarios en lenguaje Gherkin (.feature)
├── runners/ # Clases para ejecutar los features
├── stepdefinitions/ # Implementación de los pasos
├── utils/ # Clases utilitarias de soporte


---

## ✅ ¿Qué validaciones incluye?

- Pruebas E2E sobre servicios REST
- Validaciones de respuesta (status, body, contenido esperado)
- Escenarios positivos y negativos
- Diseño modular y mantenible

---

## 🔧 Cómo ejecutar el proyecto

### Requisitos previos

- Java 11+
- Maven 3.6+
- Git

### Pasos

1. Clonar el repositorio:

```bash
git clone https://github.com/fsierra752/prueba.siigo.backopcuno.git
cd prueba.siigo.backopcuno

Ejecutar las pruebas:

mvn clean verify

Ver el reporte Serenity:

target/site/serenity/index.html

👨‍💻 Autor
Fredy Yesid Sierra Ramírez
GitHub
LinkedIn
