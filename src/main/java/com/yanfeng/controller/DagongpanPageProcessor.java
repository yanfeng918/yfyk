package com.yanfeng.controller;

/**
 * Created by yanfeng on 16/5/21.
 */
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

public class DagongpanPageProcessor implements PageProcessor {

//    public static final String URL_LIST = "http://dagongpan\\.cn/yjbadmin/auth/area/list\\.jhtml\\?parentId=\\d+";

    public static final String URL_LIST = "http://dagongpan\\.cn/yjbadmin/auth/houseInfo/list\\?pageNumber=(\\d*)?";

    public static final String URL_LISTSH = "http://dagongpan\\.cn/yjbadmin/auth/houseInfo/list\\?&areaId=792&areaId_select=792&pageSize=100&orderBy=createDate&orderType=desc&pageNumber=(\\d*)?";





    private Site site = Site
            .me()
            .setDomain("dagongpan.cn")
            .setSleepTime(3000)
            .setUserAgent(
                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31")
            .addCookie("dagongpan.cn","JSESSIONID","70A492979E6569981F31BD98B203F6F7-n2");

    @Override
    public void process(Page page) {
        //列表页
        if (page.getUrl().regex(URL_LISTSH).match()) {
            //获取该页面的目标url
            //page.addTargetRequests(page.getHtml().xpath("//div[@class=\"articleList\"]").links().regex(URL_LIST).all());
//             page.addTargetRequests(page.getHtml().xpath("//table[@id='listTable']//").links().regex(URL_LIST).all());

            //判断是否下级还有元素,把数据保存一下

            List<String> all = page.getHtml().xpath("//table[@id='listTable']//tr").all();

            System.out.println(all.get(1));
            Document document = Jsoup.parseBodyFragment("<table>"+all.get(1)+"</table>");
//            Elements siblingElements = document.siblingElements();
            Elements td = document.getElementsByTag("td");

            for (Element link : td) {
                String linkText = link.html();
                System.out.println(linkText);
            }

//            System.out.println("页面:"+page.getHtml().xpath("//table[@id='listTable']//tr/td/a[@title='查看']/text()").all());

//            if(page.getHtml().links().regex(URL_LIST).all().size()>=0){
//                page.putField("title", page.getHtml().xpath("//table//tr/td/a[@title='查看']"));
//              }
// else{
//                page.putField("title", page.getHtml().xpath("//div[@class='articalTitle']/h2"));
//            }

        }
//        else {
//            page.putField("title", page.getHtml().xpath("//div[@class='articalTitle']/h2"));
//            //page.putField("content", page.getHtml().xpath("//div[@id='articlebody']//div[@class='articalContent']"));
//            page.putField("date",
//                    page.getHtml().xpath("//div[@id='articlebody']//span[@class='time SG_txtc']").regex("\\((.*)\\)"));
//        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new DagongpanPageProcessor()).addUrl("http://dagongpan.cn/yjbadmin/auth/houseInfo/list?&areaId=792&areaId_select=792&pageSize=100&orderBy=createDate&orderType=desc&pageNumber=1")
                .run();
    }
}