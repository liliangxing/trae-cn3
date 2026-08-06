package com.bytedance.android.anniex.container.holder;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.container.holder.IUIComponentHolder;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.ies.bullet.core.kit.bridge.IEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UIComponentHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0004J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u001c\u0010\u0010\u001a\u00020\u00062\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u001c\u0010\u0014\u001a\u00020\u00062\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/anniex/container/holder/UIComponentHolder;", "Lcom/bytedance/android/anniex/base/container/holder/IUIComponentHolder;", "()V", "getContainer", "Lcom/bytedance/android/anniex/base/container/IContainer;", "loadSchema", "", StrategyConstants.SCHEMA, "", "markOpenTime", "bundle", "Landroid/os/Bundle;", "preloadSchema", "sendEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/bytedance/ies/bullet/core/kit/bridge/IEvent;", "updateData", Constants.KEY_DATA, "", "", "updateGlobalProps", "globalProps", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public abstract class UIComponentHolder implements IUIComponentHolder {
    public abstract IContainer getContainer();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void markOpenTime(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        String string = bundle.getString("__x_session_id");
        if (string != null) {
            long j = bundle.getLong("open_time", 0L);
            if (j > 0) {
                MonitorManager.INSTANCE.markOpenTime(string, Long.valueOf(j));
            } else {
                MonitorManager.INSTANCE.markOpenTime(string, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    @Override // com.bytedance.android.anniex.base.container.holder.IUIComponentHolder
    public void loadSchema(String schema) {
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        IContainer.DefaultImpls.loadSchema$default(getContainer(), schema, null, 2, null);
    }

    @Override // com.bytedance.android.anniex.base.container.holder.IUIComponentHolder
    public void preloadSchema(String schema) {
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        getContainer().preloadSchema(schema);
    }

    @Override // com.bytedance.android.anniex.base.container.holder.IUIComponentHolder
    public void updateGlobalProps(Map<String, ? extends Object> globalProps) {
        Intrinsics.checkNotNullParameter(globalProps, "globalProps");
        getContainer().updateGlobalProps(globalProps);
    }

    @Override // com.bytedance.android.anniex.base.container.holder.IUIComponentHolder
    public void updateData(Map<String, ? extends Object> data) {
        Intrinsics.checkNotNullParameter(data, Constants.KEY_DATA);
        getContainer().updateData(data);
    }

    @Override // com.bytedance.android.anniex.base.container.holder.IUIComponentHolder
    public void updateData(String data) {
        Intrinsics.checkNotNullParameter(data, Constants.KEY_DATA);
        getContainer().updateData(data);
    }

    @Override // com.bytedance.android.anniex.base.container.holder.IUIComponentHolder
    public void sendEvent(IEvent event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        getContainer().sendEvent(event);
    }
}
