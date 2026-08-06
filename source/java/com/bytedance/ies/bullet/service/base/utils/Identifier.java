package com.bytedance.ies.bullet.service.base.utils;

import android.net.Uri;
import com.bytedance.ies.bullet.service.schema.utils.SchemaUtilsKt;
import java.net.URLDecoder;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: BulletLoadUriIdentifier.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0002J\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\u0006\u0010\u0014\u001a\u00020\u0006R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/utils/Identifier;", "", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "enterFromStr", "", "extraMonitorParamsStr", "hasCache", "", "getUri", "()Landroid/net/Uri;", "getCacheExtraMonitorParams", "Lorg/json/JSONObject;", "getExtraMonitorParams", "getFullUrl", "getIdentifierUrl", "getKitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "getRawUri", "getStatisticPlatform", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public abstract class Identifier {
    private static final String MONITOR_APPEND_PARAMS_KEY = "bdx_monitor_append_params";
    private String enterFromStr;
    private String extraMonitorParamsStr;
    private boolean hasCache;
    private final Uri uri;

    /* compiled from: BulletLoadUriIdentifier.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KitType.values().length];
            try {
                iArr[KitType.LYNX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KitType.WEB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public abstract String getIdentifierUrl();

    public abstract KitType getKitType();

    public Identifier(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.uri = uri;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public String getFullUrl() {
        String uri = this.uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "uri.toString()");
        return uri;
    }

    /* renamed from: getRawUri, reason: from getter */
    public Uri getUri() {
        return this.uri;
    }

    public final String getStatisticPlatform() {
        int i = WhenMappings.$EnumSwitchMapping$0[getKitType().ordinal()];
        return i != 1 ? i != 2 ? "unknown" : "web" : "lynx";
    }

    public final JSONObject getExtraMonitorParams() {
        try {
            Result.Companion companion = Result.INSTANCE;
            if (!this.hasCache) {
                Uri fullUrl = Uri.parse(getFullUrl());
                Intrinsics.checkNotNullExpressionValue(fullUrl, "fullUrl");
                String queryParameterSafely = SchemaUtilsKt.getQueryParameterSafely(fullUrl, MONITOR_APPEND_PARAMS_KEY);
                this.extraMonitorParamsStr = queryParameterSafely != null ? URLDecoder.decode(queryParameterSafely, "UTF-8") : null;
                this.enterFromStr = SchemaUtilsKt.getQueryParameterSafely(fullUrl, "enter_from");
                this.hasCache = true;
            }
            return getCacheExtraMonitorParams();
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10253constructorimpl(ResultKt.createFailure(th));
            return new JSONObject();
        }
    }

    private final JSONObject getCacheExtraMonitorParams() {
        JSONObject jSONObject;
        String str = this.extraMonitorParamsStr;
        if (str != null) {
            JSONObject jSONObject2 = new JSONObject(str);
            String str2 = this.enterFromStr;
            if (str2 == null) {
                return jSONObject2;
            }
            jSONObject2.put("enter_from", str2);
            return jSONObject2;
        }
        String str3 = this.enterFromStr;
        if (str3 != null) {
            jSONObject = new JSONObject();
            jSONObject.put("enter_from", str3);
        } else {
            jSONObject = null;
        }
        return jSONObject == null ? new JSONObject() : jSONObject;
    }
}
