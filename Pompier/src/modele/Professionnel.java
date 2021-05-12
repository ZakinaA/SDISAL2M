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
public class Professionnel extends Pompier {
    
    
    private int indiceTraitement ;
    private String dateObtentionIndice;
    
    

public Professionnel (){
    super();
}

    public Professionnel(int matricule, int indiceTraitement, String dateObtentionIndice) {
        super();
    }

   
    public int getIndiceTraitement() {
        return indiceTraitement;
    }

    public String getDateObtentionIndice() {
        return dateObtentionIndice;
    }

   

    public void setIndiceTraitement(int indiceTraitement) {
        this.indiceTraitement = indiceTraitement;
    }

    public void setDateObtentionIndice(String dateObtentionIndice) {
        this.dateObtentionIndice = dateObtentionIndice;
    }
    


}