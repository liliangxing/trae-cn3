# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/skill/SkillRequestPolicy;
.super Ljava/lang/Object;
.source "SkillRequestPolicy.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/skill/SkillRequestPolicy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/skill/SkillRequestPolicy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/skill/SkillRequestPolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/skill/SkillRequestPolicy;->INSTANCE Lcom/bytedance/trae/conversation/skill/SkillRequestPolicy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic buildQuery$default(com.bytedance.trae.conversation.skill.SkillRequestPolicy  com.bytedance.trae.conversation.skill.SkillRequestContext  java.lang.String  int  java.lang.Object)java.util.Map
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/skill/SkillRequestPolicy;->buildQuery(Lcom/bytedance/trae/conversation/skill/SkillRequestContext; Ljava/lang/String;)Ljava/util/Map;
    move-result-object v0
    return-object v0
.end method

.method public final buildQuery(com.bytedance.trae.conversation.skill.SkillRequestContext  java.lang.String)java.util.Map
    .registers 7
    # ins_size=3
    const-string v0, "context"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    move-object v1, v6
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 1
    if-eqz v1, +00bh
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    move v1, v2
    if-nez v1, +007h
    const-string v1, "page_token"
    invoke-interface v0, v1, v6, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/skill/SkillRequestContext;->getCliId()Ljava/lang/String;
    move-result-object v6
    const/4 v1, 0
    if-eqz v6, +00dh
    move-object v3, v6
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/2addr v3, v2
    if-eqz v3, +003h
    goto +2h
    move-object v6, v1
    if-eqz v6, +06bh
    const-string v3, "cli_id"
    invoke-interface v0, v3, v6, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/skill/SkillRequestContext;->getProjectId()Ljava/lang/String;
    move-result-object v6
    if-eqz v6, +015h
    move-object v3, v6
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/2addr v3, v2
    if-eqz v3, +003h
    goto +2h
    move-object v6, v1
    if-eqz v6, +007h
    const-string v3, "project_id"
    invoke-interface v0, v3, v6, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/skill/SkillRequestContext;->getWorkspaceFolder()Ljava/lang/String;
    move-result-object v6
    if-eqz v6, +016h
    move-object v3, v6
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/2addr v3, v2
    if-eqz v3, +003h
    goto +2h
    move-object v6, v1
    if-eqz v6, +008h
    const-string/jumbo v3, workspace_folder
    invoke-interface v0, v3, v6, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/skill/SkillRequestContext;->getConfigName()Ljava/lang/String;
    move-result-object v6
    if-eqz v6, +015h
    move-object v3, v6
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/2addr v3, v2
    if-eqz v3, +003h
    goto +2h
    move-object v6, v1
    if-eqz v6, +007h
    const-string v3, "config_name"
    invoke-interface v0, v3, v6, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/skill/SkillRequestContext;->getAgentType()Ljava/lang/String;
    move-result-object v5
    if-eqz v5, +014h
    move-object v6, v5
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v6, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v6
    xor-int/2addr v6, v2
    if-eqz v6, +003h
    move-object v1, v5
    if-eqz v1, +007h
    const-string v5, "agent_type"
    invoke-interface v0, v5, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-object v0
.end method

.method public final shouldUseHubApi(com.bytedance.trae.conversation.skill.SkillRequestContext)boolean
    .registers 3
    # ins_size=2
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/skill/SkillRequestContext;->getCliId()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v0, 1
    if-eqz v2, +00bh
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    move v2, v0
    xor-int/2addr v2, v0
    return v2
.end method
