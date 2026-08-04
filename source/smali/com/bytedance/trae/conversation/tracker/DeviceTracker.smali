# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/tracker/DeviceTracker;
.super Ljava/lang/Object;
.source "DeviceTracker.kt"

.field private static final EVENT_DEVICE_SELECT_PATH:Ljava/lang/String;
.field private static final EVENT_IDE_PROJECT_PAGE_VIEW:Ljava/lang/String;
.field private static final EVENT_OFFLINE_DEVICE_PAGE_VIEW:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/tracker/DeviceTracker;
.field private static final TAG:Ljava/lang/String;
.field private static final appLogSink:Lcom/bytedance/trae/conversation/tracker/DeviceEventSink;
.field private static bridge testSink:Lcom/bytedance/trae/conversation/tracker/DeviceEventSink;


.method public static synthetic $r8$lambda$Lwqr1Wjfr7Dk_xN99O7z61oUqwY(com.bytedance.trae.conversation.tracker.DeviceEvent)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->appLogSink$lambda$0(Lcom/bytedance/trae/conversation/tracker/DeviceEvent;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;
    invoke-direct v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceTracker;
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker$$ExternalSyntheticLambda0;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->appLogSink Lcom/bytedance/trae/conversation/tracker/DeviceEventSink;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final appLogSink$lambda$0(com.bytedance.trae.conversation.tracker.DeviceEvent)void
    .registers 4
    # ins_size=1
    const-string v0, "event"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lorg/json/JSONObject;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;->getParams()Ljava/util/Map;
    move-result-object v1
    invoke-direct v0, v1, Lorg/json/JSONObject;-><init>(Ljava/util/Map;)V
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v1
    if-eqz v1, +025h
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, reportEvent: 
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;->getName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", params: "
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "DeviceTracker"
    invoke-static v2, v1, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;->getName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v3, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method private final report(com.bytedance.trae.conversation.tracker.DeviceEvent)void
    .registers 4
    # ins_size=2
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v2
    check-cast v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->appLogSink Lcom/bytedance/trae/conversation/tracker/DeviceEventSink;
    invoke-interface v0, v3, Lcom/bytedance/trae/conversation/tracker/DeviceEventSink;->report(Lcom/bytedance/trae/conversation/tracker/DeviceEvent;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v2
    check-cast v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->testSink Lcom/bytedance/trae/conversation/tracker/DeviceEventSink;
    if-eqz v0, +008h
    invoke-interface v0, v3, Lcom/bytedance/trae/conversation/tracker/DeviceEventSink;->report(Lcom/bytedance/trae/conversation/tracker/DeviceEvent;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto +2h
    const/4 v3, 0
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v3
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0x0
    :try_start_0x1a
.end method

.method private final toBindState(boolean)com.bytedance.trae.conversation.tracker.DeviceBindState
    .registers 2
    # ins_size=2
    if-eqz v1, +005h
    sget-object v1, Lcom/bytedance/trae/conversation/tracker/DeviceBindState;->BOUND Lcom/bytedance/trae/conversation/tracker/DeviceBindState;
    goto +3h
    sget-object v1, Lcom/bytedance/trae/conversation/tracker/DeviceBindState;->UNBOUND Lcom/bytedance/trae/conversation/tracker/DeviceBindState;
    return-object v1
.end method

.method private final toGuideType(com.bytedance.trae.conversation.devices.DeviceProductType)com.bytedance.trae.conversation.tracker.DeviceGuideType
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->ordinal()I
    move-result v2
    aget v2, v0, v2
    const/4 v0, 1
    if-eq v2, v0, +00eh
    const/4 v0, 2
    if-ne v2, v0, +005h
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/DeviceGuideType;->IDE Lcom/bytedance/trae/conversation/tracker/DeviceGuideType;
    goto +9h
    new-instance v2, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v2, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v2
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/DeviceGuideType;->WORK Lcom/bytedance/trae/conversation/tracker/DeviceGuideType;
    return-object v2
.end method

.method private final toLegacyDeviceType(com.bytedance.trae.im.service.CliType)java.lang.String
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    if-ne v2, v0, +005h
    const-string v2, "cloud_sandbox"
    goto +3h
    const-string v2, "pc"
    return-object v2
.end method

.method private final toTrackCliType(com.bytedance.trae.conversation.devices.DeviceProductType)com.bytedance.trae.conversation.tracker.DeviceTrackCliType
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->ordinal()I
    move-result v2
    aget v2, v0, v2
    const/4 v0, 1
    if-eq v2, v0, +00eh
    const/4 v0, 2
    if-ne v2, v0, +005h
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;->LOCAL_IDE Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;
    goto +9h
    new-instance v2, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v2, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v2
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;->LOCAL Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;
    return-object v2
.end method

.method private final toTrackCliType(com.bytedance.trae.im.service.CliType)com.bytedance.trae.conversation.tracker.DeviceTrackCliType
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker$WhenMappings;->$EnumSwitchMapping$1 [I
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CliType;->ordinal()I
    move-result v2
    aget v2, v0, v2
    const/4 v0, 1
    if-eq v2, v0, +014h
    const/4 v0, 2
    if-eq v2, v0, +00eh
    const/4 v0, 3
    if-ne v2, v0, +005h
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;->LOCAL_IDE Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;
    goto +ch
    new-instance v2, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v2, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v2
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;->LOCAL Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;
    goto +3h
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;->REMOTE Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;
    return-object v2
.end method

.method private final toTrackMode(com.bytedance.trae.conversation.widget.ChatMode)com.bytedance.trae.conversation.tracker.DeviceTrackMode
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker$WhenMappings;->$EnumSwitchMapping$2 [I
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/ChatMode;->ordinal()I
    move-result v2
    aget v2, v0, v2
    const/4 v0, 1
    if-eq v2, v0, +00eh
    const/4 v0, 2
    if-ne v2, v0, +005h
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/DeviceTrackMode;->CODE Lcom/bytedance/trae/conversation/tracker/DeviceTrackMode;
    goto +9h
    new-instance v2, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v2, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v2
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/DeviceTrackMode;->MTC Lcom/bytedance/trae/conversation/tracker/DeviceTrackMode;
    return-object v2
.end method

.method public static synthetic trackPairingPageView$default(com.bytedance.trae.conversation.tracker.DeviceTracker  java.lang.String  com.bytedance.trae.conversation.devices.DeviceProductType  com.bytedance.trae.conversation.devices.DevicePairingTrigger  int  java.lang.Object)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    sget-object v3, Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;->CONNECT_BUTTON Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->trackPairingPageView(Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DeviceProductType; Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;)V
    return-void 
.end method

.method public final setTestSink$conversation_mainlandRelease(com.bytedance.trae.conversation.tracker.DeviceEventSink)void
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v0
    if-eqz v0, +005h
    sput-object v2, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->testSink Lcom/bytedance/trae/conversation/tracker/DeviceEventSink;
    return-void 
    new-instance v2, Ljava/lang/IllegalStateException;
    const-string v0, "Device event test sink is only available in debug builds"
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v2, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v2
.end method

.method public final trackConnectEntryClick(java.lang.String  com.bytedance.trae.conversation.widget.ChatMode)void
    .registers 4
    # ins_size=3
    const-string v0, "enterFrom"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->Companion Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom$Companion;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom$Companion;->from(Ljava/lang/String;)Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    move-result-object v2
    if-nez v2, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;
    if-eqz v3, +007h
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->toTrackMode(Lcom/bytedance/trae/conversation/widget/ChatMode;)Lcom/bytedance/trae/conversation/tracker/DeviceTrackMode;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->connectEntryClick(Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom; Lcom/bytedance/trae/conversation/tracker/DeviceTrackMode;)Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    move-result-object v2
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->report(Lcom/bytedance/trae/conversation/tracker/DeviceEvent;)V
    return-void 
.end method

.method public final trackDevicePairCount$conversation_mainlandRelease(com.bytedance.trae.conversation.DeviceCountSnapshot)void
    .registers 5
    # ins_size=2
    const-string/jumbo v0, snapshot
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/DeviceCountSnapshot;->getLegacyTotal()I
    move-result v1
    invoke-virtual v4, Lcom/bytedance/trae/conversation/DeviceCountSnapshot;->getWorkCount()I
    move-result v2
    invoke-virtual v4, Lcom/bytedance/trae/conversation/DeviceCountSnapshot;->getIdeCount()I
    move-result v4
    invoke-virtual v0, v1, v2, v4, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->pairCount(I I I)Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    move-result-object v4
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->report(Lcom/bytedance/trae/conversation/tracker/DeviceEvent;)V
    return-void 
.end method

.method public final trackDevicePickerShow(int  int  int  com.bytedance.trae.conversation.widget.ChatMode)void
    .registers 6
    # ins_size=5
    const-string v0, "currentMode"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;
    invoke-direct v1, v5, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->toTrackMode(Lcom/bytedance/trae/conversation/widget/ChatMode;)Lcom/bytedance/trae/conversation/tracker/DeviceTrackMode;
    move-result-object v5
    invoke-virtual v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->devicePickerShow(I I I Lcom/bytedance/trae/conversation/tracker/DeviceTrackMode;)Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    move-result-object v2
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->report(Lcom/bytedance/trae/conversation/tracker/DeviceEvent;)V
    return-void 
.end method

.method public final trackDeviceSelectClick(java.lang.String  com.bytedance.trae.im.service.CliType  boolean  boolean)void
    .registers 12
    # ins_size=5
    const-string v0, "deviceId"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliType"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;
    invoke-direct v7, v9, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->toLegacyDeviceType(Lcom/bytedance/trae/im/service/CliType;)Ljava/lang/String;
    move-result-object v3
    invoke-direct v7, v9, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->toTrackCliType(Lcom/bytedance/trae/im/service/CliType;)Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;
    move-result-object v4
    if-eqz v10, +005h
    sget-object v9, Lcom/bytedance/trae/conversation/tracker/DeviceTrackOnlineStatus;->ONLINE Lcom/bytedance/trae/conversation/tracker/DeviceTrackOnlineStatus;
    goto +3h
    sget-object v9, Lcom/bytedance/trae/conversation/tracker/DeviceTrackOnlineStatus;->OFFLINE Lcom/bytedance/trae/conversation/tracker/DeviceTrackOnlineStatus;
    move-object v5, v9
    if-eqz v11, +005h
    sget-object v9, Lcom/bytedance/trae/conversation/tracker/DeviceRegisterStatus;->REGISTERED Lcom/bytedance/trae/conversation/tracker/DeviceRegisterStatus;
    goto +3h
    sget-object v9, Lcom/bytedance/trae/conversation/tracker/DeviceRegisterStatus;->UNREGISTERED Lcom/bytedance/trae/conversation/tracker/DeviceRegisterStatus;
    move-object v6, v9
    move-object v2, v8
    invoke-virtual/range v1 ... v6, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->deviceSelectClick(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType; Lcom/bytedance/trae/conversation/tracker/DeviceTrackOnlineStatus; Lcom/bytedance/trae/conversation/tracker/DeviceRegisterStatus;)Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    move-result-object v8
    invoke-direct v7, v8, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->report(Lcom/bytedance/trae/conversation/tracker/DeviceEvent;)V
    return-void 
.end method

.method public final trackDeviceSelectPath(int)void
    .registers 4
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    const-string v1, "depth"
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-static v1, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v3
    invoke-static v3, Lkotlin/collections/MapsKt;->mapOf(Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v3
    const-string v1, "icube_path_select_click"
    invoke-direct v0, v1, v3, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;-><init>(Ljava/lang/String; Ljava/util/Map;)V
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->report(Lcom/bytedance/trae/conversation/tracker/DeviceEvent;)V
    return-void 
.end method

.method public final trackDownloadLinkCopyClick(java.lang.String  com.bytedance.trae.conversation.devices.DeviceProductType)void
    .registers 4
    # ins_size=3
    const-string v0, "enterFrom"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "productType"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->Companion Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom$Companion;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom$Companion;->from(Ljava/lang/String;)Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    move-result-object v2
    if-nez v2, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->toTrackCliType(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;
    move-result-object v3
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->downloadLinkCopyClick(Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom; Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;)Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    move-result-object v2
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->report(Lcom/bytedance/trae/conversation/tracker/DeviceEvent;)V
    return-void 
.end method

.method public final trackGuideClick$conversation_mainlandRelease(com.bytedance.trae.conversation.devices.DeviceProductType  com.bytedance.trae.conversation.tracker.DeviceGuideAction)void
    .registers 4
    # ins_size=3
    const-string v0, "productType"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "action"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->toGuideType(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)Lcom/bytedance/trae/conversation/tracker/DeviceGuideType;
    move-result-object v2
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->guideClick(Lcom/bytedance/trae/conversation/tracker/DeviceGuideType; Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;)Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    move-result-object v2
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->report(Lcom/bytedance/trae/conversation/tracker/DeviceEvent;)V
    return-void 
.end method

.method public final trackGuideShow(com.bytedance.trae.conversation.devices.DeviceProductType  boolean  boolean)void
    .registers 5
    # ins_size=4
    const-string v0, "productType"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->toGuideType(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)Lcom/bytedance/trae/conversation/tracker/DeviceGuideType;
    move-result-object v2
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->toBindState(Z)Lcom/bytedance/trae/conversation/tracker/DeviceBindState;
    move-result-object v3
    invoke-direct v1, v4, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->toBindState(Z)Lcom/bytedance/trae/conversation/tracker/DeviceBindState;
    move-result-object v4
    invoke-virtual v0, v2, v3, v4, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->guideShow(Lcom/bytedance/trae/conversation/tracker/DeviceGuideType; Lcom/bytedance/trae/conversation/tracker/DeviceBindState; Lcom/bytedance/trae/conversation/tracker/DeviceBindState;)Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    move-result-object v2
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->report(Lcom/bytedance/trae/conversation/tracker/DeviceEvent;)V
    return-void 
.end method

.method public final trackIdeProjectPageView(int  int  int)void
    .registers 7
    # ins_size=4
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    const/4 v1, 3
    new-array v1, v1, [Lkotlin/Pair;
    const-string v2, "project_count"
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-static v2, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v2, 0
    aput-object v4, v1, v2
    const-string v4, "multi_root_save_project_count"
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v5, 1
    aput-object v4, v1, v5
    const-string v4, "multi_root_unsave_project_count"
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v5, 2
    aput-object v4, v1, v5
    invoke-static v1, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v4
    const-string v5, "ide_project_page_view"
    invoke-direct v0, v5, v4, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;-><init>(Ljava/lang/String; Ljava/util/Map;)V
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->report(Lcom/bytedance/trae/conversation/tracker/DeviceEvent;)V
    return-void 
.end method

.method public final trackOfflineDevicePageView(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string v0, "deviceType"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    const-string v1, "device_type"
    invoke-static v1, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v3
    invoke-static v3, Lkotlin/collections/MapsKt;->mapOf(Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v3
    const-string v1, "offline_device_page_view"
    invoke-direct v0, v1, v3, Lcom/bytedance/trae/conversation/tracker/DeviceEvent;-><init>(Ljava/lang/String; Ljava/util/Map;)V
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->report(Lcom/bytedance/trae/conversation/tracker/DeviceEvent;)V
    return-void 
.end method

.method public final trackPairResult$conversation_mainlandRelease(long  boolean  java.lang.String  com.bytedance.trae.conversation.devices.DeviceProductType  com.bytedance.trae.conversation.tracker.DevicePairResultDetail  com.bytedance.trae.conversation.devices.DevicePairingTrigger)void
    .registers 20
    # ins_size=8
    move-object v0, v12
    move-object/from16 v1, v16
    move-object/from16 v2, v17
    const-string v3, "enterFrom"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v3, "productType"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v3, resultDetail
    move-object/from16 v10, v18
    invoke-static v10, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v3, triggerBy
    move-object/from16 v11, v19
    invoke-static v11, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->Companion Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom$Companion;
    invoke-virtual v3, v1, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom$Companion;->from(Ljava/lang/String;)Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    move-result-object v8
    if-nez v8, +003h
    return-void 
    sget-object v4, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;
    invoke-direct v12, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->toTrackCliType(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;
    move-result-object v9
    move-wide v5, v13
    move v7, v15
    move-object/from16 v10, v18
    move-object/from16 v11, v19
    invoke-virtual/range v4 ... v11, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->pairResult(J Z Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom; Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType; Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail; Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;)Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    move-result-object v1
    invoke-direct v12, v1, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->report(Lcom/bytedance/trae/conversation/tracker/DeviceEvent;)V
    return-void 
.end method

.method public final trackPairingPageShareClick(java.lang.String  com.bytedance.trae.conversation.devices.DeviceProductType)void
    .registers 4
    # ins_size=3
    const-string v0, "enterFrom"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "productType"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->Companion Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom$Companion;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom$Companion;->from(Ljava/lang/String;)Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    move-result-object v2
    if-nez v2, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->toTrackCliType(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;
    move-result-object v3
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->pairingPageShareClick(Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom; Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;)Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    move-result-object v2
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->report(Lcom/bytedance/trae/conversation/tracker/DeviceEvent;)V
    return-void 
.end method

.method public final trackPairingPageView(java.lang.String  com.bytedance.trae.conversation.devices.DeviceProductType  com.bytedance.trae.conversation.devices.DevicePairingTrigger)void
    .registers 6
    # ins_size=4
    const-string v0, "enterFrom"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "productType"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, triggerBy
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->Companion Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom$Companion;
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom$Companion;->from(Ljava/lang/String;)Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    move-result-object v3
    if-nez v3, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;
    invoke-direct v2, v4, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->toTrackCliType(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;
    move-result-object v1
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->getCliTypeValue()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v3, v1, v4, v5, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->pairingPageView(Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom; Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;)Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    move-result-object v3
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->report(Lcom/bytedance/trae/conversation/tracker/DeviceEvent;)V
    return-void 
.end method

.method public final trackPairingStep1Complete(java.lang.String  com.bytedance.trae.conversation.devices.DeviceProductType)void
    .registers 4
    # ins_size=3
    const-string v0, "enterFrom"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "productType"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->Companion Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom$Companion;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom$Companion;->from(Ljava/lang/String;)Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    move-result-object v2
    if-nez v2, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->toTrackCliType(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;
    move-result-object v3
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->pairingStep1Complete(Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom; Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;)Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    move-result-object v2
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->report(Lcom/bytedance/trae/conversation/tracker/DeviceEvent;)V
    return-void 
.end method

.method public final trackPairingStep2Show(java.lang.String  com.bytedance.trae.conversation.devices.DeviceProductType)void
    .registers 4
    # ins_size=3
    const-string v0, "enterFrom"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "productType"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->Companion Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom$Companion;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom$Companion;->from(Ljava/lang/String;)Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    move-result-object v2
    if-nez v2, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->toTrackCliType(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;
    move-result-object v3
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->pairingStep2Show(Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom; Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;)Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    move-result-object v2
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->report(Lcom/bytedance/trae/conversation/tracker/DeviceEvent;)V
    return-void 
.end method

.method public final trackShareChannelSelect(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string v0, "enterFrom"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "channel"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->Companion Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom$Companion;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom$Companion;->from(Ljava/lang/String;)Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    move-result-object v2
    if-nez v2, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->shareChannelSelect(Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom; Ljava/lang/String;)Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    move-result-object v2
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->report(Lcom/bytedance/trae/conversation/tracker/DeviceEvent;)V
    return-void 
.end method

.method public final trackTargetSelectClick(java.lang.String  com.bytedance.trae.conversation.devices.DeviceProductType)void
    .registers 4
    # ins_size=3
    const-string v0, "enterFrom"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "productType"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->Companion Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom$Companion;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom$Companion;->from(Ljava/lang/String;)Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    move-result-object v2
    if-nez v2, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->toTrackCliType(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;
    move-result-object v3
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->targetSelectClick(Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom; Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;)Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    move-result-object v2
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->report(Lcom/bytedance/trae/conversation/tracker/DeviceEvent;)V
    return-void 
.end method

.method public final trackTargetSelectShow(java.lang.String  int  boolean  boolean)void
    .registers 6
    # ins_size=5
    const-string v0, "enterFrom"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->Companion Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom$Companion;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom$Companion;->from(Ljava/lang/String;)Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    move-result-object v2
    if-nez v2, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;
    invoke-virtual v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/tracker/DeviceEventFactory;->targetSelectShow(Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom; I Z Z)Lcom/bytedance/trae/conversation/tracker/DeviceEvent;
    move-result-object v2
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->report(Lcom/bytedance/trae/conversation/tracker/DeviceEvent;)V
    return-void 
.end method
