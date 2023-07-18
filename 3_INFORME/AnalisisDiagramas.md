# Análisis y diseño de la aplicación Mov-UTPL

## Análisis

1. **Requisitos funcionales**: Basándonos en los datos básicos del cliente proporcionados y los diferentes planes, podemos establecer varios requisitos funcionales. Esto incluiría operaciones de creación, lectura, actualización y eliminación (CRUD) de clientes y planes. Además, la aplicación debería ser capaz de generar facturas basadas en los planes de cada cliente.

| Número  | Requerimiento                                               | Asignado a   | Completado | Tested |
|---------|-------------------------------------------------------------|--------------|:----------:|:------:|
| RM-01   | Agregar un nuevo cliente                                    | Daniel       |     ✓      |   ✓    |
| RM-02   | Editar la información de un cliente existente               | Daniel       |     ✓      |   ✓    |
| RM-03   | Eliminar un cliente                                         | Daniel       |     ✓      |   ✓    |
| RM-04   | Visualizar la información de un cliente                     | Daniel       |     ✓      |   ✓    |
| RM-05   | Listar todos los clientes                                   | Daniel       |     ✓      |   ✓    |
| RM-06   | Agregar un nuevo plan de telefonía móvil                    | Integrante 3 |     ✓      |   ✓    |
| RM-07   | Editar la información de un plan existente                  | Integrante 1 |     ✓      |   ✓    |
| RM-08   | Eliminar un plan                                            | Integrante 2 |     ✓      |   ✓    |
| RM-09   | Visualizar la información de un plan                        | Integrante 3 |     ✓      |   ✓    |
| RM-10   | Listar todos los planes de telefonía móvil                  | Integrante 1 |     ✓      |   ✓    |
| RM-11   | Asociar un plan a un cliente                                | Integrante 2 |     ✓      |   ✓    |
| RM-12   | Desasociar un plan de un cliente                            | Integrante 3 |     ✓      |   ✓    |
| RM-13   | Visualizar los planes asociados a un cliente                | Integrante 1 |     ✓      |   ✓    |
| RM-14   | Generar una factura para un cliente                         | Integrante 2 |     ✓      |   ✓    |
| RM-15   | Visualizar una factura generada                             | Integrante 3 |     ✓      |   ✓    |
| RM-16   | Listar todas las facturas generadas                         | Integrante 1 |     ✓      |   ✓    |
| RM-17   | Calcular el costo de cada tipo de plan                      | Integrante 2 |     ✓      |   ✓    |
| RM-18   | Guardar y recuperar todos los datos relevantes en/de una DB | Integrante 3 |     ✓      |   ✓    |

2. **Requisitos no funcionales**: La aplicación debería usar SQLite como motor de base de datos. Debe seguir los principios de la arquitectura MVC y utilizar el paradigma de la programación orientada a objetos (POO) utilizando conceptos como la herencia y el polimorfismo.

   Los requerimientos no funcionales son aquellos que no están directamente relacionados con la funcionalidad específica del sistema, sino con cómo se desempeña el sistema. A continuación, se muestran algunos posibles requerimientos no funcionales para este proyecto:

   1. **Usabilidad**: La interfaz de usuario del sistema debe ser fácil de usar y entender.
2. **Mantenibilidad**: El código del sistema debe estar bien organizado, bien comentado y seguir las mejores prácticas de programación. Esto facilitará cualquier mantenimiento o mejora futura del sistema.
   3. **Extensibilidad**: El sistema debe ser diseñado de tal manera que sea fácil agregar nuevas características o modificar las existentes.
4. **Persistencia de Datos**: El sistema debe garantizar la persistencia de los datos incluso en caso de fallas del sistema.
   
Pueden existir otros requerimientos que a lo largo del proyecto se irán contemplando.

## Diseño

1. **Arquitectura**: Deberíamos adoptar una arquitectura MVC (Modelo-Vista-Controlador) para este sistema. Esto significa que el sistema estará dividido en tres partes interconectadas:

   - **Modelo**: Contendrá la lógica empresarial y se ocupará de la interacción con la base de datos.

   - **Vista**: Representará la interfaz de usuario y mostrará la información al usuario.

   - **Controlador**: Gestionará la comunicación entre el modelo y la vista.

2. **UML**: Para representar nuestra arquitectura y la interacción entre diferentes componentes, utilizaremos diagramas UML (Unified Modeling Language). Los diagramas UML también ayudarán a ilustrar el uso de la herencia y el polimorfismo en el sistema.

3. **Base de datos**: Como se especifica en los requerimientos, utilizaremos SQLite como motor de base de datos. En la base de datos, habrá tablas para almacenar información de clientes, planes y facturas.

## Modelo

El diagrama ER (Entidad-Relación) permite modelar la estructura de una base de datos. 

```mermaid
erDiagram
          CLIENT ||--|| CLIENT-PLAN : "has"
          CLIENT-PLAN ||--|| PLAN : "uses"
          CLIENT {
            string id
            string nombres
            string pasaporte_cedula
            string ciudad
            string marca
            string modelo
            string numero_de_celular
            float pago_mensual
            string atributo_adicional_1
            string atributo_adicional_2
          }
          CLIENT-PLAN{
            string id
            string clientId
            string planId
          }
          PLAN {
            string id
            string nombre
          }
          PLANPOSTPAGOMINUTOSMEGASECONOMICO ||--|| PLAN : "is_a"
          PLANPOSTPAGOMINUTOSMEGASECONOMICO {
            string id
            int minutos
            float costo_minutos
            float gigas
            float costo_por_giga
            float porcentaje_de_descuento
          }
          PLANPOSTPAGOMINUTOS ||--|| PLAN : "is_a"
          PLANPOSTPAGOMINUTOS {
            string id
            int minutos_nacionales
            float costo_minuto_nacional
            int minutos_internacionales
            float costo_minuto_internacional
          }
          PLANPOSTPAGOMEGAS ||--|| PLAN : "is_a"
          PLANPOSTPAGOMEGAS {
            string id
            float gigas
            float costo_por_giga
            float tarifa_base
          }
          PLANPOSTPAGOMINUTOSMEGAS ||--|| PLAN : "is_a"
          PLANPOSTPAGOMINUTOSMEGAS {
            string id
            int minutos
            float costo_minutos
            float gigas
            float costo_por_giga
          }

```

Por favor ten en cuenta que esta es una aproximación muy básica y puede requerir ajustes basados en los requerimientos exactos de tu proyecto.

Este diagrama representa tres entidades principales: `CLIENT`, `CLIENT-PLAN` y `PLAN`. `CLIENT` representa a los clientes, `PLAN` representa los diferentes tipos de planes disponibles, y `CLIENT-PLAN` representa la relación entre los clientes y los planes. Los clientes pueden tener uno o dos planes, y cada plan puede ser utilizado por muchos clientes. Los diferentes tipos de planes heredan de la entidad `PLAN`.

## Diagrama de clases

La siguiente es una versión simplificada de cómo podrían organizarse las clases para este proyecto utilizando el patrón MVC (Modelo-Vista-Controlador) y el lenguaje de programación Java. 

```mermaid
classDiagram
      class Cliente {
          +String id
          +String nombres
          +String pasaporte_cedula
          +String ciudad
          +String marca
          +String modelo
          +String numero_de_celular
          +double pago_mensual
          +String atributo_adicional_1
          +String atributo_adicional_2
          +Plan[] planes
      }
      class Plan {
          +String id
          +String nombre
          +double calcularCosto()
      }
      Plan <|-- PlanPostPagoMinutosMegasEconomico
      Plan <|-- PlanPostPagoMinutos
      Plan <|-- PlanPostPagoMegas
      Plan <|-- PlanPostPagoMinutosMegas
      class PlanPostPagoMinutosMegasEconomico {
          +int minutos
          +double costo_minutos
          +double gigas
          +double costo_por_giga
          +double porcentaje_de_descuento
          +double calcularCosto()
      }
      class PlanPostPagoMinutos {
          +int minutos_nacionales
          +double costo_minuto_nacional
          +int minutos_internacionales
          +double costo_minuto_internacional
          +double calcularCosto()
      }
      class PlanPostPagoMegas {
          +double gigas
          +double costo_por_giga
          +double tarifa_base
          +double calcularCosto()
      }
      class PlanPostPagoMinutosMegas {
          +int minutos
          +double costo_minutos
          +double gigas
          +double costo_por_giga
          +double calcularCosto()
      }
      class ClienteController {
          +void addCliente(Cliente cliente)
          +void deleteCliente(String id)
          +void updateCliente(Cliente cliente)
          +Cliente getCliente(String id)
      }
      class PlanController {
          +void addPlan(Plan plan)
          +void deletePlan(String id)
          +void updatePlan(Plan plan)
          +Plan getPlan(String id)
      }
      class FacturaController {
          +Factura generateFactura(Cliente cliente)
      }
      class Factura {
          +String id
          +Cliente cliente
          +double total
          +String generarDetalle()
      }
      class ClienteView {
          +void printClienteDetails(String clienteId, String clienteNombre, String clienteCiudad)
      }
      class FacturaView {
          +void printFacturaDetails(String facturaId, String clienteNombre, double total)
      }
```
Este diagrama de clases representa las relaciones entre las clases propuestas. Hay una clase `Cliente`, que tiene una relación con la clase `Plan` a través de un array (un cliente puede tener uno o dos planes). La clase `Plan` es una clase abstracta, de la que heredan las clases `PlanPostPagoMinutosMegasEconomico`, `PlanPostPagoMinutos`, `PlanPostPagoMegas` y `PlanPostPagoMinutosMegas`. Cada una de estas clases tiene un método `calcularCosto` que se implementará de manera diferente en cada subclase.

Para el patrón MVC, tenemos controladores `ClienteController`, `PlanController` y `FacturaController`, que administrarán las operaciones CRUD para los clientes, planes y facturas, respectivamente. También tenemos las clases `ClienteView` y `FacturaView` que se encargan de presentar la información al usuario.

Este diagrama de clases es una versión inicial, se puede requerir más clases para garantizar la persistencia de los datos.

## Estructura del proyecto

La estructura de un proyecto de Java utilizando el patrón MVC (Modelo-Vista-Controlador) es la siguiente:

```
Mov-UTPL
│
├───src
│   ├───main
│   │   ├───java
│   │   │   ├───com
│   │   │   │   ├───utpl
│   │   │   │   │   ├───mov
│   │   │   │   │   │   ├───controller
│   │   │   │   │   │   │   ├───ClienteController.java
│   │   │   │   │   │   │   ├───PlanController.java
│   │   │   │   │   │   │   └───FacturaController.java
│   │   │   │   │   │   ├───model
│   │   │   │   │   │   │   ├───Cliente.java
│   │   │   │   │   │   │   ├───Plan.java
│   │   │   │   │   │   │   ├───PlanPostPagoMinutosMegasEconomico.java
│   │   │   │   │   │   │   ├───PlanPostPagoMinutos.java
│   │   │   │   │   │   │   ├───PlanPostPagoMegas.java
│   │   │   │   │   │   │   ├───PlanPostPagoMinutosMegas.java
│   │   │   │   │   │   │   └───Factura.java
│   │   │   │   │   │   └───view
│   │   │   │   │   │       ├───ClienteView.java
│   │   │   │   │   │       └───FacturaView.java
│   │   │   │   │   └───utils
│   │   │   │   │       └───DBUtil.java
│   │   ├───resources
│   │   │   └───db
│   │   │       └───movutpl.db
│   └───test
│       └───java
│           └───com
│               └───utpl
│                   └───mov
│                       └───controller
│                           ├───ClienteControllerTest.java
│                           ├───PlanControllerTest.java
│                           └───FacturaControllerTest.java
├───.gitignore
├───pom.xml
└───README.md
```

Esta es una estructura de proyecto típica de Maven. 

- En el directorio `src/main/java` colocas todas las clases Java de la aplicación.

- En `src/main/resources` colocamos los recursos, como archivos de configuración. En este caso, se ha colocado una base de datos SQLite en el directorio `src/main/resources/db`.

- En `src/test/java` colocas todas las pruebas de tu aplicación.

- El archivo `pom.xml` es el archivo de configuración de Maven, que define las dependencias del proyecto y otras configuraciones.

- El archivo `.gitignore` es donde indicas a Git qué archivos o directorios no debería rastrear.

- El archivo `README.md` es donde puedes escribir la documentación de tu proyecto.
