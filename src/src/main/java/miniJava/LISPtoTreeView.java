package miniJava;

import java.awt.Container;
import java.awt.Font;
import java.awt.FontMetrics;

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

		JScrollPane jsp = new JScrollPane(panel);
		contentPane.add(jsp);

		jsp.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);


        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 500);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
	}

	private static int getboxwidth(String str){
		Font f = new Font("TimesRoman", Font.BOLD, 16);
    	FontMetrics fm = sun.font.FontDesignMetrics.getMetrics(f);

		int length = 0;
		if(str.contains("\n")){
			String[] parts = str.split("\n");
			int lm = parts[0].length() > parts[1].length() ? 0 : 1;
			length = fm.stringWidth(parts[lm]) + 5;
		}
		else{
			length = fm.stringWidth(str) + 5;
		}
		if(length < 30)
			length = 30;

		return length;
	}

	private static int getboxheight(String str){
		Font f = new Font("TimesRoman", Font.BOLD, 16);
    	FontMetrics fm = sun.font.FontDesignMetrics.getMetrics(f);

		int heigth = 0;
		if(str.contains("\n")){
			String[] parts = str.split("\n");
			heigth = parts.length;
		}
		else{
			heigth = 1;
		}

		return heigth * (fm.getHeight());
	}

	private static int LISP2Tree(DefaultTreeForTreeLayout<LISPtoTree.LISPTreeNode> tree, String[] parts, int pos, LISPtoTree.LISPTreeNode parent){
		if(pos ==-1 || pos >= parts.length)
			return -1;
		if(parts[pos].equals("(")){
			while(pos != -1 && !parts[pos].equals(")")){
				pos ++;
				LISPtoTree.LISPTreeNode child = new LISPtoTree.LISPTreeNode(parts[pos], getboxwidth(parts[pos]), getboxheight(parts[pos]));
				tree.addChild(parent, child);
				pos = LISP2Tree(tree, parts, pos+1, child);
			}
			return pos + 1;
		}
		else if(parts[pos].equals(",") || parts[pos].equals(")")){
			return pos;
		}
		else{
			return -1;
		}
	}

	public static void ShowLISPTree(String str){
		String [] parts = str.split("\\s+");
		if(parts.length < 1 || parts[0].equals("(") || parts[0].equals(")") || parts[0].equals(",")){
			System.out.println("AST LISP is wrong!");
			return ;
		}

		LISPtoTree.LISPTreeNode root = new LISPtoTree.LISPTreeNode(parts[0], getboxwidth(parts[0]), getboxheight(parts[0]));
		DefaultTreeForTreeLayout<LISPtoTree.LISPTreeNode> tree = new DefaultTreeForTreeLayout<>(root);

		int pos = 1;
		if(pos < parts.length && parts[pos].equals("(")){
			while(pos != -1 && !parts[pos].equals(")")){
				pos ++;
				LISPtoTree.LISPTreeNode child = new LISPtoTree.LISPTreeNode(parts[pos], getboxwidth(parts[pos]), getboxheight(parts[pos]));
				tree.addChild(root, child);
				pos = LISP2Tree(tree, parts, pos+1, child);
			}
		}



//		TreeForTreeLayout<LISPtoTree.LISPTreeNode> tree = LISP2Tree(parts, 0);

		// setup the tree layout configuration
		double gapBetweenLevels = 100;
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



	public static void main(String[] args) {
		ShowLISPTree("MainClass ( Identifier:BinarySearch , Identifier:a , Print ( Call ( NewObject ( Identifier:BS ) , Identifier:Start  , Number:20 )  )  )");
	}
}
