package edu.courseproject.server.DAO;

import edu.courseproject.server.entity.Order;

import java.util.List;

public interface OrderDAO extends BaseDAO<Order>{
    List<String> findPostedOrders();
    List<Order> findSumCost(Long begin, Long end);
    List<Order> findByID (Long idUser);
    List<String> findProcessedOrders();
    Long findIDSklad(Long idOrder);
}
