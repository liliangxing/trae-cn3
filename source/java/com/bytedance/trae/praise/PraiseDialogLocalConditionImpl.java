package com.bytedance.trae.praise;

import com.bytedance.praisedialoglib.depend.IPraiseDialogLocalConditionConfig;
import kotlin.Metadata;

/* compiled from: PraiseDialogLocalConditionImpl.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/praise/PraiseDialogLocalConditionImpl;", "Lcom/bytedance/praisedialoglib/depend/IPraiseDialogLocalConditionConfig;", "<init>", "()V", "isMatchLocalCondition", "", "isCurDemo", "praise_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PraiseDialogLocalConditionImpl implements IPraiseDialogLocalConditionConfig {
    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogLocalConditionConfig
    public boolean isMatchLocalCondition() {
        return PraiseDialogTrigger.INSTANCE.shouldShow();
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogLocalConditionConfig
    public boolean isCurDemo() {
        return PraiseDialogTrigger.INSTANCE.isIgnoreUgRule();
    }
}
