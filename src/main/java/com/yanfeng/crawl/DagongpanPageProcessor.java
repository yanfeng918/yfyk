package com.yanfeng.crawl;

/**
 * Created by yanfeng on 16/5/21.
 */
import com.yanfeng.dao.extend.HouseInfoCrawlExtendMapper;
import com.yanfeng.dao.mbg.HouseInfoCrawlMapper;
import com.yanfeng.entity.HouseInfoCrawl;
import com.yanfeng.entity.HouseInfoCrawlExample;
import com.yanfeng.utils.DateUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class DagongpanPageProcessor implements PageProcessor {

    private static List<HouseInfoCrawl> list = new ArrayList<HouseInfoCrawl>();

    public static final String URL_LISTSH = "http://dagongpan\\.cn/yjbadmin/auth/houseInfo/list\\?&areaId=792&areaId_select=792&pageSize=100&orderBy=createDate&orderType=desc&pageNumber=(\\d*)?";

    private Site site = Site
            .me()
            .setDomain("dagongpan.cn")
            .setSleepTime(3000)
            .setUserAgent(
                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31")
            .addCookie("dagongpan.cn","JSESSIONID","FE42552B737C903454E46A83220D752F-n1");

    @Override
    public void process(Page page) {
        //列表页
        if (page.getUrl().regex(URL_LISTSH).match()) {

            List<String> all = page.getHtml().xpath("//table[@id='listTable']//tr").all();

            for (String tr : all) {
                Document document = Jsoup.parseBodyFragment("<table>" + tr + "</table>");
                Elements td = document.getElementsByTag("td");

                if(td.isEmpty())
                    continue;

                HouseInfoCrawl houseInfoCrawl = new HouseInfoCrawl();
                houseInfoCrawl.setOid(Integer.parseInt(td.get(0).child(0).val()));

                houseInfoCrawl.setName(td.get(1).html());
                try {
                    houseInfoCrawl.setCreatedate(DateUtils.parse(td.get(2).html()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                houseInfoCrawl.setMembername(td.get(3).html());
                houseInfoCrawl.setAreaname(td.get(4).html());
                houseInfoCrawl.setCommunity(td.get(6).html());
                houseInfoCrawl.setBan(td.get(7).html());
                houseInfoCrawl.setRoomnumber(td.get(8).html());
                houseInfoCrawl.setAreasize(Float.parseFloat(td.get(9).html()));
                houseInfoCrawl.setSaleprice(Float.parseFloat(td.get(10).html()));
                houseInfoCrawl.setMobile(td.get(11).html());

                houseInfoCrawl.setCheckcontent(td.get(13).html());
                houseInfoCrawl.setStatus(td.get(14).child(0).text());

                list.add(houseInfoCrawl);

//                System.out.println(houseInfoCrawl.toString());
            }

        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new DagongpanPageProcessor()).addUrl("http://dagongpan.cn/yjbadmin/auth/houseInfo/list?&areaId=792&areaId_select=792&pageSize=100&orderBy=createDate&orderType=desc&pageNumber=1")
                .run();
    }

    public List<HouseInfoCrawl> begin(String url){
        int totalPager=2;
        String baseUrl="http://dagongpan.cn/yjbadmin/auth/houseInfo/list?&areaId=792&areaId_select=792&pageSize=100&orderBy=createDate&orderType=desc&pageNumber=";

        Spider.create(new DagongpanPageProcessor()).addUrl(url).run();
        return list;
    }

    public void clearList(){
        list.clear();
    }

}