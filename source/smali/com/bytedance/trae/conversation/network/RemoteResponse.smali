# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/RemoteResponse;
.super Ljava/lang/Object;
.source "RemoteResponse.kt"

.field private static final CODE_RISK_CONTROL:[J
.field public static final CODE_UNKNOWN:J
.field public static final Companion:Lcom/bytedance/trae/conversation/network/RemoteResponse$Companion;
.field private final code:J
.field private final data:Ljava/lang/Object;
.field private final msg:Ljava/lang/String;
.field private varargs ssResponse:Lcom/bytedance/retrofit2/SsResponse;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/network/RemoteResponse$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/network/RemoteResponse$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/network/RemoteResponse;->Companion Lcom/bytedance/trae/conversation/network/RemoteResponse$Companion;
    const/4 v0, 2
    new-array v0, v0, [J
    fill-array-data v0, +0000007h
    sput-object v0, Lcom/bytedance/trae/conversation/network/RemoteResponse;->CODE_RISK_CONTROL [J
    return-void 
    nop 
    fill-array-data-payload b'e\xecQ*\x00\x00\x00\x00u\xecQ*\x00\x00\x00\x00' | \x65\xec\x51\x2a\x00\x00\x00\x00\x75\xec\x51\x2a\x00\x00\x00\x00
.end method

.method public constructor <init>()void
    .registers 8
    # ins_size=1
    const-wide/16 v1, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 7
    const/4 v6, 0
    move-object v0, v7
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/network/RemoteResponse;-><init>(J Ljava/lang/String; Ljava/lang/Object; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(long  java.lang.String  java.lang.Object)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/network/RemoteResponse;->code J
    iput-object v3, v0, Lcom/bytedance/trae/conversation/network/RemoteResponse;->msg Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/network/RemoteResponse;->data Ljava/lang/Object;
    return-void 
.end method

.method public synthetic constructor <init>(long  java.lang.String  java.lang.Object  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    const-wide/16 v1, 0
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    const-string v3, ""
    and-int/lit8 v5, v5, 4
    if-eqz v5, +003h
    const/4 v4, 0
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/network/RemoteResponse;-><init>(J Ljava/lang/String; Ljava/lang/Object;)V
    return-void 
.end method

.method public static final synthetic access$getCODE_RISK_CONTROL$cp()long[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/network/RemoteResponse;->CODE_RISK_CONTROL [J
    return-object v0
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.network.RemoteResponse  long  java.lang.String  java.lang.Object  int  java.lang.Object)com.bytedance.trae.conversation.network.RemoteResponse
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-wide v1, v0, Lcom/bytedance/trae/conversation/network/RemoteResponse;->code J
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/network/RemoteResponse;->msg Ljava/lang/String;
    and-int/lit8 v5, v5, 4
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/network/RemoteResponse;->data Ljava/lang/Object;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/network/RemoteResponse;->copy(J Ljava/lang/String; Ljava/lang/Object;)Lcom/bytedance/trae/conversation/network/RemoteResponse;
    move-result-object v0
    return-object v0
.end method

.method public final component1()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/network/RemoteResponse;->code J
    return-wide v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteResponse;->msg Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteResponse;->data Ljava/lang/Object;
    return-object v0
.end method

.method public final copy(long  java.lang.String  java.lang.Object)com.bytedance.trae.conversation.network.RemoteResponse
    .registers 6
    # ins_size=5
    new-instance v0, Lcom/bytedance/trae/conversation/network/RemoteResponse;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/network/RemoteResponse;-><init>(J Ljava/lang/String; Ljava/lang/Object;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/network/RemoteResponse;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/network/RemoteResponse;
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/network/RemoteResponse;->code J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/network/RemoteResponse;->code J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/network/RemoteResponse;->msg Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/network/RemoteResponse;->msg Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/network/RemoteResponse;->data Ljava/lang/Object;
    iget-object v8, v8, Lcom/bytedance/trae/conversation/network/RemoteResponse;->data Ljava/lang/Object;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getCode()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/network/RemoteResponse;->code J
    return-wide v0
.end method

.method public final getData()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteResponse;->data Ljava/lang/Object;
    return-object v0
.end method

.method public final getMsg()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteResponse;->msg Ljava/lang/String;
    return-object v0
.end method

.method public final getSSResponse()com.bytedance.retrofit2.SsResponse
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/RemoteResponse;->ssResponse Lcom/bytedance/retrofit2/SsResponse;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-wide v0, v3, Lcom/bytedance/trae/conversation/network/RemoteResponse;->code J
    invoke-static v0, v1, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/RemoteResponse;->msg Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/RemoteResponse;->data Ljava/lang/Object;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public final isSuccess()boolean
    .registers 5
    # ins_size=1
    iget-wide v0, v4, Lcom/bytedance/trae/conversation/network/RemoteResponse;->code J
    const-wide/16 v2, 0
    cmp-long v0, v0, v2
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method public final setupSSResponse(com.bytedance.retrofit2.SsResponse)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, ssResponse
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/network/RemoteResponse;->ssResponse Lcom/bytedance/retrofit2/SsResponse;
    return-void 
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "RemoteResponse(code="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/network/RemoteResponse;->code J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", msg="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/RemoteResponse;->msg Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", data="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/RemoteResponse;->data Ljava/lang/Object;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
