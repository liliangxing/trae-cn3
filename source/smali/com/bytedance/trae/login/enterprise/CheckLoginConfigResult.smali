# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;
.super Ljava/lang/Object;
.source "EnterpriseAuthModels.kt"

.field private final isDefaultDomainLoginBlocked:Z
.field private final isEnableSso:Z
.field private final isSsoLoginRequired:Z
.field private final ssoAuthUrl:Ljava/lang/String;


.method public constructor <init>()void
    .registers 8
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/16 v5, 15
    const/4 v6, 0
    move-object v0, v7
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;-><init>(Z Ljava/lang/String; Z Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(boolean  java.lang.String  boolean  boolean)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-boolean v1, v0, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->isEnableSso Z
    iput-object v2, v0, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->ssoAuthUrl Ljava/lang/String;
    iput-boolean v3, v0, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->isSsoLoginRequired Z
    iput-boolean v4, v0, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->isDefaultDomainLoginBlocked Z
    return-void 
.end method

.method public synthetic constructor <init>(boolean  java.lang.String  boolean  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 1
    const/4 v0, 0
    if-eqz v7, +003h
    move v2, v0
    and-int/lit8 v7, v6, 2
    if-eqz v7, +003h
    const/4 v3, 0
    and-int/lit8 v7, v6, 4
    if-eqz v7, +003h
    move v4, v0
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    move v5, v0
    invoke-direct v1, v2, v3, v4, v5, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;-><init>(Z Ljava/lang/String; Z Z)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.login.enterprise.CheckLoginConfigResult  boolean  java.lang.String  boolean  boolean  int  java.lang.Object)com.bytedance.trae.login.enterprise.CheckLoginConfigResult
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-boolean v1, v0, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->isEnableSso Z
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->ssoAuthUrl Ljava/lang/String;
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-boolean v3, v0, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->isSsoLoginRequired Z
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-boolean v4, v0, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->isDefaultDomainLoginBlocked Z
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->copy(Z Ljava/lang/String; Z Z)Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;
    move-result-object v0
    return-object v0
.end method

.method public final component1()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->isEnableSso Z
    return v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->ssoAuthUrl Ljava/lang/String;
    return-object v0
.end method

.method public final component3()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->isSsoLoginRequired Z
    return v0
.end method

.method public final component4()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->isDefaultDomainLoginBlocked Z
    return v0
.end method

.method public final copy(boolean  java.lang.String  boolean  boolean)com.bytedance.trae.login.enterprise.CheckLoginConfigResult
    .registers 6
    # ins_size=5
    new-instance v0, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;-><init>(Z Ljava/lang/String; Z Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;
    iget-boolean v1, v4, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->isEnableSso Z
    iget-boolean v3, v5, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->isEnableSso Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->ssoAuthUrl Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->ssoAuthUrl Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->isSsoLoginRequired Z
    iget-boolean v3, v5, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->isSsoLoginRequired Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->isDefaultDomainLoginBlocked Z
    iget-boolean v5, v5, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->isDefaultDomainLoginBlocked Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getSsoAuthUrl()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->ssoAuthUrl Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-boolean v0, v2, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->isEnableSso Z
    invoke-static v0, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->ssoAuthUrl Ljava/lang/String;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->isSsoLoginRequired Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->isDefaultDomainLoginBlocked Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isDefaultDomainLoginBlocked()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->isDefaultDomainLoginBlocked Z
    return v0
.end method

.method public final isEnableSso()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->isEnableSso Z
    return v0
.end method

.method public final isSsoLoginRequired()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->isSsoLoginRequired Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "CheckLoginConfigResult(isEnableSso="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-boolean v1, v2, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->isEnableSso Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", ssoAuthUrl="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->ssoAuthUrl Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isSsoLoginRequired="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->isSsoLoginRequired Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isDefaultDomainLoginBlocked="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;->isDefaultDomainLoginBlocked Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
