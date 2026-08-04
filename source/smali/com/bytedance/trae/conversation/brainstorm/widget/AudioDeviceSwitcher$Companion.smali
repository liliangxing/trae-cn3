# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher$Companion;
.super Ljava/lang/Object;
.source "AudioDeviceSwitcher.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher$Companion;-><init>()V
    return-void 
.end method

.method public final newInstance(com.bytedance.trae.conversation.brainstorm.model.AudioDevice  java.util.List  java.lang.String  kotlin.jvm.functions.Function1)com.bytedance.trae.conversation.brainstorm.widget.AudioDeviceSwitcher
    .registers 8
    # ins_size=5
    const-string/jumbo v0, selectedDevice
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "availableDevices"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onDeviceSelected"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;-><init>()V
    new-instance v1, Landroid/os/Bundle;
    invoke-direct v1, Landroid/os/Bundle;-><init>()V
    const-string v2, "arg_selected_device"
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;->name()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v2, v4, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    check-cast v5, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    const/16 v2, 10
    invoke-static v5, v2, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v2
    invoke-direct v4, v2, Ljava/util/ArrayList;-><init>(I)V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +010h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;->name()Ljava/lang/String;
    move-result-object v2
    invoke-interface v4, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v4, Ljava/util/List;
    check-cast v4, Ljava/util/Collection;
    new-instance v5, Ljava/util/ArrayList;
    invoke-direct v5, v4, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V
    const-string v4, "arg_available_devices"
    invoke-virtual v1, v4, v5, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String; Ljava/util/ArrayList;)V
    const-string v4, "arg_bluetooth_name"
    invoke-virtual v1, v4, v6, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;->setArguments(Landroid/os/Bundle;)V
    invoke-virtual v0, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;->setOnDeviceSelected(Lkotlin/jvm/functions/Function1;)V
    return-object v0
.end method
