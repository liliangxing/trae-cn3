package com.bytedance.trae.praise;

import android.app.Activity;
import android.content.DialogInterface;
import com.bytedance.praisedialoglib.callback.IPraiseDialogActionCallback;
import com.bytedance.praisedialoglib.callback.IPraiseDialogCallback;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: PraiseDialogHelper.kt */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/bytedance/trae/praise/PraiseDialogHelper$registerCustomDialogCallback$1", "Lcom/bytedance/praisedialoglib/callback/IPraiseDialogActionCallback;", "onPraiseDialogShow", "", "iPraiseDialogCallback", "Lcom/bytedance/praisedialoglib/callback/IPraiseDialogCallback;", "praise_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PraiseDialogHelper$registerCustomDialogCallback$1 implements IPraiseDialogActionCallback {
    @Override // com.bytedance.praisedialoglib.callback.IPraiseDialogActionCallback
    public void onPraiseDialogShow(final IPraiseDialogCallback iPraiseDialogCallback) {
        Activity currentActivity = AppHost.Companion.getActivityStackManager().getCurrentActivity();
        if (currentActivity == null || currentActivity.isFinishing() || currentActivity.isDestroyed()) {
            FLogger.INSTANCE.mo430w("Praise", "registerCustomDialogCallback: activity is null, skip showing dialog");
            return;
        }
        PraiseDialog praiseDialog = new PraiseDialog(currentActivity, new Function0() { // from class: com.bytedance.trae.praise.PraiseDialogHelper$registerCustomDialogCallback$1$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit onPraiseDialogShow$lambda$0;
                onPraiseDialogShow$lambda$0 = PraiseDialogHelper$registerCustomDialogCallback$1.onPraiseDialogShow$lambda$0(IPraiseDialogCallback.this);
                return onPraiseDialogShow$lambda$0;
            }
        }, new Function0() { // from class: com.bytedance.trae.praise.PraiseDialogHelper$registerCustomDialogCallback$1$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit onPraiseDialogShow$lambda$1;
                onPraiseDialogShow$lambda$1 = PraiseDialogHelper$registerCustomDialogCallback$1.onPraiseDialogShow$lambda$1(IPraiseDialogCallback.this);
                return onPraiseDialogShow$lambda$1;
            }
        });
        praiseDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.trae.praise.PraiseDialogHelper$registerCustomDialogCallback$1$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                PraiseDialogHelper$registerCustomDialogCallback$1.onPraiseDialogShow$lambda$2(IPraiseDialogCallback.this, dialogInterface);
            }
        });
        praiseDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.trae.praise.PraiseDialogHelper$registerCustomDialogCallback$1$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                PraiseDialogHelper$registerCustomDialogCallback$1.onPraiseDialogShow$lambda$3(IPraiseDialogCallback.this, dialogInterface);
            }
        });
        praiseDialog.show();
        FLogger.INSTANCE.mo428i("Praise", "registerCustomDialogCallback: PraiseDialog shown");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onPraiseDialogShow$lambda$0(IPraiseDialogCallback iPraiseDialogCallback) {
        if (iPraiseDialogCallback != null) {
            iPraiseDialogCallback.onPraiseBtnClick();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onPraiseDialogShow$lambda$1(IPraiseDialogCallback iPraiseDialogCallback) {
        if (iPraiseDialogCallback != null) {
            iPraiseDialogCallback.onFeedbackBtnClick();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPraiseDialogShow$lambda$2(IPraiseDialogCallback iPraiseDialogCallback, DialogInterface dialogInterface) {
        if (iPraiseDialogCallback != null) {
            iPraiseDialogCallback.onDialogShow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPraiseDialogShow$lambda$3(IPraiseDialogCallback iPraiseDialogCallback, DialogInterface dialogInterface) {
        if (iPraiseDialogCallback != null) {
            iPraiseDialogCallback.onDialogDismiss();
        }
    }
}
