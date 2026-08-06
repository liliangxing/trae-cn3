package com.bytedance.ies.argus.repository;

import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.ies.argus.base.ArgusLog;
import com.bytedance.ies.argus.bean.ArgusGlobalCommonConfig;
import com.bytedance.ies.argus.util.ArgusGsonUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArgusConfigManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.ies.argus.repository.ArgusConfigManager$updateFromSettings$1", f = "ArgusConfigManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ArgusConfigManager$updateFromSettings$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $data;
    int label;
    final /* synthetic */ ArgusConfigManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArgusConfigManager$updateFromSettings$1(String str, ArgusConfigManager argusConfigManager, Continuation<? super ArgusConfigManager$updateFromSettings$1> continuation) {
        super(2, continuation);
        this.$data = str;
        this.this$0 = argusConfigManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArgusConfigManager$updateFromSettings$1(this.$data, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ConfigInfo configInfo;
        boolean z;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            JSONObject jSONObject = new JSONObject(this.$data);
            String optString = jSONObject.optString("version", "0");
            configInfo = this.this$0.cacheSettingsInfo;
            String version = configInfo != null ? configInfo.getVersion() : null;
            if (version != null && Intrinsics.areEqual(version, optString)) {
                ArgusLog.i$default(ArgusLog.INSTANCE, null, "no need update settings, version=" + optString + " is equal", null, 4, null);
            } else {
                ConfigFrom configFrom = ConfigFrom.SETTING;
                Intrinsics.checkNotNullExpressionValue(optString, "version");
                ConfigInfo configInfo2 = new ConfigInfo(configFrom, optString, null, null, null, 24, null);
                this.this$0.cacheSettingsInfo = configInfo2;
                ArgusLog.i$default(ArgusLog.INSTANCE, null, "start update settings: " + version + " -> " + optString, null, 4, null);
                JSONObject optJSONObject = jSONObject.optJSONObject("recovery_config");
                this.this$0.parseRecoveryConfig(optJSONObject);
                z = this.this$0.forceCloseAll;
                if (z) {
                    ArgusLog.i$default(ArgusLog.INSTANCE, null, "force close all", null, 4, null);
                } else if (optJSONObject != null) {
                    this.this$0.onRecoveryConfigUpdate(optJSONObject, configInfo2);
                }
                this.this$0.argusSecuritySettingConfig = (ArgusGlobalCommonConfig) ArgusGsonUtils.INSTANCE.safelyFromJSONObjectToClass(jSONObject.optJSONObject(SettingsManager.COMMON_SERVICE), ArgusGlobalCommonConfig.class);
            }
        } catch (Exception e) {
            ArgusLog.e$default(ArgusLog.INSTANCE, null, "updateSettings error: " + e, null, null, 12, null);
        }
        return Unit.INSTANCE;
    }
}
