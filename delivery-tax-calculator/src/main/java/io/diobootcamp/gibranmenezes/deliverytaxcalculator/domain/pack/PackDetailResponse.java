package io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack;

public record PackDetailResponse(long id, long deliveryId, Double height, Double width, Double lenght, Double weigth) {

    public PackDetailResponse(Pack pack) {
        this(pack.getId(), pack.getDelivery().getId(), pack.getHeight(), pack.getWidth(), pack.getLenght(), pack.getWeigth());
    }

}
