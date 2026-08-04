# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/GitBranch;
.super Ljava/lang/Object;
.source "Models.kt"

.field private final commitSha:Ljava/lang/String;
.field private final isDefault:Ljava/lang/Boolean;
.field private final isProtected:Ljava/lang/Boolean;
.field private final name:Ljava/lang/String;


.method public constructor <init>(java.lang.String  java.lang.String  java.lang.Boolean  java.lang.Boolean)void
    .registers 6
    # ins_size=5
    const-string v0, "name"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/network/GitBranch;->name Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/network/GitBranch;->commitSha Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/network/GitBranch;->isDefault Ljava/lang/Boolean;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/network/GitBranch;->isProtected Ljava/lang/Boolean;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.Boolean  java.lang.Boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 2
    const/4 v0, 0
    if-eqz v7, +003h
    move-object v3, v0
    and-int/lit8 v7, v6, 4
    if-eqz v7, +003h
    move-object v4, v0
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    move-object v5, v0
    invoke-direct v1, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/network/GitBranch;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.network.GitBranch  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.Boolean  int  java.lang.Object)com.bytedance.trae.conversation.network.GitBranch
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/network/GitBranch;->name Ljava/lang/String;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/network/GitBranch;->commitSha Ljava/lang/String;
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/network/GitBranch;->isDefault Ljava/lang/Boolean;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/network/GitBranch;->isProtected Ljava/lang/Boolean;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/network/GitBranch;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean;)Lcom/bytedance/trae/conversation/network/GitBranch;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/GitBranch;->name Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/GitBranch;->commitSha Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/GitBranch;->isDefault Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component4()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/GitBranch;->isProtected Ljava/lang/Boolean;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.Boolean  java.lang.Boolean)com.bytedance.trae.conversation.network.GitBranch
    .registers 6
    # ins_size=5
    const-string v0, "name"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/network/GitBranch;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/network/GitBranch;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/network/GitBranch;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/network/GitBranch;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/GitBranch;->name Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/GitBranch;->name Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/GitBranch;->commitSha Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/GitBranch;->commitSha Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/GitBranch;->isDefault Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/GitBranch;->isDefault Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/GitBranch;->isProtected Ljava/lang/Boolean;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/network/GitBranch;->isProtected Ljava/lang/Boolean;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getCommitSha()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/GitBranch;->commitSha Ljava/lang/String;
    return-object v0
.end method

.method public final getName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/GitBranch;->name Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/network/GitBranch;->name Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/GitBranch;->commitSha Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/GitBranch;->isDefault Ljava/lang/Boolean;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/GitBranch;->isProtected Ljava/lang/Boolean;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public final isDefault()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/GitBranch;->isDefault Ljava/lang/Boolean;
    return-object v0
.end method

.method public final isProtected()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/GitBranch;->isProtected Ljava/lang/Boolean;
    return-object v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "GitBranch(name="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/GitBranch;->name Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", commitSha="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/GitBranch;->commitSha Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isDefault="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/GitBranch;->isDefault Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isProtected="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/GitBranch;->isProtected Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
