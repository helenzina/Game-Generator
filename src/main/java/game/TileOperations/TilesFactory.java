package game.TileOperations;

import org.json.simple.JSONObject;

public class TilesFactory {
    public static TileService getInstance(JSONObject jsonObject) throws Exception {
        final String parameter = jsonObject.get("parameter").toString();
        switch (parameter) {
            case "simple" -> {
                final int index = Integer.parseInt(jsonObject.get("index").toString());
                final int value = Integer.parseInt(jsonObject.get("value").toString());
                return new SimpleTile(index, value);
            }
            case "card" -> {
                final int index = Integer.parseInt(jsonObject.get("index").toString());
                final String stat = jsonObject.get("stat").toString();
                final int value = Integer.parseInt(jsonObject.get("value").toString());
                return new CardTile(index, stat, parameter, value);
            }
            case "points" -> {
                final int index = Integer.parseInt(jsonObject.get("index").toString());
                final String stat = jsonObject.get("stat").toString();
                final int value = Integer.parseInt(jsonObject.get("value").toString());
                return new PointsTile(index, stat, parameter, value);
            }
            case "dicepoints" -> {
                final int index = Integer.parseInt(jsonObject.get("index").toString());
                final String stat = jsonObject.get("stat").toString();
                final int value = Integer.parseInt(jsonObject.get("value").toString());
                return new DicePointsTile(index, stat, parameter, value);
            }
            case "tile" -> {
                final int index = Integer.parseInt(jsonObject.get("index").toString());
                final String stat = jsonObject.get("stat").toString();
                final int value = Integer.parseInt(jsonObject.get("value").toString());
                return new BackAndForthTile(index, stat, parameter, value);
            }
            case "none" -> {
                final int index = Integer.parseInt(jsonObject.get("index").toString());
                final String stat = jsonObject.get("stat").toString();
                final int value = Integer.parseInt(jsonObject.get("value").toString());
                return new BlankTile(index, stat, parameter, value);
            }
            default -> {
                throw new Exception();
            }
        }
    }
}
