# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/IListEventsService$DefaultImpls;
.super Ljava/lang/Object;
.source "IListEventsService.kt"


.method public static synthetic listEvents$default(com.bytedance.trae.im.service.IListEventsService  java.lang.String  java.lang.Integer  java.lang.Integer  int  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 15
    # ins_size=8
    if-nez v14, +01ah
    and-int/lit8 v14, v13, 2
    const/4 v0, 0
    if-eqz v14, +004h
    move-object v3, v0
    goto +2h
    move-object v3, v9
    and-int/lit8 v9, v13, 4
    if-eqz v9, +004h
    move-object v4, v0
    goto +2h
    move-object v4, v10
    move-object v1, v7
    move-object v2, v8
    move v5, v11
    move-object v6, v12
    invoke-interface/range v1 ... v6, Lcom/bytedance/trae/im/service/IListEventsService;->listEvents(Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer; I Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    return-object v7
    new-instance v7, Ljava/lang/UnsupportedOperationException;
    const-string v8, "Super calls with default arguments not supported in this target, function: listEvents"
    invoke-direct v7, v8, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v7
.end method
