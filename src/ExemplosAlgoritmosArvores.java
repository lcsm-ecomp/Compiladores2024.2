class ExemplosAlgoritmosArvores {

    class Tree {
        String info;
        Tree childs[]; 
        Tree(String i, Tree... childs) {
            this.info = i;
            this.childs = childs;
        } 
    }

    /* Gramatica:
       Exp -> Exp + Exp (Soma)
            | Exp * Exp (Prod)
            | NUM       (Const)
    */

    //Versão Usando Árvores Genéricas:
    //1 + 2*3
    Tree t1 = new Tree("Soma", 
        new Tree("Const", new Tree("1")),
        new Tree("+"),
        new Tree("Prod", 
           new Tree("Const", new Tree("2")),
           new Tree("*"),
           new Tree("Const", new Tree("3"))
        )
    );

    int avalie1(Tree t) {
        if (t.info.equals("Soma"))
           return avalie1(t.childs[0]) + avalie1(t.childs[2]);
        if (t.info.equals("Prod"))
           return avalie1(t.childs[0]) * avalie1(t.childs[2]);
        if (t.info.equals("Const"))
           return Integer.parseInt(t.childs[0].info);
        throw new RuntimeException("Não sei compilar : "+t.info);
    }

    //Árvores Orientadas a Objetos:

    interface VisitorExp {
        int visit(Soma s);
        int visit(Prod p);
        int visit(Const c); 
    }
    abstract class Exp { 
        abstract int avalie();
        abstract int accept(VisitorExp v); 
    } 
    class Soma extends Exp {
        Exp esq, dir;
        Soma(Exp e, Exp d) {
            esq = e; dir = d;
        }
        int avalie() {
            return esq.avalie() + dir.avalie();
        }
        int accept(VisitorExp v) { return v.visit(this); }
    }
    class Prod extends Exp {
        Exp esq, dir;
        Prod(Exp e, Exp d) {
            esq = e; dir = d;
        }
        int avalie() {
            return esq.avalie() * dir.avalie();
        }
        int accept(VisitorExp v) { return v.visit(this); }
    }
    class Const extends Exp {
        String num;
        Const(String n) { num = n;}
        int avalie() {
            return Integer.parseInt(num);
        }
        int accept(VisitorExp v) { return v.visit(this); }

    }
    // 1 + 2 * 3
    Exp t2 = new Soma(
        new Const("1"),
        new Prod(
            new Const("2"),
            new Const("3")
        ) 
    );

    int avalie2(Exp ex) {
        if (ex instanceof Soma) {
            Soma soma = (Soma) ex;
            return avalie2(soma.esq) + avalie2(soma.dir);
        }
        if (ex instanceof Prod) {
            Prod prod = (Prod) ex;
            return avalie2(prod.esq) * avalie2(prod.dir);
        }
        if (ex instanceof Const) {
            Const cons = (Const)ex;
            return Integer.parseInt(cons.num);
        }
        throw new RuntimeException("Não sei compilar : "+ex.getClass().getName());

    }


    class Avaliador implements VisitorExp {
        public int visit(Soma s) {
            return avalie3(s.esq) + avalie3(s.dir); 
        }
        public int visit(Prod p) {
            return avalie3(p.esq) *  avalie3(p.dir);
        }
        public int visit(Const c) {
            return Integer.parseInt(c.num); 
        }
    }
    Avaliador avaliador = new Avaliador(); 
    int avalie3(Exp ex) {
        return ex.accept(avaliador); 
    }
    void main() {
        System.out.printf("valor avalie1 = %d\n", avalie1(t1));
        System.out.printf("valor avalie2 = %d\n", avalie2(t2));
        System.out.printf("valor t2.avalie() = %d\n", t2.avalie());
        System.out.printf("valor avalie3 = %d\n", avalie3(t2));
        
    }
    public static void main(String args[]) {
        new ExemplosAlgoritmosArvores().main();
    }


}