package com.bytedance.ies.bullet.service.base.resourceloader.config;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResourceLoaderConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b)\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R\u001c\u0010!\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000eR\u001a\u0010(\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0011\"\u0004\b*\u0010\u0013R\u001a\u0010+\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0011\"\u0004\b-\u0010\u0013R\u001a\u0010.\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0011\"\u0004\b0\u0010\u0013¨\u00061"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/resourceloader/config/GeckoConfig;", "", "accessKey", "", "offlineDir", "loaderDepender", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ILoaderDepender;", "isRelativePath", "", "loopCheck", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ILoaderDepender;ZZ)V", "getAccessKey", "()Ljava/lang/String;", "setAccessKey", "(Ljava/lang/String;)V", "appLogMonitor", "getAppLogMonitor", "()Z", "setAppLogMonitor", "(Z)V", "businessVersion", "getBusinessVersion", "setBusinessVersion", "setRelativePath", "getLoaderDepender", "()Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ILoaderDepender;", "setLoaderDepender", "(Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ILoaderDepender;)V", "localInfo", "getLocalInfo", "setLocalInfo", "getLoopCheck", "setLoopCheck", "networkImpl", "getNetworkImpl", "()Ljava/lang/Object;", "setNetworkImpl", "(Ljava/lang/Object;)V", "getOfflineDir", "setOfflineDir", "serverMonitor", "getServerMonitor", "setServerMonitor", "updateWhenInit", "getUpdateWhenInit", "setUpdateWhenInit", "useGeckoXV4", "getUseGeckoXV4", "setUseGeckoXV4", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class GeckoConfig {
    private String accessKey;
    private boolean appLogMonitor;
    private String businessVersion;
    private boolean isRelativePath;
    private ILoaderDepender loaderDepender;
    private String localInfo;
    private boolean loopCheck;
    private Object networkImpl;
    private String offlineDir;
    private boolean serverMonitor;
    private boolean updateWhenInit;
    private boolean useGeckoXV4;

    public GeckoConfig(String accessKey, String offlineDir, ILoaderDepender loaderDepender, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(accessKey, "accessKey");
        Intrinsics.checkNotNullParameter(offlineDir, "offlineDir");
        Intrinsics.checkNotNullParameter(loaderDepender, "loaderDepender");
        this.accessKey = accessKey;
        this.offlineDir = offlineDir;
        this.loaderDepender = loaderDepender;
        this.isRelativePath = z;
        this.loopCheck = z2;
        this.useGeckoXV4 = true;
        this.serverMonitor = true;
        this.localInfo = "";
    }

    public /* synthetic */ GeckoConfig(String str, String str2, ILoaderDepender iLoaderDepender, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, iLoaderDepender, (i & 8) != 0 ? true : z, (i & 16) != 0 ? false : z2);
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public final void setAccessKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.accessKey = str;
    }

    public final String getOfflineDir() {
        return this.offlineDir;
    }

    public final void setOfflineDir(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.offlineDir = str;
    }

    public final ILoaderDepender getLoaderDepender() {
        return this.loaderDepender;
    }

    public final void setLoaderDepender(ILoaderDepender iLoaderDepender) {
        Intrinsics.checkNotNullParameter(iLoaderDepender, "<set-?>");
        this.loaderDepender = iLoaderDepender;
    }

    /* renamed from: isRelativePath, reason: from getter */
    public final boolean getIsRelativePath() {
        return this.isRelativePath;
    }

    public final void setRelativePath(boolean z) {
        this.isRelativePath = z;
    }

    public final boolean getLoopCheck() {
        return this.loopCheck;
    }

    public final void setLoopCheck(boolean z) {
        this.loopCheck = z;
    }

    public final boolean getUseGeckoXV4() {
        return this.useGeckoXV4;
    }

    public final void setUseGeckoXV4(boolean z) {
        this.useGeckoXV4 = z;
    }

    public final boolean getServerMonitor() {
        return this.serverMonitor;
    }

    public final void setServerMonitor(boolean z) {
        this.serverMonitor = z;
    }

    public final boolean getUpdateWhenInit() {
        return this.updateWhenInit;
    }

    public final void setUpdateWhenInit(boolean z) {
        this.updateWhenInit = z;
    }

    public final boolean getAppLogMonitor() {
        return this.appLogMonitor;
    }

    public final void setAppLogMonitor(boolean z) {
        this.appLogMonitor = z;
    }

    public final String getLocalInfo() {
        return this.localInfo;
    }

    public final void setLocalInfo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.localInfo = str;
    }

    public final Object getNetworkImpl() {
        return this.networkImpl;
    }

    public final void setNetworkImpl(Object obj) {
        this.networkImpl = obj;
    }

    public final String getBusinessVersion() {
        return this.businessVersion;
    }

    public final void setBusinessVersion(String str) {
        this.businessVersion = str;
    }
}
