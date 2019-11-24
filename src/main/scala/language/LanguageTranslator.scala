import scalaj.http.{Http, HttpResponse, HttpRequest}
//import org.json4s._
//import org.json4s.JsonDSL._
//import org.json4s.jackson.JsonMethods._

package language {
  class LanguageTranslator  {

    val base_url : String = "https://translate.yandex.net/api/v1.5/tr.json"
    val api_key : String = "trnsl.1.1.20191123T042847Z.9cbe09e68450f11a.6a453d0246373470816ee73d70fa34bb7ae9d0fc"

    def translate(text: String, from_lang : String = "", target_lang: String = "en"): String = {
      var lang = target_lang;
      if (from_lang != "") {
        lang = from_lang + "-" + target_lang
      }

      var request: HttpRequest = Http(base_url + "/translate")
        .method("POST")
        .params(
          Seq(
            "key" -> api_key,
            "lang" -> lang,
            "text" -> text
          )
        )
      var response :  HttpResponse[String] = request.asString
      return response.body
    }
  }

  case class ResponseTranslate(code : String, lang : String, text : Array[String])
}
