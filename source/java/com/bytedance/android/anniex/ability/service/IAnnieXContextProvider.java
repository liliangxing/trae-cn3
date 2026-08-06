package com.bytedance.android.anniex.ability.service;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.anniex.base.service.IAnnieXService;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import com.bytedance.sdk.xbridge.cn.service.IContainerInstance;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: IAnnieXContextProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u00060\bj\u0002`\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J$\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010 j\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`!2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006#"}, d2 = {"Lcom/bytedance/android/anniex/ability/service/IAnnieXContextProvider;", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "Lcom/bytedance/android/anniex/base/service/IAnnieXService;", "appendCommonParams", "", "uri", "Landroid/net/Uri;", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "isApi", "", "clearContextProvider", "bid", "", "contextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "completeContextProvider", "containerInstance", "Lcom/bytedance/sdk/xbridge/cn/service/IContainerInstance;", "context", "Landroid/content/Context;", "getAttachScene", "Lcom/bytedance/android/anniex/ability/service/AttachScene;", "getBcmChainByFinder", "Lorg/json/JSONObject;", "any", "", "length", "", "isDomainStandard", "getUnSupportMethod", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "initAnnieXCardBizEnv", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public interface IAnnieXContextProvider extends IBulletService, IAnnieXService {

    /* compiled from: IAnnieXContextProvider.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class DefaultImpls {
        public static void appendCommonParams(IAnnieXContextProvider iAnnieXContextProvider, Uri uri, StringBuilder sb, boolean z) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(sb, "sb");
        }

        public static void clearContextProvider(IAnnieXContextProvider iAnnieXContextProvider, String str, ContextProviderFactory contextProviderFactory) {
            Intrinsics.checkNotNullParameter(str, "bid");
        }

        public static void completeContextProvider(IAnnieXContextProvider iAnnieXContextProvider, IContainerInstance iContainerInstance, Context context, ContextProviderFactory contextProviderFactory) {
            Intrinsics.checkNotNullParameter(iContainerInstance, "containerInstance");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(contextProviderFactory, "contextProviderFactory");
        }

        public static AttachScene getAttachScene(IAnnieXContextProvider iAnnieXContextProvider) {
            return null;
        }

        public static JSONObject getBcmChainByFinder(IAnnieXContextProvider iAnnieXContextProvider, Object obj, int i, boolean z) {
            return null;
        }

        public static HashSet<String> getUnSupportMethod(IAnnieXContextProvider iAnnieXContextProvider, String str) {
            Intrinsics.checkNotNullParameter(str, "bid");
            return null;
        }

        public static boolean initAnnieXCardBizEnv(IAnnieXContextProvider iAnnieXContextProvider, String str) {
            Intrinsics.checkNotNullParameter(str, "bid");
            return true;
        }
    }

    void appendCommonParams(Uri uri, StringBuilder sb, boolean isApi);

    void clearContextProvider(String bid, ContextProviderFactory contextProviderFactory);

    void completeContextProvider(IContainerInstance containerInstance, Context context, ContextProviderFactory contextProviderFactory);

    AttachScene getAttachScene();

    JSONObject getBcmChainByFinder(Object any, int length, boolean isDomainStandard);

    HashSet<String> getUnSupportMethod(String bid);

    boolean initAnnieXCardBizEnv(String bid);
}
