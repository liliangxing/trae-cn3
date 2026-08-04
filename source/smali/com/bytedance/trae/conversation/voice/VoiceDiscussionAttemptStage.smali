# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
.super Ljava/lang/Enum;
.source "VoiceDiscussionAttemptTracker.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
.field public static final enum ACTIVITY_LAUNCH_REQUESTED:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
.field public static final enum ACTIVITY_SHOWN:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
.field public static final enum CLICK:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
.field public static final enum DISCUSSION_STARTED:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
.field public static final enum ELIGIBILITY_PASSED:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
.field public static final enum FIRST_VOICE_DETECTED:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
.field public static final enum INTRO_SHOWN:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
.field public static final enum PERMISSION_GRANTED:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
.field public static final enum RECORDING_STARTED:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
.field public static final enum ROUND_REPORTED:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
.field public static final enum RTC_JOINED:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
.field public static final enum THINKING_RECEIVED:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
.field public static final enum USER_FINAL_RECEIVED:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
.field private final order:I
.field private final value:Ljava/lang/String;


.method private static final synthetic $values()com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptStage[]
    .registers 3
    # ins_size=0
    const/16 v0, 13
    new-array v0, v0, [Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->CLICK Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->ELIGIBILITY_PASSED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->ACTIVITY_LAUNCH_REQUESTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->ACTIVITY_SHOWN Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    aput-object v2, v0, v1
    const/4 v1, 4
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->PERMISSION_GRANTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    aput-object v2, v0, v1
    const/4 v1, 5
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->INTRO_SHOWN Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    aput-object v2, v0, v1
    const/4 v1, 6
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->DISCUSSION_STARTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    aput-object v2, v0, v1
    const/4 v1, 7
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->RECORDING_STARTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    aput-object v2, v0, v1
    const/16 v1, 8
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->RTC_JOINED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    aput-object v2, v0, v1
    const/16 v1, 9
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->FIRST_VOICE_DETECTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    aput-object v2, v0, v1
    const/16 v1, 10
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->USER_FINAL_RECEIVED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    aput-object v2, v0, v1
    const/16 v1, 11
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->THINKING_RECEIVED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    aput-object v2, v0, v1
    const/16 v1, 12
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->ROUND_REPORTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 6
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    const/4 v1, 0
    const-string v2, "click"
    const-string v3, "CLICK"
    invoke-direct v0, v3, v1, v2, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;-><init>(Ljava/lang/String; I Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->CLICK Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    const-string v1, "ELIGIBILITY_PASSED"
    const/4 v2, 1
    const-string v3, "eligibility_passed"
    const/16 v4, 10
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;-><init>(Ljava/lang/String; I Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->ELIGIBILITY_PASSED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    const-string v1, "activity_launch_requested"
    const/16 v2, 20
    const-string v3, "ACTIVITY_LAUNCH_REQUESTED"
    const/4 v5, 2
    invoke-direct v0, v3, v5, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;-><init>(Ljava/lang/String; I Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->ACTIVITY_LAUNCH_REQUESTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    const-string v1, "activity_shown"
    const/16 v2, 30
    const-string v3, "ACTIVITY_SHOWN"
    const/4 v5, 3
    invoke-direct v0, v3, v5, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;-><init>(Ljava/lang/String; I Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->ACTIVITY_SHOWN Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    const-string v1, "permission_granted"
    const/16 v2, 40
    const-string v3, "PERMISSION_GRANTED"
    const/4 v5, 4
    invoke-direct v0, v3, v5, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;-><init>(Ljava/lang/String; I Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->PERMISSION_GRANTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    const-string v1, "intro_shown"
    const/16 v2, 50
    const-string v3, "INTRO_SHOWN"
    const/4 v5, 5
    invoke-direct v0, v3, v5, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;-><init>(Ljava/lang/String; I Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->INTRO_SHOWN Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    const-string v1, "discussion_started"
    const/16 v2, 60
    const-string v3, "DISCUSSION_STARTED"
    const/4 v5, 6
    invoke-direct v0, v3, v5, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;-><init>(Ljava/lang/String; I Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->DISCUSSION_STARTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    const-string v1, "recording_started"
    const/16 v2, 70
    const-string v3, "RECORDING_STARTED"
    const/4 v5, 7
    invoke-direct v0, v3, v5, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;-><init>(Ljava/lang/String; I Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->RECORDING_STARTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    const-string/jumbo v1, rtc_joined
    const/16 v2, 80
    const-string v3, "RTC_JOINED"
    const/16 v5, 8
    invoke-direct v0, v3, v5, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;-><init>(Ljava/lang/String; I Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->RTC_JOINED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    const-string v1, "first_voice_detected"
    const/16 v2, 90
    const-string v3, "FIRST_VOICE_DETECTED"
    const/16 v5, 9
    invoke-direct v0, v3, v5, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;-><init>(Ljava/lang/String; I Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->FIRST_VOICE_DETECTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    const-string/jumbo v1, user_final_received
    const/16 v2, 100
    const-string v3, "USER_FINAL_RECEIVED"
    invoke-direct v0, v3, v4, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;-><init>(Ljava/lang/String; I Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->USER_FINAL_RECEIVED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    const-string/jumbo v1, thinking_received
    const/16 v2, 110
    const-string v3, "THINKING_RECEIVED"
    const/16 v4, 11
    invoke-direct v0, v3, v4, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;-><init>(Ljava/lang/String; I Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->THINKING_RECEIVED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    const-string/jumbo v1, round_reported
    const/16 v2, 120
    const-string v3, "ROUND_REPORTED"
    const/16 v4, 12
    invoke-direct v0, v3, v4, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;-><init>(Ljava/lang/String; I Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->ROUND_REPORTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-static Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->$values()[Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->$VALUES [Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int  java.lang.String  int)void
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->value Ljava/lang/String;
    iput v4, v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->order I
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptStage
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    return-object v1
.end method

.method public static values()com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptStage[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->$VALUES [Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    return-object v0
.end method

.method public final getOrder$conversation_mainlandRelease()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->order I
    return v0
.end method

.method public final getValue()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->value Ljava/lang/String;
    return-object v0
.end method
