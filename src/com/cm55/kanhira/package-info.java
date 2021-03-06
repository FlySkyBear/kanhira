/**
 * KAKASIの辞書を流用して、漢字->ひらがな変換を行うライブラリ
 * <p>
 * かかし(KAKASI）やら、なまず（NAMAZU）やらSKKについては検索して欲しい。かなり昔からあるフリーの日本語変換ライブラリであり、
 * これは、その辞書を流用し、漢字->ひらがな変換を行うものである。KAWAO, Tomoyukiという人のKAKASI/JAVAというライブラリを
 * 元としているが、かなり変更している。
 * </p>
 * <h2>基本的な使い方</h2>
 * <p>
 * 基本としては、{@link MainTest}に示したように、「dict/kakasidict」としてKAKASIの辞書があるものとし、それを読み込んだ後に、
 * 漢字->ひらがな変換を行う（ちなみに、kakasidictはEUCである。UTFに変換してはみたものの、なぜかうまくいかなかった）。
 * しかし、当然のことながら実際の現場ではこんなことはやっていられないだろう。つまり、
 * </p>
 * <ul>
 * <li>kakasidictのようなテキストファイルのメンテナンスはできない。
 * <li>辞書をデータベースに格納し、自由に追加・修正したい
 * </ul>
 * <p>
 * という要望があると思われる。
 * </p>
 * <h2>辞書インターフェース{@link KanwaDict}</h2>
 * <p>
 * {@link MainTest}の例でわかるが、基本的に辞書は{@link KanwaDict}というインターフェースの実装が必要になる。この例では、「dict/kakasidict」を
 * 読み込んで辞書を構成しているに過ぎない。この辞書を元に{@link Kanhira}では漢字-->ひらがな変換を行っている。
 * </p>
 * <p>
 * 辞書では、熟語の最初の一文字を指定すると、その文字から開始する登録済の熟語のリスト{@link KanjiYomiList}が返される。例えば、「悪」を指定すると、
 * 「代官」「巧み」「い」といった{@link KanjiYomi}オブジェクトのリストであり、入力された文字列に対して最長一致で検索され、対応するよみが返されることになる。
 * </p>
 * <h2>{@link KanjiYomiMap}</h2>
 * <p>
 * 最初に戻り、{@link KakasiDictReader}を使用して「dict/kakasidict」を読み込むと、{@link KanjiYomiMap}が返されるが、
 * これは{@link KanjiYomiMap}を実装しているので、そのまま辞書として使用できるほか、追加登録等も行うことができる。
 * また、データベース等に登録したい場合には、ここからデータを得ることができる。
 * </p>
 */
package com.cm55.kanhira;
