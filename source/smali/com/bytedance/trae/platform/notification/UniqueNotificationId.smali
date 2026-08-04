# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/platform/notification/UniqueNotificationId;
.super Ljava/lang/Object;
.source "UniqueNotificationId.kt"

.field public static final BAIDU_NAVI_ID:I
.field public static final DORA_ID:I
.field public static final INSTANCE:Lcom/bytedance/trae/platform/notification/UniqueNotificationId;
.field public static final ONE_PART_AI_NOTE_ID:I
.field public static final ONE_PART_MUSIC_ID:I
.field public static final ONE_PART_NEWS_PLAY_ID:I
.field public static final REALTIME_ID:I
.field public static final UGC_CREATION_ID:I


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/platform/notification/UniqueNotificationId;
    invoke-direct v0, Lcom/bytedance/trae/platform/notification/UniqueNotificationId;-><init>()V
    sput-object v0, Lcom/bytedance/trae/platform/notification/UniqueNotificationId;->INSTANCE Lcom/bytedance/trae/platform/notification/UniqueNotificationId;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method
