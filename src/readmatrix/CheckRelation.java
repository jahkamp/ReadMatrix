package readmatrix;
/**
 * Homework 6 programming
 * This program reads in a binary relation matrix and determines
 * the reflexivity, symmetry, and transitivity of the matrix
 * and then prints out whether or not it is an equivalence matrix
 * @author Karl L Ohaus
 * @author Jared Kamp
 */
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class CheckRelation {

    static int[][] matrix;

    public static void readMatrix() {
        try {
            Scanner scanner = new Scanner(new File("matrix.txt"));
            int i = 0;
            matrix = null;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineArr = line.split(" ");
                int N = lineArr.length; // N x N matrix
                if (matrix == null) {
                    matrix = new int[N][N]; // allocate the matrix once we know the size
                }
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(lineArr[j]);
                }
                i++; // increment current matrix row
            }
        } catch (FileNotFoundException ex) {
            System.err.println("File not found, exiting.");
            System.exit(-1);
        }
    }
    
    public static void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }
      public static boolean CompReflex(){
        for(int i=0;i<matrix.length; i++){
            if(matrix[i][i]==0){
                return false;
            }
    }
        return true;
    
    }
    
    public static boolean CompSymm(){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                if(matrix[i][j]!=matrix[j][i]){
                    return false;
                }
                    
            }
        }
        return true;
    }
    
    public static boolean CompTrans(){
        for (int i=0;i<matrix.length;i++){
            for(int j=0; j<matrix.length;j++){
                for(int k=0;k<matrix.length;k++){
                    if(matrix[i][j]==1 && matrix[j][k] == 1 && matrix[i][k]==0){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean reflexive = true;
        boolean symmetric = true;
        boolean transitive = true;
        readMatrix();
        printMatrix();
        reflexive = CompReflex();
        symmetric = CompSymm();
        transitive = CompTrans();
        System.out.println("Reflexive: " + reflexive +", Symmetric: " + symmetric + ", Transitive: "+transitive);
        if(reflexive == false){
            System.out.println("The matrix is not an equivalnece relation!  It is not reflexive.");
        }
        else if (symmetric == false){
            System.out.println("The matrix is not an equivalnece relation!  It is not symmetric.");
        }
        else if (transitive == false){
            System.out.println("The matrix is not an equivalnece relation!  It is not transitive.");
        }
        else if(reflexive == true && symmetric == true && transitive == true){
            System.out.println("The matrix is an equivalence relation!");
        }

        
    }

}
