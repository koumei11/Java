package study.classes;

import java.util.Arrays;

public class Misc {

	public static void main(String[] args) {
		// 入れ子の三項演算子。argsの引数は実行→実行の構成から引数タブから引数を入れて実行する
		String seiseki = Integer.parseInt(args[0]) < 60 ? "落第" : (Integer.parseInt(args[0]) < 80 ? "合格" : "優秀");
		System.out.println(seiseki);

		String[] array = new String[]{"a", "b", "e", "s", "h", "i"};
		String str = "";
		// 通常のfor文を使った場合
		for(int i = 0; i < array.length; i++) {
			str += array[i];
			if (i != array.length - 1) {
				str += ",";
			}
		}
		System.out.println(str);
		str = "";
		int num = 0;
		// foreachを使った場合
		// 今回のように配列要素をカンマで繋げるといった場合、最後の要素がどうしてもネックになる
		// そこで変数numを作っているがそのスコープが問題となる
		// 普通のfor文のiとは違ってfor文が終了してもnumがmain関数が終わるまで残り続けてしまう
		// 結果、メモリを圧迫してしまう。配列を回す時は必ずしもforeachが言い訳ではない
		for(String c : array) {
			str += c;
			if (num != array.length - 1) {
				str += ",";
			}
			num++;
		}
		System.out.println(str);
		// +での文字列結合は結合するたびに新たなオブジェクトを生成しているので速度的には速いとは言えない
		// StringBuilderはある領域を確保して(文字列バッファ（可変の文字列）)そこに文字列を追加してるだけなので高速
		// これくらいならほとんど変わらないが大規模になってくると違いが如実に現れるため文字列連結の場合はStringBuilderを使うのが良い
		// ただしスレッドセーフではないのでマルチスレッドを考慮するような場合にはStringBufferを使う(ただしStringBuilderよりも速度は落ちる)
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < array.length; i++) {
			// appendのなかで三項演算子により配列の最後かを判定している
			sb.append(array[i]).append(i != array.length - 1 ? "," : "");
		}
		System.out.println(sb.toString());
		// Java8以降。streamの処理には大きく分けて変換、集計、フィルタリングの3つの機能がある。これは集計。
		// aはaccumrater、bは配列の要素が入ってくる
		// この例では最初、aは"a"、bは"b"。二回目ではaは"a,b"、bは"e"。三回目ではaは"a,b,e"、bは"s"。以降同じ流れで続いていく。
		// OptionalもJava8で追加されたものでこれをつけた変数がnullかもしれないことを明示的に示すもの
		// getを使うことでOptionalの値を取り出せる
		String result1 = Arrays.stream(array).reduce((a, b) -> a + "," + b).get();
		System.out.println(result1);
//		Optional<String> result = Arrays.stream(array).reduce((a, b) -> a + "," + b);
//		System.out.println(result.get());

		// 色々やってきたがjoinを使えばたった一行で簡単に上記の結果を得ることができる。第一引数がデリミタ、第二引数が配列。
		System.out.println(String.join(",", array));
	}
}
