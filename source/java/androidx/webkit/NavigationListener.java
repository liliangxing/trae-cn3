package androidx.webkit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public interface NavigationListener {
    default void onFirstContentfulPaintMillis(Page page, long j) {
    }

    default void onLargestContentfulPaintMillis(Page page, long j) {
    }

    default void onNavigationCompleted(Navigation navigation) {
    }

    default void onNavigationRedirected(Navigation navigation) {
    }

    default void onNavigationStarted(Navigation navigation) {
    }

    default void onPageDeleted(Page page) {
    }

    default void onPageDomContentLoadedEvent(Page page) {
    }

    default void onPageLoadEvent(Page page) {
    }

    default void onPerformanceMarkMillis(Page page, String str, long j) {
    }
}
