object Patterns {
  any match {
    case 1             => //定数パターン
    case _: Int        => //型付きパターン
    case (_, _)        => //タプルパターン
    case List(_, _, _) => //固定長シーケンスパターン
    case List(_, _*)   => //_*で任意長シーケンスパターン
    case Some(x)       => //コンストラクタパターン
    case x             => //変数パターン
    case x @ (_, _)    => //変数束縛パターン
    case x if x.length > 0 => // パターン + if
    case _             => //ワイルドカードパターン
  }
}