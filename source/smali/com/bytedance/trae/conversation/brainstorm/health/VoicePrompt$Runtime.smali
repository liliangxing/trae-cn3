# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public abstract Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime;
.super Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;
.source "VoicePrompt.kt"

.field private final messageRes:I


.method private constructor <init>(int  int)void
    .registers 10
    # ins_size=3
    const/4 v2, 0
    const-wide/16 v3, 5000
    const/4 v5, 2
    const/4 v6, 0
    move-object v0, v7
    move v1, v8
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;-><init>(I I J I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput v9, v7, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime;->messageRes I
    return-void 
.end method

.method public synthetic constructor <init>(int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime;-><init>(I I)V
    return-void 
.end method

.method public text(android.content.Context)java.lang.CharSequence
    .registers 3
    # ins_size=2
    const-string v0, "ctx"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime;->messageRes I
    invoke-virtual v2, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v2
    const-string v0, "getString(...)"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Ljava/lang/CharSequence;
    return-object v2
.end method
