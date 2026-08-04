# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;
.super Ljava/lang/Object;
.source "AgentContentBlockBuilder.kt"

.field private static final AGENT_FLOW_TAG:Ljava/lang/String;
.field private static final BLOCK_TAG:Ljava/lang/String;
.field private static final CREDITS_EXHAUSTED_ERROR_CODE:I
.field private static final FINISH_TOOLS:Ljava/util/Set;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;
.field private static final PURE_SHOW_WIDGET_TOOL_NAME:Ljava/lang/String;
.field private static final gson:Lcom/google/gson/Gson;


.method public static synthetic $r8$lambda$6tZ46E0wp4w6kUkWkvVeJoKixN8(java.lang.String  com.bytedance.trae.im.model.ParsedPlanItem)boolean
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->extractVoiceSummaryFromThought$lambda$31(Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedPlanItem;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$ETITxJfBVw_K1IT2qGuFGi3qGfA(java.lang.String  com.bytedance.trae.im.model.ParsedPlanItem)boolean
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->extractSummary$lambda$24(Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedPlanItem;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$LBpAJUNFWYWdX3OM86YJ9GAE5-U(java.lang.String  com.bytedance.trae.im.model.ParsedPlanItem)boolean
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->extractVoiceSummaryFromFinishParams$lambda$29(Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedPlanItem;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$YXxSNmsCNLmMj3zRHCgaVIECGls(com.bytedance.trae.im.model.ParsedPlanItem)com.bytedance.trae.conversation.chat.block.VoiceSummaryPayload
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->extractVoiceSummaryFromFinishParams$lambda$30(Lcom/bytedance/trae/im/model/ParsedPlanItem;)Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$jZ311PFha-Q3-eiaZMPLRtO72Aw(com.bytedance.trae.im.model.ParsedPlanItem)com.bytedance.trae.conversation.chat.block.VoiceSummaryPayload
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->extractVoiceSummaryFromThought$lambda$32(Lcom/bytedance/trae/im/model/ParsedPlanItem;)Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$ozA8VcYc6fIu1aln3JvdUGR1Ebk(com.bytedance.trae.im.model.ParsedPlanItem)java.lang.String
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->extractSummary$lambda$27(Lcom/bytedance/trae/im/model/ParsedPlanItem;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 8
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;
    new-instance v0, Lcom/google/gson/Gson;
    invoke-direct v0, Lcom/google/gson/Gson;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->gson Lcom/google/gson/Gson;
    const-string v1, "finish"
    const-string v2, "Finish"
    const-string v3, "agent_finish"
    const-string v4, "AgentFinish"
    const-string/jumbo v5, response_to_user
    const-string v6, "ResponseToUser"
    const-string v7, "Task"
    filled-new-array/range v1 ... v7, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->FINISH_TOOLS Ljava/util/Set;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final allPlanItemsAreFinishOnly(java.util.List)boolean
    .registers 8
    # ins_size=2
    move-object v0, v7
    check-cast v0, Ljava/util/Collection;
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +003h
    return v2
    check-cast v7, Ljava/lang/Iterable;
    instance-of v0, v7, Ljava/util/Collection;
    if-eqz v0, +00dh
    move-object v0, v7
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +004h
    move v1, v2
    goto +55h
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, -00ah
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v3
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    if-eqz v3, +00ch
    sget-object v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->FINISH_TOOLS Ljava/util/Set;
    invoke-interface v4, v3, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +004h
    move v3, v2
    goto +2h
    move v3, v1
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getReasoningContent()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00bh
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    if-eqz v4, +003h
    goto +3h
    move v4, v1
    goto +2h
    move v4, v2
    xor-int/2addr v4, v2
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getHide()Ljava/lang/Boolean;
    move-result-object v0
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v5
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +009h
    if-eqz v3, +005h
    if-nez v4, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    if-nez v0, -04eh
    return v1
.end method

.method private static final build$addNoticeBlock(java.lang.Integer  com.bytedance.trae.im.model.ParsedChatMessage  java.util.List  java.lang.String  java.lang.String  java.lang.String)void
    .registers 15
    # ins_size=6
    if-eqz v9, +007h
    invoke-virtual v9, Ljava/lang/Integer;->intValue()I
    move-result v0
    goto +2h
    const/4 v0, 1
    move v2, v0
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v3, "[Builder] addNoticeBlock: queuingPos="
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v1, ", noticeType="
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v10, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getNoticeType()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    const-string v1, "AgentBlock"
    invoke-virtual v0, v1, v9, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v10, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getRequestUUID()Ljava/lang/String;
    move-result-object v8
    new-instance v9, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;
    const/4 v6, 0
    move-object v1, v9
    move-object v3, v12
    move-object v4, v13
    move-object v5, v10
    move-object v7, v14
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;-><init>(I Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/im/service/FastRequestEvent; Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v11, v9, Ljava/util/List;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method private static final build$addQueueBlock(java.lang.Integer  com.bytedance.trae.im.model.ParsedChatMessage  boolean  java.util.List  java.lang.String  boolean)void
    .registers 19
    # ins_size=6
    move-object v0, v13
    move-object/from16 v1, v16
    if-eqz v0, +007h
    invoke-virtual v13, Ljava/lang/Integer;->intValue()I
    move-result v2
    goto +2h
    const/4 v2, 1
    move v4, v2
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v5, "[Builder] addQueueBlock: queuingPos="
    invoke-direct v3, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v3, 32
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getFastRequestEvent()Lcom/bytedance/trae/im/service/FastRequestEvent;
    move-result-object v5
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingManager;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingManager;
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getRequestUUID()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v3, v5, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingManager;->hasUsedPayRight(Ljava/lang/String; Ljava/lang/String;)Z
    move-result v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v3, "AgentBlock"
    invoke-virtual v2, v3, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v15, +01bh
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getQueuingMessage()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getRequestUUID()Ljava/lang/String;
    move-result-object v10
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;
    const/4 v5, 0
    const/4 v8, 0
    const/4 v11, 2
    const/4 v12, 0
    move-object v3, v0
    move-object v7, v14
    move-object/from16 v9, v17
    invoke-direct/range v3 ... v12, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;-><init>(I Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/im/service/FastRequestEvent; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v1, v0, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto +45h
    if-nez v18, +02eh
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingManager;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingManager;
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getRequestUUID()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingManager;->hasUsedPayRight(Ljava/lang/String; Ljava/lang/String;)Z
    move-result v0
    if-nez v0, +034h
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getQueuingMessage()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getFastRequestEvent()Lcom/bytedance/trae/im/service/FastRequestEvent;
    move-result-object v8
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getRequestUUID()Ljava/lang/String;
    move-result-object v10
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;
    const/4 v5, 0
    const/4 v11, 2
    const/4 v12, 0
    move-object v3, v0
    move-object v7, v14
    move-object/from16 v9, v17
    invoke-direct/range v3 ... v12, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;-><init>(I Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/im/service/FastRequestEvent; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v1, v0, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto +17h
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getQueuingMessage()Ljava/lang/String;
    move-result-object v6
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;
    const/4 v5, 0
    const/4 v8, 0
    const/4 v10, 0
    const/16 v11, 82
    const/4 v12, 0
    move-object v3, v0
    move-object v7, v14
    move-object/from16 v9, v17
    invoke-direct/range v3 ... v12, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;-><init>(I Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/im/service/FastRequestEvent; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v1, v0, Ljava/util/List;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public static synthetic build$default(com.bytedance.trae.conversation.chat.block.AgentContentBlockBuilder  com.bytedance.trae.im.model.ParsedChatMessage  android.content.res.Resources  com.bytedance.trae.im.service.Conversation  kotlin.jvm.functions.Function1  com.bytedance.trae.conversation.chat.IMessageListener  boolean  boolean  com.bytedance.trae.conversation.chat.block.AgentContentBlock$FeedbackState  int  int  boolean  int  java.lang.Object)java.util.List
    .registers 28
    # ins_size=14
    move/from16 v0, v26
    and-int/lit8 v1, v0, 8
    if-eqz v1, +005h
    const/4 v1, 0
    move-object v6, v1
    goto +3h
    move-object/from16 v6, v18
    and-int/lit8 v1, v0, 32
    if-eqz v1, +005h
    const/4 v1, 1
    move v8, v1
    goto +3h
    move/from16 v8, v20
    and-int/lit8 v1, v0, 64
    const/4 v2, 0
    if-eqz v1, +004h
    move v9, v2
    goto +3h
    move/from16 v9, v21
    and-int/lit16 v1, v0, 128
    if-eqz v1, +006h
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;->NONE Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    move-object v10, v1
    goto +3h
    move-object/from16 v10, v22
    and-int/lit16 v1, v0, 256
    if-eqz v1, +004h
    move v11, v2
    goto +3h
    move/from16 v11, v23
    and-int/lit16 v1, v0, 512
    if-eqz v1, +004h
    move v12, v2
    goto +3h
    move/from16 v12, v24
    and-int/lit16 v0, v0, 1024
    if-eqz v0, +031h
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    sget-object v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v0
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    move-object v0, v1
    check-cast v0, Ljava/lang/Boolean;
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    move v13, v0
    goto +3h
    move/from16 v13, v25
    move-object v2, v14
    move-object v3, v15
    move-object/from16 v4, v16
    move-object/from16 v5, v17
    move-object/from16 v7, v19
    invoke-virtual/range v2 ... v13, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->build(Lcom/bytedance/trae/im/model/ParsedChatMessage; Landroid/content/res/Resources; Lcom/bytedance/trae/im/service/Conversation; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/conversation/chat/IMessageListener; Z Z Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState; I I Z)Ljava/util/List;
    move-result-object v0
    return-object v0
    :try_start_0x3b
.end method

.method private final buildVideoArtifactInputs(java.util.List)java.util.List
    .registers 16
    # ins_size=2
    if-nez v15, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v15
    check-cast v15, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    const/16 v1, 10
    invoke-static v15, v1, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v2
    invoke-direct v0, v2, Ljava/util/ArrayList;-><init>(I)V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v15, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v15
    invoke-interface v15, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +0e1h
    invoke-interface v15, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v3
    const/4 v4, 0
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v5
    goto +2h
    move-object v5, v4
    if-eqz v5, +042h
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getData()Lcom/google/gson/JsonObject;
    move-result-object v6
    if-eqz v6, +03ch
    sget-object v7, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    sget-object v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->gson Lcom/google/gson/Gson;
    check-cast v6, Lcom/google/gson/JsonElement;
    const-class v8, Lcom/bytedance/trae/im/model/FinishCardResult;
    invoke-virtual v7, v6, v8, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/im/model/FinishCardResult;
    invoke-static v6, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    goto +ch
    move-exception v6
    sget-object v7, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v6, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v6
    invoke-static v6, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    invoke-static v6, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +003h
    move-object v6, v4
    check-cast v6, Lcom/bytedance/trae/im/model/FinishCardResult;
    if-eqz v6, +013h
    invoke-virtual v6, Lcom/bytedance/trae/im/model/FinishCardResult;->getData()Lcom/bytedance/trae/im/model/FinishCardResultData;
    move-result-object v7
    if-eqz v7, +008h
    invoke-virtual v7, Lcom/bytedance/trae/im/model/FinishCardResultData;->getProducts()Lcom/bytedance/trae/im/model/ArtifactData;
    move-result-object v7
    if-nez v7, +008h
    invoke-virtual v6, Lcom/bytedance/trae/im/model/FinishCardResult;->getProducts()Lcom/bytedance/trae/im/model/ArtifactData;
    move-result-object v7
    goto +2h
    move-object v7, v4
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getAgentRunId()Ljava/lang/String;
    move-result-object v2
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v4
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v4
    if-eqz v7, +00dh
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ArtifactData;->getChangedVideos()Lcom/bytedance/trae/im/model/ChangedVideoData;
    move-result-object v6
    if-eqz v6, +007h
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ChangedVideoData;->getFileDiffInfos()Ljava/util/List;
    move-result-object v6
    goto +2h
    move-object v6, v4
    if-nez v6, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v6
    check-cast v6, Ljava/lang/Iterable;
    new-instance v7, Ljava/util/ArrayList;
    invoke-static v6, v1, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v8
    invoke-direct v7, v8, Ljava/util/ArrayList;-><init>(I)V
    check-cast v7, Ljava/util/Collection;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v8
    if-eqz v8, +040h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;
    sget-object v9, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;
    invoke-virtual v8, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;->getFilePath()Lcom/google/gson/JsonElement;
    move-result-object v10
    invoke-direct v9, v10, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->primitiveStringOrNull(Lcom/google/gson/JsonElement;)Ljava/lang/String;
    move-result-object v10
    invoke-virtual v8, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;->getFileAction()Lcom/google/gson/JsonElement;
    move-result-object v11
    invoke-direct v9, v11, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->primitiveStringOrNull(Lcom/google/gson/JsonElement;)Ljava/lang/String;
    move-result-object v11
    invoke-virtual v8, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;->getVideoInfo()Lcom/bytedance/trae/im/model/VideoInfoData;
    move-result-object v8
    if-eqz v8, +018h
    new-instance v12, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactInfoInput;
    invoke-virtual v8, Lcom/bytedance/trae/im/model/VideoInfoData;->getLastFrameUri()Lcom/google/gson/JsonElement;
    move-result-object v13
    invoke-direct v9, v13, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->primitiveStringOrNull(Lcom/google/gson/JsonElement;)Ljava/lang/String;
    move-result-object v13
    invoke-virtual v8, Lcom/bytedance/trae/im/model/VideoInfoData;->getDuration()Lcom/google/gson/JsonElement;
    move-result-object v8
    invoke-direct v9, v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->primitiveIntOrNull(Lcom/google/gson/JsonElement;)Ljava/lang/Integer;
    move-result-object v8
    invoke-direct v12, v13, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactInfoInput;-><init>(Ljava/lang/String; Ljava/lang/Integer;)V
    goto +2h
    move-object v12, v4
    new-instance v8, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;
    invoke-direct v8, v10, v11, v12, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactInfoInput;)V
    invoke-interface v7, v8, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -43h
    check-cast v7, Ljava/util/List;
    new-instance v4, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;
    invoke-direct v4, v2, v3, v5, v7, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List;)V
    invoke-interface v0, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto/16 -0e3h
    check-cast v0, Ljava/util/List;
    return-object v0
    :try_start_0x3a
.end method

.method private final computeDurationMs(java.lang.Long  java.lang.Long)long
    .registers 7
    # ins_size=3
    const-wide/16 v0, 0
    if-eqz v5, +017h
    invoke-virtual v5, Ljava/lang/Long;->longValue()J
    move-result-wide v2
    if-eqz v6, +007h
    invoke-virtual v6, Ljava/lang/Long;->longValue()J
    move-result-wide v5
    goto +5h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v5
    sub-long/2addr v5, v2
    invoke-static v0, v1, v5, v6, Ljava/lang/Math;->max(J J)J
    move-result-wide v5
    return-wide v5
    return-wide v0
.end method

.method private final computeTailStatus(java.util.List)com.bytedance.trae.conversation.chat.block.AgentContentBlock$TailStatus
    .registers 7
    # ins_size=2
    move-object v0, v6
    check-cast v0, Ljava/util/Collection;
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +005h
    sget-object v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;->THINKING Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    return-object v6
    invoke-interface v6, Ljava/util/List;->size()I
    move-result v0
    invoke-interface v6, v0, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/ListIterator;->hasPrevious()Z
    move-result v0
    const/4 v3, 0
    if-eqz v0, +015h
    invoke-interface v6, Ljava/util/ListIterator;->previous()Ljava/lang/Object;
    move-result-object v0
    move-object v4, v0
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v4
    if-eqz v4, +004h
    move v4, v2
    goto +2h
    move v4, v1
    if-eqz v4, -017h
    goto +2h
    move-object v0, v3
    check-cast v0, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v6
    goto +2h
    move-object v6, v3
    if-eqz v6, +063h
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v0
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v0, running
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +00fh
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v1
    invoke-direct v5, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->isCodeGenTool(Ljava/lang/String;)Z
    move-result v1
    if-eqz v1, +005h
    sget-object v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;->GENERATING_CODE Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    goto +41h
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +00fh
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v6
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->isCommandTool(Ljava/lang/String;)Z
    move-result v6
    if-eqz v6, +005h
    sget-object v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;->COMMAND_RUNNING Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    goto +2eh
    const-string/jumbo v6, success
    invoke-static v3, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +005h
    sget-object v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;->SUCCESS Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    goto +22h
    const-string v6, "failed"
    invoke-static v3, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-nez v6, +019h
    const-string v6, "error"
    invoke-static v3, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +003h
    goto +fh
    const-string v6, "pending"
    invoke-static v3, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +005h
    sget-object v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;->PENDING Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    goto +6h
    sget-object v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;->THINKING Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    goto +3h
    sget-object v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;->FAILED Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    return-object v6
    sget-object v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;->THINKING Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;
    return-object v6
.end method

.method private final containsPureShowWidgetInlineBlock(java.util.List)boolean
    .registers 7
    # ins_size=2
    check-cast v6, Ljava/lang/Iterable;
    instance-of v0, v6, Ljava/util/Collection;
    const/4 v1, 0
    if-eqz v0, +00dh
    move-object v0, v6
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +004h
    goto/16 +07bh
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +071h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    instance-of v2, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PureShowWidgetToolcallGroup;
    const/4 v3, 1
    if-eqz v2, +004h
    move v0, v3
    goto +60h
    instance-of v2, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    const-string v4, "PureShowWidget"
    if-eqz v2, +027h
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->getChildren()Ljava/util/List;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/CollectionsKt;->singleOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    if-eqz v0, +017h
    instance-of v2, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    if-eqz v2, +013h
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto -2ah
    move v0, v1
    goto +35h
    instance-of v2, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    if-eqz v2, +00fh
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getChildren()Ljava/util/List;
    move-result-object v0
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->containsPureShowWidgetInlineBlock(Ljava/util/List;)Z
    move-result v0
    goto +24h
    instance-of v2, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    if-eqz v2, +00fh
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->getChildren()Ljava/util/List;
    move-result-object v0
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->containsPureShowWidgetInlineBlock(Ljava/util/List;)Z
    move-result v0
    goto +13h
    instance-of v2, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    if-eqz v2, -026h
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, -072h
    move v1, v3
    return v1
.end method

.method private final extractProducts(java.util.List  java.lang.String)com.bytedance.trae.im.model.ArtifactData
    .registers 7
    # ins_size=3
    move-object v0, v5
    check-cast v0, Ljava/util/Collection;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    const/4 v1, 0
    if-eqz v0, +003h
    return-object v1
    invoke-interface v5, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +041h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    invoke-direct v4, v0, v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->isMainAgentFinish(Lcom/bytedance/trae/im/model/ParsedPlanItem; Ljava/lang/String;)Z
    move-result v2
    if-eqz v2, -010h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v0
    if-nez v0, +003h
    goto -18h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v0
    if-eqz v0, -01dh
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getData()Lcom/google/gson/JsonObject;
    move-result-object v0
    if-nez v0, +003h
    goto -25h
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->gson Lcom/google/gson/Gson;
    check-cast v0, Lcom/google/gson/JsonElement;
    const-class v3, Lcom/bytedance/trae/im/model/FinishCardResult;
    invoke-virtual v2, v0, v3, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/model/FinishCardResult;
    invoke-virtual v0, Lcom/bytedance/trae/im/model/FinishCardResult;->getData()Lcom/bytedance/trae/im/model/FinishCardResultData;
    move-result-object v2
    if-eqz v2, +008h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/FinishCardResultData;->getProducts()Lcom/bytedance/trae/im/model/ArtifactData;
    move-result-object v2
    if-nez v2, +006h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/FinishCardResult;->getProducts()Lcom/bytedance/trae/im/model/ArtifactData;
    move-result-object v2
    if-eqz v2, -042h
    return-object v2
    return-object v1
    :try_start_0x3d
.end method

.method private final extractSummary(java.util.List  java.lang.String)java.lang.String
    .registers 4
    # ins_size=3
    move-object v0, v2
    check-cast v0, Ljava/util/Collection;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    if-eqz v0, +004h
    const/4 v2, 0
    return-object v2
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v2, Lkotlin/collections/CollectionsKt;->asSequence(Ljava/lang/Iterable;)Lkotlin/sequences/Sequence;
    move-result-object v2
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder$$ExternalSyntheticLambda0;
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder$$ExternalSyntheticLambda0;-><init>(Ljava/lang/String;)V
    invoke-static v2, v0, Lkotlin/sequences/SequencesKt;->filter(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder$$ExternalSyntheticLambda1;
    invoke-direct v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder$$ExternalSyntheticLambda1;-><init>()V
    invoke-static v2, v3, Lkotlin/sequences/SequencesKt;->mapNotNull(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v2
    invoke-static v2, Lkotlin/sequences/SequencesKt;->lastOrNull(Lkotlin/sequences/Sequence;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    return-object v2
.end method

.method private static final extractSummary$lambda$24(java.lang.String  com.bytedance.trae.im.model.ParsedPlanItem)boolean
    .registers 3
    # ins_size=2
    const-string v0, "it"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->isMainAgentFinish(Lcom/bytedance/trae/im/model/ParsedPlanItem; Ljava/lang/String;)Z
    move-result v1
    return v1
.end method

.method private static final extractSummary$lambda$27(com.bytedance.trae.im.model.ParsedPlanItem)java.lang.String
    .registers 3
    # ins_size=1
    const-string v0, "it"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v2
    const/4 v0, 0
    if-eqz v2, +02dh
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v2
    if-eqz v2, +027h
    const-string/jumbo v1, summary
    invoke-virtual v2, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +01eh
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v2, v0
    if-eqz v2, +014h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +00eh
    move-object v1, v2
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    if-eqz v1, +003h
    move-object v0, v2
    return-object v0
.end method

.method private final extractVoiceSummary(java.util.List  java.lang.String)com.bytedance.trae.conversation.chat.block.VoiceSummaryPayload
    .registers 4
    # ins_size=3
    move-object v0, v2
    check-cast v0, Ljava/util/Collection;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    if-eqz v0, +004h
    const/4 v2, 0
    return-object v2
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->extractVoiceSummaryFromFinishParams(Ljava/util/List; Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;
    move-result-object v0
    if-eqz v0, +003h
    return-object v0
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->extractVoiceSummaryFromThought(Ljava/util/List; Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;
    move-result-object v2
    return-object v2
.end method

.method private final extractVoiceSummaryFromFinishParams(java.util.List  java.lang.String)com.bytedance.trae.conversation.chat.block.VoiceSummaryPayload
    .registers 4
    # ins_size=3
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v2, Lkotlin/collections/CollectionsKt;->asSequence(Ljava/lang/Iterable;)Lkotlin/sequences/Sequence;
    move-result-object v2
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder$$ExternalSyntheticLambda4;
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder$$ExternalSyntheticLambda4;-><init>(Ljava/lang/String;)V
    invoke-static v2, v0, Lkotlin/sequences/SequencesKt;->filter(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder$$ExternalSyntheticLambda5;
    invoke-direct v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder$$ExternalSyntheticLambda5;-><init>()V
    invoke-static v2, v3, Lkotlin/sequences/SequencesKt;->mapNotNull(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v2
    invoke-static v2, Lkotlin/sequences/SequencesKt;->lastOrNull(Lkotlin/sequences/Sequence;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;
    return-object v2
.end method

.method private static final extractVoiceSummaryFromFinishParams$lambda$29(java.lang.String  com.bytedance.trae.im.model.ParsedPlanItem)boolean
    .registers 3
    # ins_size=2
    const-string v0, "it"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->isMainAgentFinish(Lcom/bytedance/trae/im/model/ParsedPlanItem; Ljava/lang/String;)Z
    move-result v1
    return v1
.end method

.method private static final extractVoiceSummaryFromFinishParams$lambda$30(com.bytedance.trae.im.model.ParsedPlanItem)com.bytedance.trae.conversation.chat.block.VoiceSummaryPayload
    .registers 2
    # ins_size=1
    const-string v0, "it"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->parseParams(Lcom/google/gson/JsonObject;)Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;
    move-result-object v1
    return-object v1
.end method

.method private final extractVoiceSummaryFromThought(java.util.List  java.lang.String)com.bytedance.trae.conversation.chat.block.VoiceSummaryPayload
    .registers 4
    # ins_size=3
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v2, Lkotlin/collections/CollectionsKt;->asSequence(Ljava/lang/Iterable;)Lkotlin/sequences/Sequence;
    move-result-object v2
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder$$ExternalSyntheticLambda2;
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder$$ExternalSyntheticLambda2;-><init>(Ljava/lang/String;)V
    invoke-static v2, v0, Lkotlin/sequences/SequencesKt;->filter(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder$$ExternalSyntheticLambda3;
    invoke-direct v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder$$ExternalSyntheticLambda3;-><init>()V
    invoke-static v2, v3, Lkotlin/sequences/SequencesKt;->mapNotNull(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v2
    invoke-static v2, Lkotlin/sequences/SequencesKt;->lastOrNull(Lkotlin/sequences/Sequence;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;
    return-object v2
.end method

.method private static final extractVoiceSummaryFromThought$lambda$31(java.lang.String  com.bytedance.trae.im.model.ParsedPlanItem)boolean
    .registers 3
    # ins_size=2
    const-string v0, "it"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->isMainAgentPlanItem(Lcom/bytedance/trae/im/model/ParsedPlanItem; Ljava/lang/String;)Z
    move-result v1
    return v1
.end method

.method private static final extractVoiceSummaryFromThought$lambda$32(com.bytedance.trae.im.model.ParsedPlanItem)com.bytedance.trae.conversation.chat.block.VoiceSummaryPayload
    .registers 2
    # ins_size=1
    const-string v0, "it"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getThought()Ljava/lang/String;
    move-result-object v1
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->parseVoiceSummaryThoughtPayload(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;
    move-result-object v1
    return-object v1
.end method

.method private final extractWebReferences(java.util.List)java.util.List
    .registers 18
    # ins_size=2
    move-object/from16 v0, v17
    check-cast v0, Ljava/util/Collection;
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    const/4 v3, 0
    if-eqz v0, +003h
    return-object v3
    const-string/jumbo v0, web_search
    const-string/jumbo v4, web_fetch
    const-string v5, "WebSearch"
    const-string v6, "WebFetch"
    filled-new-array v5, v6, v0, v4, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    new-instance v4, Ljava/util/LinkedHashSet;
    invoke-direct v4, Ljava/util/LinkedHashSet;-><init>()V
    check-cast v4, Ljava/util/Set;
    new-instance v5, Ljava/util/ArrayList;
    invoke-direct v5, Ljava/util/ArrayList;-><init>()V
    check-cast v5, Ljava/util/List;
    invoke-interface/range v17, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +0fdh
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v7
    if-nez v7, +003h
    goto -12h
    move-object v8, v0
    check-cast v8, Ljava/lang/Iterable;
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v9
    invoke-static v8, v9, Lkotlin/collections/CollectionsKt;->contains(Ljava/lang/Iterable; Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, -01eh
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v7
    if-eqz v7, -024h
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getData()Lcom/google/gson/JsonObject;
    move-result-object v7
    if-nez v7, +003h
    goto -2ch
    const-string v8, "references"
    invoke-virtual v7, v8, Lcom/google/gson/JsonObject;->getAsJsonArray(Ljava/lang/String;)Lcom/google/gson/JsonArray;
    move-result-object v7
    if-nez v7, +003h
    goto -35h
    invoke-virtual v7, Lcom/google/gson/JsonArray;->iterator()Ljava/util/Iterator;
    move-result-object v7
    const-string v8, "iterator(...)"
    invoke-static v7, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v8
    if-eqz v8, -043h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/google/gson/JsonElement;
    invoke-virtual v8, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v9
    if-eqz v9, -010h
    invoke-virtual v8, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v8
    const-string v9, "link"
    invoke-virtual v8, v9, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v9
    if-eqz v9, -01ch
    invoke-virtual v9, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v10
    if-eqz v10, +003h
    goto +2h
    move-object v9, v3
    if-eqz v9, -026h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v12
    if-nez v12, +003h
    goto -2eh
    invoke-interface v4, v12, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, -033h
    const-string/jumbo v9, title
    invoke-virtual v8, v9, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v9
    if-eqz v9, +012h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v10
    if-eqz v10, +003h
    goto +2h
    move-object v9, v3
    if-eqz v9, +008h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v9
    if-nez v9, +004h
    const-string v9, ""
    move-object v11, v9
    const-string v9, "favicon"
    invoke-virtual v8, v9, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v9
    if-eqz v9, +012h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v10
    if-eqz v10, +003h
    goto +2h
    move-object v9, v3
    if-eqz v9, +008h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v9
    move-object v13, v9
    goto +2h
    move-object v13, v3
    const-string v9, "description"
    invoke-virtual v8, v9, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v9
    if-eqz v9, +012h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v10
    if-eqz v10, +003h
    goto +2h
    move-object v9, v3
    if-eqz v9, +008h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v9
    move-object v14, v9
    goto +2h
    move-object v14, v3
    const-string v9, "content"
    invoke-virtual v8, v9, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v8
    if-eqz v8, +012h
    invoke-virtual v8, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v9
    if-eqz v9, +003h
    goto +2h
    move-object v8, v3
    if-eqz v8, +008h
    invoke-virtual v8, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v8
    move-object v15, v8
    goto +2h
    move-object v15, v3
    move-object v8, v11
    check-cast v8, Ljava/lang/CharSequence;
    invoke-static v8, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v8
    xor-int/2addr v8, v2
    if-nez v8, +013h
    move-object v8, v14
    check-cast v8, Ljava/lang/CharSequence;
    if-eqz v8, +00bh
    invoke-static v8, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v8
    if-eqz v8, +003h
    goto +3h
    move v8, v1
    goto +2h
    move v8, v2
    if-nez v8, -0b5h
    new-instance v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/WebReference;
    move-object v10, v8
    invoke-direct/range v10 ... v15, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/WebReference;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v5, v8, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto/16 -0c0h
    move-object v0, v5
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    xor-int/2addr v0, v2
    if-eqz v0, +003h
    move-object v3, v5
    return-object v3
.end method

.method private final findMainAgentRunId(java.util.List  java.lang.String)java.lang.String
    .registers 9
    # ins_size=3
    move-object v0, v7
    check-cast v0, Ljava/util/Collection;
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    const-string v3, ""
    if-eqz v0, +003h
    return-object v3
    invoke-interface v7, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +028h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getAgentRunId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getAgentId()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, -018h
    move-object v4, v5
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00bh
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +003h
    goto +3h
    move v4, v1
    goto +2h
    move v4, v2
    if-nez v4, -029h
    return-object v5
    check-cast v8, Ljava/lang/CharSequence;
    if-eqz v8, +00bh
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v8
    if-nez v8, +003h
    goto +3h
    move v8, v1
    goto +2h
    move v8, v2
    if-eqz v8, +02fh
    check-cast v7, Ljava/lang/Iterable;
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v8
    const/4 v0, 0
    if-eqz v8, +01fh
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getAgentRunId()Ljava/lang/String;
    move-result-object v8
    if-eqz v8, +011h
    move-object v4, v8
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-lez v4, +004h
    move v4, v2
    goto +2h
    move v4, v1
    if-eqz v4, +003h
    move-object v0, v8
    if-eqz v0, -022h
    if-eqz v0, +003h
    return-object v0
    return-object v3
.end method

.method private final isCodeGenTool(java.lang.String)boolean
    .registers 11
    # ins_size=2
    const-string v0, "edit_file"
    const-string v1, "Write"
    const-string v2, "Edit"
    const-string v3, "MultiEdit"
    const-string v4, "SearchReplace"
    const-string v5, "create_file"
    const-string v6, "edit_file_search_replace"
    const-string v7, "edit_file_update"
    const-string/jumbo v8, write_to_file
    filled-new-array/range v0 ... v8, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, v10, Lkotlin/collections/CollectionsKt;->contains(Ljava/lang/Iterable; Ljava/lang/Object;)Z
    move-result v10
    return v10
.end method

.method private final isCommandTool(java.lang.String)boolean
    .registers 6
    # ins_size=2
    const-string v0, "Shell"
    const-string v1, "exec_command"
    const-string/jumbo v2, run_command
    const-string v3, "RunCommand"
    filled-new-array v2, v3, v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, v5, Lkotlin/collections/CollectionsKt;->contains(Ljava/lang/Iterable; Ljava/lang/Object;)Z
    move-result v5
    return v5
.end method

.method private final isMainAgentFinish(com.bytedance.trae.im.model.ParsedPlanItem  java.lang.String)boolean
    .registers 6
    # ins_size=3
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +02fh
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +27h
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->FINISH_TOOLS Ljava/util/Set;
    invoke-interface v2, v0, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    return v1
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getAgentRunId()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +004h
    const-string v4, ""
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    const/4 v0, 1
    if-nez v5, +00fh
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +004h
    move v4, v0
    goto +2h
    move v4, v1
    if-eqz v4, +003h
    move v1, v0
    return v1
.end method

.method private final isMainAgentPlanItem(com.bytedance.trae.im.model.ParsedPlanItem  java.lang.String)boolean
    .registers 6
    # ins_size=3
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getAgentRunId()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +004h
    const-string v4, ""
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v1, 1
    const/4 v2, 0
    if-nez v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-nez v0, +017h
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +011h
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +004h
    move v4, v1
    goto +2h
    move v4, v2
    if-eqz v4, +003h
    goto +2h
    move v1, v2
    return v1
.end method

.method private final isOversea()boolean
    .registers 4
    # ins_size=1
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v3
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    const/4 v1, 0
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    move-object v0, v1
    check-cast v0, Ljava/lang/Boolean;
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    return v0
    :try_start_0x0
.end method

.method private final parseVoiceSummaryThoughtPayload(java.lang.String)com.bytedance.trae.conversation.chat.block.VoiceSummaryPayload
    .registers 7
    # ins_size=2
    const/4 v0, 0
    if-eqz v6, +058h
    move-object v1, v6
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    if-eqz v1, +003h
    goto +2h
    move-object v6, v0
    if-nez v6, +003h
    goto +47h
    move-object v1, v6
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->trimStart(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, {
    const/4 v3, 0
    const/4 v4, 2
    invoke-static v1, v2, v3, v4, v0, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +02bh
    check-cast v1, Ljava/lang/CharSequence;
    const-string v2, ""header""
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v1, v2, v3, v4, v0, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +01fh
    const-string v2, ""summary""
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v1, v2, v3, v4, v0, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +015h
    const-string v2, ""bottom""
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v1, v2, v3, v4, v0, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +9h
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;
    const-string v1, ""
    invoke-direct v0, v1, v6, v1, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;
    invoke-virtual v0, v6, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->parseThought(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;
    move-result-object v6
    return-object v6
    return-object v0
.end method

.method private final primitiveIntOrNull(com.google.gson.JsonElement)java.lang.Integer
    .registers 4
    # ins_size=2
    const/4 v0, 0
    if-eqz v3, +030h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v3, v0
    if-eqz v3, +026h
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsInt()I
    move-result v3
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    goto +ch
    move-exception v3
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v0, v3
    check-cast v0, Ljava/lang/Integer;
    return-object v0
    :try_start_0xd
.end method

.method private final primitiveStringOrNull(com.google.gson.JsonElement)java.lang.String
    .registers 4
    # ins_size=2
    const/4 v0, 0
    if-eqz v3, +02ch
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v3, v0
    if-eqz v3, +022h
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    goto +ch
    move-exception v3
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v0, v3
    check-cast v0, Ljava/lang/String;
    return-object v0
    :try_start_0xd
.end method

.method private final resolveNoticeMessage(android.content.res.Resources  com.bytedance.trae.im.model.ParsedChatMessage)java.lang.String
    .registers 8
    # ins_size=3
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getNoticeMessage()Ljava/lang/String;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +012h
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    goto +2h
    move-object v0, v1
    if-eqz v0, +003h
    return-object v0
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getNoticeType()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +051h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v2
    const v3, 720850185
    const/4 v4, 0
    if-eq v2, v3, +035h
    const v3, 1778997648
    if-eq v2, v3, +01ch
    const v3, 1967322283
    if-eq v2, v3, +003h
    goto +3bh
    const-string v2, "content_filter_blocked"
    invoke-virtual v0, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +32h
    sget-object v0, Lcom/bytedance/trae/conversation/chat/error/ContentSecurityErrorMessages;->INSTANCE Lcom/bytedance/trae/conversation/chat/error/ContentSecurityErrorMessages;
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getContentSecurityRuleName()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v0, v6, v7, Lcom/bytedance/trae/conversation/chat/error/ContentSecurityErrorMessages;->blockedMessage(Landroid/content/res/Resources; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    goto +27h
    const-string v7, "content_filter_output_desensitized"
    invoke-virtual v0, v7, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v7
    if-nez v7, +003h
    goto +1eh
    sget-object v7, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_enterprise_content_filter_output_desensitized I
    new-array v1, v4, [Ljava/lang/Object;
    invoke-virtual v7, v6, v0, v1, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    goto +13h
    const-string v7, "content_filter_input_desensitized"
    invoke-virtual v0, v7, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +00ch
    sget-object v7, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_enterprise_content_filter_input_desensitized I
    new-array v1, v4, [Ljava/lang/Object;
    invoke-virtual v7, v6, v0, v1, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    return-object v1
.end method

.method private final resolveNoticeTitle(android.content.res.Resources  com.bytedance.trae.im.model.ParsedChatMessage)java.lang.String
    .registers 6
    # ins_size=3
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getNoticeTitle()Ljava/lang/String;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +012h
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    goto +2h
    move-object v0, v1
    if-eqz v0, +003h
    return-object v0
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getNoticeType()Ljava/lang/String;
    move-result-object v5
    if-eqz v5, +03bh
    invoke-virtual v5, Ljava/lang/String;->hashCode()I
    move-result v0
    const v2, 720850185
    if-eq v0, v2, +01fh
    const v2, 1778997648
    if-eq v0, v2, +011h
    const v2, 1967322283
    if-eq v0, v2, +003h
    goto +26h
    const-string v0, "content_filter_blocked"
    invoke-virtual v5, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +014h
    goto +1dh
    const-string v0, "content_filter_output_desensitized"
    invoke-virtual v5, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +00bh
    goto +14h
    const-string v0, "content_filter_input_desensitized"
    invoke-virtual v5, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +00dh
    sget-object v5, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_chat_content_security_notice_title I
    const/4 v1, 0
    new-array v1, v1, [Ljava/lang/Object;
    invoke-virtual v5, v4, v0, v1, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    return-object v1
.end method

.method private final sanitizeVoiceSummaryPlanItemsForProcess(java.util.List  java.lang.String)java.util.List
    .registers 21
    # ins_size=3
    move-object/from16 v0, v19
    check-cast v0, Ljava/util/Collection;
    const/4 v1, 0
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    const/4 v0, 1
    if-eqz v0, +003h
    return-object v19
    move-object/from16 v0, v19
    check-cast v0, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    const/16 v3, 10
    invoke-static v0, v3, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v3
    invoke-direct v2, v3, Ljava/util/ArrayList;-><init>(I)V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +039h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getThought()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +028h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;
    move-object/from16 v15, v20
    invoke-direct v5, v4, v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->isMainAgentPlanItem(Lcom/bytedance/trae/im/model/ParsedPlanItem; Ljava/lang/String;)Z
    move-result v6
    if-eqz v6, +01eh
    invoke-direct v5, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->shouldConsumeVoiceSummaryThought(Ljava/lang/String;)Z
    move-result v3
    if-eqz v3, +018h
    add-int/lit8 v1, v1, 1
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v3, 0
    const/16 v16, 2015
    const/16 v17, 0
    move-object v15, v3
    invoke-static/range v4 ... v17, Lcom/bytedance/trae/im/model/ParsedPlanItem;->copy$default(Lcom/bytedance/trae/im/model/ParsedPlanItem; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/im/model/ConfirmInfo; Ljava/lang/Boolean; I Ljava/lang/Object;)Lcom/bytedance/trae/im/model/ParsedPlanItem;
    move-result-object v4
    invoke-interface v2, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -3ch
    check-cast v2, Ljava/util/List;
    if-lez v1, +018h
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "[Node6] Builder voice_summary suppress payload thoughts: count="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v3, "AgentDataFlow"
    invoke-virtual v0, v3, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-object v2
.end method

.method private final shouldConsumeVoiceSummaryThought(java.lang.String)boolean
    .registers 9
    # ins_size=2
    move-object v0, v8
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->trimStart(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v2
    const/4 v3, 1
    const/4 v4, 0
    if-nez v2, +004h
    move v2, v3
    goto +2h
    move v2, v4
    if-eqz v2, +003h
    return v4
    const-string/jumbo v2, {
    const/4 v5, 2
    const/4 v6, 0
    invoke-static v0, v2, v4, v5, v6, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +028h
    const-string v0, ""header""
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v1, v0, v4, v5, v6, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +01eh
    const-string v0, ""summary""
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v1, v0, v4, v5, v6, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +014h
    const-string v0, ""bottom""
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v1, v0, v4, v5, v6, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +00ah
    invoke-direct v7, v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->parseVoiceSummaryThoughtPayload(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;
    move-result-object v8
    if-eqz v8, +003h
    goto +2h
    move v3, v4
    return v3
.end method

.method public final build(com.bytedance.trae.im.model.ParsedChatMessage  android.content.res.Resources  com.bytedance.trae.im.service.Conversation  kotlin.jvm.functions.Function1  com.bytedance.trae.conversation.chat.IMessageListener  boolean  boolean  com.bytedance.trae.conversation.chat.block.AgentContentBlock$FeedbackState  int  int  boolean)java.util.List
    .registers 62
    # ins_size=12
    move-object/from16 v1, v50
    move-object/from16 v8, v51
    move-object/from16 v10, v52
    move/from16 v9, v56
    move/from16 v15, v61
    const-string v0, "message"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, resources
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "feedbackState"
    move-object/from16 v14, v58
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    move-object v13, v0
    check-cast v13, Ljava/util/List;
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "[Builder] build start: messageId="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v11, ", status="
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v12, ", isHistory="
    invoke-virtual v2, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", isInterjected="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isInterjected()Z
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v7, ", isLatestTurn="
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v9, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v6, "AgentBlock"
    invoke-virtual v0, v6, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct/range v50, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->isOversea()Z
    move-result v5
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;
    sget-object v0, Lcom/bytedance/trae/conversation/LoginUtils;->INSTANCE Lcom/bytedance/trae/conversation/LoginUtils;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/LoginUtils;->shouldSkipTocCommercialFeatures()Z
    move-result v0
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    const/16 v19, 1
    invoke-static/range v19, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    move-object v0, v2
    check-cast v0, Ljava/lang/Boolean;
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    if-nez v15, +03ch
    if-nez v5, +03ah
    if-nez v0, +038h
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getFastRequestSavings()Lcom/bytedance/trae/im/model/FastRequestSavings;
    move-result-object v2
    if-eqz v2, +005h
    move/from16 v2, v19
    goto +2h
    const/4 v2, 0
    if-nez v2, +01fh
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getFastRequestEvent()Lcom/bytedance/trae/im/service/FastRequestEvent;
    move-result-object v2
    if-eqz v2, +018h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/FastRequestEvent;->getType()Ljava/lang/Integer;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/im/service/FastRequestEventType;->AlreadyUsing Lcom/bytedance/trae/im/service/FastRequestEventType;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/FastRequestEventType;->getValue()I
    move-result v3
    if-nez v2, +003h
    goto +ah
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v2
    if-ne v2, v3, +005h
    move/from16 v2, v19
    goto +2h
    const/4 v2, 0
    if-nez v2, +00eh
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingManager;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingManager;
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingManager;->hasMessageId(Ljava/lang/String;)Z
    move-result v2
    goto +2h
    const/4 v2, 0
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getAgentName()Ljava/lang/String;
    move-result-object v21
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getAgentAvatarId()Ljava/lang/String;
    move-result-object v22
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getAgentType()Ljava/lang/String;
    move-result-object v23
    if-eqz v53, +009h
    invoke-virtual/range v53, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v16
    move-object/from16 v24, v16
    goto +3h
    const/16 v24, 0
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v25
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getSessionId()Ljava/lang/String;
    move-result-object v26
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v27
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v29
    new-instance v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v28
    move-object/from16 v20, v3
    invoke-direct/range v20 ... v30, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; J)V
    invoke-interface v13, v3, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v2
    if-eqz v2, +02fh
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getMessages()Ljava/util/List;
    move-result-object v2
    if-eqz v2, +029h
    check-cast v2, Ljava/lang/Iterable;
    new-instance v3, Ljava/util/ArrayList;
    invoke-direct v3, Ljava/util/ArrayList;-><init>()V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v16
    if-eqz v16, +012h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v16
    check-cast v16, Lcom/bytedance/trae/im/model/ParsedPlanItemMessage;
    invoke-virtual/range v16, Lcom/bytedance/trae/im/model/ParsedPlanItemMessage;->getPlanItem()Lcom/bytedance/trae/im/model/ParsedPlanItem;
    move-result-object v4
    if-eqz v4, -010h
    invoke-interface v3, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -15h
    check-cast v3, Ljava/util/List;
    move-object v4, v3
    goto +2h
    const/4 v4, 0
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getAgentId()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +006h
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getAgentType()Ljava/lang/String;
    move-result-object v2
    move-object v3, v2
    invoke-direct v1, v4, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->findMainAgentRunId(Ljava/util/List; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    move-object/from16 v16, v2
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getAgentType()Ljava/lang/String;
    move-result-object v2
    move/from16 v20, v0
    const-string/jumbo v0, voice_summary
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v21
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v2
    const-string v14, "in_progress"
    invoke-static v2, v14, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +00bh
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v2
    if-nez v2, +005h
    move/from16 v17, v19
    goto +3h
    const/16 v17, 0
    if-eqz v17, +007h
    if-nez v9, +005h
    move/from16 v18, v19
    goto +3h
    const/16 v18, 0
    new-instance v2, Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v22
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v23
    move-object/from16 v24, v16
    move-object/from16 v16, v2
    move-object/from16 v25, v0
    move-object v0, v3
    move-object/from16 v3, v24
    move-object v15, v4
    move-object/from16 v4, v22
    move/from16 v60, v5
    move/from16 v5, v23
    move-object/from16 v22, v13
    move-object v13, v6
    move/from16 v6, v56
    move-object v8, v7
    move/from16 v7, v17
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;-><init>(Ljava/lang/String; Ljava/lang/String; Z Z Z)V
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "[Node6] Builder.build: planItemCount="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    if-eqz v15, +007h
    invoke-interface v15, Ljava/util/List;->size()I
    move-result v4
    goto +2h
    const/4 v4, 0
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", mainAgentId="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v3, ", mainAgentRunId="
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    move-object/from16 v7, v24
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v9, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v8, "AgentDataFlow"
    invoke-virtual v2, v8, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v15, +098h
    move-object v4, v15
    check-cast v4, Ljava/lang/Iterable;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const/4 v4, 0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +088h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    add-int/lit8 v3, v4, 1
    if-gez v4, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    sget-object v5, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v9, "[Node6] Builder planItem["
    invoke-direct v6, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v6, "]: id="
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v6, ", agentId="
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getAgentId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v6, ", agentRunId="
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getAgentRunId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v6, ", tool="
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v6
    if-eqz v6, +007h
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v6
    goto +2h
    const/4 v6, 0
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v6, ", hasThought="
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getThought()Ljava/lang/String;
    move-result-object v6
    if-eqz v6, +005h
    move/from16 v6, v19
    goto +2h
    const/4 v6, 0
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v6, ", hide="
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getHide()Ljava/lang/Boolean;
    move-result-object v2
    invoke-virtual v4, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v5, v8, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    move v4, v3
    goto/16 -08ah
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    if-eqz v21, +007h
    invoke-direct v1, v15, v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->sanitizeVoiceSummaryPlanItemsForProcess(Ljava/util/List; Ljava/lang/String;)Ljava/util/List;
    move-result-object v4
    goto +2h
    move-object v4, v15
    move-object v0, v4
    check-cast v0, Ljava/util/Collection;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +3h
    move/from16 v0, v19
    if-nez v0, +00bh
    sget-object v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->INSTANCE Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;
    move-object/from16 v2, v16
    invoke-virtual v0, v4, v10, v2, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->group(Ljava/util/List; Landroid/content/res/Resources; Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;)Ljava/util/List;
    move-result-object v0
    goto +5h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "[Builder] processBlocks: count="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", planItems="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    if-eqz v15, +007h
    invoke-interface v15, Ljava/util/List;->size()I
    move-result v4
    goto +2h
    const/4 v4, 0
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v13, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "[Node6] Builder processBlocks: count="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v9, ", types="
    invoke-virtual v3, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    move-object v4, v0
    check-cast v4, Ljava/lang/Iterable;
    new-instance v5, Ljava/util/ArrayList;
    const/16 v12, 10
    invoke-static v4, v12, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v6
    invoke-direct v5, v6, Ljava/util/ArrayList;-><init>(I)V
    check-cast v5, Ljava/util/Collection;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +018h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-virtual v6, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v6
    invoke-static v6, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v6
    invoke-interface v6, Lkotlin/reflect/KClass;->getSimpleName()Ljava/lang/String;
    move-result-object v6
    invoke-interface v5, v6, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1bh
    check-cast v5, Ljava/util/List;
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v8, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    const-string v11, "completed"
    const-string v6, "failed"
    const-string v5, "canceled"
    filled-new-array v11, v6, v5, [Ljava/lang/String;
    move-result-object v2
    invoke-static v2, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v2
    check-cast v2, Ljava/lang/Iterable;
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v3
    invoke-static v2, v3, Lkotlin/collections/CollectionsKt;->contains(Ljava/lang/Iterable; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +01dh
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v14, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +008h
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v2
    if-nez v2, +00dh
    if-nez v18, +00bh
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isInterjected()Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    const/4 v14, 0
    goto +3h
    move/from16 v14, v19
    move-object v4, v0
    check-cast v4, Ljava/util/Collection;
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-nez v2, +009h
    if-eqz v17, +005h
    if-nez v21, +003h
    goto +3h
    const/4 v3, 0
    goto +3h
    move/from16 v3, v19
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->containsPureShowWidgetInlineBlock(Ljava/util/List;)Z
    move-result v0
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getQueuingPosition()Ljava/lang/Integer;
    move-result-object v16
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getQueueId()Ljava/lang/String;
    move-result-object v17
    move-object/from16 v2, v51
    invoke-direct v1, v10, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->resolveNoticeTitle(Landroid/content/res/Resources; Lcom/bytedance/trae/im/model/ParsedChatMessage;)Ljava/lang/String;
    move-result-object v18
    invoke-direct v1, v10, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->resolveNoticeMessage(Landroid/content/res/Resources; Lcom/bytedance/trae/im/model/ParsedChatMessage;)Ljava/lang/String;
    move-result-object v23
    move-object/from16 v24, v18
    check-cast v24, Ljava/lang/CharSequence;
    if-eqz v24, +00ch
    invoke-static/range v24, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v24
    if-eqz v24, +003h
    goto +4h
    const/16 v24, 0
    goto +3h
    move/from16 v24, v19
    if-eqz v24, +01ah
    move-object/from16 v24, v23
    check-cast v24, Ljava/lang/CharSequence;
    if-eqz v24, +00ch
    invoke-static/range v24, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v24
    if-eqz v24, +003h
    goto +4h
    const/16 v24, 0
    goto +3h
    move/from16 v24, v19
    if-nez v24, +003h
    goto +4h
    const/16 v24, 0
    goto +3h
    move/from16 v24, v19
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v26
    if-nez v26, +00fh
    if-eqz v16, +00dh
    invoke-virtual/range v16, Ljava/lang/Integer;->intValue()I
    move-result v26
    if-lez v26, +007h
    if-nez v14, +005h
    move/from16 v26, v19
    goto +3h
    const/16 v26, 0
    if-eqz v24, +011h
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getNoticeType()Ljava/lang/String;
    move-result-object v12
    const-string v2, "content_filter_input_desensitized"
    invoke-static v12, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +005h
    move/from16 v12, v19
    goto +2h
    const/4 v12, 0
    if-eqz v12, +020h
    move-object/from16 v27, v8
    move-object/from16 v8, v51
    move-object/from16 v2, v16
    move v10, v3
    move-object/from16 v3, v51
    move-object/from16 v28, v9
    move-object v9, v4
    move-object/from16 v4, v22
    move-object/from16 v40, v5
    move-object/from16 v5, v18
    move-object v8, v6
    move-object/from16 v6, v23
    move-object/from16 v29, v13
    move-object v13, v7
    move-object/from16 v7, v17
    invoke-static/range v2 ... v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->build$addNoticeBlock(Ljava/lang/Integer; Lcom/bytedance/trae/im/model/ParsedChatMessage; Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    goto +dh
    move v10, v3
    move-object/from16 v40, v5
    move-object/from16 v27, v8
    move-object/from16 v28, v9
    move-object/from16 v29, v13
    move-object v9, v4
    move-object v8, v6
    move-object v13, v7
    if-eqz v10, +033h
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessStart;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessStart;
    move-object/from16 v7, v22
    invoke-interface v7, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-interface v7, v9, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getChatStartTime()Ljava/lang/Long;
    move-result-object v2
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getChatEndTime()Ljava/lang/Long;
    move-result-object v3
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->computeDurationMs(Ljava/lang/Long; Ljava/lang/Long;)J
    move-result-wide v2
    new-instance v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;
    if-eqz v14, +011h
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v11, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +007h
    if-nez v0, +005h
    move/from16 v0, v19
    goto +2h
    const/4 v0, 0
    invoke-direct v4, v2, v3, v14, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;-><init>(J Z Z)V
    invoke-interface v7, v4, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto +3h
    move-object/from16 v7, v22
    if-eqz v24, +014h
    if-nez v12, +012h
    move-object/from16 v2, v16
    move-object/from16 v3, v51
    move-object v4, v7
    move-object/from16 v5, v18
    move-object/from16 v6, v23
    move-object v9, v7
    move-object/from16 v7, v17
    invoke-static/range v2 ... v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->build$addNoticeBlock(Ljava/lang/Integer; Lcom/bytedance/trae/im/model/ParsedChatMessage; Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    goto +2h
    move-object v9, v7
    if-eqz v26, +010h
    move-object/from16 v2, v16
    move-object/from16 v3, v51
    move/from16 v4, v61
    move-object v5, v9
    move-object/from16 v6, v17
    move/from16 v7, v60
    invoke-static/range v2 ... v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->build$addQueueBlock(Ljava/lang/Integer; Lcom/bytedance/trae/im/model/ParsedChatMessage; Z Ljava/util/List; Ljava/lang/String; Z)V
    if-eqz v21, +007h
    invoke-direct v1, v15, v13, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->extractVoiceSummary(Ljava/util/List; Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    if-eqz v3, +006h
    const/4 v0, 0
    const/4 v6, 0
    const/4 v7, 0
    goto +2bh
    if-nez v21, +007h
    invoke-direct v1, v15, v13, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->extractSummary(Ljava/util/List; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    goto -9h
    if-eqz v14, +020h
    invoke-direct v1, v15, v13, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->extractSummary(Ljava/util/List; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +01ah
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->trimStart(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v4, {
    const/4 v5, 2
    const/4 v6, 0
    const/4 v7, 0
    invoke-static v2, v4, v7, v5, v6, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +005h
    goto +4h
    const/4 v6, 0
    const/4 v7, 0
    move-object v0, v6
    if-eqz v3, +00ch
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;->getMarkdown()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    goto +4h
    move-object/from16 v22, v2
    goto +3h
    move-object/from16 v22, v0
    if-eqz v3, +032h
    new-instance v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummary;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;->getHeader()Ljava/lang/String;
    move-result-object v33
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;->getMarkdown()Ljava/lang/String;
    move-result-object v34
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;->getBottom()Ljava/lang/String;
    move-result-object v35
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v4
    if-eqz v4, +009h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getTaskId()Ljava/lang/String;
    move-result-object v4
    move-object/from16 v37, v4
    goto +3h
    move-object/from16 v37, v6
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v38
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getSessionId()Ljava/lang/String;
    move-result-object v39
    move-object/from16 v32, v2
    move/from16 v36, v14
    invoke-direct/range v32 ... v39, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummary;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v9, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto +2bh
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    move v4, v7
    goto +3h
    move/from16 v4, v19
    if-nez v4, +01ah
    new-instance v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v4
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getTaskId()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v6
    invoke-direct v1, v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->extractWebReferences(Ljava/util/List;)Ljava/util/List;
    move-result-object v5
    invoke-direct v2, v0, v14, v4, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;-><init>(Ljava/lang/String; Z Ljava/lang/String; Ljava/util/List;)V
    invoke-interface v9, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-direct v1, v15, v13, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->extractProducts(Ljava/util/List; Ljava/lang/String;)Lcom/bytedance/trae/im/model/ArtifactData;
    move-result-object v23
    sget-object v2, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;
    invoke-direct v1, v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->buildVideoArtifactInputs(Ljava/util/List;)Ljava/util/List;
    move-result-object v4
    invoke-virtual v2, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;->parseInputs(Ljava/util/List;)Ljava/util/List;
    move-result-object v32
    const-string v2, ""
    if-nez v23, +00eh
    move-object/from16 v4, v32
    check-cast v4, Ljava/util/Collection;
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    xor-int/lit8 v4, v4, 1
    if-eqz v4, +025h
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getSessionId()Ljava/lang/String;
    move-result-object v33
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTurnId()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +005h
    move-object/from16 v34, v2
    goto +3h
    move-object/from16 v34, v4
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v35
    new-instance v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;
    move-object/from16 v30, v4
    move-object/from16 v31, v23
    move-object/from16 v36, v55
    move-object/from16 v37, v22
    invoke-direct/range v30 ... v37, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;-><init>(Lcom/bytedance/trae/im/model/ArtifactData; Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/IMessageListener; Ljava/lang/String;)V
    invoke-interface v9, v4, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getError()Lcom/bytedance/trae/im/model/ParsedError;
    move-result-object v5
    if-eqz v5, +0e3h
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +0d9h
    invoke-virtual v1, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->resolveErrorCode$conversation_mainlandRelease(Lcom/bytedance/trae/im/model/ParsedError;)Ljava/lang/Integer;
    move-result-object v4
    if-nez v4, +00eh
    move/from16 v11, v60
    move/from16 v6, v61
    move-object/from16 v24, v8
    move v8, v14
    move/from16 v12, v20
    move-object/from16 v47, v29
    goto +4ch
    invoke-virtual v4, Ljava/lang/Integer;->intValue()I
    move-result v11
    const/16 v12, 4008
    if-ne v11, v12, +03ah
    sget-object v11, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getSessionId()Ljava/lang/String;
    move-result-object v12
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedError;->getCode()Ljava/lang/Integer;
    move-result-object v15
    if-eqz v15, +005h
    sget-object v15, Lcom/bytedance/trae/conversation/tracker/Credits4008CodeSource;->TopLevel Lcom/bytedance/trae/conversation/tracker/Credits4008CodeSource;
    goto +3h
    sget-object v15, Lcom/bytedance/trae/conversation/tracker/Credits4008CodeSource;->DataCode Lcom/bytedance/trae/conversation/tracker/Credits4008CodeSource;
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v16
    if-eqz v53, +007h
    invoke-virtual/range v53, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v17
    goto +3h
    move-object/from16 v17, v6
    if-eqz v53, +007h
    invoke-virtual/range v53, Lcom/bytedance/trae/im/service/Conversation;->getMode()Ljava/lang/String;
    move-result-object v18
    goto +3h
    move-object/from16 v18, v6
    move-object/from16 v47, v29
    move-object/from16 v24, v8
    move v8, v14
    move/from16 v14, v61
    move/from16 v6, v61
    invoke-virtual/range v11 ... v18, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;->trackCredits4008Hit(Ljava/lang/String; Ljava/lang/String; Z Lcom/bytedance/trae/conversation/tracker/Credits4008CodeSource; Z Ljava/lang/String; Ljava/lang/String;)V
    goto +8h
    move/from16 v6, v61
    move-object/from16 v24, v8
    move v8, v14
    move-object/from16 v47, v29
    move/from16 v11, v60
    move/from16 v12, v20
    invoke-virtual v1, v4, v6, v11, v12, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;->shouldShowFreeActivityQuotaError$conversation_mainlandRelease(Ljava/lang/Integer; Z Z Z)Z
    move-result v11
    if-eqz v11, +01ah
    new-instance v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;
    move-object/from16 v15, v51
    move-object/from16 v14, v54
    move/from16 v6, v57
    move-object/from16 v13, v24
    invoke-direct v4, v5, v6, v15, v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;-><init>(Lcom/bytedance/trae/im/model/ParsedError; Z Lcom/bytedance/trae/im/model/ParsedChatMessage; Lkotlin/jvm/functions/Function1;)V
    invoke-interface v9, v4, Ljava/util/List;->add(Ljava/lang/Object;)Z
    move-object v1, v9
    move/from16 v49, v10
    move-object v4, v13
    move-object/from16 v48, v28
    goto/16 +067h
    move-object/from16 v15, v51
    move-object/from16 v14, v54
    move-object/from16 v13, v24
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedError;->getData()Lcom/google/gson/JsonObject;
    move-result-object v11
    if-eqz v11, +010h
    const-string/jumbo v12, type
    invoke-virtual v11, v12, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v11
    if-eqz v11, +007h
    invoke-virtual v11, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v11
    goto +2h
    const/4 v11, 0
    move-object/from16 v16, v11
    goto +3h
    const/16 v16, 0
    sget-object v11, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->INSTANCE Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedError;->getMessage()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedError;->getData()Lcom/google/gson/JsonObject;
    move-result-object v17
    move-object v1, v9
    move-object/from16 v48, v28
    move-object v9, v11
    move v11, v10
    move-object/from16 v10, v52
    move/from16 v49, v11
    move-object v11, v4
    move-object v4, v13
    move-object/from16 v13, v17
    move-object/from16 v14, v16
    move/from16 v15, v61
    invoke-virtual/range v9 ... v15, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;->displayMessage(Landroid/content/res/Resources; Ljava/lang/Integer; Ljava/lang/String; Lcom/google/gson/JsonObject; Ljava/lang/String; Z)Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;
    move-result-object v6
    new-instance v9, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->getMessage()Ljava/lang/String;
    move-result-object v43
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->getLevel()Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    move-result-object v44
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->getTitle()Ljava/lang/String;
    move-result-object v45
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->getShowInfoIcon()Z
    move-result v46
    move-object/from16 v41, v9
    move-object/from16 v42, v5
    invoke-direct/range v41 ... v46, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;-><init>(Lcom/bytedance/trae/im/model/ParsedError; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/String; Z)V
    invoke-interface v1, v9, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto +ah
    move-object v4, v8
    move-object v1, v9
    move/from16 v49, v10
    move v8, v14
    move-object/from16 v48, v28
    move-object/from16 v47, v29
    if-nez v8, +018h
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v6
    if-nez v6, +012h
    if-eqz v21, +009h
    if-nez v3, +007h
    sget-object v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummaryLoading;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummaryLoading;
    check-cast v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    goto +5h
    sget-object v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$InitialLoading;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$InitialLoading;
    check-cast v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-interface v1, v6, Ljava/util/List;->add(Ljava/lang/Object;)Z
    if-eqz v8, +0b4h
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getAgentType()Ljava/lang/String;
    move-result-object v6
    move-object/from16 v9, v25
    invoke-static v6, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +03eh
    if-nez v3, +03ch
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v7
    goto +3h
    move/from16 v0, v19
    if-nez v0, +02bh
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v7
    goto +3h
    move/from16 v0, v19
    if-nez v0, +016h
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ViewVoiceHistory;
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +003h
    goto +2h
    move-object v2, v3
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getSessionId()Ljava/lang/String;
    move-result-object v3
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ViewVoiceHistory;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v1, v0, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v0
    move-object/from16 v2, v40
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +015h
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +00bh
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isInterjected()Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    move v4, v7
    goto +3h
    move/from16 v4, v19
    new-instance v13, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v3
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTokenUsage()Lcom/bytedance/trae/im/model/ParsedTokenUsage;
    move-result-object v9
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserCanceled()Ljava/lang/Boolean;
    move-result-object v10
    xor-int/lit8 v11, v4, 1
    if-eqz v0, +00bh
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isInterjected()Z
    move-result v0
    if-nez v0, +005h
    move/from16 v0, v19
    goto +2h
    move v0, v7
    invoke-virtual/range v51, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isInterjected()Z
    move-result v12
    move-object v2, v13
    move-object v4, v6
    move-object v14, v5
    move-object v5, v9
    move-object v6, v10
    move v15, v7
    move-object/from16 v7, v58
    move v10, v8
    move-object/from16 v9, v27
    move v8, v11
    move-object v11, v9
    move v9, v0
    move v0, v10
    move v10, v12
    move-object v12, v11
    move/from16 v11, v21
    move-object v15, v12
    move-object/from16 v12, v54
    invoke-direct/range v2 ... v12, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedTokenUsage; Ljava/lang/Boolean; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState; Z Z Z Z Lkotlin/jvm/functions/Function1;)V
    invoke-interface v1, v13, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto +5h
    move-object v14, v5
    move v0, v8
    move-object/from16 v15, v27
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "[Node6] Builder RESULT: totalBlocks="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    move-object/from16 v4, v48
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    move-object v13, v1
    check-cast v13, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    const/16 v5, 10
    invoke-static v13, v5, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v5
    invoke-direct v4, v5, Ljava/util/ArrayList;-><init>(I)V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v13, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +018h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-virtual v6, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v6
    invoke-static v6, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v6
    invoke-interface v6, Lkotlin/reflect/KClass;->getSimpleName()Ljava/lang/String;
    move-result-object v6
    invoke-interface v4, v6, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1bh
    check-cast v4, Ljava/util/List;
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", hasSummary="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    if-eqz v22, +005h
    move/from16 v5, v19
    goto +2h
    const/4 v5, 0
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v5, ", hasProducts="
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    if-eqz v23, +005h
    move/from16 v6, v19
    goto +2h
    const/4 v6, 0
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v6, ", hasProcess="
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    move/from16 v6, v49
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v15, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v6, "[Builder] build done: totalBlocks="
    invoke-direct v3, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v6
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    check-cast v22, Ljava/lang/CharSequence;
    if-eqz v22, +00bh
    invoke-interface/range v22, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +003h
    goto +3h
    const/4 v4, 0
    goto +3h
    move/from16 v4, v19
    xor-int/lit8 v4, v4, 1
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    if-eqz v23, +005h
    move/from16 v4, v19
    goto +2h
    const/4 v4, 0
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", hasError="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    if-eqz v14, +005h
    move/from16 v4, v19
    goto +2h
    const/4 v4, 0
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", isCompleted="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    move-object/from16 v3, v47
    invoke-virtual v2, v3, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-object v1
    :try_start_0x76
    :try_start_0x5f2
.end method

.method public final resolveErrorCode$conversation_mainlandRelease(com.bytedance.trae.im.model.ParsedError)java.lang.Integer
    .registers 4
    # ins_size=2
    const-string v0, "error"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedError;->getCode()Ljava/lang/Integer;
    move-result-object v0
    if-nez v0, +035h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedError;->getData()Lcom/google/gson/JsonObject;
    move-result-object v3
    const/4 v0, 0
    if-eqz v3, +02eh
    const-string v1, "code"
    invoke-virtual v3, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-eqz v3, +026h
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsInt()I
    move-result v3
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    goto +ch
    move-exception v3
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v0, v3
    check-cast v0, Ljava/lang/Integer;
    return-object v0
    :try_start_0x1a
.end method

.method public final shouldShowFreeActivityQuotaError$conversation_mainlandRelease(java.lang.Integer  boolean  boolean  boolean)boolean
    .registers 6
    # ins_size=5
    if-nez v2, +003h
    goto +11h
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v2
    const/16 v0, 4031
    if-ne v2, v0, +00ah
    if-nez v3, +008h
    if-nez v4, +006h
    if-nez v5, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    return v2
.end method
