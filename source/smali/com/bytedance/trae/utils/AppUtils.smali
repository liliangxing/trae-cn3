# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public Lcom/bytedance/trae/utils/AppUtils;
.super Ljava/lang/Object;
.source "AppUtils.java"

.field public static sProcessName:Ljava/lang/String;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static getApplication(android.content.Context)android.app.Application
    .registers 2
    # ins_size=1
    if-nez v1, +004h
    const/4 v1, 0
    return-object v1
    instance-of v0, v1, Landroid/app/Application;
    if-eqz v0, +003h
    goto +5h
    invoke-virtual v1, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    move-result-object v1
    check-cast v1, Landroid/app/Application;
    return-object v1
.end method

.method public static getCurrentProcessName()java.lang.String
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/AppUtils;->sProcessName Ljava/lang/String;
    invoke-static v0, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +00ch
    invoke-static Landroid/os/Process;->myPid()I
    move-result v0
    invoke-static v0, Lcom/bytedance/trae/utils/AppUtils;->getProcessName(I)Ljava/lang/String;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/utils/AppUtils;->sProcessName Ljava/lang/String;
    sget-object v0, Lcom/bytedance/trae/utils/AppUtils;->sProcessName Ljava/lang/String;
    return-object v0
.end method

.method public static getProcessName(int)java.lang.String
    .registers 6
    # ins_size=1
    const-string v0, "/proc/"
    sget-object v1, Lcom/bytedance/trae/utils/AppUtils;->sProcessName Ljava/lang/String;
    invoke-static v1, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v1
    if-nez v1, +005h
    sget-object v5, Lcom/bytedance/trae/utils/AppUtils;->sProcessName Ljava/lang/String;
    return-object v5
    const/4 v1, 0
    new-instance v2, Ljava/io/BufferedReader;
    new-instance v3, Ljava/io/FileReader;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v0, "/cmdline"
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-direct v3, v5, Ljava/io/FileReader;-><init>(Ljava/lang/String;)V
    invoke-direct v2, v3, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    invoke-virtual v2, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;
    move-result-object v5
    invoke-static v5, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v0
    if-nez v0, +006h
    invoke-virtual v5, Ljava/lang/String;->trim()Ljava/lang/String;
    move-result-object v5
    sput-object v5, Lcom/bytedance/trae/utils/AppUtils;->sProcessName Ljava/lang/String;
    invoke-virtual v2, Ljava/io/BufferedReader;->close()V
    goto +5h
    move-exception v0
    invoke-virtual v0, Ljava/io/IOException;->printStackTrace()V
    return-object v5
    move-exception v5
    goto +3h
    move-exception v5
    move-object v2, v1
    invoke-virtual v5, Ljava/lang/Throwable;->printStackTrace()V
    if-eqz v2, +00ah
    invoke-virtual v2, Ljava/io/BufferedReader;->close()V
    goto +5h
    move-exception v5
    invoke-virtual v5, Ljava/io/IOException;->printStackTrace()V
    return-object v1
    move-exception v5
    if-eqz v2, +00ah
    invoke-virtual v2, Ljava/io/BufferedReader;->close()V
    goto +5h
    move-exception v0
    invoke-virtual v0, Ljava/io/IOException;->printStackTrace()V
    throw v5
    :try_start_0xe
    :try_start_0x2b
    :try_start_0x3b
    :try_start_0x48
    :try_start_0x4d
    :try_start_0x59
.end method

.method public static isMainProcess(android.content.Context)boolean
    .registers 4
    # ins_size=1
    invoke-static Landroid/os/Process;->myPid()I
    move-result v0
    invoke-static v0, Lcom/bytedance/trae/utils/AppUtils;->getProcessName(I)Ljava/lang/String;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +00bh
    const-string v2, ":"
    invoke-virtual v0, v2, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    return v1
    if-eqz v0, +00dh
    invoke-virtual v3, Landroid/content/Context;->getPackageName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    const/4 v1, 1
    return v1
.end method
