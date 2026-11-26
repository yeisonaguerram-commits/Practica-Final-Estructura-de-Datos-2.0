package HU4;

public class ObjetoContrato {

    private String IDcontrato;
    private String CedulaCliente;
    private String PlacaVehiculo;
    private String FechaInicio;
    private String FechaFin;
    private int TotalDias;
    private double ValorTotal;
    private String Estado;

    public ObjetoContrato() {
    }

    public ObjetoContrato(String iDcontrato, String cedulaCliente, String placaVehiculo, String fechaInicio,
            String fechaFin, int totalDias, double valorTotal, String estado) {
        IDcontrato = iDcontrato;
        CedulaCliente = cedulaCliente;
        PlacaVehiculo = placaVehiculo;
        FechaInicio = fechaInicio;
        FechaFin = fechaFin;
        TotalDias = totalDias;
        ValorTotal = valorTotal;
        Estado = estado;
    }

    public String getIDcontrato() {
        return IDcontrato;
    }

    public void setIDcontrato(String iDcontrato) {
        IDcontrato = iDcontrato;
    }

    public String getCedulaCliente() {
        return CedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        CedulaCliente = cedulaCliente;
    }

    public String getPlacaVehiculo() {
        return PlacaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        PlacaVehiculo = placaVehiculo;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(String fechaFin) {
        FechaFin = fechaFin;
    }

    public int getTotalDias() {
        return TotalDias;
    }

    public void setTotalDias(int totalDias) {
        TotalDias = totalDias;
    }

    public double getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(double valorTotal) {
        ValorTotal = valorTotal;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
