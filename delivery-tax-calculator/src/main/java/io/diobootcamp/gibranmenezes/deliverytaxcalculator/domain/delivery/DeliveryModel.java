package io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.enums.DeliveryType;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.Pack;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class DeliveryModel implements Serializable {

    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String code;

    private String senderUF;

    private String recieverUF;

    private DeliveryType typeSent;

    private BigDecimal deliveryTax;

    @OneToMany
    @JoinColumn(name="pack_id")
    private List<Pack> packs;


}
