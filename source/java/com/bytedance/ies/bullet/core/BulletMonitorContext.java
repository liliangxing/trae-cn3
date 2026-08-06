package com.bytedance.ies.bullet.core;

import com.bytedance.android.monitorV2.entity.UnifyErrorDomain;
import com.bytedance.ies.bullet.core.common.JSONObjectExtKt;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.utils.BulletLoadUriIdentifier;
import com.bytedance.ies.bullet.service.monitor.MetricConstant;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: BulletMonitorContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u00106\u001a\u000207J'\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u00032\n\b\u0002\u0010<\u001a\u0004\u0018\u000107¢\u0006\u0002\u0010=J\u001a\u0010>\u001a\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010?\u001a\u0004\u0018\u00010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0007R\u001c\u0010'\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010\u0004R\u001a\u0010*\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006@"}, d2 = {"Lcom/bytedance/ies/bullet/core/BulletMonitorContext;", "", "monitorId", "", "(Ljava/lang/String;)V", "bid", "getBid", "()Ljava/lang/String;", "setBid", "category", "Lorg/json/JSONObject;", "getCategory", "()Lorg/json/JSONObject;", "endToEndErrorMessage", "getEndToEndErrorMessage", "setEndToEndErrorMessage", "endToEndStage", "getEndToEndStage", "setEndToEndStage", "endToEndTraced", "", "getEndToEndTraced", "()Z", "setEndToEndTraced", "(Z)V", "inUse", "getInUse", "setInUse", "loadStage", "Lcom/bytedance/ies/bullet/core/LoadStage;", "getLoadStage", "()Lcom/bytedance/ies/bullet/core/LoadStage;", "setLoadStage", "(Lcom/bytedance/ies/bullet/core/LoadStage;)V", "metric", "getMetric", "setMetric", "(Lorg/json/JSONObject;)V", "getMonitorId", "sessionId", "getSessionId", "setSessionId", "unifyErrorDomain", "", "getUnifyErrorDomain", "()I", "setUnifyErrorDomain", "(I)V", "uriIdentifier", "Lcom/bytedance/ies/bullet/service/base/utils/BulletLoadUriIdentifier;", "getUriIdentifier", "()Lcom/bytedance/ies/bullet/service/base/utils/BulletLoadUriIdentifier;", "setUriIdentifier", "(Lcom/bytedance/ies/bullet/service/base/utils/BulletLoadUriIdentifier;)V", "getInitTime", "", EventConstants.PARAM_SOURCE_INIT, "", "tracertId", "sdkType", "initTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "inject", LynxMonitorService.KEY_METRICS, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletMonitorContext {
    private String bid;
    private final JSONObject category;
    private String endToEndErrorMessage;
    private String endToEndStage;
    private boolean endToEndTraced;
    private boolean inUse;
    private LoadStage loadStage;
    private JSONObject metric;
    private final String monitorId;
    private String sessionId;
    private int unifyErrorDomain;
    private BulletLoadUriIdentifier uriIdentifier;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BulletMonitorContext() {
        this(r0, 1, r0);
        String str = null;
    }

    public BulletMonitorContext(String str) {
        Intrinsics.checkNotNullParameter(str, "monitorId");
        this.monitorId = str;
        this.category = new JSONObject();
        this.metric = new JSONObject();
        this.loadStage = LoadStage.BEGIN;
        this.endToEndStage = "begin";
        this.endToEndErrorMessage = "unknown";
        this.unifyErrorDomain = UnifyErrorDomain.AnnieXUnifyErrorDomainReserved.getErrorDomain();
        this.bid = "default_bid";
    }

    public /* synthetic */ BulletMonitorContext(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    public final String getMonitorId() {
        return this.monitorId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final void setSessionId(String str) {
        this.sessionId = str;
    }

    public final boolean getInUse() {
        return this.inUse;
    }

    public final void setInUse(boolean z) {
        this.inUse = z;
    }

    public final JSONObject getCategory() {
        return this.category;
    }

    public final JSONObject getMetric() {
        return this.metric;
    }

    public final void setMetric(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<set-?>");
        this.metric = jSONObject;
    }

    public final LoadStage getLoadStage() {
        return this.loadStage;
    }

    public final void setLoadStage(LoadStage loadStage) {
        Intrinsics.checkNotNullParameter(loadStage, "<set-?>");
        this.loadStage = loadStage;
    }

    public final String getEndToEndStage() {
        return this.endToEndStage;
    }

    public final void setEndToEndStage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.endToEndStage = str;
    }

    public final String getEndToEndErrorMessage() {
        return this.endToEndErrorMessage;
    }

    public final void setEndToEndErrorMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.endToEndErrorMessage = str;
    }

    public final int getUnifyErrorDomain() {
        return this.unifyErrorDomain;
    }

    public final void setUnifyErrorDomain(int i) {
        this.unifyErrorDomain = i;
    }

    public final boolean getEndToEndTraced() {
        return this.endToEndTraced;
    }

    public final void setEndToEndTraced(boolean z) {
        this.endToEndTraced = z;
    }

    public final String getBid() {
        return this.bid;
    }

    public final void setBid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bid = str;
    }

    public final BulletLoadUriIdentifier getUriIdentifier() {
        return this.uriIdentifier;
    }

    public final void setUriIdentifier(BulletLoadUriIdentifier bulletLoadUriIdentifier) {
        this.uriIdentifier = bulletLoadUriIdentifier;
    }

    public static /* synthetic */ void init$default(BulletMonitorContext bulletMonitorContext, String str, String str2, Long l, int i, Object obj) {
        if ((i & 4) != 0) {
            l = null;
        }
        bulletMonitorContext.init(str, str2, l);
    }

    public final void init(String tracertId, String sdkType, Long initTime) {
        Intrinsics.checkNotNullParameter(tracertId, "tracertId");
        Intrinsics.checkNotNullParameter(sdkType, "sdkType");
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "Tracert init, monitorId " + this.monitorId, null, null, 6, null);
        JSONObject jSONObject = new JSONObject();
        this.metric = jSONObject;
        jSONObject.put(MetricConstant.TRACERT_INIT, initTime != null ? initTime.longValue() : System.currentTimeMillis());
        this.category.put(MetricConstant.TRACERT_ID, tracertId);
        this.category.put(MetricConstant.SDK_TYPE, sdkType);
        this.inUse = true;
    }

    public final long getInitTime() {
        return this.metric.optLong(MetricConstant.TRACERT_INIT);
    }

    public final boolean inject(JSONObject category, JSONObject metrics) {
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "Tracert inject, monitorId " + this.monitorId + ", " + category + ", " + metrics, null, null, 6, null);
        if (!this.inUse) {
            return false;
        }
        if (category != null) {
            JSONObjectExtKt.wrap(this.category, category);
        }
        if (metrics == null) {
            return true;
        }
        JSONObjectExtKt.wrap(this.metric, metrics);
        return true;
    }
}
