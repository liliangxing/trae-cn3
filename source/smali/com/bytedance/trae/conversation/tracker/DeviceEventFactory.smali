# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;
.super Ljava/lang/Object;
.source "DeviceEvents.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;
    invoke-direct v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final toInt(boolean)int
    .registers 2
    # ins_size=2
    return v1
.end method

.method private final trackValue(com.bytedance.trae.conversation.devices.DevicePairingTrigger)java.lang.String
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;->ordinal()I
    move-result v2
    aget v2, v0, v2
    const/4 v0, 1
    if-eq v2, v0, +00fh
    const/4 v0, 2
    if-ne v2, v0, +006h
    const-string/jumbo v2, unbound_device
    goto +9h
    new-instance v2, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v2, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v2
    const-string v2, "connect_button"
    return-object v2
.end method

.method public final connectEntryClick(com.bytedance.trae.conversation.tracker.DeviceTrackEnterFrom  com.bytedance.trae.conversation.tracker.DeviceTrackMode)com.bytedance.trae.conversation.tracker.DeviceEvent
    .registers 5
    # ins_size=3
    const-string v0, "enterFrom"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lkotlin/collections/MapsKt;->createMapBuilder()Ljava/util/Map;
    move-result-object v0
    const-string v1, "enter_from"
    invoke-virtual v3, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->getValue()Ljava/lang/String;
    move-result-object v3
    invoke-interface v0, v1, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    if-eqz v4, +00bh
    const-string v3, "current_mode"
    invoke-virtual v4, Lcom/bytedance/trae/conversation/tracker/DeviceTrackMode;->getValue()Ljava/lang/String;
    move-result-object v4
    invoke-interface v0, v3, v4, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static v0, Lkotlin/collections/MapsKt;->build(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    const-string v0, "icube_device_connect_entry_click"
    invoke-direct v4, v0, v3, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;-><init>(Ljava/lang/String; Ljava/util/Map;)V
    return-object v4
.end method

.method public final devicePickerShow(int  int  int  com.bytedance.trae.conversation.tracker.DeviceTrackMode)com.bytedance.trae.conversation.tracker.DeviceEvent
    .registers 8
    # ins_size=5
    const-string v0, "currentMode"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    const/4 v1, 4
    new-array v1, v1, [Lkotlin/Pair;
    const-string v2, "device_count"
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-static v2, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v2, 0
    aput-object v4, v1, v2
    const-string/jumbo v4, work_device_count
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v5, 1
    aput-object v4, v1, v5
    const-string v4, "ide_device_count"
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v5, 2
    aput-object v4, v1, v5
    const-string v4, "current_mode"
    invoke-virtual v7, Lcom/bytedance/trae/conversation/tracker/DeviceTrackMode;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v5, 3
    aput-object v4, v1, v5
    invoke-static v1, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v4
    const-string v5, "icube_device_picker_show"
    invoke-direct v0, v5, v4, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;-><init>(Ljava/lang/String; Ljava/util/Map;)V
    return-object v0
.end method

.method public final deviceSelectClick(java.lang.String  java.lang.String  com.bytedance.trae.conversation.tracker.DeviceTrackCliType  com.bytedance.trae.conversation.tracker.DeviceTrackOnlineStatus  com.bytedance.trae.conversation.tracker.DeviceRegisterStatus)com.bytedance.trae.conversation.tracker.DeviceEvent
    .registers 9
    # ins_size=6
    const-string v0, "deviceId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "deviceType"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliType"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onlineStatus"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "registerStatus"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    const/4 v1, 5
    new-array v1, v1, [Lkotlin/Pair;
    const-string v2, "device_id"
    invoke-static v2, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v2, 0
    aput-object v4, v1, v2
    const-string v4, "device_type"
    invoke-static v4, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v5, 1
    aput-object v4, v1, v5
    const-string v4, "cli_type"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v5, 2
    aput-object v4, v1, v5
    const-string v4, "online_status"
    invoke-virtual v7, Lcom/bytedance/trae/conversation/tracker/DeviceTrackOnlineStatus;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v5, 3
    aput-object v4, v1, v5
    const-string v4, "register_status"
    invoke-virtual v8, Lcom/bytedance/trae/conversation/tracker/DeviceRegisterStatus;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v5, 4
    aput-object v4, v1, v5
    invoke-static v1, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v4
    const-string v5, "icube_device_select_click"
    invoke-direct v0, v5, v4, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;-><init>(Ljava/lang/String; Ljava/util/Map;)V
    return-object v0
.end method

.method public final downloadLinkCopyClick(com.bytedance.trae.conversation.tracker.DeviceTrackEnterFrom  com.bytedance.trae.conversation.tracker.DeviceTrackCliType)com.bytedance.trae.conversation.tracker.DeviceEvent
    .registers 6
    # ins_size=3
    const-string v0, "enterFrom"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliType"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    const/4 v1, 2
    new-array v1, v1, [Lkotlin/Pair;
    const-string v2, "enter_from"
    invoke-virtual v4, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->getValue()Ljava/lang/String;
    move-result-object v4
    invoke-static v2, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v2, 0
    aput-object v4, v1, v2
    const-string v4, "cli_type"
    invoke-virtual v5, Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v5, 1
    aput-object v4, v1, v5
    invoke-static v1, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v4
    const-string v5, "download_link_copy_click"
    invoke-direct v0, v5, v4, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;-><init>(Ljava/lang/String; Ljava/util/Map;)V
    return-object v0
.end method

.method public final guideClick(com.bytedance.trae.conversation.tracker.DeviceGuideType  com.bytedance.trae.conversation.tracker.DeviceGuideAction)com.bytedance.trae.conversation.tracker.DeviceEvent
    .registers 7
    # ins_size=3
    const-string v0, "guideType"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "action"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    const/4 v2, 2
    new-array v2, v2, [Lkotlin/Pair;
    const-string v3, "guide_type"
    invoke-virtual v5, Lcom/bytedance/trae/conversation/tracker/DeviceGuideType;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-static v3, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v5
    const/4 v3, 0
    aput-object v5, v2, v3
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-static v0, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v5
    const/4 v6, 1
    aput-object v5, v2, v6
    invoke-static v2, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v5
    const-string v6, "icube_device_guide_click"
    invoke-direct v1, v6, v5, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;-><init>(Ljava/lang/String; Ljava/util/Map;)V
    return-object v1
.end method

.method public final guideShow(com.bytedance.trae.conversation.tracker.DeviceGuideType  com.bytedance.trae.conversation.tracker.DeviceBindState  com.bytedance.trae.conversation.tracker.DeviceBindState)com.bytedance.trae.conversation.tracker.DeviceEvent
    .registers 7
    # ins_size=4
    const-string v0, "guideType"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, workBindState
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "ideBindState"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    const/4 v1, 3
    new-array v1, v1, [Lkotlin/Pair;
    const-string v2, "guide_type"
    invoke-virtual v4, Lcom/bytedance/trae/conversation/tracker/DeviceGuideType;->getValue()Ljava/lang/String;
    move-result-object v4
    invoke-static v2, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v2, 0
    aput-object v4, v1, v2
    const-string/jumbo v4, work_bind_state
    invoke-virtual v5, Lcom/bytedance/trae/conversation/tracker/DeviceBindState;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v5, 1
    aput-object v4, v1, v5
    const-string v4, "ide_bind_state"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/DeviceBindState;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v5, 2
    aput-object v4, v1, v5
    invoke-static v1, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v4
    const-string v5, "icube_device_guide_show"
    invoke-direct v0, v5, v4, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;-><init>(Ljava/lang/String; Ljava/util/Map;)V
    return-object v0
.end method

.method public final pairCount(int  int  int)com.bytedance.trae.conversation.tracker.DeviceEvent
    .registers 7
    # ins_size=4
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    const/4 v1, 3
    new-array v1, v1, [Lkotlin/Pair;
    const-string v2, "local_cli_count"
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-static v2, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v2, 0
    aput-object v4, v1, v2
    const-string/jumbo v4, work_device_count
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v5, 1
    aput-object v4, v1, v5
    const-string v4, "ide_device_count"
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v5, 2
    aput-object v4, v1, v5
    invoke-static v1, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v4
    const-string v5, "icube_device_pair_count"
    invoke-direct v0, v5, v4, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;-><init>(Ljava/lang/String; Ljava/util/Map;)V
    return-object v0
.end method

.method public final pairResult(long  boolean  com.bytedance.trae.conversation.tracker.DeviceTrackEnterFrom  com.bytedance.trae.conversation.tracker.DeviceTrackCliType  com.bytedance.trae.conversation.tracker.DevicePairResultDetail  com.bytedance.trae.conversation.devices.DevicePairingTrigger)com.bytedance.trae.conversation.tracker.DeviceEvent
    .registers 12
    # ins_size=8
    const-string v0, "enterFrom"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliType"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, resultDetail
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, triggerBy
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    const/4 v1, 6
    new-array v1, v1, [Lkotlin/Pair;
    const-wide/16 v2, 0
    invoke-static v5, v6, v2, v3, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v5
    invoke-static v5, v6, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v5
    const-string v6, "duration"
    invoke-static v6, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v5
    const/4 v6, 0
    aput-object v5, v1, v6
    invoke-direct v4, v7, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->toInt(Z)I
    move-result v5
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const-string v6, "is_success"
    invoke-static v6, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v5
    const/4 v6, 1
    aput-object v5, v1, v6
    const-string v5, "enter_from"
    invoke-virtual v8, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->getValue()Ljava/lang/String;
    move-result-object v6
    invoke-static v5, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v5
    const/4 v6, 2
    aput-object v5, v1, v6
    const-string v5, "cli_type"
    invoke-virtual v9, Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;->getValue()Ljava/lang/String;
    move-result-object v6
    invoke-static v5, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v5
    const/4 v6, 3
    aput-object v5, v1, v6
    const-string/jumbo v5, result_detail
    invoke-virtual v10, Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail;->getValue()Ljava/lang/String;
    move-result-object v6
    invoke-static v5, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v5
    const/4 v6, 4
    aput-object v5, v1, v6
    const-string/jumbo v5, trigger_by
    invoke-direct v4, v11, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->trackValue(Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;)Ljava/lang/String;
    move-result-object v6
    invoke-static v5, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v5
    const/4 v6, 5
    aput-object v5, v1, v6
    invoke-static v1, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v5
    const-string v6, "icube_device_pair_result"
    invoke-direct v0, v6, v5, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;-><init>(Ljava/lang/String; Ljava/util/Map;)V
    return-object v0
.end method

.method public final pairingPageShareClick(com.bytedance.trae.conversation.tracker.DeviceTrackEnterFrom  com.bytedance.trae.conversation.tracker.DeviceTrackCliType)com.bytedance.trae.conversation.tracker.DeviceEvent
    .registers 6
    # ins_size=3
    const-string v0, "enterFrom"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliType"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    const/4 v1, 2
    new-array v1, v1, [Lkotlin/Pair;
    const-string v2, "enter_from"
    invoke-virtual v4, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->getValue()Ljava/lang/String;
    move-result-object v4
    invoke-static v2, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v2, 0
    aput-object v4, v1, v2
    const-string v4, "cli_type"
    invoke-virtual v5, Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v5, 1
    aput-object v4, v1, v5
    invoke-static v1, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v4
    const-string v5, "device_pairing_page_share_click"
    invoke-direct v0, v5, v4, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;-><init>(Ljava/lang/String; Ljava/util/Map;)V
    return-object v0
.end method

.method public final pairingPageView(com.bytedance.trae.conversation.tracker.DeviceTrackEnterFrom  com.bytedance.trae.conversation.tracker.DeviceTrackCliType  java.lang.String  com.bytedance.trae.conversation.devices.DevicePairingTrigger)com.bytedance.trae.conversation.tracker.DeviceEvent
    .registers 8
    # ins_size=5
    const-string v0, "enterFrom"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliType"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "deviceType"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, triggerBy
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    const/4 v1, 4
    new-array v1, v1, [Lkotlin/Pair;
    const-string v2, "enter_from"
    invoke-virtual v4, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->getValue()Ljava/lang/String;
    move-result-object v4
    invoke-static v2, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v2, 0
    aput-object v4, v1, v2
    const-string v4, "cli_type"
    invoke-virtual v5, Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v5, 1
    aput-object v4, v1, v5
    const-string v4, "device_type"
    invoke-static v4, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v5, 2
    aput-object v4, v1, v5
    const-string/jumbo v4, trigger_by
    invoke-direct v3, v7, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->trackValue(Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;)Ljava/lang/String;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v5, 3
    aput-object v4, v1, v5
    invoke-static v1, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v4
    const-string v5, "device_pairing_page_view"
    invoke-direct v0, v5, v4, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;-><init>(Ljava/lang/String; Ljava/util/Map;)V
    return-object v0
.end method

.method public final pairingStep1Complete(com.bytedance.trae.conversation.tracker.DeviceTrackEnterFrom  com.bytedance.trae.conversation.tracker.DeviceTrackCliType)com.bytedance.trae.conversation.tracker.DeviceEvent
    .registers 6
    # ins_size=3
    const-string v0, "enterFrom"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliType"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    const/4 v1, 2
    new-array v1, v1, [Lkotlin/Pair;
    const-string v2, "enter_from"
    invoke-virtual v4, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->getValue()Ljava/lang/String;
    move-result-object v4
    invoke-static v2, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v2, 0
    aput-object v4, v1, v2
    const-string v4, "cli_type"
    invoke-virtual v5, Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v5, 1
    aput-object v4, v1, v5
    invoke-static v1, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v4
    const-string v5, "device_pairing_step1_complete"
    invoke-direct v0, v5, v4, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;-><init>(Ljava/lang/String; Ljava/util/Map;)V
    return-object v0
.end method

.method public final pairingStep2Show(com.bytedance.trae.conversation.tracker.DeviceTrackEnterFrom  com.bytedance.trae.conversation.tracker.DeviceTrackCliType)com.bytedance.trae.conversation.tracker.DeviceEvent
    .registers 6
    # ins_size=3
    const-string v0, "enterFrom"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliType"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    const/4 v1, 2
    new-array v1, v1, [Lkotlin/Pair;
    const-string v2, "enter_from"
    invoke-virtual v4, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->getValue()Ljava/lang/String;
    move-result-object v4
    invoke-static v2, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v2, 0
    aput-object v4, v1, v2
    const-string v4, "cli_type"
    invoke-virtual v5, Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v5, 1
    aput-object v4, v1, v5
    invoke-static v1, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v4
    const-string v5, "device_pairing_step2_show"
    invoke-direct v0, v5, v4, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;-><init>(Ljava/lang/String; Ljava/util/Map;)V
    return-object v0
.end method

.method public final shareChannelSelect(com.bytedance.trae.conversation.tracker.DeviceTrackEnterFrom  java.lang.String)com.bytedance.trae.conversation.tracker.DeviceEvent
    .registers 7
    # ins_size=3
    const-string v0, "enterFrom"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "channel"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    const/4 v2, 2
    new-array v2, v2, [Lkotlin/Pair;
    const-string v3, "enter_from"
    invoke-virtual v5, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-static v3, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v5
    const/4 v3, 0
    aput-object v5, v2, v3
    const/4 v5, 1
    invoke-static v0, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v6
    aput-object v6, v2, v5
    invoke-static v2, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v5
    const-string v6, "icube_device_share_channel_select"
    invoke-direct v1, v6, v5, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;-><init>(Ljava/lang/String; Ljava/util/Map;)V
    return-object v1
.end method

.method public final targetSelectClick(com.bytedance.trae.conversation.tracker.DeviceTrackEnterFrom  com.bytedance.trae.conversation.tracker.DeviceTrackCliType)com.bytedance.trae.conversation.tracker.DeviceEvent
    .registers 6
    # ins_size=3
    const-string v0, "enterFrom"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliType"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    const/4 v1, 2
    new-array v1, v1, [Lkotlin/Pair;
    const-string v2, "enter_from"
    invoke-virtual v4, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->getValue()Ljava/lang/String;
    move-result-object v4
    invoke-static v2, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v2, 0
    aput-object v4, v1, v2
    const-string v4, "cli_type"
    invoke-virtual v5, Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v5, 1
    aput-object v4, v1, v5
    invoke-static v1, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v4
    const-string v5, "icube_device_target_select_click"
    invoke-direct v0, v5, v4, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;-><init>(Ljava/lang/String; Ljava/util/Map;)V
    return-object v0
.end method

.method public final targetSelectShow(com.bytedance.trae.conversation.tracker.DeviceTrackEnterFrom  int  boolean  boolean)com.bytedance.trae.conversation.tracker.DeviceEvent
    .registers 8
    # ins_size=5
    const-string v0, "enterFrom"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    const/4 v1, 4
    new-array v1, v1, [Lkotlin/Pair;
    const-string v2, "enter_from"
    invoke-virtual v4, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->getValue()Ljava/lang/String;
    move-result-object v4
    invoke-static v2, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v2, 0
    aput-object v4, v1, v2
    const-string v4, "available_target_count"
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v5, 1
    aput-object v4, v1, v5
    invoke-direct v3, v6, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->toInt(Z)I
    move-result v4
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "has_work_device"
    invoke-static v5, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v5, 2
    aput-object v4, v1, v5
    invoke-direct v3, v7, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->toInt(Z)I
    move-result v4
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-string v5, "has_ide_device"
    invoke-static v5, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v5, 3
    aput-object v4, v1, v5
    invoke-static v1, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v4
    const-string v5, "icube_device_target_select_show"
    invoke-direct v0, v5, v4, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;-><init>(Ljava/lang/String; Ljava/util/Map;)V
    return-object v0
.end method
