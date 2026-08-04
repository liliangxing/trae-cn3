# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;
.super Ljava/lang/Object;
.source "AccountCancelApi.kt"

.field public static final $stable:I
.field private final authType:I
.field private final oauthPlatforms:Ljava/util/List;
.field private final platformUserNames:Ljava/util/Map;
.field private final userType:I
.field private final valueTicket:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 9
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/16 v6, 31
    const/4 v7, 0
    move-object v0, v8
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;-><init>(I I Ljava/lang/String; Ljava/util/List; Ljava/util/Map; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(int  int  java.lang.String  java.util.List  java.util.Map)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->userType I
    iput v2, v0, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->authType I
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->valueTicket Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->oauthPlatforms Ljava/util/List;
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->platformUserNames Ljava/util/Map;
    return-void 
.end method

.method public synthetic constructor <init>(int  int  java.lang.String  java.util.List  java.util.Map  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    const/4 v0, 0
    if-eqz v10, +004h
    move v10, v0
    goto +2h
    move v10, v4
    and-int/lit8 v4, v9, 2
    if-eqz v4, +003h
    goto +2h
    move v0, v5
    and-int/lit8 v4, v9, 4
    const/4 v5, 0
    if-eqz v4, +004h
    move-object v1, v5
    goto +2h
    move-object v1, v6
    and-int/lit8 v4, v9, 8
    if-eqz v4, +004h
    move-object v2, v5
    goto +2h
    move-object v2, v7
    and-int/lit8 v4, v9, 16
    if-eqz v4, +004h
    move-object v9, v5
    goto +2h
    move-object v9, v8
    move-object v4, v3
    move v5, v10
    move v6, v0
    move-object v7, v1
    move-object v8, v2
    invoke-direct/range v4 ... v9, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;-><init>(I I Ljava/lang/String; Ljava/util/List; Ljava/util/Map;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.CancelUserCheckData  int  int  java.lang.String  java.util.List  java.util.Map  int  java.lang.Object)com.bytedance.trae.home.solo.setting.CancelUserCheckData
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    if-eqz v10, +004h
    iget v4, v3, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->userType I
    and-int/lit8 v10, v9, 2
    if-eqz v10, +004h
    iget v5, v3, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->authType I
    move v10, v5
    and-int/lit8 v5, v9, 4
    if-eqz v5, +004h
    iget-object v6, v3, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->valueTicket Ljava/lang/String;
    move-object v0, v6
    and-int/lit8 v5, v9, 8
    if-eqz v5, +004h
    iget-object v7, v3, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->oauthPlatforms Ljava/util/List;
    move-object v1, v7
    and-int/lit8 v5, v9, 16
    if-eqz v5, +004h
    iget-object v8, v3, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->platformUserNames Ljava/util/Map;
    move-object v2, v8
    move-object v5, v3
    move v6, v4
    move v7, v10
    move-object v8, v0
    move-object v9, v1
    move-object v10, v2
    invoke-virtual/range v5 ... v10, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->copy(I I Ljava/lang/String; Ljava/util/List; Ljava/util/Map;)Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;
    move-result-object v3
    return-object v3
.end method

.method public final component1()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->userType I
    return v0
.end method

.method public final component2()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->authType I
    return v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->valueTicket Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->oauthPlatforms Ljava/util/List;
    return-object v0
.end method

.method public final component5()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->platformUserNames Ljava/util/Map;
    return-object v0
.end method

.method public final copy(int  int  java.lang.String  java.util.List  java.util.Map)com.bytedance.trae.home.solo.setting.CancelUserCheckData
    .registers 13
    # ins_size=6
    new-instance v6, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;
    move-object v0, v6
    move v1, v8
    move v2, v9
    move-object v3, v10
    move-object v4, v11
    move-object v5, v12
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;-><init>(I I Ljava/lang/String; Ljava/util/List; Ljava/util/Map;)V
    return-object v6
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;
    iget v1, v4, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->userType I
    iget v3, v5, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->userType I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->authType I
    iget v3, v5, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->authType I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->valueTicket Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->valueTicket Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->oauthPlatforms Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->oauthPlatforms Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->platformUserNames Ljava/util/Map;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->platformUserNames Ljava/util/Map;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getAuthType()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->authType I
    return v0
.end method

.method public final getOauthPlatforms()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->oauthPlatforms Ljava/util/List;
    return-object v0
.end method

.method public final getPlatformUserNames()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->platformUserNames Ljava/util/Map;
    return-object v0
.end method

.method public final getUserType()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->userType I
    return v0
.end method

.method public final getValueTicket()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->valueTicket Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget v0, v3, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->userType I
    invoke-static v0, Ljava/lang/Integer;->hashCode(I)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->authType I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->valueTicket Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->oauthPlatforms Ljava/util/List;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->platformUserNames Ljava/util/Map;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "CancelUserCheckData(userType="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->userType I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", authType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->authType I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", valueTicket="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->valueTicket Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", oauthPlatforms="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->oauthPlatforms Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", platformUserNames="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->platformUserNames Ljava/util/Map;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
