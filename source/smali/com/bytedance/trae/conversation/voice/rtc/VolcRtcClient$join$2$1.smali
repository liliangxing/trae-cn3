# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1;
.super Lcom/ss/bytertc/engine/handler/IRTCRoomEventHandler;
.source "VolcRtcClient.kt"

.field final synthetic $roomId:Ljava/lang/String;


.method public static synthetic $r8$lambda$-3lmdaq9VXC-t_QBtgUHCiUHFf8(java.lang.String  com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1;->onUserJoined$lambda$1$lambda$0(Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$EPYifqZhcJmhFQseO9xGCW6zbOg(java.lang.String  java.lang.String  com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1;->onUserMessageReceived$lambda$6(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Zm3BVOKg3Cw8wkOwNMrszQKRjhU(java.lang.String  byte[]  com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1;->onUserBinaryMessageReceived$lambda$4(Ljava/lang/String; [B Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$_-l_Ovubx-njRcDeYiPwg2A3z3w(java.lang.String  com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1;->onRoomStateChanged$lambda$2(Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$eWzDY3vSnYtA-mHDoWfwWhJx86c(java.lang.String  java.lang.String  com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1;->onUserMessageReceived$lambda$5(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$s_VCuMUJtQzNCjzTTPGIp761mhA(java.lang.String  byte[]  com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1;->onRoomBinaryMessageReceived$lambda$3(Ljava/lang/String; [B Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$wtHPgpK5eiRbikojFsXzu9cRUoQ(com.ss.bytertc.engine.type.NetworkQualityStats  com.ss.bytertc.engine.type.NetworkQualityStats[]  com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1;->onNetworkQuality$lambda$8(Lcom/ss/bytertc/engine/type/NetworkQualityStats; [Lcom/ss/bytertc/engine/type/NetworkQualityStats; Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1;->$roomId Ljava/lang/String;
    invoke-direct v0, Lcom/ss/bytertc/engine/handler/IRTCRoomEventHandler;-><init>()V
    return-void 
.end method

.method private static final onNetworkQuality$lambda$8(com.ss.bytertc.engine.type.NetworkQualityStats  com.ss.bytertc.engine.type.NetworkQualityStats[]  com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener)kotlin.Unit
    .registers 8
    # ins_size=3
    const-string v0, "it"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-static v0, v5, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->access$toRtcNetworkQuality(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient; Lcom/ss/bytertc/engine/type/NetworkQualityStats;)Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;
    move-result-object v5
    new-instance v0, Ljava/util/ArrayList;
    array-length v1, v6
    invoke-direct v0, v1, Ljava/util/ArrayList;-><init>(I)V
    check-cast v0, Ljava/util/Collection;
    array-length v1, v6
    const/4 v2, 0
    if-ge v2, v1, +010h
    aget-object v3, v6, v2
    sget-object v4, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-static v4, v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->access$toRtcNetworkQuality(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient; Lcom/ss/bytertc/engine/type/NetworkQualityStats;)Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;
    move-result-object v3
    invoke-interface v0, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    add-int/lit8 v2, v2, 1
    goto -fh
    check-cast v0, Ljava/util/List;
    invoke-interface v7, v5, v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;->onNetworkQuality(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality; Ljava/util/List;)V
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
.end method

.method private static final onRoomBinaryMessageReceived$lambda$3(java.lang.String  byte[]  com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener)kotlin.Unit
    .registers 4
    # ins_size=3
    const-string v0, "it"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v3, v1, v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;->onRoomBinaryMessage(Ljava/lang/String; [B)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onRoomStateChanged$lambda$2(java.lang.String  com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "it"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;->onJoinedRoom(Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onUserBinaryMessageReceived$lambda$4(java.lang.String  byte[]  com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener)kotlin.Unit
    .registers 4
    # ins_size=3
    const-string v0, "it"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v3, v1, v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;->onRoomBinaryMessage(Ljava/lang/String; [B)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onUserJoined$lambda$1$lambda$0(java.lang.String  com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "it"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;->onRemoteUserJoined(Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onUserMessageReceived$lambda$5(java.lang.String  java.lang.String  com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener)kotlin.Unit
    .registers 4
    # ins_size=3
    const-string v0, "it"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v3, v1, v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;->onUserMessage(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onUserMessageReceived$lambda$6(java.lang.String  java.lang.String  com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener)kotlin.Unit
    .registers 4
    # ins_size=3
    const-string v0, "it"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v3, v1, v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;->onUserMessage(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public onNetworkQuality(com.ss.bytertc.engine.type.NetworkQualityStats  com.ss.bytertc.engine.type.NetworkQualityStats[])void
    .registers 5
    # ins_size=3
    const-string v0, "localQuality"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "remoteQualities"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    new-instance v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1$$ExternalSyntheticLambda4;
    invoke-direct v1, v3, v4, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1$$ExternalSyntheticLambda4;-><init>(Lcom/ss/bytertc/engine/type/NetworkQualityStats; [Lcom/ss/bytertc/engine/type/NetworkQualityStats;)V
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->access$notifyListeners(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public onRoomBinaryMessageReceived(java.lang.String  java.nio.ByteBuffer)void
    .registers 5
    # ins_size=3
    const-string/jumbo v0, uid
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "message"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-static v0, v4, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->access$toByteArraySafely(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient; Ljava/nio/ByteBuffer;)[B
    move-result-object v4
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    new-instance v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1$$ExternalSyntheticLambda5;
    invoke-direct v1, v3, v4, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1$$ExternalSyntheticLambda5;-><init>(Ljava/lang/String; [B)V
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->access$notifyListeners(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public onRoomStateChanged(java.lang.String  java.lang.String  int  java.lang.String)void
    .registers 13
    # ins_size=5
    const-string/jumbo v0, roomId
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, uid
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "extraInfo"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    sget-object v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "onRoomStateChanged: roomId="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", uid="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v4, ", state="
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, ", listenerCount="
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    sget-object v5, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-static v5, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->access$liveListenerCount(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;)I
    move-result v5
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, ", extra="
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->access$rtcDiag(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    const-string v2, "VolcRtcClient"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    if-nez v11, +00dh
    sget-object v10, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    new-instance v11, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1$$ExternalSyntheticLambda3;
    invoke-direct v11, v9, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1$$ExternalSyntheticLambda3;-><init>(Ljava/lang/String;)V
    invoke-static v10, v11, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->access$notifyListeners(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient; Lkotlin/jvm/functions/Function1;)V
    goto +33h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    sget-object v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v7, "onRoomStateChanged non-success: roomId="
    invoke-direct v6, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v11, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-static v1, v9, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->access$rtcDiag(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    invoke-virtual v0, v2, v9, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public onUserBinaryMessageReceived(java.lang.String  java.nio.ByteBuffer)void
    .registers 5
    # ins_size=3
    const-string/jumbo v0, uid
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "message"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-static v0, v4, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->access$toByteArraySafely(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient; Ljava/nio/ByteBuffer;)[B
    move-result-object v4
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    new-instance v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1$$ExternalSyntheticLambda2;
    invoke-direct v1, v3, v4, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1$$ExternalSyntheticLambda2;-><init>(Ljava/lang/String; [B)V
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->access$notifyListeners(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public onUserJoined(com.ss.bytertc.engine.UserInfo)void
    .registers 6
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    sget-object v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "onUserJoined: roomId="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v3, v4, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1;->$roomId Ljava/lang/String;
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", uid="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    if-eqz v5, +005h
    iget-object v3, v5, Lcom/ss/bytertc/engine/UserInfo;->uid Ljava/lang/String;
    goto +2h
    const/4 v3, 0
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", listenerCount="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-static v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->access$liveListenerCount(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;)I
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->access$rtcDiag(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    const-string v2, "VolcRtcClient"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v5, +010h
    iget-object v5, v5, Lcom/ss/bytertc/engine/UserInfo;->uid Ljava/lang/String;
    if-eqz v5, +00ch
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    new-instance v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1$$ExternalSyntheticLambda0;
    invoke-direct v1, v5, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1$$ExternalSyntheticLambda0;-><init>(Ljava/lang/String;)V
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->access$notifyListeners(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient; Lkotlin/jvm/functions/Function1;)V
    invoke-static Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->access$getRtcRoom$p()Lcom/ss/bytertc/engine/RTCRoom;
    move-result-object v5
    if-eqz v5, +006h
    const/4 v0, 1
    invoke-virtual v5, v0, Lcom/ss/bytertc/engine/RTCRoom;->publishScreenAudio(Z)I
    new-instance v5, Lorg/json/JSONObject;
    invoke-direct v5, Lorg/json/JSONObject;-><init>()V
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "is_cache_audio_data"
    const/4 v3, 0
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Z)Lorg/json/JSONObject;
    const-string v1, "cache_audio_data_ms"
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string/jumbo v1, rtc.pre_cache_config
    invoke-virtual v5, v1, v0, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-static Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->access$getEngine$p()Lcom/ss/bytertc/engine/RTCEngine;
    move-result-object v0
    if-eqz v0, +015h
    invoke-virtual v0, v5, Lcom/ss/bytertc/engine/RTCEngine;->setRuntimeParameters(Lorg/json/JSONObject;)I
    goto +10h
    move-exception v5
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    sget-object v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    const-string/jumbo v3, set pre cache runtime parameters failed
    invoke-static v1, v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->access$rtcDiag(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v2, v1, v5, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x5d
.end method

.method public onUserMessageReceived(long  java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=5
    const-string/jumbo v1, uid
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "message"
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    new-instance v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1$$ExternalSyntheticLambda6;
    invoke-direct v2, v3, v4, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1$$ExternalSyntheticLambda6;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v1, v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->access$notifyListeners(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public onUserMessageReceived(java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=3
    const-string/jumbo v0, uid
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "message"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    new-instance v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1$$ExternalSyntheticLambda1;
    invoke-direct v1, v3, v4, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1$$ExternalSyntheticLambda1;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->access$notifyListeners(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method
