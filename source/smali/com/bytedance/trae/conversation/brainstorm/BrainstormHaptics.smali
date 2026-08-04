# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;
.super Ljava/lang/Object;
.source "BrainstormHaptics.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final obtainVibrator(android.content.Context)android.os.Vibrator
    .registers 5
    # ins_size=2
    sget v0, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v1, 31
    const/4 v2, 0
    if-lt v0, v1, +018h
    const-string/jumbo v0, vibrator_manager
    invoke-virtual v4, v0, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v4
    instance-of v0, v4, Landroid/os/VibratorManager;
    if-eqz v0, +005h
    check-cast v4, Landroid/os/VibratorManager;
    goto +2h
    move-object v4, v2
    if-eqz v4, +015h
    invoke-virtual v4, Landroid/os/VibratorManager;->getDefaultVibrator()Landroid/os/Vibrator;
    move-result-object v2
    goto +fh
    const-string/jumbo v0, vibrator
    invoke-virtual v4, v0, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v4
    instance-of v0, v4, Landroid/os/Vibrator;
    if-eqz v0, +005h
    move-object v2, v4
    check-cast v2, Landroid/os/Vibrator;
    return-object v2
.end method

.method private final playEndDismissApi26(android.os.Vibrator)void
    .registers 5
    # ins_size=2
    const/4 v0, 6
    new-array v1, v0, [J
    fill-array-data v1, +0000037h
    new-array v0, v0, [I
    fill-array-data v0, +000004eh
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v2, v3
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;
    const/4 v2, -1
    invoke-static v1, v0, v2, Landroid/os/VibrationEffect;->createWaveform([J [I I)Landroid/os/VibrationEffect;
    move-result-object v0
    invoke-virtual v4, v0, Landroid/os/Vibrator;->vibrate(Landroid/os/VibrationEffect;)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
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
    if-eqz v4, +00bh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "BrainstormHaptics"
    const-string v2, "playEndDismissApi26: vibrate failed"
    invoke-virtual v0, v1, v2, v4, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    fill-array-data-payload b'\x00\x00\x00\x00\x00\x00\x00\x00\x0f\x00\x00\x00\x00\x00\x00\x00U\x00\x00\x00\x00\x00\x00\x00\x0f\x00\x00\x00\x00\x00\x00\x00U\x00\x00\x00\x00\x00\x00\x00\x0f\x00\x00\x00\x00\x00\x00\x00' | \x00\x00\x00\x00\x00\x00\x00\x00\x0f\x00\x00\x00\x00\x00\x00\x00\x55\x00\x00\x00\x00\x00\x00\x00\x0f\x00\x00\x00\x00\x00\x00\x00\x55\x00\x00\x00\x00\x00\x00\x00\x0f\x00\x00\x00\x00\x00\x00\x00
    fill-array-data-payload b'\x00\x00\x00\x00\xc8\x00\x00\x00\x00\x00\x00\x00\xbe\x00\x00\x00\x00\x00\x00\x00\xc8\x00\x00\x00' | \x00\x00\x00\x00\xc8\x00\x00\x00\x00\x00\x00\x00\xbe\x00\x00\x00\x00\x00\x00\x00\xc8\x00\x00\x00
    :try_start_0xb
.end method

.method private final playEndDismissApi31(android.os.Vibrator)void
    .registers 8
    # ins_size=2
    const/4 v0, 1
    new-array v0, v0, [I
    const/4 v1, 0
    const/4 v2, 7
    aput v2, v0, v1
    invoke-virtual v7, v0, Landroid/os/Vibrator;->areAllPrimitivesSupported([I)Z
    move-result v0
    const-string v3, "BrainstormHaptics"
    if-nez v0, +00dh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "playEndDismissApi31: PRIMITIVE_TICK unsupported, fallback to waveform"
    invoke-virtual v0, v3, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;->playEndDismissApi26(Landroid/os/Vibrator;)V
    return-void 
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v6
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;
    invoke-static Landroid/os/VibrationEffect;->startComposition()Landroid/os/VibrationEffect$Composition;
    move-result-object v0
    const v4, 1063675494
    invoke-virtual v0, v2, v4, v1, Landroid/os/VibrationEffect$Composition;->addPrimitive(I F I)Landroid/os/VibrationEffect$Composition;
    move-result-object v0
    const v1, 1062836634
    const/16 v5, 100
    invoke-virtual v0, v2, v1, v5, Landroid/os/VibrationEffect$Composition;->addPrimitive(I F I)Landroid/os/VibrationEffect$Composition;
    move-result-object v0
    invoke-virtual v0, v2, v4, v5, Landroid/os/VibrationEffect$Composition;->addPrimitive(I F I)Landroid/os/VibrationEffect$Composition;
    move-result-object v0
    invoke-virtual v0, Landroid/os/VibrationEffect$Composition;->compose()Landroid/os/VibrationEffect;
    move-result-object v0
    const-string v1, "compose(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v7, v0, Landroid/os/Vibrator;->vibrate(Landroid/os/VibrationEffect;)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v7, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    goto +ch
    move-exception v7
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v7, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v7
    if-eqz v7, +009h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "playEndDismissApi31: vibrate failed"
    invoke-virtual v0, v3, v1, v7, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x1a
.end method

.method private final playEndDismissLegacy(android.os.Vibrator)void
    .registers 8
    # ins_size=2
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v6
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;
    const/4 v0, 6
    new-array v0, v0, [J
    const/4 v1, 0
    const-wide/16 v2, 0
    aput-wide v2, v0, v1
    const/4 v1, 1
    const-wide/16 v2, 15
    aput-wide v2, v0, v1
    const/4 v1, 2
    const-wide/16 v4, 85
    aput-wide v4, v0, v1
    const/4 v1, 3
    aput-wide v2, v0, v1
    const/4 v1, 4
    aput-wide v4, v0, v1
    const/4 v1, 5
    aput-wide v2, v0, v1
    const/4 v1, -1
    invoke-virtual v7, v0, v1, Landroid/os/Vibrator;->vibrate([J I)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v7, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    goto +ch
    move-exception v7
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v7, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v7
    if-eqz v7, +00bh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "BrainstormHaptics"
    const-string v2, "playEndDismissLegacy: vibrate failed"
    invoke-virtual v0, v1, v2, v7, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x0
.end method

.method private final playKnockApi26(android.os.Vibrator)void
    .registers 5
    # ins_size=2
    const/4 v0, 6
    new-array v1, v0, [J
    fill-array-data v1, +0000037h
    new-array v0, v0, [I
    fill-array-data v0, +000004eh
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v2, v3
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;
    const/4 v2, -1
    invoke-static v1, v0, v2, Landroid/os/VibrationEffect;->createWaveform([J [I I)Landroid/os/VibrationEffect;
    move-result-object v0
    invoke-virtual v4, v0, Landroid/os/Vibrator;->vibrate(Landroid/os/VibrationEffect;)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
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
    if-eqz v4, +00bh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "BrainstormHaptics"
    const-string v2, "playKnockApi26: vibrate failed"
    invoke-virtual v0, v1, v2, v4, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    fill-array-data-payload b'\x00\x00\x00\x00\x00\x00\x00\x00\x1e\x00\x00\x00\x00\x00\x00\x00\x96\x00\x00\x00\x00\x00\x00\x00\x1e\x00\x00\x00\x00\x00\x00\x00\x96\x00\x00\x00\x00\x00\x00\x00\x1e\x00\x00\x00\x00\x00\x00\x00' | \x00\x00\x00\x00\x00\x00\x00\x00\x1e\x00\x00\x00\x00\x00\x00\x00\x96\x00\x00\x00\x00\x00\x00\x00\x1e\x00\x00\x00\x00\x00\x00\x00\x96\x00\x00\x00\x00\x00\x00\x00\x1e\x00\x00\x00\x00\x00\x00\x00
    fill-array-data-payload b'\x00\x00\x00\x00\xf0\x00\x00\x00\x00\x00\x00\x00\xe6\x00\x00\x00\x00\x00\x00\x00\xeb\x00\x00\x00' | \x00\x00\x00\x00\xf0\x00\x00\x00\x00\x00\x00\x00\xe6\x00\x00\x00\x00\x00\x00\x00\xeb\x00\x00\x00
    :try_start_0xb
.end method

.method private final playKnockApi31(android.os.Vibrator)void
    .registers 7
    # ins_size=2
    const/4 v0, 1
    new-array v0, v0, [I
    const/4 v1, 0
    const/4 v2, 2
    aput v2, v0, v1
    invoke-virtual v6, v0, Landroid/os/Vibrator;->areAllPrimitivesSupported([I)Z
    move-result v0
    const-string v3, "BrainstormHaptics"
    if-nez v0, +00dh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "playKnockApi31: PRIMITIVE_THUD unsupported, fallback to waveform"
    invoke-virtual v0, v3, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;->playKnockApi26(Landroid/os/Vibrator;)V
    return-void 
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v5
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;
    invoke-static Landroid/os/VibrationEffect;->startComposition()Landroid/os/VibrationEffect$Composition;
    move-result-object v0
    const v4, 1064346583
    invoke-virtual v0, v2, v4, v1, Landroid/os/VibrationEffect$Composition;->addPrimitive(I F I)Landroid/os/VibrationEffect$Composition;
    move-result-object v0
    const v1, 1063675494
    const/16 v4, 180
    invoke-virtual v0, v2, v1, v4, Landroid/os/VibrationEffect$Composition;->addPrimitive(I F I)Landroid/os/VibrationEffect$Composition;
    move-result-object v0
    const v1, 1064011039
    invoke-virtual v0, v2, v1, v4, Landroid/os/VibrationEffect$Composition;->addPrimitive(I F I)Landroid/os/VibrationEffect$Composition;
    move-result-object v0
    invoke-virtual v0, Landroid/os/VibrationEffect$Composition;->compose()Landroid/os/VibrationEffect;
    move-result-object v0
    const-string v1, "compose(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v6, v0, Landroid/os/Vibrator;->vibrate(Landroid/os/VibrationEffect;)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v6, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    goto +ch
    move-exception v6
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v6, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v6
    invoke-static v6, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    invoke-static v6, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v6
    if-eqz v6, +009h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "playKnockApi31: vibrate failed"
    invoke-virtual v0, v3, v1, v6, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x1a
.end method

.method private final playKnockLegacy(android.os.Vibrator)void
    .registers 8
    # ins_size=2
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v6
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;
    const/4 v0, 6
    new-array v0, v0, [J
    const/4 v1, 0
    const-wide/16 v2, 0
    aput-wide v2, v0, v1
    const/4 v1, 1
    const-wide/16 v2, 30
    aput-wide v2, v0, v1
    const/4 v1, 2
    const-wide/16 v4, 150
    aput-wide v4, v0, v1
    const/4 v1, 3
    aput-wide v2, v0, v1
    const/4 v1, 4
    aput-wide v4, v0, v1
    const/4 v1, 5
    aput-wide v2, v0, v1
    const/4 v1, -1
    invoke-virtual v7, v0, v1, Landroid/os/Vibrator;->vibrate([J I)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v7, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    goto +ch
    move-exception v7
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v7, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v7
    if-eqz v7, +00bh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "BrainstormHaptics"
    const-string v2, "playKnockLegacy: vibrate failed"
    invoke-virtual v0, v1, v2, v7, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x0
.end method

.method private final playSoftImpactApi26(android.os.Vibrator)void
    .registers 5
    # ins_size=2
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v3
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;
    const-wide/16 v0, 18
    const/16 v2, 90
    invoke-static v0, v1, v2, Landroid/os/VibrationEffect;->createOneShot(J I)Landroid/os/VibrationEffect;
    move-result-object v0
    invoke-virtual v4, v0, Landroid/os/Vibrator;->vibrate(Landroid/os/VibrationEffect;)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
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
    if-eqz v4, +00bh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "BrainstormHaptics"
    const-string v2, "playSoftImpactApi26: vibrate failed"
    invoke-virtual v0, v1, v2, v4, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x0
.end method

.method private final playSoftImpactApi31(android.os.Vibrator)void
    .registers 7
    # ins_size=2
    const/4 v0, 1
    new-array v0, v0, [I
    const/4 v1, 0
    const/16 v2, 8
    aput v2, v0, v1
    invoke-virtual v6, v0, Landroid/os/Vibrator;->areAllPrimitivesSupported([I)Z
    move-result v0
    const-string v3, "BrainstormHaptics"
    if-nez v0, +00dh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "playSoftImpactApi31: PRIMITIVE_LOW_TICK unsupported, fallback to waveform"
    invoke-virtual v0, v3, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;->playSoftImpactApi26(Landroid/os/Vibrator;)V
    return-void 
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v5
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;
    invoke-static Landroid/os/VibrationEffect;->startComposition()Landroid/os/VibrationEffect$Composition;
    move-result-object v0
    const v4, 1055286886
    invoke-virtual v0, v2, v4, v1, Landroid/os/VibrationEffect$Composition;->addPrimitive(I F I)Landroid/os/VibrationEffect$Composition;
    move-result-object v0
    invoke-virtual v0, Landroid/os/VibrationEffect$Composition;->compose()Landroid/os/VibrationEffect;
    move-result-object v0
    invoke-virtual v6, v0, Landroid/os/Vibrator;->vibrate(Landroid/os/VibrationEffect;)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v6, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    goto +ch
    move-exception v6
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v6, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v6
    invoke-static v6, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    invoke-static v6, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v6
    if-eqz v6, +009h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "playSoftImpactApi31: vibrate failed"
    invoke-virtual v0, v3, v1, v6, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x1b
.end method

.method private final playSoftImpactLegacy(android.os.Vibrator)void
    .registers 5
    # ins_size=2
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v3
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;
    const-wide/16 v0, 18
    invoke-virtual v4, v0, v1, Landroid/os/Vibrator;->vibrate(J)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
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
    if-eqz v4, +00bh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "BrainstormHaptics"
    const-string v2, "playSoftImpactLegacy: vibrate failed"
    invoke-virtual v0, v1, v2, v4, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x0
.end method

.method public final playEndDismiss(android.content.Context)void
    .registers 4
    # ins_size=2
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;->obtainVibrator(Landroid/content/Context;)Landroid/os/Vibrator;
    move-result-object v3
    if-nez v3, +003h
    return-void 
    invoke-virtual v3, Landroid/os/Vibrator;->hasVibrator()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    sget v0, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v1, 31
    if-lt v0, v1, +006h
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;->playEndDismissApi31(Landroid/os/Vibrator;)V
    goto +eh
    sget v0, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v1, 26
    if-lt v0, v1, +006h
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;->playEndDismissApi26(Landroid/os/Vibrator;)V
    goto +4h
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;->playEndDismissLegacy(Landroid/os/Vibrator;)V
    return-void 
.end method

.method public final playKnock(android.content.Context)void
    .registers 4
    # ins_size=2
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;->obtainVibrator(Landroid/content/Context;)Landroid/os/Vibrator;
    move-result-object v3
    if-nez v3, +003h
    return-void 
    invoke-virtual v3, Landroid/os/Vibrator;->hasVibrator()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    sget v0, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v1, 31
    if-lt v0, v1, +006h
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;->playKnockApi31(Landroid/os/Vibrator;)V
    goto +eh
    sget v0, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v1, 26
    if-lt v0, v1, +006h
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;->playKnockApi26(Landroid/os/Vibrator;)V
    goto +4h
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;->playKnockLegacy(Landroid/os/Vibrator;)V
    return-void 
.end method

.method public final playSoftImpact(android.content.Context)void
    .registers 4
    # ins_size=2
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;->obtainVibrator(Landroid/content/Context;)Landroid/os/Vibrator;
    move-result-object v3
    if-nez v3, +003h
    return-void 
    invoke-virtual v3, Landroid/os/Vibrator;->hasVibrator()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    sget v0, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v1, 31
    if-lt v0, v1, +006h
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;->playSoftImpactApi31(Landroid/os/Vibrator;)V
    goto +eh
    sget v0, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v1, 26
    if-lt v0, v1, +006h
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;->playSoftImpactApi26(Landroid/os/Vibrator;)V
    goto +4h
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;->playSoftImpactLegacy(Landroid/os/Vibrator;)V
    return-void 
.end method
