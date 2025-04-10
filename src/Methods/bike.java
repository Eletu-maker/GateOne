package Methods;

public class bike {
    private boolean on;
    private int acc;
    private int gear;


    public bike(){
        this.on = false;
        this.acc = 0;
        this.gear =1;
    }

    public boolean power(){
        if(this.on == false){
            this.on = true;
        }else {
            this.on = false;
        }
        return this.on;
    }

    public String increse() {
        if (this.on == false) {
            return "bike is off";
        } else {
            String result;
            this.acc++;
            if (this.acc >= 0 && this.acc <= 20) {
                this.gear = 1;

            }
            if (this.acc > 20 && this.acc <= 29) {
                this.gear = 2;

            }
            if (this.acc > 30 && this.acc <= 40) {
                this.gear = 3;

            }
            if (this.acc>40){
                this.gear = 4;

            }
            result = String.format("acceleration of %dm/s at gear%d", this.acc, this.gear);
            return result;
        }
    }


    public String decrease(){
        if (this.on == false) {
            return "bike is off";
        } else {
            if( this.acc <=0){
                return "no speed yet can not decrease";
            }else {
                String result ;
                this.acc--;
                if (this.acc >= 0 && this.acc <= 20) {
                    this.gear = 1;

                }
                if (this.acc > 20 && this.acc <= 30) {
                    this.gear = 2;

                }
                if (this.acc > 30 && this.acc <= 40) {
                    this.gear = 3;

                } if(this.acc > 40){
                    this.gear = 4;

                }
                result = String.format("acceleration of %dm/s at gear%d", this.acc, this.gear);
                return result;
            }
        }
    }
}
