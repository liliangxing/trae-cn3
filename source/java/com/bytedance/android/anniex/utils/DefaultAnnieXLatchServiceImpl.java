package com.bytedance.android.anniex.utils;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.anniex.utils.IAnnieXLatchService;
import com.bytedance.pia.core.metrics.ErrorType;
import com.lynx.tasm.TimingHandler;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAnnieXLatchService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J$\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\bH\u0016J*\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0015H\u0016J4\u0010\u001e\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\bH\u0016J\u0018\u0010#\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u001bH\u0016¨\u0006%"}, d2 = {"Lcom/bytedance/android/anniex/utils/DefaultAnnieXLatchServiceImpl;", "Lcom/bytedance/android/anniex/utils/IAnnieXLatchService;", "()V", "createLatchProcessOptions", "Lcom/bytedance/android/anniex/utils/IAnnieXLatchService$AnnieXLatchProcessOptions;", TimingHandler.OPEN_TIME, "", "display", "", "errMsg", "url", "getLatchProcess", "Lcom/bytedance/android/anniex/utils/IAnnieXLatchService$Process;", "sessionId", "getLatchViewUrlOrNull", "view", "Landroid/view/View;", "getPrefetchStrategyAndReport", "Lkotlin/Pair;", "Lcom/bytedance/android/anniex/utils/IAnnieXLatchService$PrefetchStrategy;", "uri", "Landroid/net/Uri;", "handlePrefetch", "", "context", "Landroid/content/Context;", "enablePrefetch", "", "isEnableLatch", "schema", ErrorType.PREFETCH, "pageUrl", "latchProcessOptions", "releaseLatchProcess", "reportComponentDuration", "reportComponentStart", "isLatch", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class DefaultAnnieXLatchServiceImpl implements IAnnieXLatchService {
    @Override // com.bytedance.android.anniex.utils.IAnnieXLatchService
    public IAnnieXLatchService.Process getLatchProcess(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        return null;
    }

    @Override // com.bytedance.android.anniex.utils.IAnnieXLatchService
    public String getLatchViewUrlOrNull(View view) {
        return null;
    }

    @Override // com.bytedance.android.anniex.utils.IAnnieXLatchService
    public void handlePrefetch(Context context, Uri uri, String sessionId, boolean enablePrefetch) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
    }

    @Override // com.bytedance.android.anniex.utils.IAnnieXLatchService
    public boolean isEnableLatch(Uri schema) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        return false;
    }

    @Override // com.bytedance.android.anniex.utils.IAnnieXLatchService
    public String prefetch(Context context, String pageUrl, Uri schema, IAnnieXLatchService.AnnieXLatchProcessOptions latchProcessOptions, String sessionId) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(latchProcessOptions, "latchProcessOptions");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        return "";
    }

    @Override // com.bytedance.android.anniex.utils.IAnnieXLatchService
    public void releaseLatchProcess(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
    }

    @Override // com.bytedance.android.anniex.utils.IAnnieXLatchService
    public void reportComponentDuration(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
    }

    @Override // com.bytedance.android.anniex.utils.IAnnieXLatchService
    public void reportComponentStart(String url, boolean isLatch) {
        Intrinsics.checkNotNullParameter(url, "url");
    }

    @Override // com.bytedance.android.anniex.utils.IAnnieXLatchService
    public IAnnieXLatchService.AnnieXLatchProcessOptions createLatchProcessOptions(long openTime, String display, String errMsg, String url) {
        Intrinsics.checkNotNullParameter(display, "display");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        return new IAnnieXLatchService.AnnieXLatchProcessOptions();
    }

    @Override // com.bytedance.android.anniex.utils.IAnnieXLatchService
    public Pair<IAnnieXLatchService.PrefetchStrategy, String> getPrefetchStrategyAndReport(Uri uri, String url) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(url, "url");
        return new Pair<>(IAnnieXLatchService.PrefetchStrategy.Nothing, "annie is not ready.");
    }
}
