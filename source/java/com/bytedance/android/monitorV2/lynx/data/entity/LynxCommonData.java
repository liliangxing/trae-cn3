package com.bytedance.android.monitorV2.lynx.data.entity;

import com.bytedance.android.monitorV2.entity.NativeCommon;
import com.bytedance.android.monitorV2.util.JsonUtils;
import com.lynx.tasm.LynxEnv;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: LynxCommonData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxCommonData;", "Lcom/bytedance/android/monitorV2/entity/NativeCommon;", "()V", "annieXContainerReuse", "", "getAnnieXContainerReuse", "()Z", "setAnnieXContainerReuse", "(Z)V", "lynxVersion", "", "kotlin.jvm.PlatformType", "getLynxVersion", "()Ljava/lang/String;", "setLynxVersion", "(Ljava/lang/String;)V", "pageVersion", "getPageVersion", "setPageVersion", "templateState", "", "getTemplateState", "()I", "setTemplateState", "(I)V", "fillInJsonObject", "", "jsonObject", "Lorg/json/JSONObject;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LynxCommonData extends NativeCommon {
    private volatile boolean annieXContainerReuse;
    private int templateState;
    private String pageVersion = "";
    private String lynxVersion = LynxEnv.inst().getLynxVersion();

    public LynxCommonData() {
        this.containerType = "lynx";
    }

    public final int getTemplateState() {
        return this.templateState;
    }

    public final void setTemplateState(int i) {
        this.templateState = i;
    }

    public final String getPageVersion() {
        return this.pageVersion;
    }

    public final void setPageVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pageVersion = str;
    }

    public final String getLynxVersion() {
        return this.lynxVersion;
    }

    public final void setLynxVersion(String str) {
        this.lynxVersion = str;
    }

    public final boolean getAnnieXContainerReuse() {
        return this.annieXContainerReuse;
    }

    public final void setAnnieXContainerReuse(boolean z) {
        this.annieXContainerReuse = z;
    }

    @Override // com.bytedance.android.monitorV2.entity.NativeCommon, com.bytedance.android.monitorV2.base.BaseMonitorData
    public void fillInJsonObject(JSONObject jsonObject) {
        super.fillInJsonObject(jsonObject);
        JsonUtils.safePut(jsonObject, "template_state", this.templateState);
        JsonUtils.safePut(jsonObject, "lynx_version", this.lynxVersion);
        JsonUtils.safePut(jsonObject, "page_version", this.pageVersion);
    }
}
