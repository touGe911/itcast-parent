package cn.itcast.usermanage.controller;

import cn.itcast.usermanage.mapper.NewUserMapper;
import cn.itcast.usermanage.pojo.EasyUIResult;
import cn.itcast.usermanage.pojo.User;
import cn.itcast.usermanage.mapper.UserMapper;
import cn.itcast.usermanage.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: touGe
 * @Date: 2018-01-14
 * @Time: 16:52
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private NewUserMapper newUserMapper;

    @Override
    public String toString() {
        return super.toString();
    }

   /* @RequestMapping("users")
    public String toUser(){

        return "users";
    }*/

    @RequestMapping("list")
    @ResponseBody
    public EasyUIResult queryUserByPage(@RequestParam("page")Integer page,@RequestParam("rows") Integer rows){

       /* // 在查询方法调用之前，调用分页插件的静态方法，中间最好不要隔任何代码
        PageHelper.startPage(page,rows);

        List<User> users = this.userMapper.queryUserAll();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        EasyUIResult easyUIResult = new EasyUIResult();
        easyUIResult.setTotal(pageInfo.getTotal());
        easyUIResult.setRows(users);*/

        EasyUIResult easyUIResult = userService.queryEasyUIResult(page, rows);

        return easyUIResult;
    }

    /**
     * 新增页面的显示
     * @return
     */
    /*@RequestMapping("page/add")
    public String toUserAdd(){
        return "user-add";
    }*/

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * 请求路径：/save
     * 方法返回值：{status：200}
     * 参数：User对象
     */
    @RequestMapping("save")
    @ResponseBody
    public Map<String, Object> addUser(User user){
        Map<String, Object> map = new HashMap<>();
        try {
            // 调用userService的新增方法
            Boolean b = this.userService.addUser(user);
            if (b) {
                map.put("status", "200");
            } else {
                map.put("status", "500");
            }
        } catch (Exception e) {
            map.put("status", "500");
            e.printStackTrace();
        }
        return map;
    }


    /**
     * 通用页面的加载
     * @param pageName
     * @return
     */
    @RequestMapping(value="/page/{pageName}")
    public String toUserAdd(@PathVariable("pageName") String pageName){

        return pageName;
    }

    /**
     * 请求路径：/delete
     * 方法返回值：{status：200}
     * 参数：以逗号分割的ids
     */
    @RequestMapping("delete")
    @ResponseBody
    public Map<String, Object> deleteByIds(@RequestParam("ids") String[] ids){
        Map<String, Object> map = new HashMap<>(16);
        try {
//            Boolean b = this.userService.deleteByIds(ids);
            boolean b = true;
            if (b) {
                map.put("status", "200");
            } else {
                map.put("status", "500");
            }
        } catch (Exception e) {
            map.put("status", "500");
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping(value="export/excel")
    public String exportExcel(@RequestParam("page")Integer pageNum, @RequestParam("rows")Integer pageSize, Model model){
        EasyUIResult easyUIResult = this.userService.queryEasyUIResult(pageNum, pageSize);
        model.addAttribute("userList", easyUIResult.getRows());
        return "userExcelView";
    }

    /**
     * 页面的显示
     * @return
     */
   /* @RequestMapping("page/edit")
    public String toUserEdit(@RequestParam("_")Long id,Model model){

        User user = new User();
        user.setId(id);
        User user1 = this.newUserMapper.selectOne(user);
        model.addAttribute("user",user1);

        return "user-edit";
    }*/

}
