package io.github.rushiranpise.gameunlocker;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.Log;

import java.lang.reflect.Field;
import java.util.List;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

@SuppressLint("DiscouragedPrivateApi")
@SuppressWarnings("ConstantConditions")
public class GAMEUNLOCKER implements IXposedHookLoadPackage {

    private static final String TAG = GAMEUNLOCKER.class.getSimpleName();

    // Packages to Spoof as ROG Phone 6
    private static final List<String> packagesToChangeROG6 = List.of(
        "com.activision.callofduty.shooter",
        "com.activision.callofduty.warzone",
        "com.ea.gp.fifamobile",
        "com.gameloft.android.ANMP.GloftA9HM",
        "com.madfingergames.legends",
        "com.pearlabyss.blackdesertm",
        "com.pearlabyss.blackdesertm.gl"
    );

    // Packages to Spoof as OnePlus 9 Pro
    private static final List<String> packagesToChangeOP9P = List.of(
        "com.epicgames.fortnite",
        "com.epicgames.portal",
        "com.tencent.lolm",
        "jp.konami.pesam"
    );

    // Packages to Spoof as OnePlus 11R
    private static final List<String> packagesToChangeOP11R = List.of(
        "com.YoStar.AetherGazer",
        "com.garena.game.lmjx",
        "com.miHoYo.GenshinImpact",
        "com.mojang.minecraftpe",
        "com.ngame.allstar.eu",
        "com.pubg.imobile",
        "com.pubg.krmobile",
        "com.rekoo.pubgm",
        "com.riotgames.league.wildrift",
        "com.riotgames.league.wildrifttw",
        "com.riotgames.league.wildriftvn",
        "com.riotgames.league.teamfighttactics",
        "com.riotgames.league.teamfighttacticstw",
        "com.riotgames.league.teamfighttacticsvn",
        "com.tencent.ig",
        "com.tencent.tmgp.pubgmhd",
        "com.vng.pubgmobile",
        "vng.games.revelation.mobile"
    );

    // Packages to Spoof as Mi 11T Pro
    private static final List<String> packagesToChangeMI11TP = List.of(
        "com.levelinfinite.hotta.gp",
        "com.supercell.clashofclans",
        "com.vng.mlbbvn"
    );

    // Packages to Spoof as Xiaomi 13 Pro
    private static final List<String> packagesToChangeMI13P = List.of(
        "com.levelinfinite.sgameGlobal",
        "com.tencent.tmgp.sgame"
    );

    // Packages to Spoof as POCO F5
    private static final List<String> packagesToChangeF5 = List.of(
        "com.mobile.legends"
    );

    // Packages to Spoof as Black Shark 4
    private static final List<String> packagesToChangeBS4 = List.of(
        "com.proximabeta.mf.uamo"
    );

    // Packages to Spoof as iQOO 11 Pro
    private static final List<String> packagesToChangeiQ11P = List.of(
        "com.tencent.KiHan",
        "com.tencent.tmgp.cf",
        "com.tencent.tmgp.cod",
        "com.tencent.tmgp.gnyx"
    );

    // Packages to Spoof as iQOO 13
    private static final List<String> packagesToChangeiQ13 = List.of(
        "com.garena.game.codm",
        "com.garena.game.df",
        "com.garena.game.kgvn",
        "com.proxima.dfm",
        "com.tencent.tmgp.dfm",
        "com.tencent.tmgp.kr.codm",
        "com.vng.codmvn"
    );

    // Packages to Spoof as Realme 14
    private static final List<String> packagesToChangeRM14 = List.of(
        "com.dts.freefiremax",
        "com.dts.freefireth"
    );

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) {

        String packageName = loadPackageParam.packageName;

        // Asus
        if (packagesToChangeROG6.contains(packageName)) {
            propsToChangeROG6();
            XposedBridge.log("Spoofed " + packageName + " as Asus ROG 6");
        }

        // Black Shark
        if (packagesToChangeBS4.contains(packageName)) {
            propsToChangeBS4();
            XposedBridge.log("Spoofed " + packageName + " as Black Shark 4");
        }

        // Iqoo
        if (packagesToChangeiQ11P.contains(packageName)) {
            propsToChangeiQ11P();
            XposedBridge.log("Spoofed " + packageName + " as iQOO 11 Pro");
        }

        if (packagesToChangeiQ13.contains(packageName)) {
            propsToChangeiQ13();
            XposedBridge.log("Spoofed " + packageName + " as iQOO 13");
        }

        // OnePlus
        if (packagesToChangeOP9P.contains(packageName)) {
            propsToChangeOP9P();
            XposedBridge.log("Spoofed " + packageName + " as OnePlus 9 Pro");
        }

        if (packagesToChangeOP11R.contains(packageName)) {
            propsToChangeOP11R();
            XposedBridge.log("Spoofed " + packageName + " as OnePlus 11R");
        }

        // Poco
        if (packagesToChangeF5.contains(packageName)) {
            propsToChangeF5();
            XposedBridge.log("Spoofed " + packageName + " as Poco F5");
        }

        // Xiaomi
        if (packagesToChangeMI11TP.contains(packageName)) {
            propsToChangeMI11TP();
            XposedBridge.log("Spoofed " + packageName + " as Xiaomi Mi 11T Pro");
        }

        if (packagesToChangeMI13P.contains(packageName)) {
            propsToChangeMI13P();
            XposedBridge.log("Spoofed " + packageName + " as Xiaomi Mi 13 Pro");
        }

        // Realme
        if (packagesToChangeRM14.contains(packageName)) {
            propsToChangeRM14();
            XposedBridge.log("Spoofed " + packageName + " as Realme 14");
        }
    }

    // Asus
    // Props to Spoof as Asus Rog 6
    private static void propsToChangeROG6() {
        setPropValue("BRAND", "asus");
        setPropValue("MANUFACTURER", "asus");
        setPropValue("DEVICE", "AI2201");
        setPropValue("MODEL", "ASUS_AI2201");
    }

    // Blackshark
    // Props to Spoof as Blackshark 4
    private static void propsToChangeBS4() {
        setPropValue("MANUFACTURER", "blackshark");
        setPropValue("MODEL", "2SM-X706B");
    }

    // Iqoo
    // Props to Spoof as iQOO 11 Pro
    private static void propsToChangeiQ11P() {
        setPropValue("MANUFACTURER", "vivo");
        setPropValue("MODEL", "V2243A");
    }

    // Props to Spoof as iQOO 13
    private static void propsToChangeiQ13() {
        setPropValue("MANUFACTURER", "vivo");
        setPropValue("MODEL", "V2408A");
    }

    // OnePlus
    // Props to Spoof as OnePlus 9 Pro
    private static void propsToChangeOP9P() {
        setPropValue("MANUFACTURER", "OnePlus");
        setPropValue("MODEL", "LE2123");
    }

    // Props to Spoof as OnePlus 11R
    private static void propsToChangeOP11R() {
        setPropValue("MANUFACTURER", "OnePlus");
        setPropValue("MODEL", "CPH2487");
    }

    //Poco
    // Props to Spoof as Poco F5
    private static void propsToChangeF5() {
        setPropValue("MANUFACTURER", "Xiaomi");
        setPropValue("MODEL", "23049PCD8G");
    }

    // Xiaomi
    // Props to Spoof as Xiaomi Mi 11T Pro
    private static void propsToChangeMI11TP() {
        setPropValue("MANUFACTURER", "Xiaomi");
        setPropValue("MODEL", "2107113SI");
    }

    // Props to Spoof as Xiaomi Mi 13 Pro
    private static void propsToChangeMI13P() {
        setPropValue("MANUFACTURER", "Xiaomi");
        setPropValue("MODEL", "2210132C");
    }

    // Realme
    // Props to Spoof as Realme 14
    private static void propsToChangeRM14() {
        setPropValue("MANUFACTURER", "realme");
        setPropValue("MODEL", "RMX5070");
    }

    private static void setPropValue(String key, Object value) {
        try {
            Log.d(TAG, "Setting prop " + key + " = " + value);
            Field field = Build.class.getDeclaredField(key);
            field.setAccessible(true);
            field.set(null, value);
        } catch (ReflectiveOperationException e) {
            XposedBridge.log("Failed to set prop: " + key + "\n" + Log.getStackTraceString(e));
        }
    }
}