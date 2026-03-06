package com.antutu.ABenchMark.db

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.antutu.ABenchMark.data.ChangeNumbers
import com.antutu.ABenchMark.data.AppInfo
import com.antutu.ABenchMark.data.FileChangeLists
import com.antutu.ABenchMark.data.SteamApp
import com.antutu.ABenchMark.data.SteamLicense
import com.antutu.ABenchMark.data.CachedLicense
import com.antutu.ABenchMark.data.DownloadingAppInfo
import com.antutu.ABenchMark.data.EncryptedAppTicket
import com.antutu.ABenchMark.data.GOGGame
import com.antutu.ABenchMark.data.EpicGame
import com.antutu.ABenchMark.data.AmazonGame
import com.antutu.ABenchMark.db.converters.AppConverter
import com.antutu.ABenchMark.db.converters.ByteArrayConverter
import com.antutu.ABenchMark.db.converters.FriendConverter
import com.antutu.ABenchMark.db.converters.LicenseConverter
import com.antutu.ABenchMark.db.converters.PathTypeConverter
import com.antutu.ABenchMark.db.converters.UserFileInfoListConverter
import com.antutu.ABenchMark.db.converters.GOGConverter
import com.antutu.ABenchMark.db.dao.ChangeNumbersDao
import com.antutu.ABenchMark.db.dao.FileChangeListsDao
import com.antutu.ABenchMark.db.dao.SteamAppDao
import com.antutu.ABenchMark.db.dao.SteamLicenseDao
import com.antutu.ABenchMark.db.dao.AppInfoDao
import com.antutu.ABenchMark.db.dao.CachedLicenseDao
import com.antutu.ABenchMark.db.dao.DownloadingAppInfoDao
import com.antutu.ABenchMark.db.dao.EncryptedAppTicketDao
import com.antutu.ABenchMark.db.dao.GOGGameDao
import com.antutu.ABenchMark.db.dao.EpicGameDao
import com.antutu.ABenchMark.db.dao.AmazonGameDao

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
