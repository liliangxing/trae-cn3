package com.bytedance.trae.home.solo.setting.fragment;

import com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CmpSettingsAboutFragment.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public /* synthetic */ class CmpSettingsAboutFragment$RenderCmpContent$1$1 extends FunctionReferenceImpl implements Function2<SettingsAboutItem, String, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CmpSettingsAboutFragment$RenderCmpContent$1$1(Object obj) {
        super(2, obj, CmpSettingsAboutFragment.class, "handleItemClick", "handleItemClick(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;Ljava/lang/String;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((SettingsAboutItem) obj, (String) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(SettingsAboutItem settingsAboutItem, String str) {
        Intrinsics.checkNotNullParameter(settingsAboutItem, "p0");
        Intrinsics.checkNotNullParameter(str, "p1");
        ((CmpSettingsAboutFragment) this.receiver).handleItemClick(settingsAboutItem, str);
    }
}
