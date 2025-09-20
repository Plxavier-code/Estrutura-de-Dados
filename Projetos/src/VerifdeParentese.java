import java.util.Stack;

public class VerifdeParentese {

    public boolean VerPar(String input) {
        Stack<Character> pilha = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char a = input.charAt(i);

            if (a == '(' || a == '{' || a == '[') {
                pilha.push(a);
            } else if (a == ')' || a == '}' || a == ']') {
                if (pilha.isEmpty()) {
                    return false; 
                }

                char topo = pilha.pop();
                if ((a == ')' && topo != '(') ||
                    (a == '}' && topo != '{') ||
                    (a == ']' && topo != '[')) {
                    return false; 
                }
            }
        }

        return pilha.isEmpty();
    }

    public static void main(String[] args) {
        VerifdeParentese v = new VerifdeParentese();
        System.out.println(v.VerPar("(2+3)*[5-(3+1)]")); 
        System.out.println(v.VerPar("(2+3]*5"));         
        System.out.println(v.VerPar("((()))"));          
        System.out.println(v.VerPar("(()"));             
        System.out.println(v.VerPar(")("));              
    }
}
/*Primeira ideia que deu errado 
import java.util.Stack; 
public class VerifdeParentese { 
    // inserir 
    public boolean VerPar(String input){ 
        Stack<Character> pilha = new Stack<>(); 
        int cont = 0; 
        char a; 

        //verificação 
        for (int i = 0; i < input.length(); i++ ){ 
            a = input.charAt(i); 
            if(a=='('||a=='{'||a=='['||a==')'||a=='}'||a==']'){ 
                pilha.push(a); 
            } 
        } 

        for (int i = 0; i < pilha.size(); i++) { 
            char aux; 
            aux = pilha.pop(); 
            if(aux==')'||aux=='}'||aux==']'){ 
                cont++; 
            } else { 
                cont--; 
            } 
        } 

        return (cont==0); 
    } 

    public static void main(String[] args) { 
        VerifdeParentese v = new VerifdeParentese(); 
        System.out.println(v.VerPar("(2+3)*[5-(3+1)]")); // true 
        System.out.println(v.VerPar("(2+3]*5")); // false 
        System.out.println(v.VerPar("((()))")); // true 
        System.out.println(v.VerPar("(()")); // false 
        System.out.println(v.VerPar(")(")); // false 
    } 
} */