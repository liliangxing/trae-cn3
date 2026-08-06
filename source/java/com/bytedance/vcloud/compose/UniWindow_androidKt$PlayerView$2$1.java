package com.bytedance.vcloud.compose;

import android.content.Context;
import android.widget.LinearLayout;
import com.bytedance.vcloud.uniplayer.UniScaleType;
import com.bytedance.vcloud.uniplayer.WindowClientNative;
import com.ss.ttm.player.TTAVPlayerView;
import com.ss.ttm.player.TTAVWindowClient;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: UniWindow.android.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "invoke"}, k = 3, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
final class UniWindow_androidKt$PlayerView$2$1 extends Lambda implements Function1<Context, LinearLayout> {
    final /* synthetic */ Function1<WindowClientNative, Unit> $onWindowReady;
    final /* synthetic */ UniScaleType $scaleType;
    final /* synthetic */ float $videoAspect;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UniWindow_androidKt$PlayerView$2$1(float f, UniScaleType uniScaleType, Function1<? super WindowClientNative, Unit> function1) {
        super(1);
        this.$videoAspect = f;
        this.$scaleType = uniScaleType;
        this.$onWindowReady = function1;
    }

    public final LinearLayout invoke(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        final Function1<WindowClientNative, Unit> function1 = this.$onWindowReady;
        TTAVPlayerView create = TTAVPlayerView.Factory.create(context, new TTAVPlayerView.LifeCycleCallback() { // from class: com.bytedance.vcloud.compose.UniWindow_androidKt$PlayerView$2$1$$ExternalSyntheticLambda0
            public final void onLoad(TTAVWindowClient tTAVWindowClient) {
                UniWindow_androidKt$PlayerView$2$1.invoke$lambda$0(function1, tTAVWindowClient);
            }
        }, 2, this.$videoAspect, this.$scaleType.getValue());
        LinearLayout linearLayout = new LinearLayout(context);
        create.attachToParent(linearLayout);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(Function1 function1, TTAVWindowClient tTAVWindowClient) {
        Intrinsics.checkNotNullParameter(tTAVWindowClient, "client");
        function1.invoke(new WindowClientImpl(tTAVWindowClient));
    }
}
