package com.learn;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


public class PaBaidu {
	public static void main(String[] args) throws Exception {
		String url ="https://talent.baidu.com/baidu/web/httpservice/getPostList?recruitType=1&postType=&pageSize=15000&curPage=1";
		String jsonname="postList";//json 数组的名字
		String name="name";//标题名字 
		String publishDate="publishDate";//发布时间
		String postType="postType";//类型
		String workPlace="workPlace";//工作地点
		String workYears="workYears";//工作年限
		String recruitNum="recruitNum";//工作人员
		String serviceCondition="serviceCondition";//内容
		String orgName="orgName";//公司名称
		String hrefone="postId";//需要自己分析，一般为网址加ID
		String hreftwo="https://talent.baidu.com/external/baidu/campus.html#/jobDetail/1/";//详情网址前
		//String href="postId";//结合网址
		login(url,jsonname,name,publishDate,postType,workPlace,workYears,recruitNum,serviceCondition,orgName,hrefone,hreftwo);
	}
	public static void login(String url,String jsonname,String name,String publishDate,String postType,String workPlace,String workYears,String recruitNum,String serviceCondition,String orgName,String hrefone,String hreftwo) throws Exception {
  
        Connection con2 = Jsoup 
                .connect(url);
       //建立链接，需要爬取的网页
        con2.header("User-Agent",
                "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");    
        //伪造浏览器请求
        Response rs = con2.execute();//建立链接
        Document d1 = Jsoup.parse(rs.body());// 转换为Dom树
        String str = d1.body().html();//转换成String类型
        String str1 =JSON.toJSONString(str);//String类型 变成标准的StringJson串
        JSONObject object =JSONObject.parseObject(str);//转换成JSONObject类型
        JSONArray jsonArray =object.getJSONArray(""+jsonname+"");//将其中的数组转换成JSONArray
        System.out.println(jsonArray);      
        for (int i = 0; i < jsonArray.size(); i++) {//遍历
        	JSONObject job = jsonArray.getJSONObject(i);
        	/*System.out.println(" 网址:href = https://talent.baidu.com/external/baidu/campus.html#/jobDetail/1/"+job.get("postId"));        	
        	System.out.println("职业名称:"+job.get("name"));
        	System.out.println("发布时间:"+job.get("publishDate"));
        	System.out.println("类型:"+job.get("postType"));
        	System.out.println("地点:"+job.get("workPlace"));
        	System.out.println("工作年限:"+job.get("workYears"));
        	System.out.println("工作人数:"+job.get("recruitNum"));
        	System.out.println("内容:"+job.get("serviceCondition"));
        	System.out.println("工作公司:"+job.get("orgName"));*/ 
        	String herf =hreftwo+job.get(""+hrefone+"");
        	String sql ="insert into jobtable(url,title,city,experience,salary,education,publictime,details,neednum,company,jobtype) values('"+herf+"','"+job.get(""+name+"")+"','"+job.get(""+workPlace+"")+"','"+job.get(""+workYears+"")+"','面议','本科及以上','"+job.get(""+publishDate+"")+"','"+job.get(""+serviceCondition+"")+"','"+job.get(""+recruitNum+"")+"','"+job.get(""+orgName+"")+"','"+job.get(""+postType+"")+"')";
        	int r =mysqlUtil.add(sql);
        	if (r==1) {
				System.out.println("插入成功");
			}else {
				System.out.println("失败");
			}
        	//插入数据库
		}
    }
}
