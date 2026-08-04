# Decompiled TRAE business class
# Source DEX: classes5.dex
.class 0x0 Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp$1;
.super Ljava/lang/Object;
.source "BinderTranTooLargeExp.java"

.implements Landroid/app/Application$ActivityLifecycleCallbacks;

.field final synthetic this$0:Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;


.method constructor <init>(com.bytedance.trae.apm.impl.BinderTranTooLargeExp)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp$1;->this$0 Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onActivityCreated(android.app.Activity  android.os.Bundle)void
    .registers 4
    # ins_size=3
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v0, "["
    invoke-direct v3, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, "] onActivityCreated"
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v3, "BinderTranTooLargeExp"
    invoke-static v3, v2, Lcom/bytedance/platform/godzilla/common/Logger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public onActivityDestroyed(android.app.Activity)void
    .registers 4
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "["
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v0, "] onActivityDestroyed"
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v0, "BinderTranTooLargeExp"
    invoke-static v0, v3, Lcom/bytedance/platform/godzilla/common/Logger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public onActivityPaused(android.app.Activity)void
    .registers 4
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "["
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v0, "] onActivityPaused"
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v0, "BinderTranTooLargeExp"
    invoke-static v0, v3, Lcom/bytedance/platform/godzilla/common/Logger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public onActivityPostSaveInstanceState(android.app.Activity  android.os.Bundle)void
    .registers 8
    # ins_size=3
    iget-object v0, v5, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp$1;->this$0 Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;
    invoke-static v0, v6, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->access$000(Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp; Landroid/app/Activity;)Z
    move-result v0
    const-string v1, "BinderTranTooLargeExp"
    const-string v2, "["
    if-eqz v0, +019h
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, "] onSaveState disabled"
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-static v1, v6, Lcom/bytedance/platform/godzilla/common/Logger;->e(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    iget-object v0, v5, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp$1;->this$0 Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;
    invoke-static v0, v7, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->access$500(Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp; Landroid/os/Bundle;)[B
    move-result-object v0
    if-nez v0, +03ah
    iget-object v0, v5, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp$1;->this$0 Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;
    invoke-static v0, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->access$600(Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;)Z
    move-result v0
    if-eqz v0, +01bh
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v3, "] onSaveState force clear"
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v1, v0, Lcom/bytedance/platform/godzilla/common/Logger;->e(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v7, Landroid/os/Bundle;->clear()V
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, "] onSaveState bundleBytes is null"
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-static v1, v6, Lcom/bytedance/platform/godzilla/common/Logger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    array-length v3, v0
    const v4, 460800
    if-le v3, v4, +060h
    invoke-static Ljava/util/UUID;->randomUUID()Ljava/util/UUID;
    move-result-object v3
    invoke-virtual v3, Ljava/util/UUID;->toString()Ljava/lang/String;
    move-result-object v3
    iget-object v4, v5, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp$1;->this$0 Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;
    invoke-static v4, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->access$100(Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;)Ljava/util/LinkedHashMap;
    move-result-object v4
    invoke-virtual v4, v3, v0, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v7, Landroid/os/Bundle;->clear()V
    const-string v0, "BinderTranTooLargeExpActivityRecordKey"
    invoke-virtual v7, v0, v3, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v7, Lorg/json/JSONObject;
    invoke-direct v7, Lorg/json/JSONObject;-><init>()V
    const-string v0, "activity"
    invoke-virtual v6, Landroid/app/Activity;->getComponentName()Landroid/content/ComponentName;
    move-result-object v4
    invoke-virtual v4, Landroid/content/ComponentName;->getClassName()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v7, v0, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v0, step
    const/4 v4, 1
    invoke-virtual v7, v0, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v0, "binder_tran_too_large_exp"
    const/4 v4, 0
    invoke-static v0, v7, v4, v4, Lcom/bytedance/apm/ApmAgent;->monitorEvent(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, "] onSaveState success uuid = ["
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, "]"
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-static v1, v6, Lcom/bytedance/platform/godzilla/common/Logger;->i(Ljava/lang/String; Ljava/lang/String;)V
    goto +1ch
    move-exception v6
    invoke-virtual v6, Ljava/lang/Throwable;->printStackTrace()V
    goto +17h
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, "] onSaveState length not reach"
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-static v1, v6, Lcom/bytedance/platform/godzilla/common/Logger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    :try_start_0x71
.end method

.method public onActivityPreCreated(android.app.Activity  android.os.Bundle)void
    .registers 10
    # ins_size=3
    const-string v0, "BinderTranTooLargeExp"
    const-string v1, "["
    if-nez v9, +019h
    new-instance v9, Ljava/lang/StringBuilder;
    invoke-direct v9, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v9, "] onActivityPreCreated savedState is null"
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-static v0, v8, Lcom/bytedance/platform/godzilla/common/Logger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    iget-object v2, v7, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp$1;->this$0 Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;
    invoke-static v2, v8, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->access$000(Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp; Landroid/app/Activity;)Z
    move-result v2
    if-eqz v2, +019h
    new-instance v9, Ljava/lang/StringBuilder;
    invoke-direct v9, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v9, "] onActivityPreCreated disabled"
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-static v0, v8, Lcom/bytedance/platform/godzilla/common/Logger;->e(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    const-string v2, "BinderTranTooLargeExpActivityRecordKey"
    invoke-virtual v9, v2, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v2
    if-nez v2, +019h
    new-instance v9, Ljava/lang/StringBuilder;
    invoke-direct v9, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v9, "] onActivityPreCreated uuid is null"
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-static v0, v8, Lcom/bytedance/platform/godzilla/common/Logger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    instance-of v3, v2, Ljava/lang/String;
    const-string v4, "]"
    if-eqz v3, +0eeh
    invoke-virtual v9, Landroid/os/Bundle;->clear()V
    iget-object v3, v7, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp$1;->this$0 Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;
    invoke-static v3, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->access$100(Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;)Ljava/util/LinkedHashMap;
    move-result-object v3
    invoke-virtual v3, v2, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, [B
    if-nez v3, +036h
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, "] onActivityPreCreated uuid = ["
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, "], decoded == null"
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lcom/bytedance/platform/godzilla/common/Logger;->e(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v7, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp$1;->this$0 Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;
    invoke-static v0, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->access$300(Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;)Z
    move-result v0
    if-eqz v0, +00dh
    invoke-virtual v9, Landroid/os/Bundle;->isEmpty()Z
    move-result v9
    if-eqz v9, +007h
    iget-object v9, v7, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp$1;->this$0 Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;
    invoke-static v9, v8, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->access$400(Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp; Landroid/app/Activity;)V
    return-void 
    iget-object v5, v7, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp$1;->this$0 Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;
    invoke-virtual v8, Landroid/app/Activity;->getClassLoader()Ljava/lang/ClassLoader;
    move-result-object v6
    invoke-static v5, v3, v6, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->access$200(Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp; [B Ljava/lang/ClassLoader;)Landroid/os/Bundle;
    move-result-object v3
    if-eqz v3, +043h
    invoke-virtual v9, v3, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    const-string v5, "activity"
    invoke-virtual v8, Landroid/app/Activity;->getComponentName()Landroid/content/ComponentName;
    move-result-object v6
    invoke-virtual v6, Landroid/content/ComponentName;->getClassName()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v3, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v5, step
    const/4 v6, 2
    invoke-virtual v3, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v5, "binder_tran_too_large_exp"
    const/4 v6, 0
    invoke-static v5, v3, v6, v6, Lcom/bytedance/apm/ApmAgent;->monitorEvent(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, "] onActivityPreCreated restore success uuid = ["
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lcom/bytedance/platform/godzilla/common/Logger;->i(Ljava/lang/String; Ljava/lang/String;)V
    goto +1fh
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, "] onActivityPreCreated restore bundle is null uuid = ["
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lcom/bytedance/platform/godzilla/common/Logger;->w(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v7, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp$1;->this$0 Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;
    invoke-static v0, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->access$300(Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;)Z
    move-result v0
    if-eqz v0, +054h
    invoke-virtual v9, Landroid/os/Bundle;->isEmpty()Z
    move-result v9
    if-eqz v9, +04eh
    goto +13h
    move-exception v0
    invoke-virtual v0, Ljava/lang/Throwable;->printStackTrace()V
    iget-object v0, v7, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp$1;->this$0 Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;
    invoke-static v0, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->access$300(Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;)Z
    move-result v0
    if-eqz v0, +041h
    invoke-virtual v9, Landroid/os/Bundle;->isEmpty()Z
    move-result v9
    if-eqz v9, +03bh
    iget-object v9, v7, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp$1;->this$0 Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;
    invoke-static v9, v8, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->access$400(Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp; Landroid/app/Activity;)V
    goto +34h
    move-exception v0
    iget-object v1, v7, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp$1;->this$0 Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;
    invoke-static v1, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->access$300(Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;)Z
    move-result v1
    if-eqz v1, +00dh
    invoke-virtual v9, Landroid/os/Bundle;->isEmpty()Z
    move-result v9
    if-eqz v9, +007h
    iget-object v9, v7, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp$1;->this$0 Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;
    invoke-static v9, v8, Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp;->access$400(Lcom/bytedance/trae/apm/impl/BinderTranTooLargeExp; Landroid/app/Activity;)V
    throw v0
    new-instance v9, Ljava/lang/StringBuilder;
    invoke-direct v9, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v9, "] onActivityPreCreated uuid is not String["
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-static v0, v8, Lcom/bytedance/platform/godzilla/common/Logger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    :try_start_0x61
    :try_start_0xa6
    :try_start_0x121
.end method

.method public onActivityResumed(android.app.Activity)void
    .registers 4
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "["
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v0, "] onActivityResumed"
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v0, "BinderTranTooLargeExp"
    invoke-static v0, v3, Lcom/bytedance/platform/godzilla/common/Logger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public onActivitySaveInstanceState(android.app.Activity  android.os.Bundle)void
    .registers 5
    # ins_size=3
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "["
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v0, "] onActivitySaveInstanceState, outState = ["
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, "]"
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v4, "BinderTranTooLargeExp"
    invoke-static v4, v3, Lcom/bytedance/platform/godzilla/common/Logger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public onActivityStarted(android.app.Activity)void
    .registers 4
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "["
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v0, "] onActivityStarted"
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v0, "BinderTranTooLargeExp"
    invoke-static v0, v3, Lcom/bytedance/platform/godzilla/common/Logger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public onActivityStopped(android.app.Activity)void
    .registers 4
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "["
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v0, "] onActivityStopped"
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v0, "BinderTranTooLargeExp"
    invoke-static v0, v3, Lcom/bytedance/platform/godzilla/common/Logger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
