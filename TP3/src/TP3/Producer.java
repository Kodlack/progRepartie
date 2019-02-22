package TP3;

public class Producer extends Thread implements Runnable{
	Monitor boiteMail;
	String texteAjout;
	
	public Producer(Monitor m, String txt){
		boiteMail = m;
		texteAjout = txt;
	}
	@Override
	public void run() {
		boiteMail.write(texteAjout);
	}

}
