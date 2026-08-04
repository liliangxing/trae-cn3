# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public abstract Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;
.super Ljava/lang/Object;
.source "BaseToolDetailCardCreator.kt"

.implements Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;

.field private static final Companion:Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator$Companion;
.field public static final TOOL_TAG:Ljava/lang/String;
.field private final cardRefs:Ljava/util/Map;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;->Companion Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;->cardRefs Ljava/util/Map;
    return-void 
.end method

.method public static synthetic updateCard$default(com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator  android.content.Context  java.lang.String  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext  int  java.lang.Object)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 7
    # ins_size=7
    if-nez v6, +00ch
    and-int/lit8 v5, v5, 8
    if-eqz v5, +003h
    const/4 v4, 0
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;->updateCard(Landroid/content/Context; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v0
    return-object v0
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: updateCard"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public createDetail(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 5
    # ins_size=4
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, toolCallInfo
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;->onCreateDetail(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getId()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +00dh
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->getPlanItemId()Ljava/lang/String;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    if-nez v3, +003h
    return-object v2
    move-object v4, v3
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +004h
    const/4 v4, 1
    goto +2h
    const/4 v4, 0
    if-nez v4, +00ch
    iget-object v4, v1, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;->cardRefs Ljava/util/Map;
    new-instance v0, Ljava/lang/ref/WeakReference;
    invoke-direct v0, v2, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V
    invoke-interface v4, v3, v0, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-object v2
.end method

.method protected abstract onCreateDetail(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    # abstract or native
.end method

.method protected onUpdateCard(android.content.Context  com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)void
    .registers 6
    # ins_size=5
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "card"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, toolCallInfo
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v2, v4, v5, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;->onCreateDetail(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getIconEmoji()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconEmoji(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getIconResId()I
    move-result v4
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconResId(I)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getIconTintColorRes()I
    move-result v4
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setIconTintColorRes(I)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getTitle()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setTitle(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getSubtitle()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setSubtitle(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getBadgeText()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setBadgeText(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getStatus()Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v4
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setStatus(Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getShimmerTitle()Z
    move-result v4
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setShimmerTitle(Z)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getOnDetailClick()Lkotlin/jvm/functions/Function1;
    move-result-object v2
    invoke-virtual v3, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->setOnDetailClick(Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public final updateCard(android.content.Context  java.lang.String  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 9
    # ins_size=5
    const-string v0, "context"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "id"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, toolCallInfo
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;->cardRefs Ljava/util/Map;
    invoke-interface v0, v6, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/ref/WeakReference;
    const/4 v1, 0
    const-string v2, ", name="
    const-string v3, "AgentTool"
    if-nez v0, +026h
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;
    sget-object v5, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v0, "[CardCreator] updateCard: no ref for id="
    invoke-direct v8, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v8, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v3, v6, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-object v1
    invoke-virtual v0, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    if-nez v0, +02bh
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;
    iget-object v5, v4, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;->cardRefs Ljava/util/Map;
    invoke-interface v5, v6, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v5, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v0, "[CardCreator] updateCard: ref GC'd for id="
    invoke-direct v8, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v8, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v3, v6, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-object v1
    invoke-virtual v4, v5, v0, v7, v8, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;->onUpdateCard(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)V
    sget-object v5, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v1, "[CardCreator] updateCard: id="
    invoke-direct v8, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v8, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, ", title="
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getTitle()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v3, v6, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
.end method
