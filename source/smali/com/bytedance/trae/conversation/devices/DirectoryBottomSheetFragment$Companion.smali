# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$Companion;
.super Ljava/lang/Object;
.source "DirectoryBottomSheetFragment.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$Companion;-><init>()V
    return-void 
.end method

.method public static synthetic newInstance$default(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment$Companion  java.lang.String  com.bytedance.trae.conversation.widget.ChatMode  java.lang.String  boolean  int  java.lang.Object)com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    sget-object v2, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    and-int/lit8 v6, v5, 4
    if-eqz v6, +003h
    const/4 v3, 0
    and-int/lit8 v5, v5, 8
    if-eqz v5, +003h
    const/4 v4, 1
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$Companion;->newInstance(Ljava/lang/String; Lcom/bytedance/trae/conversation/widget/ChatMode; Ljava/lang/String; Z)Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    move-result-object v0
    return-object v0
.end method

.method public final newInstance(java.lang.String  com.bytedance.trae.conversation.widget.ChatMode  java.lang.String  boolean)com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment
    .registers 8
    # ins_size=5
    const-string v0, "cliId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "chatMode"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;-><init>()V
    new-instance v1, Landroid/os/Bundle;
    invoke-direct v1, Landroid/os/Bundle;-><init>()V
    const-string v2, "arg_cli_id"
    invoke-virtual v1, v2, v4, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "arg_chat_mode"
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/ChatMode;->name()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v1, v4, v5, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v6, +007h
    const-string v4, "arg_selected_directory"
    invoke-virtual v1, v4, v6, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "arg_use_flow_route_back"
    invoke-virtual v1, v4, v7, Landroid/os/Bundle;->putBoolean(Ljava/lang/String; Z)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->setArguments(Landroid/os/Bundle;)V
    return-object v0
.end method
