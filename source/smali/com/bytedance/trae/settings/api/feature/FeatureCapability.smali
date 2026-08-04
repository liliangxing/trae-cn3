# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/settings/api/feature/FeatureCapability;
.super Ljava/lang/Object;
.source "FeatureCapability.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/settings/api/feature/FeatureCapability;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;
    invoke-direct v0, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;-><init>()V
    sput-object v0, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->INSTANCE Lcom/bytedance/trae/settings/api/feature/FeatureCapability;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getService()com.bytedance.trae.settings.api.feature.IFeatureCapabilityService
    .registers 3
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService;
    return-object v0
.end method

.method public final getEnabledFeatures()java.util.Set
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->getService()Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService;
    move-result-object v0
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService;->getEnabledFeatures()Ljava/util/Set;
    move-result-object v0
    if-nez v0, +006h
    invoke-static Lkotlin/collections/SetsKt;->emptySet()Ljava/util/Set;
    move-result-object v0
    return-object v0
.end method

.method public final isEnabled(com.bytedance.trae.settings.api.feature.Feature)boolean
    .registers 3
    # ins_size=2
    const-string v0, "feature"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->getService()Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService;
    move-result-object v0
    if-eqz v0, +007h
    invoke-interface v0, v2, Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService;->isEnabled(Lcom/bytedance/trae/settings/api/feature/Feature;)Z
    move-result v2
    goto +2h
    const/4 v2, 0
    return v2
.end method

.method public final isToBUser()boolean
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->getService()Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService;
    move-result-object v0
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService;->isToBUser()Z
    move-result v0
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method public final refresh()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->getService()Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService;->refresh()V
    return-void 
.end method
