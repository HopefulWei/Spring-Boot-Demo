package com.neo.service;

import com.neo.model.User;

import java.util.List;

public interface UserService {

    public List<User> getUserList();

    public User findUserById(long id);

    public void save(User user);

    public void edit(User user);

    public void delete(long id);

    public void sendSimpleMail(String to, String subject, String content);

    public void sendAttachmentsMail(String to, String subject, String content, String filePath);

    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);

    public boolean Login(String UserName, String passWord);

    public void addUserRedis(String UserName, String passWord);

    public void deleteUserRedis(String UserName);


}
