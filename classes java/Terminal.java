package app6;

/** @author Ahmed Khoumsi */

/** Cette classe identifie les terminaux reconnus et retournes par
 *  l'analyseur lexical
 */
public class Terminal {


    public String chaine;
    public int integer;
    public boolean operande;


/** Un ou deux constructeurs (ou plus, si vous voulez)
  *   pour l'initalisation d'attributs 
 */	
  public Terminal( ) {   // arguments possibles
     chaine = "";
     operande = false;
  }

    public int getVal() {
        return integer;
    }

    public String getChaine() {
        return chaine;
    }

    public void setChaine(String chaine) {
        this.chaine = chaine;
    }

    public void setVal(int val) {
        this.integer = val;
    }
}
