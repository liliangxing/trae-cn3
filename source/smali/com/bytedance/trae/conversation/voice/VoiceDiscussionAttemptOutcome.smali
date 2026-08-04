# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
.super Ljava/lang/Enum;
.source "VoiceDiscussionAttemptTracker.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
.field public static final enum ACTIVITY_ABANDON:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
.field public static final enum ACTIVITY_NOT_SHOWN:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
.field public static final enum BLOCKED_IDE_VERSION:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
.field public static final enum CONVERSATION_ERROR:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
.field public static final enum HEALTH_CHECK_BLOCKED:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
.field public static final enum INTRO_ABANDON:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
.field public static final enum JOINED_NO_SPEECH:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
.field public static final enum PERMISSION_DENIED:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
.field public static final enum PREREQUISITE_FAILED:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
.field public static final enum ROUND_NOT_FINALIZED:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
.field public static final enum RTC_JOIN_FAILED:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
.field public static final enum RTC_RUNTIME_ERROR:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
.field public static final enum SPEECH_NO_THINKING:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
.field public static final enum START_ABANDON:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
.field public static final enum START_API_FAILED:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
.field public static final enum SUCCESS:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
.field public static final enum UNKNOWN:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
.field private final value:Ljava/lang/String;


.method private static final synthetic $values()com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptOutcome[]
    .registers 3
    # ins_size=0
    const/16 v0, 17
    new-array v0, v0, [Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->SUCCESS Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->BLOCKED_IDE_VERSION Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->PERMISSION_DENIED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->HEALTH_CHECK_BLOCKED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    aput-object v2, v0, v1
    const/4 v1, 4
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->PREREQUISITE_FAILED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    aput-object v2, v0, v1
    const/4 v1, 5
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->ACTIVITY_NOT_SHOWN Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    aput-object v2, v0, v1
    const/4 v1, 6
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->ACTIVITY_ABANDON Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    aput-object v2, v0, v1
    const/4 v1, 7
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->INTRO_ABANDON Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    aput-object v2, v0, v1
    const/16 v1, 8
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->START_API_FAILED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    aput-object v2, v0, v1
    const/16 v1, 9
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->RTC_JOIN_FAILED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    aput-object v2, v0, v1
    const/16 v1, 10
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->RTC_RUNTIME_ERROR Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    aput-object v2, v0, v1
    const/16 v1, 11
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->CONVERSATION_ERROR Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    aput-object v2, v0, v1
    const/16 v1, 12
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->START_ABANDON Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    aput-object v2, v0, v1
    const/16 v1, 13
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->JOINED_NO_SPEECH Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    aput-object v2, v0, v1
    const/16 v1, 14
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->SPEECH_NO_THINKING Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    aput-object v2, v0, v1
    const/16 v1, 15
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->ROUND_NOT_FINALIZED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    aput-object v2, v0, v1
    const/16 v1, 16
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->UNKNOWN Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    const/4 v1, 0
    const-string/jumbo v2, success
    const-string v3, "SUCCESS"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->SUCCESS Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    const/4 v1, 1
    const-string v2, "blocked_ide_version"
    const-string v3, "BLOCKED_IDE_VERSION"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->BLOCKED_IDE_VERSION Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    const/4 v1, 2
    const-string v2, "permission_denied"
    const-string v3, "PERMISSION_DENIED"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->PERMISSION_DENIED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    const/4 v1, 3
    const-string v2, "health_check_blocked"
    const-string v3, "HEALTH_CHECK_BLOCKED"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->HEALTH_CHECK_BLOCKED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    const/4 v1, 4
    const-string v2, "prerequisite_failed"
    const-string v3, "PREREQUISITE_FAILED"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->PREREQUISITE_FAILED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    const/4 v1, 5
    const-string v2, "activity_not_shown"
    const-string v3, "ACTIVITY_NOT_SHOWN"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->ACTIVITY_NOT_SHOWN Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    const/4 v1, 6
    const-string v2, "activity_abandon"
    const-string v3, "ACTIVITY_ABANDON"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->ACTIVITY_ABANDON Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    const/4 v1, 7
    const-string v2, "intro_abandon"
    const-string v3, "INTRO_ABANDON"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->INTRO_ABANDON Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    const/16 v1, 8
    const-string/jumbo v2, start_api_failed
    const-string v3, "START_API_FAILED"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->START_API_FAILED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    const/16 v1, 9
    const-string/jumbo v2, rtc_join_failed
    const-string v3, "RTC_JOIN_FAILED"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->RTC_JOIN_FAILED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    const/16 v1, 10
    const-string/jumbo v2, rtc_runtime_error
    const-string v3, "RTC_RUNTIME_ERROR"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->RTC_RUNTIME_ERROR Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    const/16 v1, 11
    const-string v2, "conversation_error"
    const-string v3, "CONVERSATION_ERROR"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->CONVERSATION_ERROR Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    const/16 v1, 12
    const-string/jumbo v2, start_abandon
    const-string v3, "START_ABANDON"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->START_ABANDON Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    const/16 v1, 13
    const-string v2, "joined_no_speech"
    const-string v3, "JOINED_NO_SPEECH"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->JOINED_NO_SPEECH Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    const/16 v1, 14
    const-string/jumbo v2, speech_no_thinking
    const-string v3, "SPEECH_NO_THINKING"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->SPEECH_NO_THINKING Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    const/16 v1, 15
    const-string/jumbo v2, round_not_finalized
    const-string v3, "ROUND_NOT_FINALIZED"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->ROUND_NOT_FINALIZED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    const/16 v1, 16
    const-string/jumbo v2, unknown
    const-string v3, "UNKNOWN"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->UNKNOWN Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    invoke-static Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->$values()[Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->$VALUES [Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->value Ljava/lang/String;
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptOutcome
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    return-object v1
.end method

.method public static values()com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptOutcome[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->$VALUES [Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    return-object v0
.end method

.method public final getValue()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->value Ljava/lang/String;
    return-object v0
.end method
