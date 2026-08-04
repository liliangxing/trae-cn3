# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public abstract Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;
.super Ljava/lang/Object;
.source "VoicePrompt.kt"

.field private final iconRes:I
.field private final priority:I
.field private final throttleMs:J


.method private constructor <init>(int  int  long)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;->priority I
    iput v2, v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;->iconRes I
    iput-wide v3, v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;->throttleMs J
    return-void 
.end method

.method public synthetic constructor <init>(int  int  long  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 13
    # ins_size=7
    and-int/lit8 v12, v11, 2
    if-eqz v12, +004h
    sget v8, Lcom/bytedance/trae/conversation/R$drawable;->warning_filled_yellow I
    move v2, v8
    and-int/lit8 v8, v11, 4
    if-eqz v8, +004h
    const-wide/16 v9, 30000
    move-wide v3, v9
    const/4 v5, 0
    move-object v0, v6
    move v1, v7
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;-><init>(I I J Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public synthetic constructor <init>(int  int  long  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;-><init>(I I J)V
    return-void 
.end method

.method public final getIconRes()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;->iconRes I
    return v0
.end method

.method public final getPriority()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;->priority I
    return v0
.end method

.method public final getThrottleMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;->throttleMs J
    return-wide v0
.end method

.method public abstract text(android.content.Context)java.lang.CharSequence
    # abstract or native
.end method
