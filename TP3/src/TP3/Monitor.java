package TP3;

public class Monitor {
	String[] buffer = new String[2];
	boolean available = true;
	
	public synchronized void write(String leTexte){
		//tant que la ressource n'est pas libre : attend
		while(available == false){
			try{wait();}
				catch(InterruptedException e){	
					System.out.println("Erreur : " + e+"\n");
				}
			}
		//si libre, on écrit
		available = false;
		notifyAll();
		boolean fait = true;
		for(int i = 0; i<buffer.length;i++){
			if(buffer[i]==null){
				fait = false;
				buffer[i]= leTexte;
				System.out.println("Prod : J'ai écrit dans le tableau à la case "+ i +" "+ leTexte);
				break;
			}
		}
		if(fait == true){
			System.out.println("Je peux pas écrire");
		}
		available = true;
		notifyAll();
	}
	
	public synchronized void read(){
		//tant que la ressource n'est pas libre : attend
		while(available == false){
			try{wait();}
			catch(InterruptedException e){
				System.out.println("Erreur : " + e+"\n");
			}
		}
		//si libre, on la lit
		available = false;
		notifyAll();
		for(int j =0;j<buffer.length;j++){
			if(buffer[j]!=null){
				System.out.print("Cons : Je lis à la case " + j +" : "+ buffer[j]+"\n");
				buffer[j] = null;
			}
		}
		System.out.println("J'ai finis de lire");
		available = true;
		notifyAll();
	}
}
