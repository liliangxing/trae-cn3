package com.bytedance.frameworks.baselib.network.http.exception;

import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import java.net.HttpURLConnection;
import java.net.URI;
import okhttp3.Request;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class HttpResponseException extends ClientProtocolException {
    private static final long serialVersionUID = -7186627969477257933L;
    private final String errorResponse;
    private final int statusCode;

    public HttpResponseException(int i, String str) {
        super(str);
        this.statusCode = i;
        this.errorResponse = null;
    }

    public HttpResponseException(int i, String str, String str2) {
        super((str == null ? "" : str) + " " + (str2 == null ? "" : str2));
        this.statusCode = i;
        this.errorResponse = null;
    }

    public HttpResponseException(int i, String str, String str2, String str3) {
        super((str == null ? "" : str) + " " + (str2 == null ? "" : str2));
        this.statusCode = i;
        this.errorResponse = str3;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public static String getPathFromHttpURLConnection(HttpURLConnection httpURLConnection) {
        return (httpURLConnection == null || httpURLConnection.getURL() == null || httpURLConnection.getURL().getPath() == null) ? "" : httpURLConnection.getURL().getPath();
    }

    public static String getPathFromUrlString(String str) {
        URI safeCreateUri = UrlUtils.safeCreateUri(str);
        return safeCreateUri != null ? safeCreateUri.getPath() : "";
    }

    public static String getPathFromOk3Request(Request request) {
        return (request == null || request.url() == null) ? "" : request.url().url().getPath();
    }

    public String getErrorResponse() {
        return this.errorResponse;
    }
}
