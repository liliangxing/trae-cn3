# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/response/BizResponse;
.super Ljava/lang/Object;
.source "BizResponse.kt"

.field private static final CODE_RISK_CONTROL:[J
.field public static final CODE_UNKNOWN:J
.field public static final Companion:Lcom/bytedance/trae/network/response/BizResponse$Companion;
.field private static final DEFAULT_SUCCESS_CODES:Ljava/util/Set;
.field private final activityMessage:Ljava/lang/String;
.field private final code:J
.field private final data:Ljava/lang/Object;
.field private final message:Ljava/lang/String;
.field private final msg:Ljava/lang/String;
.field private final payload:Ljava/lang/String;
.field private varargs ssResponse:Lcom/bytedance/retrofit2/SsResponse;
.field private varargs successCodes:Ljava/util/Set;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/response/BizResponse$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/network/response/BizResponse$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/network/response/BizResponse;->Companion Lcom/bytedance/trae/network/response/BizResponse$Companion;
    const/4 v0, 2
    new-array v0, v0, [J
    fill-array-data v0, +0000013h
    sput-object v0, Lcom/bytedance/trae/network/response/BizResponse;->CODE_RISK_CONTROL [J
    const-wide/16 v0, 0
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf(Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/response/BizResponse;->DEFAULT_SUCCESS_CODES Ljava/util/Set;
    return-void 
    nop 
    fill-array-data-payload b'e\xecQ*\x00\x00\x00\x00u\xecQ*\x00\x00\x00\x00' | \x65\xec\x51\x2a\x00\x00\x00\x00\x75\xec\x51\x2a\x00\x00\x00\x00
.end method

.method public constructor <init>()void
    .registers 11
    # ins_size=1
    const-wide/16 v1, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 63
    const/4 v9, 0
    move-object v0, v10
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/network/response/BizResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(long  java.lang.String  java.lang.String  java.lang.String  java.lang.Object  java.lang.String)void
    .registers 8
    # ins_size=8
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-wide v1, v0, Lcom/bytedance/trae/network/response/BizResponse;->code J
    iput-object v3, v0, Lcom/bytedance/trae/network/response/BizResponse;->msg Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/network/response/BizResponse;->message Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/network/response/BizResponse;->payload Ljava/lang/String;
    iput-object v6, v0, Lcom/bytedance/trae/network/response/BizResponse;->data Ljava/lang/Object;
    iput-object v7, v0, Lcom/bytedance/trae/network/response/BizResponse;->activityMessage Ljava/lang/String;
    sget-object v1, Lcom/bytedance/trae/network/response/BizResponse;->DEFAULT_SUCCESS_CODES Ljava/util/Set;
    iput-object v1, v0, Lcom/bytedance/trae/network/response/BizResponse;->successCodes Ljava/util/Set;
    return-void 
.end method

.method public synthetic constructor <init>(long  java.lang.String  java.lang.String  java.lang.String  java.lang.Object  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 18
    # ins_size=10
    and-int/lit8 v0, v16, 1
    if-eqz v0, +005h
    const-wide/16 v0, 0
    goto +2h
    move-wide v0, v9
    and-int/lit8 v2, v16, 2
    const-string v3, ""
    if-eqz v2, +004h
    move-object v2, v3
    goto +2h
    move-object v2, v11
    and-int/lit8 v4, v16, 4
    if-eqz v4, +004h
    move-object v4, v3
    goto +2h
    move-object v4, v12
    and-int/lit8 v5, v16, 8
    if-eqz v5, +003h
    goto +2h
    move-object v3, v13
    and-int/lit8 v5, v16, 16
    const/4 v6, 0
    if-eqz v5, +004h
    move-object v5, v6
    goto +2h
    move-object v5, v14
    and-int/lit8 v7, v16, 32
    if-eqz v7, +003h
    goto +2h
    move-object v6, v15
    move-object v9, v8
    move-wide v10, v0
    move-object v12, v2
    move-object v13, v4
    move-object v14, v3
    move-object v15, v5
    move-object/from16 v16, v6
    invoke-direct/range v9 ... v16, Lcom/bytedance/trae/network/response/BizResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$getCODE_RISK_CONTROL$cp()long[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/response/BizResponse;->CODE_RISK_CONTROL [J
    return-object v0
.end method

.method public static final synthetic access$getDEFAULT_SUCCESS_CODES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/response/BizResponse;->DEFAULT_SUCCESS_CODES Ljava/util/Set;
    return-object v0
.end method

.method public static synthetic copy$default(com.bytedance.trae.network.response.BizResponse  long  java.lang.String  java.lang.String  java.lang.String  java.lang.Object  java.lang.String  int  java.lang.Object)com.bytedance.trae.network.response.BizResponse
    .registers 18
    # ins_size=10
    move-object v0, v8
    and-int/lit8 v1, v16, 1
    if-eqz v1, +005h
    iget-wide v1, v0, Lcom/bytedance/trae/network/response/BizResponse;->code J
    goto +2h
    move-wide v1, v9
    and-int/lit8 v3, v16, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/network/response/BizResponse;->msg Ljava/lang/String;
    goto +2h
    move-object v3, v11
    and-int/lit8 v4, v16, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/network/response/BizResponse;->message Ljava/lang/String;
    goto +2h
    move-object v4, v12
    and-int/lit8 v5, v16, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/network/response/BizResponse;->payload Ljava/lang/String;
    goto +2h
    move-object v5, v13
    and-int/lit8 v6, v16, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/network/response/BizResponse;->data Ljava/lang/Object;
    goto +2h
    move-object v6, v14
    and-int/lit8 v7, v16, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/network/response/BizResponse;->activityMessage Ljava/lang/String;
    goto +2h
    move-object v7, v15
    move-wide v9, v1
    move-object v11, v3
    move-object v12, v4
    move-object v13, v5
    move-object v14, v6
    move-object v15, v7
    invoke-virtual/range v8 ... v15, Lcom/bytedance/trae/network/response/BizResponse;->copy(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String;)Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    return-object v0
.end method

.method public final component1()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/network/response/BizResponse;->code J
    return-wide v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/response/BizResponse;->msg Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/response/BizResponse;->message Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/response/BizResponse;->payload Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/response/BizResponse;->data Ljava/lang/Object;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/response/BizResponse;->activityMessage Ljava/lang/String;
    return-object v0
.end method

.method public final copy(long  java.lang.String  java.lang.String  java.lang.String  java.lang.Object  java.lang.String)com.bytedance.trae.network.response.BizResponse
    .registers 17
    # ins_size=8
    new-instance v8, Lcom/bytedance/trae/network/response/BizResponse;
    move-object v0, v8
    move-wide v1, v10
    move-object v3, v12
    move-object v4, v13
    move-object v5, v14
    move-object v6, v15
    move-object/from16 v7, v16
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/network/response/BizResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String;)V
    return-object v8
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/network/response/BizResponse;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/network/response/BizResponse;
    iget-wide v3, v7, Lcom/bytedance/trae/network/response/BizResponse;->code J
    iget-wide v5, v8, Lcom/bytedance/trae/network/response/BizResponse;->code J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/network/response/BizResponse;->msg Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/network/response/BizResponse;->msg Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/network/response/BizResponse;->message Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/network/response/BizResponse;->message Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/network/response/BizResponse;->payload Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/network/response/BizResponse;->payload Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/network/response/BizResponse;->data Ljava/lang/Object;
    iget-object v3, v8, Lcom/bytedance/trae/network/response/BizResponse;->data Ljava/lang/Object;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/network/response/BizResponse;->activityMessage Ljava/lang/String;
    iget-object v8, v8, Lcom/bytedance/trae/network/response/BizResponse;->activityMessage Ljava/lang/String;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getActivityMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/response/BizResponse;->activityMessage Ljava/lang/String;
    return-object v0
.end method

.method public final getCode()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/network/response/BizResponse;->code J
    return-wide v0
.end method

.method public final getData()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/response/BizResponse;->data Ljava/lang/Object;
    return-object v0
.end method

.method public final getMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/response/BizResponse;->message Ljava/lang/String;
    return-object v0
.end method

.method public final getMsg()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/response/BizResponse;->msg Ljava/lang/String;
    return-object v0
.end method

.method public final getPayload()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/response/BizResponse;->payload Ljava/lang/String;
    return-object v0
.end method

.method public final getSSResponse()com.bytedance.retrofit2.SsResponse
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/response/BizResponse;->ssResponse Lcom/bytedance/retrofit2/SsResponse;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-wide v0, v3, Lcom/bytedance/trae/network/response/BizResponse;->code J
    invoke-static v0, v1, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/network/response/BizResponse;->msg Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/network/response/BizResponse;->message Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/network/response/BizResponse;->payload Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/network/response/BizResponse;->data Ljava/lang/Object;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/network/response/BizResponse;->activityMessage Ljava/lang/String;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public final isSuccess()boolean
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/network/response/BizResponse;->successCodes Ljava/util/Set;
    iget-wide v1, v3, Lcom/bytedance/trae/network/response/BizResponse;->code J
    invoke-static v1, v2, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    return v0
.end method

.method public final setupSSResponse(com.bytedance.retrofit2.SsResponse)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, ssResponse
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/network/response/BizResponse;->ssResponse Lcom/bytedance/retrofit2/SsResponse;
    return-void 
.end method

.method public final setupSuccessCodes(java.util.Set)void
    .registers 3
    # ins_size=2
    const-string v0, "codes"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +004h
    sget-object v2, Lcom/bytedance/trae/network/response/BizResponse;->DEFAULT_SUCCESS_CODES Ljava/util/Set;
    check-cast v2, Ljava/util/Set;
    iput-object v2, v1, Lcom/bytedance/trae/network/response/BizResponse;->successCodes Ljava/util/Set;
    return-void 
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "BizResponse(code="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v3, Lcom/bytedance/trae/network/response/BizResponse;->code J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", msg="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/network/response/BizResponse;->msg Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", message="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/network/response/BizResponse;->message Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", payload="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/network/response/BizResponse;->payload Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", data="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/network/response/BizResponse;->data Ljava/lang/Object;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", activityMessage="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/network/response/BizResponse;->activityMessage Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
