package com.bytedance.ies.argus.aspect.eventCenter;

import android.view.View;
import com.bytedance.ies.argus.api.params.IFePageInfo;
import com.bytedance.ies.argus.util.CommonUtils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseViewContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0002\u0010\u001bJ\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH&J\b\u0010\u001e\u001a\u00020\u000fH\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R.\u0010\u0016\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00152\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ies/argus/aspect/eventCenter/BaseViewContext;", "T", "Landroid/view/View;", "Lcom/bytedance/ies/argus/aspect/eventCenter/BaseRuntimeContext;", "()V", "feAuthConfig", "Lcom/bytedance/ies/argus/aspect/eventCenter/FeAuthConfig;", "getFeAuthConfig", "()Lcom/bytedance/ies/argus/aspect/eventCenter/FeAuthConfig;", "setFeAuthConfig", "(Lcom/bytedance/ies/argus/aspect/eventCenter/FeAuthConfig;)V", "view", "getView", "()Landroid/view/View;", "<set-?>", "", "viewClassName", "getViewClassName", "()Ljava/lang/String;", "viewId", "getViewId", "Ljava/lang/ref/WeakReference;", "weakView", "getWeakView", "()Ljava/lang/ref/WeakReference;", "attachView", "", "(Landroid/view/View;)V", "getMainPageInfo", "Lcom/bytedance/ies/argus/api/params/IFePageInfo;", "updateContextLogTag", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class BaseViewContext<T extends View> extends BaseRuntimeContext {
    private FeAuthConfig feAuthConfig;
    private String viewClassName = "";
    private String viewId;
    private WeakReference<T> weakView;

    public abstract IFePageInfo getMainPageInfo();

    @Override // com.bytedance.ies.argus.aspect.eventCenter.BaseRuntimeContext
    public String updateContextLogTag() {
        return "view";
    }

    public final WeakReference<T> getWeakView() {
        return this.weakView;
    }

    public final T getView() {
        WeakReference<T> weakReference = this.weakView;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final String getViewClassName() {
        return this.viewClassName;
    }

    public final String getViewId() {
        return this.viewId;
    }

    public final FeAuthConfig getFeAuthConfig() {
        return this.feAuthConfig;
    }

    public final void setFeAuthConfig(FeAuthConfig feAuthConfig) {
        this.feAuthConfig = feAuthConfig;
    }

    public final void attachView(T view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.weakView = new WeakReference<>(view);
        this.viewId = CommonUtils.INSTANCE.getObjectId(view);
        String name = view.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "view.javaClass.name");
        this.viewClassName = name;
    }
}
