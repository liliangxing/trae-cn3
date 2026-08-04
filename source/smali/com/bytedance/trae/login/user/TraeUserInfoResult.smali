# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/user/TraeUserInfoResult;
.super Ljava/lang/Object;
.source "UserInfoModel.kt"

.field private final aiRegion:Ljava/lang/String;
.field private final auditInfo:Ljava/lang/String;
.field private final avatarUrl:Ljava/lang/String;
.field private final description:Ljava/lang/String;
.field private final gender:Ljava/lang/String;
.field private final lastLoginTime:Ljava/lang/String;
.field private final lastLoginType:Ljava/lang/String;
.field private final migrateToSG:Ljava/lang/Boolean;
.field private final nonPlainTextEmail:Ljava/lang/String;
.field private final nonPlainTextMobile:Ljava/lang/String;
.field private final region:Ljava/lang/String;
.field private final registerTime:Ljava/lang/String;
.field private final screenName:Ljava/lang/String;
.field private final storeCountry:Ljava/lang/String;
.field private final tenantId:Ljava/lang/String;
.field private final userId:Ljava/lang/String;


.method public constructor <init>()void
    .registers 20
    # ins_size=1
    move-object/from16 v0, v19
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const v17, 65535
    const/16 v18, 0
    invoke-direct/range v0 ... v18, Lcom/bytedance/trae/login/user/TraeUserInfoResult;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean)void
    .registers 19
    # ins_size=17
    move-object v0, v2
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    move-object v1, v3
    iput-object v1, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->screenName Ljava/lang/String;
    move-object v1, v4
    iput-object v1, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->gender Ljava/lang/String;
    move-object v1, v5
    iput-object v1, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->avatarUrl Ljava/lang/String;
    move-object v1, v6
    iput-object v1, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->userId Ljava/lang/String;
    move-object v1, v7
    iput-object v1, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->description Ljava/lang/String;
    move-object v1, v8
    iput-object v1, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->tenantId Ljava/lang/String;
    move-object v1, v9
    iput-object v1, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->registerTime Ljava/lang/String;
    move-object v1, v10
    iput-object v1, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->lastLoginTime Ljava/lang/String;
    move-object v1, v11
    iput-object v1, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->lastLoginType Ljava/lang/String;
    move-object v1, v12
    iput-object v1, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->auditInfo Ljava/lang/String;
    move-object v1, v13
    iput-object v1, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->region Ljava/lang/String;
    move-object v1, v14
    iput-object v1, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->aiRegion Ljava/lang/String;
    move-object v1, v15
    iput-object v1, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->nonPlainTextEmail Ljava/lang/String;
    move-object/from16 v1, v16
    iput-object v1, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->nonPlainTextMobile Ljava/lang/String;
    move-object/from16 v1, v17
    iput-object v1, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->storeCountry Ljava/lang/String;
    move-object/from16 v1, v18
    iput-object v1, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->migrateToSG Ljava/lang/Boolean;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 36
    # ins_size=19
    move/from16 v0, v34
    and-int/lit8 v1, v0, 1
    if-eqz v1, +004h
    const/4 v1, 0
    goto +3h
    move-object/from16 v1, v18
    and-int/lit8 v3, v0, 2
    if-eqz v3, +004h
    const/4 v3, 0
    goto +3h
    move-object/from16 v3, v19
    and-int/lit8 v4, v0, 4
    if-eqz v4, +004h
    const/4 v4, 0
    goto +3h
    move-object/from16 v4, v20
    and-int/lit8 v5, v0, 8
    if-eqz v5, +004h
    const/4 v5, 0
    goto +3h
    move-object/from16 v5, v21
    and-int/lit8 v6, v0, 16
    if-eqz v6, +004h
    const/4 v6, 0
    goto +3h
    move-object/from16 v6, v22
    and-int/lit8 v7, v0, 32
    if-eqz v7, +004h
    const/4 v7, 0
    goto +3h
    move-object/from16 v7, v23
    and-int/lit8 v8, v0, 64
    if-eqz v8, +004h
    const/4 v8, 0
    goto +3h
    move-object/from16 v8, v24
    and-int/lit16 v9, v0, 128
    if-eqz v9, +004h
    const/4 v9, 0
    goto +3h
    move-object/from16 v9, v25
    and-int/lit16 v10, v0, 256
    if-eqz v10, +004h
    const/4 v10, 0
    goto +3h
    move-object/from16 v10, v26
    and-int/lit16 v11, v0, 512
    if-eqz v11, +004h
    const/4 v11, 0
    goto +3h
    move-object/from16 v11, v27
    and-int/lit16 v12, v0, 1024
    if-eqz v12, +004h
    const/4 v12, 0
    goto +3h
    move-object/from16 v12, v28
    and-int/lit16 v13, v0, 2048
    if-eqz v13, +004h
    const/4 v13, 0
    goto +3h
    move-object/from16 v13, v29
    and-int/lit16 v14, v0, 4096
    if-eqz v14, +004h
    const/4 v14, 0
    goto +3h
    move-object/from16 v14, v30
    and-int/lit16 v15, v0, 8192
    if-eqz v15, +004h
    const/4 v15, 0
    goto +3h
    move-object/from16 v15, v31
    and-int/lit16 v2, v0, 16384
    if-eqz v2, +004h
    const/4 v2, 0
    goto +3h
    move-object/from16 v2, v32
    const v16, 32768
    and-int v0, v0, v16
    if-eqz v0, +004h
    const/4 v0, 0
    goto +3h
    move-object/from16 v0, v33
    move-object/from16 v18, v17
    move-object/from16 v19, v1
    move-object/from16 v20, v3
    move-object/from16 v21, v4
    move-object/from16 v22, v5
    move-object/from16 v23, v6
    move-object/from16 v24, v7
    move-object/from16 v25, v8
    move-object/from16 v26, v9
    move-object/from16 v27, v10
    move-object/from16 v28, v11
    move-object/from16 v29, v12
    move-object/from16 v30, v13
    move-object/from16 v31, v14
    move-object/from16 v32, v15
    move-object/from16 v33, v2
    move-object/from16 v34, v0
    invoke-direct/range v18 ... v34, Lcom/bytedance/trae/login/user/TraeUserInfoResult;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.login.user.TraeUserInfoResult  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  int  java.lang.Object)com.bytedance.trae.login.user.TraeUserInfoResult
    .registers 36
    # ins_size=19
    move-object/from16 v0, v17
    move/from16 v1, v34
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->screenName Ljava/lang/String;
    goto +3h
    move-object/from16 v2, v18
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->gender Ljava/lang/String;
    goto +3h
    move-object/from16 v3, v19
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->avatarUrl Ljava/lang/String;
    goto +3h
    move-object/from16 v4, v20
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->userId Ljava/lang/String;
    goto +3h
    move-object/from16 v5, v21
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->description Ljava/lang/String;
    goto +3h
    move-object/from16 v6, v22
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->tenantId Ljava/lang/String;
    goto +3h
    move-object/from16 v7, v23
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->registerTime Ljava/lang/String;
    goto +3h
    move-object/from16 v8, v24
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->lastLoginTime Ljava/lang/String;
    goto +3h
    move-object/from16 v9, v25
    and-int/lit16 v10, v1, 256
    if-eqz v10, +005h
    iget-object v10, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->lastLoginType Ljava/lang/String;
    goto +3h
    move-object/from16 v10, v26
    and-int/lit16 v11, v1, 512
    if-eqz v11, +005h
    iget-object v11, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->auditInfo Ljava/lang/String;
    goto +3h
    move-object/from16 v11, v27
    and-int/lit16 v12, v1, 1024
    if-eqz v12, +005h
    iget-object v12, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->region Ljava/lang/String;
    goto +3h
    move-object/from16 v12, v28
    and-int/lit16 v13, v1, 2048
    if-eqz v13, +005h
    iget-object v13, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->aiRegion Ljava/lang/String;
    goto +3h
    move-object/from16 v13, v29
    and-int/lit16 v14, v1, 4096
    if-eqz v14, +005h
    iget-object v14, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->nonPlainTextEmail Ljava/lang/String;
    goto +3h
    move-object/from16 v14, v30
    and-int/lit16 v15, v1, 8192
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->nonPlainTextMobile Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v31
    move-object/from16 v31, v15
    and-int/lit16 v15, v1, 16384
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->storeCountry Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v32
    const v16, 32768
    and-int v1, v1, v16
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->migrateToSG Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v1, v33
    move-object/from16 v18, v2
    move-object/from16 v19, v3
    move-object/from16 v20, v4
    move-object/from16 v21, v5
    move-object/from16 v22, v6
    move-object/from16 v23, v7
    move-object/from16 v24, v8
    move-object/from16 v25, v9
    move-object/from16 v26, v10
    move-object/from16 v27, v11
    move-object/from16 v28, v12
    move-object/from16 v29, v13
    move-object/from16 v30, v14
    move-object/from16 v32, v15
    move-object/from16 v33, v1
    invoke-virtual/range v17 ... v33, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean;)Lcom/bytedance/trae/login/user/TraeUserInfoResult;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->screenName Ljava/lang/String;
    return-object v0
.end method

.method public final component10()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->auditInfo Ljava/lang/String;
    return-object v0
.end method

.method public final component11()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->region Ljava/lang/String;
    return-object v0
.end method

.method public final component12()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->aiRegion Ljava/lang/String;
    return-object v0
.end method

.method public final component13()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->nonPlainTextEmail Ljava/lang/String;
    return-object v0
.end method

.method public final component14()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->nonPlainTextMobile Ljava/lang/String;
    return-object v0
.end method

.method public final component15()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->storeCountry Ljava/lang/String;
    return-object v0
.end method

.method public final component16()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->migrateToSG Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->gender Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->avatarUrl Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->userId Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->description Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->tenantId Ljava/lang/String;
    return-object v0
.end method

.method public final component7()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->registerTime Ljava/lang/String;
    return-object v0
.end method

.method public final component8()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->lastLoginTime Ljava/lang/String;
    return-object v0
.end method

.method public final component9()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->lastLoginType Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean)com.bytedance.trae.login.user.TraeUserInfoResult
    .registers 35
    # ins_size=17
    move-object/from16 v1, v19
    move-object/from16 v2, v20
    move-object/from16 v3, v21
    move-object/from16 v4, v22
    move-object/from16 v5, v23
    move-object/from16 v6, v24
    move-object/from16 v7, v25
    move-object/from16 v8, v26
    move-object/from16 v9, v27
    move-object/from16 v10, v28
    move-object/from16 v11, v29
    move-object/from16 v12, v30
    move-object/from16 v13, v31
    move-object/from16 v14, v32
    move-object/from16 v15, v33
    move-object/from16 v16, v34
    new-instance v17, Lcom/bytedance/trae/login/user/TraeUserInfoResult;
    move-object/from16 v0, v17
    invoke-direct/range v0 ... v16, Lcom/bytedance/trae/login/user/TraeUserInfoResult;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean;)V
    return-object v17
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/login/user/TraeUserInfoResult;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/login/user/TraeUserInfoResult;
    iget-object v1, v4, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->screenName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->screenName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->gender Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->gender Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->avatarUrl Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->avatarUrl Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->userId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->userId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->description Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->description Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->tenantId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->tenantId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->registerTime Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->registerTime Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->lastLoginTime Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->lastLoginTime Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->lastLoginType Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->lastLoginType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->auditInfo Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->auditInfo Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->region Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->region Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->aiRegion Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->aiRegion Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->nonPlainTextEmail Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->nonPlainTextEmail Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->nonPlainTextMobile Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->nonPlainTextMobile Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->storeCountry Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->storeCountry Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->migrateToSG Ljava/lang/Boolean;
    iget-object v5, v5, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->migrateToSG Ljava/lang/Boolean;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getAiRegion()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->aiRegion Ljava/lang/String;
    return-object v0
.end method

.method public final getAuditInfo()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->auditInfo Ljava/lang/String;
    return-object v0
.end method

.method public final getAvatarUrl()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->avatarUrl Ljava/lang/String;
    return-object v0
.end method

.method public final getDescription()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->description Ljava/lang/String;
    return-object v0
.end method

.method public final getGender()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->gender Ljava/lang/String;
    return-object v0
.end method

.method public final getLastLoginTime()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->lastLoginTime Ljava/lang/String;
    return-object v0
.end method

.method public final getLastLoginType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->lastLoginType Ljava/lang/String;
    return-object v0
.end method

.method public final getMigrateToSG()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->migrateToSG Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getNonPlainTextEmail()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->nonPlainTextEmail Ljava/lang/String;
    return-object v0
.end method

.method public final getNonPlainTextMobile()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->nonPlainTextMobile Ljava/lang/String;
    return-object v0
.end method

.method public final getRegion()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->region Ljava/lang/String;
    return-object v0
.end method

.method public final getRegisterTime()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->registerTime Ljava/lang/String;
    return-object v0
.end method

.method public final getScreenName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->screenName Ljava/lang/String;
    return-object v0
.end method

.method public final getStoreCountry()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->storeCountry Ljava/lang/String;
    return-object v0
.end method

.method public final getTenantId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->tenantId Ljava/lang/String;
    return-object v0
.end method

.method public final getUserId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->userId Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->screenName Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->gender Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->avatarUrl Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->userId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->description Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->tenantId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->registerTime Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->lastLoginTime Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->lastLoginType Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->auditInfo Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->region Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->aiRegion Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->nonPlainTextEmail Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->nonPlainTextMobile Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->storeCountry Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->migrateToSG Ljava/lang/Boolean;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "TraeUserInfoResult(screenName="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->screenName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", gender="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->gender Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", avatarUrl="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->avatarUrl Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", userId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->userId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", description="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->description Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", tenantId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->tenantId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", registerTime="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->registerTime Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", lastLoginTime="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->lastLoginTime Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", lastLoginType="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->lastLoginType Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", auditInfo="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->auditInfo Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", region="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->region Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", aiRegion="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-object v1, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->aiRegion Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", nonPlainTextEmail="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->nonPlainTextEmail Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", nonPlainTextMobile="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->nonPlainTextMobile Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", storeCountry="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->storeCountry Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", migrateToSG="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->migrateToSG Ljava/lang/Boolean;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
