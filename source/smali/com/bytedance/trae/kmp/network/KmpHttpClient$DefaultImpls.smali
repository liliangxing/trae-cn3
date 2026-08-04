# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/network/KmpHttpClient$DefaultImpls;
.super Ljava/lang/Object;
.source "KmpHttpClient.kt"


.method public static synthetic getResult$default(com.bytedance.trae.kmp.network.KmpHttpClient  com.bytedance.trae.kmp.network.KmpHostType  java.lang.String  java.util.Map  java.util.Map  com.bytedance.trae.kmp.network.KmpHttpRequestOptions  kotlinx.serialization.DeserializationStrategy  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 25
    # ins_size=10
    if-nez v24, +03fh
    and-int/lit8 v0, v23, 4
    if-eqz v0, +008h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v0
    move-object v4, v0
    goto +3h
    move-object/from16 v4, v18
    and-int/lit8 v0, v23, 8
    if-eqz v0, +008h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v0
    move-object v5, v0
    goto +3h
    move-object/from16 v5, v19
    and-int/lit8 v0, v23, 16
    if-eqz v0, +013h
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v13, 31
    const/4 v14, 0
    move-object v6, v0
    move-object/from16 v12, v16
    invoke-direct/range v6 ... v14, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;-><init>(Ljava/lang/String; Z Z Z Lcom/bytedance/trae/kmp/network/KmpRequestAuth; Lcom/bytedance/trae/kmp/network/KmpHostType; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    goto +3h
    move-object/from16 v6, v20
    move-object v1, v15
    move-object/from16 v2, v16
    move-object/from16 v3, v17
    move-object/from16 v7, v21
    move-object/from16 v8, v22
    invoke-interface/range v1 ... v8, Lcom/bytedance/trae/kmp/network/KmpHttpClient;->getResult(Lcom/bytedance/trae/kmp/network/KmpHostType; Ljava/lang/String; Ljava/util/Map; Ljava/util/Map; Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions; Lkotlinx/serialization/DeserializationStrategy; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: getResult"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static synthetic postResult$default(com.bytedance.trae.kmp.network.KmpHttpClient  com.bytedance.trae.kmp.network.KmpHostType  java.lang.String  java.lang.String  java.lang.String  java.util.Map  com.bytedance.trae.kmp.network.KmpHttpRequestOptions  kotlinx.serialization.DeserializationStrategy  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 27
    # ins_size=11
    if-nez v26, +040h
    and-int/lit8 v0, v25, 8
    if-eqz v0, +006h
    const-string v0, "application/json; charset=UTF-8"
    move-object v5, v0
    goto +3h
    move-object/from16 v5, v20
    and-int/lit8 v0, v25, 16
    if-eqz v0, +008h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v0
    move-object v6, v0
    goto +3h
    move-object/from16 v6, v21
    and-int/lit8 v0, v25, 32
    if-eqz v0, +013h
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/16 v14, 31
    const/4 v15, 0
    move-object v7, v0
    move-object/from16 v13, v17
    invoke-direct/range v7 ... v15, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;-><init>(Ljava/lang/String; Z Z Z Lcom/bytedance/trae/kmp/network/KmpRequestAuth; Lcom/bytedance/trae/kmp/network/KmpHostType; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    goto +3h
    move-object/from16 v7, v22
    move-object/from16 v1, v16
    move-object/from16 v2, v17
    move-object/from16 v3, v18
    move-object/from16 v4, v19
    move-object/from16 v8, v23
    move-object/from16 v9, v24
    invoke-interface/range v1 ... v9, Lcom/bytedance/trae/kmp/network/KmpHttpClient;->postResult(Lcom/bytedance/trae/kmp/network/KmpHostType; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions; Lkotlinx/serialization/DeserializationStrategy; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: postResult"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method
