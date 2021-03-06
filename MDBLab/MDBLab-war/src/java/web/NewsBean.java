/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package web;

import ejb.NewsItem;
import ejb.NewsItemFacadeLocal;
import java.util.List;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

/**
 *
 * @author Kacper
 */
@Named(value = "newsBean")
@RequestScoped
public class NewsBean {

    @Inject
    private NewsItemFacadeLocal facade;

    @Inject
    private JMSContext context;

    @Resource(lookup = "java:app/jms/NewsQueue")
    private javax.jms.Queue queue;

    private String headingText;
    private String bodyText;

    public String getHeadingText() {
        return headingText;
    }

    public void setHeadingText(String headingText) {
        this.headingText = headingText;
    }

    public String getBodyText() {
        return bodyText;
    }

    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }

    /**
     * Creates a new instance of NewsBean
     */
    public NewsBean() {
    }

    void sendNewsItem(String heading, String body) {
//        try {
//            ObjectMessage message = context.createObjectMessage();
//            NewsItem e = new NewsItem();
//            e.setHeading(heading);
//            e.setBody(body);
//            message.setObject(e);
//            context.createProducer().send(queue, message);
//        } catch (JMSException ex) {
//            ex.printStackTrace();
//        }

        TextMessage message = context.createTextMessage(heading + "|" + body);
        context.createProducer().send(queue, message);
    }

    public List<NewsItem> getNewsItems() {
        return facade.getAllNewsItems();
    }

    public String submitNews() {
        sendNewsItem(headingText, bodyText);
        return null;
    }

}
