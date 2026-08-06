package com.bytedance.ies.argus.strategy;

import com.bytedance.applog.server.Api;
import com.bytedance.ies.argus.base.ArgusLog;
import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: BaseStrategyParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0015\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0016¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/argus/strategy/BaseStrategyParams;", "Lcom/bytedance/ies/argus/strategy/ITTMDataHandler;", "()V", "getValue", "", Api.KEY_ENCRYPT_RESP_KEY, "", "setValue", "", "value", "toALogObject", "Lorg/json/JSONObject;", "action", "Lcom/bytedance/ies/argus/bean/ArgusVerifyAction;", "toMonitorObject", "transformStrToBool", "(Ljava/lang/Object;)Ljava/lang/Boolean;", "ttmGetValue", "ttmSetValue", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class BaseStrategyParams implements ITTMDataHandler {
    public static final String TAG = "TTMStrategy";

    public JSONObject toALogObject(ArgusVerifyAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return null;
    }

    public JSONObject toMonitorObject(ArgusVerifyAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return null;
    }

    public Object ttmGetValue(String key) {
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        return null;
    }

    public boolean ttmSetValue(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkNotNullParameter(value, "value");
        return false;
    }

    @Override // com.bytedance.ies.argus.strategy.ITTMDataHandler
    public boolean setValue(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            boolean ttmSetValue = ttmSetValue(key, value);
            if (ttmSetValue) {
                return ttmSetValue;
            }
            ArgusLog.e$default(ArgusLog.INSTANCE, TAG, getClass().getSimpleName() + " setValue error: " + key + ", " + value, null, null, 12, null);
            return ttmSetValue;
        } catch (Exception e) {
            ArgusLog.e$default(ArgusLog.INSTANCE, TAG, getClass().getSimpleName() + " setValue error: " + key + ", " + value, null, e, 4, null);
            return false;
        }
    }

    @Override // com.bytedance.ies.argus.strategy.ITTMDataHandler
    public Object getValue(String key) {
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        try {
            return ttmGetValue(key);
        } catch (Exception e) {
            ArgusLog.e$default(ArgusLog.INSTANCE, TAG, getClass().getSimpleName() + " getValue error: " + key, null, e, 4, null);
            return null;
        }
    }

    public final Boolean transformStrToBool(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if ((value instanceof String ? (String) value : null) != null) {
            if (Intrinsics.areEqual(value, "true")) {
                return true;
            }
            if (Intrinsics.areEqual(value, "false")) {
                return false;
            }
        }
        return null;
    }
}
