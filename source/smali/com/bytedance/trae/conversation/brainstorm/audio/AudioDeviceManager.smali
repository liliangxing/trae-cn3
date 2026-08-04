# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;
.super Ljava/lang/Object;
.source "AudioDeviceManager.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager$Companion;
.field private static final TAG:Ljava/lang/String;
.field private final audioManager:Landroid/media/AudioManager;
.field private final context:Landroid/content/Context;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;->Companion Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager$Companion;
    return-void 
.end method

.method public constructor <init>(android.content.Context)void
    .registers 3
    # ins_size=2
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;->context Landroid/content/Context;
    const-string v0, "audio"
    invoke-virtual v2, v0, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v2
    const-string v0, "null cannot be cast to non-null type android.media.AudioManager"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/media/AudioManager;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;->audioManager Landroid/media/AudioManager;
    return-void 
.end method

.method public final init()void
    .registers 3
    # ins_size=1
    const-string v0, "AudioDeviceManager"
    const-string v1, "init: AudioDeviceManager initialized (speaker/earpiece only)"
    invoke-static v0, v1, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    return-void 
.end method

.method public final release()void
    .registers 3
    # ins_size=1
    const-string v0, "AudioDeviceManager"
    const-string v1, "release: AudioDeviceManager released"
    invoke-static v0, v1, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    return-void 
.end method

.method public final switchToDevice(com.bytedance.trae.conversation.brainstorm.model.AudioDevice)void
    .registers 5
    # ins_size=2
    const-string v0, "device"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, switchToDevice: target=
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "AudioDeviceManager"
    invoke-static v1, v0, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;->ordinal()I
    move-result v4
    aget v4, v0, v4
    const/4 v0, 0
    const/4 v2, 1
    if-eq v4, v2, +01dh
    const/4 v2, 2
    if-ne v4, v2, +014h
    iget-object v4, v3, Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;->audioManager Landroid/media/AudioManager;
    const/4 v2, 3
    invoke-virtual v4, v2, Landroid/media/AudioManager;->setMode(I)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;->audioManager Landroid/media/AudioManager;
    invoke-virtual v4, v0, Landroid/media/AudioManager;->setSpeakerphoneOn(Z)V
    const-string/jumbo v4, switchToDevice: routed to Earpiece
    invoke-static v1, v4, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    goto +17h
    new-instance v4, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v4, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v4
    iget-object v4, v3, Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;->audioManager Landroid/media/AudioManager;
    invoke-virtual v4, v0, Landroid/media/AudioManager;->setMode(I)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;->audioManager Landroid/media/AudioManager;
    invoke-virtual v4, v2, Landroid/media/AudioManager;->setSpeakerphoneOn(Z)V
    const-string/jumbo v4, switchToDevice: routed to Speaker
    invoke-static v1, v4, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    return-void 
.end method
