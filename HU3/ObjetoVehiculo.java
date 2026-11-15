public class ObjetoVehiculo {

    // Atributos generales
    private String TipoVehiculo;
    private String Placa;
    private String Marca;
    private int Modelo;
    private float PrecioDiario;
    private String Estado;

    // Atributos CarroSedan
    private String TipoCombustible;
    private String Transmision;

    // Atributos CamionetaSUV
    private String Traccion;
    private float CapacidadMaletero;

    public ObjetoVehiculo() {
    }

    // Constructor completo
    public ObjetoVehiculo(String tipoVehiculo, String placa, String marca, int modelo, float precioDiario,
            String estado, String tipoCombustible, String transmision,
            String traccion, float capacidadMaletero) {
        TipoVehiculo = tipoVehiculo;
        Placa = placa;
        Marca = marca;
        Modelo = modelo;
        PrecioDiario = precioDiario;
        Estado = estado;
        TipoCombustible = tipoCombustible;
        Transmision = transmision;
        Traccion = traccion;
        CapacidadMaletero = capacidadMaletero;
    }

    public String getTipoVehiculo() {
        return TipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        TipoVehiculo = tipoVehiculo;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String placa) {
        Placa = placa;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public int getModelo() {
        return Modelo;
    }

    public void setModelo(int modelo) {
        Modelo = modelo;
    }

    public float getPrecioDiario() {
        return PrecioDiario;
    }

    public void setPrecioDiario(float precioDiario) {
        PrecioDiario = precioDiario;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getTipoCombustible() {
        return TipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        TipoCombustible = tipoCombustible;
    }

    public String getTransmision() {
        return Transmision;
    }

    public void setTransmision(String transmision) {
        Transmision = transmision;
    }

    public String getTraccion() {
        return Traccion;
    }

    public void setTraccion(String traccion) {
        Traccion = traccion;
    }

    public float getCapacidadMaletero() {
        return CapacidadMaletero;
    }

    public void setCapacidadMaletero(float capacidadMaletero) {
        CapacidadMaletero = capacidadMaletero;
    }
}
