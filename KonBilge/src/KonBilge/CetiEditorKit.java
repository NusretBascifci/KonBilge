/*

This file is adapted from a file shared under 
the GNU license on GitHub around 2019. 
That file is no longer accessible.
https://github.com/

*/
 /*
 This file is part of KonBilge.

KonBilge is free software: you can redistribute it and/or 
modify it under the terms of the GNU General Public 
License as published by the Free Software Foundation, 
either version 3 of the License, or (at your option)
any later version.

KonBilge is distributed in the hope that it will be 
useful, but WITHOUT ANY WARRANTY; without even 
the implied warranty of MERCHANTABILITY or 
FITNESS FOR A PARTICULAR PURPOSE. 
See the GNU General Public License for more details.

You should have received a copy of the GNU General 
Public License along with Foobar. 
If not, see <https://www.gnu.org/licenses/>.
 */



package KonBilge;

/**
 *
 * @author abcDe
 */
import javax.swing.text.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.text.DefaultEditorKit;

/**
 *
 * @author OkulOgretmen
 */
public class CetiEditorKit extends StyledEditorKit {

    int sayfa = 0;
    int PAGE_WIDTH;
    protected static final int PAGE_HEIGHT = 1012;
    protected static final int PAGE_INSET = 50;
    protected static final Insets PAGE_MARGIN = new Insets(20, 50, 50, 30);//default u 20,20,50,30
    //(üst girinti,soldan girinti,alttan girinti, sağdan girinti)
    protected static final Color BACKGROUND = Color.orange;
    private ViewFactory factory;

    public CetiEditorKit() {
        factory = new PagingViewFactory();

    }

    public ViewFactory getViewFactory() {
        return factory;
    }

    protected int calculatePageBreak(int pageNumber) {
        int pageBreak = (pageNumber * PAGE_HEIGHT) - PAGE_INSET - PAGE_MARGIN.bottom;
        return pageBreak;
    }

    private class PagingViewFactory implements ViewFactory {

        public View create(Element elem) {
            String kind = elem.getName();
            if (kind != null) {
                if (kind.equals(AbstractDocument.ContentElementName)) {
                    return new LabelView(elem);
                } else if (kind.equals(AbstractDocument.ParagraphElementName)) {
                    return new PagingParagraphView(elem);
                } else if (kind.equals(AbstractDocument.SectionElementName)) {
                    return new SectionView(elem, View.Y_AXIS);
                } else if (kind.equals(StyleConstants.ComponentElementName)) {
                    return new ComponentView(elem);
                } else if (kind.equals(StyleConstants.IconElementName)) {
                    return new IconView(elem);
                }
            }
// default to text display
            return new LabelView(elem);
        }
    }

    private class SectionView extends BoxView {

        private int pageNumber;

        /**
         * Creates a view from an element that spans the supplied axis
         *
         * @param element
         * @param axis
         */
        public SectionView(Element element, int axis) {
            super(element, axis);

            setInsets((short) (0),
                    (short) (PAGE_INSET + PAGE_MARGIN.left),
                    (short) (0),
                    (short) (PAGE_INSET + PAGE_MARGIN.right));
        }

        protected void layout(int width, int height) {

            width = PAGE_WIDTH - 2 * PAGE_INSET - PAGE_MARGIN.left - PAGE_MARGIN.right;

            super.layout(width, height);
        }

        public float getPreferredSpan(int axis) {
            float span = 0;
            if (axis == View.X_AXIS) {
                span = PAGE_WIDTH;
            } else {
                span = pageNumber * PAGE_HEIGHT;
                sayfa = pageNumber;
            }

            return span;

        }

        public float getMinimumSpan(int axis) {
            return getPreferredSpan(axis);
        }

        public float getMaximumSpan(int axis) {
            return getPreferredSpan(axis);
        }

        protected void layoutMajorAxis(int targetSpan, int axis, int[] offsets, int[] spans) {
            super.layoutMajorAxis(targetSpan, axis, offsets, spans);

            int totalOffset = PAGE_INSET + PAGE_MARGIN.top;
            int pageBreak;
            pageNumber = 1;
            PagingParagraphView view;

            for (int i = 0; i < offsets.length; i++) {
                offsets[i] = totalOffset;
                pageBreak = calculatePageBreak(pageNumber);

                view = (PagingParagraphView) getView(i);
                view.setPargraphOffset(totalOffset);
                view.setStartPage(pageNumber);

                if ((spans[i] + offsets[i]) > pageBreak) {
                    view.layout(view.getWidth(), getHeight());
                    pageNumber = view.getEndPage();

                    spans[i] += view.getAdjustedSpan();
                }

                totalOffset = offsets[i] + spans[i];

            }
        }

        public void paint(Graphics g, Shape a) {
            super.paint(g, a);

            Rectangle alloc = (a instanceof Rectangle) ? (Rectangle) a : a.getBounds();
            Rectangle page = new Rectangle(alloc.x, alloc.y, PAGE_WIDTH, PAGE_HEIGHT);
            g.setColor(Color.BLACK);
            Font myFont = new Font("Times New Roman", Font.PLAIN, 22);

            g.setFont(myFont);

            for (int i = 0; i < pageNumber; i++) {
                page.y = alloc.y + PAGE_HEIGHT * i;
                if (page.intersects(alloc)) {
                    paintPageFrame(g, page);
                    g.setColor(Color.BLACK);

                }
                g.drawString("          Sayfa : " + Integer.toString(i + 1) + "/" + Integer.toString(pageNumber), PAGE_WIDTH / 8 * 3, (i + 1) * PAGE_HEIGHT);
//sayfa numaraları ekleniyor
            }

// Fills in any unpainted areas
            if ((alloc.y + alloc.height) > (page.y + page.height)) {
                g.setColor(BACKGROUND);
                g.fillRect(page.x, page.y + page.height, page.width, alloc.height / 2 - page.height);

            }

        }

        private void paintPageFrame(Graphics g, Rectangle page) {
            Color oldColor = g.getColor();

//borders
            g.setColor(BACKGROUND);
            g.fillRect(page.x, page.y, page.width, PAGE_INSET);
            g.fillRect(page.x, page.y, PAGE_INSET, page.height);
            g.fillRect(page.x, page.y + page.height - PAGE_INSET, page.width, PAGE_INSET);
            g.fillRect(page.x + page.width - PAGE_INSET, page.y, PAGE_INSET, page.height);

//frame
            g.setColor(Color.black);
            g.drawRect(page.x + PAGE_INSET,
                    page.y + PAGE_INSET,
                    page.width - 2 * PAGE_INSET,
                    page.height - 2 * PAGE_INSET);

//shadow
            g.fillRect(page.x + page.width - PAGE_INSET,
                    page.y + PAGE_INSET + 4,
                    4,
                    page.height - 2 * PAGE_INSET);
            g.fillRect(page.x + PAGE_INSET + 4,
                    page.y + page.height - PAGE_INSET,
                    page.width - 2 * PAGE_INSET,
                    4);

            g.setColor(oldColor);

        }

    }

    private class PagingParagraphView extends ParagraphView {

        private int startPage, endPage;
        private int adjustedSpan;
        private int paragraphOffset;

        public PagingParagraphView(Element elem) {
            super(elem);

            startPage = 1;
            endPage = 1;
            adjustedSpan = 0;
            paragraphOffset = 0;

        }

        public void setStartPage(int sp) {
            startPage = sp;
        }

        public int getEndPage() {
            return endPage;
        }

        public int getAdjustedSpan() {
            return adjustedSpan;
        }

        public void setPargraphOffset(int po) {
            paragraphOffset = po;
        }

        public void layout(int width, int height) {

            super.layout(width, height);
        }

        protected void layoutMajorAxis(int targetSpan, int axis, int[] offsets, int[] spans) {
            super.layoutMajorAxis(targetSpan, axis, offsets, spans);

            if (paragraphOffset != 0) {
                endPage = startPage;
                int relativeBreak = calculatePageBreak(endPage) - paragraphOffset;
                int correctedOffset;
                adjustedSpan = 0;

                for (int i = 0; i < offsets.length; i++) {
                // determine the location of the page break
                    if (offsets[i] + spans[i] > relativeBreak) {
                        correctedOffset = relativeBreak
                                + PAGE_MARGIN.bottom + (2 * PAGE_INSET) + PAGE_MARGIN.top
                                - offsets[i];

                        for (int j = i; j < offsets.length; j++) {
                            offsets[j] += correctedOffset;
                        }

                        adjustedSpan += correctedOffset;
                        endPage++;
                        relativeBreak = calculatePageBreak(endPage) - paragraphOffset;
                    }
                }
            }
        }
    }
}
