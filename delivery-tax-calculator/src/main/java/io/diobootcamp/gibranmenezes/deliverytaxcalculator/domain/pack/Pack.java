package io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PACKS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pack implements Serializable {

    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Double height;

    private Double width; 

    private Double lenght;

    private Double weigth;

    public Pack(PackRegistrationDTO data) {
        this.height = data.height();
        this.width = data.width();
        this.lenght = data.lenght();
        this.weigth = data.weigth();
    }

}
