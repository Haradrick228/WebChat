package ru.serov.springchat.WebChat.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.serov.springchat.WebChat.models.User;
import ru.serov.springchat.WebChat.repositories.UserRepository;

public class UserValidator implements Validator {

    private final UserRepository userRepository;

    @Autowired
    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        //проверка на существование пользователя. Для этого нужно сделать метод который его вызывает в sql
    }
}
