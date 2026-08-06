package com.bytedance.android.anniex.lite.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.webkit.ProxyConfig;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.service.AnnieXPageLifecycleService;
import com.bytedance.android.anniex.base.service.AnnieXUIService;
import com.bytedance.android.anniex.lite.AnnieXProcessCenter;
import com.bytedance.android.anniex.lite.container.AnnieXLiteContainer;
import com.bytedance.android.anniex.lite.flow.base.FlowDispatchConfig;
import com.bytedance.android.anniex.lite.model.AnnieXContext;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.ies.bullet.container.router.interceptor.AnnieXFlowInterceptor;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.schema.interceptor.WebStandardInterceptor;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.router.interceptor.DisableAutoExposeInterceptor;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.ISchemaInterceptor;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.ies.bullet.service.schema.interceptor.BundleInterceptor;
import com.bytedance.ies.bullet.service.sdk.SchemaConfig;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXLiteUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002\u001a,\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0000\u001a\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0000\u001a\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\f\u001a\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0000\u001a\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0016\u001a\u00020\u0017H\u0000\u001a\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0000\u001a6\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0000¨\u0006#"}, d2 = {"createCustomTitleBar", "Landroid/view/View;", "currentBid", "", "pageContainer", "Lcom/bytedance/android/anniex/base/container/IContainer;", "context", "Landroid/content/Context;", "getAnnieXSchemaModelUnion", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "bid", StrategyConstants.SCHEMA, "Landroid/net/Uri;", "sessionId", "config", "Lcom/bytedance/android/anniex/lite/flow/base/FlowDispatchConfig;", "getEnableThirdPartyWebUi", "", "getKitTypeFromSchema", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "uri", "isAnnieXLite", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "isInitDefaultTitleBar", "isLitePage", "Landroidx/fragment/app/DialogFragment;", "onBackPressed", "annieXContext", "Lcom/bytedance/android/anniex/lite/model/AnnieXContext;", "setTitleBarView", "", "titleBarContainer", "Landroid/widget/FrameLayout;", "defaultTitleBar", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXLiteUtilsKt {
    public static final KitType getKitTypeFromSchema(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        String scheme = uri.getScheme();
        if (scheme != null) {
            int hashCode = scheme.hashCode();
            if (hashCode != -1772600516) {
                if (hashCode != 3213448) {
                    if (hashCode == 99617003 && scheme.equals(ProxyConfig.MATCH_HTTPS)) {
                        return KitType.WEB;
                    }
                } else if (scheme.equals("http")) {
                    return KitType.WEB;
                }
            } else if (scheme.equals("lynxview")) {
                return KitType.LYNX;
            }
        }
        return KitType.UNKNOWN;
    }

    public static final DialogFragment isLitePage(IBDXBridgeContext iBDXBridgeContext) {
        Intrinsics.checkNotNullParameter(iBDXBridgeContext, "bridgeContext");
        ContextProviderFactory contextProviderFactory = (ContextProviderFactory) iBDXBridgeContext.getService(ContextProviderFactory.class);
        if (contextProviderFactory == null || !(contextProviderFactory.provideInstance(IContainer.class) instanceof AnnieXLiteContainer)) {
            return null;
        }
        return (DialogFragment) contextProviderFactory.provideInstance(DialogFragment.class);
    }

    public static final IContainer isAnnieXLite(IBDXBridgeContext iBDXBridgeContext) {
        Intrinsics.checkNotNullParameter(iBDXBridgeContext, "bridgeContext");
        ContextProviderFactory contextProviderFactory = (ContextProviderFactory) iBDXBridgeContext.getService(ContextProviderFactory.class);
        if (contextProviderFactory == null) {
            return null;
        }
        IContainer iContainer = (IContainer) contextProviderFactory.provideInstance(IContainer.class);
        if (iContainer instanceof AnnieXLiteContainer) {
            return iContainer;
        }
        return null;
    }

    public static /* synthetic */ SchemaModelUnion getAnnieXSchemaModelUnion$default(String str, Uri uri, String str2, FlowDispatchConfig flowDispatchConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "default_bid";
        }
        return getAnnieXSchemaModelUnion(str, uri, str2, flowDispatchConfig);
    }

    public static final SchemaModelUnion getAnnieXSchemaModelUnion(String str, Uri uri, String str2, FlowDispatchConfig flowDispatchConfig) {
        Bundle bundle;
        List<ISchemaInterceptor> interceptors;
        Intrinsics.checkNotNullParameter(str, "bid");
        Intrinsics.checkNotNullParameter(uri, StrategyConstants.SCHEMA);
        Intrinsics.checkNotNullParameter(str2, "sessionId");
        SchemaService companion = SchemaService.Companion.getInstance();
        SchemaConfig schemaConfig = new SchemaConfig();
        if (flowDispatchConfig == null || (bundle = flowDispatchConfig.getBundle()) == null) {
            bundle = new Bundle();
        }
        schemaConfig.addInterceptor(new BundleInterceptor(bundle));
        schemaConfig.addInterceptor(new DisableAutoExposeInterceptor());
        schemaConfig.addInterceptor(new WebStandardInterceptor(str));
        schemaConfig.addInterceptor(new AnnieXFlowInterceptor());
        if (flowDispatchConfig != null && (interceptors = flowDispatchConfig.getInterceptors()) != null) {
            schemaConfig.addInterceptors(interceptors);
        }
        Unit unit = Unit.INSTANCE;
        companion.bindConfig(uri, schemaConfig);
        return AnnieXProcessCenter.INSTANCE.getOrCreateSchemaData(str, uri, str2);
    }

    public static final boolean getEnableThirdPartyWebUi(IContainer iContainer) {
        ISchemaData schemaData;
        Boolean bool;
        if (iContainer == null || (schemaData = iContainer.getSchemaData()) == null || (bool = (Boolean) new BooleanParam(schemaData, "enable_third_party_web_ui", false).getValue()) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static final void setTitleBarView(FrameLayout frameLayout, IContainer iContainer, String str, View view, Context context) {
        View createCustomTitleBar;
        Intrinsics.checkNotNullParameter(str, "currentBid");
        Intrinsics.checkNotNullParameter(view, "defaultTitleBar");
        if (frameLayout == null) {
            return;
        }
        if (IConditionCallKt.enableLitePageBidExpand() && getEnableThirdPartyWebUi(iContainer) && (createCustomTitleBar = createCustomTitleBar(str, iContainer, context)) != null) {
            view = createCustomTitleBar;
        }
        ViewParent parent = view.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(view);
        }
        frameLayout.addView(view);
    }

    private static final View createCustomTitleBar(String str, IContainer iContainer, Context context) {
        AnnieXUIService annieXUIService;
        AnnieXUIService.TitleBar createTitleBar;
        if (iContainer == null || context == null || (annieXUIService = ServiceCenter.Companion.instance().get(str, AnnieXUIService.class)) == null || (createTitleBar = annieXUIService.createTitleBar(null, iContainer)) == null) {
            return null;
        }
        return createTitleBar.constructUi(context, iContainer);
    }

    public static final boolean isInitDefaultTitleBar(IContainer iContainer) {
        Intrinsics.checkNotNullParameter(iContainer, "pageContainer");
        return (IConditionCallKt.enableLitePageBidExpand() && getEnableThirdPartyWebUi(iContainer) && ServiceCenter.Companion.instance().get(iContainer.getCurrentBid(), AnnieXUIService.class) != null) ? false : true;
    }

    public static final boolean onBackPressed(IContainer iContainer, AnnieXContext annieXContext) {
        AnnieXPageLifecycleService annieXPageLifecycleService;
        Intrinsics.checkNotNullParameter(iContainer, "pageContainer");
        Intrinsics.checkNotNullParameter(annieXContext, "annieXContext");
        if (!IConditionCallKt.enableLitePageBidExpand() || (annieXPageLifecycleService = ServiceCenter.Companion.instance().get(iContainer.getCurrentBid(), AnnieXPageLifecycleService.class)) == null || !annieXPageLifecycleService.isInterceptor(annieXContext.getContextProviderFactory(), iContainer)) {
            return false;
        }
        annieXPageLifecycleService.onBackPress(annieXContext.getContextProviderFactory(), iContainer);
        return true;
    }
}
