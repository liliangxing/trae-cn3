package com.bytedance.timon.foundation.interfaces;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: TimonBackgroundReferee.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0006H&J\u001c\u0010\n\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/timon/foundation/interfaces/TimonBackgroundReferee;", "", "addStatusChangeListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "", "enterBackgroundTimeStamp", "", "isAppBackground", "removeStatusChangeListener", "timonfoundation_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public interface TimonBackgroundReferee {
    void addStatusChangeListener(Function1<? super Boolean, Unit> listener);

    long enterBackgroundTimeStamp();

    boolean isAppBackground();

    void removeStatusChangeListener(Function1<? super Boolean, Unit> listener);
}
