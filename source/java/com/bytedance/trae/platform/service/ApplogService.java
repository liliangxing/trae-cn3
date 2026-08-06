package com.bytedance.trae.platform.service;

import android.os.Bundle;
import com.bytedance.push.interfaze.ISignalReportService;
import com.bytedance.trae.platform.ITraeSdkCommonDepend;
import com.bytedance.trae.platform.api.IApplogIdCallback;
import com.bytedance.trae.platform.api.ISdkApplog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ApplogService.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\fH\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J\u001c\u0010\u0018\u001a\u00020\n2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020!H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\""}, d2 = {"Lcom/bytedance/trae/platform/service/ApplogService;", "Lcom/bytedance/trae/platform/api/ISdkApplog;", "<init>", "()V", "service", "getService", "()Lcom/bytedance/trae/platform/api/ISdkApplog;", "service$delegate", "Lkotlin/Lazy;", "reportEvent", "", ISignalReportService.BODY_KEY_EVENT, "", "jsonParams", "Lorg/json/JSONObject;", "bundleParams", "Landroid/os/Bundle;", "addApplogIdCallback", "callback", "Lcom/bytedance/trae/platform/api/IApplogIdCallback;", "getDeviceId", "getUserUniqueID", "getUserID", "getInstallId", "putCommonParams", "params", "", "changeBgSessionTask", "resume", "", "setHeaderInfo", "key", "value", "", "platform_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ApplogService implements ISdkApplog {
    public static final ApplogService INSTANCE = new ApplogService();

    /* renamed from: service$delegate, reason: from kotlin metadata */
    private static final Lazy service = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.platform.service.ApplogService$$ExternalSyntheticLambda0
        public final Object invoke() {
            ISdkApplog service_delegate$lambda$0;
            service_delegate$lambda$0 = ApplogService.service_delegate$lambda$0();
            return service_delegate$lambda$0;
        }
    });

    private ApplogService() {
    }

    private final ISdkApplog getService() {
        return (ISdkApplog) service.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ISdkApplog service_delegate$lambda$0() {
        ITraeSdkCommonDepend iTraeSdkCommonDepend = (ITraeSdkCommonDepend) ServiceManager.get().getService(ITraeSdkCommonDepend.class);
        if (iTraeSdkCommonDepend != null) {
            return iTraeSdkCommonDepend.getApplogService();
        }
        return null;
    }

    @Override // com.bytedance.trae.platform.api.ISdkApplog
    public void reportEvent(String event, JSONObject jsonParams) {
        Intrinsics.checkNotNullParameter(event, ISignalReportService.BODY_KEY_EVENT);
        ISdkApplog service2 = getService();
        if (service2 != null) {
            service2.reportEvent(event, jsonParams);
        }
    }

    @Override // com.bytedance.trae.platform.api.ISdkApplog
    public void reportEvent(String event, Bundle bundleParams) {
        Intrinsics.checkNotNullParameter(event, ISignalReportService.BODY_KEY_EVENT);
        ISdkApplog service2 = getService();
        if (service2 != null) {
            service2.reportEvent(event, bundleParams);
        }
    }

    @Override // com.bytedance.trae.platform.api.ISdkApplog
    public void addApplogIdCallback(IApplogIdCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ISdkApplog service2 = getService();
        if (service2 != null) {
            service2.addApplogIdCallback(callback);
        }
    }

    @Override // com.bytedance.trae.platform.api.ISdkApplog
    public String getDeviceId() {
        String deviceId;
        ISdkApplog service2 = getService();
        return (service2 == null || (deviceId = service2.getDeviceId()) == null) ? "" : deviceId;
    }

    @Override // com.bytedance.trae.platform.api.ISdkApplog
    public String getUserUniqueID() {
        String userUniqueID;
        ISdkApplog service2 = getService();
        return (service2 == null || (userUniqueID = service2.getUserUniqueID()) == null) ? "" : userUniqueID;
    }

    @Override // com.bytedance.trae.platform.api.ISdkApplog
    public String getUserID() {
        String userID;
        ISdkApplog service2 = getService();
        return (service2 == null || (userID = service2.getUserID()) == null) ? "" : userID;
    }

    @Override // com.bytedance.trae.platform.api.ISdkApplog
    public String getInstallId() {
        String installId;
        ISdkApplog service2 = getService();
        return (service2 == null || (installId = service2.getInstallId()) == null) ? "" : installId;
    }

    @Override // com.bytedance.trae.platform.api.ISdkApplog
    public void putCommonParams(Map<String, String> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        ISdkApplog service2 = getService();
        if (service2 != null) {
            service2.putCommonParams(params);
        }
    }

    @Override // com.bytedance.trae.platform.api.ISdkApplog
    public void changeBgSessionTask(boolean resume) {
        ISdkApplog service2 = getService();
        if (service2 != null) {
            service2.changeBgSessionTask(resume);
        }
    }

    @Override // com.bytedance.trae.platform.api.ISdkApplog
    public void setHeaderInfo(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        ISdkApplog service2 = getService();
        if (service2 != null) {
            service2.setHeaderInfo(key, value);
        }
    }
}
