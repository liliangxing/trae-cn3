package com.bytedance.ies.bullet.service.base;

import com.bytedance.bdturing.setting.SettingsManager;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: MonitorConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 72\u00020\u0001:\u000267B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007RJ\u0010\u0015\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010!\"\u0004\b,\u0010#R2\u0010-\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0007\"\u0004\b5\u0010\u0004¨\u00068"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/MonitorConfig;", "", "containerName", "", "(Ljava/lang/String;)V", "bizTag", "getBizTag", "()Ljava/lang/String;", "setBizTag", "category", "Lorg/json/JSONObject;", "getCategory", "()Lorg/json/JSONObject;", "setCategory", "(Lorg/json/JSONObject;)V", SettingsManager.COMMON_SERVICE, "getCommon", "setCommon", "getContainerName$annotations", "()V", "getContainerName", "customReporter", "Lkotlin/Function4;", "", "", "getCustomReporter$annotations", "getCustomReporter", "()Lkotlin/jvm/functions/Function4;", "setCustomReporter", "(Lkotlin/jvm/functions/Function4;)V", "injectBrowser", "", "getInjectBrowser", "()Z", "setInjectBrowser", "(Z)V", "intercept", "Lcom/bytedance/ies/bullet/service/base/BulletMonitorIntercept;", "getIntercept", "()Lcom/bytedance/ies/bullet/service/base/BulletMonitorIntercept;", "setIntercept", "(Lcom/bytedance/ies/bullet/service/base/BulletMonitorIntercept;)V", "logSwitch", "getLogSwitch", "setLogSwitch", "teaReporter", "Lkotlin/Function2;", "getTeaReporter", "()Lkotlin/jvm/functions/Function2;", "setTeaReporter", "(Lkotlin/jvm/functions/Function2;)V", "virtualAID", "getVirtualAID", "setVirtualAID", "Builder", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class MonitorConfig {
    public static final String DEFAULT_CONTAINER_NAME = "AnnieX";
    public static final String defaultBulletBid = "bullet_custom_bid";
    private String bizTag;
    private JSONObject category;
    private JSONObject common;
    private final String containerName;
    private Function4<? super String, ? super Integer, ? super JSONObject, ? super JSONObject, Unit> customReporter;
    private boolean injectBrowser;
    private BulletMonitorIntercept intercept;
    private boolean logSwitch;
    private Function2<? super String, ? super JSONObject, Unit> teaReporter;
    private String virtualAID;

    /* JADX WARN: Multi-variable type inference failed */
    public MonitorConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Deprecated(message = "该字段已经废弃，容器名称统一为 AnnieX")
    public static /* synthetic */ void getContainerName$annotations() {
    }

    @Deprecated(message = "废弃接口，若拦截上报请使用 interceptor, 注入 tea 上报逻辑请使用 teaReporter")
    public static /* synthetic */ void getCustomReporter$annotations() {
    }

    public MonitorConfig(String containerName) {
        Intrinsics.checkNotNullParameter(containerName, "containerName");
        this.containerName = containerName;
        this.logSwitch = true;
        this.bizTag = "bullet_custom_bid";
        this.injectBrowser = true;
    }

    public /* synthetic */ MonitorConfig(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "AnnieX" : str);
    }

    public final String getContainerName() {
        return this.containerName;
    }

    public final boolean getLogSwitch() {
        return this.logSwitch;
    }

    public final void setLogSwitch(boolean z) {
        this.logSwitch = z;
    }

    public final String getBizTag() {
        return this.bizTag;
    }

    public final void setBizTag(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bizTag = str;
    }

    public final String getVirtualAID() {
        return this.virtualAID;
    }

    public final void setVirtualAID(String str) {
        this.virtualAID = str;
    }

    public final JSONObject getCategory() {
        return this.category;
    }

    public final void setCategory(JSONObject jSONObject) {
        this.category = jSONObject;
    }

    public final JSONObject getCommon() {
        return this.common;
    }

    public final void setCommon(JSONObject jSONObject) {
        this.common = jSONObject;
    }

    public final Function4<String, Integer, JSONObject, JSONObject, Unit> getCustomReporter() {
        return this.customReporter;
    }

    public final void setCustomReporter(Function4<? super String, ? super Integer, ? super JSONObject, ? super JSONObject, Unit> function4) {
        this.customReporter = function4;
    }

    public final Function2<String, JSONObject, Unit> getTeaReporter() {
        return this.teaReporter;
    }

    public final void setTeaReporter(Function2<? super String, ? super JSONObject, Unit> function2) {
        this.teaReporter = function2;
    }

    public final BulletMonitorIntercept getIntercept() {
        return this.intercept;
    }

    public final void setIntercept(BulletMonitorIntercept bulletMonitorIntercept) {
        this.intercept = bulletMonitorIntercept;
    }

    public final boolean getInjectBrowser() {
        return this.injectBrowser;
    }

    public final void setInjectBrowser(boolean z) {
        this.injectBrowser = z;
    }

    /* compiled from: MonitorConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\nJ\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\nJ\u0017\u0010\u0003\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/MonitorConfig$Builder;", "", "()V", "logSwitch", "", "getLogSwitch", "()Z", "setLogSwitch", "(Z)V", "mBizTag", "", "getMBizTag", "()Ljava/lang/String;", "setMBizTag", "(Ljava/lang/String;)V", "mContainerName", "getMContainerName", "setMContainerName", "mVirtualAID", "getMVirtualAID", "setMVirtualAID", "bizTag", "tag", "build", "Lcom/bytedance/ies/bullet/service/base/MonitorConfig;", "containerName", "name", "switch", "(Ljava/lang/Boolean;)Lcom/bytedance/ies/bullet/service/base/MonitorConfig$Builder;", "virtualAID", "aid", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    @Deprecated(message = "推荐直接新建对象，Builder 仅兼容 Rifle 逻辑")
    /* loaded from: classes4.dex */
    public static final class Builder {
        private boolean logSwitch = true;
        private String mBizTag;
        private String mContainerName;
        private String mVirtualAID;

        public final String getMContainerName() {
            return this.mContainerName;
        }

        public final void setMContainerName(String str) {
            this.mContainerName = str;
        }

        public final String getMBizTag() {
            return this.mBizTag;
        }

        public final void setMBizTag(String str) {
            this.mBizTag = str;
        }

        public final String getMVirtualAID() {
            return this.mVirtualAID;
        }

        public final void setMVirtualAID(String str) {
            this.mVirtualAID = str;
        }

        public final boolean getLogSwitch() {
            return this.logSwitch;
        }

        public final void setLogSwitch(boolean z) {
            this.logSwitch = z;
        }

        public final Builder containerName(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.mContainerName = name;
            return this;
        }

        public final Builder bizTag(String tag) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.mBizTag = tag;
            return this;
        }

        public final Builder virtualAID(String aid) {
            Intrinsics.checkNotNullParameter(aid, "aid");
            this.mVirtualAID = aid;
            return this;
        }

        @Deprecated(message = "废弃接口")
        public final Builder logSwitch(Boolean r1) {
            this.logSwitch = r1 != null ? r1.booleanValue() : true;
            return this;
        }

        public final MonitorConfig build() {
            String str = this.mContainerName;
            if (str == null) {
                str = "bullet";
            }
            MonitorConfig monitorConfig = new MonitorConfig(str);
            String str2 = this.mBizTag;
            if (str2 != null) {
                monitorConfig.setBizTag(str2);
            }
            String str3 = this.mVirtualAID;
            if (str3 != null) {
                monitorConfig.setVirtualAID(str3);
            }
            monitorConfig.setLogSwitch(this.logSwitch);
            return monitorConfig;
        }
    }
}
