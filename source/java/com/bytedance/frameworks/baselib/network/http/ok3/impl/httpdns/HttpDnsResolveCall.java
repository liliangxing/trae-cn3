package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.DnsRecord;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.HttpDnsUtil;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.HttpsURLConnClient;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.IPAddressUtils;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.Ipv6ConnectionManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class HttpDnsResolveCall implements Callable<Void> {
    private static final String DEVICE_PLATFORM = "android";
    private static final String HTTPDNS_SOURCE = "tt-ok";
    public static final String MSG_HTTPDDNS_COMPLETED_HOSTS_KEY = "httpdns_completed_hosts";
    public static final int MSG_HTTPDNS_COMPLETED = 3;
    private static final String TAG = "HttpDnsResolveCall";
    private DnsRecord.CacheStaleReason mCacheStaleReason;
    private final HostResolveManager mHostResolveManager;
    private String mHosts;
    private final WeakHandler mHttpDnsHanlder;
    private final String mSdkVersion;
    private List<String> mHostList = new ArrayList();
    private List<String> mCallbackHostList = new ArrayList();
    private int mType = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpDnsResolveCall(String str, String str2, HostResolveManager hostResolveManager, DnsRecord.CacheStaleReason cacheStaleReason, WeakHandler weakHandler) {
        this.mHosts = str;
        this.mSdkVersion = str2;
        this.mHostResolveManager = hostResolveManager;
        this.mCacheStaleReason = cacheStaleReason;
        this.mHttpDnsHanlder = weakHandler;
    }

    @Override // java.util.concurrent.Callable
    public Void call() {
        String str;
        for (String str2 : this.mHosts.split(",")) {
            this.mHostList.add(str2);
            this.mCallbackHostList.add(str2);
        }
        if (Logger.debug()) {
            Logger.d(TAG, "Start httpdns resolve for host : " + this.mHostList);
        }
        String httpDnsDomain = HttpDns.getService().getHttpDnsDomain();
        if (HttpDns.getService().getHttpDnsDomainHardCodeIps().size() == 0) {
            this.mHostResolveManager.resetHttpDnsDomainFailedCnt();
        }
        if (!HttpDnsUtil.isValidHost(httpDnsDomain) || this.mHostResolveManager.getHttpDnsDomainFailedCnt().get() >= 2) {
            str = null;
        } else {
            str = doHttpDnsRequest(httpDnsDomain);
            if (str == null) {
                this.mHostResolveManager.addHttpDnsDomainFailedCnt();
            }
        }
        if (str != null) {
            parseHttpDnsResponse(str);
            this.mHostResolveManager.resetHttpDnsDomainFailedCnt();
        } else {
            Iterator<String> it = HttpDns.getService().getHttpDnsDomainHardCodeIps().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!IPAddressUtils.isValidIpv4(next) && !IPAddressUtils.isValidIpv6(next)) {
                    if (Logger.debug()) {
                        Logger.d(TAG, "httpdns backup domian hardcode ip: " + next + " is invalid");
                    }
                } else {
                    String doHttpDnsRequest = doHttpDnsRequest(next);
                    if (doHttpDnsRequest == null) {
                        if (Logger.debug()) {
                            Logger.d(TAG, "httpdns request failed use hardcode ip: " + next + " try next hardcode ip");
                        }
                    } else {
                        parseHttpDnsResponse(doHttpDnsRequest);
                        break;
                    }
                }
            }
        }
        for (String str3 : this.mHostList) {
            this.mHostResolveManager.removeHttpDnsResolvingFuture(str3);
            this.mHostResolveManager.removeHttpDnsCache(str3);
        }
        Message obtain = Message.obtain();
        obtain.obj = this;
        obtain.what = 3;
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(MSG_HTTPDDNS_COMPLETED_HOSTS_KEY, (ArrayList) this.mCallbackHostList);
        obtain.setData(bundle);
        this.mHttpDnsHanlder.sendMessage(obtain);
        if (Logger.debug()) {
            Logger.d(TAG, "send message to collect result handler for host : " + this.mCallbackHostList);
        }
        return null;
    }

    private String doHttpDnsRequest(String str) {
        StringBuilder sb = new StringBuilder("https://");
        if (!Ipv6ConnectionManager.getIpv6GloballyReachable().get()) {
            this.mType = 1;
        }
        sb.append(str).append("/q?host=").append(this.mHosts).append("&aid=").append(HttpDns.getService().getHttpDnsDepend().getAppId()).append("&okhttp_version=").append(this.mSdkVersion).append("&p=android&source=tt-ok&f=").append(this.mType).append("&reason=").append(this.mCacheStaleReason.ordinal() - 1);
        if (this.mHostResolveManager.getDetectedHardCodeipsCnt().get() < 3) {
            sb.append("&refresh_bkup_ip=1");
            this.mHostResolveManager.setDetectedHardCodeipsCnt();
        }
        return HttpsURLConnClient.executeGet(sb.toString(), str);
    }

    private void parseHttpDnsResponse(String str) {
        if (Logger.debug()) {
            Logger.d(TAG, "parseHttpDnsResponse");
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            if (this.mHostList.size() > 1) {
                JSONArray optJSONArray = jSONObject.optJSONArray("dns");
                if (optJSONArray == null) {
                    return;
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    parseSingleHostHttpDnsResponse(optJSONArray.optJSONObject(i));
                }
            } else {
                parseSingleHostHttpDnsResponse(jSONObject);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("httpdns_backup_ip");
            if (optJSONArray2 != null) {
                HttpDns.getService().setHttpDnsHardCodeIps(optJSONArray2);
            }
        } catch (JSONException unused) {
            if (Logger.debug()) {
                Logger.d(TAG, "httpdns server returned a invalid json response.");
            }
        }
    }

    private void parseSingleHostHttpDnsResponse(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("host");
        if (Logger.debug()) {
            Logger.d(TAG, "parseSingleHostHttpDnsResponse for host " + optString);
        }
        int optInt = jSONObject.optInt("ttl");
        JSONArray optJSONArray = jSONObject.optJSONArray("ips");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                String optString2 = optJSONArray.optString(i);
                if (IPAddressUtils.isValidIpv6(optString2)) {
                    arrayList2.add(optString2);
                } else if (IPAddressUtils.isValidIpv4(optString2)) {
                    arrayList.add(optString2);
                } else if (Logger.debug()) {
                    Logger.d(TAG, "httpdns server returned a invalid address: " + optString2);
                }
            }
        }
        if (this.mHostList.contains(optString)) {
            if (arrayList.size() > 0 || arrayList2.size() > 0) {
                this.mHostResolveManager.addHttpDnsCache(optString, new DnsRecord(optString, System.currentTimeMillis(), arrayList, arrayList2, optInt));
                this.mHostResolveManager.removeHttpDnsResolvingFuture(optString);
                this.mHostList.remove(optString);
            }
        }
    }
}
