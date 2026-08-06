package com.bytedance.trae.home.solo.setting;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.TocCreditsPolicy;
import com.bytedance.trae.conversation.imageupload.CompressionResult;
import com.bytedance.trae.conversation.imageupload.ImageCompressor;
import com.bytedance.trae.im.model.MessagePart;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.AccountType;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: SettingsViewModel.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020'J\u000e\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020'J\u0010\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020/H\u0002J\u000e\u00100\u001a\u00020'2\u0006\u00101\u001a\u00020+J\u000e\u00102\u001a\u00020'2\u0006\u00103\u001a\u000204J\u001a\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020\u00032\u0006\u00103\u001a\u000204H\u0002J\u0012\u00108\u001a\u0004\u0018\u0001062\u0006\u00109\u001a\u000206H\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u001c\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u000f0\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\fR\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\fR\u0016\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\fR\u0016\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\n¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\fR\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "_userProfile", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/trae/home/solo/setting/UserProfileState;", "userProfile", "Landroidx/lifecycle/LiveData;", "getUserProfile", "()Landroidx/lifecycle/LiveData;", "_updateNameResult", "Lcom/bytedance/trae/home/solo/setting/Event;", "", "updateNameResult", "getUpdateNameResult", "_uploadAvatarResult", "uploadAvatarResult", "getUploadAvatarResult", "_isLoading", "kotlin.jvm.PlatformType", "isLoading", "_userPayStatus", "Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;", "userPayStatus", "getUserPayStatus", "_userCNPayStatus", "Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;", "userCNPayStatus", "getUserCNPayStatus", "_creditsBalanceSnapshot", "Lcom/bytedance/trae/home/solo/setting/CreditsBalanceSnapshot;", "creditsBalanceSnapshot", "getCreditsBalanceSnapshot", "creditsBalanceFetchJob", "Lkotlinx/coroutines/Job;", "fetchUserPayStatus", "", "fetchCreditsBalance", "updatePhoneNumber", "phone", "", "loadUserInfo", "doRefreshUserInfo", "loginService", "Lcom/bytedance/trae/login/api/ILoginService;", "updateNickname", "newName", "uploadAvatar", "uri", "Landroid/net/Uri;", "copyAndCompressAvatar", "Ljava/io/File;", "context", "cropToSquare", MessagePart.TYPE_FILE, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SettingsViewModel extends AndroidViewModel {
    private static final int AVATAR_MAX_DIMENSION = 1024;
    private static final long AVATAR_MAX_SIZE_BYTES = 512000;
    private static final String TAG = "SettingsViewModel";
    private final MutableLiveData<CreditsBalanceSnapshot> _creditsBalanceSnapshot;
    private final MutableLiveData<Boolean> _isLoading;
    private final MutableLiveData<Event<Boolean>> _updateNameResult;
    private final MutableLiveData<Event<Boolean>> _uploadAvatarResult;
    private final MutableLiveData<CNUserPayStatusData> _userCNPayStatus;
    private final MutableLiveData<UserPayStatusData> _userPayStatus;
    private final MutableLiveData<UserProfileState> _userProfile;
    private Job creditsBalanceFetchJob;
    private final LiveData<CreditsBalanceSnapshot> creditsBalanceSnapshot;
    private final LiveData<Boolean> isLoading;
    private final LiveData<Event<Boolean>> updateNameResult;
    private final LiveData<Event<Boolean>> uploadAvatarResult;
    private final LiveData<CNUserPayStatusData> userCNPayStatus;
    private final LiveData<UserPayStatusData> userPayStatus;
    private final LiveData<UserProfileState> userProfile;
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        LiveData<UserProfileState> mutableLiveData = new MutableLiveData<>();
        this._userProfile = mutableLiveData;
        this.userProfile = mutableLiveData;
        LiveData<Event<Boolean>> mutableLiveData2 = new MutableLiveData<>();
        this._updateNameResult = mutableLiveData2;
        this.updateNameResult = mutableLiveData2;
        LiveData<Event<Boolean>> mutableLiveData3 = new MutableLiveData<>();
        this._uploadAvatarResult = mutableLiveData3;
        this.uploadAvatarResult = mutableLiveData3;
        LiveData<Boolean> mutableLiveData4 = new MutableLiveData<>(false);
        this._isLoading = mutableLiveData4;
        this.isLoading = mutableLiveData4;
        LiveData<UserPayStatusData> mutableLiveData5 = new MutableLiveData<>();
        this._userPayStatus = mutableLiveData5;
        this.userPayStatus = mutableLiveData5;
        LiveData<CNUserPayStatusData> mutableLiveData6 = new MutableLiveData<>();
        this._userCNPayStatus = mutableLiveData6;
        this.userCNPayStatus = mutableLiveData6;
        LiveData<CreditsBalanceSnapshot> mutableLiveData7 = new MutableLiveData<>();
        this._creditsBalanceSnapshot = mutableLiveData7;
        this.creditsBalanceSnapshot = mutableLiveData7;
    }

    public final LiveData<UserProfileState> getUserProfile() {
        return this.userProfile;
    }

    public final LiveData<Event<Boolean>> getUpdateNameResult() {
        return this.updateNameResult;
    }

    public final LiveData<Event<Boolean>> getUploadAvatarResult() {
        return this.uploadAvatarResult;
    }

    public final LiveData<Boolean> isLoading() {
        return this.isLoading;
    }

    public final LiveData<UserPayStatusData> getUserPayStatus() {
        return this.userPayStatus;
    }

    public final LiveData<CNUserPayStatusData> getUserCNPayStatus() {
        return this.userCNPayStatus;
    }

    public final LiveData<CreditsBalanceSnapshot> getCreditsBalanceSnapshot() {
        return this.creditsBalanceSnapshot;
    }

    public final void fetchUserPayStatus() {
        if (AppHost.INSTANCE.isOversea()) {
            this._userPayStatus.setValue((Object) null);
        } else {
            this._userCNPayStatus.setValue((Object) null);
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new SettingsViewModel$fetchUserPayStatus$1(this, null), 3, (Object) null);
    }

    public final void fetchCreditsBalance() {
        if (!TocCreditsPolicy.INSTANCE.isEnabled()) {
            Job job = this.creditsBalanceFetchJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this._creditsBalanceSnapshot.setValue((Object) null);
            return;
        }
        this._creditsBalanceSnapshot.setValue(UserPayIdentityCache.INSTANCE.getCreditsBalanceSnapshot());
        Job job2 = this.creditsBalanceFetchJob;
        if (job2 != null && job2.isActive()) {
            return;
        }
        this.creditsBalanceFetchJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new SettingsViewModel$fetchCreditsBalance$1(this, null), 3, (Object) null);
    }

    public final void updatePhoneNumber(String phone) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        String obj = StringsKt.replaceRange(phone, 3, phone.length() - 2, StringsKt.repeat("*", phone.length() - 5)).toString();
        UserProfileState userProfileState = (UserProfileState) this._userProfile.getValue();
        if (userProfileState != null) {
            this._userProfile.setValue(UserProfileState.copy$default(userProfileState, null, null, null, obj, null, 0, null, 119, null));
        }
    }

    public final void loadUserInfo() {
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (iLoginService == null) {
            return;
        }
        AccountInfo accountInfo = iLoginService.getAccountInfo();
        UserProfileState userProfileState = (UserProfileState) this._userProfile.getValue();
        if (userProfileState != null) {
            MutableLiveData<UserProfileState> mutableLiveData = this._userProfile;
            String email = accountInfo.getEmail();
            if (email.length() == 0) {
                email = userProfileState.getEmail();
            }
            String str = email;
            String phoneNumber = accountInfo.getPhoneNumber();
            if (phoneNumber.length() == 0) {
                phoneNumber = userProfileState.getPhoneNumber();
            }
            String str2 = phoneNumber;
            String screenName = accountInfo.getScreenName();
            if (screenName.length() == 0) {
                screenName = userProfileState.getScreenName();
            }
            String str3 = screenName;
            String avatarUrl = accountInfo.getAvatarUrl();
            if (avatarUrl.length() == 0) {
                avatarUrl = userProfileState.getAvatarUrl();
            }
            String str4 = avatarUrl;
            Integer valueOf = Integer.valueOf(accountInfo.getProductType());
            if (!(valueOf.intValue() != 0)) {
                valueOf = null;
            }
            mutableLiveData.setValue(UserProfileState.copy$default(userProfileState, str3, str4, str, str2, null, valueOf != null ? valueOf.intValue() : userProfileState.getProductType(), accountInfo.getSaasPrivacyMode(), 16, null));
        } else {
            this._userProfile.setValue(new UserProfileState(accountInfo.getScreenName(), accountInfo.getAvatarUrl(), accountInfo.getEmail(), accountInfo.getPhoneNumber(), accountInfo.getUserId(), accountInfo.getProductType(), accountInfo.getSaasPrivacyMode()));
        }
        doRefreshUserInfo(iLoginService);
    }

    private final void doRefreshUserInfo(ILoginService loginService) {
        ILoginService.DefaultImpls.refreshUserInfo$default(loginService, new Function1() { // from class: com.bytedance.trae.home.solo.setting.SettingsViewModel$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit doRefreshUserInfo$lambda$11;
                doRefreshUserInfo$lambda$11 = SettingsViewModel.doRefreshUserInfo$lambda$11(SettingsViewModel.this, (AccountInfo) obj);
                return doRefreshUserInfo$lambda$11;
            }
        }, (Function0) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit doRefreshUserInfo$lambda$11(SettingsViewModel settingsViewModel, AccountInfo accountInfo) {
        Intrinsics.checkNotNullParameter(accountInfo, "fresh");
        UserProfileState userProfileState = (UserProfileState) settingsViewModel._userProfile.getValue();
        if (userProfileState == null) {
            return Unit.INSTANCE;
        }
        MutableLiveData<UserProfileState> mutableLiveData = settingsViewModel._userProfile;
        String email = accountInfo.getEmail();
        if (email.length() == 0) {
            email = userProfileState.getEmail();
        }
        String str = email;
        String phoneNumber = accountInfo.getPhoneNumber();
        if (phoneNumber.length() == 0) {
            phoneNumber = userProfileState.getPhoneNumber();
        }
        String str2 = phoneNumber;
        String screenName = accountInfo.getScreenName();
        if (screenName.length() == 0) {
            screenName = userProfileState.getScreenName();
        }
        String str3 = screenName;
        String avatarUrl = accountInfo.getAvatarUrl();
        if (avatarUrl.length() == 0) {
            avatarUrl = userProfileState.getAvatarUrl();
        }
        String str4 = avatarUrl;
        String userId = accountInfo.getUserId();
        if (userId.length() == 0) {
            userId = userProfileState.getUserId();
        }
        String str5 = userId;
        Integer valueOf = Integer.valueOf(accountInfo.getProductType());
        if (!(valueOf.intValue() != 0)) {
            valueOf = null;
        }
        mutableLiveData.postValue(userProfileState.copy(str3, str4, str, str2, str5, valueOf != null ? valueOf.intValue() : userProfileState.getProductType(), accountInfo.getSaasPrivacyMode()));
        return Unit.INSTANCE;
    }

    public final void updateNickname(final String newName) {
        Intrinsics.checkNotNullParameter(newName, "newName");
        if (StringsKt.isBlank(newName)) {
            return;
        }
        this._isLoading.setValue(true);
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (iLoginService == null) {
            this._isLoading.setValue(false);
            this._updateNameResult.setValue(new Event(false));
        } else {
            iLoginService.updateUserProfile(MapsKt.mapOf(TuplesKt.to("name", newName)), new Function0() { // from class: com.bytedance.trae.home.solo.setting.SettingsViewModel$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit updateNickname$lambda$12;
                    updateNickname$lambda$12 = SettingsViewModel.updateNickname$lambda$12(SettingsViewModel.this, newName);
                    return updateNickname$lambda$12;
                }
            }, new Function1() { // from class: com.bytedance.trae.home.solo.setting.SettingsViewModel$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    Unit updateNickname$lambda$13;
                    updateNickname$lambda$13 = SettingsViewModel.updateNickname$lambda$13(SettingsViewModel.this, ((Integer) obj).intValue());
                    return updateNickname$lambda$13;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateNickname$lambda$12(SettingsViewModel settingsViewModel, String str) {
        settingsViewModel._isLoading.postValue(false);
        UserProfileState userProfileState = (UserProfileState) settingsViewModel._userProfile.getValue();
        if (userProfileState != null) {
            settingsViewModel._userProfile.postValue(UserProfileState.copy$default(userProfileState, str, null, null, null, null, 0, null, 126, null));
        }
        settingsViewModel._updateNameResult.postValue(new Event(true));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateNickname$lambda$13(SettingsViewModel settingsViewModel, int i) {
        FLogger.INSTANCE.e(TAG, "updateNickname failed, errorCode=" + i);
        settingsViewModel._isLoading.postValue(false);
        settingsViewModel._updateNameResult.postValue(new Event(false));
        return Unit.INSTANCE;
    }

    public final void uploadAvatar(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this._isLoading.setValue(true);
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (iLoginService == null) {
            this._isLoading.setValue(false);
            this._uploadAvatarResult.setValue(new Event(false));
        } else if (iLoginService.getAccountInfo().getAccountType() == AccountType.TOB) {
            this._isLoading.setValue(false);
            this._uploadAvatarResult.setValue(new Event(false));
        } else {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new SettingsViewModel$uploadAvatar$1(this, iLoginService, getApplication(), uri, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007a, code lost:
    
        if (r14 == false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final File copyAndCompressAvatar(Application context, Uri uri) {
        boolean z;
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                return null;
            }
            File file = new File(context.getCacheDir(), "avatar_upload_" + System.currentTimeMillis() + ".jpg");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                boolean z2 = false;
                ByteStreamsKt.copyTo$default(openInputStream, fileOutputStream, 0, 2, (Object) null);
                CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                openInputStream.close();
                File cropToSquare = cropToSquare(file);
                if (cropToSquare != null) {
                    file = cropToSquare;
                }
                if (file.length() <= AVATAR_MAX_SIZE_BYTES) {
                    SettingsViewModel settingsViewModel = this;
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(file.getAbsolutePath(), options);
                    if (options.outWidth <= 1024 && options.outHeight <= 1024) {
                        z = false;
                    }
                    z = true;
                }
                z2 = true;
                if (!z2) {
                    return file;
                }
                File cacheDir = context.getCacheDir();
                Intrinsics.checkNotNullExpressionValue(cacheDir, "getCacheDir(...)");
                CompressionResult compressIfNeeded = new ImageCompressor(cacheDir).compressIfNeeded(file, null, new ImageCompressor.Config(AVATAR_MAX_SIZE_BYTES, 1024, 0.0f, false, 12, null));
                if (compressIfNeeded.getWasCompressed() && !Intrinsics.areEqual(compressIfNeeded.getFile(), file)) {
                    file.delete();
                }
                return compressIfNeeded.getFile();
            } finally {
            }
        } catch (Exception e) {
            FLogger.INSTANCE.e(TAG, "uploadAvatar copy/compress exception: " + e.getMessage());
            return null;
        } catch (OutOfMemoryError e2) {
            FLogger.INSTANCE.e(TAG, "uploadAvatar OOM: " + e2.getMessage());
            return null;
        }
    }

    private final File cropToSquare(File file) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            if (i > 0 && i2 > 0) {
                if (i == i2) {
                    return file;
                }
                int min = Math.min(i, i2);
                int min2 = min / Math.min(min, 1024);
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inSampleSize = min2 >= 2 ? Integer.highestOneBit(min2) : 1;
                Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options2);
                if (decodeFile == null) {
                    return null;
                }
                int width = decodeFile.getWidth();
                int height = decodeFile.getHeight();
                int min3 = Math.min(width, height);
                Bitmap createBitmap = Bitmap.createBitmap(decodeFile, (width - min3) / 2, (height - min3) / 2, min3, min3);
                Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
                if (!Intrinsics.areEqual(createBitmap, decodeFile)) {
                    decodeFile.recycle();
                }
                File file2 = new File(file.getParent(), "avatar_cropped_" + System.currentTimeMillis() + ".jpg");
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    createBitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                    CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                    createBitmap.recycle();
                    if (!Intrinsics.areEqual(file2, file)) {
                        file.delete();
                    }
                    return file2;
                } finally {
                }
            }
            return null;
        } catch (Exception e) {
            FLogger.INSTANCE.e(TAG, "cropToSquare exception: " + e.getMessage());
            return null;
        } catch (OutOfMemoryError e2) {
            FLogger.INSTANCE.e(TAG, "cropToSquare OOM: " + e2.getMessage());
            return null;
        }
    }
}
