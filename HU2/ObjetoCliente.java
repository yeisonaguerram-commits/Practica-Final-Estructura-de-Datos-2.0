package HU2;

public class ObjetoCliente {
    private String Cedula;
    private String NombreCliente;
    private String ApellidoCliente;
    private String Telefono;
    private String Direccion;
    private String Licencia;
    public ObjetoCliente(String cedula, String nombreCliente, String apellidoCliente, String telefono, String direccion,
            String licencia) {
        Cedula = cedula;
        NombreCliente = nombreCliente;
        ApellidoCliente = apellidoCliente;
        Telefono = telefono;
        Direccion = direccion;
        Licencia = licencia;
    }
    public String getCedula() {
        return Cedula;
    }
    public void setCedula(String cedula) {
        Cedula = cedula;
    }
    public String getNombreCliente() {
        return NombreCliente;
    }
    public void setNombreCliente(String nombreCliente) {
        NombreCliente = nombreCliente;
    }
    public String getApellidoCliente() {
        return ApellidoCliente;
    }
    public void setApellidoCliente(String apellidoCliente) {
        ApellidoCliente = apellidoCliente;
    }
    public String getTelefono() {
        return Telefono;
    }
    public void setTelefono(String telefono) {
        Telefono = telefono;
    }
    public String getDireccion() {
        return Direccion;
    }
    public void setDireccion(String direccion) {
        Direccion = direccion;
    }
    public String getLicencia() {
        return Licencia;
    }
    public void setLicencia(String licencia) {
        Licencia = licencia;
    }

}
