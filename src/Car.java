public class Car {
    private int total_kilometers,partial_kilometres;
    private boolean car_on;
    private final Battery battery;
    private final Car_door passenger_front_door;
    private final Car_door driver_door;
    private final Door hood;
    private final Door luggage;
    private final Engine motor;
    private final AirConditioning driver_climate;
    private final AirConditioning passenger_climate;
    private final AirConditioning car_climate;
    private final Security_belt driver_security_belt;
    private final Security_belt passenger_security_belt;

    public Car(int capacity, int power){
        this.car_on=true;
        this.partial_kilometres=0;
        this.total_kilometers=0;
        this.battery=new Battery(capacity);
        this.motor=new Engine(power);
        this.driver_door=new Car_door();
        this.passenger_front_door=new Car_door();
        this.hood=new Door();
        this.luggage=new Door();
        this.driver_climate=new AirConditioning();
        this.passenger_climate=new AirConditioning();
        this.car_climate=new AirConditioning();
        this.driver_security_belt=new Security_belt();
        this.passenger_security_belt=new Security_belt();
    }

    //Total kilometers
    public void setKm_tot(int kilometers) {this.total_kilometers=kilometers;}
    public int getKm_tot() {return this.total_kilometers;}
    public void increase_Km_tot() {this.total_kilometers+=1;}

    //Partial kilometers
    public void setKm_part(int partial_kilometres) {this.partial_kilometres=partial_kilometres;}
    public int getKm_part() {return partial_kilometres;}
    public void reset_Km_part() {this.partial_kilometres=0;}
    public void increase_Km_parz() {this.partial_kilometres+=1;}

    //car on/off
    public void car_on() {this.car_on=true;}
    public void car_off() {this.car_on=false;}
    public boolean isCar_on() {return this.car_on;}

    //battery
    public void stop_charge() {this.battery.setIn_charge(false);}
    public void charge_car() {this.battery.charge_battery(this.motor.getMax_velocity(),this.motor.getRegeneration());}
    public void discharge_battery() {this.battery.discharge_battery(this.motor.getMax_velocity(),this.motor.getRegeneration());}
    public boolean isIn_charge() {return this.battery.isIn_charge();}
    public int percentage() {return this.battery.getBattery();}
    public void energy_saving_on_off() {this.battery.setEnergy_saving(!this.battery.isEnergy_saving());}
    public boolean isEnergy_saving() {return this.battery.isEnergy_saving();}
    public double getBattery_temperature() {return this.battery.getTemperature();}
    public int getBattery_capacity() {return this.battery.getCapacity();}

    //Motor
    public void setMax_velocity(int max_velocity) {this.motor.setMax_velocity(max_velocity);}
    public int getMax_velocity() {return this.motor.getMax_velocity();}
    public int getVelocity() {return this.motor.getVelocity();}
    public void accelerate(double velocity) {this.motor.accelerate(battery.isIn_charge(),driver_door.isClosed_door()&&passenger_front_door.isClosed_door()&& hood.isClosed_door()&&luggage.isClosed_door(),velocity);}
    public void decelerate() {this.motor.decelerate();}
    public void change_gear(Gear gear) {this.motor.chg_gear(gear);}
    public Gear getGear() {return this.motor.getGear();}
    public double getConsumption() {return this.motor.getConsumption();}
    public int getPower() {return this.motor.getPower();}
    public void setRegeneration(Regeneration regeneration){this.motor.setRegeneration(regeneration);}
    public Regeneration getRegeneration() {return this.motor.getRegeneration();}
    public void parking() {this.motor.parking();}

    //car's door/ hood & luggage
    public void open_close_driver_door() {this.driver_door.open_close_door();}
    public void open_close_window_driver_door() {this.driver_door.open_close_window();}
    public void lock_unlock_driver_door() {this.driver_door.lock_unlock_door();}
    public boolean isDriver_windows_closed() {return this.driver_door.isClosed_window();}
    public boolean isDriver_door_closed() {return this.driver_door.isClosed_door();}
    public boolean isDriver_door_locked() {return this.driver_door.isLocked_door();}

    public void open_close_passenger_front_door() {this.passenger_front_door.open_close_door();}
    public void open_close_window_passenger_front_door() {this.passenger_front_door.open_close_window();}
    public void lock_unlock_passenger_front_door() {this.passenger_front_door.lock_unlock_door();}
    public boolean isPassenger_window_closed() {return this.passenger_front_door.isClosed_window();}
    public boolean isPassenger_door_closed() {return this.passenger_front_door.isClosed_door();}
    public boolean isPassenger_door_locked() {return this.passenger_front_door.isLocked_door();}

    public void open_close_hood() {this.hood.open_close_door();}
    public void lock_unlock_hood() {this.hood.lock_unlock_door();}
    public boolean isHood_closed() {return this.hood.isClosed_door();}
    public boolean isHood_locked() {return this.hood.isLocked_door();}

    public void open_close_luggage() {this.luggage.open_close_door();}
    public void lock_unlock_luggage() {this.luggage.lock_unlock_door();}
    public boolean isLuggage_closed() {return this.luggage.isClosed_door();}
    public boolean isLuggage_locked() {return this.luggage.isLocked_door();}

    public void close_car() {
        if (!driver_door.isClosed_door()) this.driver_door.open_close_door();
        if (!driver_door.isLocked_door()) this.driver_door.lock_unlock_door();
        if (!driver_door.isClosed_window()) this.driver_door.open_close_window();
        if (!passenger_front_door.isClosed_door()) this.passenger_front_door.open_close_door();
        if (!passenger_front_door.isLocked_door()) this.passenger_front_door.lock_unlock_door();
        if (!passenger_front_door.isClosed_window()) this.passenger_front_door.open_close_window();
        if (!hood.isClosed_door()) this.hood.open_close_door();
        if (!hood.isLocked_door()) this.hood.lock_unlock_door();
        if (!luggage.isClosed_door()) this.luggage.open_close_door();
        if (!luggage.isLocked_door()) this.luggage.isLocked_door();
    }
    public boolean isDoor_closed() {return this.driver_door.isClosed_door()&&this.passenger_front_door.isClosed_door()&&this.hood.isClosed_door()&&this.luggage.isClosed_door();}

    public void open_car() {
        this.driver_door.lock_unlock_door();
        this.passenger_front_door.lock_unlock_door();
        this.hood.lock_unlock_door();
        this.luggage.lock_unlock_door();
    }

    //climate
    public void setDriver_clima(Climate tipology) {this.driver_climate.setTipology(tipology);}
    public Climate getDriver_clima() {return this.driver_climate.getTipology();}
    public void setDriver_velocity_clima(int velocity) {this.driver_climate.setVelocity(velocity);}
    public int getDriver_velocity_clima() {return this.driver_climate.getVelocity();}
    public void setDriver_temperature(double temperature) {this.driver_climate.setTemperature(temperature);}
    public double getDriver_temperature() {return this.driver_climate.getTemperature();}
    public boolean isDriver_clima_off() {return this.driver_climate.isClima_acceso();}

    public void setPassenger_climate(Climate tipology) {this.passenger_climate.setTipology(tipology);}
    public Climate getPassenger_climate() {return this.passenger_climate.getTipology();}
    public void setPassenger_velocity_clima(int velocity) {this.passenger_climate.setVelocity(velocity);}
    public int getPassenger_velocity_clima() {return this.passenger_climate.getVelocity();}
    public void setPassenger_temperature(double temperature) {this.passenger_climate.setTemperature(temperature);}
    public double getPassenger_temperature() {return this.passenger_climate.getTemperature();}
    public boolean isPassenger_clima_off() {return this.passenger_climate.isClima_acceso();}

    public void setPurification(Purification purificazione) {
        this.driver_climate.setPurification(purificazione);
        this.passenger_climate.setPurification(purificazione);
        this.car_climate.setPurification(purificazione);
    }
    public Purification getPurification() {return this.driver_climate.getPurification();}

    public void setCar_climate(Climate tipology) {this.car_climate.setTipology(tipology);}
    public Climate getCar_climate() {return this.car_climate.getTipology();}
    public void setCar_velocity_clima(int velocity) {this.car_climate.setVelocity(velocity);}
    public int getCar_velocity_clima() {return this.car_climate.getVelocity();}
    public void setCar_temperature(double temperature) {this.car_climate.setTemperature(temperature);}
    public double getCar_temperature() {return this.car_climate.getTemperature();}

    //security belt
    public void fastened_unfastened_driver_belt() {this.driver_security_belt.belt_fastened_unfastened();}
    public boolean isDriver_belt_fastened() {return this.driver_security_belt.isFastened();}

    public void fastened_unfastened_passenger_belt() {this.passenger_security_belt.belt_fastened_unfastened();}
    public boolean isPassenger_belt_fastened() {return this.passenger_security_belt.isFastened();}

}