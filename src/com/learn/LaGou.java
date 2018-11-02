package com.learn;



import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 * 使用Jsoup模拟登陆拉钩网
 * 
 * 
 * 大体思路如下:
 * 
 * 第一次请求登陆页面，获取页面信息，包含表单信息，和cookie（这个很重要），拿不到，会模拟登陆不上
 * 
 * 
 * 第二次登陆，设置用户名，密码，把第一次的cooking，放进去，即可
 * 
 * 怎么确定是否登陆成功？
 * 
 * 登陆后，打印页面，会看到账户的详细信息。
 * 
 * 
 * @date 2018年 9/8
 * @author 空白
 * 
 * 
 * **/
public class LaGou {
    public static void main(String[] args) throws Exception {
    	LaGou loginDemo = new LaGou();
        loginDemo.login();// 输入CSDN的用户名，和密码
    }
    /**
     * 模拟登陆拉勾网
     * 
     * @param userName
     *            用户名
     * @param pwd
     *            密码
     *  @param  request_form_verifyCode
     *           验证码
     *  @param  submit
     *           无意义
     * **/
    public void login() throws Exception {
        // 第一次请求
        Connection con = Jsoup
                .connect("https://campus.meituan.com/");// 获取连接
        con.header("User-Agent",
                "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");// 配置模拟浏览器
       
        Response rs = con.execute();//获取响应
        Document d1 = Jsoup.parse(rs.body());// 转换为Dom树
        Element e1 =d1.select("script").get(1);
      /*  String mid =e1.html();
        System.out.println(mid);
        String pattern = ".*X_Anti_Forge_Token = \\'(.*?)\\'";

		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(mid);
		System.out.println(m.matches());*/
       /* String xt =*/  
       // m.find(); 
        
        /**
         * 爬去拉钩的动态页面 token 以及验证码，并设置头文件
         */
        String mid =e1.html();
        String pattern = " \\'(.*?)\\'";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(mid);
		String pattern1 = "\\'(\\d+?)\\'";
		Pattern r1 = Pattern.compile(pattern1);
		Matcher m1 = r1.matcher(mid);
		String xt="";
		String xc="";
		
		if (m.find()) {
			xt =m.group(1);
		}if (m1.find()) {
			 xc=m1.group(1);
		}
		
		System.out.println(xt);
		System.out.println(xc);
/*        List<Element> et = d1.select("form[class=active]");// 获取form表单，可以通过查看页面源码代码得知
        System.out.println(et.get(0).getAllElements());*/
        // 获取，cooking和表单属性，下面map存放post时的数据
        Map<String, String> datas = new HashMap<>();
        
        /*for (Element e : et.get(0).getAllElements()) {
            if (e.attr("data-propertyname").equals("username")) {
                e.attr("value", userName);// 设置用户名 
               System.out.println(e.attr("data-propertyname").equals("username"));
            }
            if (e.attr("data-propertyname").equals("password")) {
                e.attr("value", pwd); // 设置用户密码
                System.out.println(e.attr("data-propertyname").equals("password"));
            }
            if (e.attr("data-propertyname").length() > 0) {// 排除空值表单属性
                datas.put(e.attr("data-propertyname"), e.attr("value"));
               
            }
        }*/
        
         /* datas.put("isValidate", "true");
          datas.put("username", "18632620365");
          datas.put("password", "05ff690e6c5e31dc670b9a125720c8b5");
          datas.put("request_form_verifyCode","");
          datas.put("submit", "");*/
          
        /**
         * 第二次请求，post表单数据，以及cookie信息
         * 
         * **/ 
        //Thread.sleep(5000);//防止连续请求，造成请求频繁

       /* String xt =*/  
        Connection con2 = Jsoup 
                .connect("https://campus.meituan.com/api/job/list/get");
        con2.header("User-Agent",
                "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");    
        con2.header("X-Requested-With", "XMLHttpRequest");
        con.header("Cookie", "_lxsdk_cuid=165d100e139c8-0c228b85be0019-323b5b03-1fa400-165d100e13bc8; _lxsdk=165d100e139c8-0c228b85be0019-323b5b03-1fa400-165d100e13bc8; _lx_utm=utm_source%3Dcampus%26utm_medium%3D; _lxsdk_s=165d100e13e-94e-727-f67%7C%7C6");
        // 设置cookie和post上面的map数据
        Response login = con2.ignoreContentType(true).method(Method.POST).execute();
        // 打印，登陆成功后的信息      
        System.out.println(login.cookies());  
        System.out.println(login.body());
        // 登陆成功后的cookie信息，可以保存到本地，以后登陆时，只需一次登陆即可
        Map<String, String> map = login.cookies();
        for (String s : map.keySet()) {
            System.out.println(s + "      " + map.get(s));
        }
    }
}