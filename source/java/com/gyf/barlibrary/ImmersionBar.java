package com.gyf.barlibrary;

import android.app.Activity;
import android.app.Dialog;
import android.database.ContentObserver;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.lynx.tasm.animation.AnimationConstant;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ImmersionBar {
    private static final int BOUNDARY_COLOR = -4539718;
    private static final int FLAG_FITS_DEFAULT = 0;
    private static final int FLAG_FITS_STATUS = 3;
    private static final int FLAG_FITS_SYSTEM_WINDOWS = 4;
    private static final int FLAG_FITS_TITLE = 1;
    private static final int FLAG_FITS_TITLE_MARGIN_TOP = 2;
    private static final String MIUI_NAVIGATION_BAR_DARK = "EXTRA_FLAG_NAVIGATION_BAR_DARK_MODE";
    private static final String MIUI_STATUS_BAR_DARK = "EXTRA_FLAG_STATUS_BAR_DARK_MODE";
    private static final String NAVIGATIONBAR_IS_MIN = "navigationbar_is_min";
    private Activity mActivity;
    private BarConfig mBarConfig;
    private BarParams mBarParams;
    private ViewGroup mContentView;
    private ViewGroup mDecorView;
    private Dialog mDialog;
    private FitsKeyboard mFitsKeyboard;
    private int mFitsStatusBarType;
    private Fragment mFragment;
    private boolean mHasNavigationBarColor;
    private String mImmersionBarName;
    private boolean mIsFitsLayoutOverlap;
    private boolean mIsFitsNotch;
    private boolean mIsFragment;
    private int mNavigationBarHeight;
    private int mNavigationBarWidth;
    private ContentObserver mNavigationObserver;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private Map<String, BarParams> mTagMap;
    private Window mWindow;
    private static final int IMMERSION_STATUS_BAR_VIEW = C0866R.id.immersion_status_bar_view;
    private static final int IMMERSION_NAVIGATION_BAR_VIEW = C0866R.id.immersion_navigation_bar_view;
    private static Map<String, ImmersionBar> mImmersionBarMap = new HashMap();

    private ImmersionBar(Activity activity) {
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mIsFragment = false;
        this.mNavigationObserver = null;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mIsFitsLayoutOverlap = false;
        this.mFitsStatusBarType = 0;
        this.mHasNavigationBarColor = false;
        this.mIsFitsNotch = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mActivity = activity;
        this.mWindow = activity.getWindow();
        this.mImmersionBarName = this.mActivity.toString();
        this.mBarParams = new BarParams();
        ViewGroup viewGroup = (ViewGroup) this.mWindow.getDecorView();
        this.mDecorView = viewGroup;
        this.mContentView = (ViewGroup) viewGroup.findViewById(android.R.id.content);
    }

    private ImmersionBar(Fragment fragment) {
        this((Activity) fragment.getActivity(), fragment);
    }

    private ImmersionBar(Activity activity, Fragment fragment) {
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mIsFragment = false;
        this.mNavigationObserver = null;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mIsFitsLayoutOverlap = false;
        this.mFitsStatusBarType = 0;
        this.mHasNavigationBarColor = false;
        this.mIsFitsNotch = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mActivity = activity;
        this.mFragment = fragment;
        if (activity == null) {
            throw new IllegalArgumentException("Activity cannot be null!!!");
        }
        if (mImmersionBarMap.get(activity.toString()) == null) {
            throw new IllegalArgumentException("you should initialize ImmersionBar in Activity first if used in Fragment");
        }
        this.mIsFragment = true;
        this.mWindow = this.mActivity.getWindow();
        this.mImmersionBarName = activity.toString() + fragment.toString();
        initParams();
    }

    private ImmersionBar(DialogFragment dialogFragment) {
        this(dialogFragment, dialogFragment.getDialog());
    }

    private ImmersionBar(DialogFragment dialogFragment, Dialog dialog) {
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mIsFragment = false;
        this.mNavigationObserver = null;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mIsFitsLayoutOverlap = false;
        this.mFitsStatusBarType = 0;
        this.mHasNavigationBarColor = false;
        this.mIsFitsNotch = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        FragmentActivity activity = dialogFragment.getActivity();
        this.mActivity = activity;
        this.mFragment = dialogFragment;
        this.mDialog = dialog;
        if (activity == null) {
            throw new IllegalArgumentException("Activity cannot be null!!!");
        }
        if (dialog == null) {
            throw new IllegalArgumentException("dialog in DialogFragment cannot be null");
        }
        if (mImmersionBarMap.get(activity.toString()) == null) {
            throw new IllegalArgumentException("you should initialize ImmersionBar in Activity first if used in Fragment");
        }
        this.mWindow = this.mDialog.getWindow();
        this.mImmersionBarName = this.mActivity.toString() + dialogFragment.toString();
        initParams();
    }

    private ImmersionBar(Activity activity, Dialog dialog) {
        this(activity, dialog, "");
    }

    private ImmersionBar(Activity activity, Dialog dialog, String str) {
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mIsFragment = false;
        this.mNavigationObserver = null;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mIsFitsLayoutOverlap = false;
        this.mFitsStatusBarType = 0;
        this.mHasNavigationBarColor = false;
        this.mIsFitsNotch = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mActivity = activity;
        this.mDialog = dialog;
        if (activity == null) {
            throw new IllegalArgumentException("Activity cannot be null!!!");
        }
        if (dialog == null) {
            throw new IllegalArgumentException("dialog cannot be null");
        }
        if (mImmersionBarMap.get(activity.toString()) == null) {
            throw new IllegalArgumentException("you should initialize ImmersionBar in Activity first if used in Fragment");
        }
        this.mWindow = this.mDialog.getWindow();
        this.mImmersionBarName = activity.toString() + dialog.toString() + str;
        initParams();
    }

    private void initParams() {
        this.mBarParams = new BarParams();
        ViewGroup viewGroup = (ViewGroup) this.mWindow.getDecorView();
        this.mDecorView = viewGroup;
        this.mContentView = (ViewGroup) viewGroup.findViewById(android.R.id.content);
    }

    public static ImmersionBar with(Activity activity) {
        ImmersionBar immersionBar = mImmersionBarMap.get(activity.toString());
        if (immersionBar != null) {
            return immersionBar;
        }
        ImmersionBar immersionBar2 = new ImmersionBar(activity);
        mImmersionBarMap.put(activity.toString(), immersionBar2);
        return immersionBar2;
    }

    public static ImmersionBar with(Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException("Activity cannot be null!!!");
        }
        ImmersionBar immersionBar = mImmersionBarMap.get(fragment.getActivity().toString() + fragment.toString());
        if (immersionBar != null) {
            return immersionBar;
        }
        ImmersionBar immersionBar2 = new ImmersionBar(fragment);
        mImmersionBarMap.put(fragment.getActivity().toString() + fragment.toString(), immersionBar2);
        return immersionBar2;
    }

    public static ImmersionBar with(Activity activity, Fragment fragment) {
        ImmersionBar immersionBar = mImmersionBarMap.get(activity.toString() + fragment.toString());
        if (immersionBar != null) {
            return immersionBar;
        }
        ImmersionBar immersionBar2 = new ImmersionBar(activity, fragment);
        mImmersionBarMap.put(activity.toString() + fragment.toString(), immersionBar2);
        return immersionBar2;
    }

    public static ImmersionBar with(DialogFragment dialogFragment) {
        if (dialogFragment.getActivity() == null) {
            throw new IllegalArgumentException("Activity cannot be null!!!");
        }
        ImmersionBar immersionBar = mImmersionBarMap.get(dialogFragment.getActivity().toString() + dialogFragment.toString());
        if (immersionBar != null) {
            return immersionBar;
        }
        ImmersionBar immersionBar2 = new ImmersionBar(dialogFragment);
        mImmersionBarMap.put(dialogFragment.getActivity().toString() + dialogFragment.toString(), immersionBar2);
        return immersionBar2;
    }

    @Deprecated
    public static ImmersionBar with(DialogFragment dialogFragment, Dialog dialog) {
        if (dialogFragment.getActivity() == null) {
            throw new IllegalArgumentException("Activity cannot be null!!!");
        }
        ImmersionBar immersionBar = mImmersionBarMap.get(dialogFragment.getActivity().toString() + dialogFragment.toString());
        if (immersionBar != null) {
            return immersionBar;
        }
        ImmersionBar immersionBar2 = new ImmersionBar(dialogFragment, dialog);
        mImmersionBarMap.put(dialogFragment.getActivity().toString() + dialogFragment.toString(), immersionBar2);
        return immersionBar2;
    }

    public static ImmersionBar with(Activity activity, Dialog dialog) {
        ImmersionBar immersionBar = mImmersionBarMap.get(activity.toString() + dialog.toString());
        if (immersionBar != null) {
            return immersionBar;
        }
        ImmersionBar immersionBar2 = new ImmersionBar(activity, dialog);
        mImmersionBarMap.put(activity.toString() + dialog.toString(), immersionBar2);
        return immersionBar2;
    }

    @Deprecated
    public static ImmersionBar with(Activity activity, Dialog dialog, String str) {
        ImmersionBar immersionBar = mImmersionBarMap.get(activity.toString() + dialog.toString() + str);
        if (immersionBar != null) {
            return immersionBar;
        }
        ImmersionBar immersionBar2 = new ImmersionBar(activity, dialog, str);
        mImmersionBarMap.put(activity.toString() + dialog.toString() + str, immersionBar2);
        return immersionBar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int destroyAll(String str) {
        int i = 0;
        try {
            Iterator<Map.Entry<String, ImmersionBar>> it = mImmersionBarMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, ImmersionBar> next = it.next();
                if (next.getKey().startsWith(str)) {
                    i++;
                    next.getValue().cancelListener();
                    it.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public ImmersionBar transparentStatusBar() {
        this.mBarParams.statusBarColor = 0;
        return this;
    }

    public ImmersionBar transparentNavigationBar() {
        this.mBarParams.navigationBarColor = 0;
        this.mBarParams.useDefaultNavigationBarColor = false;
        this.mBarParams.fullScreen = true;
        return this;
    }

    public ImmersionBar transparentBar() {
        this.mBarParams.statusBarColor = 0;
        this.mBarParams.navigationBarColor = 0;
        this.mBarParams.useDefaultNavigationBarColor = false;
        this.mBarParams.fullScreen = true;
        return this;
    }

    public ImmersionBar statusBarColor(int i) {
        return statusBarColorInt(ContextCompat.getColor(this.mActivity, i));
    }

    public ImmersionBar statusBarColor(int i, float f) {
        return statusBarColorInt(ContextCompat.getColor(this.mActivity, i), f);
    }

    public ImmersionBar statusBarColor(int i, int i2, float f) {
        return statusBarColorInt(ContextCompat.getColor(this.mActivity, i), ContextCompat.getColor(this.mActivity, i2), f);
    }

    public ImmersionBar statusBarColor(String str) {
        return statusBarColorInt(Color.parseColor(str));
    }

    public ImmersionBar statusBarColor(String str, float f) {
        return statusBarColorInt(Color.parseColor(str), f);
    }

    public ImmersionBar statusBarColor(String str, String str2, float f) {
        return statusBarColorInt(Color.parseColor(str), Color.parseColor(str2), f);
    }

    public ImmersionBar statusBarColorInt(int i) {
        this.mBarParams.statusBarColor = i;
        return this;
    }

    public ImmersionBar statusBarColorInt(int i, float f) {
        this.mBarParams.statusBarColor = i;
        this.mBarParams.statusBarAlpha = f;
        return this;
    }

    public ImmersionBar statusBarColorInt(int i, int i2, float f) {
        this.mBarParams.statusBarColor = i;
        this.mBarParams.statusBarColorTransform = i2;
        this.mBarParams.statusBarAlpha = f;
        return this;
    }

    public ImmersionBar navigationBarColor(int i) {
        return navigationBarColorInt(ContextCompat.getColor(this.mActivity, i));
    }

    public ImmersionBar navigationBarColor(int i, float f) {
        return navigationBarColorInt(ContextCompat.getColor(this.mActivity, i), f);
    }

    public ImmersionBar navigationBarColor(int i, int i2, float f) {
        return navigationBarColorInt(ContextCompat.getColor(this.mActivity, i), ContextCompat.getColor(this.mActivity, i2), f);
    }

    public ImmersionBar navigationBarColor(String str) {
        return navigationBarColorInt(Color.parseColor(str));
    }

    public ImmersionBar navigationBarColor(String str, float f) {
        return navigationBarColorInt(Color.parseColor(str), f);
    }

    public ImmersionBar navigationBarColor(String str, String str2, float f) {
        return navigationBarColorInt(Color.parseColor(str), Color.parseColor(str2), f);
    }

    public ImmersionBar navigationBarColorInt(int i) {
        this.mBarParams.navigationBarColor = i;
        this.mBarParams.useDefaultNavigationBarColor = false;
        return this;
    }

    public ImmersionBar navigationBarColorInt(int i, float f) {
        this.mBarParams.navigationBarColor = i;
        this.mBarParams.useDefaultNavigationBarColor = false;
        this.mBarParams.navigationBarAlpha = f;
        return this;
    }

    public ImmersionBar navigationBarColorInt(int i, int i2, float f) {
        this.mBarParams.navigationBarColor = i;
        this.mBarParams.useDefaultNavigationBarColor = false;
        this.mBarParams.navigationBarColorTransform = i2;
        this.mBarParams.navigationBarAlpha = f;
        return this;
    }

    public ImmersionBar barColor(int i) {
        return barColorInt(ContextCompat.getColor(this.mActivity, i));
    }

    public ImmersionBar barColor(int i, float f) {
        return barColorInt(ContextCompat.getColor(this.mActivity, i), i);
    }

    public ImmersionBar barColor(int i, int i2, float f) {
        return barColorInt(ContextCompat.getColor(this.mActivity, i), ContextCompat.getColor(this.mActivity, i2), f);
    }

    public ImmersionBar barColor(String str) {
        return barColorInt(Color.parseColor(str));
    }

    public ImmersionBar barColor(String str, float f) {
        return barColorInt(Color.parseColor(str), f);
    }

    public ImmersionBar barColor(String str, String str2, float f) {
        return barColorInt(Color.parseColor(str), Color.parseColor(str2), f);
    }

    public ImmersionBar barColorInt(int i) {
        this.mBarParams.statusBarColor = i;
        this.mBarParams.navigationBarColor = i;
        this.mBarParams.useDefaultNavigationBarColor = false;
        return this;
    }

    public ImmersionBar barColorInt(int i, float f) {
        this.mBarParams.statusBarColor = i;
        this.mBarParams.navigationBarColor = i;
        this.mBarParams.useDefaultNavigationBarColor = false;
        this.mBarParams.statusBarAlpha = f;
        this.mBarParams.navigationBarAlpha = f;
        return this;
    }

    public ImmersionBar barColorInt(int i, int i2, float f) {
        this.mBarParams.statusBarColor = i;
        this.mBarParams.navigationBarColor = i;
        this.mBarParams.useDefaultNavigationBarColor = false;
        this.mBarParams.statusBarColorTransform = i2;
        this.mBarParams.navigationBarColorTransform = i2;
        this.mBarParams.statusBarAlpha = f;
        this.mBarParams.navigationBarAlpha = f;
        return this;
    }

    public ImmersionBar statusBarColorTransform(int i) {
        return statusBarColorTransformInt(ContextCompat.getColor(this.mActivity, i));
    }

    public ImmersionBar statusBarColorTransform(String str) {
        return statusBarColorTransformInt(Color.parseColor(str));
    }

    public ImmersionBar statusBarColorTransformInt(int i) {
        this.mBarParams.statusBarColorTransform = i;
        return this;
    }

    public ImmersionBar navigationBarColorTransform(int i) {
        return navigationBarColorTransformInt(ContextCompat.getColor(this.mActivity, i));
    }

    public ImmersionBar navigationBarColorTransform(String str) {
        return navigationBarColorTransformInt(Color.parseColor(str));
    }

    public ImmersionBar navigationBarColorTransformInt(int i) {
        this.mBarParams.navigationBarColorTransform = i;
        return this;
    }

    public ImmersionBar barColorTransform(int i) {
        return barColorTransformInt(ContextCompat.getColor(this.mActivity, i));
    }

    public ImmersionBar barColorTransform(String str) {
        return barColorTransformInt(Color.parseColor(str));
    }

    public ImmersionBar barColorTransformInt(int i) {
        this.mBarParams.statusBarColorTransform = i;
        this.mBarParams.navigationBarColorTransform = i;
        return this;
    }

    public ImmersionBar addViewSupportTransformColor(View view) {
        return addViewSupportTransformColorInt(view, this.mBarParams.statusBarColorTransform);
    }

    public ImmersionBar addViewSupportTransformColor(View view, int i) {
        return addViewSupportTransformColorInt(view, ContextCompat.getColor(this.mActivity, i));
    }

    public ImmersionBar addViewSupportTransformColor(View view, int i, int i2) {
        return addViewSupportTransformColorInt(view, ContextCompat.getColor(this.mActivity, i), ContextCompat.getColor(this.mActivity, i2));
    }

    public ImmersionBar addViewSupportTransformColor(View view, String str) {
        return addViewSupportTransformColorInt(view, Color.parseColor(str));
    }

    public ImmersionBar addViewSupportTransformColor(View view, String str, String str2) {
        return addViewSupportTransformColorInt(view, Color.parseColor(str), Color.parseColor(str2));
    }

    public ImmersionBar addViewSupportTransformColorInt(View view, int i) {
        if (view == null) {
            throw new IllegalArgumentException("view cannot be null");
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(this.mBarParams.statusBarColor), Integer.valueOf(i));
        this.mBarParams.viewMap.put(view, hashMap);
        return this;
    }

    public ImmersionBar addViewSupportTransformColorInt(View view, int i, int i2) {
        if (view == null) {
            throw new IllegalArgumentException("view cannot be null");
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(i), Integer.valueOf(i2));
        this.mBarParams.viewMap.put(view, hashMap);
        return this;
    }

    public ImmersionBar viewAlpha(float f) {
        this.mBarParams.viewAlpha = f;
        return this;
    }

    public ImmersionBar removeSupportView(View view) {
        if (view == null) {
            throw new IllegalArgumentException("view cannot be null");
        }
        Map<Integer, Integer> map = this.mBarParams.viewMap.get(view);
        if (map != null && map.size() != 0) {
            this.mBarParams.viewMap.remove(view);
        }
        return this;
    }

    public ImmersionBar removeSupportAllView() {
        if (this.mBarParams.viewMap.size() != 0) {
            this.mBarParams.viewMap.clear();
        }
        return this;
    }

    public ImmersionBar fullScreen(boolean z) {
        this.mBarParams.fullScreen = z;
        return this;
    }

    public ImmersionBar statusBarAlpha(float f) {
        this.mBarParams.statusBarAlpha = f;
        return this;
    }

    public ImmersionBar navigationBarAlpha(float f) {
        this.mBarParams.navigationBarAlpha = f;
        return this;
    }

    public ImmersionBar barAlpha(float f) {
        this.mBarParams.statusBarAlpha = f;
        this.mBarParams.navigationBarAlpha = f;
        return this;
    }

    public ImmersionBar autoDarkModeEnable(boolean z) {
        return autoDarkModeEnable(z, 0.2f);
    }

    public ImmersionBar autoDarkModeEnable(boolean z, float f) {
        this.mBarParams.autoStatusBarDarkModeEnable = z;
        this.mBarParams.autoStatusBarDarkModeAlpha = f;
        this.mBarParams.autoNavigationBarDarkModeEnable = z;
        this.mBarParams.autoNavigationBarDarkModeAlpha = f;
        return this;
    }

    public ImmersionBar autoStatusBarDarkModeEnable(boolean z) {
        return autoStatusBarDarkModeEnable(z, 0.2f);
    }

    public ImmersionBar autoStatusBarDarkModeEnable(boolean z, float f) {
        this.mBarParams.autoStatusBarDarkModeEnable = z;
        this.mBarParams.autoStatusBarDarkModeAlpha = f;
        return this;
    }

    public ImmersionBar autoNavigationBarDarkModeEnable(boolean z) {
        return autoNavigationBarDarkModeEnable(z, 0.2f);
    }

    public ImmersionBar autoNavigationBarDarkModeEnable(boolean z, float f) {
        this.mBarParams.autoNavigationBarDarkModeEnable = z;
        this.mBarParams.autoNavigationBarDarkModeAlpha = f;
        return this;
    }

    public ImmersionBar statusBarDarkFont(boolean z) {
        return statusBarDarkFont(z, 0.2f);
    }

    public ImmersionBar statusBarDarkFont(boolean z, float f) {
        this.mBarParams.statusBarDarkFont = z;
        if (z && !isSupportStatusBarDarkFont()) {
            this.mBarParams.statusBarAlpha = f;
        } else {
            this.mBarParams.flymeOSStatusBarFontColor = 0;
            this.mBarParams.statusBarAlpha = 0.0f;
        }
        return this;
    }

    public ImmersionBar navigationBarDarkIcon(boolean z) {
        return navigationBarDarkIcon(z, 0.2f);
    }

    public ImmersionBar navigationBarDarkIcon(boolean z, float f) {
        this.mBarParams.navigationBarDarkIcon = z;
        if (z && !isSupportNavigationIconDark()) {
            this.mBarParams.navigationBarAlpha = f;
        } else {
            this.mBarParams.navigationBarAlpha = 0.0f;
        }
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColor(int i) {
        this.mBarParams.flymeOSStatusBarFontColor = ContextCompat.getColor(this.mActivity, i);
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColor(String str) {
        this.mBarParams.flymeOSStatusBarFontColor = Color.parseColor(str);
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColorInt(int i) {
        this.mBarParams.flymeOSStatusBarFontColor = i;
        return this;
    }

    public ImmersionBar hideBar(BarHide barHide) {
        this.mBarParams.barHide = barHide;
        if (OSUtils.isEMUI3_x()) {
            this.mBarParams.useDefaultNavigationBarColor = false;
            if (this.mBarParams.barHide == BarHide.FLAG_HIDE_NAVIGATION_BAR || this.mBarParams.barHide == BarHide.FLAG_HIDE_BAR) {
                this.mBarParams.hideNavigationBar = true;
            } else {
                this.mBarParams.hideNavigationBar = false;
            }
        }
        return this;
    }

    public ImmersionBar fitsSystemWindows(boolean z) {
        this.mBarParams.fits = z;
        if (this.mBarParams.fits) {
            if (this.mFitsStatusBarType == 0) {
                this.mFitsStatusBarType = 4;
            }
        } else {
            this.mFitsStatusBarType = 0;
        }
        return this;
    }

    public ImmersionBar fitsSystemWindows(boolean z, int i) {
        return fitsSystemWindowsInt(z, ContextCompat.getColor(this.mActivity, i));
    }

    public ImmersionBar fitsSystemWindows(boolean z, int i, int i2, float f) {
        return fitsSystemWindowsInt(z, ContextCompat.getColor(this.mActivity, i), ContextCompat.getColor(this.mActivity, i2), f);
    }

    public ImmersionBar fitsSystemWindowsInt(boolean z, int i) {
        return fitsSystemWindowsInt(z, i, -16777216, 0.0f);
    }

    public ImmersionBar fitsSystemWindowsInt(boolean z, int i, int i2, float f) {
        this.mBarParams.fits = z;
        this.mBarParams.contentColor = i;
        this.mBarParams.contentColorTransform = i2;
        this.mBarParams.contentAlpha = f;
        if (this.mBarParams.fits) {
            if (this.mFitsStatusBarType == 0) {
                this.mFitsStatusBarType = 4;
            }
        } else {
            this.mFitsStatusBarType = 0;
        }
        this.mContentView.setBackgroundColor(ColorUtils.blendARGB(this.mBarParams.contentColor, this.mBarParams.contentColorTransform, this.mBarParams.contentAlpha));
        return this;
    }

    public ImmersionBar statusBarView(View view) {
        if (view == null) {
            return this;
        }
        this.mBarParams.statusBarView = view;
        if (this.mFitsStatusBarType == 0) {
            this.mFitsStatusBarType = 3;
        }
        return this;
    }

    public ImmersionBar statusBarView(int i) {
        return statusBarView(this.mActivity.findViewById(i));
    }

    public ImmersionBar statusBarView(int i, View view) {
        return statusBarView(view.findViewById(i));
    }

    public ImmersionBar supportActionBar(boolean z) {
        this.mBarParams.isSupportActionBar = z;
        return this;
    }

    public ImmersionBar titleBar(View view) {
        return view == null ? this : titleBar(view, true);
    }

    public ImmersionBar titleBar(View view, boolean z) {
        if (view == null) {
            return this;
        }
        if (this.mFitsStatusBarType == 0) {
            this.mFitsStatusBarType = 1;
        }
        this.mBarParams.titleBarView = view;
        this.mBarParams.statusBarColorEnabled = z;
        return this;
    }

    public ImmersionBar titleBar(int i) {
        return titleBar(i, true);
    }

    public ImmersionBar titleBar(int i, boolean z) {
        Fragment fragment = this.mFragment;
        if (fragment != null && fragment.getView() != null) {
            return titleBar(this.mFragment.getView().findViewById(i), z);
        }
        return titleBar(this.mActivity.findViewById(i), z);
    }

    public ImmersionBar titleBar(int i, View view) {
        return titleBar(view.findViewById(i), true);
    }

    public ImmersionBar titleBar(int i, View view, boolean z) {
        return titleBar(view.findViewById(i), z);
    }

    public ImmersionBar titleBarMarginTop(int i) {
        Fragment fragment = this.mFragment;
        if (fragment != null && fragment.getView() != null) {
            return titleBarMarginTop(this.mFragment.getView().findViewById(i));
        }
        return titleBarMarginTop(this.mActivity.findViewById(i));
    }

    public ImmersionBar titleBarMarginTop(int i, View view) {
        return titleBarMarginTop(view.findViewById(i));
    }

    public ImmersionBar titleBarMarginTop(View view) {
        if (view == null) {
            return this;
        }
        if (this.mFitsStatusBarType == 0) {
            this.mFitsStatusBarType = 2;
        }
        this.mBarParams.titleBarView = view;
        return this;
    }

    public ImmersionBar statusBarColorTransformEnable(boolean z) {
        this.mBarParams.statusBarColorEnabled = z;
        return this;
    }

    public ImmersionBar reset() {
        this.mBarParams = new BarParams();
        this.mFitsStatusBarType = 0;
        return this;
    }

    public ImmersionBar addTag(String str) {
        if (isEmpty(str)) {
            throw new IllegalArgumentException("tag cannot be null");
        }
        this.mTagMap.put(str, this.mBarParams.m2807clone());
        return this;
    }

    public ImmersionBar getTag(String str) {
        if (isEmpty(str)) {
            throw new IllegalArgumentException("tag cannot be null");
        }
        BarParams barParams = this.mTagMap.get(str);
        if (barParams != null) {
            this.mBarParams = barParams.m2807clone();
        }
        return this;
    }

    public ImmersionBar keyboardEnable(boolean z) {
        return keyboardEnable(z, this.mBarParams.keyboardMode);
    }

    public ImmersionBar keyboardEnable(boolean z, int i) {
        this.mBarParams.keyboardEnable = z;
        this.mBarParams.keyboardMode = i;
        return this;
    }

    public ImmersionBar keyboardMode(int i) {
        this.mBarParams.keyboardMode = i;
        return this;
    }

    public ImmersionBar setOnKeyboardListener(OnKeyboardListener onKeyboardListener) {
        if (this.mBarParams.onKeyboardListener == null) {
            this.mBarParams.onKeyboardListener = onKeyboardListener;
        }
        return this;
    }

    public ImmersionBar navigationBarEnable(boolean z) {
        this.mBarParams.navigationBarEnable = z;
        return this;
    }

    public ImmersionBar navigationBarWithKitkatEnable(boolean z) {
        this.mBarParams.navigationBarWithKitkatEnable = z;
        return this;
    }

    public ImmersionBar navigationBarWithEMUI3Enable(boolean z) {
        this.mBarParams.navigationBarWithEMUI3Enable = z;
        return this;
    }

    @Deprecated
    public ImmersionBar fixMarginAtBottom(boolean z) {
        this.mBarParams.fixMarginAtBottom = z;
        return this;
    }

    public void init() {
        updateBarParams();
        setBar();
        fitsLayoutOverlap();
        fitsKeyboard();
        transformView();
    }

    public void destroy() {
        cancelListener();
        Iterator<Map.Entry<String, ImmersionBar>> it = mImmersionBarMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, ImmersionBar> next = it.next();
            if (next.getKey().contains(this.mImmersionBarName) || next.getKey().equals(this.mImmersionBarName)) {
                it.remove();
            }
        }
    }

    private void updateBarParams() {
        ImmersionBar immersionBar;
        adjustDarkModeParams();
        if (OSUtils.isEMUI3_x() && this.mBarParams.navigationBarWithKitkatEnable) {
            BarParams barParams = this.mBarParams;
            barParams.navigationBarWithKitkatEnable = barParams.navigationBarWithEMUI3Enable;
        }
        this.mBarConfig = new BarConfig(this.mActivity);
        if (!this.mIsFragment || (immersionBar = mImmersionBarMap.get(this.mActivity.toString())) == null) {
            return;
        }
        immersionBar.mBarParams = this.mBarParams;
    }

    private void setBar() {
        checkNavigationBarInitialized();
        int i = 256;
        if (!OSUtils.isEMUI3_x()) {
            fitsNotchScreen();
            int statusBarDarkFont = setStatusBarDarkFont(initBarAboveLOLLIPOP(256));
            checkNavigationBarFlag();
            i = setNavigationIconDark(statusBarDarkFont);
        } else {
            initBarBelowLOLLIPOP();
        }
        int hideBar = hideBar(i);
        fitsWindows();
        this.mDecorView.setSystemUiVisibility(hideBar);
        if (OSUtils.isMIUI6Later()) {
            setMIUIBarDark(this.mWindow, MIUI_STATUS_BAR_DARK, this.mBarParams.statusBarDarkFont);
            if (this.mBarParams.navigationBarEnable) {
                setMIUIBarDark(this.mWindow, MIUI_NAVIGATION_BAR_DARK, this.mBarParams.navigationBarDarkIcon);
            }
        }
        if (OSUtils.isFlymeOS4Later()) {
            if (this.mBarParams.flymeOSStatusBarFontColor != 0) {
                FlymeOSStatusBarFontUtils.setStatusBarDarkIcon(this.mActivity, this.mBarParams.flymeOSStatusBarFontColor);
            } else {
                FlymeOSStatusBarFontUtils.setStatusBarDarkIcon(this.mActivity, this.mBarParams.statusBarDarkFont);
            }
        }
    }

    private void fitsNotchScreen() {
        if (Build.VERSION.SDK_INT < 28 || this.mIsFitsNotch) {
            return;
        }
        WindowManager.LayoutParams attributes = this.mWindow.getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        this.mWindow.setAttributes(attributes);
        this.mIsFitsNotch = true;
    }

    private void checkNavigationBarInitialized() {
        if (this.mBarParams.useDefaultNavigationBarColor) {
            this.mBarParams.navigationBarColor = this.mWindow.getNavigationBarColor();
        }
    }

    private void checkNavigationBarFlag() {
        if (Build.VERSION.SDK_INT < 26 || !this.mBarParams.useDefaultNavigationBarColor) {
            return;
        }
        this.mBarParams.navigationBarDarkIcon = (this.mWindow.getDecorView().getSystemUiVisibility() & 16) != 0;
    }

    private int initBarAboveLOLLIPOP(int i) {
        if (!this.mHasNavigationBarColor) {
            this.mBarParams.defaultNavigationBarColor = this.mWindow.getNavigationBarColor();
            this.mHasNavigationBarColor = true;
        }
        int i2 = i | 1024;
        if (this.mBarParams.fullScreen && this.mBarParams.navigationBarEnable) {
            i2 |= 512;
        }
        this.mWindow.clearFlags(67108864);
        if (this.mBarConfig.hasNavigationBar()) {
            this.mWindow.clearFlags(134217728);
        }
        this.mWindow.addFlags(Integer.MIN_VALUE);
        if (this.mBarParams.statusBarColorEnabled) {
            this.mWindow.setStatusBarColor(ColorUtils.blendARGB(this.mBarParams.statusBarColor, this.mBarParams.statusBarColorTransform, this.mBarParams.statusBarAlpha));
        } else {
            this.mWindow.setStatusBarColor(ColorUtils.blendARGB(this.mBarParams.statusBarColor, 0, this.mBarParams.statusBarAlpha));
        }
        if (this.mBarParams.navigationBarEnable) {
            this.mWindow.setNavigationBarColor(ColorUtils.blendARGB(this.mBarParams.navigationBarColor, this.mBarParams.navigationBarColorTransform, this.mBarParams.navigationBarAlpha));
        } else {
            this.mWindow.setNavigationBarColor(this.mBarParams.defaultNavigationBarColor);
        }
        return i2;
    }

    private void initBarBelowLOLLIPOP() {
        this.mWindow.addFlags(67108864);
        setupStatusBarView();
        if (this.mBarConfig.hasNavigationBar() || OSUtils.isEMUI3_x()) {
            if (this.mBarParams.navigationBarEnable && this.mBarParams.navigationBarWithKitkatEnable) {
                this.mWindow.addFlags(134217728);
            } else {
                this.mWindow.clearFlags(134217728);
            }
            if (this.mNavigationBarHeight == 0) {
                this.mNavigationBarHeight = this.mBarConfig.getNavigationBarHeight();
            }
            if (this.mNavigationBarWidth == 0) {
                this.mNavigationBarWidth = this.mBarConfig.getNavigationBarWidth();
            }
            setupNavBarView();
        }
    }

    private void setupStatusBarView() {
        ViewGroup viewGroup = this.mDecorView;
        int i = IMMERSION_STATUS_BAR_VIEW;
        View findViewById = viewGroup.findViewById(i);
        if (findViewById == null) {
            findViewById = new View(this.mActivity);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.mBarConfig.getStatusBarHeight());
            layoutParams.gravity = 48;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
            findViewById.setId(i);
            this.mDecorView.addView(findViewById);
        }
        if (this.mBarParams.statusBarColorEnabled) {
            findViewById.setBackgroundColor(ColorUtils.blendARGB(this.mBarParams.statusBarColor, this.mBarParams.statusBarColorTransform, this.mBarParams.statusBarAlpha));
        } else {
            findViewById.setBackgroundColor(ColorUtils.blendARGB(this.mBarParams.statusBarColor, 0, this.mBarParams.statusBarAlpha));
        }
    }

    private void setupNavBarView() {
        FrameLayout.LayoutParams layoutParams;
        ViewGroup viewGroup = this.mDecorView;
        int i = IMMERSION_NAVIGATION_BAR_VIEW;
        View findViewById = viewGroup.findViewById(i);
        if (findViewById == null) {
            findViewById = new View(this.mActivity);
            findViewById.setId(i);
            this.mDecorView.addView(findViewById);
        }
        if (this.mBarConfig.isNavigationAtBottom()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.mBarConfig.getNavigationBarHeight());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.mBarConfig.getNavigationBarWidth(), -1);
            layoutParams.gravity = 8388613;
        }
        findViewById.setLayoutParams(layoutParams);
        findViewById.setBackgroundColor(ColorUtils.blendARGB(this.mBarParams.navigationBarColor, this.mBarParams.navigationBarColorTransform, this.mBarParams.navigationBarAlpha));
        if (this.mBarParams.navigationBarEnable && this.mBarParams.navigationBarWithKitkatEnable && !this.mBarParams.hideNavigationBar) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
    }

    private void adjustDarkModeParams() {
        if (this.mBarParams.autoStatusBarDarkModeEnable) {
            statusBarDarkFont(this.mBarParams.statusBarColor != 0 && this.mBarParams.statusBarColor > BOUNDARY_COLOR, this.mBarParams.autoStatusBarDarkModeAlpha);
        }
        if (this.mBarParams.autoNavigationBarDarkModeEnable) {
            navigationBarDarkIcon(this.mBarParams.navigationBarColor != 0 && this.mBarParams.navigationBarColor > BOUNDARY_COLOR, this.mBarParams.autoNavigationBarDarkModeAlpha);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.gyf.barlibrary.ImmersionBar$3 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static /* synthetic */ class C08643 {
        static final /* synthetic */ int[] $SwitchMap$com$gyf$barlibrary$BarHide;

        static {
            int[] iArr = new int[BarHide.values().length];
            $SwitchMap$com$gyf$barlibrary$BarHide = iArr;
            try {
                iArr[BarHide.FLAG_HIDE_BAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$gyf$barlibrary$BarHide[BarHide.FLAG_HIDE_STATUS_BAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$gyf$barlibrary$BarHide[BarHide.FLAG_HIDE_NAVIGATION_BAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$gyf$barlibrary$BarHide[BarHide.FLAG_SHOW_BAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private int hideBar(int i) {
        int i2 = C08643.$SwitchMap$com$gyf$barlibrary$BarHide[this.mBarParams.barHide.ordinal()];
        if (i2 == 1) {
            i |= 518;
        } else if (i2 == 2) {
            i |= 1028;
        } else if (i2 == 3) {
            i |= 514;
        } else if (i2 == 4) {
            i |= 0;
        }
        return i | 4096;
    }

    private void fitsWindows() {
        if (!OSUtils.isEMUI3_x()) {
            fitsWindowsAboveLOLLIPOP();
            return;
        }
        fitsWindowsBelowLOLLIPOP();
        if (this.mIsFragment || !OSUtils.isEMUI3_x()) {
            return;
        }
        fitsWindowsEMUI();
    }

    private void fitsWindowsAboveLOLLIPOP() {
        if (checkFitsSystemWindows(this.mDecorView.findViewById(android.R.id.content))) {
            if (this.mBarParams.isSupportActionBar) {
                setPadding(0, this.mBarConfig.getActionBarHeight(), 0, 0);
            }
        } else {
            int statusBarHeight = (this.mBarParams.fits && this.mFitsStatusBarType == 4) ? this.mBarConfig.getStatusBarHeight() : 0;
            if (this.mBarParams.isSupportActionBar) {
                statusBarHeight = this.mBarConfig.getStatusBarHeight() + this.mBarConfig.getActionBarHeight();
            }
            setPadding(0, statusBarHeight, 0, 0);
        }
    }

    private void fitsWindowsBelowLOLLIPOP() {
        int i;
        int i2;
        if (checkFitsSystemWindows(this.mDecorView.findViewById(android.R.id.content))) {
            if (this.mBarParams.isSupportActionBar) {
                setPadding(0, this.mBarConfig.getActionBarHeight(), 0, 0);
                return;
            }
            return;
        }
        int statusBarHeight = (this.mBarParams.fits && this.mFitsStatusBarType == 4) ? this.mBarConfig.getStatusBarHeight() : 0;
        if (this.mBarParams.isSupportActionBar) {
            statusBarHeight = this.mBarConfig.getStatusBarHeight() + this.mBarConfig.getActionBarHeight();
        }
        if (this.mBarConfig.hasNavigationBar() && this.mBarParams.navigationBarEnable && this.mBarParams.navigationBarWithKitkatEnable) {
            if (this.mBarParams.fullScreen) {
                i = 0;
                i2 = 0;
            } else if (this.mBarConfig.isNavigationAtBottom()) {
                i2 = this.mBarConfig.getNavigationBarHeight();
                i = 0;
            } else {
                i = this.mBarConfig.getNavigationBarWidth();
                i2 = 0;
            }
            if (this.mBarParams.hideNavigationBar) {
                if (this.mBarConfig.isNavigationAtBottom()) {
                    i2 = 0;
                } else {
                    i = 0;
                }
            } else if (!this.mBarConfig.isNavigationAtBottom()) {
                i = this.mBarConfig.getNavigationBarWidth();
            }
        } else {
            i = 0;
            i2 = 0;
        }
        setPadding(0, statusBarHeight, i, i2);
    }

    private void fitsWindowsEMUI() {
        final View findViewById = this.mDecorView.findViewById(IMMERSION_NAVIGATION_BAR_VIEW);
        if (this.mBarParams.navigationBarEnable && this.mBarParams.navigationBarWithKitkatEnable) {
            if (findViewById == null || this.mNavigationObserver != null) {
                return;
            }
            this.mNavigationObserver = new ContentObserver(new Handler()) { // from class: com.gyf.barlibrary.ImmersionBar.1
                @Override // android.database.ContentObserver
                public void onChange(boolean z) {
                    int i;
                    int i2;
                    ImmersionBar.this.mBarConfig = new BarConfig(ImmersionBar.this.mActivity);
                    int paddingBottom = ImmersionBar.this.mContentView.getPaddingBottom();
                    int paddingRight = ImmersionBar.this.mContentView.getPaddingRight();
                    if (ImmersionBar.this.mActivity != null && ImmersionBar.this.mActivity.getContentResolver() != null) {
                        if (Settings.System.getInt(ImmersionBar.this.mActivity.getContentResolver(), ImmersionBar.NAVIGATIONBAR_IS_MIN, 0) == 1) {
                            findViewById.setVisibility(8);
                        } else {
                            findViewById.setVisibility(0);
                            if (!ImmersionBar.checkFitsSystemWindows(ImmersionBar.this.mDecorView.findViewById(android.R.id.content))) {
                                if (ImmersionBar.this.mNavigationBarHeight == 0) {
                                    ImmersionBar immersionBar = ImmersionBar.this;
                                    immersionBar.mNavigationBarHeight = immersionBar.mBarConfig.getNavigationBarHeight();
                                }
                                if (ImmersionBar.this.mNavigationBarWidth == 0) {
                                    ImmersionBar immersionBar2 = ImmersionBar.this;
                                    immersionBar2.mNavigationBarWidth = immersionBar2.mBarConfig.getNavigationBarWidth();
                                }
                                if (!ImmersionBar.this.mBarParams.hideNavigationBar) {
                                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) findViewById.getLayoutParams();
                                    if (ImmersionBar.this.mBarConfig.isNavigationAtBottom()) {
                                        layoutParams.gravity = 80;
                                        layoutParams.height = ImmersionBar.this.mNavigationBarHeight;
                                        i2 = !ImmersionBar.this.mBarParams.fullScreen ? ImmersionBar.this.mNavigationBarHeight : 0;
                                        i = 0;
                                    } else {
                                        layoutParams.gravity = 8388613;
                                        layoutParams.width = ImmersionBar.this.mNavigationBarWidth;
                                        i = !ImmersionBar.this.mBarParams.fullScreen ? ImmersionBar.this.mNavigationBarWidth : 0;
                                        i2 = 0;
                                    }
                                    findViewById.setLayoutParams(layoutParams);
                                    paddingBottom = i2;
                                    paddingRight = i;
                                }
                            }
                        }
                        paddingBottom = 0;
                        paddingRight = 0;
                    }
                    ImmersionBar immersionBar3 = ImmersionBar.this;
                    immersionBar3.setPadding(0, immersionBar3.mContentView.getPaddingTop(), paddingRight, paddingBottom);
                }
            };
            Activity activity = this.mActivity;
            if (activity == null || activity.getContentResolver() == null || this.mNavigationObserver == null) {
                return;
            }
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor(NAVIGATIONBAR_IS_MIN), true, this.mNavigationObserver);
            return;
        }
        findViewById.setVisibility(8);
    }

    private int setStatusBarDarkFont(int i) {
        return this.mBarParams.statusBarDarkFont ? i | AnimationConstant.PROP_COLOR : i;
    }

    private int setNavigationIconDark(int i) {
        return (Build.VERSION.SDK_INT < 26 || !this.mBarParams.navigationBarDarkIcon) ? i : i | 16;
    }

    private void setMIUIBarDark(Window window, String str, boolean z) {
        if (window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i = cls2.getField(str).getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                if (z) {
                    method.invoke(window, Integer.valueOf(i), Integer.valueOf(i));
                } else {
                    method.invoke(window, 0, Integer.valueOf(i));
                }
            } catch (Exception unused) {
            }
        }
    }

    private void fitsLayoutOverlap() {
        if (this.mIsFitsLayoutOverlap) {
            return;
        }
        int i = this.mFitsStatusBarType;
        if (i == 1) {
            setTitleBar(this.mActivity, this.mBarParams.titleBarView);
            this.mIsFitsLayoutOverlap = true;
        } else if (i == 2) {
            setTitleBarMarginTop(this.mActivity, this.mBarParams.titleBarView);
            this.mIsFitsLayoutOverlap = true;
        } else {
            if (i != 3) {
                return;
            }
            setStatusBarView(this.mActivity, this.mBarParams.statusBarView);
            this.mIsFitsLayoutOverlap = true;
        }
    }

    private void transformView() {
        if (this.mBarParams.viewMap.size() != 0) {
            for (Map.Entry<View, Map<Integer, Integer>> entry : this.mBarParams.viewMap.entrySet()) {
                View key = entry.getKey();
                Map<Integer, Integer> value = entry.getValue();
                Integer valueOf = Integer.valueOf(this.mBarParams.statusBarColor);
                Integer valueOf2 = Integer.valueOf(this.mBarParams.statusBarColorTransform);
                for (Map.Entry<Integer, Integer> entry2 : value.entrySet()) {
                    Integer key2 = entry2.getKey();
                    valueOf2 = entry2.getValue();
                    valueOf = key2;
                }
                if (key != null) {
                    if (Math.abs(this.mBarParams.viewAlpha - 0.0f) == 0.0f) {
                        key.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.mBarParams.statusBarAlpha));
                    } else {
                        key.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.mBarParams.viewAlpha));
                    }
                }
            }
        }
    }

    void cancelListener() {
        Activity activity = this.mActivity;
        if (activity != null) {
            if (this.mNavigationObserver != null) {
                activity.getContentResolver().unregisterContentObserver(this.mNavigationObserver);
                this.mNavigationObserver = null;
            }
            FitsKeyboard fitsKeyboard = this.mFitsKeyboard;
            if (fitsKeyboard != null) {
                fitsKeyboard.cancel();
                this.mFitsKeyboard = null;
            }
        }
    }

    private void fitsKeyboard() {
        if (!this.mIsFragment) {
            if (this.mBarParams.keyboardEnable) {
                if (this.mFitsKeyboard == null) {
                    this.mFitsKeyboard = new FitsKeyboard(this, this.mActivity, this.mWindow);
                }
                this.mFitsKeyboard.enable(this.mBarParams.keyboardMode);
                return;
            } else {
                FitsKeyboard fitsKeyboard = this.mFitsKeyboard;
                if (fitsKeyboard != null) {
                    fitsKeyboard.disable();
                    return;
                }
                return;
            }
        }
        ImmersionBar immersionBar = mImmersionBarMap.get(this.mActivity.toString());
        if (immersionBar != null) {
            if (immersionBar.mBarParams.keyboardEnable) {
                if (immersionBar.mFitsKeyboard == null) {
                    immersionBar.mFitsKeyboard = new FitsKeyboard(immersionBar, immersionBar.mActivity, immersionBar.mWindow);
                }
                immersionBar.mFitsKeyboard.enable(immersionBar.mBarParams.keyboardMode);
            } else {
                FitsKeyboard fitsKeyboard2 = immersionBar.mFitsKeyboard;
                if (fitsKeyboard2 != null) {
                    fitsKeyboard2.disable();
                }
            }
        }
    }

    public BarParams getBarParams() {
        return this.mBarParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPadding(int i, int i2, int i3, int i4) {
        ViewGroup viewGroup = this.mContentView;
        if (viewGroup != null) {
            viewGroup.setPadding(i, i2, i3, i4);
        }
        this.mPaddingLeft = i;
        this.mPaddingTop = i2;
        this.mPaddingRight = i3;
        this.mPaddingBottom = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPaddingRight() {
        return this.mPaddingRight;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public static boolean isSupportStatusBarDarkFont() {
        if (OSUtils.isMIUI6Later()) {
            return true;
        }
        OSUtils.isFlymeOS4Later();
        return true;
    }

    public static boolean isSupportNavigationIconDark() {
        return OSUtils.isMIUI6Later() || Build.VERSION.SDK_INT >= 26;
    }

    public static void setTitleBar(final Activity activity, final View view) {
        if (activity == null || view == null) {
            return;
        }
        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams.height == -2 || layoutParams.height == -1) {
            view.post(new Runnable() { // from class: com.gyf.barlibrary.ImmersionBar.2
                @Override // java.lang.Runnable
                public void run() {
                    layoutParams.height = view.getHeight() + ImmersionBar.getStatusBarHeight(activity);
                    View view2 = view;
                    view2.setPadding(view2.getPaddingLeft(), view.getPaddingTop() + ImmersionBar.getStatusBarHeight(activity), view.getPaddingRight(), view.getPaddingBottom());
                }
            });
        } else {
            layoutParams.height += getStatusBarHeight(activity);
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + getStatusBarHeight(activity), view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    public static void setTitleBarMarginTop(Activity activity, View view) {
        if (activity == null || view == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + getStatusBarHeight(activity), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
    }

    public static void setStatusBarView(Activity activity, View view) {
        if (activity == null || view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = getStatusBarHeight(activity);
        view.setLayoutParams(layoutParams);
    }

    public static void setFitsSystemWindows(Activity activity) {
        if (activity == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(android.R.id.content);
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof ViewGroup) && !(childAt instanceof DrawerLayout)) {
                childAt.setFitsSystemWindows(true);
                ((ViewGroup) childAt).setClipToPadding(true);
            }
        }
    }

    public static boolean checkFitsSystemWindows(View view) {
        if (view.getFitsSystemWindows()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (((childAt instanceof DrawerLayout) && checkFitsSystemWindows(childAt)) || childAt.getFitsSystemWindows()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasNavigationBar(Activity activity) {
        return new BarConfig(activity).hasNavigationBar();
    }

    public static int getNavigationBarHeight(Activity activity) {
        return new BarConfig(activity).getNavigationBarHeight();
    }

    public static int getNavigationBarWidth(Activity activity) {
        return new BarConfig(activity).getNavigationBarWidth();
    }

    public static boolean isNavigationAtBottom(Activity activity) {
        return new BarConfig(activity).isNavigationAtBottom();
    }

    public static int getStatusBarHeight(Activity activity) {
        return new BarConfig(activity).getStatusBarHeight();
    }

    public static int getActionBarHeight(Activity activity) {
        return new BarConfig(activity).getActionBarHeight();
    }

    public static boolean hasNotchScreen(Activity activity) {
        return new BarConfig(activity).hasNotchScreen();
    }

    public static boolean hasNotchScreen(View view) {
        return NotchUtils.hasNotchScreen(view);
    }

    public static void hideStatusBar(Window window) {
        window.setFlags(1024, 1024);
    }

    private static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }
}
