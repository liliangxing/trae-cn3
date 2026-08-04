# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/ShareLinkData;
.super Ljava/lang/Object;
.source "IShareLinkApi.kt"

.field private final anonymous:Z
.field private final artifactPath:Ljava/lang/String;
.field private final createdAt:Ljava/lang/String;
.field private final expiresAt:Ljava/lang/String;
.field private final shareSessionId:Ljava/lang/String;
.field private final status:Ljava/lang/String;
.field private final title:Ljava/lang/String;


.method public constructor <init>()void
    .registers 11
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 127
    const/4 v9, 0
    move-object v0, v10
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/conversation/products/ShareLinkData;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  boolean  java.lang.String  java.lang.String  java.lang.String  java.lang.String)void
    .registers 8
    # ins_size=8
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/ShareLinkData;->shareSessionId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/ShareLinkData;->title Ljava/lang/String;
    iput-boolean v3, v0, Lcom/bytedance/trae/conversation/products/ShareLinkData;->anonymous Z
    iput-object v4, v0, Lcom/bytedance/trae/conversation/products/ShareLinkData;->createdAt Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/products/ShareLinkData;->status Ljava/lang/String;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/products/ShareLinkData;->artifactPath Ljava/lang/String;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/products/ShareLinkData;->expiresAt Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  boolean  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 16
    # ins_size=10
    and-int/lit8 v15, v14, 1
    const/4 v0, 0
    if-eqz v15, +004h
    move-object v15, v0
    goto +2h
    move-object v15, v7
    and-int/lit8 v7, v14, 2
    if-eqz v7, +004h
    move-object v1, v0
    goto +2h
    move-object v1, v8
    and-int/lit8 v7, v14, 4
    if-eqz v7, +003h
    const/4 v9, 0
    move v2, v9
    and-int/lit8 v7, v14, 8
    if-eqz v7, +004h
    move-object v3, v0
    goto +2h
    move-object v3, v10
    and-int/lit8 v7, v14, 16
    if-eqz v7, +004h
    move-object v4, v0
    goto +2h
    move-object v4, v11
    and-int/lit8 v7, v14, 32
    if-eqz v7, +004h
    move-object v5, v0
    goto +2h
    move-object v5, v12
    and-int/lit8 v7, v14, 64
    if-eqz v7, +004h
    move-object v14, v0
    goto +2h
    move-object v14, v13
    move-object v7, v6
    move-object v8, v15
    move-object v9, v1
    move v10, v2
    move-object v11, v3
    move-object v12, v4
    move-object v13, v5
    invoke-direct/range v7 ... v14, Lcom/bytedance/trae/conversation/products/ShareLinkData;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.products.ShareLinkData  java.lang.String  java.lang.String  boolean  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.products.ShareLinkData
    .registers 15
    # ins_size=10
    and-int/lit8 v14, v13, 1
    if-eqz v14, +004h
    iget-object v6, v5, Lcom/bytedance/trae/conversation/products/ShareLinkData;->shareSessionId Ljava/lang/String;
    and-int/lit8 v14, v13, 2
    if-eqz v14, +004h
    iget-object v7, v5, Lcom/bytedance/trae/conversation/products/ShareLinkData;->title Ljava/lang/String;
    move-object v14, v7
    and-int/lit8 v7, v13, 4
    if-eqz v7, +004h
    iget-boolean v8, v5, Lcom/bytedance/trae/conversation/products/ShareLinkData;->anonymous Z
    move v0, v8
    and-int/lit8 v7, v13, 8
    if-eqz v7, +004h
    iget-object v9, v5, Lcom/bytedance/trae/conversation/products/ShareLinkData;->createdAt Ljava/lang/String;
    move-object v1, v9
    and-int/lit8 v7, v13, 16
    if-eqz v7, +004h
    iget-object v10, v5, Lcom/bytedance/trae/conversation/products/ShareLinkData;->status Ljava/lang/String;
    move-object v2, v10
    and-int/lit8 v7, v13, 32
    if-eqz v7, +004h
    iget-object v11, v5, Lcom/bytedance/trae/conversation/products/ShareLinkData;->artifactPath Ljava/lang/String;
    move-object v3, v11
    and-int/lit8 v7, v13, 64
    if-eqz v7, +004h
    iget-object v12, v5, Lcom/bytedance/trae/conversation/products/ShareLinkData;->expiresAt Ljava/lang/String;
    move-object v4, v12
    move-object v7, v5
    move-object v8, v6
    move-object v9, v14
    move v10, v0
    move-object v11, v1
    move-object v12, v2
    move-object v13, v3
    move-object v14, v4
    invoke-virtual/range v7 ... v14, Lcom/bytedance/trae/conversation/products/ShareLinkData;->copy(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/products/ShareLinkData;
    move-result-object v5
    return-object v5
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/ShareLinkData;->shareSessionId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/ShareLinkData;->title Ljava/lang/String;
    return-object v0
.end method

.method public final component3()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/products/ShareLinkData;->anonymous Z
    return v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/ShareLinkData;->createdAt Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/ShareLinkData;->status Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/ShareLinkData;->artifactPath Ljava/lang/String;
    return-object v0
.end method

.method public final component7()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/ShareLinkData;->expiresAt Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  boolean  java.lang.String  java.lang.String  java.lang.String  java.lang.String)com.bytedance.trae.conversation.products.ShareLinkData
    .registers 17
    # ins_size=8
    new-instance v8, Lcom/bytedance/trae/conversation/products/ShareLinkData;
    move-object v0, v8
    move-object v1, v10
    move-object v2, v11
    move v3, v12
    move-object v4, v13
    move-object v5, v14
    move-object v6, v15
    move-object/from16 v7, v16
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/products/ShareLinkData;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-object v8
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/products/ShareLinkData;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/products/ShareLinkData;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/ShareLinkData;->shareSessionId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/products/ShareLinkData;->shareSessionId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/ShareLinkData;->title Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/products/ShareLinkData;->title Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/products/ShareLinkData;->anonymous Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/products/ShareLinkData;->anonymous Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/ShareLinkData;->createdAt Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/products/ShareLinkData;->createdAt Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/ShareLinkData;->status Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/products/ShareLinkData;->status Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/ShareLinkData;->artifactPath Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/products/ShareLinkData;->artifactPath Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/ShareLinkData;->expiresAt Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/products/ShareLinkData;->expiresAt Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getAnonymous()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/products/ShareLinkData;->anonymous Z
    return v0
.end method

.method public final getArtifactPath()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/ShareLinkData;->artifactPath Ljava/lang/String;
    return-object v0
.end method

.method public final getCreatedAt()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/ShareLinkData;->createdAt Ljava/lang/String;
    return-object v0
.end method

.method public final getExpiresAt()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/ShareLinkData;->expiresAt Ljava/lang/String;
    return-object v0
.end method

.method public final getShareSessionId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/ShareLinkData;->shareSessionId Ljava/lang/String;
    return-object v0
.end method

.method public final getStatus()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/ShareLinkData;->status Ljava/lang/String;
    return-object v0
.end method

.method public final getTitle()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/ShareLinkData;->title Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/ShareLinkData;->shareSessionId Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/products/ShareLinkData;->title Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-boolean v2, v3, Lcom/bytedance/trae/conversation/products/ShareLinkData;->anonymous Z
    invoke-static v2, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/products/ShareLinkData;->createdAt Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/products/ShareLinkData;->status Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/products/ShareLinkData;->artifactPath Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/products/ShareLinkData;->expiresAt Ljava/lang/String;
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
    const-string v1, "ShareLinkData(shareSessionId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/ShareLinkData;->shareSessionId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", title="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/ShareLinkData;->title Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", anonymous="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/products/ShareLinkData;->anonymous Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", createdAt="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/ShareLinkData;->createdAt Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", status="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/ShareLinkData;->status Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", artifactPath="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/ShareLinkData;->artifactPath Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", expiresAt="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/ShareLinkData;->expiresAt Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
