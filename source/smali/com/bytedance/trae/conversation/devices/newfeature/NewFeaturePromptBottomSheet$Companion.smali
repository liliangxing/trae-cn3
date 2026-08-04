# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet$Companion;
.super Ljava/lang/Object;
.source "NewFeaturePromptBottomSheet.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet$Companion;-><init>()V
    return-void 
.end method

.method public final newInstance(com.bytedance.trae.conversation.devices.DeviceProductType  boolean  boolean)com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptBottomSheet
    .registers 7
    # ins_size=4
    const-string v0, "productType"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;-><init>()V
    new-instance v1, Landroid/os/Bundle;
    invoke-direct v1, Landroid/os/Bundle;-><init>()V
    const-string v2, "arg_product_type"
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->name()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v2, v4, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "arg_has_registered_work"
    invoke-virtual v1, v4, v5, Landroid/os/Bundle;->putBoolean(Ljava/lang/String; Z)V
    const-string v4, "arg_has_registered_ide"
    invoke-virtual v1, v4, v6, Landroid/os/Bundle;->putBoolean(Ljava/lang/String; Z)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->setArguments(Landroid/os/Bundle;)V
    return-object v0
.end method
