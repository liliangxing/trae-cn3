# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/common/apphost/AppHost;
.super Ljava/lang/Object;
.source "AppHost.kt"

.field public static final Companion:Lcom/bytedance/trae/common/apphost/AppHost$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->$$INSTANCE Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    sput-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    return-void 
.end method

.method public abstract getActivityStackManager()com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager
    # abstract or native
.end method

.method public abstract getAppClock()com.bytedance.trae.common.apphost.time.AppClock
    # abstract or native
.end method

.method public abstract getAppIconId()int
    # abstract or native
.end method

.method public abstract getAppId()int
    # abstract or native
.end method

.method public abstract getAppName()java.lang.String
    # abstract or native
.end method

.method public abstract getAppStartTime()kotlin.Pair
    # abstract or native
.end method

.method public abstract getAppStringName()java.lang.String
    # abstract or native
.end method

.method public abstract getApplication()android.app.Application
    # abstract or native
.end method

.method public abstract getBuildChannel()java.lang.String
    # abstract or native
.end method

.method public abstract getDefaultOfficialWebsiteName()java.lang.String
    # abstract or native
.end method

.method public abstract getDefaultOfficialWebsiteUrl()java.lang.String
    # abstract or native
.end method

.method public abstract getManifestVersionCode()int
    # abstract or native
.end method

.method public abstract getManifestVersionName()java.lang.String
    # abstract or native
.end method

.method public abstract getSupportCloudTest()boolean
    # abstract or native
.end method

.method public abstract getUpdateVersionCode()int
    # abstract or native
.end method

.method public abstract getVersionCode()int
    # abstract or native
.end method

.method public abstract getVersionName()java.lang.String
    # abstract or native
.end method

.method public abstract isDebug()boolean
    # abstract or native
.end method

.method public abstract isDebugChannel()boolean
    # abstract or native
.end method

.method public abstract isOversea()boolean
    # abstract or native
.end method

.method public abstract isPlugin()boolean
    # abstract or native
.end method

.method public abstract isPreinstallApp()boolean
    # abstract or native
.end method

.method public abstract isTestChannel()boolean
    # abstract or native
.end method
