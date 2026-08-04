# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker$Companion;
.super Ljava/lang/Object;
.source "VoiceDiscussionAttemptTracker.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker$Companion;-><init>()V
    return-void 
.end method

.method public static final synthetic access$normalizeFailureReason(com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptTracker$Companion  java.lang.String)java.lang.String
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker$Companion;->normalizeFailureReason(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final normalizeFailureReason(java.lang.String)java.lang.String
    .registers 14
    # ins_size=2
    const/16 v1, 13
    const/16 v2, 32
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    move-object v0, v13
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; C C Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    const/16 v7, 10
    const/16 v8, 32
    const/4 v9, 0
    const/4 v10, 4
    const/4 v11, 0
    invoke-static/range v6 ... v11, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; C C Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v13
    check-cast v13, Ljava/lang/CharSequence;
    invoke-static v13, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v13
    const/16 v0, 120
    invoke-static v13, v0, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v13
    return-object v13
.end method

.method public final isVoiceDetected(float)boolean
    .registers 3
    # ins_size=2
    const v0, 1028443341
    cmpl-float v2, v2, v0
    if-ltz v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    return v2
.end method
