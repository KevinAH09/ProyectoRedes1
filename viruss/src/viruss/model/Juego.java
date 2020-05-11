/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viruss.model;

import java.util.List;

/**
 *
 * @author cfugu
 */
public class Juego {
    List<Jugador> jugadores;
    int turno;
    List<Carta> mazo;

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
