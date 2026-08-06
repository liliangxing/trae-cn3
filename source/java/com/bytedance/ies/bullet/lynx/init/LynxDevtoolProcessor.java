package com.bytedance.ies.bullet.lynx.init;

import com.bytedance.apm.constant.ReportConsts;
import kotlin.Metadata;

/* compiled from: LynxDevtoolWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/init/LynxDevtoolProcessor;", "", ReportConsts.RESPONSE_REDIRECT, "", "url", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface LynxDevtoolProcessor {

    /* compiled from: LynxDevtoolWrapper.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static boolean redirect(LynxDevtoolProcessor lynxDevtoolProcessor, String str) {
            return false;
        }
    }

    boolean redirect(String url);
}
