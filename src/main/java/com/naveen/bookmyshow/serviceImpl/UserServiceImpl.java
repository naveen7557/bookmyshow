package com.naveen.bookmyshow.serviceImpl;

import com.naveen.bookmyshow.DAO.UserDao;
import com.naveen.bookmyshow.constants.BookMyShowConstants;
import com.naveen.bookmyshow.pojo.User;
import com.naveen.bookmyshow.service.UserService;
import com.naveen.bookmyshow.utils.BookMyShowUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        try{
        if(validateSignUp(requestMap)) {

                User user = userDao.findByEmailId(requestMap.get("email"));
                if (Objects.isNull(user)) {
                    userDao.save(getUserFromMap(requestMap));
                    return BookMyShowUtils.responseEntity("Successfully Registered", HttpStatus.OK);
                } else {
                    return BookMyShowUtils.responseEntity("Entered email is already exists", HttpStatus.BAD_REQUEST);
                }
            }
        else
            {
                return BookMyShowUtils.responseEntity(BookMyShowConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
      return BookMyShowUtils.responseEntity(BookMyShowConstants.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private boolean validateSignUp(Map<String,String> requestMap)
    {
        if(requestMap.containsKey("name") && requestMap.containsKey("contactNumber")
           && requestMap.containsKey("email") && requestMap.containsKey("password"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private User getUserFromMap(Map<String,String> requestMap)
    {
        var user = new User();
        user.setName(requestMap.get("name"));
        user.setContactNumber(requestMap.get("contactNumber"));
        user.setEmail(requestMap.get("email"));
        user.setPassword(requestMap.get("password"));
        user.setRole("user")
        ;

        return  user;
    }
}
