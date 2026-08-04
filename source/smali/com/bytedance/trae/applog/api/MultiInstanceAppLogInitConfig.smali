# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;
.super Ljava/lang/Object;
.source "IMultiInstanceAppLogService.kt"

.field private final appId:I
.field private final appName:Ljava/lang/String;
.field private final channel:Ljava/lang/String;
.field private final isBoe:Z
.field private final updateVersinCode:I
.field private final versionCode:I
.field private final versionName:Ljava/lang/String;


.method public constructor <init>(int  java.lang.String  int  java.lang.String  int  java.lang.String  boolean)void
    .registers 9
    # ins_size=8
    const-string v0, "appName"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, versionName
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "channel"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput v2, v1, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->appId I
    iput-object v3, v1, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->appName Ljava/lang/String;
    iput v4, v1, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->versionCode I
    iput-object v5, v1, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->versionName Ljava/lang/String;
    iput v6, v1, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->updateVersinCode I
    iput-object v7, v1, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->channel Ljava/lang/String;
    iput-boolean v8, v1, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->isBoe Z
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.applog.api.MultiInstanceAppLogInitConfig  int  java.lang.String  int  java.lang.String  int  java.lang.String  boolean  int  java.lang.Object)com.bytedance.trae.applog.api.MultiInstanceAppLogInitConfig
    .registers 15
    # ins_size=10
    and-int/lit8 v14, v13, 1
    if-eqz v14, +004h
    iget v6, v5, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->appId I
    and-int/lit8 v14, v13, 2
    if-eqz v14, +004h
    iget-object v7, v5, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->appName Ljava/lang/String;
    move-object v14, v7
    and-int/lit8 v7, v13, 4
    if-eqz v7, +004h
    iget v8, v5, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->versionCode I
    move v0, v8
    and-int/lit8 v7, v13, 8
    if-eqz v7, +004h
    iget-object v9, v5, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->versionName Ljava/lang/String;
    move-object v1, v9
    and-int/lit8 v7, v13, 16
    if-eqz v7, +004h
    iget v10, v5, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->updateVersinCode I
    move v2, v10
    and-int/lit8 v7, v13, 32
    if-eqz v7, +004h
    iget-object v11, v5, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->channel Ljava/lang/String;
    move-object v3, v11
    and-int/lit8 v7, v13, 64
    if-eqz v7, +004h
    iget-boolean v12, v5, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->isBoe Z
    move v4, v12
    move-object v7, v5
    move v8, v6
    move-object v9, v14
    move v10, v0
    move-object v11, v1
    move v12, v2
    move-object v13, v3
    move v14, v4
    invoke-virtual/range v7 ... v14, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->copy(I Ljava/lang/String; I Ljava/lang/String; I Ljava/lang/String; Z)Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;
    move-result-object v5
    return-object v5
.end method

.method public final component1()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->appId I
    return v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->appName Ljava/lang/String;
    return-object v0
.end method

.method public final component3()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->versionCode I
    return v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->versionName Ljava/lang/String;
    return-object v0
.end method

.method public final component5()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->updateVersinCode I
    return v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->channel Ljava/lang/String;
    return-object v0
.end method

.method public final component7()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->isBoe Z
    return v0
.end method

.method public final copy(int  java.lang.String  int  java.lang.String  int  java.lang.String  boolean)com.bytedance.trae.applog.api.MultiInstanceAppLogInitConfig
    .registers 17
    # ins_size=8
    const-string v0, "appName"
    move-object v3, v11
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, versionName
    move-object v5, v13
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "channel"
    move-object v7, v15
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;
    move-object v1, v0
    move v2, v10
    move v4, v12
    move v6, v14
    move/from16 v8, v16
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;-><init>(I Ljava/lang/String; I Ljava/lang/String; I Ljava/lang/String; Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;
    iget v1, v4, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->appId I
    iget v3, v5, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->appId I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->appName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->appName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->versionCode I
    iget v3, v5, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->versionCode I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->versionName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->versionName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->updateVersinCode I
    iget v3, v5, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->updateVersinCode I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->channel Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->channel Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->isBoe Z
    iget-boolean v5, v5, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->isBoe Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getAppId()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->appId I
    return v0
.end method

.method public final getAppName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->appName Ljava/lang/String;
    return-object v0
.end method

.method public final getChannel()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->channel Ljava/lang/String;
    return-object v0
.end method

.method public final getUpdateVersinCode()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->updateVersinCode I
    return v0
.end method

.method public final getVersionCode()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->versionCode I
    return v0
.end method

.method public final getVersionName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->versionName Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget v0, v2, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->appId I
    invoke-static v0, Ljava/lang/Integer;->hashCode(I)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->appName Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->versionCode I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->versionName Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->updateVersinCode I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->channel Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->isBoe Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isBoe()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->isBoe Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "MultiInstanceAppLogInitConfig(appId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->appId I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", appName="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->appName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", versionCode="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->versionCode I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", versionName="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->versionName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", updateVersinCode="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->updateVersinCode I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", channel="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->channel Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isBoe="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->isBoe Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
