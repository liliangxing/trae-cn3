package com.bytedance.bdturing.verify.request;

import android.app.Activity;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.domain.UrlBuilder;
import com.bytedance.bdturing.utils.UtilsKt;
import com.lynx.devtoolwrapper.ScreenshotMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AbstractRequest.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010B\u001a\u00020C2\n\u0010D\u001a\u00060Ej\u0002`FH&J\b\u0010G\u001a\u00020\u001aH\u0016J\b\u0010H\u001a\u00020\u000eH&J\b\u0010I\u001a\u00020\u0004H&J\b\u0010J\u001a\u00020\u000eH&J\b\u0010K\u001a\u00020\u0004H&R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001a\u0010\u0016\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001a\u0010\u0019\u001a\u00020\u001aX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001a\u0010\"\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001a\u0010%\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010\u001eR\u001a\u0010(\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\u001a\u0010+\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001c\"\u0004\b-\u0010\u001eR\u001a\u0010.\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\u001a\u00101\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001c\"\u0004\b3\u0010\u001eR\u0011\u00104\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b5\u0010\u0006R\u001a\u00106\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR\u001a\u00109\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR\u001a\u0010<\u001a\u00020=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A¨\u0006L"}, d2 = {"Lcom/bytedance/bdturing/verify/request/AbstractRequest;", "", "()V", "LogId", "", "getLogId", "()Ljava/lang/String;", "setLogId", "(Ljava/lang/String;)V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "callType", "", "getCallType", "()I", "setCallType", "(I)V", "customUrl", "getCustomUrl", "setCustomUrl", "decision_detail", "getDecision_detail", "setDecision_detail", ScreenshotMode.SCREEN_SHOT_MODE_FULL_SCREEN, "", "getFullscreen", "()Z", "setFullscreen", "(Z)V", "h5PopUp", "getH5PopUp", "setH5PopUp", "loading", "getLoading", "setLoading", "mask", "getMask", "setMask", "maskCancel", "getMaskCancel", "setMaskCancel", "preCreate", "getPreCreate", "setPreCreate", "replayData", "getReplayData", "setReplayData", "skipConfirm", "getSkipConfirm", "setSkipConfirm", "url", "getUrl", "verifyScene", "getVerifyScene", "setVerifyScene", "verifySubType", "getVerifySubType", "setVerifySubType", "verifyTypeCode", "", "getVerifyTypeCode", "()J", "setVerifyTypeCode", "(J)V", "buildUrl", "", "queryBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "cancelAble", "getEventLimits", "getServiceType", "getType", "getVerifyType", "BdTuringSdk_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class AbstractRequest {
    private String customUrl;
    private boolean fullscreen;
    private boolean h5PopUp;
    private boolean maskCancel;
    private boolean preCreate;
    private boolean skipConfirm;
    private long verifyTypeCode;
    private boolean mask = true;
    private boolean loading = true;
    private String LogId = "";
    private String verifyScene = "";
    private int callType = -1;
    private String replayData = "";
    private String decision_detail = "";
    private String verifySubType = "";

    public abstract void buildUrl(StringBuilder queryBuilder);

    public boolean cancelAble() {
        return true;
    }

    public abstract int getEventLimits();

    public abstract String getServiceType();

    public abstract int getType();

    public abstract String getVerifyType();

    public final Activity getActivity() {
        BdTuringConfig config = BdTuring.getInstance().getConfig();
        if (config != null) {
            return config.getTopActivity();
        }
        return null;
    }

    public boolean getFullscreen() {
        return this.fullscreen;
    }

    public void setFullscreen(boolean z) {
        this.fullscreen = z;
    }

    public final boolean getPreCreate() {
        return this.preCreate;
    }

    public final void setPreCreate(boolean z) {
        this.preCreate = z;
    }

    public final boolean getMaskCancel() {
        return this.maskCancel;
    }

    public final void setMaskCancel(boolean z) {
        this.maskCancel = z;
    }

    public final boolean getMask() {
        return this.mask;
    }

    public final void setMask(boolean z) {
        this.mask = z;
    }

    public final boolean getLoading() {
        return this.loading;
    }

    public final void setLoading(boolean z) {
        this.loading = z;
    }

    public final String getLogId() {
        return this.LogId;
    }

    public final void setLogId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.LogId = str;
    }

    public final boolean getH5PopUp() {
        return this.h5PopUp;
    }

    public final void setH5PopUp(boolean z) {
        this.h5PopUp = z;
    }

    public final String getVerifyScene() {
        return this.verifyScene;
    }

    public final void setVerifyScene(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.verifyScene = str;
    }

    public final boolean getSkipConfirm() {
        return this.skipConfirm;
    }

    public final void setSkipConfirm(boolean z) {
        this.skipConfirm = z;
    }

    public final int getCallType() {
        return this.callType;
    }

    public final void setCallType(int i) {
        this.callType = i;
    }

    public final String getReplayData() {
        return this.replayData;
    }

    public final void setReplayData(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.replayData = str;
    }

    public final String getDecision_detail() {
        return this.decision_detail;
    }

    public final void setDecision_detail(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.decision_detail = str;
    }

    public final long getVerifyTypeCode() {
        return this.verifyTypeCode;
    }

    public final void setVerifyTypeCode(long j) {
        this.verifyTypeCode = j;
    }

    public final String getVerifySubType() {
        return this.verifySubType;
    }

    public final void setVerifySubType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.verifySubType = str;
    }

    public final String getCustomUrl() {
        return this.customUrl;
    }

    public final void setCustomUrl(String str) {
        this.customUrl = str;
    }

    public final String getUrl() {
        StringBuilder createBuilder = UrlBuilder.INSTANCE.createBuilder(this.customUrl, getServiceType(), getActivity());
        if (this.preCreate) {
            UtilsKt.appendParams(createBuilder, "preload", 1);
        }
        buildUrl(createBuilder);
        String sb = createBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "queryBuilder.toString()");
        return sb;
    }
}
