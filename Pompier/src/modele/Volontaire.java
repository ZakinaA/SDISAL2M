/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author ts1sio
 */
public class Volontaire extends Pompier {
    private ProVonl leProVonl;
    public Volontaire(){
        super() ;
    }
    public Volontaire(ProVonl leProVonl) {
        this.leProVonl = leProVonl;
    }
    public ProVonl getLeProVonl() {
        return leProVonl;
    }
    public void setLeProVonl(ProVonl leProVonl) {
        this.leProVonl = leProVonl;
    }
    
}
