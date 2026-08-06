package com.bytedance.trae.home.solo.sitemessage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.ConversationActivity;
import com.bytedance.trae.conversation.ShareWebViewActivity;
import com.bytedance.trae.conversation.devices.DeviceProductType;
import com.bytedance.trae.conversation.devices.MobileIdeFeatureGate;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.home.C0820R;
import com.bytedance.trae.im.model.MessagePart;
import com.bytedance.trae.utils.TrustedDomainUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: SiteMessageListFragment.kt */
@Metadata(d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\b\n\u0002\b\u0004*\u0001B\b\u0007\u0018\u0000 D2\u00020\u0001:\u0001DB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u001c\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010&\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020$H\u0002J\b\u0010(\u001a\u00020$H\u0002J\b\u0010)\u001a\u00020$H\u0002J\b\u0010*\u001a\u00020$H\u0002J\u0016\u0010+\u001a\u00020$2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-H\u0002J\u0010\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020.H\u0002J\u0010\u00101\u001a\u00020$2\u0006\u00100\u001a\u00020.H\u0002J\u0018\u00102\u001a\u00020$2\u0006\u00100\u001a\u00020.2\u0006\u00103\u001a\u000204H\u0002J\u001c\u00105\u001a\u0004\u0018\u0001042\u0006\u00103\u001a\u0002042\b\u00106\u001a\u0004\u0018\u000104H\u0002J\u001c\u00107\u001a\u00020$2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020409H\u0002J\u001c\u0010:\u001a\u00020$2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020409H\u0002J\u001c\u0010;\u001a\u00020$2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020409H\u0002J\u001c\u0010<\u001a\u00020$2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020409H\u0002J \u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020\r2\u0006\u00100\u001a\u00020.2\u0006\u0010?\u001a\u00020\u0018H\u0002J\u0018\u0010@\u001a\u00020$2\u0006\u0010?\u001a\u00020\u00182\u0006\u00100\u001a\u00020.H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0004\n\u0002\u0010C¨\u0006E"}, d2 = {"Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "titleBar", "Lcom/bytedance/trae/common/widget/TraeTitleBar;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "swipeRefresh", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "tvEmpty", "Landroid/widget/TextView;", "emptyState", "Landroid/view/View;", "dimOverlay", "floatingCard", "Landroid/widget/ImageView;", "adapter", "Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;", "readTracker", "Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;", "getReadTracker", "()Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;", "currentPage", "", "hasMore", "", "isLoading", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "navigateToSettings", "fetchFirstPage", "loadMore", "updateEmptyState", "markAllAsRead", "items", "", "Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;", "handleCtaTap", "item", "openInExternalBrowser", "routeByCommand", "commandId", "", "resolveDeepLink", "commandArgs", "routeToWebview", "params", "", "routeToConversation", "routeToNewtask", "routeToConnectDevice", "showDeletePopup", "anchorView", NewTaskTracker.Param.POSITION, "deleteItem", "scrollListener", "com/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$scrollListener$1", "Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$scrollListener$1;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SiteMessageListFragment extends Fragment {
    private SiteMessageAdapter adapter;
    private View dimOverlay;
    private View emptyState;
    private ImageView floatingCard;
    private boolean hasMore;
    private boolean isLoading;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefresh;
    private TraeTitleBar titleBar;
    private TextView tvEmpty;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private int currentPage = 1;
    private final SiteMessageListFragment$scrollListener$1 scrollListener = new RecyclerView.OnScrollListener() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment$scrollListener$1
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            SiteMessageAdapter siteMessageAdapter;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 1) {
                siteMessageAdapter = SiteMessageListFragment.this.adapter;
                if (siteMessageAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    siteMessageAdapter = null;
                }
                siteMessageAdapter.closeOpenItem();
            }
        }

        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            SiteMessageAdapter siteMessageAdapter;
            SiteMessageReadTracker readTracker;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            LinearLayoutManager layoutManager = recyclerView.getLayoutManager();
            LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? layoutManager : null;
            if (linearLayoutManager == null) {
                return;
            }
            if (linearLayoutManager.findLastVisibleItemPosition() >= linearLayoutManager.getItemCount() - 3) {
                SiteMessageListFragment.this.loadMore();
            }
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            if (findFirstVisibleItemPosition > findLastVisibleItemPosition) {
                return;
            }
            while (true) {
                siteMessageAdapter = SiteMessageListFragment.this.adapter;
                if (siteMessageAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    siteMessageAdapter = null;
                }
                SiteMessageItem item = siteMessageAdapter.getItem(findFirstVisibleItemPosition);
                if (item != null && Intrinsics.areEqual(item.isRead(), false)) {
                    readTracker = SiteMessageListFragment.this.getReadTracker();
                    readTracker.startTracking(item.getId());
                }
                if (findFirstVisibleItemPosition == findLastVisibleItemPosition) {
                    return;
                } else {
                    findFirstVisibleItemPosition++;
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public final SiteMessageReadTracker getReadTracker() {
        return SiteMessageRepository.INSTANCE.getReadTracker();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0820R.layout.fragment_site_message_list, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.titleBar = (TraeTitleBar) view.findViewById(C0820R.id.title_bar);
        this.recyclerView = view.findViewById(C0820R.id.rv_messages);
        this.swipeRefresh = view.findViewById(C0820R.id.swipe_refresh);
        this.tvEmpty = (TextView) view.findViewById(C0820R.id.tv_empty);
        this.emptyState = view.findViewById(C0820R.id.empty_state);
        this.dimOverlay = view.findViewById(C0820R.id.dim_overlay);
        this.floatingCard = (ImageView) view.findViewById(C0820R.id.floating_card);
        TraeTitleBar traeTitleBar = this.titleBar;
        if (traeTitleBar != null) {
            traeTitleBar.setOnLeftActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SiteMessageListFragment.onViewCreated$lambda$0(SiteMessageListFragment.this, view2);
                }
            });
        }
        if (AppHost.INSTANCE.isOversea()) {
            TraeTitleBar traeTitleBar2 = this.titleBar;
            if (traeTitleBar2 != null) {
                traeTitleBar2.setOnRightActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        SiteMessageListFragment.this.navigateToSettings();
                    }
                });
            }
        } else {
            TraeTitleBar traeTitleBar3 = this.titleBar;
            if (traeTitleBar3 != null) {
                traeTitleBar3.setRightActionsVisible(false);
            }
        }
        this.adapter = new SiteMessageAdapter(new Function1() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$2;
                onViewCreated$lambda$2 = SiteMessageListFragment.onViewCreated$lambda$2(SiteMessageListFragment.this, (SiteMessageItem) obj);
                return onViewCreated$lambda$2;
            }
        }, new Function2() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment$$ExternalSyntheticLambda6
            public final Object invoke(Object obj, Object obj2) {
                Unit onViewCreated$lambda$3;
                onViewCreated$lambda$3 = SiteMessageListFragment.onViewCreated$lambda$3(SiteMessageListFragment.this, (SiteMessageItem) obj, ((Integer) obj2).intValue());
                return onViewCreated$lambda$3;
            }
        }, new Function3() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment$$ExternalSyntheticLambda7
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit onViewCreated$lambda$4;
                onViewCreated$lambda$4 = SiteMessageListFragment.onViewCreated$lambda$4(SiteMessageListFragment.this, (View) obj, (SiteMessageItem) obj2, ((Integer) obj3).intValue());
                return onViewCreated$lambda$4;
            }
        }, new Function2() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment$$ExternalSyntheticLambda8
            public final Object invoke(Object obj, Object obj2) {
                Unit onViewCreated$lambda$5;
                onViewCreated$lambda$5 = SiteMessageListFragment.onViewCreated$lambda$5((SiteMessageItem) obj, ((Integer) obj2).intValue());
                return onViewCreated$lambda$5;
            }
        });
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
            SiteMessageAdapter siteMessageAdapter = this.adapter;
            if (siteMessageAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                siteMessageAdapter = null;
            }
            recyclerView.setAdapter(siteMessageAdapter);
            recyclerView.addOnScrollListener(this.scrollListener);
        }
        SwipeRefreshLayout swipeRefreshLayout = this.swipeRefresh;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment$$ExternalSyntheticLambda9
                public final void onRefresh() {
                    SiteMessageListFragment.this.fetchFirstPage();
                }
            });
        }
        SiteMessageRepository.INSTANCE.clearLocalUnreadBadge();
        fetchFirstPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(SiteMessageListFragment siteMessageListFragment, View view) {
        siteMessageListFragment.getParentFragmentManager().popBackStack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$2(SiteMessageListFragment siteMessageListFragment, SiteMessageItem siteMessageItem) {
        Intrinsics.checkNotNullParameter(siteMessageItem, "item");
        siteMessageListFragment.handleCtaTap(siteMessageItem);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$3(SiteMessageListFragment siteMessageListFragment, SiteMessageItem siteMessageItem, int i) {
        Intrinsics.checkNotNullParameter(siteMessageItem, "item");
        siteMessageListFragment.deleteItem(i, siteMessageItem);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$4(SiteMessageListFragment siteMessageListFragment, View view, SiteMessageItem siteMessageItem, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(siteMessageItem, "item");
        siteMessageListFragment.showDeletePopup(view, siteMessageItem, i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$5(SiteMessageItem siteMessageItem, int i) {
        Intrinsics.checkNotNullParameter(siteMessageItem, "item");
        SiteMessageTracker siteMessageTracker = SiteMessageTracker.INSTANCE;
        int id = siteMessageItem.getId();
        String notificationType = siteMessageItem.getNotificationType();
        if (notificationType == null) {
            notificationType = "";
        }
        siteMessageTracker.trackItemClick(id, notificationType, !Intrinsics.areEqual(siteMessageItem.isRead(), false), i);
        return Unit.INSTANCE;
    }

    public void onDestroyView() {
        super.onDestroyView();
        getReadTracker().flushReadReport();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateToSettings() {
        getParentFragmentManager().beginTransaction().setCustomAnimations(C0820R.anim.trae_slide_in_right, C0820R.anim.trae_slide_out_left, C0820R.anim.trae_slide_in_left, C0820R.anim.trae_slide_out_right).replace(C0820R.id.settings_fragment_container, SiteMessageSettingsFragment.INSTANCE.newInstance()).addToBackStack((String) null).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchFirstPage() {
        this.isLoading = true;
        this.currentPage = 1;
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new SiteMessageListFragment$fetchFirstPage$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadMore() {
        if (!this.hasMore || this.isLoading) {
            return;
        }
        this.isLoading = true;
        int i = this.currentPage + 1;
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new SiteMessageListFragment$loadMore$1(i, this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateEmptyState() {
        SiteMessageAdapter siteMessageAdapter = this.adapter;
        if (siteMessageAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            siteMessageAdapter = null;
        }
        boolean isEmpty = siteMessageAdapter.isEmpty();
        View view = this.emptyState;
        if (view != null) {
            view.setVisibility(isEmpty ? 0 : 8);
        }
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.setVisibility(isEmpty ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void markAllAsRead(List<SiteMessageItem> items) {
        List<SiteMessageItem> list = items;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (Intrinsics.areEqual(((SiteMessageItem) obj).isRead(), false)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(Integer.valueOf(((SiteMessageItem) it.next()).getId()));
        }
        ArrayList arrayList4 = arrayList3;
        if (arrayList4.isEmpty()) {
            return;
        }
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (SiteMessageItem siteMessageItem : list) {
            if (Intrinsics.areEqual(siteMessageItem.isRead(), false)) {
                siteMessageItem = SiteMessageItem.copy$default(siteMessageItem, 0, null, null, null, true, null, 47, null);
            }
            arrayList5.add(siteMessageItem);
        }
        ArrayList arrayList6 = arrayList5;
        SiteMessageAdapter siteMessageAdapter = this.adapter;
        if (siteMessageAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            siteMessageAdapter = null;
        }
        siteMessageAdapter.setData(arrayList6);
        SiteMessageRepository.updateStatus$default(SiteMessageRepository.INSTANCE, arrayList4, "read", null, null, 12, null);
    }

    private final void handleCtaTap(SiteMessageItem item) {
        if (item.getOpenInBrowser()) {
            openInExternalBrowser(item);
            return;
        }
        String commandId = item.getCommandId();
        String str = commandId;
        if (!(str == null || StringsKt.isBlank(str))) {
            routeByCommand(item, commandId);
            return;
        }
        String actionUrl = item.getActionUrl();
        String obj = actionUrl != null ? StringsKt.trim(actionUrl).toString() : null;
        if (obj == null || StringsKt.isBlank(obj)) {
            return;
        }
        openInExternalBrowser(item);
    }

    private final void openInExternalBrowser(SiteMessageItem item) {
        String obj;
        String actionUrl = item.getActionUrl();
        if (actionUrl == null || (obj = StringsKt.trim(actionUrl).toString()) == null) {
            return;
        }
        if (obj.length() == 0) {
            return;
        }
        Uri parse = Uri.parse(obj);
        String scheme = parse.getScheme();
        if (StringsKt.equals(scheme, "http", true) || StringsKt.equals(scheme, "https", true)) {
            SiteMessageTracker siteMessageTracker = SiteMessageTracker.INSTANCE;
            int id = item.getId();
            String actionTitle = item.getActionTitle();
            if (actionTitle == null) {
                actionTitle = "";
            }
            siteMessageTracker.trackCtaClick(id, actionTitle, obj);
            try {
                startActivity(new Intent("android.intent.action.VIEW", parse));
            } catch (Exception unused) {
            }
        }
    }

    private final void routeByCommand(SiteMessageItem item, String commandId) {
        Uri parse;
        String host;
        String resolveDeepLink = resolveDeepLink(commandId, item.getCommandArgs());
        if (resolveDeepLink == null || (host = (parse = Uri.parse(resolveDeepLink)).getHost()) == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : parse.getQueryParameterNames()) {
            String queryParameter = parse.getQueryParameter(str);
            if (queryParameter != null) {
                linkedHashMap.put(str, queryParameter);
            }
        }
        SiteMessageTracker siteMessageTracker = SiteMessageTracker.INSTANCE;
        int id = item.getId();
        String actionTitle = item.getActionTitle();
        if (actionTitle == null) {
            actionTitle = "";
        }
        siteMessageTracker.trackCtaClick(id, actionTitle, resolveDeepLink);
        int hashCode = host.hashCode();
        if (hashCode == 740154499) {
            if (host.equals("conversation")) {
                routeToConversation(linkedHashMap);
            }
        } else if (hashCode == 1224424441) {
            if (host.equals(MessagePart.TYPE_WEBVIEW)) {
                routeToWebview(linkedHashMap);
            }
        } else if (hashCode == 1846152997 && host.equals("newtask")) {
            routeToNewtask(linkedHashMap);
        }
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment$resolveDeepLink$type$1] */
    private final String resolveDeepLink(String commandId, String commandArgs) {
        if (!Intrinsics.areEqual(commandId, "in_app_navigation")) {
            return commandId;
        }
        String str = commandArgs;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        try {
            Object fromJson = new Gson().fromJson(commandArgs, new TypeToken<Map<String, ? extends String>>() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment$resolveDeepLink$type$1
            }.getType());
            Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
            return (String) ((Map) fromJson).get(IWeixinService.ResponseConstants.URL);
        } catch (Exception unused) {
            return null;
        }
    }

    private final void routeToWebview(Map<String, String> params) {
        Context context;
        String str = params.get(IWeixinService.ResponseConstants.URL);
        if (str == null || !TrustedDomainUtils.INSTANCE.isTrustedUrl(str) || (context = getContext()) == null) {
            return;
        }
        ShareWebViewActivity.INSTANCE.start(context, str, (r16 & 4) != 0 ? null : null, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? "inside" : null);
    }

    private final void routeToConversation(Map<String, String> params) {
        Context context;
        String str = params.get("conversation_id");
        if (str == null || (context = getContext()) == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) ConversationActivity.class);
        intent.putExtra(ConversationActivity.EXTRA_CONVERSATION_ID, str);
        intent.putExtra(ConversationActivity.EXTRA_ENTER_FROM, "site_message");
        startActivity(intent);
    }

    private final void routeToNewtask(Map<String, String> params) {
        String str = params.get("action");
        if (str != null && Intrinsics.areEqual(str, "connect_device")) {
            routeToConnectDevice(params);
        }
    }

    private final void routeToConnectDevice(Map<String, String> params) {
        String str = params.get(Constant.KEY_DEVICE_TYPE);
        if (str == null) {
            str = "work";
        }
        DeviceProductType deviceProductType = Intrinsics.areEqual(str, "ide") ? DeviceProductType.IDE : DeviceProductType.WORK;
        if (!MobileIdeFeatureGate.INSTANCE.canOpenConnectGuide(deviceProductType)) {
            deviceProductType = DeviceProductType.WORK;
        }
        Context context = getContext();
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) ConversationActivity.class);
        intent.putExtra(ConversationActivity.EXTRA_ENTER_FROM, "site_message");
        intent.putExtra(ConversationActivity.EXTRA_PENDING_CONNECT_DEVICE_TYPE, deviceProductType.name());
        if (deviceProductType == DeviceProductType.IDE) {
            intent.putExtra("extra_mode", "code");
        }
        startActivity(intent);
    }

    private final void showDeletePopup(View anchorView, final SiteMessageItem item, final int position) {
        View findViewById;
        Context context = anchorView.getContext();
        float f = context.getResources().getDisplayMetrics().density;
        View view = getView();
        if (view == null || (findViewById = view.findViewById(C0820R.id.root_container)) == null) {
            return;
        }
        SiteMessageAdapter siteMessageAdapter = this.adapter;
        if (siteMessageAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            siteMessageAdapter = null;
        }
        siteMessageAdapter.closeOpenItem();
        Object parent = anchorView.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        if (view2 == null) {
            view2 = anchorView;
        }
        try {
            final Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNull(createBitmap);
            view2.draw(new Canvas(createBitmap));
            int[] iArr = new int[2];
            view2.getLocationInWindow(iArr);
            int[] iArr2 = new int[2];
            findViewById.getLocationInWindow(iArr2);
            int i = iArr[0] - iArr2[0];
            int i2 = iArr[1] - iArr2[1];
            ImageView imageView = this.floatingCard;
            if (imageView != null) {
                imageView.setImageBitmap(createBitmap);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(view2.getWidth(), view2.getHeight());
                layoutParams.leftMargin = i;
                layoutParams.topMargin = i2;
                imageView.setLayoutParams(layoutParams);
                imageView.setVisibility(0);
            }
            View view3 = this.dimOverlay;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            View inflate = LayoutInflater.from(context).inflate(C0820R.layout.popup_message_delete, (ViewGroup) null);
            final PopupWindow popupWindow = new PopupWindow(inflate, (int) (240 * f), (int) (44 * f), true);
            popupWindow.setElevation(8.0f * f);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment$$ExternalSyntheticLambda0
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    SiteMessageListFragment.showDeletePopup$lambda$17(SiteMessageListFragment.this, createBitmap);
                }
            });
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    SiteMessageListFragment.showDeletePopup$lambda$18(popupWindow, this, position, item, view4);
                }
            });
            popupWindow.showAtLocation(findViewById, 0, iArr[0], iArr[1] + view2.getHeight() + ((int) (8 * f)));
        } catch (OutOfMemoryError unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDeletePopup$lambda$17(SiteMessageListFragment siteMessageListFragment, Bitmap bitmap) {
        View view = siteMessageListFragment.dimOverlay;
        if (view != null) {
            view.setVisibility(8);
        }
        ImageView imageView = siteMessageListFragment.floatingCard;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        ImageView imageView2 = siteMessageListFragment.floatingCard;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        bitmap.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDeletePopup$lambda$18(PopupWindow popupWindow, SiteMessageListFragment siteMessageListFragment, int i, SiteMessageItem siteMessageItem, View view) {
        popupWindow.dismiss();
        siteMessageListFragment.deleteItem(i, siteMessageItem);
    }

    private final void deleteItem(int position, final SiteMessageItem item) {
        Object obj;
        SiteMessageAdapter siteMessageAdapter = this.adapter;
        SiteMessageAdapter siteMessageAdapter2 = null;
        if (siteMessageAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            siteMessageAdapter = null;
        }
        siteMessageAdapter.closeOpenItem();
        SiteMessageAdapter siteMessageAdapter3 = this.adapter;
        if (siteMessageAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            siteMessageAdapter3 = null;
        }
        Iterator it = RangesKt.until(0, siteMessageAdapter3.getItemCount()).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            int intValue = ((Number) obj).intValue();
            SiteMessageAdapter siteMessageAdapter4 = this.adapter;
            if (siteMessageAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                siteMessageAdapter4 = null;
            }
            SiteMessageItem item2 = siteMessageAdapter4.getItem(intValue);
            if (item2 != null && item2.getId() == item.getId()) {
                break;
            }
        }
        Integer num = (Integer) obj;
        if (num != null) {
            position = num.intValue();
        }
        SiteMessageTracker.INSTANCE.trackItemDelete(item.getId(), position);
        SiteMessageAdapter siteMessageAdapter5 = this.adapter;
        if (siteMessageAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            siteMessageAdapter2 = siteMessageAdapter5;
        }
        siteMessageAdapter2.removeAt(position);
        updateEmptyState();
        SiteMessageRepository.updateStatus$default(SiteMessageRepository.INSTANCE, CollectionsKt.listOf(Integer.valueOf(item.getId())), "delete", null, new Function0() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment$$ExternalSyntheticLambda2
            public final Object invoke() {
                Unit deleteItem$lambda$20;
                deleteItem$lambda$20 = SiteMessageListFragment.deleteItem$lambda$20(SiteMessageListFragment.this, item);
                return deleteItem$lambda$20;
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteItem$lambda$20(SiteMessageListFragment siteMessageListFragment, SiteMessageItem siteMessageItem) {
        siteMessageListFragment.getReadTracker().cachePendingDeleteEvent(siteMessageItem.getId());
        return Unit.INSTANCE;
    }

    /* compiled from: SiteMessageListFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SiteMessageListFragment newInstance() {
            return new SiteMessageListFragment();
        }
    }
}
