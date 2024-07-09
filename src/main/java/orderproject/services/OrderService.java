package orderproject.services;

import org.springframework.stereotype.Service;
import orderproject.repositories.OrderDAO;

import java.util.List;

@Service
public class OrderService {


    private OrderDAO repository;

    public OrderService(OrderDAO repository) {
        this.repository = repository;
    }

    public List<String> getProductName(String name) {
        return repository.getProductName(name);
    }
}
