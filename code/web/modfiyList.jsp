<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cn.com.pojo.Contracts" %>
<%@ page import="cn.com.utils.Common" %>
<%@ page import="cn.com.pojo.PageBean" %><%--
  Created by IntelliJ IDEA.
  User: rzh
  Date: 2020/1/15
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>在线通讯录</title>
    <link rel="stylesheet" href="./css/MainCss.css" />
    <script type="text/javascript" src="./js/Main.js"></script>
    <script type="text/javascript">
        function selPage_onchange(){
            var selPage=document.getElementById("selPage");
            var pageNum=selPage.options[selPage.selectedIndex].value;
            location.href="modfiyList?page="+pageNum;
        }

        function modfiy(cid,pageNum) {
            location.href="modfiy?cid="+cid+"&page="+pageNum;
        }
    </script>
    <style>
        .modify{
            border-radius: 15px;
            color: #fff;
            font-size: 10px;
            width: 100px;
            height: 20px;
            background: #666666;
            border: none;
            outline:none;
        }
    </style>
</head>
<body>
<div class="all">
    <%@include file="top.jsp"%>
    <div  class="main">
        <div class="left">
            <%@include file="menu.jsp"%>
        </div>
        <div class="right">
            <div style="text-align: center;">
                <h2 >联系人修改列表</h2>
                <table class="table_context">
                    <tr>
                        <td width="10%" height="25" align="center">修改</td>
                        <td width="10%" height="25" align="center">姓名</td>
                        <td width="8%" height="25" align="center">性别</td>
                        <td width="16%" height="25" align="center">固定电话</td>
                        <td width="16%" height="25" align="center">手机</td>
                        <td width="36%" height="25" align="center">工作单位</td>
                        <td width="4%" height="25" align="center">类别</td>
                    </tr>
                    <c:set var="i" value="${pageBean.startIndex}" scope="request"></c:set>
                    <%
                        Integer i= Integer.valueOf(String.valueOf(request.getAttribute("i")));
                        PageBean<Contracts> pageBean= (PageBean) request.getAttribute("pageBean");
                    %>
                    <c:forEach begin="0" end="${pageBean.pageSize}" items="${pageBean.list}" var="contracts">
                        <c:if test="${i<pageBean.totalRecord}">
                            <tr>
                                <td width="6%" height="25" align="center">
                                    <button style="width: 30px" class="modify" onclick="modfiy('<%=pageBean.getList().get(i).getCid()%>','<%=pageBean.getPageNum()%>')" >...</button>
                                        <%--                            <a href="modfiy.do?cid=<%=pageBean.getList().get(i).getCid()%>&page=<%=pageNum%>" target="_self"><img src="img/button1.jpg" border="0" width="23" height="23"/></a>--%>
                                </td>
                                <td width="10%" height="25" align="center"><%=pageBean.getList().get(i).getName() %></td>
                                <td width="8%" height="25" align="center"><%=pageBean.getList().get(i).getSex() %></td>
                                <td width="16%" height="25" align="center"><%=displayNumber(pageBean.getList().get(i).getNumber()) %></td>
                                <td width="16%" height="25" align="center"><%=Common.getNotNullString(pageBean.getList().get(i).getPhone()) %></td>
                                <td width="40%" height="25" align="center"><%=displayWorkspace(pageBean.getList().get(i).getWorkspace()) %></td>
                                <td width="4%" height="25" align="center"><%= pageBean.getList().get(i).getRole() %></td>
                            </tr>
                        </c:if>
                        <c:set var="i" value="${i+1}"></c:set>
                        <% i++; %>
                    </c:forEach>
                    <c:remove var="i" scope="request"></c:remove>
                </table>
                <div class="selectDiv">
                    <c:if test="${not empty pageBean}">
                        <div class="check_All">
                        </div>
                        <div class="selectPage">
                            <c:choose>
                                <c:when test="${pageBean.pageNum>1}">
                                    <a href="modfiyList?page=1">第一页</a>&nbsp;&nbsp;
                                    <a href="modfiyList?page=${pageBean.pageNum-1}">上一页</a>
                                </c:when>
                                <c:otherwise>
                                    第一页&nbsp;&nbsp;上一页&nbsp;&nbsp;
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${pageBean.pageNum<pageBean.totalPage}">
                                    <a href="modfiyList?page=${pageBean.pageNum+1}">下一页</a>&nbsp;&nbsp;
                                    <a href="modfiyList?page=${pageBean.totalPage}">最后一页</a>
                                </c:when>
                                <c:otherwise>
                                    下一页&nbsp;&nbsp;最后一页&nbsp;
                                </c:otherwise>
                            </c:choose>
                            转到第
                        </div>
                        <div class="selectstyle">
                            <select id="selPage" name="selPage" onchange="selPage_onchange()" class="select">
                                <c:forEach begin="1" end="${pageBean.totalPage}" varStatus="m" >
                                    <c:choose>
                                        <c:when test="${m.index==pageBean.pageNum}">
                                            <option value="${m.index}" selected>${m.index}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${m.index}">${m.index}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="selectPage">
                            页
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
    <%@include file="bottom.jsp"%>
</div>

<%!
    String displayNumber(String number){
        if(number!=null)
            return "<a title='" + number + "'>" + Common.getFixedLengthString(number, 7) + "</a>";
        else
            return "&nbsp;";
    }



    String displayWorkspace(String workspace){
        if(workspace!=null)
            return "<a title='" + workspace + "'>" + Common.getFixedLengthString(workspace, 8) + "</a>";
        else
            return "&nbsp;";
    }

    String displayAddress(String address){
        if(address!=null)
            return "<a title='" + address + "'>" + Common.getFixedLengthString(address, 5) + "</a>";
        else
            return "&nbsp;";
    }
    String displayEmail(String email){
        if(email!=null)
            return "<a title='" + email + "'>" + Common.getFixedLengthString(email, 6) + "</a>";
        else
            return "&nbsp;";
    }
%>
</body>
</html>
