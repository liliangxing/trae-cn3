package com.bytedance.android.sdk.bdticketguard.key;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AbsKeyHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/key/KeyObject;", "", "newKey", "", "(Z)V", "getNewKey", "()Z", "isComplete", "Lcom/bytedance/android/sdk/bdticketguard/key/TeeKeyObject;", "Lcom/bytedance/android/sdk/bdticketguard/key/ReeKeyObject;", "bd_ticket_guard_core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public abstract class KeyObject {
    private final boolean newKey;

    public abstract boolean isComplete();

    private KeyObject(boolean z) {
        this.newKey = z;
    }

    public /* synthetic */ KeyObject(boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(z);
    }

    public final boolean getNewKey() {
        return this.newKey;
    }
}
