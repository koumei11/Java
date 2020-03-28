package study1.chapter1.unit2;

public class Program02Kadai1 {
    public static void main(String[] args) {
        // トップページ用のaccess counterを作成
        AccessCounter counter1 = new AccessCounter("トップページ");

        // 自己紹介ページ用のaccess counterを作成
        AccessCounter counter2 = new AccessCounter("自己紹介ページ");

        // 趣味のページ用のaccess counterを作成
        AccessCounter counter3 = new AccessCounter("趣味のページ");

        // 誰かがトップページに訪問し、趣味のページを開いて去る
        counter1.incrementAccess();
        counter3.incrementAccess();

        // 誰かがトップページに訪問し、自己紹介のページを開いて去る
        counter1.incrementAccess();
        counter2.incrementAccess();

        // 誰かが趣味のページを訪問して去る
        counter3.incrementAccess();

        // 誰かがトップページに訪問して去る
        counter1.incrementAccess();

        // トップページのアクセス数を取得して表示
        System.out.println(counter1.getPageAccessCount()); // 3

        // 自己紹介のアクセス数を取得して表示
        System.out.println(counter2.getPageAccessCount()); // 1

        // 趣味のページのアクセス数を取得して表示
        System.out.println(counter3.getPageAccessCount()); // 2

        // サイト全体のアクセス数を取得して表示
        System.out.println(AccessCounter.getWebsiteAccessCount()); // 6

        // トップページのアクセスステータスを取得して表示
        System.out.println(counter1.getStatusMessage()); // 現在のアクセス数：3回（トップページ)／6回（サイト全体）
        }
}
// AccessCounterクラス
class AccessCounter
{
    // field
    private static int countAll;
    private int count;
    private String pageName;

    // Constructor
    public AccessCounter(String name) {
        this.pageName = name;
        // →× 「fieldは「ゼロ値」で初期化されること」かつ「intの「ゼロ値」は0であること」から、この処理は不要！(済み)
    }

    // method
    /**
     * サイト全体と該当ページの訪問数を+1する
     */
    public void incrementAccess() {
        countAll++; // →△ 1以外を加算する場合にはこの書き方で良いが、increment（＝1を加算すること）は「countAll++」（理由がある場合に限り「++countAll」）と書くのがお約束！(済み)
        this.count++; // →△ 同上(済み)
    }
    /**
     * 該当ページの訪問数を返す
     * @return 該当ページの訪問数
     */
    public int getPageAccessCount() {
        return this.count;
    }
    /**
     * サイト全体の訪問数を返す
     * @return サイト全体の訪問数
     */
    public static int getWebsiteAccessCount() {
        return countAll;
    }
    /**
     * 該当ページのアクセスステータスを取得して表示
     * @return アクセスステータス
     */
    public String getStatusMessage() {
        return "現在のアクセス数：" + Integer.toString(this.count) + "回（" + this.pageName + "）"
               + "／" + countAll + "回（サイト全体）"; // →× 「Integer.toString」は不要！pythonと違いJavaはintとStringを「+演算子」で文字列結合ができるので、わざわざintをStringに変換するのは冗長である！(済み)
    }
}
