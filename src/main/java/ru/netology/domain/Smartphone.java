package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;



import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class Smartphone extends Product {
    private String manufacturer;

   public Smartphone(){
       super();
    }

    public Smartphone(int id, String title, int price, String manufacturer) {
        super(id, title, price);
        this.manufacturer = manufacturer;
    }

//    public Smartphone(String manufacturer) {
//        this.manufacturer = manufacturer;
//    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return Objects.equals(manufacturer, that.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), manufacturer);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
