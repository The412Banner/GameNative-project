package com.ludashi.benchmark.db

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ludashi.benchmark.data.ChangeNumbers
import com.ludashi.benchmark.data.AppInfo
import com.ludashi.benchmark.data.FileChangeLists
import com.ludashi.benchmark.data.SteamApp
import com.ludashi.benchmark.data.SteamLicense
import com.ludashi.benchmark.data.CachedLicense
import com.ludashi.benchmark.data.DownloadingAppInfo
import com.ludashi.benchmark.data.EncryptedAppTicket
import com.ludashi.benchmark.data.GOGGame
import com.ludashi.benchmark.data.EpicGame
import com.ludashi.benchmark.data.AmazonGame
import com.ludashi.benchmark.db.converters.AppConverter
import com.ludashi.benchmark.db.converters.ByteArrayConverter
import com.ludashi.benchmark.db.converters.FriendConverter
import com.ludashi.benchmark.db.converters.LicenseConverter
import com.ludashi.benchmark.db.converters.PathTypeConverter
import com.ludashi.benchmark.db.converters.UserFileInfoListConverter
import com.ludashi.benchmark.db.converters.GOGConverter
import com.ludashi.benchmark.db.dao.ChangeNumbersDao
import com.ludashi.benchmark.db.dao.FileChangeListsDao
import com.ludashi.benchmark.db.dao.SteamAppDao
import com.ludashi.benchmark.db.dao.SteamLicenseDao
import com.ludashi.benchmark.db.dao.AppInfoDao
import com.ludashi.benchmark.db.dao.CachedLicenseDao
import com.ludashi.benchmark.db.dao.DownloadingAppInfoDao
import com.ludashi.benchmark.db.dao.EncryptedAppTicketDao
import com.ludashi.benchmark.db.dao.GOGGameDao
import com.ludashi.benchmark.db.dao.EpicGameDao
import com.ludashi.benchmark.db.dao.AmazonGameDao

const val DATABASE_NAME = "pluvia.db"

@Database(
    entities = [
        AppInfo::class,
        CachedLicense::class,
        ChangeNumbers::class,
        EncryptedAppTicket::class,
        FileChangeLists::class,
        SteamApp::class,
        SteamLicense::class,
        GOGGame::class,
        EpicGame::class,
        AmazonGame::class,
        DownloadingAppInfo::class
    ],
    version = 13,
    // For db migration, visit https://developer.android.com/training/data-storage/room/migrating-db-versions for more information
    exportSchema = true, // It is better to handle db changes carefully, as GN is getting much more users.
    autoMigrations = [
        // For every version change, if it is automatic, please add a new migration here.
        AutoMigration(from = 8, to = 9),
        AutoMigration(from = 9, to = 10),
        AutoMigration(from = 10, to = 11),
        AutoMigration(from = 11, to = 12),
        AutoMigration(from = 12, to = 13), // Added amazon_games table
    ]
)
@TypeConverters(
    AppConverter::class,
    ByteArrayConverter::class,
    FriendConverter::class,
    LicenseConverter::class,
    PathTypeConverter::class,
    UserFileInfoListConverter::class,
    GOGConverter::class,
)
abstract class PluviaDatabase : RoomDatabase() {

    abstract fun steamLicenseDao(): SteamLicenseDao

    abstract fun steamAppDao(): SteamAppDao

    abstract fun appChangeNumbersDao(): ChangeNumbersDao

    abstract fun appFileChangeListsDao(): FileChangeListsDao

    abstract fun appInfoDao(): AppInfoDao

    abstract fun cachedLicenseDao(): CachedLicenseDao

    abstract fun encryptedAppTicketDao(): EncryptedAppTicketDao

    abstract fun gogGameDao(): GOGGameDao

    abstract fun epicGameDao(): EpicGameDao

    abstract fun amazonGameDao(): AmazonGameDao

    abstract fun downloadingAppInfoDao(): DownloadingAppInfoDao
}
