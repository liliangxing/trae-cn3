package com.bytedance.ies.bullet.kit.lynx.api;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ThreadStrategyForRendering.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/kit/lynx/api/ThreadStrategyForRendering;", "", "(Ljava/lang/String;I)V", "mId", "", "ThreadStrategyForRendering", "", "id", "ALL_ON_UI", "MOST_ON_TASM", "PART_ON_LAYOUT", "MULTI_THREADS", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public enum ThreadStrategyForRendering {
    ALL_ON_UI { // from class: com.bytedance.ies.bullet.kit.lynx.api.ThreadStrategyForRendering.ALL_ON_UI
        @Override // com.bytedance.ies.bullet.kit.lynx.api.ThreadStrategyForRendering
        /* renamed from: id */
        public int getMId() {
            return 0;
        }
    },
    MOST_ON_TASM { // from class: com.bytedance.ies.bullet.kit.lynx.api.ThreadStrategyForRendering.MOST_ON_TASM
        @Override // com.bytedance.ies.bullet.kit.lynx.api.ThreadStrategyForRendering
        /* renamed from: id */
        public int getMId() {
            return 1;
        }
    },
    PART_ON_LAYOUT { // from class: com.bytedance.ies.bullet.kit.lynx.api.ThreadStrategyForRendering.PART_ON_LAYOUT
        @Override // com.bytedance.ies.bullet.kit.lynx.api.ThreadStrategyForRendering
        /* renamed from: id */
        public int getMId() {
            return 2;
        }
    },
    MULTI_THREADS { // from class: com.bytedance.ies.bullet.kit.lynx.api.ThreadStrategyForRendering.MULTI_THREADS
        @Override // com.bytedance.ies.bullet.kit.lynx.api.ThreadStrategyForRendering
        /* renamed from: id */
        public int getMId() {
            return 3;
        }
    };

    private int mId;

    /* synthetic */ ThreadStrategyForRendering(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public void ThreadStrategyForRendering(int id) {
        this.mId = id;
    }

    /* renamed from: id, reason: from getter */
    public int getMId() {
        return this.mId;
    }
}
