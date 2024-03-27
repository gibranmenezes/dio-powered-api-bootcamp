package io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.dtos.request.DeliveryRegistrationRequest;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.enums.DeliveryType;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.Pack;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Entity
@Table(name="DELIVERIES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Delivery implements Serializable {

    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String code;

    private String addressUF;

    private DeliveryType deliveryType;

    private BigDecimal deliveryTax;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Pack> packs = new ArrayList<>();

    public Delivery(DeliveryRegistrationRequest data) {
        this.addressUF = data.addressUF();
        this.deliveryType = data.deliveryType();
    }
    
    public void addPack(Pack pack){
        this.packs.add(pack);
    }


}
