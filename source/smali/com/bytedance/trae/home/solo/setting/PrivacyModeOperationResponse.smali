# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationResponse;
.super Ljava/lang/Object;
.source "PrivacyModeApi.kt"

.field public static final $stable:I
.field private final code:J
.field private final message:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 7
    # ins_size=1
    const-wide/16 v1, 0
    const/4 v3, 0
    const/4 v4, 3
    const/4 v5, 0
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationResponse;-><init>(J Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(long  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationResponse;->code J
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationResponse;->message Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(long  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    const-wide/16 v1, 0
    and-int/lit8 v4, v4, 2
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationResponse;-><init>(J Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.PrivacyModeOperationResponse  long  java.lang.String  int  java.lang.Object)com.bytedance.trae.home.solo.setting.PrivacyModeOperationResponse
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationResponse;->code J
    and-int/lit8 v4, v4, 2
    if-eqz v4, +004h
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationResponse;->message Ljava/lang/String;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationResponse;->copy(J Ljava/lang/String;)Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationResponse;
    move-result-object v0
    return-object v0
.end method

.method public final component1()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationResponse;->code J
    return-wide v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationResponse;->message Ljava/lang/String;
    return-object v0
.end method

.method public final copy(long  java.lang.String)com.bytedance.trae.home.solo.setting.PrivacyModeOperationResponse
    .registers 5
    # ins_size=4
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationResponse;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationResponse;-><init>(J Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationResponse;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationResponse;
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationResponse;->code J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationResponse;->code J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationResponse;->message Ljava/lang/String;
    iget-object v8, v8, Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationResponse;->message Ljava/lang/String;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getCode()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationResponse;->code J
    return-wide v0
.end method

.method public final getMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationResponse;->message Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationResponse;->code J
    invoke-static v0, v1, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationResponse;->message Ljava/lang/String;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "PrivacyModeOperationResponse(code="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationResponse;->code J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", message="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationResponse;->message Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
