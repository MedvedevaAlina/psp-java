package edu.courseproject.server.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class Order {
    private long idOrder;
    private long idSklad;

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getRepresentCustomer() {
        return representCustomer;
    }

    public void setRepresentCustomer(String representCustomer) {
        this.representCustomer = representCustomer;
    }

    private long idCustomer;
    private long orderDate;
    private long deliveryDate;
    private String processing;
    private String nameCustomer;
    private String representCustomer;
    private double cost;

    public Order() {
    }

    public Order(long idSklad, long idCustomer, long orderDate, long deliveryDate, String processing) {
        this.idSklad = idSklad;
        this.idCustomer = idCustomer;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.processing = processing;
    }
     public Order(ResultSet resultSet){
         try {
             this.idOrder = resultSet.getLong("idorder");
            this.idSklad = resultSet.getLong("sklad_idsklad");
            this.idCustomer = resultSet.getLong("customer_idcustomer");
            this.orderDate = resultSet.getLong("orderDate");
            this.deliveryDate = resultSet.getLong("deliveryDate");
            this.processing = resultSet.getString("processing");
            this.cost = resultSet.getDouble("cost");
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
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
        result += factor*idOrder;
        result *= factor+idSklad;
        result+= factor*idCustomer;
        result+=factor+((processing==null)? 0: processing.hashCode());
        result += factor+((orderDate==0)? 0: orderDate);
        result+= ((deliveryDate==0)?0: deliveryDate);
        return result;
    }
}
