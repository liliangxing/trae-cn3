package com.bytedance.trae.service;

import android.os.Bundle;
import com.bytedance.push.interfaze.ISignalReportService;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.applog.api.OnGetAppLogIdListener;
import com.bytedance.trae.platform.api.IApplogIdCallback;
import com.bytedance.trae.platform.api.ISdkApplog;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ApplogServiceImpl.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u001c\u0010\u0013\u001a\u00020\u00052\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cH\u0016¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/service/ApplogServiceImpl;", "Lcom/bytedance/trae/platform/api/ISdkApplog;", "<init>", "()V", "reportEvent", "", ISignalReportService.BODY_KEY_EVENT, "", "jsonParams", "Lorg/json/JSONObject;", "bundleParams", "Landroid/os/Bundle;", "addApplogIdCallback", "callback", "Lcom/bytedance/trae/platform/api/IApplogIdCallback;", "getDeviceId", "getUserUniqueID", "getUserID", "getInstallId", "putCommonParams", "params", "", "changeBgSessionTask", "resume", "", "setHeaderInfo", "key", "value", "", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ApplogServiceImpl implements ISdkApplog {
    public static final int $stable = 0;
    public static final ApplogServiceImpl INSTANCE = new ApplogServiceImpl();

    private ApplogServiceImpl() {
    }

    @Override // com.bytedance.trae.platform.api.ISdkApplog
    public void reportEvent(String event, JSONObject jsonParams) {
        Intrinsics.checkNotNullParameter(event, ISignalReportService.BODY_KEY_EVENT);
        IApplog.Companion.reportEvent(event, jsonParams);
    }

    @Override // com.bytedance.trae.platform.api.ISdkApplog
    public void reportEvent(String event, Bundle bundleParams) {
        Intrinsics.checkNotNullParameter(event, ISignalReportService.BODY_KEY_EVENT);
        IApplog.Companion.reportEvent(event, bundleParams);
    }

    @Override // com.bytedance.trae.platform.api.ISdkApplog
    public void addApplogIdCallback(final IApplogIdCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        IApplog.Companion.addGetAppLogIdListener(new OnGetAppLogIdListener() { // from class: com.bytedance.trae.service.ApplogServiceImpl$addApplogIdCallback$1
            public void onGetId(String did, String iid, String ssid) {
                Intrinsics.checkNotNullParameter(did, CommonConstants.KEY_DEVICE_ID);
                Intrinsics.checkNotNullParameter(iid, "iid");
                Intrinsics.checkNotNullParameter(ssid, "ssid");
                IApplogIdCallback.this.onGetId(did, iid, ssid);
                if (IApplogIdCallback.this.onlyOnce()) {
                    IApplog.Companion.removeDidListener(this);
                }
            }
        });
    }

    @Override // com.bytedance.trae.platform.api.ISdkApplog
    public String getDeviceId() {
        return IApplog.Companion.getDeviceId();
    }

    @Override // com.bytedance.trae.platform.api.ISdkApplog
    public String getUserUniqueID() {
        return IApplog.Companion.getUserUniqueID();
    }

    @Override // com.bytedance.trae.platform.api.ISdkApplog
    public String getUserID() {
        return IApplog.Companion.getUserID();
    }

    @Override // com.bytedance.trae.platform.api.ISdkApplog
    public String getInstallId() {
        return IApplog.Companion.getInstallId();
    }

    @Override // com.bytedance.trae.platform.api.ISdkApplog
    public void putCommonParams(Map<String, String> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        IApplog.Companion.putCommonParams(params);
    }

    @Override // com.bytedance.trae.platform.api.ISdkApplog
    public void changeBgSessionTask(boolean resume) {
        if (resume) {
            IApplog.Companion.onBgSessionTaskResume();
        } else {
            IApplog.Companion.onBgSessionTaskPause();
        }
    }

    @Override // com.bytedance.trae.platform.api.ISdkApplog
    public void setHeaderInfo(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        IApplog.Companion.setHeaderInfo(key, value);
    }
}
