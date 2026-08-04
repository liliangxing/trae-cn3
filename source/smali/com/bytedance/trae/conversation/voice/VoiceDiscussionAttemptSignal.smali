# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
.super Ljava/lang/Enum;
.source "VoiceDiscussionAttemptTracker.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
.field public static final enum CONVERSATION_ERROR:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
.field public static final enum HEALTH_CHECK_BLOCKED:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
.field public static final enum PERMISSION_DENIED:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
.field public static final enum RTC_ERROR:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
.field public static final enum START_API_FAILED:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
.field private final value:Ljava/lang/String;


.method private static final synthetic $values()com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptSignal[]
    .registers 3
    # ins_size=0
    const/4 v0, 5
    new-array v0, v0, [Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->PERMISSION_DENIED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->HEALTH_CHECK_BLOCKED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->START_API_FAILED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->RTC_ERROR Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    aput-object v2, v0, v1
    const/4 v1, 4
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->CONVERSATION_ERROR Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    const/4 v1, 0
    const-string v2, "permission_denied"
    const-string v3, "PERMISSION_DENIED"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->PERMISSION_DENIED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    const/4 v1, 1
    const-string v2, "health_check_blocked"
    const-string v3, "HEALTH_CHECK_BLOCKED"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->HEALTH_CHECK_BLOCKED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    const/4 v1, 2
    const-string/jumbo v2, start_api_failed
    const-string v3, "START_API_FAILED"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->START_API_FAILED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    const/4 v1, 3
    const-string/jumbo v2, rtc_error
    const-string v3, "RTC_ERROR"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->RTC_ERROR Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    const/4 v1, 4
    const-string v2, "conversation_error"
    const-string v3, "CONVERSATION_ERROR"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->CONVERSATION_ERROR Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    invoke-static Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->$values()[Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->$VALUES [Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->value Ljava/lang/String;
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptSignal
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    return-object v1
.end method

.method public static values()com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptSignal[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->$VALUES [Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    return-object v0
.end method

.method public final getValue()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->value Ljava/lang/String;
    return-object v0
.end method
