package com.bytedance.bdturing.verify;

import android.app.Activity;
import android.content.DialogInterface;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.BdTuringCallback;
import com.bytedance.bdturing.BdTuringQaSmsVerifyActivity;
import com.bytedance.bdturing.BdTuringVerifyActivity;
import com.bytedance.bdturing.BdTuringWebLiveActivity;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.LogUtil;
import com.bytedance.bdturing.TuringVerifyInterface;
import com.bytedance.bdturing.VerifyDialog;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.bdturing.monitor.VerifyStateManager;
import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.bdturing.verify.request.AbstractRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RiskControlService.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nJ\u0006\u0010\u0017\u001a\u00020\u0015J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000fH\u0002J\u0018\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000fH\u0016J\b\u0010\u001c\u001a\u00020\fH\u0016J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\fH\u0016J\u0010\u0010!\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u000e\u0010\"\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\fJ\u0006\u0010#\u001a\u00020\u0015J\u0018\u0010$\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000fH\u0002J\u0018\u0010%\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000fH\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006&"}, d2 = {"Lcom/bytedance/bdturing/verify/RiskControlService;", "Lcom/bytedance/bdturing/verify/ITuringVerifyService;", "()V", "currentRequest", "Lcom/bytedance/bdturing/verify/request/AbstractRequest;", "getCurrentRequest", "()Lcom/bytedance/bdturing/verify/request/AbstractRequest;", "setCurrentRequest", "(Lcom/bytedance/bdturing/verify/request/AbstractRequest;)V", "mDialogShowing", "Lcom/bytedance/bdturing/TuringVerifyInterface;", "mOnVerify", "", "mRequest", "resultCallBack", "Lcom/bytedance/bdturing/BdTuringCallback;", "getResultCallBack", "()Lcom/bytedance/bdturing/BdTuringCallback;", "setResultCallBack", "(Lcom/bytedance/bdturing/BdTuringCallback;)V", "bindVerifyInterface", "", "dialog", "dismissVerifyDialog", "doVerify", "request", JsCallParser.VALUE_CALLBACK, "execute", "isOnVerify", "isProcess", "verifyType", "", "isSenseless", "isWebLive", "onVerify", "release", "startVerifyV1", "startVerifyV2", "BdTuringSdk_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class RiskControlService implements ITuringVerifyService {
    public static final RiskControlService INSTANCE = new RiskControlService();
    private static AbstractRequest currentRequest;
    private static TuringVerifyInterface mDialogShowing;
    private static boolean mOnVerify;
    private static AbstractRequest mRequest;
    private static BdTuringCallback resultCallBack;

    @Override // com.bytedance.bdturing.verify.IVerifyService
    public boolean isProcess(int verifyType) {
        return verifyType == 1 || verifyType == 2 || verifyType == 3 || verifyType == 5 || verifyType == 12;
    }

    @Override // com.bytedance.bdturing.verify.ITuringVerifyService
    public boolean isSenseless() {
        return false;
    }

    private RiskControlService() {
    }

    public final AbstractRequest getCurrentRequest() {
        return currentRequest;
    }

    public final void setCurrentRequest(AbstractRequest abstractRequest) {
        currentRequest = abstractRequest;
    }

    public final BdTuringCallback getResultCallBack() {
        return resultCallBack;
    }

    public final void setResultCallBack(BdTuringCallback bdTuringCallback) {
        resultCallBack = bdTuringCallback;
    }

    @Override // com.bytedance.bdturing.verify.IVerifyService
    public boolean execute(AbstractRequest request, BdTuringCallback callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(callback, JsCallParser.VALUE_CALLBACK);
        if (isOnVerify()) {
            VerifyStateManager.getInstance().verifyConflict(request, "");
            if (BdTuring.getInstance().isOnLoginVerify()) {
                Activity activity = request.getActivity();
                if (activity != null) {
                    activity.runOnUiThread(new Runnable() { // from class: com.bytedance.bdturing.verify.RiskControlService$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            RiskControlService.m437execute$lambda0();
                        }
                    });
                }
            } else {
                EventReport.verifyConflict(request, "RiskControlService");
                callback.onFail(BdTuring.VERIFY_FAIL_CONFLICT, null);
                return true;
            }
        }
        mRequest = request;
        SettingsManager.INSTANCE.requestSettings(false, new RiskControlService$execute$2(request, callback));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: execute$lambda-0, reason: not valid java name */
    public static final void m437execute$lambda0() {
        TuringVerifyInterface turingVerifyInterface = mDialogShowing;
        if (turingVerifyInterface != null) {
            turingVerifyInterface.cancelByConflict(1001);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doVerify(AbstractRequest request, BdTuringCallback callback) {
        if (SettingsManager.INSTANCE.getVerifyUseDialogV2() || isWebLive(request)) {
            EventReport.statisticDialogPop(request);
            startVerifyV2(request, callback);
        } else {
            EventReport.statisticDialogPop(request);
            startVerifyV1(request, callback);
        }
    }

    private final void startVerifyV2(AbstractRequest request, BdTuringCallback callback) {
        String name;
        currentRequest = request;
        resultCallBack = callback;
        Activity activity = request.getActivity();
        if (activity != null) {
            if (request.getType() == 1 || request.getType() == 3) {
                BdTuringQaSmsVerifyActivity.startActivity(activity);
                name = BdTuringQaSmsVerifyActivity.class.getName();
                Intrinsics.checkNotNullExpressionValue(name, "BdTuringQaSmsVerifyActivity::class.java.name");
            } else if (isWebLive(request)) {
                BdTuringWebLiveActivity.startActivity(activity);
                name = BdTuringWebLiveActivity.class.getName();
                Intrinsics.checkNotNullExpressionValue(name, "BdTuringWebLiveActivity::class.java.name");
            } else {
                BdTuringVerifyActivity.startActivity(activity);
                name = BdTuringVerifyActivity.class.getName();
                Intrinsics.checkNotNullExpressionValue(name, "BdTuringVerifyActivity::class.java.name");
            }
            EventReport.startActivity(true, name, request);
            return;
        }
        EventReport.startActivity(false, "activity is null", request);
        callback.onFail(6, null);
    }

    private final boolean isWebLive(AbstractRequest request) {
        return Intrinsics.areEqual(TuringVerifyType.LIVE_H5, request.getVerifySubType());
    }

    public final void bindVerifyInterface(TuringVerifyInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        onVerify(true);
        mDialogShowing = dialog;
    }

    public final void release() {
        mDialogShowing = null;
        currentRequest = null;
        resultCallBack = null;
        onVerify(false);
    }

    private final void startVerifyV1(AbstractRequest request, BdTuringCallback callback) {
        if (request.getActivity() == null) {
            callback.onFail(1, null);
            return;
        }
        VerifyDialog verifyDialog = new VerifyDialog(request, callback);
        mDialogShowing = verifyDialog;
        verifyDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.bdturing.verify.RiskControlService$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                RiskControlService.m438startVerifyV1$lambda1(dialogInterface);
            }
        });
        verifyDialog.show();
        onVerify(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startVerifyV1$lambda-1, reason: not valid java name */
    public static final void m438startVerifyV1$lambda1(DialogInterface dialogInterface) {
        if (dialogInterface == mDialogShowing) {
            RiskControlService riskControlService = INSTANCE;
            mDialogShowing = null;
            riskControlService.onVerify(false);
        }
    }

    public final synchronized void onVerify(boolean onVerify) {
        EventReport.VerifyStateChange(onVerify, "RiskControlService", mRequest);
        mOnVerify = onVerify;
    }

    @Override // com.bytedance.bdturing.verify.ITuringVerifyService
    public synchronized boolean isOnVerify() {
        return mOnVerify;
    }

    public final void dismissVerifyDialog() {
        try {
            TuringVerifyInterface turingVerifyInterface = mDialogShowing;
            if (turingVerifyInterface != null) {
                Intrinsics.checkNotNull(turingVerifyInterface);
                if (turingVerifyInterface.isShowing()) {
                    onVerify(false);
                    TuringVerifyInterface turingVerifyInterface2 = mDialogShowing;
                    Intrinsics.checkNotNull(turingVerifyInterface2);
                    turingVerifyInterface2.dismiss();
                }
            }
        } catch (Exception unused) {
            LogUtil.m163w("BdTuring", "an exception caught in the stage of VerifyDialog dismissing.");
        }
    }
}
