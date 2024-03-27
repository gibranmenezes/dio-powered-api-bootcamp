package io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack;

import java.io.Serializable;

import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.Delivery;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PACKS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pack implements Serializable {

    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String code;

    private Double height;

    private Double width; 

    private Double lenght;

    private Double weigth;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    public Pack(PackRegistrationRequest data) {
        this.height = data.height();
        this.width = data.width();
        this.lenght = data.lenght();
        this.weigth = data.weigth();
    }

    public void setDelivery(Delivery delivery){
        this.delivery = delivery;
    }
    

}
