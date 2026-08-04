# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/tracker/PluginEvent;
.super Ljava/lang/Object;
.source "PluginTracker.kt"

.field public static final CHAT_PLUGIN_INCLUDE:Ljava/lang/String;
.field public static final CHAT_PLUGIN_INVOKED:Ljava/lang/String;
.field public static final CONNECTOR_AUTH_FAIL:Ljava/lang/String;
.field public static final CONNECTOR_AUTH_RESULT:Ljava/lang/String;
.field public static final CONNECTOR_AUTH_START:Ljava/lang/String;
.field public static final CONNECTOR_AUTH_SUCCESS:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/tracker/PluginEvent;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/PluginEvent;
    invoke-direct v0, Lcom/bytedance/trae/conversation/tracker/PluginEvent;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/PluginEvent;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginEvent;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method
