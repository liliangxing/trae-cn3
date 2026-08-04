# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public Lcom/bytedance/trae/apm/impl/plugin/UnsupportedOperationExceptionPlugin;
.super Lcom/bytedance/platform/godzilla/plugin/UncaughtExceptionPlugin;
.source "UnsupportedOperationExceptionPlugin.java"


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/platform/godzilla/plugin/UncaughtExceptionPlugin;-><init>()V
    return-void 
.end method

.method public consumeUncaughtException(java.lang.Thread  java.lang.Throwable)boolean
    .registers 7
    # ins_size=3
    const/4 v5, 1
    const/4 v0, 0
    invoke-virtual v6, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v1
    instance-of v2, v6, Ljava/lang/UnsupportedOperationException;
    if-eqz v2, +021h
    invoke-static v1, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    goto +19h
    const-string v2, "This isn't a hierarchical URI"
    invoke-virtual v1, v2, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z
    move-result v1
    if-nez v1, +003h
    return v0
    invoke-virtual v4, Lcom/bytedance/trae/apm/impl/plugin/UnsupportedOperationExceptionPlugin;->getName()Ljava/lang/String;
    move-result-object v1
    const-string v2, "Hint UnsupportedOperationExceptionPlugin case ,fix it."
    invoke-static v1, v2, Lcom/bytedance/platform/godzilla/common/Logger;->e(Ljava/lang/String; Ljava/lang/String;)V
    const-string v1, "UnsupportedOperationExceptionPlugin"
    invoke-static v6, v1, Lcom/bytedance/services/apm/api/EnsureManager;->ensureNotReachHere(Ljava/lang/Throwable; Ljava/lang/String;)V
    return v5
    return v0
    move-exception v6
    invoke-virtual v4, Lcom/bytedance/trae/apm/impl/plugin/UnsupportedOperationExceptionPlugin;->getName()Ljava/lang/String;
    move-result-object v1
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v4, Lcom/bytedance/trae/apm/impl/plugin/UnsupportedOperationExceptionPlugin;->getName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, " error"
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    new-array v5, v5, [Ljava/lang/Object;
    invoke-virtual v6, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v6
    aput-object v6, v5, v0
    invoke-static v1, v2, v5, Lcom/bytedance/platform/godzilla/common/Logger;->e(Ljava/lang/String; Ljava/lang/String; [Ljava/lang/Object;)V
    return v0
    :try_start_0x2
.end method

.method public getName()java.lang.String
    .registers 2
    # ins_size=1
    const-string v0, "UnsupportedOperationExceptionPlugin"
    return-object v0
.end method

.method public shouldEnableOpt()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 1
    return v0
.end method
