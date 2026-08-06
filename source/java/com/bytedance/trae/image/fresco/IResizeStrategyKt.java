package com.bytedance.trae.image.fresco;

import android.net.Uri;
import com.bytedance.trae.im.model.MessagePart;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* compiled from: IResizeStrategy.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a:\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0010"}, d2 = {"strategies", "", "Lcom/bytedance/trae/image/fresco/IResizeStrategy;", "getStrategies", "()Ljava/util/List;", MessagePart.TYPE_LOG, "", "tag", "", "uri", "Landroid/net/Uri;", "imgWidth", "", "imgHeight", "viewWidth", "viewHeight", "impl_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class IResizeStrategyKt {
    private static final List<IResizeStrategy> strategies = CollectionsKt.listOf(new IResizeStrategy[]{PreviewLongImageStrategy.INSTANCE, DefaultResizeStrategy.INSTANCE});

    public static final List<IResizeStrategy> getStrategies() {
        return strategies;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void log(String str, Uri uri, int i, int i2, int i3, int i4) {
        FLogger.INSTANCE.i(str, "use strategy for " + uri + ", img=" + i + 'x' + i2 + ", view=" + i3 + 'x' + i4);
    }
}
