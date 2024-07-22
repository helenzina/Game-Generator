package game.GameplayOperations;

public class Player {
    private int id;
    private String name;
    private int position;
    private int initialPoints;
    private int points;

    public Player(){
        this.id = 0;
        this.name = "";
        this.position = 0;
        this.initialPoints = 0;
        this.points = 0;
    }

    public Player(int id, String name, int position, int initialPoints, int points) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.initialPoints = initialPoints;
        this.points = points;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setPosition(int position){
        this.position = position;
    }

    public int getPosition(){
        return this.position;
    }

    public void setPoints(int points){ this.points = points; }

    public int getPoints(){
        return this.points;
    }

    public int getInitialPoints() { return this.initialPoints; }

    public void setInitialPoints(int initialPoints) { this.initialPoints = initialPoints; }
}
