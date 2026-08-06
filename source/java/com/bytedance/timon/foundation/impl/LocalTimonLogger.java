package com.bytedance.timon.foundation.impl;

import com.bytedance.timon.foundation.TimonFoundation;
import com.bytedance.timon.foundation.interfaces.ITimonLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalTimonLogger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/timon/foundation/impl/LocalTimonLogger;", "Lcom/bytedance/timon/foundation/interfaces/ITimonLogger;", "()V", "report", "", "id", "", "params", "", "", "token", "Companion", "timonfoundation_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class LocalTimonLogger implements ITimonLogger {
    public static final String TAG = "TimonLogger";

    @Override // com.bytedance.timon.foundation.interfaces.ITimonLogger
    public void report(int id, final Map<String, String> params, String token) {
        Intrinsics.checkParameterIsNotNull(params, "params");
        TimonFoundation.INSTANCE.getLogger().mo215i(TAG, "id=" + id + '(' + CollectionsKt.joinToString$default(params.keySet(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<String, String>() { // from class: com.bytedance.timon.foundation.impl.LocalTimonLogger$report$paramsContent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final String invoke(String str) {
                Intrinsics.checkParameterIsNotNull(str, "it");
                return str + ':' + ((String) params.get(str));
            }
        }, 31, (Object) null) + ") " + (token != null ? "withToken(" + token + ')' : null), null);
    }
}
