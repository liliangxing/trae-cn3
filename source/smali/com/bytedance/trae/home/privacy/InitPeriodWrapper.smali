# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;
.super Ljava/lang/Object;
.source "InitPeriodWrapper.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;
.field public static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;
    invoke-direct v0, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;->INSTANCE Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final afterSuperCreateEnd()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-virtual v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->notifyStartEventDelay()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "InitPeriodWrapper - after super activity end, curMills = "
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "InitPeriodWrapper"
    invoke-static v1, v0, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v0, Lcom/bytedance/lego/init/model/InitPeriod;->MAIN_SUPER2ONCREATEEND Lcom/bytedance/lego/init/model/InitPeriod;
    invoke-static v0, Lcom/bytedance/lego/init/InitScheduler;->onPeriodEnd(Lcom/bytedance/lego/init/model/InitPeriod;)V
    return-void 
.end method

.method public final afterSuperCreateStart()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-virtual v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->notifyStartEventDelay()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "InitPeriodWrapper - after super activity start, curMills = "
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "InitPeriodWrapper"
    invoke-static v1, v0, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v0, Lcom/bytedance/lego/init/model/InitPeriod;->MAIN_SUPER2ONCREATEEND Lcom/bytedance/lego/init/model/InitPeriod;
    invoke-static v0, Lcom/bytedance/lego/init/InitScheduler;->onPeriodStart(Lcom/bytedance/lego/init/model/InitPeriod;)V
    return-void 
.end method

.method public final afterSuperResume()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-virtual v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->notifyStartEventDelay()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/lego/init/model/InitPeriod;->MAIN_SUPER2ONRESUMEEND Lcom/bytedance/lego/init/model/InitPeriod;
    invoke-static v0, Lcom/bytedance/lego/init/InitScheduler;->onPeriodStart(Lcom/bytedance/lego/init/model/InitPeriod;)V
    sget-object v0, Lcom/bytedance/lego/init/model/InitPeriod;->MAIN_SUPER2ONRESUMEEND Lcom/bytedance/lego/init/model/InitPeriod;
    invoke-static v0, Lcom/bytedance/lego/init/InitScheduler;->onPeriodEnd(Lcom/bytedance/lego/init/model/InitPeriod;)V
    return-void 
.end method

.method public final applicationAttachAfterSuper()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-virtual v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->notifyStartEventDelay()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/lego/init/model/InitPeriod;->APP_SUPER2ATTACHBASEEND Lcom/bytedance/lego/init/model/InitPeriod;
    invoke-static v0, Lcom/bytedance/lego/init/InitScheduler;->onPeriodStart(Lcom/bytedance/lego/init/model/InitPeriod;)V
    sget-object v0, Lcom/bytedance/lego/init/model/InitPeriod;->APP_SUPER2ATTACHBASEEND Lcom/bytedance/lego/init/model/InitPeriod;
    invoke-static v0, Lcom/bytedance/lego/init/InitScheduler;->onPeriodEnd(Lcom/bytedance/lego/init/model/InitPeriod;)V
    return-void 
.end method

.method public final applicationAttachBeforeSuper(android.content.Context)void
    .registers 4
    # ins_size=2
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-virtual v3, Lcom/bytedance/trae/home/privacy/PrivacyManager;->notifyStartEventDelay()Z
    move-result v3
    if-eqz v3, +003h
    return-void 
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v0, "InitPeriodWrapper - before application attach, curMills = "
    invoke-direct v3, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    invoke-virtual v3, v0, v1, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v0, "InitPeriodWrapper"
    invoke-static v0, v3, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v3, Lcom/bytedance/lego/init/model/InitPeriod;->APP_ATTACHBASE2SUPER Lcom/bytedance/lego/init/model/InitPeriod;
    invoke-static v3, Lcom/bytedance/lego/init/InitScheduler;->onPeriodStart(Lcom/bytedance/lego/init/model/InitPeriod;)V
    sget-object v3, Lcom/bytedance/lego/init/model/InitPeriod;->APP_ATTACHBASE2SUPER Lcom/bytedance/lego/init/model/InitPeriod;
    invoke-static v3, Lcom/bytedance/lego/init/InitScheduler;->onPeriodEnd(Lcom/bytedance/lego/init/model/InitPeriod;)V
    return-void 
.end method

.method public final applicationCreateAfterSuper()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-virtual v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->notifyStartEventDelay()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "InitPeriodWrapper - after application create, curMills = "
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "InitPeriodWrapper"
    invoke-static v1, v0, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v0, Lcom/bytedance/lego/init/model/InitPeriod;->APP_SUPER2ONCREATEEND Lcom/bytedance/lego/init/model/InitPeriod;
    invoke-static v0, Lcom/bytedance/lego/init/InitScheduler;->onPeriodStart(Lcom/bytedance/lego/init/model/InitPeriod;)V
    sget-object v0, Lcom/bytedance/lego/init/model/InitPeriod;->APP_SUPER2ONCREATEEND Lcom/bytedance/lego/init/model/InitPeriod;
    invoke-static v0, Lcom/bytedance/lego/init/InitScheduler;->onPeriodEnd(Lcom/bytedance/lego/init/model/InitPeriod;)V
    invoke-static Lcom/bytedance/lego/init/InitScheduler;->startDispatchDelayTask()V
    invoke-static Lcom/bytedance/lego/init/InitScheduler;->startDispatchIdleTask()V
    return-void 
.end method

.method public final applicationCreateBeforeSuper(android.app.Application)void
    .registers 4
    # ins_size=2
    const-string v0, "application"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-virtual v3, Lcom/bytedance/trae/home/privacy/PrivacyManager;->notifyStartEventDelay()Z
    move-result v3
    if-eqz v3, +003h
    return-void 
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v0, "InitPeriodWrapper - before application create, curMills = "
    invoke-direct v3, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    invoke-virtual v3, v0, v1, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v0, "InitPeriodWrapper"
    invoke-static v0, v3, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v3, Lcom/bytedance/lego/init/model/InitPeriod;->APP_ONCREATE2SUPER Lcom/bytedance/lego/init/model/InitPeriod;
    invoke-static v3, Lcom/bytedance/lego/init/InitScheduler;->onPeriodStart(Lcom/bytedance/lego/init/model/InitPeriod;)V
    sget-object v3, Lcom/bytedance/lego/init/model/InitPeriod;->APP_ONCREATE2SUPER Lcom/bytedance/lego/init/model/InitPeriod;
    invoke-static v3, Lcom/bytedance/lego/init/InitScheduler;->onPeriodEnd(Lcom/bytedance/lego/init/model/InitPeriod;)V
    return-void 
.end method

.method public final beforeSuperCreate(android.app.Activity)void
    .registers 4
    # ins_size=2
    const-string v0, "activity"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v3, Lcom/bytedance/lego/init/InitScheduler;->registerMainActivity(Landroid/app/Activity;)V
    sget-object v3, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-virtual v3, Lcom/bytedance/trae/home/privacy/PrivacyManager;->notifyStartEventDelay()Z
    move-result v3
    if-eqz v3, +003h
    return-void 
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v0, "InitPeriodWrapper - before super activity create, curMills = "
    invoke-direct v3, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    invoke-virtual v3, v0, v1, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v0, "InitPeriodWrapper"
    invoke-static v0, v3, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v3, Lcom/bytedance/lego/init/model/InitPeriod;->MAIN_ONCREATE2SUPER Lcom/bytedance/lego/init/model/InitPeriod;
    invoke-static v3, Lcom/bytedance/lego/init/InitScheduler;->onPeriodStart(Lcom/bytedance/lego/init/model/InitPeriod;)V
    sget-object v3, Lcom/bytedance/lego/init/model/InitPeriod;->MAIN_ONCREATE2SUPER Lcom/bytedance/lego/init/model/InitPeriod;
    invoke-static v3, Lcom/bytedance/lego/init/InitScheduler;->onPeriodEnd(Lcom/bytedance/lego/init/model/InitPeriod;)V
    return-void 
.end method

.method public final beforeSuperResume()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-virtual v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->notifyStartEventDelay()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/lego/init/model/InitPeriod;->MAIN_ONRESUME2SUPER Lcom/bytedance/lego/init/model/InitPeriod;
    invoke-static v0, Lcom/bytedance/lego/init/InitScheduler;->onPeriodStart(Lcom/bytedance/lego/init/model/InitPeriod;)V
    sget-object v0, Lcom/bytedance/lego/init/model/InitPeriod;->MAIN_ONRESUME2SUPER Lcom/bytedance/lego/init/model/InitPeriod;
    invoke-static v0, Lcom/bytedance/lego/init/InitScheduler;->onPeriodEnd(Lcom/bytedance/lego/init/model/InitPeriod;)V
    return-void 
.end method

.method public final notifyAllPeriod(android.app.Activity)void
    .registers 5
    # ins_size=2
    const-string v0, "activity"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "InitPeriodWrapper - notifyAllPeriod = "
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "InitPeriodWrapper"
    invoke-static v1, v0, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    invoke-virtual v4, Landroid/app/Activity;->getApplication()Landroid/app/Application;
    move-result-object v0
    invoke-virtual v0, Landroid/app/Application;->getBaseContext()Landroid/content/Context;
    move-result-object v0
    const-string v1, "getBaseContext(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, v0, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;->applicationAttachBeforeSuper(Landroid/content/Context;)V
    invoke-virtual v3, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;->applicationAttachAfterSuper()V
    invoke-virtual v4, Landroid/app/Activity;->getApplication()Landroid/app/Application;
    move-result-object v0
    const-string v1, "getApplication(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, v0, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;->applicationCreateBeforeSuper(Landroid/app/Application;)V
    invoke-virtual v3, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;->applicationCreateAfterSuper()V
    invoke-virtual v3, v4, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;->beforeSuperCreate(Landroid/app/Activity;)V
    invoke-virtual v3, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;->afterSuperCreateStart()V
    invoke-virtual v3, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;->afterSuperCreateEnd()V
    invoke-virtual v3, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;->beforeSuperResume()V
    invoke-virtual v3, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;->afterSuperResume()V
    return-void 
.end method
