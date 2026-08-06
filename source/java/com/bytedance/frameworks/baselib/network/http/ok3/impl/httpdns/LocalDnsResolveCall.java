package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.os.Bundle;
import android.os.Message;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class LocalDnsResolveCall implements Callable<Void> {
    public static final int MSG_LOCALDNS_COMPLETED = 1;
    public static final String MSG_LOCALDNS_COMPLETED_HOST_KEY = "localdns_completed_host";
    private final String TAG = "LocalDnsResolveCall";
    private final String mHost;
    private final HostResolveManager mHostResolveManager;
    private final WeakHandler mHttpDnsHanlder;

    public LocalDnsResolveCall(String str, HostResolveManager hostResolveManager, WeakHandler weakHandler) {
        this.mHost = str;
        this.mHostResolveManager = hostResolveManager;
        this.mHttpDnsHanlder = weakHandler;
    }

    @Override // java.util.concurrent.Callable
    public Void call() {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            for (InetAddress inetAddress : InetAddress.getAllByName(this.mHost)) {
                if (inetAddress instanceof Inet4Address) {
                    arrayList.add(inetAddress.getHostAddress());
                } else if (inetAddress instanceof Inet6Address) {
                    arrayList2.add(inetAddress.getHostAddress());
                } else if (Logger.debug()) {
                    Logger.d(this.TAG, "local dns server returned a invalid address: " + inetAddress.getHostAddress());
                }
            }
            if (Logger.debug()) {
                Logger.d(this.TAG, "local dns resolved success for host: " + this.mHost);
            }
            if (arrayList.size() > 0 || arrayList2.size() > 0) {
                this.mHostResolveManager.addLocalDnsCache(this.mHost, new DnsRecord(this.mHost, System.currentTimeMillis(), arrayList, arrayList2, HttpDns.getService().getLocalDnsCacheTTL().get()));
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        if (!HttpDns.getService().isHttpDnsPrefer().get()) {
            Message obtain = Message.obtain();
            obtain.obj = this;
            obtain.what = 1;
            Bundle bundle = new Bundle();
            bundle.putString(MSG_LOCALDNS_COMPLETED_HOST_KEY, this.mHost);
            obtain.setData(bundle);
            this.mHttpDnsHanlder.sendMessage(obtain);
            if (Logger.debug()) {
                Logger.d(this.TAG, "send message to collect result handler for host : " + this.mHost);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("host", this.mHost);
                if (arrayList.size() == 0 && arrayList2.size() == 0) {
                    jSONObject.put("status", "failed");
                    jSONObject.put(StrategyConstants.RESULT, "");
                } else {
                    jSONObject.put("status", "succeed");
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.addAll(arrayList2);
                    arrayList3.addAll(arrayList);
                    jSONObject.put(StrategyConstants.RESULT, arrayList3);
                }
                jSONObject.put("rtt", currentTimeMillis2);
                if (Logger.debug()) {
                    Logger.d(this.TAG, jSONObject.toString());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.mHostResolveManager.removeLocalDnsResolvingFuture(this.mHost);
        return null;
    }
}
