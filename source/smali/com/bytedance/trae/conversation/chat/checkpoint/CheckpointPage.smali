# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;
.super Ljava/lang/Object;
.source "CheckpointModels.kt"

.field private final allowCustomInput:Z
.field private final isSupplementaryPage:Z
.field private final multiSelect:Z
.field private final options:Ljava/util/List;
.field private final question:Ljava/lang/String;


.method public constructor <init>(java.lang.String  java.util.List  boolean  boolean  boolean)void
    .registers 7
    # ins_size=6
    const-string v0, "question"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "options"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->question Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->options Ljava/util/List;
    iput-boolean v4, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->allowCustomInput Z
    iput-boolean v5, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->multiSelect Z
    iput-boolean v6, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->isSupplementaryPage Z
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.util.List  boolean  boolean  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 14
    # ins_size=8
    and-int/lit8 v13, v12, 4
    if-eqz v13, +003h
    const/4 v9, 1
    move v3, v9
    and-int/lit8 v9, v12, 8
    const/4 v13, 0
    if-eqz v9, +004h
    move v4, v13
    goto +2h
    move v4, v10
    and-int/lit8 v9, v12, 16
    if-eqz v9, +004h
    move v5, v13
    goto +2h
    move v5, v11
    move-object v0, v6
    move-object v1, v7
    move-object v2, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;-><init>(Ljava/lang/String; Ljava/util/List; Z Z Z)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.checkpoint.CheckpointPage  java.lang.String  java.util.List  boolean  boolean  boolean  int  java.lang.Object)com.bytedance.trae.conversation.chat.checkpoint.CheckpointPage
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    if-eqz v10, +004h
    iget-object v4, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->question Ljava/lang/String;
    and-int/lit8 v10, v9, 2
    if-eqz v10, +004h
    iget-object v5, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->options Ljava/util/List;
    move-object v10, v5
    and-int/lit8 v5, v9, 4
    if-eqz v5, +004h
    iget-boolean v6, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->allowCustomInput Z
    move v0, v6
    and-int/lit8 v5, v9, 8
    if-eqz v5, +004h
    iget-boolean v7, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->multiSelect Z
    move v1, v7
    and-int/lit8 v5, v9, 16
    if-eqz v5, +004h
    iget-boolean v8, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->isSupplementaryPage Z
    move v2, v8
    move-object v5, v3
    move-object v6, v4
    move-object v7, v10
    move v8, v0
    move v9, v1
    move v10, v2
    invoke-virtual/range v5 ... v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->copy(Ljava/lang/String; Ljava/util/List; Z Z Z)Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;
    move-result-object v3
    return-object v3
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->question Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->options Ljava/util/List;
    return-object v0
.end method

.method public final component3()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->allowCustomInput Z
    return v0
.end method

.method public final component4()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->multiSelect Z
    return v0
.end method

.method public final component5()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->isSupplementaryPage Z
    return v0
.end method

.method public final copy(java.lang.String  java.util.List  boolean  boolean  boolean)com.bytedance.trae.conversation.chat.checkpoint.CheckpointPage
    .registers 13
    # ins_size=6
    const-string v0, "question"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "options"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;
    move-object v1, v0
    move-object v2, v8
    move-object v3, v9
    move v4, v10
    move v5, v11
    move v6, v12
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;-><init>(Ljava/lang/String; Ljava/util/List; Z Z Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->question Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->question Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->options Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->options Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->allowCustomInput Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->allowCustomInput Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->multiSelect Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->multiSelect Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->isSupplementaryPage Z
    iget-boolean v5, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->isSupplementaryPage Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getAllowCustomInput()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->allowCustomInput Z
    return v0
.end method

.method public final getMultiSelect()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->multiSelect Z
    return v0
.end method

.method public final getOptions()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->options Ljava/util/List;
    return-object v0
.end method

.method public final getQuestion()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->question Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->question Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->options Ljava/util/List;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->allowCustomInput Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->multiSelect Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->isSupplementaryPage Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isSupplementaryPage()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->isSupplementaryPage Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "CheckpointPage(question="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->question Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", options="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->options Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", allowCustomInput="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->allowCustomInput Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", multiSelect="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->multiSelect Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isSupplementaryPage="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->isSupplementaryPage Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
