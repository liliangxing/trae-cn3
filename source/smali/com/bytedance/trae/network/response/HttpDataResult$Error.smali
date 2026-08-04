# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/response/HttpDataResult$Error;
.super Lcom/bytedance/trae/network/response/HttpDataResult;
.source "HttpDataResult.kt"

.field private final code:I
.field private final errorBody:Ljava/lang/String;
.field private final msg:Ljava/lang/String;
.field private final throwable:Ljava/lang/Throwable;


.method public constructor <init>(int  java.lang.String  java.lang.Throwable  java.lang.String)void
    .registers 6
    # ins_size=5
    const-string v0, "msg"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/network/response/HttpDataResult;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput v2, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->code I
    iput-object v3, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->msg Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->throwable Ljava/lang/Throwable;
    iput-object v5, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->errorBody Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(int  java.lang.String  java.lang.Throwable  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=7
    and-int/lit8 v5, v5, 8
    if-eqz v5, +003h
    const/4 v4, 0
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.network.response.HttpDataResult$Error  int  java.lang.String  java.lang.Throwable  java.lang.String  int  java.lang.Object)com.bytedance.trae.network.response.HttpDataResult$Error
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget v1, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->code I
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->msg Ljava/lang/String;
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->throwable Ljava/lang/Throwable;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->errorBody Ljava/lang/String;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->copy(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String;)Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    move-result-object v0
    return-object v0
.end method

.method public final component1()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->code I
    return v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->msg Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.Throwable
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->throwable Ljava/lang/Throwable;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->errorBody Ljava/lang/String;
    return-object v0
.end method

.method public final copy(int  java.lang.String  java.lang.Throwable  java.lang.String)com.bytedance.trae.network.response.HttpDataResult$Error
    .registers 6
    # ins_size=5
    const-string v0, "msg"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    iget v1, v4, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->code I
    iget v3, v5, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->code I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->msg Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->msg Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->throwable Ljava/lang/Throwable;
    iget-object v3, v5, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->throwable Ljava/lang/Throwable;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->errorBody Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->errorBody Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getCode()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->code I
    return v0
.end method

.method public final getErrorBody()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->errorBody Ljava/lang/String;
    return-object v0
.end method

.method public final getMsg()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->msg Ljava/lang/String;
    return-object v0
.end method

.method public final getThrowable()java.lang.Throwable
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->throwable Ljava/lang/Throwable;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget v0, v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->code I
    invoke-static v0, Ljava/lang/Integer;->hashCode(I)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->msg Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->throwable Ljava/lang/Throwable;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Throwable;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->errorBody Ljava/lang/String;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Error(code="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->code I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", msg="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->msg Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", throwable="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->throwable Ljava/lang/Throwable;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", errorBody="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->errorBody Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
