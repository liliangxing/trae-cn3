package com.bytedance.applog.collector;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.bullet.kit.resourceloader.monitor.RLMonitorReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PageHolder.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0004J\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/applog/collector/PageHolder;", "", "()V", "currentPageId", "", "currentPageName", "enabled", "", "sdkPageId", "getPageId", "getPageInfo", "Lcom/bytedance/applog/collector/PageHolder$PageInfo;", "getSdkPageId", "isEnabled", "onBackground", "", "setEnabled", "e", "setPageId", "id", "setPageName", "name", "setSdkPageId", "PageInfo", "agent_chinaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PageHolder {
    private boolean enabled;
    private String currentPageId = "__coldstart";
    private String currentPageName = "";
    private String sdkPageId = "__coldstart";

    /* compiled from: PageHolder.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0006\u0010\u0018\u001a\u00020\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/applog/collector/PageHolder$PageInfo;", "", "pid", "", "pName", "sdkPageId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPName", "()Ljava/lang/String;", "getPid", "getSdkPageId", "appendToJson", "", "target", "Lorg/json/JSONObject;", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toJsonString", "toString", "Companion", "agent_chinaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* data */ class PageInfo {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String pName;
        private final String pid;
        private final String sdkPageId;

        public static /* synthetic */ PageInfo copy$default(PageInfo pageInfo, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pageInfo.pid;
            }
            if ((i & 2) != 0) {
                str2 = pageInfo.pName;
            }
            if ((i & 4) != 0) {
                str3 = pageInfo.sdkPageId;
            }
            return pageInfo.copy(str, str2, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getPid() {
            return this.pid;
        }

        /* renamed from: component2, reason: from getter */
        public final String getPName() {
            return this.pName;
        }

        /* renamed from: component3, reason: from getter */
        public final String getSdkPageId() {
            return this.sdkPageId;
        }

        public final PageInfo copy(String pid, String pName, String sdkPageId) {
            Intrinsics.checkNotNullParameter(pid, "pid");
            Intrinsics.checkNotNullParameter(pName, "pName");
            Intrinsics.checkNotNullParameter(sdkPageId, "sdkPageId");
            return new PageInfo(pid, pName, sdkPageId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PageInfo)) {
                return false;
            }
            PageInfo pageInfo = (PageInfo) other;
            return Intrinsics.areEqual(this.pid, pageInfo.pid) && Intrinsics.areEqual(this.pName, pageInfo.pName) && Intrinsics.areEqual(this.sdkPageId, pageInfo.sdkPageId);
        }

        public int hashCode() {
            return (((this.pid.hashCode() * 31) + this.pName.hashCode()) * 31) + this.sdkPageId.hashCode();
        }

        public String toString() {
            return "PageInfo(pid=" + this.pid + ", pName=" + this.pName + ", sdkPageId=" + this.sdkPageId + ')';
        }

        public PageInfo(String pid, String pName, String sdkPageId) {
            Intrinsics.checkNotNullParameter(pid, "pid");
            Intrinsics.checkNotNullParameter(pName, "pName");
            Intrinsics.checkNotNullParameter(sdkPageId, "sdkPageId");
            this.pid = pid;
            this.pName = pName;
            this.sdkPageId = sdkPageId;
        }

        public final String getPName() {
            return this.pName;
        }

        public final String getPid() {
            return this.pid;
        }

        public final String getSdkPageId() {
            return this.sdkPageId;
        }

        public final String toJsonString() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pid", this.pid);
            jSONObject.put("pName", this.pName);
            jSONObject.put("sdkPageId", this.sdkPageId);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   …\n            }.toString()");
            return jSONObject2;
        }

        public final void appendToJson(JSONObject target) {
            Intrinsics.checkNotNullParameter(target, "target");
            target.putOpt(PageHolderKt.pidKey, this.pid);
            target.putOpt(PageHolderKt.pNameKey, this.pName);
            target.putOpt(PageHolderKt.sdkPidKey, this.sdkPageId);
        }

        /* compiled from: PageHolder.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/applog/collector/PageHolder$PageInfo$Companion;", "", "()V", RLMonitorReporter.PARSE, "Lcom/bytedance/applog/collector/PageHolder$PageInfo;", "json", "", "agent_chinaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final PageInfo parse(String json) {
                Intrinsics.checkNotNullParameter(json, "json");
                try {
                    JSONObject jSONObject = new JSONObject(json);
                    String optString = jSONObject.optString("pid");
                    Intrinsics.checkNotNullExpressionValue(optString, "optString(\"pid\")");
                    String optString2 = jSONObject.optString("pName");
                    Intrinsics.checkNotNullExpressionValue(optString2, "optString(\"pName\")");
                    String optString3 = jSONObject.optString("sdkPageId");
                    Intrinsics.checkNotNullExpressionValue(optString3, "optString(\"sdkPageId\")");
                    return new PageInfo(optString, optString2, optString3);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
        }
    }

    public final void setEnabled(boolean e) {
        this.enabled = e;
    }

    /* renamed from: isEnabled, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    public final void setPageId(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.currentPageId = id;
    }

    public final void setSdkPageId(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.sdkPageId = id;
    }

    public final void setPageName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.currentPageName = name;
    }

    public final void onBackground() {
        this.currentPageId = "__background";
        this.sdkPageId = "__background";
        this.currentPageName = "";
    }

    /* renamed from: getPageId, reason: from getter */
    public final String getCurrentPageId() {
        return this.currentPageId;
    }

    public final String getSdkPageId() {
        return this.sdkPageId;
    }

    public final PageInfo getPageInfo() {
        if (this.enabled) {
            return new PageInfo(this.currentPageId, this.currentPageName, this.sdkPageId);
        }
        return null;
    }
}
