package com.bytedance.ug.sdk.deeplink;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.ug.sdk.deeplink.interfaces.IZLinkCompliance;
import com.bytedance.ug.sdk.deeplink.utils.EventUtil;
import com.bytedance.ug.sdk.deeplink.utils.Logger;
import com.bytedance.ug.sdk.share.impl.network.request.FetchTokenInfoThread;
import java.util.ArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ClipboardUtils {
    private static final String TAG = "ClipboardUtils";

    private static void clearLastTTCBContent() {
    }

    public static ClipData getClipBoardContent(Context context) {
        ClipboardManager clipboardManager = getClipboardManager(context);
        if (clipboardManager == null) {
            return null;
        }
        boolean z = true;
        try {
            ClipboardTrace.setHasPrimaryClipCalled(true);
            IZLinkCompliance iZLinkCompliance = (IZLinkCompliance) ZlinkProviderManager.getProvider(IZLinkCompliance.class);
            StringBuilder sb = new StringBuilder("getClipBoardContent, compliance == null? ");
            if (iZLinkCompliance != null) {
                z = false;
            }
            Logger.m446d(TAG, sb.append(z).toString());
            EventUtil.sendGetClipboardEvent();
            if (iZLinkCompliance != null) {
                return iZLinkCompliance.getPrimaryClipData(clipboardManager);
            }
            return clipboardManager.getPrimaryClip();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0073 A[Catch: all -> 0x008e, TRY_ENTER, TryCatch #0 {all -> 0x008e, blocks: (B:33:0x0073, B:37:0x0077, B:39:0x007d, B:41:0x0083, B:42:0x0087), top: B:31:0x0071 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0077 A[Catch: all -> 0x008e, TryCatch #0 {all -> 0x008e, blocks: (B:33:0x0073, B:37:0x0077, B:39:0x007d, B:41:0x0083, B:42:0x0087), top: B:31:0x0071 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void clearClipBoard(Context context, String str, ClipData clipData) {
        ClipboardManager clipboardManager;
        ClipData clipData2;
        if (TextUtils.isEmpty(str) || clipData == null || (clipboardManager = getClipboardManager(context)) == null) {
            return;
        }
        try {
            if (clipData.getItemCount() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < clipData.getItemCount(); i++) {
                    ClipData.Item itemAt = clipData.getItemAt(i);
                    if (itemAt != null && (itemAt.getText() == null || !str.equals(itemAt.getText().toString()))) {
                        arrayList.add(itemAt);
                    }
                }
                if (arrayList.size() > 0) {
                    clipData2 = new ClipData(clipData.getDescription(), (ClipData.Item) arrayList.get(0));
                    for (int i2 = 1; i2 < arrayList.size(); i2++) {
                        clipData2.addItem((ClipData.Item) arrayList.get(i2));
                    }
                    if (clipData2 == null) {
                        setPrimaryClip(clipboardManager, clipData2);
                    } else if (clipData.getItemCount() > 0) {
                        if (Build.VERSION.SDK_INT >= 28) {
                            clipboardManager.clearPrimaryClip();
                        } else {
                            setPrimaryClip(clipboardManager, ClipData.newPlainText("", ""));
                        }
                    }
                    return;
                }
            }
            if (clipData2 == null) {
            }
            return;
        } catch (Throwable unused) {
            return;
        }
        clipData2 = null;
    }

    public static void clearClipBoard(Context context) {
        try {
            ClipboardManager clipboardManager = getClipboardManager(context);
            if (Build.VERSION.SDK_INT >= 28) {
                clipboardManager.clearPrimaryClip();
            } else {
                setPrimaryClip(clipboardManager, ClipData.newPlainText("", ""));
            }
        } catch (Throwable unused) {
        }
    }

    public static void appendTextToClipboard(Context context, CharSequence charSequence) {
        ClipData primaryClip;
        try {
            ClipboardManager clipboardManager = getClipboardManager(context);
            if (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null) {
                return;
            }
            primaryClip.addItem(new ClipData.Item(charSequence));
            setPrimaryClip(clipboardManager, primaryClip);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void writeClipBoard(Context context, CharSequence charSequence, CharSequence charSequence2) {
        try {
            setPrimaryClip(getClipboardManager(context), ClipData.newPlainText(charSequence, charSequence2));
        } catch (Throwable unused) {
        }
    }

    public static Pair<Boolean, ClipData> shouldGetClipBoardContent(Context context) {
        ClipboardManager clipboardManager = getClipboardManager(context);
        ClipData clipData = null;
        boolean z = false;
        if (clipboardManager.hasPrimaryClip()) {
            boolean z2 = true;
            if (Build.VERSION.SDK_INT >= 26) {
                long timestamp = clipboardManager.getPrimaryClipDescription().getTimestamp();
                if (timestamp == ClipboardSaveHelper.INSTANCE.getSaveClipboardTimeStamp(context)) {
                    String saveTTCBContent = ClipboardSaveHelper.INSTANCE.getSaveTTCBContent(context);
                    if (!saveTTCBContent.isEmpty()) {
                        clipData = ClipData.newPlainText("ttcb", saveTTCBContent);
                    }
                } else {
                    ClipboardSaveHelper.INSTANCE.saveClipboardTimeStamp(context, timestamp);
                    z = true;
                }
                z2 = z;
            }
            if (z2) {
                ClipboardSaveHelper.INSTANCE.removeTTCBSave(context);
            }
            return new Pair<>(Boolean.valueOf(z2), clipData);
        }
        ClipboardSaveHelper.INSTANCE.removeTTCBSave(context);
        return new Pair<>(false, null);
    }

    private static void setPrimaryClip(ClipboardManager clipboardManager, ClipData clipData) {
        if (clipboardManager != null) {
            IZLinkCompliance iZLinkCompliance = (IZLinkCompliance) ZlinkProviderManager.getProvider(IZLinkCompliance.class);
            Logger.m446d(TAG, "setPrimaryClip, compliance == null? " + (iZLinkCompliance == null));
            if (iZLinkCompliance != null) {
                iZLinkCompliance.setPrimaryClip(clipboardManager, clipData);
            } else {
                clipboardManager.setPrimaryClip(clipData);
            }
        }
    }

    private static ClipboardManager getClipboardManager(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return (ClipboardManager) context.getSystemService(FetchTokenInfoThread.CLIPBOARD_TOKEN);
        } catch (Throwable th) {
            Logger.m448e(TAG, "Can't create handler inside thread that has not called Looper.prepare() ", th);
            if (Looper.myLooper() != null) {
                return null;
            }
            Looper.prepare();
            return (ClipboardManager) context.getSystemService(FetchTokenInfoThread.CLIPBOARD_TOKEN);
        }
    }
}
