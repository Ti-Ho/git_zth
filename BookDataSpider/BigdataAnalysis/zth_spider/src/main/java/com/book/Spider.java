package com.book;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.util.PageDownloadUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.awt.windows.WPrinterJob;

import java.io.IOException;
import java.net.MalformedURLException;


/**
 * 豆瓣电子图书爬虫
 * @author Kai
 * @date 2020/7/8 10:46
 */
public class Spider {
    private static Logger logger = LoggerFactory.getLogger(Spider.class);
    private static String REQ_URL = "https://yuedu.163.com/book/category/category/";
    private static String kind[] = {"2000", "2300", "2800", "2500", "2600", "2400", "2100", "2200", "2900", "2700", "3000", "3100", "12000","3200"};
    //eg. url: https://yuedu.163.com/book/category/category/3200

    // 一.下载总览页面
    @Test
    public void requestPageData(String URL){
        System.out.println(URL);
        String content = PageDownloadUtil.getPageContent(URL);
        //System.out.println(content);
        pageParseHtml(content);
    }

    //三.下载单书页面
    private void requstBookData(String URL){
        System.out.println(URL);
        String content = PageDownloadUtil.getPageContent(URL);
        bookParseHtml(content);
    }



    // 二.总览页面解析
    private void pageParseHtml(String content) {
        // 1. 使用jsoup封装响应数据为Document对象
        Document document = Jsoup.parse(content);
        // 2. 使用jsoup API实现页面解析（数据抽取）
        Elements elements =  document.select("div.yd-book-content");
        int cnt = 0;
        // 3. 解析页面数据
        Elements books = elements.first().select("div.yd-book-item");
        //System.out.println(books.toString());
        for(Element book : books){
            cnt ++;
            System.out.println(cnt  + ":");
//            System.out.println(book.toString());
//            String ans = item.select("div.yd-book-item > a").html();
//            System.out.println(ans);
            String url = book.select("div.yd-book-item > a").attr("href");
////            String score = item.select("div.star > span.rating_num").html();
////            String number = item.select("div.star > span").last().html();
            System.out.println(url);
            // 4. 数据简单处理
//            Pattern pattern = Pattern.compile("\\d*");
//            Matcher matcher = pattern.matcher(number);
//            number = matcher.find() ? matcher.group() : "0";
//
//            StringBuilder stringBuilder = new StringBuilder();
//            stringBuilder.append(movieName).append("\t").append(score).append("\t").append(number);
//            logger.info(stringBuilder.toString());
        }
    }

    //四.单书页面解析
    private void bookParseHtml(String content){
        Document document = Jsoup.parse(content);
        Elements elements =  document.select("div.yd-book-content");
    }

    public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
        String URL = REQ_URL + kind[0];
        Spider spider = new Spider();
        spider.requestPageData(URL);
    }
}
