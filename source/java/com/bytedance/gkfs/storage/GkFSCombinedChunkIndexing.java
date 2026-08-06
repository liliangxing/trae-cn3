package com.bytedance.gkfs.storage;

import com.bytedance.gkfs.GkFSLogger;
import com.bytedance.gkfs.UtilsKt$traceTime$1$1;
import com.bytedance.gkfs.io.BlockIdentifier;
import com.bytedance.gkfs.io.ChunkIdentifier;
import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaConstants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: indexing.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0000\u0018\u0000 82\u00020\u0001:\u00018B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001f\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0015J\u001d\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0019J\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001b\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u001cJ\u001f\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\tH\u0000¢\u0006\u0002\b J\u0017\u0010!\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001b\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\"J\u0010\u0010#\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u0015\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u0011H\u0000¢\u0006\u0002\b&J%\u0010'\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u001eH\u0000¢\u0006\u0002\b(J\u001d\u0010)\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0000¢\u0006\u0002\b*J5\u0010+\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020-0,0,2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\t0/H\u0001¢\u0006\u0004\b0\u00101J\f\u00102\u001a\u00020\u001e*\u000203H\u0002J\u001c\u00104\u001a\u00020\u0011*\u0002032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u00105\u001a\u000206H\u0002J\f\u00107\u001a\u000203*\u00020\u001eH\u0002J\f\u00107\u001a\u000203*\u00020\u0011H\u0003R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/bytedance/gkfs/storage/GkFSCombinedChunkIndexing;", "", "logger", "Lcom/bytedance/gkfs/GkFSLogger;", "kevaRoot", "Ljava/io/File;", "(Lcom/bytedance/gkfs/GkFSLogger;Ljava/io/File;)V", "blockIndexingRepos", "", "Lcom/bytedance/gkfs/io/BlockIdentifier;", "Lcom/bytedance/keva/Keva;", "chunkIndexingRepo", "getChunkIndexingRepo", "()Lcom/bytedance/keva/Keva;", "chunkIndexingRepo$delegate", "Lkotlin/Lazy;", "delete", "Lcom/bytedance/gkfs/storage/ChunkIndexingInfo;", "id", "Lcom/bytedance/gkfs/io/ChunkIdentifier;", "majorFile", "delete$geckox_noasanRelease", "deleteBlock", "", "blockId", "deleteBlock$geckox_noasanRelease", "find", "identity", "find$geckox_noasanRelease", "findBlock", "Lcom/bytedance/gkfs/storage/ChunkBlockIndexingInfo;", "chunkId", "findBlock$geckox_noasanRelease", "findGeneral", "findGeneral$geckox_noasanRelease", "getBlockIndexingRepo", "insertOrCover", "info", "insertOrCover$geckox_noasanRelease", "insertOrCoverBlock", "insertOrCoverBlock$geckox_noasanRelease", "insertReference", "insertReference$geckox_noasanRelease", "tidyUp", "", "Lcom/bytedance/gkfs/storage/ChunkIndexingTidyUpInfo;", "existingBlocks", "", "tidyUp$geckox_noasanRelease", "([Lcom/bytedance/gkfs/io/BlockIdentifier;)Ljava/util/Map;", "toBlockInfo", "Lorg/json/JSONObject;", "toGeneralInfo", "timeCost", "", "toJSON", "Companion", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GkFSCombinedChunkIndexing {
    private static final String BLOCK_INDEXING_FILE_PREFIX = "gkfs_block_indexing_";
    private static final String BLOCK_INDEX_KEY_OFFSET = "offset";
    private static final String BLOCK_INDEX_KEY_SIZE = "size";
    private static final String CHUNK_INDEXING_FILE = "gkfs_combined_chunk_indexing";
    private static final String CHUNK_INDEX_KEY_BLOCK_ID = "block_id";
    private static final String CHUNK_INDEX_KEY_REFERENCE = "reference";
    private static final String TAG = "ChunkIndexing";
    private final Map<BlockIdentifier, Keva> blockIndexingRepos;

    /* renamed from: chunkIndexingRepo$delegate, reason: from kotlin metadata */
    private final Lazy chunkIndexingRepo;
    private final File kevaRoot;
    private final GkFSLogger logger;

    private final Keva getChunkIndexingRepo() {
        return (Keva) this.chunkIndexingRepo.getValue();
    }

    public GkFSCombinedChunkIndexing(GkFSLogger gkFSLogger, File file) {
        Intrinsics.checkParameterIsNotNull(gkFSLogger, "logger");
        Intrinsics.checkParameterIsNotNull(file, "kevaRoot");
        this.logger = gkFSLogger;
        this.kevaRoot = file;
        this.chunkIndexingRepo = LazyKt.lazy(new Function0<Keva>() { // from class: com.bytedance.gkfs.storage.GkFSCombinedChunkIndexing$chunkIndexingRepo$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Keva m576invoke() {
                return Keva.getRepo("gkfs_combined_chunk_indexing", 1);
            }
        });
        this.blockIndexingRepos = new LinkedHashMap();
    }

    public /* synthetic */ GkFSCombinedChunkIndexing(GkFSLogger gkFSLogger, File file, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new GkFSLogger() : gkFSLogger, file);
    }

    private final Keva getBlockIndexingRepo(BlockIdentifier id) {
        Keva keva = this.blockIndexingRepos.get(id);
        if (keva != null) {
            return keva;
        }
        Keva repo = Keva.getRepo(BLOCK_INDEXING_FILE_PREFIX + id.getValue(), 1);
        Map<BlockIdentifier, Keva> map = this.blockIndexingRepos;
        Intrinsics.checkExpressionValueIsNotNull(repo, "repo");
        map.put(id, repo);
        return repo;
    }

    public final ChunkBlockIndexingInfo findBlock$geckox_noasanRelease(ChunkIdentifier chunkId, BlockIdentifier blockId) {
        Intrinsics.checkParameterIsNotNull(chunkId, "chunkId");
        Intrinsics.checkParameterIsNotNull(blockId, "blockId");
        String stringJustDisk = getBlockIndexingRepo(blockId).getStringJustDisk(chunkId.getValue(), (String) null);
        if (stringJustDisk == null) {
            return null;
        }
        if (!(stringJustDisk.length() > 0)) {
            stringJustDisk = null;
        }
        if (stringJustDisk != null) {
            return toBlockInfo(new JSONObject(stringJustDisk));
        }
        return null;
    }

    public final ChunkBlockIndexingInfo insertOrCoverBlock$geckox_noasanRelease(ChunkIdentifier id, BlockIdentifier blockId, ChunkBlockIndexingInfo info) throws IOException {
        Intrinsics.checkParameterIsNotNull(id, "id");
        Intrinsics.checkParameterIsNotNull(blockId, "blockId");
        Intrinsics.checkParameterIsNotNull(info, "info");
        getBlockIndexingRepo(blockId).storeStringJustDisk(id.getValue(), toJSON(info).toString());
        ChunkBlockIndexingInfo findBlock$geckox_noasanRelease = findBlock$geckox_noasanRelease(id, blockId);
        if (findBlock$geckox_noasanRelease != null) {
            if (!Intrinsics.areEqual(findBlock$geckox_noasanRelease, info)) {
                findBlock$geckox_noasanRelease = null;
            }
            if (findBlock$geckox_noasanRelease != null) {
                return info;
            }
        }
        throw new IOException("can not insert or cover block indexing of [" + id.getValue() + " : " + blockId.getValue() + ']');
    }

    public final ChunkIndexingInfo insertReference$geckox_noasanRelease(ChunkIdentifier id, File majorFile) throws IOException {
        Intrinsics.checkParameterIsNotNull(id, "id");
        Intrinsics.checkParameterIsNotNull(majorFile, "majorFile");
        ChunkIndexingInfo findGeneral$geckox_noasanRelease = findGeneral$geckox_noasanRelease(id);
        if (findGeneral$geckox_noasanRelease == null) {
            throw new IOException("can not find origin indexing info for " + id.getValue());
        }
        Set mutableSet = ArraysKt.toMutableSet(findGeneral$geckox_noasanRelease.getReference());
        String absolutePath = majorFile.getAbsolutePath();
        Intrinsics.checkExpressionValueIsNotNull(absolutePath, "majorFile.absolutePath");
        mutableSet.add(absolutePath);
        Object[] array = mutableSet.toArray(new String[0]);
        if (array != null) {
            ChunkIndexingInfo copy$default = ChunkIndexingInfo.copy$default(findGeneral$geckox_noasanRelease, null, null, (String[]) array, null, 0L, 27, null);
            getChunkIndexingRepo().storeStringJustDisk(id.getValue(), toJSON(copy$default).toString());
            ChunkIndexingInfo findGeneral$geckox_noasanRelease2 = findGeneral$geckox_noasanRelease(id);
            if (findGeneral$geckox_noasanRelease2 != null) {
                if (!ArraysKt.contains(findGeneral$geckox_noasanRelease2.getReference(), majorFile.getAbsolutePath())) {
                    findGeneral$geckox_noasanRelease2 = null;
                }
                if (findGeneral$geckox_noasanRelease2 != null) {
                    return copy$default;
                }
            }
            throw new IOException("can not insert reference of " + id.getValue());
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final void deleteBlock$geckox_noasanRelease(ChunkIdentifier id, BlockIdentifier blockId) {
        Intrinsics.checkParameterIsNotNull(id, "id");
        Intrinsics.checkParameterIsNotNull(blockId, "blockId");
        getBlockIndexingRepo(blockId).erase(id.getValue());
    }

    private final ChunkIndexingInfo toGeneralInfo(JSONObject jSONObject, ChunkIdentifier chunkIdentifier, long j) {
        Object obj;
        BlockIdentifier blockIdentifier = new BlockIdentifier(jSONObject.getInt(CHUNK_INDEX_KEY_BLOCK_ID));
        try {
            Result.Companion companion = Result.Companion;
            JSONArray jSONArray = jSONObject.getJSONArray(CHUNK_INDEX_KEY_REFERENCE);
            int length = jSONArray.length();
            String[] strArr = new String[length];
            for (int i = 0; i < length; i++) {
                String string = jSONArray.getString(i);
                Intrinsics.checkExpressionValueIsNotNull(string, "jArray.getString(index)");
                strArr[i] = string;
            }
            obj = Result.constructor-impl(strArr);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        String[] strArr2 = (String[]) obj;
        if (strArr2 == null) {
            strArr2 = new String[0];
        }
        return new ChunkIndexingInfo(chunkIdentifier, blockIdentifier, strArr2, null, j, 8, null);
    }

    private final ChunkBlockIndexingInfo toBlockInfo(JSONObject jSONObject) {
        return new ChunkBlockIndexingInfo(jSONObject.getLong(BLOCK_INDEX_KEY_OFFSET), jSONObject.getInt("size"));
    }

    private final JSONObject toJSON(ChunkIndexingInfo chunkIndexingInfo) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(CHUNK_INDEX_KEY_BLOCK_ID, chunkIndexingInfo.getBlockId().getValue());
        jSONObject.put(CHUNK_INDEX_KEY_REFERENCE, new JSONArray(chunkIndexingInfo.getReference()));
        return jSONObject;
    }

    private final JSONObject toJSON(ChunkBlockIndexingInfo chunkBlockIndexingInfo) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(BLOCK_INDEX_KEY_OFFSET, chunkBlockIndexingInfo.getOffset());
        jSONObject.put("size", chunkBlockIndexingInfo.getSize());
        return jSONObject;
    }

    public final ChunkIndexingInfo find$geckox_noasanRelease(ChunkIdentifier identity) {
        ChunkBlockIndexingInfo findBlock$geckox_noasanRelease;
        Intrinsics.checkParameterIsNotNull(identity, "identity");
        UtilsKt$traceTime$1$1 utilsKt$traceTime$1$1 = new UtilsKt$traceTime$1$1(System.currentTimeMillis());
        ChunkIndexingInfo findGeneral$geckox_noasanRelease = findGeneral$geckox_noasanRelease(identity);
        if (findGeneral$geckox_noasanRelease == null || (findBlock$geckox_noasanRelease = findBlock$geckox_noasanRelease(identity, findGeneral$geckox_noasanRelease.getBlockId())) == null) {
            return null;
        }
        return ChunkIndexingInfo.copy$default(findGeneral$geckox_noasanRelease, identity, null, null, findBlock$geckox_noasanRelease, ((Number) utilsKt$traceTime$1$1.invoke()).longValue(), 6, null);
    }

    public final ChunkIndexingInfo findGeneral$geckox_noasanRelease(ChunkIdentifier identity) {
        ChunkIndexingInfo generalInfo;
        Intrinsics.checkParameterIsNotNull(identity, "identity");
        UtilsKt$traceTime$1$1 utilsKt$traceTime$1$1 = new UtilsKt$traceTime$1$1(System.currentTimeMillis());
        String stringJustDisk = getChunkIndexingRepo().getStringJustDisk(identity.getValue(), (String) null);
        if (stringJustDisk == null) {
            return null;
        }
        if (!(stringJustDisk.length() > 0)) {
            stringJustDisk = null;
        }
        if (stringJustDisk == null || (generalInfo = toGeneralInfo(new JSONObject(stringJustDisk), identity, ((Number) utilsKt$traceTime$1$1.invoke()).longValue())) == null) {
            return null;
        }
        return generalInfo;
    }

    public final ChunkIndexingInfo insertOrCover$geckox_noasanRelease(ChunkIndexingInfo info) throws IOException {
        Object obj;
        Intrinsics.checkParameterIsNotNull(info, "info");
        UtilsKt$traceTime$1$1 utilsKt$traceTime$1$1 = new UtilsKt$traceTime$1$1(System.currentTimeMillis());
        String stringJustDisk = getChunkIndexingRepo().getStringJustDisk(info.getId().getValue(), (String) null);
        getChunkIndexingRepo().storeStringJustDisk(info.getId().getValue(), toJSON(info).toString());
        ChunkIndexingInfo findGeneral$geckox_noasanRelease = findGeneral$geckox_noasanRelease(info.getId());
        if (findGeneral$geckox_noasanRelease != null) {
            if ((Intrinsics.areEqual(findGeneral$geckox_noasanRelease.getBlockId(), info.getBlockId()) && Arrays.equals(findGeneral$geckox_noasanRelease.getReference(), info.getReference()) ? findGeneral$geckox_noasanRelease : null) != null) {
                try {
                    Result.Companion companion = Result.Companion;
                    obj = Result.constructor-impl(insertOrCoverBlock$geckox_noasanRelease(info.getId(), info.getBlockId(), info.getBlockInfo()));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                Throwable th2 = Result.exceptionOrNull-impl(obj);
                if (th2 != null) {
                    if (stringJustDisk == null) {
                        getChunkIndexingRepo().erase(info.getId().getValue());
                    } else {
                        getChunkIndexingRepo().storeStringJustDisk(info.getId().getValue(), stringJustDisk);
                    }
                    throw th2;
                }
                return ChunkIndexingInfo.copy$default(info, null, null, null, null, ((Number) utilsKt$traceTime$1$1.invoke()).longValue(), 15, null);
            }
        }
        throw new IOException("can not insert or cover indexing of " + info.getId().getValue());
    }

    public final ChunkIndexingInfo delete$geckox_noasanRelease(ChunkIdentifier id, File majorFile) {
        Intrinsics.checkParameterIsNotNull(id, "id");
        Intrinsics.checkParameterIsNotNull(majorFile, "majorFile");
        UtilsKt$traceTime$1$1 utilsKt$traceTime$1$1 = new UtilsKt$traceTime$1$1(System.currentTimeMillis());
        ChunkIndexingInfo findGeneral$geckox_noasanRelease = findGeneral$geckox_noasanRelease(id);
        if (findGeneral$geckox_noasanRelease == null) {
            return null;
        }
        String absolutePath = majorFile.getAbsolutePath();
        Set mutableSet = ArraysKt.toMutableSet(findGeneral$geckox_noasanRelease.getReference());
        if (mutableSet.remove(absolutePath)) {
            GkFSLogger.d$default(this.logger, TAG, "Remove reference " + absolutePath + " from chunk " + id, 0, false, 12, null);
        }
        if (mutableSet.isEmpty()) {
            getChunkIndexingRepo().erase(id.getValue());
            GkFSLogger.d$default(this.logger, TAG, "Remove chunk " + id + " indexing info cause no references", 0, false, 12, null);
        } else {
            Keva chunkIndexingRepo = getChunkIndexingRepo();
            String value = id.getValue();
            Object[] array = mutableSet.toArray(new String[0]);
            if (array != null) {
                chunkIndexingRepo.storeStringJustDisk(value, toJSON(ChunkIndexingInfo.copy$default(findGeneral$geckox_noasanRelease, null, null, (String[]) array, null, 0L, 27, null)).toString());
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        deleteBlock$geckox_noasanRelease(id, findGeneral$geckox_noasanRelease.getBlockId());
        ChunkIndexingInfo find$geckox_noasanRelease = find$geckox_noasanRelease(id);
        if (find$geckox_noasanRelease != null) {
            return ChunkIndexingInfo.copy$default(find$geckox_noasanRelease, null, null, null, null, ((Number) utilsKt$traceTime$1$1.invoke()).longValue(), 15, null);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x020a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<BlockIdentifier, Map<ChunkIdentifier, ChunkIndexingTidyUpInfo>> tidyUp$geckox_noasanRelease(BlockIdentifier[] existingBlocks) {
        long longValue;
        long j;
        LinkedHashMap linkedHashMap;
        Intrinsics.checkParameterIsNotNull(existingBlocks, "existingBlocks");
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(existingBlocks.length), 16));
        int i = 0;
        for (BlockIdentifier blockIdentifier : existingBlocks) {
            Pair pair = TuplesKt.to(blockIdentifier, new LinkedHashMap());
            linkedHashMap2.put(pair.getFirst(), pair.getSecond());
        }
        Map<BlockIdentifier, Map<ChunkIdentifier, ChunkIndexingTidyUpInfo>> mutableMap = MapsKt.toMutableMap(linkedHashMap2);
        Keva chunkIndexingRepo = getChunkIndexingRepo();
        chunkIndexingRepo.count();
        Iterator it = chunkIndexingRepo.buildNewMap(KevaConstants.FLAG_CURRENT_KEY_MAP).keySet().iterator();
        while (true) {
            if (it.hasNext()) {
                String str = (String) it.next();
                Intrinsics.checkExpressionValueIsNotNull(str, "keyStr");
                ChunkIdentifier chunkIdentifier = new ChunkIdentifier(str);
                ChunkIndexingInfo findGeneral$geckox_noasanRelease = findGeneral$geckox_noasanRelease(chunkIdentifier);
                if (findGeneral$geckox_noasanRelease == null) {
                    getChunkIndexingRepo().erase(str);
                } else {
                    String[] reference = findGeneral$geckox_noasanRelease.getReference();
                    Set set = ArraysKt.toSet(reference);
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : set) {
                        if (new File((String) obj).exists()) {
                            arrayList.add(obj);
                        }
                    }
                    List<String> mutableList = CollectionsKt.toMutableList(arrayList);
                    ChunkBlockIndexingInfo findBlock$geckox_noasanRelease = findBlock$geckox_noasanRelease(chunkIdentifier, findGeneral$geckox_noasanRelease.getBlockId());
                    UtilsKt$traceTime$1$1 utilsKt$traceTime$1$1 = new UtilsKt$traceTime$1$1(System.currentTimeMillis());
                    if (findBlock$geckox_noasanRelease == null || !ArraysKt.contains(existingBlocks, findGeneral$geckox_noasanRelease.getBlockId())) {
                        GkFSLogger.e$default(this.logger, TAG, "can not find block relative data(info or file) for chunk " + chunkIdentifier.getValue() + " when tidyUp", 0, null, false, 28, null);
                        getChunkIndexingRepo().erase(chunkIdentifier.getValue());
                        deleteBlock$geckox_noasanRelease(chunkIdentifier, findGeneral$geckox_noasanRelease.getBlockId());
                        for (String str2 : mutableList) {
                            new File(str2).delete();
                            GkFSLogger.w$default(this.logger, TAG, "delete " + str2 + " cause chunk " + chunkIdentifier.getValue() + " stale", 0, null, false, 28, null);
                        }
                        mutableList.clear();
                        longValue = ((Number) utilsKt$traceTime$1$1.invoke()).longValue();
                    } else if (mutableList.isEmpty()) {
                        getChunkIndexingRepo().erase(chunkIdentifier.getValue());
                        deleteBlock$geckox_noasanRelease(chunkIdentifier, findGeneral$geckox_noasanRelease.getBlockId());
                        longValue = ((Number) utilsKt$traceTime$1$1.invoke()).longValue();
                    } else if (mutableList.size() != reference.length) {
                        Keva chunkIndexingRepo2 = getChunkIndexingRepo();
                        Object[] array = mutableList.toArray(new String[0]);
                        if (array != null) {
                            chunkIndexingRepo2.storeStringJustDisk(str, toJSON(ChunkIndexingInfo.copy$default(findGeneral$geckox_noasanRelease, null, null, (String[]) array, null, 0L, 27, null)).toString());
                            longValue = ((Number) utilsKt$traceTime$1$1.invoke()).longValue();
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    } else {
                        j = Long.MIN_VALUE;
                        linkedHashMap = mutableMap.get(findGeneral$geckox_noasanRelease.getBlockId());
                        if (linkedHashMap == null) {
                            linkedHashMap = new LinkedHashMap();
                            mutableMap.put(findGeneral$geckox_noasanRelease.getBlockId(), linkedHashMap);
                            Unit unit = Unit.INSTANCE;
                        }
                        Map<ChunkIdentifier, ChunkIndexingTidyUpInfo> map = linkedHashMap;
                        String[] strArr = new String[0];
                        ChunkBlockIndexingInfo chunkBlockIndexingInfo = findBlock$geckox_noasanRelease == null ? findBlock$geckox_noasanRelease : new ChunkBlockIndexingInfo(0L, 0, 3, null);
                        Long valueOf = Long.valueOf(j);
                        Long l = !((valueOf.longValue() > Long.MIN_VALUE ? 1 : (valueOf.longValue() == Long.MIN_VALUE ? 0 : -1)) == 0) ? valueOf : null;
                        map.put(chunkIdentifier, new ChunkIndexingTidyUpInfo(ChunkIndexingInfo.copy$default(findGeneral$geckox_noasanRelease, null, null, strArr, chunkBlockIndexingInfo, l == null ? l.longValue() : 0L, 3, null), j != Long.MIN_VALUE, mutableList.isEmpty()));
                        Unit unit2 = Unit.INSTANCE;
                    }
                    j = longValue;
                    linkedHashMap = mutableMap.get(findGeneral$geckox_noasanRelease.getBlockId());
                    if (linkedHashMap == null) {
                    }
                    Map<ChunkIdentifier, ChunkIndexingTidyUpInfo> map2 = linkedHashMap;
                    String[] strArr2 = new String[0];
                    if (findBlock$geckox_noasanRelease == null) {
                    }
                    Long valueOf2 = Long.valueOf(j);
                    if (!((valueOf2.longValue() > Long.MIN_VALUE ? 1 : (valueOf2.longValue() == Long.MIN_VALUE ? 0 : -1)) == 0)) {
                    }
                    map2.put(chunkIdentifier, new ChunkIndexingTidyUpInfo(ChunkIndexingInfo.copy$default(findGeneral$geckox_noasanRelease, null, null, strArr2, chunkBlockIndexingInfo, l == null ? l.longValue() : 0L, 3, null), j != Long.MIN_VALUE, mutableList.isEmpty()));
                    Unit unit22 = Unit.INSTANCE;
                }
            } else {
                int length = existingBlocks.length;
                int i2 = 0;
                while (i2 < length) {
                    BlockIdentifier blockIdentifier2 = existingBlocks[i2];
                    Keva blockIndexingRepo = getBlockIndexingRepo(blockIdentifier2);
                    blockIndexingRepo.count();
                    for (String str3 : blockIndexingRepo.buildNewMap(KevaConstants.FLAG_CURRENT_KEY_MAP).keySet()) {
                        Intrinsics.checkExpressionValueIsNotNull(str3, "chunkIdStr");
                        ChunkIdentifier chunkIdentifier2 = new ChunkIdentifier(str3);
                        Map<ChunkIdentifier, ChunkIndexingTidyUpInfo> map3 = mutableMap.get(blockIdentifier2);
                        if ((map3 != null ? map3.get(chunkIdentifier2) : null) == null) {
                            ChunkBlockIndexingInfo findBlock$geckox_noasanRelease2 = findBlock$geckox_noasanRelease(chunkIdentifier2, blockIdentifier2);
                            deleteBlock$geckox_noasanRelease(chunkIdentifier2, blockIdentifier2);
                            LinkedHashMap linkedHashMap3 = mutableMap.get(blockIdentifier2);
                            if (linkedHashMap3 == null) {
                                linkedHashMap3 = new LinkedHashMap();
                                mutableMap.put(blockIdentifier2, linkedHashMap3);
                                Unit unit3 = Unit.INSTANCE;
                            }
                            Map<ChunkIdentifier, ChunkIndexingTidyUpInfo> map4 = linkedHashMap3;
                            String[] strArr3 = new String[i];
                            if (findBlock$geckox_noasanRelease2 == null) {
                                findBlock$geckox_noasanRelease2 = new ChunkBlockIndexingInfo(0L, 0, 3, null);
                            }
                            map4.put(chunkIdentifier2, new ChunkIndexingTidyUpInfo(new ChunkIndexingInfo(chunkIdentifier2, blockIdentifier2, strArr3, findBlock$geckox_noasanRelease2, 0L), true, true));
                        }
                        i = 0;
                    }
                    i2++;
                    i = 0;
                }
                return mutableMap;
            }
        }
    }
}
