package com.example.interopdemo;

import android.os.Build;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform.android.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/example/interopdemo/AndroidPlatform;", "Lcom/example/interopdemo/Platform;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "sha256", "str", "doRequestKL", "", "url", "kmpNativeInterface_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AndroidPlatform implements Platform {
    private final String name = "Android " + Build.VERSION.SDK_INT;

    @Override // com.example.interopdemo.Platform
    public String sha256(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        return "";
    }

    @Override // com.example.interopdemo.Platform
    public String getName() {
        return this.name;
    }

    @Override // com.example.interopdemo.Platform
    public void doRequestKL(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
