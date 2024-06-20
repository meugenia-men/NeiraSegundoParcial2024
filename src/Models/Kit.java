package Models;

import java.util.Random;

public class Kit {
    private static Integer nro = 0;

    public Kit() {
    }

    public Integer getNro() {
        return nro;
    }

    public void setNro(Integer nro) {
        Kit.nro = nro;
    }

    public Integer generatedNewkit() {
        nro = nro + 1;
        return nro;
    }

    @Override
    public String toString() {
        return "Kit{" + nro +
                "}";
    }
}
