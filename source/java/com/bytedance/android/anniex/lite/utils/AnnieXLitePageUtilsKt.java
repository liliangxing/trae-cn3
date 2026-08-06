package com.bytedance.android.anniex.lite.utils;

import android.net.Uri;
import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.android.anniex.lite.base.IAnnieXLitePageDelegate;
import com.bytedance.android.anniex.lite.base.IAnnieXLitePageDelegateProvider;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.kit.lynx.service.ILynxGlobalConfigService;
import com.bytedance.ies.bullet.lynx_adapter_impl.LynxBehaviorFactory;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxBehaviorWrapper;
import com.lynx.tasm.behavior.Behavior;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXLitePageUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\u0007"}, d2 = {"getBehaviorList", "", "Lcom/lynx/tasm/behavior/Behavior;", "bid", "", StrategyConstants.SCHEMA, "Landroid/net/Uri;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXLitePageUtilsKt {
    public static final List<Behavior> getBehaviorList(String str, Uri uri) {
        List emptyList;
        Behavior createLynxBehavior;
        IAnnieXLitePageDelegate provideDelegate;
        Intrinsics.checkNotNullParameter(str, "bid");
        Intrinsics.checkNotNullParameter(uri, StrategyConstants.SCHEMA);
        if (!IConditionCallKt.getEnableLitePageBidOpt() || !IConditionCallKt.getEnableLitePageBidBehaviorOpt()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ILynxGlobalConfigService iLynxGlobalConfigService = ServiceCenter.Companion.instance().get(str, ILynxGlobalConfigService.class);
        if (iLynxGlobalConfigService == null || (emptyList = iLynxGlobalConfigService.createBehaviors(new ContextProviderFactory())) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        arrayList.addAll(CollectionsKt.filterNotNull(emptyList));
        if (IConditionCallKt.enableLitePageBusinessBehavior()) {
            IAnnieXLitePageDelegateProvider iAnnieXLitePageDelegateProvider = (IAnnieXLitePageDelegateProvider) AnnieXServiceCenter.INSTANCE.getService(str, IAnnieXLitePageDelegateProvider.class);
            List<Object> businessBehavior = (iAnnieXLitePageDelegateProvider == null || (provideDelegate = iAnnieXLitePageDelegateProvider.provideDelegate()) == null) ? null : provideDelegate.getBusinessBehavior(uri);
            if (businessBehavior != null) {
                arrayList.addAll(businessBehavior);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (obj instanceof Behavior) {
                createLynxBehavior = (Behavior) obj;
            } else {
                createLynxBehavior = obj instanceof LynxBehaviorWrapper ? LynxBehaviorFactory.INSTANCE.createLynxBehavior((LynxBehaviorWrapper) obj) : null;
            }
            if (createLynxBehavior != null) {
                arrayList2.add(createLynxBehavior);
            }
        }
        ArrayList arrayList3 = arrayList2;
        if (!arrayList3.isEmpty()) {
            return arrayList3;
        }
        return null;
    }
}
