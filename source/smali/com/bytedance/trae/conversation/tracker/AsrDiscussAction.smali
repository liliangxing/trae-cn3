# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/tracker/AsrDiscussAction;
.super Ljava/lang/Object;
.source "TraeAITracker.kt"

.field public static final ATTACH_BUTTON_CLICK:Ljava/lang/String;
.field public static final ATTACH_DISPATCH_REFUSED:Ljava/lang/String;
.field public static final ATTACH_DISPATCH_TO_AGENT:Ljava/lang/String;
.field public static final ATTACH_UPLOAD_FAILED:Ljava/lang/String;
.field public static final ATTACH_UPLOAD_SUCCESS:Ljava/lang/String;
.field public static final DISCUSSION_BUTTON_CLICK:Ljava/lang/String;
.field public static final END_DISCUSSION_CLICK:Ljava/lang/String;
.field public static final EXIT_DISCUSSION_CLICK:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/tracker/AsrDiscussAction;
.field public static final SUBTITLE_MODE_DISABLE:Ljava/lang/String;
.field public static final SUBTITLE_MODE_ENABLE:Ljava/lang/String;
.field public static final SUMMARY_ADDITIONAL_INPUT_CLICK:Ljava/lang/String;
.field public static final SUMMARY_DIRECT_EXECUTE_CLICK:Ljava/lang/String;
.field public static final SUMMARY_OTHER_OPTION_CLICK:Ljava/lang/String;
.field public static final SUMMARY_VIEW_DETAIL_CLICK:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/AsrDiscussAction;
    invoke-direct v0, Lcom/bytedance/trae/conversation/tracker/AsrDiscussAction;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/AsrDiscussAction;->INSTANCE Lcom/bytedance/trae/conversation/tracker/AsrDiscussAction;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method
