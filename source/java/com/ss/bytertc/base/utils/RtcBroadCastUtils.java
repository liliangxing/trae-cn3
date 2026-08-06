package com.ss.bytertc.base.utils;

import android.content.Context;
import android.content.Intent;
import com.bytedance.realx.base.RXLogging;

/* loaded from: classes7.dex */
public class RtcBroadCastUtils {
    private static int PLAY_STATE_INIT = 0;
    private static int PLAY_STATE_PAUSE = 2;
    private static int PLAY_STATE_START = 1;
    private static int PLAY_STATE_STOP = 3;
    private static String TAG = "RtcBroadCastUtils";

    public static void sendBroadcast(int state) {
        Context applicationContext = RtcContextUtils.getApplicationContext();
        Intent intent = new Intent("CrossTalkDetectPlayerStatusChangeNotification");
        intent.putExtra("player_type", "RTC");
        intent.putExtra("player_hash", 0);
        intent.putExtra("biz_tag", "");
        intent.putExtra("play_source_id", "Android");
        if (state == 1) {
            intent.putExtra("play_state", PLAY_STATE_START);
        } else if (state == 2) {
            intent.putExtra("play_state", PLAY_STATE_STOP);
        }
        intent.putExtra("play_start_timestamp", System.currentTimeMillis() / 1000);
        intent.putExtra("volume", 1.0f);
        if (state == 1) {
            intent.putExtra("is_mute", false);
        } else {
            intent.putExtra("is_mute", true);
        }
        applicationContext.sendBroadcast(intent);
        RXLogging.w(TAG, TAG + " :sendBroadcast state after: " + state);
    }
}
