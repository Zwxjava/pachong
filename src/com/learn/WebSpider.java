package com.learn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
/**
 * 用于爬取一些职位信息,输出到某个文件中
 * @author evan_qb
 *
 */
public class WebSpider {
	public static  String getHtml(String url,String encoding) {
		URL uri = null;
		URLConnection conn = null;
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		try {
			//建立网络连接
			uri = new URL(url);
			//打开连接
			conn = uri.openConnection();
			//使用输入流读取网页数据
			InputStream in = conn.getInputStream();
			br = new BufferedReader(new InputStreamReader(in, encoding));
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(new String(line + "\n"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
	
	/**
	 * 获取对应内容
	 * @return
	 */
	public static List<Map<String,String>> getContent(String url,String encoding){
		//获取网页内容
		String html = getHtml(url, encoding);
		//将网页内容转成document的格式
		Document document = Jsoup.parse(html);
		//获取ul标签
		Elements elements = document.getElementsByClass("searchResultItemDetailed");
		
		//使用List<Map>集合进行收集数据
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		//使用一个map进行存储数据
		for (Element element : elements) {
			//获取职位名
			String jobName = element.getElementsByClass("searchResultJobName").text().split(" ")[0];
			String firmName = element.getElementsByClass("searchResultCompanyname").text();
			String city = element.getElementsByClass("searchResultJobCityval").text();
			//获取发布时间
			String time = element.getElementsByClass("searchResultKeyval").text().split(" ")[1].split("：")[1];
			String desc = element.getElementsByClass("searchResultCompanyInfodetailed").text();
			String industry = null;
			String posType = null;
			String empNum = null;
			//由于desc的标签比较多，我们需要对其进行细分
			//System.out.println(desc);
			//爬取到的数据为:   所属行业：大型设备/机电设备/重工业,仪器仪表及工业自动化 职位类别：Java开发工程师 招聘人数：1人
			//所以我们以空格进行分隔
			String[] strs = desc.split(" ");
			//分别获取  所属行业  职位类型  招聘人数
			/*
				所属行业：大型设备/机电设备/重工业,仪器仪表及工业自动化
				职位类别：Java开发工程师
				招聘人数：1人
			*/
			if (strs.length > 0) {
				//获取所需内容
				//所属行业
				industry = strs[0].split("：")[1];
				//职位类型
				posType = strs[1].split("：")[1];
				//招聘人数
				if (strs.length >= 3 && strs[2].split("：").length > 1) {
					empNum = strs[2].split("：")[1];
				}
				
			}
			System.out.println();
			String require = element.getElementsByClass("searchResultJobdescription").text();
			/*Map<String,String> map = new HashMap<String, String>();
			map.put("职位名称", jobName);*/
			
			
			System.out.println(String.format("职位: %s\n公司名:%s\n所在城市:%s\n发布时间:%s\n所属行业:%s\n职位类型:%s\n招聘人数:%s\n需求: %s\n",
						jobName,firmName,city,time,industry,posType,empNum,require));
			Map<String,String> map = new HashMap<String, String>();
			map.put("职位", jobName);
			map.put("公司名", firmName);
			map.put("所在城市", city);
			map.put("发布时间", time);
			map.put("所属行业", industry);
			map.put("职位类型", posType);
			map.put("招聘人数", empNum);
			map.put("要求", require);
			System.out.println();
			list.add(map);
		}
		return list;
		
	}
	
	public static void main(String[] args) {
		List<Map<String, String>> content = getContent("https://xiaoyuan.zhaopin.com/full/0/0_0_0_0_0_-1_java_1_0", "UTF-8");
		System.out.println(content);
	}
}
