package orderproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import orderproject.repositories.OrderDAO;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderDAO repository;

    public List<String> getProductName(String name) {
        return repository.getProductName(name);
    }
}
