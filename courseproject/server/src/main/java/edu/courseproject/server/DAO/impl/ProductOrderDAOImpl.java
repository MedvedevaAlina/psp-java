package edu.courseproject.server.DAO.impl;

import edu.courseproject.server.DAO.ProductOrderDAO;
import edu.courseproject.server.datasource.DataSource;
import edu.courseproject.server.entity.Product;

import java.sql.*;
import java.util.*;

public class ProductOrderDAOImpl implements ProductOrderDAO {
    private DataSource datasource = DataSource.getInstance();
    private final static String FIND_FULL_INFO_SUPPLIERS= "select logist.product.name,   logist.product.price , logist.order_product.amount " +
            "from logist.order_product " +
            "join logist.order on logist.order_product.order_idorder = logist.order.idorder " +
            "join logist.product on logist.product.idproduct = logist.order_product.product_idproduct " +
            "where logist.order_product.order_idorder=?";

    private final static String FIND_PRODUCTS_IN_ORDER="select logist.order_product.product_idproduct as idproduct, logist.order_product.amount as amount " +
            "from logist.order_product " +
            "join logist.order on logist.order_product.order_idorder = logist.order.idorder " +
            "where logist.order_product.order_idorder=? " +
            "order by logist.order_product.product_idproduct asc;";

    private final static String FIND_POPULAR = "select  logist.product.name , (-1)*sum(logist.sklad_product.quantity) as summary " +
            "from logist.sklad_product " +
            "join logist.product on logist.sklad_product.product_idproduct = logist.product.idproduct " +
            "where  logist.sklad_product.quantity <0 " +
            "group by logist.product.name ";


    @Override
    public List findAll() {
        return null;
    }

    @Override
    public boolean delete(Object o) {
        return false;
    }

    @Override
    public long create(Object o) throws SQLException {
        return 0;
    }

    @Override
    public Object update(Object o) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean create(Long idOrder, Map<Long, Integer> map) throws SQLException {
        Connection connection = datasource.getConnection();
        Statement statement = connection.createStatement();
        Set<Map.Entry<Long,Integer>> demoEntrySet = map.entrySet();
        ArrayList<Map.Entry<Long,Integer>> demoList = new ArrayList<>(demoEntrySet);
        for (Map.Entry<Long,Integer> entry: demoList ) {
            String query = "insert into order_product values(default , ' "+idOrder+"','"+entry.getKey()+" ',' "+entry.getValue()+" ')";
            statement.addBatch(query);
        }
        statement.executeBatch();
        return true;
    }

    @Override
    public Map<Long, Integer> findProductsInOrder(Long idOrder) {
        Map<Long, Integer> map = new HashMap<>();
        try {
            PreparedStatement preparedStatement = datasource.getConnection().prepareStatement(FIND_PRODUCTS_IN_ORDER);
            preparedStatement.setLong(1, idOrder);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                map.put(resultSet.getLong("idproduct"), resultSet.getInt("amount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public List<String> findFullInfo(Long idOrder) {
        List<String> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = datasource.getConnection().prepareStatement(FIND_FULL_INFO_SUPPLIERS);
            preparedStatement.setLong(1, idOrder);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                list.add(resultSet.getString("name")+"="+resultSet.getDouble("price")+"="+resultSet.getInt("amount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> findPopularProduct() {
        List<Product> products = new ArrayList<>();
        try {
            Statement statement = datasource.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_POPULAR);
            while (resultSet.next()){
                Product product  = new Product();
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getInt("summary"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
