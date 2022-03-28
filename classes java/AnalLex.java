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
  boolean lastCharUnderScore;
  static boolean erreur;

	
/** Constructeur pour l'initialisation d'attribut(s)
 * @param s
 */
  public AnalLex(String s) {  // arguments possibles
    chaine = s;//
    pointeur = -1;
    etat = 0;
    erreur = false;
    lastCharUnderScore = false;
  }


/** resteTerminal() retourne :
      false  si tous les terminaux de l'expression arithmetique ont ete retournes
      true s'il reste encore au moins un terminal qui n'a pas ete retourne 
 */
  public boolean resteTerminal( ) {
    if(pointeur != chaine.length()-1) return true;
    if(lastCharUnderScore == true) ErreurLex("Le tout dernier caractere est un _ a l'espace ");
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
          if(chaine.charAt(pointeur) == '+'|| chaine.charAt(pointeur) == '-' || chaine.charAt(pointeur) == '*' || chaine.charAt(pointeur) == '/' || chaine.charAt(pointeur) == '(' || chaine.charAt(pointeur) == ')'){
            currentTerminal.setChaine(Character.toString(chaine.charAt(pointeur)));
            fini = true;

            currentTerminal.type = "operateur";
          }

          else if(chaine.charAt(pointeur) == '0' || chaine.charAt(pointeur) == '1'|| chaine.charAt(pointeur) == '2'|| chaine.charAt(pointeur) == '3'|| chaine.charAt(pointeur) == '4'
                  || chaine.charAt(pointeur) == '5'|| chaine.charAt(pointeur) == '6'|| chaine.charAt(pointeur) == '7'|| chaine.charAt(pointeur) == '8'|| chaine.charAt(pointeur) == '9' ){
            temp= temp + Character.toString(chaine.charAt(pointeur));
            currentTerminal.chaine = Character.toString(chaine.charAt(pointeur));
            currentTerminal.operande = true;
            etat = 1;
            currentTerminal.type = "nombre";
          }

          else if(chaine.charAt(pointeur) == 'A' || chaine.charAt(pointeur) == 'B'|| chaine.charAt(pointeur) == 'C'|| chaine.charAt(pointeur) == 'D'|| chaine.charAt(pointeur) == 'E'
                  || chaine.charAt(pointeur) == 'F'|| chaine.charAt(pointeur) == 'G'|| chaine.charAt(pointeur) == 'H'|| chaine.charAt(pointeur) == 'I'|| chaine.charAt(pointeur) == 'J' ||
                  chaine.charAt(pointeur) == 'K' || chaine.charAt(pointeur) == 'L'|| chaine.charAt(pointeur) == 'M'|| chaine.charAt(pointeur) == 'N'|| chaine.charAt(pointeur) == 'O'
                  || chaine.charAt(pointeur) == 'P'|| chaine.charAt(pointeur) == 'Q'|| chaine.charAt(pointeur) == 'R'|| chaine.charAt(pointeur) == 'S'|| chaine.charAt(pointeur) == 'T'|| chaine.charAt(pointeur) == 'U'
                  || chaine.charAt(pointeur) == 'V'|| chaine.charAt(pointeur) == 'W'|| chaine.charAt(pointeur) == 'X'|| chaine.charAt(pointeur) == 'Y'|| chaine.charAt(pointeur) == 'Z'){
            temp= temp + Character.toString(chaine.charAt(pointeur));
            currentTerminal.chaine = Character.toString(chaine.charAt(pointeur));
            currentTerminal.operande = true;
            etat = 2;
            currentTerminal.type = "identificateur";
          }

          else{
            ErreurLex("Erreur caractere non reconnu \"" + chaine.charAt(pointeur)+ "\" au caractere ");
            fini = true;
          }

          break;

        case 1:
          if(chaine.charAt(pointeur) == '0' || chaine.charAt(pointeur) == '1'|| chaine.charAt(pointeur) == '2'|| chaine.charAt(pointeur) == '3'|| chaine.charAt(pointeur) == '4'
             || chaine.charAt(pointeur) == '5'|| chaine.charAt(pointeur) == '6'|| chaine.charAt(pointeur) == '7'|| chaine.charAt(pointeur) == '8'|| chaine.charAt(pointeur) == '9') {
            temp = temp + chaine.charAt(pointeur);
            currentTerminal.setChaine(temp);
            lastCharUnderScore = false;
          }

          else{
            fini = true;
            pointeur--;
          }

          break;

        case 2:
          if(Character.toUpperCase(chaine.charAt(pointeur))=='A' || Character.toUpperCase(chaine.charAt(pointeur)) == 'B'|| Character.toUpperCase(chaine.charAt(pointeur)) == 'C'|| Character.toUpperCase(chaine.charAt(pointeur)) == 'D'|| Character.toUpperCase(chaine.charAt(pointeur)) == 'E'
             || Character.toUpperCase(chaine.charAt(pointeur)) == 'F'|| Character.toUpperCase(chaine.charAt(pointeur)) == 'G'|| Character.toUpperCase(chaine.charAt(pointeur)) == 'H'|| Character.toUpperCase(chaine.charAt(pointeur)) == 'I'|| Character.toUpperCase(chaine.charAt(pointeur)) == 'J' ||
             Character.toUpperCase(chaine.charAt(pointeur)) == 'K' || Character.toUpperCase(chaine.charAt(pointeur)) == 'L'|| Character.toUpperCase(chaine.charAt(pointeur)) == 'M'|| Character.toUpperCase(chaine.charAt(pointeur)) == 'N'|| Character.toUpperCase(chaine.charAt(pointeur)) == 'O'
             || Character.toUpperCase(chaine.charAt(pointeur)) == 'P'|| Character.toUpperCase(chaine.charAt(pointeur)) == 'Q'|| Character.toUpperCase(chaine.charAt(pointeur)) == 'R'|| Character.toUpperCase(chaine.charAt(pointeur)) == 'S'|| Character.toUpperCase(chaine.charAt(pointeur)) == 'T'|| Character.toUpperCase(chaine.charAt(pointeur)) == 'U'
             || Character.toUpperCase(chaine.charAt(pointeur)) == 'V'|| Character.toUpperCase(chaine.charAt(pointeur)) == 'W'|| Character.toUpperCase(chaine.charAt(pointeur)) == 'X'|| Character.toUpperCase(chaine.charAt(pointeur)) == 'Y'|| Character.toUpperCase(chaine.charAt(pointeur)) == 'Z'){
            temp = temp + chaine.charAt(pointeur);
            currentTerminal.setChaine(temp);
            lastCharUnderScore = false;
          }

          else if(chaine.charAt(pointeur) == '_'){
            if(lastCharUnderScore == true){
              ErreurLex("Deux _ se suivent au caractere ");
              fini = true;
            }

            else
            {
              temp = temp + chaine.charAt(pointeur);
              currentTerminal.setChaine(temp);
              lastCharUnderScore = true;
            }
          }

          else{
            if(lastCharUnderScore == true){
              ErreurLex("Le dernier caractere d'une operande est un _ au caractere ");
            }

            lastCharUnderScore = false;
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
      toWrite += t.type + " " + t.chaine +  "\n" ;  // toWrite contient le resultat
    }				   //    d'analyse lexicale
    System.out.println(toWrite); 	// Ecriture de toWrite sur la console
    Writer w = new Writer(args[1],toWrite); // Ecriture de toWrite dans fichier args[1]
    System.out.println("Fin d'analyse lexicale");
  }
}
