package com.bytedance.trae.update;

import android.content.Context;
import com.bytedance.services.app.common.context.api.AppCommonContext;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.update.bits.impl.BuildConfig;
import kotlin.Metadata;

/* compiled from: IBitsUpdateImpl.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/update/TraeAppCommonContext;", "Lcom/bytedance/services/app/common/context/api/AppCommonContext;", "<init>", "()V", "getContext", "Landroid/content/Context;", "getStringAppName", "", "getAppName", "getVersion", "getFeedbackAppKey", "getChannel", "getTweakedChannel", "getVersionCode", "", "getDeviceId", "getUpdateVersionCode", "getManifestVersionCode", "getManifestVersion", "getAid", "getSdkAppId", "getAbClient", "getAbFlag", "", "getAbVersion", "getAbGroup", "getAbFeature", "bits-impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeAppCommonContext implements AppCommonContext {
    public String getAbClient() {
        return "";
    }

    public String getAbFeature() {
        return "";
    }

    public long getAbFlag() {
        return 0L;
    }

    public String getAbGroup() {
        return "";
    }

    public String getAbVersion() {
        return "";
    }

    public int getAid() {
        return BuildConfig.BITS_APP_ID;
    }

    public String getFeedbackAppKey() {
        return "";
    }

    public String getSdkAppId() {
        return "943841";
    }

    public Context getContext() {
        return AppHost.Companion.getApplication();
    }

    public String getStringAppName() {
        return AppHost.Companion.getAppStringName();
    }

    public String getAppName() {
        return AppHost.Companion.getAppName();
    }

    public String getVersion() {
        return AppHost.Companion.getVersionName();
    }

    public String getChannel() {
        return AppHost.Companion.getBuildChannel();
    }

    public String getTweakedChannel() {
        return AppHost.Companion.getBuildChannel();
    }

    public int getVersionCode() {
        return AppHost.Companion.getVersionCode();
    }

    public String getDeviceId() {
        return IApplog.Companion.getDeviceId();
    }

    public int getUpdateVersionCode() {
        return AppHost.Companion.getUpdateVersionCode();
    }

    public int getManifestVersionCode() {
        return AppHost.Companion.getManifestVersionCode();
    }

    public String getManifestVersion() {
        return AppHost.Companion.getManifestVersionName();
    }
}
