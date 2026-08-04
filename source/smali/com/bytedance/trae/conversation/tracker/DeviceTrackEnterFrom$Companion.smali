# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom$Companion;
.super Ljava/lang/Object;
.source "DeviceEvents.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom$Companion;-><init>()V
    return-void 
.end method

.method public final from(java.lang.String)com.bytedance.trae.conversation.tracker.DeviceTrackEnterFrom
    .registers 3
    # ins_size=2
    const-string/jumbo v0, value
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->NEW_FEATURE_PROMPT Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->getValue()Ljava/lang/String;
    move-result-object v0
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +04eh
    const-string v0, "new_feature_popup"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +44h
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->DEVICE_PICKER Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->getValue()Ljava/lang/String;
    move-result-object v0
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +036h
    const-string v0, "device_list"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +02eh
    const-string v0, "code_add_device"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +026h
    const-string v0, "new_task"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +1ch
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->SETTINGS Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->getValue()Ljava/lang/String;
    move-result-object v0
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +00eh
    const-string/jumbo v0, settings_device_management
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    const/4 v2, 0
    goto +9h
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->SETTINGS Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    goto +6h
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->DEVICE_PICKER Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    goto +3h
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->NEW_FEATURE_PROMPT Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    return-object v2
.end method
