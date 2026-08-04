# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;
.super Ljava/lang/Object;
.source "BrainstormVoiceForegroundService.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;-><init>()V
    return-void 
.end method

.method private final commandIntent(android.content.Context  java.lang.String  boolean)android.content.Intent
    .registers 6
    # ins_size=4
    new-instance v0, Landroid/content/Intent;
    const-class v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;
    invoke-direct v0, v3, v1, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    invoke-virtual v0, v4, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;
    const-string v3, "extra_mic_muted"
    invoke-virtual v0, v3, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; Z)Landroid/content/Intent;
    return-object v0
.end method

.method public final start(android.content.Context  boolean)boolean
    .registers 6
    # ins_size=3
    const-string v0, "context"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    move-result-object v4
    const-string v0, "BrainstormVoiceFGS"
    if-nez v5, +014h
    const-string v1, "android.permission.RECORD_AUDIO"
    invoke-static v4, v1, Landroidx/core/content/ContextCompat;->checkSelfPermission(Landroid/content/Context; Ljava/lang/String;)I
    move-result v1
    if-eqz v1, +00ch
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v5, start refused: RECORD_AUDIO not granted
    invoke-virtual v4, v0, v5, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v4, 0
    return v4
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v3
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    const-string v1, "com.bytedance.trae.conversation.brainstorm.voice_fg.START"
    invoke-direct v3, v4, v1, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;->commandIntent(Landroid/content/Context; Ljava/lang/String; Z)Landroid/content/Intent;
    move-result-object v5
    invoke-static v4, v5, Landroidx/core/content/ContextCompat;->startForegroundService(Landroid/content/Context; Landroid/content/Intent;)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    goto +ch
    move-exception v4
    sget-object v5, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v4, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v5
    if-eqz v5, +00ah
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v2, startForegroundService failed
    invoke-virtual v1, v0, v2, v5, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-static v4, Lkotlin/Result;->isSuccess-impl(Ljava/lang/Object;)Z
    move-result v4
    return v4
    :try_start_0x1f
.end method

.method public final stop(android.content.Context)void
    .registers 5
    # ins_size=2
    const-string v0, "context"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    move-result-object v4
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v3
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;
    new-instance v0, Landroid/content/Intent;
    const-class v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;
    invoke-direct v0, v4, v1, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    invoke-virtual v4, v0, Landroid/content/Context;->stopService(Landroid/content/Intent;)Z
    move-result v4
    invoke-static v4, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    goto +ch
    move-exception v4
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v4, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v4
    if-eqz v4, +00ch
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "BrainstormVoiceFGS"
    const-string/jumbo v2, stopService failed
    invoke-virtual v0, v1, v2, v4, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x9
.end method

.method public final update(android.content.Context  boolean)void
    .registers 5
    # ins_size=3
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    move-result-object v3
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v2
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    const-string v0, "com.bytedance.trae.conversation.brainstorm.voice_fg.UPDATE"
    invoke-direct v2, v3, v0, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;->commandIntent(Landroid/content/Context; Ljava/lang/String; Z)Landroid/content/Intent;
    move-result-object v4
    invoke-virtual v3, v4, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    goto +ch
    move-exception v3
    sget-object v4, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v3
    if-eqz v3, +00ch
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v0, "BrainstormVoiceFGS"
    const-string/jumbo v1, update ignored: service is not running
    invoke-virtual v4, v0, v1, v3, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x9
.end method
