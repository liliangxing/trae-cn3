# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/applog/impl/AppLogInitHookHelper;
.super Ljava/lang/Object;
.source "AppLogInitHookHelper.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/applog/impl/AppLogInitHookHelper;
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/applog/impl/AppLogInitHookHelper;
    invoke-direct v0, Lcom/bytedance/trae/applog/impl/AppLogInitHookHelper;-><init>()V
    sput-object v0, Lcom/bytedance/trae/applog/impl/AppLogInitHookHelper;->INSTANCE Lcom/bytedance/trae/applog/impl/AppLogInitHookHelper;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final preInit()void
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    const-string/jumbo v1, ug_install_settings_pref
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Landroid/app/Application;->getSharedPreferences(Ljava/lang/String; I)Landroid/content/SharedPreferences;
    move-result-object v0
    invoke-interface v0, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v0
    const-string/jumbo v1, serial_number
    const-string v2, ""
    invoke-interface v0, v1, v2, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String; Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    move-result-object v0
    invoke-interface v0, Landroid/content/SharedPreferences$Editor;->apply()V
    const/4 v0, 1
    invoke-static v0, Lcom/ss/android/deviceregister/DeviceRegisterManager;->checkPermissionBeforeCallSensitiveApi(Z)V
    goto +bh
    move-exception v0
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v2, "AppLogInitHookHelper"
    const-string v3, "detect serial_number failed"
    invoke-virtual v1, v2, v3, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x0
.end method

.method public final setupInitHook(com.bytedance.applog.InitConfig)void
    .registers 3
    # ins_size=2
    const-string v0, "config"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/applog/impl/AppLogInitHookHelper$setupInitHook$1;
    invoke-direct v0, Lcom/bytedance/trae/applog/impl/AppLogInitHookHelper$setupInitHook$1;-><init>()V
    check-cast v0, Lcom/bytedance/applog/BDInstallInitHook;
    invoke-virtual v2, v0, Lcom/bytedance/applog/InitConfig;->setBDInstallInitHook(Lcom/bytedance/applog/BDInstallInitHook;)Lcom/bytedance/applog/InitConfig;
    return-void 
.end method
