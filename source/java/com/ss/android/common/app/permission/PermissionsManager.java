package com.ss.android.common.app.permission;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.common.utility.DeviceUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.components.permissions_manager.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class PermissionsManager {
    private static final int FLAG_USE_IN_LITE = 1;
    private static final String TAG = "PermissionsManager";
    private static DialogBuilderProvider mDialogBuilderProvider;
    private static PermissionsManager mInstance;
    private static Map<String, Integer> sDescriptMap = new HashMap();
    private static volatile int sFlag;
    private NeverShowDialogHooker mNeverShowDialogHooker;
    private final Set<String> mPendingRequests = new HashSet(1);
    private final Set<String> mPermissions = new HashSet(1);
    private final List<WeakReference<PermissionsResultAction>> mPendingActions = new ArrayList(1);
    private final List<PermissionsResultAction> mPendingActionsForGc = new ArrayList(1);
    private final List<WeakReference<RequestPermissionResultListener>> mRequestPermissionResultListeners = new ArrayList();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static abstract class DialogBuilder {
        public abstract Dialog create();

        public abstract DialogBuilder setMessage(CharSequence charSequence);

        public abstract DialogBuilder setNegativeButton(int i, DialogInterface.OnClickListener onClickListener);

        public abstract DialogBuilder setPositiveButton(int i, DialogInterface.OnClickListener onClickListener);

        public abstract DialogBuilder setTitle(int i);

        public abstract DialogBuilder setTitle(CharSequence charSequence);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface DialogBuilderProvider {
        DialogBuilder createBuilder(Context context);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface NeverShowDialogHooker {
        boolean hook(Activity activity, String[] strArr, String[] strArr2, int[] iArr, String str);
    }

    public static void config(int i) {
        sFlag = i;
    }

    public static boolean useInLite() {
        return (sFlag & 1) == 1;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class DefaultDialogBuilder extends DialogBuilder {
        private AlertDialog.Builder builder;

        public DefaultDialogBuilder(Context context) {
            this.builder = new AlertDialog.Builder(context);
        }

        @Override // com.ss.android.common.app.permission.PermissionsManager.DialogBuilder
        public DialogBuilder setTitle(int i) {
            this.builder.setTitle(i);
            return this;
        }

        @Override // com.ss.android.common.app.permission.PermissionsManager.DialogBuilder
        public DialogBuilder setTitle(CharSequence charSequence) {
            this.builder.setTitle(charSequence);
            return this;
        }

        @Override // com.ss.android.common.app.permission.PermissionsManager.DialogBuilder
        public DialogBuilder setMessage(CharSequence charSequence) {
            this.builder.setMessage(charSequence);
            return this;
        }

        @Override // com.ss.android.common.app.permission.PermissionsManager.DialogBuilder
        public DialogBuilder setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            this.builder.setPositiveButton(i, onClickListener);
            return this;
        }

        @Override // com.ss.android.common.app.permission.PermissionsManager.DialogBuilder
        public DialogBuilder setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            this.builder.setNegativeButton(i, onClickListener);
            return this;
        }

        @Override // com.ss.android.common.app.permission.PermissionsManager.DialogBuilder
        public Dialog create() {
            return this.builder.create();
        }
    }

    public static void setDialogBuilderProvider(DialogBuilderProvider dialogBuilderProvider) {
        mDialogBuilderProvider = dialogBuilderProvider;
    }

    static {
        int i;
        int i2;
        if (useInLite()) {
            i = R.string.REQUEST_PERMISSION_DESCRIPT_LOCATION;
            i2 = R.string.REQUEST_PERMISSION_DESCRIPT_EXTERNAL_STORAGE_SPACE;
            sDescriptMap.put("android.permission.READ_CALENDAR", Integer.valueOf(R.string.REQUEST_PERMISSION_DESCRIPT_CALENDAR));
            sDescriptMap.put("android.permission.WRITE_CALENDAR", Integer.valueOf(R.string.REQUEST_PERMISSION_DESCRIPT_CALENDAR));
        } else {
            i = R.string.REQUEST_PERMISSION_DESCRIPT_LOCATION_INFO;
            i2 = R.string.REQUEST_PERMISSION_DESCRIPT_EXTERNAL_STORAGE;
            sDescriptMap.put("android.permission.ACCESS_FINE_LOCATION", Integer.valueOf(R.string.REQUEST_PERMISSION_DESCRIPT_LOCATION_INFO));
            sDescriptMap.put("android.permission.RECORD_AUDIO", Integer.valueOf(R.string.REQUEST_PERMISSION_DESCRIPT_RECORD_AUDIO));
            sDescriptMap.put("android.permission.READ_PHONE_STATE", Integer.valueOf(R.string.REQUEST_PERMISSION_DESCRIPT_READ_PHONE_STATE));
        }
        sDescriptMap.put("android.permission.ACCESS_COARSE_LOCATION", Integer.valueOf(i));
        sDescriptMap.put("android.permission.READ_SMS", Integer.valueOf(R.string.REQUEST_PERMISSION_DESCRIPT_SMS));
        sDescriptMap.put("android.permission.READ_CONTACTS", Integer.valueOf(R.string.REQUEST_PERMISSION_DESCRIPT_CONTACT));
        sDescriptMap.put("android.permission.CAMERA", Integer.valueOf(R.string.REQUEST_PERMISSION_DESCRIPT_CAMERA));
        sDescriptMap.put("android.permission.WRITE_EXTERNAL_STORAGE", Integer.valueOf(i2));
        useInLite();
        sDescriptMap.put("android.permission.READ_EXTERNAL_STORAGE", Integer.valueOf(i2));
    }

    public static PermissionsManager getInstance() {
        if (mInstance == null) {
            mInstance = new PermissionsManager();
        }
        return mInstance;
    }

    private PermissionsManager() {
        initializePermissionsMap();
    }

    private synchronized void initializePermissionsMap() {
        String str;
        for (Field field : Manifest.permission.class.getFields()) {
            try {
                str = (String) field.get("");
            } catch (IllegalAccessException e) {
                Log.e(TAG, "Could not access field", e);
                str = null;
            }
            this.mPermissions.add(str);
        }
    }

    private synchronized String[] getManifestPermissions(Activity activity) {
        ArrayList arrayList;
        PackageInfo packageInfo;
        String[] strArr;
        arrayList = new ArrayList(1);
        try {
            Logger.d(TAG, activity.getPackageName());
            packageInfo = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 4096);
        } catch (PackageManager.NameNotFoundException e) {
            Logger.e(TAG, "A problem occurred when retrieving permissions", e);
            packageInfo = null;
        }
        if (packageInfo != null && (strArr = packageInfo.requestedPermissions) != null) {
            for (String str : strArr) {
                Log.d(TAG, "Manifest contained permission: " + str);
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private synchronized void addPendingAction(String[] strArr, PermissionsResultAction permissionsResultAction) {
        if (permissionsResultAction == null) {
            return;
        }
        permissionsResultAction.registerPermissions(strArr);
        this.mPendingActionsForGc.add(permissionsResultAction);
        this.mPendingActions.add(new WeakReference<>(permissionsResultAction));
    }

    private synchronized void removePendingAction(PermissionsResultAction permissionsResultAction) {
        Iterator<WeakReference<PermissionsResultAction>> it = this.mPendingActions.iterator();
        while (it.hasNext()) {
            WeakReference<PermissionsResultAction> next = it.next();
            if (next.get() == permissionsResultAction || next.get() == null) {
                it.remove();
            }
        }
        Iterator<PermissionsResultAction> it2 = this.mPendingActionsForGc.iterator();
        while (it2.hasNext()) {
            if (it2.next() == permissionsResultAction) {
                it2.remove();
            }
        }
    }

    public synchronized boolean hasPermission(Context context, String str) {
        if (context == null) {
            return false;
        }
        if (DeviceUtils.isMiui()) {
            if (MIUIPermissionUtils.checkPermission(context, str) && (PermissionActivityCompat.checkSelfPermission(context, str) == 0 || !this.mPermissions.contains(str))) {
                r0 = true;
            }
            return r0;
        }
        return PermissionActivityCompat.checkSelfPermission(context, str) == 0 || !this.mPermissions.contains(str);
    }

    public synchronized boolean hasAllPermissions(Context context, String[] strArr) {
        if (context == null) {
            return false;
        }
        boolean z = true;
        for (String str : strArr) {
            z &= hasPermission(context, str);
        }
        return z;
    }

    public synchronized void requestAllManifestPermissionsIfNecessary(Activity activity, PermissionsResultAction permissionsResultAction) {
        if (activity == null) {
            return;
        }
        requestPermissionsIfNecessaryForResult(activity, getManifestPermissions(activity), permissionsResultAction);
    }

    public synchronized void requestPermissionsIfNecessaryForResult(Activity activity, String[] strArr, PermissionsResultAction permissionsResultAction) {
        if (activity == null) {
            return;
        }
        try {
            addPendingAction(strArr, permissionsResultAction);
            List<String> permissionsListToRequest = getPermissionsListToRequest(activity, strArr, permissionsResultAction);
            if (permissionsListToRequest.isEmpty()) {
                removePendingAction(permissionsResultAction);
            } else {
                String[] strArr2 = (String[]) permissionsListToRequest.toArray(new String[permissionsListToRequest.size()]);
                this.mPendingRequests.addAll(permissionsListToRequest);
                PermissionActivityCompat.requestPermissions(activity, strArr2, 1);
            }
        } finally {
        }
    }

    public synchronized void requestPermissionsIfNecessaryForResult(Fragment fragment, String[] strArr, PermissionsResultAction permissionsResultAction) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return;
        }
        try {
            addPendingAction(strArr, permissionsResultAction);
            List<String> permissionsListToRequest = getPermissionsListToRequest(activity, strArr, permissionsResultAction);
            if (permissionsListToRequest.isEmpty()) {
                removePendingAction(permissionsResultAction);
            } else {
                String[] strArr2 = (String[]) permissionsListToRequest.toArray(new String[permissionsListToRequest.size()]);
                this.mPendingRequests.addAll(permissionsListToRequest);
                fragment.requestPermissions(strArr2, 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized void requestPermissionsForMIUI7(Activity activity, String[] strArr, PermissionsResultAction permissionsResultAction) {
        if (activity == null) {
            return;
        }
        try {
            addPendingAction(strArr, permissionsResultAction);
            List<String> permissionsListToRequest = getPermissionsListToRequest(activity, strArr, permissionsResultAction);
            if (permissionsListToRequest.isEmpty()) {
                removePendingAction(permissionsResultAction);
            } else {
                String[] strArr2 = (String[]) permissionsListToRequest.toArray(new String[permissionsListToRequest.size()]);
                this.mPendingRequests.addAll(permissionsListToRequest);
                int length = strArr.length;
                int[] iArr = new int[length];
                for (int i = 0; i < length; i++) {
                    iArr[i] = -1;
                }
                String permissionTip = getPermissionTip(activity, permissionsListToRequest);
                if (!TextUtils.isEmpty(permissionTip)) {
                    handleNeverShowPermissionDialog(activity, strArr2, strArr2, iArr, permissionTip, new OkListener(activity, strArr, iArr, strArr2), new CancelListener(activity, strArr, iArr, strArr2));
                } else {
                    this.mNeverShowDialogHooker = null;
                    invokeAndClearPermissionResult(strArr, iArr, null);
                }
            }
        } finally {
        }
    }

    public synchronized void notifyPermissionsChange(Activity activity, String[] strArr, int[] iArr) {
        notifyPermissionsChange(activity, strArr, iArr, false);
    }

    public synchronized void notifyPermissionsChange(Activity activity, String[] strArr, int[] iArr, boolean z) {
        try {
            int i = 0;
            if (!useInLite()) {
                ArrayList arrayList = new ArrayList(3);
                int length = strArr.length;
                while (i < length) {
                    String str = strArr[i];
                    if (iArr[i] == -1 || (DeviceUtils.isMiui() && !MIUIPermissionUtils.checkPermission(activity, str))) {
                        if (iArr[i] != -1) {
                            iArr[i] = -1;
                        }
                        if (!ActivityCompat.shouldShowRequestPermissionRationale(activity, str) && sDescriptMap.containsKey(str)) {
                            arrayList.add(str);
                        }
                    }
                    i++;
                }
                if (!arrayList.isEmpty()) {
                    String permissionTip = getPermissionTip(activity, arrayList);
                    if (!TextUtils.isEmpty(permissionTip)) {
                        String[] strArr2 = (String[]) arrayList.toArray(new String[arrayList.size()]);
                        handleNeverShowPermissionDialog(activity, strArr, (String[]) arrayList.toArray(new String[arrayList.size()]), iArr, permissionTip, new OkListener(activity, strArr, iArr, strArr2), new CancelListener(activity, strArr, iArr, strArr2));
                        return;
                    }
                }
            } else if (z) {
                int length2 = strArr.length;
                while (true) {
                    if (i >= length2) {
                        break;
                    }
                    String str2 = strArr[i];
                    if (iArr[i] != -1 || ActivityCompat.shouldShowRequestPermissionRationale(activity, str2)) {
                        i++;
                    } else {
                        String requestDescription = getRequestDescription(activity, strArr);
                        if (!TextUtils.isEmpty(requestDescription)) {
                            handleNeverShowPermissionDialog(activity, strArr, null, iArr, requestDescription, new OkListener(activity, strArr, iArr, null), null);
                        }
                    }
                }
            }
            this.mNeverShowDialogHooker = null;
            invokeAndClearPermissionResult(strArr, iArr, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeAndClearPermissionResult(String[] strArr, int[] iArr, String[] strArr2) {
        int i;
        try {
            int length = strArr.length;
            if (iArr.length < length) {
                length = iArr.length;
            }
            Iterator<WeakReference<PermissionsResultAction>> it = this.mPendingActions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PermissionsResultAction permissionsResultAction = it.next().get();
                if (strArr2 == null || strArr2.length <= 0 || !(permissionsResultAction instanceof CustomPermissionsResultAction)) {
                    while (i < length) {
                        i = (permissionsResultAction == null || permissionsResultAction.onResult(strArr[i], iArr[i])) ? 0 : i + 1;
                        it.remove();
                        break;
                    }
                } else {
                    ((CustomPermissionsResultAction) permissionsResultAction).onCustomAction(strArr2);
                }
            }
            Iterator<PermissionsResultAction> it2 = this.mPendingActionsForGc.iterator();
            while (it2.hasNext()) {
                it2.next();
                it2.remove();
            }
            while (i < length) {
                this.mPendingRequests.remove(strArr[i]);
                i++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setNeverShowDialogHooker(NeverShowDialogHooker neverShowDialogHooker) {
        this.mNeverShowDialogHooker = neverShowDialogHooker;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static abstract class SimpleDialogListener implements DialogInterface.OnClickListener {
        protected Activity mActivity;
        protected String[] mCustomActionPermissions;
        protected String[] mPermissions;
        protected int[] mResults;

        public SimpleDialogListener(Activity activity, String[] strArr, int[] iArr, String[] strArr2) {
            this.mActivity = activity;
            this.mPermissions = strArr;
            this.mResults = iArr;
            this.mCustomActionPermissions = strArr2;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class OkListener extends SimpleDialogListener {
        public OkListener(Activity activity, String[] strArr, int[] iArr, String[] strArr2) {
            super(activity, strArr, iArr, strArr2);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (DeviceUtils.isMiui()) {
                MIUIPermissionUtils.startPermissionManager(this.mActivity);
            } else {
                try {
                    this.mActivity.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + this.mActivity.getPackageName())));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (PermissionsManager.useInLite()) {
                return;
            }
            PermissionsManager.this.invokeAndClearPermissionResult(this.mPermissions, this.mResults, this.mCustomActionPermissions);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class CancelListener extends SimpleDialogListener {
        public CancelListener(Activity activity, String[] strArr, int[] iArr, String[] strArr2) {
            super(activity, strArr, iArr, strArr2);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (PermissionsManager.useInLite()) {
                return;
            }
            PermissionsManager.this.invokeAndClearPermissionResult(this.mPermissions, this.mResults, null);
        }
    }

    public void handleNeverShowPermissionDialog(Activity activity, String[] strArr, String[] strArr2, int[] iArr, String str, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        if (activity == null || strArr == null || strArr.length <= 0) {
            return;
        }
        NeverShowDialogHooker neverShowDialogHooker = this.mNeverShowDialogHooker;
        if (neverShowDialogHooker != null) {
            boolean hook = neverShowDialogHooker.hook(activity, strArr, strArr2, iArr, str);
            this.mNeverShowDialogHooker = null;
            if (hook) {
                if (useInLite()) {
                    return;
                }
                invokeAndClearPermissionResult(strArr, iArr, null);
                return;
            }
        }
        try {
            showSimpleDialog(activity, str, onClickListener, onClickListener2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private String getPermissionTip(Context context, List<String> list) {
        if (list.isEmpty()) {
            return "";
        }
        char c = 0;
        if (list.size() > 1) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                int intValue = sDescriptMap.get(it.next()).intValue();
                if (intValue > 0) {
                    sb.append(context.getString(intValue)).append("、");
                }
            }
            int length = sb.length() - 1;
            if (length >= 0) {
                sb.deleteCharAt(length);
            }
            return context.getString(R.string.permission_multi_tip, sb.toString());
        }
        String str = list.get(0);
        try {
            switch (str.hashCode()) {
                case -1888586689:
                    if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -406040016:
                    if (str.equals("android.permission.READ_EXTERNAL_STORAGE")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -63024214:
                    if (str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -5573545:
                    if (str.equals("android.permission.READ_PHONE_STATE")) {
                        break;
                    }
                    c = 65535;
                    break;
                case 463403621:
                    if (str.equals("android.permission.CAMERA")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1365911975:
                    if (str.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 1831139720:
                    if (str.equals("android.permission.RECORD_AUDIO")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 1977429404:
                    if (str.equals("android.permission.READ_CONTACTS")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
        } catch (Exception unused) {
        }
        switch (c) {
            case 0:
                return Build.VERSION.SDK_INT >= 29 ? "" : context.getString(R.string.permission_device_id_tip);
            case 1:
            case 2:
                return context.getString(R.string.permission_location_tip);
            case 3:
                return context.getString(R.string.permission_contacts_tip);
            case 4:
                return context.getString(R.string.permission_camera_tip);
            case 5:
                return context.getString(R.string.permission_microphone_tip);
            case 6:
            case 7:
                return context.getString(R.string.permission_storage_tip);
            default:
                return "";
        }
    }

    public String getRequestDescription(Activity activity, String[] strArr) {
        int intValue;
        if (activity == null || strArr == null || strArr.length <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str : strArr) {
            if (!getInstance().hasPermission(activity, str) && (intValue = sDescriptMap.get(str).intValue()) > 0) {
                if (i == strArr.length - 1) {
                    sb.append(activity.getString(intValue));
                } else {
                    sb.append(activity.getString(intValue)).append("；");
                }
            }
            i++;
        }
        return String.format(activity.getResources().getString(R.string.REQUEST_PERMISSION_DENIED_DESCRIPTION), sb.toString());
    }

    private void doPermissionWorkBeforeAndroidM(Activity activity, String[] strArr, PermissionsResultAction permissionsResultAction) {
        boolean onResult;
        for (String str : strArr) {
            if (permissionsResultAction != null) {
                try {
                    if (!this.mPermissions.contains(str)) {
                        onResult = permissionsResultAction.onResult(str, Permissions.NOT_FOUND);
                    } else if (PermissionActivityCompat.checkSelfPermission(activity, str) != 0) {
                        onResult = permissionsResultAction.onResult(str, Permissions.DENIED);
                    } else {
                        onResult = permissionsResultAction.onResult(str, Permissions.GRANTED);
                    }
                    if (onResult) {
                        break;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        removePendingAction(permissionsResultAction);
    }

    private List<String> getPermissionsListToRequest(Activity activity, String[] strArr, PermissionsResultAction permissionsResultAction) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (this.mPermissions.contains(str)) {
                if (hasPermission(activity, str)) {
                    if (permissionsResultAction != null) {
                        permissionsResultAction.onResult(str, Permissions.GRANTED);
                    }
                } else if (!this.mPendingRequests.contains(str)) {
                    arrayList.add(str);
                }
            } else if (permissionsResultAction != null) {
                permissionsResultAction.onResult(str, Permissions.NOT_FOUND);
            }
        }
        return arrayList;
    }

    private void showSimpleDialog(Context context, String str, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        DialogBuilder defaultDialogBuilder;
        Dialog create;
        DialogBuilderProvider dialogBuilderProvider = mDialogBuilderProvider;
        if (dialogBuilderProvider != null) {
            defaultDialogBuilder = dialogBuilderProvider.createBuilder(context);
        } else {
            defaultDialogBuilder = new DefaultDialogBuilder(context);
        }
        if (useInLite()) {
            create = defaultDialogBuilder.setMessage(str).setPositiveButton(R.string.confirm, onClickListener).setNegativeButton(R.string.cancel, onClickListener2).create();
            create.setCanceledOnTouchOutside(false);
        } else {
            create = defaultDialogBuilder.setTitle(R.string.permission_request).setMessage(str).setPositiveButton(R.string.permission_go_to_settings, onClickListener).setNegativeButton(R.string.permission_cancel, onClickListener2).create();
            create.setCancelable(false);
        }
        create.show();
    }

    public void addReauestPermissionResultListener(WeakReference<RequestPermissionResultListener> weakReference) {
        this.mRequestPermissionResultListeners.add(weakReference);
    }

    public void removeRequestPermissionResultListener(WeakReference<RequestPermissionResultListener> weakReference) {
        this.mRequestPermissionResultListeners.remove(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyRequestPermissionResultListener(String str, int i) {
        List<WeakReference<RequestPermissionResultListener>> list = this.mRequestPermissionResultListeners;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<WeakReference<RequestPermissionResultListener>> it = this.mRequestPermissionResultListeners.iterator();
        while (it.hasNext()) {
            RequestPermissionResultListener requestPermissionResultListener = it.next().get();
            if (requestPermissionResultListener != null) {
                requestPermissionResultListener.onPermissionResult(str, i);
            }
        }
    }
}
