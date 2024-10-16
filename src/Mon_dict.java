public class Mon_dict {
	private String mot;
	private String definition;
	
	String getMot(){
		return mot;
	}
	String getDefinition() {
		return definition;
	}
	void setDefinition(String def) {
		this.definition=def;
	}
	void setMot(String m) {
		this.mot=m;
	}
	boolean synonyme( Mon_dict mot) {
		if(this.definition.equals(mot.definition)) {
			return true;
		}else {
			return false;
		}
	}
	public Mon_dict(String m,String def) {
		this.mot=m;
		this.definition=def;
	}
	
	 public static void main(String args[]) {
			Mon_dict m1=new Mon_dict("pomme","fruits");
			Mon_dict m2=new Mon_dict("oiseau","animal");
			Mon_dict m3=new Mon_dict("banane","fruits");
			Dictionnaire d=new Dictionnaire(12,"larousse");
			
			d.ajouter_mot(m1);
			d.ajouter_mot(m2);
			d.ajouter_mot(m3);
			d.lister_dict();
			d.trier();
			System.out.println(m1.synonyme(m3));
			System.out.println(m1.synonyme(m2));
			d.supprimer(m3);
			d.lister_dict();
		}
	
}

