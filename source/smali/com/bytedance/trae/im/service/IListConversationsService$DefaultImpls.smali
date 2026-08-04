# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/IListConversationsService$DefaultImpls;
.super Ljava/lang/Object;
.source "IListConversationsService.kt"


.method public static synthetic listConversations$default(com.bytedance.trae.im.service.IListConversationsService  int  int  java.lang.String  java.lang.String  boolean  java.lang.Integer  java.lang.Integer  java.lang.String  java.util.List  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 26
    # ins_size=13
    move/from16 v0, v24
    if-nez v25, +064h
    and-int/lit8 v1, v0, 1
    if-eqz v1, +006h
    const/16 v1, 300
    move v3, v1
    goto +2h
    move v3, v14
    and-int/lit8 v1, v0, 2
    if-eqz v1, +005h
    const/4 v1, 0
    move v4, v1
    goto +2h
    move v4, v15
    and-int/lit8 v1, v0, 4
    if-eqz v1, +007h
    const-string/jumbo v1, updated_at
    move-object v5, v1
    goto +3h
    move-object/from16 v5, v16
    and-int/lit8 v1, v0, 8
    if-eqz v1, +006h
    const-string v1, "desc"
    move-object v6, v1
    goto +3h
    move-object/from16 v6, v17
    and-int/lit8 v1, v0, 16
    const/4 v2, 1
    if-eqz v1, +004h
    move v7, v2
    goto +3h
    move/from16 v7, v18
    and-int/lit8 v1, v0, 32
    if-eqz v1, +008h
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    move-object v8, v1
    goto +3h
    move-object/from16 v8, v19
    and-int/lit8 v1, v0, 64
    if-eqz v1, +008h
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    move-object v9, v1
    goto +3h
    move-object/from16 v9, v20
    and-int/lit16 v1, v0, 128
    if-eqz v1, +006h
    const-string v1, ""
    move-object v10, v1
    goto +3h
    move-object/from16 v10, v21
    and-int/lit16 v0, v0, 256
    if-eqz v0, +005h
    const/4 v0, 0
    move-object v11, v0
    goto +3h
    move-object/from16 v11, v22
    move-object v2, v13
    move-object/from16 v12, v23
    invoke-interface/range v2 ... v12, Lcom/bytedance/trae/im/service/IListConversationsService;->listConversations(I I Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/String; Ljava/util/List; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: listConversations"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static synthetic listConversationsRaw$default(com.bytedance.trae.im.service.IListConversationsService  int  int  java.lang.String  java.lang.String  boolean  java.lang.Integer  java.lang.Integer  java.lang.String  java.util.List  java.lang.Object  int  java.lang.Object)com.bytedance.retrofit2.Call
    .registers 24
    # ins_size=13
    move/from16 v0, v22
    if-nez v23, +06fh
    and-int/lit8 v1, v0, 1
    if-eqz v1, +005h
    const/16 v1, 300
    goto +2h
    move v1, v12
    and-int/lit8 v2, v0, 2
    if-eqz v2, +004h
    const/4 v2, 0
    goto +2h
    move v2, v13
    and-int/lit8 v3, v0, 4
    if-eqz v3, +006h
    const-string/jumbo v3, updated_at
    goto +2h
    move-object v3, v14
    and-int/lit8 v4, v0, 8
    if-eqz v4, +005h
    const-string v4, "desc"
    goto +2h
    move-object v4, v15
    and-int/lit8 v5, v0, 16
    const/4 v6, 1
    if-eqz v5, +004h
    move v5, v6
    goto +3h
    move/from16 v5, v16
    and-int/lit8 v7, v0, 32
    if-eqz v7, +007h
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    goto +3h
    move-object/from16 v7, v17
    and-int/lit8 v8, v0, 64
    if-eqz v8, +007h
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    goto +3h
    move-object/from16 v6, v18
    and-int/lit16 v8, v0, 128
    if-eqz v8, +005h
    const-string v8, ""
    goto +3h
    move-object/from16 v8, v19
    and-int/lit16 v9, v0, 256
    const/4 v10, 0
    if-eqz v9, +004h
    move-object v9, v10
    goto +3h
    move-object/from16 v9, v20
    and-int/lit16 v0, v0, 512
    if-eqz v0, +003h
    goto +3h
    move-object/from16 v10, v21
    move v12, v1
    move v13, v2
    move-object v14, v3
    move-object v15, v4
    move/from16 v16, v5
    move-object/from16 v17, v7
    move-object/from16 v18, v6
    move-object/from16 v19, v8
    move-object/from16 v20, v9
    move-object/from16 v21, v10
    invoke-interface/range v11 ... v21, Lcom/bytedance/trae/im/service/IListConversationsService;->listConversationsRaw(I I Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/String; Ljava/util/List; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    return-object v0
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: listConversationsRaw"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static synthetic searchConversationsRaw$default(com.bytedance.trae.im.service.IListConversationsService  java.lang.String  int  int  long  long  java.lang.Object  int  java.lang.Object)com.bytedance.retrofit2.Call
    .registers 21
    # ins_size=11
    if-nez v20, +02dh
    and-int/lit8 v0, v19, 2
    if-eqz v0, +006h
    const/16 v0, 20
    move v3, v0
    goto +2h
    move v3, v12
    and-int/lit8 v0, v19, 4
    if-eqz v0, +005h
    const/4 v0, 0
    move v4, v0
    goto +2h
    move v4, v13
    and-int/lit8 v0, v19, 8
    const-wide/16 v1, 0
    if-eqz v0, +004h
    move-wide v5, v1
    goto +2h
    move-wide v5, v14
    and-int/lit8 v0, v19, 16
    if-eqz v0, +004h
    move-wide v7, v1
    goto +3h
    move-wide/from16 v7, v16
    move-object v1, v10
    move-object v2, v11
    move-object/from16 v9, v18
    invoke-interface/range v1 ... v9, Lcom/bytedance/trae/im/service/IListConversationsService;->searchConversationsRaw(Ljava/lang/String; I I J J Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    return-object v0
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: searchConversationsRaw"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method
