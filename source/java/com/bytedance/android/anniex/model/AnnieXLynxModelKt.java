package com.bytedance.android.anniex.model;

import com.bytedance.android.anniex.model.AnnieXLynxModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXLynxModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toComparableByteArray", "Lcom/bytedance/android/anniex/model/AnnieXLynxModel$ComparableByteArray;", "", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class AnnieXLynxModelKt {
    public static final AnnieXLynxModel.ComparableByteArray toComparableByteArray(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return new AnnieXLynxModel.ComparableByteArray(bArr);
    }
}
