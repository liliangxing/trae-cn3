# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/MobileIdeFeatureGate;
.super Ljava/lang/Object;
.source "MobileIdeFeatureGate.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/devices/MobileIdeFeatureGate;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/MobileIdeFeatureGate;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/MobileIdeFeatureGate;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/MobileIdeFeatureGate;->INSTANCE Lcom/bytedance/trae/conversation/devices/MobileIdeFeatureGate;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final canOpenConnectGuide(com.bytedance.trae.conversation.devices.DeviceProductType)boolean
    .registers 3
    # ins_size=2
    const-string v0, "productType"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/MobileIdeFeatureGate;->isGuideEnabled()Z
    move-result v0
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/conversation/devices/MobileIdeFeatureGate;->canOpenConnectGuide(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Z)Z
    move-result v2
    return v2
.end method

.method public final canOpenConnectGuide(com.bytedance.trae.conversation.devices.DeviceProductType  boolean)boolean
    .registers 4
    # ins_size=3
    const-string v0, "productType"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->IDE Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    if-ne v2, v0, +007h
    if-eqz v3, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    const/4 v2, 1
    return v2
.end method

.method public final eligibleNewFeaturePromptProducts()java.util.Set
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/MobileIdeFeatureGate;->isGuideEnabled()Z
    move-result v0
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/devices/MobileIdeFeatureGate;->eligibleNewFeaturePromptProducts(Z)Ljava/util/Set;
    move-result-object v0
    return-object v0
.end method

.method public final eligibleNewFeaturePromptProducts(boolean)java.util.Set
    .registers 2
    # ins_size=2
    if-eqz v1, +00bh
    invoke-static Lcom/bytedance/trae/conversation/devices/DeviceProductType;->values()[Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v1
    invoke-static v1, Lkotlin/collections/ArraysKt;->toSet([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v1
    goto +7h
    sget-object v1, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-static v1, Lkotlin/collections/SetsKt;->setOf(Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v1
    return-object v1
.end method

.method public final isGuideEnabled()boolean
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->INSTANCE Lcom/bytedance/trae/settings/api/feature/FeatureCapability;
    sget-object v1, Lcom/bytedance/trae/settings/api/feature/Feature;->MOBILE_IDE_GUIDE Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-virtual v0, v1, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->isEnabled(Lcom/bytedance/trae/settings/api/feature/Feature;)Z
    move-result v0
    return v0
.end method
