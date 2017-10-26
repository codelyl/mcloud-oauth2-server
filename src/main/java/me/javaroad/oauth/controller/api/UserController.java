package me.javaroad.oauth.controller.api;

import static me.javaroad.oauth.controller.OAuthConstants.API_PREFIX;

import io.swagger.annotations.ApiOperation;
import java.security.Principal;
import java.util.Objects;
import me.javaroad.common.exception.UnauthorizedException;
import me.javaroad.oauth.dto.response.UserResponse;
import me.javaroad.oauth.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heyx
 */
@RestController
@RequestMapping(API_PREFIX + "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Get current user", httpMethod = "POST")
    @GetMapping("me")
    public UserResponse me(Principal principal) {
        if(Objects.isNull(principal) || StringUtils.isBlank(principal.getName())) {
            throw new UnauthorizedException("unauthorized");
        }
        return userService.getResponse(principal.getName());
    }

}
