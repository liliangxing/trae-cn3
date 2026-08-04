# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/FeedbackRepository;
.super Ljava/lang/Object;
.source "FeedbackRepository.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/FeedbackRepository;
.field private static final REPO_NAME:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/FeedbackRepository;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/FeedbackRepository;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/FeedbackRepository;->INSTANCE Lcom/bytedance/trae/conversation/chat/FeedbackRepository;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getKeva()com.bytedance.keva.Keva
    .registers 3
    # ins_size=1
    const-string v0, "message_feedback"
    invoke-static v0, Lcom/bytedance/keva/Keva;->getRepo(Ljava/lang/String;)Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v1, "getRepo(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method

.method public final getFeedbackState(java.lang.String)com.bytedance.trae.conversation.chat.block.AgentContentBlock$FeedbackState
    .registers 4
    # ins_size=2
    const-string v0, "messageId"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;->NONE Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    return-object v3
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/FeedbackRepository;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const/4 v1, 0
    invoke-virtual v0, v3, v1, Lcom/bytedance/keva/Keva;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    if-nez v3, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;->NONE Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    return-object v3
    const-string/jumbo v0, thumbs_up
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;->THUMBS_UP Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    goto +fh
    const-string/jumbo v0, thumbs_down
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;->THUMBS_DOWN Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    goto +3h
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;->NONE Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    return-object v3
.end method

.method public final saveFeedbackState(java.lang.String  com.bytedance.trae.conversation.chat.block.AgentContentBlock$FeedbackState)void
    .registers 5
    # ins_size=3
    const-string v0, "messageId"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, state
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v1, 1
    if-nez v0, +004h
    move v0, v1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/chat/FeedbackRepository$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;->ordinal()I
    move-result v4
    aget v4, v0, v4
    if-eq v4, v1, +022h
    const/4 v0, 2
    if-eq v4, v0, +014h
    const/4 v0, 3
    if-ne v4, v0, +00bh
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/FeedbackRepository;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v4
    const/4 v0, 0
    invoke-virtual v4, v3, v0, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    goto +1ch
    new-instance v3, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v3, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v3
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/FeedbackRepository;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v4
    const-string/jumbo v0, thumbs_down
    invoke-virtual v4, v3, v0, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    goto +bh
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/FeedbackRepository;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v4
    const-string/jumbo v0, thumbs_up
    invoke-virtual v4, v3, v0, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
