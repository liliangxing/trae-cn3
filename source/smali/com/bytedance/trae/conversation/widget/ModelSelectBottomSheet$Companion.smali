# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$Companion;
.super Ljava/lang/Object;
.source "ModelSelectBottomSheet.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$Companion;-><init>()V
    return-void 
.end method

.method public final newInstance(java.lang.String  com.bytedance.trae.im.service.CliType  com.bytedance.trae.conversation.widget.ChatMode  java.lang.String  java.lang.String)com.bytedance.trae.conversation.widget.ModelSelectBottomSheet
    .registers 9
    # ins_size=6
    const-string/jumbo v0, selectedModelId
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliType"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "chatMode"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliId"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;-><init>()V
    new-instance v1, Landroid/os/Bundle;
    invoke-direct v1, Landroid/os/Bundle;-><init>()V
    const-string/jumbo v2, selected_model_id
    invoke-virtual v1, v2, v4, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "cli_type"
    invoke-virtual v5, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v1, v4, v5, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "chat_mode"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/ChatMode;->name()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v1, v4, v5, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "cli_id"
    invoke-virtual v1, v4, v7, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "ide_version"
    invoke-virtual v1, v4, v8, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->setArguments(Landroid/os/Bundle;)V
    return-object v0
.end method
