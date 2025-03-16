package persistencia;

public class ProductoDAO extends DAO {
    public void eliminarProductoPorCodigo(int idProducto) throws Exception {
        try {
            String sql = """
                DELETE FROM producto
                WHERE id_producto = %d;
                """.formatted(idProducto);

            insertarModificarEliminarBD(sql);
            System.out.printf("El producto con código %d fue eliminado de manera exitosa.", idProducto);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBD();
        }
    }
}
