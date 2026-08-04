# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;
.super Ljava/lang/Object;
.source "TaskTemplateRepository.kt"

.field private final gitPrompt:Ljava/lang/String;
.field private final icon:Ljava/lang/String;
.field private final id:I
.field private final mode:Ljava/lang/String;
.field private final prompt:Ljava/lang/String;
.field private final title:Ljava/lang/String;


.method public constructor <init>(int  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String)void
    .registers 8
    # ins_size=7
    const-string/jumbo v0, title
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "prompt"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "gitPrompt"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "icon"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput v2, v1, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->id I
    iput-object v3, v1, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->title Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->prompt Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->gitPrompt Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->icon Ljava/lang/String;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->mode Ljava/lang/String;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.network.TaskTemplateRepository$TaskTemplateModel  int  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.network.TaskTemplateRepository$TaskTemplateModel
    .registers 13
    # ins_size=9
    and-int/lit8 v12, v11, 1
    if-eqz v12, +004h
    iget v5, v4, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->id I
    and-int/lit8 v12, v11, 2
    if-eqz v12, +004h
    iget-object v6, v4, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->title Ljava/lang/String;
    move-object v12, v6
    and-int/lit8 v6, v11, 4
    if-eqz v6, +004h
    iget-object v7, v4, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->prompt Ljava/lang/String;
    move-object v0, v7
    and-int/lit8 v6, v11, 8
    if-eqz v6, +004h
    iget-object v8, v4, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->gitPrompt Ljava/lang/String;
    move-object v1, v8
    and-int/lit8 v6, v11, 16
    if-eqz v6, +004h
    iget-object v9, v4, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->icon Ljava/lang/String;
    move-object v2, v9
    and-int/lit8 v6, v11, 32
    if-eqz v6, +004h
    iget-object v10, v4, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->mode Ljava/lang/String;
    move-object v3, v10
    move-object v6, v4
    move v7, v5
    move-object v8, v12
    move-object v9, v0
    move-object v10, v1
    move-object v11, v2
    move-object v12, v3
    invoke-virtual/range v6 ... v12, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->copy(I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;
    move-result-object v4
    return-object v4
.end method

.method public final component1()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->id I
    return v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->title Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->prompt Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->gitPrompt Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->icon Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->mode Ljava/lang/String;
    return-object v0
.end method

.method public final copy(int  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String)com.bytedance.trae.conversation.network.TaskTemplateRepository$TaskTemplateModel
    .registers 15
    # ins_size=7
    const-string/jumbo v0, title
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "prompt"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "gitPrompt"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "icon"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;
    move-object v1, v0
    move v2, v9
    move-object v3, v10
    move-object v4, v11
    move-object v5, v12
    move-object v6, v13
    move-object v7, v14
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;-><init>(I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;
    iget v1, v4, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->id I
    iget v3, v5, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->id I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->title Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->title Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->prompt Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->prompt Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->gitPrompt Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->gitPrompt Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->icon Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->icon Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->mode Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->mode Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getGitPrompt()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->gitPrompt Ljava/lang/String;
    return-object v0
.end method

.method public final getIcon()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->icon Ljava/lang/String;
    return-object v0
.end method

.method public final getId()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->id I
    return v0
.end method

.method public final getMode()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->mode Ljava/lang/String;
    return-object v0
.end method

.method public final getPrompt()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->prompt Ljava/lang/String;
    return-object v0
.end method

.method public final getTitle()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->title Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget v0, v2, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->id I
    invoke-static v0, Ljava/lang/Integer;->hashCode(I)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->title Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->prompt Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->gitPrompt Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->icon Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->mode Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "TaskTemplateModel(id="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->id I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", title="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->title Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", prompt="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->prompt Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", gitPrompt="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->gitPrompt Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", icon="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->icon Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", mode="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->mode Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
