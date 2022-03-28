package app6;

/** @author Ahmed Khoumsi */

/** Cette classe effectue l'analyse syntaxique
 */
public class DescenteRecursive {

  // Attributs
  Terminal currentTerminal;
  String chaine;
  AnalLex analyseurLexical;
  static boolean Erreur = false;


  public static void setErreur(boolean e)
  {
    Erreur = e;
  }

  public static boolean getErreur()
  {

    return Erreur;
  }
  public ElemAST F()
  {

    if(currentTerminal.chaine.equals("(") )
    {
      currentTerminal = analyseurLexical.prochainTerminal();
      ElemAST dernierUL = E();
      if(currentTerminal.chaine.equals(")"))
      {
        currentTerminal= analyseurLexical.prochainTerminal();
        return dernierUL;
      }
      else {
        System.out.println("Erreur: manque une \")\" au caractere " + analyseurLexical.pointeur);
      }


    }
    else {
      if(currentTerminal.operande)
      {
        FeuilleAST feuille = new FeuilleAST(currentTerminal);
        currentTerminal = analyseurLexical.prochainTerminal();
        return feuille;
      }
      else{
        System.out.println("Erreur une opérande est attendu au caractere " + analyseurLexical.pointeur + " charatère présent " + currentTerminal.chaine );
      }

    }


    return null;
  }

  public ElemAST E(){
    if(!DescenteRecursive.getErreur()){

    }
    ElemAST dernierUL = T();
    NoeudAST noeud;
    FeuilleAST feuille;
    if(currentTerminal.chaine.equals("+") || currentTerminal.chaine.equals("-") )
    {
      noeud = new NoeudAST(currentTerminal);
      noeud.enfants[0] = dernierUL;
      currentTerminal = analyseurLexical.prochainTerminal();
      noeud.enfants[1] = E();
      return noeud;
    }

    else{
      return dernierUL;
    }

  }

  public ElemAST T(){
    ElemAST dernierUL = F();
    NoeudAST noeud;
    FeuilleAST feuille;
    if(currentTerminal.chaine.equals("*") || currentTerminal.chaine.equals("/")){
      noeud = new NoeudAST(currentTerminal);
      noeud.enfants[0] = dernierUL;
      currentTerminal = analyseurLexical.prochainTerminal();
      noeud.enfants[1] = T();

      return noeud;
    }

    else{
      return dernierUL;
    }

  }

  /** Constructeur de DescenteRecursive :
   - recoit en argument le nom du fichier contenant l'expression a analyser
   - pour l'initalisation d'attribut(s)
   */
  public DescenteRecursive(String in) {
    Reader r = new Reader(in);
    chaine = r.toString();

    analyseurLexical = new AnalLex(chaine);

    currentTerminal = analyseurLexical.prochainTerminal();


    //
  }


  /** AnalSynt() effectue l'analyse syntaxique et construit l'AST.
   *    Elle retourne une reference sur la racine de l'AST construit
   */
  public ElemAST AnalSynt( ) {
    return E();//
  }


// Methode pour chaque symbole non-terminal de la grammaire retenue
// ...
// ...



  /** ErreurSynt() envoie un message d'erreur syntaxique
   */
  public void ErreurSynt(String s)
  {
    System.out.println(s);//
  }



  //Methode principale a lancer pour tester l'analyseur syntaxique
  public static void main(String[] args) {
    String toWriteLect = "";
    String toWriteEval = "";
    String toWritePostfixLect = "";

    System.out.println("Debut d'analyse syntaxique");
    if (args.length == 0){
      args = new String [2];
      args[0] = "ExpArith.txt";
      args[1] = "ResultatSyntaxique.txt";
    }
    DescenteRecursive dr = new DescenteRecursive(args[0]);
    try {
      ElemAST RacineAST = dr.AnalSynt();
      toWriteLect += "Lecture de l'AST trouve : " + RacineAST.LectAST() + "\n";
      System.out.println(toWriteLect);
      toWritePostfixLect += "Lecture de l'AST en postfix trouve : " + RacineAST.LectASTPostFix() + "\n";
      System.out.println(toWritePostfixLect);
      toWriteEval += "Evaluation de l'AST trouve : " + RacineAST.EvalAST() + "\n";
      if(!DescenteRecursive.getErreur()) System.out.println(toWriteEval);
      Writer w = new Writer(args[1],toWriteLect+toWriteEval); // Ecriture de toWrite 
      // dans fichier args[1]
    } catch (Exception e) {
      System.out.println(e);
      e.printStackTrace();
      System.exit(51);
    }
    System.out.println("Analyse syntaxique terminee");
  }

}

