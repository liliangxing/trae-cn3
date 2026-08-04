# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/update/AppUpdateChecker;
.super Ljava/lang/Object;
.source "AppUpdateChecker.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/update/AppUpdateChecker;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/update/AppUpdateChecker;
    invoke-direct v0, Lcom/bytedance/trae/update/AppUpdateChecker;-><init>()V
    sput-object v0, Lcom/bytedance/trae/update/AppUpdateChecker;->INSTANCE Lcom/bytedance/trae/update/AppUpdateChecker;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final checkUpdate(boolean)void
    .registers 4
    # ins_size=2
    const-class v0, Lcom/bytedance/trae/update/IBitsUpdate;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/update/IBitsUpdate;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/update/IBitsUpdate;
    if-eqz v0, +005h
    invoke-interface v0, v3, Lcom/bytedance/trae/update/IBitsUpdate;->checkUpdate(Z)V
    return-void 
.end method

.method public final manualUpdateEnable()boolean
    .registers 3
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/update/IBitsUpdate;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/update/IBitsUpdate;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/update/IBitsUpdate;
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/update/IBitsUpdate;->manualUpdateEnable()Z
    move-result v0
    goto +2h
    const/4 v0, 0
    return v0
.end method
