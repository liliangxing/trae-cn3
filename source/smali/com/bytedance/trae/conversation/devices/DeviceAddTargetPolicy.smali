# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;
.super Ljava/lang/Object;
.source "DeviceAddTargetPolicy.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic availableTargets$default(com.bytedance.trae.conversation.devices.DeviceAddTargetPolicy  boolean  int  java.lang.Object)java.util.List
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +008h
    sget-object v1, Lcom/bytedance/trae/conversation/devices/MobileIdeFeatureGate;->INSTANCE Lcom/bytedance/trae/conversation/devices/MobileIdeFeatureGate;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/MobileIdeFeatureGate;->isGuideEnabled()Z
    move-result v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;->availableTargets(Z)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method private final toProductTypeOrNull(com.bytedance.trae.conversation.devices.DeviceItem)com.bytedance.trae.conversation.devices.DeviceProductType
    .registers 3
    # ins_size=2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v2
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CliType;->ordinal()I
    move-result v2
    aget v2, v0, v2
    const/4 v0, 1
    if-eq v2, v0, +00ah
    const/4 v0, 2
    if-eq v2, v0, +004h
    const/4 v2, 0
    goto +6h
    sget-object v2, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->IDE Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    goto +3h
    sget-object v2, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    return-object v2
.end method

.method public final availableTargets(boolean)java.util.List
    .registers 4
    # ins_size=2
    if-eqz v3, +014h
    const/4 v3, 2
    new-array v3, v3, [Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    const/4 v0, 0
    sget-object v1, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    aput-object v1, v3, v0
    const/4 v0, 1
    sget-object v1, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->IDE Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    aput-object v1, v3, v0
    invoke-static v3, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v3
    goto +7h
    sget-object v3, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-static v3, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v3
    return-object v3
.end method

.method public final bindingTarget(com.bytedance.trae.conversation.devices.DeviceProductType  java.util.List  java.lang.String)com.bytedance.trae.conversation.devices.BindingTarget
    .registers 13
    # ins_size=4
    const-string v0, "productType"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "currentDevices"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "enterFrom"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v11, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v11, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v11
    invoke-interface v11, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +01ah
    invoke-interface v11, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    sget-object v3, Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;
    invoke-direct v3, v2, Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;->toProductTypeOrNull(Lcom/bytedance/trae/conversation/devices/DeviceItem;)Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v2
    if-ne v2, v10, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    if-eqz v2, -018h
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1dh
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    new-instance v11, Ljava/util/ArrayList;
    const/16 v1, 10
    invoke-static v0, v1, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v1
    invoke-direct v11, v1, Ljava/util/ArrayList;-><init>(I)V
    check-cast v11, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +010h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getId()Ljava/lang/String;
    move-result-object v1
    invoke-interface v11, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v11, Ljava/util/List;
    check-cast v11, Ljava/lang/Iterable;
    invoke-static v11, Lkotlin/collections/CollectionsKt;->toSet(Ljava/lang/Iterable;)Ljava/util/Set;
    move-result-object v2
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 56
    const/4 v8, 0
    new-instance v11, Lcom/bytedance/trae/conversation/devices/BindingTarget;
    move-object v0, v11
    move-object v1, v10
    move-object v3, v12
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/conversation/devices/BindingTarget;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/util/Set; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v11
.end method
