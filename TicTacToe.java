/**
 * Java-1 Homework-4
 *
 * @autor Timofei Tokarev
 * @version dated 23.07.18
 */

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

//    final int SIZE=3;
//    final int LINE=3;

    final int SIZE=5;
    final int LINE=4;

    final char DOT_X='x';
    final char DOT_O='o';
    final char DOT_EMPTY='.';
    char[][] map=new char[SIZE][SIZE];
    char[][] test={
            {'x','x','x'},
            {'x','.','.'},
            {'x','.','x'}};
    Scanner sc=new Scanner(System.in);
    Random rand=new Random();



    public static void main(String[] args) {

        new TicTacToe();
    }
    TicTacToe(){
        play();
    }

    public void play(){
        initMap();
        while (true){
            humanTurn();
            if (checkWin(DOT_X)){
                System.out.println("You won! :D");
                break;
            }
            if (isMapFull()){
                System.out.println("Draw '.'");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)){
                System.out.println("You lose! :P");
                break;
            }
            if (isMapFull()){
                System.out.println("Draw '.'");
                break;
            }

        }
        end();
    }


    public void initMap(){
        for (int i=0;i<SIZE;i++)
            for (int j=0;j<SIZE;j++)
                map[i][j]=DOT_EMPTY;

    }

    public void humanTurn(){
        int x,y;
        do {
            System.out.println("Enter X and Y (1.."+LINE+"):");
            x=sc.nextInt()-1;
            y=sc.nextInt()-1;
        }while (!isCellValid(x,y));
        map[y][x]=DOT_X;
    }


    void aiTurn(){
        int x,y;
        do {
            x=rand.nextInt(SIZE);
            y=rand.nextInt(SIZE);
        }while (!isCellValid(x,y));
        map[y][x]=DOT_O;
    }

    boolean isCellValid(int x,int y){
        if (x<0||y<0||x>=SIZE||y>=SIZE)
            return false;
        return map[y][x]==DOT_EMPTY;
    }

    boolean isMapFull() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (map[i][j] == DOT_EMPTY)
                    return false;
        return true;
    }

    boolean checkWin(char dot){
        int[] arr1=new int[LINE*2];
        int[] arr2=new int[LINE*2];
        /// Горизонталь и вертикаль
        for (int a=0;a<=SIZE-LINE;a++)       // Можно разделить размер не вертикальный и горизонтальный
            for (int b=0;b<=SIZE-LINE;b++) {
                for (int i = a; i < LINE + a; i++) {
                    for (int j = b; j < LINE + b; j++) {
                        if (map[i][j] == dot)
                            arr1[i]++;
                        if (map[j][i] == dot)
                            arr2[i]++;
                    }
                    if (arr1[i]==LINE)
                        return true;
                    else arr1[i]=0;
                    if (arr2[i]==LINE)
                        return true;
                    else arr2[i]=0;
                }
            }
            // Диагонали
        for (int a=0;a<=SIZE-LINE;a++)
            for (int b=0;b<=SIZE-LINE;b++) {
                for (int i = a, j = b; i < LINE + a; i++, j++) {
                    if (map[i][j] == dot)
                        arr1[0]++;
                    if (map[i][LINE - j] == dot)
                        arr2[1]++;
                }
                if (arr1[0]==LINE)
                    return true;
                else arr1[0]=0;
                if (arr2[1]==LINE)
                    return true;
                else arr2[1]=0;
            }
        return false;
    }

    void printMap(){
        for (int i=0;i<SIZE;i++) {
            for (int j = 0; j < SIZE; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
    }
    public void end(){
        printMap();
        System.out.println("------------------------------");
        System.out.println("Do u want to play, again?(y/n)");
        String input=sc.next();
        char ans=input.charAt(0);
        if (ans == 'y'|| ans=='н')
            play();
        else
            System.out.println("Good bye take care!");
    }
}
