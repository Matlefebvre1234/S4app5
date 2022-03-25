package app6;

/** @author Ahmed Khoumsi */

/** Classe representant une feuille d'AST
 */
public class NoeudAST extends ElemAST {

  // Attributs
  public ElemAST[] enfants;
  /** Constructeur pour l'initialisation d'attributs
   */
  public NoeudAST(Terminal terminalRecu) { // avec arguments
    //
    terminal = terminalRecu;
    enfants = new ElemAST[2];
  }

 
  /** Evaluation de noeud d'AST
   */
  public int EvalAST( ) {
    //Faudrait faire des if pour les differnets operateurs
     return enfants[0].EvalAST() + enfants[1].EvalAST();
  }


  /** Lecture de noeud d'AST
   */
  public String LectAST( ) {
     return enfants[0].LectAST() + terminal.chaine + enfants[1].LectAST();
  }

}


