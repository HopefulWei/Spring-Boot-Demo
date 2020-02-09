package com.neo.web;

import com.neo.model.Email;
import com.neo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class EmailController {

    @Resource
    com.neo.RabiitMQ.topicSender topicSender;
    @Resource
    UserService UserService;

    private static String UPLOADED_FOLDER = "/Users/hopefulguowei/IdeaProjects/demoForEmailAndUserAdd/src/main/resources/static/file/";
    //路径要填写电脑中存在的绝对路径；

    @RequestMapping("/toEmail")
    public String toEmail(Model model,Long id) {
        return "user/email";
    }

    @RequestMapping("/email")
    public String email(Email emial, @RequestParam("file") MultipartFile file) {
        if(file.isEmpty()){
            topicSender.send1(emial);
        }else{
            try {

                // Get the file and save it somewhere
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);
                emial.setEmailPath(path.toString());
                topicSender.send2(emial);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "user/welcome";
    }
}