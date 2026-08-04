# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;
.super Ljava/lang/Object;
.source "CreateTaskWorkspacePolicy.kt"

.field private final projectId:Ljava/lang/String;
.field private final workspaceDir:Ljava/lang/String;
.field private final workspaceFolders:Ljava/util/List;


.method public constructor <init>(java.lang.String  java.util.List  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;->workspaceDir Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;->workspaceFolders Ljava/util/List;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;->projectId Ljava/lang/String;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.CreateTaskWorkspaceFields  java.lang.String  java.util.List  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.CreateTaskWorkspaceFields
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;->workspaceDir Ljava/lang/String;
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;->workspaceFolders Ljava/util/List;
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;->projectId Ljava/lang/String;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;->copy(Ljava/lang/String; Ljava/util/List; Ljava/lang/String;)Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;->workspaceDir Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;->workspaceFolders Ljava/util/List;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;->projectId Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.util.List  java.lang.String)com.bytedance.trae.conversation.CreateTaskWorkspaceFields
    .registers 5
    # ins_size=4
    new-instance v0, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;-><init>(Ljava/lang/String; Ljava/util/List; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;->workspaceDir Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;->workspaceDir Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;->workspaceFolders Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;->workspaceFolders Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;->projectId Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;->projectId Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getProjectId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;->projectId Ljava/lang/String;
    return-object v0
.end method

.method public final getWorkspaceDir()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;->workspaceDir Ljava/lang/String;
    return-object v0
.end method

.method public final getWorkspaceFolders()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;->workspaceFolders Ljava/util/List;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;->workspaceDir Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;->workspaceFolders Ljava/util/List;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;->projectId Ljava/lang/String;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "CreateTaskWorkspaceFields(workspaceDir="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;->workspaceDir Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", workspaceFolders="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;->workspaceFolders Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", projectId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;->projectId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
