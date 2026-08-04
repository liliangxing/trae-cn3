# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/push/api/PushConst;
.super Ljava/lang/Object;
.source "PushConst.kt"

.field public static final BUNDLE_MESSAGE_BODY:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/push/api/PushConst;
.field public static final KEY_GROUP_ID:Ljava/lang/String;
.field public static final KEY_OPEN_METHOD:Ljava/lang/String;
.field public static final KEY_OPEN_URL_FIR_TYPE:Ljava/lang/String;
.field public static final KEY_OPEN_URL_SEC_TYPE:Ljava/lang/String;
.field public static final KEY_PARAM_IS_PUSH:Ljava/lang/String;
.field public static final KEY_PARAM_PUSH_CONTENT_TYPE:Ljava/lang/String;
.field public static final KEY_PENDING_DEEPLINK_SCHEMA:Ljava/lang/String;
.field public static final KEY_PUSH_CONTENT_FIR_TYPE:Ljava/lang/String;
.field public static final KEY_PUSH_CONTENT_SEC_TYPE:Ljava/lang/String;
.field public static final KEY_PUSH_MESSAGE_FROM:Ljava/lang/String;
.field public static final KEY_PUSH_TRACK:Ljava/lang/String;
.field public static final KEY_RULE_ID:Ljava/lang/String;
.field public static final KEY_SENDER:Ljava/lang/String;
.field public static final PUSH_KEY_CONVERSATION_ID:Ljava/lang/String;
.field public static final PUSH_KEY_ENTER_METHOD:Ljava/lang/String;
.field public static final PUSH_KEY_IS_FROM_CUSTOM_PUSH:Ljava/lang/String;
.field public static final PUSH_KEY_IS_FROM_PUSH:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/push/api/PushConst;
    invoke-direct v0, Lcom/bytedance/trae/push/api/PushConst;-><init>()V
    sput-object v0, Lcom/bytedance/trae/push/api/PushConst;->INSTANCE Lcom/bytedance/trae/push/api/PushConst;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method
