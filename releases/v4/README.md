# v4 — Package Rename: cn → cn3

## Changes

- Package name: `com.bytedance.trae.cn` → `com.bytedance.trae.cn3`
- APP display name: `TRAE` → `TRAE3`

## Files

- `TRAE3_cn3.apk` — DOWNLOAD from [GitHub Releases](https://github.com/liliangxing/trae-cn3/releases/tag/v4)
- `manifest_patched.xml` — Patched AndroidManifest.xml with cn3 package
- `resources.arsc` — Patched resources with cn3 package + TRAE3 app name

## Build Notes

The compiled classes already used `com.bytedance.trae.cn3` namespace.
Only the manifest and resources needed patching.

See `../BUILD_SCRIPT/PACKAGE_POLICY.md` for build instructions.
