package org.iesalandalus.programacion.robot.vista;

import org.iesalandalus.programacion.robot.modulo.ControladorRobot;
import org.iesalandalus.programacion.robot.modulo.Robot;

import javax.naming.OperationNotSupportedException;
import javax.xml.transform.Source;
import java.sql.SQLOutput;

public class Main {
    private static ControladorRobot controladorRobot;

    public static void main(String[] args) throws IllegalAccessException {
        int opcion;
        do {
            opcion = Consola.elegirOpcion();
            ejecutarOpcion(opcion);
            Consola.mostrarRobot(controladorRobot);
        } while (opcion != 0);
        Consola.despedirse();
    }

    private static void ejecutarOpcion(int opcion) throws IllegalAccessException {
        switch (opcion) {
            case 1 -> controlarRobotDefecto();
            case 2 -> controlarRobotZona();
            case 3 -> controlarRobotZonaOrientacion();
            case 4 -> controlarRobotZonaOrientacionCoordenada();
            case 5 -> ejecutarComando();
        }
    }

    private static void ejecutarComando() {
        if (controladorRobot != null) {
            try {
                controladorRobot.ejecutar(Consola.elegirComando());
            } catch (OperationNotSupportedException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Aun no has creado ningun robot que controlar. ");
        }
    }

    private static void controlarRobotZonaOrientacionCoordenada() throws IllegalAccessException {
        controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona(), Consola.elegirOrientacion(), Consola.elegirCoordenada()));
    }

    private static void controlarRobotZonaOrientacion() throws IllegalAccessException {
        controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona(), Consola.elegirOrientacion()));
    }

    private static void controlarRobotZona() {
        controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona()));
    }

    private static void controlarRobotDefecto() {
        controladorRobot = new ControladorRobot(new Robot());
    }
}
