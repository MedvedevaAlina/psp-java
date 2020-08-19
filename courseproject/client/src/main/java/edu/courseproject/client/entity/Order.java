package edu.courseproject.client.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Order {
    private long idOrder;
    private long idSklad;
    private long idCustomer;
    private long orderDate;
    private  long deliveryDate;
    private String processing;
    private String nameCustomer;
    private String representativeCustomer;

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getRepresentativeCustomer() {
        return representativeCustomer;
    }

    public void setRepresentativeCustomer(String representativeCustomer) {
        this.representativeCustomer = representativeCustomer;
    }

    private double cost;

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Order() {
    }

    public Order(long idSklad, long idCustomer, String orderDate, String deliveryDate, String processing) {
        this.idSklad = idSklad;
        this.idCustomer = idCustomer;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date orderD = null;
        try {
            orderD = formatter.parse(orderDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.orderDate = orderD.getTime();
        Date deliveryD = null;
        try {
            deliveryD = formatter.parse(deliveryDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.deliveryDate = deliveryD.getTime();
        this.processing = processing;
    }

    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public long getIdSklad() {
        return idSklad;
    }

    public void setIdSklad(long idSklad) {
        this.idSklad = idSklad;
    }

    public long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public long getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(long orderDate) {
        this.orderDate = orderDate;
    }

    public long getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(long deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getProcessing() {
        return processing;
    }

    public void setProcessing(String processing) {
        this.processing = processing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return idOrder == order.idOrder &&
                idSklad == order.idSklad &&
                idCustomer == order.idCustomer &&
                Objects.equals(orderDate, order.orderDate) &&
                Objects.equals(deliveryDate, order.deliveryDate) &&
                Objects.equals(processing, order.processing);
    }

    @Override
    public int hashCode() {
        final int factor = 31;
        int result = 1;
        result += factor * idOrder;
        result *= factor + idSklad;
        result += factor * idCustomer;
        result += factor + ((processing == null) ? 0 : processing.hashCode());
        result += factor + ((orderDate == 0) ? 0 : orderDate);
        result += ((deliveryDate == 0) ? 0 : deliveryDate);
        return result;
    }
}
