package com.naveen.bookmyshow.restImpl;

import com.naveen.bookmyshow.constants.BookMyShowConstants;
import com.naveen.bookmyshow.rest.UserRest;
import com.naveen.bookmyshow.service.UserService;
import com.naveen.bookmyshow.utils.BookMyShowUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserRestImpl implements UserRest {
    @Autowired
    UserService userService;
    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        System.out.println("hi");
        try
        {
            return userService.signUp(requestMap);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return BookMyShowUtils.responseEntity(BookMyShowConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
