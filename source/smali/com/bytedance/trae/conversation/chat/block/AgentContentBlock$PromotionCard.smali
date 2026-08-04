# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;
.super Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
.source "AgentContentBlock.kt"

.field private final actions:Ljava/util/List;
.field private final cardId:Ljava/lang/String;
.field private final iconRes:Ljava/lang/Integer;
.field private final iconUrl:Ljava/lang/String;
.field private final varargs onActionClick:Lkotlin/jvm/functions/Function1;
.field private final style:Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CardStyle;
.field private final title:Ljava/lang/String;


.method public constructor <init>(java.lang.String  java.lang.Integer  java.lang.String  java.lang.String  java.util.List  com.bytedance.trae.conversation.chat.block.AgentContentBlock$CardStyle  kotlin.jvm.functions.Function1)void
    .registers 9
    # ins_size=8
    const-string v0, "cardId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, title
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "actions"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, style
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->cardId Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->iconRes Ljava/lang/Integer;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->iconUrl Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->title Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->actions Ljava/util/List;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->style Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CardStyle;
    iput-object v8, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->onActionClick Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.Integer  java.lang.String  java.lang.String  java.util.List  com.bytedance.trae.conversation.chat.block.AgentContentBlock$CardStyle  kotlin.jvm.functions.Function1  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 20
    # ins_size=10
    and-int/lit8 v0, v18, 2
    const/4 v1, 0
    if-eqz v0, +004h
    move-object v4, v1
    goto +2h
    move-object v4, v12
    and-int/lit8 v0, v18, 4
    if-eqz v0, +004h
    move-object v5, v1
    goto +2h
    move-object v5, v13
    and-int/lit8 v0, v18, 16
    if-eqz v0, +008h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    move-object v7, v0
    goto +2h
    move-object v7, v15
    and-int/lit8 v0, v18, 32
    if-eqz v0, +006h
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CardStyle;->DEFAULT Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CardStyle;
    move-object v8, v0
    goto +3h
    move-object/from16 v8, v16
    and-int/lit8 v0, v18, 64
    if-eqz v0, +004h
    move-object v9, v1
    goto +3h
    move-object/from16 v9, v17
    move-object v2, v10
    move-object v3, v11
    move-object v6, v14
    invoke-direct/range v2 ... v9, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;-><init>(Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CardStyle; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.block.AgentContentBlock$PromotionCard  java.lang.String  java.lang.Integer  java.lang.String  java.lang.String  java.util.List  com.bytedance.trae.conversation.chat.block.AgentContentBlock$CardStyle  kotlin.jvm.functions.Function1  int  java.lang.Object)com.bytedance.trae.conversation.chat.block.AgentContentBlock$PromotionCard
    .registers 15
    # ins_size=10
    and-int/lit8 v14, v13, 1
    if-eqz v14, +004h
    iget-object v6, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->cardId Ljava/lang/String;
    and-int/lit8 v14, v13, 2
    if-eqz v14, +004h
    iget-object v7, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->iconRes Ljava/lang/Integer;
    move-object v14, v7
    and-int/lit8 v7, v13, 4
    if-eqz v7, +004h
    iget-object v8, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->iconUrl Ljava/lang/String;
    move-object v0, v8
    and-int/lit8 v7, v13, 8
    if-eqz v7, +004h
    iget-object v9, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->title Ljava/lang/String;
    move-object v1, v9
    and-int/lit8 v7, v13, 16
    if-eqz v7, +004h
    iget-object v10, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->actions Ljava/util/List;
    move-object v2, v10
    and-int/lit8 v7, v13, 32
    if-eqz v7, +004h
    iget-object v11, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->style Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CardStyle;
    move-object v3, v11
    and-int/lit8 v7, v13, 64
    if-eqz v7, +004h
    iget-object v12, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->onActionClick Lkotlin/jvm/functions/Function1;
    move-object v4, v12
    move-object v7, v5
    move-object v8, v6
    move-object v9, v14
    move-object v10, v0
    move-object v11, v1
    move-object v12, v2
    move-object v13, v3
    move-object v14, v4
    invoke-virtual/range v7 ... v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->copy(Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CardStyle; Lkotlin/jvm/functions/Function1;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;
    move-result-object v5
    return-object v5
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->cardId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->iconRes Ljava/lang/Integer;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->iconUrl Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->title Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->actions Ljava/util/List;
    return-object v0
.end method

.method public final component6()com.bytedance.trae.conversation.chat.block.AgentContentBlock$CardStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->style Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CardStyle;
    return-object v0
.end method

.method public final component7()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->onActionClick Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.Integer  java.lang.String  java.lang.String  java.util.List  com.bytedance.trae.conversation.chat.block.AgentContentBlock$CardStyle  kotlin.jvm.functions.Function1)com.bytedance.trae.conversation.chat.block.AgentContentBlock$PromotionCard
    .registers 17
    # ins_size=8
    const-string v0, "cardId"
    move-object v2, v10
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, title
    move-object v5, v13
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "actions"
    move-object v6, v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, style
    move-object v7, v15
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;
    move-object v1, v0
    move-object v3, v11
    move-object v4, v12
    move-object/from16 v8, v16
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;-><init>(Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CardStyle; Lkotlin/jvm/functions/Function1;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->cardId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->cardId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->iconRes Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->iconRes Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->iconUrl Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->iconUrl Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->title Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->title Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->actions Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->actions Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->style Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CardStyle;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->style Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CardStyle;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->onActionClick Lkotlin/jvm/functions/Function1;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->onActionClick Lkotlin/jvm/functions/Function1;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getActions()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->actions Ljava/util/List;
    return-object v0
.end method

.method public final getCardId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->cardId Ljava/lang/String;
    return-object v0
.end method

.method public final getIconRes()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->iconRes Ljava/lang/Integer;
    return-object v0
.end method

.method public final getIconUrl()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->iconUrl Ljava/lang/String;
    return-object v0
.end method

.method public final getOnActionClick()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->onActionClick Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getStyle()com.bytedance.trae.conversation.chat.block.AgentContentBlock$CardStyle
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->style Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CardStyle;
    return-object v0
.end method

.method public final getTitle()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->title Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->cardId Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->iconRes Ljava/lang/Integer;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->iconUrl Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->title Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->actions Ljava/util/List;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->style Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CardStyle;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CardStyle;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->onActionClick Lkotlin/jvm/functions/Function1;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "PromotionCard(cardId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->cardId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", iconRes="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->iconRes Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", iconUrl="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->iconUrl Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", title="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->title Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", actions="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->actions Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", style="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->style Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CardStyle;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", onActionClick="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;->onActionClick Lkotlin/jvm/functions/Function1;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
