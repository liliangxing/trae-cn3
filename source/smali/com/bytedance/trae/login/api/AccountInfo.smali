# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/api/AccountInfo;
.super Ljava/lang/Object;
.source "AccountInfo.kt"

.field private final accountType:Lcom/bytedance/trae/login/api/AccountType;
.field private final aiRegion:Ljava/lang/String;
.field private final avatarUrl:Ljava/lang/String;
.field private final email:Ljava/lang/String;
.field private final isLogin:Z
.field private final loginPlatform:Ljava/lang/String;
.field private final odinUserType:I
.field private final phoneNumber:Ljava/lang/String;
.field private final productType:I
.field private final saasPrivacyMode:Ljava/lang/Boolean;
.field private final screenName:Ljava/lang/String;
.field private final secUserId:Ljava/lang/String;
.field private final tenantId:Ljava/lang/String;
.field private final tenantName:Ljava/lang/String;
.field private final userId:Ljava/lang/String;


.method public constructor <init>(boolean  java.lang.String  java.lang.String  java.lang.String  int  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  com.bytedance.trae.login.api.AccountType  java.lang.String  java.lang.Boolean)void
    .registers 29
    # ins_size=16
    move-object v0, v13
    move-object v1, v15
    move-object/from16 v2, v16
    move-object/from16 v3, v17
    move-object/from16 v4, v19
    move-object/from16 v5, v20
    move-object/from16 v6, v21
    move-object/from16 v7, v22
    move-object/from16 v8, v23
    move-object/from16 v9, v24
    move-object/from16 v10, v26
    move-object/from16 v11, v27
    const-string v12, "loginPlatform"
    invoke-static v15, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v12, userId
    invoke-static v2, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v12, secUserId
    invoke-static v3, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v12, "avatarUrl"
    invoke-static v4, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v12, screenName
    invoke-static v5, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v12, "email"
    invoke-static v6, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v12, phoneNumber
    invoke-static v7, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v12, tenantId
    invoke-static v8, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v12, "aiRegion"
    invoke-static v9, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v12, "accountType"
    invoke-static v10, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v12, tenantName
    invoke-static v11, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v13, Ljava/lang/Object;-><init>()V
    move v12, v14
    iput-boolean v12, v0, Lcom/bytedance/trae/login/api/AccountInfo;->isLogin Z
    iput-object v1, v0, Lcom/bytedance/trae/login/api/AccountInfo;->loginPlatform Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/login/api/AccountInfo;->userId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/login/api/AccountInfo;->secUserId Ljava/lang/String;
    move/from16 v1, v18
    iput v1, v0, Lcom/bytedance/trae/login/api/AccountInfo;->odinUserType I
    iput-object v4, v0, Lcom/bytedance/trae/login/api/AccountInfo;->avatarUrl Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/login/api/AccountInfo;->screenName Ljava/lang/String;
    iput-object v6, v0, Lcom/bytedance/trae/login/api/AccountInfo;->email Ljava/lang/String;
    iput-object v7, v0, Lcom/bytedance/trae/login/api/AccountInfo;->phoneNumber Ljava/lang/String;
    iput-object v8, v0, Lcom/bytedance/trae/login/api/AccountInfo;->tenantId Ljava/lang/String;
    iput-object v9, v0, Lcom/bytedance/trae/login/api/AccountInfo;->aiRegion Ljava/lang/String;
    move/from16 v1, v25
    iput v1, v0, Lcom/bytedance/trae/login/api/AccountInfo;->productType I
    iput-object v10, v0, Lcom/bytedance/trae/login/api/AccountInfo;->accountType Lcom/bytedance/trae/login/api/AccountType;
    iput-object v11, v0, Lcom/bytedance/trae/login/api/AccountInfo;->tenantName Ljava/lang/String;
    move-object/from16 v1, v28
    iput-object v1, v0, Lcom/bytedance/trae/login/api/AccountInfo;->saasPrivacyMode Ljava/lang/Boolean;
    return-void 
.end method

.method public synthetic constructor <init>(boolean  java.lang.String  java.lang.String  java.lang.String  int  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  com.bytedance.trae.login.api.AccountType  java.lang.String  java.lang.Boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 34
    # ins_size=18
    move-object/from16 v2, v18
    move/from16 v0, v32
    and-int/lit8 v1, v0, 64
    const-string v3, ""
    if-eqz v1, +004h
    move-object v7, v3
    goto +3h
    move-object/from16 v7, v23
    and-int/lit16 v1, v0, 128
    if-eqz v1, +004h
    move-object v8, v3
    goto +3h
    move-object/from16 v8, v24
    and-int/lit16 v1, v0, 256
    if-eqz v1, +004h
    move-object v9, v3
    goto +3h
    move-object/from16 v9, v25
    and-int/lit16 v1, v0, 512
    if-eqz v1, +004h
    move-object v10, v3
    goto +3h
    move-object/from16 v10, v26
    and-int/lit16 v1, v0, 1024
    if-eqz v1, +004h
    move-object v11, v3
    goto +3h
    move-object/from16 v11, v27
    and-int/lit16 v1, v0, 2048
    if-eqz v1, +005h
    const/4 v1, 0
    move v12, v1
    goto +3h
    move/from16 v12, v28
    and-int/lit16 v1, v0, 4096
    if-eqz v1, +021h
    if-nez v17, +005h
    sget-object v1, Lcom/bytedance/trae/login/api/AccountType;->UNKNOWN Lcom/bytedance/trae/login/api/AccountType;
    goto +19h
    const-string v1, "bytecloud"
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +005h
    sget-object v1, Lcom/bytedance/trae/login/api/AccountType;->BYTEDANCE Lcom/bytedance/trae/login/api/AccountType;
    goto +eh
    const-string v1, "enterprise"
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +005h
    sget-object v1, Lcom/bytedance/trae/login/api/AccountType;->TOB Lcom/bytedance/trae/login/api/AccountType;
    goto +3h
    sget-object v1, Lcom/bytedance/trae/login/api/AccountType;->TOC Lcom/bytedance/trae/login/api/AccountType;
    move-object v13, v1
    goto +3h
    move-object/from16 v13, v29
    and-int/lit16 v1, v0, 8192
    if-eqz v1, +004h
    move-object v14, v3
    goto +3h
    move-object/from16 v14, v30
    and-int/lit16 v0, v0, 16384
    if-eqz v0, +005h
    const/4 v0, 0
    move-object v15, v0
    goto +3h
    move-object/from16 v15, v31
    move-object/from16 v0, v16
    move/from16 v1, v17
    move-object/from16 v2, v18
    move-object/from16 v3, v19
    move-object/from16 v4, v20
    move/from16 v5, v21
    move-object/from16 v6, v22
    invoke-direct/range v0 ... v15, Lcom/bytedance/trae/login/api/AccountInfo;-><init>(Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lcom/bytedance/trae/login/api/AccountType; Ljava/lang/String; Ljava/lang/Boolean;)V
    return-void 
.end method

.method public final getAccountType()com.bytedance.trae.login.api.AccountType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/AccountInfo;->accountType Lcom/bytedance/trae/login/api/AccountType;
    return-object v0
.end method

.method public final getAiRegion()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/AccountInfo;->aiRegion Ljava/lang/String;
    return-object v0
.end method

.method public final getAvatarUrl()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/AccountInfo;->avatarUrl Ljava/lang/String;
    return-object v0
.end method

.method public final getEmail()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/AccountInfo;->email Ljava/lang/String;
    return-object v0
.end method

.method public final getLoginPlatform()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/AccountInfo;->loginPlatform Ljava/lang/String;
    return-object v0
.end method

.method public final getOdinUserType()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/login/api/AccountInfo;->odinUserType I
    return v0
.end method

.method public final getPhoneNumber()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/AccountInfo;->phoneNumber Ljava/lang/String;
    return-object v0
.end method

.method public final getProductType()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/login/api/AccountInfo;->productType I
    return v0
.end method

.method public final getSaasPrivacyMode()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/AccountInfo;->saasPrivacyMode Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getScreenName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/AccountInfo;->screenName Ljava/lang/String;
    return-object v0
.end method

.method public final getSecUserId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/AccountInfo;->secUserId Ljava/lang/String;
    return-object v0
.end method

.method public final getTenantId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/AccountInfo;->tenantId Ljava/lang/String;
    return-object v0
.end method

.method public final getTenantName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/AccountInfo;->tenantName Ljava/lang/String;
    return-object v0
.end method

.method public final getUserId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/AccountInfo;->userId Ljava/lang/String;
    return-object v0
.end method

.method public final isLogin()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/login/api/AccountInfo;->isLogin Z
    return v0
.end method
