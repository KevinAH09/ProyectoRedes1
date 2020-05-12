/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viruss.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cfugu
 */
import java.io.Serializable;
public class Juego implements Serializable{
    List<Jugador> jugadores=new ArrayList();
    int turno;
    List<Carta> mazo=new ArrayList();

    public Juego() {
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

    public void setJugadores(Jugador jugadores) {
        this.jugadores = (List<Jugador>) jugadores;
    }

    public List getMazo() {
        return mazo;
    }

    public void setMazo(Carta mazo) {
        this.mazo = (List<Carta>) mazo;
    }
    
    
}
