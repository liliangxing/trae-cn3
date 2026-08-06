package com.bytedance.frameworks.baselib.network.http;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class NativeRequestInterceptor {
    private static final String TAG = "NativeRequestInterceptor";
    private static RequestInterceptorCallback sRequestInterceptorCallback;

    /* loaded from: classes2.dex */
    public interface RequestInterceptorCallback {
        RequestResult onRequestInterceptorCallback(String str, Map<String, String> map, List<String> list);

        ResponseResult onResponseInterceptorCallback(String str, Map<String, List<String>> map, int i);
    }

    /* loaded from: classes2.dex */
    public enum RequestModified {
        NOT_MODIFIED(0),
        URL_MODIFIED(1),
        HEADER_MODIFIED(2),
        BOTH_MODIFIED(3);

        public final int mValue;

        RequestModified(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class RequestResult {
        private RequestModified modified;
        private Map<String, String> newHeaders;
        private String newUrl;
        private Set<String> removedHeaders;

        public RequestResult(RequestModified requestModified) {
            this.modified = requestModified;
        }

        public void setNewUrl(String str) {
            this.newUrl = str;
        }

        public void setNewHeaders(Map<String, String> map) {
            this.newHeaders = map;
        }

        public void setRemoveHeaders(Set<String> set) {
            this.removedHeaders = set;
        }

        public String toJsonStr() {
            JSONObject jSONObject = new JSONObject();
            try {
                int i = AnonymousClass1.$SwitchMap$com$bytedance$frameworks$baselib$network$http$NativeRequestInterceptor$RequestModified[this.modified.ordinal()];
                if (i == 1) {
                    jSONObject.put("modified", RequestModified.URL_MODIFIED.getValue());
                    constructUrlJson(jSONObject, this.newUrl);
                } else if (i == 2) {
                    jSONObject.put("modified", RequestModified.HEADER_MODIFIED.getValue());
                    constructHeaderJson(jSONObject, this.newHeaders, this.removedHeaders);
                } else if (i == 3) {
                    jSONObject.put("modified", RequestModified.BOTH_MODIFIED.getValue());
                    constructUrlJson(jSONObject, this.newUrl);
                    constructHeaderJson(jSONObject, this.newHeaders, this.removedHeaders);
                }
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }

        private static void constructUrlJson(JSONObject jSONObject, String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                new URI(str);
                jSONObject.put("new_url", str);
            } catch (Exception unused) {
            }
        }

        private static void constructHeaderJson(JSONObject jSONObject, Map<String, String> map, Set<String> set) throws JSONException {
            if (set != null) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject.put("removed_headers", jSONArray);
            }
            if (map == null) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!entry.getValue().isEmpty()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("new_headers", jSONObject2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.frameworks.baselib.network.http.NativeRequestInterceptor$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$frameworks$baselib$network$http$NativeRequestInterceptor$RequestModified;

        static {
            int[] iArr = new int[RequestModified.values().length];
            $SwitchMap$com$bytedance$frameworks$baselib$network$http$NativeRequestInterceptor$RequestModified = iArr;
            try {
                iArr[RequestModified.URL_MODIFIED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$frameworks$baselib$network$http$NativeRequestInterceptor$RequestModified[RequestModified.HEADER_MODIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$frameworks$baselib$network$http$NativeRequestInterceptor$RequestModified[RequestModified.BOTH_MODIFIED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class ResponseResult {
        private RequestModified modified;
        private Map<String, List<String>> newHeaders;
        private Set<String> removedHeaders;

        public ResponseResult(RequestModified requestModified) {
            this.modified = requestModified;
        }

        public void setRemoveHeaders(Set<String> set) {
            this.removedHeaders = set;
        }

        public void setNewHeaders(Map<String, List<String>> map) {
            this.newHeaders = map;
        }

        public String toJsonStr() {
            if (this.modified != RequestModified.HEADER_MODIFIED && this.modified != RequestModified.BOTH_MODIFIED) {
                return null;
            }
            if (this.newHeaders == null && this.removedHeaders == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("modified", this.modified.getValue());
                Map<String, List<String>> map = this.newHeaders;
                if (map != null) {
                    jSONObject.put("new_headers", constructHeaderJson(map));
                }
                if (this.removedHeaders != null) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<String> it = this.removedHeaders.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next());
                    }
                    jSONObject.put("removed_headers", jSONArray);
                }
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }

        private static JSONObject constructHeaderJson(Map<String, List<String>> map) throws JSONException {
            if (map == null || map.isEmpty()) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                JSONArray jSONArray = new JSONArray();
                for (String str : entry.getValue()) {
                    if (!TextUtils.isEmpty(str)) {
                        jSONArray.put(str);
                    }
                }
                jSONObject.put(entry.getKey(), jSONArray);
            }
            return jSONObject;
        }
    }

    public static void setRequestInterceptorCallback(RequestInterceptorCallback requestInterceptorCallback) {
        sRequestInterceptorCallback = requestInterceptorCallback;
    }

    public static String onCallRequestInterceptorToStart(String str, Map<String, String> map, List<String> list) {
        if (sRequestInterceptorCallback == null) {
            return null;
        }
        if (Logger.debug()) {
            Logger.d(TAG, "request url:" + str + " headers:" + map.toString() + " domains:" + list);
        }
        RequestResult onRequestInterceptorCallback = sRequestInterceptorCallback.onRequestInterceptorCallback(str, map, list);
        if (onRequestInterceptorCallback == null) {
            return null;
        }
        String jsonStr = onRequestInterceptorCallback.toJsonStr();
        if (Logger.debug()) {
            Logger.d(TAG, "request json:" + jsonStr);
        }
        return jsonStr;
    }

    public static String onCallResponseInterceptorToStart(String str, Map<String, List<String>> map, int i) {
        if (sRequestInterceptorCallback == null) {
            return null;
        }
        if (Logger.debug()) {
            Logger.d(TAG, "response url:" + str + " headers:" + map.toString() + " code:" + i);
        }
        ResponseResult onResponseInterceptorCallback = sRequestInterceptorCallback.onResponseInterceptorCallback(str, map, i);
        if (onResponseInterceptorCallback == null) {
            return null;
        }
        String jsonStr = onResponseInterceptorCallback.toJsonStr();
        if (Logger.debug()) {
            Logger.d(TAG, "response json:" + jsonStr);
        }
        return jsonStr;
    }
}
