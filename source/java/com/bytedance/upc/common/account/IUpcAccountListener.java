package com.bytedance.upc.common.account;

import com.bytedance.upc.BuildConfig;
import com.ss.android.ug.bus.account.event.OnLoginEvent;
import com.ss.android.ug.bus.account.event.OnLogoutEvent;
import com.ss.android.ug.bus.account.event.OnSwitchEvent;
import kotlin.Metadata;

/* compiled from: IUpcAccountListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/bytedance/upc/common/account/IUpcAccountListener;", "", "onChangeEvent", "", "event", "Lcom/ss/android/ug/bus/account/event/OnSwitchEvent;", "onLoginEvent", "Lcom/ss/android/ug/bus/account/event/OnLoginEvent;", "onLogoutEvent", "Lcom/ss/android/ug/bus/account/event/OnLogoutEvent;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: classes6.dex */
public interface IUpcAccountListener {
    void onChangeEvent(OnSwitchEvent event);

    void onLoginEvent(OnLoginEvent event);

    void onLogoutEvent(OnLogoutEvent event);
}
