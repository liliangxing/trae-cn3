# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/zlink/ZlinkSetup$ZlinkDependImpl;
.super Ljava/lang/Object;
.source "ZlinkSetup.kt"

.implements Lcom/bytedance/ug/sdk/deeplink/IZlinkDepend;

.field private final application:Landroid/app/Application;


.method public constructor <init>(android.app.Application)void
    .registers 3
    # ins_size=2
    const-string v0, "application"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/zlink/ZlinkSetup$ZlinkDependImpl;->application Landroid/app/Application;
    return-void 
.end method

.method public dealWithClipboard(boolean  java.lang.String  boolean)boolean
    .registers 10
    # ins_size=4
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "dealWithClipboard, isCheckedClipboard="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v0, ", fromDevicePrint="
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v9, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v0, ", raw="
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    const-string v0, "ZlinkSetup"
    invoke-static v0, v7, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    move-object v7, v8
    check-cast v7, Ljava/lang/CharSequence;
    const/4 v1, 0
    if-eqz v7, +00bh
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v7
    if-nez v7, +003h
    goto +3h
    move v7, v1
    goto +2h
    const/4 v7, 1
    if-eqz v7, +003h
    return v1
    const/4 v7, 2
    invoke-static v8, v7, Landroid/util/Base64;->decode(Ljava/lang/String; I)[B
    move-result-object v2
    new-instance v3, Ljava/lang/String;
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    const-string v4, "UTF-8"
    invoke-static v4, Ljava/nio/charset/Charset;->forName(Ljava/lang/String;)Ljava/nio/charset/Charset;
    move-result-object v4
    const-string v5, "forName(...)"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v3, v2, v4, Ljava/lang/String;-><init>([B Ljava/nio/charset/Charset;)V
    move-object v8, v3
    goto +9h
    move-exception v2
    const-string v3, "Clipboard content is not base64, use raw"
    check-cast v2, Ljava/lang/Throwable;
    invoke-static v0, v3, v2, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    sget-object v3, Lcom/bytedance/trae/home/zlink/ZlinkConfig;->INSTANCE Lcom/bytedance/trae/home/zlink/ZlinkConfig;
    invoke-virtual v3, Lcom/bytedance/trae/home/zlink/ZlinkConfig;->getSCHEME()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, "://"
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const/4 v3, 0
    invoke-static v8, v2, v1, v7, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v7
    if-nez v7, +008h
    const-string v7, "Clipboard content does not match scheme, ignore"
    invoke-static v0, v7, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    return v1
    sget-object v7, Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;->INSTANCE Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;
    invoke-virtual v7, v8, v9, Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;->reportFromClipboard(Ljava/lang/String; Z)V
    invoke-static v8, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v7
    if-eqz v9, +005h
    const-string v8, "clipboard_device_print"
    goto +3h
    const-string v8, "clipboard"
    new-instance v9, Landroid/content/Intent;
    iget-object v0, v6, Lcom/bytedance/trae/home/zlink/ZlinkSetup$ZlinkDependImpl;->application Landroid/app/Application;
    check-cast v0, Landroid/content/Context;
    const-class v2, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;
    invoke-direct v9, v0, v2, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    const/high16 v0, 268435456
    invoke-virtual v9, v0, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;
    invoke-virtual v9, v7, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;
    const-string v7, "extra_zlink_source"
    invoke-virtual v9, v7, v8, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    iget-object v7, v6, Lcom/bytedance/trae/home/zlink/ZlinkSetup$ZlinkDependImpl;->application Landroid/app/Application;
    invoke-virtual v7, v9, Landroid/app/Application;->startActivity(Landroid/content/Intent;)V
    sget-object v7, Lcom/bytedance/trae/home/zlink/ZlinkClipboardUtil;->INSTANCE Lcom/bytedance/trae/home/zlink/ZlinkClipboardUtil;
    iget-object v8, v6, Lcom/bytedance/trae/home/zlink/ZlinkSetup$ZlinkDependImpl;->application Landroid/app/Application;
    check-cast v8, Landroid/content/Context;
    invoke-virtual v7, v8, Lcom/bytedance/trae/home/zlink/ZlinkClipboardUtil;->clearClipboard(Landroid/content/Context;)V
    return v1
    :try_start_0x3c
.end method

.method public dealWithSchema(java.lang.String)boolean
    .registers 4
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "dealWithSchema="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "ZlinkSetup"
    invoke-static v1, v0, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v0, Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;->INSTANCE Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;
    invoke-virtual v0, v3, Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;->reportFromSchema(Ljava/lang/String;)V
    const/4 v3, 1
    return v3
.end method

.method public delayMillis()long
    .registers 3
    # ins_size=1
    const-wide/16 v0, 500
    return-wide v0
.end method

.method public getAppId()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/zlink/ZlinkConfig;->INSTANCE Lcom/bytedance/trae/home/zlink/ZlinkConfig;
    invoke-virtual v0, Lcom/bytedance/trae/home/zlink/ZlinkConfig;->getAPP_ID()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getDeepLinkActivities()java.util.List
    .registers 2
    # ins_size=1
    const-string v0, "com.bytedance.trae.home.zlink.ZlinkLinkEntryActivity"
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public getDeviceId()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v0
    goto +3h
    const-string v0, ""
    return-object v0
    :try_start_0x0
.end method

.method public getSchemeList()java.util.List
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/zlink/ZlinkConfig;->INSTANCE Lcom/bytedance/trae/home/zlink/ZlinkConfig;
    invoke-virtual v0, Lcom/bytedance/trae/home/zlink/ZlinkConfig;->getSCHEME()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public getUpdateVersionCode()long
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getUpdateVersionCode()I
    move-result v0
    int-to-long v0, v0
    return-wide v0
.end method

.method public isConfirmedPrivacy()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-virtual v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->checkAgreed()Z
    move-result v0
    return v0
.end method

.method public log(int  java.lang.String  java.lang.String  java.lang.Throwable)void
    .registers 5
    # ins_size=5
    if-nez v2, +004h
    const-string v2, "ZlinkSetup"
    if-nez v3, +004h
    const-string v3, ""
    invoke-static v1, v2, v3, Landroid/util/Log;->println(I Ljava/lang/String; Ljava/lang/String;)I
    return-void 
.end method

.method public monitorEvent(java.lang.String  org.json.JSONObject  org.json.JSONObject  org.json.JSONObject)void
    .registers 8
    # ins_size=5
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "monitorEvent service="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", category="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", metric="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "ZlinkSetup"
    invoke-static v1, v0, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v2, service_name
    if-nez v4, +004h
    const-string v4, ""
    invoke-virtual v0, v2, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v5, +007h
    const-string v4, "category"
    invoke-virtual v0, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v6, +007h
    const-string v4, "metric"
    invoke-virtual v0, v4, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v7, +007h
    const-string v4, "log_extr"
    invoke-virtual v0, v4, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v4, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string/jumbo v5, zlink_monitor
    invoke-virtual v4, v5, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    goto +9h
    move-exception v4
    const-string v5, "monitorEvent report failed"
    check-cast v4, Ljava/lang/Throwable;
    invoke-static v1, v5, v4, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    return-void 
    :try_start_0x28
.end method

.method public onEvent(java.lang.String  org.json.JSONObject)void
    .registers 5
    # ins_size=3
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "onEvent name="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", data="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "ZlinkSetup"
    invoke-static v1, v0, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    if-eqz v3, +011h
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, v3, v4, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    goto +ah
    move-exception v3
    const-string/jumbo v4, reportEvent failed
    check-cast v3, Ljava/lang/Throwable;
    invoke-static v1, v4, v3, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    return-void 
    :try_start_0x20
.end method

.method public settingsRefactorEnable()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 1
    return v0
.end method
