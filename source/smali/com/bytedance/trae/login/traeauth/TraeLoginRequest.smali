# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;
.super Ljava/lang/Object;
.source "TraeAuthModels.kt"

.field private final activityId:Ljava/lang/String;
.field private final activityName:Ljava/lang/String;
.field private final bdvid:Ljava/lang/String;
.field private final extraUtmInfo:Ljava/lang/String;
.field private final loginChannel:Ljava/lang/String;
.field private final platform:Ljava/lang/String;
.field private final promotionChannel:Ljava/lang/String;
.field private final riskActivityName:Ljava/lang/String;
.field private final sig:Ljava/lang/String;
.field private final sso:Ljava/lang/String;
.field private final utmCampaign:Ljava/lang/String;
.field private final utmContent:Ljava/lang/String;
.field private final utmMedium:Ljava/lang/String;
.field private final utmSource:Ljava/lang/String;
.field private final utmTerm:Ljava/lang/String;


.method public constructor <init>()void
    .registers 19
    # ins_size=1
    move-object/from16 v0, v18
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
    const/16 v16, 32767
    const/16 v17, 0
    invoke-direct/range v0 ... v17, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String)void
    .registers 16
    # ins_size=16
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->loginChannel Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->platform Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->sso Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->sig Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmSource Ljava/lang/String;
    iput-object v6, v0, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmMedium Ljava/lang/String;
    iput-object v7, v0, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmCampaign Ljava/lang/String;
    iput-object v8, v0, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmTerm Ljava/lang/String;
    iput-object v9, v0, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmContent Ljava/lang/String;
    iput-object v10, v0, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->bdvid Ljava/lang/String;
    iput-object v11, v0, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->activityName Ljava/lang/String;
    iput-object v12, v0, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->activityId Ljava/lang/String;
    iput-object v13, v0, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->promotionChannel Ljava/lang/String;
    iput-object v14, v0, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->riskActivityName Ljava/lang/String;
    iput-object v15, v0, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->extraUtmInfo Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 34
    # ins_size=18
    move/from16 v0, v32
    and-int/lit8 v1, v0, 1
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v1, v2
    goto +3h
    move-object/from16 v1, v17
    and-int/lit8 v3, v0, 2
    if-eqz v3, +004h
    move-object v3, v2
    goto +3h
    move-object/from16 v3, v18
    and-int/lit8 v4, v0, 4
    if-eqz v4, +004h
    move-object v4, v2
    goto +3h
    move-object/from16 v4, v19
    and-int/lit8 v5, v0, 8
    if-eqz v5, +004h
    move-object v5, v2
    goto +3h
    move-object/from16 v5, v20
    and-int/lit8 v6, v0, 16
    if-eqz v6, +004h
    move-object v6, v2
    goto +3h
    move-object/from16 v6, v21
    and-int/lit8 v7, v0, 32
    if-eqz v7, +004h
    move-object v7, v2
    goto +3h
    move-object/from16 v7, v22
    and-int/lit8 v8, v0, 64
    if-eqz v8, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v23
    and-int/lit16 v9, v0, 128
    if-eqz v9, +004h
    move-object v9, v2
    goto +3h
    move-object/from16 v9, v24
    and-int/lit16 v10, v0, 256
    if-eqz v10, +004h
    move-object v10, v2
    goto +3h
    move-object/from16 v10, v25
    and-int/lit16 v11, v0, 512
    if-eqz v11, +004h
    move-object v11, v2
    goto +3h
    move-object/from16 v11, v26
    and-int/lit16 v12, v0, 1024
    if-eqz v12, +004h
    move-object v12, v2
    goto +3h
    move-object/from16 v12, v27
    and-int/lit16 v13, v0, 2048
    if-eqz v13, +004h
    move-object v13, v2
    goto +3h
    move-object/from16 v13, v28
    and-int/lit16 v14, v0, 4096
    if-eqz v14, +004h
    move-object v14, v2
    goto +3h
    move-object/from16 v14, v29
    and-int/lit16 v15, v0, 8192
    if-eqz v15, +004h
    move-object v15, v2
    goto +3h
    move-object/from16 v15, v30
    and-int/lit16 v0, v0, 16384
    if-eqz v0, +003h
    goto +3h
    move-object/from16 v2, v31
    move-object/from16 v17, v16
    move-object/from16 v18, v1
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
    move-object/from16 v31, v15
    move-object/from16 v32, v2
    invoke-direct/range v17 ... v32, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.login.traeauth.TraeLoginRequest  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.login.traeauth.TraeLoginRequest
    .registers 34
    # ins_size=18
    move-object/from16 v0, v16
    move/from16 v1, v32
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->loginChannel Ljava/lang/String;
    goto +3h
    move-object/from16 v2, v17
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->platform Ljava/lang/String;
    goto +3h
    move-object/from16 v3, v18
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->sso Ljava/lang/String;
    goto +3h
    move-object/from16 v4, v19
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->sig Ljava/lang/String;
    goto +3h
    move-object/from16 v5, v20
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmSource Ljava/lang/String;
    goto +3h
    move-object/from16 v6, v21
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmMedium Ljava/lang/String;
    goto +3h
    move-object/from16 v7, v22
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmCampaign Ljava/lang/String;
    goto +3h
    move-object/from16 v8, v23
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmTerm Ljava/lang/String;
    goto +3h
    move-object/from16 v9, v24
    and-int/lit16 v10, v1, 256
    if-eqz v10, +005h
    iget-object v10, v0, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmContent Ljava/lang/String;
    goto +3h
    move-object/from16 v10, v25
    and-int/lit16 v11, v1, 512
    if-eqz v11, +005h
    iget-object v11, v0, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->bdvid Ljava/lang/String;
    goto +3h
    move-object/from16 v11, v26
    and-int/lit16 v12, v1, 1024
    if-eqz v12, +005h
    iget-object v12, v0, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->activityName Ljava/lang/String;
    goto +3h
    move-object/from16 v12, v27
    and-int/lit16 v13, v1, 2048
    if-eqz v13, +005h
    iget-object v13, v0, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->activityId Ljava/lang/String;
    goto +3h
    move-object/from16 v13, v28
    and-int/lit16 v14, v1, 4096
    if-eqz v14, +005h
    iget-object v14, v0, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->promotionChannel Ljava/lang/String;
    goto +3h
    move-object/from16 v14, v29
    and-int/lit16 v15, v1, 8192
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->riskActivityName Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v30
    and-int/lit16 v1, v1, 16384
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->extraUtmInfo Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v31
    move-object/from16 v17, v2
    move-object/from16 v18, v3
    move-object/from16 v19, v4
    move-object/from16 v20, v5
    move-object/from16 v21, v6
    move-object/from16 v22, v7
    move-object/from16 v23, v8
    move-object/from16 v24, v9
    move-object/from16 v25, v10
    move-object/from16 v26, v11
    move-object/from16 v27, v12
    move-object/from16 v28, v13
    move-object/from16 v29, v14
    move-object/from16 v30, v15
    move-object/from16 v31, v1
    invoke-virtual/range v16 ... v31, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->loginChannel Ljava/lang/String;
    return-object v0
.end method

.method public final component10()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->bdvid Ljava/lang/String;
    return-object v0
.end method

.method public final component11()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->activityName Ljava/lang/String;
    return-object v0
.end method

.method public final component12()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->activityId Ljava/lang/String;
    return-object v0
.end method

.method public final component13()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->promotionChannel Ljava/lang/String;
    return-object v0
.end method

.method public final component14()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->riskActivityName Ljava/lang/String;
    return-object v0
.end method

.method public final component15()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->extraUtmInfo Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->platform Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->sso Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->sig Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmSource Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmMedium Ljava/lang/String;
    return-object v0
.end method

.method public final component7()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmCampaign Ljava/lang/String;
    return-object v0
.end method

.method public final component8()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmTerm Ljava/lang/String;
    return-object v0
.end method

.method public final component9()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmContent Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String)com.bytedance.trae.login.traeauth.TraeLoginRequest
    .registers 33
    # ins_size=16
    new-instance v16, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;
    move-object/from16 v0, v16
    move-object/from16 v1, v18
    move-object/from16 v2, v19
    move-object/from16 v3, v20
    move-object/from16 v4, v21
    move-object/from16 v5, v22
    move-object/from16 v6, v23
    move-object/from16 v7, v24
    move-object/from16 v8, v25
    move-object/from16 v9, v26
    move-object/from16 v10, v27
    move-object/from16 v11, v28
    move-object/from16 v12, v29
    move-object/from16 v13, v30
    move-object/from16 v14, v31
    move-object/from16 v15, v32
    invoke-direct/range v0 ... v15, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-object v16
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->loginChannel Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->loginChannel Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->platform Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->platform Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->sso Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->sso Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->sig Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->sig Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmSource Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmSource Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmMedium Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmMedium Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmCampaign Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmCampaign Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmTerm Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmTerm Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmContent Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmContent Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->bdvid Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->bdvid Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->activityName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->activityName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->activityId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->activityId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->promotionChannel Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->promotionChannel Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->riskActivityName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->riskActivityName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->extraUtmInfo Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->extraUtmInfo Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getActivityId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->activityId Ljava/lang/String;
    return-object v0
.end method

.method public final getActivityName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->activityName Ljava/lang/String;
    return-object v0
.end method

.method public final getBdvid()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->bdvid Ljava/lang/String;
    return-object v0
.end method

.method public final getExtraUtmInfo()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->extraUtmInfo Ljava/lang/String;
    return-object v0
.end method

.method public final getLoginChannel()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->loginChannel Ljava/lang/String;
    return-object v0
.end method

.method public final getPlatform()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->platform Ljava/lang/String;
    return-object v0
.end method

.method public final getPromotionChannel()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->promotionChannel Ljava/lang/String;
    return-object v0
.end method

.method public final getRiskActivityName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->riskActivityName Ljava/lang/String;
    return-object v0
.end method

.method public final getSig()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->sig Ljava/lang/String;
    return-object v0
.end method

.method public final getSso()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->sso Ljava/lang/String;
    return-object v0
.end method

.method public final getUtmCampaign()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmCampaign Ljava/lang/String;
    return-object v0
.end method

.method public final getUtmContent()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmContent Ljava/lang/String;
    return-object v0
.end method

.method public final getUtmMedium()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmMedium Ljava/lang/String;
    return-object v0
.end method

.method public final getUtmSource()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmSource Ljava/lang/String;
    return-object v0
.end method

.method public final getUtmTerm()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmTerm Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->loginChannel Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->platform Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->sso Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->sig Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmSource Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmMedium Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmCampaign Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmTerm Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmContent Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->bdvid Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->activityName Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->activityId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->promotionChannel Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->riskActivityName Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->extraUtmInfo Ljava/lang/String;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "TraeLoginRequest(loginChannel="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->loginChannel Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", platform="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->platform Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", sso="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->sso Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", sig="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->sig Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", utmSource="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmSource Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", utmMedium="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmMedium Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", utmCampaign="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmCampaign Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", utmTerm="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmTerm Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", utmContent="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->utmContent Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bdvid="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->bdvid Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", activityName="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->activityName Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", activityId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-object v1, v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->activityId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", promotionChannel="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->promotionChannel Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", riskActivityName="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->riskActivityName Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", extraUtmInfo="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;->extraUtmInfo Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
