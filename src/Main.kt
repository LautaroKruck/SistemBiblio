data  class Libro(val isbn: String, var titulo: String, var autor: String, var estado: EstadoLibro = EstadoLibro.DISPONIBLE)

enum class EstadoLibro {
    DISPONIBLE, PRESTADO
}

class Inventario() {
    private val libros = mutableListOf<Libro>()

    fun agregarLibro(libro: Libro){
        // Conexión a la base de datos
        println("Conectando a la base de datos...")

        libros.add(libro)
        println("Libro con titulo ${libro.titulo} guardado en la base de datos")
    }

    fun eliminarLibro(libro: Libro) {
        // Conexión a la base de datos
        println("Conectando a la base de datos...")

        libros.remove(libro)
        println("Libro con titulo ${libro.titulo} eliminado de la base de datos")
    }

    fun estaDisponible(libro: Libro, isbn: String ): Boolean {
        // Conexión a la base de datos
        println("Conectando a la base de datos...")

        return libros.any {it.isbn == isbn && it.estado == EstadoLibro.DISPONIBLE}
    }

    fun cambiarEstado(libro: Libro, isbn: String, nuevoEstado: EstadoLibro){
        libros.find {it.isbn == isbn }?.let {
            it.estado = nuevoEstado
            println("Estado del libro ${libro.titulo} cambiado a $nuevoEstado")
        }
    }

    fun listarTodosLibros(): List<Libro> = libros

    fun listarLibrosDisponibles(): List<Libro> = libros.filter { it.estado == EstadoLibro.DISPONIBLE }

    fun listarLibrosPrestados(): List<Libro> = libros.filter { it.estado == EstadoLibro.PRESTADO }
}

class Prestamos() {
    fun prestar(isbn: String ){

    }
    fun devolver(isbn: String){

    }
}

class Informes() {
    fun InfDetallado() {

    }

    fun InfDisopinble() {

    }
    fun InfPrestado() {

    }
}

fun main() {
    val llibro1 = Libro("123-456-789", "jota", "TheGrefg")

    val inventario: Inventario()

    inventario.agregarLibro(llibro1)

    val prestamos: Prestamos()
    prestamos.prestar(llibro1)

    prestamos.prestar(llibro1)

    prestamos.devolver(llibro1)


    inventario.agregarLibro()
}