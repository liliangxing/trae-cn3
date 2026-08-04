# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$Companion;
.super Ljava/lang/Object;
.source "CodeDeviceSelectBottomSheet.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$Companion;-><init>()V
    return-void 
.end method

.method public static synthetic newInstance$default(com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet$Companion  com.bytedance.trae.conversation.widget.ChatMode  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$Companion;->newInstance(Lcom/bytedance/trae/conversation/widget/ChatMode; Ljava/lang/String;)Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;
    move-result-object v0
    return-object v0
.end method

.method public final newInstance(com.bytedance.trae.conversation.widget.ChatMode  java.lang.String)com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet
    .registers 6
    # ins_size=3
    const-string v0, "mode"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;-><init>()V
    new-instance v1, Landroid/os/Bundle;
    invoke-direct v1, Landroid/os/Bundle;-><init>()V
    const-string v2, "arg_mode"
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/ChatMode;->name()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v2, v4, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v5, +007h
    const-string v4, "arg_preselected_device_id"
    invoke-virtual v1, v4, v5, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->setArguments(Landroid/os/Bundle;)V
    return-object v0
.end method
