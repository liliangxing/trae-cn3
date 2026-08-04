# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/IListMessagesService$DefaultImpls;
.super Ljava/lang/Object;
.source "IListMessagesService.kt"


.method public static synthetic listMessagesByAnchorRaw$default(com.bytedance.trae.im.service.IListMessagesService  java.lang.String  java.lang.String  int  int  boolean  int  java.lang.Object  int  java.lang.Object)com.bytedance.retrofit2.Call
    .registers 19
    # ins_size=10
    if-nez v18, +017h
    and-int/lit8 v0, v17, 2
    if-eqz v0, +005h
    const/4 v0, 0
    move-object v3, v0
    goto +2h
    move-object v3, v11
    move-object v1, v9
    move-object v2, v10
    move v4, v12
    move v5, v13
    move v6, v14
    move v7, v15
    move-object/from16 v8, v16
    invoke-interface/range v1 ... v8, Lcom/bytedance/trae/im/service/IListMessagesService;->listMessagesByAnchorRaw(Ljava/lang/String; Ljava/lang/String; I I Z I Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    return-object v0
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: listMessagesByAnchorRaw"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method
