package com.bytedance.android.monitorV2.event;

import com.bytedance.android.monitorV2.entity.CustomInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/monitorV2/event/CustomEvent;", "Lcom/bytedance/android/monitorV2/event/HybridEvent;", "customInfo", "Lcom/bytedance/android/monitorV2/entity/CustomInfo;", "(Lcom/bytedance/android/monitorV2/entity/CustomInfo;)V", "getCustomInfo", "()Lcom/bytedance/android/monitorV2/entity/CustomInfo;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public class CustomEvent extends HybridEvent {
    private final CustomInfo customInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomEvent(CustomInfo customInfo) {
        super("custom");
        Intrinsics.checkNotNullParameter(customInfo, "customInfo");
        this.customInfo = customInfo;
        onEventCreated();
    }

    public final CustomInfo getCustomInfo() {
        return this.customInfo;
    }
}
