# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;
.super Lcom/bytedance/trae/im/service/ChatEventPayload;
.source "IMEvent.kt"

.field public static final ACTION_TYPE_BLOCK:I
.field public static final ACTION_TYPE_DESENSITIZE:I
.field public static final Companion:Lcom/bytedance/trae/im/service/ChatEventPayload$Notification$Companion;
.field public static final EXECUTE_POINT_POST:I
.field public static final EXECUTE_POINT_PRE:I
.field public static final TYPE_CONTENT_FILTER_WARNING:Ljava/lang/String;
.field public static final TYPE_QUEUE:Ljava/lang/String;
.field private final actionType:Ljava/lang/Integer;
.field private final executePoint:Ljava/lang/Integer;
.field private final fastRequestEvent:Lcom/bytedance/trae/im/service/FastRequestEvent;
.field private final hitRuleId:Ljava/lang/String;
.field private final hitRuleName:Ljava/lang/String;
.field private final message:Ljava/lang/String;
.field private final notificationType:Ljava/lang/String;
.field private final position:Ljava/lang/Integer;
.field private final requestUUId:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->Companion Lcom/bytedance/trae/im/service/ChatEventPayload$Notification$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 13
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 511
    const/4 v11, 0
    move-object v0, v12
    invoke-direct/range v0 ... v11, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;-><init>(Ljava/lang/String; Ljava/lang/Integer; Lcom/bytedance/trae/im/service/FastRequestEvent; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.Integer  com.bytedance.trae.im.service.FastRequestEvent  java.lang.String  java.lang.String  java.lang.String  java.lang.Integer  java.lang.Integer  java.lang.String)void
    .registers 11
    # ins_size=10
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->notificationType Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->position Ljava/lang/Integer;
    iput-object v4, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    iput-object v5, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->requestUUId Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->hitRuleId Ljava/lang/String;
    iput-object v7, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->hitRuleName Ljava/lang/String;
    iput-object v8, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->actionType Ljava/lang/Integer;
    iput-object v9, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->executePoint Ljava/lang/Integer;
    iput-object v10, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->message Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.Integer  com.bytedance.trae.im.service.FastRequestEvent  java.lang.String  java.lang.String  java.lang.String  java.lang.Integer  java.lang.Integer  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 22
    # ins_size=12
    move/from16 v0, v20
    and-int/lit8 v1, v0, 1
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v1, v2
    goto +2h
    move-object v1, v11
    and-int/lit8 v3, v0, 2
    if-eqz v3, +004h
    move-object v3, v2
    goto +2h
    move-object v3, v12
    and-int/lit8 v4, v0, 4
    if-eqz v4, +004h
    move-object v4, v2
    goto +2h
    move-object v4, v13
    and-int/lit8 v5, v0, 8
    if-eqz v5, +004h
    move-object v5, v2
    goto +2h
    move-object v5, v14
    and-int/lit8 v6, v0, 16
    if-eqz v6, +004h
    move-object v6, v2
    goto +2h
    move-object v6, v15
    and-int/lit8 v7, v0, 32
    if-eqz v7, +004h
    move-object v7, v2
    goto +3h
    move-object/from16 v7, v16
    and-int/lit8 v8, v0, 64
    if-eqz v8, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v17
    and-int/lit16 v9, v0, 128
    if-eqz v9, +004h
    move-object v9, v2
    goto +3h
    move-object/from16 v9, v18
    and-int/lit16 v0, v0, 256
    if-eqz v0, +003h
    goto +3h
    move-object/from16 v2, v19
    move-object v11, v10
    move-object v12, v1
    move-object v13, v3
    move-object v14, v4
    move-object v15, v5
    move-object/from16 v16, v6
    move-object/from16 v17, v7
    move-object/from16 v18, v8
    move-object/from16 v19, v9
    move-object/from16 v20, v2
    invoke-direct/range v11 ... v20, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;-><init>(Ljava/lang/String; Ljava/lang/Integer; Lcom/bytedance/trae/im/service/FastRequestEvent; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.ChatEventPayload$Notification  java.lang.String  java.lang.Integer  com.bytedance.trae.im.service.FastRequestEvent  java.lang.String  java.lang.String  java.lang.String  java.lang.Integer  java.lang.Integer  java.lang.String  int  java.lang.Object)com.bytedance.trae.im.service.ChatEventPayload$Notification
    .registers 22
    # ins_size=12
    move-object v0, v10
    move/from16 v1, v20
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->notificationType Ljava/lang/String;
    goto +2h
    move-object v2, v11
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->position Ljava/lang/Integer;
    goto +2h
    move-object v3, v12
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    goto +2h
    move-object v4, v13
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->requestUUId Ljava/lang/String;
    goto +2h
    move-object v5, v14
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->hitRuleId Ljava/lang/String;
    goto +2h
    move-object v6, v15
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->hitRuleName Ljava/lang/String;
    goto +3h
    move-object/from16 v7, v16
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->actionType Ljava/lang/Integer;
    goto +3h
    move-object/from16 v8, v17
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->executePoint Ljava/lang/Integer;
    goto +3h
    move-object/from16 v9, v18
    and-int/lit16 v1, v1, 256
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->message Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v19
    move-object v11, v2
    move-object v12, v3
    move-object v13, v4
    move-object v14, v5
    move-object v15, v6
    move-object/from16 v16, v7
    move-object/from16 v17, v8
    move-object/from16 v18, v9
    move-object/from16 v19, v1
    invoke-virtual/range v10 ... v19, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->copy(Ljava/lang/String; Ljava/lang/Integer; Lcom/bytedance/trae/im/service/FastRequestEvent; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/String;)Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->notificationType Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->position Ljava/lang/Integer;
    return-object v0
.end method

.method public final component3()com.bytedance.trae.im.service.FastRequestEvent
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->requestUUId Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->hitRuleId Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->hitRuleName Ljava/lang/String;
    return-object v0
.end method

.method public final component7()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->actionType Ljava/lang/Integer;
    return-object v0
.end method

.method public final component8()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->executePoint Ljava/lang/Integer;
    return-object v0
.end method

.method public final component9()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->message Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.Integer  com.bytedance.trae.im.service.FastRequestEvent  java.lang.String  java.lang.String  java.lang.String  java.lang.Integer  java.lang.Integer  java.lang.String)com.bytedance.trae.im.service.ChatEventPayload$Notification
    .registers 21
    # ins_size=10
    new-instance v10, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;
    move-object v0, v10
    move-object v1, v12
    move-object v2, v13
    move-object v3, v14
    move-object v4, v15
    move-object/from16 v5, v16
    move-object/from16 v6, v17
    move-object/from16 v7, v18
    move-object/from16 v8, v19
    move-object/from16 v9, v20
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;-><init>(Ljava/lang/String; Ljava/lang/Integer; Lcom/bytedance/trae/im/service/FastRequestEvent; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/String;)V
    return-object v10
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->notificationType Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->notificationType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->position Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->position Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->requestUUId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->requestUUId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->hitRuleId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->hitRuleId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->hitRuleName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->hitRuleName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->actionType Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->actionType Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->executePoint Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->executePoint Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->message Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->message Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getActionType()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->actionType Ljava/lang/Integer;
    return-object v0
.end method

.method public final getExecutePoint()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->executePoint Ljava/lang/Integer;
    return-object v0
.end method

.method public final getFastRequestEvent()com.bytedance.trae.im.service.FastRequestEvent
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    return-object v0
.end method

.method public final getHitRuleId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->hitRuleId Ljava/lang/String;
    return-object v0
.end method

.method public final getHitRuleName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->hitRuleName Ljava/lang/String;
    return-object v0
.end method

.method public final getMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->message Ljava/lang/String;
    return-object v0
.end method

.method public final getNotificationType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->notificationType Ljava/lang/String;
    return-object v0
.end method

.method public final getPosition()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->position Ljava/lang/Integer;
    return-object v0
.end method

.method public final getRequestUUId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->requestUUId Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->notificationType Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->position Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/FastRequestEvent;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->requestUUId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->hitRuleId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->hitRuleName Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->actionType Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->executePoint Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->message Ljava/lang/String;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Notification(notificationType="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->notificationType Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", position="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->position Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", fastRequestEvent="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", requestUUId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->requestUUId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", hitRuleId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->hitRuleId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", hitRuleName="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->hitRuleName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", actionType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->actionType Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", executePoint="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->executePoint Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", message="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;->message Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
