package com.bytedance.ies.argus.api.params;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.applog.server.Api;
import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ContainerCreatedParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ies/argus/api/params/ContainerCreatedParams;", "Lcom/bytedance/ies/argus/api/params/BaseAspectParamsWithoutRewrite;", "schema", "Landroid/net/Uri;", "createType", "Lcom/bytedance/ies/argus/api/params/ArgusContainerCreateType;", "anniexBid", "", "bundle", "Landroid/os/Bundle;", "(Landroid/net/Uri;Lcom/bytedance/ies/argus/api/params/ArgusContainerCreateType;Ljava/lang/String;Landroid/os/Bundle;)V", "getAnniexBid", "()Ljava/lang/String;", "getBundle", "()Landroid/os/Bundle;", "getCreateType", "()Lcom/bytedance/ies/argus/api/params/ArgusContainerCreateType;", "getSchema", "()Landroid/net/Uri;", "getValue", "", Api.KEY_ENCRYPT_RESP_KEY, "toALogObject", "Lorg/json/JSONObject;", "action", "Lcom/bytedance/ies/argus/bean/ArgusVerifyAction;", "toMonitorObject", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ContainerCreatedParams extends BaseAspectParamsWithoutRewrite {
    private final String anniexBid;
    private final Bundle bundle;
    private final ArgusContainerCreateType createType;
    private final Uri schema;

    public /* synthetic */ ContainerCreatedParams(Uri uri, ArgusContainerCreateType argusContainerCreateType, String str, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, argusContainerCreateType, str, (i & 8) != 0 ? null : bundle);
    }

    public final Uri getSchema() {
        return this.schema;
    }

    public final ArgusContainerCreateType getCreateType() {
        return this.createType;
    }

    public final String getAnniexBid() {
        return this.anniexBid;
    }

    public final Bundle getBundle() {
        return this.bundle;
    }

    public ContainerCreatedParams(Uri uri, ArgusContainerCreateType argusContainerCreateType, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(argusContainerCreateType, "createType");
        this.schema = uri;
        this.createType = argusContainerCreateType;
        this.anniexBid = str;
        this.bundle = bundle;
    }

    @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
    public JSONObject toALogObject(ArgusVerifyAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        JSONObject jSONObject = new JSONObject();
        JSONUtilsKt.safelyPut(jSONObject, "schema", String.valueOf(this.schema));
        JSONUtilsKt.safelyPut(jSONObject, "anniex_bid", this.anniexBid);
        return jSONObject;
    }

    @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
    public JSONObject toMonitorObject(ArgusVerifyAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        JSONObject jSONObject = new JSONObject();
        JSONUtilsKt.safelyPut(jSONObject, "schema", String.valueOf(this.schema));
        JSONUtilsKt.safelyPut(jSONObject, "container_create_type", this.createType.getStrValue());
        JSONUtilsKt.safelyPut(jSONObject, "anniex_bid", this.anniexBid);
        return jSONObject;
    }

    @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams, com.bytedance.ies.argus.strategy.ITTMDataHandler
    public Object getValue(String key) {
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        if (Intrinsics.areEqual(key, "container_create_type")) {
            return this.createType.getStrValue();
        }
        if (Intrinsics.areEqual(key, "anniex_bid")) {
            return this.anniexBid;
        }
        return null;
    }
}
