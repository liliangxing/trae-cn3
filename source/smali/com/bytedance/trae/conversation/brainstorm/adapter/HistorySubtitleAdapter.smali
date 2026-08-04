# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;
.super Landroidx/recyclerview/widget/RecyclerView$Adapter;
.source "HistorySubtitleAdapter.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$Companion;
.field private static final PAYLOAD_ATTACHMENT_GROUP_UPDATE:Ljava/lang/String;
.field private static final PAYLOAD_ATTACHMENT_UPDATE:Ljava/lang/String;
.field private static final PAYLOAD_SUBTASK_UPDATE:Ljava/lang/String;
.field private static final PAYLOAD_TEXT_UPDATE:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field private static final VIEW_TYPE_ATTACHMENT:I
.field private static final VIEW_TYPE_ATTACHMENT_GROUP:I
.field private static final VIEW_TYPE_FILE_GROUP:I
.field private static final VIEW_TYPE_FOOTER:I
.field private static final VIEW_TYPE_MESSAGE:I
.field private static final VIEW_TYPE_THINKING:I
.field private attachmentCallback:Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;
.field private final attachmentDelegate:Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$attachmentDelegate$1;
.field private footerItem:Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
.field private final historyItems:Ljava/util/List;
.field private final items:Ljava/util/List;
.field private liveBotItem:Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
.field private liveUserItem:Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
.field private thinkingItem:Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;


.method public static synthetic $r8$lambda$57SsWGDV7lp9f8kYJpyuZvchVvs(com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged)java.lang.Comparable
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->seedHistoryWithAttachments$lambda$17(Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;)Ljava/lang/Comparable;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$ZbfkoqXHuggwR7TM8E1z4a0Axns(com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged)java.lang.Comparable
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->seedHistoryWithAttachments$lambda$16(Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;)Ljava/lang/Comparable;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$yhuJ6ooXZpTWDtZur_ZC-P6h6MU(com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$SubtitleItem)java.lang.CharSequence
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->updateSubTaskBadgeOnMessage$lambda$10(Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;)Ljava/lang/CharSequence;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->Companion Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Landroidx/recyclerview/widget/RecyclerView$Adapter;-><init>()V
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->items Ljava/util/List;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$attachmentDelegate$1;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$attachmentDelegate$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;)V
    iput-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->attachmentDelegate Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$attachmentDelegate$1;
    return-void 
.end method

.method private final appendOrUpdateGroupedAttachment(java.lang.String  com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)void
    .registers 24
    # ins_size=3
    move-object/from16 v0, v21
    move-object/from16 v1, v23
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-interface v2, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v2
    const/4 v3, 0
    move v4, v3
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    const/4 v6, -1
    const/4 v7, 1
    if-eqz v5, +033h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getAttachments()Ljava/util/List;
    move-result-object v8
    if-eqz v8, +01eh
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getAttachments()Ljava/util/List;
    move-result-object v5
    invoke-static v5, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getGroupId()Ljava/lang/String;
    move-result-object v5
    goto +2h
    const/4 v5, 0
    move-object/from16 v8, v22
    invoke-static v5, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +006h
    move v5, v7
    goto +4h
    move-object/from16 v8, v22
    move v5, v3
    if-eqz v5, +003h
    goto +7h
    add-int/lit8 v4, v4, 1
    goto -38h
    move-object/from16 v8, v22
    move v4, v6
    if-ltz v4, +070h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-interface v2, v4, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getAttachments()Ljava/util/List;
    move-result-object v2
    if-nez v2, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    invoke-interface v2, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +01bh
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getAttachmentId()Ljava/lang/String;
    move-result-object v7
    invoke-virtual/range v23, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getAttachmentId()Ljava/lang/String;
    move-result-object v8
    invoke-static v7, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +004h
    move v6, v3
    goto +4h
    add-int/lit8 v3, v3, 1
    goto -1eh
    if-ltz v6, +00ch
    check-cast v2, Ljava/util/Collection;
    invoke-static v2, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v2
    invoke-interface v2, v6, v1, Ljava/util/List;->set(I Ljava/lang/Object;)Ljava/lang/Object;
    goto +7h
    check-cast v2, Ljava/util/Collection;
    invoke-static v2, v1, Lkotlin/collections/CollectionsKt;->plus(Ljava/util/Collection; Ljava/lang/Object;)Ljava/util/List;
    move-result-object v2
    move-object v13, v2
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-interface v1, v4, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 895
    const/16 v17, 0
    invoke-static/range v5 ... v17, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole; Ljava/lang/String; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Ljava/util/List; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    move-result-object v2
    invoke-interface v1, v4, v2, Ljava/util/List;->set(I Ljava/lang/Object;)Ljava/lang/Object;
    invoke-direct/range v21, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->rebuildItems()V
    const-string v1, "attachment_group_update"
    invoke-virtual v0, v4, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->notifyItemChanged(I Ljava/lang/Object;)V
    return-void 
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    invoke-direct/range v21 ... v22, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->groupItemId(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    sget-object v10, Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;->User Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    const-string v11, ""
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    invoke-static/range v23, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v16
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 888
    const/16 v20, 0
    move-object v8, v2
    invoke-direct/range v8 ... v20, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole; Ljava/lang/String; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Ljava/util/List; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-interface v1, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-direct/range v21, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->rebuildItems()V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v1
    sub-int/2addr v1, v7
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->notifyItemInserted(I)V
    return-void 
.end method

.method private final footerPos()int
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->thinkingPos()I
    move-result v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->thinkingItem Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    if-eqz v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    add-int/2addr v0, v1
    return v0
.end method

.method private final groupItemId(java.lang.String)java.lang.String
    .registers 4
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "group_"
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method private final liveBotPos()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    return v0
.end method

.method private final liveUserPos()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->liveBotItem Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    if-eqz v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    add-int/2addr v0, v1
    return v0
.end method

.method private final rebuildItems()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->items Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->clear()V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->items Ljava/util/List;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, v1, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->liveBotItem Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    if-eqz v0, +007h
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->items Ljava/util/List;
    invoke-interface v1, v0, Ljava/util/List;->add(Ljava/lang/Object;)Z
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->liveUserItem Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    if-eqz v0, +007h
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->items Ljava/util/List;
    invoke-interface v1, v0, Ljava/util/List;->add(Ljava/lang/Object;)Z
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->thinkingItem Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    if-eqz v0, +007h
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->items Ljava/util/List;
    invoke-interface v1, v0, Ljava/util/List;->add(Ljava/lang/Object;)Z
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->footerItem Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    if-eqz v0, +007h
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->items Ljava/util/List;
    invoke-interface v1, v0, Ljava/util/List;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method private static final seedHistoryWithAttachments$lambda$16(com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged)java.lang.Comparable
    .registers 3
    # ins_size=1
    const-string v0, "it"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;->getTs()J
    move-result-wide v0
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v2
    check-cast v2, Ljava/lang/Comparable;
    return-object v2
.end method

.method private static final seedHistoryWithAttachments$lambda$17(com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged)java.lang.Comparable
    .registers 2
    # ins_size=1
    const-string v0, "it"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;->getKindRank()I
    move-result v1
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    check-cast v1, Ljava/lang/Comparable;
    return-object v1
.end method

.method private static final seedHistoryWithAttachments$tsOf(com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)long
    .registers 5
    # ins_size=1
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getCreatedAtMs()J
    move-result-wide v0
    const-wide/16 v2, 0
    cmp-long v0, v0, v2
    if-lez v0, +007h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getCreatedAtMs()J
    move-result-wide v0
    goto +6h
    const-wide v0, 9223372036854775807
    return-wide v0
.end method

.method public static synthetic setLiveBot$default(com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)void
    .registers 7
    # ins_size=6
    and-int/lit8 v6, v5, 2
    const/4 v0, 0
    if-eqz v6, +003h
    move-object v3, v0
    and-int/lit8 v5, v5, 4
    if-eqz v5, +003h
    move-object v4, v0
    invoke-virtual v1, v2, v3, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->setLiveBot(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic setLiveUser$default(com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter  java.lang.String  java.lang.String  int  java.lang.Object)boolean
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->setLiveUser(Ljava/lang/String; Ljava/lang/String;)Z
    move-result v0
    return v0
.end method

.method private final thinkingPos()int
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->liveBotItem Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v1, +004h
    move v1, v2
    goto +2h
    move v1, v3
    add-int/2addr v0, v1
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->liveUserItem Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    if-eqz v1, +003h
    goto +2h
    move v2, v3
    add-int/2addr v0, v2
    return v0
.end method

.method private static final updateSubTaskBadgeOnMessage$lambda$10(com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$SubtitleItem)java.lang.CharSequence
    .registers 5
    # ins_size=1
    const-string v0, "item"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 58
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getAttachedSubTaskId()Ljava/lang/String;
    move-result-object v2
    const-string v3, "-"
    if-nez v2, +003h
    move-object v2, v3
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getSubTaskBadge()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-result-object v4
    if-eqz v4, +00ah
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v4
    if-nez v4, +003h
    goto +2h
    move-object v3, v4
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    return-object v4
.end method

.method public final appendOrUpdateAttachment(com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)void
    .registers 21
    # ins_size=2
    move-object/from16 v0, v19
    move-object/from16 v14, v20
    const-string v1, "item"
    invoke-static v14, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getGroupId()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +006h
    invoke-direct v0, v1, v14, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->appendOrUpdateGroupedAttachment(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)V
    return-void 
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v1
    const/4 v2, 0
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +022h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getAttachment()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-result-object v3
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getAttachmentId()Ljava/lang/String;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getAttachmentId()Ljava/lang/String;
    move-result-object v4
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    goto +5h
    add-int/lit8 v2, v2, 1
    goto -25h
    const/4 v2, -1
    move v13, v2
    const/16 v16, 1
    if-ltz v13, +075h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-interface v1, v13, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getAttachment()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-result-object v17
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-interface v1, v13, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 959
    const/16 v18, 0
    move-object/from16 v8, v20
    move v15, v13
    move-object/from16 v13, v18
    invoke-static/range v1 ... v13, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole; Ljava/lang/String; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Ljava/util/List; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    move-result-object v1
    if-eqz v17, +017h
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getCreatedAtMs()J
    move-result-wide v2
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getCreatedAtMs()J
    move-result-wide v4
    cmp-long v2, v2, v4
    if-lez v2, +00bh
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-static v2, Lkotlin/collections/CollectionsKt;->getLastIndex(Ljava/util/List;)I
    move-result v2
    if-eq v15, v2, +003h
    goto +3h
    const/16 v16, 0
    const-string v2, "attachment_update"
    if-eqz v16, +022h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-interface v3, v15, Ljava/util/List;->remove(I)Ljava/lang/Object;
    iget-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-interface v3, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-direct/range v19, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->rebuildItems()V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->getLastIndex(Ljava/util/List;)I
    move-result v1
    invoke-virtual v0, v15, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->notifyItemMoved(I I)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->getLastIndex(Ljava/util/List;)I
    move-result v1
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->notifyItemChanged(I Ljava/lang/Object;)V
    return-void 
    iget-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-interface v3, v15, v1, Ljava/util/List;->set(I Ljava/lang/Object;)Ljava/lang/Object;
    invoke-direct/range v19, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->rebuildItems()V
    invoke-virtual v0, v15, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->notifyItemChanged(I Ljava/lang/Object;)V
    return-void 
    new-instance v15, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "attach_"
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getAttachmentId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;->User Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    const-string v4, ""
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 952
    const/4 v13, 0
    move-object v1, v15
    move-object/from16 v8, v20
    invoke-direct/range v1 ... v13, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole; Ljava/lang/String; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Ljava/util/List; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-interface v1, v15, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-direct/range v19, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->rebuildItems()V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v1
    add-int/lit8 v1, v1, -1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->notifyItemInserted(I)V
    return-void 
.end method

.method public final currentImageAttachments()java.util.List
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->items Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +027h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getAttachments()Ljava/util/List;
    move-result-object v3
    if-nez v3, +015h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getAttachment()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-result-object v2
    if-eqz v2, +007h
    invoke-static v2, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    move-object v3, v2
    if-nez v3, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v3
    check-cast v3, Ljava/lang/Iterable;
    invoke-static v1, v3, Lkotlin/collections/CollectionsKt;->addAll(Ljava/util/Collection; Ljava/lang/Iterable;)Z
    goto -2ah
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +025h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-static v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapterKt;->access$isImageAttachment(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)Z
    move-result v4
    if-eqz v4, +011h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getLocalUri()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    const/4 v4, 1
    xor-int/2addr v3, v4
    if-eqz v3, +003h
    goto +2h
    const/4 v4, 0
    if-eqz v4, -023h
    invoke-interface v0, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -28h
    check-cast v0, Ljava/util/List;
    return-object v0
.end method

.method public final getAttachmentCallback()com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$AttachmentCallback
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->attachmentCallback Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;
    return-object v0
.end method

.method public getItemCount()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->items Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    return v0
.end method

.method public getItemViewType(int)int
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->items Ljava/util/List;
    invoke-interface v0, v4, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getAttachments()Ljava/util/List;
    move-result-object v0
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +01ch
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getAttachments()Ljava/util/List;
    move-result-object v4
    invoke-static v4, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    if-eqz v4, +009h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->isImage()Z
    move-result v4
    if-ne v4, v1, +003h
    goto +2h
    move v1, v2
    if-eqz v1, +004h
    const/4 v1, 4
    goto +1bh
    const/4 v1, 5
    goto +19h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getAttachment()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-result-object v0
    if-eqz v0, +004h
    const/4 v1, 2
    goto +11h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->isThinkingPlaceholder()Z
    move-result v0
    if-eqz v0, +004h
    const/4 v1, 3
    goto +9h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->isFooter()Z
    move-result v4
    if-eqz v4, +003h
    goto +2h
    move v1, v2
    return v1
.end method

.method public final getTotalItemCount()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->items Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    return v0
.end method

.method public onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 4
    # ins_size=3
    const-string v0, "holder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->items Ljava/util/List;
    invoke-interface v0, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    instance-of v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;
    if-eqz v0, +008h
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->bind(Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;)V
    goto +44h
    instance-of v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FooterViewHolder;
    if-eqz v0, +008h
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FooterViewHolder;
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FooterViewHolder;->bind(Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;)V
    goto +3ah
    instance-of v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;
    if-eqz v0, +00eh
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getAttachment()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-result-object v3
    if-eqz v3, +031h
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->bind(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)V
    goto +2ah
    instance-of v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$GroupAttachmentViewHolder;
    if-eqz v0, +00eh
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getAttachments()Ljava/util/List;
    move-result-object v3
    if-eqz v3, +021h
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$GroupAttachmentViewHolder;
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$GroupAttachmentViewHolder;->bind(Ljava/util/List;)V
    goto +1ah
    instance-of v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder;
    if-eqz v0, +00eh
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getAttachments()Ljava/util/List;
    move-result-object v3
    if-eqz v3, +011h
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder;
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder;->bind(Ljava/util/List;)V
    goto +ah
    instance-of v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$ThinkingViewHolder;
    if-eqz v3, +007h
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$ThinkingViewHolder;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$ThinkingViewHolder;->bind()V
    return-void 
.end method

.method public onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int  java.util.List)void
    .registers 6
    # ins_size=4
    const-string v0, "holder"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "payloads"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, text_update
    invoke-interface v5, v0, Ljava/util/List;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +02dh
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->items Ljava/util/List;
    invoke-interface v0, v4, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    instance-of v1, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;
    if-eqz v1, +00dh
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getContent()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->updateText(Ljava/lang/String;)V
    goto/16 +090h
    instance-of v1, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FooterViewHolder;
    if-eqz v1, +00dh
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FooterViewHolder;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getContent()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FooterViewHolder;->updateText(Ljava/lang/String;)V
    goto/16 +081h
    invoke-super v2, v3, v4, v5, Landroidx/recyclerview/widget/RecyclerView$Adapter;->onBindViewHolder(Landroidx/recyclerview/widget/RecyclerView$ViewHolder; I Ljava/util/List;)V
    goto/16 +07ch
    const-string v0, "attachment_update"
    invoke-interface v5, v0, Ljava/util/List;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +01eh
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->items Ljava/util/List;
    invoke-interface v0, v4, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getAttachment()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-result-object v0
    instance-of v1, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;
    if-eqz v1, +00ah
    if-eqz v0, +008h
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;
    invoke-virtual v3, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->updateState(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)V
    goto +5bh
    invoke-super v2, v3, v4, v5, Landroidx/recyclerview/widget/RecyclerView$Adapter;->onBindViewHolder(Landroidx/recyclerview/widget/RecyclerView$ViewHolder; I Ljava/util/List;)V
    goto +57h
    const-string v0, "attachment_group_update"
    invoke-interface v5, v0, Ljava/util/List;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +02ah
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->items Ljava/util/List;
    invoke-interface v0, v4, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getAttachments()Ljava/util/List;
    move-result-object v0
    instance-of v1, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$GroupAttachmentViewHolder;
    if-eqz v1, +00ah
    if-eqz v0, +008h
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$GroupAttachmentViewHolder;
    invoke-virtual v3, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$GroupAttachmentViewHolder;->bind(Ljava/util/List;)V
    goto +37h
    instance-of v1, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder;
    if-eqz v1, +00ah
    if-eqz v0, +008h
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder;
    invoke-virtual v3, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder;->bind(Ljava/util/List;)V
    goto +2bh
    invoke-super v2, v3, v4, v5, Landroidx/recyclerview/widget/RecyclerView$Adapter;->onBindViewHolder(Landroidx/recyclerview/widget/RecyclerView$ViewHolder; I Ljava/util/List;)V
    goto +27h
    const-string/jumbo v0, subtask_update
    invoke-interface v5, v0, Ljava/util/List;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +01ch
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->items Ljava/util/List;
    invoke-interface v0, v4, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    instance-of v1, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;
    if-eqz v1, +00ch
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getSubTaskBadge()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-result-object v4
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->updateSubTaskBadge(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;)V
    goto +8h
    invoke-super v2, v3, v4, v5, Landroidx/recyclerview/widget/RecyclerView$Adapter;->onBindViewHolder(Landroidx/recyclerview/widget/RecyclerView$ViewHolder; I Ljava/util/List;)V
    goto +4h
    invoke-super v2, v3, v4, v5, Landroidx/recyclerview/widget/RecyclerView$Adapter;->onBindViewHolder(Landroidx/recyclerview/widget/RecyclerView$ViewHolder; I Ljava/util/List;)V
    return-void 
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 8
    # ins_size=3
    const-string v0, "parent"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v6, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-static v0, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v0
    const/4 v1, 1
    const-string v2, "null cannot be cast to non-null type android.widget.LinearLayout"
    const/4 v3, 0
    if-eq v7, v1, +07bh
    const/4 v1, 2
    const-string v4, "null cannot be cast to non-null type android.widget.FrameLayout"
    if-eq v7, v1, +05fh
    const/4 v1, 3
    if-eq v7, v1, +049h
    const/4 v1, 4
    if-eq v7, v1, +02fh
    const/4 v1, 5
    if-eq v7, v1, +015h
    new-instance v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;
    sget v1, Lcom/bytedance/trae/conversation/R$layout;->trae_item_brainstorm_subtitle I
    invoke-virtual v0, v1, v6, v3, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v6
    invoke-static v6, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Landroid/widget/LinearLayout;
    invoke-direct v7, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;-><init>(Landroid/widget/LinearLayout;)V
    check-cast v7, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    goto +6bh
    new-instance v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder;
    sget v1, Lcom/bytedance/trae/conversation/R$layout;->trae_item_brainstorm_attachment_group I
    invoke-virtual v0, v1, v6, v3, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v6
    invoke-static v6, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Landroid/widget/FrameLayout;
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->attachmentDelegate Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$attachmentDelegate$1;
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;
    invoke-direct v7, v6, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder;-><init>(Landroid/widget/FrameLayout; Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;)V
    check-cast v7, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    goto +54h
    new-instance v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$GroupAttachmentViewHolder;
    sget v1, Lcom/bytedance/trae/conversation/R$layout;->trae_item_brainstorm_attachment_group I
    invoke-virtual v0, v1, v6, v3, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v6
    invoke-static v6, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Landroid/widget/FrameLayout;
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->attachmentDelegate Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$attachmentDelegate$1;
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;
    invoke-direct v7, v6, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$GroupAttachmentViewHolder;-><init>(Landroid/widget/FrameLayout; Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;)V
    check-cast v7, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    goto +3dh
    new-instance v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$ThinkingViewHolder;
    sget v1, Lcom/bytedance/trae/conversation/R$layout;->trae_item_brainstorm_thinking_dots I
    invoke-virtual v0, v1, v6, v3, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v6
    invoke-static v6, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Landroid/widget/LinearLayout;
    invoke-direct v7, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$ThinkingViewHolder;-><init>(Landroid/widget/LinearLayout;)V
    check-cast v7, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    goto +2ah
    new-instance v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;
    sget v1, Lcom/bytedance/trae/conversation/R$layout;->trae_item_brainstorm_attachment I
    invoke-virtual v0, v1, v6, v3, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v6
    invoke-static v6, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Landroid/widget/FrameLayout;
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->attachmentDelegate Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$attachmentDelegate$1;
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;
    invoke-direct v7, v6, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;-><init>(Landroid/widget/FrameLayout; Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;)V
    check-cast v7, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    goto +13h
    new-instance v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FooterViewHolder;
    sget v1, Lcom/bytedance/trae/conversation/R$layout;->trae_item_brainstorm_subtitle_footer I
    invoke-virtual v0, v1, v6, v3, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v6
    invoke-static v6, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Landroid/widget/LinearLayout;
    invoke-direct v7, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FooterViewHolder;-><init>(Landroid/widget/LinearLayout;)V
    check-cast v7, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v7
.end method

.method public final pruneAttachmentsExcept(java.util.Set)void
    .registers 21
    # ins_size=2
    move-object/from16 v0, v20
    const-string v1, "attachmentIdsToKeep"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object/from16 v1, v19
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-interface v2, Ljava/util/List;->listIterator()Ljava/util/ListIterator;
    move-result-object v2
    const/4 v3, 0
    invoke-interface v2, Ljava/util/ListIterator;->hasNext()Z
    move-result v4
    if-eqz v4, +081h
    invoke-interface v2, Ljava/util/ListIterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getAttachments()Ljava/util/List;
    move-result-object v4
    const/16 v18, 1
    if-eqz v4, +057h
    move-object v6, v4
    check-cast v6, Ljava/lang/Iterable;
    new-instance v7, Ljava/util/ArrayList;
    invoke-direct v7, Ljava/util/ArrayList;-><init>()V
    check-cast v7, Ljava/util/Collection;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v8
    if-eqz v8, +017h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v8
    move-object v9, v8
    check-cast v9, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getAttachmentId()Ljava/lang/String;
    move-result-object v9
    invoke-interface v0, v9, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, -015h
    invoke-interface v7, v8, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1ah
    move-object v13, v7
    check-cast v13, Ljava/util/List;
    invoke-interface v13, Ljava/util/List;->isEmpty()Z
    move-result v6
    if-eqz v6, +006h
    invoke-interface v2, Ljava/util/ListIterator;->remove()V
    goto +37h
    invoke-interface v13, Ljava/util/List;->size()I
    move-result v6
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v4
    if-eq v6, v4, -053h
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 895
    const/16 v17, 0
    invoke-static/range v5 ... v17, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole; Ljava/lang/String; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Ljava/util/List; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    move-result-object v3
    invoke-interface v2, v3, Ljava/util/ListIterator;->set(Ljava/lang/Object;)V
    goto +18h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getAttachment()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-result-object v4
    if-eqz v4, -06eh
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getAttachment()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getAttachmentId()Ljava/lang/String;
    move-result-object v4
    invoke-interface v0, v4, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, -07ch
    invoke-interface v2, Ljava/util/ListIterator;->remove()V
    move/from16 v3, v18
    goto/16 -083h
    if-eqz v3, +008h
    invoke-direct/range v19, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->rebuildItems()V
    invoke-virtual/range v19, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->notifyDataSetChanged()V
    return-void 
.end method

.method public final removeAttachment(java.lang.String)void
    .registers 5
    # ins_size=2
    const-string v0, "attachmentId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const/4 v1, 0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +01eh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getAttachment()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getAttachmentId()Ljava/lang/String;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +5h
    add-int/lit8 v1, v1, 1
    goto -21h
    const/4 v1, -1
    if-gez v1, +003h
    return-void 
    iget-object v4, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-interface v4, v1, Ljava/util/List;->remove(I)Ljava/lang/Object;
    invoke-direct v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->rebuildItems()V
    invoke-virtual v3, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->notifyItemRemoved(I)V
    return-void 
.end method

.method public final seedHistoryWithAttachments(java.util.List  java.util.List)void
    .registers 30
    # ins_size=3
    move-object/from16 v0, v27
    const-string v1, "messages"
    move-object/from16 v2, v28
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "attachments"
    move-object/from16 v3, v29
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->clear()V
    new-instance v1, Ljava/util/ArrayList;
    invoke-interface/range v28, Ljava/util/List;->size()I
    move-result v4
    invoke-interface/range v29, Ljava/util/List;->size()I
    move-result v5
    add-int/2addr v4, v5
    invoke-direct v1, v4, Ljava/util/ArrayList;-><init>(I)V
    invoke-interface/range v28, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    const/4 v5, 0
    if-eqz v4, +04bh
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;
    move-object v6, v1
    check-cast v6, Ljava/util/Collection;
    new-instance v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->getTimestamp()J
    move-result-wide v8
    new-instance v15, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->getId()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->getRole()Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    move-result-object v12
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->getContent()Ljava/lang/String;
    move-result-object v13
    const/4 v14, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->getAttachedSubTaskId()Ljava/lang/String;
    move-result-object v4
    const/16 v20, 0
    const/16 v21, 736
    const/16 v22, 0
    move-object v10, v15
    move-object/from16 v23, v15
    move/from16 v15, v16
    move/from16 v16, v17
    move-object/from16 v17, v18
    move-object/from16 v18, v19
    move-object/from16 v19, v4
    invoke-direct/range v10 ... v22, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole; Ljava/lang/String; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Ljava/util/List; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object/from16 v4, v23
    invoke-direct v7, v8, v9, v5, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;-><init>(J I Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;)V
    invoke-interface v6, v7, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -4fh
    new-instance v2, Ljava/util/LinkedHashMap;
    invoke-direct v2, Ljava/util/LinkedHashMap;-><init>()V
    invoke-interface/range v29, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    const/4 v6, 1
    if-eqz v4, +07fh
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v14, v4
    check-cast v14, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getGroupId()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +059h
    move-object v4, v1
    check-cast v4, Ljava/util/Collection;
    new-instance v15, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;
    invoke-static v14, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->seedHistoryWithAttachments$tsOf(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)J
    move-result-wide v12
    new-instance v11, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v8, "attach_"
    invoke-direct v7, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v14, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getAttachmentId()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    sget-object v9, Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;->User Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    const-string v10, ""
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 952
    const/16 v23, 0
    move-object v7, v11
    move-object v5, v11
    move/from16 v11, v16
    move-wide/from16 v24, v12
    move/from16 v12, v17
    move/from16 v13, v18
    move-object/from16 v26, v15
    move-object/from16 v15, v19
    move-object/from16 v16, v20
    move-object/from16 v17, v21
    move/from16 v18, v22
    move-object/from16 v19, v23
    invoke-direct/range v7 ... v19, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole; Ljava/lang/String; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Ljava/util/List; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-wide/from16 v8, v24
    move-object/from16 v7, v26
    invoke-direct v7, v8, v9, v6, v5, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;-><init>(J I Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;)V
    invoke-interface v4, v7, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    const/4 v5, 0
    goto -6ah
    move-object v5, v2
    check-cast v5, Ljava/util/Map;
    invoke-interface v5, v4, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    if-nez v6, +00ch
    new-instance v6, Ljava/util/ArrayList;
    invoke-direct v6, Ljava/util/ArrayList;-><init>()V
    check-cast v6, Ljava/util/List;
    invoke-interface v5, v4, v6, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    check-cast v6, Ljava/util/List;
    invoke-interface v6, v14, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -1ah
    check-cast v2, Ljava/util/Map;
    invoke-interface v2, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v2
    invoke-interface v2, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +074h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/util/Map$Entry;
    invoke-interface v3, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    invoke-interface v3, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/util/List;
    check-cast v3, Ljava/lang/Iterable;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +050h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-static v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->seedHistoryWithAttachments$tsOf(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)J
    move-result-wide v7
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +012h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-static v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->seedHistoryWithAttachments$tsOf(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)J
    move-result-wide v9
    cmp-long v11, v7, v9
    if-lez v11, -012h
    move-wide v7, v9
    goto -15h
    move-object v5, v1
    check-cast v5, Ljava/util/Collection;
    new-instance v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;
    new-instance v15, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    invoke-direct v0, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->groupItemId(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v11
    sget-object v12, Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;->User Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    const-string v13, ""
    const/4 v14, 0
    const/4 v4, 0
    const/16 v16, 0
    const/16 v17, 0
    invoke-static v3, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v18
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 888
    const/16 v22, 0
    move-object v10, v15
    move-object v3, v15
    move v15, v4
    invoke-direct/range v10 ... v22, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole; Ljava/lang/String; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Ljava/util/List; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v9, v7, v8, v6, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;-><init>(J I Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;)V
    invoke-interface v5, v9, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -71h
    new-instance v1, Ljava/util/NoSuchElementException;
    invoke-direct v1, Ljava/util/NoSuchElementException;-><init>()V
    throw v1
    move-object v2, v1
    check-cast v2, Ljava/util/List;
    const/4 v3, 2
    new-array v3, v3, [Lkotlin/jvm/functions/Function1;
    new-instance v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$$ExternalSyntheticLambda1;
    invoke-direct v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$$ExternalSyntheticLambda1;-><init>()V
    const/4 v5, 0
    aput-object v4, v3, v5
    new-instance v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$$ExternalSyntheticLambda2;
    invoke-direct v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$$ExternalSyntheticLambda2;-><init>()V
    aput-object v4, v3, v6
    invoke-static v3, Lkotlin/comparisons/ComparisonsKt;->compareBy([Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;
    move-result-object v3
    invoke-static v2, v3, Lkotlin/collections/CollectionsKt;->sortWith(Ljava/util/List; Ljava/util/Comparator;)V
    check-cast v1, Ljava/lang/Iterable;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    check-cast v2, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +010h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;->getItem()Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    move-result-object v3
    invoke-interface v2, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    invoke-direct/range v27, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->rebuildItems()V
    invoke-virtual/range v27, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->notifyDataSetChanged()V
    return-void 
.end method

.method public final setAttachmentCallback(com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$AttachmentCallback)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->attachmentCallback Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;
    return-void 
.end method

.method public final setFooter(java.lang.String)void
    .registers 3
    # ins_size=2
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->footerItem Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    invoke-direct v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->footerPos()I
    move-result v0
    if-eqz v2, +00bh
    const/4 v2, 0
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->footerItem Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    invoke-direct v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->rebuildItems()V
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->notifyItemRemoved(I)V
    return-void 
.end method

.method public final setLiveBot(java.lang.String  java.lang.String  java.lang.String)void
    .registers 25
    # ins_size=4
    move-object/from16 v0, v21
    move-object/from16 v14, v22
    move-object/from16 v1, v23
    move-object/from16 v10, v24
    const-string v2, "content"
    invoke-static v14, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v15, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->liveBotItem Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    invoke-direct/range v21, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->liveBotPos()I
    move-result v13
    move-object v2, v14
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    const-string v12, "HistorySubtitleAdapter"
    if-eqz v2, +0b8h
    const-string v2, ", attachedId="
    if-eqz v15, +082h
    if-nez v1, +017h
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v3, "history_bot_"
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-interface v3, Ljava/util/List;->size()I
    move-result v3
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    move-object v3, v1
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string/jumbo v5, setLiveBot[archive]: archivedId=
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v4, ", oldLen="
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v15, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getContent()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/String;->length()I
    move-result v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v4, ", historySizeBefore="
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    iget-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v12, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v11, 0
    const/4 v12, 0
    const/16 v13, 758
    const/4 v14, 0
    move-object v1, v15
    move-object v2, v3
    move-object v3, v4
    move-object v4, v5
    move v5, v6
    move v6, v7
    move v7, v8
    move-object v8, v9
    move-object v9, v11
    move-object/from16 v10, v24
    move-object v11, v12
    move v12, v13
    move-object v13, v14
    invoke-static/range v1 ... v13, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole; Ljava/lang/String; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Ljava/util/List; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    move-result-object v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-interface v2, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    const/4 v1, 0
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->liveBotItem Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    invoke-direct/range v21, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->rebuildItems()V
    goto +32h
    if-nez v1, +004h
    if-eqz v10, +02fh
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string/jumbo v5, setLiveBot[archive-missing-live]: archivedId=
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", historySize="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v12, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    new-instance v11, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    const-string v2, "live_bot"
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;->Assistant Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    const/4 v5, 1
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v16, 0
    const/16 v17, 1008
    const/16 v18, 0
    move-object v1, v11
    move-object/from16 v4, v22
    move-object/from16 v19, v11
    move-object/from16 v11, v16
    move-object/from16 v20, v12
    move/from16 v12, v17
    move v14, v13
    move-object/from16 v13, v18
    invoke-direct/range v1 ... v13, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole; Ljava/lang/String; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Ljava/util/List; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    if-nez v15, +032h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, setLiveBot[start-live]: len=
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v22, Ljava/lang/String;->length()I
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", pos="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v14, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    move-object/from16 v3, v20
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    move-object/from16 v1, v19
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->liveBotItem Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    invoke-direct/range v21, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->rebuildItems()V
    invoke-virtual v0, v14, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->notifyItemInserted(I)V
    goto +1dh
    move-object/from16 v1, v19
    invoke-virtual v15, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getContent()Ljava/lang/String;
    move-result-object v2
    move-object/from16 v3, v22
    move v4, v14
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +00fh
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->liveBotItem Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->items Ljava/util/List;
    invoke-interface v2, v4, v1, Ljava/util/List;->set(I Ljava/lang/Object;)Ljava/lang/Object;
    const-string/jumbo v1, text_update
    invoke-virtual v0, v4, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->notifyItemChanged(I Ljava/lang/Object;)V
    return-void 
.end method

.method public final setLiveUser(java.lang.String  java.lang.String)boolean
    .registers 23
    # ins_size=3
    move-object/from16 v0, v20
    move-object/from16 v14, v21
    const-string v1, "content"
    invoke-static v14, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v15, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->liveUserItem Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    invoke-direct/range v20, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->liveUserPos()I
    move-result v13
    move-object v1, v14
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    const/16 v16, 0
    if-eqz v1, +03ch
    if-eqz v15, +039h
    if-nez v22, +019h
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "history_user_"
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    move-object v3, v1
    goto +3h
    move-object/from16 v3, v22
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/16 v13, 1014
    const/4 v14, 0
    move-object v2, v15
    invoke-static/range v2 ... v14, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole; Ljava/lang/String; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Ljava/util/List; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    move-result-object v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-interface v2, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    const/4 v1, 0
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->liveUserItem Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    invoke-direct/range v20, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->rebuildItems()V
    return v16
    new-instance v12, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    const-string v2, "live_user"
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;->User Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    const/4 v5, 1
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v17, 1008
    const/16 v18, 0
    move-object v1, v12
    move-object/from16 v4, v21
    move-object/from16 v19, v12
    move/from16 v12, v17
    move v14, v13
    move-object/from16 v13, v18
    invoke-direct/range v1 ... v13, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole; Ljava/lang/String; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Ljava/util/List; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    if-nez v15, +00eh
    move-object/from16 v1, v19
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->liveUserItem Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    invoke-direct/range v20, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->rebuildItems()V
    invoke-virtual v0, v14, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->notifyItemInserted(I)V
    const/4 v1, 1
    return v1
    move-object/from16 v1, v19
    invoke-virtual v15, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getContent()Ljava/lang/String;
    move-result-object v2
    move-object/from16 v3, v21
    move v4, v14
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +00fh
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->liveUserItem Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->items Ljava/util/List;
    invoke-interface v2, v4, v1, Ljava/util/List;->set(I Ljava/lang/Object;)Ljava/lang/Object;
    const-string/jumbo v1, text_update
    invoke-virtual v0, v4, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->notifyItemChanged(I Ljava/lang/Object;)V
    return v16
.end method

.method public final setThinkingVisible(boolean)boolean
    .registers 18
    # ins_size=2
    move-object/from16 v0, v16
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->thinkingItem Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    invoke-direct/range v16, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->thinkingPos()I
    move-result v2
    if-eqz v17, +025h
    if-nez v1, +023h
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    const-string/jumbo v4, thinking_dots
    sget-object v5, Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;->Assistant Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    const-string v6, ""
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 1
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/16 v14, 984
    const/4 v15, 0
    move-object v3, v1
    invoke-direct/range v3 ... v15, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole; Ljava/lang/String; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Ljava/util/List; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->thinkingItem Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    invoke-direct/range v16, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->rebuildItems()V
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->notifyItemInserted(I)V
    const/4 v1, 1
    goto +10h
    const/4 v3, 0
    if-nez v17, +00dh
    if-eqz v1, +00bh
    const/4 v1, 0
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->thinkingItem Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    invoke-direct/range v16, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->rebuildItems()V
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->notifyItemRemoved(I)V
    move v1, v3
    return v1
.end method

.method public final updateSubTaskBadgeOnMessage(java.lang.String  com.bytedance.trae.conversation.voice.subtask.SubTaskUiState)void
    .registers 24
    # ins_size=3
    move-object/from16 v0, v21
    move-object/from16 v1, v22
    const-string v2, "anchorMessageId"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v3
    invoke-interface v2, v3, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/ListIterator;->hasPrevious()Z
    move-result v3
    if-eqz v3, +017h
    invoke-interface v2, Ljava/util/ListIterator;->previous()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getId()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, -014h
    invoke-interface v2, Ljava/util/ListIterator;->nextIndex()I
    move-result v2
    goto +2h
    const/4 v2, -1
    move v15, v2
    const-string v14, "HistorySubtitleAdapter"
    const/16 v16, 0
    if-gez v15, +076h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    const/4 v3, 5
    invoke-static v2, v3, Lkotlin/collections/CollectionsKt;->takeLast(Ljava/util/List; I)Ljava/util/List;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Ljava/lang/Iterable;
    const-string v2, " | "
    move-object v4, v2
    check-cast v4, Ljava/lang/CharSequence;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    new-instance v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$$ExternalSyntheticLambda0;
    invoke-direct v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$$ExternalSyntheticLambda0;-><init>()V
    const/16 v10, 30
    const/4 v11, 0
    invoke-static/range v3 ... v11, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string/jumbo v5, updateSubTaskBadgeOnMessage[anchor-missing]: anchorMessageId=
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v4, ", badgeTaskId="
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    if-eqz v23, +007h
    invoke-virtual/range v23, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v4
    goto +3h
    move-object/from16 v4, v16
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v4, ", badgeState="
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    if-eqz v23, +006h
    invoke-virtual/range v23, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v16
    move-object/from16 v4, v16
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v4, ", historySize="
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v4
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v4, ", recentAnchors="
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v14, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    invoke-interface v2, v15, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getSubTaskBadge()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-result-object v17
    if-eqz v17, +007h
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v3
    goto +3h
    move-object/from16 v3, v16
    if-eqz v23, +007h
    invoke-virtual/range v23, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v4
    goto +3h
    move-object/from16 v4, v16
    if-ne v3, v4, +03bh
    if-eqz v17, +007h
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getFailureReason()Ljava/lang/String;
    move-result-object v3
    goto +3h
    move-object/from16 v3, v16
    if-eqz v23, +007h
    invoke-virtual/range v23, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getFailureReason()Ljava/lang/String;
    move-result-object v4
    goto +3h
    move-object/from16 v4, v16
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +023h
    if-eqz v17, +00bh
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getLongRunning()Z
    move-result v3
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v3
    goto +3h
    move-object/from16 v3, v16
    if-eqz v23, +00bh
    invoke-virtual/range v23, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getLongRunning()Z
    move-result v4
    invoke-static v4, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v4
    goto +3h
    move-object/from16 v4, v16
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    return-void 
    iget-object v13, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->historyItems Ljava/util/List;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v18, 511
    const/16 v19, 0
    move-object/from16 v12, v23
    move-object/from16 v20, v13
    move/from16 v13, v18
    move-object v0, v14
    move-object/from16 v14, v19
    invoke-static/range v2 ... v14, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole; Ljava/lang/String; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Ljava/util/List; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    move-result-object v2
    move-object/from16 v3, v20
    invoke-interface v3, v15, v2, Ljava/util/List;->set(I Ljava/lang/Object;)Ljava/lang/Object;
    invoke-direct/range v21, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->rebuildItems()V
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, updateSubTaskBadgeOnMessage[update]: anchorMessageId=
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, ", idx="
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v15, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, ", taskId="
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    if-eqz v23, +007h
    invoke-virtual/range v23, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v3
    goto +3h
    move-object/from16 v3, v16
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, ", from="
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    if-eqz v17, +007h
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v3
    goto +3h
    move-object/from16 v3, v16
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v3, 58
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    if-eqz v17, +00bh
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getLongRunning()Z
    move-result v4
    invoke-static v4, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v4
    goto +3h
    move-object/from16 v4, v16
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v4, " to="
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    if-eqz v23, +007h
    invoke-virtual/range v23, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v4
    goto +3h
    move-object/from16 v4, v16
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    if-eqz v23, +00ah
    invoke-virtual/range v23, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getLongRunning()Z
    move-result v3
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v16
    move-object/from16 v3, v16
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    const-string/jumbo v0, subtask_update
    move-object/from16 v1, v21
    invoke-virtual v1, v15, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->notifyItemChanged(I Ljava/lang/Object;)V
    return-void 
.end method
