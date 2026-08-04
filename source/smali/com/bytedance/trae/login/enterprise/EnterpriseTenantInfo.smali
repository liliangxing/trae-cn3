# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;
.super Ljava/lang/Object;
.source "EnterpriseAuthModels.kt"

.field private final productType:Ljava/lang/Integer;
.field private final tenantId:Ljava/lang/String;
.field private final tenantName:Ljava/lang/String;


.method public constructor <init>()void
    .registers 7
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 7
    const/4 v5, 0
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.Integer)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;->tenantId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;->tenantName Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;->productType Ljava/lang/Integer;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.Integer  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=6
    and-int/lit8 v6, v5, 1
    const/4 v0, 0
    if-eqz v6, +003h
    move-object v2, v0
    and-int/lit8 v6, v5, 2
    if-eqz v6, +003h
    move-object v3, v0
    and-int/lit8 v5, v5, 4
    if-eqz v5, +003h
    move-object v4, v0
    invoke-direct v1, v2, v3, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.login.enterprise.EnterpriseTenantInfo  java.lang.String  java.lang.String  java.lang.Integer  int  java.lang.Object)com.bytedance.trae.login.enterprise.EnterpriseTenantInfo
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;->tenantId Ljava/lang/String;
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget-object v2, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;->tenantName Ljava/lang/String;
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget-object v3, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;->productType Ljava/lang/Integer;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer;)Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;->tenantId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;->tenantName Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;->productType Ljava/lang/Integer;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.Integer)com.bytedance.trae.login.enterprise.EnterpriseTenantInfo
    .registers 5
    # ins_size=4
    new-instance v0, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;
    iget-object v1, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;->tenantId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;->tenantId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;->tenantName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;->tenantName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;->productType Ljava/lang/Integer;
    iget-object v5, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;->productType Ljava/lang/Integer;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getProductType()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;->productType Ljava/lang/Integer;
    return-object v0
.end method

.method public final getTenantId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;->tenantId Ljava/lang/String;
    return-object v0
.end method

.method public final getTenantName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;->tenantName Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;->tenantId Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;->tenantName Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;->productType Ljava/lang/Integer;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "EnterpriseTenantInfo(tenantId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;->tenantId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", tenantName="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;->tenantName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", productType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;->productType Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
