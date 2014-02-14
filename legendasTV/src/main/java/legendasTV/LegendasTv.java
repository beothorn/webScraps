package legendasTV;

import webToJava.Browser;
import webToJava.annotations.PageURL;

@PageURL("http://legendas.tv/")
public class LegendasTv {

	public static void main(final String[] args) {
		final LegendasTv legendasTv = Browser.open(LegendasTv.class);
		System.out.println(legendasTv.destaquesDaSemana.destaques.get(0).linkPraLegenda.href);
	}
	
	public DestaquesDaSemana destaquesDaSemana;
	
}