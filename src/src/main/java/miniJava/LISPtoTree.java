package miniJava;

import org.abego.treelayout.NodeExtentProvider;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;


import javax.swing.JComponent;

import org.abego.treelayout.TreeLayout;
import org.abego.treelayout.TreeForTreeLayout;

public class LISPtoTree {
    public static class LISPTreeNode {
        private final String text;
        private final int height;
        private final int width;
        public LISPTreeNode(String text, int width, int height) {
            this.text = text;
            this.width = width;
            this.height = height;
        }
    }

    public static class LISPTreeNodeExtentProvider implements
            NodeExtentProvider<LISPTreeNode> {
        @Override
        public double getWidth(LISPTreeNode treeNode) {
            return treeNode.width;
        }
        @Override
        public double getHeight(LISPTreeNode treeNode) {
            return treeNode.height;
        }
    }

    public static class LISPTreePane extends JComponent {
	    private final TreeLayout<LISPTreeNode> treeLayout;
        private TreeForTreeLayout<LISPTreeNode> getTree() {
            return treeLayout.getTree();
        }

        private Iterable<LISPTreeNode> getChildren(LISPTreeNode parent) {
            return getTree().getChildren(parent);
        }

        private Rectangle2D.Double getBoundsOfNode(LISPTreeNode node) {
            return treeLayout.getNodeBounds().get(node);
        }


        public LISPTreePane(TreeLayout<LISPTreeNode> treeLayout) {
            this.treeLayout = treeLayout;
            Dimension size = treeLayout.getBounds().getBounds().getSize();
            setPreferredSize(size);
        }


        private final static int ARC_SIZE = 10;
        private final static Color BOX_COLOR = Color.orange;
        private final static Color BORDER_COLOR = Color.darkGray;
        private final static Color TEXT_COLOR = Color.black;

        private void paintEdges(Graphics g, LISPTreeNode parent) {
            if (!getTree().isLeaf(parent)) {
                Rectangle2D.Double b1 = getBoundsOfNode(parent);
                double x1 = b1.getCenterX();
                double y1 = b1.getCenterY();
                for (LISPTreeNode child : getChildren(parent)) {
                    Rectangle2D.Double b2 = getBoundsOfNode(child);
                    g.drawLine((int) x1, (int) (y1+b1.getHeight()/2), (int) b2.getCenterX(),
                            (int) (b2.getCenterY()-b2.getHeight()/2));
                    paintEdges(g, child);
                }
            }
        }

        private void paintBox(Graphics g, LISPTreeNode LISPTreeNode) {
            // draw the box in the background
            g.setColor(BOX_COLOR);
            Rectangle2D.Double box = getBoundsOfNode(LISPTreeNode);
            g.fillRoundRect((int) box.x, (int) box.y, (int) box.width - 1,
                    (int) box.height - 1, ARC_SIZE, ARC_SIZE);
            g.setColor(BORDER_COLOR);
            g.drawRoundRect((int) box.x, (int) box.y, (int) box.width - 1,
                    (int) box.height - 1, ARC_SIZE, ARC_SIZE);

            // draw the text on top of the box (possibly multiple lines)
            g.setColor(TEXT_COLOR);
            g.setFont(new Font("TimesRoman", Font.BOLD, 15));
            String[] lines = LISPTreeNode.text.split("\n");
            FontMetrics m = getFontMetrics(getFont());
            int x = (int) box.x + ARC_SIZE / 2;
            int y = (int) box.y + m.getAscent() + m.getLeading() + 3;
            for (int i = 0; i < lines.length; i++) {
                g.drawString(lines[i], x, y);
                y += m.getHeight();
            }
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            paintEdges(g, getTree().getRoot());

            // paint the boxes
            for (LISPTreeNode LISPTreeNode : treeLayout.getNodeBounds().keySet()) {
                paintBox(g, LISPTreeNode);
            }
        }
    }

}
