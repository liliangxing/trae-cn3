package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.DnsResult;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.HttpDns;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.Dns;
import okhttp3.ttnet.TTNetDns;
import okhttp3.ttnet.TTNetDnsResult;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class OkHttp3DnsParserInterceptor implements TTNetDns {
    private static volatile OkHttp3DnsParserInterceptor mInstance;
    private final String TAG = "OkHttp3DnsParserInterceptor";

    public static OkHttp3DnsParserInterceptor inst() {
        if (mInstance == null) {
            synchronized (OkHttp3DnsParserInterceptor.class) {
                if (mInstance == null) {
                    mInstance = new OkHttp3DnsParserInterceptor();
                }
            }
        }
        return mInstance;
    }

    public TTNetDnsResult lookup(String str, int i) throws UnknownHostException {
        if (Logger.debug()) {
            Logger.d(this.TAG, "lookup address list for " + str + " " + i);
        }
        DnsResult httpDnsResultForHostSyncBlock = HttpDns.getService().getHttpDnsResultForHostSyncBlock(str);
        DnsResult.Source source = DnsResult.Source.UNKNOWN;
        List<InetAddress> arrayList = new ArrayList<>();
        if (httpDnsResultForHostSyncBlock != null && (!httpDnsResultForHostSyncBlock.ipv4List.isEmpty() || !httpDnsResultForHostSyncBlock.ipv6List.isEmpty())) {
            Iterator<String> it = httpDnsResultForHostSyncBlock.ipv6List.iterator();
            Iterator<String> it2 = httpDnsResultForHostSyncBlock.ipv4List.iterator();
            while (true) {
                if (!it.hasNext() && !it2.hasNext()) {
                    break;
                }
                if (it.hasNext()) {
                    arrayList.add(InetAddress.getByName(it.next()));
                }
                if (it2.hasNext()) {
                    arrayList.add(InetAddress.getByName(it2.next()));
                }
            }
            source = httpDnsResultForHostSyncBlock.source;
        } else {
            try {
                arrayList = Dns.SYSTEM.lookup(str);
                source = DnsResult.Source.LOCALDNS_REQUEST;
            } catch (UnknownHostException unused) {
            }
        }
        return new TTNetDnsResult(arrayList, constructDnsInfoJson(arrayList, source));
    }

    private String constructDnsInfoJson(List<InetAddress> list, DnsResult.Source source) {
        boolean z;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            for (InetAddress inetAddress : list) {
                if (inetAddress != null && !TextUtils.isEmpty(inetAddress.getHostAddress())) {
                    jSONArray.put(inetAddress.getHostAddress());
                }
            }
            jSONObject.put("address_list", jSONArray);
            int i = 1;
            jSONObject.put("httpdns_prefer", HttpDns.getService().isHttpDnsPrefer().get() ? 1 : 0);
            TTNetDnsSource tTNetDnsSource = TTNetDnsSource.NOT_SET;
            TTNetDnsCacheSource tTNetDnsCacheSource = TTNetDnsCacheSource.UNKNOWN;
            switch (C09191.f784x66c52070[source.ordinal()]) {
                case 1:
                    tTNetDnsSource = TTNetDnsSource.SERVE_FROM_CACHE;
                    tTNetDnsCacheSource = TTNetDnsCacheSource.SOURCE_HTTPDNS;
                    z = false;
                    break;
                case 2:
                    tTNetDnsSource = TTNetDnsSource.SERVE_FROM_CACHE;
                    tTNetDnsCacheSource = TTNetDnsCacheSource.SOURCE_PROC;
                    z = false;
                    break;
                case 3:
                    tTNetDnsSource = TTNetDnsSource.SERVE_FROM_HTTP_DNS_JOB;
                    z = false;
                    break;
                case 4:
                    tTNetDnsSource = TTNetDnsSource.SERVE_FROM_PROC_DNS_JOB;
                    z = false;
                    break;
                case 5:
                    tTNetDnsSource = TTNetDnsSource.SERVE_FROM_CACHE;
                    tTNetDnsCacheSource = TTNetDnsCacheSource.SOURCE_HTTPDNS;
                    z = true;
                    break;
                case 6:
                    tTNetDnsSource = TTNetDnsSource.SERVE_FROM_HARDCODE_HOSTS;
                    z = false;
                    break;
                default:
                    z = false;
                    break;
            }
            jSONObject.put("source", tTNetDnsSource.mValue);
            jSONObject.put("cache_source", tTNetDnsCacheSource.mValue);
            if (!z) {
                i = 0;
            }
            jSONObject.put("from_stale_cache", i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.frameworks.baselib.network.http.ok3.impl.OkHttp3DnsParserInterceptor$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static /* synthetic */ class C09191 {

        /* renamed from: $SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$httpdns$DnsResult$Source */
        static final /* synthetic */ int[] f784x66c52070;

        static {
            int[] iArr = new int[DnsResult.Source.values().length];
            f784x66c52070 = iArr;
            try {
                iArr[DnsResult.Source.HTTPDNS_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f784x66c52070[DnsResult.Source.LOCALDNS_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f784x66c52070[DnsResult.Source.HTTPDNS_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f784x66c52070[DnsResult.Source.LOCALDNS_REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f784x66c52070[DnsResult.Source.HTTPDNS_STALE_CACHE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f784x66c52070[DnsResult.Source.HARDCODE_IPS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f784x66c52070[DnsResult.Source.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }
}
