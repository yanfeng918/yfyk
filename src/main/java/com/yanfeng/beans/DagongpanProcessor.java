package com.yanfeng.beans;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.List;

/**
 * Created by yanfeng on 2016/5/24.
 */
public class DagongpanProcessor implements PageProcessor {

    public static final String URL_LIST = "http://dagongpan\\.cn/yjbadmin/auth/area/list\\.jhtml\\?parentId=(\\d*)?";

    private Site site = Site
            .me()
            .setDomain("dagongpan.cn")
            .setSleepTime(1000)
            .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31")
            .addCookie("dagongpan.cn","JSESSIONID","06D1CC7E457EB9872FD67F673BE1EC21-n2");

    @Override
    public void process(Page page) {
        //列表页
        if (page.getUrl().regex(URL_LIST).match()) {

            //首先加入目标请求
//            System.out.println(html);
            List<String> all = page.getHtml().xpath("//table[@class='list']//td").links().regex(URL_LIST).all();
            page.addTargetRequests(page.getHtml().xpath("//table[@class='list']//td").links().regex(URL_LIST).all());
//            page.addTargetRequests(page.getHtml().links().regex(URL_LIST).all());
            //文章页

            page.putField("title", page.getHtml().xpath("//table[@class='list']//td//a[@title='查看']").all());
//            page.putField("content", page.getHtml().xpath("//div[@id='articlebody']//div[@class='articalContent']"));
//            page.putField("date",page.getHtml().xpath("//div[@id='articlebody']//span[@class='time SG_txtc']").regex("\\((.*)\\)"));
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new DagongpanProcessor()).addUrl("http://dagongpan.cn/yjbadmin/auth/area/list.jhtml?parentId=793")
                .run();
    }
}
