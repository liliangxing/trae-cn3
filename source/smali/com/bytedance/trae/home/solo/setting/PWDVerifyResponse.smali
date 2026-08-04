# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;
.super Ljava/lang/Object;
.source "AccountCancelApi.kt"

.field public static final $stable:I
.field private final data:Lcom/bytedance/trae/home/solo/setting/VerifyTicketData;
.field private final description:Ljava/lang/String;
.field private final errorCode:I
.field private final message:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

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
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;-><init>(I Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/VerifyTicketData; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(int  java.lang.String  java.lang.String  com.bytedance.trae.home.solo.setting.VerifyTicketData)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->errorCode I
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->message Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->description Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->data Lcom/bytedance/trae/home/solo/setting/VerifyTicketData;
    return-void 
.end method

.method public synthetic constructor <init>(int  java.lang.String  java.lang.String  com.bytedance.trae.home.solo.setting.VerifyTicketData  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 1
    if-eqz v7, +003h
    const/4 v2, 0
    and-int/lit8 v7, v6, 2
    const/4 v0, 0
    if-eqz v7, +003h
    move-object v3, v0
    and-int/lit8 v7, v6, 4
    if-eqz v7, +003h
    move-object v4, v0
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    move-object v5, v0
    invoke-direct v1, v2, v3, v4, v5, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;-><init>(I Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/VerifyTicketData;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.PWDVerifyResponse  int  java.lang.String  java.lang.String  com.bytedance.trae.home.solo.setting.VerifyTicketData  int  java.lang.Object)com.bytedance.trae.home.solo.setting.PWDVerifyResponse
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget v1, v0, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->errorCode I
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->message Ljava/lang/String;
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->description Ljava/lang/String;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->data Lcom/bytedance/trae/home/solo/setting/VerifyTicketData;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->copy(I Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/VerifyTicketData;)Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;
    move-result-object v0
    return-object v0
.end method

.method public final component1()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->errorCode I
    return v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->message Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->description Ljava/lang/String;
    return-object v0
.end method

.method public final component4()com.bytedance.trae.home.solo.setting.VerifyTicketData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->data Lcom/bytedance/trae/home/solo/setting/VerifyTicketData;
    return-object v0
.end method

.method public final copy(int  java.lang.String  java.lang.String  com.bytedance.trae.home.solo.setting.VerifyTicketData)com.bytedance.trae.home.solo.setting.PWDVerifyResponse
    .registers 6
    # ins_size=5
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;-><init>(I Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/VerifyTicketData;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;
    iget v1, v4, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->errorCode I
    iget v3, v5, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->errorCode I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->message Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->message Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->description Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->description Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->data Lcom/bytedance/trae/home/solo/setting/VerifyTicketData;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->data Lcom/bytedance/trae/home/solo/setting/VerifyTicketData;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getData()com.bytedance.trae.home.solo.setting.VerifyTicketData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->data Lcom/bytedance/trae/home/solo/setting/VerifyTicketData;
    return-object v0
.end method

.method public final getDescription()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->description Ljava/lang/String;
    return-object v0
.end method

.method public final getErrorCode()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->errorCode I
    return v0
.end method

.method public final getMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->message Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget v0, v3, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->errorCode I
    invoke-static v0, Ljava/lang/Integer;->hashCode(I)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->message Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->description Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->data Lcom/bytedance/trae/home/solo/setting/VerifyTicketData;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/VerifyTicketData;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "PWDVerifyResponse(errorCode="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->errorCode I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", message="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->message Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", description="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->description Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", data="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;->data Lcom/bytedance/trae/home/solo/setting/VerifyTicketData;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
