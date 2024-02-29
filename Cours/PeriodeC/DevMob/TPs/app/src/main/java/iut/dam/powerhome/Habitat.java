package iut.dam.powerhome;

import java.util.ArrayList;
import java.util.List;

public class Habitat {

    int id;
    String residentName;
    int floor;
    double area;
    List<Appliance> appliances;

    public Habitat(int id, String residentName, int floor, double area) {
        this.id = id;
        this.residentName = residentName;
        this.floor = floor;
        this.area = area;

        this.appliances = new ArrayList<>();
        this.appliances.add(new Appliance(1, "Aspirateur", "Philips X123", 600, R.drawable.ic_aspirateur));
    }

    public String getResident() {
        return residentName;
    }

    public int getNumberFloor() {
        return floor;
    }

    public List<Appliance> getAppliance() {
        return appliances;
    }

    public int getApplianceImage(int index) {
        if (appliances != null && index >= 0 && index < appliances.size()) {
            Appliance appliance = appliances.get(index);
            return appliance.getImageResourceId();
        } else {
            return -1;
        }
    }

}
