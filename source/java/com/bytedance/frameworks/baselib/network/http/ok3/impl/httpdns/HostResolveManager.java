package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.DnsRecord;
import com.bytedance.frameworks.baselib.network.http.util.LRUCache;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class HostResolveManager {
    public static final int MSG_REMOVE_HTTPDNSDOMAIN_DARKROME = 20;
    private static final String TAG = "HostResolveManager";
    private final Handler mHandler;
    private LRUCache<String, DnsRecord> mHttpDnsCacheMap = new LRUCache<>(100);
    private ConcurrentMap<String, DnsRecord> mLocalDnsCacheMap = new ConcurrentHashMap();
    private ConcurrentMap<String, Future<Void>> mHttpDnsResolvingFutureMap = new ConcurrentHashMap();
    private ConcurrentMap<String, Future<Void>> mLocalDnsResolvingFutureMap = new ConcurrentHashMap();
    private ConcurrentMap<String, ConcurrentSkipListSet<HostResolveJob>> mHttpDnsResolveJobs = new ConcurrentHashMap();
    private ConcurrentMap<String, ConcurrentSkipListSet<HostResolveJob>> mLocalDnsResolveJobs = new ConcurrentHashMap();
    private ConcurrentSkipListSet<String> mHttpDnsStaleCacheHosts = new ConcurrentSkipListSet<>();
    private AtomicInteger mDetectedHardCodeipsCnt = new AtomicInteger(0);
    private AtomicInteger mHttpDnsDomainFailedCnt = new AtomicInteger(0);
    private NetworkUtils.NetworkType mLastNetType = NetworkUtils.NetworkType.NONE;
    private final long TIME_IN_DARKROOM = 180000;
    private final int BATCH_REFRESH_CNT = 10;

    public HostResolveManager(Handler handler) {
        this.mHandler = handler;
    }

    public void onNetworkChanged(Context context) {
        NetworkUtils.NetworkType networkType = NetworkUtils.getNetworkType(context);
        if (networkType != this.mLastNetType) {
            if (Logger.debug()) {
                Logger.d(TAG, "network changed, clear cache and re-batch-preload preload hosts, current net type is " + networkType);
            }
            synchronized (this.mHttpDnsCacheMap.map()) {
                for (Map.Entry<String, DnsRecord> entry : this.mHttpDnsCacheMap.map().entrySet()) {
                    if (entry != null) {
                        if (HttpDns.getService().isHttpDnsPrefer().get()) {
                            entry.getValue().removeHttpDnsRefreshTask();
                        } else {
                            entry.getValue().removeHttpDnsRemoveTask();
                        }
                    }
                }
                this.mHttpDnsCacheMap.evictAll();
            }
            for (Map.Entry<String, DnsRecord> entry2 : this.mLocalDnsCacheMap.entrySet()) {
                if (entry2 != null) {
                    entry2.getValue().removeLocalDnsRemoveTask();
                }
            }
            this.mLocalDnsCacheMap.clear();
            if (networkType != NetworkUtils.NetworkType.NONE) {
                HttpDns.getService().doHttpDnsPreload(DnsRecord.CacheStaleReason.CACHE_STALE_NETCHANGED);
                HttpDns.getService().submitIpv6Detect();
            }
        }
        this.mLastNetType = networkType;
    }

    public void addHttpDnsCache(String str, DnsRecord dnsRecord) {
        DnsRecord httpDnsCache = getHttpDnsCache(str);
        if (httpDnsCache != null) {
            if (HttpDns.getService().isHttpDnsPrefer().get()) {
                httpDnsCache.removeHttpDnsRefreshTask();
            } else {
                httpDnsCache.removeHttpDnsRemoveTask();
            }
        }
        if (HttpDns.getService().isHttpDnsPrefer().get()) {
            dnsRecord.addHttpDnsRefreshTask();
        } else {
            dnsRecord.addHttpDnsRemoveTask();
        }
        synchronized (this.mHttpDnsCacheMap.map()) {
            this.mHttpDnsCacheMap.put(str, dnsRecord);
        }
    }

    public void removeHttpDnsCache(String str) {
        DnsRecord httpDnsCache = getHttpDnsCache(str);
        if (httpDnsCache != null) {
            if (HttpDns.getService().isHttpDnsPrefer().get()) {
                httpDnsCache.removeHttpDnsRefreshTask();
            } else {
                httpDnsCache.removeHttpDnsRemoveTask();
            }
            synchronized (this.mHttpDnsCacheMap.map()) {
                this.mHttpDnsCacheMap.remove(str);
            }
        }
    }

    public DnsRecord getHttpDnsCache(String str) {
        DnsRecord dnsRecord;
        synchronized (this.mHttpDnsCacheMap.map()) {
            dnsRecord = this.mHttpDnsCacheMap.get(str);
        }
        return dnsRecord;
    }

    public void addLocalDnsCache(String str, DnsRecord dnsRecord) {
        DnsRecord localDnsCache = getLocalDnsCache(str);
        if (localDnsCache != null) {
            localDnsCache.removeLocalDnsRemoveTask();
        }
        dnsRecord.addLocalDnsRemoveTask();
        this.mLocalDnsCacheMap.put(str, dnsRecord);
    }

    public void removeLocalDnsCache(String str) {
        DnsRecord localDnsCache = getLocalDnsCache(str);
        if (localDnsCache != null) {
            localDnsCache.removeLocalDnsRemoveTask();
            this.mLocalDnsCacheMap.remove(str);
        }
    }

    public DnsRecord getLocalDnsCache(String str) {
        if (this.mLocalDnsCacheMap.containsKey(str)) {
            return this.mLocalDnsCacheMap.get(str);
        }
        return null;
    }

    public boolean isHttpDnsResolving(String str) {
        return this.mHttpDnsResolvingFutureMap.containsKey(str);
    }

    public void addHttpDnsResolvingFuture(String str, Future<Void> future) {
        this.mHttpDnsResolvingFutureMap.put(str, future);
    }

    public void removeHttpDnsResolvingFuture(String str) {
        this.mHttpDnsResolvingFutureMap.remove(str);
    }

    public Future<Void> getHttpDnsResolvingFuture(String str) {
        if (this.mHttpDnsResolvingFutureMap.containsKey(str)) {
            return this.mHttpDnsResolvingFutureMap.get(str);
        }
        return null;
    }

    public void addLocalDnsResolvingFuture(String str, Future<Void> future) {
        this.mLocalDnsResolvingFutureMap.put(str, future);
    }

    public void removeLocalDnsResolvingFuture(String str) {
        this.mLocalDnsResolvingFutureMap.remove(str);
    }

    public boolean isLocalDnsResolving(String str) {
        return this.mLocalDnsResolvingFutureMap.containsKey(str);
    }

    public Future<Void> getLocalDnsResolvingFuture(String str) {
        if (this.mLocalDnsResolvingFutureMap.containsKey(str)) {
            return this.mLocalDnsResolvingFutureMap.get(str);
        }
        return null;
    }

    public synchronized void addHttpDnsJob(String str, HostResolveJob hostResolveJob) {
        if (this.mHttpDnsResolveJobs.containsKey(str)) {
            this.mHttpDnsResolveJobs.get(str).add(hostResolveJob);
        } else {
            ConcurrentSkipListSet<HostResolveJob> concurrentSkipListSet = new ConcurrentSkipListSet<>();
            concurrentSkipListSet.add(hostResolveJob);
            this.mHttpDnsResolveJobs.put(str, concurrentSkipListSet);
        }
    }

    public ConcurrentSkipListSet<HostResolveJob> getHttpDnsJobs(String str) {
        return this.mHttpDnsResolveJobs.get(str);
    }

    public boolean shouldHttpDnsCallback(String str) {
        return this.mHttpDnsResolveJobs.containsKey(str);
    }

    public boolean shouldHttpDnsTimeoutCallback(HostResolveJob hostResolveJob) {
        return this.mHttpDnsResolveJobs.containsKey(hostResolveJob.getHost()) && this.mHttpDnsResolveJobs.get(hostResolveJob.getHost()).contains(hostResolveJob);
    }

    public void removeHttpDnsJob(HostResolveJob hostResolveJob) {
        String host = hostResolveJob.getHost();
        if (this.mHttpDnsResolveJobs.containsKey(host)) {
            this.mHttpDnsResolveJobs.get(host).remove(hostResolveJob);
            if (this.mHttpDnsResolveJobs.get(host).isEmpty()) {
                this.mHttpDnsResolveJobs.remove(host);
            }
        }
    }

    public synchronized void addLocalDnsJob(String str, HostResolveJob hostResolveJob) {
        if (this.mLocalDnsResolveJobs.containsKey(str)) {
            this.mLocalDnsResolveJobs.get(str).add(hostResolveJob);
        } else {
            ConcurrentSkipListSet<HostResolveJob> concurrentSkipListSet = new ConcurrentSkipListSet<>();
            concurrentSkipListSet.add(hostResolveJob);
            this.mLocalDnsResolveJobs.put(str, concurrentSkipListSet);
        }
    }

    public ConcurrentSkipListSet<HostResolveJob> getLocalDnsJobs(String str) {
        return this.mLocalDnsResolveJobs.get(str);
    }

    public boolean shouldLocalDnsCallback(String str) {
        return this.mLocalDnsResolveJobs.containsKey(str);
    }

    public boolean shouldLocalDnsTimeoutCallback(HostResolveJob hostResolveJob) {
        return this.mLocalDnsResolveJobs.containsKey(hostResolveJob.getHost()) && this.mLocalDnsResolveJobs.get(hostResolveJob.getHost()).contains(hostResolveJob);
    }

    public void removeLocalDnsJob(HostResolveJob hostResolveJob) {
        String host = hostResolveJob.getHost();
        if (this.mLocalDnsResolveJobs.containsKey(host)) {
            this.mLocalDnsResolveJobs.get(host).remove(hostResolveJob);
            if (this.mLocalDnsResolveJobs.get(host).isEmpty()) {
                this.mLocalDnsResolveJobs.remove(host);
            }
        }
    }

    public void addHttpDnsStaleCacheHost(String str) {
        this.mHttpDnsStaleCacheHosts.add(str);
        if (this.mHttpDnsStaleCacheHosts.size() < 10) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mHttpDnsStaleCacheHosts);
        HttpDns.getService().batchRefreshHttpDnsStaleCache(arrayList);
    }

    public void removeHttpDnsStaleCacheHost(String str) {
        if (this.mHttpDnsStaleCacheHosts.contains(str)) {
            this.mHttpDnsStaleCacheHosts.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AtomicInteger getDetectedHardCodeipsCnt() {
        return this.mDetectedHardCodeipsCnt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDetectedHardCodeipsCnt() {
        this.mDetectedHardCodeipsCnt.getAndIncrement();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AtomicInteger getHttpDnsDomainFailedCnt() {
        return this.mHttpDnsDomainFailedCnt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addHttpDnsDomainFailedCnt() {
        this.mHttpDnsDomainFailedCnt.getAndIncrement();
        if (this.mHttpDnsDomainFailedCnt.get() >= 2) {
            Message obtain = Message.obtain();
            obtain.what = 20;
            obtain.obj = this;
            this.mHandler.sendMessageDelayed(obtain, 180000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetHttpDnsDomainFailedCnt() {
        this.mHttpDnsDomainFailedCnt.set(0);
    }
}
