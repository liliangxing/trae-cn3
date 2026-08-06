package com.bytedance.android.anniex.detect;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: AnnieXBlankDetector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/anniex/detect/AnnieXBlankDetector;", "", "snapShotPipeline", "Lcom/bytedance/android/anniex/detect/SnapshotPipeline;", "detectPipeline", "Lcom/bytedance/android/anniex/detect/DetectionPipeline;", "(Lcom/bytedance/android/anniex/detect/SnapshotPipeline;Lcom/bytedance/android/anniex/detect/DetectionPipeline;)V", "asFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bytedance/android/anniex/detect/DetectionStatus;", "view", "Landroid/view/View;", "detectionStatus", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXBlankDetector {
    private final DetectionPipeline detectPipeline;
    private final SnapshotPipeline snapShotPipeline;

    public AnnieXBlankDetector(SnapshotPipeline snapshotPipeline, DetectionPipeline detectionPipeline) {
        Intrinsics.checkNotNullParameter(snapshotPipeline, "snapShotPipeline");
        Intrinsics.checkNotNullParameter(detectionPipeline, "detectPipeline");
        this.snapShotPipeline = snapshotPipeline;
        this.detectPipeline = detectionPipeline;
    }

    public final Flow<DetectionStatus> asFlow(View view, DetectionStatus detectionStatus) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(detectionStatus, "detectionStatus");
        return FlowKt.flowOn(FlowKt.catch(FlowKt.flow(new AnnieXBlankDetector$asFlow$1(view, this, detectionStatus, null)), new AnnieXBlankDetector$asFlow$2(detectionStatus, null)), Dispatchers.getIO());
    }
}
