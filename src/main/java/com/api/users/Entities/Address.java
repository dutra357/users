package com.api.users.Entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "cep", unique = false, length = 50, nullable = false)
    private String cep;

    @Column(name = "city", unique = false, length = 50, nullable = false)
    private String city;

    @Column(name = "road", unique = false, length = 250, nullable = false)
    private String road;

    @Column(name = "number", unique = false, nullable = false)
    private Long number;

    @Column(name = "complement", unique = false, length = 250, nullable = false)
    private String complement;

    @Column(name = "state", unique = false, length = 50, nullable = false)
    private String state;

    public Address() {
    }
    public Address(String cep, String city, String road, Long number, String complement, String state) {
        this.cep = cep;
        this.city = city;
        this.road = road;
        this.number = number;
        this.complement = complement;
        this.state = state;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address adress = (Address) o;
        return Objects.equals(getId(), adress.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Adress{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", city='" + city + '\'' +
                ", road='" + road + '\'' +
                ", complement='" + complement + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
