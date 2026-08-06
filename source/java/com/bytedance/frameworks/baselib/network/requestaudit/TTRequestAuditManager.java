package com.bytedance.frameworks.baselib.network.requestaudit;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.frameworks.baselib.network.requestaudit.TTRequestAuditLog;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class TTRequestAuditManager {
    private static final String REQ_AUDIT_DISABLED_KEY = "req_audit_disabled";
    private static final String TAG = "TTRequestAuditManager";
    private static final AtomicBoolean sRequestAuditDisabled = new AtomicBoolean(false);
    private static final List<Pair<String, TTRequestAuditCallback>> sReqAuditCallbackList = new CopyOnWriteArrayList();

    public static boolean addRequestAuditCallback(String str, TTRequestAuditCallback tTRequestAuditCallback) {
        if (StringUtils.isEmpty(str) || tTRequestAuditCallback == null) {
            return false;
        }
        sReqAuditCallbackList.add(new Pair<>(str, tTRequestAuditCallback));
        return true;
    }

    public static void removeAllRequestAuditCallback() {
        sReqAuditCallbackList.clear();
    }

    public static Request auditAndControl(Request request, BaseHttpRequestInfo baseHttpRequestInfo) {
        if (!sRequestAuditDisabled.get()) {
            List<Pair<String, TTRequestAuditCallback>> list = sReqAuditCallbackList;
            if (!list.isEmpty()) {
                baseHttpRequestInfo.metrics.requestAuditStart();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                HashSet hashSet = new HashSet();
                HashSet hashSet2 = new HashSet();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                Pair<String, String> pair = null;
                TTRequestAuditLog tTRequestAuditLog = null;
                for (Pair<String, TTRequestAuditCallback> pair2 : list) {
                    if (pair2 != null) {
                        String str = (String) pair2.first;
                        TTRequestAuditCallback tTRequestAuditCallback = (TTRequestAuditCallback) pair2.second;
                        if (tTRequestAuditCallback != null && !TextUtils.isEmpty(str)) {
                            try {
                                TTRequestAuditResult onCallToRequestAudit = tTRequestAuditCallback.onCallToRequestAudit(new RequestAuditParams(request.getUrl(), request.getHeaders()));
                                if (onCallToRequestAudit != null) {
                                    TTRequestAuditLog.AuditDetail auditDetail = new TTRequestAuditLog.AuditDetail(str);
                                    handleHeaderResult(onCallToRequestAudit, request, auditDetail, hashSet);
                                    if (!CollectionUtils.isEmpty(onCallToRequestAudit.queryRmKeySet) || (onCallToRequestAudit.queryAddMap != null && !onCallToRequestAudit.queryAddMap.isEmpty())) {
                                        if (pair == null) {
                                            try {
                                                pair = UrlUtils.parseUrlWithValueList(request.getUrl(), linkedHashMap);
                                            } catch (Throwable unused) {
                                            }
                                        }
                                        if (pair != null) {
                                            handleQueryResult(onCallToRequestAudit, linkedHashMap, auditDetail, hashSet2, linkedHashMap2);
                                        }
                                    }
                                    if (!auditDetail.isEmpty()) {
                                        if (tTRequestAuditLog == null) {
                                            tTRequestAuditLog = new TTRequestAuditLog();
                                        }
                                        tTRequestAuditLog.addDetail(auditDetail);
                                    }
                                }
                            } catch (Throwable th) {
                                Log.e(TAG, "onCallToRequestAudit failed, callbackIdentify:" + str, th);
                            }
                        }
                    }
                }
                Request.Builder processHeaderChange = processHeaderChange(request, hashSet);
                if (pair != null) {
                    processHeaderChange = processQueryChange(processHeaderChange, request, pair, linkedHashMap, hashSet2, linkedHashMap2);
                }
                if (processHeaderChange != null) {
                    request = processHeaderChange.build();
                }
                if (tTRequestAuditLog != null) {
                    baseHttpRequestInfo.metrics.setRequestAuditLog(tTRequestAuditLog.toJson());
                }
                baseHttpRequestInfo.metrics.requestAuditEnd();
            }
        }
        return request;
    }

    private static void handleHeaderResult(TTRequestAuditResult tTRequestAuditResult, Request request, TTRequestAuditLog.AuditDetail auditDetail, Set<Header> set) {
        if (CollectionUtils.isEmpty(request.getHeaders()) || CollectionUtils.isEmpty(tTRequestAuditResult.headerRmSet)) {
            return;
        }
        for (String str : tTRequestAuditResult.headerRmSet) {
            if (!TextUtils.isEmpty(str)) {
                List headers = request.headers(str);
                if (!CollectionUtils.isEmpty(headers)) {
                    if (auditDetail.headerRmKeys == null) {
                        auditDetail.headerRmKeys = new HashSet();
                    }
                    auditDetail.headerRmKeys.add(str);
                    set.addAll(headers);
                }
            }
        }
    }

    private static Request.Builder processHeaderChange(Request request, Set<Header> set) {
        ArrayList arrayList;
        if (set.isEmpty()) {
            return null;
        }
        if (request.getHeaders() != null) {
            arrayList = new ArrayList(request.getHeaders());
        } else {
            arrayList = new ArrayList();
        }
        arrayList.removeAll(set);
        Request.Builder newBuilder = request.newBuilder();
        newBuilder.headers(arrayList);
        return newBuilder;
    }

    private static void handleQueryResult(TTRequestAuditResult tTRequestAuditResult, Map<String, List<String>> map, TTRequestAuditLog.AuditDetail auditDetail, Set<String> set, Map<String, List<String>> map2) {
        if (!map.isEmpty() && !CollectionUtils.isEmpty(tTRequestAuditResult.queryRmKeySet)) {
            for (String str : tTRequestAuditResult.queryRmKeySet) {
                if (!TextUtils.isEmpty(str) && map.containsKey(str)) {
                    if (auditDetail.queryRmKeys == null) {
                        auditDetail.queryRmKeys = new HashSet();
                    }
                    auditDetail.queryRmKeys.add(str);
                    set.add(str);
                }
            }
        }
        if (tTRequestAuditResult.queryAddMap == null || tTRequestAuditResult.queryAddMap.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : tTRequestAuditResult.queryAddMap.entrySet()) {
            String key = entry.getKey();
            if (!TextUtils.isEmpty(key) && entry.getValue() != null) {
                List<String> list = map2.get(key);
                if (list == null) {
                    list = new ArrayList<>();
                    map2.put(key, list);
                }
                list.add(entry.getValue());
                if (auditDetail.queryAddKeys == null) {
                    auditDetail.queryAddKeys = new HashSet();
                }
                auditDetail.queryAddKeys.add(key);
            }
        }
    }

    private static Request.Builder processQueryChange(Request.Builder builder, Request request, Pair<String, String> pair, Map<String, List<String>> map, Set<String> set, Map<String, List<String>> map2) {
        boolean z;
        boolean z2 = true;
        if (set.isEmpty()) {
            z = false;
        } else {
            for (String str : set) {
                if (!TextUtils.isEmpty(str)) {
                    map.remove(str);
                }
            }
            z = true;
        }
        if (map2.isEmpty()) {
            z2 = z;
        } else {
            for (Map.Entry<String, List<String>> entry : map2.entrySet()) {
                if (entry != null) {
                    List<String> list = map.get(entry.getKey());
                    if (list == null) {
                        list = new ArrayList<>();
                        map.put(entry.getKey(), list);
                    }
                    list.addAll(entry.getValue());
                }
            }
        }
        if (pair != null && z2) {
            String rebuildURL = rebuildURL(request.getUrl(), pair, map);
            if (!TextUtils.isEmpty(rebuildURL) && !rebuildURL.equals(request.getUrl())) {
                if (builder == null) {
                    builder = request.newBuilder();
                }
                builder.url(rebuildURL);
            }
        }
        return builder;
    }

    public static void onServerConfigChanged(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            resetTncConfig();
            sRequestAuditDisabled.set(jSONObject.optInt(REQ_AUDIT_DISABLED_KEY, 0) > 0);
        } catch (Throwable unused) {
        }
    }

    private static void resetTncConfig() {
        sRequestAuditDisabled.set(false);
    }

    public static String rebuildURL(String str, Pair<String, String> pair, Map<String, List<String>> map) {
        List<String> value;
        if (pair == null) {
            return str;
        }
        try {
            UrlBuilder urlBuilder = new UrlBuilder(((String) pair.first) + ((String) pair.second));
            if (!map.isEmpty()) {
                for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                    if (entry != null && !TextUtils.isEmpty(entry.getKey()) && (value = entry.getValue()) != null && !value.isEmpty()) {
                        Iterator<String> it = value.iterator();
                        while (it.hasNext()) {
                            urlBuilder.addParam(entry.getKey(), it.next());
                        }
                    }
                }
            }
            String build = urlBuilder.build();
            String encodedFragment = Uri.parse(str).getEncodedFragment();
            return !TextUtils.isEmpty(encodedFragment) ? build + "#" + encodedFragment : build;
        } catch (Throwable unused) {
            return str;
        }
    }
}
