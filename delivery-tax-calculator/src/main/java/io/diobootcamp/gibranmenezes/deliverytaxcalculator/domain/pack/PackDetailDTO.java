package io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack;

public record PackDetailDTO(long id, Double height, Double width, Double lenght, Double weigth) {

    public PackDetailDTO(Pack pack) {
        this(pack.getId(), pack.getHeight(), pack.getWidth(), pack.getLenght(), pack.getWeigth());
    }

}
