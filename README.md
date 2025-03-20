# Aplicación de Gestión de Stock

Aplicación web desarrollada con **Java** y **Spring** para la gestión de stock de productos.  
Permite controlar el **ingreso y egreso de mercadería**, llevar un registro detallado y administrar usuarios con diferentes **roles**:  
- **Administradores**  
- **Vendedores**  
- **Compradores**  
El projecto sigue en desarrollo, aun le faltan algunas cuestiones para poder manejar las distintas cuentas de administrador,vendedor, y comprador, ya que tienen distintos niveles de privilegio en cuanto funcionalidades.
Por ejemplo, el unico que podria crear categorias y productos seria el administrador. Por el momento el usuario puede ingresar a todas las funcionalidades.
La estructura es adaptable a distintos rubros, en este caso se utilizan productos relacionados a computación y accesorios. 

## 🚀 Endpoints Disponibles  
Hay ejemplos de las solicitudes post y put aqui en el readme, se pueden probar tanto en postman como en swagger. 

### 🔹 Usuarios  

📌 **GET** - Traer todos los usuarios:  
`/usuarios`  

📌 **GET** - Buscar usuario por ID:  
`/usuarios/{id}`  

📌 **GET** - Buscar usuario por DNI:  
`/usuarios/dni/{dni}`  

📌 **GET** - Buscar usuario por Email:  
`/usuarios/email/{email}`  

📌 **POST** - Crear varios usuarios:  
`/usuarios/multiples`  
EJEMPLO DE SOLICITUD(BODY)
[{
  "nombre": "Fernanda",
  "apellido": "perez",
  "email": "fernanda.garcia@example.com",
  "edad": 32,
  "dni": 12123456
}]


📌 **PUT** - Modificar usuario:  
`/usuarios/{id}`  

EJEMPLO DE SOLICITUD(BODY)
   {
    "nombre": "Alfredo",
    "apellido": "Lofonso",
    "email": "diefgo.ramirez@example.com",
    "edad": 38,
    "dni": 123456  
  }


📌 **DELETE** - Eliminar usuario:  
`/usuarios/{id}`  

---

### 🔹 Productos  

📌 **GET** - Traer productos:  
`/productos`  

📌 **POST** - Crear producto:  
`/productos`
EJEMPLO DE SOLICITUD(BODY)
{
  "nombre": "Teclado genérico",
  "descripcion": "Teclado mecánico generico K8 bluetooth",
  "stock": 6,
  "categoria": {
    "id": 41
  }
}

📌 **PUT** - Modificar producto:  
`/productos/{id}`  
EJEMPLO DE SOLICITUD(BODY)
{
  "id": 12,
  "nombre": "Teclado Keychron",
  "descripcion": "Teclado mecánico Keychron K8 Pro",
  "precio": 280,
  "stock": 25,
  "categoria": {
    "id": 41
  }
}

📌 **DELETE** - Eliminar producto:  
`/productos/{id}`  

---

### 🔹 Categorías  

📌 **GET** - Traer todas las categorías:  
`/categorias`  

📌 **GET** - Traer categoría por ID:  
`/categorias/{id}`  

📌 **POST** - Crear categoría:  
`/categorias`  
EJEMPLO DE SOLICITUD(BODY)
{
  "nombre": "Electrónica"
}


📌 **PUT** - Modificar categoría:  
`/categorias/{id}`  
EJEMPLO DE SOLICITUD(BODY)
{
  "nombre": "Accesorios de Computación"
}


📌 **DELETE** - Eliminar categoría:  
`/categorias/{id}`  
