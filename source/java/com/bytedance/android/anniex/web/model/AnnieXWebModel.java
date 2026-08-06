package com.bytedance.android.anniex.web.model;

import android.net.Uri;
import com.bytedance.android.anniex.utils.AnnieXConstants;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.service.base.api.BaseServiceContext;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import com.bytedance.ies.bullet.service.base.api.IServiceContext;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXWebModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t¢\u0006\u0002\u0010\u0012J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\tHÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0006HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\tHÆ\u0003J\u0017\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u0017\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\u008b\u0001\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\tHÆ\u0001J\u0013\u0010<\u001a\u00020\t2\b\u0010=\u001a\u0004\u0018\u00010\fHÖ\u0003J\b\u0010>\u001a\u00020\u0003H\u0016J\t\u0010?\u001a\u00020@HÖ\u0001J\t\u0010A\u001a\u00020\u0003HÖ\u0001R'\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u001f\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015R\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015R\u0011\u0010\u0011\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001b\u0010*\u001a\u00020+8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0017\u001a\u0004\b,\u0010-R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001f¨\u0006B"}, d2 = {"Lcom/bytedance/android/anniex/web/model/AnnieXWebModel;", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "businessId", "", StreamTrafficObservable.STREAM_URL, "originalUri", "Landroid/net/Uri;", "sessionId", "enablePIA", "", "injectData", "", "", "globalProps", "schemaModelUnion", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "enterFrom", "needSccDelegate", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;ZLjava/util/Map;Ljava/util/Map;Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;Ljava/lang/String;Z)V", "appendQueryMap", "getAppendQueryMap", "()Ljava/util/Map;", "appendQueryMap$delegate", "Lkotlin/Lazy;", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "getBulletContext", "()Lcom/bytedance/ies/bullet/core/BulletContext;", "setBulletContext", "(Lcom/bytedance/ies/bullet/core/BulletContext;)V", "getBusinessId", "()Ljava/lang/String;", "getEnablePIA", "()Z", "getEnterFrom", "getGlobalProps", "getInjectData", "getNeedSccDelegate", "getOriginalUri", "()Landroid/net/Uri;", "getSchemaModelUnion", "()Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "serviceContext", "Lcom/bytedance/ies/bullet/service/base/api/IServiceContext;", "getServiceContext", "()Lcom/bytedance/ies/bullet/service/base/api/IServiceContext;", "serviceContext$delegate", "getSessionId", "getUrl", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "getBid", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final /* data */ class AnnieXWebModel implements IServiceToken {

    /* renamed from: appendQueryMap$delegate, reason: from kotlin metadata */
    private final Lazy appendQueryMap;
    private BulletContext bulletContext;
    private final String businessId;
    private final boolean enablePIA;
    private final String enterFrom;
    private final Map<String, Object> globalProps;
    private final Map<String, Object> injectData;
    private final boolean needSccDelegate;
    private final Uri originalUri;
    private final SchemaModelUnion schemaModelUnion;

    /* renamed from: serviceContext$delegate, reason: from kotlin metadata */
    private final Lazy serviceContext;
    private final String sessionId;
    private final String url;

    /* renamed from: component1, reason: from getter */
    public final String getBusinessId() {
        return this.businessId;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getNeedSccDelegate() {
        return this.needSccDelegate;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component3, reason: from getter */
    public final Uri getOriginalUri() {
        return this.originalUri;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getEnablePIA() {
        return this.enablePIA;
    }

    public final Map<String, Object> component6() {
        return this.injectData;
    }

    public final Map<String, Object> component7() {
        return this.globalProps;
    }

    /* renamed from: component8, reason: from getter */
    public final SchemaModelUnion getSchemaModelUnion() {
        return this.schemaModelUnion;
    }

    /* renamed from: component9, reason: from getter */
    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final AnnieXWebModel copy(String businessId, String url, Uri originalUri, String sessionId, boolean enablePIA, Map<String, Object> injectData, Map<String, Object> globalProps, SchemaModelUnion schemaModelUnion, String enterFrom, boolean needSccDelegate) {
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        Intrinsics.checkNotNullParameter(url, StreamTrafficObservable.STREAM_URL);
        Intrinsics.checkNotNullParameter(originalUri, "originalUri");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        return new AnnieXWebModel(businessId, url, originalUri, sessionId, enablePIA, injectData, globalProps, schemaModelUnion, enterFrom, needSccDelegate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnnieXWebModel)) {
            return false;
        }
        AnnieXWebModel annieXWebModel = (AnnieXWebModel) other;
        return Intrinsics.areEqual(this.businessId, annieXWebModel.businessId) && Intrinsics.areEqual(this.url, annieXWebModel.url) && Intrinsics.areEqual(this.originalUri, annieXWebModel.originalUri) && Intrinsics.areEqual(this.sessionId, annieXWebModel.sessionId) && this.enablePIA == annieXWebModel.enablePIA && Intrinsics.areEqual(this.injectData, annieXWebModel.injectData) && Intrinsics.areEqual(this.globalProps, annieXWebModel.globalProps) && Intrinsics.areEqual(this.schemaModelUnion, annieXWebModel.schemaModelUnion) && Intrinsics.areEqual(this.enterFrom, annieXWebModel.enterFrom) && this.needSccDelegate == annieXWebModel.needSccDelegate;
    }

    public int hashCode() {
        int hashCode = ((((((((this.businessId.hashCode() * 31) + this.url.hashCode()) * 31) + this.originalUri.hashCode()) * 31) + this.sessionId.hashCode()) * 31) + Boolean.hashCode(this.enablePIA)) * 31;
        Map<String, Object> map = this.injectData;
        int hashCode2 = (hashCode + (map == null ? 0 : map.hashCode())) * 31;
        Map<String, Object> map2 = this.globalProps;
        int hashCode3 = (hashCode2 + (map2 == null ? 0 : map2.hashCode())) * 31;
        SchemaModelUnion schemaModelUnion = this.schemaModelUnion;
        return ((((hashCode3 + (schemaModelUnion != null ? schemaModelUnion.hashCode() : 0)) * 31) + this.enterFrom.hashCode()) * 31) + Boolean.hashCode(this.needSccDelegate);
    }

    public String toString() {
        return "AnnieXWebModel(businessId=" + this.businessId + ", url=" + this.url + ", originalUri=" + this.originalUri + ", sessionId=" + this.sessionId + ", enablePIA=" + this.enablePIA + ", injectData=" + this.injectData + ", globalProps=" + this.globalProps + ", schemaModelUnion=" + this.schemaModelUnion + ", enterFrom=" + this.enterFrom + ", needSccDelegate=" + this.needSccDelegate + ')';
    }

    public AnnieXWebModel(String str, String str2, Uri uri, String str3, boolean z, Map<String, Object> map, Map<String, Object> map2, SchemaModelUnion schemaModelUnion, String str4, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "businessId");
        Intrinsics.checkNotNullParameter(str2, StreamTrafficObservable.STREAM_URL);
        Intrinsics.checkNotNullParameter(uri, "originalUri");
        Intrinsics.checkNotNullParameter(str3, "sessionId");
        Intrinsics.checkNotNullParameter(str4, "enterFrom");
        this.businessId = str;
        this.url = str2;
        this.originalUri = uri;
        this.sessionId = str3;
        this.enablePIA = z;
        this.injectData = map;
        this.globalProps = map2;
        this.schemaModelUnion = schemaModelUnion;
        this.enterFrom = str4;
        this.needSccDelegate = z2;
        this.appendQueryMap = LazyKt.lazy(new Function0<Map<String, String>>() { // from class: com.bytedance.android.anniex.web.model.AnnieXWebModel$appendQueryMap$2
            public final Map<String, String> invoke() {
                return new LinkedHashMap();
            }
        });
        BulletContext bulletContext = new BulletContext(str3);
        bulletContext.setBid(str);
        bulletContext.setSimpleCard(true);
        this.bulletContext = bulletContext;
        this.serviceContext = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<BaseServiceContext>() { // from class: com.bytedance.android.anniex.web.model.AnnieXWebModel$serviceContext$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final BaseServiceContext m3463invoke() {
                return new BaseServiceContext(BulletEnv.Companion.getInstance().getApplication(), BulletEnv.Companion.getInstance().getDebuggable());
            }
        });
    }

    public /* synthetic */ AnnieXWebModel(String str, String str2, Uri uri, String str3, boolean z, Map map, Map map2, SchemaModelUnion schemaModelUnion, String str4, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "default_bid" : str, str2, uri, str3, (i & 16) != 0 ? false : z, (i & 32) != 0 ? null : map, (i & 64) != 0 ? null : map2, (i & 128) != 0 ? null : schemaModelUnion, (i & 256) != 0 ? AnnieXConstants.ANNIEX_CARD : str4, (i & 512) != 0 ? true : z2);
    }

    public Map<Class<?>, Object> getAllDependency() {
        return IServiceToken.DefaultImpls.getAllDependency(this);
    }

    public <T> T getDependency(Class<T> cls) {
        return (T) IServiceToken.DefaultImpls.getDependency(this, cls);
    }

    public <T extends IBulletService> T getService(Class<T> cls) {
        return (T) IServiceToken.DefaultImpls.getService(this, cls);
    }

    public final String getBusinessId() {
        return this.businessId;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Uri getOriginalUri() {
        return this.originalUri;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final boolean getEnablePIA() {
        return this.enablePIA;
    }

    public final Map<String, Object> getInjectData() {
        return this.injectData;
    }

    public final Map<String, Object> getGlobalProps() {
        return this.globalProps;
    }

    public final SchemaModelUnion getSchemaModelUnion() {
        return this.schemaModelUnion;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final boolean getNeedSccDelegate() {
        return this.needSccDelegate;
    }

    public final Map<String, String> getAppendQueryMap() {
        return (Map) this.appendQueryMap.getValue();
    }

    public final BulletContext getBulletContext() {
        return this.bulletContext;
    }

    public final void setBulletContext(BulletContext bulletContext) {
        Intrinsics.checkNotNullParameter(bulletContext, "<set-?>");
        this.bulletContext = bulletContext;
    }

    public IServiceContext getServiceContext() {
        return (IServiceContext) this.serviceContext.getValue();
    }

    public String getBid() {
        return this.businessId;
    }
}
