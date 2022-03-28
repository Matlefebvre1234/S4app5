package app6;

/** @author Ahmed Khoumsi */

/** Classe representant une feuille d'AST
 */
public class FeuilleAST extends ElemAST {

  // Attribut(s)


/**Constructeur pour l'initialisation d'attribut(s)
 */
  public FeuilleAST(Terminal terminalRecu) {  // avec arguments
    terminal = terminalRecu;
  }


  /** Evaluation de feuille d'AST
   */
  public float EvalAST( ) {

      try {
          return Float.parseFloat(terminal.chaine);
      } catch (NumberFormatException e) {

          System.out.println("Erreur on ne peut pas evaluer des variables qui ne sont pas des chiffres");
          DescenteRecursive.setErreur(true);
          return 0;
      }
  }


 /** Lecture de chaine de caracteres correspondant a la feuille d'AST
  */
  public String LectAST( ) {
    return terminal.chaine;
  }

    public String LectASTPostFix() {
        return terminal.chaine;
    }

}
