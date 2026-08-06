package com.bytedance.ies.bullet.service.schema.interceptor;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.ies.bullet.forest.ForestSchemaConverter;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.kit.resourceloader.model.RLChannelBundleModel;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.api.BidConstants;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.base.utils.XConstant;
import com.bytedance.ies.bullet.service.schema.ISchemaMutableData;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.sdk.SchemaInterceptor;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import com.bytedance.ies.bullet.service.sdk.param.UrlParam;
import com.bytedance.ies.bullet.web.pia.PiaHelper;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: BulletInterceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000fH\u0002J&\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000fH\u0002J&\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/bullet/service/schema/interceptor/BulletInterceptor;", "Lcom/bytedance/ies/bullet/service/sdk/SchemaInterceptor;", "bid", "", "(Ljava/lang/String;)V", "forestInterceptor", "Lcom/bytedance/ies/bullet/forest/ForestSchemaConverter;", "name", "getName", "()Ljava/lang/String;", "appendLynxParameter", "", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaMutableData;", "queryItems", "", "appendPiaParameter", "appendWebParameter", "convert", "", "getKitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "host", "transformDeprecatedParam", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletInterceptor extends SchemaInterceptor {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> NON_INHERIT_KEY_SET = SetsKt.setOf(new String[]{SchemaConstants.QUERY_KEY_PACKAGES, "__x_session_id", SchemaConstants.QUERY_KEY_WEB_DOMAIN_PARTY, SchemaConstants.QUERY_KEY_ENABLE_THIRD_PARTY_WEB_UI});
    private final String bid;
    private final ForestSchemaConverter forestInterceptor;
    private final String name;

    /* compiled from: BulletInterceptor.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KitType.values().length];
            try {
                iArr[KitType.WEB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KitType.LYNX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public BulletInterceptor(String str) {
        Intrinsics.checkNotNullParameter(str, "bid");
        this.bid = str;
        this.forestInterceptor = new ForestSchemaConverter();
        this.name = "Bullet";
    }

    /* compiled from: BulletInterceptor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/bullet/service/schema/interceptor/BulletInterceptor$Companion;", "", "()V", "NON_INHERIT_KEY_SET", "", "", "getNON_INHERIT_KEY_SET", "()Ljava/util/Set;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<String> getNON_INHERIT_KEY_SET() {
            return BulletInterceptor.NON_INHERIT_KEY_SET;
        }
    }

    @Override // com.bytedance.ies.bullet.service.sdk.SchemaInterceptor, com.bytedance.ies.bullet.service.schema.ISchemaInterceptor
    public String getName() {
        return this.name;
    }

    @Override // com.bytedance.ies.bullet.service.sdk.SchemaInterceptor, com.bytedance.ies.bullet.service.schema.ISchemaInterceptor
    public boolean convert(ISchemaMutableData schemaData) {
        KitType kitType;
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        transformDeprecatedParam(schemaData);
        if (Intrinsics.areEqual(schemaData.getScheme(), "bullet") && Intrinsics.areEqual(schemaData.getHost(), "bullet")) {
            return true;
        }
        if (Intrinsics.areEqual(schemaData.getScheme(), "http") || Intrinsics.areEqual(schemaData.getScheme(), "https")) {
            schemaData.setPath("webview");
            schemaData.addParam("url", new UrlParam(schemaData.getInnerOriginUrl()), true);
        }
        this.forestInterceptor.convert(schemaData);
        Map<String, String> queryItems = schemaData.getQueryItems();
        if (queryItems.containsKey(SchemaConstants.QUERY_KEY_LYNX_SCHEMA)) {
            kitType = KitType.LYNX;
        } else {
            String host = schemaData.getHost();
            if (host == null) {
                host = "";
            }
            kitType = getKitType(host);
        }
        boolean enableAnnieXUrlParamFix = IConditionCallKt.getEnableAnnieXUrlParamFix();
        Boolean value = new BooleanParam(schemaData, "clear_url_params", false).getValue();
        int i = WhenMappings.$EnumSwitchMapping$0[kitType.ordinal()];
        if (i == 1) {
            schemaData.setScheme("bullet");
            schemaData.setPath("bullet");
            appendPiaParameter(schemaData, queryItems);
            if (!Intrinsics.areEqual(value, false) && enableAnnieXUrlParamFix) {
                return true;
            }
            appendWebParameter(schemaData, queryItems);
            return true;
        }
        if (i != 2) {
            return false;
        }
        schemaData.setScheme("bullet");
        schemaData.setPath("bullet");
        if (!Intrinsics.areEqual(value, false) && enableAnnieXUrlParamFix) {
            return true;
        }
        appendLynxParameter(schemaData, queryItems);
        return true;
    }

    private final void appendPiaParameter(ISchemaMutableData schemaData, Map<String, String> queryItems) {
        String str = queryItems.get("url");
        if (str == null || !PiaHelper.INSTANCE.support(str, this.bid) || Intrinsics.areEqual(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_DISABLE_PIA, null).getValue(), true)) {
            return;
        }
        schemaData.addParam(XConstant.PARAM_KEY_PIA, new BooleanParam(true), false);
    }

    private final void appendWebParameter(ISchemaMutableData schemaData, Map<String, String> queryItems) {
        String str;
        String substring;
        BulletInterceptor bulletInterceptor;
        boolean z;
        String str2 = queryItems.get("url");
        if (str2 != null) {
            String str3 = str2;
            int indexOf$default = StringsKt.indexOf$default(str3, '?', 0, false, 6, (Object) null);
            if (indexOf$default == -1) {
                str = str2;
            } else {
                String substring2 = str2.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                str = substring2;
            }
            int indexOf$default2 = indexOf$default == -1 ? -1 : StringsKt.indexOf$default(str3, '#', indexOf$default + 1, false, 4, (Object) null);
            if (indexOf$default2 == -1) {
                substring = "";
            } else {
                substring = str2.substring(indexOf$default2, str2.length());
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            StringBuilder sb = new StringBuilder(str);
            boolean z2 = true;
            for (Map.Entry<String, String> entry : queryItems.entrySet()) {
                if (!Intrinsics.areEqual(entry.getKey(), "url") && !NON_INHERIT_KEY_SET.contains(entry.getKey())) {
                    if (z2) {
                        sb.append('?');
                        bulletInterceptor = this;
                        z2 = false;
                    } else {
                        sb.append('&');
                        bulletInterceptor = this;
                    }
                    if (Intrinsics.areEqual(bulletInterceptor.bid, BidConstants.WEBCAST) && Intrinsics.areEqual(entry.getKey(), "token")) {
                        List<String> annieXLiveTokenParamAdaptionList = IConditionCallKt.getAnnieXLiveTokenParamAdaptionList();
                        if (!(annieXLiveTokenParamAdaptionList instanceof Collection) || !annieXLiveTokenParamAdaptionList.isEmpty()) {
                            Iterator<T> it = annieXLiveTokenParamAdaptionList.iterator();
                            while (it.hasNext()) {
                                if (StringsKt.contains$default(str, (String) it.next(), false, 2, (Object) null)) {
                                    z = true;
                                    break;
                                }
                            }
                        }
                        z = false;
                        if (z) {
                            sb.append(Uri.encode(entry.getKey())).append('=').append(entry.getValue());
                        }
                    }
                    sb.append(Uri.encode(entry.getKey())).append('=').append(Uri.encode(entry.getValue()));
                }
            }
            sb.append(substring);
            schemaData.addParam("url", new StringParam(sb.toString()), true);
        }
    }

    private final void appendLynxParameter(ISchemaMutableData schemaData, Map<String, String> queryItems) {
        String str;
        String str2;
        String str3 = queryItems.get("url");
        String str4 = queryItems.get(SchemaConstants.QUERY_KEY_RES_URL);
        if (str4 == null) {
            str4 = queryItems.get(SchemaConstants.QUERY_KEY_SURL);
        }
        if (str4 != null) {
            str3 = str4;
        } else if (str3 == null) {
            str3 = null;
        }
        RLChannelBundleModel parseChannelBundle = ResourceLoader.with$default(ResourceLoader.INSTANCE, this.bid, null, 2, null).parseChannelBundle(str3);
        if (parseChannelBundle == null || (str = parseChannelBundle.provideChannel()) == null) {
            str = queryItems.get("channel");
        }
        String str5 = SchemaConstants.QUERY_KEY_BUNDLE;
        if (parseChannelBundle == null || (str2 = parseChannelBundle.providerBundlePath()) == null) {
            str2 = queryItems.get(SchemaConstants.QUERY_KEY_BUNDLE);
        }
        Bundle bundle = schemaData.get_innerBundle();
        if (bundle != null) {
            if (str != null) {
                bundle.putString(XConstant.PARAM_KEY_CHANNEL, str);
            }
            if (str2 != null) {
                bundle.putString(XConstant.PARAM_KEY_BUNDLE, str2);
            }
        }
        StringBuilder sb = new StringBuilder("lynxview://");
        StringBuilder append = sb.append(str != null ? str : "channel").append('/');
        if (str2 != null) {
            str5 = str2;
        }
        append.append(str5).append('?');
        boolean z = true;
        for (Map.Entry<String, String> entry : queryItems.entrySet()) {
            if (!NON_INHERIT_KEY_SET.contains(entry.getKey())) {
                if (z) {
                    z = false;
                } else {
                    sb.append('&');
                }
                sb.append(Uri.encode(entry.getKey())).append('=').append(Uri.encode(entry.getValue()));
            }
        }
        schemaData.addParam("url", new StringParam(sb.toString()), true);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
    
        return com.bytedance.ies.bullet.service.base.utils.KitType.LYNX;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
    
        if (r2.equals("webview") == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
    
        if (r2.equals(com.bytedance.ies.bullet.service.schema.SchemaConstants.AUTHORITY_LYNX_POPUP) == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
    
        if (r2.equals(com.bytedance.ies.bullet.service.schema.SchemaConstants.AUTHORITY_LYNX_PAGE) == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003d, code lost:
    
        if (r2.equals(com.bytedance.ies.bullet.service.schema.SchemaConstants.AUTHORITY_LYNX_POPUP2) == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0046, code lost:
    
        if (r2.equals("lynxview") == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
    
        if (r2.equals(com.bytedance.ies.bullet.service.schema.SchemaConstants.AUTHORITY_WEB_POPUP) != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000f, code lost:
    
        if (r2.equals(com.bytedance.ies.bullet.service.schema.SchemaConstants.AUTHORITY_WEB_PAGE) == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:?, code lost:
    
        return com.bytedance.ies.bullet.service.base.utils.KitType.WEB;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0018, code lost:
    
        if (r2.equals(com.bytedance.ies.bullet.service.schema.SchemaConstants.AUTHORITY_LYNX_PAGE2) == false) goto L30;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0004. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final KitType getKitType(String host) {
        switch (host.hashCode()) {
            case -1932693274:
                break;
            case -1772600516:
                break;
            case -1001735703:
                break;
            case 862922167:
                break;
            case 981209732:
                break;
            case 1224424441:
                break;
            case 1630240178:
                break;
            case 2015851285:
                break;
            default:
                return KitType.UNKNOWN;
        }
    }

    private final void transformDeprecatedParam(ISchemaMutableData schemaData) {
        ISchemaMutableData iSchemaMutableData = schemaData;
        String value = new StringParam(iSchemaMutableData, "container_bgcolor", null).getValue();
        if (value != null) {
            schemaData.addParam(SchemaConstants.QUERY_KEY_CONTAINER_BG_COLOR, new StringParam(value), false);
        }
        String value2 = new StringParam(iSchemaMutableData, "bg_color", null).getValue();
        if (value2 != null) {
            schemaData.addParam(SchemaConstants.QUERY_KEY_CONTAINER_BG_COLOR, new StringParam(value2), false);
        }
        if (new BooleanParam(iSchemaMutableData, "hide_loading", null).getValue() != null) {
            schemaData.addParam(SchemaConstants.QUERY_KEY_SHOW_LOADING, new BooleanParam(Boolean.valueOf(!r0.booleanValue())), false);
        }
        String value3 = new StringParam(iSchemaMutableData, "secLinkScene", null).getValue();
        if (value3 != null) {
            schemaData.addParam(SchemaConstants.QUERY_KEY_SEC_LINK_SCENE, new StringParam(value3), false);
        }
    }
}
