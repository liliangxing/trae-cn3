# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public abstract Lcom/bytedance/trae/network/response/HttpDataResult;
.super Ljava/lang/Object;
.source "HttpDataResult.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/network/response/HttpDataResult;-><init>()V
    return-void 
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    instance-of v0, v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const/16 v1, 93
    if-eqz v0, +016h
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v2, "Success["
    invoke-direct v0, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    goto +18h
    instance-of v0, v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v0, +016h
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v2, "Error["
    invoke-direct v0, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
.end method
