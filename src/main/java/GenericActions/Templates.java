package GenericActions;

public class Templates {

	public static String jsonPrettyFormat(String jsonBody) {
		return "<pre>"+jsonBody.replace("\n", "<br>")+"</pre>";
	}
}
