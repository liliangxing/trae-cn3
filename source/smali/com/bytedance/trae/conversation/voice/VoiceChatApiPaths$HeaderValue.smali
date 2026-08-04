# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths$HeaderValue;
.super Ljava/lang/Object;
.source "VoiceChatApiPaths.kt"

.field public static final CONTENT_TYPE_JSON:Ljava/lang/String;
.field public static final DEFAULT_X_APP_ID:Ljava/lang/String;
.field public static final IDE_VERSION_CODE:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths$HeaderValue;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths$HeaderValue;
    invoke-direct v0, Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths$HeaderValue;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths$HeaderValue;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths$HeaderValue;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method
