# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;
.super Ljava/lang/Object;
.source "ArtifactModels.kt"

.field public static final $stable:I
.field private final agentRunId:Ljava/lang/String;
.field private final files:Ljava/util/List;
.field private final resultStatus:Ljava/lang/String;
.field private final toolName:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.util.List)void
    .registers 6
    # ins_size=5
    const-string v0, "files"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->agentRunId Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->toolName Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->resultStatus Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->files Ljava/util/List;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactPlanItemInput  java.lang.String  java.lang.String  java.lang.String  java.util.List  int  java.lang.Object)com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactPlanItemInput
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->agentRunId Ljava/lang/String;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->toolName Ljava/lang/String;
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->resultStatus Ljava/lang/String;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->files Ljava/util/List;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List;)Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->agentRunId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->toolName Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->resultStatus Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->files Ljava/util/List;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.util.List)com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactPlanItemInput
    .registers 6
    # ins_size=5
    const-string v0, "files"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->agentRunId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->agentRunId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->toolName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->toolName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->resultStatus Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->resultStatus Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->files Ljava/util/List;
    iget-object v5, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->files Ljava/util/List;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getAgentRunId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->agentRunId Ljava/lang/String;
    return-object v0
.end method

.method public final getFiles()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->files Ljava/util/List;
    return-object v0
.end method

.method public final getResultStatus()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->resultStatus Ljava/lang/String;
    return-object v0
.end method

.method public final getToolName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->toolName Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->agentRunId Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->toolName Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->resultStatus Ljava/lang/String;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->files Ljava/util/List;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "VideoArtifactPlanItemInput(agentRunId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->agentRunId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", toolName="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->toolName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", resultStatus="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->resultStatus Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", files="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->files Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
