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

public class Juego implements Serializable{
    List<Jugador> jugadores = new ArrayList<>();;
    int turno;
    List<Carta> mazo = new ArrayList<>();;

    public Juego() {
        jugadores = new ArrayList<>();
        mazo = new ArrayList<>();
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
