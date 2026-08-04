# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public Lcom/bytedance/trae/apm/impl/plugin/CustomerExtensionPlugin;
.super Lcom/bytedance/platform/godzilla/plugin/UncaughtExceptionPlugin;
.source "CustomerExtensionPlugin.java"


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/platform/godzilla/plugin/UncaughtExceptionPlugin;-><init>()V
    return-void 
.end method

.method private isKillPkgException(java.lang.Throwable)boolean
    .registers 5
    # ins_size=2
    instance-of v0, v4, Ljava/lang/SecurityException;
    if-eqz v0, +02fh
    invoke-virtual v4, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/String;->trim()Ljava/lang/String;
    move-result-object v4
    const-string v0, "cannot kill pkg:"
    invoke-virtual v4, v0, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z
    move-result v4
    if-eqz v4, +01fh
    const/4 v4, 1
    return v4
    move-exception v4
    invoke-virtual v3, Lcom/bytedance/trae/apm/impl/plugin/CustomerExtensionPlugin;->getName()Ljava/lang/String;
    move-result-object v0
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "isKillPkgException error: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-static v0, v4, Lcom/bytedance/platform/godzilla/common/Logger;->e(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v4, 0
    return v4
    :try_start_0x0
.end method

.method private isRemoteServiceBadNotificationException(java.lang.Throwable)boolean
    .registers 5
    # ins_size=2
    invoke-virtual v4, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Class;->getName()Ljava/lang/String;
    move-result-object v0
    const-string v1, "android.app.RemoteServiceException"
    invoke-virtual v1, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +00ah
    const-string v1, "android.app.RemoteServiceException$CannotPostForegroundServiceNotificationException"
    invoke-virtual v1, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +02fh
    invoke-virtual v4, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/String;->trim()Ljava/lang/String;
    move-result-object v4
    const-string v0, "Bad notification"
    invoke-virtual v4, v0, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z
    move-result v4
    if-eqz v4, +01fh
    const/4 v4, 1
    return v4
    move-exception v4
    invoke-virtual v3, Lcom/bytedance/trae/apm/impl/plugin/CustomerExtensionPlugin;->getName()Ljava/lang/String;
    move-result-object v0
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "isRemoteServiceBadNotificationException error: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-static v0, v4, Lcom/bytedance/platform/godzilla/common/Logger;->e(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v4, 0
    return v4
    :try_start_0x0
.end method

.method public consumeUncaughtException(java.lang.Thread  java.lang.Throwable)boolean
    .registers 4
    # ins_size=3
    const/4 v2, 0
    if-nez v3, +003h
    return v2
    invoke-direct v1, v3, Lcom/bytedance/trae/apm/impl/plugin/CustomerExtensionPlugin;->isRemoteServiceBadNotificationException(Ljava/lang/Throwable;)Z
    move-result v0
    if-nez v0, +008h
    invoke-direct v1, v3, Lcom/bytedance/trae/apm/impl/plugin/CustomerExtensionPlugin;->isKillPkgException(Ljava/lang/Throwable;)Z
    move-result v3
    if-eqz v3, +003h
    const/4 v2, 1
    if-eqz v2, +00bh
    invoke-virtual v1, Lcom/bytedance/trae/apm/impl/plugin/CustomerExtensionPlugin;->getName()Ljava/lang/String;
    move-result-object v3
    const-string v0, "Hint CustomerExtensionPlugin case ,fix it."
    invoke-static v3, v0, Lcom/bytedance/platform/godzilla/common/Logger;->e(Ljava/lang/String; Ljava/lang/String;)V
    return v2
.end method

.method public getName()java.lang.String
    .registers 2
    # ins_size=1
    const-string v0, "CustomerExtensionPlugin"
    return-object v0
.end method

.method public shouldEnableOpt()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 1
    return v0
.end method
