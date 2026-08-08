# v33 — 对齐原APK anchor 翻页 API

## Changes

- Pagination switch: `before_id` → `anchor_created_at_ms` (aligned with original APK anchor API)
- `include_anchor=false` to avoid duplicate anchor message
- Page-count judgment aligned with original APK (`items >= before_limit`)
- Multi-page messages merged in reverse order for correct chronological output
- First-page failure returns null instead of a false "API success" report
- Added MockApiServer + ApiMessageFetcherTest unit tests

## Files

- `trae_cn3_v33.apk` — DOWNLOAD from [GitHub Releases](https://github.com/liliangxing/trae-cn3/releases/tag/v33)

## Build Notes

Input APK: v32 (`trae_cn3_v32.apk`). Toolchain: JDK 17, dx 1.13
(from build-tools 26.0.1), apktool 2.9.3, baksmali 2.5.2, uber-apk-signer 1.3.0.

Build command:

```bash
bash build.sh /data/user/work/trae_cn3_v32.apk /data/user/work/trae_cn3_v33.apk
```

See `../BUILD_SCRIPT/PACKAGE_POLICY.md` for build instructions.
