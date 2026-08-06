package com.bytedance.ug.sdk.share.api.entity;

import androidx.core.app.NotificationCompat;
import com.bytedance.framwork.core.sdkmonitor.MonitorConstants;

/* loaded from: classes4.dex */
public enum ShareStrategy {
    NORMAL,
    SHARE_WITH_COMPONENT,
    SHARE_WITH_TOKEN,
    SHARE_WITH_COMPONET_OPTIMIZE,
    SHARE_WITH_IMAGE_TOKEN,
    SHARE_WITH_VIDEO;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static ShareStrategy getStrategyByType(String str) {
        char c;
        switch (str.hashCode()) {
            case -1737986495:
                if (str.equals("sys_opt")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 113722:
                if (str.equals(MonitorConstants.MONITOR_FROM_SDK)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 114381:
                if (str.equals(NotificationCompat.CATEGORY_SYSTEM)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 100313435:
                if (str.equals("image")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 110541305:
                if (str.equals("token")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 112202875:
                if (str.equals("video")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            return SHARE_WITH_COMPONENT;
        }
        if (c == 1) {
            return SHARE_WITH_TOKEN;
        }
        if (c == 2) {
            return SHARE_WITH_COMPONET_OPTIMIZE;
        }
        if (c == 3) {
            return SHARE_WITH_IMAGE_TOKEN;
        }
        if (c == 4) {
            return SHARE_WITH_VIDEO;
        }
        return NORMAL;
    }

    /* renamed from: com.bytedance.ug.sdk.share.api.entity.ShareStrategy$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$ug$sdk$share$api$entity$ShareStrategy;

        static {
            int[] iArr = new int[ShareStrategy.values().length];
            $SwitchMap$com$bytedance$ug$sdk$share$api$entity$ShareStrategy = iArr;
            try {
                iArr[ShareStrategy.SHARE_WITH_COMPONENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$ug$sdk$share$api$entity$ShareStrategy[ShareStrategy.SHARE_WITH_TOKEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$ug$sdk$share$api$entity$ShareStrategy[ShareStrategy.SHARE_WITH_COMPONET_OPTIMIZE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bytedance$ug$sdk$share$api$entity$ShareStrategy[ShareStrategy.SHARE_WITH_IMAGE_TOKEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$bytedance$ug$sdk$share$api$entity$ShareStrategy[ShareStrategy.SHARE_WITH_VIDEO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$bytedance$ug$sdk$share$api$entity$ShareStrategy[ShareStrategy.NORMAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static String getStrategyStr(ShareStrategy shareStrategy) {
        if (shareStrategy == null) {
            return "";
        }
        int i = AnonymousClass1.$SwitchMap$com$bytedance$ug$sdk$share$api$entity$ShareStrategy[shareStrategy.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? MonitorConstants.MONITOR_FROM_SDK : "video" : "image" : "sys_opt" : "token" : NotificationCompat.CATEGORY_SYSTEM;
    }
}
