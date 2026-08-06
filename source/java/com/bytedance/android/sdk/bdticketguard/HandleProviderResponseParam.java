package com.bytedance.android.sdk.bdticketguard;

import android.util.Pair;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TicketGuardApiProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0018\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\n0\t¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/HandleProviderResponseParam;", "Lcom/bytedance/android/sdk/bdticketguard/ResponseParam;", "Lcom/bytedance/android/sdk/bdticketguard/ProviderRequestContent;", "type", "", "needSave", "", "providerRequestContent", "responseHeaders", "", "Landroid/util/Pair;", "(Ljava/lang/String;ZLcom/bytedance/android/sdk/bdticketguard/ProviderRequestContent;Ljava/util/List;)V", "getNeedSave", "()Z", "getType", "()Ljava/lang/String;", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class HandleProviderResponseParam extends ResponseParam<ProviderRequestContent> {
    private final boolean needSave;
    private final String type;

    public final String getType() {
        return this.type;
    }

    public final boolean getNeedSave() {
        return this.needSave;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandleProviderResponseParam(String str, boolean z, ProviderRequestContent providerRequestContent, List<? extends Pair<String, String>> list) {
        super(providerRequestContent, list, 0L, 4, null);
        Intrinsics.checkParameterIsNotNull(str, "type");
        Intrinsics.checkParameterIsNotNull(providerRequestContent, "providerRequestContent");
        Intrinsics.checkParameterIsNotNull(list, "responseHeaders");
        this.type = str;
        this.needSave = z;
    }
}
