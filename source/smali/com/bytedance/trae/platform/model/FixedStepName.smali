# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/platform/model/FixedStepName;
.super Ljava/lang/Object;
.source "FixedStepName.kt"

.field public static final APP_CREATE_START:Ljava/lang/String;
.field public static final CHAT_ACTION_BAR_SHOW:Ljava/lang/String;
.field public static final CHAT_DRAFT_LOAD_SUCCESS:Ljava/lang/String;
.field public static final CHAT_INPUT_SHOW:Ljava/lang/String;
.field public static final CHAT_MESSAGE_SHOW:Ljava/lang/String;
.field public static final CHAT_PASTE_MESSAGE:Ljava/lang/String;
.field public static final CHAT_SUGGEST_SHOW:Ljava/lang/String;
.field public static final CHAT_TITLE_SHOW:Ljava/lang/String;
.field public static final CHAT_WCB_SHOW:Ljava/lang/String;
.field public static final ENTER_CHAT:Ljava/lang/String;
.field public static final ENTER_MAIN:Ljava/lang/String;
.field public static final INIT_TASK_FAIL:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/platform/model/FixedStepName;
.field public static final LEAVE_CHAT_PAGE:Ljava/lang/String;
.field public static final LOAD_MESSAGE_FROM_CACHE:Ljava/lang/String;
.field public static final LOAD_MESSAGE_FROM_DB:Ljava/lang/String;
.field public static final REQUEST_LAUNCH_INFO:Ljava/lang/String;
.field public static final REQUEST_LAUNCH_INFO_FINISH:Ljava/lang/String;
.field public static final SWITCH_BACKGROUND:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/platform/model/FixedStepName;
    invoke-direct v0, Lcom/bytedance/trae/platform/model/FixedStepName;-><init>()V
    sput-object v0, Lcom/bytedance/trae/platform/model/FixedStepName;->INSTANCE Lcom/bytedance/trae/platform/model/FixedStepName;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method
