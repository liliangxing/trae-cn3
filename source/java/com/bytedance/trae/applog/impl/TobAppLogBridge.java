package com.bytedance.trae.applog.impl;

import com.bytedance.tobshadow.applog.AppLog;
import com.bytedance.tobshadow.applog.IAppLogInstance;
import com.bytedance.tobshadow.applog.InitConfig;
import com.bytedance.tobshadow.applog.UriConfig;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.applog.api.AppLogConfigInfo;
import com.bytedance.trae.common.apphost.AppHost;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: TobAppLogBridge.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0005J\u0016\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/applog/impl/TobAppLogBridge;", "", "<init>", "()V", "TOB_AID", "", "TOB_DOMAIN", "tobAppLogInstance", "Lcom/bytedance/tobshadow/applog/IAppLogInstance;", "isSupported", "", "init", "configInfo", "Lcom/bytedance/trae/applog/api/AppLogConfigInfo;", "setHeaderInfo", "", "key", "value", "setUserUniqueID", "userId", "getDid", "onEventV3", Fields.EVENT, "params", "Lorg/json/JSONObject;", "onMiscEvent", "logType", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TobAppLogBridge {
    public static final TobAppLogBridge INSTANCE = new TobAppLogBridge();
    private static final String TOB_AID = "20014039";
    private static final String TOB_DOMAIN = "https://gator.volces.com";
    private static volatile IAppLogInstance tobAppLogInstance;

    public final boolean isSupported() {
        return true;
    }

    private TobAppLogBridge() {
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean init(AppLogConfigInfo configInfo) {
        Object obj;
        InitConfig autoStart;
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(configInfo, "configInfo");
        boolean z3 = true;
        if (tobAppLogInstance != null) {
            return true;
        }
        try {
            Result.Companion companion = Result.Companion;
            TobAppLogBridge tobAppLogBridge = this;
            autoStart = new InitConfig(TOB_AID, configInfo.getChannel()).setAppName(configInfo.getAppName()).setVersion(configInfo.getVersionName()).setVersionCode(configInfo.getVersionCode()).setUpdateVersionCode(configInfo.getUpdateVersionCode()).setAutoStart(true);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (!AppHost.INSTANCE.isDebug() && !AppHost.INSTANCE.isTestChannel()) {
            z = false;
            InitConfig localTest = autoStart.setLocalTest(z);
            if (!AppHost.INSTANCE.isDebug() && !AppHost.INSTANCE.isTestChannel()) {
                z2 = false;
                InitConfig uriConfig = localTest.setLogEnable(z2).setDbName("tob_applog.db").setSpName("tob_applog_sp").setUriConfig(UriConfig.createByDomain(TOB_DOMAIN, null));
                uriConfig.setHandleLifeCycle(false);
                uriConfig.setAbEnable(false);
                uriConfig.setAutoTrackEnabled(false);
                uriConfig.setTrackEventEnabled(true);
                IAppLogInstance newInstance = AppLog.newInstance();
                if (!AppHost.INSTANCE.isDebug()) {
                    z3 = false;
                }
                newInstance.setEncryptAndCompress(z3);
                newInstance.init(AppHost.INSTANCE.getApplication(), uriConfig);
                tobAppLogInstance = newInstance;
                obj = Result.constructor-impl(Unit.INSTANCE);
                return Result.isSuccess-impl(obj);
            }
            z2 = true;
            InitConfig uriConfig2 = localTest.setLogEnable(z2).setDbName("tob_applog.db").setSpName("tob_applog_sp").setUriConfig(UriConfig.createByDomain(TOB_DOMAIN, null));
            uriConfig2.setHandleLifeCycle(false);
            uriConfig2.setAbEnable(false);
            uriConfig2.setAutoTrackEnabled(false);
            uriConfig2.setTrackEventEnabled(true);
            IAppLogInstance newInstance2 = AppLog.newInstance();
            if (!AppHost.INSTANCE.isDebug()) {
            }
            newInstance2.setEncryptAndCompress(z3);
            newInstance2.init(AppHost.INSTANCE.getApplication(), uriConfig2);
            tobAppLogInstance = newInstance2;
            obj = Result.constructor-impl(Unit.INSTANCE);
            return Result.isSuccess-impl(obj);
        }
        z = true;
        InitConfig localTest2 = autoStart.setLocalTest(z);
        if (!AppHost.INSTANCE.isDebug()) {
            z2 = false;
            InitConfig uriConfig22 = localTest2.setLogEnable(z2).setDbName("tob_applog.db").setSpName("tob_applog_sp").setUriConfig(UriConfig.createByDomain(TOB_DOMAIN, null));
            uriConfig22.setHandleLifeCycle(false);
            uriConfig22.setAbEnable(false);
            uriConfig22.setAutoTrackEnabled(false);
            uriConfig22.setTrackEventEnabled(true);
            IAppLogInstance newInstance22 = AppLog.newInstance();
            if (!AppHost.INSTANCE.isDebug()) {
            }
            newInstance22.setEncryptAndCompress(z3);
            newInstance22.init(AppHost.INSTANCE.getApplication(), uriConfig22);
            tobAppLogInstance = newInstance22;
            obj = Result.constructor-impl(Unit.INSTANCE);
            return Result.isSuccess-impl(obj);
        }
        z2 = true;
        InitConfig uriConfig222 = localTest2.setLogEnable(z2).setDbName("tob_applog.db").setSpName("tob_applog_sp").setUriConfig(UriConfig.createByDomain(TOB_DOMAIN, null));
        uriConfig222.setHandleLifeCycle(false);
        uriConfig222.setAbEnable(false);
        uriConfig222.setAutoTrackEnabled(false);
        uriConfig222.setTrackEventEnabled(true);
        IAppLogInstance newInstance222 = AppLog.newInstance();
        if (!AppHost.INSTANCE.isDebug()) {
        }
        newInstance222.setEncryptAndCompress(z3);
        newInstance222.init(AppHost.INSTANCE.getApplication(), uriConfig222);
        tobAppLogInstance = newInstance222;
        obj = Result.constructor-impl(Unit.INSTANCE);
        return Result.isSuccess-impl(obj);
    }

    public final void setHeaderInfo(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        IAppLogInstance iAppLogInstance = tobAppLogInstance;
        if (iAppLogInstance != null) {
            iAppLogInstance.setHeaderInfo(key, value);
        }
    }

    public final void setUserUniqueID(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        IAppLogInstance iAppLogInstance = tobAppLogInstance;
        if (iAppLogInstance != null) {
            iAppLogInstance.setUserUniqueID(userId);
        }
    }

    public final String getDid() {
        IAppLogInstance iAppLogInstance = tobAppLogInstance;
        String did = iAppLogInstance != null ? iAppLogInstance.getDid() : null;
        return did == null ? "" : did;
    }

    public final void onEventV3(String event, JSONObject params) {
        Intrinsics.checkNotNullParameter(event, Fields.EVENT);
        Intrinsics.checkNotNullParameter(params, "params");
        IAppLogInstance iAppLogInstance = tobAppLogInstance;
        if (iAppLogInstance != null) {
            iAppLogInstance.onEventV3(event, params);
        }
    }

    public final void onMiscEvent(String logType, JSONObject params) {
        Intrinsics.checkNotNullParameter(logType, "logType");
        Intrinsics.checkNotNullParameter(params, "params");
        IAppLogInstance iAppLogInstance = tobAppLogInstance;
        if (iAppLogInstance != null) {
            iAppLogInstance.onMiscEvent(logType, params);
        }
    }
}
