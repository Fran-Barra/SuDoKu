package javasolver;

public class BackTrackingSolver {
    public static boolean backTracking(byte[][] SuDoKu){
        for (byte y = 0; y<9; y++) {
            for (byte x = 0; x < 9; x++) {
                if (SuDoKu[x][y] == 0) {
                    for (byte i = 1; i < 10; i++) {
                        SuDoKu[x][y] = i;
                        if (checker(SuDoKu, x, y)){
                            if (backTracking(SuDoKu))
                                return true;
                            SuDoKu[x][y] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }


    private static boolean checker(byte[][] SuDoKu, byte x, byte y){
        //check column
        for(byte j = 0; j<9; j++){
            if (SuDoKu[x][j] == SuDoKu[x][y] && y!=j)
                return false;
        }

        //check row
        for(byte i = 0; i<9; i++){
            if (SuDoKu[i][y] == SuDoKu[x][y] && x!=i)
                return false;
        }

        //left top of big square
        byte pX = (byte)((x/3)*3);
        byte pY = (byte)((y/3)*3);

        //check big square
        for (byte j = pY; j<pY+3; j++){
            for (byte i = pX; i<pX+3; i++){
                if (SuDoKu[i][j] == SuDoKu[x][y] && x!=i && y!=j)
                    return false;
            }
        }

        return true;
    }
}

