# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$engineHandler$1;
.super Lcom/ss/bytertc/engine/handler/IRTCEngineEventHandler;
.source "VolcRtcClient.kt"


.method public static synthetic $r8$lambda$FT-UJy1-_id9XWXudeiYWPc0nyU(int  com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$engineHandler$1;->onServerParamsSetResult$lambda$1(I Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$PyRO9S1T9h9yXrqJYIeHAQ2VPzc(int  com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$engineHandler$1;->onError$lambda$0(I Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/ss/bytertc/engine/handler/IRTCEngineEventHandler;-><init>()V
    return-void 
.end method

.method private static final onError$lambda$0(int  com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener)kotlin.Unit
    .registers 5
    # ins_size=2
    const-string v0, "it"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/RuntimeException;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "RTC onError: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-direct v0, v3, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V
    check-cast v0, Ljava/lang/Throwable;
    invoke-interface v4, v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;->onError(Ljava/lang/Throwable;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private static final onServerParamsSetResult$lambda$1(int  com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "it"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;->onServerParamsSetResult(I)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public onAudioDeviceStateChanged(java.lang.String  com.ss.bytertc.engine.type.AudioDeviceType  int  int)void
    .registers 6
    # ins_size=5
    const-string v0, "deviceID"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "deviceType"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-static v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->access$notifyAudioInputDeviceState(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient; Ljava/lang/String; Lcom/ss/bytertc/engine/type/AudioDeviceType; I I)V
    return-void 
.end method

.method public onError(int)void
    .registers 6
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    sget-object v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "RTC onError: "
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->access$rtcDiag(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    const-string v2, "VolcRtcClient"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    new-instance v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$engineHandler$1$$ExternalSyntheticLambda0;
    invoke-direct v1, v5, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$engineHandler$1$$ExternalSyntheticLambda0;-><init>(I)V
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->access$notifyListeners(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public onLocalAudioPropertiesReport(com.ss.bytertc.engine.data.LocalAudioPropertiesInfo[])void
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->access$notifyLocalAudioProperties(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient; [Lcom/ss/bytertc/engine/data/LocalAudioPropertiesInfo;)V
    return-void 
.end method

.method public onServerParamsSetResult(int)void
    .registers 6
    # ins_size=2
    if-eqz v5, +01eh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    sget-object v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "onServerParamsSetResult: error="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->access$rtcDiag(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    const-string v2, "VolcRtcClient"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    new-instance v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$engineHandler$1$$ExternalSyntheticLambda1;
    invoke-direct v1, v5, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$engineHandler$1$$ExternalSyntheticLambda1;-><init>(I)V
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->access$notifyListeners(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public onWarning(int)void
    .registers 6
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    sget-object v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "RTC onWarning: "
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-static v1, v5, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->access$rtcDiag(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    const-string v1, "VolcRtcClient"
    invoke-virtual v0, v1, v5, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
