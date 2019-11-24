import language.LanguageTranslator

object Main extends App {
  var text_translated : String = ""

  val lang_trans = new LanguageTranslator
  text_translated = lang_trans.translate("Ayo coba lari kesini", "id")

  println(text_translated)
}
