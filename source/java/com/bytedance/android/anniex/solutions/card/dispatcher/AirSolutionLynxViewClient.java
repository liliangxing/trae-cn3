package com.bytedance.android.anniex.solutions.card.dispatcher;

import com.lynx.tasm.LynxViewClient;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AirSolutionLynxViewClient.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/anniex/solutions/card/dispatcher/AirSolutionLynxViewClient;", "Lcom/lynx/tasm/LynxViewClient;", "onLoadSuccessOuter", "Lkotlin/Function0;", "", "onFirstScreenOuter", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "onFirstScreen", "onLoadSuccess", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AirSolutionLynxViewClient extends LynxViewClient {
    private final Function0<Unit> onFirstScreenOuter;
    private final Function0<Unit> onLoadSuccessOuter;

    public AirSolutionLynxViewClient(Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(function0, "onLoadSuccessOuter");
        Intrinsics.checkNotNullParameter(function02, "onFirstScreenOuter");
        this.onLoadSuccessOuter = function0;
        this.onFirstScreenOuter = function02;
    }

    public void onLoadSuccess() {
        super.onLoadSuccess();
        this.onLoadSuccessOuter.invoke();
    }

    public void onFirstScreen() {
        super.onFirstScreen();
        this.onFirstScreenOuter.invoke();
    }
}
