package com.bytedance.frameworks.baselib.network.http.ok3.impl.metadispatch;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.frameworks.baselib.network.config.hostpathmatch.TTHostPathCondition;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.frameworks.baselib.network.requestaudit.TTRequestAuditManager;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class TTMetaDispatchManager {
    private static volatile TTMetaDispatchManager mInstance;
    private static TTMetaDispatchConfig mTncConfig;
    private static final ReentrantReadWriteLock mTncConfigLock = new ReentrantReadWriteLock();

    private TTMetaDispatchManager() {
    }

    public static TTMetaDispatchManager getInstance() {
        if (mInstance == null) {
            synchronized (TTMetaDispatchManager.class) {
                if (mInstance == null) {
                    mInstance = new TTMetaDispatchManager();
                }
            }
        }
        return mInstance;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String dispatch(String str, Request request, TTMetaDispatchLog tTMetaDispatchLog, List<Header> list) {
        TTMetaDispatchConfig tTMetaDispatchConfig;
        TTMetaDispatchValue value;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ReentrantReadWriteLock reentrantReadWriteLock = mTncConfigLock;
        reentrantReadWriteLock.readLock().lock();
        Pair<String, String> pair = null;
        boolean z = false;
        try {
            tTMetaDispatchConfig = mTncConfig;
        } finally {
            try {
                if (z) {
                }
            } finally {
            }
        }
        if (tTMetaDispatchConfig != null && tTMetaDispatchConfig.isEnabled() && (value = mTncConfig.getValue(str)) != null) {
            List<Header> handleHeader = handleHeader(request, value, tTMetaDispatchLog);
            if (!CollectionUtils.isEmpty(handleHeader)) {
                list.addAll(handleHeader);
            }
            try {
                pair = UrlUtils.parseUrlWithValueList(str, linkedHashMap);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (pair != null) {
                z = handleQuery(linkedHashMap, value, tTMetaDispatchLog);
            }
            return z ? str : TTRequestAuditManager.rebuildURL(str, pair, linkedHashMap);
        }
        reentrantReadWriteLock.readLock().unlock();
        return str;
    }

    private boolean handleQuery(Map<String, List<String>> map, TTMetaDispatchValue tTMetaDispatchValue, TTMetaDispatchLog tTMetaDispatchLog) {
        boolean z = false;
        if (tTMetaDispatchValue != null && tTMetaDispatchLog != null) {
            if (!map.isEmpty() && !CollectionUtils.isEmpty(tTMetaDispatchValue.queryRmSet)) {
                for (String str : tTMetaDispatchValue.queryRmSet) {
                    if (!TextUtils.isEmpty(str) && map.remove(str) != null) {
                        if (tTMetaDispatchLog.queryRm == null) {
                            tTMetaDispatchLog.queryRm = new HashSet();
                        }
                        tTMetaDispatchLog.queryRm.add(str);
                        z = true;
                    }
                }
            }
            if (tTMetaDispatchValue.queryAddMap != null && !tTMetaDispatchValue.queryAddMap.isEmpty()) {
                for (Map.Entry<String, String> entry : tTMetaDispatchValue.queryAddMap.entrySet()) {
                    if (entry != null && !TextUtils.isEmpty(entry.getKey()) && entry.getValue() != null) {
                        String key = entry.getKey();
                        List<String> list = map.get(key);
                        if (list == null) {
                            list = new ArrayList<>();
                            map.put(key, list);
                        }
                        list.add(entry.getValue());
                        if (tTMetaDispatchLog.queryAdd == null) {
                            tTMetaDispatchLog.queryAdd = new HashSet();
                        }
                        tTMetaDispatchLog.queryAdd.add(entry.getKey());
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    private List<Header> handleHeader(Request request, TTMetaDispatchValue tTMetaDispatchValue, TTMetaDispatchLog tTMetaDispatchLog) {
        ArrayList arrayList = null;
        if (request != null && tTMetaDispatchValue != null && tTMetaDispatchLog != null) {
            if (CollectionUtils.isEmpty(tTMetaDispatchValue.headerRmSet) && (tTMetaDispatchValue.headerAddMap == null || tTMetaDispatchValue.headerAddMap.isEmpty())) {
                return null;
            }
            if (request.getHeaders() == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(request.getHeaders());
            }
            if (!CollectionUtils.isEmpty(arrayList) && !CollectionUtils.isEmpty(tTMetaDispatchValue.headerRmSet)) {
                for (String str : tTMetaDispatchValue.headerRmSet) {
                    List headers = request.headers(str);
                    if (headers != null) {
                        arrayList.removeAll(headers);
                        if (tTMetaDispatchLog.headerRm == null) {
                            tTMetaDispatchLog.headerRm = new HashSet();
                        }
                        tTMetaDispatchLog.headerRm.add(str);
                    }
                }
            }
            if (tTMetaDispatchValue.headerAddMap != null && !tTMetaDispatchValue.headerAddMap.isEmpty()) {
                for (Map.Entry<String, String> entry : tTMetaDispatchValue.headerAddMap.entrySet()) {
                    if (entry != null && !TextUtils.isEmpty(entry.getKey()) && entry.getValue() != null) {
                        arrayList.add(new Header(entry.getKey(), entry.getValue()));
                        if (tTMetaDispatchLog.headerAdd == null) {
                            tTMetaDispatchLog.headerAdd = new HashSet();
                        }
                        tTMetaDispatchLog.headerAdd.add(entry.getKey());
                    }
                }
            }
        }
        return arrayList;
    }

    public static void onServerConfigChanged(JSONObject jSONObject) {
        try {
            ReentrantReadWriteLock reentrantReadWriteLock = mTncConfigLock;
            reentrantReadWriteLock.writeLock().lock();
            TTMetaDispatchConfig tTMetaDispatchConfig = new TTMetaDispatchConfig();
            mTncConfig = tTMetaDispatchConfig;
            if (jSONObject != null) {
                if (!tTMetaDispatchConfig.parseTNCConfig(jSONObject)) {
                    mTncConfig.setEnabled(false);
                }
                List<Pair<TTHostPathCondition, TTMetaDispatchValue>> list = mTncConfig.getmRuleList();
                if (list == null || list.isEmpty()) {
                    mTncConfig.setEnabled(false);
                }
                reentrantReadWriteLock.writeLock().unlock();
                return;
            }
            reentrantReadWriteLock.writeLock().unlock();
        } catch (Throwable th) {
            mTncConfigLock.writeLock().unlock();
            throw th;
        }
    }
}
