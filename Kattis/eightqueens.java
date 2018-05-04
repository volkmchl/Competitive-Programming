import java.util.*;

//probid: 8queens

public class eightqueens {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        char board[][] = new char[8][8];
        boolean invalid = false;
        int count = 0;

        for(int i = 0; i < 8; i++){

            String row = in.nextLine();
            
            for(int j = 0; j < 8 ; j++){

                board[i][j] = row.charAt(j);
                
                if(!invalid){
                    if(board[i][j] == '*'){     
                        count++;
                        
                        for(int k = i+1; k < 8; k++){               //keep col constant, flag row
                            if(board[k][j] == '*'){
                                invalid = true;
                            }
                        }
                        
                        for(int k = i-1; k >= 0; k--){
                            if(board[k][j] == '*'){
                                invalid = true;
                            }
                        }
                        
                        for(int m = j+1; m < 8; m++){               //keep row constant
                            if(board[i][m] == '*'){
                                invalid = true;
                            }
                        }
                        
                        for(int m = j-1; m >= 0; m--){
                            if(board[i][m] == '*'){
                                invalid = true;
                            }
                        }

                        int keepI = i-1;
                        int keepJ = j-1;

                        //flag NORTHWEST TO SOUTHEAST DIAG
                        while(keepI >= 0 && keepJ >= 0){
                            if(board[keepI--][keepJ--] == '*'){
                                invalid = true;
                            }
                        }

                        keepI = i+1;
                        keepJ = j+1;
                        while(keepI < 8 && keepJ < 8){
                            if(board[keepI++][keepJ++] == '*'){
                                invalid = true;
                            }
                        }
                        //***********************************

                        //flag NORTHEAST TO SOUTHWEST DIAG
                        keepI = i-1;
                        keepJ = j+1;

                        while(keepI >= 0 && keepJ < 8){
                            if(board[keepI--][keepJ++] == '*'){
                                invalid = true;
                            }
                        }

                        keepI = i+1;
                        keepJ = j-1;

                        while(keepI < 8 && keepJ >= 0){
                            if(board[keepI++][keepJ--] == '*'){
                                invalid = true;
                            }
                        }
                    }

                }
            }
        }
        
        if(invalid || count <8){
            System.out.println("invalid");
        }
        else{
            System.out.println("valid");
        }
    }
}
