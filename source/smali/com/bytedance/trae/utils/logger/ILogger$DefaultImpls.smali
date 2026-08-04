# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/utils/logger/ILogger$DefaultImpls;
.super Ljava/lang/Object;
.source "ILogger.kt"


.method public static synthetic uploadALog$default(com.bytedance.trae.utils.logger.ILogger  java.lang.String  long  long  kotlin.jvm.functions.Function1  int  java.lang.Object)void
    .registers 16
    # ins_size=9
    if-nez v15, +010h
    and-int/lit8 v14, v14, 8
    if-eqz v14, +003h
    const/4 v13, 0
    move-object v6, v13
    move-object v0, v7
    move-object v1, v8
    move-wide v2, v9
    move-wide v4, v11
    invoke-interface/range v0 ... v6, Lcom/bytedance/trae/utils/logger/ILogger;->uploadALog(Ljava/lang/String; J J Lkotlin/jvm/functions/Function1;)V
    return-void 
    new-instance v7, Ljava/lang/UnsupportedOperationException;
    const-string v8, "Super calls with default arguments not supported in this target, function: uploadALog"
    invoke-direct v7, v8, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v7
.end method

.method public static synthetic uploadAllLog$default(com.bytedance.trae.utils.logger.ILogger  java.lang.String  kotlin.jvm.functions.Function1  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    if-nez v4, +00bh
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-interface v0, v1, v2, Lcom/bytedance/trae/utils/logger/ILogger;->uploadAllLog(Ljava/lang/String; Lkotlin/jvm/functions/Function1;)V
    return-void 
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: uploadAllLog"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static synthetic uploadAllLogV2$default(com.bytedance.trae.utils.logger.ILogger  java.lang.String  kotlin.jvm.functions.Function3  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    if-nez v4, +00bh
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-interface v0, v1, v2, Lcom/bytedance/trae/utils/logger/ILogger;->uploadAllLogV2(Ljava/lang/String; Lkotlin/jvm/functions/Function3;)V
    return-void 
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: uploadAllLogV2"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method
