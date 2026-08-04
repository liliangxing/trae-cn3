# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/zlink/ZlinkSetup$buildDependAbility$appLinkCallback$1;
.super Ljava/lang/Object;
.source "ZlinkSetup.kt"

.implements Lcom/bytedance/ug/sdk/deeplink/CallBackForAppLink;

.field final synthetic $application:Landroid/app/Application;
.field private bridge lastHandledScheme:Ljava/lang/String;
.field private lastHandledTime:J


.method constructor <init>(android.app.Application)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/zlink/ZlinkSetup$buildDependAbility$appLinkCallback$1;->$application Landroid/app/Application;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public dealWithSchema(java.lang.String)boolean
    .registers 10
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "dealWithSchema from AppLink: "
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "ZlinkSetup"
    invoke-static v1, v0, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    move-object v0, v9
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    move v0, v1
    if-eqz v0, +003h
    return v1
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    iget-object v0, v8, Lcom/bytedance/trae/home/zlink/ZlinkSetup$buildDependAbility$appLinkCallback$1;->lastHandledScheme Ljava/lang/String;
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +00dh
    iget-wide v4, v8, Lcom/bytedance/trae/home/zlink/ZlinkSetup$buildDependAbility$appLinkCallback$1;->lastHandledTime J
    sub-long v4, v2, v4
    const-wide/16 v6, 3000
    cmp-long v0, v4, v6
    if-gez v0, +003h
    return v1
    iput-object v9, v8, Lcom/bytedance/trae/home/zlink/ZlinkSetup$buildDependAbility$appLinkCallback$1;->lastHandledScheme Ljava/lang/String;
    iput-wide v2, v8, Lcom/bytedance/trae/home/zlink/ZlinkSetup$buildDependAbility$appLinkCallback$1;->lastHandledTime J
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v8
    check-cast v0, Lcom/bytedance/trae/home/zlink/ZlinkSetup$buildDependAbility$appLinkCallback$1;
    invoke-static v9, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    const/4 v0, 0
    check-cast v0, Landroid/net/Uri;
    if-nez v0, +003h
    return v1
    sget-object v2, Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;->INSTANCE Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;
    invoke-virtual v2, v9, Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;->reportFromSchema(Ljava/lang/String;)V
    new-instance v9, Landroid/content/Intent;
    iget-object v2, v8, Lcom/bytedance/trae/home/zlink/ZlinkSetup$buildDependAbility$appLinkCallback$1;->$application Landroid/app/Application;
    check-cast v2, Landroid/content/Context;
    const-class v3, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;
    invoke-direct v9, v2, v3, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    const/high16 v2, 268435456
    invoke-virtual v9, v2, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;
    invoke-virtual v9, v0, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;
    const-string v0, "extra_zlink_source"
    const-string v2, "applink"
    invoke-virtual v9, v0, v2, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    iget-object v0, v8, Lcom/bytedance/trae/home/zlink/ZlinkSetup$buildDependAbility$appLinkCallback$1;->$application Landroid/app/Application;
    invoke-virtual v0, v9, Landroid/app/Application;->startActivity(Landroid/content/Intent;)V
    return v1
    :try_start_0x42
.end method

.method public getHostList()java.util.List
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/zlink/ZlinkConfig;->INSTANCE Lcom/bytedance/trae/home/zlink/ZlinkConfig;
    invoke-virtual v0, Lcom/bytedance/trae/home/zlink/ZlinkConfig;->getAPPLINK_HOST()Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +007h
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    goto +5h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    return-object v0
.end method
