package com.bytedance.android.monitor.webview;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class WebSaveTempCache {
    private static final String TAG = "WebviewTempCache";
    private Map<Key, List<Data>> dataMap = new WeakHashMap();

    /* loaded from: classes3.dex */
    public static class Key {
        String url;
        WebView webView;

        public Key(WebView webView, String str) {
            this.webView = webView;
            this.url = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Key key = (Key) obj;
            WebView webView = this.webView;
            if (webView == null ? key.webView != null : !webView.equals(key.webView)) {
                return false;
            }
            String str = this.url;
            String str2 = key.url;
            return str != null ? str.equals(str2) : str2 == null;
        }

        public int hashCode() {
            WebView webView = this.webView;
            int hashCode = (webView != null ? webView.hashCode() : 0) * 31;
            String str = this.url;
            return hashCode + (str != null ? str.hashCode() : 0);
        }
    }

    /* loaded from: classes3.dex */
    public static class Data {
        JSONObject o;
        String type;

        public Data(String str, JSONObject jSONObject) {
            this.type = str;
            this.o = jSONObject;
        }
    }

    public void save(WebView webView, String str, String str2, JSONObject jSONObject) {
        Key key = new Key(webView, str);
        Data data = new Data(str2, jSONObject);
        List<Data> list = this.dataMap.get(key);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(data);
    }

    public List<Data> poll(WebView webView, String str) {
        return this.dataMap.remove(new Key(webView, str));
    }
}
