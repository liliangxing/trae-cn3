package com.bytedance.trae.common.apphost;

import android.app.Application;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager;
import com.bytedance.trae.common.apphost.time.AppClock;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;

/* compiled from: AppHost.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\bg\u0018\u0000 92\u00020\u0001:\u00019R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0012\u0010\u0010\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0012\u0010\u0012\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016R\u0012\u0010\u0018\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\rR\u0012\u0010\u001a\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0012\u0010\u001b\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016R\u0012\u0010\u001c\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\u0012\u0010\u001d\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\rR\u0012\u0010\u001f\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\tR\u0012\u0010!\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\rR\u0012\u0010#\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\tR\u0012\u0010%\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\tR\u0012\u0010'\u001a\u00020(X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0012\u0010+\u001a\u00020,X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u001e\u0010/\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020100X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0012\u00104\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\tR\u0012\u00106\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u0016R\u0012\u00108\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u0016¨\u0006:"}, d2 = {"Lcom/bytedance/trae/common/apphost/AppHost;", "", "application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "appId", "", "getAppId", "()I", "appName", "", "getAppName", "()Ljava/lang/String;", "appStringName", "getAppStringName", "defaultOfficialWebsiteName", "getDefaultOfficialWebsiteName", "defaultOfficialWebsiteUrl", "getDefaultOfficialWebsiteUrl", "isOversea", "", "()Z", "isDebug", "buildChannel", "getBuildChannel", "isTestChannel", "isDebugChannel", "isPlugin", "versionName", "getVersionName", "versionCode", "getVersionCode", "manifestVersionName", "getManifestVersionName", "manifestVersionCode", "getManifestVersionCode", "updateVersionCode", "getUpdateVersionCode", "activityStackManager", "Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;", "getActivityStackManager", "()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;", "appClock", "Lcom/bytedance/trae/common/apphost/time/AppClock;", "getAppClock", "()Lcom/bytedance/trae/common/apphost/time/AppClock;", "appStartTime", "Lkotlin/Pair;", "", "getAppStartTime", "()Lkotlin/Pair;", "appIconId", "getAppIconId", "supportCloudTest", "getSupportCloudTest", "isPreinstallApp", "Companion", "apphost_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface AppHost {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    ActivityStackManager getActivityStackManager();

    AppClock getAppClock();

    int getAppIconId();

    int getAppId();

    String getAppName();

    Pair<Long, Long> getAppStartTime();

    String getAppStringName();

    Application getApplication();

    String getBuildChannel();

    String getDefaultOfficialWebsiteName();

    String getDefaultOfficialWebsiteUrl();

    int getManifestVersionCode();

    String getManifestVersionName();

    boolean getSupportCloudTest();

    int getUpdateVersionCode();

    int getVersionCode();

    String getVersionName();

    boolean isDebug();

    boolean isDebugChannel();

    boolean isOversea();

    boolean isPlugin();

    boolean isPreinstallApp();

    boolean isTestChannel();

    /* compiled from: AppHost.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0014R\u0014\u0010\u001c\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0014R\u0014\u0010\u001e\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0010R\u0014\u0010 \u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0019R\u0014\u0010\"\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0019R\u0014\u0010#\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0019R\u0014\u0010$\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0014R\u0014\u0010&\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0019R\u0014\u0010'\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0019R\u0014\u0010(\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0014R\u0014\u0010*\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0010R\u0014\u0010,\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0019R\u0014\u0010-\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0014R\u0014\u0010/\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0010R\u0014\u00101\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0010R\u0014\u00103\u001a\u0002048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0014\u00107\u001a\u0002088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R \u0010;\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020=0<8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?¨\u0006@"}, d2 = {"Lcom/bytedance/trae/common/apphost/AppHost$Companion;", "Lcom/bytedance/trae/common/apphost/AppHost;", "<init>", "()V", "inst", "getInst", "()Lcom/bytedance/trae/common/apphost/AppHost;", "inst$delegate", "Lkotlin/Lazy;", "application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "appId", "", "getAppId", "()I", "appName", "", "getAppName", "()Ljava/lang/String;", "appStringName", "getAppStringName", "isOversea", "", "()Z", "defaultOfficialWebsiteName", "getDefaultOfficialWebsiteName", "defaultOfficialWebsiteUrl", "getDefaultOfficialWebsiteUrl", "appIconId", "getAppIconId", "supportCloudTest", "getSupportCloudTest", "isPreinstallApp", "isDebug", "buildChannel", "getBuildChannel", "isDebugChannel", "isPlugin", "versionName", "getVersionName", "versionCode", "getVersionCode", "isTestChannel", "manifestVersionName", "getManifestVersionName", "manifestVersionCode", "getManifestVersionCode", "updateVersionCode", "getUpdateVersionCode", "activityStackManager", "Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;", "getActivityStackManager", "()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;", "appClock", "Lcom/bytedance/trae/common/apphost/time/AppClock;", "getAppClock", "()Lcom/bytedance/trae/common/apphost/time/AppClock;", "appStartTime", "Lkotlin/Pair;", "", "getAppStartTime", "()Lkotlin/Pair;", "apphost_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion implements AppHost {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* renamed from: inst$delegate, reason: from kotlin metadata */
        private static final Lazy<AppHost> inst = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.common.apphost.AppHost$Companion$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                AppHost inst_delegate$lambda$0;
                inst_delegate$lambda$0 = AppHost.Companion.inst_delegate$lambda$0();
                return inst_delegate$lambda$0;
            }
        });

        private Companion() {
        }

        private final AppHost getInst() {
            return inst.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AppHost inst_delegate$lambda$0() {
            AppHost appHost = (AppHost) ServiceManager.get().getService(AppHost.class);
            if (appHost != null) {
                return appHost;
            }
            throw new IllegalStateException("app module must have an implementation of this service");
        }

        @Override // com.bytedance.trae.common.apphost.AppHost
        public Application getApplication() {
            return getInst().getApplication();
        }

        @Override // com.bytedance.trae.common.apphost.AppHost
        public int getAppId() {
            return getInst().getAppId();
        }

        @Override // com.bytedance.trae.common.apphost.AppHost
        public String getAppName() {
            return getInst().getAppName();
        }

        @Override // com.bytedance.trae.common.apphost.AppHost
        public String getAppStringName() {
            return getInst().getAppStringName();
        }

        @Override // com.bytedance.trae.common.apphost.AppHost
        public boolean isOversea() {
            return getInst().isOversea();
        }

        @Override // com.bytedance.trae.common.apphost.AppHost
        public String getDefaultOfficialWebsiteName() {
            return getInst().getDefaultOfficialWebsiteName();
        }

        @Override // com.bytedance.trae.common.apphost.AppHost
        public String getDefaultOfficialWebsiteUrl() {
            return getInst().getDefaultOfficialWebsiteUrl();
        }

        @Override // com.bytedance.trae.common.apphost.AppHost
        public int getAppIconId() {
            return getInst().getAppIconId();
        }

        @Override // com.bytedance.trae.common.apphost.AppHost
        public boolean getSupportCloudTest() {
            return getInst().getSupportCloudTest();
        }

        @Override // com.bytedance.trae.common.apphost.AppHost
        public boolean isPreinstallApp() {
            return getInst().isPreinstallApp();
        }

        @Override // com.bytedance.trae.common.apphost.AppHost
        public boolean isDebug() {
            return getInst().isDebug();
        }

        @Override // com.bytedance.trae.common.apphost.AppHost
        public String getBuildChannel() {
            return getInst().getBuildChannel();
        }

        @Override // com.bytedance.trae.common.apphost.AppHost
        public boolean isDebugChannel() {
            return getInst().isDebugChannel();
        }

        @Override // com.bytedance.trae.common.apphost.AppHost
        public boolean isPlugin() {
            return getInst().isPlugin();
        }

        @Override // com.bytedance.trae.common.apphost.AppHost
        public String getVersionName() {
            return getInst().getVersionName();
        }

        @Override // com.bytedance.trae.common.apphost.AppHost
        public int getVersionCode() {
            return getInst().getVersionCode();
        }

        @Override // com.bytedance.trae.common.apphost.AppHost
        public boolean isTestChannel() {
            return getInst().isTestChannel();
        }

        @Override // com.bytedance.trae.common.apphost.AppHost
        public String getManifestVersionName() {
            return getInst().getManifestVersionName();
        }

        @Override // com.bytedance.trae.common.apphost.AppHost
        public int getManifestVersionCode() {
            return getInst().getManifestVersionCode();
        }

        @Override // com.bytedance.trae.common.apphost.AppHost
        public int getUpdateVersionCode() {
            return getInst().getUpdateVersionCode();
        }

        @Override // com.bytedance.trae.common.apphost.AppHost
        public ActivityStackManager getActivityStackManager() {
            return getInst().getActivityStackManager();
        }

        @Override // com.bytedance.trae.common.apphost.AppHost
        public AppClock getAppClock() {
            return getInst().getAppClock();
        }

        @Override // com.bytedance.trae.common.apphost.AppHost
        public Pair<Long, Long> getAppStartTime() {
            return getInst().getAppStartTime();
        }
    }
}
