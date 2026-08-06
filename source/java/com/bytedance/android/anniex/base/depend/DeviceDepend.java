package com.bytedance.android.anniex.base.depend;

import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.ies.bullet.base.constants.GlobalPropertiesConstants;
import com.bytedance.ies.bullet.core.container.IBulletContainer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: DeviceDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J&\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0017J\b\u0010\r\u001a\u00020\u0007H\u0017J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J6\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0017H\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/anniex/base/depend/DeviceDepend;", "", "()V", "enableBreakPoint", "", "getBreakPoint", "", "", "", GlobalPropertiesConstants.CONTENT_WIDTH, GlobalPropertiesConstants.CONTENT_HEIGHT, "getBreakPointKey", "getFoldStatus", "getFoldType", "isFold", "isPad", "onBreakPointChange", "", "container", "Lcom/bytedance/android/anniex/base/container/IContainer;", "bulletContainer", "Lcom/bytedance/ies/bullet/core/container/IBulletContainer;", "screenProps", "", "FoldStatus", "FoldType", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public class DeviceDepend {
    public boolean enableBreakPoint() {
        return false;
    }

    public Map<String, Integer> getBreakPoint(int contentWidth, int contentHeight) {
        return null;
    }

    public String getBreakPointKey() {
        return "";
    }

    @FoldStatus
    public String getFoldStatus() {
        return "";
    }

    @FoldType
    public String getFoldType() {
        return "";
    }

    public boolean isFold() {
        return false;
    }

    public boolean isPad() {
        return false;
    }

    public void onBreakPointChange(IContainer container, IBulletContainer bulletContainer, Map<String, Object> screenProps) {
    }

    public static /* synthetic */ void onBreakPointChange$default(DeviceDepend deviceDepend, IContainer iContainer, IBulletContainer iBulletContainer, Map map, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onBreakPointChange");
        }
        if ((i & 1) != 0) {
            iContainer = null;
        }
        if ((i & 2) != 0) {
            iBulletContainer = null;
        }
        deviceDepend.onBreakPointChange(iContainer, iBulletContainer, map);
    }

    /* compiled from: DeviceDepend.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/anniex/base/depend/DeviceDepend$FoldStatus;", "", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes2.dex */
    public @interface FoldStatus {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final String FLAT = "flat";
        public static final String FOLDED = "folded";
        public static final String HALF = "half";
        public static final String UNKNOWN = "";

        /* compiled from: DeviceDepend.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/anniex/base/depend/DeviceDepend$FoldStatus$Companion;", "", "()V", "FLAT", "", "FOLDED", "HALF", "UNKNOWN", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String FLAT = "flat";
            public static final String FOLDED = "folded";
            public static final String HALF = "half";
            public static final String UNKNOWN = "";

            private Companion() {
            }
        }
    }

    /* compiled from: DeviceDepend.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/anniex/base/depend/DeviceDepend$FoldType;", "", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes2.dex */
    public @interface FoldType {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final String HORIZONTAL = "horizontal";
        public static final String UNKNOWN = "";
        public static final String VERTICAL = "vertical";

        /* compiled from: DeviceDepend.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/anniex/base/depend/DeviceDepend$FoldType$Companion;", "", "()V", "HORIZONTAL", "", "UNKNOWN", "VERTICAL", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String HORIZONTAL = "horizontal";
            public static final String UNKNOWN = "";
            public static final String VERTICAL = "vertical";

            private Companion() {
            }
        }
    }
}
