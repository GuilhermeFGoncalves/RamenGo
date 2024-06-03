package ramenGo.com.demo.domain.service;

import org.springframework.stereotype.Service;
import ramenGo.com.demo.domain.entities.BrothEntity;
import ramenGo.com.demo.domain.entities.ProteinsEntity;
import ramenGo.com.demo.domain.service.Interface.IOrderService;
import ramenGo.com.demo.infra.repository.db.BrothRepository;
import ramenGo.com.demo.infra.repository.db.ProteinsRepository;
import ramenGo.com.demo.web.adapters.RedVenturesAdapter;
import ramenGo.com.demo.web.request.OrderCreateRequest;
import ramenGo.com.demo.web.response.OrderResponse;

@Service
public class OrderService implements IOrderService {

    private BrothRepository brothRepository;
    private ProteinsRepository proteinsRepository;

    public OrderService(BrothRepository brothRepository, ProteinsRepository proteinsRepository) {
        this.brothRepository = brothRepository;
        this.proteinsRepository = proteinsRepository;
    }

    public Object createOrder(OrderCreateRequest request) throws Exception{

        if(request.getBrothId() == null || request.getProteinId() == null){
            throw new Exception("both brothId and proteinId are required");
        }
        String orderIdResponse = RedVenturesAdapter.getOrderId();
        BrothEntity broth = this.brothRepository.getReferenceById(request.getBrothId());
        ProteinsEntity protein = this.proteinsRepository.getById(request.getProteinId());

        if(broth.getId()== null || protein.getId() == null){
            throw new Exception("could not place order");
        }

        String orderDescription = broth.getName() + " and " + protein.getName() + " Lamen";
        return new OrderResponse(orderIdResponse,orderDescription,protein.getImageInactive());
    }
}
