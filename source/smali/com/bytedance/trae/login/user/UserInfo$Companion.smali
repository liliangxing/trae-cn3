# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/user/UserInfo$Companion;
.super Ljava/lang/Object;
.source "UserInfo.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/login/user/UserInfo$Companion;-><init>()V
    return-void 
.end method

.method public final from(com.bytedance.trae.login.user.TraeUserInfoResult)com.bytedance.trae.login.user.UserInfo
    .registers 19
    # ins_size=2
    const-string/jumbo v0, result
    move-object/from16 v1, v18
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/login/user/UserInfo;
    invoke-virtual/range v18, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->getUserId()Ljava/lang/String;
    move-result-object v2
    const-string v3, ""
    if-nez v2, +003h
    move-object v2, v3
    invoke-virtual/range v18, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->getScreenName()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +003h
    move-object v4, v3
    invoke-virtual/range v18, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->getAvatarUrl()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    move-object v5, v3
    invoke-virtual/range v18, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->getGender()Ljava/lang/String;
    move-result-object v6
    if-nez v6, +003h
    move-object v6, v3
    invoke-virtual/range v18, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->getNonPlainTextEmail()Ljava/lang/String;
    move-result-object v7
    if-nez v7, +003h
    move-object v7, v3
    invoke-virtual/range v18, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->getNonPlainTextMobile()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +003h
    move-object v8, v3
    invoke-virtual/range v18, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->getTenantId()Ljava/lang/String;
    move-result-object v9
    if-nez v9, +003h
    move-object v9, v3
    const/4 v10, 0
    const/4 v11, 0
    invoke-virtual/range v18, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->getAiRegion()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    move-object v12, v3
    goto +2h
    move-object v12, v1
    const/4 v13, 0
    const/4 v14, 0
    const/16 v15, 3456
    const/16 v16, 0
    move-object v1, v0
    move-object v3, v4
    move-object v4, v5
    move-object v5, v6
    move-object v6, v7
    move-object v7, v8
    move-object v8, v9
    move-object v9, v10
    move v10, v11
    move-object v11, v12
    move-object v12, v13
    move-object v13, v14
    move v14, v15
    move-object/from16 v15, v16
    invoke-direct/range v1 ... v15, Lcom/bytedance/trae/login/user/UserInfo;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
.end method
