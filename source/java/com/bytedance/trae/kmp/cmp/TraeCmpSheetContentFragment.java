package com.bytedance.trae.kmp.cmp;

import com.bytedance.trae.common.widget.TraeTitleBar;
import kotlin.Metadata;

/* compiled from: TraeCmpContentFragment.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/kmp/cmp/TraeCmpSheetContentFragment;", "Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;", "<init>", "()V", "titleBarMode", "Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;", "getTitleBarMode", "()Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class TraeCmpSheetContentFragment extends TraeCmpContentFragment {
    public static final int $stable = 0;
    private final TraeTitleBar.Mode titleBarMode = TraeTitleBar.Mode.SHEET;

    @Override // com.bytedance.trae.kmp.cmp.TraeCmpContentFragment
    protected final TraeTitleBar.Mode getTitleBarMode() {
        return this.titleBarMode;
    }
}
