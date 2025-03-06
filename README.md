# Aplicación de Gestión de Stock

Aplicación web desarrollada con **Java** y **Spring** para la gestión de stock de productos.  
Permite controlar el **ingreso y egreso de mercadería**, llevar un registro detallado y administrar usuarios con diferentes **roles**:  
- **Administradores**  
- **Vendedores**  
- **Compradores**  

La estructura es adaptable a distintos rubros, ya que aún no se ha definido un tipo específico de producto.  

## 🚀 Endpoints Disponibles  

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

📌 **PUT** - Modificar usuario:  
`/usuarios/{id}`  

📌 **DELETE** - Eliminar usuario:  
`/usuarios/{id}`  

---

### 🔹 Productos  

📌 **GET** - Traer productos:  
`/productos`  

📌 **POST** - Crear producto:  
`/productos`  

📌 **PUT** - Modificar producto:  
`/productos/{id}`  

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

📌 **PUT** - Modificar categoría:  
`/categorias/{id}`  

📌 **DELETE** - Eliminar categoría:  
`/categorias/{id}`  
