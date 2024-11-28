Historia de Usuario 1: Registrar un nuevo usuario
Como administrador de la aplicación,
Quiero poder registrar los datos personales de una nueva persona,
Para almacenar su información de manera segura en la base de datos.

Criterios de Aceptación:
La interfaz debe permitir ingresar información como clave, nombre, domicilio, celular, correo, fecha de nacimiento y género.
Al hacer clic en el botón "Insertar", los datos deben almacenarse en la base de datos si son válidos.
Si ocurre un error durante el registro, se debe mostrar un mensaje de error adecuado.


Historia de Usuario 2: Buscar a un usuario por su clave
Como administrador de la aplicación,
Quiero buscar la información de una persona registrada mediante su clave,
Para poder visualizar sus datos completos rápidamente.

Criterios de Aceptación:
El sistema debe permitir ingresar una clave en el campo correspondiente y buscar al usuario.
Si se encuentra un usuario con la clave proporcionada, los datos deben mostrarse en los campos de texto de la interfaz.
Si no se encuentra un usuario con esa clave, debe mostrarse un mensaje indicando que no existe.


Historia de Usuario 3: Actualizar información de un usuario existente
Como administrador de la aplicación,
Quiero modificar los datos de un usuario existente,
Para mantener la información actualizada y corregir errores si es necesario.

Criterios de Aceptación:
Debe ser posible cargar los datos de un usuario existente en la interfaz a través de su clave.
Una vez cargados, se debe poder editar cualquier campo y guardar los cambios al hacer clic en "Modificar".
El sistema debe mostrar un mensaje de confirmación al completar la modificación o un error si la operación falla.


Historia de Usuario 4: Eliminar un usuario de la base de datos
Como administrador de la aplicación,
Quiero eliminar el registro de un usuario existente,
Para gestionar correctamente la información y mantener una base de datos limpia.

Criterios de Aceptación:
Debe ser posible buscar al usuario que se desea eliminar mediante su clave o ID.
Una vez cargada la información, debe haber un botón "Eliminar" que permita borrar el registro de la base de datos.
El sistema debe confirmar la eliminación exitosa o mostrar un mensaje en caso de error.


Historia de Usuario 5: Limpiar la interfaz para un nuevo registro
Como administrador de la aplicación,
Quiero borrar rápidamente los datos ingresados en los campos de texto,
Para poder registrar o buscar un nuevo usuario sin interferencia de datos anteriores.

Criterios de Aceptación:
Al hacer clic en el botón "Limpiar", todos los campos de texto deben quedar vacíos y la lista desplegable de género debe restablecerse a su valor predeterminado.
El sistema debe mostrar un mensaje confirmando que los campos han sido limpiados.
