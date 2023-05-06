package cn.biq.mn.user.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import cn.biq.mn.base.response.BaseResponse;
import cn.biq.mn.base.response.DataMessageResponse;
import cn.biq.mn.base.response.DataResponse;
import cn.biq.mn.base.utils.MessageSourceUtil;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final MessageSourceUtil messageSourceUtil;
    private final HttpServletRequest httpServletRequest;

    // 登录
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public BaseResponse handleLogin(@Valid @RequestBody LoginForm request) {
        var result = userService.login(request);
        httpServletRequest.getSession().setAttribute("accessToken", result.getAccessToken());
        return new DataMessageResponse<>(result, messageSourceUtil.getMessage("user.login.success"));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/logout")
    public BaseResponse handleLogout() {
        httpServletRequest.getSession().removeAttribute("accessToken");
        return new BaseResponse(userService.logout());
    }

    // 注册
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public BaseResponse handleRegister(@Valid @RequestBody RegisterForm request) {
        return new BaseResponse(userService.register(request));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/bind")
    public BaseResponse handleBind(@Valid @RequestBody RegisterForm request) {
        boolean result = userService.bindUsername(request);
        return new DataMessageResponse<>(result, messageSourceUtil.getMessage("user.bind.success"));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/initState")
    public BaseResponse handleInitState() {
        return new DataResponse<>(userService.getInitState());
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/setDefaultBook/{id}")
    public BaseResponse handleSetDefaultBook(@PathVariable("id") Integer id) {
        return new BaseResponse(userService.setDefaultBook(id));
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/changePassword")
    public BaseResponse handleChangePassword(@Valid @RequestBody ChangePasswordRequest request) {
        return new BaseResponse(userService.changePassword(request));
    }

}
