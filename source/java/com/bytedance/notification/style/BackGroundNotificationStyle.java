package com.bytedance.notification.style;

import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.bytedance.android.service.manager.push.notification.NotificationBody;
import com.bytedance.common.notification.R;
import com.bytedance.notification.extra.PushNotificationExtra;
import com.bytedance.notification.interfaze.IViewCallback;
import com.bytedance.push.utils.RomUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.message.util.DpUtils;
import com.ss.android.message.util.ToolUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class BackGroundNotificationStyle {
    private static final String TAG = "PushNotification";
    public static IViewCallback sViewCallback;
    private Context mContext;
    private NotificationBody mNotificationBody;
    private PushNotificationExtra mPushNotificationExtra;

    public BackGroundNotificationStyle(Context context, PushNotificationExtra pushNotificationExtra, NotificationBody notificationBody) {
        this.mContext = context;
        this.mPushNotificationExtra = pushNotificationExtra;
        this.mNotificationBody = notificationBody;
    }

    public Notification.Builder buildBackGroundNotification(Notification.Builder builder) {
        RemoteViews createContentView;
        PushNotificationExtra pushNotificationExtra = this.mPushNotificationExtra;
        if (pushNotificationExtra == null || pushNotificationExtra.mIsEmptyExtra || !this.mPushNotificationExtra.mEnableNotificationHighLight) {
            return builder;
        }
        builder.setSmallIcon(Icon.createWithBitmap(this.mNotificationBody.iconBitmap));
        if (this.mPushNotificationExtra.mEnableOnTop) {
            builder.setShowWhen(false);
            builder.setWhen(System.currentTimeMillis() + (this.mPushNotificationExtra.mOnTopTime * 24 * 60 * 60 * 1000));
        }
        if (this.mPushNotificationExtra.mNotificationColor != -1 || !TextUtils.isEmpty(this.mPushNotificationExtra.mNotificationBackgroundImage)) {
            Notification build = builder.build();
            if (build.contentView != null) {
                createContentView = build.contentView;
            } else {
                createContentView = builder.createContentView();
            }
            if (createContentView != null) {
                View apply = createContentView.apply(this.mContext.getApplicationContext(), new FrameLayout(this.mContext.getApplicationContext()));
                if (RomUtils.getInstance().isHigherMi12()) {
                    createContentView.setViewPadding(Resources.getSystem().getIdentifier(RemoteMessageConst.Notification.ICON, "id", "android"), DpUtils.dp2px(this.mContext, 2.0f), 0, 0, 0);
                }
                if (RomUtils.getInstance().isMiOS() && !RomUtils.getInstance().isHigherMi12()) {
                    createContentView = buildXmRemoteViews(apply);
                    setTextColor(createContentView, apply);
                } else {
                    if (this.mPushNotificationExtra.mResetAllTextToBlack) {
                        ArrayList arrayList = new ArrayList();
                        phaseAllTextViewOfTargetView(apply, arrayList);
                        Iterator<Integer> it = arrayList.iterator();
                        while (it.hasNext()) {
                            createContentView.setTextColor(it.next().intValue(), -16777216);
                        }
                    }
                    setTextColor(createContentView, apply);
                    if (this.mPushNotificationExtra.mProxyNotificationExtra != null && this.mPushNotificationExtra.mProxyNotificationExtra.mProxyType == 2) {
                        setAppName(createContentView, apply, this.mPushNotificationExtra.mProxyNotificationExtra.mTargetAppName);
                    }
                    RemoteViews remoteViews = new RemoteViews(this.mContext.getPackageName(), R.layout.highlight_notification_image_back);
                    if (this.mPushNotificationExtra.mNotificationBackgroundBitmap != null) {
                        remoteViews.setBitmap(R.id.notification_background_img, "setImageBitmap", this.mPushNotificationExtra.mNotificationBackgroundBitmap);
                    }
                    try {
                        Method method = RemoteViews.class.getMethod("addView", Integer.TYPE, RemoteViews.class, Integer.TYPE);
                        method.setAccessible(true);
                        method.invoke(createContentView, Integer.valueOf(Resources.getSystem().getIdentifier("status_bar_latest_event_content", "id", "android")), remoteViews, 0);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    createContentView.reapply(this.mContext.getApplicationContext(), apply);
                    IViewCallback iViewCallback = sViewCallback;
                    if (iViewCallback != null) {
                        iViewCallback.onViewCallback(apply);
                    }
                }
                if (this.mPushNotificationExtra.mEnableOnTop) {
                    setImageVisible(createContentView, "alerted_icon", "id", "android", 8, apply);
                }
                if (createContentView != null) {
                    builder.setCustomBigContentView(createContentView);
                    builder.setCustomContentView(createContentView);
                }
            }
        }
        return builder;
    }

    private void phaseAllTextViewOfTargetView(View view, List<Integer> list) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt != null) {
                    phaseAllTextViewOfTargetView(childAt, list);
                }
            }
            return;
        }
        if (view instanceof TextView) {
            list.add(Integer.valueOf(view.getId()));
        }
    }

    private void setAppName(RemoteViews remoteViews, View view, String str) {
        int identifier = Resources.getSystem().getIdentifier("app_name_text", "id", "android");
        if (view.findViewById(identifier) instanceof TextView) {
            remoteViews.setTextViewText(identifier, str);
        }
    }

    private void setTextColor(RemoteViews remoteViews, View view) {
        int i = this.mPushNotificationExtra.mNotificationHeaderColor;
        if (i != 0) {
            setTextColor(remoteViews, "app_name_text", "id", "android", i, view);
            setTextColor(remoteViews, "time_divider", "id", "android", i, view);
            setTextColor(remoteViews, "time", "id", "android", i, view);
            if (ToolUtils.isTargetBrandDevice(ToolUtils.VIVO)) {
                if (this.mPushNotificationExtra.mEnableOnTop) {
                    setTextColor(remoteViews, "sub_time_divider", "id", "vivo", 0, view);
                    setTextColor(remoteViews, "sub_time", "id", "vivo", 0, view);
                } else {
                    setTextColor(remoteViews, "sub_time_divider", "id", "vivo", i, view);
                    setTextColor(remoteViews, "sub_time", "id", "vivo", i, view);
                }
            }
        }
        if (this.mPushNotificationExtra.mEnableOnTop) {
            setTextColor(remoteViews, "time", "id", "android", 0, view);
            setTextColor(remoteViews, "time_divider", "id", "android", 0, view);
        }
        if (this.mPushNotificationExtra.mNotificationTitleColor != 0) {
            setTextColor(remoteViews, "title", "id", "android", this.mPushNotificationExtra.mNotificationTitleColor, view);
        }
        if (this.mPushNotificationExtra.mNotificationContentColor != 0) {
            setTextColor(remoteViews, "text", "id", "android", this.mPushNotificationExtra.mNotificationContentColor, view);
        }
    }

    private void setTextColor(RemoteViews remoteViews, String str, String str2, String str3, int i, View view) {
        int identifier = Resources.getSystem().getIdentifier(str, str2, str3);
        if (view.findViewById(identifier) instanceof TextView) {
            remoteViews.setTextColor(identifier, i);
        }
    }

    private void setImageVisible(RemoteViews remoteViews, String str, String str2, String str3, int i, View view) {
        int identifier = Resources.getSystem().getIdentifier(str, str2, str3);
        if (view.findViewById(identifier) instanceof ImageView) {
            remoteViews.setViewVisibility(identifier, i);
        }
    }

    private RemoteViews buildXmRemoteViews(View view) {
        if (view == null) {
            return null;
        }
        RemoteViews remoteViews = new RemoteViews(this.mContext.getPackageName(), R.layout.notification_style_layout_xm);
        remoteViews.setBitmap(R.id.notification_background_img, "setImageBitmap", this.mPushNotificationExtra.mNotificationBackgroundBitmap);
        TextView textView = (TextView) view.findViewById(Resources.getSystem().getIdentifier("title", "id", "android"));
        remoteViews.setTextColor(R.id.push_notification_title, this.mPushNotificationExtra.mNotificationTitleColor == 0 ? textView.getCurrentTextColor() : this.mPushNotificationExtra.mNotificationTitleColor);
        remoteViews.setTextViewTextSize(R.id.push_notification_title, 0, textView.getTextSize());
        remoteViews.setTextViewText(R.id.push_notification_title, this.mNotificationBody.title);
        TextView textView2 = (TextView) view.findViewById(Resources.getSystem().getIdentifier("text", "id", "android"));
        remoteViews.setTextColor(R.id.push_notification_content, this.mPushNotificationExtra.mNotificationContentColor == 0 ? textView2.getCurrentTextColor() : this.mPushNotificationExtra.mNotificationContentColor);
        remoteViews.setTextViewTextSize(R.id.push_notification_content, 0, textView2.getTextSize());
        remoteViews.setTextViewText(R.id.push_notification_content, this.mNotificationBody.content);
        if (this.mNotificationBody.imageType == 1) {
            this.mNotificationBody.imageType = 2;
        }
        if (this.mNotificationBody.imageBitmap != null && this.mNotificationBody.imageType == 2) {
            if (RomUtils.getInstance().isMi12()) {
                remoteViews.setBitmap(R.id.push_notification_small_picture, "setImageBitmap", this.mNotificationBody.imageBitmap);
                remoteViews.setViewVisibility(R.id.push_notification_small_picture, 0);
                int dp2px = DpUtils.dp2px(this.mContext, 24.0f);
                NotificationBody notificationBody = this.mNotificationBody;
                notificationBody.iconBitmap = Bitmap.createScaledBitmap(notificationBody.iconBitmap, dp2px, dp2px, true);
                remoteViews.setBitmap(R.id.push_notification_small_icon, "setImageBitmap", this.mNotificationBody.iconBitmap);
            } else {
                int dp2px2 = DpUtils.dp2px(this.mContext, 40.0f);
                NotificationBody notificationBody2 = this.mNotificationBody;
                notificationBody2.imageBitmap = Bitmap.createScaledBitmap(notificationBody2.imageBitmap, dp2px2, dp2px2, true);
                remoteViews.setBitmap(R.id.push_notification_small_icon, "setImageBitmap", this.mNotificationBody.imageBitmap);
                int dp2px3 = DpUtils.dp2px(this.mContext, 4.0f);
                remoteViews.setViewPadding(R.id.push_notification_small_icon, dp2px3, dp2px3, dp2px3, dp2px3);
                remoteViews.setViewVisibility(R.id.push_notification_small_picture, 8);
            }
        } else {
            if (RomUtils.getInstance().isMi12()) {
                int dp2px4 = DpUtils.dp2px(this.mContext, 24.0f);
                NotificationBody notificationBody3 = this.mNotificationBody;
                notificationBody3.iconBitmap = Bitmap.createScaledBitmap(notificationBody3.iconBitmap, dp2px4, dp2px4, true);
            } else {
                int dp2px5 = DpUtils.dp2px(this.mContext, 36.0f);
                NotificationBody notificationBody4 = this.mNotificationBody;
                notificationBody4.iconBitmap = Bitmap.createScaledBitmap(notificationBody4.iconBitmap, dp2px5, dp2px5, true);
                int dp2px6 = DpUtils.dp2px(this.mContext, 4.0f);
                remoteViews.setViewPadding(R.id.push_notification_small_icon, dp2px6, dp2px6, dp2px6, dp2px6);
            }
            remoteViews.setBitmap(R.id.push_notification_small_icon, "setImageBitmap", this.mNotificationBody.iconBitmap);
            remoteViews.setViewVisibility(R.id.push_notification_small_picture, 8);
        }
        return remoteViews;
    }
}
