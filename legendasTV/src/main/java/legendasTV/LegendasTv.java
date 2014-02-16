package legendasTV;

import webGrude.Browser;
import webGrude.annotations.Page;

@Page("http://legendas.tv/")
public class LegendasTv {

	public static void main(final String[] args) {
		final LegendasTv legendasTv = Browser.open(LegendasTv.class);
		System.out.println(legendasTv.destaquesDaSemana.destaques.get(0).linkPraLegenda.href);
	}
	
	public DestaquesDaSemana destaquesDaSemana;
	
}