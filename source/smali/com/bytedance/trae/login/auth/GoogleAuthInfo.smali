# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/auth/GoogleAuthInfo;
.super Ljava/lang/Object;
.source "GoogleAuthHelper.kt"

.field private final accessToken:Ljava/lang/String;
.field private final accessTokenSecret:Ljava/lang/String;
.field private final expiresIn:J
.field private final idToken:Ljava/lang/String;
.field private final platform:Ljava/lang/String;
.field private final platformAppId:Ljava/lang/String;
.field private final serverAuthCode:Ljava/lang/String;
.field private final uid:Ljava/lang/String;


.method public constructor <init>()void
    .registers 13
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const-wide/16 v7, 0
    const/4 v9, 0
    const/16 v10, 255
    const/4 v11, 0
    move-object v0, v12
    invoke-direct/range v0 ... v11, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  java.lang.String)void
    .registers 11
    # ins_size=10
    const-string/jumbo v0, platform
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, platformAppId
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->platform Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->platformAppId Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->idToken Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->accessToken Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->accessTokenSecret Ljava/lang/String;
    iput-object v7, v1, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->serverAuthCode Ljava/lang/String;
    iput-wide v8, v1, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->expiresIn J
    iput-object v10, v1, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->uid Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 22
    # ins_size=12
    move/from16 v0, v20
    and-int/lit8 v1, v0, 1
    if-eqz v1, +005h
    const-string v1, "google"
    goto +2h
    move-object v1, v11
    and-int/lit8 v2, v0, 2
    if-eqz v2, +005h
    const-string v2, ""
    goto +2h
    move-object v2, v12
    and-int/lit8 v3, v0, 4
    const/4 v4, 0
    if-eqz v3, +004h
    move-object v3, v4
    goto +2h
    move-object v3, v13
    and-int/lit8 v5, v0, 8
    if-eqz v5, +004h
    move-object v5, v4
    goto +2h
    move-object v5, v14
    and-int/lit8 v6, v0, 16
    if-eqz v6, +004h
    move-object v6, v4
    goto +2h
    move-object v6, v15
    and-int/lit8 v7, v0, 32
    if-eqz v7, +004h
    move-object v7, v4
    goto +3h
    move-object/from16 v7, v16
    and-int/lit8 v8, v0, 64
    if-eqz v8, +005h
    const-wide/16 v8, 0
    goto +3h
    move-wide/from16 v8, v17
    and-int/lit16 v0, v0, 128
    if-eqz v0, +003h
    goto +3h
    move-object/from16 v4, v19
    move-object v11, v10
    move-object v12, v1
    move-object v13, v2
    move-object v14, v3
    move-object v15, v5
    move-object/from16 v16, v6
    move-object/from16 v17, v7
    move-wide/from16 v18, v8
    move-object/from16 v20, v4
    invoke-direct/range v11 ... v20, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.login.auth.GoogleAuthInfo  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  java.lang.String  int  java.lang.Object)com.bytedance.trae.login.auth.GoogleAuthInfo
    .registers 22
    # ins_size=12
    move-object v0, v10
    move/from16 v1, v20
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->platform Ljava/lang/String;
    goto +2h
    move-object v2, v11
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->platformAppId Ljava/lang/String;
    goto +2h
    move-object v3, v12
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->idToken Ljava/lang/String;
    goto +2h
    move-object v4, v13
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->accessToken Ljava/lang/String;
    goto +2h
    move-object v5, v14
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->accessTokenSecret Ljava/lang/String;
    goto +2h
    move-object v6, v15
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->serverAuthCode Ljava/lang/String;
    goto +3h
    move-object/from16 v7, v16
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-wide v8, v0, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->expiresIn J
    goto +3h
    move-wide/from16 v8, v17
    and-int/lit16 v1, v1, 128
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->uid Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v19
    move-object v11, v2
    move-object v12, v3
    move-object v13, v4
    move-object v14, v5
    move-object v15, v6
    move-object/from16 v16, v7
    move-wide/from16 v17, v8
    move-object/from16 v19, v1
    invoke-virtual/range v10 ... v19, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String;)Lcom/bytedance/trae/login/auth/GoogleAuthInfo;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->platform Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->platformAppId Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->idToken Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->accessToken Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->accessTokenSecret Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->serverAuthCode Ljava/lang/String;
    return-object v0
.end method

.method public final component7()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->expiresIn J
    return-wide v0
.end method

.method public final component8()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->uid Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  java.lang.String)com.bytedance.trae.login.auth.GoogleAuthInfo
    .registers 21
    # ins_size=10
    const-string/jumbo v0, platform
    move-object v2, v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, platformAppId
    move-object v3, v13
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;
    move-object v1, v0
    move-object v4, v14
    move-object v5, v15
    move-object/from16 v6, v16
    move-object/from16 v7, v17
    move-wide/from16 v8, v18
    move-object/from16 v10, v20
    invoke-direct/range v1 ... v10, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;
    iget-object v1, v7, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->platform Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->platform Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->platformAppId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->platformAppId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->idToken Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->idToken Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->accessToken Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->accessToken Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->accessTokenSecret Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->accessTokenSecret Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->serverAuthCode Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->serverAuthCode Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->expiresIn J
    iget-wide v5, v8, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->expiresIn J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->uid Ljava/lang/String;
    iget-object v8, v8, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->uid Ljava/lang/String;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getAccessToken()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->accessToken Ljava/lang/String;
    return-object v0
.end method

.method public final getAccessTokenSecret()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->accessTokenSecret Ljava/lang/String;
    return-object v0
.end method

.method public final getExpiresIn()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->expiresIn J
    return-wide v0
.end method

.method public final getIdToken()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->idToken Ljava/lang/String;
    return-object v0
.end method

.method public final getPlatform()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->platform Ljava/lang/String;
    return-object v0
.end method

.method public final getPlatformAppId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->platformAppId Ljava/lang/String;
    return-object v0
.end method

.method public final getServerAuthCode()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->serverAuthCode Ljava/lang/String;
    return-object v0
.end method

.method public final getUid()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->uid Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->platform Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->platformAppId Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->idToken Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->accessToken Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->accessTokenSecret Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->serverAuthCode Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v3, v5, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->expiresIn J
    invoke-static v3, v4, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->uid Ljava/lang/String;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "GoogleAuthInfo(platform="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->platform Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", platformAppId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->platformAppId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", idToken="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->idToken Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", accessToken="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->accessToken Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", accessTokenSecret="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->accessTokenSecret Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", serverAuthCode="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->serverAuthCode Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", expiresIn="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->expiresIn J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", uid="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->uid Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
