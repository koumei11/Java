package study1.chapter1.unit2;

import java.util.HashMap;
import java.util.Map;

public class Program02Kadai2 {
    public static void main(String[] args)
    {
        // トップページ用のaccess counterを作成
        AccessCounter2 counter = AccessCounter2.getCounter();

        // 誰かがトップページに訪問し、趣味のページを開いて去る
        counter.incrementAccess("トップページ");
        counter.incrementAccess("趣味のページ");

        // 誰かがトップページに訪問し、自己紹介のページを開いて去る
        counter.incrementAccess("トップページ");
        counter.incrementAccess("自己紹介ページ");

        // 誰かが趣味のページを訪問して去る
        counter.incrementAccess("趣味のページ");

        // 誰かがトップページに訪問して去る
        counter.incrementAccess("トップページ");

        // トップページのアクセス数を取得して表示
        System.out.println(counter.getPageAccessCount("トップページ")); // 3

        // 自己紹介のアクセス数を取得して表示
        System.out.println(counter.getPageAccessCount("自己紹介ページ")); // 1

        // 趣味のページのアクセス数を取得して表示
        System.out.println(counter.getPageAccessCount("趣味のページ")); // 2

        // サイト全体のアクセス数を取得して表示
        System.out.println(counter.getWebsiteAccessCount()); // 6

        // トップページのアクセスステータスを取得して表示
        System.out.println(counter.getStatusMessage("トップページ")); // 現在のアクセス数：3回（トップページ)／6回（サイト全体）
    }
}

class AccessCounter2
{
    // field
    private static int websiteAccessCount;
    private Map<String, Integer> accessMap = new HashMap<>();

    // 初期化method
    public static AccessCounter2 getCounter() {
        return new AccessCounter2();
    }

    /**
     * ページにアクセスする度に該当ページとサイト全体のアクセス数を+1
     * @param page ページ名
     */
    public void incrementAccess(String page) {
        websiteAccessCount++;
        if(accessMap.containsKey(page)) {
            accessMap.put(page, accessMap.get(page) + 1);
        } else {
            accessMap.put(page, 1);
        }
    }
    /**
     * ページのアクセス数を取得
     * @param page ページ名
     * @return アクセス回数
     */
    public int getPageAccessCount(String page) {
        if(accessMap.containsKey(page)) {
            return accessMap.get(page);
        } else {
            return 0;
        }
    }
    /**
     * サイト全体のアクセス数を取得
     * @return サイト全体のアクセス回数
     */
    public int getWebsiteAccessCount() {
        return websiteAccessCount;
    }
    /**
     * ページのステータスを取得
     * @param page ページ名
     * @return アクセスステータス
     */
    public String getStatusMessage(String page) {
        return "現在のアクセス数：" + accessMap.get(page) + "回（" + page + ")／"
                + websiteAccessCount + "回（サイト全体）";
    }
}