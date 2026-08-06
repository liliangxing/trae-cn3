package com.bytedance.trae.home.solo.setting.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CmpDeviceManagementFragment.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public /* synthetic */ class CmpDeviceManagementFragment$RenderCmpContent$2$1 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CmpDeviceManagementFragment$RenderCmpContent$2$1(Object obj) {
        super(0, obj, CmpDeviceManagementFragment.class, "refreshDeviceCache", "refreshDeviceCache()V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m2431invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m2431invoke() {
        ((CmpDeviceManagementFragment) this.receiver).refreshDeviceCache();
    }
}
