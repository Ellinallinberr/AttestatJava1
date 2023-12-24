package HWsetkomp;

import java.util.Objects;

public class Laptop {
    private String brand;
    private int ramSizeGB;
    private int storageSizeGB;
    private String operatingSystem;
    private String color;

    public Laptop(String brand, int ramSizeGB, int storageSizeGB, String operatingSystem, String color) {
        this.brand = brand;
        this.ramSizeGB = ramSizeGB;
        this.storageSizeGB = storageSizeGB;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public int getRamSizeGB() {
        return ramSizeGB;
    }

    public int getStorageSizeGB() {
        return storageSizeGB;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Laptop {" +
                "brand='" + brand + '\'' +
                ", ramSizeGB=" + ramSizeGB +
                ", storageSizeGB=" + storageSizeGB +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return ramSizeGB == laptop.ramSizeGB && storageSizeGB == laptop.storageSizeGB && brand.equals(laptop.brand) && operatingSystem.equals(laptop.operatingSystem) && color.equals(laptop.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, ramSizeGB, storageSizeGB, operatingSystem, color);
    }
}