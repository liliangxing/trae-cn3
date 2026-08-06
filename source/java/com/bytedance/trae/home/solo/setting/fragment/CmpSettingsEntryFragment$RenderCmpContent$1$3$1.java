package com.bytedance.trae.home.solo.setting.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CmpSettingsEntryFragment.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public /* synthetic */ class CmpSettingsEntryFragment$RenderCmpContent$1$3$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CmpSettingsEntryFragment$RenderCmpContent$1$3$1(Object obj) {
        super(1, obj, CmpSettingsEntryFragment.class, "applyLanguage", "applyLanguage(Ljava/lang/String;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "p0");
        ((CmpSettingsEntryFragment) this.receiver).applyLanguage(str);
    }
}
