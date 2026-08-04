# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/DirectoryNode$Companion;
.super Ljava/lang/Object;
.source "DirectoryNode.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/DirectoryNode$Companion;-><init>()V
    return-void 
.end method

.method public final newFolderPlaceholder(java.lang.String  int)com.bytedance.trae.conversation.devices.DirectoryNode
    .registers 16
    # ins_size=3
    new-instance v12, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "new_folder_"
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, 未命名文件夹
    const-string v3, ""
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 1
    const/4 v11, 0
    move-object v0, v12
    move v4, v15
    move-object v5, v14
    invoke-direct/range v0 ... v11, Lcom/bytedance/trae/conversation/devices/DirectoryNode;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Z Z Z Z Z Z)V
    return-object v12
.end method
