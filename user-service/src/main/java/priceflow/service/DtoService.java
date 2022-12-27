package priceflow.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priceflow.model.User;
import priceflow.repository.UserRepository;

import java.util.Optional;

@Service
public class DtoService {

    private final UserRepository userRepository;

    @Autowired
    public DtoService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserInfoByUserId(Long user_id){
        Optional<User> user = userRepository.findByUser_id(user_id);
        return user;
    }


}
