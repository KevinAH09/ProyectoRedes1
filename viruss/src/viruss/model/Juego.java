/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viruss.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cfugu
 */
public class Juego implements Serializable {

    public List<Jugador> jugadores = new ArrayList<>();

    int turno;
    public String conexion = "w";//w=esperar, o=tiempo excedido, l=juego listo
    public List<Carta> mazo = new ArrayList<>();
    public List<Carta> cementerio = new ArrayList<>();

    public Juego() {
        jugadores = new ArrayList<>();
        mazo = new ArrayList<>();
        cementerio = new ArrayList<>();
    }

    public List<Carta> getCementerio() {
        return cementerio;
    }

    public void setCementerio(List<Carta> cementerio) {
        this.cementerio = cementerio;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public List getJugadores() {
        return jugadores;
    }

    public void setJugadores(List jugadores) {
        this.jugadores = jugadores;
    }

    public List getMazo() {
        return mazo;
    }

    public void setMazo(List mazo) {
        this.mazo = mazo;
    }

}
