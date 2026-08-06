package com.bytedance.ies.xbridge.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import kotlin.Metadata;

/* compiled from: XBridgeMethodHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0004¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/xbridge/utils/XBridgeMethodHelper;", "", "()V", "getActContext", "Landroid/content/Context;", "context", "getActivity", "Landroid/app/Activity;", AirActionConstant.ActionId.ACTION_ID_CALL, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class XBridgeMethodHelper {
    public static final XBridgeMethodHelper INSTANCE = new XBridgeMethodHelper();

    private XBridgeMethodHelper() {
    }

    public final Activity getActivity(Context c) {
        while (true) {
            if (c != null) {
                if (c instanceof Activity) {
                    return (Activity) c;
                }
                if (c instanceof ContextWrapper) {
                    c = ((ContextWrapper) c).getBaseContext();
                } else {
                    Log.w("ViewUtils", "find non-ContextWrapper in view: " + c);
                    break;
                }
            } else {
                break;
            }
        }
        return null;
    }

    public final Context getActContext(Context context) {
        return getActivity(context);
    }
}
