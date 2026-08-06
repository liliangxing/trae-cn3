package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.OkHttp3AppMonitor;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.DnsRecord;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.DnsResult;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.HttpDnsUtil;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.IPAddressUtils;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class HttpDns implements WeakHandler.IHandler {
    private static final int CORE_POOL_SIZE = 6;
    public static final String HTTPDNS_HARDCODEIP_SP_KEY = "httpdns_hardcodeips";
    public static final String HTTPDNS_HARDCODEIP_SP_NAME = "dispatchersdk_httpdns_hardcodeips";
    private static final String MSG_CALLBACK_DNSRESULT_JOB_KEY = "callback_dnsresult_job_key";
    public static final String MSG_CALLBACK_DNSRESULT_KEY = "callback_dnsresult_key";
    private static final int MSG_CALLBACK_DNS_RESULT = 1;
    private static final String MSG_DNS_TIMEOUT_JOB_KEY = "dns_timeout_job_key";
    private static final int MSG_HTTPDNS_PREFER_TIMEOUT = 2;
    private static final String MSG_HTTPDNS_PREFER_TIMEOUT_JOB_KEY = "httpdns_timeout_job_key";
    private static final int MSG_HTTPDNS_REQUEST_TIMEOUT = 4;
    private static final int MSG_LOAD_LOCAL_HARDCODEIPS = 5;
    private static final int MSG_LOCALDNS_REQUEST_TIMEOUT = 3;
    private static final int MSG_ON_NETWORK_CHANGED = 6;
    private static final int MSG_ON_RESUME = 7;
    private static String TAG = "HttpDns";
    private static WeakHandler mHttpDnsHandler;
    private static HandlerThread mHttpDnsHandlerThread;
    private static volatile HttpDns mInstance;
    private static String mSdkVersion;
    private static ExecutorService mThreadPool = Executors.newFixedThreadPool(6);
    private final HostResolveManager mHostResolveManager;
    private volatile IHttpDnsDepend mHttpDnsDepend;
    private volatile String mHttpDnsDomain;
    private AtomicBoolean mEnableHttpDns = new AtomicBoolean(true);
    private AtomicBoolean mIsHttpDnsPrefer = new AtomicBoolean(false);
    private ConcurrentSkipListSet<String> mHttpdnsDomainHardCodeIps = new ConcurrentSkipListSet<>();
    private ConcurrentMap<String, CopyOnWriteArrayList<String>> mHardCodeIps = new ConcurrentHashMap();
    private ConcurrentSkipListSet<String> mPreResolveHosts = new ConcurrentSkipListSet<>();
    private AtomicInteger mLocalDnsCacheTTL = new AtomicInteger(30);
    private AtomicInteger mHttpDnsPreferInterval = new AtomicInteger(2000);
    private AtomicInteger mHttpDnsRefreshStaleCacheInterval = new AtomicInteger(60);
    private AtomicInteger mEnableCompareLocalDnsHttpDns = new AtomicInteger(0);
    private AtomicInteger mHttpDnsTimeout = new AtomicInteger(5);
    private AtomicInteger mLocalDnsTimeout = new AtomicInteger(5);
    private final OkHttp3AppMonitor mOkHttp3AppMonitor = new OkHttp3AppMonitor();
    private boolean mHasSetHttpDnsDepend = false;
    private Handler mMainThreadHandler = new Handler(Looper.getMainLooper()) { // from class: com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.HttpDns.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message == null || !(message.obj instanceof HttpDns)) {
                return;
            }
            Bundle data = message.getData();
            DnsResult dnsResult = (DnsResult) data.getSerializable(HttpDns.MSG_CALLBACK_DNSRESULT_KEY);
            HostResolveJob hostResolveJob = (HostResolveJob) data.getSerializable(HttpDns.MSG_CALLBACK_DNSRESULT_JOB_KEY);
            if (hostResolveJob == null) {
                if (Logger.debug()) {
                    Logger.d(HttpDns.TAG, "callback job is null");
                }
            } else {
                if (message.what != 1) {
                    return;
                }
                if (Logger.debug()) {
                    Logger.d(HttpDns.TAG, "callback dns result for host " + hostResolveJob.getHost() + " in thread " + Thread.currentThread().getName());
                }
                hostResolveJob.mHttpDnsCallback.onHttpDnsCompleted(dnsResult);
            }
        }
    };

    public static HttpDns getService() {
        if (mInstance == null) {
            synchronized (HttpDns.class) {
                if (mInstance == null) {
                    mInstance = new HttpDns();
                }
            }
        }
        return mInstance;
    }

    private HttpDns() {
        if (Logger.debug()) {
            Logger.d(TAG, "HttpDns constructor");
        }
        HandlerThread handlerThread = new HandlerThread("TTOK-HTTPDNS");
        mHttpDnsHandlerThread = handlerThread;
        handlerThread.start();
        mHttpDnsHandler = new WeakHandler(mHttpDnsHandlerThread.getLooper(), this);
        mSdkVersion = "4.2.243.6-doubao";
        this.mHostResolveManager = new HostResolveManager(mHttpDnsHandler);
    }

    public void setHttpDnsDepend(IHttpDnsDepend iHttpDnsDepend) {
        if (this.mHasSetHttpDnsDepend) {
            if (Logger.debug()) {
                Logger.d(TAG, "you have set httpdns depend before.");
                return;
            }
            return;
        }
        if (iHttpDnsDepend == null || iHttpDnsDepend.getContext() == null || TextUtils.isEmpty(iHttpDnsDepend.getHttpDnsDomain()) || iHttpDnsDepend.getAppId() == null) {
            this.mHttpDnsDepend = null;
            throw new IllegalArgumentException("you must set correct httpdns depend");
        }
        this.mHttpDnsDepend = iHttpDnsDepend;
        if (TextUtils.isEmpty(this.mHttpDnsDomain)) {
            this.mHttpDnsDomain = iHttpDnsDepend.getHttpDnsDomain();
        }
        this.mHasSetHttpDnsDepend = true;
        submitIpv6Detect();
        this.mOkHttp3AppMonitor.registerAppMonitorListener(iHttpDnsDepend.getContext());
        if (this.mPreResolveHosts.size() < 1) {
            if (this.mHttpDnsDepend.getPreloadDomains() != null && this.mHttpDnsDepend.getPreloadDomains().length > 0 && this.mHttpDnsDepend.getPreloadDomains().length <= 10) {
                this.mPreResolveHosts.addAll(Arrays.asList(this.mHttpDnsDepend.getPreloadDomains()));
                doHttpDnsPreload(DnsRecord.CacheStaleReason.PRELOAD_BATCH);
            } else if (Logger.debug()) {
                Logger.d(TAG, "httpdns preload domains's number must less than 10, httpdns preload is skipped.");
            }
        } else {
            doHttpDnsPreload(DnsRecord.CacheStaleReason.PRELOAD_BATCH);
        }
        Message obtain = Message.obtain();
        obtain.what = 5;
        obtain.obj = this;
        mHttpDnsHandler.sendMessage(obtain);
    }

    public DnsResult getHttpDnsResultForHostSyncBlock(String str) {
        Future<Void> submitLocalDnsResolve;
        DnsResult httpDnsResultForLocalDnsPreferRequest;
        DnsResult lookupLocalDnsCache;
        if (Logger.debug()) {
            Logger.d(TAG, "getHttpDnsResultForHostSyncBlock for host : " + str);
        }
        if (invalidConfigure(str)) {
            return null;
        }
        boolean equals = str.equals(this.mHttpDnsDomain);
        if (this.mIsHttpDnsPrefer.get() && !equals) {
            DnsResult lookupHttpDnsCache = lookupHttpDnsCache(str, false);
            if (lookupHttpDnsCache != null) {
                return lookupHttpDnsCache;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(0, false);
            httpDnsResultForLocalDnsPreferRequest = getDnsResultInHttpDnsPreferTime(submitHttpDnsAndLocalDnsResolve(str, arrayList, true), str, arrayList.get(0).booleanValue());
        } else {
            DnsResult lookupLocalDnsCache2 = lookupLocalDnsCache(str, false);
            if (lookupLocalDnsCache2 != null) {
                return lookupLocalDnsCache2;
            }
            if (this.mHostResolveManager.isLocalDnsResolving(str)) {
                submitLocalDnsResolve = this.mHostResolveManager.getLocalDnsResolvingFuture(str);
            } else {
                submitLocalDnsResolve = submitLocalDnsResolve(str);
            }
            if (submitLocalDnsResolve == null) {
                DnsResult httpDnsResultForLocalDnsPreferRequest2 = getHttpDnsResultForLocalDnsPreferRequest(str, equals);
                return httpDnsResultForLocalDnsPreferRequest2 == null ? getHardCodeIpResult(str) : httpDnsResultForLocalDnsPreferRequest2;
            }
            if (submitLocalDnsResolve.isDone()) {
                lookupLocalDnsCache = lookupLocalDnsCache(str, true);
                if (lookupLocalDnsCache == null) {
                    httpDnsResultForLocalDnsPreferRequest = getHttpDnsResultForLocalDnsPreferRequest(str, equals);
                }
            } else {
                try {
                    submitLocalDnsResolve.get(this.mLocalDnsTimeout.get() * 1000, TimeUnit.MILLISECONDS);
                    lookupLocalDnsCache = lookupLocalDnsCache(str, true);
                    if (lookupLocalDnsCache == null) {
                        httpDnsResultForLocalDnsPreferRequest = getHttpDnsResultForLocalDnsPreferRequest(str, equals);
                    }
                } catch (Exception unused) {
                    httpDnsResultForLocalDnsPreferRequest = getHttpDnsResultForLocalDnsPreferRequest(str, equals);
                }
            }
            httpDnsResultForLocalDnsPreferRequest = lookupLocalDnsCache;
        }
        return httpDnsResultForLocalDnsPreferRequest == null ? getHardCodeIpResult(str) : httpDnsResultForLocalDnsPreferRequest;
    }

    private DnsResult getHardCodeIpResult(String str) {
        if (Logger.debug()) {
            Logger.d(TAG, "try to look up hardcode ips");
        }
        if (!this.mHardCodeIps.containsKey(str)) {
            return null;
        }
        DnsResult dnsResult = new DnsResult();
        Iterator<String> it = this.mHardCodeIps.get(str).iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (IPAddressUtils.isValidIpv6(next)) {
                dnsResult.ipv6List.add(next);
            } else if (IPAddressUtils.isValidIpv4(next)) {
                dnsResult.ipv4List.add(next);
            } else if (Logger.debug()) {
                Logger.d(TAG, "find a invalid hardcode ip: " + next);
            }
        }
        dnsResult.source = DnsResult.Source.HARDCODE_IPS;
        return dnsResult;
    }

    private DnsResult getHttpDnsResultForLocalDnsPreferRequest(String str, boolean z) {
        Future<Void> submitHttpDnsResolve;
        if (z) {
            return null;
        }
        if (this.mHostResolveManager.isHttpDnsResolving(str)) {
            submitHttpDnsResolve = this.mHostResolveManager.getHttpDnsResolvingFuture(str);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            submitHttpDnsResolve = submitHttpDnsResolve(arrayList, DnsRecord.CacheStaleReason.CACHE_UNSET, true);
        }
        if (submitHttpDnsResolve == null) {
            return null;
        }
        if (submitHttpDnsResolve.isDone()) {
            return lookupHttpDnsCache(str, true);
        }
        try {
            submitHttpDnsResolve.get(this.mHttpDnsTimeout.get() * 1000, TimeUnit.MILLISECONDS);
            return lookupHttpDnsCache(str, true);
        } catch (InterruptedException | ExecutionException | TimeoutException unused) {
            return null;
        }
    }

    public DnsResult getHttpDnsResultForHostSyncNonBlock(String str) {
        if (Logger.debug()) {
            Logger.d(TAG, "getHttpDnsResultForHostSyncNonBlock for host : " + str);
        }
        if (invalidConfigure(str)) {
            return null;
        }
        if (isHttpDnsPrefer().get()) {
            DnsResult lookupHttpDnsCache = lookupHttpDnsCache(str, false);
            if (lookupHttpDnsCache != null) {
                return lookupHttpDnsCache;
            }
            if (!this.mHostResolveManager.isHttpDnsResolving(str)) {
                synchronized (this) {
                    if (!this.mHostResolveManager.isHttpDnsResolving(str)) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(str);
                        submitHttpDnsResolve(arrayList, DnsRecord.CacheStaleReason.CACHE_UNSET, false);
                    }
                }
            }
            return lookupLocalDnsCache(str, false);
        }
        DnsResult lookupLocalDnsCache = lookupLocalDnsCache(str, false);
        if (lookupLocalDnsCache != null) {
            return lookupLocalDnsCache;
        }
        if (!this.mHostResolveManager.isLocalDnsResolving(str)) {
            synchronized (this) {
                if (!this.mHostResolveManager.isLocalDnsResolving(str)) {
                    submitLocalDnsResolve(str);
                }
            }
        }
        return lookupHttpDnsCache(str, false);
    }

    public DnsResult getHttpDnsResultForHostAsync(String str, IHttpDnsCallback iHttpDnsCallback) {
        if (Logger.debug()) {
            Logger.d(TAG, "HttpDns::getHttpDnsResultForHostAsync for host " + str);
        }
        if (invalidConfigure(str)) {
            return null;
        }
        if (isHttpDnsPrefer().get()) {
            DnsResult lookupHttpDnsCache = lookupHttpDnsCache(str, false);
            if (lookupHttpDnsCache != null) {
                if (Logger.debug()) {
                    Logger.d(TAG, "returned httpdns cache, wouldn't callback");
                }
                return lookupHttpDnsCache;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(0, false);
            submitHttpDnsAndLocalDnsResolve(str, arrayList, false);
            HostResolveJob hostResolveJob = new HostResolveJob(str, iHttpDnsCallback, arrayList.get(0).booleanValue());
            this.mHostResolveManager.addHttpDnsJob(str, hostResolveJob);
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = this;
            Bundle bundle = new Bundle();
            bundle.putSerializable(MSG_HTTPDNS_PREFER_TIMEOUT_JOB_KEY, hostResolveJob);
            obtain.setData(bundle);
            mHttpDnsHandler.sendMessageDelayed(obtain, this.mHttpDnsPreferInterval.get());
        } else {
            DnsResult lookupLocalDnsCache = lookupLocalDnsCache(str, false);
            if (lookupLocalDnsCache != null) {
                return lookupLocalDnsCache;
            }
            if (!this.mHostResolveManager.isLocalDnsResolving(str)) {
                submitLocalDnsResolve(str);
            }
            HostResolveJob hostResolveJob2 = new HostResolveJob(str, iHttpDnsCallback, true);
            this.mHostResolveManager.addLocalDnsJob(str, hostResolveJob2);
            Message obtain2 = Message.obtain();
            obtain2.what = 3;
            obtain2.obj = this;
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable(MSG_DNS_TIMEOUT_JOB_KEY, hostResolveJob2);
            obtain2.setData(bundle2);
            mHttpDnsHandler.sendMessageDelayed(obtain2, this.mLocalDnsTimeout.get() * 1000);
        }
        return null;
    }

    private boolean invalidConfigure(String str) {
        if (!this.mHasSetHttpDnsDepend) {
            if (Logger.debug()) {
                Logger.d(TAG, "you have not set httpdns depend");
            }
            return true;
        }
        if (!this.mEnableHttpDns.get()) {
            if (Logger.debug()) {
                Logger.d(TAG, "httpdns was unabled by tnc");
            }
            return true;
        }
        if (!HttpDnsUtil.isValidHost(str)) {
            if (Logger.debug()) {
                Logger.d(TAG, "illegal host");
            }
            return true;
        }
        if (!IPAddressUtils.isValidIpv4(str) && !IPAddressUtils.isValidIpv6(str)) {
            return false;
        }
        if (Logger.debug()) {
            Logger.d(TAG, "host is ipaddress");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void doHttpDnsPreload(DnsRecord.CacheStaleReason cacheStaleReason) {
        ConcurrentSkipListSet<String> concurrentSkipListSet;
        if (this.mHttpDnsDepend != null && ProcessUtils.isMainProcessByProcessFlag(this.mHttpDnsDepend.getContext()) && (concurrentSkipListSet = this.mPreResolveHosts) != null && concurrentSkipListSet.size() != 0 && this.mPreResolveHosts.size() <= 10) {
            if (Logger.debug()) {
                Logger.d(TAG, "do httpdns preload");
            }
            Iterator<String> it = this.mPreResolveHosts.iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                String next = it.next();
                if (!this.mHostResolveManager.isHttpDnsResolving(next)) {
                    arrayList.add(next);
                }
            }
            if (arrayList.size() == 0) {
                return;
            }
            if (Logger.debug()) {
                Logger.d(TAG, "httpdns batch preload for : " + arrayList);
            }
            submitHttpDnsResolve(arrayList, cacheStaleReason, false);
        }
    }

    void refreshHttpDnsCache(String str) {
        if (HttpDnsUtil.isValidHost(str) && !this.mHostResolveManager.isHttpDnsResolving(str) && this.mIsHttpDnsPrefer.get()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            submitHttpDnsResolve(arrayList, DnsRecord.CacheStaleReason.CACHE_STALE_EXPIRED, false);
        }
    }

    void removeHttpDnsCache(String str) {
        if (!HttpDnsUtil.isValidHost(str) || this.mHostResolveManager.isHttpDnsResolving(str)) {
            return;
        }
        this.mHostResolveManager.removeHttpDnsCache(str);
    }

    void addHttpDnsStaleCacheHost(String str) {
        this.mHostResolveManager.addHttpDnsStaleCacheHost(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void batchRefreshHttpDnsStaleCache(List<String> list) {
        if (Logger.debug()) {
            Logger.d(TAG, "batchRefreshHttpDnsStaleCache for host " + list);
        }
        submitHttpDnsResolve(list, DnsRecord.CacheStaleReason.REFRESH_BATCH, false);
    }

    void removeLocalDnsStaleCache(String str) {
        if (Logger.debug()) {
            Logger.d(TAG, "removeLocalDnsStaleCache");
        }
        if (HttpDnsUtil.isValidHost(str)) {
            this.mHostResolveManager.removeLocalDnsCache(str);
        }
    }

    public void onServerConfigChanged(JSONObject jSONObject) {
        if (Logger.debug()) {
            Logger.d(TAG, "onServerConfigChanged");
        }
        if (this.mHttpDnsDepend == null || jSONObject == null) {
            return;
        }
        int optInt = jSONObject.optInt("ttnet_http_dns_enabled", -1);
        if (optInt >= 0) {
            this.mEnableHttpDns.set(optInt == 1);
        }
        String optString = jSONObject.optString("ttnet_tt_http_dns_domain");
        if (!TextUtils.isEmpty(optString)) {
            this.mHttpDnsDomain = optString;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("ttnet_tt_http_dns_preload_batch_host");
        if (optJSONArray != null) {
            this.mPreResolveHosts.clear();
            for (int i = 0; i < optJSONArray.length(); i++) {
                String optString2 = optJSONArray.optString(i);
                if (!TextUtils.isEmpty(optString2)) {
                    this.mPreResolveHosts.add(optString2);
                }
            }
        }
        int optInt2 = jSONObject.optInt("localdns_cache_ttl", -1);
        if (optInt2 >= 0) {
            this.mLocalDnsCacheTTL.set(optInt2);
        }
        int optInt3 = jSONObject.optInt("httpdns_prefer_time_ms", -1);
        if (optInt3 >= 0) {
            this.mHttpDnsPreferInterval.set(optInt3);
        }
        int optInt4 = jSONObject.optInt("httpdns_stale_cache_interval", -1);
        if (optInt4 >= 0) {
            this.mHttpDnsRefreshStaleCacheInterval.set(optInt4);
        }
        int optInt5 = jSONObject.optInt("enable_compare_localdns_httpdns", -1);
        if (optInt5 >= 0) {
            this.mEnableCompareLocalDnsHttpDns.set(optInt5);
        }
        int optInt6 = jSONObject.optInt("ttnet_http_dns_prefer", -1);
        if (optInt6 >= 0) {
            this.mIsHttpDnsPrefer.set(optInt6 == 1);
        }
        int optInt7 = jSONObject.optInt("ttnet_http_dns_timeout", -1);
        if (optInt7 >= 0) {
            this.mHttpDnsTimeout.set(optInt7);
        }
        int optInt8 = jSONObject.optInt("ttnet_local_dns_time_out", -1);
        if (optInt8 >= 0) {
            this.mLocalDnsTimeout.set(optInt8);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("ttnet_http_dns_addr");
        if (optJSONObject != null) {
            this.mHardCodeIps.clear();
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String optString3 = optJSONObject.optString(next);
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString3)) {
                    String[] split = optString3.split(",");
                    if (next.equals(this.mHttpDnsDomain)) {
                        this.mHttpdnsDomainHardCodeIps.clear();
                        this.mHttpdnsDomainHardCodeIps.addAll(Arrays.asList(split));
                    } else {
                        this.mHardCodeIps.put(next, new CopyOnWriteArrayList<>(Arrays.asList(split)));
                    }
                }
            }
        }
    }

    private Future<Void> submitHttpDnsAndLocalDnsResolve(String str, List<Boolean> list, boolean z) {
        Future<Void> submitHttpDnsResolve;
        DnsRecord localDnsCache = this.mHostResolveManager.getLocalDnsCache(str);
        if (localDnsCache == null || localDnsCache.getFetchTime() + (localDnsCache.getTTL() * 1000) <= System.currentTimeMillis() + this.mHttpDnsPreferInterval.get()) {
            list.set(0, true);
            if (!this.mHostResolveManager.isLocalDnsResolving(str)) {
                submitLocalDnsResolve(str);
            }
        }
        if (this.mHostResolveManager.isHttpDnsResolving(str)) {
            if (Logger.debug()) {
                Logger.d(TAG, "httpdns is resolving for host " + str);
            }
            return this.mHostResolveManager.getHttpDnsResolvingFuture(str);
        }
        synchronized (this) {
            if (this.mHostResolveManager.isHttpDnsResolving(str)) {
                submitHttpDnsResolve = this.mHostResolveManager.getHttpDnsResolvingFuture(str);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                submitHttpDnsResolve = submitHttpDnsResolve(arrayList, DnsRecord.CacheStaleReason.CACHE_UNSET, z);
            }
        }
        return submitHttpDnsResolve;
    }

    synchronized Future<Void> submitHttpDnsResolve(List<String> list, DnsRecord.CacheStaleReason cacheStaleReason, boolean z) {
        Future<Void> future = null;
        if (list != null) {
            if (list.size() != 0) {
                for (int i = 0; i < list.size(); i++) {
                    if (this.mHostResolveManager.isHttpDnsResolving(list.get(i))) {
                        if (z && list.size() == 1 && i == 0) {
                            future = this.mHostResolveManager.getHttpDnsResolvingFuture(list.get(i));
                            if (Logger.debug()) {
                                Logger.d(TAG, "sync block request for " + list.get(i) + " is resolving");
                            }
                        }
                        list.remove(list.get(i));
                    }
                }
                if (list.size() == 0) {
                    return future;
                }
                if (Logger.debug()) {
                    Logger.d(TAG, "submit httpdns resolve for host : " + list);
                }
                try {
                    future = mThreadPool.submit(new HttpDnsResolveCall(HttpDnsUtil.transHostList2String(list), mSdkVersion, this.mHostResolveManager, cacheStaleReason, mHttpDnsHandler));
                    for (String str : list) {
                        this.mHostResolveManager.addHttpDnsResolvingFuture(str, future);
                        if (this.mIsHttpDnsPrefer.get()) {
                            this.mHostResolveManager.removeHttpDnsStaleCacheHost(str);
                        }
                    }
                } catch (RejectedExecutionException e) {
                    e.printStackTrace();
                    if (Logger.debug()) {
                        Logger.d(TAG, "submit httpdns resolve for host : " + list + " was rejected");
                    }
                }
                return future;
            }
        }
        if (Logger.debug()) {
            Logger.d(TAG, "httpdns resolve hostlist is null.");
        }
        return null;
    }

    private synchronized Future<Void> submitLocalDnsResolve(String str) {
        if (this.mHostResolveManager.isLocalDnsResolving(str)) {
            if (Logger.debug()) {
                Logger.d(TAG, "localdns is resolving for host : " + str);
            }
            return this.mHostResolveManager.getLocalDnsResolvingFuture(str);
        }
        if (Logger.debug()) {
            Logger.d(TAG, "submit localdns resolve host : " + str);
        }
        Future<Void> future = null;
        try {
            future = mThreadPool.submit(new LocalDnsResolveCall(str, this.mHostResolveManager, mHttpDnsHandler));
            this.mHostResolveManager.addLocalDnsResolvingFuture(str, future);
        } catch (RejectedExecutionException e) {
            e.printStackTrace();
        }
        return future;
    }

    private DnsResult getDnsResultInHttpDnsPreferTime(Future<Void> future, String str, boolean z) {
        if (Logger.debug()) {
            Logger.d(TAG, "getDnsResultInHttpDnsPreferTime");
        }
        try {
            if (future == null) {
                if (Logger.debug()) {
                    Logger.d(TAG, "httpdns future is null");
                }
                return lookupLocalDnsCache(str, z);
            }
            if (future.isDone()) {
                if (Logger.debug()) {
                    Logger.d(TAG, "httpdns future is done");
                }
                DnsResult lookupHttpDnsCache = lookupHttpDnsCache(str, true);
                return lookupHttpDnsCache == null ? lookupLocalDnsCache(str, z) : lookupHttpDnsCache;
            }
            future.get(getService().getHttpDnsPreferInterval().get(), TimeUnit.MILLISECONDS);
            DnsResult lookupHttpDnsCache2 = lookupHttpDnsCache(str, true);
            return lookupHttpDnsCache2 == null ? lookupLocalDnsCache(str, z) : lookupHttpDnsCache2;
        } catch (InterruptedException unused) {
            if (Logger.debug()) {
                Logger.d(TAG, "httpdns InterruptedException, look up localdns");
            }
            return lookupLocalDnsCache(str, z);
        } catch (ExecutionException unused2) {
            if (Logger.debug()) {
                Logger.d(TAG, "httpdns ExecutionException, look up localdns");
            }
            return lookupLocalDnsCache(str, z);
        } catch (TimeoutException unused3) {
            if (Logger.debug()) {
                Logger.d(TAG, "httpdns timeout in httpdns prefer time, look up localdns");
            }
            return lookupLocalDnsCache(str, z);
        }
    }

    private DnsResult lookupLocalDnsCache(String str, boolean z) {
        if (Logger.debug()) {
            Logger.d(TAG, "lookup localdns cache for host " + str);
        }
        DnsResult dnsResult = new DnsResult();
        DnsRecord localDnsCache = this.mHostResolveManager.getLocalDnsCache(str);
        if (localDnsCache == null) {
            return null;
        }
        dnsResult.ipv4List = localDnsCache.getIpv4List();
        dnsResult.ipv6List = localDnsCache.getIpv6List();
        if (z) {
            dnsResult.source = DnsResult.Source.LOCALDNS_REQUEST;
        } else {
            dnsResult.source = DnsResult.Source.LOCALDNS_CACHE;
        }
        return dnsResult;
    }

    private DnsResult lookupHttpDnsCache(String str, boolean z) {
        if (Logger.debug()) {
            Logger.d(TAG, "look up httpdns cache for host " + str);
        }
        DnsRecord httpDnsCache = this.mHostResolveManager.getHttpDnsCache(str);
        if (httpDnsCache == null) {
            return null;
        }
        DnsResult dnsResult = new DnsResult();
        dnsResult.ipv4List = httpDnsCache.getIpv4List();
        dnsResult.ipv6List = httpDnsCache.getIpv6List();
        if (z) {
            if ((httpDnsCache.getTTL() * 1000) + httpDnsCache.getFetchTime() <= System.currentTimeMillis()) {
                return null;
            }
            dnsResult.source = DnsResult.Source.HTTPDNS_REQUEST;
            return dnsResult;
        }
        if ((httpDnsCache.getTTL() * 1000) + httpDnsCache.getFetchTime() > System.currentTimeMillis()) {
            dnsResult.source = DnsResult.Source.HTTPDNS_CACHE;
        } else {
            dnsResult.source = DnsResult.Source.HTTPDNS_STALE_CACHE;
        }
        return dnsResult;
    }

    public void handleMsg(Message message) {
        if (Logger.debug()) {
            Logger.d(TAG, "httpdns handler handle msg in " + Thread.currentThread().getName());
        }
        if (message != null) {
            if ((message.obj instanceof HttpDns) || (message.obj instanceof HttpDnsResolveCall) || (message.obj instanceof LocalDnsResolveCall) || (message.obj instanceof DnsRecord) || (message.obj instanceof HostResolveManager)) {
                try {
                    if ((message.obj instanceof HttpDns) && message.what == 2) {
                        if (Logger.debug()) {
                            Logger.d(TAG, "MSG_HTTPDNS_PREFER_TIMEOUT");
                        }
                        HostResolveJob hostResolveJob = (HostResolveJob) message.getData().getSerializable(MSG_HTTPDNS_PREFER_TIMEOUT_JOB_KEY);
                        if (hostResolveJob == null) {
                            if (Logger.debug()) {
                                Logger.d(TAG, "MSG_HTTPDNS_PREFER_TIMEOUT job is null");
                                return;
                            }
                            return;
                        } else {
                            if (this.mHostResolveManager.shouldHttpDnsTimeoutCallback(hostResolveJob)) {
                                if (Logger.debug()) {
                                    Logger.d(TAG, "httpdns request not return in httpdns prefer time for host : " + hostResolveJob.getHost());
                                }
                                callbackDnsResultInMainthread(hostResolveJob, lookupLocalDnsCache(hostResolveJob.getHost(), hostResolveJob.isLocalDnsExpired()));
                                this.mHostResolveManager.removeHttpDnsJob(hostResolveJob);
                                return;
                            }
                            return;
                        }
                    }
                    if ((message.obj instanceof HttpDnsResolveCall) && message.what == 3) {
                        if (Logger.debug()) {
                            Logger.d(TAG, "MSG_HTTPDNS_COMPLETED");
                        }
                        ArrayList<String> stringArrayList = message.getData().getStringArrayList(HttpDnsResolveCall.MSG_HTTPDDNS_COMPLETED_HOSTS_KEY);
                        if (stringArrayList == null) {
                            if (Logger.debug()) {
                                Logger.d(TAG, "MSG_HTTPDNS_COMPLETED hostlist is null");
                                return;
                            }
                            return;
                        }
                        for (String str : stringArrayList) {
                            if (this.mHostResolveManager.shouldHttpDnsCallback(str)) {
                                if (Logger.debug()) {
                                    Logger.d(TAG, "httpdns returned in httpdns prefer time for host : " + stringArrayList);
                                }
                                Iterator<HostResolveJob> it = this.mHostResolveManager.getHttpDnsJobs(str).iterator();
                                while (it.hasNext()) {
                                    HostResolveJob next = it.next();
                                    DnsResult lookupHttpDnsCache = lookupHttpDnsCache(str, true);
                                    if (getService().isHttpDnsPrefer().get() && lookupHttpDnsCache == null) {
                                        lookupHttpDnsCache = lookupLocalDnsCache(str, next.isLocalDnsExpired());
                                    }
                                    if (Logger.debug()) {
                                        Logger.d(TAG, "httpdns request is returned in prefer time for " + str);
                                    }
                                    callbackDnsResultInMainthread(next, lookupHttpDnsCache);
                                    this.mHostResolveManager.removeHttpDnsJob(next);
                                }
                            }
                        }
                        return;
                    }
                    if ((message.obj instanceof LocalDnsResolveCall) && message.what == 1) {
                        if (Logger.debug()) {
                            Logger.d(TAG, "MSG_LOCALDNS_COMPLETED");
                        }
                        String string = message.getData().getString(LocalDnsResolveCall.MSG_LOCALDNS_COMPLETED_HOST_KEY);
                        if (string == null) {
                            if (Logger.debug()) {
                                Logger.d(TAG, "MSG_HTTPDNS_COMPLETED host is null");
                                return;
                            }
                            return;
                        }
                        if (this.mHostResolveManager.shouldLocalDnsCallback(string)) {
                            if (Logger.debug()) {
                                Logger.d(TAG, "localdns returned in localdns timeout for host : " + string);
                            }
                            Iterator<HostResolveJob> it2 = this.mHostResolveManager.getLocalDnsJobs(string).iterator();
                            while (it2.hasNext()) {
                                HostResolveJob next2 = it2.next();
                                DnsResult lookupLocalDnsCache = lookupLocalDnsCache(string, true);
                                if (lookupLocalDnsCache == null) {
                                    DnsResult lookupHttpDnsCache2 = lookupHttpDnsCache(string, false);
                                    if (lookupHttpDnsCache2 == null) {
                                        submitHttpDnsTaskForLocalDnsPreferReq(next2);
                                        this.mHostResolveManager.addHttpDnsJob(next2.getHost(), next2);
                                    } else {
                                        callbackDnsResultInMainthread(next2, lookupHttpDnsCache2);
                                    }
                                } else {
                                    if (Logger.debug()) {
                                        Logger.d(TAG, "localdns request is returned in timeout for " + string);
                                    }
                                    callbackDnsResultInMainthread(next2, lookupLocalDnsCache);
                                }
                                this.mHostResolveManager.removeLocalDnsJob(next2);
                            }
                            return;
                        }
                        return;
                    }
                    if ((message.obj instanceof HttpDns) && message.what == 3) {
                        if (Logger.debug()) {
                            Logger.d(TAG, "MSG_LOCALDNS_REQUEST_TIMEOUT");
                        }
                        HostResolveJob hostResolveJob2 = (HostResolveJob) message.getData().getSerializable(MSG_DNS_TIMEOUT_JOB_KEY);
                        if (hostResolveJob2 == null) {
                            if (Logger.debug()) {
                                Logger.d(TAG, "MSG_HTTPDNS_PREFER_TIMEOUT job is null");
                                return;
                            }
                            return;
                        } else {
                            if (this.mHostResolveManager.shouldLocalDnsTimeoutCallback(hostResolveJob2)) {
                                if (Logger.debug()) {
                                    Logger.d(TAG, "local request not return in localdns timeout for host : " + hostResolveJob2.getHost());
                                }
                                DnsResult lookupHttpDnsCache3 = lookupHttpDnsCache(hostResolveJob2.getHost(), false);
                                if (lookupHttpDnsCache3 != null) {
                                    callbackDnsResultInMainthread(hostResolveJob2, lookupHttpDnsCache3);
                                } else {
                                    if (!this.mHostResolveManager.isHttpDnsResolving(hostResolveJob2.getHost())) {
                                        submitHttpDnsTaskForLocalDnsPreferReq(hostResolveJob2);
                                    }
                                    this.mHostResolveManager.addHttpDnsJob(hostResolveJob2.getHost(), hostResolveJob2);
                                }
                                this.mHostResolveManager.removeLocalDnsJob(hostResolveJob2);
                                return;
                            }
                            return;
                        }
                    }
                    if ((message.obj instanceof HttpDns) && message.what == 4) {
                        if (Logger.debug()) {
                            Logger.d(TAG, "MSG_HTTPDNS_REQUEST_TIMEOUT");
                        }
                        HostResolveJob hostResolveJob3 = (HostResolveJob) message.getData().getSerializable(MSG_DNS_TIMEOUT_JOB_KEY);
                        if (hostResolveJob3 == null) {
                            if (Logger.debug()) {
                                Logger.d(TAG, "MSG_HTTPDNS_PREFER_TIMEOUT job is null");
                                return;
                            }
                            return;
                        } else {
                            if (this.mHostResolveManager.shouldHttpDnsTimeoutCallback(hostResolveJob3)) {
                                callbackDnsResultInMainthread(hostResolveJob3, null);
                                this.mHostResolveManager.removeHttpDnsJob(hostResolveJob3);
                                return;
                            }
                            return;
                        }
                    }
                    if ((message.obj instanceof HttpDns) && message.what == 5) {
                        if (Logger.debug()) {
                            Logger.d(TAG, "MSG_LOAD_LOCAL_HARDCODEIPS");
                        }
                        String string2 = this.mHttpDnsDepend.getContext().getSharedPreferences(HTTPDNS_HARDCODEIP_SP_NAME, 0).getString(HTTPDNS_HARDCODEIP_SP_KEY, "");
                        if (!TextUtils.isEmpty(string2)) {
                            this.mHttpdnsDomainHardCodeIps.clear();
                            try {
                                JSONArray jSONArray = new JSONArray(string2);
                                for (int i = 0; i < jSONArray.length(); i++) {
                                    String optString = jSONArray.optString(i);
                                    if (!TextUtils.isEmpty(optString)) {
                                        this.mHttpdnsDomainHardCodeIps.add(optString);
                                    }
                                }
                                return;
                            } catch (JSONException unused) {
                                if (Logger.debug()) {
                                    Logger.d(TAG, "local httpdns hardcode ips not exists, use default");
                                    return;
                                }
                                return;
                            }
                        }
                        if (this.mHttpDnsDepend.getHardCodeIps() == null || this.mHttpdnsDomainHardCodeIps.size() != 0) {
                            return;
                        }
                        this.mHttpdnsDomainHardCodeIps.addAll(Arrays.asList(this.mHttpDnsDepend.getHardCodeIps()));
                        return;
                    }
                    if ((message.obj instanceof HttpDns) && message.what == 6) {
                        if (Logger.debug()) {
                            Logger.d(TAG, "network changed");
                        }
                        this.mHostResolveManager.onNetworkChanged(getService().getHttpDnsDepend().getContext());
                        return;
                    }
                    if ((message.obj instanceof HttpDns) && message.what == 7) {
                        if (Logger.debug()) {
                            Logger.d(TAG, "activity resume, detect ipv6 reachable");
                        }
                        submitIpv6Detect();
                        return;
                    }
                    if (message.obj instanceof DnsRecord) {
                        String string3 = message.getData().getString(DnsRecord.MSG_DNSRECORD_HOST);
                        if (TextUtils.isEmpty(string3)) {
                            if (Logger.debug()) {
                                Logger.d(TAG, "DnsRecord refresh host is null");
                                return;
                            }
                            return;
                        }
                        switch (message.what) {
                            case 10:
                                if (Logger.debug()) {
                                    Logger.d(TAG, "refresh httpdns cache for host : " + string3);
                                }
                                getService().refreshHttpDnsCache(string3);
                                return;
                            case 11:
                                if (Logger.debug()) {
                                    Logger.d(TAG, "remove localdns cache for host : " + string3);
                                }
                                getService().removeLocalDnsStaleCache(string3);
                                return;
                            case 12:
                                if (Logger.debug()) {
                                    Logger.d(TAG, "add host : " + string3 + " to stale cache host list");
                                }
                                getService().addHttpDnsStaleCacheHost(string3);
                                return;
                            case 13:
                                if (Logger.debug()) {
                                    Logger.d(TAG, "remove httpdns cache for host : " + string3);
                                }
                                getService().removeHttpDnsCache(string3);
                                return;
                            default:
                                return;
                        }
                    }
                    if ((message.obj instanceof HostResolveManager) && message.what == 20) {
                        if (Logger.debug()) {
                            Logger.d(TAG, "reset httpdns domain failed count");
                        }
                        this.mHostResolveManager.resetHttpDnsDomainFailedCnt();
                    } else if (Logger.debug()) {
                        Logger.d(TAG, "HTTPDNS-CollectResult handler thread receive a unknown message : " + message);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    private void submitHttpDnsTaskForLocalDnsPreferReq(HostResolveJob hostResolveJob) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(hostResolveJob.getHost());
        submitHttpDnsResolve(arrayList, DnsRecord.CacheStaleReason.CACHE_UNSET, false);
        Message obtain = Message.obtain();
        obtain.what = 4;
        obtain.obj = this;
        Bundle bundle = new Bundle();
        bundle.putSerializable(MSG_DNS_TIMEOUT_JOB_KEY, hostResolveJob);
        obtain.setData(bundle);
        mHttpDnsHandler.sendMessageDelayed(obtain, this.mHttpDnsTimeout.get() * 1000);
    }

    private void callbackDnsResultInMainthread(HostResolveJob hostResolveJob, DnsResult dnsResult) {
        if (Logger.debug()) {
            Logger.d(TAG, "doDnsResultCallback for host " + hostResolveJob.getHost());
        }
        Message obtain = Message.obtain();
        obtain.obj = this;
        obtain.what = 1;
        Bundle bundle = new Bundle();
        bundle.putSerializable(MSG_CALLBACK_DNSRESULT_JOB_KEY, hostResolveJob);
        bundle.putSerializable(MSG_CALLBACK_DNSRESULT_KEY, dnsResult);
        obtain.setData(bundle);
        this.mMainThreadHandler.sendMessage(obtain);
    }

    AtomicInteger getHttpDnsPreferInterval() {
        return this.mHttpDnsPreferInterval;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AtomicInteger getLocalDnsCacheTTL() {
        return this.mLocalDnsCacheTTL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AtomicInteger getHttpDnsRefreshStaleCacheInterval() {
        return this.mHttpDnsRefreshStaleCacheInterval;
    }

    public IHttpDnsDepend getHttpDnsDepend() {
        return this.mHttpDnsDepend;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getHttpDnsDomain() {
        return this.mHttpDnsDomain;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConcurrentSkipListSet<String> getHttpDnsDomainHardCodeIps() {
        return this.mHttpdnsDomainHardCodeIps;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setHttpDnsHardCodeIps(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.mHttpdnsDomainHardCodeIps.clear();
        for (int i = 0; i < jSONArray.length(); i++) {
            String optString = jSONArray.optString(i);
            if (!TextUtils.isEmpty(optString)) {
                this.mHttpdnsDomainHardCodeIps.add(optString);
            }
        }
        SharedPreferences.Editor edit = this.mHttpDnsDepend.getContext().getSharedPreferences(HTTPDNS_HARDCODEIP_SP_NAME, 0).edit();
        edit.putString(HTTPDNS_HARDCODEIP_SP_KEY, String.valueOf(jSONArray));
        edit.apply();
    }

    public AtomicBoolean isHttpDnsPrefer() {
        return this.mIsHttpDnsPrefer;
    }

    public void onResume() {
        Message obtain = Message.obtain();
        obtain.obj = this;
        obtain.what = 7;
        mHttpDnsHandler.sendMessage(obtain);
    }

    public void onNetworkChanged() {
        Message obtain = Message.obtain();
        obtain.obj = this;
        obtain.what = 6;
        mHttpDnsHandler.sendMessage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void submitIpv6Detect() {
        try {
            mThreadPool.submit(new Ipv6DetectCall());
        } catch (RejectedExecutionException e) {
            e.printStackTrace();
        }
    }

    public HandlerThread getHttpDnsHandlerThread() {
        return mHttpDnsHandlerThread;
    }
}
