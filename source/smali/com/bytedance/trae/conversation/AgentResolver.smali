# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/AgentResolver;
.super Ljava/lang/Object;
.source "AgentResolver.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/AgentResolver;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/AgentResolver;
    invoke-direct v0, Lcom/bytedance/trae/conversation/AgentResolver;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/AgentResolver;->INSTANCE Lcom/bytedance/trae/conversation/AgentResolver;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final resolveDefaultAgentType(com.bytedance.trae.im.service.Mode  com.bytedance.trae.im.service.CliType)java.lang.String
    .registers 4
    # ins_size=3
    const-string v0, "mode"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    if-ne v3, v0, +00eh
    sget-object v3, Lcom/bytedance/trae/im/service/Mode;->CODE Lcom/bytedance/trae/im/service/Mode;
    if-ne v3, v2, +006h
    const-string/jumbo v2, solo_agent_remote
    goto +18h
    const-string/jumbo v2, solo_work_remote
    goto +14h
    sget-object v0, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-ne v3, v0, +006h
    const-string/jumbo v2, solo_agent
    goto +ch
    sget-object v3, Lcom/bytedance/trae/im/service/Mode;->CODE Lcom/bytedance/trae/im/service/Mode;
    if-ne v3, v2, +006h
    const-string/jumbo v2, solo_agent_lite
    goto +4h
    const-string/jumbo v2, solo_work_lite
    return-object v2
.end method
