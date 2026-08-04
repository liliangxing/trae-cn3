# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$Companion;
.super Ljava/lang/Object;
.source "PluginsBottomSheet.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$Companion;-><init>()V
    return-void 
.end method

.method public static synthetic newInstance$default(com.bytedance.trae.conversation.plugin.PluginsBottomSheet$Companion  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.plugin.PluginsBottomSheet
    .registers 6
    # ins_size=5
    and-int/lit8 v5, v4, 1
    const/4 v0, 0
    if-eqz v5, +003h
    move-object v2, v0
    and-int/lit8 v4, v4, 2
    if-eqz v4, +003h
    move-object v3, v0
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$Companion;->newInstance(Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;
    move-result-object v1
    return-object v1
.end method

.method public final newInstance(java.lang.String  java.lang.String)com.bytedance.trae.conversation.plugin.PluginsBottomSheet
    .registers 6
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;
    invoke-direct v0, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;-><init>()V
    new-instance v1, Landroid/os/Bundle;
    invoke-direct v1, Landroid/os/Bundle;-><init>()V
    if-eqz v4, +007h
    const-string v2, "arg_cli_id"
    invoke-virtual v1, v2, v4, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v5, +007h
    const-string v4, "arg_workspace_folder"
    invoke-virtual v1, v4, v5, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->setArguments(Landroid/os/Bundle;)V
    return-object v0
.end method
