package com.github.alexzhirkevich.customqrgenerator;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: QrCodeGenerator.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/QrCodeCreationException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "cause", "", "message", "", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class QrCodeCreationException extends Exception {
    /* JADX WARN: Multi-variable type inference failed */
    public QrCodeCreationException() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public /* synthetic */ QrCodeCreationException(Throwable th, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : th, (i & 2) != 0 ? null : str);
    }

    public QrCodeCreationException(Throwable th, String str) {
        super(str, th);
    }
}
