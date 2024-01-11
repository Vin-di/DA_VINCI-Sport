import java.io.*;

public class Main{
    public static void main(String[] args){
        Car volta_DA_VINCI = new Car(75, 150);
        String msg_error="\f Write one of options!";
        String choose_options= "\nChoose one option: ";
        String[] options = {"Kilometers", "Car", "Battery", "Motor", "Doors", "Climate"};
        String[] optionsOff = {"Car", "Battery", "Motor", "Doors", "Climate"};
        String[] optionsKm = {"Show total kilometers", "Show partial kilometers", "Reset partial kilometers", "Back"};
        String[] optionsCarOn = {"Get out"};
        String[] optionsCarOff = {"Get into"};
        String[] optionsBattery = {"Charge car", "Energy saving On/Off", "Back"};
        String[] optionsBatteryOff = {"Stop charge", "Energy saving On/Off", "Back"};
        String[] optionsMotor = {"Accelerate", "Decelerate", "Change gear", "Regeneration", "Show consumption", "Set maximum velocity", "Back"};
        String[] optionsMotorOff = {"Show consumption", "Set maximum velocity", "Back"};
        String[] optionsDoors= {"Open/Close driver door", "Open/Close passenger door", "Open/Close driver window", "Open/Close passenger window", "Open/Close hood", "Open/Close luggage", "Back"};
        String[] optionsClimate= {"Set drivers climate", "Set passenger climate", "Set car climate", "Set purification", "Back"};
        String[] optionsClimateOff= {"Set clima", "Set purification", "Back"};
        String[] optionsClimate2= {"Feet", "Head", "Back"};
        String[] optionsClimateCar= {"Windshield defrosting", "Rear window defrosting", "Back"};
        String[] optionsClimate3= {"Recirculation", "New air", "Back"};

        int velocityMaximum= 250, velocityMinClima= 0, velocityMaxClima= 5, temperatureMin= 18, temperatureMax= 30;

        BufferedReader input_user = new BufferedReader(new InputStreamReader(System.in));
        int i;

        for(;;){
            while (volta_DA_VINCI.isCar_on()) {
                System.out.println("\n\nVolta DA VINCI: On\n" +
                        "Velocity: " + volta_DA_VINCI.getVelocity() + "Km/h\n" +
                        "Engine: " + volta_DA_VINCI.getGear() + "\n" +
                        "Battery: " + volta_DA_VINCI.percentage() + "%\n" +
                        "Doors closed: " + volta_DA_VINCI.isDoor_closed() + "\n");
                try {
                    for (i = 0; i < options.length; i++) System.out.println((i + 1) + ")" + options[i]);
                    System.out.print(choose_options);
                    String input = input_user.readLine().toLowerCase();
                    switch (input) {//completare eccezioni
                        case "kilometers": {
                            try {
                                System.out.println(options[0]+": ");
                                for (i = 0; i < optionsKm.length; i++) System.out.println((i + 1) + ")" + optionsKm[i]);
                                System.out.print(choose_options);
                                input = input_user.readLine().toLowerCase();
                                switch (input) {
                                    case "show total kilometers": {
                                        System.out.println("Total kilometers travelled: " + volta_DA_VINCI.getKm_tot() + "Km");
                                        break;
                                    }
                                    case "show partial kilometers": {
                                        System.out.println("Partial kilometers travelled: " + volta_DA_VINCI.getKm_part() + "Km");
                                        break;
                                    }
                                    case "reset partial kilometers": {
                                        volta_DA_VINCI.reset_Km_part();
                                        if (volta_DA_VINCI.getKm_part() == 0) System.out.println("Partial kilometers reset");
                                        else System.out.println("Error on reset");
                                        break;
                                    }
                                    case "back": {
                                        break;
                                    }
                                    default: {
                                        System.out.println(msg_error);
                                    }
                                }
                            } catch (IOException error) {
                                System.out.println(msg_error);
                            }
                        }
                        case "car": {
                            try {
                                System.out.println(options[1]+": ");
                                for (i = 0; i < optionsCarOn.length; i++) System.out.println((i + 1) + ")" + optionsCarOn[i]);
                                System.out.print(choose_options);
                                input = input_user.readLine().toLowerCase();
                                switch (input) {
                                    case "get out":{
                                        volta_DA_VINCI.parking();
                                        volta_DA_VINCI.close_car();
                                        volta_DA_VINCI.car_off();
                                        break;
                                    }
                                    default:{
                                        System.out.println(msg_error);
                                    }
                                }
                            } catch (IOException error) {
                                System.out.println("Write the proposed option!");
                            }
                            break;
                        }
                        case "battery": {
                            try {
                                System.out.println(options[2]+": ");
                                for (i = 0; i < optionsBattery.length; i++) System.out.println((i + 1) + ")" + optionsBattery[i]);
                                System.out.print(choose_options);
                                input = input_user.readLine().toLowerCase();
                                switch (input) {
                                    case "charge car": {
                                        volta_DA_VINCI.charge_car();
                                        if (volta_DA_VINCI.isIn_charge()) {System.out.println("Charged car");}
                                        break;
                                    }
                                    case "energy saving on/off": {
                                        volta_DA_VINCI.energy_saving_on_off();
                                        if (volta_DA_VINCI.isEnergy_saving()) {System.out.println("Energy saving: On");}
                                        else System.out.println("Energy saving: Off");
                                        break;
                                    }
                                    case "back": {
                                        break;
                                    }
                                    default: {
                                        System.out.println(msg_error);
                                    }
                                }
                            } catch (IOException error) {
                                System.out.println(msg_error);
                            }
                        }
                        case "motor": {
                            try {
                                System.out.println(options[3]+": ");
                                for (i = 0; i < optionsMotor.length; i++) System.out.println((i + 1) + ")" + optionsMotor[i]);
                                System.out.print(choose_options);
                                input = input_user.readLine().toLowerCase();
                                switch (input) {
                                    case "accelerate": {
                                        try {
                                            System.out.println("Accelerate \n Enter velocity: ");
                                            volta_DA_VINCI.accelerate(Integer.parseInt(input_user.readLine().toLowerCase()));
                                        } catch (IOException error) {
                                            System.out.println("Enter only numbers!!");
                                        }
                                        break;
                                    }
                                    case "decelerate": {
                                        volta_DA_VINCI.decelerate();
                                        break;
                                    }
                                    case "change gear": {
                                        if (volta_DA_VINCI.getVelocity() == 0) {
                                            char gear = 'P';
                                            try {
                                                do {
                                                    System.out.println("Gear: \n Enter new gear (R or D): (If you enter multiple inputs, the last correct input will be considered)");
                                                    char[] new_gear = input_user.readLine().toUpperCase().toCharArray();
                                                    for (i = 0; i < new_gear.length; i++)
                                                        if (new_gear[i] == 'R' || new_gear[i] == 'D')
                                                            gear = new_gear[i];
                                                    if (gear != 'P') {
                                                        if (gear == 'R') volta_DA_VINCI.change_gear(Gear.R);
                                                        else if (gear == 'D') volta_DA_VINCI.change_gear(Gear.D);
                                                        System.out.println("Gear engaged: " + volta_DA_VINCI.getGear());
                                                    } else System.out.println("Engage correct gear!!");
                                                } while (gear == 'P');
                                            } catch (IOException error) {
                                                System.out.println("Enter 'R' or 'D' only!");
                                            }
                                        } else {System.out.println("Stop the car before changing gear!!");}
                                        break;
                                    }
                                    case "regeneration": {
                                        char regeneration = 'P';
                                        do {
                                            try {
                                                do {
                                                    System.out.println("Enter regeneration (B-D-A(AUTO)): (If you enter multiple characters, only the last one will be considered)");
                                                    char[] String_regeneration = input_user.readLine().toUpperCase().toCharArray();
                                                    for (i = 0; i < String_regeneration.length; i++)
                                                        if (String_regeneration[i] == 'B' || String_regeneration[i] == 'D' || String_regeneration[i] == 'A')
                                                            regeneration = String_regeneration[i];
                                                    if (regeneration != 'P') {
                                                        switch (regeneration) {
                                                            case 'B': {volta_DA_VINCI.setRegeneration(Regeneration.B);break;}
                                                            case 'D': {volta_DA_VINCI.setRegeneration(Regeneration.D);break;}
                                                            case 'A': {volta_DA_VINCI.setRegeneration(Regeneration.AUTO);break;}
                                                        }
                                                        System.out.println("Regeneration inserted: " + volta_DA_VINCI.getRegeneration());
                                                    } else System.out.println("Enter correct regeneration!!");
                                                } while (regeneration == 'P');
                                            } catch (IOException error) {
                                                System.out.println("Enter only 'B', 'D' or 'A' !");
                                            }
                                        } while (regeneration == 'P');
                                        break;
                                    }
                                    case "show consumption": {
                                        System.out.println("consumption:" + volta_DA_VINCI.getConsumption() + "Kwh/100Km");
                                        break;
                                    }
                                    case "set maximum velocity": {
                                        try {
                                            int velocitymax;
                                            do {
                                                System.out.println("Enter maximum speed (maximum speed 250km/h):");
                                                velocitymax = Integer.parseInt(input_user.readLine());
                                                if (velocitymax <= velocityMaximum)
                                                    volta_DA_VINCI.setMax_velocity(velocitymax);
                                            } while (velocitymax > velocityMaximum);
                                        } catch (IOException error) {
                                            System.out.println("Enter maximum speed value!");
                                        }
                                        break;
                                    }
                                    case "back": {
                                        break;
                                    }
                                    default: {
                                        System.out.println(msg_error);
                                    }
                                }
                            } catch (IOException error) {
                                System.out.println(msg_error);
                            }
                            break;
                        }
                        case "doors": {
                            try {
                                System.out.println(options[4]+": ");
                                for (i = 0; i < optionsDoors.length; i++) System.out.println((i + 1) + ")" + optionsDoors[i]);
                                System.out.print(choose_options);
                                input = input_user.readLine().toLowerCase();
                                switch (input) {
                                    case "open/close driver door": {
                                        volta_DA_VINCI.open_close_drivers_door();
                                        if (volta_DA_VINCI.isDrivers_door_closed()) System.out.println("Driver's door: close");
                                        else System.out.println("Driver's door: open");
                                        break;
                                    }
                                    case "open/close driver window": {
                                        volta_DA_VINCI.open_close_window_drivers_door();
                                        if (volta_DA_VINCI.isDrivers_windows_closed()) System.out.println("Driver's window: close");
                                        else System.out.println("Driver's window: open");
                                        break;
                                    }

                                    case "open/close passenger door": {
                                        volta_DA_VINCI.open_close_passenger_front_door();
                                        if (volta_DA_VINCI.isPassenger_door_closed()) System.out.println("Passenger's door: close");
                                        else System.out.println("Passenger's door: open");
                                        break;
                                    }
                                    case "open/close passenger window": {
                                        volta_DA_VINCI.open_close_window_passenger_front_door();
                                        if (volta_DA_VINCI.isPassenger_window_closed()) System.out.println("Passenger's window: close");
                                        else System.out.println("Passenger's window: open");
                                        break;
                                    }

                                    case "open/close hood": {
                                        volta_DA_VINCI.open_close_hood();
                                        if (volta_DA_VINCI.isHood_closed()) System.out.println("Hood: close");
                                        else System.out.println("Hood: open");
                                        break;
                                    }

                                    case "open/close luggage": {
                                        volta_DA_VINCI.open_close_luggage();
                                        if (volta_DA_VINCI.isLuggage_closed()) System.out.println("Luggage: close");
                                        else System.out.println("Luggage: open");
                                        break;
                                    }

                                    case "back": {
                                        break;
                                    }
                                    default: {
                                        System.out.println(msg_error);
                                    }
                                }
                            } catch (IOException error) {
                                System.out.println(msg_error);
                            }
                        }
                        case "climate": {
                            int velocity = 0, temperature;
                            String purification, climate;
                            try {
                                System.out.println(options[5]+": ");
                                for (i = 0; i < optionsClimate.length; i++) System.out.println((i + 1) + ")" + optionsClimate[i]);
                                System.out.print(choose_options);
                                input = input_user.readLine().toLowerCase();
                                switch (input) {
                                    case "set drivers climate": {
                                        System.out.println("Velocity:" + volta_DA_VINCI.getDrivers_velocity_clima());
                                        System.out.println("Tipology:" + volta_DA_VINCI.getDrivers_clima());
                                        System.out.println("Temperature:" + volta_DA_VINCI.getDrivers_temperature() +"°C");
                                        try {//VELOCITY
                                            do {
                                                System.out.println("Enter the speed from 0 to 5: (0 to turn off)");
                                                velocity = Integer.parseInt(input_user.readLine());
                                                if (velocity >= velocityMinClima && velocity <= velocityMaxClima) {
                                                    volta_DA_VINCI.setDrivers_velocity_clima(velocity);
                                                    if (velocity == velocityMinClima) System.out.println("Climate off");
                                                }
                                            } while (!(velocity >= velocityMinClima && velocity <= velocityMaxClima));
                                        } catch (IOException error) {
                                            System.out.println("Enter values from 0 to 5!!");
                                        }

                                        if (velocity != velocityMinClima) {
                                            try {//TIPOLOGY
                                                for (i = 0; i < optionsClimate2.length; i++) System.out.println((i + 1) + ")" + optionsClimate2[i]);
                                                System.out.println("\nEnter type of ventilation:");
                                                climate = input_user.readLine().toLowerCase();
                                                switch (climate) {
                                                    case "feet": {
                                                        volta_DA_VINCI.setDrivers_clima(Climate.FEET);
                                                        break;
                                                    }
                                                    case "head": {
                                                        volta_DA_VINCI.setDrivers_clima(Climate.HEAD);
                                                        break;
                                                    }
                                                    case "back": {
                                                        break;
                                                    }
                                                    default: {
                                                        System.out.println(msg_error);
                                                    }
                                                }
                                            } catch (IOException error) {
                                                System.out.println(msg_error);
                                            }
                                            try {//TEMPERATURE
                                                do {
                                                    System.out.println("Enter the temperature between 18°C and 30°C:");
                                                    temperature = Integer.parseInt(input_user.readLine());
                                                    if (temperature >= temperatureMin && temperature <= temperatureMax) {
                                                        volta_DA_VINCI.setDrivers_temperature(temperature);
                                                        volta_DA_VINCI.setPassenger_temperature(temperature);
                                                    }
                                                } while (!(temperature >= temperatureMin && temperature <= temperatureMax));
                                            } catch (IOException error) {
                                                System.out.println("Enter the temperature value between 18°C and 30°C!!");
                                            }
                                            System.out.println("Climate set to: \n" +
                                                    "Velocity:" + volta_DA_VINCI.getDrivers_velocity_clima() + "\n" +
                                                    "Tipology:" + volta_DA_VINCI.getDrivers_clima() + "\n" +
                                                    "Temperature:" + volta_DA_VINCI.getDrivers_temperature() + "°C");
                                        }
                                        break;
                                    }

                                    case "Set passenger climate": {
                                        System.out.println("Velocity:" + volta_DA_VINCI.getPassenger_velocity_clima());
                                        System.out.println("Tipology:" + volta_DA_VINCI.getPassenger_climate());
                                        System.out.println("Temperature:" + volta_DA_VINCI.getPassenger_temperature()+"°C");
                                        try {//VELOCITY
                                            do {
                                                System.out.println("Enter the speed from 0 to 5: (0 to turn off)");
                                                velocity = Integer.parseInt(input_user.readLine());
                                                if (velocity >= velocityMinClima && velocity <= velocityMaxClima) {
                                                    volta_DA_VINCI.setPassenger_velocity_clima(velocity);
                                                    if (velocity == velocityMinClima) System.out.println("Climate off");
                                                }
                                            } while (!(velocity > velocityMinClima && velocity <= velocityMaxClima));
                                        } catch (IOException error) {
                                            System.out.println("Enter values from 0 to 5");
                                        }

                                        if (velocity != velocityMinClima) {
                                            try {//TIPOLOGY
                                                for (i = 0; i < optionsClimate2.length; i++) System.out.println((i + 1) + ")" + optionsClimate2[i]);
                                                System.out.print(choose_options);
                                                climate = input_user.readLine().toLowerCase();
                                                switch (climate) {
                                                    case "windshield defrosting": {
                                                        volta_DA_VINCI.setDrivers_clima(Climate.WINDSHIELD_DEFROSTING);
                                                        break;
                                                    }
                                                    case "rear window defrosting": {
                                                        volta_DA_VINCI.setDrivers_clima(Climate.REAR_WINDOW_DEFROST);
                                                        break;
                                                    }
                                                    case "feet": {
                                                        volta_DA_VINCI.setPassenger_climate(Climate.FEET);
                                                        break;
                                                    }
                                                    case "head": {
                                                        volta_DA_VINCI.setPassenger_climate(Climate.HEAD);
                                                        break;
                                                    }
                                                    case "back": {
                                                        break;
                                                    }
                                                    default: {
                                                        System.out.println(msg_error);
                                                    }
                                                }
                                            } catch (IOException error) {
                                                System.out.println(msg_error);
                                            }
                                            try {//TEMPERATURE
                                                do {
                                                    System.out.println("Enter the temperature between 18°C and 30°C:");
                                                    temperature = Integer.parseInt(input_user.readLine());
                                                    if (temperature >= temperatureMin && temperature <= temperatureMax) {
                                                        volta_DA_VINCI.setPassenger_temperature(temperature);
                                                    }
                                                } while (!(temperature >= temperatureMin && temperature <= temperatureMax));
                                            } catch (IOException error) {
                                                System.out.println("Enter the temperature value between 18°C and 30°C!!");
                                            }
                                            System.out.println("Climate set to: \n" +
                                                    "Velocity:" + volta_DA_VINCI.getPassenger_velocity_clima() + "\n" +
                                                    "Tipology:" + volta_DA_VINCI.getPassenger_climate() + "\n" +
                                                    "Temperature:" + volta_DA_VINCI.getPassenger_temperature() + "°C");
                                        }
                                        break;
                                    }

                                    case "set car climate":{
                                        System.out.println("Velocity:" + volta_DA_VINCI.getCar_velocity_clima());
                                        System.out.println("Tipology:" + volta_DA_VINCI.getCar_climate());
                                        System.out.println("Temperature:" + volta_DA_VINCI.getCar_temperature()+"°C");
                                        try {//VELOCITY
                                            do {
                                                System.out.println("Enter the speed from 0 to 5: (0 to turn off)");
                                                velocity = Integer.parseInt(input_user.readLine());
                                                if (velocity >= velocityMinClima && velocity <= velocityMaxClima) {
                                                    volta_DA_VINCI.setCar_velocity_clima(velocity);
                                                    if (velocity == velocityMinClima) System.out.println("Climate off");
                                                }
                                            } while (!(velocity > velocityMinClima && velocity <= velocityMaxClima));
                                        } catch (IOException error) {
                                            System.out.println("Enter values from 0 to 5");
                                        }

                                        if (velocity != velocityMinClima) {
                                            try {//TIPOLOGY
                                                for (i = 0; i < optionsClimateCar.length; i++) System.out.println((i + 1) + ")" + optionsClimateCar[i]);
                                                System.out.print(choose_options);
                                                climate = input_user.readLine().toLowerCase();
                                                switch (climate) {
                                                    case "windshield defrosting": {
                                                        volta_DA_VINCI.setCar_climate(Climate.WINDSHIELD_DEFROSTING);
                                                        break;
                                                    }
                                                    case "rear window defrosting": {
                                                        volta_DA_VINCI.setCar_climate(Climate.REAR_WINDOW_DEFROST);
                                                        break;
                                                    }
                                                    case "back": {
                                                        break;
                                                    }
                                                    default: {
                                                        System.out.println(msg_error);
                                                    }
                                                }
                                            } catch (IOException error) {
                                                System.out.println(msg_error);
                                            }
                                            try {//TEMPERATURE
                                                do {
                                                    System.out.println("Enter the temperature between 18°C and 30°C:");
                                                    temperature = Integer.parseInt(input_user.readLine());
                                                    if (temperature >= temperatureMin && temperature <= temperatureMax) {
                                                        volta_DA_VINCI.setCar_temperature(temperature);
                                                    }
                                                } while (!(temperature >= temperatureMin && temperature <= temperatureMax));
                                            } catch (IOException error) {
                                                System.out.println("Enter the temperature value between 18°C and 30°C!!");
                                            }
                                            System.out.println("Climate set to: \n" +
                                                    "Velocity:" + volta_DA_VINCI.getCar_velocity_clima() + "\n" +
                                                    "Tipology:" + volta_DA_VINCI.getCar_climate() + "\n" +
                                                    "Temperature:" + volta_DA_VINCI.getCar_temperature() + "°C");
                                        }
                                        break;
                                    }

                                    case "set purification": {
                                        System.out.println("Type of purification:" + volta_DA_VINCI.getPurification());
                                        try {
                                            for (i = 0; i < optionsClimate3.length; i++)
                                                System.out.println((i + 1) + ")" + optionsClimate3[i]);
                                            System.out.print(choose_options);
                                            purification = input_user.readLine().toLowerCase();
                                            switch (purification) {
                                                case "recirculation": {
                                                    volta_DA_VINCI.setPurification(Purification.RECIRCULATION);
                                                    break;
                                                }
                                                case "new air": {
                                                    volta_DA_VINCI.setPurification(Purification.NEW_AIR);
                                                    break;
                                                }
                                                case "back": {
                                                    break;
                                                }
                                                default: {
                                                    System.out.println(msg_error);
                                                }
                                            }
                                        } catch (IOException error) {
                                            System.out.println(msg_error);
                                        }
                                    }
                                    case "back": {
                                        break;
                                    }
                                    default: {
                                        System.out.println(msg_error);
                                    }
                                }
                            } catch (IOException error) {
                                System.out.println(msg_error);
                            }
                        }
                        default: {System.out.println(msg_error);}
                    }
                } catch (IOException error) {
                    System.out.println(msg_error);
                }
            }

            while (!volta_DA_VINCI.isCar_on()) {
                System.out.flush();
                System.out.println("\n\nVolta DA VINCI: Off\n" +
                        "Battery:" + volta_DA_VINCI.percentage()+"%\n"+
                        "Temperature: "+volta_DA_VINCI.getDrivers_temperature()+"°C");
                try {
                    for (i = 0; i < optionsOff.length; i++) System.out.println((i + 1) + ")" + optionsOff[i]);
                    System.out.print(choose_options);
                    String input = input_user.readLine().toLowerCase();
                    switch (input) {
                        case "car": {
                            try {
                                for (i = 0; i < optionsCarOff.length; i++) System.out.println((i + 1) + ")" + optionsCarOff[i]);
                                System.out.print(choose_options);
                                input = input_user.readLine().toLowerCase();
                                if ("get into".equals(input)) {volta_DA_VINCI.car_on();}
                            } catch (IOException error) {System.out.println(msg_error);}
                            break;
                        }
                        case "battery": {
                            try {
                                for (i = 0; i < optionsBatteryOff.length; i++) System.out.println((i + 1) + ")" + optionsBatteryOff[i]);
                                System.out.print(choose_options);
                                input = input_user.readLine().toLowerCase();
                                switch (input) {
                                    case "stop charge": {
                                        volta_DA_VINCI.stop_charge();
                                        System.out.println("Car charging finished\n Battery percentage:"+volta_DA_VINCI.percentage()+"%");
                                        break;}
                                    case "energy saving on/off": {
                                        volta_DA_VINCI.energy_saving_on_off();
                                        if (volta_DA_VINCI.isEnergy_saving()) {System.out.println("Energy saving: On");}
                                        else System.out.println("Energy saving: Off");
                                        break;}
                                    case "back" :{break;}
                                    default:{System.out.println(msg_error);}
                                }
                            } catch (IOException error) {System.out.println(msg_error);}
                            break;
                        }
                        case "motor": {
                            try {
                                for (i = 0; i < optionsMotorOff.length; i++) System.out.println((i + 1) + ")" + optionsMotorOff[i]);
                                System.out.print(choose_options);
                                input = input_user.readLine().toLowerCase();
                                switch (input) {
                                    case "show consumption": {System.out.println("consumption: "+volta_DA_VINCI.getConsumption()+"Kwh/100Km");break;}
                                    case "set maximum velocity":{
                                        try {
                                            int velocitymax;
                                            do {
                                                System.out.println("Enter maximum speed (maximum speed 250km/h):");
                                                velocitymax = Integer.parseInt(input_user.readLine());
                                                if (velocitymax <= velocityMaximum)
                                                    volta_DA_VINCI.setMax_velocity(velocitymax);
                                            } while (velocitymax > velocityMaximum);
                                        } catch (IOException error) {
                                            System.out.println("Enter maximum speed value!");
                                        }
                                        break;
                                    }
                                    case "back" :{break;}
                                    default:{System.out.println(msg_error);}
                                }
                            }catch (IOException error) {System.out.println(msg_error);}
                            break;
                        }
                        case "doors": {
                            try {
                                for (i = 0; i < optionsClimate.length; i++) System.out.println((i + 1) + ")" + optionsClimate[i]);
                                System.out.print(choose_options);
                                input = input_user.readLine().toLowerCase();
                                switch (input) {
                                    case "open/close driver door": {
                                        volta_DA_VINCI.open_close_drivers_door();
                                        if (volta_DA_VINCI.isDrivers_door_closed()) System.out.println("Driver's door: close");
                                        else System.out.println("Driver's door: open");
                                        break;
                                    }
                                    case "open/close driver window": {
                                        volta_DA_VINCI.open_close_window_drivers_door();
                                        if (volta_DA_VINCI.isDrivers_windows_closed()) System.out.println("Driver's window: close");
                                        else System.out.println("Driver's window: open");
                                        break;
                                    }

                                    case "open/close passenger door": {
                                        volta_DA_VINCI.open_close_passenger_front_door();
                                        if (volta_DA_VINCI.isPassenger_door_closed()) System.out.println("Passenger's door: close");
                                        else System.out.println("Passenger's door: open");
                                        break;
                                    }
                                    case "open/close passenger window": {
                                        volta_DA_VINCI.open_close_window_passenger_front_door();
                                        if (volta_DA_VINCI.isPassenger_window_closed()) System.out.println("Passenger's window: close");
                                        else System.out.println("Passenger's window: open");
                                        break;
                                    }

                                    case "open/close hood": {
                                        volta_DA_VINCI.open_close_hood();
                                        if (volta_DA_VINCI.isHood_closed()) System.out.println("Hood: close");
                                        else System.out.println("Hood: open");
                                        break;
                                    }

                                    case "open/close luggage": {
                                        volta_DA_VINCI.open_close_luggage();
                                        if (volta_DA_VINCI.isLuggage_closed()) System.out.println("Luggage: close");
                                        else System.out.println("Luggage: open");
                                        break;
                                    }

                                    case "back": {
                                        break;
                                    }
                                    default:{System.out.println(msg_error);}
                                }
                            } catch (IOException error) {System.out.println(msg_error);}
                            break;
                        }
                        case "climate": {
                            int velocity=0,temperature;
                            String purification, climate;
                            try {
                                for (i = 0; i < optionsClimateOff.length; i++) System.out.println((i + 1) + ")" + optionsClimateOff[i]);
                                System.out.print(choose_options);
                                input = input_user.readLine().toLowerCase();
                                switch (input) {
                                    case "set clima": {
                                        System.out.println("Velocity:" + volta_DA_VINCI.getCar_velocity_clima());
                                        System.out.println("Tipology:" + volta_DA_VINCI.getCar_climate());
                                        System.out.println("Temperature:" + volta_DA_VINCI.getCar_temperature()+"°C");
                                        try {//VELOCITY
                                            do {
                                                System.out.println("Enter the speed from 0 to 5: (0 to turn off)");
                                                velocity = Integer.parseInt(input_user.readLine());
                                                if (velocity >= velocityMinClima && velocity <= velocityMaxClima) {
                                                    volta_DA_VINCI.setCar_velocity_clima(velocity);
                                                    if (velocity == velocityMinClima) System.out.println("Climate off");
                                                }
                                            } while (!(velocity > velocityMinClima && velocity <= velocityMaxClima));
                                        } catch (IOException error) {
                                            System.out.println("Enter values from 0 to 5");
                                        }

                                        if (velocity != velocityMinClima) {
                                            try {//TIPOLOGY
                                                for (i = 0; i < optionsClimateCar.length; i++) System.out.println((i + 1) + ")" + optionsClimateCar[i]);
                                                System.out.print(choose_options);
                                                climate = input_user.readLine().toLowerCase();
                                                switch (climate) {
                                                    case "windshield defrosting": {
                                                        volta_DA_VINCI.setCar_climate(Climate.WINDSHIELD_DEFROSTING);
                                                        break;
                                                    }
                                                    case "rear window defrosting": {
                                                        volta_DA_VINCI.setCar_climate(Climate.REAR_WINDOW_DEFROST);
                                                        break;
                                                    }
                                                    case "back": {
                                                        break;
                                                    }
                                                    default: {
                                                        System.out.println(msg_error);
                                                    }
                                                }
                                            } catch (IOException error) {
                                                System.out.println(msg_error);
                                            }
                                            try {//TEMPERATURE
                                                do {
                                                    System.out.println("Enter the temperature between 18°C and 30°C:");
                                                    temperature = Integer.parseInt(input_user.readLine());
                                                    if (temperature >= temperatureMin && temperature <= temperatureMax) {
                                                        volta_DA_VINCI.setCar_temperature(temperature);
                                                    }
                                                } while (!(temperature >= temperatureMin && temperature <= temperatureMax));
                                            } catch (IOException error) {
                                                System.out.println("Enter the temperature value between 18°C and 30°C!!");
                                            }
                                            System.out.println("Climate set to: \n" +
                                                    "Velocity:" + volta_DA_VINCI.getCar_velocity_clima() + "\n" +
                                                    "Tipology:" + volta_DA_VINCI.getCar_climate() + "\n" +
                                                    "Temperature:" + volta_DA_VINCI.getCar_temperature() + "°C");
                                        }
                                        break;
                                    }

                                    case "set purification": {
                                        System.out.println("Type of purification:"+volta_DA_VINCI.getPurification());
                                        try {
                                            for (i = 0; i < optionsClimate3.length; i++) System.out.println((i + 1) + ")" + optionsClimate3[i]);
                                            System.out.print(choose_options);
                                            purification=input_user.readLine().toLowerCase();
                                            switch (purification) {
                                                case "recirculation":{volta_DA_VINCI.setPurification(Purification.RECIRCULATION);break;}
                                                case "new air":{volta_DA_VINCI.setPurification(Purification.NEW_AIR);break;}
                                                case "back" :{break;}
                                                default:{System.out.println(msg_error);}
                                            }
                                        }catch (IOException error){System.out.println(msg_error);}
                                        break;
                                    }
                                    case "back" :{break;}
                                    default:{System.out.println(msg_error);}
                                }
                            }catch (IOException error) {System.out.println(msg_error);}
                            break;
                        }
                        default:{System.out.println(msg_error);}
                    }
                } catch (IOException error) {System.out.println(msg_error);}
            }
        }
    }
}
