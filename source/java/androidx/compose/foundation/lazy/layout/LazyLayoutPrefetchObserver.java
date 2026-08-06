package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;

/* compiled from: LazyLayout.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&J \u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&J \u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchObserver;", "", "onPrefetchRequestInvalid", "", "index", "", "hasPrecompose", "", "onPrecomposeItem", "executed", "averageTime", "", "onPreMeasureItem", "onReachLimitTime", "limitTime", "averageComposeTime", "averagePreMeasureTime", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface LazyLayoutPrefetchObserver {
    void onPreMeasureItem(int index, boolean executed, long averageTime);

    void onPrecomposeItem(int index, boolean executed, long averageTime);

    void onPrefetchRequestInvalid(int index, boolean hasPrecompose);

    void onReachLimitTime(int limitTime, long averageComposeTime, long averagePreMeasureTime);
}
