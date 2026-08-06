package com.bytedance.kmp.network.wschannel;

import com.bytedance.common.wschannel.WsConstants;
import com.heytap.mcssdk.constant.b;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChannelInfo.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0010\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\u0002\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/kmp/network/wschannel/ChannelInfo;", "", "deviceId", "", "installId", b.z, WsConstants.KEY_FPID, "", "aid", "appVersion", "updateVersionCode", "extra", "", "headers", MonitorConstants.URLS, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIILjava/util/Map;Ljava/util/Map;Ljava/util/List;)V", "getAid", "()I", "getAppKey", "()Ljava/lang/String;", "getAppVersion", "getDeviceId", "getExtra", "()Ljava/util/Map;", "getFpid", "getHeaders", "getInstallId", "getUpdateVersionCode", "getUrls", "()Ljava/util/List;", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ChannelInfo {
    private final int aid;
    private final String appKey;
    private final int appVersion;
    private final String deviceId;
    private final Map<String, String> extra;
    private final int fpid;
    private final Map<String, String> headers;
    private final String installId;
    private final int updateVersionCode;
    private final List<String> urls;

    public ChannelInfo(String deviceId, String installId, String appKey, int i, int i2, int i3, int i4, Map<String, String> extra, Map<String, String> headers, List<String> urls) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(installId, "installId");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(extra, "extra");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(urls, "urls");
        this.deviceId = deviceId;
        this.installId = installId;
        this.appKey = appKey;
        this.fpid = i;
        this.aid = i2;
        this.appVersion = i3;
        this.updateVersionCode = i4;
        this.extra = extra;
        this.headers = headers;
        this.urls = urls;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getInstallId() {
        return this.installId;
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final int getFpid() {
        return this.fpid;
    }

    public final int getAid() {
        return this.aid;
    }

    public final int getAppVersion() {
        return this.appVersion;
    }

    public final int getUpdateVersionCode() {
        return this.updateVersionCode;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final List<String> getUrls() {
        return this.urls;
    }
}
