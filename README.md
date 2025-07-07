# StockMasterPro 🛒

Proyecto final para la materia de **Validación y Verificación de Software**. StockMasterPro es un sistema de gestión de inventario y ventas para un supermercado ficticio, desarrollado en Java con el framework OpenXava.

## 📜 Descripción

Este proyecto implementa las funcionalidades básicas para la administración de un supermercado, permitiendo gestionar el ciclo completo desde la compra a proveedores hasta la venta a clientes, manteniendo un control preciso del stock de productos. El objetivo principal fue aplicar metodologías de validación y verificación para asegurar la calidad y robustez del software.

## ✨ Funcionalidades Principales

* **Gestión de Productos:** Creación, edición y eliminación de productos y sus categorías.
* **Gestión de Clientes y Proveedores:** Administración de la información de contacto y datos relevantes.
* **Ciclo de Compras:** Creación y seguimiento de órdenes de compra a proveedores.
* **Ciclo de Ventas:** Registro de ventas a clientes y generación de detalles.
* **Control de Stock:** Movimientos de inventario automáticos basados en compras y ventas.

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java 11
* **Framework:** OpenXava 7
* **Servidor de Aplicaciones:** Apache Tomcat
* **Gestión de Dependencias:** Maven
* **Base de Datos:** HSQLDB (integrada)
* **IDE:** Eclipse IDE for Enterprise Java and Web Developers
* **Control de Versiones:** Git y GitHub

## 🚀 Cómo Empezar

Sigue estos pasos para clonar y ejecutar el proyecto en tu máquina local.

### **Prerrequisitos**

* Tener instalado [Git](https://git-scm.com/).
* Tener instalado el **JDK 11** (Java Development Kit).
* Tener instalado [Eclipse IDE for Enterprise Java and Web Developers](https://www.eclipse.org/downloads/packages/).

### **Instalación y Ejecución**

1.  **Clona el repositorio:**
    ```bash
    git clone [https://github.com/JuanAlvarezP/StockMasterPro.git](https://github.com/JuanAlvarezP/StockMasterPro.git)
    ```

2.  **Navega a la carpeta del proyecto:**
    ```bash
    cd StockMasterPro
    ```

3.  **Importa el proyecto en Eclipse:**
    * Abre Eclipse.
    * Ve a `File > Import...`.
    * Selecciona `Maven > Existing Maven Projects`.
    * En `Root Directory`, busca y selecciona la carpeta `StockMasterPro` que acabas de clonar.
    * Asegúrate de que el proyecto esté marcado y haz clic en `Finish`.
    * Espera a que Maven descargue todas las dependencias (puede tardar unos minutos).

4.  **Ejecuta el proyecto:**
    * En el "Package Explorer" de Eclipse, haz clic derecho sobre el proyecto `StockMasterPro`.
    * Selecciona `Run As > Run on Server`.
    * Elige un servidor (ej. el Tomcat que viene con OpenXava) y haz clic en `Finish`.

5.  **Accede a la aplicación:**
    * Abre tu navegador web y ve a la siguiente dirección:
    * [http://localhost:8080/StockMasterPro/](http://localhost:8080/StockMasterPro/)

## ✅ Validación y Verificación

Como parte de los requisitos del curso, se aplicaron diversas técnicas y metodologías para asegurar la calidad del software.

* **Diseño y Arquitectura:** Se utilizó el **Modelo C4** para describir la arquitectura del sistema. Los diagramas de Clases y de Base de Datos se diseñaron para reflejar los requisitos.
* **Análisis de Código:** Se generó el **Grafo de Flujo de Control** y se calculó la **Complejidad Ciclomática** para algoritmos clave del sistema.
* **Pruebas de Software:** Se diseñaron y ejecutaron los siguientes tipos de pruebas:
    * **Pruebas de Caja Blanca:** Cobertura de sentencias y decisiones.
    * **Pruebas de Caja Negra:**
        * Técnica de Casos de Uso.
        * Particiones de Equivalencia.
        * Análisis de Valores Límite.

> 📄 **Nota:** Todos los documentos, diagramas, casos de prueba y reportes de resultados se encuentran en la carpeta `/documentos` del repositorio.

## 👨‍💻 Autores

Este proyecto fue desarrollado por:

* **Juan Alvarez**
* **Daniel Chaguaro**
* **Ricardo Quintana**
* **Ariel Ramos**

---
