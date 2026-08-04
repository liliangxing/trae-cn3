# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public Lcom/bytedance/trae/init/task/util/Target28WebviewFixHelper;
.super Ljava/lang/Object;
.source "Target28WebviewFixHelper.java"

.field private static final HUAWEI_BRAND_LIST:Ljava/util/List;
.field private static final HUAWEI_WEBVIEW_DIR:Ljava/lang/String;
.field private static final WEBVIEW_DATA_LOCK_FILE:Ljava/lang/String;
.field private static final WEBVIEW_DIR:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    const-string v0, "huawei"
    const-string v1, "honor"
    filled-new-array v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/init/task/util/Target28WebviewFixHelper;->HUAWEI_BRAND_LIST Ljava/util/List;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static checkWebViewDataLock(android.content.Context  java.lang.String)void
    .registers 3
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v1, Landroid/content/Context;->getDataDir()Ljava/io/File;
    move-result-object v1
    invoke-virtual v1, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, "/webview_data.lock"
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    new-instance v2, Ljava/io/File;
    invoke-direct v2, v1, Ljava/io/File;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, Ljava/io/File;->exists()Z
    move-result v1
    if-nez v1, +003h
    return-void 
    new-instance v1, Ljava/io/RandomAccessFile;
    const-string/jumbo v0, rw
    invoke-direct v1, v2, v0, Ljava/io/RandomAccessFile;-><init>(Ljava/io/File; Ljava/lang/String;)V
    invoke-virtual v1, Ljava/io/RandomAccessFile;->getChannel()Ljava/nio/channels/FileChannel;
    move-result-object v1
    invoke-virtual v1, Ljava/nio/channels/FileChannel;->tryLock()Ljava/nio/channels/FileLock;
    move-result-object v1
    if-eqz v1, +006h
    invoke-virtual v1, Ljava/nio/channels/FileLock;->close()V
    goto +18h
    invoke-virtual v2, Ljava/io/File;->delete()Z
    move-result v1
    invoke-static v2, v1, Lcom/bytedance/trae/init/task/util/Target28WebviewFixHelper;->tryCreateLockFile(Ljava/io/File; Z)Z
    goto +10h
    invoke-virtual v2, Ljava/io/File;->exists()Z
    move-result v1
    if-eqz v1, +007h
    invoke-virtual v2, Ljava/io/File;->delete()Z
    move-result v1
    goto +2h
    const/4 v1, 0
    invoke-static v2, v1, Lcom/bytedance/trae/init/task/util/Target28WebviewFixHelper;->tryCreateLockFile(Ljava/io/File; Z)Z
    return-void 
    :try_start_0x2b
.end method

.method public static initWebViewDataDirectory(boolean  android.content.Context)void
    .registers 4
    # ins_size=2
    sget v0, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v1, 28
    if-lt v0, v1, +024h
    if-eqz v2, +01fh
    const-string v2, "/app_webview"
    invoke-static v3, v2, Lcom/bytedance/trae/init/task/util/Target28WebviewFixHelper;->checkWebViewDataLock(Landroid/content/Context; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/init/task/util/Target28WebviewFixHelper;->HUAWEI_BRAND_LIST Ljava/util/List;
    sget-object v0, Landroid/os/Build;->BRAND Ljava/lang/String;
    invoke-static Ljava/util/Locale;->getDefault()Ljava/util/Locale;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    invoke-interface v2, v0, Ljava/util/List;->contains(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +00bh
    const-string v2, "/app_hws_webview"
    invoke-static v3, v2, Lcom/bytedance/trae/init/task/util/Target28WebviewFixHelper;->checkWebViewDataLock(Landroid/content/Context; Ljava/lang/String;)V
    goto +4h
    invoke-static v3, Lcom/bytedance/trae/init/task/util/Target28WebviewFixHelper;->setWebViewDataDirectory(Landroid/content/Context;)V
    return-void 
.end method

.method private static setWebViewDataDirectory(android.content.Context)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/ss/android/common/util/ToolUtils;->getCurProcessName(Landroid/content/Context;)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Landroid/webkit/WebView;->setDataDirectorySuffix(Ljava/lang/String;)V
    goto +5h
    move-exception v0
    invoke-virtual v0, Ljava/lang/Exception;->printStackTrace()V
    return-void 
    :try_start_0x4
.end method

.method private static tryCreateLockFile(java.io.File  boolean)boolean
    .registers 2
    # ins_size=2
    if-eqz v1, +011h
    invoke-virtual v0, Ljava/io/File;->exists()Z
    move-result v1
    if-nez v1, +00bh
    invoke-virtual v0, Ljava/io/File;->createNewFile()Z
    move-result v0
    goto +6h
    move-exception v0
    invoke-virtual v0, Ljava/io/IOException;->printStackTrace()V
    const/4 v0, 0
    return v0
    :try_start_0x8
.end method
