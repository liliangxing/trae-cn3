package okhttp3.internal.http;

import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;

/* loaded from: classes8.dex */
public final class HttpMethod {
    public static boolean invalidatesCache(String str) {
        return str.equals("POST") || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    public static boolean requiresRequestBody(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals(OpenNetMethod.PROPPATCH) || str.equals(OpenNetMethod.REPORT);
    }

    public static boolean permitsRequestBody(String str) {
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }

    public static boolean redirectsWithBody(String str) {
        return str.equals(OpenNetMethod.PROPFIND);
    }

    public static boolean redirectsToGet(String str) {
        return !str.equals(OpenNetMethod.PROPFIND);
    }

    private HttpMethod() {
    }
}
