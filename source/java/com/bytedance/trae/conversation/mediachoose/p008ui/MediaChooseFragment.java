package com.bytedance.trae.conversation.mediachoose.p008ui;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.common.widget.PermissionRationaleDialog;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.databinding.TraeMediaChooseFragmentBinding;
import com.bytedance.trae.conversation.mediachoose.data.MediaStoreRepository;
import com.bytedance.trae.conversation.mediachoose.model.AlbumBucket;
import com.bytedance.trae.conversation.mediachoose.model.MediaChooseConfig;
import com.bytedance.trae.conversation.mediachoose.model.MediaChooseContract;
import com.bytedance.trae.conversation.mediachoose.model.MediaItem;
import com.bytedance.trae.conversation.mediachoose.model.MediaType;
import com.bytedance.trae.conversation.mediachoose.p008ui.MediaSelection;
import com.bytedance.trae.multilanguage.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: MediaChooseFragment.kt */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 O2\u00020\u0001:\u0001OB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J$\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u001a\u00107\u001a\u00020.2\u0006\u00108\u001a\u0002022\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00109\u001a\u00020.H\u0016J\b\u0010:\u001a\u00020.H\u0002J\b\u0010;\u001a\u00020.H\u0002J\b\u0010<\u001a\u00020.H\u0002J\b\u0010=\u001a\u00020.H\u0002J\b\u0010>\u001a\u00020.H\u0002J\u0010\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020\u0018H\u0002J\b\u0010A\u001a\u00020.H\u0002J\b\u0010B\u001a\u00020.H\u0002J\u001e\u0010C\u001a\u00020.2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00180\u00122\u0006\u0010E\u001a\u00020\u001bH\u0002J\b\u0010F\u001a\u00020.H\u0002J\b\u0010G\u001a\u00020.H\u0002J\n\u0010H\u001a\u0004\u0018\u00010!H\u0002J\b\u0010I\u001a\u00020.H\u0002J\b\u0010J\u001a\u00020\u001dH\u0002J\u001b\u0010K\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010L\u001a\u00020MH\u0002¢\u0006\u0002\u0010NR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010$\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020' (*\n\u0012\u0004\u0012\u00020'\u0018\u00010&0&0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010'0'0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010!0!0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010,0,0%X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;", "binding", "getBinding", "()Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;", "config", "Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;", "repository", "Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository;", "adapter", "Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;", "selection", "Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;", "buckets", "", "Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;", "currentBucketId", "", "mediaItems", "Ljava/util/ArrayList;", "Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;", "Lkotlin/collections/ArrayList;", "offset", "", "hasMore", "", "loadJob", "Lkotlinx/coroutines/Job;", "pendingCameraUri", "Landroid/net/Uri;", "singleMaxSize", "maxTotalSize", "permissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "kotlin.jvm.PlatformType", "cameraPermissionLauncher", "takePictureLauncher", "previewLauncher", "Landroid/content/Intent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "requestPermissionsIfNeeded", "startLoad", "resetAndReload", "loadNextPageIfNeed", "showBucketMenu", "toggleSelection", "item", "updateBottomBar", "sendAndFinish", "openPreview", "items", "startIndex", "onCameraItemClick", "openCamera", "createImageUri", "updatePartialPermissionNotice", "isPartialMediaPermissionGranted", "requiredReadPermissions", "mediaType", "Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;", "(Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;)[Ljava/lang/String;", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MediaChooseFragment extends Fragment {
    private static final long MAX_IMAGE_SIZE_BYTES = 104857600;
    private static final int PAGE_SIZE = 60;
    private static final int PREFETCH_THRESHOLD = 12;
    private TraeMediaChooseFragmentBinding _binding;
    private MediaGridAdapter adapter;
    private final ActivityResultLauncher<String> cameraPermissionLauncher;
    private MediaChooseConfig config;
    private Job loadJob;
    private int offset;
    private Uri pendingCameraUri;
    private final ActivityResultLauncher<String[]> permissionLauncher;
    private final ActivityResultLauncher<Intent> previewLauncher;
    private MediaStoreRepository repository;
    private MediaSelection selection;
    private final ActivityResultLauncher<Uri> takePictureLauncher;
    private List<AlbumBucket> buckets = CollectionsKt.emptyList();
    private long currentBucketId = -1;
    private final ArrayList<MediaItem> mediaItems = new ArrayList<>();
    private boolean hasMore = true;
    private long singleMaxSize = MAX_IMAGE_SIZE_BYTES;
    private long maxTotalSize = Long.MAX_VALUE;

    /* compiled from: MediaChooseFragment.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[MediaSelection.ToggleResult.values().length];
            try {
                iArr[MediaSelection.ToggleResult.ReachMax.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaSelection.ToggleResult.BlockedByExclusive.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MediaSelection.ToggleResult.Added.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MediaSelection.ToggleResult.Removed.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[MediaType.values().length];
            try {
                iArr2[MediaType.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[MediaType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[MediaType.ALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[MediaType.ALL_EXCLUSIVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public MediaChooseFragment() {
        ActivityResultLauncher<String[]> registerForActivityResult = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment$$ExternalSyntheticLambda4
            public final void onActivityResult(Object obj) {
                MediaChooseFragment.permissionLauncher$lambda$1(MediaChooseFragment.this, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.permissionLauncher = registerForActivityResult;
        ActivityResultLauncher<String> registerForActivityResult2 = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment$$ExternalSyntheticLambda5
            public final void onActivityResult(Object obj) {
                MediaChooseFragment.cameraPermissionLauncher$lambda$2(MediaChooseFragment.this, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "registerForActivityResult(...)");
        this.cameraPermissionLauncher = registerForActivityResult2;
        ActivityResultLauncher<Uri> registerForActivityResult3 = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.TakePicture(), new ActivityResultCallback() { // from class: com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment$$ExternalSyntheticLambda6
            public final void onActivityResult(Object obj) {
                MediaChooseFragment.takePictureLauncher$lambda$4(MediaChooseFragment.this, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult3, "registerForActivityResult(...)");
        this.takePictureLauncher = registerForActivityResult3;
        ActivityResultLauncher<Intent> registerForActivityResult4 = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment$$ExternalSyntheticLambda7
            public final void onActivityResult(Object obj) {
                MediaChooseFragment.previewLauncher$lambda$7(MediaChooseFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult4, "registerForActivityResult(...)");
        this.previewLauncher = registerForActivityResult4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TraeMediaChooseFragmentBinding getBinding() {
        TraeMediaChooseFragmentBinding traeMediaChooseFragmentBinding = this._binding;
        Intrinsics.checkNotNull(traeMediaChooseFragmentBinding);
        return traeMediaChooseFragmentBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void permissionLauncher$lambda$1(MediaChooseFragment mediaChooseFragment, Map map) {
        boolean z;
        Collection values = map.values();
        if (!(values instanceof Collection) || !values.isEmpty()) {
            Iterator it = values.iterator();
            while (it.hasNext()) {
                if (!((Boolean) it.next()).booleanValue()) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            mediaChooseFragment.startLoad();
            return;
        }
        if (Build.VERSION.SDK_INT >= 34) {
            if (ContextCompat.checkSelfPermission(mediaChooseFragment.requireContext(), "android.permission.READ_MEDIA_VISUAL_USER_SELECTED") == 0) {
                mediaChooseFragment.startLoad();
                return;
            }
        }
        Toast.makeText(mediaChooseFragment.requireContext(), R.string.trae_media_choose_permission_denied, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cameraPermissionLauncher$lambda$2(MediaChooseFragment mediaChooseFragment, Boolean bool) {
        if (!bool.booleanValue()) {
            Toast.makeText(mediaChooseFragment.requireContext(), R.string.trae_media_choose_camera_permission_denied, 0).show();
        } else {
            mediaChooseFragment.openCamera();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void takePictureLauncher$lambda$4(MediaChooseFragment mediaChooseFragment, Boolean bool) {
        Uri uri = mediaChooseFragment.pendingCameraUri;
        mediaChooseFragment.pendingCameraUri = null;
        if (bool.booleanValue()) {
            mediaChooseFragment.resetAndReload();
        } else if (uri != null) {
            mediaChooseFragment.requireContext().getContentResolver().delete(uri, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void previewLauncher$lambda$7(MediaChooseFragment mediaChooseFragment, ActivityResult activityResult) {
        Intent data;
        long[] longArrayExtra;
        Set set;
        if (activityResult.getResultCode() == -1) {
            Intent data2 = activityResult.getData();
            if (data2 == null) {
                return;
            }
            ArrayList parcelableArrayListExtra = data2.getParcelableArrayListExtra(MediaChooseContract.RESULT_SELECTED);
            if (parcelableArrayListExtra == null) {
                parcelableArrayListExtra = CollectionsKt.emptyList();
            }
            boolean booleanExtra = data2.getBooleanExtra(MediaChooseContract.RESULT_KEEP_ORIGIN, false);
            boolean booleanExtra2 = data2.getBooleanExtra(MediaChooseContract.RESULT_HAS_VIDEO, false);
            FragmentActivity requireActivity = mediaChooseFragment.requireActivity();
            Intent intent = new Intent();
            intent.putParcelableArrayListExtra(MediaChooseContract.RESULT_SELECTED, new ArrayList<>(parcelableArrayListExtra));
            intent.putExtra(MediaChooseContract.RESULT_KEEP_ORIGIN, booleanExtra);
            intent.putExtra(MediaChooseContract.RESULT_HAS_VIDEO, booleanExtra2);
            Unit unit = Unit.INSTANCE;
            requireActivity.setResult(-1, intent);
            mediaChooseFragment.requireActivity().finish();
            return;
        }
        if (activityResult.getResultCode() != 2 || (data = activityResult.getData()) == null || (longArrayExtra = data.getLongArrayExtra(MediaChooseContract.RESULT_BACK_SELECTED_IDS)) == null || (set = ArraysKt.toSet(longArrayExtra)) == null) {
            return;
        }
        boolean booleanExtra3 = data.getBooleanExtra(MediaChooseContract.RESULT_BACK_KEEP_ORIGIN, false);
        MediaSelection mediaSelection = mediaChooseFragment.selection;
        MediaSelection mediaSelection2 = null;
        if (mediaSelection == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selection");
            mediaSelection = null;
        }
        ArrayList<MediaItem> arrayList = mediaChooseFragment.mediaItems;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (set.contains(Long.valueOf(((MediaItem) obj).getId()))) {
                arrayList2.add(obj);
            }
        }
        mediaSelection.setSelected(arrayList2);
        MediaSelection mediaSelection3 = mediaChooseFragment.selection;
        if (mediaSelection3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selection");
            mediaSelection3 = null;
        }
        mediaSelection3.setKeepOrigin(booleanExtra3);
        mediaChooseFragment.getBinding().cbOrigin.setChecked(booleanExtra3);
        MediaGridAdapter mediaGridAdapter = mediaChooseFragment.adapter;
        if (mediaGridAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            mediaGridAdapter = null;
        }
        MediaSelection mediaSelection4 = mediaChooseFragment.selection;
        if (mediaSelection4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selection");
        } else {
            mediaSelection2 = mediaSelection4;
        }
        mediaGridAdapter.updateSelection(mediaSelection2);
        mediaChooseFragment.updateBottomBar();
    }

    public void onCreate(Bundle savedInstanceState) {
        MediaChooseConfig mediaChooseConfig;
        MediaChooseConfig copy;
        MediaChooseConfig copy2;
        super.onCreate(savedInstanceState);
        String string = getString(R.string.trae_media_choose_send);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        MediaChooseConfig mediaChooseConfig2 = (MediaChooseConfig) requireActivity().getIntent().getParcelableExtra(MediaChooseContract.EXTRA_CONFIG);
        if (mediaChooseConfig2 == null) {
            mediaChooseConfig2 = new MediaChooseConfig(0, null, false, false, false, false, false, string, 0, false, 895, null);
        }
        this.config = mediaChooseConfig2;
        long longExtra = requireActivity().getIntent().getLongExtra(MediaChooseContract.EXTRA_MAIN_COUNT, 5L);
        this.singleMaxSize = requireActivity().getIntent().getLongExtra(MediaChooseContract.EXTRA_MAX_SINGLE_SIZE, MAX_IMAGE_SIZE_BYTES);
        this.maxTotalSize = requireActivity().getIntent().getLongExtra(MediaChooseContract.EXTRA_MAX_TOTAL_SIZE, Long.MAX_VALUE);
        MediaChooseConfig mediaChooseConfig3 = this.config;
        if (mediaChooseConfig3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            mediaChooseConfig = null;
        } else {
            mediaChooseConfig = mediaChooseConfig3;
        }
        copy = mediaChooseConfig.copy((r22 & 1) != 0 ? mediaChooseConfig.maxSelectCount : (int) longExtra, (r22 & 2) != 0 ? mediaChooseConfig.mediaType : null, (r22 & 4) != 0 ? mediaChooseConfig.singleVideo : false, (r22 & 8) != 0 ? mediaChooseConfig.showCamera : false, (r22 & 16) != 0 ? mediaChooseConfig.enablePreview : false, (r22 & 32) != 0 ? mediaChooseConfig.showOrigin : false, (r22 & 64) != 0 ? mediaChooseConfig.keepOriginDefault : false, (r22 & 128) != 0 ? mediaChooseConfig.actionText : null, (r22 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? mediaChooseConfig.columnCount : 0, (r22 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? mediaChooseConfig.showSingleSelector : false);
        this.config = copy;
        if (copy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            copy = null;
        }
        boolean z = true;
        if (copy.getActionText().length() == 0) {
            MediaChooseConfig mediaChooseConfig4 = this.config;
            if (mediaChooseConfig4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("config");
                mediaChooseConfig4 = null;
            }
            copy2 = mediaChooseConfig4.copy((r22 & 1) != 0 ? mediaChooseConfig4.maxSelectCount : 0, (r22 & 2) != 0 ? mediaChooseConfig4.mediaType : null, (r22 & 4) != 0 ? mediaChooseConfig4.singleVideo : false, (r22 & 8) != 0 ? mediaChooseConfig4.showCamera : false, (r22 & 16) != 0 ? mediaChooseConfig4.enablePreview : false, (r22 & 32) != 0 ? mediaChooseConfig4.showOrigin : false, (r22 & 64) != 0 ? mediaChooseConfig4.keepOriginDefault : false, (r22 & 128) != 0 ? mediaChooseConfig4.actionText : string, (r22 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? mediaChooseConfig4.columnCount : 0, (r22 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? mediaChooseConfig4.showSingleSelector : false);
            this.config = copy2;
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        this.repository = new MediaStoreRepository(requireContext);
        MediaChooseConfig mediaChooseConfig5 = this.config;
        if (mediaChooseConfig5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            mediaChooseConfig5 = null;
        }
        this.selection = new MediaSelection(mediaChooseConfig5);
        ArrayList parcelableArrayListExtra = requireActivity().getIntent().getParcelableArrayListExtra(MediaChooseContract.EXTRA_INITIAL_SELECTED);
        ArrayList arrayList = parcelableArrayListExtra;
        if (arrayList != null && !arrayList.isEmpty()) {
            z = false;
        }
        if (z) {
            return;
        }
        MediaSelection mediaSelection = this.selection;
        if (mediaSelection == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selection");
            mediaSelection = null;
        }
        mediaSelection.setSelected(parcelableArrayListExtra);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = TraeMediaChooseFragmentBinding.inflate(inflater, container, false);
        LinearLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().titleBar.setOnLeftActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MediaChooseFragment.onViewCreated$lambda$8(MediaChooseFragment.this, view2);
            }
        });
        getBinding().titleBar.setOnTitleClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MediaChooseFragment.this.showBucketMenu();
            }
        });
        getBinding().partialPermissionNotice.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MediaChooseFragment.onViewCreated$lambda$11(MediaChooseFragment.this, view2);
            }
        });
        CheckBox checkBox = getBinding().cbOrigin;
        MediaChooseConfig mediaChooseConfig = this.config;
        MediaSelection mediaSelection = null;
        if (mediaChooseConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            mediaChooseConfig = null;
        }
        checkBox.setVisibility(mediaChooseConfig.getShowOrigin() ? 0 : 8);
        CheckBox checkBox2 = getBinding().cbOrigin;
        MediaSelection mediaSelection2 = this.selection;
        if (mediaSelection2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selection");
            mediaSelection2 = null;
        }
        checkBox2.setChecked(mediaSelection2.getKeepOrigin());
        getBinding().cbOrigin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment$$ExternalSyntheticLambda13
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MediaChooseFragment.onViewCreated$lambda$12(MediaChooseFragment.this, compoundButton, z);
            }
        });
        getBinding().btnPreview.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MediaChooseFragment.onViewCreated$lambda$13(MediaChooseFragment.this, view2);
            }
        });
        getBinding().btnSend.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MediaChooseFragment.this.sendAndFinish();
            }
        });
        Function0 function0 = new Function0() { // from class: com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment$$ExternalSyntheticLambda16
            public final Object invoke() {
                Unit onViewCreated$lambda$15;
                onViewCreated$lambda$15 = MediaChooseFragment.onViewCreated$lambda$15(MediaChooseFragment.this);
                return onViewCreated$lambda$15;
            }
        };
        Function1 function1 = new Function1() { // from class: com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$16;
                onViewCreated$lambda$16 = MediaChooseFragment.onViewCreated$lambda$16(MediaChooseFragment.this, (MediaItem) obj);
                return onViewCreated$lambda$16;
            }
        };
        Function1 function12 = new Function1() { // from class: com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$17;
                onViewCreated$lambda$17 = MediaChooseFragment.onViewCreated$lambda$17(MediaChooseFragment.this, ((Integer) obj).intValue());
                return onViewCreated$lambda$17;
            }
        };
        MediaChooseConfig mediaChooseConfig2 = this.config;
        if (mediaChooseConfig2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            mediaChooseConfig2 = null;
        }
        this.adapter = new MediaGridAdapter(function0, function1, function12, mediaChooseConfig2.getEnablePreview());
        Context requireContext = requireContext();
        MediaChooseConfig mediaChooseConfig3 = this.config;
        if (mediaChooseConfig3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            mediaChooseConfig3 = null;
        }
        final RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(requireContext, mediaChooseConfig3.getColumnCount());
        getBinding().f1300rv.setLayoutManager(gridLayoutManager);
        RecyclerView recyclerView = getBinding().f1300rv;
        MediaGridAdapter mediaGridAdapter = this.adapter;
        if (mediaGridAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            mediaGridAdapter = null;
        }
        recyclerView.setAdapter(mediaGridAdapter);
        getBinding().f1300rv.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment$onViewCreated$10
            public void onScrolled(RecyclerView recyclerView2, int dx, int dy) {
                MediaGridAdapter mediaGridAdapter2;
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                if (dy <= 0) {
                    return;
                }
                int findLastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
                mediaGridAdapter2 = this.adapter;
                if (mediaGridAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    mediaGridAdapter2 = null;
                }
                if (findLastVisibleItemPosition >= mediaGridAdapter2.getItemCount() - 12) {
                    this.loadNextPageIfNeed();
                }
            }
        });
        MediaGridAdapter mediaGridAdapter2 = this.adapter;
        if (mediaGridAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            mediaGridAdapter2 = null;
        }
        MediaSelection mediaSelection3 = this.selection;
        if (mediaSelection3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selection");
        } else {
            mediaSelection = mediaSelection3;
        }
        mediaGridAdapter2.updateSelection(mediaSelection);
        updateBottomBar();
        requestPermissionsIfNeeded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$8(MediaChooseFragment mediaChooseFragment, View view) {
        mediaChooseFragment.requireActivity().getOnBackPressedDispatcher().onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$11(MediaChooseFragment mediaChooseFragment, View view) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", mediaChooseFragment.requireContext().getPackageName(), null));
        mediaChooseFragment.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$12(MediaChooseFragment mediaChooseFragment, CompoundButton compoundButton, boolean z) {
        MediaSelection mediaSelection = mediaChooseFragment.selection;
        if (mediaSelection == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selection");
            mediaSelection = null;
        }
        mediaSelection.setKeepOrigin(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$13(MediaChooseFragment mediaChooseFragment, View view) {
        MediaSelection mediaSelection = mediaChooseFragment.selection;
        if (mediaSelection == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selection");
            mediaSelection = null;
        }
        List<MediaItem> selectedItems = mediaSelection.selectedItems();
        if (selectedItems.isEmpty()) {
            return;
        }
        mediaChooseFragment.openPreview(selectedItems, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$15(MediaChooseFragment mediaChooseFragment) {
        mediaChooseFragment.onCameraItemClick();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$16(MediaChooseFragment mediaChooseFragment, MediaItem mediaItem) {
        Intrinsics.checkNotNullParameter(mediaItem, "it");
        mediaChooseFragment.toggleSelection(mediaItem);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$17(MediaChooseFragment mediaChooseFragment, int i) {
        MediaGridAdapter mediaGridAdapter = mediaChooseFragment.adapter;
        if (mediaGridAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            mediaGridAdapter = null;
        }
        List<MediaItem> currentMediaItems = mediaGridAdapter.currentMediaItems();
        boolean z = false;
        if (i >= 0 && i < currentMediaItems.size()) {
            z = true;
        }
        if (z) {
            mediaChooseFragment.openPreview(currentMediaItems, i);
        }
        return Unit.INSTANCE;
    }

    public void onDestroyView() {
        super.onDestroyView();
        Job job = this.loadJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this._binding = null;
    }

    private final void requestPermissionsIfNeeded() {
        MediaChooseConfig mediaChooseConfig = this.config;
        if (mediaChooseConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            mediaChooseConfig = null;
        }
        final String[] requiredReadPermissions = requiredReadPermissions(mediaChooseConfig.getMediaType());
        int length = requiredReadPermissions.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (ContextCompat.checkSelfPermission(requireContext(), requiredReadPermissions[i]) != 0) {
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            startLoad();
            return;
        }
        PermissionRationaleDialog.Companion companion = PermissionRationaleDialog.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        companion.showForPermission(requireContext, C0591R.drawable.trae_ic_permission_photo, R.string.trae_permission_photo_title, R.string.trae_permission_photo_message, R.string.trae_permission_allow, R.string.trae_permission_deny, new Function0() { // from class: com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment$$ExternalSyntheticLambda8
            public final Object invoke() {
                Unit requestPermissionsIfNeeded$lambda$19;
                requestPermissionsIfNeeded$lambda$19 = MediaChooseFragment.requestPermissionsIfNeeded$lambda$19(MediaChooseFragment.this, requiredReadPermissions);
                return requestPermissionsIfNeeded$lambda$19;
            }
        }, new Function0() { // from class: com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment$$ExternalSyntheticLambda9
            public final Object invoke() {
                Unit requestPermissionsIfNeeded$lambda$20;
                requestPermissionsIfNeeded$lambda$20 = MediaChooseFragment.requestPermissionsIfNeeded$lambda$20(MediaChooseFragment.this);
                return requestPermissionsIfNeeded$lambda$20;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestPermissionsIfNeeded$lambda$19(MediaChooseFragment mediaChooseFragment, String[] strArr) {
        mediaChooseFragment.permissionLauncher.launch(strArr);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestPermissionsIfNeeded$lambda$20(MediaChooseFragment mediaChooseFragment) {
        FragmentActivity activity = mediaChooseFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
        return Unit.INSTANCE;
    }

    private final void startLoad() {
        updatePartialPermissionNotice();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new MediaChooseFragment$startLoad$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetAndReload() {
        this.mediaItems.clear();
        this.offset = 0;
        this.hasMore = true;
        MediaGridAdapter mediaGridAdapter = this.adapter;
        MediaChooseConfig mediaChooseConfig = null;
        if (mediaGridAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            mediaGridAdapter = null;
        }
        ArrayList<MediaItem> arrayList = this.mediaItems;
        MediaChooseConfig mediaChooseConfig2 = this.config;
        if (mediaChooseConfig2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
        } else {
            mediaChooseConfig = mediaChooseConfig2;
        }
        mediaGridAdapter.submit(arrayList, mediaChooseConfig.getShowCamera());
        loadNextPageIfNeed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadNextPageIfNeed() {
        if (this.hasMore) {
            Job job = this.loadJob;
            boolean z = false;
            if (job != null && job.isActive()) {
                z = true;
            }
            if (z) {
                return;
            }
            this.loadJob = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new MediaChooseFragment$loadNextPageIfNeed$1(this, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showBucketMenu() {
        if (this.buckets.isEmpty()) {
            return;
        }
        PopupMenu popupMenu = new PopupMenu(requireContext(), getBinding().titleBar);
        int i = 0;
        for (Object obj : this.buckets) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            AlbumBucket albumBucket = (AlbumBucket) obj;
            popupMenu.getMenu().add(0, i, i, getString(R.string.trae_media_choose_bucket_item, new Object[]{albumBucket.getName(), Integer.valueOf(albumBucket.getCount())}));
            i = i2;
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment$$ExternalSyntheticLambda3
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean showBucketMenu$lambda$22;
                showBucketMenu$lambda$22 = MediaChooseFragment.showBucketMenu$lambda$22(MediaChooseFragment.this, menuItem);
                return showBucketMenu$lambda$22;
            }
        });
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showBucketMenu$lambda$22(MediaChooseFragment mediaChooseFragment, MenuItem menuItem) {
        AlbumBucket albumBucket = (AlbumBucket) CollectionsKt.getOrNull(mediaChooseFragment.buckets, menuItem.getItemId());
        if (albumBucket == null) {
            return false;
        }
        mediaChooseFragment.currentBucketId = albumBucket.getId();
        mediaChooseFragment.getBinding().titleBar.setTitle(albumBucket.getName());
        mediaChooseFragment.resetAndReload();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0115, code lost:
    
        if (r0.getShowSingleSelector() == false) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void toggleSelection(MediaItem item) {
        boolean z = true;
        if (!item.isVideo() && item.getSizeBytes() > this.singleMaxSize) {
            long j = 1024;
            String string = requireContext().getString(R.string.trae_media_choose_file_too_large, Long.valueOf((this.singleMaxSize / j) / j));
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Toast.makeText(requireContext(), string, 0).show();
            return;
        }
        MediaSelection mediaSelection = this.selection;
        MediaSelection mediaSelection2 = null;
        if (mediaSelection == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selection");
            mediaSelection = null;
        }
        if (!mediaSelection.isSelected(item.getId()) && this.maxTotalSize != Long.MAX_VALUE) {
            MediaSelection mediaSelection3 = this.selection;
            if (mediaSelection3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selection");
                mediaSelection3 = null;
            }
            Iterator<T> it = mediaSelection3.selectedItems().iterator();
            long j2 = 0;
            while (it.hasNext()) {
                j2 += ((MediaItem) it.next()).getSizeBytes();
            }
            if (j2 + item.getSizeBytes() > this.maxTotalSize) {
                Toast.makeText(requireContext(), R.string.trae_media_choose_total_size_too_large, 0).show();
                return;
            }
        }
        MediaSelection mediaSelection4 = this.selection;
        if (mediaSelection4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selection");
            mediaSelection4 = null;
        }
        MediaSelection.ToggleResult toggleResult = mediaSelection4.toggle(item);
        int i = WhenMappings.$EnumSwitchMapping$0[toggleResult.ordinal()];
        if (i == 1) {
            Context requireContext = requireContext();
            int i2 = R.string.trae_media_choose_reach_max;
            Object[] objArr = new Object[1];
            MediaChooseConfig mediaChooseConfig = this.config;
            if (mediaChooseConfig == null) {
                Intrinsics.throwUninitializedPropertyAccessException("config");
                mediaChooseConfig = null;
            }
            objArr[0] = Integer.valueOf(mediaChooseConfig.getMaxSelectCount());
            Toast.makeText(requireContext, getString(i2, objArr), 0).show();
        } else if (i == 2) {
            Toast.makeText(requireContext(), R.string.trae_media_choose_exclusive_tips, 0).show();
        } else if (i != 3 && i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        MediaChooseConfig mediaChooseConfig2 = this.config;
        if (mediaChooseConfig2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            mediaChooseConfig2 = null;
        }
        if (mediaChooseConfig2.getMaxSelectCount() == 1) {
            MediaChooseConfig mediaChooseConfig3 = this.config;
            if (mediaChooseConfig3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("config");
                mediaChooseConfig3 = null;
            }
        }
        z = false;
        if (z && toggleResult == MediaSelection.ToggleResult.Added) {
            sendAndFinish();
            return;
        }
        MediaGridAdapter mediaGridAdapter = this.adapter;
        if (mediaGridAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            mediaGridAdapter = null;
        }
        MediaSelection mediaSelection5 = this.selection;
        if (mediaSelection5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selection");
        } else {
            mediaSelection2 = mediaSelection5;
        }
        mediaGridAdapter.updateSelection(mediaSelection2);
        updateBottomBar();
    }

    private final void updateBottomBar() {
        MediaSelection mediaSelection = this.selection;
        MediaChooseConfig mediaChooseConfig = null;
        if (mediaSelection == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selection");
            mediaSelection = null;
        }
        int selectedCount = mediaSelection.selectedCount();
        getBinding().btnPreview.setVisibility(selectedCount > 0 ? 0 : 8);
        if (selectedCount > 0) {
            getBinding().btnSend.setVisibility(0);
            getBinding().btnSend.setEnabled(true);
            TextView textView = getBinding().btnSend;
            int i = R.string.trae_media_choose_send_with_count;
            Object[] objArr = new Object[2];
            MediaChooseConfig mediaChooseConfig2 = this.config;
            if (mediaChooseConfig2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("config");
            } else {
                mediaChooseConfig = mediaChooseConfig2;
            }
            objArr[0] = mediaChooseConfig.getActionText();
            objArr[1] = Integer.valueOf(selectedCount);
            textView.setText(getString(i, objArr));
            return;
        }
        getBinding().btnSend.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendAndFinish() {
        MediaSelection mediaSelection = this.selection;
        MediaSelection mediaSelection2 = null;
        if (mediaSelection == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selection");
            mediaSelection = null;
        }
        List<MediaItem> selectedItems = mediaSelection.selectedItems();
        if (selectedItems.isEmpty()) {
            return;
        }
        List<MediaItem> list = selectedItems;
        boolean z = false;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((MediaItem) it.next()).isVideo()) {
                    z = true;
                    break;
                }
            }
        }
        FragmentActivity requireActivity = requireActivity();
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra(MediaChooseContract.RESULT_SELECTED, new ArrayList<>(selectedItems));
        MediaSelection mediaSelection3 = this.selection;
        if (mediaSelection3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selection");
        } else {
            mediaSelection2 = mediaSelection3;
        }
        intent.putExtra(MediaChooseContract.RESULT_KEEP_ORIGIN, mediaSelection2.getKeepOrigin());
        intent.putExtra(MediaChooseContract.RESULT_HAS_VIDEO, z);
        Unit unit = Unit.INSTANCE;
        requireActivity.setResult(-1, intent);
        requireActivity().finish();
    }

    private final void openPreview(List<MediaItem> items, int startIndex) {
        MediaChooseContract.INSTANCE.setPreviewItemsCache(items);
        Intent intent = new Intent(requireContext(), (Class<?>) PreviewActivity.class);
        intent.putExtra(MediaChooseContract.EXTRA_PREVIEW_INDEX, startIndex);
        MediaChooseConfig mediaChooseConfig = this.config;
        MediaSelection mediaSelection = null;
        if (mediaChooseConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            mediaChooseConfig = null;
        }
        intent.putExtra(MediaChooseContract.EXTRA_PREVIEW_CONFIG, mediaChooseConfig);
        MediaSelection mediaSelection2 = this.selection;
        if (mediaSelection2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selection");
            mediaSelection2 = null;
        }
        intent.putExtra(MediaChooseContract.EXTRA_PREVIEW_KEEP_ORIGIN, mediaSelection2.getKeepOrigin());
        MediaSelection mediaSelection3 = this.selection;
        if (mediaSelection3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selection");
        } else {
            mediaSelection = mediaSelection3;
        }
        List<MediaItem> selectedItems = mediaSelection.selectedItems();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(selectedItems, 10));
        Iterator<T> it = selectedItems.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((MediaItem) it.next()).getId()));
        }
        intent.putExtra(MediaChooseContract.EXTRA_PREVIEW_SELECTED_IDS, CollectionsKt.toLongArray(arrayList));
        intent.putExtra(MediaChooseContract.EXTRA_MAX_TOTAL_SIZE, this.maxTotalSize);
        intent.putExtra(MediaChooseContract.EXTRA_MAX_SINGLE_SIZE, this.singleMaxSize);
        this.previewLauncher.launch(intent);
    }

    private final void onCameraItemClick() {
        if (ContextCompat.checkSelfPermission(requireContext(), "android.permission.CAMERA") != 0) {
            PermissionRationaleDialog.Companion companion = PermissionRationaleDialog.INSTANCE;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            companion.showForPermission(requireContext, C0591R.drawable.trae_ic_permission_camera, R.string.trae_permission_camera_title, R.string.trae_permission_camera_message, R.string.trae_permission_allow, R.string.trae_permission_deny, new Function0() { // from class: com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit onCameraItemClick$lambda$28;
                    onCameraItemClick$lambda$28 = MediaChooseFragment.onCameraItemClick$lambda$28(MediaChooseFragment.this);
                    return onCameraItemClick$lambda$28;
                }
            }, (r19 & 128) != 0 ? new Function0() { // from class: com.bytedance.trae.common.widget.PermissionRationaleDialog$Companion$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            } : null);
            return;
        }
        openCamera();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCameraItemClick$lambda$28(MediaChooseFragment mediaChooseFragment) {
        mediaChooseFragment.cameraPermissionLauncher.launch("android.permission.CAMERA");
        return Unit.INSTANCE;
    }

    private final void openCamera() {
        Uri createImageUri = createImageUri();
        if (createImageUri == null) {
            Toast.makeText(requireContext(), R.string.trae_media_choose_camera_create_failed, 0).show();
        } else {
            this.pendingCameraUri = createImageUri;
            this.takePictureLauncher.launch(createImageUri);
        }
    }

    private final Uri createImageUri() {
        ContentResolver contentResolver = requireContext().getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", "trae_media_choose_" + System.currentTimeMillis() + ".jpg");
        contentValues.put("mime_type", "image/jpeg");
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("relative_path", "Pictures/TraeMediaChoose");
        }
        return contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
    }

    private final void updatePartialPermissionNotice() {
        getBinding().partialPermissionNotice.setVisibility(isPartialMediaPermissionGranted() ? 0 : 8);
    }

    private final boolean isPartialMediaPermissionGranted() {
        if (Build.VERSION.SDK_INT < 34) {
            return false;
        }
        return (ContextCompat.checkSelfPermission(requireContext(), "android.permission.READ_MEDIA_VISUAL_USER_SELECTED") == 0) && !(ContextCompat.checkSelfPermission(requireContext(), "android.permission.READ_MEDIA_IMAGES") == 0);
    }

    private final String[] requiredReadPermissions(MediaType mediaType) {
        if (Build.VERSION.SDK_INT >= 34) {
            int i = WhenMappings.$EnumSwitchMapping$1[mediaType.ordinal()];
            if (i == 1) {
                return new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VISUAL_USER_SELECTED"};
            }
            if (i == 2) {
                return new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VISUAL_USER_SELECTED"};
            }
            if (i == 3 || i == 4) {
                return new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VISUAL_USER_SELECTED"};
            }
            throw new NoWhenBranchMatchedException();
        }
        if (Build.VERSION.SDK_INT >= 33) {
            return new String[]{"android.permission.READ_MEDIA_IMAGES"};
        }
        return new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
    }
}
