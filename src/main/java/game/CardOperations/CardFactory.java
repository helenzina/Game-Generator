package game.CardOperations;

import org.json.simple.JSONObject;

public class CardFactory {
    public static CardService getInstance(JSONObject jsonObject) throws Exception {
        final String parameter = jsonObject.get("parameter").toString();
        switch (parameter) {
            case "start" -> {
                final int id = Integer.parseInt(jsonObject.get("id").toString());
                final String message = jsonObject.get("message").toString();
                final int value = Integer.parseInt(jsonObject.get("value").toString());
                return new StartCard(id, message, parameter, value);
            }
            case "points" -> {
                final int id = Integer.parseInt(jsonObject.get("id").toString());
                final String message = jsonObject.get("message").toString();
                final int value = Integer.parseInt(jsonObject.get("value").toString());
                return new PointsCard(id, message, parameter, value);
            }
            case "min_points_tile" -> {
                final int id = Integer.parseInt(jsonObject.get("id").toString());
                final String message = jsonObject.get("message").toString();
                final int value = Integer.parseInt(jsonObject.get("value").toString());
                return new ChangeTileMinPCard(id, message, parameter, value);
            }
            case "max_points_tile" -> {
                final int id = Integer.parseInt(jsonObject.get("id").toString());
                final String message = jsonObject.get("message").toString();
                final int value = Integer.parseInt(jsonObject.get("value").toString());
                return new ChangeTileMaxPCard(id, message, parameter, value);
            }
            case "mul_points" -> {
                final int id = Integer.parseInt(jsonObject.get("id").toString());
                final String message = jsonObject.get("message").toString();
                final int value = Integer.parseInt(jsonObject.get("value").toString());
                return new MulPointsCard(id, message, parameter, value);
            }
            case "div_points" -> {
                final int id = Integer.parseInt(jsonObject.get("id").toString());
                final String message = jsonObject.get("message").toString();
                final int value = Integer.parseInt(jsonObject.get("value").toString());
                return new DivPointsCard(id, message, parameter, value);
            }
            case "steal_points" -> {
                final int id = Integer.parseInt(jsonObject.get("id").toString());
                final String message = jsonObject.get("message").toString();
                final int value = Integer.parseInt(jsonObject.get("value").toString());
                return new StealPointsCard(id, message, parameter, value);
            }
            default -> {
                throw new Exception();
            }
        }
    }
}
