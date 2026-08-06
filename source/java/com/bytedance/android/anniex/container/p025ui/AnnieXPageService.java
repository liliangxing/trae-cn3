package com.bytedance.android.anniex.container.p025ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.service.IAnnieXPageService;
import com.bytedance.android.anniex.container.util.AnnieXContainerManager;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.framwork.core.sdklib.MonitorCommonConstants;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.service.base.api.UIShowConfig;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXPageService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \f2\u00020\u00012\u00020\u0002:\u0001\fB\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/android/anniex/container/ui/AnnieXPageService;", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "Lcom/bytedance/android/anniex/base/service/IAnnieXPageService;", "()V", "show", "", "context", "Landroid/content/Context;", StrategyConstants.SCHEMA, "Landroid/net/Uri;", "config", "Lcom/bytedance/ies/bullet/service/base/api/UIShowConfig;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXPageService extends BaseBulletService implements IAnnieXPageService {
    public static final String BUNDLE_ANNIEX_BID = "bundle_annie_x_bid";
    public static final String BUNDLE_ANNIE_X_FLOW = "bundle_annie_x_flow";
    public static final String CUSTOM_ACTIVITY_CLAZZ = "com.bytedance.android.anniex.container.AnnieXHostActivity";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: AnnieXPageService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/anniex/container/ui/AnnieXPageService$Companion;", "", "()V", "BUNDLE_ANNIEX_BID", "", "BUNDLE_ANNIE_X_FLOW", "CUSTOM_ACTIVITY_CLAZZ", "getAnnieXPageContainer", "Lcom/bytedance/android/anniex/base/container/IContainer;", "containerId", "getAnnieXPageContainer$anniex_release", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IContainer getAnnieXPageContainer$anniex_release(String containerId) {
            Intrinsics.checkNotNullParameter(containerId, "containerId");
            return AnnieXContainerManager.INSTANCE.getContainerById(containerId);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean show(Context context, Uri schema, UIShowConfig config) {
        Class cls;
        Object obj;
        boolean z;
        Integer flags;
        boolean z2;
        Integer requestCode;
        Unit unit;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        Intrinsics.checkNotNullParameter(config, "config");
        Unit unit2 = null;
        try {
            Result.Companion companion = Result.Companion;
            cls = Class.forName(CUSTOM_ACTIVITY_CLAZZ);
            try {
                obj = Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                th = th;
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
                if (Result.isSuccess-impl(obj)) {
                }
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context, (Class<?>) cls));
                intent.setData(schema);
                z = context instanceof Activity;
                if (!z) {
                }
                flags = config.getFlags();
                if (flags != null) {
                }
                config.getBundle().putString(BUNDLE_ANNIEX_BID, getBid());
                intent.putExtras(config.getBundle());
                if (z) {
                }
                z2 = false;
                if (!z2) {
                }
                HybridLogger hybridLogger = HybridLogger.INSTANCE;
                Map mapOf = MapsKt.mapOf(TuplesKt.to(StreamTrafficObservable.STREAM_URL, schema.toString()));
                LoggerContext loggerContext = new LoggerContext();
                loggerContext.pushStage(MonitorCommonConstants.KEY_SESSION_ID, config.getSessionId());
                loggerContext.pushStage("callId", config.getCallId());
                Unit unit3 = Unit.INSTANCE;
                hybridLogger.i("XRouter", "create page container successfully", mapOf, loggerContext);
                return true;
            }
        } catch (Throwable th2) {
            th = th2;
            cls = null;
        }
        if (Result.isSuccess-impl(obj)) {
            HybridLogger.i$default(HybridLogger.INSTANCE, "XRouter", "get custom page container failed,use default container,url:" + schema, (Map) null, (LoggerContext) null, 12, (Object) null);
            cls = AnnieXDefaultActivity.class;
        } else if (cls == null) {
            cls = AnnieXDefaultActivity.class;
        }
        Intent intent2 = new Intent();
        intent2.setComponent(new ComponentName(context, (Class<?>) cls));
        intent2.setData(schema);
        z = context instanceof Activity;
        if (!z) {
            intent2.addFlags(268435456);
        }
        flags = config.getFlags();
        if (flags != null) {
            intent2.addFlags(flags.intValue());
        }
        config.getBundle().putString(BUNDLE_ANNIEX_BID, getBid());
        intent2.putExtras(config.getBundle());
        if (z || (requestCode = config.getRequestCode()) == null) {
            z2 = false;
        } else {
            int intValue = requestCode.intValue();
            Bundle animationBundle = config.getAnimationBundle();
            if (animationBundle != null) {
                ((Activity) context).startActivityForResult(intent2, intValue, animationBundle);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                ((Activity) context).startActivityForResult(intent2, intValue);
            }
            z2 = true;
        }
        if (!z2) {
            Bundle animationBundle2 = config.getAnimationBundle();
            if (animationBundle2 != null) {
                context.startActivity(intent2, animationBundle2);
                unit2 = Unit.INSTANCE;
            }
            if (unit2 == null) {
                context.startActivity(intent2);
            }
        }
        HybridLogger hybridLogger2 = HybridLogger.INSTANCE;
        Map mapOf2 = MapsKt.mapOf(TuplesKt.to(StreamTrafficObservable.STREAM_URL, schema.toString()));
        LoggerContext loggerContext2 = new LoggerContext();
        loggerContext2.pushStage(MonitorCommonConstants.KEY_SESSION_ID, config.getSessionId());
        loggerContext2.pushStage("callId", config.getCallId());
        Unit unit32 = Unit.INSTANCE;
        hybridLogger2.i("XRouter", "create page container successfully", mapOf2, loggerContext2);
        return true;
    }
}
