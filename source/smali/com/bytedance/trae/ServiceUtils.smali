# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public Lcom/bytedance/trae/ServiceUtils;
.super Ljava/lang/Object;
.source "ServiceUtils.java"


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static bindService()void
    .registers 3
    # ins_size=0
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/common/apphost/AppHost;
    new-instance v2, Lcom/bytedance/trae/ServiceUtils$1;
    invoke-direct v2, Lcom/bytedance/trae/ServiceUtils$1;-><init>()V
    invoke-virtual v0, v1, v2, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->bind(Ljava/lang/Class; Lcom/ss/android/ugc/aweme/framework/services/ServiceProvider;)Lcom/ss/android/ugc/aweme/framework/services/Binding;
    move-result-object v0
    invoke-virtual v0, Lcom/ss/android/ugc/aweme/framework/services/Binding;->asSingleton()Lcom/ss/android/ugc/aweme/framework/services/Binding;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/platform/ITraeSdkCommonDepend;
    new-instance v2, Lcom/bytedance/trae/ServiceUtils$2;
    invoke-direct v2, Lcom/bytedance/trae/ServiceUtils$2;-><init>()V
    invoke-virtual v0, v1, v2, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->bind(Ljava/lang/Class; Lcom/ss/android/ugc/aweme/framework/services/ServiceProvider;)Lcom/ss/android/ugc/aweme/framework/services/Binding;
    move-result-object v0
    invoke-virtual v0, Lcom/ss/android/ugc/aweme/framework/services/Binding;->asSingleton()Lcom/ss/android/ugc/aweme/framework/services/Binding;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/applog/init/IAppLogInitiator;
    new-instance v2, Lcom/bytedance/trae/ServiceUtils$3;
    invoke-direct v2, Lcom/bytedance/trae/ServiceUtils$3;-><init>()V
    invoke-virtual v0, v1, v2, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->bind(Ljava/lang/Class; Lcom/ss/android/ugc/aweme/framework/services/ServiceProvider;)Lcom/ss/android/ugc/aweme/framework/services/Binding;
    move-result-object v0
    invoke-virtual v0, Lcom/ss/android/ugc/aweme/framework/services/Binding;->asSingleton()Lcom/ss/android/ugc/aweme/framework/services/Binding;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    new-instance v2, Lcom/bytedance/trae/ServiceUtils$4;
    invoke-direct v2, Lcom/bytedance/trae/ServiceUtils$4;-><init>()V
    invoke-virtual v0, v1, v2, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->bind(Ljava/lang/Class; Lcom/ss/android/ugc/aweme/framework/services/ServiceProvider;)Lcom/ss/android/ugc/aweme/framework/services/Binding;
    move-result-object v0
    invoke-virtual v0, Lcom/ss/android/ugc/aweme/framework/services/Binding;->asSingleton()Lcom/ss/android/ugc/aweme/framework/services/Binding;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/applog/api/IApplog;
    new-instance v2, Lcom/bytedance/trae/ServiceUtils$5;
    invoke-direct v2, Lcom/bytedance/trae/ServiceUtils$5;-><init>()V
    invoke-virtual v0, v1, v2, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->bind(Ljava/lang/Class; Lcom/ss/android/ugc/aweme/framework/services/ServiceProvider;)Lcom/ss/android/ugc/aweme/framework/services/Binding;
    move-result-object v0
    invoke-virtual v0, Lcom/ss/android/ugc/aweme/framework/services/Binding;->asSingleton()Lcom/ss/android/ugc/aweme/framework/services/Binding;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/image/api/IImageInitiator;
    new-instance v2, Lcom/bytedance/trae/ServiceUtils$6;
    invoke-direct v2, Lcom/bytedance/trae/ServiceUtils$6;-><init>()V
    invoke-virtual v0, v1, v2, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->bind(Ljava/lang/Class; Lcom/ss/android/ugc/aweme/framework/services/ServiceProvider;)Lcom/ss/android/ugc/aweme/framework/services/Binding;
    move-result-object v0
    invoke-virtual v0, Lcom/ss/android/ugc/aweme/framework/services/Binding;->asSingleton()Lcom/ss/android/ugc/aweme/framework/services/Binding;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/push/api/IPushService;
    new-instance v2, Lcom/bytedance/trae/ServiceUtils$7;
    invoke-direct v2, Lcom/bytedance/trae/ServiceUtils$7;-><init>()V
    invoke-virtual v0, v1, v2, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->bind(Ljava/lang/Class; Lcom/ss/android/ugc/aweme/framework/services/ServiceProvider;)Lcom/ss/android/ugc/aweme/framework/services/Binding;
    move-result-object v0
    invoke-virtual v0, Lcom/ss/android/ugc/aweme/framework/services/Binding;->asSingleton()Lcom/ss/android/ugc/aweme/framework/services/Binding;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/apm/api/IApm;
    new-instance v2, Lcom/bytedance/trae/ServiceUtils$8;
    invoke-direct v2, Lcom/bytedance/trae/ServiceUtils$8;-><init>()V
    invoke-virtual v0, v1, v2, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->bind(Ljava/lang/Class; Lcom/ss/android/ugc/aweme/framework/services/ServiceProvider;)Lcom/ss/android/ugc/aweme/framework/services/Binding;
    move-result-object v0
    invoke-virtual v0, Lcom/ss/android/ugc/aweme/framework/services/Binding;->asSingleton()Lcom/ss/android/ugc/aweme/framework/services/Binding;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/utils/logger/ILogger;
    new-instance v2, Lcom/bytedance/trae/ServiceUtils$9;
    invoke-direct v2, Lcom/bytedance/trae/ServiceUtils$9;-><init>()V
    invoke-virtual v0, v1, v2, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->bind(Ljava/lang/Class; Lcom/ss/android/ugc/aweme/framework/services/ServiceProvider;)Lcom/ss/android/ugc/aweme/framework/services/Binding;
    move-result-object v0
    invoke-virtual v0, Lcom/ss/android/ugc/aweme/framework/services/Binding;->asSingleton()Lcom/ss/android/ugc/aweme/framework/services/Binding;
    return-void 
.end method
