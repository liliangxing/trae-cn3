# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/HubNetFallbackApi$DefaultImpls;
.super Ljava/lang/Object;
.source "HubNetFallbackApi.kt"


.method public static synthetic poll$default(com.bytedance.trae.network.HubNetFallbackApi  long  java.lang.String  java.lang.Long  java.lang.Integer  int  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 19
    # ins_size=10
    if-nez v18, +022h
    and-int/lit8 v0, v17, 4
    if-eqz v0, +005h
    const/4 v0, 0
    move-object v5, v0
    goto +2h
    move-object v5, v13
    and-int/lit8 v0, v17, 8
    if-eqz v0, +00ah
    const/16 v0, 20
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    move-object v6, v0
    goto +2h
    move-object v6, v14
    move-object v1, v9
    move-wide v2, v10
    move-object v4, v12
    move v7, v15
    move-object/from16 v8, v16
    invoke-interface/range v1 ... v8, Lcom/bytedance/trae/network/HubNetFallbackApi;->poll(J Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Integer; I Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: poll"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method
