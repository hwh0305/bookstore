package org.hao.bookstore.web.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.hao.bookstore.modules.goods.BookstoreServicesLocator;
import org.hao.bookstore.modules.goods.dto.ProductDTO;
import org.hao.bookstore.modules.goods.dto.ProductQuery;
import org.hao.bookstore.modules.weixin.WeiXinValidateHelper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WeiXinServlet extends HttpServlet {

    private static final long serialVersionUID = -686861629811893735L;

    private final String      SIGNATURE_KEY    = "signature";         // 微信加密签名
    private final String      TIMESTAMP_KEY    = "timestamp";         // 时间戄1�7
    private final String      NONCE_KEY        = "nonce";             // 随机敄1�7
    private final String      ECHO_STR_KEY     = "echostr";

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String echostr = req.getParameter(ECHO_STR_KEY);
        if (validate(req)) {
            PrintWriter out = resp.getWriter();
            out.print(echostr);
            out.flush();
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (validate(req)) {
            Map<String, String> reqMap = getRequest(req.getInputStream());
            String content = "什么？";
            String eventType = reqMap.get("MsgType");
            if ("text".equals(eventType)) {
                content = reqMap.get("Content");
                ProductQuery query = new ProductQuery();
                query.setKeyword(content);
                query.setNickName("颦儿814");
                query.setCurrentPage(1);
                List<ProductDTO> dtos = BookstoreServicesLocator.getProductService().queryProducts(query);
                dtos.size();
            }
            if ("event".equals(eventType) && "subscribe".equals(reqMap.get("Event"))) content = "青藤书屋欢迎你！";
            resp.setContentType("application/xml");
            resp.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();
            out.print("<xml><ToUserName><![CDATA[" + reqMap.get("FromUserName") + "]]></ToUserName>"
                      + "<FromUserName><![CDATA[" + reqMap.get("ToUserName") + "]]></FromUserName>" + "<CreateTime>"
                      + System.currentTimeMillis() + "</CreateTime>" + "<MsgType><![CDATA[text]]></MsgType>"
                      + "<Content><![CDATA[" + content + "]]></Content>" + "<FuncFlag>0</FuncFlag></xml>");
            out.flush();
        }
    }

    private boolean validate(HttpServletRequest req) {
        String signature = req.getParameter(SIGNATURE_KEY);
        String timestamp = req.getParameter(TIMESTAMP_KEY);
        String nonce = req.getParameter(NONCE_KEY);
        return WeiXinValidateHelper.validate(signature, timestamp, nonce);
    }

    private Map<String, String> getRequest(InputStream in) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(in);
            Element element = document.getDocumentElement();
            NodeList xmlNodes = element.getChildNodes();
            Map<String, String> result = new HashMap<String, String>();
            for (int i = 0; i < xmlNodes.getLength(); ++i) {
                Node node = xmlNodes.item(i);
                String name = node.getNodeName();
                String value = node.getTextContent();
                result.put(name, value);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyMap();
    }
}
