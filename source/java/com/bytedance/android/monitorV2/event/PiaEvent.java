package com.bytedance.android.monitorV2.event;

import com.bytedance.android.monitorV2.entity.CustomInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PiaEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/monitorV2/event/PiaEvent;", "Lcom/bytedance/android/monitorV2/event/CustomEvent;", "customInfo", "Lcom/bytedance/android/monitorV2/entity/CustomInfo;", "(Lcom/bytedance/android/monitorV2/entity/CustomInfo;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class PiaEvent extends CustomEvent {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PiaEvent(CustomInfo customInfo) {
        super(customInfo);
        Intrinsics.checkNotNullParameter(customInfo, "customInfo");
    }
}
