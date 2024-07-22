package game.RulesOperations;

public class Rule {
    private String message;

    public Rule(){
        this.message = "";
    }

    public Rule(String message){
        this.message = message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
