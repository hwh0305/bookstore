package org.hao.bookstore.modules.weixin.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WeiXinValidateHelper {

    private final static Log    log   = LogFactory.getLog(WeiXinValidateHelper.class);

    private final static String TOKEN = "melody";

    public static boolean validate(String signature, String timestamp, String nonce) {
        if (StringUtils.isBlank(signature) || StringUtils.isBlank(timestamp) || StringUtils.isBlank(nonce)) return false;
        String[] seeds = { TOKEN, timestamp, nonce };
        Arrays.sort(seeds);
        byte[] cipher = sha1Encode(seeds);
        String hexCipher = byte2HexString(cipher);
        return StringUtils.equals(hexCipher, signature);
    }

    public static String byte2HexString(byte[] bytes) {
        StringBuilder builder = new StringBuilder(bytes.length * 2);
        if (bytes != null) {
            for (byte b : bytes) {
                if ((int) (b & 0xFF) <= 0xF) builder.append("0");
                builder.append(Integer.toHexString(b & 0xFF));
            }
        }
        return builder.toString();
    }

    public static byte[] sha1Encode(String[] strs) {
        byte[] result = new byte[0];
        if (strs != null) {
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-1");
                for (String str : strs)
                    digest.update(str.getBytes());
                result = digest.digest();
            } catch (NoSuchAlgorithmException e) {
                log.error(e);
            }
        }
        return result;
    }
}
