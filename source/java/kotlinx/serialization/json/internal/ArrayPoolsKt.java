package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.openid.appauth.BuildConfig;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: ArrayPools.kt */
@Metadata(m4d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0002"}, m5d2 = {"MAX_CHARS_IN_POOL", BuildConfig.FLAVOR, "kotlinx-serialization-json"}, m6k = 2, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class ArrayPoolsKt {
    private static final int MAX_CHARS_IN_POOL;

    static {
        Object m378constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            Intrinsics.checkNotNullExpressionValue(property, "getProperty(...)");
            m378constructorimpl = Result.m378constructorimpl(StringsKt.toIntOrNull(property));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m378constructorimpl = Result.m378constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m384isFailureimpl(m378constructorimpl)) {
            m378constructorimpl = null;
        }
        Integer num = (Integer) m378constructorimpl;
        MAX_CHARS_IN_POOL = num != null ? num.intValue() : PKIFailureInfo.badSenderNonce;
    }
}
