# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/VoiceDiscussionPhase2Policy;
.super Ljava/lang/Object;
.source "VoiceDiscussionPhase2Policy.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/brainstorm/VoiceDiscussionPhase2Policy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/VoiceDiscussionPhase2Policy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/VoiceDiscussionPhase2Policy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/VoiceDiscussionPhase2Policy;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/VoiceDiscussionPhase2Policy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final isAttachmentSubTaskEnabled()boolean
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->INSTANCE Lcom/bytedance/trae/settings/api/feature/FeatureCapability;
    sget-object v1, Lcom/bytedance/trae/settings/api/feature/Feature;->BRAINSTORM_V2 Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-virtual v0, v1, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->isEnabled(Lcom/bytedance/trae/settings/api/feature/Feature;)Z
    move-result v0
    return v0
.end method
