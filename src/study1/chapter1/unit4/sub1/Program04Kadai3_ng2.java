//package study1.chapter1.unit4.sub1;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Program04Kadai3_ng2 {
//    public static void main(String[] args)
//    {
//        int quantity = 10;
//        System.out.println(quantity + "羽のオウムを仕入れての実験：");
//
//        String call = "ありがとう";
//        System.out.println("\n*** 「" + call + "」と声をかけたときの応答 ***");
//        for (Parrot parrot : getParrots(quantity))
//        {
//            System.out.println(parrot.getSpecies() + "の応答：" + parrot.reply(call));
//        }
//
//        call = "すりじゃやわるだなぷらこって";
//        System.out.println("\n*** 「" + call + "」と声をかけたときの応答 ***");
//        for (Parrot parrot : getParrots(quantity))
//        {
//            System.out.println(parrot.getSpecies() + "の応答：" + parrot.reply(call));
//        }
//    }
//
//    /**
//     * オウムを仕入れる
//     * @param patrrotsNum オウムの数
//     * @return ランダムなオウムのリスト
//     */
//    private static List<Parrot> getParrots(int patrrotsNum)
//    {
//        List<Parrot> parrots = new ArrayList<>();
//        for (int i = 0; i < patrrotsNum; i++)
//        {
//            Parrot parrot;
//            int rand = (int)(Math.random() * 10); // 優先順位注意：castは*よりも評価の優先度が高いため(int)Math.random() * 10だと「(int)Math.random()」の評価結果に対して10をかける、という意味になってしまう
//            switch (rand % 3)
//            {
//            case 0:
//                parrot = getTomatoParrot();
//                break;
//            case 1:
//                parrot = getCabbageParrot();
//                break;
//            case 2:
//                parrot = new RomanescoParrot();
//                break;
//            default:
//                throw new IllegalStateException("ここに入ったらバグ！");
//            }
//            parrots.add(parrot);
//        }
//        return parrots;
//    }
//
//    /**
//     * トマトオウムを仕入れる
//     * @return トマトオウム
//     */
//    private static TomatoParrot getTomatoParrot()
//    {
//        int rand = (int)(Math.random() * 10);
//        switch (rand % 3)
//        {
//        case 0:
//            return new MomotarouTomatoParrot();
//        case 1:
//            return new SanMarzanoTomatoParrot();
//        case 2:
//            return new FiorentinoTomatoParrot();
//        default:
//            throw new IllegalStateException("ここに入ったらバグ！");
//        }
//    }
//
//    /**
//     * キャベツオウムを仕入れる
//     * @return キャベツオウム
//     */
//    private static CabbageParrot getCabbageParrot()
//    {
//        int rand = (int)(Math.random() * 10);
//        switch (rand % 2)
//        {
//        case 0:
//            return new CannonballCabbage();
//        case 1:
//            return new SavoyCabbageParrot();
//        default:
//            throw new IllegalStateException("ここに入ったらバグ！");
//        }
//    }
//}
//
///**
// * オウムを表すclass
// * @author kinjouhiroaki
// */
//abstract class Parrot
//{
//    /**
//     * かけられた言葉に対して「キュルルッ！」をつけて返す
//     * @param words 言葉
//     * @return 応答
//     */
//    public String reply(String words)
//    {
//        words = (words != null) ? words : "";
//        return "キュルルッ！" + replySub(words);
//    }
//    /**
//     * かけられた言葉に対しておうむ返しをする
//     * @param words 言葉
//     * @return 応答
//     */
//    abstract String replySub(String words);
//    /**
//     * オウムの種類を返す(問３で追加)
//     * @return オウムの種類
//     */
//    abstract String getSpecies();
//}
///**
// * トマトオウムを表すclass
// * @author kinjouhiroaki
// */
//abstract class TomatoParrot extends Parrot
//{
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    String replySub(String words) {
//        return willReplyProperly(words) ? tomatoReply(words) : elseReply(words);
//    }
//    /**
//     * トマトオウムの応答
//     * @param words
//     * @return トマトオウムの応答
//     */
//    protected String tomatoReply(String words) {
//        return words.replaceAll("[あいうえお]", "と").replaceAll("[かきくけこ]", "ま");
//    }
//    /**
//     * 応答の仕方を決める
//     * @param words
//     * @return boolean
//     */
//    protected abstract boolean willReplyProperly(String words);
//    /**
//     * 子オウムの応答
//     * @param words
//     * @return 子オウムの応答
//     */
//    protected abstract String elseReply(String words);
//}
///**
// * 桃太郎トマトオウム種を表すclass
// * @author kinjouhiroaki
// */
//class MomotarouTomatoParrot extends TomatoParrot
//{
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    String getSpecies() {
//        return "桃太郎トマトオウム";
//    }
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    protected boolean willReplyProperly(String words) {
//        return (words.length() <= 5) ? true : false;
//    }
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    protected String elseReply(String words) {
//        return "とまと・・";
//    }
//}
///**
// * サンマルツァーノトマトオウム種を表すclass
// * @author kinjouhiroaki
// */
//class SanMarzanoTomatoParrot extends TomatoParrot
//{
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    String getSpecies() {
//        return "サンマルツァーノトマトオウム";
//    }
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    protected boolean willReplyProperly(String words) {
//        return (words.length() >= 10) ? true : false;
//    }
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    protected String elseReply(String words) {
//        return "まえからよんでもうしろからとまと";
//    }
//}
///**
// * フィオレンティーノトマトオウム種を表すclass
// * @author kinjouhiroaki
// */
//class FiorentinoTomatoParrot extends TomatoParrot
//{
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    String getSpecies() {
//        return "フィオレンティーノトマトオウム";
//    }
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    protected boolean willReplyProperly(String words) {
//        return (words.matches(".*[とま].*")) ? true : false;
//    }
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    protected String elseReply(String words) {
//        return String.join("と", words.split(""));
//    }
//}
///**
// * キャベツオウムを表すclass
// * @author kinjouhiroaki
// */
//abstract class CabbageParrot extends Parrot
//{
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    String replySub(String words) {
//        return willReplyProperly(words) ? cabbageReply(words) : elseReply(words);
//    }
//    /**
//     * キャベツオウムの応答
//     * @param words
//     * @return キャベツオウムの応答
//     */
//    protected String cabbageReply(String words) {
//        return words.substring(1);
//    }
//    /**
//     * 応答の仕方を決める
//     * @param words
//     * @return boolean
//     */
//    protected abstract boolean willReplyProperly(String words);
//    /**
//     * 子オウムの応答
//     * @param words
//     * @return 子オウムの応答
//     */
//    protected abstract String elseReply(String words);
//}
///**
// * グリーンボールキャベツオウム種を表すclass
// * @author kinjouhiroaki
// */
//class CannonballCabbage extends CabbageParrot
//{
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    String getSpecies() {
//        return "グリーンボールキャベツオウム";
//    }
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    protected boolean willReplyProperly(String words) {
//        return true;
//    }
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    protected String elseReply(String words) {
//        return super.cabbageReply(words); // こちらはこれでいいでしょうか？親classは抽象classなのでここでこのmethodを実装しないとエラーになってしまいます。しかしこの応答は親classのもの（子class固有の処理ではない）なのでここに書くべきじゃないような気もします。。
//    }
//}
///**
// * サボイキャベツオウム種を表すclass
// * @author kinjouhiroaki
// */
//class SavoyCabbageParrot extends CabbageParrot
//{
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    String getSpecies() {
//        return "サボイキャベツオウム";
//    }
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    protected boolean willReplyProperly(String words) {
//        return ((int)(Math.random() * 10) % 2 == 0) ? true : false;
//    }
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    protected String elseReply(String words) {
//        return new StringBuilder(words).reverse().toString();
//    }
//}
//
///**
// * ロマネスコオウムを表すclass
// * @author kinjouhiroaki
// */
//class RomanescoParrot extends Parrot
//{
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    String replySub(String words) {
//        words = words.replaceAll(".", "$0$0");
//        return words;
//    }
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    String getSpecies() {
//        return "ロマネスコオウム";
//    }
//}
//
