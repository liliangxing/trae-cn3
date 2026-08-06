package com.bytedance.trae.service;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.common.utility.android.ManifestData;
import com.bytedance.memory.api.MemoryApi;
import com.bytedance.trae.ActivityManager;
import com.bytedance.trae.ApkProperties;
import com.bytedance.trae.AppClockImpl;
import com.bytedance.trae.TraeApplication;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager;
import com.bytedance.trae.common.apphost.time.AppClock;
import com.bytedance.trae.network.HttpConst;
import com.bytedance.trae.update.bits.impl.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppHostImpl.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001aX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0018R\u0014\u0010!\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010$R\u0014\u0010&\u001a\u00020\"X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0014\u0010'\u001a\u00020\"X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b'\u0010$R\u0014\u0010(\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0014\u0010*\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001cR\u001b\u0010,\u001a\u00020\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b-\u0010\u001cR\u0014\u00100\u001a\u00020\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010$R\u0014\u00101\u001a\u00020\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010$R\u0014\u00102\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u001cR\u0014\u00104\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u0018R\u0014\u00106\u001a\u00020\u001aX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u001cR\u0014\u00108\u001a\u00020\u0016X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0018R\u0014\u0010:\u001a\u00020\u0016X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0018R\u0014\u0010<\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010$¨\u0006="}, d2 = {"Lcom/bytedance/trae/service/AppHostImpl;", "Lcom/bytedance/trae/common/apphost/AppHost;", "<init>", "()V", "application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "activityStackManager", "Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;", "getActivityStackManager", "()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;", "appClock", "Lcom/bytedance/trae/common/apphost/time/AppClock;", "getAppClock", "()Lcom/bytedance/trae/common/apphost/time/AppClock;", "appStartTime", "Lkotlin/Pair;", "", "getAppStartTime", "()Lkotlin/Pair;", "appId", "", "getAppId", "()I", "appName", "", "getAppName", "()Ljava/lang/String;", "appStringName", "getAppStringName", "appIconId", "getAppIconId", "supportCloudTest", "", "getSupportCloudTest", "()Z", "isPreinstallApp", "isDebug", "isOversea", "defaultOfficialWebsiteName", "getDefaultOfficialWebsiteName", "defaultOfficialWebsiteUrl", "getDefaultOfficialWebsiteUrl", "buildChannel", "getBuildChannel", "buildChannel$delegate", "Lkotlin/Lazy;", "isTestChannel", "isDebugChannel", "versionName", "getVersionName", "versionCode", "getVersionCode", "manifestVersionName", "getManifestVersionName", "manifestVersionCode", "getManifestVersionCode", "updateVersionCode", "getUpdateVersionCode", "isPlugin", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AppHostImpl implements AppHost {
    public static final int $stable = 8;
    private final boolean isDebug;
    private final boolean isDebugChannel;
    private final boolean isOversea;
    private final Application application = TraeApplication.Companion.getInst();
    private final ActivityStackManager activityStackManager = new ActivityManager(getApplication());
    private final AppClock appClock = new AppClockImpl();
    private final Pair<Long, Long> appStartTime = TraeApplication.Companion.getInst().getStartTime();
    private final int appId = BuildConfig.BITS_APP_ID;
    private final String appName = "trae";
    private final String defaultOfficialWebsiteName = HttpConst.INSTANCE.getONLINE_BASE_HOST();
    private final String defaultOfficialWebsiteUrl = HttpConst.INSTANCE.getONLINE_WWW();

    /* renamed from: buildChannel$delegate, reason: from kotlin metadata */
    private final Lazy buildChannel = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.service.AppHostImpl$$ExternalSyntheticLambda0
        public final Object invoke() {
            String buildChannel_delegate$lambda$1;
            buildChannel_delegate$lambda$1 = AppHostImpl.buildChannel_delegate$lambda$1(AppHostImpl.this);
            return buildChannel_delegate$lambda$1;
        }
    });
    private final boolean isTestChannel = SetsKt.setOf(new String[]{MemoryApi.DEBUG, "local_test"}).contains("release");
    private final String manifestVersionName = "0.0.16";
    private final int manifestVersionCode = 21;
    private final int updateVersionCode = 160200;

    public int getAppIconId() {
        return 2131492866;
    }

    public boolean getSupportCloudTest() {
        return false;
    }

    public boolean isPlugin() {
        return false;
    }

    public boolean isPreinstallApp() {
        return false;
    }

    public Application getApplication() {
        return this.application;
    }

    public ActivityStackManager getActivityStackManager() {
        return this.activityStackManager;
    }

    public AppClock getAppClock() {
        return this.appClock;
    }

    public Pair<Long, Long> getAppStartTime() {
        return this.appStartTime;
    }

    public int getAppId() {
        return this.appId;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAppStringName() {
        String string = getApplication().getString(2131689519);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    /* renamed from: isDebug, reason: from getter */
    public boolean getIsDebug() {
        return this.isDebug;
    }

    /* renamed from: isOversea, reason: from getter */
    public boolean getIsOversea() {
        return this.isOversea;
    }

    public String getDefaultOfficialWebsiteName() {
        return this.defaultOfficialWebsiteName;
    }

    public String getDefaultOfficialWebsiteUrl() {
        return this.defaultOfficialWebsiteUrl;
    }

    public String getBuildChannel() {
        Object value = this.buildChannel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (String) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String buildChannel_delegate$lambda$1(AppHostImpl appHostImpl) {
        String str;
        return ApkProperties.inst(appHostImpl.getApplication()).getString("meta_umeng_channel", str.length() == 0 ? MemoryApi.DEBUG : "release");
    }

    /* renamed from: isTestChannel, reason: from getter */
    public boolean getIsTestChannel() {
        return this.isTestChannel;
    }

    /* renamed from: isDebugChannel, reason: from getter */
    public boolean getIsDebugChannel() {
        return this.isDebugChannel;
    }

    public String getVersionName() {
        String str;
        try {
            str = ManifestData.getString(getApplication(), "SS_VERSION_NAME");
        } catch (Exception unused) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return getManifestVersionName();
        }
        return String.valueOf(str);
    }

    public int getVersionCode() {
        int i;
        try {
            i = ManifestData.getInt(getApplication(), "SS_VERSION_CODE");
        } catch (Exception unused) {
            i = 0;
        }
        return (i == -1 || i == 0) ? getManifestVersionCode() : i;
    }

    public String getManifestVersionName() {
        return this.manifestVersionName;
    }

    public int getManifestVersionCode() {
        return this.manifestVersionCode;
    }

    public int getUpdateVersionCode() {
        return this.updateVersionCode;
    }
}
