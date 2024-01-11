public class Gears {
    private Gear gear, pre_gear;

    public Gears(){
        this.gear=Gear.P;
        this.pre_gear=Gear.P;
    }

    public Gear getGear() {return this.gear;}
    public Gear getPre_gear() {return this.pre_gear;}

    public void parking(){switch_gear(pre_gear);}// change gear between R or D and P
    public void chg_gear(Gear marcia){switch_gear(marcia);}//change gear between R and D

    private void switch_gear(Gear now){//method to switch gear
        this.pre_gear=this.gear;
        this.gear=now;
    }


}