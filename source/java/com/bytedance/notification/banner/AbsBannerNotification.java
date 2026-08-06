package com.bytedance.notification.banner;

import android.app.Activity;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.push.notification.NotificationBody;
import com.bytedance.common.notification.R;
import com.bytedance.common.push.BaseJson;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.notification.Constants;
import com.bytedance.notification.extra.PushNotificationExtra;
import com.bytedance.notification.helper.BannerActivityHelper;
import com.bytedance.notification.interfaze.IBannerNotification;
import com.bytedance.notification.interfaze.IViewCallback;
import com.bytedance.notification.supporter.PushNotificationSupporter;
import com.bytedance.notification.utils.Log;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.push.utils.Logger;
import com.bytedance.push.utils.RomUtils;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.DpUtils;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class AbsBannerNotification extends BaseJson implements IBannerNotification, View.OnTouchListener {
    public static IViewCallback sViewCallback;
    protected View mBannerView;
    protected Notification.Builder mBuilder;
    protected Context mContext;
    protected int mMarginTop;
    private boolean mNeedDismiss;
    protected NotificationBody mNotificationBody;
    private int mNotificationId;
    private String mNotificationTag;
    protected PushNotificationExtra mPushNotificationExtra;
    protected Intent mTargetIntent;

    /* renamed from: x1 */
    private float f63x1;

    /* renamed from: x2 */
    private float f64x2;

    /* renamed from: y1 */
    private float f65y1;

    /* renamed from: y2 */
    private float f66y2;
    private final String TAG = "IBannerNotification";
    protected final int CANCEL_TOAST_EVENT = 3111802;
    protected final Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.bytedance.notification.banner.AbsBannerNotification.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            AbsBannerNotification.this.handleMessage(message);
        }
    };

    protected abstract void dismissBanner(boolean z, int i);

    public abstract void handleMessage(Message message);

    public AbsBannerNotification(Context context, Notification.Builder builder, Intent intent, PushNotificationExtra pushNotificationExtra, NotificationBody notificationBody) {
        RemoteViews createContentView;
        this.f63x1 = 0.0f;
        this.f64x2 = 0.0f;
        this.f65y1 = 0.0f;
        this.f66y2 = 0.0f;
        this.mNeedDismiss = false;
        this.mContext = context;
        this.mBuilder = builder;
        this.mTargetIntent = intent;
        this.mPushNotificationExtra = pushNotificationExtra;
        this.mNotificationBody = notificationBody;
        Notification build = builder.build();
        if (build.contentView != null) {
            createContentView = build.contentView;
        } else {
            createContentView = builder.createContentView();
        }
        View buildBannerView = buildBannerView(createContentView.apply(this.mContext.getApplicationContext(), new FrameLayout(this.mContext.getApplicationContext())));
        this.mBannerView = buildBannerView;
        buildBannerView.setOnClickListener(getBannerOnClickListener());
        this.f63x1 = 0.0f;
        this.f65y1 = 0.0f;
        this.f64x2 = 0.0f;
        this.f66y2 = 0.0f;
        this.mNeedDismiss = false;
        this.mBannerView.setOnTouchListener(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        String str;
        int i;
        if (motionEvent.getAction() == 0) {
            this.f63x1 = motionEvent.getX();
            this.f65y1 = motionEvent.getY();
        }
        if (motionEvent.getAction() != 1) {
            return false;
        }
        this.f64x2 = motionEvent.getX();
        float y = motionEvent.getY();
        this.f66y2 = y;
        if (this.f65y1 - y > 50.0f) {
            Logger.m268d("IBannerNotification", "监听到上划");
            this.mNeedDismiss = true;
            i = BannerActivityHelper.DISMISS_ANIMAL_FROM_BOTTOM_TO_TOP;
            str = "up";
        } else {
            float f = this.f63x1;
            float f2 = this.f64x2;
            if (f - f2 > 50.0f) {
                Logger.m268d("IBannerNotification", "监听到左划");
                this.mNeedDismiss = true;
                i = BannerActivityHelper.DISMISS_ANIMAL_FROM_RIGHT_TO_LEFT;
                str = "left";
            } else if (f2 - f > 50.0f) {
                Logger.m268d("IBannerNotification", "监听到右划");
                this.mNeedDismiss = true;
                i = BannerActivityHelper.DISMISS_ANIMAL_FROM_LEFT_TO_RIGHT;
                str = "right";
            } else {
                str = "";
                i = -1;
            }
        }
        if (!this.mNeedDismiss) {
            return false;
        }
        Logger.m268d("IBannerNotification", "监听到滑动，消除弹窗");
        dismissBanner(true, i);
        JSONObject jSONObject = new JSONObject();
        add(jSONObject, "clear_position", "banner");
        add(jSONObject, ISignalReportConstants.KEY_CLEAR_TYPE, "slide");
        add(jSONObject, "slide_direction", str);
        PushServiceManager.get().getPushExternalService().onNotificationDelete(this.mNotificationBody.id, jSONObject);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x02af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private View buildBannerView(View view) {
        final float f;
        IViewCallback iViewCallback;
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        FrameLayout frameLayout = (FrameLayout) layoutInflater.inflate(R.layout.highlight_banner_parent, (ViewGroup) null);
        frameLayout.addView(view);
        ImageView imageView = (ImageView) view.findViewById(Resources.getSystem().getIdentifier("icon", "id", "android"));
        if (imageView != null) {
            imageView.setImageBitmap(this.mNotificationBody.iconBitmap);
        }
        if (RomUtils.getInstance().isHigherColor7()) {
            View findViewById = view.findViewById(Resources.getSystem().getIdentifier("notification_header", "id", "android"));
            ((ViewGroup) findViewById.getParent()).removeView(findViewById);
            View findViewById2 = view.findViewById(Resources.getSystem().getIdentifier("notification_main_column", "id", "android"));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) findViewById2.getLayoutParams();
            layoutParams.topMargin = layoutParams.bottomMargin;
            findViewById2.setLayoutParams(layoutParams);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(Resources.getSystem().getIdentifier("right_icon_container", "id", "android"));
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams2.height = -1;
            linearLayout.setVerticalGravity(16);
            layoutParams2.topMargin = 0;
            layoutParams2.bottomMargin = 0;
            linearLayout.setLayoutParams(layoutParams2);
            ImageView imageView2 = (ImageView) view.findViewById(Resources.getSystem().getIdentifier("right_icon", "id", "android"));
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) imageView2.getLayoutParams();
            layoutParams3.gravity = 17;
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
            imageView2.setPadding(0, 0, 0, 0);
            imageView2.setLayoutParams(layoutParams3);
        } else if (RomUtils.getInstance().isFuntouchOS()) {
            if (RomUtils.getInstance().isLessFuntouch4()) {
                View findViewById3 = frameLayout.findViewById(R.id.push_notification_logo_and_name_layout);
                FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) view.findViewById(Resources.getSystem().getIdentifier("notification_main_column", "id", "android")).getLayoutParams();
                ((ImageView) frameLayout.findViewById(R.id.push_notification_small_icon)).setImageBitmap(this.mNotificationBody.iconBitmap);
                TextView textView = (TextView) frameLayout.findViewById(R.id.push_notification_app_name);
                textView.setText(this.mNotificationBody.appName);
                if (this.mPushNotificationExtra.mBannerTitleColor != 0) {
                    textView.setTextColor(this.mPushNotificationExtra.mBannerTitleColor);
                }
                LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) findViewById3.getLayoutParams();
                layoutParams5.leftMargin = layoutParams4.leftMargin;
                layoutParams5.topMargin = layoutParams4.topMargin;
                if (layoutParams5.topMargin == 0) {
                    layoutParams5.topMargin = DpUtils.dp2px(this.mContext, 10.0f);
                }
                findViewById3.setLayoutParams(layoutParams5);
                findViewById3.setVisibility(0);
            }
        } else {
            if (RomUtils.getInstance().isEMUI()) {
                if (RomUtils.getInstance().isHigherEmui10()) {
                    View findViewById4 = frameLayout.findViewById(Resources.getSystem().getIdentifier("notification_header", "id", "android"));
                    findViewById4.setPadding(findViewById4.getPaddingLeft(), 0, findViewById4.getPaddingRight(), 0);
                    View findViewById5 = findViewById4.findViewById(Resources.getSystem().getIdentifier("icon", "id", "android"));
                    if (findViewById5 != null) {
                        ((ImageView) findViewById5).setImageIcon(Icon.createWithResource(this.mContext, R.drawable.status_icon));
                    }
                } else if (RomUtils.getInstance().isLessEmui5()) {
                    view.setPadding(DpUtils.dp2px(this.mContext, 5.0f), 0, 0, 0);
                }
                f = 15.0f;
                setTextColor(frameLayout);
                WindowManager windowManager = (WindowManager) this.mContext.getApplicationContext().getSystemService("window");
                windowManager.getDefaultDisplay().getSize(new Point());
                this.mMarginTop = DpUtils.dp2px(this.mContext, 8.0f);
                int dp2px = this.mContext.getResources().getDisplayMetrics().widthPixels - DpUtils.dp2px(this.mContext, 10.0f);
                FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) view.getLayoutParams();
                layoutParams6.width = dp2px;
                layoutParams6.gravity = 1;
                view.setLayoutParams(layoutParams6);
                view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.notification.banner.AbsBannerNotification.2
                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view2, Outline outline) {
                        outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), f);
                    }
                });
                view.setClipToOutline(true);
                if (this.mPushNotificationExtra.mEnableBannerHighLight && this.mPushNotificationExtra.mBannerBackgroundBitmap != null) {
                    FrameLayout frameLayout2 = (FrameLayout) layoutInflater.inflate(R.layout.highlight_notification_image_back, (ViewGroup) null);
                    ((ImageView) frameLayout2.findViewById(R.id.notification_background_img)).setImageBitmap(this.mPushNotificationExtra.mBannerBackgroundBitmap);
                    ((ViewGroup) frameLayout.findViewById(Resources.getSystem().getIdentifier("status_bar_latest_event_content", "id", "android"))).addView(frameLayout2, 0);
                }
                iViewCallback = sViewCallback;
                if (iViewCallback != null) {
                    iViewCallback.onViewCallback(frameLayout);
                }
                return frameLayout;
            }
            if (RomUtils.getInstance().isMiOS()) {
                ViewGroup viewGroup = (ViewGroup) view.findViewById(Resources.getSystem().getIdentifier("notification_header", "id", "android"));
                if (viewGroup != null) {
                    int identifier = Resources.getSystem().getIdentifier("app_name_text", "id", "android");
                    int identifier2 = Resources.getSystem().getIdentifier("time_divider", "id", "android");
                    int identifier3 = Resources.getSystem().getIdentifier("time", "id", "android");
                    View findViewById6 = viewGroup.findViewById(identifier);
                    if (findViewById6 != null) {
                        viewGroup.removeView(findViewById6);
                    }
                    View findViewById7 = viewGroup.findViewById(identifier2);
                    if (findViewById7 != null) {
                        viewGroup.removeView(findViewById7);
                    }
                    View findViewById8 = viewGroup.findViewById(identifier3);
                    if (findViewById8 != null) {
                        viewGroup.removeView(findViewById8);
                    }
                }
                frameLayout.setPadding(view.getPaddingLeft(), DpUtils.dp2px(this.mContext, 13.0f), view.getPaddingRight(), DpUtils.dp2px(this.mContext, 13.0f));
                view.setBackgroundColor(this.mPushNotificationExtra.mBannerColor);
                View findViewById9 = view.findViewById(R.id.push_inner_layout);
                if (findViewById9 != null) {
                    findViewById9.setBackgroundColor(this.mPushNotificationExtra.mBannerColor);
                }
            }
        }
        f = 30.0f;
        setTextColor(frameLayout);
        WindowManager windowManager2 = (WindowManager) this.mContext.getApplicationContext().getSystemService("window");
        windowManager2.getDefaultDisplay().getSize(new Point());
        this.mMarginTop = DpUtils.dp2px(this.mContext, 8.0f);
        int dp2px2 = this.mContext.getResources().getDisplayMetrics().widthPixels - DpUtils.dp2px(this.mContext, 10.0f);
        FrameLayout.LayoutParams layoutParams62 = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams62.width = dp2px2;
        layoutParams62.gravity = 1;
        view.setLayoutParams(layoutParams62);
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.notification.banner.AbsBannerNotification.2
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), f);
            }
        });
        view.setClipToOutline(true);
        if (this.mPushNotificationExtra.mEnableBannerHighLight) {
            FrameLayout frameLayout22 = (FrameLayout) layoutInflater.inflate(R.layout.highlight_notification_image_back, (ViewGroup) null);
            ((ImageView) frameLayout22.findViewById(R.id.notification_background_img)).setImageBitmap(this.mPushNotificationExtra.mBannerBackgroundBitmap);
            ((ViewGroup) frameLayout.findViewById(Resources.getSystem().getIdentifier("status_bar_latest_event_content", "id", "android"))).addView(frameLayout22, 0);
        }
        iViewCallback = sViewCallback;
        if (iViewCallback != null) {
        }
        return frameLayout;
    }

    private Bitmap bitmapRound(Bitmap bitmap, float f) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    private void setTextColor(View view) {
        if (this.mPushNotificationExtra.mBannerHeaderColor != 0) {
            if (RomUtils.getInstance().isFuntouchOS()) {
                if (!RomUtils.getInstance().isLessFuntouch4()) {
                    setTextViewColor(view, Resources.getSystem().getIdentifier("sub_time_divider", "id", "vivo"), this.mPushNotificationExtra.mBannerHeaderColor);
                    setTextViewColor(view, Resources.getSystem().getIdentifier("sub_time", "id", "vivo"), this.mPushNotificationExtra.mBannerHeaderColor);
                }
            } else {
                setTextViewColor(view, Resources.getSystem().getIdentifier("app_name_text", "id", "android"), this.mPushNotificationExtra.mBannerHeaderColor);
                setTextViewColor(view, Resources.getSystem().getIdentifier("time_divider", "id", "android"), this.mPushNotificationExtra.mBannerHeaderColor);
                setTextViewColor(view, Resources.getSystem().getIdentifier("time", "id", "android"), this.mPushNotificationExtra.mBannerHeaderColor);
            }
        }
        if (this.mPushNotificationExtra.mBannerTitleColor != 0) {
            setTextViewColor(view, Resources.getSystem().getIdentifier(SchemaConstants.QUERY_KEY_TITLE, "id", "android"), this.mPushNotificationExtra.mBannerTitleColor);
        }
        if (this.mPushNotificationExtra.mBannerContentColor != 0) {
            setTextViewColor(view, Resources.getSystem().getIdentifier("text", "id", "android"), this.mPushNotificationExtra.mBannerContentColor);
        }
    }

    private void setTextViewColor(View view, int i, int i2) {
        try {
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                textView.setTextColor(i2);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.notification.interfaze.IBannerNotification
    public void showBannerNotification(String str, int i) {
        this.mNotificationTag = str;
        this.mNotificationId = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.notification.banner.AbsBannerNotification$3 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public class ViewOnClickListenerC03983 implements View.OnClickListener {
        ViewOnClickListenerC03983() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Log.m148d("IBannerNotification", "onClick: on click of banner,mTargetIntent is " + AbsBannerNotification.this.mTargetIntent);
            if (AbsBannerNotification.this.mNeedDismiss) {
                Log.m148d("IBannerNotification", "onClick: mNeedDismiss is true so banner has been dismiss,not jump");
                return;
            }
            AbsBannerNotification.this.dismissBanner(false, -1);
            PushNotificationSupporter.get().getNotificationClickService().onBannerClick(AbsBannerNotification.this.mNotificationBody.id);
            try {
                AbsBannerNotification.this.mTargetIntent.putExtra(Constants.BUNDLE_FROM_BANNER_NOTIFICATION, true);
                PendingIntent.getActivity(AbsBannerNotification.this.mContext, 0, AbsBannerNotification.this.mTargetIntent, 67108864).send(AbsBannerNotification.this.mContext, 0, AbsBannerNotification.this.mTargetIntent);
                final Application application = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mApplication;
                application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.notification.banner.AbsBannerNotification.3.1
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity) {
                        Log.m148d("IBannerNotification", "onActivityResumed");
                        application.unregisterActivityLifecycleCallbacks(this);
                        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.notification.banner.AbsBannerNotification.3.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AbsBannerNotification.this.disappearPushNotification();
                                AbsBannerNotification.this.startTargetActivityWithBannerNotificationResult(true, "");
                            }
                        });
                    }
                });
            } catch (Exception e) {
                Logger.m272e("IBannerNotification", "error when show jump to target activity ", e);
                AbsBannerNotification.this.startTargetActivityWithBannerNotificationResult(false, "exception:" + e.getLocalizedMessage());
            }
        }
    }

    protected View.OnClickListener getBannerOnClickListener() {
        return new ViewOnClickListenerC03983();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTargetActivityWithBannerNotificationResult(boolean z, String str) {
        Log.m148d("IBannerNotification", "startTargetActivityWithBannerNotificationResult: startSuccess is " + z + " errMsg is " + str);
        if (this.mPushNotificationExtra.mIBannerNotificationListener != null) {
            this.mPushNotificationExtra.mIBannerNotificationListener.onStartTargetActivityResult(z, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disappearPushNotification() {
        try {
            ((NotificationManager) this.mContext.getSystemService("notification")).cancel(this.mNotificationTag, this.mNotificationId);
        } catch (Throwable unused) {
        }
    }
}
