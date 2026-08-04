# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public interface abstract Lcom/bytedance/trae/push/api/IPushService;
.super Ljava/lang/Object;
.source "IPushService.kt"

.field public static final Companion:Lcom/bytedance/trae/push/api/IPushService$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/push/api/IPushService$Companion;->$$INSTANCE Lcom/bytedance/trae/push/api/IPushService$Companion;
    sput-object v0, Lcom/bytedance/trae/push/api/IPushService;->Companion Lcom/bytedance/trae/push/api/IPushService$Companion;
    return-void 
.end method

.method public abstract applyRedBadgeCount(int)void
    # abstract or native
.end method

.method public abstract asyncStartPush()void
    # abstract or native
.end method

.method public abstract getPushActivityClazz()java.lang.Class
    # abstract or native
.end method

.method public abstract getPushContentType()java.lang.String
    # abstract or native
.end method

.method public abstract initAndStart()void
    # abstract or native
.end method

.method public abstract isNotificationPermissionGranted()boolean
    # abstract or native
.end method

.method public abstract onPushClick(java.lang.String  int)void
    # abstract or native
.end method

.method public abstract openSystemNotificationSetting()void
    # abstract or native
.end method

.method public abstract requestNotificationPermission()void
    # abstract or native
.end method

.method public abstract showNotification(android.content.Context  android.content.Intent  com.bytedance.trae.push.api.TraeNotificationBody)boolean
    # abstract or native
.end method

.method public abstract trackClickPush(android.content.Context  java.lang.String  boolean  org.json.JSONObject)void
    # abstract or native
.end method
