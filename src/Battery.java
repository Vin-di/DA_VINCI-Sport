public class Battery {
    private double temperature;
    private int battery;
    private final int capacity;
    private boolean energy_saving, in_charge;

    public Battery(int capacity){
        this.battery=80;
        this.energy_saving=false;
        this.in_charge=false;
        this.capacity=capacity;
        this.temperature=20.0;
    }

    private void setBattery(int battery) {this.battery=battery;}
    public int getBattery() {return this.battery;}

    public void setIn_charge(boolean in_charge) {this.in_charge = in_charge;}
    public boolean isIn_charge() {return this.in_charge;}

    public void setEnergy_saving(boolean energy_saving) {this.energy_saving = energy_saving;}
    public boolean isEnergy_saving() {return this.energy_saving;}

    public int getCapacity() {return this.capacity;}

    public void setTemperature(double temperature) {this.temperature = temperature;}
    public double getTemperature(){return this.temperature;}


    public void charge_battery(float max_velocity, Regeneration regeneration){
        if (!this.in_charge) {this.in_charge=true;}
        for (int i=0;battery<100;i++){
            if (this.battery>=20 && energy_saving) {
                this.energy_saving=false;
                max_velocity=250;
                regeneration=Regeneration.D;
            }
            if (this.battery>79){this.battery+=i/10;}
            else {this.battery+=i/5;}
            System.out.println("Battery percentage: "+this.battery+"%");
        }
        System.out.println("Full charge!");
        this.in_charge=false;
    }
    public void discharge_battery(float max_velocity, Regeneration regeneration){
        while (this.battery>0) {
            this.battery-=0.5;
            if ((battery>0 && battery<=20) ^ this.energy_saving) {energy_saving(max_velocity,regeneration);}
        }
        if (this.battery==0) {System.out.println("Low battery!!");}
    }

    private void energy_saving(float max_velocity, Regeneration regeneration){
        this.energy_saving=true;
        max_velocity=80;
        regeneration=Regeneration.B;
        System.out.println("Energy saving on:\n" +
                "Maximum speed set a "+max_velocity+"km/h\n" +
                "Regenerative braking set to "+regeneration);
    }

    public void increases_temperature() {this.temperature+=1;}
    public void decrease_temperature() {this.temperature-=1;}

}
