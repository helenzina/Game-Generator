package game.BoardOperations;


import org.json.simple.JSONObject;

public class BoardFactory {

    public static BoardService getInstance(JSONObject gameObj) throws Exception {
        String boardType= gameObj.get("board_type").toString();
        switch(boardType){
            case "limited_range":
                return new LimitedRangeBoard();
            case "endless":
                return new EndlessBoard();
            default:
                throw new Exception();
        }
    }
}
