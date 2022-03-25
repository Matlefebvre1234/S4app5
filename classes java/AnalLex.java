package app6;

/** @author Ahmed Khoumsi */

/** Cette classe effectue l'analyse lexicale
 */
public class AnalLex {

// Attributs
//  ...
  String chaine;
  Terminal currentTerminal;
  int pointeur;
  int etat;
  static boolean erreur;

	
/** Constructeur pour l'initialisation d'attribut(s)
 * @param s
 */
  public AnalLex(String s) {  // arguments possibles
    chaine = s;//
    pointeur = -1;
    etat = 0;
    erreur = false;
  }


/** resteTerminal() retourne :
      false  si tous les terminaux de l'expression arithmetique ont ete retournes
      true s'il reste encore au moins un terminal qui n'a pas ete retourne 
 */
  public boolean resteTerminal( ) {
    if(pointeur != chaine.length()-1) return true;
    return false;//
  }
  
  
/** prochainTerminal() retourne le prochain terminal
      Cette methode est une implementation d'un AEF
 */  
  public Terminal prochainTerminal( ) {

    currentTerminal = new Terminal();
    String temp = currentTerminal.getChaine();
    etat = 0;

    boolean fini = false;

    while(fini != true && resteTerminal()){
      pointeur++;
      switch(etat){
        case 0:
          if(chaine.charAt(pointeur) == '+'){
            currentTerminal.setChaine("+");
            fini = true;
          }

          else if(chaine.charAt(pointeur) == '0' || chaine.charAt(pointeur) == '1'){
            temp= temp + Character.toString(chaine.charAt(pointeur));
            currentTerminal.chaine = Character.toString(chaine.charAt(pointeur));
            currentTerminal.operande = true;
            etat = 1;
          }

          else{
            ErreurLex("Erreur caractere non reconnu \"" + chaine.charAt(pointeur)+ "\" au caractere ");
            fini = true;
          }

          break;

        case 1:
          if(chaine.charAt(pointeur) == '1' || chaine.charAt(pointeur) == '0'){
            temp = temp + chaine.charAt(pointeur);
            currentTerminal.setChaine(temp);
          }

          else{
            fini = true;
            pointeur--;
          }

          break;

      }
    }
    return currentTerminal;
  }

 
/** ErreurLex() envoie un message d'erreur lexicale
 */ 
  public void ErreurLex(String s) {	
     System.out.println(s + pointeur);//
    erreur = true;
  }

  
  //Methode principale a lancer pour tester l'analyseur lexical
  public static void main(String[] args) {
    String toWrite = "";
    System.out.println("Debut d'analyse lexicale");
    if (args.length == 0){
    args = new String [2];
            args[0] = "ExpArith.txt";
            args[1] = "ResultatLexical.txt";
    }
    Reader r = new Reader(args[0]);

    AnalLex lexical = new AnalLex(r.toString()); // Creation de l'analyseur lexical

    // Execution de l'analyseur lexical
    Terminal t = null;
    while(lexical.resteTerminal() && erreur == false){
      t = lexical.prochainTerminal();
      toWrite +=t.chaine + "\n" ;  // toWrite contient le resultat
    }				   //    d'analyse lexicale
    System.out.println(toWrite); 	// Ecriture de toWrite sur la console
    Writer w = new Writer(args[1],toWrite); // Ecriture de toWrite dans fichier args[1]
    System.out.println("Fin d'analyse lexicale");
  }
}
