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
  public float EvalAST( ) {
    //Faudrait faire des if pour les differnets operateurs
    switch (terminal.chaine) {
      case "+":
        return enfants[0].EvalAST() + enfants[1].EvalAST();
      case "-":
        return enfants[0].EvalAST() - enfants[1].EvalAST();
      case "*":
        return enfants[0].EvalAST() * enfants[1].EvalAST();
      case "/":
        return enfants[0].EvalAST() / enfants[1].EvalAST();
    }

    return enfants[0].EvalAST() + enfants[1].EvalAST();
  }


  /** Lecture de noeud d'AST
   */
  public String LectAST( ) {
    return "("+enfants[0].LectAST() + terminal.chaine + enfants[1].LectAST() + ")";
  }

  public String LectASTPostFix(){
    //if(!enfants[1].LectASTPostFix().contains(terminal.chaine)){
      return enfants[0].LectASTPostFix()+enfants[1].LectASTPostFix()+terminal.chaine;
    //}

    //else{
      //return enfants[1].LectASTPostFix()+enfants[0].LectASTPostFix()+terminal.chaine;
    //}

  }

}


