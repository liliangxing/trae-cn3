# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;
.super Ljava/lang/Object;
.source "EnterpriseAuthModels.kt"

.field private final isAllowLogin:Ljava/lang/Boolean;
.field private final privacyMode:Ljava/lang/Boolean;
.field private final tenantInfoBase:Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;
.field private final userInfo:Lcom/bytedance/trae/login/enterprise/EnterpriseUserInfo;


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
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;-><init>(Lcom/bytedance/trae/login/enterprise/EnterpriseUserInfo; Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo; Ljava/lang/Boolean; Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.login.enterprise.EnterpriseUserInfo  com.bytedance.trae.login.enterprise.EnterpriseTenantInfo  java.lang.Boolean  java.lang.Boolean)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->userInfo Lcom/bytedance/trae/login/enterprise/EnterpriseUserInfo;
    iput-object v2, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->tenantInfoBase Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;
    iput-object v3, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->isAllowLogin Ljava/lang/Boolean;
    iput-object v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->privacyMode Ljava/lang/Boolean;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.login.enterprise.EnterpriseUserInfo  com.bytedance.trae.login.enterprise.EnterpriseTenantInfo  java.lang.Boolean  java.lang.Boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 1
    const/4 v0, 0
    if-eqz v7, +003h
    move-object v2, v0
    and-int/lit8 v7, v6, 2
    if-eqz v7, +003h
    move-object v3, v0
    and-int/lit8 v7, v6, 4
    if-eqz v7, +003h
    move-object v4, v0
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    move-object v5, v0
    invoke-direct v1, v2, v3, v4, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;-><init>(Lcom/bytedance/trae/login/enterprise/EnterpriseUserInfo; Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo; Ljava/lang/Boolean; Ljava/lang/Boolean;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.login.enterprise.EnterpriseGetUserInfoData  com.bytedance.trae.login.enterprise.EnterpriseUserInfo  com.bytedance.trae.login.enterprise.EnterpriseTenantInfo  java.lang.Boolean  java.lang.Boolean  int  java.lang.Object)com.bytedance.trae.login.enterprise.EnterpriseGetUserInfoData
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->userInfo Lcom/bytedance/trae/login/enterprise/EnterpriseUserInfo;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->tenantInfoBase Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->isAllowLogin Ljava/lang/Boolean;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->privacyMode Ljava/lang/Boolean;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->copy(Lcom/bytedance/trae/login/enterprise/EnterpriseUserInfo; Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo; Ljava/lang/Boolean; Ljava/lang/Boolean;)Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.login.enterprise.EnterpriseUserInfo
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->userInfo Lcom/bytedance/trae/login/enterprise/EnterpriseUserInfo;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.login.enterprise.EnterpriseTenantInfo
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->tenantInfoBase Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;
    return-object v0
.end method

.method public final component3()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->isAllowLogin Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component4()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->privacyMode Ljava/lang/Boolean;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.login.enterprise.EnterpriseUserInfo  com.bytedance.trae.login.enterprise.EnterpriseTenantInfo  java.lang.Boolean  java.lang.Boolean)com.bytedance.trae.login.enterprise.EnterpriseGetUserInfoData
    .registers 6
    # ins_size=5
    new-instance v0, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;-><init>(Lcom/bytedance/trae/login/enterprise/EnterpriseUserInfo; Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo; Ljava/lang/Boolean; Ljava/lang/Boolean;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;
    iget-object v1, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->userInfo Lcom/bytedance/trae/login/enterprise/EnterpriseUserInfo;
    iget-object v3, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->userInfo Lcom/bytedance/trae/login/enterprise/EnterpriseUserInfo;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->tenantInfoBase Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;
    iget-object v3, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->tenantInfoBase Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->isAllowLogin Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->isAllowLogin Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->privacyMode Ljava/lang/Boolean;
    iget-object v5, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->privacyMode Ljava/lang/Boolean;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getPrivacyMode()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->privacyMode Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getTenantInfoBase()com.bytedance.trae.login.enterprise.EnterpriseTenantInfo
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->tenantInfoBase Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;
    return-object v0
.end method

.method public final getUserInfo()com.bytedance.trae.login.enterprise.EnterpriseUserInfo
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->userInfo Lcom/bytedance/trae/login/enterprise/EnterpriseUserInfo;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->userInfo Lcom/bytedance/trae/login/enterprise/EnterpriseUserInfo;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Lcom/bytedance/trae/login/enterprise/EnterpriseUserInfo;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->tenantInfoBase Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->isAllowLogin Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->privacyMode Ljava/lang/Boolean;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isAllowLogin()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->isAllowLogin Ljava/lang/Boolean;
    return-object v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "EnterpriseGetUserInfoData(userInfo="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->userInfo Lcom/bytedance/trae/login/enterprise/EnterpriseUserInfo;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", tenantInfoBase="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->tenantInfoBase Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isAllowLogin="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->isAllowLogin Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", privacyMode="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->privacyMode Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
