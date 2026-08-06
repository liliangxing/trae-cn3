package com.bytedance.ies.bullet.secure;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.lynx.scc.cloudservice.utils.SccUtils;
import com.bytedance.memory.api.MemoryApi;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SccConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0003-./B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010%\u001a\u00020\u0000H\u0000¢\u0006\u0002\b&J\u0015\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0000H\u0000¢\u0006\u0002\b)J\u000f\u0010*\u001a\u0004\u0018\u00010+H\u0000¢\u0006\u0002\b,R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0000@\u0000X\u0081\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR\"\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0000@\u0000X\u0081\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\"\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0000@\u0000X\u0081\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR\"\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0000@\u0000X\u0081\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u0004\u0018\u00010\u001c8\u0000@\u0000X\u0081\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 ¨\u00060"}, d2 = {"Lcom/bytedance/ies/bullet/secure/SccConfig;", "", "()V", "allowList", "", "", "getAllowList$anniex_release", "()Ljava/util/List;", "setAllowList$anniex_release", "(Ljava/util/List;)V", MemoryApi.DEBUG, "", "getDebug$anniex_release", "()Ljava/lang/Boolean;", "setDebug$anniex_release", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "denyList", "Lcom/bytedance/ies/bullet/secure/SccConfig$DenyItem;", "getDenyList$anniex_release", "setDenyList$anniex_release", "enablePrefetch", "getEnablePrefetch$anniex_release", "setEnablePrefetch$anniex_release", "enableScc", "getEnableScc$anniex_release", "setEnableScc$anniex_release", "maxReloadCount", "", "getMaxReloadCount$anniex_release", "()Ljava/lang/Integer;", "setMaxReloadCount$anniex_release", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "maxWaitTime", "getMaxWaitTime$anniex_release", "setMaxWaitTime$anniex_release", "clone", "clone$anniex_release", "merge", "config", "merge$anniex_release", "toJsonObject", "Lcom/google/gson/JsonObject;", "toJsonObject$anniex_release", "Builder", "DenyItem", "SccLevel", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SccConfig {

    @SerializedName(SccUtils.CS_ALLOW_LIST)
    private List<String> allowList;

    @SerializedName("scc_cs_deny_list")
    private List<DenyItem> denyList;

    @SerializedName(SccUtils.CS_ENABLE)
    private Boolean enableScc = false;

    @SerializedName("scc_cs_debug")
    private Boolean debug = false;

    @SerializedName("scc_cs_max_reload_count")
    private Integer maxReloadCount = 5;

    @SerializedName(SccUtils.CS_MAX_WAIT_TIME)
    private Integer maxWaitTime = Integer.valueOf(BytePatchException.ErrorCode.paramsError);

    @SerializedName(SccUtils.CS_ENABLE_PREFETCH)
    private Boolean enablePrefetch = false;

    /* compiled from: SccConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/bullet/secure/SccConfig$SccLevel;", "", "(Ljava/lang/String;I)V", "SAFE", "NOTICE", "DENY", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public enum SccLevel {
        SAFE,
        NOTICE,
        DENY
    }

    /* renamed from: getEnableScc$anniex_release, reason: from getter */
    public final Boolean getEnableScc() {
        return this.enableScc;
    }

    public final void setEnableScc$anniex_release(Boolean bool) {
        this.enableScc = bool;
    }

    /* renamed from: getDebug$anniex_release, reason: from getter */
    public final Boolean getDebug() {
        return this.debug;
    }

    public final void setDebug$anniex_release(Boolean bool) {
        this.debug = bool;
    }

    public final List<String> getAllowList$anniex_release() {
        return this.allowList;
    }

    public final void setAllowList$anniex_release(List<String> list) {
        this.allowList = list;
    }

    public final List<DenyItem> getDenyList$anniex_release() {
        return this.denyList;
    }

    public final void setDenyList$anniex_release(List<DenyItem> list) {
        this.denyList = list;
    }

    /* renamed from: getMaxReloadCount$anniex_release, reason: from getter */
    public final Integer getMaxReloadCount() {
        return this.maxReloadCount;
    }

    public final void setMaxReloadCount$anniex_release(Integer num) {
        this.maxReloadCount = num;
    }

    /* renamed from: getMaxWaitTime$anniex_release, reason: from getter */
    public final Integer getMaxWaitTime() {
        return this.maxWaitTime;
    }

    public final void setMaxWaitTime$anniex_release(Integer num) {
        this.maxWaitTime = num;
    }

    /* renamed from: getEnablePrefetch$anniex_release, reason: from getter */
    public final Boolean getEnablePrefetch() {
        return this.enablePrefetch;
    }

    public final void setEnablePrefetch$anniex_release(Boolean bool) {
        this.enablePrefetch = bool;
    }

    /* compiled from: SccConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/secure/SccConfig$DenyItem;", "", "()V", ISignalReportConstants.KEY_REASON, "", "getReason", "()Ljava/lang/String;", "setReason", "(Ljava/lang/String;)V", "urlSet", "", "getUrlSet", "()Ljava/util/List;", "setUrlSet", "(Ljava/util/List;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class DenyItem {

        @SerializedName(ISignalReportConstants.KEY_REASON)
        private String reason;

        @SerializedName("urlSet")
        private List<String> urlSet;

        public final String getReason() {
            return this.reason;
        }

        public final void setReason(String str) {
            this.reason = str;
        }

        public final List<String> getUrlSet() {
            return this.urlSet;
        }

        public final void setUrlSet(List<String> list) {
            this.urlSet = list;
        }
    }

    public final JsonObject toJsonObject$anniex_release() {
        try {
            JsonObject jsonTree = new Gson().toJsonTree(this);
            if (jsonTree instanceof JsonObject) {
                return jsonTree;
            }
            return null;
        } catch (Throwable th) {
            HybridLogger.e$default(HybridLogger.INSTANCE, "Bullet_secure", "parse scc config error, e=" + th.getMessage(), null, null, 12, null);
            return null;
        }
    }

    public final SccConfig clone$anniex_release() {
        SccConfig sccConfig = new SccConfig();
        sccConfig.enableScc = this.enableScc;
        sccConfig.debug = this.debug;
        ArrayList arrayList = new ArrayList();
        List<String> list = this.allowList;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add((String) it.next());
            }
        }
        sccConfig.allowList = arrayList;
        ArrayList arrayList2 = new ArrayList();
        List<DenyItem> list2 = this.denyList;
        if (list2 != null) {
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList2.add((DenyItem) it2.next());
            }
        }
        sccConfig.denyList = arrayList2;
        sccConfig.maxReloadCount = this.maxReloadCount;
        sccConfig.maxWaitTime = this.maxWaitTime;
        sccConfig.enablePrefetch = this.enablePrefetch;
        return sccConfig;
    }

    public final SccConfig merge$anniex_release(SccConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        Boolean bool = config.enableScc;
        if (bool != null) {
            this.enableScc = Boolean.valueOf(bool.booleanValue());
        }
        Boolean bool2 = config.debug;
        if (bool2 != null) {
            this.debug = Boolean.valueOf(bool2.booleanValue());
        }
        Integer num = config.maxReloadCount;
        if (num != null) {
            this.maxReloadCount = Integer.valueOf(num.intValue());
        }
        Integer num2 = config.maxWaitTime;
        if (num2 != null) {
            this.maxWaitTime = Integer.valueOf(num2.intValue());
        }
        Boolean bool3 = config.enablePrefetch;
        if (bool3 != null) {
            this.enablePrefetch = Boolean.valueOf(bool3.booleanValue());
        }
        return this;
    }

    /* compiled from: SccConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/secure/SccConfig$Builder;", "", "()V", "config", "Lcom/bytedance/ies/bullet/secure/SccConfig;", "allowList", "", "", "build", MemoryApi.DEBUG, "", "enablePrefetch", "enableScc", "maxWaitTime", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Builder {
        private final SccConfig config = new SccConfig();

        public final Builder enableScc(boolean enableScc) {
            this.config.setEnableScc$anniex_release(Boolean.valueOf(enableScc));
            return this;
        }

        public final Builder debug(boolean debug) {
            this.config.setDebug$anniex_release(Boolean.valueOf(debug));
            return this;
        }

        public final Builder allowList(List<String> allowList) {
            Intrinsics.checkNotNullParameter(allowList, "allowList");
            this.config.setAllowList$anniex_release(allowList);
            return this;
        }

        public final Builder maxWaitTime(int maxWaitTime) {
            this.config.setMaxWaitTime$anniex_release(Integer.valueOf(maxWaitTime));
            return this;
        }

        public final Builder enablePrefetch(boolean enablePrefetch) {
            this.config.setEnablePrefetch$anniex_release(Boolean.valueOf(enablePrefetch));
            return this;
        }

        /* renamed from: build, reason: from getter */
        public final SccConfig getConfig() {
            return this.config;
        }
    }
}
