package com.bytedance.ies.bullet.assembler.settings;

import android.net.Uri;
import com.bytedance.ies.bullet.base.settings.MixConfig;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.BulletSettings;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.api.BidConstants;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: BulletMixSwitch.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001(B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020#H\u0007R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR.\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R.\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R.\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R.\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R.\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001a\u0010\u001d\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\u000e\u0010 \u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/ies/bullet/assembler/settings/BulletMixSwitch;", "", "()V", "ANNIEX_ALL_ENABLE", "", "getANNIEX_ALL_ENABLE", "()Z", "setANNIEX_ALL_ENABLE", "(Z)V", "ANNIEX_CARD_ALLOW_LIST", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getANNIEX_CARD_ALLOW_LIST", "()Ljava/util/ArrayList;", "setANNIEX_CARD_ALLOW_LIST", "(Ljava/util/ArrayList;)V", "ANNIEX_CARD_BID_ALLOW_LIST", "getANNIEX_CARD_BID_ALLOW_LIST", "setANNIEX_CARD_BID_ALLOW_LIST", "ANNIEX_CARD_BLOCK_LIST", "getANNIEX_CARD_BLOCK_LIST", "setANNIEX_CARD_BLOCK_LIST", "ANNIEX_PAGE_ALLOW_LIST", "getANNIEX_PAGE_ALLOW_LIST", "setANNIEX_PAGE_ALLOW_LIST", "ANNIEX_PAGE_BLOCK_LIST", "getANNIEX_PAGE_BLOCK_LIST", "setANNIEX_PAGE_BLOCK_LIST", "ENABLE_FORCE_RUN_WEBCAST_WITH_SCHEMA", "getENABLE_FORCE_RUN_WEBCAST_WITH_SCHEMA", "setENABLE_FORCE_RUN_WEBCAST_WITH_SCHEMA", "TAG", "enableMixLogic", "schemaUri", "Landroid/net/Uri;", "type", "Lcom/bytedance/ies/bullet/assembler/settings/BulletMixSwitch$ContainerType;", "getContainerTypeFromWebcastSchema", "schema", "ContainerType", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletMixSwitch {
    private static boolean ANNIEX_ALL_ENABLE = false;
    private static ArrayList<String> ANNIEX_CARD_ALLOW_LIST = null;
    private static ArrayList<String> ANNIEX_CARD_BID_ALLOW_LIST = null;
    private static ArrayList<String> ANNIEX_CARD_BLOCK_LIST = null;
    private static ArrayList<String> ANNIEX_PAGE_ALLOW_LIST = null;
    private static ArrayList<String> ANNIEX_PAGE_BLOCK_LIST = null;
    public static final String TAG = "BulletMixSwitch";
    public static final BulletMixSwitch INSTANCE = new BulletMixSwitch();
    private static boolean ENABLE_FORCE_RUN_WEBCAST_WITH_SCHEMA = true;

    /* compiled from: BulletMixSwitch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/bullet/assembler/settings/BulletMixSwitch$ContainerType;", "", "(Ljava/lang/String;I)V", "CARD", "POPUP", "FULLSCREEN", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public enum ContainerType {
        CARD,
        POPUP,
        FULLSCREEN
    }

    private BulletMixSwitch() {
    }

    public final boolean getANNIEX_ALL_ENABLE() {
        return ANNIEX_ALL_ENABLE;
    }

    public final void setANNIEX_ALL_ENABLE(boolean z) {
        ANNIEX_ALL_ENABLE = z;
    }

    public final boolean getENABLE_FORCE_RUN_WEBCAST_WITH_SCHEMA() {
        return ENABLE_FORCE_RUN_WEBCAST_WITH_SCHEMA;
    }

    public final void setENABLE_FORCE_RUN_WEBCAST_WITH_SCHEMA(boolean z) {
        ENABLE_FORCE_RUN_WEBCAST_WITH_SCHEMA = z;
    }

    public final ArrayList<String> getANNIEX_PAGE_ALLOW_LIST() {
        return ANNIEX_PAGE_ALLOW_LIST;
    }

    public final void setANNIEX_PAGE_ALLOW_LIST(ArrayList<String> arrayList) {
        ANNIEX_PAGE_ALLOW_LIST = arrayList;
    }

    public final ArrayList<String> getANNIEX_PAGE_BLOCK_LIST() {
        return ANNIEX_PAGE_BLOCK_LIST;
    }

    public final void setANNIEX_PAGE_BLOCK_LIST(ArrayList<String> arrayList) {
        ANNIEX_PAGE_BLOCK_LIST = arrayList;
    }

    public final ArrayList<String> getANNIEX_CARD_ALLOW_LIST() {
        return ANNIEX_CARD_ALLOW_LIST;
    }

    public final void setANNIEX_CARD_ALLOW_LIST(ArrayList<String> arrayList) {
        ANNIEX_CARD_ALLOW_LIST = arrayList;
    }

    public final ArrayList<String> getANNIEX_CARD_BLOCK_LIST() {
        return ANNIEX_CARD_BLOCK_LIST;
    }

    public final void setANNIEX_CARD_BLOCK_LIST(ArrayList<String> arrayList) {
        ANNIEX_CARD_BLOCK_LIST = arrayList;
    }

    public final ArrayList<String> getANNIEX_CARD_BID_ALLOW_LIST() {
        return ANNIEX_CARD_BID_ALLOW_LIST;
    }

    public final void setANNIEX_CARD_BID_ALLOW_LIST(ArrayList<String> arrayList) {
        ANNIEX_CARD_BID_ALLOW_LIST = arrayList;
    }

    public final boolean enableMixLogic(Uri schemaUri, ContainerType type) {
        Object obj;
        boolean z;
        Object obj2;
        boolean z2;
        boolean z3;
        boolean z4;
        Intrinsics.checkNotNullParameter(schemaUri, "schemaUri");
        Intrinsics.checkNotNullParameter(type, "type");
        String queryParameter = schemaUri.getQueryParameter("url");
        if (queryParameter == null) {
            return false;
        }
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        BulletSettings provideBulletSettings = iSettingService != null ? iSettingService.provideBulletSettings() : null;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        MixConfig mixConfig = iBulletSettingsService != null ? (MixConfig) iBulletSettingsService.obtainSettings(MixConfig.class) : null;
        if ((provideBulletSettings != null ? provideBulletSettings.getUseNewContainer() : null) != null) {
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "use host libra settings", null, null, 12, null);
            mixConfig = new MixConfig();
            mixConfig.setRouterAllowList(provideBulletSettings.getRouterAllowList());
            mixConfig.setRouterBlockList(provideBulletSettings.getRouterBlockList());
        } else {
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "use bullet sdk settings", null, null, 12, null);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        LinkedHashSet linkedHashSet3 = new LinkedHashSet();
        ArrayList<String> arrayList = ANNIEX_PAGE_ALLOW_LIST;
        if (arrayList != null) {
            linkedHashSet2.addAll(arrayList);
        }
        ArrayList<String> arrayList2 = ANNIEX_CARD_ALLOW_LIST;
        if (arrayList2 != null) {
            linkedHashSet3.addAll(arrayList2);
        }
        if (mixConfig != null) {
            linkedHashSet.addAll(mixConfig.getRouterAllowList());
        }
        LinkedHashSet linkedHashSet4 = new LinkedHashSet();
        ArrayList<String> arrayList3 = ANNIEX_PAGE_BLOCK_LIST;
        if (arrayList3 != null) {
            linkedHashSet4.addAll(arrayList3);
        }
        ArrayList<String> arrayList4 = ANNIEX_CARD_BLOCK_LIST;
        if (arrayList4 != null) {
            linkedHashSet4.addAll(arrayList4);
        }
        if (mixConfig != null) {
            linkedHashSet4.addAll(mixConfig.getRouterBlockList());
        }
        String queryParameter2 = schemaUri.getQueryParameter("mix_container_type");
        String str = queryParameter2;
        if (str == null || StringsKt.isBlank(str)) {
            queryParameter2 = Uri.parse(queryParameter).getQueryParameter("mix_container_type");
        }
        String str2 = queryParameter2;
        LinkedHashSet<String> linkedHashSet5 = linkedHashSet4;
        if (!(linkedHashSet5 instanceof Collection) || !linkedHashSet5.isEmpty()) {
            for (String str3 : linkedHashSet5) {
                try {
                    Result.Companion companion = Result.Companion;
                    obj = Result.constructor-impl(Boolean.valueOf(StringsKt.contains$default(queryParameter, str3, false, 2, (Object) null)));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.isFailure-impl(obj)) {
                    obj = false;
                }
                if (((Boolean) obj).booleanValue()) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        String queryParameter3 = Uri.parse(queryParameter).getQueryParameter("mix_container_bid");
        if (queryParameter3 == null) {
            queryParameter3 = "unknown";
        }
        ArrayList<String> arrayList5 = ANNIEX_CARD_BID_ALLOW_LIST;
        boolean contains = arrayList5 != null ? arrayList5.contains(queryParameter3) : false;
        if (z) {
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "match block list:" + queryParameter, null, null, 12, null);
            return false;
        }
        if (Intrinsics.areEqual(str2, BidConstants.WEBCAST) && ENABLE_FORCE_RUN_WEBCAST_WITH_SCHEMA) {
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "match mixContainerType == webcast :" + queryParameter, null, null, 12, null);
            return false;
        }
        if (Intrinsics.areEqual(str2, "annie")) {
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "match mixContainerType == annie :" + queryParameter, null, null, 12, null);
            return true;
        }
        if (contains) {
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "match containerBid is:" + queryParameter3 + " url is: " + queryParameter, null, null, 12, null);
            return true;
        }
        if (ANNIEX_ALL_ENABLE) {
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "match anniex all enable  url is: " + queryParameter, null, null, 12, null);
            return true;
        }
        try {
            Result.Companion companion3 = Result.Companion;
            BulletMixSwitch bulletMixSwitch = this;
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "====newPageAllowList.size:" + linkedHashSet2.size() + " type: " + type + "  search allow list:" + queryParameter, null, null, 12, null);
            LinkedHashSet linkedHashSet6 = linkedHashSet2;
            if (!(linkedHashSet6 instanceof Collection) || !linkedHashSet6.isEmpty()) {
                Iterator it = linkedHashSet6.iterator();
                while (it.hasNext()) {
                    if (StringsKt.contains$default(queryParameter, (String) it.next(), false, 2, (Object) null)) {
                        z2 = true;
                        break;
                    }
                }
            }
            z2 = false;
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
        }
        if (z2 && (type == ContainerType.FULLSCREEN || type == ContainerType.POPUP)) {
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "match page allow list:" + queryParameter, null, null, 12, null);
            return true;
        }
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "start match card allow list:" + queryParameter, null, null, 12, null);
        LinkedHashSet linkedHashSet7 = linkedHashSet3;
        if (!(linkedHashSet7 instanceof Collection) || !linkedHashSet7.isEmpty()) {
            Iterator it2 = linkedHashSet7.iterator();
            while (it2.hasNext()) {
                if (StringsKt.contains$default(queryParameter, (String) it2.next(), false, 2, (Object) null)) {
                    z3 = true;
                    break;
                }
            }
        }
        z3 = false;
        if (z3 && type == ContainerType.CARD) {
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "match card allow list:" + queryParameter, null, null, 12, null);
            return true;
        }
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "start match router allow list:" + queryParameter, null, null, 12, null);
        LinkedHashSet linkedHashSet8 = linkedHashSet;
        if (!(linkedHashSet8 instanceof Collection) || !linkedHashSet8.isEmpty()) {
            Iterator it3 = linkedHashSet8.iterator();
            while (it3.hasNext()) {
                if (StringsKt.contains$default(queryParameter, (String) it3.next(), false, 2, (Object) null)) {
                    z4 = true;
                    break;
                }
            }
        }
        z4 = false;
        if (!z4) {
            obj2 = Result.constructor-impl(Unit.INSTANCE);
            if (Result.exceptionOrNull-impl(obj2) != null) {
                HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "match failure return default false: " + queryParameter, null, null, 12, null);
                return false;
            }
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "match default false: " + queryParameter, null, null, 12, null);
            return false;
        }
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "match router allow list:" + queryParameter, null, null, 12, null);
        return true;
    }

    @JvmStatic
    public static final ContainerType getContainerTypeFromWebcastSchema(Uri schema) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(schema, "schema");
        try {
            Result.Companion companion = Result.Companion;
            String host = schema.getHost();
            z = false;
            if (host != null) {
                Intrinsics.checkNotNullExpressionValue(host, "host");
                if (StringsKt.startsWith$default(host, "webcast_", false, 2, (Object) null)) {
                    z = true;
                }
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (z) {
            String queryParameter = schema.getQueryParameter("type");
            if (queryParameter == null) {
                obj = Result.constructor-impl((Object) null);
                Throwable th2 = Result.exceptionOrNull-impl(obj);
                if (th2 != null) {
                    HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "schema transfer error:" + th2.getMessage(), null, null, 12, null);
                }
                return ContainerType.FULLSCREEN;
            }
            int hashCode = queryParameter.hashCode();
            if (hashCode != 3046160) {
                if (hashCode != 106852524) {
                    if (hashCode == 110066619 && queryParameter.equals("fullscreen")) {
                        return ContainerType.FULLSCREEN;
                    }
                } else if (queryParameter.equals("popup")) {
                    return ContainerType.POPUP;
                }
            } else if (queryParameter.equals("card")) {
                return ContainerType.CARD;
            }
            return ContainerType.FULLSCREEN;
        }
        throw new RuntimeException("当前传入的schema并非直播容器的schema:" + schema);
    }
}
