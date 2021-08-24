package com.haebun.erhb.main;

public class ServerData {
    public static String IP = "182.228.83.7";
    public static String LOCALHOST = "192.168.219.110";

    public static String URL = "http://" + LOCALHOST + "/ER_Handbook/";

    public static String SEASON_BANNER_URL = URL +"season/";
    public static String REWARD_BANNER_URL = URL +"reward/";
    public static String PROMOTION_IMAGE_URL = "https://t1.kakaocdn.net/gamepub/pub-img/common/web/main/promotion/er/";

    public static String REQUEST_PROMOTION_LIST = URL + "php/promotion.php";
    public static String REQUEST_SEASON_DATA = URL + "php/season.php";
    public static String REQUEST_VERSION_DATA = URL + "php/version.php";
    public static String REQUEST_REWARD_DATA = URL + "php/reward.php";
    public static String REQUEST_SUBJECT_DATA_LIST = URL + "php/subject_list.php";

    public static String SUBJECT_IMAGE_DIRECTORY = URL + "subject/";
}
