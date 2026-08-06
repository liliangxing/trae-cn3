package com.bytedance.kit.nglynx.compatible;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: GroupConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/kit/nglynx/compatible/CardConfig;", "", "version", "", "id", "path", "desc", "fetchRes", "", "resPrefix", "", "extra", "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;Lorg/json/JSONObject;)V", "getDesc", "()Ljava/lang/String;", "getExtra", "()Lorg/json/JSONObject;", "getFetchRes", "()Z", "getId", "getPath", "getResPrefix", "()Ljava/util/List;", "getVersion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class CardConfig {
    private final String desc;
    private final JSONObject extra;
    private final boolean fetchRes;
    private final String id;
    private final String path;
    private final List<String> resPrefix;
    private final String version;

    public CardConfig(String version, String id, String path, String str, boolean z, List<String> list, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(path, "path");
        this.version = version;
        this.id = id;
        this.path = path;
        this.desc = str;
        this.fetchRes = z;
        this.resPrefix = list;
        this.extra = jSONObject;
    }

    public final String getVersion() {
        return this.version;
    }

    public final String getId() {
        return this.id;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final boolean getFetchRes() {
        return this.fetchRes;
    }

    public final List<String> getResPrefix() {
        return this.resPrefix;
    }

    public final JSONObject getExtra() {
        return this.extra;
    }
}
