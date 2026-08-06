package com.bytedance.android.anniex.detect;

import android.graphics.Bitmap;
import com.bytedance.android.anniex.ability.service.AnnieXPitayaProvider;
import com.bytedance.android.anniex.ability.service.TaskConfig;
import com.bytedance.android.anniex.ability.service.TaskResultCallback;
import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.android.anniex.pitaya.PitayaPackageInfo;
import com.bytedance.android.anniex.pitaya.StrategyError;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.json.JSONObject;

/* compiled from: AnnieXBlankDetectorManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "callback", "Lcom/bytedance/android/anniex/ability/service/TaskResultCallback;"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.android.anniex.detect.AnnieXBlankDetectorManager$getBlankDetections$1", f = "AnnieXBlankDetectorManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
final class AnnieXBlankDetectorManager$getBlankDetections$1 extends SuspendLambda implements Function3<Bitmap, TaskResultCallback, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnnieXBlankDetectorManager$getBlankDetections$1(Continuation<? super AnnieXBlankDetectorManager$getBlankDetections$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(Bitmap bitmap, TaskResultCallback taskResultCallback, Continuation<? super Unit> continuation) {
        AnnieXBlankDetectorManager$getBlankDetections$1 annieXBlankDetectorManager$getBlankDetections$1 = new AnnieXBlankDetectorManager$getBlankDetections$1(continuation);
        annieXBlankDetectorManager$getBlankDetections$1.L$0 = bitmap;
        annieXBlankDetectorManager$getBlankDetections$1.L$1 = taskResultCallback;
        return annieXBlankDetectorManager$getBlankDetections$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Bitmap bitmap = (Bitmap) this.L$0;
        final TaskResultCallback taskResultCallback = (TaskResultCallback) this.L$1;
        AnnieXPitayaProvider annieXPitayaProvider = (AnnieXPitayaProvider) AnnieXServiceCenter.INSTANCE.getService("default_bid", AnnieXPitayaProvider.class);
        if (annieXPitayaProvider != null) {
            annieXPitayaProvider.runPartialBlankDetect(bitmap, new TaskConfig("caijing_half_blank_detection", false, null, 5.0f), new JSONObject(), new TaskResultCallback() { // from class: com.bytedance.android.anniex.detect.AnnieXBlankDetectorManager$getBlankDetections$1$1$1
                @Override // com.bytedance.android.anniex.ability.service.TaskResultCallback
                public void onResult(boolean isPitayaReady, boolean success, StrategyError error, JSONObject outputData, JSONObject extraParams, PitayaPackageInfo packageInfo) {
                    TaskResultCallback.this.onResult(isPitayaReady, success, error, outputData, extraParams, packageInfo);
                }
            });
        }
        return Unit.INSTANCE;
    }
}
