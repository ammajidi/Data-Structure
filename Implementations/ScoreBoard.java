
public class ScoreBoard {
    private GameEntry[] gameArray;
    int numEntries;
    int[] emptyIndexes=new int[10];


    public ScoreBoard(int capacity) {
        setGameArray(new GameEntry[capacity]);
    }
    void add(GameEntry g){
        GameEntry min=new GameEntry();
        if(numEntries==0){
            min=g;
        }
        else if(g.getScore()<min.getScore()){
            min=g;
        }
        if(numEntries<gameArray.length){
            if(numEntries!=0 && g.getScore()>gameArray[0].getScore()){
                GameEntry temp=new GameEntry();
                temp=gameArray[0];
                gameArray[0]=g;
                gameArray[numEntries]=temp;
                numEntries++;
            }
            else{
                gameArray[numEntries]=g;
                numEntries++;
            }
        }

        //when board is full:

        else if(g.getScore()>min.getScore()){
            gameArray[gameArray.length-1]=g;

        }
        else if(g.getScore()<min.getScore()){
            System.out.print("Your Score is lower than the minimum !Try again ");
        }

    }


    public void remove (Integer index) throws IndexOutOfBoundsException{

        if(index>numEntries || index<0){
            throw new IndexOutOfBoundsException("you should choose a valid index");
        }
        else{
            gameArray[index]=null;
        }

    }

    public GameEntry[] getGameArray() {
        return gameArray;
    }


    public void setGameArray(GameEntry[] gameArray) {
        this.gameArray = gameArray;
    }



}
