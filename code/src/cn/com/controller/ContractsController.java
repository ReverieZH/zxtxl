package cn.com.controller;


import cn.com.pojo.Contracts;
import cn.com.pojo.PageBean;
import cn.com.service.ContractsService;
import cn.com.service.UserService;
import cn.com.utils.Common;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class ContractsController {
    @Autowired(required = false)
    private ContractsService contractsService;

    @RequestMapping("main")
    public String getContracts(HttpServletRequest request, HttpServletResponse response,@RequestParam(defaultValue = "1") int page) throws IOException {
        try {
            ServletContext servletContext=request.getServletContext();
            int pagesize= Integer.parseInt(servletContext.getInitParameter("pagesize"));

            String username= String.valueOf(request.getSession().getAttribute("username"));
            List<Contracts> contracts=contractsService.getContractsList(username,null,null,null,null,null);
            if(contracts.size()!=0){
                PageBean<Contracts> pageBean=new PageBean<>(page,pagesize,contracts.size());
                pageBean.setList(contracts);
                request.setAttribute("pageBean",pageBean);
            }
            return "/main.jsp";
        } catch (NumberFormatException e) {
            Common.alertAndBack(response,e.getMessage());
            return null;
        }
    }

    @RequestMapping(value = "addContracts",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public void addContracts(HttpServletRequest request, HttpServletResponse response,Contracts contracts) throws IOException {
        try {
            ServletContext servletContext=request.getServletContext();
            String username= String.valueOf(request.getSession().getAttribute("username"));

            String age=request.getParameter("age");
            Integer ageInt=null;
            if(!age.isEmpty()){
                ageInt= Integer.valueOf(age);
            }
            contracts.setAge(ageInt);
            contracts.setUsername(username);
            System.out.println(contracts);
            contractsService.addContracts(contracts);
            Common.alertAndRedirect(response,"添加成功","main");
        } catch (Exception e) {
            e.printStackTrace();
            Common.alertAndBack(response,"添加失败");
        }
    }

    @RequestMapping("modfiyList")
    public String modfiyList(HttpServletRequest request, HttpServletResponse response,@RequestParam(defaultValue = "1") int page){
        try {
            ServletContext servletContext= request.getServletContext();
            int pageSize= Integer.parseInt(servletContext.getInitParameter("pagesize"));

            String username= String.valueOf(request.getSession().getAttribute("username"));
            System.out.println(username);
            List<Contracts> contractsList=contractsService.getContractsList(username,null,null,null,null,null) ;
            if(contractsList.size()!=0){
                PageBean<Contracts> pageBean=new PageBean<>(page,pageSize,contractsList.size());
                pageBean.setList(contractsList);
                request.setAttribute("pageBean",pageBean);
            }

            return "/modfiyList.jsp";
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("modfiy")
    public String modfiy(HttpServletRequest request, HttpServletResponse response,String cid,@RequestParam(defaultValue = "1") int page) throws IOException {
        try {
            Contracts contracts=contractsService.getContractsById(cid);
            request.setAttribute("contracts",contracts);

            return "/modfiyContracts.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            Common.alertAndBack(response, e.getMessage());
            return null;
        }
    }

    @RequestMapping("saveModfiy")
    public void saveModfiy(HttpServletRequest request, HttpServletResponse response,Contracts contracts,String age,@RequestParam(defaultValue = "1") int page) throws IOException {
        try {
            Integer ageInt=null;
            if(age!=null){
                ageInt= Integer.valueOf(age);
            }
            contracts.setAge(ageInt);
            contracts.setUsername(String.valueOf(request.getSession().getAttribute("username")));

            contractsService.updateContracts(contracts);
            Common.alertAndRedirect(response,"修改成功","modfiyList?page="+page);
        } catch (Exception e) {
            e.printStackTrace();
            Common.alertAndBack(response,e.getMessage());
        }
    }

    @RequestMapping("deleteList")
    public String deleteList(HttpServletRequest request, HttpServletResponse response,@RequestParam(defaultValue = "1") int page) throws IOException {
        try {
            ServletContext context=request.getServletContext();
            int pageSzie= Integer.parseInt(context.getInitParameter("pagesize"));

            String username= String.valueOf(request.getSession().getAttribute("username"));

            List<Contracts> contractsList=contractsService.getContractsList(username,null,null,null,null,null);
            if(contractsList.size()!=0){
                PageBean<Contracts> pageBean=new PageBean<>(page,pageSzie,contractsList.size());
                pageBean.setList(contractsList);
                request.setAttribute("pageBean",pageBean);
            }

            return "/deleteList.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            Common.alertAndBack(response,e.getMessage());
            return null;
        }

    }


    @RequestMapping("deleteContracts")
    public void deleteContracts(HttpServletRequest request, HttpServletResponse response,@RequestParam("cid")List<String> cidList,@RequestParam(defaultValue = "1") int page) throws IOException {
        try {
            contractsService.deleteContracts(cidList);

            Common.alertAndRedirect(response,"删除成功","deleteList?page="+page);
        } catch (Exception e) {
            e.printStackTrace();
            Common.alertAndBack(response,e.getMessage());
        }
    }

    @RequestMapping("queryContracts")
    public String queryContracts(HttpServletRequest request, HttpServletResponse response,@RequestParam(defaultValue = "1") int page,String name,String number,String phone,String workspace,String role) throws IOException {
        try {
            ServletContext context=request.getServletContext();

            int pagesize= Integer.parseInt(context.getInitParameter("pagesize"));


            String username= String.valueOf(request.getSession().getAttribute("username"));

            if(name.equals(""))
                name=null;
            if(number.equals(""))
                number=null;
            if(phone.equals(""))
                phone=null;
            if(workspace.equals(""))
                workspace=null;

            System.out.println(name+" "+number+" "+phone+" "+workspace+" "+role);
            List<Contracts> contractsList=contractsService.getContractsList(username,name,number,phone,workspace,role);
            System.out.println(contractsList);
            if(contractsList.size()!=0){
                PageBean<Contracts> pageBean=new PageBean<>(page,pagesize,contractsList.size());
                pageBean.setList(contractsList);
                request.setAttribute("pageBean",pageBean);
            }
            return "/queryList.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            Common.alertAndBack(response,e.getMessage());
            return null;
        }
    }


}
