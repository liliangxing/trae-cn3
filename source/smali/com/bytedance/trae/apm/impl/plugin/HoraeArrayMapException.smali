# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public Lcom/bytedance/trae/apm/impl/plugin/HoraeArrayMapException;
.super Lcom/bytedance/platform/godzilla/plugin/UncaughtExceptionPlugin;
.source "HoraeArrayMapException.java"


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/platform/godzilla/plugin/UncaughtExceptionPlugin;-><init>()V
    return-void 
.end method

.method public consumeUncaughtException(java.lang.Thread  java.lang.Throwable)boolean
    .registers 10
    # ins_size=3
    instance-of v8, v9, Ljava/lang/ArrayIndexOutOfBoundsException;
    const/4 v0, 0
    if-nez v8, +003h
    return v0
    invoke-virtual v9, Ljava/lang/Throwable;->getStackTrace()[Ljava/lang/StackTraceElement;
    move-result-object v8
    array-length v9, v8
    move v1, v0
    if-ge v1, v9, +038h
    aget-object v2, v8, v1
    invoke-virtual v2, Ljava/lang/StackTraceElement;->getClassName()Ljava/lang/String;
    move-result-object v3
    const-string v4, "android.app.ActivityThread"
    invoke-virtual v4, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    const/4 v5, 1
    if-eqz v3, +00fh
    const-string v3, "handleTrimMemory"
    invoke-virtual v2, Ljava/lang/StackTraceElement;->getMethodName()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v3, v6, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    return v5
    invoke-virtual v2, Ljava/lang/StackTraceElement;->getClassName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v4, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +00fh
    const-string v3, "collectComponentCallbacks"
    invoke-virtual v2, Ljava/lang/StackTraceElement;->getMethodName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v3, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    return v5
    add-int/lit8 v1, v1, 1
    goto -37h
    return v0
.end method

.method public getName()java.lang.String
    .registers 2
    # ins_size=1
    const-string v0, "HoraeArrayMapException"
    return-object v0
.end method

.method public shouldEnableOpt()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 1
    return v0
.end method
