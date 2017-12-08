package com.glory.shenghuo.service.apiservice;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.glory.shenghuo.api.user.param.*;
import com.glory.shenghuo.api.user.pojo.UserPoJo;
import com.glory.shenghuo.common.MyResponseUtil;
import com.glory.shenghuo.mapper.UserMapper;
import com.glory.shenghuo.util.ConstantUtils;
import com.glory.shenghuo.util.LogUtils;
import com.glory.shenghuo.util.PageInfos;
import com.glory.shenghuo.util.UtilTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Service
public class APIUserService {

    @Autowired
    HttpSession session;

    @Autowired
    private UserMapper userMapper;

    /**
     * 注册用户
     * @param registerParam
     * @return
     */
    public ResponseEntity<Object> registerUser(UserRegisterParam registerParam){

        ResponseEntity<Object> responseEntity = null;

        if(!StringUtil.isEmpty(registerParam.getPhone())&&
                !StringUtil.isEmpty(registerParam.getPwd())&&
                !StringUtil.isEmpty(registerParam.getCheckCode())){

            UserPoJo existUser = userMapper.findUserByPhone(registerParam.getPhone());
            if(existUser!=null){
                return MyResponseUtil.error("该用户已被注册");
            }

            UserPoJo userPoJo = new UserPoJo();
            userPoJo.setPhone(registerParam.getPhone());
            userPoJo.setPwd(registerParam.getPwd());
            userPoJo.setUserType(1);
            userPoJo.setCreateTime(new Date());

            if(userMapper.add(userPoJo)>0){
                responseEntity = MyResponseUtil.ok("注册成功");
            }else{
                responseEntity = MyResponseUtil.error("注册失败");
            }

        }else {
            responseEntity = MyResponseUtil.error("参数为空");
        }
        return responseEntity;
    }

    /**
     * 用户登陆
     * @param loginParam
     * @return
     */
    public ResponseEntity<Object> login(UserLoginParam loginParam){

        UserPoJo userPoJo = userMapper.findUserByPhone(loginParam.getPhone());
        if(userPoJo==null){
            return MyResponseUtil.error("用户不存在");
        }

        if(!userPoJo.getPwd().equals(loginParam.getPwd())){
            return MyResponseUtil.error("密码错误");
        }

        return MyResponseUtil.ok(userPoJo);
    }

    /**
     * 修改用户电话号码
     * @param param
     * @return
     */
    public ResponseEntity<Object> updateUserPhone(UpdatePhoneParam param){

        UserPoJo  userPoJo = userMapper.findUserByUserId(param.getUserId());
        if(userPoJo==null){
            return MyResponseUtil.error("用户不存在");
        }

        if(!userPoJo.getPwd().equals(param.getPwd())){
            return MyResponseUtil.error("密码不正确");
        }

        String checkCode = (String) session.getAttribute(ConstantUtils.getCheckCodeName(param.getPhone()));
        LogUtils.info("checkCode="+checkCode);

        if(!param.getCheckCode().equals(checkCode)){
            return MyResponseUtil.error("验证码错误");
        }

        userPoJo.setPhone(param.getPhone());

        if(userMapper.updateUser(userPoJo)>0){
            return MyResponseUtil.ok("修改成功");
        }else{
            return MyResponseUtil.error("修改失败");
        }
    }

    /**
     * 修改用户姓名
     * @param param
     * @return
     */
    public ResponseEntity<Object> updateUserName(UpdateNameParam param){
        UserPoJo  userPoJo = userMapper.findUserByUserId(param.getUserId());
        if(userPoJo==null){
            return MyResponseUtil.error("用户不存在");
        }

        userPoJo.setUserName(param.getUserName());

        if(userMapper.updateUser(userPoJo)>0){
            return MyResponseUtil.ok("修改成功");
        }else{
            return MyResponseUtil.error("修改失败");
        }
    }

    /**
     * 修改密码
     * @param param
     * @return
     */
    public ResponseEntity<Object> updateUserPwd(UpdatePwdParam param){
        UserPoJo  userPoJo = userMapper.findUserByUserId(param.getUserId());
        if(userPoJo==null){
            return MyResponseUtil.error("用户不存在");
        }

        if(!userPoJo.getPwd().equals(param.getOldPwd())){
            return MyResponseUtil.error("密码不正确");
        }

        userPoJo.setPwd(param.getNewPwd());

        if(userMapper.updateUser(userPoJo)>0){
            return MyResponseUtil.ok("修改成功");
        }else{
            return MyResponseUtil.error("修改失败");
        }
    }


    /**
     * 修改用户头像
     * @param param
     * @return
     */
    public ResponseEntity<Object> updateUserHeadImg(UpdateImgParam param){
        UserPoJo  userPoJo = userMapper.findUserByUserId(param.getUserId());
        if(userPoJo==null){
            return MyResponseUtil.error("用户不存在");
        }
        userPoJo.setHeadImg(param.getImgUrl());

        if(userMapper.updateUser(userPoJo)>0){
            return MyResponseUtil.ok("修改成功");
        }else{
            return MyResponseUtil.error("修改失败");
        }
    }

    /**
     * web获取用户列表
     * @param userParam
     * @return
     */
    public PageInfos getUserList(UserParam userParam){
        PageHelper.startPage(userParam.getPageNum(), userParam.getPageSize(), true);
        Page<UserPoJo> userPojos = userMapper.getAllList(userParam);
        PageInfo<UserPoJo> data = new PageInfo<>(userPojos);
        return UtilTools.pageChange(data,userPojos);
    }

    /**
     * 根据用户id号查询出用户信息
     */
    public UserPoJo getUserInfoById(Integer id){
        return userMapper.getUserInfoById(id);
    }
}
