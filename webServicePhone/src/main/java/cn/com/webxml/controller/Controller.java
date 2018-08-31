package cn.com.webxml.controller;

import cn.com.webxml.MobileCodeWS;
import cn.com.webxml.MobileCodeWSSoap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author:
 * @date: 2018/8/30
 * webService地址：http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl
 */
@RestController
public class Controller {

    @RequestMapping("/phone")
    public String phone(HttpServletRequest request){
        String phone = request.getParameter("phone");
        //创建一个MobileCodeWS工厂
        MobileCodeWS factory = new MobileCodeWS();
        //根据工厂创建一个MobileCodeWSSoap对象
        MobileCodeWSSoap mobileCodeWSSoap = factory.getMobileCodeWSSoap();
        String searchResult = mobileCodeWSSoap.getMobileCodeInfo(phone, null);
        return searchResult;
    }
}
