package Models;

import java.util.ArrayList;
import java.util.List;

public class JsonObject {
    List<Person> sanos = new ArrayList<>();
    List<RegistroJson> aislar = new ArrayList<>();

    public JsonObject() {
    }

    public JsonObject(List<Person> sanos, List<RegistroJson> aislar) {
        this.sanos = sanos;
        this.aislar = aislar;
    }

    public List<Person> getSanos() {
        return sanos;
    }

    public void setSanos(List<Person> sanos) {
        this.sanos = sanos;
    }

    public List<RegistroJson> getAislar() {
        return aislar;
    }

    public void setAislar(List<RegistroJson> aislar) {
        this.aislar = aislar;
    }
}
