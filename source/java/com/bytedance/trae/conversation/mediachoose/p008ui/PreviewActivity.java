package com.bytedance.trae.conversation.mediachoose.p008ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.trae.common.activity.TraeCommonAppCompatActivity;
import com.bytedance.trae.conversation.databinding.TraeMediaChooseActivityPreviewBinding;
import com.bytedance.trae.conversation.mediachoose.model.MediaChooseConfig;
import com.bytedance.trae.conversation.mediachoose.model.MediaChooseContract;
import com.bytedance.trae.conversation.mediachoose.model.MediaItem;
import com.bytedance.trae.conversation.mediachoose.p008ui.MediaSelection;
import com.bytedance.trae.multilanguage.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: PreviewActivity.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0015H\u0014J\b\u0010\u0019\u001a\u00020\u0015H\u0002J\n\u0010\u001a\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\b\u0010\u001c\u001a\u00020\u0015H\u0002J\b\u0010\u001d\u001a\u00020\u0015H\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;", "Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;", "<init>", "()V", "binding", "Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;", "config", "Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;", "items", "", "Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;", "selection", "Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;", "maxTotalSize", "", "singleMaxSize", "adapter", "Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;", "getDecorViewBackgroundColor", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStop", "updateControls", "getCurrentItem", "sendAndFinish", "returnSelectionAndFinish", "onBackPressed", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PreviewActivity extends TraeCommonAppCompatActivity {
    private PreviewPagerAdapter adapter;
    private TraeMediaChooseActivityPreviewBinding binding;
    private MediaChooseConfig config;
    private List<MediaItem> items;
    private MediaSelection selection;
    private long maxTotalSize = Long.MAX_VALUE;
    private long singleMaxSize = Long.MAX_VALUE;

    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public int getDecorViewBackgroundColor() {
        return -16777216;
    }

    protected void onStop() {
        m833xf0b666a1(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TraeMediaChooseActivityPreviewBinding inflate = TraeMediaChooseActivityPreviewBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        TraeMediaChooseActivityPreviewBinding traeMediaChooseActivityPreviewBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView((View) inflate.getRoot());
        TraeMediaChooseActivityPreviewBinding traeMediaChooseActivityPreviewBinding2 = this.binding;
        if (traeMediaChooseActivityPreviewBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeMediaChooseActivityPreviewBinding2 = null;
        }
        ViewCompat.setOnApplyWindowInsetsListener(traeMediaChooseActivityPreviewBinding2.topBar, new OnApplyWindowInsetsListener() { // from class: com.bytedance.trae.conversation.mediachoose.ui.PreviewActivity$$ExternalSyntheticLambda0
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat onCreate$lambda$0;
                onCreate$lambda$0 = PreviewActivity.onCreate$lambda$0(view, windowInsetsCompat);
                return onCreate$lambda$0;
            }
        });
        TraeMediaChooseActivityPreviewBinding traeMediaChooseActivityPreviewBinding3 = this.binding;
        if (traeMediaChooseActivityPreviewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeMediaChooseActivityPreviewBinding3 = null;
        }
        ViewCompat.setOnApplyWindowInsetsListener(traeMediaChooseActivityPreviewBinding3.bottomBar, new OnApplyWindowInsetsListener() { // from class: com.bytedance.trae.conversation.mediachoose.ui.PreviewActivity$$ExternalSyntheticLambda1
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat onCreate$lambda$1;
                onCreate$lambda$1 = PreviewActivity.onCreate$lambda$1(view, windowInsetsCompat);
                return onCreate$lambda$1;
            }
        });
        MediaChooseConfig mediaChooseConfig = (MediaChooseConfig) getIntent().getParcelableExtra(MediaChooseContract.EXTRA_PREVIEW_CONFIG);
        if (mediaChooseConfig == null) {
            String string = getString(R.string.trae_media_choose_send);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            mediaChooseConfig = new MediaChooseConfig(0, null, false, false, false, false, false, string, 0, false, 895, null);
        }
        this.config = mediaChooseConfig;
        MediaChooseConfig mediaChooseConfig2 = this.config;
        if (mediaChooseConfig2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            mediaChooseConfig2 = null;
        }
        MediaSelection mediaSelection = new MediaSelection(mediaChooseConfig2);
        this.selection = mediaSelection;
        mediaSelection.setKeepOrigin(getIntent().getBooleanExtra(MediaChooseContract.EXTRA_PREVIEW_KEEP_ORIGIN, false));
        this.maxTotalSize = getIntent().getLongExtra(MediaChooseContract.EXTRA_MAX_TOTAL_SIZE, Long.MAX_VALUE);
        this.singleMaxSize = getIntent().getLongExtra(MediaChooseContract.EXTRA_MAX_SINGLE_SIZE, Long.MAX_VALUE);
        List<MediaItem> previewItemsCache = MediaChooseContract.INSTANCE.getPreviewItemsCache();
        if (previewItemsCache == null) {
            previewItemsCache = CollectionsKt.emptyList();
        }
        this.items = previewItemsCache;
        MediaChooseContract.INSTANCE.setPreviewItemsCache(null);
        int intExtra = getIntent().getIntExtra(MediaChooseContract.EXTRA_PREVIEW_INDEX, 0);
        List<MediaItem> list = this.items;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("items");
            list = null;
        }
        int coerceIn = RangesKt.coerceIn(intExtra, 0, RangesKt.coerceAtLeast(list.size() - 1, 0));
        long[] longArrayExtra = getIntent().getLongArrayExtra(MediaChooseContract.EXTRA_PREVIEW_SELECTED_IDS);
        if (longArrayExtra == null) {
            longArrayExtra = new long[0];
        }
        Set set = ArraysKt.toSet(longArrayExtra);
        MediaSelection mediaSelection2 = this.selection;
        if (mediaSelection2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selection");
            mediaSelection2 = null;
        }
        List<MediaItem> list2 = this.items;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("items");
            list2 = null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            if (set.contains(Long.valueOf(((MediaItem) obj).getId()))) {
                arrayList.add(obj);
            }
        }
        mediaSelection2.setSelected(arrayList);
        List<MediaItem> list3 = this.items;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("items");
            list3 = null;
        }
        this.adapter = new PreviewPagerAdapter(list3);
        TraeMediaChooseActivityPreviewBinding traeMediaChooseActivityPreviewBinding4 = this.binding;
        if (traeMediaChooseActivityPreviewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeMediaChooseActivityPreviewBinding4 = null;
        }
        ViewPager2 viewPager2 = traeMediaChooseActivityPreviewBinding4.pager;
        PreviewPagerAdapter previewPagerAdapter = this.adapter;
        if (previewPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            previewPagerAdapter = null;
        }
        viewPager2.setAdapter(previewPagerAdapter);
        TraeMediaChooseActivityPreviewBinding traeMediaChooseActivityPreviewBinding5 = this.binding;
        if (traeMediaChooseActivityPreviewBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeMediaChooseActivityPreviewBinding5 = null;
        }
        traeMediaChooseActivityPreviewBinding5.pager.setCurrentItem(coerceIn, false);
        TraeMediaChooseActivityPreviewBinding traeMediaChooseActivityPreviewBinding6 = this.binding;
        if (traeMediaChooseActivityPreviewBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeMediaChooseActivityPreviewBinding6 = null;
        }
        traeMediaChooseActivityPreviewBinding6.btnBack.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.mediachoose.ui.PreviewActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PreviewActivity.this.returnSelectionAndFinish();
            }
        });
        TraeMediaChooseActivityPreviewBinding traeMediaChooseActivityPreviewBinding7 = this.binding;
        if (traeMediaChooseActivityPreviewBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeMediaChooseActivityPreviewBinding7 = null;
        }
        traeMediaChooseActivityPreviewBinding7.selectionContainer.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.mediachoose.ui.PreviewActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PreviewActivity.onCreate$lambda$5(PreviewActivity.this, view);
            }
        });
        TraeMediaChooseActivityPreviewBinding traeMediaChooseActivityPreviewBinding8 = this.binding;
        if (traeMediaChooseActivityPreviewBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeMediaChooseActivityPreviewBinding8 = null;
        }
        CheckBox checkBox = traeMediaChooseActivityPreviewBinding8.cbOrigin;
        MediaChooseConfig mediaChooseConfig3 = this.config;
        if (mediaChooseConfig3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            mediaChooseConfig3 = null;
        }
        checkBox.setVisibility(mediaChooseConfig3.getShowOrigin() ? 0 : 8);
        TraeMediaChooseActivityPreviewBinding traeMediaChooseActivityPreviewBinding9 = this.binding;
        if (traeMediaChooseActivityPreviewBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeMediaChooseActivityPreviewBinding9 = null;
        }
        CheckBox checkBox2 = traeMediaChooseActivityPreviewBinding9.cbOrigin;
        MediaSelection mediaSelection3 = this.selection;
        if (mediaSelection3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selection");
            mediaSelection3 = null;
        }
        checkBox2.setChecked(mediaSelection3.getKeepOrigin());
        TraeMediaChooseActivityPreviewBinding traeMediaChooseActivityPreviewBinding10 = this.binding;
        if (traeMediaChooseActivityPreviewBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeMediaChooseActivityPreviewBinding10 = null;
        }
        traeMediaChooseActivityPreviewBinding10.cbOrigin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.bytedance.trae.conversation.mediachoose.ui.PreviewActivity$$ExternalSyntheticLambda4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                PreviewActivity.onCreate$lambda$6(PreviewActivity.this, compoundButton, z);
            }
        });
        TraeMediaChooseActivityPreviewBinding traeMediaChooseActivityPreviewBinding11 = this.binding;
        if (traeMediaChooseActivityPreviewBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeMediaChooseActivityPreviewBinding11 = null;
        }
        traeMediaChooseActivityPreviewBinding11.btnSend.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.mediachoose.ui.PreviewActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PreviewActivity.this.sendAndFinish();
            }
        });
        TraeMediaChooseActivityPreviewBinding traeMediaChooseActivityPreviewBinding12 = this.binding;
        if (traeMediaChooseActivityPreviewBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            traeMediaChooseActivityPreviewBinding = traeMediaChooseActivityPreviewBinding12;
        }
        traeMediaChooseActivityPreviewBinding.pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.bytedance.trae.conversation.mediachoose.ui.PreviewActivity$onCreate$8
            public void onPageSelected(int position) {
                PreviewPagerAdapter previewPagerAdapter2;
                super.onPageSelected(position);
                previewPagerAdapter2 = PreviewActivity.this.adapter;
                if (previewPagerAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    previewPagerAdapter2 = null;
                }
                previewPagerAdapter2.onPageSelected(position);
                PreviewActivity.this.updateControls();
            }
        });
        updateControls();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat onCreate$lambda$0(View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(view, "v");
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "insets");
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
        view.setPadding(view.getPaddingLeft(), insets.top, view.getPaddingRight(), view.getPaddingBottom());
        return windowInsetsCompat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat onCreate$lambda$1(View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(view, "v");
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "insets");
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), insets.bottom);
        return windowInsetsCompat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onCreate$lambda$5(PreviewActivity previewActivity, View view) {
        MediaItem currentItem = previewActivity.getCurrentItem();
        if (currentItem == null) {
            return;
        }
        MediaSelection mediaSelection = previewActivity.selection;
        MediaChooseConfig mediaChooseConfig = null;
        if (mediaSelection == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selection");
            mediaSelection = null;
        }
        if (!mediaSelection.isSelected(currentItem.getId())) {
            if (!currentItem.isVideo() && currentItem.getSizeBytes() > previewActivity.singleMaxSize) {
                long j = 1024;
                String string = previewActivity.getString(R.string.trae_media_choose_file_too_large, new Object[]{Long.valueOf((previewActivity.singleMaxSize / j) / j)});
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                Toast.makeText((Context) previewActivity, string, 0).show();
                return;
            }
            if (previewActivity.maxTotalSize != Long.MAX_VALUE) {
                MediaSelection mediaSelection2 = previewActivity.selection;
                if (mediaSelection2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selection");
                    mediaSelection2 = null;
                }
                Iterator<T> it = mediaSelection2.selectedItems().iterator();
                long j2 = 0;
                while (it.hasNext()) {
                    j2 += ((MediaItem) it.next()).getSizeBytes();
                }
                if (j2 + currentItem.getSizeBytes() > previewActivity.maxTotalSize) {
                    Toast.makeText((Context) previewActivity, R.string.trae_media_choose_total_size_too_large, 0).show();
                    return;
                }
            }
        }
        MediaSelection mediaSelection3 = previewActivity.selection;
        if (mediaSelection3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selection");
            mediaSelection3 = null;
        }
        if (mediaSelection3.toggle(currentItem) == MediaSelection.ToggleResult.ReachMax) {
            Context context = (Context) previewActivity;
            int i = R.string.trae_media_choose_reach_max;
            Object[] objArr = new Object[1];
            MediaChooseConfig mediaChooseConfig2 = previewActivity.config;
            if (mediaChooseConfig2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("config");
            } else {
                mediaChooseConfig = mediaChooseConfig2;
            }
            objArr[0] = Integer.valueOf(mediaChooseConfig.getMaxSelectCount());
            Toast.makeText(context, previewActivity.getString(i, objArr), 0).show();
            return;
        }
        previewActivity.updateControls();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$6(PreviewActivity previewActivity, CompoundButton compoundButton, boolean z) {
        MediaSelection mediaSelection = previewActivity.selection;
        if (mediaSelection == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selection");
            mediaSelection = null;
        }
        mediaSelection.setKeepOrigin(z);
    }

    /* renamed from: com_bytedance_trae_conversation_mediachoose_ui_PreviewActivity__onStop$___twin___ */
    public void m834x630a639a() {
        super.onStop();
        PreviewPagerAdapter previewPagerAdapter = this.adapter;
        if (previewPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            previewPagerAdapter = null;
        }
        previewPagerAdapter.stopCurrentVideo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateControls() {
        String str;
        MediaItem currentItem = getCurrentItem();
        MediaChooseConfig mediaChooseConfig = null;
        if (currentItem == null) {
            TraeMediaChooseActivityPreviewBinding traeMediaChooseActivityPreviewBinding = this.binding;
            if (traeMediaChooseActivityPreviewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                traeMediaChooseActivityPreviewBinding = null;
            }
            traeMediaChooseActivityPreviewBinding.selectionContainer.setSelected(false);
            TraeMediaChooseActivityPreviewBinding traeMediaChooseActivityPreviewBinding2 = this.binding;
            if (traeMediaChooseActivityPreviewBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                traeMediaChooseActivityPreviewBinding2 = null;
            }
            traeMediaChooseActivityPreviewBinding2.tvOrder.setText("");
            TraeMediaChooseActivityPreviewBinding traeMediaChooseActivityPreviewBinding3 = this.binding;
            if (traeMediaChooseActivityPreviewBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                traeMediaChooseActivityPreviewBinding3 = null;
            }
            TextView textView = traeMediaChooseActivityPreviewBinding3.btnSend;
            MediaChooseConfig mediaChooseConfig2 = this.config;
            if (mediaChooseConfig2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("config");
            } else {
                mediaChooseConfig = mediaChooseConfig2;
            }
            textView.setText(mediaChooseConfig.getActionText());
            return;
        }
        MediaSelection mediaSelection = this.selection;
        if (mediaSelection == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selection");
            mediaSelection = null;
        }
        String orderText = mediaSelection.getOrderText(currentItem.getId());
        TraeMediaChooseActivityPreviewBinding traeMediaChooseActivityPreviewBinding4 = this.binding;
        if (traeMediaChooseActivityPreviewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeMediaChooseActivityPreviewBinding4 = null;
        }
        String str2 = orderText;
        traeMediaChooseActivityPreviewBinding4.selectionContainer.setSelected(str2.length() > 0);
        TraeMediaChooseActivityPreviewBinding traeMediaChooseActivityPreviewBinding5 = this.binding;
        if (traeMediaChooseActivityPreviewBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeMediaChooseActivityPreviewBinding5 = null;
        }
        traeMediaChooseActivityPreviewBinding5.tvOrder.setText(str2);
        MediaSelection mediaSelection2 = this.selection;
        if (mediaSelection2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selection");
            mediaSelection2 = null;
        }
        int selectedCount = mediaSelection2.selectedCount();
        TraeMediaChooseActivityPreviewBinding traeMediaChooseActivityPreviewBinding6 = this.binding;
        if (traeMediaChooseActivityPreviewBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeMediaChooseActivityPreviewBinding6 = null;
        }
        TextView textView2 = traeMediaChooseActivityPreviewBinding6.btnSend;
        if (selectedCount == 0) {
            MediaChooseConfig mediaChooseConfig3 = this.config;
            if (mediaChooseConfig3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("config");
            } else {
                mediaChooseConfig = mediaChooseConfig3;
            }
            str = mediaChooseConfig.getActionText();
        } else {
            int i = R.string.trae_media_choose_send_with_count;
            Object[] objArr = new Object[2];
            MediaChooseConfig mediaChooseConfig4 = this.config;
            if (mediaChooseConfig4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("config");
            } else {
                mediaChooseConfig = mediaChooseConfig4;
            }
            objArr[0] = mediaChooseConfig.getActionText();
            objArr[1] = Integer.valueOf(selectedCount);
            String string = getString(i, objArr);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            str = string;
        }
        textView2.setText(str);
    }

    private final MediaItem getCurrentItem() {
        TraeMediaChooseActivityPreviewBinding traeMediaChooseActivityPreviewBinding = this.binding;
        List<MediaItem> list = null;
        if (traeMediaChooseActivityPreviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeMediaChooseActivityPreviewBinding = null;
        }
        int currentItem = traeMediaChooseActivityPreviewBinding.pager.getCurrentItem();
        List<MediaItem> list2 = this.items;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("items");
        } else {
            list = list2;
        }
        return (MediaItem) CollectionsKt.getOrNull(list, currentItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void sendAndFinish() {
        MediaSelection mediaSelection = this.selection;
        MediaSelection mediaSelection2 = null;
        if (mediaSelection == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selection");
            mediaSelection = null;
        }
        List mutableList = CollectionsKt.toMutableList(mediaSelection.selectedItems());
        boolean z = true;
        if (mutableList.isEmpty()) {
            MediaItem currentItem = getCurrentItem();
            if (currentItem == null) {
                return;
            }
            if (!currentItem.isVideo() && currentItem.getSizeBytes() > this.singleMaxSize) {
                long j = 1024;
                String string = getString(R.string.trae_media_choose_file_too_large, new Object[]{Long.valueOf((this.singleMaxSize / j) / j)});
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                Toast.makeText((Context) this, string, 0).show();
                return;
            }
            MediaSelection mediaSelection3 = this.selection;
            if (mediaSelection3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selection");
                mediaSelection3 = null;
            }
            mediaSelection3.toggle(currentItem);
            MediaSelection mediaSelection4 = this.selection;
            if (mediaSelection4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selection");
                mediaSelection4 = null;
            }
            mutableList.addAll(mediaSelection4.selectedItems());
        }
        List list = mutableList;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((MediaItem) it.next()).isVideo()) {
                    break;
                }
            }
        }
        z = false;
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra(MediaChooseContract.RESULT_SELECTED, new ArrayList<>(mutableList));
        MediaSelection mediaSelection5 = this.selection;
        if (mediaSelection5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selection");
        } else {
            mediaSelection2 = mediaSelection5;
        }
        intent.putExtra(MediaChooseContract.RESULT_KEEP_ORIGIN, mediaSelection2.getKeepOrigin());
        intent.putExtra(MediaChooseContract.RESULT_HAS_VIDEO, z);
        Unit unit = Unit.INSTANCE;
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void returnSelectionAndFinish() {
        Intent intent = new Intent();
        MediaSelection mediaSelection = this.selection;
        MediaSelection mediaSelection2 = null;
        if (mediaSelection == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selection");
            mediaSelection = null;
        }
        List<MediaItem> selectedItems = mediaSelection.selectedItems();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(selectedItems, 10));
        Iterator<T> it = selectedItems.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((MediaItem) it.next()).getId()));
        }
        intent.putExtra(MediaChooseContract.RESULT_BACK_SELECTED_IDS, CollectionsKt.toLongArray(arrayList));
        MediaSelection mediaSelection3 = this.selection;
        if (mediaSelection3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selection");
        } else {
            mediaSelection2 = mediaSelection3;
        }
        intent.putExtra(MediaChooseContract.RESULT_BACK_KEEP_ORIGIN, mediaSelection2.getKeepOrigin());
        Unit unit = Unit.INSTANCE;
        setResult(2, intent);
        finish();
    }

    @Deprecated(message = "Deprecated in Java")
    public void onBackPressed() {
        returnSelectionAndFinish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_conversation_mediachoose_ui_PreviewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m833xf0b666a1(PreviewActivity previewActivity) {
        previewActivity.m834x630a639a();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) previewActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
