# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;
.super Ljava/lang/Object;
.source "BrainstormSummary.kt"

.field private final actionItems:Ljava/util/List;
.field private final duration:Ljava/lang/String;
.field private final keyPoints:Ljava/util/List;
.field private final messageCount:I
.field private final title:Ljava/lang/String;


.method public constructor <init>(java.lang.String  java.util.List  java.util.List  java.lang.String  int)void
    .registers 7
    # ins_size=6
    const-string/jumbo v0, title
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "keyPoints"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "actionItems"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "duration"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->title Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->keyPoints Ljava/util/List;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->actionItems Ljava/util/List;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->duration Ljava/lang/String;
    iput v6, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->messageCount I
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.brainstorm.model.BrainstormSummary  java.lang.String  java.util.List  java.util.List  java.lang.String  int  int  java.lang.Object)com.bytedance.trae.conversation.brainstorm.model.BrainstormSummary
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    if-eqz v10, +004h
    iget-object v4, v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->title Ljava/lang/String;
    and-int/lit8 v10, v9, 2
    if-eqz v10, +004h
    iget-object v5, v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->keyPoints Ljava/util/List;
    move-object v10, v5
    and-int/lit8 v5, v9, 4
    if-eqz v5, +004h
    iget-object v6, v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->actionItems Ljava/util/List;
    move-object v0, v6
    and-int/lit8 v5, v9, 8
    if-eqz v5, +004h
    iget-object v7, v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->duration Ljava/lang/String;
    move-object v1, v7
    and-int/lit8 v5, v9, 16
    if-eqz v5, +004h
    iget v8, v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->messageCount I
    move v2, v8
    move-object v5, v3
    move-object v6, v4
    move-object v7, v10
    move-object v8, v0
    move-object v9, v1
    move v10, v2
    invoke-virtual/range v5 ... v10, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->copy(Ljava/lang/String; Ljava/util/List; Ljava/util/List; Ljava/lang/String; I)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;
    move-result-object v3
    return-object v3
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->title Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->keyPoints Ljava/util/List;
    return-object v0
.end method

.method public final component3()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->actionItems Ljava/util/List;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->duration Ljava/lang/String;
    return-object v0
.end method

.method public final component5()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->messageCount I
    return v0
.end method

.method public final copy(java.lang.String  java.util.List  java.util.List  java.lang.String  int)com.bytedance.trae.conversation.brainstorm.model.BrainstormSummary
    .registers 13
    # ins_size=6
    const-string/jumbo v0, title
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "keyPoints"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "actionItems"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "duration"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;
    move-object v1, v0
    move-object v2, v8
    move-object v3, v9
    move-object v4, v10
    move-object v5, v11
    move v6, v12
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;-><init>(Ljava/lang/String; Ljava/util/List; Ljava/util/List; Ljava/lang/String; I)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->title Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->title Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->keyPoints Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->keyPoints Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->actionItems Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->actionItems Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->duration Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->duration Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->messageCount I
    iget v5, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->messageCount I
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getActionItems()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->actionItems Ljava/util/List;
    return-object v0
.end method

.method public final getDuration()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->duration Ljava/lang/String;
    return-object v0
.end method

.method public final getKeyPoints()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->keyPoints Ljava/util/List;
    return-object v0
.end method

.method public final getMessageCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->messageCount I
    return v0
.end method

.method public final getTitle()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->title Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->title Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->keyPoints Ljava/util/List;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->actionItems Ljava/util/List;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->duration Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->messageCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "BrainstormSummary(title="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->title Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", keyPoints="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->keyPoints Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", actionItems="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->actionItems Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", duration="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->duration Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", messageCount="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;->messageCount I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
