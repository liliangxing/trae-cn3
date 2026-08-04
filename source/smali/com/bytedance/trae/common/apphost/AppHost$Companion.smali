# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common/apphost/AppHost$Companion;
.super Ljava/lang/Object;
.source "AppHost.kt"

.implements Lcom/bytedance/trae/common/apphost/AppHost;

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/common/apphost/AppHost$Companion;
.field private static final inst$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$y624UGfLp_Ovd_aBNzBJXzp0kr4()com.bytedance.trae.common.apphost.AppHost
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/common/apphost/AppHost$Companion;->inst_delegate$lambda$0()Lcom/bytedance/trae/common/apphost/AppHost;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-direct v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->$$INSTANCE Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    new-instance v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->inst$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getInst()com.bytedance.trae.common.apphost.AppHost
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->inst$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/common/apphost/AppHost;
    return-object v0
.end method

.method private static final inst_delegate$lambda$0()com.bytedance.trae.common.apphost.AppHost
    .registers 2
    # ins_size=0
    const-class v0, Lcom/bytedance/trae/common/apphost/AppHost;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/common/apphost/AppHost;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/common/apphost/AppHost;
    if-eqz v0, +003h
    return-object v0
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "app module must have an implementation of this service"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public getActivityStackManager()com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getInst()Lcom/bytedance/trae/common/apphost/AppHost;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/AppHost;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v0
    return-object v0
.end method

.method public getAppClock()com.bytedance.trae.common.apphost.time.AppClock
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getInst()Lcom/bytedance/trae/common/apphost/AppHost;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/AppHost;->getAppClock()Lcom/bytedance/trae/common/apphost/time/AppClock;
    move-result-object v0
    return-object v0
.end method

.method public getAppIconId()int
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getInst()Lcom/bytedance/trae/common/apphost/AppHost;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/AppHost;->getAppIconId()I
    move-result v0
    return v0
.end method

.method public getAppId()int
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getInst()Lcom/bytedance/trae/common/apphost/AppHost;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/AppHost;->getAppId()I
    move-result v0
    return v0
.end method

.method public getAppName()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getInst()Lcom/bytedance/trae/common/apphost/AppHost;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/AppHost;->getAppName()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getAppStartTime()kotlin.Pair
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getInst()Lcom/bytedance/trae/common/apphost/AppHost;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/AppHost;->getAppStartTime()Lkotlin/Pair;
    move-result-object v0
    return-object v0
.end method

.method public getAppStringName()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getInst()Lcom/bytedance/trae/common/apphost/AppHost;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/AppHost;->getAppStringName()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getApplication()android.app.Application
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getInst()Lcom/bytedance/trae/common/apphost/AppHost;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/AppHost;->getApplication()Landroid/app/Application;
    move-result-object v0
    return-object v0
.end method

.method public getBuildChannel()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getInst()Lcom/bytedance/trae/common/apphost/AppHost;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/AppHost;->getBuildChannel()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getDefaultOfficialWebsiteName()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getInst()Lcom/bytedance/trae/common/apphost/AppHost;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/AppHost;->getDefaultOfficialWebsiteName()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getDefaultOfficialWebsiteUrl()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getInst()Lcom/bytedance/trae/common/apphost/AppHost;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/AppHost;->getDefaultOfficialWebsiteUrl()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getManifestVersionCode()int
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getInst()Lcom/bytedance/trae/common/apphost/AppHost;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/AppHost;->getManifestVersionCode()I
    move-result v0
    return v0
.end method

.method public getManifestVersionName()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getInst()Lcom/bytedance/trae/common/apphost/AppHost;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/AppHost;->getManifestVersionName()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getSupportCloudTest()boolean
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getInst()Lcom/bytedance/trae/common/apphost/AppHost;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/AppHost;->getSupportCloudTest()Z
    move-result v0
    return v0
.end method

.method public getUpdateVersionCode()int
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getInst()Lcom/bytedance/trae/common/apphost/AppHost;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/AppHost;->getUpdateVersionCode()I
    move-result v0
    return v0
.end method

.method public getVersionCode()int
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getInst()Lcom/bytedance/trae/common/apphost/AppHost;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/AppHost;->getVersionCode()I
    move-result v0
    return v0
.end method

.method public getVersionName()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getInst()Lcom/bytedance/trae/common/apphost/AppHost;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/AppHost;->getVersionName()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public isDebug()boolean
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getInst()Lcom/bytedance/trae/common/apphost/AppHost;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/AppHost;->isDebug()Z
    move-result v0
    return v0
.end method

.method public isDebugChannel()boolean
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getInst()Lcom/bytedance/trae/common/apphost/AppHost;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/AppHost;->isDebugChannel()Z
    move-result v0
    return v0
.end method

.method public isOversea()boolean
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getInst()Lcom/bytedance/trae/common/apphost/AppHost;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/AppHost;->isOversea()Z
    move-result v0
    return v0
.end method

.method public isPlugin()boolean
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getInst()Lcom/bytedance/trae/common/apphost/AppHost;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/AppHost;->isPlugin()Z
    move-result v0
    return v0
.end method

.method public isPreinstallApp()boolean
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getInst()Lcom/bytedance/trae/common/apphost/AppHost;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/AppHost;->isPreinstallApp()Z
    move-result v0
    return v0
.end method

.method public isTestChannel()boolean
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getInst()Lcom/bytedance/trae/common/apphost/AppHost;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/AppHost;->isTestChannel()Z
    move-result v0
    return v0
.end method
