package com.bytedance.timon.foundation.interfaces;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* compiled from: ITimonLogger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH&¨\u0006\n"}, d2 = {"Lcom/bytedance/timon/foundation/interfaces/ITimonLogger;", "", "report", "", "id", "", "params", "", "", "token", "timonfoundation_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public interface ITimonLogger {
    void report(int id, Map<String, String> params, String token);

    /* compiled from: ITimonLogger.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void report$default(ITimonLogger iTimonLogger, int i, Map map, String str, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: report");
            }
            if ((i2 & 2) != 0) {
                map = MapsKt.emptyMap();
            }
            if ((i2 & 4) != 0) {
                str = null;
            }
            iTimonLogger.report(i, map, str);
        }
    }
}
