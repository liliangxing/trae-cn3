# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/IListClisService$DefaultImpls;
.super Ljava/lang/Object;
.source "IListClisService.kt"


.method public static synthetic listClis$default(com.bytedance.trae.im.service.IListClisService  java.lang.String  int  int  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=7
    if-nez v6, +01ch
    and-int/lit8 v6, v5, 1
    if-eqz v6, +008h
    sget-object v1, Lcom/bytedance/trae/im/service/CliListSource;->REGISTERED Lcom/bytedance/trae/im/service/CliListSource;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/CliListSource;->getValue()Ljava/lang/String;
    move-result-object v1
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    const/16 v2, 100
    and-int/lit8 v5, v5, 4
    if-eqz v5, +003h
    const/4 v3, 0
    invoke-interface v0, v1, v2, v3, v4, Lcom/bytedance/trae/im/service/IListClisService;->listClis(Ljava/lang/String; I I Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: listClis"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method
