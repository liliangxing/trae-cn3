package com.bytedance.trae.applog.impl;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.applog.IAppLogInstance;
import com.bytedance.applog.InitConfig;
import com.bytedance.applog.util.EventsSenderUtils;
import com.bytedance.news.common.settings.api.exposed.ExposedManager;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.applog.api.BDTrackerConsts;
import com.bytedance.trae.applog.api.IMultiInstanceAppLog;
import com.bytedance.trae.applog.api.MultiInstanceAppLogInitConfig;
import com.bytedance.trae.common.apphost.AppHost;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: MultiInstanceAppLogServiceImpl.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J,\u0010\u0013\u001a\u00020\u00072\"\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00160\u0015j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0016`\u0017H\u0016J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/applog/impl/MultiInstanceAppLog;", "Lcom/bytedance/trae/applog/api/IMultiInstanceAppLog;", "instance", "Lcom/bytedance/applog/IAppLogInstance;", "<init>", "(Lcom/bytedance/applog/IAppLogInstance;)V", "init", "", "context", "Landroid/content/Context;", "config", "Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;", "reportEvent", Fields.EVENT, "", "jsonParams", "Lorg/json/JSONObject;", "bundleParams", "Landroid/os/Bundle;", "setHeaderInfo", "custom", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "key", "value", "removeHeaderInfo", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MultiInstanceAppLog implements IMultiInstanceAppLog {
    private final IAppLogInstance instance;

    public MultiInstanceAppLog(IAppLogInstance iAppLogInstance) {
        Intrinsics.checkNotNullParameter(iAppLogInstance, "instance");
        this.instance = iAppLogInstance;
    }

    @Override // com.bytedance.trae.applog.api.IMultiInstanceAppLog
    public void init(Context context, MultiInstanceAppLogInitConfig config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        InitConfig initConfig = new InitConfig(String.valueOf(config.getAppId()), config.getChannel());
        initConfig.setAppName(config.getAppName());
        initConfig.setUriConfig(BDTrackerConfigs.INSTANCE.uriConfig(config.isBoe()));
        initConfig.setNetworkClient(new MultiInstanceAppLogNetworkClient());
        initConfig.setAutoStart(true);
        initConfig.setHandleLifeCycle(true);
        initConfig.setVersionCode(config.getVersionCode());
        initConfig.setVersion(config.getVersionName());
        initConfig.setUpdateVersionCode(config.getUpdateVersinCode());
        initConfig.setLogger(new AppLogLogger("AppLog_" + config.getAppId()));
        BDTrackerConfigs.INSTANCE.configSensitiveApi(initConfig);
        this.instance.setEncryptAndCompress(!AppHost.INSTANCE.isDebug());
        this.instance.init(context, initConfig);
        this.instance.setExternalAbVersion(ExposedManager.getInstance(AppHost.INSTANCE.getApplication()).getExposedVids());
        this.instance.addDataObserver(new MultiInstanceAppLogDataObserver());
        if (AppHost.INSTANCE.isDebug() || AppHost.INSTANCE.isTestChannel()) {
            EventsSenderUtils.setEventsSenderEnable(this.instance.getAppId().toString(), true, AppHost.INSTANCE.getApplication());
            if (AppHost.INSTANCE.isOversea()) {
                EventsSenderUtils.setEventVerifyHost(this.instance.getAppId().toString(), BDTrackerConsts.EVENT_VERIFY_OVERSEA_HOST);
            } else {
                EventsSenderUtils.setEventVerifyHost(this.instance.getAppId().toString(), BDTrackerConsts.EVENT_VERIFY_HOST);
            }
        }
    }

    @Override // com.bytedance.trae.applog.api.IMultiInstanceAppLog
    public void reportEvent(String event) {
        Intrinsics.checkNotNullParameter(event, Fields.EVENT);
        this.instance.onEventV3(event);
    }

    @Override // com.bytedance.trae.applog.api.IMultiInstanceAppLog
    public void reportEvent(String event, JSONObject jsonParams) {
        Intrinsics.checkNotNullParameter(event, Fields.EVENT);
        this.instance.onEventV3(event, jsonParams);
    }

    @Override // com.bytedance.trae.applog.api.IMultiInstanceAppLog
    public void reportEvent(String event, Bundle bundleParams) {
        Intrinsics.checkNotNullParameter(event, Fields.EVENT);
        this.instance.onEventV3(event, bundleParams);
    }

    @Override // com.bytedance.trae.applog.api.IMultiInstanceAppLog
    public void setHeaderInfo(HashMap<String, Object> custom) {
        Intrinsics.checkNotNullParameter(custom, "custom");
        this.instance.setHeaderInfo(custom);
    }

    @Override // com.bytedance.trae.applog.api.IMultiInstanceAppLog
    public void setHeaderInfo(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.instance.setHeaderInfo(key, value);
    }

    @Override // com.bytedance.trae.applog.api.IMultiInstanceAppLog
    public void removeHeaderInfo(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.instance.removeHeaderInfo(key);
    }
}
