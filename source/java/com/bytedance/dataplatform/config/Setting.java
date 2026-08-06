package com.bytedance.dataplatform.config;

import kotlin.Metadata;

/* compiled from: ExperimentEntityUtiil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/bytedance/dataplatform/config/Setting;", "Lcom/bytedance/dataplatform/config/SettingInternal;", "()V", "Generic", "Sticky", "experiment_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final class Setting extends SettingInternal {
    public static final Setting INSTANCE = new Setting();

    /* compiled from: ExperimentEntityUtiil.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/dataplatform/config/Setting$Sticky;", "Lcom/bytedance/dataplatform/config/SettingInternal;", "()V", "Generic", "experiment_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes3.dex */
    public static final class Sticky extends SettingInternal {
        public static final Sticky INSTANCE = new Sticky();

        /* compiled from: ExperimentEntityUtiil.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/dataplatform/config/Setting$Sticky$Generic;", "Lcom/bytedance/dataplatform/config/SettingGenericInternal;", "()V", "experiment_release"}, k = 1, mv = {1, 1, 15})
        /* loaded from: classes3.dex */
        public static final class Generic extends SettingGenericInternal {
            public static final Generic INSTANCE = new Generic();

            private Generic() {
                super(true);
            }
        }

        private Sticky() {
            super(true);
        }
    }

    private Setting() {
        super(false);
    }

    /* compiled from: ExperimentEntityUtiil.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/dataplatform/config/Setting$Generic;", "Lcom/bytedance/dataplatform/config/SettingGenericInternal;", "()V", "Sticky", "experiment_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes3.dex */
    public static final class Generic extends SettingGenericInternal {
        public static final Generic INSTANCE = new Generic();

        /* compiled from: ExperimentEntityUtiil.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/dataplatform/config/Setting$Generic$Sticky;", "Lcom/bytedance/dataplatform/config/SettingGenericInternal;", "()V", "experiment_release"}, k = 1, mv = {1, 1, 15})
        /* loaded from: classes3.dex */
        public static final class Sticky extends SettingGenericInternal {
            public static final Sticky INSTANCE = new Sticky();

            private Sticky() {
                super(true);
            }
        }

        private Generic() {
            super(false);
        }
    }
}
