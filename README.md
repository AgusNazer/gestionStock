Aplicacion web con java y spring, para la gestion de stock de productos, donde se podra controlar el ingreso y egreso de mercaderia,levar un control, 
y donde tambien haya roles como amdmins y usuarios como vendedores y/o compradores. Todavia no tengo definido exactamente que productos, 
pero la estructura general del projecto puede adaptarse a distintos rubros ya que todavia no he avanzado en detalles.

#Endpoints funcionandoen localhost:8080
#/usuarios
get
traer todos los usuarios: /usuarios
buscar usuario por Id: /{id}
buscar usuario por dni: dni/{dni}
buscar usuario por email: email/{email}
buscar usuario por dni: dni/{dni}
post
crear varios usuarios: /multiples
put
modificar usuario: /{id}
delete
elminar usuario: /{id}

#/productos
get
traer productos: /productos
post
crear productos: /productos
put
modificar productos: /{id}
delete
eliminar productos: /{id}

#/categorias
get
traer categorias: /categorias
traer por id: /{id}
post
crear categoria: /categoria
put
modificar categoria: /{id}
delete
eliminar categoria: /{id}