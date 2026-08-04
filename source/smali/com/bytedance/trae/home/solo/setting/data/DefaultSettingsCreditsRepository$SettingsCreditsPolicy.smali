# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$SettingsCreditsPolicy;
.super Ljava/lang/Object;
.source "SettingsCreditsRepository.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$SettingsCreditsPolicy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$SettingsCreditsPolicy;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$SettingsCreditsPolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$SettingsCreditsPolicy;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$SettingsCreditsPolicy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final isEligible(com.bytedance.trae.kmp.host.KmpHostInfo)boolean
    .registers 3
    # ins_size=2
    const-string v0, "hostInfo"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isLoggedIn()Z
    move-result v0
    if-eqz v0, +010h
    invoke-interface v2, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isMainland()Z
    move-result v0
    if-eqz v0, +00ah
    invoke-interface v2, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isPublicCloud()Z
    move-result v2
    if-eqz v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    return v2
.end method
