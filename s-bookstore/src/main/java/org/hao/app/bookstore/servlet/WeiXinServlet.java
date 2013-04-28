package org.hao.app.bookstore.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
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

import org.hao.app.bookstore.dto.ProductDTO;
import org.hao.app.bookstore.dto.ProductQuery;
import org.hao.app.bookstore.service.BookstoreServicesLocator;
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
    private final String      TOKEN            = "melody";

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
        if (signature != null) {
            String sigStr = encode(timestamp, nonce);
            return signature.equals(sigStr);
        }
        return false;
    }

    private String encode(String timestamp, String nonce) {
        String signature = null;
        if (timestamp != null && nonce != null) {
            String[] srcs = { timestamp, nonce, TOKEN };
            Arrays.sort(srcs);
            StringBuilder seed = new StringBuilder();
            for (String src : srcs)
                seed.append(src);
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-1");
                StringBuilder signatureStringBuilder = new StringBuilder();
                byte[] results = digest.digest(seed.toString().getBytes());
                for (byte result : results) {
                    String tmp = Integer.toHexString(result & 0xFF);
                    signatureStringBuilder.append(tmp.length() == 1 ? "0" + tmp : tmp);
                }
                signature = signatureStringBuilder.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return signature;
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
