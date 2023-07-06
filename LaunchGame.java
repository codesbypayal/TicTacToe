import java.util.Scanner;
class TicTacToe
{
    /**
     *
     */
   static char[][] board = new char[3][3];//without creating object when we have to access function we use static //

    /**
     * 
     */
    void initboard()
    {
        for(int i =0; i<board.length; i++)
        {
            for(int j =0; j< board.length ; j++)
            {
                board[i][j] = ' ';//initialise the board 
            }
        }
   }


/**
 * 
 */
static void  dispBoard()//displaying thr board 
{
    System.out.println("-------------");

    for(int i=0; i<board.length; i++)
    {
        System.out.print(" | "); // row divided into three //
        for(int j =0; j<board.length;j++)
        {   // inside column // 
            System.out.print(board[i][j] + " | ");// print space - pipe 
        }
        System.out.println();
        System.out.println("-------------");// box closed 
    }
}
 // initailising the input of row and col and X or O//
/**
 * @param row
 * @param col
 * @param mark
 */
static void placeMark(int row , int col , char mark )
 {
    /*board[row][col] = mark;//
    // valid boundrries if user enter the the dim of box 
    more than 2 because box is 3*3 only/ */
    
    if(row >=0 && row <= 2 && col >=0 && col <=2)
    {
        board[row][col]= mark;
    }
    else
    {
        System.out.println("invalid position");
    }
 }

//check column win //
/**
 * @return
 */
static boolean checkColWin()
{
    for(int j =0; j<=2 ; j++)
    {   // checking the first cahracter is not equal to null //
        if(  board[0][j] != ' ' &&  board[0][j] == board[1][j] && board[1][j] ==   board[2][j] )
        {
            return true;
        }
    }
    return false;
}

//checking for the row //
static boolean checkRowWin()
{
    for(int i=0;i<=2;i++)
    {  // checking the first cahracter is not equal to null // 
        if(board[i][0] != ' ' && board[i][0] == board[i][1] &&  board[i][1] == board[i][2] )
         {
             return true;
         }          
    }
    return false;
}

/**
 * @return
 */
//checking for both daignol//
static boolean CheckDiagWin()
{
    if( board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2] ||  board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0])
    {
        return true;
    }
    return false;
}

}

class HumanPlayer
{
    String name;
    char mark;

    //create constructor //
    HumanPlayer(String name , char mark)
    {
        this.name = name ;
        this.mark = mark;
    }

    void makeMove()
    {
        Scanner sc = new Scanner(System.in);
        int row;
        int col;
       do
       {
        System.out.println("enter the row and col");
         row = sc.nextInt();
         col = sc.nextInt();
       } while( ! isValidMove(row, col));

       TicTacToe.placeMark(row, col, mark);
    }

  boolean isValidMove(int row , int col)
    {
        if(row>=0 && row <=2 && col>=0 && col<=2)
        {
            if(TicTacToe.board[row][col] == ' ')
            {
                return true;
            }
        }
        return false;
    }
}


public class LaunchGame
{
    /**
     * @param args
     */
    public static void main(String args[])
    {
        TicTacToe t= new TicTacToe();
      HumanPlayer p1 =  new HumanPlayer("bob",'X');
      HumanPlayer p2 = new HumanPlayer("payal",'O');

        //create reference as current player //
        HumanPlayer cp; 
        cp = p1;
        while(true)
    {
        System.out.println(cp.name + "turn");
        cp.makeMove();
        TicTacToe.dispBoard();
        if(TicTacToe.checkColWin() || TicTacToe.checkRowWin() || TicTacToe.CheckDiagWin())
        {
            System.out.println(cp.name + "has won" );
            break;
        }
        else
        {
            if(cp == p1)
            {
                cp = p2;
            }
            else 
            {
                cp = p1;
            }
        }
    }
 }
}