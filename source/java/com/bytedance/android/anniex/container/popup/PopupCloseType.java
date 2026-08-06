package com.bytedance.android.anniex.container.popup;

import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PopupCloseType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/anniex/container/popup/PopupCloseType;", "", "tag", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTag", "()Ljava/lang/String;", "enableFix", "", "SYSTEM_BACK", "PULL_DOWN", "CLICK_MASK", "UNKNOWN", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public enum PopupCloseType {
    SYSTEM_BACK { // from class: com.bytedance.android.anniex.container.popup.PopupCloseType.SYSTEM_BACK
        @Override // com.bytedance.android.anniex.container.popup.PopupCloseType
        public String getTag(boolean enableFix) {
            return enableFix ? CloseType.SystemBack.getTag() : getTag();
        }
    },
    PULL_DOWN { // from class: com.bytedance.android.anniex.container.popup.PopupCloseType.PULL_DOWN
        @Override // com.bytedance.android.anniex.container.popup.PopupCloseType
        public String getTag(boolean enableFix) {
            return enableFix ? CloseType.PullDown.getTag() : getTag();
        }
    },
    CLICK_MASK { // from class: com.bytedance.android.anniex.container.popup.PopupCloseType.CLICK_MASK
        @Override // com.bytedance.android.anniex.container.popup.PopupCloseType
        public String getTag(boolean enableFix) {
            return enableFix ? CloseType.MaskClick.getTag() : getTag();
        }
    },
    UNKNOWN { // from class: com.bytedance.android.anniex.container.popup.PopupCloseType.UNKNOWN
        @Override // com.bytedance.android.anniex.container.popup.PopupCloseType
        public String getTag(boolean enableFix) {
            return enableFix ? CloseType.UnKnown.getTag() : getTag();
        }
    };

    private final String tag;

    /* synthetic */ PopupCloseType(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public abstract String getTag(boolean enableFix);

    PopupCloseType(String str) {
        this.tag = str;
    }

    public final String getTag() {
        return this.tag;
    }

    public static /* synthetic */ String getTag$default(PopupCloseType popupCloseType, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTag");
        }
        if ((i & 1) != 0) {
            z = IConditionCallKt.enableAnnieXLiveDialogClickMaskCloseFix();
        }
        return popupCloseType.getTag(z);
    }
}
