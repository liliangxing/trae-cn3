package com.bytedance.android.anniex.detect;

import android.graphics.Bitmap;
import android.view.View;
import com.bytedance.forest.model.PreloadConfig;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DetectorConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\u0010\fJ\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\u0015\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\nHÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/bytedance/android/anniex/detect/SnapShotContext;", "", "view", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "bitmap", "Landroid/graphics/Bitmap;", "SnapShotStats", "Lcom/bytedance/android/anniex/detect/SnapShotStats;", "extras", "", "", "(Ljava/lang/ref/WeakReference;Landroid/graphics/Bitmap;Lcom/bytedance/android/anniex/detect/SnapShotStats;Ljava/util/Map;)V", "getSnapShotStats", "()Lcom/bytedance/android/anniex/detect/SnapShotStats;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "getExtras", "()Ljava/util/Map;", "getView", "()Ljava/lang/ref/WeakReference;", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SnapShotContext {
    private final SnapShotStats SnapShotStats;
    private Bitmap bitmap;
    private final Map<String, Object> extras;
    private final WeakReference<View> view;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SnapShotContext copy$default(SnapShotContext snapShotContext, WeakReference weakReference, Bitmap bitmap, SnapShotStats snapShotStats, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            weakReference = snapShotContext.view;
        }
        if ((i & 2) != 0) {
            bitmap = snapShotContext.bitmap;
        }
        if ((i & 4) != 0) {
            snapShotStats = snapShotContext.SnapShotStats;
        }
        if ((i & 8) != 0) {
            map = snapShotContext.extras;
        }
        return snapShotContext.copy(weakReference, bitmap, snapShotStats, map);
    }

    public final WeakReference<View> component1() {
        return this.view;
    }

    /* renamed from: component2, reason: from getter */
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    /* renamed from: component3, reason: from getter */
    public final SnapShotStats getSnapShotStats() {
        return this.SnapShotStats;
    }

    public final Map<String, Object> component4() {
        return this.extras;
    }

    public final SnapShotContext copy(WeakReference<View> view, Bitmap bitmap, SnapShotStats SnapShotStats, Map<String, Object> extras) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(SnapShotStats, "SnapShotStats");
        Intrinsics.checkNotNullParameter(extras, "extras");
        return new SnapShotContext(view, bitmap, SnapShotStats, extras);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SnapShotContext)) {
            return false;
        }
        SnapShotContext snapShotContext = (SnapShotContext) other;
        return Intrinsics.areEqual(this.view, snapShotContext.view) && Intrinsics.areEqual(this.bitmap, snapShotContext.bitmap) && Intrinsics.areEqual(this.SnapShotStats, snapShotContext.SnapShotStats) && Intrinsics.areEqual(this.extras, snapShotContext.extras);
    }

    public int hashCode() {
        int hashCode = this.view.hashCode() * 31;
        Bitmap bitmap = this.bitmap;
        return ((((hashCode + (bitmap == null ? 0 : bitmap.hashCode())) * 31) + this.SnapShotStats.hashCode()) * 31) + this.extras.hashCode();
    }

    public String toString() {
        return "SnapShotContext(view=" + this.view + ", bitmap=" + this.bitmap + ", SnapShotStats=" + this.SnapShotStats + ", extras=" + this.extras + ')';
    }

    public SnapShotContext(WeakReference<View> view, Bitmap bitmap, SnapShotStats SnapShotStats, Map<String, Object> extras) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(SnapShotStats, "SnapShotStats");
        Intrinsics.checkNotNullParameter(extras, "extras");
        this.view = view;
        this.bitmap = bitmap;
        this.SnapShotStats = SnapShotStats;
        this.extras = extras;
    }

    public final WeakReference<View> getView() {
        return this.view;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public /* synthetic */ SnapShotContext(WeakReference weakReference, Bitmap bitmap, SnapShotStats snapShotStats, LinkedHashMap linkedHashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(weakReference, (i & 2) != 0 ? null : bitmap, (i & 4) != 0 ? new SnapShotStats(false, null, 3, null) : snapShotStats, (i & 8) != 0 ? new LinkedHashMap() : linkedHashMap);
    }

    public final SnapShotStats getSnapShotStats() {
        return this.SnapShotStats;
    }

    public final Map<String, Object> getExtras() {
        return this.extras;
    }
}
