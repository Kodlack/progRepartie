package TP3;

public class Consumer extends Thread implements Runnable{
	Monitor boiteMail;
	
	public Consumer(Monitor m){
		boiteMail = m;
	}
	
	@Override
	public void run() {
		try {
			sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boiteMail.read();
	}

}
