package com.bytedance.android.anniex.lite.container;

import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle;
import com.bytedance.android.anniex.web.api.IAnnieXWebLifecycle;
import kotlin.Metadata;

/* compiled from: AnnieXWebEngineProxy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/anniex/lite/container/IStickWebLifeCycle;", "Lcom/bytedance/android/anniex/web/api/IAnnieXWebLifecycle;", "flushStickLifeCycle", "", "iContainer", "Lcom/bytedance/android/anniex/base/container/IContainer;", "lifecycle", "Lcom/bytedance/android/anniex/base/lifecycle/AbsAnnieXLifecycle;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public interface IStickWebLifeCycle extends IAnnieXWebLifecycle {
    void flushStickLifeCycle(IContainer iContainer, AbsAnnieXLifecycle lifecycle);
}
