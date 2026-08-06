package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.redirectdispatch;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.frameworks.baselib.network.config.hostpathmatch.TTHostPathCondition;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.OkHttp3RequestLog;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchActionInfo;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchResult;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatcher;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLRequest;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import okhttp3.HttpUrl;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class TTRedirectDispatchManager {
    private static volatile TTRedirectDispatchManager mInstance;
    private static TTRedirectDispatchConfig mTncConfig;
    private static final ReentrantReadWriteLock mTncConfigLock = new ReentrantReadWriteLock();

    private TTRedirectDispatchManager() {
    }

    public static TTRedirectDispatchManager getInstance() {
        if (mInstance == null) {
            synchronized (TTRedirectDispatchManager.class) {
                if (mInstance == null) {
                    mInstance = new TTRedirectDispatchManager();
                }
            }
        }
        return mInstance;
    }

    public HttpUrl onRedirect(HttpUrl httpUrl, HttpUrl httpUrl2, String str, OkHttp3RequestLog okHttp3RequestLog) {
        ReentrantReadWriteLock.ReadLock readLock;
        String str2;
        ReentrantReadWriteLock reentrantReadWriteLock;
        TTRedirectDispatchConfig tTRedirectDispatchConfig;
        TTRedirectDispatchValue value;
        if (httpUrl == null || TextUtils.isEmpty(httpUrl.host()) || httpUrl2 == null || TextUtils.isEmpty(httpUrl2.host())) {
            return httpUrl2;
        }
        String httpUrl3 = httpUrl.toString();
        try {
            reentrantReadWriteLock = mTncConfigLock;
            reentrantReadWriteLock.readLock().lock();
            tTRedirectDispatchConfig = mTncConfig;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                readLock = mTncConfigLock.readLock();
            } catch (Throwable th2) {
                mTncConfigLock.readLock().unlock();
                throw th2;
            }
        }
        if (tTRedirectDispatchConfig != null && tTRedirectDispatchConfig.isEnabled() && (value = mTncConfig.getValue(httpUrl3)) != null) {
            if (value.enabled) {
                readLock = reentrantReadWriteLock.readLock();
                readLock.unlock();
                HttpUrl httpUrl4 = null;
                try {
                    DispatchResult dispatchResultForUrl = URLDispatcher.inst().getDispatchResultForUrl(new URLRequest(httpUrl2.toString(), str, new ArrayList()));
                    str2 = (dispatchResultForUrl == null || !UrlUtils.isValidUrl(dispatchResultForUrl.mDispatchedURL)) ? null : dispatchResultForUrl.mDispatchedURL;
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
                if (TextUtils.isEmpty(str2) || (httpUrl4 = HttpUrl.parse(str2)) == null) {
                    return httpUrl2;
                }
                if (okHttp3RequestLog != null) {
                    DispatchActionInfo dispatchActionInfo = new DispatchActionInfo();
                    boolean z = true;
                    dispatchActionInfo.mActionHit = true;
                    dispatchActionInfo.mRuleid = 0L;
                    dispatchActionInfo.mPriority = 0;
                    dispatchActionInfo.mStrategyType = 0;
                    dispatchActionInfo.mNeedFeedBack = false;
                    dispatchActionInfo.mDispatchedUrl = httpUrl4.toString();
                    dispatchActionInfo.mServiceName = "redirect_dispatch_" + httpUrl2.host();
                    if (str2.equals(httpUrl2.toString())) {
                        z = false;
                    }
                    okHttp3RequestLog.recordDispatchActionInfo(str, dispatchActionInfo, z);
                }
                return httpUrl4;
            }
        }
        reentrantReadWriteLock.readLock().unlock();
        return httpUrl2;
    }

    public static void onServerConfigChanged(JSONObject jSONObject) {
        try {
            ReentrantReadWriteLock reentrantReadWriteLock = mTncConfigLock;
            reentrantReadWriteLock.writeLock().lock();
            TTRedirectDispatchConfig tTRedirectDispatchConfig = new TTRedirectDispatchConfig();
            mTncConfig = tTRedirectDispatchConfig;
            if (jSONObject != null) {
                if (!tTRedirectDispatchConfig.parseTNCConfig(jSONObject)) {
                    mTncConfig.setEnabled(false);
                }
                List<Pair<TTHostPathCondition, TTRedirectDispatchValue>> list = mTncConfig.getmRuleList();
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
