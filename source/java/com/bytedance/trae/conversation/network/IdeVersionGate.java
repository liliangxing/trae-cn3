package com.bytedance.trae.conversation.network;

import com.bytedance.trae.im.service.CliType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: IdeVersionComparator.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\"\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/network/IdeVersionGate;", "", "<init>", "()V", "shouldBlockByMinimum", "", "version", "", "minimum", "shouldBlockCliModelList", "cliType", "Lcom/bytedance/trae/im/service/CliType;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class IdeVersionGate {
    public static final IdeVersionGate INSTANCE = new IdeVersionGate();

    private IdeVersionGate() {
    }

    public final boolean shouldBlockByMinimum(String version, String minimum) {
        String str = minimum;
        if (str == null || StringsKt.isBlank(str)) {
            return false;
        }
        return !IdeVersionComparator.INSTANCE.isGreaterOrEqual(version, minimum);
    }

    public final boolean shouldBlockCliModelList(CliType cliType, String version, String minimum) {
        Intrinsics.checkNotNullParameter(cliType, "cliType");
        if (cliType == CliType.IDE) {
            return false;
        }
        return shouldBlockByMinimum(version, minimum);
    }
}
