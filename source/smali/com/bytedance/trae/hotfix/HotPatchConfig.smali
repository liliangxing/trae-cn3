# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public Lcom/bytedance/trae/hotfix/HotPatchConfig;
.super Ljava/lang/Object;
.source "HotPatchConfig.kt"

.field public static final $stable:I
.field private final application:Landroid/app/Application;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(android.app.Application)void
    .registers 3
    # ins_size=2
    const-string v0, "application"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/hotfix/HotPatchConfig;->application Landroid/app/Application;
    return-void 
.end method

.method private final buildUrlParameters(java.lang.String)java.lang.String
    .registers 6
    # ins_size=2
    invoke-static v5, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v5
    invoke-virtual v5, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;
    move-result-object v0
    const-string v1, "buildUpon(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "device_id"
    invoke-virtual v5, v1, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +009h
    invoke-virtual v4, Lcom/bytedance/trae/hotfix/HotPatchConfig;->getDeviceId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri$Builder;
    const-string v1, "channel"
    invoke-virtual v5, v1, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +009h
    invoke-virtual v4, Lcom/bytedance/trae/hotfix/HotPatchConfig;->getChannel()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri$Builder;
    const-string v1, "aid"
    invoke-virtual v5, v1, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    if-nez v5, +009h
    invoke-virtual v4, Lcom/bytedance/trae/hotfix/HotPatchConfig;->getAppId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, v1, v5, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri$Builder;
    const-string v5, "device_platform"
    const-string v1, "android"
    invoke-virtual v0, v5, v1, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri$Builder;
    move-result-object v5
    sget v1, Landroid/os/Build$VERSION;->SDK_INT I
    invoke-static v1, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v1
    const-string v2, "os_api"
    invoke-virtual v5, v2, v1, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri$Builder;
    move-result-object v5
    const-string/jumbo v1, update_version_code
    invoke-virtual v4, Lcom/bytedance/trae/hotfix/HotPatchConfig;->getUpdateVersionCode()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v5, v1, v2, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri$Builder;
    sget-object v5, Landroid/os/Build$VERSION;->RELEASE Ljava/lang/String;
    if-eqz v5, +015h
    invoke-virtual v5, Ljava/lang/String;->length()I
    move-result v1
    const/16 v2, 10
    if-le v1, v2, +00dh
    const/4 v1, 0
    invoke-virtual v5, v1, v2, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v5
    const-string/jumbo v1, substring(...)
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "os_version"
    invoke-virtual v0, v1, v5, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri$Builder;
    goto +fh
    move-exception v5
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    invoke-virtual v5, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v2
    check-cast v5, Ljava/lang/Throwable;
    const-string v3, "hot patch"
    invoke-virtual v1, v3, v2, v5, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-virtual v0, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;
    move-result-object v5
    invoke-virtual v5, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v5
    const-string/jumbo v0, toString(...)
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v5
    :try_start_0x58
.end method

.method public final enable()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 1
    return v0
.end method

.method public final executePatchRequest(int  java.lang.String  byte[]  java.lang.String)java.lang.String
    .registers 6
    # ins_size=5
    const-string/jumbo v0, url
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "localPatchInfoBytes"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "contentType"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v3, Lcom/bytedance/trae/hotfix/HotPatchConfig;->buildUrlParameters(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    sget-object v0, Lcom/bytedance/common/utility/NetworkUtils$CompressType;->GZIP Lcom/bytedance/common/utility/NetworkUtils$CompressType;
    invoke-static v2, v3, v4, v0, v5, Lcom/ss/android/common/util/NetworkUtils;->executePost(I Ljava/lang/String; [B Lcom/bytedance/common/utility/NetworkUtils$CompressType; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    const-string v3, "executePost(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method public final getAppId()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppId()I
    move-result v0
    invoke-static v0, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public final getApplication()android.app.Application
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/hotfix/HotPatchConfig;->application Landroid/app/Application;
    return-object v0
.end method

.method public final getChannel()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getBuildChannel()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public final getDeviceId()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public final getRequestInterval()long
    .registers 3
    # ins_size=1
    const-wide/16 v0, 10000
    return-wide v0
.end method

.method public final getUpdateVersionCode()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getUpdateVersionCode()I
    move-result v0
    invoke-static v0, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public final isMainProcess()boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/hotfix/HotPatchConfig;->application Landroid/app/Application;
    check-cast v0, Landroid/content/Context;
    invoke-static v0, Lcom/ss/android/common/util/ToolUtils;->isMainProcess(Landroid/content/Context;)Z
    move-result v0
    return v0
.end method
