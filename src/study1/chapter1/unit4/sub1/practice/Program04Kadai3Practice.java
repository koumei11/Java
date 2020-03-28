package study1.chapter1.unit4.sub1.practice;

import java.util.ArrayList;
import java.util.List;

public class Program04Kadai3Practice {
    public static void main(String[] args)
    {
        int quantity = 10;
        System.out.println(quantity + "羽のオウムを仕入れての実験：");

        String call = "ありがとう";
        System.out.println("\n*** 「" + call + "」と声をかけたときの応答 ***");
        for (Parrot parrot : getParrots(quantity))
        {
            System.out.println(parrot.getSpecies() + "の応答：" + parrot.reply(call));
            // 下記がランダムで10行だけ表示される：
            // 桃太郎トマトオウムの応答：キュルルッ！とりがとと
            // サンマルツァーノトマトオウムの応答：キュルルッ！まえからよんでもうしろからとまと
            // フィオレンティーノトマトオウムの応答：キュルルッ！とりがとと
            // グリーンボールキャベツオウムの応答：キュルルッ！りがとう
            // サボイキャベツオウムの応答：キュルルッ！りがとう
            // サボイキャベツオウムの応答：キュルルッ！うとがり
            // ロマネスコオウムの応答：キュルルッ！あありりががととうう
        }

        call = "すりじゃやわるだなぷらこって";
        System.out.println("\n*** 「" + call + "」と声をかけたときの応答 ***");
        for (Parrot parrot : getParrots(quantity))
        {
            System.out.println(parrot.getSpecies() + "の応答：" + parrot.reply(call));
            // 下記がランダムで10行だけ表示される：
            // 桃太郎トマトオウムの応答：キュルルッ！とまと・・
            // サンマルツァーノトマトオウムの応答：キュルルッ！すりじゃやわるだなぷらまって
            // フィオレンティーノトマトオウムの応答：キュルルッ！すとりとじとゃとやとわとるとだとなとぷとらとことっとて
            // グリーンボールキャベツオウムの応答：キュルルッ！りじゃやわるだなぷらこって
            // サボイキャベツオウムの応答：キュルルッ！りじゃやわるだなぷらこって
            // サボイキャベツオウムの応答：キュルルッ！てっこらぷなだるわやゃじり
            // ロマネスコオウムの応答：キュルルッ！すすりりじじゃゃややわわるるだだななぷぷららここっってて
        }
    }

    /**
     * オウムを希望の個数だけ仕入れる。
     * @param patrrotsNum 仕入れ個数
     * @return 仕入れたオウム達
     */
    private static List<Parrot> getParrots(int patrrotsNum)
    {
        List<Parrot> parrots = new ArrayList<>();
        for (int i = 0; i < patrrotsNum; i++)
        {
            Parrot parrot;
            int rand = (int)(Math.random() * 10); // 優先順位注意：castは*よりも評価の優先度が高いため(int)Math.random() * 10だと「(int)Math.random()」の評価結果に対して10をかける、という意味になってしまう
            switch (rand % 3)
            {
            case 0:
                parrot = getTomatoParrot();
                break;
            case 1:
                parrot = getCabbageParrot();
                break;
            case 2:
                parrot = new RomanescoParrot();
                break;
            default:
                throw new IllegalStateException("ここに入ったらバグ！");
            }
            parrots.add(parrot);
        }
        return parrots;
    }

    /**
     * トマトオウムを仕入れる。
     * @return 仕入れたオウム
     */
    private static TomatoParrot getTomatoParrot()
    {
        int rand = (int)(Math.random() * 10);
        switch (rand % 3)
        {
        case 0:
            return new MomotarouTomatoParrot();
        case 1:
            return new SanMarzanoTomatoParrot();
        case 2:
            return new FiorentinoTomatoParrot();
        default:
            throw new IllegalStateException("ここに入ったらバグ！");
        }
    }

    /**
     * キャベツオウムを仕入れる。
     * @return 仕入れたオウム
     */
    private static CabbageParrot getCabbageParrot()
    {
        int rand = (int)(Math.random() * 10);
        switch (rand % 2)
        {
        case 0:
            return new CannonballCabbage();
        case 1:
            return new SavoyCabbageParrot();
        default:
            throw new IllegalStateException("ここに入ったらバグ！");
        }
    }
}
/**
 * オウムclass
 * @author kinjouhiroaki
 */
abstract class Parrot
{
    // field
    private String species;
    /**
     * constractor
     * @param species
     */
    public Parrot(String species)
    {
        this.species = species;
    }
    /**
     * 種を返す
     * @return 種
     */
    public String getSpecies()
    {
        return species;
    }
    /**
     * おうむ返しをする
     * @param words かけた言葉
     * @return 返答
     */
    public String reply(String words)
    {
        String censoredWords = (words != null) ? words : "";
        return "キュルルッ！" + replySub(censoredWords);
    }
    /**
     * 各種オウムの固有の応答処理を行う。
     * @param words かけた言葉
     * @return 返答
     */
    abstract protected String replySub(String words);
}
/**
 * トマトオウムclass
 * @author kinjouhiroaki
 */
abstract class TomatoParrot extends Parrot
{
    // constructor
    protected TomatoParrot(String species)
    {
        super(species);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    protected String replySub(String words) {
        return willReplyProperly(words) ? tomatoReply(words) : elseReply(words);
    }
    /**
     * トマトオウム固有の返し
     * @param words かけた言葉
     * @return 返答
     */
    protected String tomatoReply(String words)
    {
        return words.replaceAll("[あいうえお]", "と").replaceAll("[かきくけこ]", "ま");
    }
    /**
     * 子classが種固有の処理をしないか
     * @return boolean
     */
    abstract protected boolean willReplyProperly(String words);
    /**
     * 子class固有の処理
     * @param words かけた言葉
     * @return 返答
     */
    abstract protected String elseReply(String words);
}
/**
 * 桃太郎オウムclass
 * @author kinjouhiroaki
 *
 */
class MomotarouTomatoParrot extends TomatoParrot
{
    // constractor
    public MomotarouTomatoParrot()
    {
        super("桃太郎トマトオウム");
    }
    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean willReplyProperly(String words) {
        return (words.length() <= 5);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    protected String elseReply(String words) {
        return "とまと・・";
    }
}
/**
 * サンマルツァーノトマトオウムclass
 * @author kinjouhiroaki
 *
 */
class SanMarzanoTomatoParrot extends TomatoParrot
{
    // constractor
    public SanMarzanoTomatoParrot()
    {
        super("サンマルツァーノトマトオウム");
    }
    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean willReplyProperly(String words) {
        return (words.length() >= 10);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    protected String elseReply(String words) {
        return "まえからよんでもうしろからとまと";
    }
}
class FiorentinoTomatoParrot extends TomatoParrot
{
    // constructor
    public FiorentinoTomatoParrot()
    {
        super("フィオレンティーノトマトオウム");
    }
    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean willReplyProperly(String words) {
        return (words.matches(".*[とま].*"));
    }
    /**
     * {@inheritDoc}
     */
    @Override
    protected String elseReply(String words) {
        return (String.join("と", words.split("")));
    }
}
abstract class CabbageParrot extends Parrot
{
    // constructor
    protected CabbageParrot(String species)
    {
        super(species);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    protected String replySub(String words) {
        return childReply(cabbageReply(words));
    }
    /**
     * キャベツオウム固有の返答
     * @param words かけた言葉
     * @return 返答
     */
    protected String cabbageReply(String words) {
        return words.substring(1);
    }
    /**
     * 子オウム固有の返答
     * @param words かけた言葉
     * @return 返答
     */
    protected abstract String childReply(String words);
}
/**
 * グリーンボールキャベツオウムclass
 * @author kinjouhiroaki
 *
 */
class CannonballCabbage extends CabbageParrot
{
    // constructor
    public CannonballCabbage()
    {
        super("グリーンボールキャベツオウム");
    }
    /**
     * {@inheritDoc}
     */
    @Override
    protected String childReply(String words) {
        return words;
    }
}
/**
 * サボイキャベツオウムclass
 * @author kinjouhiroaki
 *
 */
class SavoyCabbageParrot extends CabbageParrot
{
    // constructor
    public SavoyCabbageParrot() {
        super("サボイキャベツオウム");
    }
    /**
     * {@inheritDoc}
     */
    @Override
    protected String childReply(String words) {
        return ((int)(Math.random() * 10) % 2 == 0) ? (new StringBuilder(words).reverse().toString()) : words;
    }
}

class RomanescoParrot extends Parrot
{
    // constructor
    public RomanescoParrot()
    {
        super("ロマネスコオウム");
    }
    /**
     * {@inheritDoc}
     */
    @Override
    protected String replySub(String words) {
        return words.replaceAll(".", "$0$0");
    }
}
