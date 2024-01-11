public class AirConditioning {

    private boolean air_conditioning_on;
    private double temperature;
    private Climate typology;
    private int velocity;
    private Purification purification;


    public AirConditioning(){
        this.air_conditioning_on=false;
        this.temperature=20.0;
        this.typology=Climate.WINDSHIELD_DEFROSTING;
        this.velocity=0;
        this.purification=Purification.RECIRCULATION;
    }

    public void on_off_air_conditioning() {
        this.air_conditioning_on = !air_conditioning_on;
        if(air_conditioning_on){
            setVelocity(1);
            setTemperature(20);
        }
        else setVelocity(0);
    }
    public boolean isClima_acceso() {return this.air_conditioning_on;}

    public void setTemperature(double temperature) {this.temperature = temperature;}
    public double getTemperature() {return this.temperature;}

    public void setTipology(Climate typology) {
        this.typology=typology;
        if(!isClima_acceso()) on_off_air_conditioning();
    }
    public Climate getTipology() {return this.typology;}

    public void setVelocity(int velocity) {
        this.air_conditioning_on= (velocity != 0);
        this.velocity=velocity;
    }
    public int getVelocity() {return this.velocity;}

    public void setPurification(Purification purification){this.purification = purification;}
    public Purification getPurification() {return this.purification;}
}
