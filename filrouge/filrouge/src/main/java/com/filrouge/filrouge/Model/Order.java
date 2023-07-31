package com.filrouge.filrouge.Model;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
    
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;

     @Column(name="type_presta")
     private String typePresta;
     @Column(name="designation")
     private String designation;
     
     @ManyToOne 
     @JoinColumn(name="client_id")
     private Client client;
     
     @Column(name="nb_days")
     private Integer nbDays;
     @Column(name="unit_price")
     private Integer unnitPrice;
     
     @Column(name="state")
     @Enumerated(EnumType.ORDINAL)
     private StatusOrder state;

  
     
    public Order() {
    }

   @Override
public String toString() {
    return "Order [id=" + id + ", typePresta=" + typePresta + ", designation=" + designation + ", client=" + client
            + ", nbDays=" + nbDays + ", unnitPrice=" + unnitPrice + ", state=" + state + "]";
}

 public Order(Integer id, String typePresta, String designation, Client client, Integer nbDays, Integer unnitPrice,
            StatusOrder state) {
        this.id = id;
        this.typePresta = typePresta;
        this.designation = designation;
        this.client = client;
        this.nbDays = nbDays;
        this.unnitPrice = unnitPrice;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypePresta() {
        return typePresta;
    }

    public void setTypePresta(String typePresta) {
        this.typePresta = typePresta;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getNbDays() {
        return nbDays;
    }

    public void setNbDays(Integer nbDays) {
        this.nbDays = nbDays;
    }

    public Integer getUnnitPrice() {
        return unnitPrice;
    }

    public void setUnnitPrice(Integer unnitPrice) {
        this.unnitPrice = unnitPrice;
    }

    public String getState() {
        return state.getValue();
    }

    public void setState(StatusOrder state) {
        this.state = state;
    }



   

  
     
    

}
