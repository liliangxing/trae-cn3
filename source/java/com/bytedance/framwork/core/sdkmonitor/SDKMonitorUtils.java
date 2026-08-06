package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.frameworks.core.sdkmonitor.BuildConfig;
import com.bytedance.framwork.core.sdklib.apm6.safety.CustomExceptionHelper;
import com.bytedance.framwork.core.sdklib.util.ListUtils;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.services.apm.api.IHttpService;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class SDKMonitorUtils {
    public static ConcurrentHashMap<String, SDKMonitor> sAidToMonitorCommon = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, List<String>> sAidToDefaultReportUrl = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, List<String>> sAidToConfigUrl = new ConcurrentHashMap<>();
    private static final Object[] LOCKS = new Object[16];

    public static String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    static {
        int i = 0;
        while (true) {
            Object[] objArr = LOCKS;
            if (i >= objArr.length) {
                return;
            }
            objArr[i] = new Object();
            i++;
        }
    }

    public static void setConfigUrl(String str, List<String> list) {
        if (TextUtils.isEmpty(str) || ListUtils.isEmpty(list)) {
            return;
        }
        int hashCode = str.hashCode();
        Object[] objArr = LOCKS;
        synchronized (objArr[hashCode % objArr.length]) {
            try {
                CustomExceptionHelper.setHost("https://" + new URL(list.get(0)).getHost());
            } catch (Exception unused) {
            }
            LinkedList linkedList = new LinkedList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                try {
                    linkedList.add(("https://" + new URL(it.next()).getHost()) + MonitorConstants.SETTING_V5_PATH);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            sAidToConfigUrl.put(str, linkedList);
        }
    }

    @Deprecated
    public static void setDeafultReportUrl(String str, List<String> list) {
        if (TextUtils.isEmpty(str) || ListUtils.isEmpty(list)) {
            return;
        }
        int hashCode = str.hashCode();
        Object[] objArr = LOCKS;
        synchronized (objArr[hashCode % objArr.length]) {
            sAidToDefaultReportUrl.put(str, convertReportUrl(list));
        }
    }

    public static void setDefaultReportUrl(String str, List<String> list) {
        if (TextUtils.isEmpty(str) || ListUtils.isEmpty(list)) {
            return;
        }
        int hashCode = str.hashCode();
        Object[] objArr = LOCKS;
        synchronized (objArr[hashCode % objArr.length]) {
            sAidToDefaultReportUrl.put(str, convertReportUrl(list));
            try {
                CustomExceptionHelper.setHost("https://" + new URL(list.get(0)).getHost());
            } catch (Exception unused) {
            }
        }
    }

    public static List<String> convertReportUrl(List<String> list) {
        LinkedList linkedList = new LinkedList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            try {
                linkedList.add(("https://" + new URL(it.next()).getHost()) + MonitorConstants.COLLECT_PATH);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return linkedList;
    }

    @Deprecated
    public static void init(Context context, String str, JSONObject jSONObject, SDKMonitor.IGetCommonParams iGetCommonParams) {
        if (context == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("param 'aid' is not allowed to assigned empty string");
        }
        if (jSONObject == null) {
            throw new IllegalArgumentException("param 'headerInfo' is not allowed to be null");
        }
        int hashCode = str.hashCode();
        Object[] objArr = LOCKS;
        synchronized (objArr[hashCode % objArr.length]) {
            if (sAidToMonitorCommon.get(str) == null || !sAidToMonitorCommon.get(str).isHasInit()) {
                SDKMonitor sDKMonitor = sAidToMonitorCommon.get(str);
                if (sDKMonitor == null) {
                    sDKMonitor = new SDKMonitor(str);
                    sAidToMonitorCommon.put(str, sDKMonitor);
                }
                sDKMonitor.resetConfigUrls(sAidToConfigUrl.remove(str));
                sDKMonitor.resetReportUrls(sAidToDefaultReportUrl.remove(str));
                sDKMonitor.init(context, jSONObject, iGetCommonParams);
            }
        }
    }

    public static void initMonitor(Context context, String str, JSONObject jSONObject, SDKMonitor.IGetExtendParams iGetExtendParams) {
        if (context == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("param 'aid' is not allowed to assigned empty string");
        }
        if (jSONObject == null) {
            throw new IllegalArgumentException("param 'headerInfo' is not allowed to be null");
        }
        int hashCode = str.hashCode();
        Object[] objArr = LOCKS;
        synchronized (objArr[hashCode % objArr.length]) {
            if (sAidToMonitorCommon.get(str) == null || !sAidToMonitorCommon.get(str).isHasInit()) {
                SDKMonitor sDKMonitor = sAidToMonitorCommon.get(str);
                if (sDKMonitor == null) {
                    sDKMonitor = new SDKMonitor(str);
                    sAidToMonitorCommon.put(str, sDKMonitor);
                }
                sDKMonitor.resetConfigUrls(sAidToConfigUrl.remove(str));
                sDKMonitor.resetReportUrls(sAidToDefaultReportUrl.remove(str));
                sDKMonitor.init(context, jSONObject, iGetExtendParams);
            }
        }
    }

    public static SDKMonitor getInstance(String str) {
        SDKMonitor sDKMonitor;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("param 'aid' is not allowed to assign empty string");
        }
        int hashCode = str.hashCode();
        Object[] objArr = LOCKS;
        synchronized (objArr[hashCode % objArr.length]) {
            sDKMonitor = sAidToMonitorCommon.get(str);
            if (sDKMonitor == null) {
                sDKMonitor = new SDKMonitor(str);
                sAidToMonitorCommon.put(str, sDKMonitor);
            }
        }
        return sDKMonitor;
    }

    public static void setHttpService(IHttpService iHttpService) {
        SDKMonitor.setHttpService(iHttpService);
    }

    public static void setHostAid(String str) {
        SDKMonitor.setHostAid(str);
    }
}
