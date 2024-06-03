package ramenGo.com.demo.domain.service.Interface;

import ramenGo.com.demo.web.request.OrderCreateRequest;

public interface IOrderService {
    Object createOrder(OrderCreateRequest request) throws Exception;
}
