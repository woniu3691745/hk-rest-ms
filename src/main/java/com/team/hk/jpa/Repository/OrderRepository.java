package com.team.hk.jpa.Repository;

import com.team.hk.jpa.entity.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lidongliang on 2017/6/29.
 * Jpa Repository
 */
@Transactional
public interface OrderRepository extends JpaRepository<OrderInfo, Long> {

    List<OrderInfo> findAllByOrderId(Long id);

}
