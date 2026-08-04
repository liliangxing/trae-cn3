# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/update/IBitsUpdateImpl;
.super Ljava/lang/Object;
.source "IBitsUpdateImpl.kt"

.implements Lcom/bytedance/trae/update/IBitsUpdate;

.field public static final Companion:Lcom/bytedance/trae/update/IBitsUpdateImpl$Companion;
.field private static final TAG:Ljava/lang/String;
.field private final appCommonContext:Lcom/bytedance/trae/update/TraeAppCommonContext;
.field private backGroundListener:Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;
.field private listener:Lcom/ss/android/update/OnUpdateStatusChangedListener;
.field private saveFileDir:Ljava/lang/String;
.field private bridge sdkHasInit:Z
.field private shouldCheckUpdate:Z


.method public static synthetic $r8$lambda$6x2Gok5Z4c84PSobT_9mVluTCLU(com.ss.android.update.UpdateConfig)com.ss.android.update.UpdateConfig
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/update/IBitsUpdateImpl;->initSDK$lambda$7(Lcom/ss/android/update/UpdateConfig;)Lcom/ss/android/update/UpdateConfig;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Dt9WSnZwgqdLCSOozzS-HrLShwE()android.util.Pair
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/update/IBitsUpdateImpl;->initSDK$lambda$8()Landroid/util/Pair;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$HaPF8rj6FhpnbzDVdCumb7CQgOQ(java.lang.String  org.json.JSONObject)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/update/IBitsUpdateImpl;->initSDK$lambda$3(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$ako4XoCH2f0J4UKkszBDI7LNTpk()java.lang.ref.WeakReference
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/update/IBitsUpdateImpl;->initSDK$lambda$5()Ljava/lang/ref/WeakReference;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$bVBVOWUw0FoUMjpuBQP3dVZTDN4(com.bytedance.trae.update.IBitsUpdateImpl  java.lang.String  android.content.Context  java.io.File)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/update/IBitsUpdateImpl;->initSDK$lambda$6(Lcom/bytedance/trae/update/IBitsUpdateImpl; Ljava/lang/String; Landroid/content/Context; Ljava/io/File;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$gwoOmZOerORz3EcTHJBTwD1YErU(com.bytedance.trae.update.IBitsUpdateImpl  android.content.Context)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/update/IBitsUpdateImpl;->initSDK$lambda$4(Lcom/bytedance/trae/update/IBitsUpdateImpl; Landroid/content/Context;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/update/IBitsUpdateImpl$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/update/IBitsUpdateImpl$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/update/IBitsUpdateImpl;->Companion Lcom/bytedance/trae/update/IBitsUpdateImpl$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    const/4 v0, 1
    iput-boolean v0, v1, Lcom/bytedance/trae/update/IBitsUpdateImpl;->shouldCheckUpdate Z
    new-instance v0, Lcom/bytedance/trae/update/TraeAppCommonContext;
    invoke-direct v0, Lcom/bytedance/trae/update/TraeAppCommonContext;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/update/IBitsUpdateImpl;->appCommonContext Lcom/bytedance/trae/update/TraeAppCommonContext;
    return-void 
.end method

.method public static final synthetic access$setShouldCheckUpdate$p(com.bytedance.trae.update.IBitsUpdateImpl  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/update/IBitsUpdateImpl;->shouldCheckUpdate Z
    return-void 
.end method

.method private final autoCheckUpdate()void
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/update/IBitsUpdateImpl;->shouldCheckUpdate Z
    if-nez v0, +003h
    return-void 
    const/4 v0, 0
    iput-boolean v0, v1, Lcom/bytedance/trae/update/IBitsUpdateImpl;->shouldCheckUpdate Z
    invoke-direct v1, Lcom/bytedance/trae/update/IBitsUpdateImpl;->tryInitSDK()V
    const/4 v0, 1
    invoke-direct v1, v0, Lcom/bytedance/trae/update/IBitsUpdateImpl;->checkUpdateNow(Z)V
    return-void 
.end method

.method private final autoInstallApk(java.io.File  java.lang.String)void
    .registers 7
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->getCurrentActivity()Landroid/app/Activity;
    move-result-object v0
    if-nez v0, +008h
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "auto install apk context:"
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ",file:"
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v3, update_sdk
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    move-object v1, v0
    check-cast v1, Landroid/content/Context;
    invoke-direct v4, v1, v5, v6, Lcom/bytedance/trae/update/IBitsUpdateImpl;->createAutoInstallIntent(Landroid/content/Context; Ljava/io/File; Ljava/lang/String;)Landroid/content/Intent;
    move-result-object v5
    check-cast v0, Landroid/content/ContextWrapper;
    invoke-virtual v0, v5, Landroid/content/ContextWrapper;->startActivity(Landroid/content/Intent;)V
    return-void 
.end method

.method private final checkUpdateNow(boolean)void
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/update/IBitsUpdateImpl;->saveFileDir Ljava/lang/String;
    if-nez v0, +003h
    return-void 
    invoke-static Lcom/ss/android/update/UpdateHelper;->getInstance()Lcom/ss/android/update/UpdateHelper;
    move-result-object v0
    const-string v1, "getInstance(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;->INSTANCE Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;
    check-cast v1, Lcom/ss/android/update/IUpdateMainDialog;
    sget-object v2, Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog;->INSTANCE Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog;
    check-cast v2, Lcom/ss/android/update/IUpdateCheckDialog;
    invoke-virtual v0, v1, v2, Lcom/ss/android/update/UpdateHelper;->setCustomUpdateDialog(Lcom/ss/android/update/IUpdateMainDialog; Lcom/ss/android/update/IUpdateCheckDialog;)V
    iget-object v1, v3, Lcom/bytedance/trae/update/IBitsUpdateImpl;->listener Lcom/ss/android/update/OnUpdateStatusChangedListener;
    if-nez v1, +00bh
    new-instance v1, Lcom/bytedance/trae/update/UpdateListener;
    invoke-direct v1, Lcom/bytedance/trae/update/UpdateListener;-><init>()V
    check-cast v1, Lcom/ss/android/update/OnUpdateStatusChangedListener;
    iput-object v1, v3, Lcom/bytedance/trae/update/IBitsUpdateImpl;->listener Lcom/ss/android/update/OnUpdateStatusChangedListener;
    invoke-virtual v0, Lcom/ss/android/update/UpdateHelper;->needPreDownload()Z
    move-result v1
    if-eqz v1, +005h
    invoke-virtual v0, Lcom/ss/android/update/UpdateHelper;->startPreDownload()V
    if-eqz v4, +004h
    const/4 v1, 2
    goto +2h
    const/4 v1, 1
    iget-object v2, v3, Lcom/bytedance/trae/update/IBitsUpdateImpl;->listener Lcom/ss/android/update/OnUpdateStatusChangedListener;
    invoke-virtual v0, v1, v2, v4, Lcom/ss/android/update/UpdateHelper;->startCheckUpdate(I Lcom/ss/android/update/OnUpdateStatusChangedListener; Z)V
    iget-object v4, v3, Lcom/bytedance/trae/update/IBitsUpdateImpl;->backGroundListener Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;
    if-nez v4, +00eh
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/update/IBitsUpdateImpl;
    new-instance v4, Lcom/bytedance/trae/update/IBitsUpdateImpl$checkUpdateNow$backListener$1$1;
    invoke-direct v4, v0, v3, Lcom/bytedance/trae/update/IBitsUpdateImpl$checkUpdateNow$backListener$1$1;-><init>(Lcom/ss/android/update/UpdateHelper; Lcom/bytedance/trae/update/IBitsUpdateImpl;)V
    check-cast v4, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;
    iput-object v4, v3, Lcom/bytedance/trae/update/IBitsUpdateImpl;->backGroundListener Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v0
    invoke-interface v0, v4, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->addAppBackGroundListener(Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;)V
    return-void 
.end method

.method private final createAutoInstallIntent(android.content.Context  java.io.File  java.lang.String)android.content.Intent
    .registers 4
    # ins_size=4
    invoke-static v1, v3, v2, Landroidx/core/content/FileProvider;->getUriForFile(Landroid/content/Context; Ljava/lang/String; Ljava/io/File;)Landroid/net/Uri;
    move-result-object v1
    new-instance v2, Landroid/content/Intent;
    const-string v3, "android.intent.action.VIEW"
    invoke-direct v2, v3, Landroid/content/Intent;-><init>(Ljava/lang/String;)V
    const-string v3, "application/vnd.android.package-archive"
    invoke-virtual v2, v1, v3, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri; Ljava/lang/String;)Landroid/content/Intent;
    const v1, 268435457
    invoke-virtual v2, v1, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;
    return-object v2
.end method

.method private final getSaveFilesDir()java.lang.String
    .registers 7
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Landroid/content/Context;
    const/4 v2, 0
    invoke-static v1, v2, Landroidx/core/content/ContextCompat;->getExternalFilesDirs(Landroid/content/Context; Ljava/lang/String;)[Ljava/io/File;
    move-result-object v1
    const-string v3, "getExternalFilesDirs(...)"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    array-length v3, v1
    const/4 v4, 1
    const/4 v5, 0
    if-nez v3, +004h
    move v3, v4
    goto +2h
    move v3, v5
    xor-int/2addr v3, v4
    const-string/jumbo v4, update
    if-eqz v3, +00dh
    new-instance v2, Ljava/io/File;
    aget-object v1, v1, v5
    invoke-direct v2, v1, v4, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    invoke-virtual v2, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +01dh
    invoke-virtual v0, Landroid/app/Application;->getExternalCacheDir()Ljava/io/File;
    move-result-object v1
    if-nez v1, +006h
    invoke-virtual v0, Landroid/app/Application;->getFilesDir()Ljava/io/File;
    move-result-object v1
    if-nez v1, +006h
    invoke-virtual v0, Landroid/app/Application;->getCacheDir()Ljava/io/File;
    move-result-object v1
    if-eqz v1, +00bh
    new-instance v0, Ljava/io/File;
    invoke-direct v0, v1, v4, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    invoke-virtual v0, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    move-result-object v2
    return-object v2
.end method

.method private final initSDK()void
    .registers 10
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/update/UpdateSdkLogger;
    invoke-direct v0, Lcom/bytedance/trae/update/UpdateSdkLogger;-><init>()V
    check-cast v0, Lcom/ss/android/update/IUpdateLogger;
    new-instance v1, Lcom/bytedance/trae/update/IBitsUpdateImpl$$ExternalSyntheticLambda0;
    invoke-direct v1, Lcom/bytedance/trae/update/IBitsUpdateImpl$$ExternalSyntheticLambda0;-><init>()V
    sget-object v2, Lcom/bytedance/trae/update/settings/UpdateSdkSettings;->INSTANCE Lcom/bytedance/trae/update/settings/UpdateSdkSettings;
    invoke-virtual v2, Lcom/bytedance/trae/update/settings/UpdateSdkSettings;->getUpdateFormalConfig()Lcom/google/gson/JsonObject;
    move-result-object v2
    const/4 v3, 1
    if-eqz v2, +00fh
    const-string v4, "new_strategy_enable"
    invoke-virtual v2, v4, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v4
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsBoolean()Z
    move-result v4
    goto +2h
    move v4, v3
    if-eqz v2, +00fh
    const-string v5, "interval_version"
    invoke-virtual v2, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v5
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsInt()I
    move-result v5
    goto +2h
    const/4 v5, 2
    if-eqz v2, +010h
    const-string/jumbo v6, update_delay_time
    invoke-virtual v2, v6, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsLong()J
    move-result-wide v6
    goto +3h
    const-wide/16 v6, -1
    invoke-direct v9, Lcom/bytedance/trae/update/IBitsUpdateImpl;->getSaveFilesDir()Ljava/lang/String;
    move-result-object v2
    iput-object v2, v9, Lcom/bytedance/trae/update/IBitsUpdateImpl;->saveFileDir Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    sget-object v8, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v8, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v8
    invoke-virtual v8, Landroid/app/Application;->getPackageName()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v8, ".uri.key"
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    new-instance v8, Lcom/ss/android/update/UpdateStrategyInfo;
    invoke-direct v8, Lcom/ss/android/update/UpdateStrategyInfo;-><init>()V
    iput-boolean v4, v8, Lcom/ss/android/update/UpdateStrategyInfo;->updateNewStrategyEnable Z
    iput v5, v8, Lcom/ss/android/update/UpdateStrategyInfo;->intervalVersion I
    iput-wide v6, v8, Lcom/ss/android/update/UpdateStrategyInfo;->updateDelayTime J
    new-instance v4, Lcom/ss/android/update/UpdateLocalStrategy;
    invoke-direct v4, Lcom/ss/android/update/UpdateLocalStrategy;-><init>()V
    iput-boolean v3, v4, Lcom/ss/android/update/UpdateLocalStrategy;->updateLocalStrategyEnable Z
    new-instance v5, Lcom/ss/android/update/UpdateConfig$Builder;
    invoke-direct v5, Lcom/ss/android/update/UpdateConfig$Builder;-><init>()V
    invoke-virtual v5, v4, Lcom/ss/android/update/UpdateConfig$Builder;->updateLocalStrategy(Lcom/ss/android/update/UpdateLocalStrategy;)Lcom/ss/android/update/UpdateConfig$Builder;
    move-result-object v4
    iget-object v5, v9, Lcom/bytedance/trae/update/IBitsUpdateImpl;->appCommonContext Lcom/bytedance/trae/update/TraeAppCommonContext;
    check-cast v5, Lcom/bytedance/services/app/common/context/api/AppCommonContext;
    invoke-virtual v4, v5, Lcom/ss/android/update/UpdateConfig$Builder;->setAppCommonContext(Lcom/bytedance/services/app/common/context/api/AppCommonContext;)Lcom/ss/android/update/UpdateConfig$Builder;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/update/IBitsUpdateImpl$$ExternalSyntheticLambda1;
    invoke-direct v5, v9, Lcom/bytedance/trae/update/IBitsUpdateImpl$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/update/IBitsUpdateImpl;)V
    invoke-virtual v4, v5, Lcom/ss/android/update/UpdateConfig$Builder;->setIUpdateForceExit(Lcom/ss/android/update/IUpdateForceExit;)Lcom/ss/android/update/UpdateConfig$Builder;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/update/IBitsUpdateImpl$$ExternalSyntheticLambda2;
    invoke-direct v5, Lcom/bytedance/trae/update/IBitsUpdateImpl$$ExternalSyntheticLambda2;-><init>()V
    invoke-virtual v4, v5, Lcom/ss/android/update/UpdateConfig$Builder;->setICurrentActivityCallback(Lcom/ss/android/update/ICurrentActivityCallback;)Lcom/ss/android/update/UpdateConfig$Builder;
    move-result-object v4
    sget v5, Lcom/bytedance/trae/update/bits/impl/R$drawable;->trae_status_icon I
    invoke-virtual v4, v5, Lcom/ss/android/update/UpdateConfig$Builder;->setNotifyIcon(I)Lcom/ss/android/update/UpdateConfig$Builder;
    move-result-object v4
    invoke-virtual v4, v3, Lcom/ss/android/update/UpdateConfig$Builder;->setHideNotice(Z)Lcom/ss/android/update/UpdateConfig$Builder;
    move-result-object v4
    invoke-virtual v4, v3, Lcom/ss/android/update/UpdateConfig$Builder;->isUpdateActivityOff(Z)Lcom/ss/android/update/UpdateConfig$Builder;
    move-result-object v4
    const-string v5, "App Update"
    invoke-virtual v4, v5, Lcom/ss/android/update/UpdateConfig$Builder;->setNotificationChannelName(Ljava/lang/String;)Lcom/ss/android/update/UpdateConfig$Builder;
    move-result-object v4
    invoke-virtual v4, v2, Lcom/ss/android/update/UpdateConfig$Builder;->setFormalAuthority(Ljava/lang/String;)Lcom/ss/android/update/UpdateConfig$Builder;
    move-result-object v4
    invoke-virtual v4, v8, Lcom/ss/android/update/UpdateConfig$Builder;->setUpdateStrategyInfo(Lcom/ss/android/update/UpdateStrategyInfo;)Lcom/ss/android/update/UpdateConfig$Builder;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/update/settings/UpdateSdkSettings;->INSTANCE Lcom/bytedance/trae/update/settings/UpdateSdkSettings;
    const-wide/32 v6, 3600000
    invoke-virtual v5, v6, v7, Lcom/bytedance/trae/update/settings/UpdateSdkSettings;->getDialogShowInterval(J)J
    move-result-wide v5
    invoke-virtual v4, v5, v6, Lcom/ss/android/update/UpdateConfig$Builder;->dialogShowInterval(J)Lcom/ss/android/update/UpdateConfig$Builder;
    move-result-object v4
    invoke-virtual v4, v3, Lcom/ss/android/update/UpdateConfig$Builder;->newUiEnable(Z)Lcom/ss/android/update/UpdateConfig$Builder;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Lcom/ss/android/update/UpdateConfig$Builder;->deviceId(Ljava/lang/String;)Lcom/ss/android/update/UpdateConfig$Builder;
    move-result-object v3
    const/4 v4, 0
    invoke-virtual v3, v4, Lcom/ss/android/update/UpdateConfig$Builder;->isLocalApp(Z)Lcom/ss/android/update/UpdateConfig$Builder;
    move-result-object v3
    iget-object v4, v9, Lcom/bytedance/trae/update/IBitsUpdateImpl;->saveFileDir Ljava/lang/String;
    invoke-virtual v3, v4, Lcom/ss/android/update/UpdateConfig$Builder;->setSaveFileDir(Ljava/lang/String;)Lcom/ss/android/update/UpdateConfig$Builder;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/update/IBitsUpdateImpl$$ExternalSyntheticLambda3;
    invoke-direct v4, v9, v2, Lcom/bytedance/trae/update/IBitsUpdateImpl$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/update/IBitsUpdateImpl; Ljava/lang/String;)V
    invoke-virtual v3, v4, Lcom/ss/android/update/UpdateConfig$Builder;->setAutoInstallApk(Lcom/ss/android/update/IAutoInstallApk;)Lcom/ss/android/update/UpdateConfig$Builder;
    move-result-object v2
    invoke-virtual v2, Lcom/ss/android/update/UpdateConfig$Builder;->build()Lcom/ss/android/update/UpdateConfig;
    move-result-object v2
    iget-object v3, v9, Lcom/bytedance/trae/update/IBitsUpdateImpl;->appCommonContext Lcom/bytedance/trae/update/TraeAppCommonContext;
    check-cast v3, Lcom/bytedance/services/app/common/context/api/AppCommonContext;
    new-instance v4, Lcom/bytedance/trae/update/IBitsUpdateImpl$$ExternalSyntheticLambda4;
    invoke-direct v4, v2, Lcom/bytedance/trae/update/IBitsUpdateImpl$$ExternalSyntheticLambda4;-><init>(Lcom/ss/android/update/UpdateConfig;)V
    invoke-static v3, v4, v0, v1, Lcom/ss/android/update/UpdateSDK;->init(Lcom/bytedance/services/app/common/context/api/AppCommonContext; Lcom/ss/android/update/IUpdateConfig; Lcom/ss/android/update/IUpdateLogger; Lcom/ss/android/update/IEventReporter;)V
    new-instance v0, Lcom/bytedance/trae/update/IBitsUpdateImpl$$ExternalSyntheticLambda5;
    invoke-direct v0, Lcom/bytedance/trae/update/IBitsUpdateImpl$$ExternalSyntheticLambda5;-><init>()V
    invoke-static v0, Lcom/ss/android/update/RequestTagHeaderManager;->setRequestTagHeaderProvider(Lcom/ss/android/update/IRequestTagHeaderProvider;)V
    return-void 
.end method

.method private static final initSDK$lambda$3(java.lang.String  org.json.JSONObject)void
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method private static final initSDK$lambda$4(com.bytedance.trae.update.IBitsUpdateImpl  android.content.Context)void
    .registers 3
    # ins_size=2
    const-string v0, "it"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 1
    iput-boolean v2, v1, Lcom/bytedance/trae/update/IBitsUpdateImpl;->shouldCheckUpdate Z
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v1
    invoke-interface v1, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->finishAllActivities()V
    return-void 
.end method

.method private static final initSDK$lambda$5()java.lang.ref.WeakReference
    .registers 2
    # ins_size=0
    new-instance v0, Ljava/lang/ref/WeakReference;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v1
    invoke-interface v1, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->getCurrentActivity()Landroid/app/Activity;
    move-result-object v1
    invoke-direct v0, v1, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V
    return-object v0
.end method

.method private static final initSDK$lambda$6(com.bytedance.trae.update.IBitsUpdateImpl  java.lang.String  android.content.Context  java.io.File)void
    .registers 4
    # ins_size=4
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v0, v3, v1, Lcom/bytedance/trae/update/IBitsUpdateImpl;->autoInstallApk(Ljava/io/File; Ljava/lang/String;)V
    return-void 
.end method

.method private static final initSDK$lambda$7(com.ss.android.update.UpdateConfig)com.ss.android.update.UpdateConfig
    .registers 1
    # ins_size=1
    return-object v0
.end method

.method private static final initSDK$lambda$8()android.util.Pair
    .registers 2
    # ins_size=0
    new-instance v0, Landroid/util/Pair;
    const-string v1, ""
    invoke-direct v0, v1, v1, Landroid/util/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    return-object v0
.end method

.method private final manualCheckUpdate()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/bytedance/trae/update/IBitsUpdateImpl;->tryInitSDK()V
    invoke-static Lcom/ss/android/update/UpdateHelper;->getInstance()Lcom/ss/android/update/UpdateHelper;
    move-result-object v0
    const-string v1, "getInstance(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, Lcom/ss/android/update/UpdateHelper;->isUpdating()Z
    move-result v0
    if-eqz v0, +008h
    sget-object v0, Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog;->INSTANCE Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog;
    invoke-virtual v0, Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog;->showProgressDialog()V
    return-void 
    const/4 v0, 0
    invoke-direct v2, v0, Lcom/bytedance/trae/update/IBitsUpdateImpl;->checkUpdateNow(Z)V
    return-void 
.end method

.method private final tryInitSDK()void
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/update/IBitsUpdateImpl;->sdkHasInit Z
    if-nez v0, +014h
    monitor-enter v1
    iget-boolean v0, v1, Lcom/bytedance/trae/update/IBitsUpdateImpl;->sdkHasInit Z
    if-nez v0, +008h
    const/4 v0, 1
    iput-boolean v0, v1, Lcom/bytedance/trae/update/IBitsUpdateImpl;->sdkHasInit Z
    invoke-direct v1, Lcom/bytedance/trae/update/IBitsUpdateImpl;->initSDK()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v1
    goto +4h
    move-exception v0
    monitor-exit v1
    throw v0
    return-void 
    :try_start_0x5
.end method

.method public checkUpdate(boolean)void
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getSupportCloudTest()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/update/settings/UpdateSdkSettings;->INSTANCE Lcom/bytedance/trae/update/settings/UpdateSdkSettings;
    const/4 v1, 1
    invoke-virtual v0, v1, Lcom/bytedance/trae/update/settings/UpdateSdkSettings;->getSdkUpdateEnable(Z)Z
    move-result v0
    if-nez v0, +003h
    return-void 
    invoke-direct v2, Lcom/bytedance/trae/update/IBitsUpdateImpl;->getSaveFilesDir()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    if-eqz v3, +006h
    invoke-direct v2, Lcom/bytedance/trae/update/IBitsUpdateImpl;->autoCheckUpdate()V
    goto +4h
    invoke-direct v2, Lcom/bytedance/trae/update/IBitsUpdateImpl;->manualCheckUpdate()V
    return-void 
.end method

.method public getUpdatePackageDir()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/update/IBitsUpdateImpl;->getSaveFilesDir()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public isUpdating()boolean
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/update/IBitsUpdateImpl;->tryInitSDK()V
    invoke-static Lcom/ss/android/update/UpdateHelper;->getInstance()Lcom/ss/android/update/UpdateHelper;
    move-result-object v0
    invoke-virtual v0, Lcom/ss/android/update/UpdateHelper;->isUpdating()Z
    move-result v0
    return v0
.end method

.method public manualUpdateEnable()boolean
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/update/settings/UpdateSdkSettings;->INSTANCE Lcom/bytedance/trae/update/settings/UpdateSdkSettings;
    const/4 v1, 0
    invoke-virtual v0, v1, Lcom/bytedance/trae/update/settings/UpdateSdkSettings;->getManualUpdateEnable(Z)Z
    move-result v0
    return v0
.end method
