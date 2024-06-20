package Models;

import java.util.Map;
import java.util.Random;

public class Registro {
    private Integer dni;
    private Integer temperature;

    public Registro(Integer dni) {
        this.dni = dni;
        this.temperature = this.temperaturaRandom();
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    private Integer temperaturaRandom() {
        Random random = new Random();
        return random.nextInt(40 - 36) + 36;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "dni=" + dni +
                ", temperature=" + temperature +
                '}';
    }
}
