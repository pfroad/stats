package com.airparking.azkaban;

import com.airparking.azkaban.mapper.OrderMapper;
import com.airparking.azkaban.model.Order;
import com.airparking.azkaban.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransferOrderDaily {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransferOrderDaily.class);

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                DBUtils.close();
                LOGGER.info("Done to shutdown datasource.");
            } catch (Exception e) {
                LOGGER.error("Error to run shutdown hook!", e);
            }
        }));
    }

    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = DBUtils.getSqlSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            OrderMapper orderMapper = session.getMapper(OrderMapper.class);
            Order order = orderMapper.selectByPrimaryKey(410L);
            System.out.println(order.getIdentifier());
        }
    }
}
