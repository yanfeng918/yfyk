package com.yanfeng.controller;

/**
 * Created by yanfeng on 16/5/21.
 */
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class DagongpanPageProcessor implements PageProcessor {

    public static final String URL_LIST = "http://dagongpan\\.cn/yjbadmin/auth/area/list\\.jhtml\\?parentId=\\d+";

    public static final String URL_POST = "http://blog\\.sina\\.com\\.cn/s/blog_\\w+\\.html";

    private Site site = Site
            .me()
            .setDomain("dagongpan.cn")
            .setSleepTime(3000)
            .setUserAgent(
                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31")
            .addCookie("dagongpan.cn","JSESSIONID","DD1CBCA7F93F3FB9E07BB1B2D21E4AB3-n1");

    @Override
    public void process(Page page) {
        System.out.println("AAA:"+page.getUrl());
        //列表页
        if (page.getUrl().regex(URL_LIST).match()) {
            //获取该页面的目标url
            //page.addTargetRequests(page.getHtml().xpath("//div[@class=\"articleList\"]").links().regex(URL_LIST).all());
             page.addTargetRequests(page.getHtml().xpath("//table[@id='listTable']//").links().regex(URL_LIST).all());

            //判断是否下级还有元素,把数据保存一下
            System.out.println("页面:"+page.getHtml().xpath("//table//tr/td/a[@title='查看']/text()").all());

            if(page.getHtml().links().regex(URL_LIST).all().size()>=0){
                page.putField("title", page.getHtml().xpath("//table//tr/td/a[@title='查看']"));
              }
// else{
//                page.putField("title", page.getHtml().xpath("//div[@class='articalTitle']/h2"));
//            }





            //文章页
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
        Spider.create(new DagongpanPageProcessor()).addUrl("http://dagongpan.cn/yjbadmin/auth/area/list.jhtml?parentId=3325")
                .run();
    }
}