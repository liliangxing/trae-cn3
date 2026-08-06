package com.bytedance.ruler.base.models;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: RuleModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ruler/base/models/RuleModel;", "", "title", "", "conf", "Lcom/google/gson/JsonElement;", "cel", "key", "(Ljava/lang/String;Lcom/google/gson/JsonElement;Ljava/lang/String;Ljava/lang/String;)V", "getCel", "()Ljava/lang/String;", "setCel", "(Ljava/lang/String;)V", "getConf", "()Lcom/google/gson/JsonElement;", "setConf", "(Lcom/google/gson/JsonElement;)V", "getKey", "setKey", "getTitle", "setTitle", "ruler-base_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public class RuleModel {

    @SerializedName("cel")
    private String cel;

    @SerializedName("conf")
    private JsonElement conf;

    @SerializedName("key")
    private String key;

    @SerializedName("title")
    private String title;

    public RuleModel() {
        this(null, null, null, null, 15, null);
    }

    public RuleModel(String str, JsonElement jsonElement, String str2, String str3) {
        this.title = str;
        this.conf = jsonElement;
        this.cel = str2;
        this.key = str3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ RuleModel(String str, JsonElement jsonElement, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, jsonElement, str2, str3);
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            jsonElement = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final JsonElement getConf() {
        return this.conf;
    }

    public final void setConf(JsonElement jsonElement) {
        this.conf = jsonElement;
    }

    public final String getCel() {
        return this.cel;
    }

    public final void setCel(String str) {
        this.cel = str;
    }

    public final String getKey() {
        return this.key;
    }

    public final void setKey(String str) {
        this.key = str;
    }
}
