package com.github.alexzhirkevich.customqrgenerator;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrCodeGenerator.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"QrCodeGenerator", "Lcom/github/alexzhirkevich/customqrgenerator/QrCodeGenerator;", "threadPolicy", "Lcom/github/alexzhirkevich/customqrgenerator/ThreadPolicy;", "custom_qr_generator_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class QrCodeGeneratorKt {
    public static /* synthetic */ QrCodeGenerator QrCodeGenerator$default(ThreadPolicy threadPolicy, int i, Object obj) {
        if ((i & 1) != 0) {
            threadPolicy = ThreadPolicy.SingleThread;
        }
        return QrCodeGenerator(threadPolicy);
    }

    @Deprecated(message = "Use QrCodeDrawable instead")
    public static final QrCodeGenerator QrCodeGenerator(ThreadPolicy threadPolicy) {
        Intrinsics.checkNotNullParameter(threadPolicy, "threadPolicy");
        return new QrCodeGeneratorImpl(threadPolicy);
    }
}
