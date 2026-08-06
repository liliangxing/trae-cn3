package com.bytedance.ies.bullet.service.base.api;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.kit.resourceloader.loader.LoaderUtil;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.utils.XConstant;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.schema.utils.SchemaUtilsKt;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IServiceContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0018\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a\u0018\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\b"}, d2 = {"createSessionID", "", "getOrCreateAnnieXSessionID", "url", "Landroid/net/Uri;", SchemaConstants.QUERY_KEY_BUNDLE, "Landroid/os/Bundle;", "getOrCreateSessionID", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class IServiceContextKt {
    public static final String getOrCreateSessionID(Uri uri, Bundle bundle) {
        Intrinsics.checkNotNullParameter(uri, "url");
        String string = bundle != null ? bundle.getString("__x_session_id") : null;
        String str = string;
        if (str == null || str.length() == 0) {
            String queryParameter = uri.getQueryParameter(XConstant.START_SESSION_KEY);
            String queryParameter2 = uri.getQueryParameter(XConstant.BRIDGE_CALL_ID);
            SchemaUtilsKt.removeQueryParameterSafely(uri, XConstant.START_SESSION_KEY);
            string = createSessionID();
            if (LoaderUtil.INSTANCE.isNotNullOrEmpty(queryParameter)) {
                HybridLogger hybridLogger = HybridLogger.INSTANCE;
                LoggerContext loggerContext = new LoggerContext();
                if (queryParameter2 == null) {
                    queryParameter2 = "";
                }
                loggerContext.pushStage(XConstant.CALL_ID, queryParameter2);
                loggerContext.pushStage("sessionId", string);
                if (queryParameter == null) {
                    queryParameter = "";
                }
                loggerContext.pushStage("originSessionId", queryParameter);
                Unit unit = Unit.INSTANCE;
                hybridLogger.m11i("XRouter", "associated session", null, loggerContext);
            }
            if (!IConditionCallKt.disableAddSessionId() && bundle != null) {
                bundle.putString("__x_session_id", string);
            }
        }
        return string;
    }

    public static final String createSessionID() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        if (BulletEnv.INSTANCE.getInstance().getDebuggable()) {
            BulletLogger.printCoreReject$default(BulletLogger.INSTANCE, uuid, "create sessionId. just print for local_test, take it easy = ", "XRouter", new Throwable(), null, 16, null);
        } else {
            BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, uuid, "create sessionId.", "XRouter", null, 8, null);
        }
        return uuid;
    }

    public static final String getOrCreateAnnieXSessionID(Uri uri, Bundle bundle) {
        Intrinsics.checkNotNullParameter(uri, "url");
        if (IConditionCallKt.annieFlowEnableUrlSessionId()) {
            String queryParameterSafely = SchemaUtilsKt.getQueryParameterSafely(uri, "__x_session_id");
            if (queryParameterSafely == null) {
                queryParameterSafely = bundle != null ? bundle.getString("__x_session_id") : null;
            }
            String str = queryParameterSafely;
            if (str == null || str.length() == 0) {
                String queryParameter = uri.getQueryParameter(XConstant.START_SESSION_KEY);
                String queryParameter2 = uri.getQueryParameter(XConstant.BRIDGE_CALL_ID);
                SchemaUtilsKt.removeQueryParameterSafely(uri, XConstant.START_SESSION_KEY);
                queryParameterSafely = createSessionID();
                if (LoaderUtil.INSTANCE.isNotNullOrEmpty(queryParameter)) {
                    HybridLogger hybridLogger = HybridLogger.INSTANCE;
                    LoggerContext loggerContext = new LoggerContext();
                    if (queryParameter2 == null) {
                        queryParameter2 = "";
                    }
                    loggerContext.pushStage(XConstant.CALL_ID, queryParameter2);
                    loggerContext.pushStage("sessionId", queryParameterSafely);
                    if (queryParameter == null) {
                        queryParameter = "";
                    }
                    loggerContext.pushStage("originSessionId", queryParameter);
                    Unit unit = Unit.INSTANCE;
                    hybridLogger.m11i("XRouter", "associated session", null, loggerContext);
                }
                if (!IConditionCallKt.disableAddSessionId() && bundle != null) {
                    bundle.putString("__x_session_id", queryParameterSafely);
                }
            }
            return queryParameterSafely;
        }
        return getOrCreateSessionID(uri, bundle);
    }
}
