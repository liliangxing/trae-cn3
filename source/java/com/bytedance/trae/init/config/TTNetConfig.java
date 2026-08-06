package com.bytedance.trae.init.config;

import com.bytedance.trae.common.apphost.AppHost;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* compiled from: TTNetConfig.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/init/config/TTNetConfig;", "", "<init>", "()V", "configServers", "", "", "getConfigServers", "()[Ljava/lang/String;", "serviceDomainMap", "", "getServiceDomainMap", "()Ljava/util/Map;", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TTNetConfig {
    public static final int $stable = 0;
    public static final TTNetConfig INSTANCE = new TTNetConfig();

    private TTNetConfig() {
    }

    public final String[] getConfigServers() {
        if (AppHost.INSTANCE.isOversea()) {
            return new String[]{"tnc-boot.trae.ai", "tnc-normal.trae.ai"};
        }
        return new String[]{"tnc3-bjlgy.zijieapi.com", "tnc3-alisc1.zijieapi.com", "tnc3-aliec2.zijieapi.com"};
    }

    public final Map<String, String> getServiceDomainMap() {
        if (AppHost.INSTANCE.isOversea()) {
            return MapsKt.mapOf(new Pair[]{TuplesKt.to("httpdns", "34.102.215.99"), TuplesKt.to("netlog", "ttnet-sg.byteoversea.com"), TuplesKt.to("boe", ".boe-gateway.byted.org")});
        }
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("httpdns", "dig.bdurl.net"), TuplesKt.to("netlog", "crash.snssdk.com"), TuplesKt.to("boe", ".boe-gateway.byted.org")});
    }
}
