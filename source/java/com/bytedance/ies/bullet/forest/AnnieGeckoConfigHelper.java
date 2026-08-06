package com.bytedance.ies.bullet.forest;

import com.bytedance.env.api.AccessKeyType;
import com.bytedance.env.api.GeckoConfig;
import com.bytedance.ies.bullet.base.utils.EnvToolsHelper;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.kit.resourceloader.model.ResourceLoaderEnvData;
import com.bytedance.ies.bullet.kit.resourceloader.model.ResourceLoaderType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ForestConfigCenter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/bullet/forest/AnnieGeckoConfigHelper;", "", "()V", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AnnieGeckoConfigHelper {
    private static final String ANNIE_BOE_AK = "92549089bbfda222da88c565422ff344";
    private static final String ANNIE_ONLINE_AK = "6e5ea4687a1ae236f7677bed242a0bdd";
    private static final String ANNIE_TEST_AK = "5436709938b15832912cf5322009c03d";
    private static final String ARGUS_BOE_AK = "afe58e0f6709cd80a6524f309678f67d";
    private static final String ARGUS_ONLINE_AK = "d8feacce0eae150c8140e5c435ccbbda";
    private static final String ARGUS_TEST_AK = "e1927d8fdbbf6786914e8ca27307104b";
    private static final String BP_BOE_AK = "07467e91f0656ae9451e9beef41d1d87";
    private static final String BP_ONLINE_AK = "c03e7f8feccb52c8e0f55f63b8025d0f";
    private static final String BP_TEST_AK = "0e99390a97a5105f755f73fe564a63ad";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String VE_BOE_AK = "feb359d0564d243c06dbcf0c0446d372";
    private static final String VE_ONLINE_AK = "c772b372d999d01c25c1255e4d92ccad";
    private static final String VE_TEST_AK = "46c563b112f40133a95aa5596d83790b";
    private static final String WEBCAST_BOE_AK = "68f927652a5370ec9f4ae1dbaf56fd85";
    private static final String WEBCAST_ONLINE_AK = "5fb33cde3ebff01c8433ddc22aac0816";
    private static final String WEBCAST_TEST_AK = "36723dc3e85a23e701d1697d57de07ed";

    /* compiled from: ForestConfigCenter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/bullet/forest/AnnieGeckoConfigHelper$Companion;", "", "()V", "ANNIE_BOE_AK", "", "ANNIE_ONLINE_AK", "ANNIE_TEST_AK", "ARGUS_BOE_AK", "ARGUS_ONLINE_AK", "ARGUS_TEST_AK", "BP_BOE_AK", "BP_ONLINE_AK", "BP_TEST_AK", "VE_BOE_AK", "VE_ONLINE_AK", "VE_TEST_AK", "WEBCAST_BOE_AK", "WEBCAST_ONLINE_AK", "WEBCAST_TEST_AK", "getAks", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {

        /* compiled from: ForestConfigCenter.kt */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                int[] iArr = new int[ResourceLoaderType.values().length];
                try {
                    iArr[ResourceLoaderType.PPE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ResourceLoaderType.BOE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[AccessKeyType.values().length];
                try {
                    iArr2[AccessKeyType.INHOUSE.ordinal()] = 1;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr2[AccessKeyType.BOE.ordinal()] = 2;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$1 = iArr2;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<String> getAks() {
            String str;
            int i;
            GeckoConfig geckoEnv = EnvToolsHelper.INSTANCE.getGeckoEnv();
            AccessKeyType accessKeyType = geckoEnv != null ? geckoEnv.getAccessKeyType() : null;
            int i2 = accessKeyType == null ? -1 : WhenMappings.$EnumSwitchMapping$1[accessKeyType.ordinal()];
            if (i2 != -1) {
                if (i2 == 1) {
                    return CollectionsKt.listOf(new String[]{AnnieGeckoConfigHelper.WEBCAST_TEST_AK, AnnieGeckoConfigHelper.BP_TEST_AK, AnnieGeckoConfigHelper.ANNIE_TEST_AK, AnnieGeckoConfigHelper.VE_TEST_AK, "e1927d8fdbbf6786914e8ca27307104b"});
                }
                if (i2 == 2) {
                    return CollectionsKt.listOf(new String[]{AnnieGeckoConfigHelper.WEBCAST_BOE_AK, AnnieGeckoConfigHelper.BP_BOE_AK, AnnieGeckoConfigHelper.ANNIE_BOE_AK, AnnieGeckoConfigHelper.VE_BOE_AK, "afe58e0f6709cd80a6524f309678f67d"});
                }
                return CollectionsKt.listOf(new String[]{AnnieGeckoConfigHelper.WEBCAST_ONLINE_AK, AnnieGeckoConfigHelper.BP_ONLINE_AK, AnnieGeckoConfigHelper.ANNIE_ONLINE_AK, AnnieGeckoConfigHelper.VE_ONLINE_AK, "d8feacce0eae150c8140e5c435ccbbda"});
            }
            ResourceLoaderEnvData resourceLoaderEnvData = ResourceLoader.INSTANCE.getResourceLoaderEnvData();
            ResourceLoaderType type = resourceLoaderEnvData != null ? resourceLoaderEnvData.getType() : null;
            if (type == null) {
                str = "e1927d8fdbbf6786914e8ca27307104b";
                i = -1;
            } else {
                str = "e1927d8fdbbf6786914e8ca27307104b";
                i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            }
            if (i == 1) {
                return CollectionsKt.listOf(new String[]{AnnieGeckoConfigHelper.WEBCAST_TEST_AK, AnnieGeckoConfigHelper.BP_TEST_AK, AnnieGeckoConfigHelper.ANNIE_TEST_AK, AnnieGeckoConfigHelper.VE_TEST_AK, str});
            }
            if (i == 2) {
                return CollectionsKt.listOf(new String[]{AnnieGeckoConfigHelper.WEBCAST_BOE_AK, AnnieGeckoConfigHelper.BP_BOE_AK, AnnieGeckoConfigHelper.ANNIE_BOE_AK, AnnieGeckoConfigHelper.VE_BOE_AK, "afe58e0f6709cd80a6524f309678f67d"});
            }
            return CollectionsKt.listOf(new String[]{AnnieGeckoConfigHelper.WEBCAST_ONLINE_AK, AnnieGeckoConfigHelper.BP_ONLINE_AK, AnnieGeckoConfigHelper.ANNIE_ONLINE_AK, AnnieGeckoConfigHelper.VE_ONLINE_AK, "d8feacce0eae150c8140e5c435ccbbda"});
        }
    }
}
