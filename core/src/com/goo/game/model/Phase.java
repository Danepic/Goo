package com.goo.game.model;

/**
 * Created by TIO BIGA on 12/06/2018.
 */

class Phase {
    private String idWorld;
    private String idPhase;
    private Double time;
    private String nota;
    private Integer attempts;

    public String getIdWorld() {
        return idWorld;
    }

    public void setIdWorld(String idWorld) {
        this.idWorld = idWorld;
    }

    public String getIdPhase() {
        return idPhase;
    }

    public void setIdPhase(String idPhase) {
        this.idPhase = idPhase;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }
}
