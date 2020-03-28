package study1.chapter1.unit3;

import java.util.ArrayList;
import java.util.List;

public class Program03Kadai1 {
    public static void main(String[] args)
    {
        List<Musician> orchestra = new ArrayList<>();
        orchestra.add(new Pianistar());
        orchestra.add(new Violinist());
        orchestra.add(new Cellist());
        orchestra.add(new Trumpeter());
        orchestra.add(new Hornist());
        orchestra.add(new Percussionist());
        Conductor.conduct(orchestra);
    }
}

class Conductor
{
    public static void conduct(List<Musician> orchestra)
    {
        System.out.println("せーのっ！はいっ！");
        for (Musician member : orchestra)
        {
            System.out.println(member.play());
        }
    }
}
class Musician
{
    /**
     * 演奏する
     * @return 音
     */
    public String play()
    {
        return "ヒュ～ヒュ～♪（口笛）ドダダダ・・（足踏み）";
    }
}
class Pianistar extends Musician
{
    /**
     * {@inheritDoc}
     */
    @Override
    public String play() {
        return "ポロンポロロン♪";
    }
}
class Violinist extends Musician
{
    /**
     * {@inheritDoc}
     */
    @Override
    public String play() {
        return "ギコギコギーコ♪";
    }
}
class Cellist extends Musician
{
    /**
     * {@inheritDoc}
     */
    @Override
    public String play() {
        return "ヴォォォーーーン♪";
    }
}
class Trumpeter extends Musician
{
    /**
     * {@inheritDoc}
     */
    @Override
    public String play() {
        return "パ～ラ～～パパッ・パ～～パッ・パ～パパッパ～～♪";
    }
}
class Hornist extends Musician
{
    /**
     * {@inheritDoc}
     */
    @Override
    public String play() {
        return "パ・パ・パ・パ～ラッパ・パラッパ・パ～ラッパッ♪";
    }
}
class Percussionist extends Musician
{
    /**
     * {@inheritDoc}
     */
    @Override
    public String play() {
        return "だっだーん♪ボヨヨンボヨヨン♪";
    }
}