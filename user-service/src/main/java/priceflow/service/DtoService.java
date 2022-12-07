package priceflow.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priceflow.repository.UserRepository;

@Service
public class DtoService {

    private final UserRepository userRepository;

    @Autowired
    public DtoService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
