package com.etupitsyn.chat.dao;

import com.etupitsyn.chat.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserDao {
    public User getUser(Long userId);
    public User save(User user);
    public List<User> getAllUsers();
    public void delete(Long userId);
    public User findUserByNick(String nick);
}
