# GameNative-project Progress Log

**Repo:** https://github.com/The412Banner/GameNative-project
**Local path:** `/data/data/com.termux/files/home/GameNative-project`
**Rules:** No pull requests ever. Log every change. Push commits as needed.

---

## Session Start — 2026-03-06

### Setup
- Forked from upstream and cloned to local device as backup
- Created this progress log
- Upstream HEAD at clone time: `f04c2980` — replace Toast with Compose Snackbar system (#697)

**Recent upstream commits at clone:**
- `f04c2980` — replace Toast with Compose Snackbar system (#697)
- `d663966d` — chore(): add fexcore 2603 (#723)
- `bbc4bb53` — added back allowed orientations, only for landscape and reverse landscape (#730)
- `abcd4e06` — Updated release in readme
- `7bc524e8` — bumped version

---

## Change Log

<!-- New entries go here, most recent first -->

### [release] — 3 new package-renamed branches + releases (2026-03-06)
**Branches/Tags:**
- `pkg-antutu` / `v0.8.3-antutu` / commit `4516772b`
- `pkg-tencent` / `v0.8.3-tencent` / commit `f1e6a6ed`
- `pkg-ludashi` / `v0.8.3-ludashi` / commit `9f7001b8`

#### What changed
- Created 3 new branches off master, each with a full package rename from `com.mihoyo.genshinimpact` to a different target package:
  - `pkg-antutu` → `com.antutu.ABenchMark`
  - `pkg-tencent` → `com.tencent.ig`
  - `pkg-ludashi` → `com.ludashi.benchmark`
- For each branch:
  - `namespace` and `applicationId` updated in `app/build.gradle.kts`
  - All 4 source directories renamed (`main`, `androidTest`, `sharedTest`, `test`)
  - ~375 source files updated (package declarations, imports, all references)
  - Room schema files (8–13.json) copied to new `app/schemas/<new.package>.db.PluviaDatabase/` directory
  - CI workflow APK filename updated to reflect the new package name
- All 3 CI builds completed successfully (~7 min each)
- GitHub releases created and named: `gamenative-v0.8.0-<package>`
- Detailed release descriptions added to all 4 releases (including genshinimpact) explaining exactly what files/values were changed

#### Files touched (per branch)
- `app/build.gradle.kts`
- `app/src/*/java/` — all source directories renamed + ~375 files updated
- `app/schemas/<new.package>.db.PluviaDatabase/` — 8.json through 13.json
- `.github/workflows/tagged-release.yml`

---

### [docs] — Package rename guide created (2026-03-06)
#### What changed
- Created `PACKAGE_RENAME_GUIDE.txt` — full step-by-step manual instructions for anyone wanting to rename the package themselves
- Covers: fork/clone, source dir rename, find-and-replace, build.gradle.kts, Room schemas, CI workflow fix, commit/tag/push, signing APK, common errors, summary checklist
#### Files touched
- `PACKAGE_RENAME_GUIDE.txt` (new)

---

### [release] — v0.8.3 genshinimpact build succeeded, release description set (2026-03-06)
**Commit:** `a5f3dfc9`  |  **Tag:** `v0.8.3`  |  **GitHub release:** `gamenative-v0.8.0-com.mihoyo.genshinimpact`
#### What changed
- Confirmed CI build for v0.8.3 succeeded (7m34s)
- Set detailed GitHub release description covering all changes since original `app.gamenative` package
#### Files touched
- GitHub release description only

---

### [ci] — Skip lintVitalRelease to fix release build (2026-03-06)
**Commit:** `a5f3dfc9`  |  **Tag:** `v0.8.3`
#### What changed
- Added `-x lintVitalRelease` flag to Gradle build command in CI workflow
- Bypasses `ExpiredTargetSdkVersion` fatal lint error — targetSdk=28 is intentional (game compatibility layer)
- This was the fix that made the release build succeed after v0.8.1 and v0.8.2 both failed
#### Files touched
- `.github/workflows/tagged-release.yml`

---

### [fix] — Room schema directory renamed to match new package (2026-03-06)
**Commit:** `63234d9d`  |  **Tag:** `v0.8.2`
#### What changed
- Copied migration schema files (8–13.json) from `app/schemas/app.gamenative.db.PluviaDatabase/`
  to `app/schemas/com.mihoyo.genshinimpact.db.PluviaDatabase/`
- Room KSP requires schemas under the fully-qualified DB class name — this was causing build failures after the package rename
#### Files touched
- `app/schemas/com.mihoyo.genshinimpact.db.PluviaDatabase/` (8.json, 9.json, 10.json, 11.json, 12.json, 13.json)

---

### [ci] — Simplified workflow to unsigned APK, tag v0.8.1 pushed (2026-03-06)
**Commit:** `4dddcb85`  |  **Tag:** `v0.8.1`
#### What changed
- Rewrote `.github/workflows/tagged-release.yml` — removed all keystore/signing secret requirements
- Switched from `bundleRelease` + bundletool to `assembleRelease` (direct unsigned APK)
- Uses dummy PostHog credentials — no secrets needed to build
- Release body includes `apksigner` command for manual signing after download
- Tag `v0.8.1` pushed → CI build triggered on GitHub Actions
#### Files touched
- `.github/workflows/tagged-release.yml`

---

### [refactor] — Package rename app.gamenative → com.mihoyo.genshinimpact (2026-03-06)
**Commit:** `3465674c`
#### What changed
- Replaced all occurrences of `app.gamenative` with `com.mihoyo.genshinimpact` across 375 source files
- `applicationId` and `namespace` in `app/build.gradle.kts` updated
- Renamed all 4 source directories from `app/gamenative/` to `com/mihoyo/genshinimpact/`
#### Files touched
- All `.kt`, `.java`, `.xml`, `.kts`, `.json`, `.properties`, `.txt`, `.md` files containing `app.gamenative`
- All source directories under `app/src/*/java/`
