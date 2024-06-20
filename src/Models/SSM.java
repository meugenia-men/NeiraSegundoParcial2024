package Models;

import Exceptions.ExceptionKit;
import Exceptions.ExceptionTemperature;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SSM {

    private Kit kit = new Kit();
    private Scanner sc = new Scanner(System.in);
    private Integer kitAmount = 5;
    private Map<Integer, Person> listPatients = new HashMap<>();
    private Map<Integer, Registro> testeos = new HashMap<>();

    public SSM() {
    }

    public Map<Integer, Person> getListPatients() {
        return listPatients;
    }

    public void setListPatients(Map<Integer, Person> listPatients) {
        this.listPatients = listPatients;
    }

    public Integer getKitAmount() {
        return kitAmount;
    }

    public Map<Integer, Registro> getTesteos() {
        return testeos;
    }

    public void atender(Person p) {
        try {
            if (kitAmount > 0) {
                p.setKitNumber(kit.generatedNewkit());
                kitAmount--;
                listPatients.put(p.getDni(), p);
            } else {
                throw new ExceptionKit("Sin stock de kit");
            }

        } catch (ExceptionKit e) {
            System.out.println("Dispone de mas kits? si o no?");
            String opc = sc.nextLine();
            if (opc.equalsIgnoreCase("si")) {
                kitAmount = 5;
                p.setKitNumber(kit.generatedNewkit());
                kitAmount--;
                listPatients.put(p.getDni(), p);
            }
        }

    }

    public void testear(Person p) {
        testeos.put(p.getKitNumber(), new Registro(p.getDni()));
    }

    public void grabarUrgente(Integer nroTest, String neighborhood) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("urgente.txt"), true));
            bufferedWriter.write(nroTest);
            bufferedWriter.newLine();
            bufferedWriter.write(neighborhood);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Se produjo un error al escribir en el archivo: " + e.getMessage());
        }
    }

    public void aislar() {
        for (Map.Entry<Integer, Registro> entry : testeos.entrySet()) {
            try {
                if (entry.getValue().getTemperature() >= 38) {
                    throw new ExceptionTemperature("Debe aislar a este paciente", entry.getKey(), listPatients.get(entry.getValue().getDni()).getNeighborhood());
                }
            } catch (ExceptionTemperature e) {
                grabarUrgente(e.getNroTest(), e.getNeighborhood());
            }
        }
    }


}
