# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;
.super Ljava/lang/Object;
.source "PrivacyModeApi.kt"

.field public static final $stable:I
.field private final code:J
.field private final message:Ljava/lang/String;
.field private final privacyStatus:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 8
    # ins_size=1
    const/4 v1, 0
    const-wide/16 v2, 0
    const/4 v4, 0
    const/4 v5, 7
    const/4 v6, 0
    move-object v0, v7
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;-><init>(Ljava/lang/String; J Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  long  java.lang.String)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;->privacyStatus Ljava/lang/String;
    iput-wide v2, v0, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;->code J
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;->message Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  long  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 1
    const/4 v0, 0
    if-eqz v7, +003h
    move-object v2, v0
    and-int/lit8 v7, v6, 2
    if-eqz v7, +004h
    const-wide/16 v3, 0
    and-int/lit8 v6, v6, 4
    if-eqz v6, +003h
    move-object v5, v0
    invoke-direct v1, v2, v3, v4, v5, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;-><init>(Ljava/lang/String; J Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.PrivacyModeQueryResponse  java.lang.String  long  java.lang.String  int  java.lang.Object)com.bytedance.trae.home.solo.setting.PrivacyModeQueryResponse
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;->privacyStatus Ljava/lang/String;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-wide v2, v0, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;->code J
    and-int/lit8 v5, v5, 4
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;->message Ljava/lang/String;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;->copy(Ljava/lang/String; J Ljava/lang/String;)Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;->privacyStatus Ljava/lang/String;
    return-object v0
.end method

.method public final component2()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;->code J
    return-wide v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;->message Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  long  java.lang.String)com.bytedance.trae.home.solo.setting.PrivacyModeQueryResponse
    .registers 6
    # ins_size=5
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;-><init>(Ljava/lang/String; J Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;->privacyStatus Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;->privacyStatus Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;->code J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;->code J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;->message Ljava/lang/String;
    iget-object v8, v8, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;->message Ljava/lang/String;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getCode()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;->code J
    return-wide v0
.end method

.method public final getMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;->message Ljava/lang/String;
    return-object v0
.end method

.method public final getPrivacyStatus()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;->privacyStatus Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;->privacyStatus Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;->code J
    invoke-static v2, v3, Ljava/lang/Long;->hashCode(J)I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v4, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;->message Ljava/lang/String;
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
    const-string v1, "PrivacyModeQueryResponse(privacyStatus="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;->privacyStatus Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", code="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;->code J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", message="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;->message Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
