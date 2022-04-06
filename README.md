Descripción
La empresa “Superheroes Unlimited” lleva años asociada al rubro de los superhéroes en
distintos ámbitos. Con el afán de ampliar su mercado, ha decidido construir una aplicación
nativa para teléfonos Android que permite explorar el mundo de los superhéroes de distintos
universos.
Esta app permitirá probar la idea, por lo tanto, se debe construir un Producto Mínimo Viable
(MVP por sus siglas en inglés) para que los interesados visualicen el listado de superhéroes
y, al hacer clic en uno, vean su detalle.
Considerando que esta primera versión busca tener una gran cobertura en dispositivos
manteniendo los costos de mantención bajos, se requiere que la API mínima sea nivel 23 y
target la 30.
Se espera que cualquier usuario, sin previa autenticación, vea la lista de superhéroes y su
detalle al seleccionar uno.

Alcance del proyecto
Se ha determinado construir un Producto Mínimo Viable (MVP) con 2 pantallas: una para el
listado y otra para el detalle.
La información a desplegar proviene de una API que debe ser consumida siguiendo los
estándares de la industria, ocupando patrones de arquitectura y diseño correctamente para
construir una app escalable.

Requerimientos técnicos: arquitectura y dependencias
Aunque el alcance de la app es inicial, la arquitectura que se utilice debe permitir expandir y
modificar el proyecto si los resultados iniciales son buenos, por lo que se debe construir un
código legible, ordenado, indentado y que respete los siguientes requerimientos técnicos:
● La arquitectura de la app puede ser Modelo-Vista-Presentador (MVP) o
Modelo-Vista-VistaModel (MVVM).
● Para la comunicación con la API utilizar la biblioteca Retrofit. Debes agregar
dependencias de Retrofit y de converter para Json. Agregar permiso de internet al
manifiesto. Creación de interfaz de operaciones, cliente de conexión y POJOs
necesarios.
○ Los endpoints a utilizar son:
■ https://akabab.github.io/superhero-api/api/all.json
■ https://akabab.github.io/superhero-api/api/id/{id}.json
● Se deben respetar convenciones y estilos de codificación.
● Java es el lenguaje elegido para construir la app.

Requerimientos
1. Crear el proyecto base utilizando Java como lenguaje. Inicializar el proyecto con
control de versiones git. 
2. La aplicación debe utilizar una actividad y al menos 2 fragmentos (Single Activity o
Actividad única) 
3. Para enlazar las vistas se debe utilizar ViewBinding o DataBinding. 
4. El listado principal debe utilizar un RecyclerView. Implementar la clase Adapter que
hereda de la clase RecyclerView.Adapter para el manejo de la información, además
del ViewHolder correspondiente. 
5. Arquitectura Model-View-Presenter (MVP): Crear la clase Presenter (Presentador) y la
interfaz de callbacks necesaria para la comunicación con la vista o utilizar LiveData
para exponer la información. 
HINT: Trabajé con arquitectura MVVM.
6. Crear dos (2) archivos de pruebas unitarias con al menos una (1) prueba para dos (2)
clases distintas. 
7. Todos los textos que no provengan como resultado de la API deben estar creados
como recurso de texto (archivo strings.xml). Crear al menos 1 imagen como Image
Vector. No tener código comentado. 
