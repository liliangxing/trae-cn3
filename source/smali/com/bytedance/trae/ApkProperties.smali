# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public Lcom/bytedance/trae/ApkProperties;
.super Ljava/lang/Object;
.source "ApkProperties.java"

.field public static final KEY_UMENG_CHANNEL:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field private static sTtProperties:Lcom/bytedance/trae/ApkProperties;
.field private mJSONObject:Lorg/json/JSONObject;


.method private constructor <init>(android.content.Context)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    invoke-direct v0, v1, Lcom/bytedance/trae/ApkProperties;->tryLoadPropertiesFromApk(Landroid/content/Context;)Lorg/json/JSONObject;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/ApkProperties;->mJSONObject Lorg/json/JSONObject;
    goto +5h
    move-exception v1
    invoke-virtual v1, Ljava/lang/Exception;->printStackTrace()V
    return-void 
    :try_start_0x3
.end method

.method private checkChannelValid(org.json.JSONObject)boolean
    .registers 4
    # ins_size=2
    const/4 v0, 0
    const-string v1, "meta_umeng_channel"
    invoke-virtual v3, v1, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v3
    if-eqz v3, +003h
    return v0
    const/4 v3, 1
    return v3
    return v0
    :try_start_0x1
.end method

.method private getApkPath(android.content.Context)java.lang.String
    .registers 3
    # ins_size=2
    if-eqz v2, +013h
    instance-of v0, v2, Landroid/app/Application;
    if-eqz v0, +00fh
    check-cast v2, Landroid/app/Application;
    invoke-virtual v2, Landroid/app/Application;->getBaseContext()Landroid/content/Context;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v2, Landroid/app/Application;->getBaseContext()Landroid/content/Context;
    move-result-object v2
    goto +9h
    const-string v2, "base"
    invoke-static v2, Lcom/bytedance/lego/init/util/InitContext;->getCommonParams(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Landroid/content/Context;
    if-eqz v2, +00bh
    invoke-virtual v2, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;
    move-result-object v2
    if-eqz v2, +005h
    iget-object v2, v2, Landroid/content/pm/ApplicationInfo;->sourceDir Ljava/lang/String;
    goto +2h
    const/4 v2, 0
    return-object v2
.end method

.method public static inst(android.content.Context)com.bytedance.trae.ApkProperties
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/ApkProperties;->sTtProperties Lcom/bytedance/trae/ApkProperties;
    if-nez v0, +015h
    const-class v0, Lcom/bytedance/trae/ApkProperties;
    monitor-enter v0
    sget-object v1, Lcom/bytedance/trae/ApkProperties;->sTtProperties Lcom/bytedance/trae/ApkProperties;
    if-nez v1, +009h
    new-instance v1, Lcom/bytedance/trae/ApkProperties;
    invoke-direct v1, v2, Lcom/bytedance/trae/ApkProperties;-><init>(Landroid/content/Context;)V
    sput-object v1, Lcom/bytedance/trae/ApkProperties;->sTtProperties Lcom/bytedance/trae/ApkProperties;
    monitor-exit v0
    goto +4h
    move-exception v2
    monitor-exit v0
    throw v2
    sget-object v2, Lcom/bytedance/trae/ApkProperties;->sTtProperties Lcom/bytedance/trae/ApkProperties;
    return-object v2
    :try_start_0x7
.end method

.method private readKey(java.lang.String)java.lang.Object
    .registers 4
    # ins_size=2
    const/4 v0, 0
    iget-object v1, v2, Lcom/bytedance/trae/ApkProperties;->mJSONObject Lorg/json/JSONObject;
    if-eqz v1, +006h
    invoke-virtual v1, v3, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
    :try_start_0x1
.end method

.method private tryLoadPropertiesFromApk(android.content.Context)org.json.JSONObject
    .registers 4
    # ins_size=2
    const/4 v0, 0
    invoke-direct v2, v3, Lcom/bytedance/trae/ApkProperties;->getApkPath(Landroid/content/Context;)Ljava/lang/String;
    move-result-object v3
    const v1, 1903654775
    invoke-static v3, v1, Lcom/bytedance/trae/utils/ApkUtil;->findIdStringValue(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    return-object v0
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, v3, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    invoke-direct v2, v1, Lcom/bytedance/trae/ApkProperties;->checkChannelValid(Lorg/json/JSONObject;)Z
    move-result v3
    if-nez v3, +003h
    return-object v0
    return-object v1
    return-object v0
    :try_start_0x1
.end method

.method public get(java.lang.String)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/ApkProperties;->readKey(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public getBoolean(java.lang.String  java.lang.Boolean)java.lang.Boolean
    .registers 4
    # ins_size=3
    invoke-direct v1, v2, Lcom/bytedance/trae/ApkProperties;->readKey(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v2
    instance-of v0, v2, Ljava/lang/Boolean;
    if-nez v0, +003h
    return-object v3
    check-cast v2, Ljava/lang/Boolean;
    return-object v2
.end method

.method public getInt(java.lang.String  int)int
    .registers 4
    # ins_size=3
    invoke-direct v1, v2, Lcom/bytedance/trae/ApkProperties;->readKey(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v2
    instance-of v0, v2, Ljava/lang/Integer;
    if-nez v0, +003h
    return v3
    check-cast v2, Ljava/lang/Integer;
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v2
    return v2
.end method

.method public getString(java.lang.String  java.lang.String)java.lang.String
    .registers 4
    # ins_size=3
    invoke-direct v1, v2, Lcom/bytedance/trae/ApkProperties;->readKey(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v2
    instance-of v0, v2, Ljava/lang/String;
    if-nez v0, +003h
    return-object v3
    check-cast v2, Ljava/lang/String;
    return-object v2
.end method
