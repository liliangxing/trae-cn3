package com.bytedance.kmp.image.options;

import com.bytedance.kmp.image.options.KImageSource;
import kotlin.Metadata;

/* compiled from: KImageSource.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/kmp/image/options/None;", "Lcom/bytedance/kmp/image/options/KImageSource;", "()V", "getType", "", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class None implements KImageSource {
    public static final int $stable = 0;
    public static final None INSTANCE = new None();

    @Override // com.bytedance.kmp.image.options.KImageSource
    public int getType() {
        return 0;
    }

    private None() {
    }

    @Override // com.bytedance.kmp.image.options.KImageSource
    public boolean isLocalSource() {
        return KImageSource.DefaultImpls.isLocalSource(this);
    }
}
