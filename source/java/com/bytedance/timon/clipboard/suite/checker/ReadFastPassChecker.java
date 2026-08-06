package com.bytedance.timon.clipboard.suite.checker;

import android.os.Build;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.timon.clipboard.suite.config.CertConfigManager;
import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.scene.ScenesDetector;
import com.bytedance.timonbase.utils.WindowManagerGlobalUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReadFastPassChecker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¨\u0006\n"}, d2 = {"Lcom/bytedance/timon/clipboard/suite/checker/ReadFastPassChecker;", "", "()V", "check", "Lcom/bytedance/timon/clipboard/suite/checker/CheckResult;", "cert", "Lcom/bytedance/bpea/basics/Cert;", "hasPrimaryClip", "Lkotlin/Function0;", "", "clipboard-suite_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ReadFastPassChecker {
    public static final ReadFastPassChecker INSTANCE = new ReadFastPassChecker();

    private ReadFastPassChecker() {
    }

    public final CheckResult check(Cert cert, Function0<Boolean> hasPrimaryClip) {
        String str;
        Intrinsics.checkParameterIsNotNull(hasPrimaryClip, "hasPrimaryClip");
        if (cert == null || (str = cert.certToken()) == null) {
            str = "";
        }
        String str2 = str;
        if (CertConfigManager.INSTANCE.disableFastPass(str2)) {
            return new CheckResult(false, "disable fastPass", str2, 0, 8, null);
        }
        if (CertConfigManager.INSTANCE.tokenExpire(str2)) {
            return new CheckResult(true, "token was Expired", str2, CheckResultKt.kTMPasteboardErrorCodeCertExpired);
        }
        if (!ScenesDetector.INSTANCE.isAgreedPrivacy()) {
            return new CheckResult(true, "Can't read clipboard before  agreed   privacy policy.", str2, CheckResultKt.kTMPasteboardErrorCodeNotAgreePrivacy);
        }
        if (TMEnv.INSTANCE.getEnableClipboardWindowFocusChecker() && Build.VERSION.SDK_INT >= 29 && !WindowManagerGlobalUtil.INSTANCE.isAppFocused()) {
            return new CheckResult(true, "Can't read clipboard without focus", str2, CheckResultKt.kTMPasteboardErrorCodeNoFocus);
        }
        if (!((Boolean) hasPrimaryClip.invoke()).booleanValue()) {
            return new CheckResult(true, "Can't read clipboard when clipboard content is empty", str2, CheckResultKt.kTMPasteboardErrorCodeNotContainDataType);
        }
        if (ScenesDetector.INSTANCE.isAppBackground() && ScenesDetector.INSTANCE.enterBackgroundDuration() > CertConfigManager.INSTANCE.getBackgroundDuration()) {
            return new CheckResult(true, "Can't read clipboard in background", str2, CheckResultKt.kTMPasteboardErrorCodeInBackground);
        }
        return new CheckResult(false, "read fastPass check pass", str2, 0, 8, null);
    }
}
