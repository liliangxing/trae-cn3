package com.bytedance.kmp.network.websocket;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RawWebsocketInfo.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001BI\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/kmp/network/websocket/RawWebsocketInfo;", "", "queries", "", "", "headers", "url", MonitorConstants.PROTOCOL, "useCronet", "", "(Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Z)V", "getHeaders", "()Ljava/util/Map;", "getProtocol", "()Ljava/lang/String;", "getQueries", "getUrl", "getUseCronet", "()Z", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RawWebsocketInfo {
    private final Map<String, String> headers;
    private final String protocol;
    private final Map<String, String> queries;
    private final String url;
    private final boolean useCronet;

    public RawWebsocketInfo(Map<String, String> queries, Map<String, String> headers, String url, String protocol, boolean z) {
        Intrinsics.checkNotNullParameter(queries, "queries");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        this.queries = queries;
        this.headers = headers;
        this.url = url;
        this.protocol = protocol;
        this.useCronet = z;
    }

    public /* synthetic */ RawWebsocketInfo(Map map, Map map2, String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, map2, str, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? false : z);
    }

    public final Map<String, String> getQueries() {
        return this.queries;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getProtocol() {
        return this.protocol;
    }

    public final boolean getUseCronet() {
        return this.useCronet;
    }
}
