package com.bytedance.android.anniex.detect;

import android.graphics.Bitmap;
import com.bytedance.forest.model.PreloadConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DetectorConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/anniex/detect/DetectionContext;", "", "bitmap", "Landroid/graphics/Bitmap;", "detectionStatus", "Lcom/bytedance/android/anniex/detect/DetectionStatus;", "extras", "", "", "(Landroid/graphics/Bitmap;Lcom/bytedance/android/anniex/detect/DetectionStatus;Ljava/util/Map;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getDetectionStatus", "()Lcom/bytedance/android/anniex/detect/DetectionStatus;", "getExtras", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class DetectionContext {
    private final Bitmap bitmap;
    private final DetectionStatus detectionStatus;
    private final Map<String, Object> extras;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DetectionContext copy$default(DetectionContext detectionContext, Bitmap bitmap, DetectionStatus detectionStatus, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            bitmap = detectionContext.bitmap;
        }
        if ((i & 2) != 0) {
            detectionStatus = detectionContext.detectionStatus;
        }
        if ((i & 4) != 0) {
            map = detectionContext.extras;
        }
        return detectionContext.copy(bitmap, detectionStatus, map);
    }

    /* renamed from: component1, reason: from getter */
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    /* renamed from: component2, reason: from getter */
    public final DetectionStatus getDetectionStatus() {
        return this.detectionStatus;
    }

    public final Map<String, Object> component3() {
        return this.extras;
    }

    public final DetectionContext copy(Bitmap bitmap, DetectionStatus detectionStatus, Map<String, Object> extras) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(detectionStatus, "detectionStatus");
        Intrinsics.checkNotNullParameter(extras, "extras");
        return new DetectionContext(bitmap, detectionStatus, extras);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DetectionContext)) {
            return false;
        }
        DetectionContext detectionContext = (DetectionContext) other;
        return Intrinsics.areEqual(this.bitmap, detectionContext.bitmap) && Intrinsics.areEqual(this.detectionStatus, detectionContext.detectionStatus) && Intrinsics.areEqual(this.extras, detectionContext.extras);
    }

    public int hashCode() {
        return (((this.bitmap.hashCode() * 31) + this.detectionStatus.hashCode()) * 31) + this.extras.hashCode();
    }

    public String toString() {
        return "DetectionContext(bitmap=" + this.bitmap + ", detectionStatus=" + this.detectionStatus + ", extras=" + this.extras + ')';
    }

    public DetectionContext(Bitmap bitmap, DetectionStatus detectionStatus, Map<String, Object> extras) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(detectionStatus, "detectionStatus");
        Intrinsics.checkNotNullParameter(extras, "extras");
        this.bitmap = bitmap;
        this.detectionStatus = detectionStatus;
        this.extras = extras;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ DetectionContext(android.graphics.Bitmap r21, com.bytedance.android.anniex.detect.DetectionStatus r22, java.util.Map r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r20 = this;
            r0 = r24 & 2
            if (r0 == 0) goto L22
            com.bytedance.android.anniex.detect.DetectionStatus r0 = new com.bytedance.android.anniex.detect.DetectionStatus
            r1 = r0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 65535(0xffff, float:9.1834E-41)
            r19 = 0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            goto L24
        L22:
            r0 = r22
        L24:
            r1 = r24 & 4
            if (r1 == 0) goto L34
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            java.util.Map r1 = (java.util.Map) r1
            r2 = r20
            r3 = r21
            goto L3a
        L34:
            r2 = r20
            r3 = r21
            r1 = r23
        L3a:
            r2.<init>(r3, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.android.anniex.detect.DetectionContext.<init>(android.graphics.Bitmap, com.bytedance.android.anniex.detect.DetectionStatus, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final DetectionStatus getDetectionStatus() {
        return this.detectionStatus;
    }

    public final Map<String, Object> getExtras() {
        return this.extras;
    }
}
