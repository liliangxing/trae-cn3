# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$StartFailed;
.super Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime;
.source "VoicePrompt.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$StartFailed;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$StartFailed;
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$StartFailed;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$StartFailed;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$StartFailed;
    return-void 
.end method

.method private constructor <init>()void
    .registers 4
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_voice_error_start I
    const/4 v1, 0
    const/16 v2, 70
    invoke-direct v3, v2, v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime;-><init>(I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method
