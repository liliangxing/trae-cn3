# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet$Companion;
.super Ljava/lang/Object;
.source "DeviceTargetSelectBottomSheet.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet$Companion;-><init>()V
    return-void 
.end method

.method public static synthetic newInstance$default(com.bytedance.trae.conversation.devices.DeviceTargetSelectBottomSheet$Companion  java.util.List  java.lang.String  boolean  boolean  int  java.lang.Object)com.bytedance.trae.conversation.devices.DeviceTargetSelectBottomSheet
    .registers 9
    # ins_size=7
    and-int/lit8 v8, v7, 1
    const/4 v0, 0
    if-eqz v8, +00ah
    sget-object v3, Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;
    const/4 v8, 0
    const/4 v1, 1
    invoke-static v3, v0, v1, v8, Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;->availableTargets$default(Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy; Z I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v3
    and-int/lit8 v8, v7, 2
    if-eqz v8, +004h
    const-string v4, "device_list"
    and-int/lit8 v8, v7, 4
    if-eqz v8, +003h
    move v5, v0
    and-int/lit8 v7, v7, 8
    if-eqz v7, +003h
    move v6, v0
    invoke-virtual v2, v3, v4, v5, v6, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet$Companion;->newInstance(Ljava/util/List; Ljava/lang/String; Z Z)Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;
    move-result-object v2
    return-object v2
.end method

.method public final newInstance(java.util.List  java.lang.String  boolean  boolean)com.bytedance.trae.conversation.devices.DeviceTargetSelectBottomSheet
    .registers 9
    # ins_size=5
    const-string v0, "availableTargets"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "enterFrom"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;-><init>()V
    new-instance v1, Landroid/os/Bundle;
    invoke-direct v1, Landroid/os/Bundle;-><init>()V
    check-cast v5, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    const/16 v3, 10
    invoke-static v5, v3, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v3
    invoke-direct v2, v3, Ljava/util/ArrayList;-><init>(I)V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +010h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->name()Ljava/lang/String;
    move-result-object v3
    invoke-interface v2, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v2, Ljava/util/List;
    check-cast v2, Ljava/util/Collection;
    new-instance v5, Ljava/util/ArrayList;
    invoke-direct v5, v2, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V
    const-string v2, "arg_available_targets"
    invoke-virtual v1, v2, v5, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String; Ljava/util/ArrayList;)V
    const-string v5, "arg_enter_from"
    invoke-virtual v1, v5, v6, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    const-string v5, "arg_has_work_device"
    invoke-virtual v1, v5, v7, Landroid/os/Bundle;->putBoolean(Ljava/lang/String; Z)V
    const-string v5, "arg_has_ide_device"
    invoke-virtual v1, v5, v8, Landroid/os/Bundle;->putBoolean(Ljava/lang/String; Z)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->setArguments(Landroid/os/Bundle;)V
    return-object v0
.end method
