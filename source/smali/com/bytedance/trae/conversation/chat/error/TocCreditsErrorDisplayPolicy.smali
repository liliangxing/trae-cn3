# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorDisplayPolicy;
.super Ljava/lang/Object;
.source "AgentErrorCodeRegistry.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorDisplayPolicy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorDisplayPolicy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorDisplayPolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorDisplayPolicy;->INSTANCE Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorDisplayPolicy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final resolve(java.lang.Integer  boolean)com.bytedance.trae.conversation.chat.error.TocCreditsErrorOverride
    .registers 6
    # ins_size=3
    if-eqz v5, +01ah
    if-nez v4, +003h
    goto +16h
    invoke-virtual v4, Ljava/lang/Integer;->intValue()I
    move-result v4
    const/16 v5, 4008
    if-ne v4, v5, +00fh
    new-instance v4, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;
    sget v5, Lcom/bytedance/trae/conversation/R$string;->trae_credits_exhausted I
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_credits_exhausted_title I
    sget-object v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->WARN Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    const/4 v2, 1
    invoke-direct v4, v5, v0, v1, v2, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;-><init>(I I Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Z)V
    goto +2h
    const/4 v4, 0
    return-object v4
.end method
