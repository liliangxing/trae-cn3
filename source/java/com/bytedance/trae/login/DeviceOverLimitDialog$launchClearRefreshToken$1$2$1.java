package com.bytedance.trae.login;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.trae.login.databinding.TraeDialogDeviceOverLimitBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DeviceOverLimitDialog.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.DeviceOverLimitDialog$launchClearRefreshToken$1$2$1", f = "DeviceOverLimitDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class DeviceOverLimitDialog$launchClearRefreshToken$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ DeviceOverLimitDeviceAdapter $adapter;
    final /* synthetic */ TraeDialogDeviceOverLimitBinding $binding;
    final /* synthetic */ String $deviceId;
    final /* synthetic */ int $maxDeviceCount;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceOverLimitDialog$launchClearRefreshToken$1$2$1(DeviceOverLimitDeviceAdapter deviceOverLimitDeviceAdapter, String str, int i, TraeDialogDeviceOverLimitBinding traeDialogDeviceOverLimitBinding, Activity activity, Continuation<? super DeviceOverLimitDialog$launchClearRefreshToken$1$2$1> continuation) {
        super(2, continuation);
        this.$adapter = deviceOverLimitDeviceAdapter;
        this.$deviceId = str;
        this.$maxDeviceCount = i;
        this.$binding = traeDialogDeviceOverLimitBinding;
        this.$activity = activity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceOverLimitDialog$launchClearRefreshToken$1$2$1(this.$adapter, this.$deviceId, this.$maxDeviceCount, this.$binding, this.$activity, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$adapter.removeDevice(this.$deviceId);
        if (this.$adapter.getItemCount() < this.$maxDeviceCount) {
            View childAt = this.$binding.btnLoginCurrent.getChildAt(0);
            TextView textView = childAt instanceof TextView ? (TextView) childAt : null;
            if (textView != null) {
                textView.setEnabled(true);
            }
            if (textView != null) {
                textView.setBackgroundResource(C0820R.drawable.trae_login_bg_btn_new);
            }
            if (textView != null) {
                textView.setTextColor(ContextCompat.getColor(this.$activity, com.bytedance.trae.common_ui.R.color.trae_text_text_onaccent));
            }
            this.$binding.btnLoginCurrent.setEnabled(true);
        }
        return Unit.INSTANCE;
    }
}
