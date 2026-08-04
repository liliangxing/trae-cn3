# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health$OutputVolumeMuted;
.super Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health;
.source "VoicePrompt.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health$OutputVolumeMuted;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health$OutputVolumeMuted;
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health$OutputVolumeMuted;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health$OutputVolumeMuted;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health$OutputVolumeMuted;
    return-void 
.end method

.method private constructor <init>()void
    .registers 4
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_exception_output_volume_muted I
    const/4 v1, 0
    const/16 v2, 45
    invoke-direct v3, v2, v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health;-><init>(I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method
