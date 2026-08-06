package com.bytedance.android.monitorV2.standard;

import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContainerType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/monitorV2/standard/ContainerType;", "", "container", "Landroid/view/View;", "type", "", "(Landroid/view/View;Ljava/lang/String;)V", "mContainer", "Ljava/lang/ref/WeakReference;", "getType", "()Ljava/lang/String;", "getContainer", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class ContainerType {
    private final WeakReference<View> mContainer;
    private final String type;

    public ContainerType(View container, String type) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.mContainer = new WeakReference<>(container);
    }

    public final String getType() {
        return this.type;
    }

    public final View getContainer() {
        return this.mContainer.get();
    }
}
