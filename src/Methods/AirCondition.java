package Methods;

public class AirCondition {
    private boolean on;
    private int temp;

    public AirCondition(){
        this.on = false;
        this.temp= 20;
    }

    public boolean power(){
        if (this.on == false){
            this.on = true;
        }else {
            this.on = false;
        }
        return this.on;
    }


    public String increse(){
        if(this.on == false){
            return "Air condition is off";
        }else if(this.temp >= 30){
            return "The air condition at its highest";
        }else {
            this.temp ++;
            return String.valueOf(this.temp);
        }
    }


    public String max(){
        if(this.on == false){
            return "Air condition is off";
        }else {
            this.temp = 30;
            return String.valueOf(this.temp);
        }
    }


    public String decrese(){
        if(this.on == false){
            return "Air condition is off";
        }else if (this.temp <=16){
            return "ac is at it coldest";
        }else {
            this.temp --;
            return String.valueOf(this.temp);
        }
    }

    public String Min(){
        if(this.on == false){
            return "Air condition is off";
        }else {
            this.temp = 16;
            return String.valueOf(this.temp);
        }
    }

}
