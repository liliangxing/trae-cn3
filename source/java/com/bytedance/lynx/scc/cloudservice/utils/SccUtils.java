package com.bytedance.lynx.scc.cloudservice.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.bytedance.lynx.scc.cloudservice.network.UrlResponse;
import com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetHtml;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.io.ByteArrayInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes4.dex */
public final class SccUtils {
    public static final String CLIENT_LOG_ID = "scc_logid";
    public static final String CLIENT_REASON = "scc_reason";
    public static final String CLOUD_SERVICE_RES = "scc_res";
    public static final String CS_ALLOW_LIST = "scc_cs_allow_list";
    public static final String CS_ENABLE = "scc_cs_enable";
    public static final String CS_ENABLE_PREFETCH = "scc_cs_enable_prefetch";
    public static final String CS_IS_DEBUG = "scc_cs_is_debug";
    public static final String CS_MAX_WAIT_TIME = "scc_cs_max_wait_time";
    public static final String CS_SECLINK_SCENE = "scc_seclink_scene";
    public static final String HEADER_LOG_ID = "X-Tt-Logid";
    public static final String HEADER_LOG_ID_LOWER_CASE = "x-tt-logid";
    public static final String HEADER_TRACE_ID = "X-Tt-Trace-Id";
    public static final String HEADER_TRACE_ID_LOWER_CASE = "x-tt-trace-id";
    public static String LOG_TAG = "scc_sdk";
    public static final String REPORT_EVENT_NAME = "scc_cloudservice_result";
    public static final String REPORT_LOGID = "scc_logid";
    public static final String REPORT_PASSED_TIME = "scc_passed_time";
    public static final String REPORT_TRACE_ID = "scc_trace_id";

    private SccUtils() {
    }

    public static String getUrlWithPathUnify(String url) {
        if (TextUtils.isEmpty(url)) {
            return url;
        }
        Uri parse = Uri.parse(url);
        String host = parse.getHost();
        String path = parse.getPath();
        String query = parse.getQuery();
        if (TextUtils.isEmpty(host) && !TextUtils.isEmpty(path)) {
            int i = 0;
            while (i < path.length() && path.charAt(i) == '/') {
                i++;
            }
            if (i < path.length()) {
                path = path.substring(i);
            }
        }
        if (TextUtils.isEmpty(path)) {
            path = "/";
        } else if (path.charAt(path.length() - 1) != '/') {
            path = path + "/";
        }
        return parse.getScheme() + "://" + parse.getHost() + path + (TextUtils.isEmpty(query) ? "" : "?" + query);
    }

    public static boolean schemeIsHttpOrHttps(String url) {
        String scheme = getScheme(url);
        if (TextUtils.isEmpty(scheme)) {
            return false;
        }
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    public static String getScheme(String url) {
        if (TextUtils.isEmpty(url)) {
            return null;
        }
        return Uri.parse(url).getScheme();
    }

    public static String getHost(String url) {
        if (TextUtils.isEmpty(url)) {
            return null;
        }
        return Uri.parse(url).getHost();
    }

    public static String getHostAndPath(String urlString) {
        if (TextUtils.isEmpty(urlString)) {
            return null;
        }
        Uri parse = Uri.parse(urlString);
        if (TextUtils.isEmpty(parse.getAuthority())) {
            return null;
        }
        return removeTrailingSlash(parse.getAuthority() + parse.getPath());
    }

    public static void removeTrailingSlash(List<String> urls) {
        if (urls == null || urls.isEmpty()) {
            return;
        }
        for (int i = 0; i < urls.size(); i++) {
            String str = urls.get(i);
            if (str != null && str.endsWith("/")) {
                urls.set(i, str.substring(0, str.length() - 1));
            }
        }
    }

    public static String removeTrailingSlash(String url) {
        return (!TextUtils.isEmpty(url) && url.endsWith("/")) ? url.substring(0, url.length() - 1) : url;
    }

    public static void readDomainsFromJson(JsonArray domains, CopyOnWriteArraySet<String> container) {
        if (domains == null || container == null) {
            return;
        }
        Iterator<JsonElement> it = domains.iterator();
        while (it.hasNext()) {
            JsonElement next = it.next();
            if (next != null && next.isJsonPrimitive() && next.getAsJsonPrimitive().isString()) {
                String asString = next.getAsString();
                if (!TextUtils.isEmpty(asString)) {
                    container.add(removeTrailingSlash(asString));
                }
            }
        }
    }

    public static WebResourceResponse getWebResponse(UrlResponse response) {
        if (response == null || response.getOriginalData() == null) {
            return null;
        }
        return new WebResourceResponse(PureShowWidgetHtml.MIME_TYPE, "UTF-8", new ByteArrayInputStream(response.getOriginalData()));
    }

    public static String getHeaderValue(UrlResponse response, String key, String backupKey) {
        if (response == null || response.getHeaders() == null || response.getHeaders().isEmpty()) {
            return null;
        }
        List<String> list = response.getHeaders().get(key);
        if (list == null || list.isEmpty()) {
            list = response.getHeaders().get(backupKey);
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
