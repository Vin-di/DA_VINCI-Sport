public class Engine {
    private Regeneration regeneration=Regeneration.D;
    private double consumption, acceleration;
    private int power, velocity, max_velocity;
    private final Gears gears;

    public Engine(int power){
        this.velocity=0;
        this.acceleration=0.0;
        this.max_velocity=250;
        this.consumption=0.0;
        this.power=power;
        gears = new Gears();
    }

    public void setVelocity(int velocity) {this.velocity = velocity;}
    public int getVelocity() {return this.velocity;}

    public void setRegeneration(Regeneration regeneration) {this.regeneration = regeneration;}
    public Regeneration getRegeneration(){return this.regeneration;}

    public void setMax_velocity(int max_velocity) {this.max_velocity=max_velocity;}
    public int getMax_velocity() {return this.max_velocity;}

    private void setConsumption(double consumption){this.consumption=consumption;}
    public double getConsumption() {return this.consumption;}

    public void setAcceleration(double acceleration) {this.acceleration = acceleration;}
    public double getAcceleration() {return this.acceleration;}

    public void setPower(int power) {this.power = power;}
    public int getPower() {return this.power;}

    public void accelerate(boolean charge, boolean open_doors, double acceleration) {
        if (!(charge & open_doors)) {
            this.acceleration=acceleration;
            if (velocity <= max_velocity) {this.velocity += acceleration;}
            else System.out.println("Maximum speed reached!!");
        }else{
            if (charge) {System.out.println("Unplug the charger before you can leave");}
            else if (open_doors) {System.out.println("Close all doors before you can leave");}
        }
    }

    public void parking(){
        this.velocity=0;
        this.gears.parking();
    }

    public void decelerate() {
        if (velocity > 0) {
            if (this.regeneration == Regeneration.D) {this.velocity -= (acceleration/2);}
            else if (this.regeneration == Regeneration.B) {this.velocity -= acceleration;}
            else if (this.regeneration == Regeneration.AUTO) {this.velocity -= acceleration;}
        }
        if (velocity == 0) {gears.parking();}
    }

    public void chg_gear(Gear gear){ this.gears.chg_gear(gear);}
    public Gear getGear(){return this.gears.getGear();}

}
