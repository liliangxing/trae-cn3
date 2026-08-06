package com.bytedance.ies.bullet.service.monitor;

import android.util.Log;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.IBulletLifeCycleV2;
import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.settings.MonitorSettingsConfig;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.base.utils.BulletLoadUriIdentifier;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.notification.Constants;
import com.bytedance.push.interfaze.ISignalReportService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AbsBulletMonitorCallback.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 M2\u00020\u0001:\u0002MNB\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0016J\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\bJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0006\u0010\u0015\u001a\u00020\u000bJ)\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016J\u0019\u0010#\u001a\u00020\u00172\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u0017H\u0016J$\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010\u00142\b\u0010*\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010+\u001a\u00020\u0017H\u0016J\b\u0010,\u001a\u00020\u0017H\u0016J\b\u0010-\u001a\u00020\u0017H\u0016J\b\u0010.\u001a\u00020\u0017H\u0016J\u001a\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u00020\f2\b\b\u0002\u00101\u001a\u000202H\u0016J\"\u00103\u001a\u00020\u00172\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u000b2\b\b\u0002\u00107\u001a\u000202H\u0016J\b\u00108\u001a\u00020\u0017H\u0016J\b\u00109\u001a\u00020\u0017H\u0016J\b\u0010:\u001a\u00020\u0017H\u0016J\b\u0010;\u001a\u00020\u0017H\u0016J\b\u0010<\u001a\u00020\u0017H\u0016J\b\u0010=\u001a\u00020\u0017H\u0016J\u0010\u0010>\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010?\u001a\u00020\u0017H\u0016J\u0012\u0010@\u001a\u00020\u00172\b\u0010A\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010B\u001a\u00020\u0017H\u0016J\b\u0010C\u001a\u00020\u0017H\u0016J\b\u0010D\u001a\u00020\u0017H\u0016J\u001e\u0010E\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u000b2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00170GH\u0016J\u0010\u0010H\u001a\u00020\u00172\u0006\u0010I\u001a\u00020\u000bH\u0016J\u0010\u0010J\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010K\u001a\u00020\u0017H\u0016J\b\u0010L\u001a\u00020\u0017H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/AbsBulletMonitorCallback;", "", "()V", "bulletCallback", "Lcom/bytedance/ies/bullet/core/IBulletLifeCycleV2$Base;", "getBulletCallback", "()Lcom/bytedance/ies/bullet/core/IBulletLifeCycleV2$Base;", "mBulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "generatePerfMapForGlobalProps", "", "", "", "getBid", "getBulletContext", "getPageIdentify", "Lcom/bytedance/ies/bullet/service/base/utils/BulletLoadUriIdentifier;", "getPerfMetric", "key", "getPerfMetrics", "Lorg/json/JSONObject;", "getSessionId", "onBlankDetected", "", "context", "isBlank", "", "percent", "", "(Lcom/bytedance/ies/bullet/core/BulletContext;Ljava/lang/Integer;Ljava/lang/Float;)V", "onBulletContextCreated", "onBulletViewAttached", "monitorContainer", "Lcom/bytedance/ies/bullet/core/container/IBulletContainer;", "onBulletViewDetached", "onContainerCreated", "containerCreateTime", "(Ljava/lang/Long;)V", "onContainerLoaderStart", "onCpuMemoryInject", SchemaConstants.INNER_PARAM_EVENT_NAME, "category", LynxMonitorService.KEY_METRICS, "onCpuMemoryReport", "onJsbRegisterBegin", "onJsbRegisterEnd", "onKitViewCreateBegin", "onLoadEntryBullet", "containerStartTime", "isRouter", "", "onLoadError", "errStage", "Lcom/bytedance/ies/bullet/service/monitor/AbsBulletMonitorCallback$ErrStage;", "errMessage", "hasErrorView", "onLynxReadTemplateBegin", "onLynxReadTemplateEnd", "onLynxRenderTemplateBegin", "onLynxRenderTemplateEnd", "onPrepareTemplateBegin", "onPrepareTemplateEnd", "onReload", "onSchemaPrepared", "onViewAttached", "url", "onWebLoadUrl", "onWebPageFinished", "onWebPageStarted", "recordDuration", "block", "Lkotlin/Function0;", "recordSecurityEventTime", ISignalReportService.BODY_KEY_EVENT, "recordTimeStamp", "reportErrorViewClick", "reportErrorViewShow", "Companion", "ErrStage", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class AbsBulletMonitorCallback {
    private static final String moduleName = "Monitor-Callback";
    private final IBulletLifeCycleV2.Base bulletCallback = new IBulletLifeCycleV2.Base() { // from class: com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback$bulletCallback$1
    };
    private BulletContext mBulletContext;

    public final BulletLoadUriIdentifier getPageIdentify() {
        return null;
    }

    public long getPerfMetric(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return 0L;
    }

    public void onBlankDetected(BulletContext context, Integer isBlank, Float percent) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void onBulletViewAttached(IBulletContainer monitorContainer) {
        Intrinsics.checkNotNullParameter(monitorContainer, "monitorContainer");
    }

    public void onBulletViewDetached() {
    }

    public void onContainerCreated(Long containerCreateTime) {
    }

    public void onContainerLoaderStart() {
    }

    public void onCpuMemoryInject(String eventName, JSONObject category, JSONObject metrics) {
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
    }

    public void onCpuMemoryReport() {
    }

    public void onJsbRegisterBegin() {
    }

    public void onJsbRegisterEnd() {
    }

    public void onKitViewCreateBegin() {
    }

    public void onLoadEntryBullet(long containerStartTime, boolean isRouter) {
    }

    public void onLoadError(ErrStage errStage, String errMessage, boolean hasErrorView) {
        Intrinsics.checkNotNullParameter(errStage, "errStage");
        Intrinsics.checkNotNullParameter(errMessage, "errMessage");
    }

    public void onLynxReadTemplateBegin() {
    }

    public void onLynxReadTemplateEnd() {
    }

    public void onLynxRenderTemplateBegin() {
    }

    public void onLynxRenderTemplateEnd() {
    }

    public void onPrepareTemplateBegin() {
    }

    public void onPrepareTemplateEnd() {
    }

    public void onReload(IBulletContainer monitorContainer) {
        Intrinsics.checkNotNullParameter(monitorContainer, "monitorContainer");
    }

    public void onSchemaPrepared() {
    }

    public void onViewAttached(String url) {
    }

    public void onWebLoadUrl() {
    }

    public void onWebPageFinished() {
    }

    public void onWebPageStarted() {
    }

    public void recordSecurityEventTime(String event) {
        Intrinsics.checkNotNullParameter(event, ISignalReportService.BODY_KEY_EVENT);
    }

    public void recordTimeStamp(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
    }

    public void reportErrorViewClick() {
    }

    public void reportErrorViewShow() {
    }

    public final BulletContext getBulletContext() {
        BulletContext bulletContext = this.mBulletContext;
        if (bulletContext != null) {
            return bulletContext;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBulletContext");
        return null;
    }

    public final String getBid() {
        String bid = getBulletContext().getBid();
        return bid == null ? "default_bid" : bid;
    }

    public final String getSessionId() {
        BulletContext bulletContext = this.mBulletContext;
        if (bulletContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBulletContext");
            bulletContext = null;
        }
        return bulletContext.getSessionId();
    }

    public JSONObject getPerfMetrics() {
        return new JSONObject();
    }

    public void recordDuration(String key, Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke();
    }

    public Map<String, Long> generatePerfMapForGlobalProps() {
        return new LinkedHashMap();
    }

    public IBulletLifeCycleV2.Base getBulletCallback() {
        return this.bulletCallback;
    }

    public void onBulletContextCreated(BulletContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.mBulletContext != null) {
            Log.e("BulletMonitor-Callback", "redundancy onBulletContextCreated");
            return;
        }
        this.mBulletContext = context;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        MonitorSettingsConfig monitorSettingsConfig = iBulletSettingsService != null ? (MonitorSettingsConfig) iBulletSettingsService.obtainSettings(MonitorSettingsConfig.class) : null;
        boolean z = false;
        if (monitorSettingsConfig != null && !monitorSettingsConfig.getLogSwitch()) {
            z = true;
        }
        if (z) {
            context.setMonitorCallback(new AbsBulletMonitorCallback());
        }
    }

    public static /* synthetic */ void onContainerCreated$default(AbsBulletMonitorCallback absBulletMonitorCallback, Long l, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onContainerCreated");
        }
        if ((i & 1) != 0) {
            l = null;
        }
        absBulletMonitorCallback.onContainerCreated(l);
    }

    public static /* synthetic */ void onLoadEntryBullet$default(AbsBulletMonitorCallback absBulletMonitorCallback, long j, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onLoadEntryBullet");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        absBulletMonitorCallback.onLoadEntryBullet(j, z);
    }

    /* compiled from: AbsBulletMonitorCallback.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/AbsBulletMonitorCallback$ErrStage;", "", Constants.NOTIFICATION_TAG, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTag", "()Ljava/lang/String;", "Container", "Engine", "Plugin", "Business", "RL", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public enum ErrStage {
        Container("bullet"),
        Engine("engine"),
        Plugin("plugin"),
        Business("business"),
        RL("resource");

        private final String tag;

        ErrStage(String str) {
            this.tag = str;
        }

        public final String getTag() {
            return this.tag;
        }
    }

    public static /* synthetic */ void onLoadError$default(AbsBulletMonitorCallback absBulletMonitorCallback, ErrStage errStage, String str, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onLoadError");
        }
        if ((i & 4) != 0) {
            z = false;
        }
        absBulletMonitorCallback.onLoadError(errStage, str, z);
    }
}
