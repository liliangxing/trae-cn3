# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;
.super Lcom/bytedance/platform/godzilla/plugin/BasePlugin;
.source "BinderTranTooLargeExp.java"

.field private static final ACTIVITY_RECORD_KEY:Ljava/lang/String;
.field private static final BUNDLE_SIZE_THRESHOLD:I
.field private static final MONITOR_KEY:Ljava/lang/String;
.field private static final MONITOR_STEP_ONRESTORESTATE:I
.field private static final MONITOR_STEP_ONSAVESTATE:I
.field private static final TAG:Ljava/lang/String;
.field private mApp:Landroid/app/Application;
.field private final mDisableActivities:Ljava/util/List;
.field private final mForceClear:Z
.field private final mKey2ContentMap:Ljava/util/LinkedHashMap;
.field private final mLifecycleCallback:Landroid/app/Application$ActivityLifecycleCallbacks;
.field private final mRestartOnRestore:Z
.field private mStarted:Z


.method public constructor <init>(boolean  boolean  java.util.List)void
    .registers 5
    # ins_size=4
    invoke-direct v1, Lcom/bytedance/platform/godzilla/plugin/BasePlugin;-><init>()V
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->mKey2ContentMap Ljava/util/LinkedHashMap;
    new-instance v0, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp$1;
    invoke-direct v0, v1, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp$1;-><init>(Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;)V
    iput-object v0, v1, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->mLifecycleCallback Landroid/app/Application$ActivityLifecycleCallbacks;
    iput-boolean v2, v1, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->mForceClear Z
    iput-boolean v3, v1, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->mRestartOnRestore Z
    iput-object v4, v1, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->mDisableActivities Ljava/util/List;
    return-void 
.end method

.method static synthetic access$000(com.bytedance.trae.apm.impl.BinderTranTooLargeExp  android.app.Activity)boolean
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->isDisable(Landroid/app/Activity;)Z
    move-result v0
    return v0
.end method

.method static synthetic access$100(com.bytedance.trae.apm.impl.BinderTranTooLargeExp)java.util.LinkedHashMap
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->mKey2ContentMap Ljava/util/LinkedHashMap;
    return-object v0
.end method

.method static synthetic access$200(com.bytedance.trae.apm.impl.BinderTranTooLargeExp  byte[]  java.lang.ClassLoader)android.os.Bundle
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->bytes2Bundle([B Ljava/lang/ClassLoader;)Landroid/os/Bundle;
    move-result-object v0
    return-object v0
.end method

.method static synthetic access$300(com.bytedance.trae.apm.impl.BinderTranTooLargeExp)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->mRestartOnRestore Z
    return v0
.end method

.method static synthetic access$400(com.bytedance.trae.apm.impl.BinderTranTooLargeExp  android.app.Activity)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->restart(Landroid/app/Activity;)V
    return-void 
.end method

.method static synthetic access$500(com.bytedance.trae.apm.impl.BinderTranTooLargeExp  android.os.Bundle)byte[]
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->bundle2Bytes(Landroid/os/Bundle;)[B
    move-result-object v0
    return-object v0
.end method

.method static synthetic access$600(com.bytedance.trae.apm.impl.BinderTranTooLargeExp)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->mForceClear Z
    return v0
.end method

.method private bundle2Bytes(android.os.Bundle)byte[]
    .registers 3
    # ins_size=2
    invoke-static Landroid/os/Parcel;->obtain()Landroid/os/Parcel;
    move-result-object v0
    invoke-virtual v0, v2, Landroid/os/Parcel;->writeBundle(Landroid/os/Bundle;)V
    invoke-virtual v0, Landroid/os/Parcel;->marshall()[B
    move-result-object v2
    invoke-virtual v0, Landroid/os/Parcel;->recycle()V
    return-object v2
    move-exception v2
    invoke-virtual v2, Ljava/lang/Throwable;->printStackTrace()V
    invoke-virtual v0, Landroid/os/Parcel;->recycle()V
    const/4 v2, 0
    return-object v2
    move-exception v2
    invoke-virtual v0, Landroid/os/Parcel;->recycle()V
    throw v2
    :try_start_0x4
    :try_start_0x10
.end method

.method private bytes2Bundle(byte[]  java.lang.ClassLoader)android.os.Bundle
    .registers 6
    # ins_size=3
    invoke-static Landroid/os/Parcel;->obtain()Landroid/os/Parcel;
    move-result-object v0
    array-length v1, v4
    const/4 v2, 0
    invoke-virtual v0, v4, v2, v1, Landroid/os/Parcel;->unmarshall([B I I)V
    invoke-virtual v0, v2, Landroid/os/Parcel;->setDataPosition(I)V
    invoke-virtual v0, v5, Landroid/os/Parcel;->readBundle(Ljava/lang/ClassLoader;)Landroid/os/Bundle;
    move-result-object v4
    invoke-virtual v0, Landroid/os/Parcel;->recycle()V
    return-object v4
    move-exception v4
    invoke-virtual v0, Landroid/os/Parcel;->recycle()V
    throw v4
    :try_start_0x4
.end method

.method private isDisable(android.app.Activity)boolean
    .registers 4
    # ins_size=2
    invoke-virtual v3, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/Class;->getName()Ljava/lang/String;
    move-result-object v3
    iget-object v0, v2, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->mDisableActivities Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +010h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-static v1, v3, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence; Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, -010h
    const/4 v3, 1
    return v3
    const/4 v3, 0
    return v3
.end method

.method private restart(android.app.Activity)void
    .registers 6
    # ins_size=2
    invoke-virtual v5, Landroid/app/Activity;->getApplication()Landroid/app/Application;
    move-result-object v0
    const-string v1, "["
    const-string v2, "BinderTranTooLargeExp"
    if-nez v0, +019h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v0, "] restart, application == null"
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-static v2, v5, Lcom/bytedance/platform/godzilla/common/Logger;->e(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    invoke-virtual v0, Landroid/app/Application;->getPackageManager()Landroid/content/pm/PackageManager;
    move-result-object v3
    invoke-virtual v0, Landroid/app/Application;->getPackageName()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v0, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;
    move-result-object v0
    if-nez v0, +019h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v0, "] restart, intent == null"
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-static v2, v5, Lcom/bytedance/platform/godzilla/common/Logger;->e(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    invoke-virtual v0, Landroid/content/Intent;->getComponent()Landroid/content/ComponentName;
    move-result-object v0
    invoke-static v0, Landroid/content/Intent;->makeRestartActivityTask(Landroid/content/ComponentName;)Landroid/content/Intent;
    move-result-object v0
    invoke-virtual v5, v0, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v0, "] restart success then exit"
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-static v2, v5, Lcom/bytedance/platform/godzilla/common/Logger;->e(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;
    move-result-object v5
    const/4 v0, 0
    invoke-virtual v5, v0, Ljava/lang/Runtime;->exit(I)V
    return-void 
.end method

.method public destroy()void
    .registers 3
    # ins_size=1
    invoke-super v2, Lcom/bytedance/platform/godzilla/plugin/BasePlugin;->destroy()V
    const-string v0, "BinderTranTooLargeExp"
    const-string v1, "destroy"
    invoke-static v0, v1, Lcom/bytedance/platform/godzilla/common/Logger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public getName()java.lang.String
    .registers 2
    # ins_size=1
    const-string v0, "BinderTranTooLargeExp"
    return-object v0
.end method

.method public init(android.app.Application)void
    .registers 3
    # ins_size=2
    invoke-super v1, v2, Lcom/bytedance/platform/godzilla/plugin/BasePlugin;->init(Landroid/app/Application;)V
    iput-object v2, v1, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->mApp Landroid/app/Application;
    const-string v2, "BinderTranTooLargeExp"
    const-string v0, "init"
    invoke-static v2, v0, Lcom/bytedance/platform/godzilla/common/Logger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public start()void
    .registers 4
    # ins_size=1
    invoke-super v3, Lcom/bytedance/platform/godzilla/plugin/BasePlugin;->start()V
    sget v0, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v1, 29
    const-string v2, "BinderTranTooLargeExp"
    if-ge v0, v1, +018h
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, start, ignore sdk=
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    sget v1, Landroid/os/Build$VERSION;->SDK_INT I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v2, v0, Lcom/bytedance/platform/godzilla/common/Logger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    iget-boolean v0, v3, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->mStarted Z
    if-eqz v0, +009h
    const-string/jumbo v0, start, already started
    invoke-static v2, v0, Lcom/bytedance/platform/godzilla/common/Logger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    const/4 v0, 1
    iput-boolean v0, v3, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->mStarted Z
    iget-object v0, v3, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->mApp Landroid/app/Application;
    iget-object v1, v3, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->mLifecycleCallback Landroid/app/Application$ActivityLifecycleCallbacks;
    invoke-virtual v0, v1, Landroid/app/Application;->registerActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V
    const-string/jumbo v0, start
    invoke-static v2, v0, Lcom/bytedance/platform/godzilla/common/Logger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public stop()void
    .registers 3
    # ins_size=1
    invoke-super v2, Lcom/bytedance/platform/godzilla/plugin/BasePlugin;->stop()V
    const-string v0, "BinderTranTooLargeExp"
    const-string/jumbo v1, stop
    invoke-static v0, v1, Lcom/bytedance/platform/godzilla/common/Logger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
