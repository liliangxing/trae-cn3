package com.bytedance.ies.bullet.forest;

import com.bytedance.env.api.AccessKeyType;
import com.bytedance.env.api.EnvManager;
import com.bytedance.env.api.GeckoConfig;
import com.bytedance.forest.Forest;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.model.ForestEnvData;
import com.bytedance.forest.model.ForestEnvType;
import com.bytedance.ies.bullet.base.utils.EnvToolsHelper;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.kit.resourceloader.model.ResourceLoaderEnvData;
import com.bytedance.ies.bullet.kit.resourceloader.model.ResourceLoaderType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ForestRequestInfoBuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0007\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0002¨\u0006\u0005"}, d2 = {"addEnvParamsForCDNMultiVersion", "", "toForestEnv", "Lcom/bytedance/forest/model/ForestEnvData;", "Lcom/bytedance/ies/bullet/kit/resourceloader/model/ResourceLoaderEnvData;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ForestRequestInfoBuilderKt {

    /* compiled from: ForestRequestInfoBuilder.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[AccessKeyType.values().length];
            try {
                iArr[AccessKeyType.INHOUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AccessKeyType.BOE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ResourceLoaderType.values().length];
            try {
                iArr2[ResourceLoaderType.BOE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ResourceLoaderType.PPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final String addEnvParamsForCDNMultiVersion(String str) {
        ForestEnvData forestEnvData;
        Intrinsics.checkNotNullParameter(str, "<this>");
        ForestEnvData forestEnvData2 = null;
        if ((!StringsKt.startsWith$default(str, "http://", false, 2, (Object) null) && !StringsKt.startsWith$default(str, "https://", false, 2, (Object) null)) || !ResourceLoader.INSTANCE.isDebug()) {
            return str;
        }
        try {
            GeckoConfig geckoEnv = EnvToolsHelper.INSTANCE.getGeckoEnv();
            AccessKeyType accessKeyType = geckoEnv != null ? geckoEnv.getAccessKeyType() : null;
            int i = accessKeyType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[accessKeyType.ordinal()];
            if (i != -1) {
                if (i == 1) {
                    forestEnvData = new ForestEnvData(ForestEnvType.PPE, EnvManager.Companion.getService().getGeckoConfig().getEnvLane());
                } else if (i == 2) {
                    forestEnvData = new ForestEnvData(ForestEnvType.BOE, EnvManager.Companion.getService().getGeckoConfig().getEnvLane());
                }
                forestEnvData2 = forestEnvData;
            } else {
                ResourceLoaderEnvData resourceLoaderEnvData = ResourceLoader.INSTANCE.getResourceLoaderEnvData();
                if (resourceLoaderEnvData != null) {
                    forestEnvData2 = toForestEnv(resourceLoaderEnvData);
                }
            }
        } catch (Throwable unused) {
            ResourceLoaderEnvData resourceLoaderEnvData2 = ResourceLoader.INSTANCE.getResourceLoaderEnvData();
            if (resourceLoaderEnvData2 != null) {
                forestEnvData2 = toForestEnv(resourceLoaderEnvData2);
            }
        }
        Forest.Companion.injectEnv(forestEnvData2);
        return GeckoXAdapter.Companion.addCommonParamsForCDNMultiVersionURL(str);
    }

    private static final ForestEnvData toForestEnv(ResourceLoaderEnvData resourceLoaderEnvData) {
        ForestEnvType forestEnvType;
        int i = WhenMappings.$EnumSwitchMapping$1[resourceLoaderEnvData.getType().ordinal()];
        if (i == 1) {
            forestEnvType = ForestEnvType.BOE;
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            forestEnvType = ForestEnvType.PPE;
        }
        return new ForestEnvData(forestEnvType, resourceLoaderEnvData.getName());
    }
}
