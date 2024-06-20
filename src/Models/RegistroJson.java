package Models;

public class RegistroJson {
    public  Integer nroKit;
    public Integer temperature;
    public String neighborhood;

    public RegistroJson() {
    }

    public RegistroJson(Integer nroKit, Integer temperature, String neighborhood) {
        this.nroKit = nroKit;
        this.temperature = temperature;
        this.neighborhood = neighborhood;
    }

    public Integer getNroKit() {
        return nroKit;
    }

    public void setNroKit(Integer nroKit) {
        this.nroKit = nroKit;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    @Override
    public String toString() {
        return "RegistroJson{" +
                "nroKit=" + nroKit +
                ", temperature=" + temperature +
                ", neighborhood='" + neighborhood + '\'' +
                '}';
    }
}
