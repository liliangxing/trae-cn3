package com.bytedance.ies.bullet.lynx.init;

import android.util.AndroidRuntimeException;
import android.util.Log;
import com.lynx.devtoolwrapper.LynxDevtoolCardListener;
import com.lynx.devtoolwrapper.LynxDevtoolGlobalHelper;
import com.lynx.tasm.LynxEnv;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: LynxDevtoolWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tJ\r\u0010\u0010\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u0011J\u0010\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/init/LynxDevtoolWrapper;", "", "()V", "TAG", "", "dependDevtool", "", "devtoolNeedsList", "", "Lcom/bytedance/ies/bullet/lynx/init/LynxDevtoolProcessor;", "mListener", "com/bytedance/ies/bullet/lynx/init/LynxDevtoolWrapper$mListener$1", "Lcom/bytedance/ies/bullet/lynx/init/LynxDevtoolWrapper$mListener$1;", "addDevtoolProcessor", "", "processor", "registerDevtoolListener", "registerDevtoolListener$anniex_release", "triggerLynxDevtool", "url", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxDevtoolWrapper {
    public static final LynxDevtoolWrapper INSTANCE = new LynxDevtoolWrapper();
    private static final String TAG = "LynxDevtoolWrapper";
    private static boolean dependDevtool;
    private static final List<LynxDevtoolProcessor> devtoolNeedsList;
    private static final LynxDevtoolWrapper$mListener$1 mListener;

    private LynxDevtoolWrapper() {
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.ies.bullet.lynx.init.LynxDevtoolWrapper$mListener$1] */
    static {
        try {
            dependDevtool = true;
        } catch (Throwable unused) {
            new AndroidRuntimeException("Just Warning: No Devtool Dependency found, add lynx_devtool if needs").printStackTrace();
        }
        devtoolNeedsList = new ArrayList();
        mListener = new LynxDevtoolCardListener() { // from class: com.bytedance.ies.bullet.lynx.init.LynxDevtoolWrapper$mListener$1
            public void open(String url) {
                List list;
                List<LynxDevtoolProcessor> list2;
                StringBuilder sb = new StringBuilder("LynxDevtoolCardListener open. size:");
                list = LynxDevtoolWrapper.devtoolNeedsList;
                Log.i("LynxDevtoolWrapper", sb.append(list.size()).toString());
                list2 = LynxDevtoolWrapper.devtoolNeedsList;
                for (LynxDevtoolProcessor lynxDevtoolProcessor : list2) {
                    Log.i("LynxDevtoolWrapper", "current item:" + lynxDevtoolProcessor);
                    if (lynxDevtoolProcessor.redirect(url)) {
                        Log.i("LynxDevtoolWrapper", "open card successfully! item:" + lynxDevtoolProcessor);
                        return;
                    }
                }
            }
        };
    }

    public final void addDevtoolProcessor(LynxDevtoolProcessor processor) {
        Intrinsics.checkNotNullParameter(processor, "processor");
        devtoolNeedsList.add(processor);
    }

    public final void registerDevtoolListener$anniex_release() {
        if (dependDevtool) {
            LynxEnv.inst().enableLynxDebug(true);
            if (!LynxKitBase.INSTANCE.getDevtoolOuterControl()) {
                LynxEnv.inst().enableDevtool(true);
            }
            LynxDevtoolGlobalHelper.getInstance().registerCardListener(mListener);
        }
    }

    public final boolean triggerLynxDevtool(String url) {
        if (url != null) {
            if ((StringsKt.contains$default(url, "//remote_debug_lynx", false, 2, (Object) null) ? url : null) != null) {
                LynxDevtoolGlobalHelper lynxDevtoolGlobalHelper = LynxDevtoolGlobalHelper.getInstance();
                if (lynxDevtoolGlobalHelper.shouldPrepareRemoteDebug(url)) {
                    lynxDevtoolGlobalHelper.prepareRemoteDebug(url);
                    return true;
                }
            }
        }
        return false;
    }
}
