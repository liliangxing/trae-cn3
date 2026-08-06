package com.bytedance.ies.bullet.service.base;

import android.view.View;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.callbacks.KitViewCallback;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.context.IContextProviderFactory;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IKitViewService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH&J\b\u0010\u001e\u001a\u00020\u001dH&J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\"H&J\b\u0010#\u001a\u00020 H&J\n\u0010$\u001a\u0004\u0018\u00010 H&J\b\u0010%\u001a\u00020 H&J\u001c\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020 2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)H&J\b\u0010*\u001a\u00020\u001dH&J\b\u0010+\u001a\u00020\u001bH&J\b\u0010,\u001a\u00020\u001bH&J\n\u0010-\u001a\u0004\u0018\u00010.H&J\b\u0010/\u001a\u00020\u001bH&J\b\u00100\u001a\u00020\u001bH&J,\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020 2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u000106H&J,\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u0002032\u0006\u00104\u001a\u00020 2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u000106H&J\u001a\u00109\u001a\u00020\u001b2\u0006\u0010:\u001a\u00020 2\b\u0010;\u001a\u0004\u0018\u00010\u0001H&J\"\u00109\u001a\u00020\u001b2\u0006\u0010:\u001a\u00020 2\b\u0010;\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001c\u001a\u00020\u001dH&J\b\u0010<\u001a\u00020\u001bH&J\u001c\u0010=\u001a\u00020\u001b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u000106H&J\u001c\u0010>\u001a\u00020\u001b2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u000106H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u0015X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006@"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "", "context", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "getContext", "()Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "setContext", "(Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;)V", "contextProviderFactory", "Lcom/bytedance/ies/bullet/service/context/IContextProviderFactory;", "getContextProviderFactory", "()Lcom/bytedance/ies/bullet/service/context/IContextProviderFactory;", "setContextProviderFactory", "(Lcom/bytedance/ies/bullet/service/context/IContextProviderFactory;)V", "kitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "getKitType", "()Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "setKitType", "(Lcom/bytedance/ies/bullet/service/base/utils/KitType;)V", "kitViewCallback", "Lcom/bytedance/ies/bullet/service/base/callbacks/KitViewCallback;", "getKitViewCallback", "()Lcom/bytedance/ies/bullet/service/base/callbacks/KitViewCallback;", "setKitViewCallback", "(Lcom/bytedance/ies/bullet/service/base/callbacks/KitViewCallback;)V", WebViewContainer.EVENT_destroy, "", "useDelegate", "", "ensureViewCreated", "schemaUrl", "", "getSccLevel", "Lcom/bytedance/ies/bullet/secure/SccConfig$SccLevel;", "getSdkVersion", "getSessionId", "getViewTag", "load", "url", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bytedance/ies/bullet/service/base/ILoadUriListener;", "onBackPressed", "onHide", "onShow", "realView", "Landroid/view/View;", WebViewContainer.EVENT_reload, "reloadCurrentUrl", "renderSSR", "template", "", "baseUrl", "data", "", "renderSSRHydrate", "templateArray", "sendEvent", SchemaConstants.INNER_PARAM_EVENT_NAME, "params", "triggerBlankDetect", "updateData", "updateGlobalProps", "globalprops", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IKitViewService {
    void destroy(boolean useDelegate);

    boolean ensureViewCreated();

    boolean ensureViewCreated(String schemaUrl);

    IServiceToken getContext();

    IContextProviderFactory getContextProviderFactory();

    KitType getKitType();

    KitViewCallback getKitViewCallback();

    SccConfig.SccLevel getSccLevel();

    String getSdkVersion();

    String getSessionId();

    String getViewTag();

    void load(String url, ILoadUriListener listener);

    boolean onBackPressed();

    void onHide();

    void onShow();

    View realView();

    void reload();

    void reloadCurrentUrl();

    void renderSSR(byte[] template, String baseUrl, Map<String, ? extends Object> data);

    void renderSSRHydrate(byte[] templateArray, String baseUrl, Map<String, ? extends Object> data);

    void sendEvent(String eventName, Object params);

    void sendEvent(String eventName, Object params, boolean useDelegate);

    void setContext(IServiceToken iServiceToken);

    void setContextProviderFactory(IContextProviderFactory iContextProviderFactory);

    void setKitType(KitType kitType);

    void setKitViewCallback(KitViewCallback kitViewCallback);

    void triggerBlankDetect();

    void updateData(Map<String, ? extends Object> data);

    void updateGlobalProps(Map<String, ? extends Object> globalprops);

    /* compiled from: IKitViewService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static boolean ensureViewCreated(IKitViewService iKitViewService, String schemaUrl) {
            Intrinsics.checkNotNullParameter(schemaUrl, "schemaUrl");
            return true;
        }

        public static /* synthetic */ void load$default(IKitViewService iKitViewService, String str, ILoadUriListener iLoadUriListener, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: load");
            }
            if ((i & 2) != 0) {
                iLoadUriListener = null;
            }
            iKitViewService.load(str, iLoadUriListener);
        }

        public static /* synthetic */ void destroy$default(IKitViewService iKitViewService, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: destroy");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            iKitViewService.destroy(z);
        }
    }
}
