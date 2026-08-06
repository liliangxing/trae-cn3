package com.bytedance.android.anniex.base.container;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle;
import com.bytedance.forest.model.Timing;
import com.bytedance.ies.bullet.core.kit.bridge.IEvent;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.sdk.param.LaunchMode;
import com.bytedance.webx.core.webview.WebViewContainer;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IContainer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H'J\b\u0010\u0010\u001a\u00020\u0011H&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0013\u001a\u00020\u0005H&J\b\u0010\u0014\u001a\u00020\u0005H&J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u0005H'J\b\u0010\u0019\u001a\u00020\u001aH'J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH&J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001f0\u001eH&J\n\u0010 \u001a\u0004\u0018\u00010\u000eH'J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0005H&J\u0010\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0%H&J\b\u0010&\u001a\u00020\u0003H&J\b\u0010'\u001a\u00020\u0003H&J\b\u0010(\u001a\u00020\u0003H&J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0007H&J\b\u0010+\u001a\u00020\u0007H&J(\u0010,\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00052\u0016\b\u0002\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001eH&J@\u0010,\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00052\u0016\b\u0002\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001e2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020\u0003H&J\b\u00102\u001a\u00020\u0003H\u0016J\u0014\u00103\u001a\u00020\u00032\n\b\u0002\u00104\u001a\u0004\u0018\u000105H'J\u0010\u00106\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0016H\u0016J!\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00072\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010:J\u0010\u0010;\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0005H&J)\u0010<\u001a\u00020\u0003\"\u0004\b\u0000\u0010=2\f\u0010>\u001a\b\u0012\u0004\u0012\u0002H=0?2\u0006\u0010@\u001a\u0002H=H&¢\u0006\u0002\u0010AJ\b\u0010B\u001a\u00020\u0003H&J \u0010C\u001a\u00020\u00032\u0016\b\u0002\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001eH&J \u0010D\u001a\u00020\u00032\u0016\u0010E\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001eH&J\u0010\u0010F\u001a\u00020\u00032\u0006\u0010G\u001a\u00020HH'J\b\u0010I\u001a\u00020\u0003H&J\b\u0010J\u001a\u00020\u0003H&J\u0010\u0010K\u001a\u00020\u00032\u0006\u0010L\u001a\u00020\u0005H&J\u001c\u0010K\u001a\u00020\u00032\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u001eH&J\u001c\u0010M\u001a\u00020\u00032\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u001eH&J\u0018\u0010O\u001a\u00020\u00032\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020QH&¨\u0006S"}, d2 = {"Lcom/bytedance/android/anniex/base/container/IContainer;", "", "bindContainerId", "", "containerId", "", "canBackPress", "", WebViewContainer.EVENT_canGoBack, "close", "enterBackground", "enterForeground", Timing.SUFFIX_FINISH, "generateSchemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "schema", "getBDXLaunchMode", "Lcom/bytedance/ies/bullet/service/sdk/param/LaunchMode;", "getBDXTag", "getBid", "getContainerId", "getContextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "getCurrentSchema", "getCurrentUrl", "getKitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "getKitView", "Landroid/view/View;", "getPerfMap", "", "", "getSchemaData", "getSystemContext", "Landroid/content/Context;", "getViewType", "getWeakContext", "Ljava/lang/ref/WeakReference;", WebViewContainer.EVENT_goBack, "hideError", "hideLoading", "interceptBackPress", "enable", "isVisibility", "loadSchema", "renderData", "contextProviderFactory", "lifecycle", "Lcom/bytedance/android/anniex/base/lifecycle/AbsAnnieXLifecycle;", "observerKeyboardStatusChange", "onAttachToWindow", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onEngineReady", "onVisibleChange", "visible", "hasReadySendVisibleEvent", "(ZLjava/lang/Boolean;)V", "preloadSchema", "registerWeakHolder", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "item", "(Ljava/lang/Class;Ljava/lang/Object;)V", "release", WebViewContainer.EVENT_reload, "reloadTemplate", "templateData", "sendEvent", "event", "Lcom/bytedance/ies/bullet/core/kit/bridge/IEvent;", "showError", "showLoading", "updateData", "data", "updateGlobalProps", "globalProps", "updateScreenMetrics", "width", "", "height", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public interface IContainer {
    @Deprecated(message = "迫不得已加的下沉接口，内部重构使用，外部千万不要使用，出了问题不负责修复")
    void bindContainerId(String containerId);

    boolean canBackPress();

    boolean canGoBack();

    void close();

    void enterBackground();

    void enterForeground();

    void finish();

    @Deprecated(level = DeprecationLevel.WARNING, message = "This function will be deleted in future")
    ISchemaData generateSchemaData(String schema);

    LaunchMode getBDXLaunchMode();

    String getBDXTag();

    String getBid();

    String getContainerId();

    ContextProviderFactory getContextProviderFactory();

    ISchemaData getCurrentSchema();

    @Deprecated(message = "实现不稳定，仅容器内部使用，外部千万不要使用，出了问题不负责修复")
    String getCurrentUrl();

    @Deprecated(level = DeprecationLevel.WARNING, message = "This function will be deleted in future")
    KitType getKitType();

    View getKitView();

    Map<String, Long> getPerfMap();

    @Deprecated(level = DeprecationLevel.WARNING, message = "This function will be deleted in future")
    ISchemaData getSchemaData();

    Context getSystemContext();

    String getViewType();

    WeakReference<Context> getWeakContext();

    void goBack();

    void hideError();

    void hideLoading();

    void interceptBackPress(boolean enable);

    boolean isVisibility();

    void loadSchema(String schema, Map<String, ? extends Object> renderData);

    void loadSchema(String schema, Map<String, ? extends Object> renderData, ContextProviderFactory contextProviderFactory, AbsAnnieXLifecycle lifecycle);

    void observerKeyboardStatusChange();

    void onAttachToWindow();

    void onCreate(Bundle savedInstanceState);

    void onEngineReady(ContextProviderFactory contextProviderFactory);

    void onVisibleChange(boolean visible, Boolean hasReadySendVisibleEvent);

    void preloadSchema(String schema);

    <T> void registerWeakHolder(Class<T> clazz, T item);

    void release();

    void reload(Map<String, ? extends Object> renderData);

    void reloadTemplate(Map<String, ? extends Object> templateData);

    @Deprecated(level = DeprecationLevel.WARNING, message = "This function will be deleted in future")
    void sendEvent(IEvent event);

    void showError();

    void showLoading();

    void updateData(String data);

    void updateData(Map<String, ? extends Object> data);

    void updateGlobalProps(Map<String, ? extends Object> globalProps);

    void updateScreenMetrics(int width, int height);

    /* compiled from: IContainer.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static void finish(IContainer iContainer) {
        }

        public static ISchemaData getCurrentSchema(IContainer iContainer) {
            return null;
        }

        public static Context getSystemContext(IContainer iContainer) {
            return null;
        }

        public static void loadSchema(IContainer iContainer, String schema, Map<String, ? extends Object> map, ContextProviderFactory contextProviderFactory, AbsAnnieXLifecycle absAnnieXLifecycle) {
            Intrinsics.checkNotNullParameter(schema, "schema");
        }

        public static void onAttachToWindow(IContainer iContainer) {
        }

        public static void onEngineReady(IContainer iContainer, ContextProviderFactory contextProviderFactory) {
            Intrinsics.checkNotNullParameter(contextProviderFactory, "contextProviderFactory");
        }

        public static /* synthetic */ void onCreate$default(IContainer iContainer, Bundle bundle, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCreate");
            }
            if ((i & 1) != 0) {
                bundle = null;
            }
            iContainer.onCreate(bundle);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void loadSchema$default(IContainer iContainer, String str, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadSchema");
            }
            if ((i & 2) != 0) {
                map = null;
            }
            iContainer.loadSchema(str, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void loadSchema$default(IContainer iContainer, String str, Map map, ContextProviderFactory contextProviderFactory, AbsAnnieXLifecycle absAnnieXLifecycle, int i, Object obj) {
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
            iContainer.loadSchema(str, map, contextProviderFactory, absAnnieXLifecycle);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void reload$default(IContainer iContainer, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reload");
            }
            if ((i & 1) != 0) {
                map = null;
            }
            iContainer.reload(map);
        }

        public static /* synthetic */ void onVisibleChange$default(IContainer iContainer, boolean z, Boolean bool, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onVisibleChange");
            }
            if ((i & 2) != 0) {
                bool = false;
            }
            iContainer.onVisibleChange(z, bool);
        }
    }
}
