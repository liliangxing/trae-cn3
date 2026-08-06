package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.os.Bundle;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class DnsRecord {
    public static final String MSG_DNSRECORD_HOST = "dnsrecord_host";
    public static final int MSG_HTTPDNS_CACHE_EXPIRED = 12;
    public static final int MSG_REFRESH_HTTPDNS_STALE_CACHE = 10;
    public static final int MSG_REMOVE_HTTPDNS_STALE_CACHE = 13;
    public static final int MSG_REMOVE_LOCALDNS_STALE_CACHE = 11;
    private static final String TAG = "DnsRecord";
    private long mFetchTime;
    private final WeakHandler mHandler = new WeakHandler(HttpDns.getService().getHttpDnsHandlerThread().getLooper(), HttpDns.getService());
    private String mHost;
    private List<String> mIpv4List;
    private List<String> mIpv6List;
    private long mTTL;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public enum CacheStaleReason {
        CACHE_UNSET,
        CACHE_VALID,
        CACHE_STALE_BOTH,
        CACHE_STALE_NETCHANGED,
        CACHE_STALE_EXPIRED,
        PRELOAD_BATCH,
        REFRESH_BATCH
    }

    public DnsRecord(String str, long j, List<String> list, List<String> list2, int i) {
        this.mHost = str;
        this.mFetchTime = j;
        this.mIpv4List = list;
        this.mIpv6List = list2;
        this.mTTL = i;
    }

    public void addHttpDnsRefreshTask() {
        Message obtain = Message.obtain();
        obtain.obj = this;
        obtain.what = 12;
        setHostToMessage(obtain);
        this.mHandler.sendMessageDelayed(obtain, this.mTTL * 1000);
        Message obtain2 = Message.obtain();
        obtain2.obj = this;
        obtain2.what = 10;
        setHostToMessage(obtain2);
        this.mHandler.sendMessageDelayed(obtain2, (this.mTTL * 1000) + (HttpDns.getService().getHttpDnsRefreshStaleCacheInterval().get() * 1000));
    }

    public void addHttpDnsRemoveTask() {
        Message obtain = Message.obtain();
        obtain.obj = this;
        obtain.what = 13;
        setHostToMessage(obtain);
        this.mHandler.sendMessageDelayed(obtain, this.mTTL * 1000);
    }

    public void removeHttpDnsRefreshTask() {
        this.mHandler.removeMessages(10);
        this.mHandler.removeMessages(12);
    }

    public void removeHttpDnsRemoveTask() {
        this.mHandler.removeMessages(13);
    }

    public void addLocalDnsRemoveTask() {
        Message obtain = Message.obtain();
        obtain.obj = this;
        obtain.what = 11;
        setHostToMessage(obtain);
        this.mHandler.sendMessageDelayed(obtain, HttpDns.getService().getLocalDnsCacheTTL().get() * 1000);
    }

    public void removeLocalDnsRemoveTask() {
        this.mHandler.removeMessages(11);
    }

    public long getFetchTime() {
        return this.mFetchTime;
    }

    public long getTTL() {
        return this.mTTL;
    }

    public List<String> getIpv4List() {
        return this.mIpv4List;
    }

    public List<String> getIpv6List() {
        return this.mIpv6List;
    }

    public String getHost() {
        return this.mHost;
    }

    private void setHostToMessage(Message message) {
        Bundle bundle = new Bundle();
        bundle.putString(MSG_DNSRECORD_HOST, this.mHost);
        message.setData(bundle);
    }
}
