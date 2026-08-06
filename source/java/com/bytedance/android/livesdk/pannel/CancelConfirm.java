package com.bytedance.android.livesdk.pannel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: SheetSlideProcessor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/pannel/CancelConfirm;", "", "onCancel", "", "onConfirm", "Lkotlin/Function0;", "panel_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public interface CancelConfirm {
    void onCancel(Function0<Unit> onConfirm);
}
