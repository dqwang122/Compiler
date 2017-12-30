package miniJava;

import java.awt.Container;

import javax.swing.*;

import org.abego.treelayout.TreeLayout;
import org.abego.treelayout.util.DefaultConfiguration;
import org.abego.treelayout.util.DefaultTreeForTreeLayout;
import org.abego.treelayout.TreeForTreeLayout;


public class LISPtoTreeView {

    private static void showInDialog(JComponent panel) {
		JDialog dialog = new JDialog();
		Container contentPane = dialog.getContentPane();
		((JComponent) contentPane).setBorder(BorderFactory.createEmptyBorder(
				10, 10, 10, 10));
		contentPane.add(panel);
		dialog.pack();
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
		dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	private static void showInFrame(JComponent panel){
    	JFrame frame = new JFrame("Antlr AST");
    	Container contentPane = frame.getContentPane();
    	((JComponent) contentPane).setBorder(BorderFactory.createEmptyBorder(
				10, 10, 10, 10));
		contentPane.add(panel);
        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
	}

	private static TreeForTreeLayout<LISPtoTree.LISPTreeNode> getSampleTree(){
    	LISPtoTree.LISPTreeNode root = new LISPtoTree.LISPTreeNode("root", 40, 20);
		LISPtoTree.LISPTreeNode n1 = new LISPtoTree.LISPTreeNode("n1", 30, 20);
		LISPtoTree.LISPTreeNode n1_1 = new LISPtoTree.LISPTreeNode("n1.1\n(first node)", 80, 36);
		LISPtoTree.LISPTreeNode n1_2 = new LISPtoTree.LISPTreeNode("n1.2", 40, 20);
		LISPtoTree.LISPTreeNode n1_3 = new LISPtoTree.LISPTreeNode("n1.3\n(last node)", 80, 36);
		LISPtoTree.LISPTreeNode n2 = new LISPtoTree.LISPTreeNode("n2", 30, 20);
		LISPtoTree.LISPTreeNode n2_1 = new LISPtoTree.LISPTreeNode("n2", 30, 20);

		DefaultTreeForTreeLayout<LISPtoTree.LISPTreeNode> tree = new DefaultTreeForTreeLayout<>(root);
		tree.addChild(root, n1);
		tree.addChild(n1, n1_1);
		tree.addChild(n1, n1_2);
		tree.addChild(n1, n1_3);
		tree.addChild(root, n2);
		tree.addChild(n2, n2_1);

		return tree;
	}



	public static void main(String[] args) {

		// get the sample tree
		String treeName = (args.length > 0) ? args[0] : "";
		TreeForTreeLayout<LISPtoTree.LISPTreeNode> tree = getSampleTree();

		// setup the tree layout configuration
		double gapBetweenLevels = 50;
		double gapBetweenNodes = 10;
		DefaultConfiguration<LISPtoTree.LISPTreeNode> configuration = new DefaultConfiguration<>(gapBetweenLevels, gapBetweenNodes);

		// create the NodeExtentProvider for LISPtoTree.LISPTreeNode nodes
		LISPtoTree.LISPTreeNodeExtentProvider nodeExtentProvider = new LISPtoTree.LISPTreeNodeExtentProvider();


		// create the layout
		TreeLayout<LISPtoTree.LISPTreeNode> treeLayout = new TreeLayout<>(tree,	nodeExtentProvider, configuration);

		// Create a panel that draws the nodes and edges and show the panel
		LISPtoTree.LISPTreePane panel = new LISPtoTree.LISPTreePane(treeLayout);
		showInFrame(panel);
	}
}
