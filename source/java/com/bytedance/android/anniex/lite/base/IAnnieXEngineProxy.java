package com.bytedance.android.anniex.lite.base;

import android.view.View;
import androidx.core.app.NotificationCompat;
import com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.ies.bullet.core.kit.bridge.IEvent;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAnnieXEngineProxy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cJ\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J@\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\tH\u0016J\u001c\u0010\u0016\u001a\u00020\u00032\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u000bH\u0016J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/anniex/lite/base/IAnnieXEngineProxy;", "", "enterBackground", "", "enterForeground", "getEnginView", "Landroid/view/View;", "loadSchema", StrategyConstants.SCHEMA, "", "renderData", "", "contextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "lifecycle", "Lcom/bytedance/android/anniex/base/lifecycle/AbsAnnieXLifecycle;", "release", "reload", "", "sendEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/bytedance/ies/bullet/core/kit/bridge/IEvent;", "updateData", Constants.KEY_DATA, "updateScreenMetrics", "width", "", "height", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public interface IAnnieXEngineProxy {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String UPDATE_RENDER_DATA = "annie.updateRenderData";

    void enterBackground();

    void enterForeground();

    View getEnginView();

    void loadSchema(String schema, Map<String, ? extends Object> renderData, ContextProviderFactory contextProviderFactory, AbsAnnieXLifecycle lifecycle);

    void release();

    boolean reload();

    void sendEvent(IEvent event);

    void updateData(String data);

    void updateData(Map<String, ? extends Object> data);

    void updateScreenMetrics(int width, int height);

    /* compiled from: IAnnieXEngineProxy.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/anniex/lite/base/IAnnieXEngineProxy$Companion;", "", "()V", "UPDATE_RENDER_DATA", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String UPDATE_RENDER_DATA = "annie.updateRenderData";

        private Companion() {
        }
    }

    /* compiled from: IAnnieXEngineProxy.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class DefaultImpls {
        public static void enterBackground(IAnnieXEngineProxy iAnnieXEngineProxy) {
        }

        public static void enterForeground(IAnnieXEngineProxy iAnnieXEngineProxy) {
        }

        public static View getEnginView(IAnnieXEngineProxy iAnnieXEngineProxy) {
            return null;
        }

        public static void loadSchema(IAnnieXEngineProxy iAnnieXEngineProxy, String str, Map<String, ? extends Object> map, ContextProviderFactory contextProviderFactory, AbsAnnieXLifecycle absAnnieXLifecycle) {
            Intrinsics.checkNotNullParameter(str, StrategyConstants.SCHEMA);
        }

        public static void release(IAnnieXEngineProxy iAnnieXEngineProxy) {
        }

        public static boolean reload(IAnnieXEngineProxy iAnnieXEngineProxy) {
            return false;
        }

        public static void sendEvent(IAnnieXEngineProxy iAnnieXEngineProxy, IEvent iEvent) {
            Intrinsics.checkNotNullParameter(iEvent, NotificationCompat.CATEGORY_EVENT);
        }

        public static void updateData(IAnnieXEngineProxy iAnnieXEngineProxy, String str) {
            Intrinsics.checkNotNullParameter(str, Constants.KEY_DATA);
        }

        public static void updateData(IAnnieXEngineProxy iAnnieXEngineProxy, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, Constants.KEY_DATA);
        }

        public static void updateScreenMetrics(IAnnieXEngineProxy iAnnieXEngineProxy, int i, int i2) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void loadSchema$default(IAnnieXEngineProxy iAnnieXEngineProxy, String str, Map map, ContextProviderFactory contextProviderFactory, AbsAnnieXLifecycle absAnnieXLifecycle, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadSchema");
            }
            if ((i & 2) != 0) {
                map = null;
            }
            if ((i & 4) != 0) {
                contextProviderFactory = null;
            }
            if ((i & 8) != 0) {
                absAnnieXLifecycle = null;
            }
            iAnnieXEngineProxy.loadSchema(str, map, contextProviderFactory, absAnnieXLifecycle);
        }
    }
}
