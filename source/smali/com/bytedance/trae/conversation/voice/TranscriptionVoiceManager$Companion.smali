# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Companion;
.super Ljava/lang/Object;
.source "TranscriptionVoiceManager.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Companion;-><init>()V
    return-void 
.end method

.method public final failureReasonFor(java.lang.Throwable)java.lang.String
    .registers 3
    # ins_size=2
    const-string v0, "error"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->Companion Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$Companion;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$Companion;->failureReasonFor(Ljava/lang/Throwable;)Ljava/lang/String;
    move-result-object v2
    return-object v2
.end method

.method public final reportImmediateAttemptEnd(java.lang.String  java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=4
    const-string v0, "outcome"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "failureReason"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "inputStateWhenFinal"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->Companion Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$Companion;
    invoke-virtual v0, v2, v3, v4, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$Companion;->reportImmediate(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
