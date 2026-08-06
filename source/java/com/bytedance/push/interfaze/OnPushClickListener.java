package com.bytedance.push.interfaze;

import android.content.Context;
import com.bytedance.push.PushBody;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public interface OnPushClickListener {
    JSONObject onClickPush(Context context, int i, PushBody pushBody, String str);
}
