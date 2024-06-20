import Models.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {


        //region genero clientes
        Person p = new Person("Neira Maria", 39, "Centro", 31561321, "Farmaceutica");
        Person p1 = new Person("Rodriguez Martin", 40, "Grosellar", 30697998, "Inversionista");
        Person p2 = new Person("Diego Bruno", 24, "9 de Julio", 45998777, "Estudiante");
        Person p3 = new Person("Malena Orellano", 14, "Centro", 49008899, "Estudiante");
        Person p4 = new Person("Sonia Rivero", 68, "Chauvin", 52671725, "Jubilada");
        Person p5 = new Person("Lucia Franco", 25, "Mogotes", 39456876, "Empleada");
        Person p6 = new Person("Mirta Legrand", 90, "Mogotes", 10123567, "Jubilada");
        //endregion

        //atiendo a pacientes y los pongo en orden de llegada
        SSM ssm = new SSM();
        ssm.atender(p1);
        ssm.atender(p2);
        ssm.atender(p3);
        ssm.atender(p4);
        ssm.atender(p5);
        ssm.atender(p6);
        System.out.println(">>>>>>>>>>>>>>> REGISTRO DE PACIENTES A TESTEAR <<<<<<<<<<<<<<<<<<<<");
        for(Map.Entry<Integer,Person> entry : ssm.getListPatients().entrySet()){
            System.out.println(entry);
        }

        //testeo a los pacientes generando registros
        for (Map.Entry<Integer, Person> entry : ssm.getListPatients().entrySet()) {
            ssm.testear(entry.getValue());
        }
        System.out.println(">>>>>>>>>>>>>>> PACIENTES TESTEADOS <<<<<<<<<<<<<<<<<<<<");
        for(Map.Entry<Integer,Registro> entry : ssm.getTesteos().entrySet()){
            System.out.println(entry);
        }

        //identifico los pacientes que tienen temperatura
        ssm.aislar();

        //genero json aislar y sanos
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry<Integer, Registro> entry : ssm.getTesteos().entrySet()) {
            if (entry.getValue().getTemperature() >= 38) { //genero la lista aislar
                jsonObject.getAislar().add(new RegistroJson(entry.getKey(), entry.getValue().getTemperature(), ssm.getListPatients().get(entry.getValue().getDni()).getNeighborhood()));
            } else {
                //agrego a la lista de sanos los de temperatura menor a 38
                jsonObject.getSanos().add(ssm.getListPatients().get(entry.getValue().getDni()));
            }
        }

        //grabo el json
        File file = new File("sanosAislar.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, jsonObject);

    }
}