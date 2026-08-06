package com.ss.android.http.legacy.params;

import org.apache.http.params.HttpParams;

@Deprecated
/* loaded from: classes7.dex */
public final class HttpProtocolParams implements CoreProtocolPNames {
    private HttpProtocolParams() {
    }

    public static String getHttpElementCharset(HttpParams httpParams) {
        if (httpParams == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        String str = (String) httpParams.getParameter(CoreProtocolPNames.HTTP_ELEMENT_CHARSET);
        return str == null ? "US-ASCII" : str;
    }

    public static void setHttpElementCharset(HttpParams httpParams, String str) {
        if (httpParams == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        httpParams.setParameter(CoreProtocolPNames.HTTP_ELEMENT_CHARSET, str);
    }

    public static String getContentCharset(HttpParams httpParams) {
        if (httpParams == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        String str = (String) httpParams.getParameter(CoreProtocolPNames.HTTP_CONTENT_CHARSET);
        return str == null ? "ISO-8859-1" : str;
    }

    public static void setContentCharset(HttpParams httpParams, String str) {
        if (httpParams == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        httpParams.setParameter(CoreProtocolPNames.HTTP_CONTENT_CHARSET, str);
    }

    public static String getUserAgent(HttpParams httpParams) {
        if (httpParams == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        return (String) httpParams.getParameter(CoreProtocolPNames.USER_AGENT);
    }

    public static void setUserAgent(HttpParams httpParams, String str) {
        if (httpParams == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        httpParams.setParameter(CoreProtocolPNames.USER_AGENT, str);
    }

    public static boolean useExpectContinue(HttpParams httpParams) {
        if (httpParams == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        return httpParams.getBooleanParameter(CoreProtocolPNames.USE_EXPECT_CONTINUE, false);
    }

    public static void setUseExpectContinue(HttpParams httpParams, boolean z) {
        if (httpParams == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        httpParams.setBooleanParameter(CoreProtocolPNames.USE_EXPECT_CONTINUE, z);
    }
}
