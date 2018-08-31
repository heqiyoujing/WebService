package cn.com.webxml.controller;


import cn.com.webxml.ArrayOfString;
import cn.com.webxml.IpAddressSearchWebService;
import cn.com.webxml.IpAddressSearchWebServiceSoap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author:
 * @date: 2018/8/30
 * @description: http://ws.webxml.com.cn/WebServices/IpAddressSearchWebService.asmx?wsdl
 */
@RestController
public class Controller {

    @RequestMapping("/ip")
    public List<String> ip(HttpServletRequest request){
        String ip = request.getParameter("ip");
        IpAddressSearchWebService service = new IpAddressSearchWebService();
        IpAddressSearchWebServiceSoap soap = service.getIpAddressSearchWebServiceSoap();
        ArrayOfString ips = soap.getCountryCityByIp(ip);
        List<String> list = ips.getString();
        return list;
    }
}
