# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;
.super Ljava/lang/Object;
.source "ZlinkLaunchLog.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;
    invoke-direct v0, Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;->INSTANCE Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final detectLinkType(java.lang.String  android.net.Uri)java.lang.String
    .registers 7
    # ins_size=3
    const-string v0, "clipboard"
    const/4 v1, 0
    const/4 v2, 2
    const/4 v3, 0
    invoke-static v5, v0, v1, v2, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +003h
    goto +3eh
    if-eqz v6, +007h
    invoke-virtual v6, Landroid/net/Uri;->getScheme()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v3
    const-string v0, "https"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +02dh
    if-eqz v6, +007h
    invoke-virtual v6, Landroid/net/Uri;->getScheme()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v3
    const-string v0, "http"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +003h
    goto +1bh
    if-eqz v6, +006h
    invoke-virtual v6, Landroid/net/Uri;->getScheme()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    if-eqz v3, +008h
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +003h
    const/4 v1, 1
    if-nez v1, +005h
    const-string v0, "deeplink"
    goto +7h
    const-string/jumbo v0, unknown
    goto +3h
    const-string v0, "applink"
    return-object v0
.end method

.method public final reportFromClipboard(java.lang.String  boolean)void
    .registers 4
    # ins_size=3
    const-string v0, "decodedSchema"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;
    invoke-static v2, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    goto +ch
    move-exception v2
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v2, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    const/4 v2, 0
    check-cast v2, Landroid/net/Uri;
    if-eqz v3, +005h
    const-string v3, "clipboard_device_print"
    goto +3h
    const-string v3, "clipboard"
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;->reportFromUri(Ljava/lang/String; Landroid/net/Uri;)V
    return-void 
    :try_start_0x5
.end method

.method public final reportFromSchema(java.lang.String)void
    .registers 3
    # ins_size=2
    move-object v0, v2
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    if-eqz v0, +003h
    return-void 
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;
    invoke-static v2, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    goto +ch
    move-exception v2
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v2, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    const/4 v2, 0
    check-cast v2, Landroid/net/Uri;
    const-string/jumbo v0, sdk_schema
    invoke-virtual v1, v0, v2, Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;->reportFromUri(Ljava/lang/String; Landroid/net/Uri;)V
    return-void 
    :try_start_0x12
.end method

.method public final reportFromUri(java.lang.String  android.net.Uri)void
    .registers 10
    # ins_size=3
    const-string v0, "ZlinkLaunchLog"
    const-string/jumbo v1, source
    invoke-static v8, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 2
    new-array v2, v2, [Lkotlin/Pair;
    invoke-direct v7, v8, v9, Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;->detectLinkType(Ljava/lang/String; Landroid/net/Uri;)Ljava/lang/String;
    move-result-object v3
    const-string v4, "link_type"
    invoke-static v4, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v3
    const/4 v5, 0
    aput-object v3, v2, v5
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getBuildChannel()Ljava/lang/String;
    move-result-object v3
    const-string v5, "channel"
    invoke-static v5, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v3
    const/4 v6, 1
    aput-object v3, v2, v6
    invoke-static v2, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v2
    invoke-static Lcom/bytedance/ug/sdk/deeplink/LaunchLogManager;->getInstance()Lcom/bytedance/ug/sdk/deeplink/LaunchLogManager;
    move-result-object v3
    const/4 v6, 0
    invoke-virtual v3, v8, v9, v6, v2, Lcom/bytedance/ug/sdk/deeplink/LaunchLogManager;->reportLaunchLogEvent(Ljava/lang/String; Landroid/net/Uri; Ljava/lang/String; Ljava/util/Map;)V
    goto +ch
    move-exception v2
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string/jumbo v6, reportLaunchLogEvent to Zlink failed
    check-cast v2, Ljava/lang/Throwable;
    invoke-virtual v3, v0, v6, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v2, v1, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v1, "gd_label"
    const-string v3, ""
    if-eqz v9, +008h
    invoke-virtual v9, v1, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    if-nez v6, +003h
    move-object v6, v3
    invoke-virtual v2, v1, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v1, "item_id"
    if-eqz v9, +008h
    invoke-virtual v9, v1, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    if-nez v6, +003h
    move-object v6, v3
    invoke-virtual v2, v1, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v1, Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;->INSTANCE Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;
    invoke-direct v1, v8, v9, Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;->detectLinkType(Ljava/lang/String; Landroid/net/Uri;)Ljava/lang/String;
    move-result-object v8
    invoke-virtual v2, v4, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v9, +008h
    invoke-virtual v9, Landroid/net/Uri;->getScheme()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +003h
    move-object v8, v3
    const-string/jumbo v1, scheme
    invoke-virtual v2, v1, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v9, +008h
    invoke-virtual v9, Landroid/net/Uri;->getHost()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +003h
    move-object v8, v3
    const-string v1, "host"
    invoke-virtual v2, v1, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v9, +008h
    invoke-virtual v9, Landroid/net/Uri;->getPath()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +003h
    move-object v8, v3
    const-string v1, "path"
    invoke-virtual v2, v1, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v9, +008h
    invoke-virtual v9, Landroid/net/Uri;->getQuery()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +003h
    move-object v8, v3
    const-string v9, "query"
    invoke-virtual v2, v9, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v8, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    sget-object v8, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v8, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v8
    invoke-static v8, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    goto +ch
    move-exception v8
    sget-object v9, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v8, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v8
    invoke-static v8, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    invoke-static v8, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, +003h
    goto +2h
    move-object v3, v8
    const-string v8, "device_id"
    invoke-virtual v2, v8, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v8, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v8, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getBuildChannel()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v2, v5, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v8, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v9, Ljava/lang/StringBuilder;
    const-string v1, "launch_log: "
    invoke-direct v9, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v8, v0, v9, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v8, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v9, "launch_log"
    invoke-virtual v8, v9, v2, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    goto +ch
    move-exception v8
    sget-object v9, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string/jumbo v1, reportEvent to AppLog failed
    check-cast v8, Ljava/lang/Throwable;
    invoke-virtual v9, v0, v1, v8, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x2b
    :try_start_0xa7
    :try_start_0xe9
.end method
