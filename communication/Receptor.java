package communication;

import donneesDynamique.University;

/**
 * 
 */
public class Receptor {
	
	private University univ;
	
    /**
     * Default constructor
     */
    public Receptor(University univ) {
    	this.univ = univ;
    }


    /**
     * @param university 
     * @param message
     */
    public void transmettre(String message) {
        if(message.startsWith("Connexion")) {
        	connexion(message.substring(10));
        }
        else if(message.startsWith("Donnee")){
        	donnee(message.substring(7));        	
        }
        else if(message.startsWith("Deconnexion")){
        	deconnexion(message.substring(12));
        }
    }
    
    private void connexion(String message) {
    	int position = message.indexOf(' ');
    	String id = message.substring(0, position);
    	message = message.substring(position+1);
    	position = message.indexOf(':');
    	String type = message.substring(0, position);
    	message = message.substring(position+1);
    	position = message.indexOf(':');
    	String batiment = message.substring(0, position);
    	message = message.substring(position+1);
    	position = message.indexOf(':');
    	String et = message.substring(0, position);
    	@SuppressWarnings("deprecation")
		Integer etage = new Integer(et);
    	String lieu = message.substring(position+1);
    	univ.connection(id, batiment, etage, lieu, type);
    	
    			
    }
    
    private void donnee(String message) {
    	int position = message.indexOf(' ');
    	String id = message.substring(0, position);
    	String data = message.substring(position+1);
		@SuppressWarnings("deprecation")
		Float value = new Float(data);
		univ.newValue(id, value);
    }
    
    private void deconnexion(String message) {
    	univ.disconnection(message);
    	System.out.println("deconnexion");
    	System.out.println(univ);
    }

    /**
     * 
     */
    public void stop() {
        // TODO implement here
    }

}