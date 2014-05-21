/**
 * Created by Yariza on 5/16/2014.
 */
import com.sun.corba.se.spi.orbutil.fsm.Input;

import javax.swing.*;
import java.awt.*;

public class ABCButton extends JFrame {
    JButton A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z;
    ABCButton(){


        A = new JButton("a");
        B = new JButton("b");
        C = new JButton("c");
        D = new JButton("d");
        E = new JButton("e");
        F = new JButton("f");
        G = new JButton("g");
        H = new JButton("h");
        I = new JButton("i");
        J = new JButton("j");
        K = new JButton("k");
        L = new JButton("l");
        M = new JButton("m");
        N = new JButton("n");
        O = new JButton("o");
        P = new JButton("p");
        Q = new JButton("q");
        R = new JButton("r");
        S = new JButton("s");
        T = new JButton("t");
        U = new JButton("u");
        V = new JButton("v");
        W = new JButton("w");
        X = new JButton("x");
        Y = new JButton("y");
        Z = new JButton("z");

        setLayout(new FlowLayout());
        add(A);
        add(B);
        add(C);
        add(D);
        add(E);
        add(F);
        add(G);
        add(H);
        add(I);
        add(J);
        add(K);
        add(L);
        add(M);
        add(N);
        add(O);
        add(P);
        add(Q);
        add(R);
        add(S);
        add(T);
        add(U);
        add(V);
        add(W);
        add(X);
        add(Y);
        add(Z);



        setVisible(true);
        setSize(500,500);
        setLocation(200,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }
    public static void main(String[] args){
        new ABCButton();
    }

}
