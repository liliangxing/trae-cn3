package com.bytedance.sdk.account.twiceverify;

import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.ss.android.LogHelper;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TwiceVerifyLogHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0007J$\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0007J*\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0007J$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/sdk/account/twiceverify/TwiceVerifyLogHelper;", "", "()V", "TAG", "", AirActionConstant.ActionId.ACTION_ID_DEFAULT_VALUE, "", "tag", "content", "e", "t", "", RXScreenCaptureService.KEY_INDEX, "log", "level", "", "msg", BaseSwitches.V, "w", "uc_twice_verify_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class TwiceVerifyLogHelper {
    public static final TwiceVerifyLogHelper INSTANCE = new TwiceVerifyLogHelper();
    private static final String TAG = "UCTwiceVerify";

    @JvmStatic
    public static final void e(String str, String str2) {
        e$default(str, str2, null, 4, null);
    }

    @JvmStatic
    public static final void w(String str, String str2) {
        w$default(str, str2, null, 4, null);
    }

    private TwiceVerifyLogHelper() {
    }

    @JvmStatic
    public static final void v(String tag, String content) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(content, "content");
        INSTANCE.log(2, tag, content, null);
    }

    @JvmStatic
    public static final void d(String tag, String content) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(content, "content");
        INSTANCE.log(3, tag, content, null);
    }

    @JvmStatic
    public static final void i(String tag, String content) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(content, "content");
        INSTANCE.log(4, tag, content, null);
    }

    public static /* synthetic */ void w$default(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        w(str, str2, th);
    }

    @JvmStatic
    public static final void w(String tag, String content, Throwable t) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(content, "content");
        INSTANCE.log(5, tag, content, t);
    }

    public static /* synthetic */ void e$default(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        e(str, str2, th);
    }

    @JvmStatic
    public static final void e(String tag, String content, Throwable t) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(content, "content");
        INSTANCE.log(6, tag, content, t);
    }

    private final void log(int level, String tag, String msg, Throwable t) {
        LogHelper.log(level, TAG, tag + ": " + msg, t);
    }
}
