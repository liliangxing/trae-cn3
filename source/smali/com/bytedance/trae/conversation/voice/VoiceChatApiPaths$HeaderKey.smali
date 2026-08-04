# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths$HeaderKey;
.super Ljava/lang/Object;
.source "VoiceChatApiPaths.kt"

.field public static final APP_ID:Ljava/lang/String;
.field public static final AUDIO_SOURCE:Ljava/lang/String;
.field public static final CONTENT_TYPE:Ljava/lang/String;
.field public static final CONVERSATION_ID:Ljava/lang/String;
.field public static final IDE_VERSION_CODE:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths$HeaderKey;
.field public static final SCENE_ID:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths$HeaderKey;
    invoke-direct v0, Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths$HeaderKey;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths$HeaderKey;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths$HeaderKey;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method
