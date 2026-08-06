package com.bytedance.android.anniex.container.popup;

import kotlin.Metadata;

/* compiled from: AnnieXPopUpService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/anniex/container/popup/NonFragmentActivityException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class NonFragmentActivityException extends Exception {
    public NonFragmentActivityException() {
        super("context must be FragmentActivity or it's child class");
    }
}
