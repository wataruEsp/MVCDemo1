package datos;


import dominio.Empleado;
import java.sql.*;
import java.util.*;




public class EmpleadoDAOJDBC {
    
    
    private static final String SQL_SELECT = "SELECT id_empleado, nombre, apellido, email, telefono, salario FROM empleado";

    private static final String SQL_SELECT_BY_ID = "SELECT id_empleado, nombre, apellido, email, telefono, salario FROM empleado WHERE id_empleado = ?";

    private static final String SQL_INSERT = "INSERT INTO empleado(nombre, apellido, email, telefono, salario) VALUES(?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE empleado SET nombre=?, apellido=?, email=?, telefono=?, salario=? WHERE id_empleado=?";

    private static final String SQL_DELETE = "DELETE FROM empleado WHERE id_empleado = ?";

    public List<Empleado> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Empleado empleado = null;
        List<Empleado> empleados = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idEmpleado = rs.getInt("id_empleado");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                double salario = rs.getDouble("salario");

                empleado = new Empleado(idEmpleado, nombre, apellido, email, telefono, salario);
                empleados.add(empleado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return empleados;
    }

    public Empleado encontrar(Empleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, empleado.getIdEmpleado());
            rs = stmt.executeQuery();
            rs.next();//nos posicionamos en el primer registro devuelto

            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            double salario = rs.getDouble("salario");

            empleado.setNombre(nombre);
            empleado.setApellido(apellido);
            empleado.setEmail(email);
            empleado.setTelefono(telefono);
            empleado.setSalario(salario);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return empleado;
    }

    public int insertar(Empleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, empleado.getNombre());
            stmt.setString(2, empleado.getApellido());
            stmt.setString(3, empleado.getEmail());
            stmt.setString(4, empleado.getTelefono());
            stmt.setDouble(5, empleado.getSalario());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int actualizar(Empleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, empleado.getNombre());
            stmt.setString(2, empleado.getApellido());
            stmt.setString(3, empleado.getEmail());
            stmt.setString(4, empleado.getTelefono());
            stmt.setDouble(5, empleado.getSalario());
            stmt.setInt(6, empleado.getIdEmpleado());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int eliminar(Empleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, empleado.getIdEmpleado());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    
    
    
    
}
