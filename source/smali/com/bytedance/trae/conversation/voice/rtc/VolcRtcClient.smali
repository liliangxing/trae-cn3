# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
.super Ljava/lang/Object;
.source "VolcRtcClient.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
.field private static final TAG:Ljava/lang/String;
.field private static final callerLock:Ljava/lang/Object;
.field private static bridge currentCaller:Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$CallerType;
.field private static engine:Lcom/ss/bytertc/engine/RTCEngine;
.field private static final listeners:Ljava/util/concurrent/CopyOnWriteArrayList;
.field private static rtcRoom:Lcom/ss/bytertc/engine/RTCRoom;


.method public static synthetic $r8$lambda$4aTOTVYsKVX623YU0idNMYqhEtw(com.ss.bytertc.engine.RTCRoom)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->leaveRoom$lambda$18(Lcom/ss/bytertc/engine/RTCRoom;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$JMx2DLZ9tyBnDC2-sgjjqtzG0vc(com.ss.bytertc.engine.RTCRoom)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->leave$lambda$20(Lcom/ss/bytertc/engine/RTCRoom;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$Ulix7TagwFeG1RppZ6pinM-ywlk(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener  java.lang.ref.WeakReference)boolean
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->removeListener$lambda$0(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener; Ljava/lang/ref/WeakReference;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$dDUgicGWFX9VYE-yORrS-MlDKYc(com.ss.bytertc.engine.data.AudioPropertiesInfo  com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->notifyLocalAudioProperties$lambda$10(Lcom/ss/bytertc/engine/data/AudioPropertiesInfo; Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$wEhZokIWU_uBOTQtnLiIXKVja0A(java.lang.String  int  int  com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->notifyAudioInputDeviceState$lambda$11(Ljava/lang/String; I I Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-direct v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    new-instance v0, Ljava/lang/Object;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->callerLock Ljava/lang/Object;
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-direct v0, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->listeners Ljava/util/concurrent/CopyOnWriteArrayList;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$getEngine$p()com.ss.bytertc.engine.RTCEngine
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->engine Lcom/ss/bytertc/engine/RTCEngine;
    return-object v0
.end method

.method public static final synthetic access$getRtcRoom$p()com.ss.bytertc.engine.RTCRoom
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->rtcRoom Lcom/ss/bytertc/engine/RTCRoom;
    return-object v0
.end method

.method public static final synthetic access$liveListenerCount(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient)int
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->liveListenerCount()I
    move-result v0
    return v0
.end method

.method public static final synthetic access$notifyAudioInputDeviceState(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient  java.lang.String  com.ss.bytertc.engine.type.AudioDeviceType  int  int)void
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->notifyAudioInputDeviceState(Ljava/lang/String; Lcom/ss/bytertc/engine/type/AudioDeviceType; I I)V
    return-void 
.end method

.method public static final synthetic access$notifyListeners(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient  kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->notifyListeners(Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public static final synthetic access$notifyLocalAudioProperties(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient  com.ss.bytertc.engine.data.LocalAudioPropertiesInfo[])void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->notifyLocalAudioProperties([Lcom/ss/bytertc/engine/data/LocalAudioPropertiesInfo;)V
    return-void 
.end method

.method public static final synthetic access$rtcDiag(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient  java.lang.String)java.lang.String
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$toByteArraySafely(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient  java.nio.ByteBuffer)byte[]
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->toByteArraySafely(Ljava/nio/ByteBuffer;)[B
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$toRtcNetworkQuality(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient  com.ss.bytertc.engine.type.NetworkQualityStats)com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$RtcNetworkQuality
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->toRtcNetworkQuality(Lcom/ss/bytertc/engine/type/NetworkQualityStats;)Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;
    move-result-object v0
    return-object v0
.end method

.method private final audioCaptureStateSummary()java.lang.String
    .registers 7
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->engine Lcom/ss/bytertc/engine/RTCEngine;
    sget-object v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->rtcRoom Lcom/ss/bytertc/engine/RTCRoom;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "caller="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->currentCaller Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$CallerType;
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", engineExists="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const/4 v3, 1
    const/4 v4, 0
    if-eqz v0, +004h
    move v5, v3
    goto +2h
    move v5, v4
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, ", roomExists="
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    if-eqz v1, +003h
    goto +2h
    move v3, v4
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", engineHash="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const/4 v3, 0
    if-eqz v0, +00bh
    invoke-static v0, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I
    move-result v0
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    goto +2h
    move-object v0, v3
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, ", roomHash="
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    if-eqz v1, +00ah
    invoke-static v1, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I
    move-result v1
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private static final leave$lambda$20(com.ss.bytertc.engine.RTCRoom)void
    .registers 1
    # ins_size=1
    if-eqz v0, +00ah
    invoke-virtual v0, Lcom/ss/bytertc/engine/RTCRoom;->destroy()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto +3h
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static Lcom/ss/bytertc/engine/RTCEngine;->destroyRTCEngine()V
    return-void 
    :try_start_0x2
    :try_start_0xa
.end method

.method private static final leaveRoom$lambda$18(com.ss.bytertc.engine.RTCRoom)void
    .registers 1
    # ins_size=1
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/ss/bytertc/engine/RTCRoom;->destroy()V
    return-void 
    :try_start_0x2
.end method

.method private final liveListenerCount()int
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->listeners Ljava/util/concurrent/CopyOnWriteArrayList;
    check-cast v0, Ljava/lang/Iterable;
    instance-of v1, v0, Ljava/util/Collection;
    const/4 v2, 0
    if-eqz v1, +00ch
    move-object v1, v0
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +003h
    goto +26h
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    move v1, v2
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +01bh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/ref/WeakReference;
    invoke-virtual v3, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;
    move-result-object v3
    if-eqz v3, +004h
    const/4 v3, 1
    goto +2h
    move v3, v2
    if-eqz v3, -015h
    add-int/lit8 v1, v1, 1
    if-gez v1, -019h
    invoke-static Lkotlin/collections/CollectionsKt;->throwCountOverflow()V
    goto -1eh
    move v2, v1
    return v2
.end method

.method private final notifyAudioInputDeviceState(java.lang.String  com.ss.bytertc.engine.type.AudioDeviceType  int  int)void
    .registers 6
    # ins_size=5
    sget-object v0, Lcom/ss/bytertc/engine/type/AudioDeviceType;->AUDIO_DEVICE_TYPE_CAPTURE_DEVICE Lcom/ss/bytertc/engine/type/AudioDeviceType;
    if-ne v3, v0, +00ah
    new-instance v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$$ExternalSyntheticLambda1;
    invoke-direct v3, v2, v4, v5, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$$ExternalSyntheticLambda1;-><init>(Ljava/lang/String; I I)V
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->notifyListeners(Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private static final notifyAudioInputDeviceState$lambda$11(java.lang.String  int  int  com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener)kotlin.Unit
    .registers 5
    # ins_size=4
    const-string v0, "it"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v4, v1, v2, v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;->onAudioInputDeviceStateChanged(Ljava/lang/String; I I)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final notifyListeners(kotlin.jvm.functions.Function1)void
    .registers 5
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->listeners Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-virtual v0, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const-string v1, "iterator(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +01ah
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/ref/WeakReference;
    invoke-virtual v1, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;
    if-eqz v2, +006h
    invoke-interface v4, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto -17h
    sget-object v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->listeners Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-virtual v2, v1, Ljava/util/concurrent/CopyOnWriteArrayList;->remove(Ljava/lang/Object;)Z
    goto -1dh
    return-void 
.end method

.method private final notifyLocalAudioProperties(com.ss.bytertc.engine.data.LocalAudioPropertiesInfo[])void
    .registers 3
    # ins_size=2
    if-eqz v2, +017h
    invoke-static v2, Lkotlin/collections/ArraysKt;->firstOrNull([Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/ss/bytertc/engine/data/LocalAudioPropertiesInfo;
    if-eqz v2, +00fh
    iget-object v2, v2, Lcom/ss/bytertc/engine/data/LocalAudioPropertiesInfo;->audioPropertiesInfo Lcom/ss/bytertc/engine/data/AudioPropertiesInfo;
    if-nez v2, +003h
    goto +9h
    new-instance v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$$ExternalSyntheticLambda3;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$$ExternalSyntheticLambda3;-><init>(Lcom/ss/bytertc/engine/data/AudioPropertiesInfo;)V
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->notifyListeners(Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private static final notifyLocalAudioProperties$lambda$10(com.ss.bytertc.engine.data.AudioPropertiesInfo  com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener)kotlin.Unit
    .registers 11
    # ins_size=2
    const-string v0, "it"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget v0, v9, Lcom/ss/bytertc/engine/data/AudioPropertiesInfo;->linearVolume I
    invoke-interface v10, v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;->onLocalAudioLevel(I)V
    new-instance v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcLocalAudioProperties;
    iget v2, v9, Lcom/ss/bytertc/engine/data/AudioPropertiesInfo;->linearVolume I
    iget v3, v9, Lcom/ss/bytertc/engine/data/AudioPropertiesInfo;->nonlinearVolume I
    iget v4, v9, Lcom/ss/bytertc/engine/data/AudioPropertiesInfo;->vad I
    const-wide/16 v5, 0
    const/16 v7, 8
    const/4 v8, 0
    move-object v1, v0
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcLocalAudioProperties;-><init>(I I I J I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v10, v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;->onLocalAudioProperties(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcLocalAudioProperties;)V
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
.end method

.method private static final removeListener$lambda$0(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener  java.lang.ref.WeakReference)boolean
    .registers 2
    # ins_size=2
    invoke-virtual v1, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method private final rtcDiag(java.lang.String)java.lang.String
    .registers 4
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "RTC_DIAG "
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method private final toByteArraySafely(java.nio.ByteBuffer)byte[]
    .registers 3
    # ins_size=2
    invoke-virtual v2, Ljava/nio/ByteBuffer;->duplicate()Ljava/nio/ByteBuffer;
    move-result-object v2
    invoke-virtual v2, Ljava/nio/ByteBuffer;->remaining()I
    move-result v0
    new-array v0, v0, [B
    invoke-virtual v2, v0, Ljava/nio/ByteBuffer;->get([B)Ljava/nio/ByteBuffer;
    return-object v0
.end method

.method private final toRtcNetworkQuality(com.ss.bytertc.engine.type.NetworkQualityStats)com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$RtcNetworkQuality
    .registers 11
    # ins_size=2
    new-instance v8, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;
    iget-object v1, v10, Lcom/ss/bytertc/engine/type/NetworkQualityStats;->uid Ljava/lang/String;
    iget-wide v2, v10, Lcom/ss/bytertc/engine/type/NetworkQualityStats;->fractionLost D
    iget v4, v10, Lcom/ss/bytertc/engine/type/NetworkQualityStats;->rtt I
    iget v5, v10, Lcom/ss/bytertc/engine/type/NetworkQualityStats;->totalBandwidth I
    iget v6, v10, Lcom/ss/bytertc/engine/type/NetworkQualityStats;->txQuality I
    iget v7, v10, Lcom/ss/bytertc/engine/type/NetworkQualityStats;->rxQuality I
    move-object v0, v8
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;-><init>(Ljava/lang/String; D I I I I)V
    return-object v8
.end method

.method public final addListener(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener)void
    .registers 4
    # ins_size=2
    const-string v0, "listener"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->listeners Ljava/util/concurrent/CopyOnWriteArrayList;
    new-instance v1, Ljava/lang/ref/WeakReference;
    invoke-direct v1, v3, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V
    invoke-virtual v0, v1, Ljava/util/concurrent/CopyOnWriteArrayList;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final join$conversation_mainlandRelease(com.bytedance.trae.conversation.voice.network.StartVoiceChatData  com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener  com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$CallerType)boolean
    .registers 27
    # ins_size=4
    move-object/from16 v1, v23
    move-object/from16 v0, v24
    move-object/from16 v2, v25
    move-object/from16 v3, v26
    const-string v4, "join refused: currentCaller="
    const-string/jumbo v5, voiceChat
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v5, "listener"
    invoke-static v2, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v5, "caller"
    invoke-static v3, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v24, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getAppId()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +004h
    const-string v5, ""
    invoke-virtual/range v24, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v6
    if-nez v6, +004h
    const-string v6, ""
    invoke-virtual/range v24, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getUserId()Ljava/lang/String;
    move-result-object v7
    if-nez v7, +004h
    const-string v7, ""
    invoke-virtual/range v24, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getToken()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +004h
    const-string v8, ""
    sget-object v9, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v10, "VolcRtcClient"
    new-instance v11, Ljava/lang/StringBuilder;
    const-string v12, "join begin: caller="
    invoke-direct v11, v12, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v11, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v11
    const-string v12, ", appId="
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    const-string v12, ", roomId="
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    const-string v12, ", userId="
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    const-string v12, ", taskId="
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual/range v24, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    const-string v12, ", tokenLength="
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v8, Ljava/lang/String;->length()I
    move-result v12
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v11
    const-string v12, ", tokenHash="
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v8, Ljava/lang/String;->hashCode()I
    move-result v12
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v11
    const-string v12, ", currentCaller="
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    sget-object v12, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->currentCaller Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$CallerType;
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v11
    const-string v12, ", engineExists="
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    sget-object v12, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->engine Lcom/ss/bytertc/engine/RTCEngine;
    const/4 v13, 0
    const/4 v14, 1
    if-eqz v12, +004h
    move v12, v14
    goto +2h
    move v12, v13
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v11
    const-string v12, ", roomExists="
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    sget-object v12, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->rtcRoom Lcom/ss/bytertc/engine/RTCRoom;
    if-eqz v12, +004h
    move v12, v14
    goto +2h
    move v12, v13
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-direct v1, v11, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v11
    invoke-virtual v9, v10, v11, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    move-object v9, v5
    check-cast v9, Ljava/lang/CharSequence;
    invoke-static v9, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v9
    if-nez v9, +1b1h
    move-object v9, v6
    check-cast v9, Ljava/lang/CharSequence;
    invoke-static v9, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v9
    if-nez v9, +1a8h
    move-object v9, v7
    check-cast v9, Ljava/lang/CharSequence;
    invoke-static v9, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v9
    if-nez v9, +19fh
    move-object v9, v8
    check-cast v9, Ljava/lang/CharSequence;
    invoke-static v9, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v9
    if-eqz v9, +004h
    goto/16 +194h
    sget-object v9, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->callerLock Ljava/lang/Object;
    monitor-enter v9
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->currentCaller Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$CallerType;
    if-eqz v0, +02ah
    if-eq v0, v3, +028h
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v5, "VolcRtcClient"
    sget-object v6, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v4, " busy, requested caller="
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v6, v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v5, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    monitor-exit v9
    return v13
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    sput-object v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->currentCaller Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$CallerType;
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v9
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->addListener(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;)V
    new-instance v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$engineHandler$1;
    invoke-direct v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$engineHandler$1;-><init>()V
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v3
    if-eqz v3, +005h
    const-string v3, "AREA_CODE_OVERSEA"
    goto +3h
    const-string v3, "AREA_CODE_CN"
    new-instance v4, Lorg/json/JSONObject;
    invoke-direct v4, Lorg/json/JSONObject;-><init>()V
    const-string v9, "mediaAreaList"
    new-instance v10, Lorg/json/JSONArray;
    invoke-direct v10, Lorg/json/JSONArray;-><init>()V
    invoke-virtual v10, v3, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    move-result-object v10
    invoke-virtual v4, v9, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v9, "dataAreaList"
    new-instance v10, Lorg/json/JSONArray;
    invoke-direct v10, Lorg/json/JSONArray;-><init>()V
    invoke-virtual v10, v3, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    move-result-object v3
    invoke-virtual v4, v9, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    const-string v9, "direction"
    invoke-virtual v3, v9, v14, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string/jumbo v9, support_sentence_id
    invoke-virtual v3, v9, v14, Lorg/json/JSONObject;->put(Ljava/lang/String; Z)Lorg/json/JSONObject;
    new-instance v9, Lcom/ss/bytertc/engine/data/EngineConfig;
    invoke-direct v9, Lcom/ss/bytertc/engine/data/EngineConfig;-><init>()V
    sget-object v10, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v10, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v10
    check-cast v10, Landroid/content/Context;
    iput-object v10, v9, Lcom/ss/bytertc/engine/data/EngineConfig;->context Landroid/content/Context;
    iput-object v5, v9, Lcom/ss/bytertc/engine/data/EngineConfig;->appID Ljava/lang/String;
    new-instance v5, Lorg/json/JSONObject;
    invoke-direct v5, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v10, rtc.area_code
    invoke-virtual v5, v10, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v4, rtc.fg_config
    const-string v10, "aigc_media_360=true"
    invoke-virtual v5, v4, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v4, rtc.set_audio_burst_mode
    invoke-virtual v5, v4, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    iput-object v5, v9, Lcom/ss/bytertc/engine/data/EngineConfig;->parameters Lorg/json/JSONObject;
    check-cast v2, Lcom/ss/bytertc/engine/handler/IRTCEngineEventHandler;
    invoke-static v9, v2, Lcom/ss/bytertc/engine/RTCEngine;->createRTCEngine(Lcom/ss/bytertc/engine/data/EngineConfig; Lcom/ss/bytertc/engine/handler/IRTCEngineEventHandler;)Lcom/ss/bytertc/engine/RTCEngine;
    move-result-object v2
    sput-object v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->engine Lcom/ss/bytertc/engine/RTCEngine;
    if-eqz v2, +007h
    sget-object v3, Lcom/ss/bytertc/engine/type/AudioScenarioType;->GAMESTREAMING Lcom/ss/bytertc/engine/type/AudioScenarioType;
    invoke-virtual v2, v3, Lcom/ss/bytertc/engine/RTCEngine;->setAudioScenario(Lcom/ss/bytertc/engine/type/AudioScenarioType;)I
    sget-object v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->engine Lcom/ss/bytertc/engine/RTCEngine;
    if-eqz v2, +00ch
    new-instance v3, Lcom/ss/bytertc/engine/data/AudioPropertiesConfig;
    const/16 v4, 100
    invoke-direct v3, v4, v13, v14, Lcom/ss/bytertc/engine/data/AudioPropertiesConfig;-><init>(I Z Z)V
    invoke-virtual v2, v3, Lcom/ss/bytertc/engine/RTCEngine;->enableAudioPropertiesReport(Lcom/ss/bytertc/engine/data/AudioPropertiesConfig;)I
    sget-object v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->engine Lcom/ss/bytertc/engine/RTCEngine;
    if-eqz v2, +005h
    invoke-virtual v2, Lcom/ss/bytertc/engine/RTCEngine;->startAudioCapture()I
    sget-object v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->engine Lcom/ss/bytertc/engine/RTCEngine;
    const/4 v3, 0
    if-eqz v2, +007h
    invoke-virtual v2, v6, Lcom/ss/bytertc/engine/RTCEngine;->createRTCRoom(Ljava/lang/String;)Lcom/ss/bytertc/engine/RTCRoom;
    move-result-object v2
    goto +2h
    move-object v2, v3
    if-eqz v2, +08ah
    new-instance v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1;
    invoke-direct v3, v6, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1;-><init>(Ljava/lang/String;)V
    check-cast v3, Lcom/ss/bytertc/engine/handler/IRTCRoomEventHandler;
    invoke-virtual v2, v3, Lcom/ss/bytertc/engine/RTCRoom;->setRTCRoomEventHandler(Lcom/ss/bytertc/engine/handler/IRTCRoomEventHandler;)I
    const/16 v17, 1
    const/16 v19, 1
    const/16 v18, 0
    const/16 v20, 0
    const/16 v21, 1
    const/16 v22, 3000
    new-instance v3, Lcom/ss/bytertc/engine/RTCRoomConfig;
    sget-object v16, Lcom/ss/bytertc/engine/type/RoomProfile;->CHAT_ROOM Lcom/ss/bytertc/engine/type/RoomProfile;
    move-object v15, v3
    invoke-direct/range v15 ... v22, Lcom/ss/bytertc/engine/RTCRoomConfig;-><init>(Lcom/ss/bytertc/engine/type/RoomProfile; Z Z Z Z Z I)V
    new-instance v4, Lcom/ss/bytertc/engine/UserInfo;
    const-string v5, ""
    invoke-direct v4, v7, v5, Lcom/ss/bytertc/engine/UserInfo;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v2, v8, v4, v14, v3, Lcom/ss/bytertc/engine/RTCRoom;->joinRoom(Ljava/lang/String; Lcom/ss/bytertc/engine/UserInfo; Z Lcom/ss/bytertc/engine/RTCRoomConfig;)I
    move-result v3
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v5, "VolcRtcClient"
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v9, "joinRoom result: roomId="
    invoke-direct v8, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v8, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v9, ", userId="
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v9, ", result="
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-direct v0, v8, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    invoke-virtual v4, v5, v8, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v3, +030h
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v5, "VolcRtcClient"
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v9, "joinRoom returned non-zero: roomId="
    invoke-direct v8, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v8, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v9, ", userId="
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, ", result="
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    invoke-virtual v4, v5, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    move-object v3, v2
    sput-object v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->rtcRoom Lcom/ss/bytertc/engine/RTCRoom;
    if-nez v3, +02bh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "VolcRtcClient"
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "join skipped: createRTCRoom returned null, roomId="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", engineExists="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->engine Lcom/ss/bytertc/engine/RTCEngine;
    if-eqz v4, +003h
    move v13, v14
    invoke-virtual v3, v13, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    return v14
    move-exception v0
    monitor-exit v9
    throw v0
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v4, "VolcRtcClient"
    new-instance v9, Ljava/lang/StringBuilder;
    const-string v10, "join invalid voiceChat data: appId="
    invoke-direct v9, v10, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v9, ", roomId="
    invoke-virtual v5, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, ", userId="
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, ", hasToken="
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    check-cast v8, Ljava/lang/CharSequence;
    invoke-static v8, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v6
    xor-int/2addr v6, v14
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-direct v1, v5, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v3, v4, v5, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v3, Ljava/lang/IllegalArgumentException;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "invalid voiceChat data: "
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v3, v0, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V
    check-cast v3, Ljava/lang/Throwable;
    invoke-interface v2, v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;->onError(Ljava/lang/Throwable;)V
    return v13
    :try_start_0xf5
    :try_start_0x121
.end method

.method public final leave()void
    .registers 7
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->rtcRoom Lcom/ss/bytertc/engine/RTCRoom;
    const/4 v1, 0
    sput-object v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->rtcRoom Lcom/ss/bytertc/engine/RTCRoom;
    sput-object v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->engine Lcom/ss/bytertc/engine/RTCEngine;
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v3, "VolcRtcClient"
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "leave: roomExists="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    if-eqz v0, +004h
    const/4 v5, 1
    goto +2h
    const/4 v5, 0
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", caller="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->currentCaller Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$CallerType;
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-direct v6, v4, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v3, v4, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->callerLock Ljava/lang/Object;
    monitor-enter v2
    sput-object v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->currentCaller Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$CallerType;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v2
    invoke-static Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$$ExternalSyntheticLambda2;
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$$ExternalSyntheticLambda2;-><init>(Lcom/ss/bytertc/engine/RTCRoom;)V
    invoke-interface v1, v2, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V
    invoke-interface v1, Ljava/util/concurrent/ExecutorService;->shutdown()V
    return-void 
    move-exception v0
    monitor-exit v2
    throw v0
    :try_start_0x35
.end method

.method public final leaveRoom()void
    .registers 9
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->rtcRoom Lcom/ss/bytertc/engine/RTCRoom;
    const/4 v1, 0
    sput-object v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->rtcRoom Lcom/ss/bytertc/engine/RTCRoom;
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v3, "VolcRtcClient"
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "leaveRoom: roomExists="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const/4 v5, 1
    const/4 v6, 0
    if-eqz v0, +004h
    move v7, v5
    goto +2h
    move v7, v6
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v7, ", engineExists="
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    sget-object v7, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->engine Lcom/ss/bytertc/engine/RTCEngine;
    if-eqz v7, +003h
    goto +2h
    move v5, v6
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", caller="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->currentCaller Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$CallerType;
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-direct v8, v4, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v3, v4, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->callerLock Ljava/lang/Object;
    monitor-enter v2
    sput-object v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->currentCaller Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$CallerType;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v2
    invoke-static Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$$ExternalSyntheticLambda4;
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$$ExternalSyntheticLambda4;-><init>(Lcom/ss/bytertc/engine/RTCRoom;)V
    invoke-interface v1, v2, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V
    invoke-interface v1, Ljava/util/concurrent/ExecutorService;->shutdown()V
    return-void 
    move-exception v0
    monitor-exit v2
    throw v0
    :try_start_0x45
.end method

.method public final preloadEngine(java.lang.String)void
    .registers 7
    # ins_size=2
    const-string v0, "appId"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-eqz v0, +005h
    const-string v0, "AREA_CODE_OVERSEA"
    goto +3h
    const-string v0, "AREA_CODE_CN"
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    new-instance v2, Lorg/json/JSONArray;
    invoke-direct v2, Lorg/json/JSONArray;-><init>()V
    invoke-virtual v2, v0, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    move-result-object v2
    const-string v3, "mediaAreaList"
    invoke-virtual v1, v3, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    new-instance v2, Lorg/json/JSONArray;
    invoke-direct v2, Lorg/json/JSONArray;-><init>()V
    invoke-virtual v2, v0, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    move-result-object v0
    const-string v2, "dataAreaList"
    invoke-virtual v1, v2, v0, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v2, "direction"
    const/4 v3, 1
    invoke-virtual v0, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string/jumbo v2, support_sentence_id
    invoke-virtual v0, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Z)Lorg/json/JSONObject;
    new-instance v2, Lcom/ss/bytertc/engine/data/EngineConfig;
    invoke-direct v2, Lcom/ss/bytertc/engine/data/EngineConfig;-><init>()V
    sget-object v4, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v4
    check-cast v4, Landroid/content/Context;
    iput-object v4, v2, Lcom/ss/bytertc/engine/data/EngineConfig;->context Landroid/content/Context;
    iput-object v6, v2, Lcom/ss/bytertc/engine/data/EngineConfig;->appID Ljava/lang/String;
    new-instance v6, Lorg/json/JSONObject;
    invoke-direct v6, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v4, rtc.area_code
    invoke-virtual v6, v4, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v1, rtc.fg_config
    const-string v4, "aigc_media_360=true"
    invoke-virtual v6, v1, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v1, rtc.set_audio_burst_mode
    invoke-virtual v6, v1, v0, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    iput-object v6, v2, Lcom/ss/bytertc/engine/data/EngineConfig;->parameters Lorg/json/JSONObject;
    new-instance v6, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$preloadEngine$engineHandler$1;
    invoke-direct v6, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$preloadEngine$engineHandler$1;-><init>()V
    check-cast v6, Lcom/ss/bytertc/engine/handler/IRTCEngineEventHandler;
    invoke-static v2, v6, Lcom/ss/bytertc/engine/RTCEngine;->createRTCEngine(Lcom/ss/bytertc/engine/data/EngineConfig; Lcom/ss/bytertc/engine/handler/IRTCEngineEventHandler;)Lcom/ss/bytertc/engine/RTCEngine;
    move-result-object v6
    sput-object v6, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->engine Lcom/ss/bytertc/engine/RTCEngine;
    if-eqz v6, +007h
    sget-object v0, Lcom/ss/bytertc/engine/type/AnsMode;->ANS_MODE_AUTOMATIC Lcom/ss/bytertc/engine/type/AnsMode;
    invoke-virtual v6, v0, Lcom/ss/bytertc/engine/RTCEngine;->setAnsMode(Lcom/ss/bytertc/engine/type/AnsMode;)I
    sget-object v6, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->engine Lcom/ss/bytertc/engine/RTCEngine;
    if-eqz v6, +007h
    sget-object v0, Lcom/ss/bytertc/engine/type/AudioScenarioType;->GAMESTREAMING Lcom/ss/bytertc/engine/type/AudioScenarioType;
    invoke-virtual v6, v0, Lcom/ss/bytertc/engine/RTCEngine;->setAudioScenario(Lcom/ss/bytertc/engine/type/AudioScenarioType;)I
    sget-object v6, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->engine Lcom/ss/bytertc/engine/RTCEngine;
    if-eqz v6, +00dh
    new-instance v0, Lcom/ss/bytertc/engine/data/AudioPropertiesConfig;
    const/16 v1, 100
    const/4 v2, 0
    invoke-direct v0, v1, v2, v3, Lcom/ss/bytertc/engine/data/AudioPropertiesConfig;-><init>(I Z Z)V
    invoke-virtual v6, v0, Lcom/ss/bytertc/engine/RTCEngine;->enableAudioPropertiesReport(Lcom/ss/bytertc/engine/data/AudioPropertiesConfig;)I
    return-void 
.end method

.method public final removeListener(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener)void
    .registers 4
    # ins_size=2
    const-string v0, "listener"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->listeners Ljava/util/concurrent/CopyOnWriteArrayList;
    check-cast v0, Ljava/util/List;
    new-instance v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$$ExternalSyntheticLambda0;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;)V
    invoke-static v0, v1, Lkotlin/collections/CollectionsKt;->removeAll(Ljava/util/List; Lkotlin/jvm/functions/Function1;)Z
    return-void 
.end method

.method public final sendServerMessage(java.lang.String)long
    .registers 10
    # ins_size=2
    const-string v0, "message"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->engine Lcom/ss/bytertc/engine/RTCEngine;
    const-wide/16 v1, -1
    const-string v3, ", hash="
    const-string v4, "VolcRtcClient"
    if-nez v0, +02eh
    move-object v0, v8
    check-cast v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "engine is null, cannot sendServerMessage, length="
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, Ljava/lang/String;->length()I
    move-result v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v9, Ljava/lang/String;->hashCode()I
    move-result v9
    invoke-virtual v3, v9, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-direct v8, v9, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    invoke-virtual v0, v4, v9, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    return-wide v1
    invoke-virtual v0, v9, Lcom/ss/bytertc/engine/RTCEngine;->sendServerMessage(Ljava/lang/String;)J
    move-result-wide v1
    goto +2bh
    move-exception v0
    sget-object v5, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v6, Ljava/lang/StringBuilder;
    const-string/jumbo v7, sendServerMessage failed: length=
    invoke-direct v6, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, Ljava/lang/String;->length()I
    move-result v7
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v9, Ljava/lang/String;->hashCode()I
    move-result v9
    invoke-virtual v3, v9, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-direct v8, v9, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    invoke-virtual v5, v4, v9, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-wide v1
    :try_start_0x3b
.end method

.method public final sendUserBinaryMessageToBot(java.lang.String  byte[])void
    .registers 9
    # ins_size=3
    const-string v0, "botUserId"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "message"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->rtcRoom Lcom/ss/bytertc/engine/RTCRoom;
    const-string v1, ", size="
    const-string v2, "VolcRtcClient"
    if-nez v0, +028h
    move-object v0, v6
    check-cast v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, rtcRoom is null, cannot send message to bot, botUserId=
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    array-length v8, v8
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    invoke-virtual v0, v2, v7, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    sget-object v3, Lcom/ss/bytertc/engine/type/MessageConfig;->RELIABLE_ORDERED Lcom/ss/bytertc/engine/type/MessageConfig;
    invoke-virtual v0, v7, v8, v3, Lcom/ss/bytertc/engine/RTCRoom;->sendUserBinaryMessage(Ljava/lang/String; [B Lcom/ss/bytertc/engine/type/MessageConfig;)J
    goto +24h
    move-exception v0
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string/jumbo v5, sendUserBinaryMessageToBot failed: botUserId=
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    array-length v8, v8
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    invoke-virtual v3, v2, v7, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x38
.end method

.method public final setServerParams(java.lang.String  java.lang.String)void
    .registers 9
    # ins_size=3
    const-string/jumbo v0, signature
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, url
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->engine Lcom/ss/bytertc/engine/RTCEngine;
    const-string v1, ", url="
    const-string v2, "VolcRtcClient"
    if-nez v0, +02ah
    move-object v0, v6
    check-cast v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "engine is null, cannot setServerParams, signatureLength="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, Ljava/lang/String;->length()I
    move-result v7
    invoke-virtual v3, v7, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    invoke-virtual v0, v2, v7, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    invoke-virtual v0, v7, v8, Lcom/ss/bytertc/engine/RTCEngine;->setServerParams(Ljava/lang/String; Ljava/lang/String;)I
    goto +27h
    move-exception v0
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string/jumbo v5, setServerParams failed: signatureLength=
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, Ljava/lang/String;->length()I
    move-result v7
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    invoke-virtual v3, v2, v7, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x3c
.end method

.method public final startAudioCapture()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, startAudioCapture: 
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->audioCaptureStateSummary()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-direct v3, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    const-string v2, "VolcRtcClient"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->engine Lcom/ss/bytertc/engine/RTCEngine;
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/ss/bytertc/engine/RTCEngine;->startAudioCapture()I
    return-void 
.end method

.method public final stopAudioCapture()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, stopAudioCapture: 
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->audioCaptureStateSummary()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-direct v3, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    const-string v2, "VolcRtcClient"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->engine Lcom/ss/bytertc/engine/RTCEngine;
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/ss/bytertc/engine/RTCEngine;->stopAudioCapture()I
    return-void 
.end method
