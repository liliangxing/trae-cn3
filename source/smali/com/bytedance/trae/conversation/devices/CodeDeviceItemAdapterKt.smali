# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapterKt;
.super Ljava/lang/Object;
.source "CodeDeviceItemAdapter.kt"


.method public static final shouldShowStatusChip(com.bytedance.trae.conversation.devices.DeviceItem)boolean
    .registers 3
    # ins_size=1
    const-string v0, "<this>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-eq v0, v1, +00dh
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v2
    sget-object v0, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-ne v2, v0, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    const/4 v2, 1
    return v2
.end method
