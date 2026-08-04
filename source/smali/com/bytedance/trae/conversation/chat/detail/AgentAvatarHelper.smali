# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/detail/AgentAvatarHelper;
.super Ljava/lang/Object;
.source "AgentAvatarHelper.kt"

.field private static final AGENT_ID_EXPLORE:Ljava/lang/String;
.field private static final AGENT_ID_GENERAL_PURPOSE:Ljava/lang/String;
.field private static final AGENT_ID_PLAN:Ljava/lang/String;
.field private static final AGENT_ID_SEARCH:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/detail/AgentAvatarHelper;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/AgentAvatarHelper;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/detail/AgentAvatarHelper;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/AgentAvatarHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/detail/AgentAvatarHelper;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getAvatarResId(java.lang.String)int
    .registers 3
    # ins_size=2
    if-eqz v2, +03bh
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v0
    sparse-switch v0, +0000038h
    goto +32h
    const-string v0, "general_purpose_task"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +29h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->avatar_agent_general_purpose I
    goto +28h
    const-string v0, "Explore"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +1dh
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->avatar_agent_explore I
    goto +1ch
    const-string v0, "Plan"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +11h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->avatar_agent_plan I
    goto +10h
    const-string/jumbo v0, search
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +4h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->avatar_agent_search I
    goto +3h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->avatar_coder I
    return v2
    sparse-switch-payload -36059a58 25ff49 15309273 7c0e8dfd
.end method
