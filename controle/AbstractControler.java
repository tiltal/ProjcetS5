package controle;

import donneesDynamique.AbstractModel;

/**
 * 
 */
public class AbstractControler {

    /**
     * Default constructor
     */
    public AbstractControler() {
    }

    /**
     * 
     */
    private AbstractModel model;


    /**
     * @param AbstractModel
     */
    public void AbstractControler(AbstractModel model) {
        this.model = model;
    }

}