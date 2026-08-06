package com.bytedance.kmp.image.options;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ImageLoadPriority.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/bytedance/kmp/image/options/Priority;", "", "()V", "High", "Low", "Normal", "Lcom/bytedance/kmp/image/options/Priority$High;", "Lcom/bytedance/kmp/image/options/Priority$Low;", "Lcom/bytedance/kmp/image/options/Priority$Normal;", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class Priority {
    public static final int $stable = 0;

    public /* synthetic */ Priority(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private Priority() {
    }

    /* compiled from: ImageLoadPriority.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/kmp/image/options/Priority$Low;", "Lcom/bytedance/kmp/image/options/Priority;", "()V", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Low extends Priority {
        public static final int $stable = 0;
        public static final Low INSTANCE = new Low();

        private Low() {
            super(null);
        }
    }

    /* compiled from: ImageLoadPriority.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/kmp/image/options/Priority$Normal;", "Lcom/bytedance/kmp/image/options/Priority;", "()V", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Normal extends Priority {
        public static final int $stable = 0;
        public static final Normal INSTANCE = new Normal();

        private Normal() {
            super(null);
        }
    }

    /* compiled from: ImageLoadPriority.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/kmp/image/options/Priority$High;", "Lcom/bytedance/kmp/image/options/Priority;", "()V", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class High extends Priority {
        public static final int $stable = 0;
        public static final High INSTANCE = new High();

        private High() {
            super(null);
        }
    }
}
