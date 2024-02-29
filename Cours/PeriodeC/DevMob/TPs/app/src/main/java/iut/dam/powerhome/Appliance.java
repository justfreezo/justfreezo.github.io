package iut.dam.powerhome;

public class Appliance {
    int id;
    String name;
    String reference;
    int wattage;

    int resourceId;

    public Appliance(int id, String name, String reference, int wattage, int resource) {
        this.id = id;
        this.name = name;
        this.reference = reference;
        this.wattage = wattage;
        this.resourceId = resource;
    }

    public int getImageResourceId() {
        return resourceId;
    }
}
