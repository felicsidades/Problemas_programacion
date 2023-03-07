import java.util.*;
import java.io.*;

public class solucion{
    public static void main(String[] arg) throws FileNotFoundException{
        File fichero = new File("input.txt");
        Scanner input = new Scanner(fichero);
        int cantidad= input.nextInt()+1;
        int numValores= input.nextInt();
        int[] v = new int[numValores];
        for(int i=0;i<numValores;i++)
            v[i]=input.nextInt();
        int[][] m=new int[numValores][cantidad];
        for(int i=0;i<numValores;i++)
            m[i][0]=0;
        for(int j=1;j<cantidad;j++){
            if(v[0]>j)
                m[0][j]=cantidad+1;
            else if(j%v[0]==0)
                m[0][j]=j/v[0];
            else
                m[0][j]=1+m[0][j-v[0]];
        }
        for(int i=1;i<numValores;i++){
            for(int j=1;j<cantidad;j++){
                if(v[i]>j)
                    m[i][j]=m[i-1][j];
                else if(j%v[i]==0){
                    int div=j/v[i];
                    m[i][j]=Math.min( m[i-1][j], div+m[i][j-(div*v[i])]);
                }
                else
                    m[i][j]=Math.min( m[i-1][j], 1+m[i][j-v[i]]);
            }
        }
        System.out.print(m[numValores-1][cantidad-1]);
        input.close();
    }
}