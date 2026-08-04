# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/service/AppHostImpl;
.super Ljava/lang/Object;
.source "AppHostImpl.kt"

.implements Lcom/bytedance/trae/common/apphost/AppHost;

.field public static final $stable:I
.field private final activityStackManager:Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
.field private final appClock:Lcom/bytedance/trae/common/apphost/time/AppClock;
.field private final appId:I
.field private final appName:Ljava/lang/String;
.field private final appStartTime:Lkotlin/Pair;
.field private final application:Landroid/app/Application;
.field private final buildChannel$delegate:Lkotlin/Lazy;
.field private final defaultOfficialWebsiteName:Ljava/lang/String;
.field private final defaultOfficialWebsiteUrl:Ljava/lang/String;
.field private final isDebug:Z
.field private final isDebugChannel:Z
.field private final isOversea:Z
.field private final isTestChannel:Z
.field private final manifestVersionCode:I
.field private final manifestVersionName:Ljava/lang/String;
.field private final updateVersionCode:I


.method public static synthetic $r8$lambda$wBtBQ4sdVEJDLwYFDCxuBKoYkEQ(com.bytedance.trae.service.AppHostImpl)java.lang.String
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/service/AppHostImpl;->buildChannel_delegate$lambda$1(Lcom/bytedance/trae/service/AppHostImpl;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    sget-object v0, Lcom/bytedance/trae/TraeApplication;->Companion Lcom/bytedance/trae/TraeApplication$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/TraeApplication$Companion;->getInst()Lcom/bytedance/trae/TraeApplication;
    move-result-object v0
    check-cast v0, Landroid/app/Application;
    iput-object v0, v2, Lcom/bytedance/trae/service/AppHostImpl;->application Landroid/app/Application;
    new-instance v0, Lcom/bytedance/trae/ActivityManager;
    invoke-virtual v2, Lcom/bytedance/trae/service/AppHostImpl;->getApplication()Landroid/app/Application;
    move-result-object v1
    invoke-direct v0, v1, Lcom/bytedance/trae/ActivityManager;-><init>(Landroid/app/Application;)V
    check-cast v0, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    iput-object v0, v2, Lcom/bytedance/trae/service/AppHostImpl;->activityStackManager Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    new-instance v0, Lcom/bytedance/trae/AppClockImpl;
    invoke-direct v0, Lcom/bytedance/trae/AppClockImpl;-><init>()V
    check-cast v0, Lcom/bytedance/trae/common/apphost/time/AppClock;
    iput-object v0, v2, Lcom/bytedance/trae/service/AppHostImpl;->appClock Lcom/bytedance/trae/common/apphost/time/AppClock;
    sget-object v0, Lcom/bytedance/trae/TraeApplication;->Companion Lcom/bytedance/trae/TraeApplication$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/TraeApplication$Companion;->getInst()Lcom/bytedance/trae/TraeApplication;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/TraeApplication;->getStartTime()Lkotlin/Pair;
    move-result-object v0
    iput-object v0, v2, Lcom/bytedance/trae/service/AppHostImpl;->appStartTime Lkotlin/Pair;
    const v0, 943841
    iput v0, v2, Lcom/bytedance/trae/service/AppHostImpl;->appId I
    const-string/jumbo v0, trae
    iput-object v0, v2, Lcom/bytedance/trae/service/AppHostImpl;->appName Ljava/lang/String;
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->INSTANCE Lcom/bytedance/trae/network/HttpConst;
    invoke-virtual v0, Lcom/bytedance/trae/network/HttpConst;->getONLINE_BASE_HOST()Ljava/lang/String;
    move-result-object v0
    iput-object v0, v2, Lcom/bytedance/trae/service/AppHostImpl;->defaultOfficialWebsiteName Ljava/lang/String;
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->INSTANCE Lcom/bytedance/trae/network/HttpConst;
    invoke-virtual v0, Lcom/bytedance/trae/network/HttpConst;->getONLINE_WWW()Ljava/lang/String;
    move-result-object v0
    iput-object v0, v2, Lcom/bytedance/trae/service/AppHostImpl;->defaultOfficialWebsiteUrl Ljava/lang/String;
    new-instance v0, Lcom/bytedance/trae/service/AppHostImpl$$ExternalSyntheticLambda0;
    invoke-direct v0, v2, Lcom/bytedance/trae/service/AppHostImpl$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/service/AppHostImpl;)V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v2, Lcom/bytedance/trae/service/AppHostImpl;->buildChannel$delegate Lkotlin/Lazy;
    const-string v0, "debug"
    const-string v1, "local_test"
    filled-new-array v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    const-string/jumbo v1, release
    invoke-interface v0, v1, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    iput-boolean v0, v2, Lcom/bytedance/trae/service/AppHostImpl;->isTestChannel Z
    const-string v0, "0.0.16"
    iput-object v0, v2, Lcom/bytedance/trae/service/AppHostImpl;->manifestVersionName Ljava/lang/String;
    const/16 v0, 21
    iput v0, v2, Lcom/bytedance/trae/service/AppHostImpl;->manifestVersionCode I
    const v0, 160200
    iput v0, v2, Lcom/bytedance/trae/service/AppHostImpl;->updateVersionCode I
    return-void 
.end method

.method private static final buildChannel_delegate$lambda$1(com.bytedance.trae.service.AppHostImpl)java.lang.String
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/service/AppHostImpl;->getApplication()Landroid/app/Application;
    move-result-object v2
    check-cast v2, Landroid/content/Context;
    invoke-static v2, Lcom/bytedance/trae/ApkProperties;->inst(Landroid/content/Context;)Lcom/bytedance/trae/ApkProperties;
    move-result-object v2
    const-string/jumbo v0, release
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +004h
    const-string v0, "debug"
    check-cast v0, Ljava/lang/String;
    const-string v1, "meta_umeng_channel"
    invoke-virtual v2, v1, v0, Lcom/bytedance/trae/ApkProperties;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    return-object v2
.end method

.method public getActivityStackManager()com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/service/AppHostImpl;->activityStackManager Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    return-object v0
.end method

.method public getAppClock()com.bytedance.trae.common.apphost.time.AppClock
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/service/AppHostImpl;->appClock Lcom/bytedance/trae/common/apphost/time/AppClock;
    return-object v0
.end method

.method public getAppIconId()int
    .registers 2
    # ins_size=1
    const v0, 2131492866
    return v0
.end method

.method public getAppId()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/service/AppHostImpl;->appId I
    return v0
.end method

.method public getAppName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/service/AppHostImpl;->appName Ljava/lang/String;
    return-object v0
.end method

.method public getAppStartTime()kotlin.Pair
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/service/AppHostImpl;->appStartTime Lkotlin/Pair;
    return-object v0
.end method

.method public getAppStringName()java.lang.String
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/service/AppHostImpl;->getApplication()Landroid/app/Application;
    move-result-object v0
    const v1, 2131689519
    invoke-virtual v0, v1, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v0
    const-string v1, "getString(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method

.method public getApplication()android.app.Application
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/service/AppHostImpl;->application Landroid/app/Application;
    return-object v0
.end method

.method public getBuildChannel()java.lang.String
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/service/AppHostImpl;->buildChannel$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    const-string v1, "getValue(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Ljava/lang/String;
    return-object v0
.end method

.method public getDefaultOfficialWebsiteName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/service/AppHostImpl;->defaultOfficialWebsiteName Ljava/lang/String;
    return-object v0
.end method

.method public getDefaultOfficialWebsiteUrl()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/service/AppHostImpl;->defaultOfficialWebsiteUrl Ljava/lang/String;
    return-object v0
.end method

.method public getManifestVersionCode()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/service/AppHostImpl;->manifestVersionCode I
    return v0
.end method

.method public getManifestVersionName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/service/AppHostImpl;->manifestVersionName Ljava/lang/String;
    return-object v0
.end method

.method public getSupportCloudTest()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public getUpdateVersionCode()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/service/AppHostImpl;->updateVersionCode I
    return v0
.end method

.method public getVersionCode()int
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/service/AppHostImpl;->getApplication()Landroid/app/Application;
    move-result-object v0
    check-cast v0, Landroid/content/Context;
    const-string v1, "SS_VERSION_CODE"
    invoke-static v0, v1, Lcom/bytedance/common/utility/android/ManifestData;->getInt(Landroid/content/Context; Ljava/lang/String;)I
    move-result v0
    goto +2h
    const/4 v0, 0
    const/4 v1, -1
    if-eq v0, v1, +005h
    if-eqz v0, +003h
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/service/AppHostImpl;->getManifestVersionCode()I
    move-result v0
    return v0
    :try_start_0x0
.end method

.method public getVersionName()java.lang.String
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/service/AppHostImpl;->getApplication()Landroid/app/Application;
    move-result-object v0
    check-cast v0, Landroid/content/Context;
    const-string v1, "SS_VERSION_NAME"
    invoke-static v0, v1, Lcom/bytedance/common/utility/android/ManifestData;->getString(Landroid/content/Context; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    goto +3h
    const-string v0, ""
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +007h
    invoke-virtual v2, Lcom/bytedance/trae/service/AppHostImpl;->getManifestVersionName()Ljava/lang/String;
    move-result-object v0
    goto +5h
    invoke-static v0, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    return-object v0
    :try_start_0x0
.end method

.method public isDebug()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/service/AppHostImpl;->isDebug Z
    return v0
.end method

.method public isDebugChannel()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/service/AppHostImpl;->isDebugChannel Z
    return v0
.end method

.method public isOversea()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/service/AppHostImpl;->isOversea Z
    return v0
.end method

.method public isPlugin()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public isPreinstallApp()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public isTestChannel()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/service/AppHostImpl;->isTestChannel Z
    return v0
.end method
