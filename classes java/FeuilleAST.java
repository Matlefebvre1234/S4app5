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
  public int EvalAST( ) {
    return Integer.parseInt(terminal.chaine);
  }


 /** Lecture de chaine de caracteres correspondant a la feuille d'AST
  */
  public String LectAST( ) {
    return terminal.chaine;
  }

}
