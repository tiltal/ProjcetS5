package controle;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import affichage.CaptorManage;
import donneesDynamique.Captor;


public class CaptorManagerControler implements TreeSelectionListener{

	CaptorManage vue;
	
	
	public CaptorManagerControler(CaptorManage vue) {
		this.vue = vue;
		this.vue.getTree().addTreeSelectionListener(this);
		
	}
	@SuppressWarnings("deprecation")
	@Override
	public void valueChanged(TreeSelectionEvent arg0) {
		
		Object o = vue.getTree().getLastSelectedPathComponent();
		if (o != null) {
			o = ((DefaultMutableTreeNode)o).getUserObject();
			if (o instanceof Captor) {
				vue.getModel().setSelectedCaptor((Captor)o);
				System.out.println("captor changed");
				vue.update(null, o);
				vue.getTree().addTreeSelectionListener(this);
			}
		}
		
		
		
	}

}
