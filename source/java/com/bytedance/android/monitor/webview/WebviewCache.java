package com.bytedance.android.monitor.webview;

import android.webkit.WebView;
import com.bytedance.android.monitor.entity.ContainerCommon;
import com.bytedance.android.monitor.entity.ContainerInfo;
import com.bytedance.android.monitor.executor.MonitorExecutor;
import com.bytedance.android.monitor.logger.MonitorLog;
import com.bytedance.android.monitor.standard.ContainerDataCache;
import com.bytedance.android.monitor.util.JsonUtils;
import com.bytedance.android.monitor.webview.base.IBusinessCustom;
import com.bytedance.android.monitor.webview.cache.base.WebBaseReportData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class WebviewCache {
    private static final String TAG = "WebviewCache";
    private Map<WebView, String> urlMap = new WeakHashMap();
    private Map<WebView, Long> loadUrlMap = new WeakHashMap();
    private Map<WebView, Boolean> reuseMap = new WeakHashMap();
    private Map<WebView, Long> createMap = new WeakHashMap();
    private Map<WebView, Long> attachMap = new WeakHashMap();
    private Map<WebView, Long> detachMap = new WeakHashMap();
    private Map<WebView, Boolean> destoryMap = new WeakHashMap();
    private Map<WebView, Boolean> reportMap = new WeakHashMap();
    private Map<WebView, Map<String, Integer>> eventMap = new WeakHashMap();
    private Map<WebView, List<IBusinessCustom.IDataCallback>> dataCallbackMap = new WeakHashMap();

    public void handleViewCreate(WebView webView) {
        this.createMap.put(webView, Long.valueOf(System.currentTimeMillis()));
        MonitorLog.m6d(TAG, "handleViewCreate: " + webView);
    }

    public void setReportState(WebView webView, boolean z) {
        this.reportMap.put(webView, Boolean.valueOf(z));
    }

    public boolean hasReport(WebView webView) {
        Boolean bool = this.reportMap.get(webView);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public void handleViewAttach(WebView webView) {
        this.attachMap.put(webView, Long.valueOf(System.currentTimeMillis()));
        MonitorLog.m6d(TAG, "handleViewAttach: " + webView);
    }

    public void handleViewDetach(WebView webView) {
        this.detachMap.put(webView, Long.valueOf(System.currentTimeMillis()));
        MonitorLog.m6d(TAG, "handleViewDetach: " + webView);
    }

    public Map<WebView, Long> getLoadUrlMap() {
        return this.loadUrlMap;
    }

    public long getLoadUrlTime(WebView webView) {
        Long l = this.loadUrlMap.get(webView);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    public boolean isContainerReuse(WebView webView) {
        Boolean bool = this.reuseMap.get(webView);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public void handleLoadUrl(WebView webView, String str) {
        if (this.loadUrlMap.get(webView) != null) {
            this.reuseMap.put(webView, true);
        }
        this.loadUrlMap.put(webView, Long.valueOf(System.currentTimeMillis()));
        this.urlMap.put(webView, str);
        MonitorLog.m6d(TAG, "handleLoadUrl: " + webView);
    }

    public String getLoadUrl(WebView webView) {
        return this.urlMap.get(webView);
    }

    public void handleWebviewDestory(WebView webView) {
        this.destoryMap.put(webView, true);
    }

    public boolean isWebviewDestoryed(WebView webView) {
        Boolean bool = this.destoryMap.get(webView);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public Map<String, Integer> pollEventMap(WebView webView) {
        return this.eventMap.remove(webView);
    }

    public void putEventMap(WebView webView, String str, int i) {
        Map<String, Integer> map = this.eventMap.get(webView);
        if (map == null) {
            map = new HashMap<>();
            this.eventMap.put(webView, map);
        }
        map.put(str, Integer.valueOf(i));
    }

    public JSONObject generateNativeCommon(WebView webView) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.safePut(jSONObject, "attach_ts", this.attachMap.get(webView));
        JsonUtils.safePut(jSONObject, "detach_ts", this.detachMap.get(webView));
        JsonUtils.safePut(jSONObject, "container_init_ts", this.createMap.get(webView));
        JsonUtils.safePut(jSONObject, "container_reuse", Boolean.valueOf(isContainerReuse(webView)));
        return jSONObject;
    }

    public void registerDataCallback(WebView webView, IBusinessCustom.IDataCallback iDataCallback) {
        List<IBusinessCustom.IDataCallback> list = this.dataCallbackMap.get(webView);
        if (list == null) {
            list = new CopyOnWriteArrayList<>();
            this.dataCallbackMap.put(webView, list);
        }
        list.add(iDataCallback);
    }

    public void notifyPerf(final WebView webView, final WebBaseReportData webBaseReportData) {
        MonitorExecutor.INSTANCE.submit(new Runnable() { // from class: com.bytedance.android.monitor.webview.WebviewCache.1
            @Override // java.lang.Runnable
            public void run() {
                List<IBusinessCustom.IDataCallback> list = (List) WebviewCache.this.dataCallbackMap.get(webView);
                if (list != null) {
                    for (IBusinessCustom.IDataCallback iDataCallback : list) {
                        if (iDataCallback != null) {
                            iDataCallback.onPerfReported(webBaseReportData);
                        }
                    }
                }
            }
        });
    }

    public ContainerCommon getContainerBase(WebView webView) {
        return ContainerDataCache.INSTANCE.getContainerCommonByView(webView);
    }

    public ContainerInfo getContainerInfo(WebView webView) {
        return ContainerDataCache.INSTANCE.getContainerInfoByView(webView);
    }
}
