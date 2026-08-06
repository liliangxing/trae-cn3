package com.bytedance.android.anniex.detect;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: DetectorConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/anniex/detect/DetectionStep;", "", "id", "", "getId", "()Ljava/lang/String;", "execute", "Lcom/bytedance/android/anniex/detect/BlankCheckResult;", "context", "Lcom/bytedance/android/anniex/detect/DetectionContext;", "(Lcom/bytedance/android/anniex/detect/DetectionContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public interface DetectionStep {
    Object execute(DetectionContext detectionContext, Continuation<? super BlankCheckResult> continuation);

    String getId();
}
