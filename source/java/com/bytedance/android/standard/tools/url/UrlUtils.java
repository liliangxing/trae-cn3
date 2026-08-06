package com.bytedance.android.standard.tools.url;

import android.net.Uri;
import android.util.Pair;
import com.bytedance.android.standard.tools.string.StringUtils;
import com.lynx.tasm.core.ResManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public final class UrlUtils {
    public static final String CONTENT_TYPE = "Content-Type";
    public static final int CR = 13;
    public static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    public static final int HT = 9;
    public static final int LF = 10;
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final String PARAMETER_SEPARATOR = "&";
    public static final int SP = 32;
    public static final String USER_AGENT = "User-Agent";
    public static final String UTF_8 = "UTF-8";

    public static boolean isWhitespace(char c) {
        return c == ' ' || c == '\t' || c == '\r' || c == '\n';
    }

    private UrlUtils() {
    }

    @Deprecated
    public static Pair<String, String> parseUrl(String str, Map<String, String> map) throws IOException {
        String encodedQuery;
        if (StringUtils.isEmpty(str)) {
            throw new IOException("parseUrl url is null !!!");
        }
        try {
            Uri parse = Uri.parse(str);
            StringBuilder sb = new StringBuilder();
            String scheme = parse.getScheme();
            String host = parse.getHost();
            int port = parse.getPort();
            if (host != null) {
                if (scheme != null) {
                    sb.append(scheme);
                    sb.append("://");
                }
                sb.append(host);
                if (port > 0) {
                    sb.append(AbstractJsonLexerKt.COLON);
                    sb.append(port);
                }
            }
            String sb2 = sb.toString();
            String encodedPath = parse.getEncodedPath();
            if (map != null && (encodedQuery = parse.getEncodedQuery()) != null) {
                for (String str2 : encodedQuery.split("&")) {
                    int indexOf = str2.indexOf("=");
                    if (indexOf >= 0) {
                        map.put(URLDecoder.decode(str2.substring(0, indexOf), "UTF-8"), URLDecoder.decode(str2.substring(indexOf + 1), "UTF-8"));
                    } else {
                        map.put(URLDecoder.decode(str2, "UTF-8"), "");
                    }
                }
            }
            return new Pair<>(sb2, encodedPath);
        } catch (Throwable th) {
            th.printStackTrace();
            throw new IOException("parseUrl url is fail !!!");
        }
    }

    public static Pair<String, String> parseUrlWithValueList(String str, Map<String, List<String>> map) throws IOException {
        String encodedQuery;
        if (StringUtils.isEmpty(str)) {
            throw new IOException("parseUrl url is null !!!");
        }
        try {
            Uri parse = Uri.parse(str);
            StringBuilder sb = new StringBuilder();
            String scheme = parse.getScheme();
            String host = parse.getHost();
            int port = parse.getPort();
            if (host != null) {
                if (scheme != null) {
                    sb.append(scheme);
                    sb.append("://");
                }
                sb.append(host);
                if (port > 0) {
                    sb.append(AbstractJsonLexerKt.COLON);
                    sb.append(port);
                }
            }
            String sb2 = sb.toString();
            String encodedPath = parse.getEncodedPath();
            if (map != null && (encodedQuery = parse.getEncodedQuery()) != null) {
                for (String str2 : encodedQuery.split("&")) {
                    int indexOf = str2.indexOf("=");
                    if (indexOf >= 0) {
                        String decode = URLDecoder.decode(str2.substring(0, indexOf), "UTF-8");
                        List<String> list = map.get(decode);
                        if (list == null) {
                            list = new LinkedList<>();
                        }
                        list.add(URLDecoder.decode(str2.substring(indexOf + 1), "UTF-8"));
                        map.put(decode, list);
                    } else {
                        String decode2 = URLDecoder.decode(str2, "UTF-8");
                        List<String> list2 = map.get(decode2);
                        if (list2 == null) {
                            list2 = new LinkedList<>();
                        }
                        list2.add("");
                        map.put(decode2, list2);
                    }
                }
            }
            return new Pair<>(sb2, encodedPath);
        } catch (Throwable th) {
            th.printStackTrace();
            throw new IOException("parseUrl url is fail !!!");
        }
    }

    public static String format(Map<String, List<String>> map, String str) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String encode = encode(entry.getKey(), str);
            List<String> value = entry.getValue();
            if (value != null && value.size() > 0) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    String encode2 = next != null ? encode(next, str) : "";
                    if (sb.length() > 0) {
                        sb.append("&");
                    }
                    sb.append(encode);
                    if (!encode2.isEmpty()) {
                        sb.append("=");
                        sb.append(encode2);
                    }
                }
            }
        }
        return sb.toString();
    }

    private static String encode(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static boolean isHttpUrl(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(ResManager.HTTP_SCHEME) || str.startsWith("https://");
    }

    public static String removeUrlHashBang(String str) {
        return (!StringUtils.isEmpty(str) && str.contains("#")) ? str.substring(0, str.indexOf("#")) : str;
    }

    public static String addParameter(String str, String str2, String str3) {
        int indexOf = str.indexOf(63);
        int indexOf2 = str.indexOf(35);
        String str4 = (indexOf != -1 ? Typography.amp : '?') + encodeUrl(str2) + '=' + encodeUrl(str3);
        if (indexOf2 == -1) {
            return str + str4;
        }
        return str.substring(0, indexOf2) + str4 + str.substring(indexOf2);
    }

    private static String encodeUrl(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
