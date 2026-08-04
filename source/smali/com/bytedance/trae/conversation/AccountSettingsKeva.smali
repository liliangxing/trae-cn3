# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/AccountSettingsKeva;
.super Ljava/lang/Object;
.source "AccountSettingsKeva.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/AccountSettingsKeva;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/AccountSettingsKeva;
    invoke-direct v0, Lcom/bytedance/trae/conversation/AccountSettingsKeva;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->INSTANCE Lcom/bytedance/trae/conversation/AccountSettingsKeva;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getKeva()com.bytedance.keva.Keva
    .registers 3
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v0, +00eh
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string/jumbo v1, settings
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lcom/bytedance/keva/Keva;->getRepo(Ljava/lang/String;)Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v1, "getRepo(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method
