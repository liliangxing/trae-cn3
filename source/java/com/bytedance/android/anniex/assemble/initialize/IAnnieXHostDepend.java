package com.bytedance.android.anniex.assemble.initialize;

import android.app.Application;
import com.bytedance.android.anniex.base.depend.ApplicationDepend;
import com.bytedance.android.anniex.base.depend.DeviceDepend;
import com.bytedance.android.anniex.base.service.AnnieXServiceProvider;
import kotlin.Metadata;

/* compiled from: IAnnieXHostDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/anniex/assemble/initialize/IAnnieXHostDepend;", "", "createApplicationDepend", "Lcom/bytedance/android/anniex/base/depend/ApplicationDepend;", "createDeviceDepend", "Lcom/bytedance/android/anniex/base/depend/DeviceDepend;", "createServiceProvider", "Lcom/bytedance/android/anniex/base/service/AnnieXServiceProvider;", "bid", "", "ensureRuntimeReady", "", "initRelax", "context", "Landroid/app/Application;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public interface IAnnieXHostDepend {
    ApplicationDepend createApplicationDepend();

    DeviceDepend createDeviceDepend();

    AnnieXServiceProvider createServiceProvider(String bid);

    void ensureRuntimeReady();

    void initRelax(Application context);
}
