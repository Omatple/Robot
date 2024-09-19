package org.iesalandalus.programacion.robot.modulo;

import java.util.Objects;

public record Zona(int ancho, int alto) {

    public static final int ANCHO_MINIMO = 10;
    public static final int ANCHO_MAXIMO = 100;
    public static final int ALTO_MINIMO = 10;
    public static final int ALTO_MAXIMO = 100;

    public Zona() {
        this(ANCHO_MINIMO, ALTO_MINIMO);
    }

    public Zona {
        validarAncho(ancho);
        validarAlto(alto);
    }

    private void validarAncho(int ancho) {
        if (ancho < ANCHO_MINIMO || ancho > ANCHO_MAXIMO) {
            throw new IllegalArgumentException("Ancho no valido.");
        }
    }

    private void validarAlto(int alto) {
        if (alto < ALTO_MINIMO || alto > ALTO_MAXIMO) {
            throw new IllegalArgumentException("Alto no valido.");
        }
    }

    public Coordenada getCentro() {
        return new Coordenada(ancho / 2, alto / 2);
    }

    public boolean pertenece(Coordenada coordenada) {
        Objects.requireNonNull(coordenada, "La coordenada no puede ser nula.");
        return perteneceX(coordenada.x()) && perteneceY(coordenada.y());
    }

    private boolean perteneceY(int y) {
        return (y >= 0 && y < alto);
    }

    private boolean perteneceX(int x) {
        return (x >= 0 && x < ancho);
    }

}
