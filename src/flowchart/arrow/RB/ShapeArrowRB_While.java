/*
 * Copyright (c) 2015 Instituto Politecnico de Tomar. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 */
//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: 
//::                                                                         ::
//::     Antonio Manuel Rodrigues Manso                                      ::
//::                                                                         ::
//::     I N S T I T U T O    P O L I T E C N I C O   D E   T O M A R        ::
//::     Escola Superior de Tecnologia de Tomar                              ::
//::     e-mail: manso@ipt.pt                                                ::
//::     url   : http://orion.ipt.pt/~manso                                  ::
//::                                                                         ::
//::     This software was build with the purpose of investigate and         ::
//::     learning.                                                           ::
//::                                                                         ::
//::                                                               (c)2015   ::
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//////////////////////////////////////////////////////////////////////////////
package flowchart.arrow.RB;

import ui.FProperties;
import i18n.Fi18N;
import i18n.FkeyWord;
import flowchart.decide.While_Do;
import flowchart.decide.forNext.For_Next;
import flowchart.shape.BorderFlowChart;
import flowchart.utils.UtilsFlowchart;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Polygon;

/**
 *
 * @author ZULU
 */
public class ShapeArrowRB_While extends BorderFlowChart {

    /**
     * Creates a line border with the specified color, thickness, and corner
     * shape.
     *
     * @param color the color of the border
     */
    public ShapeArrowRB_While(Color color) {
        super(color);
    }

    /**
     * Paints the border for the specified component with the specified position
     * and size.
     *
     * @param c the component for which this border is being painted
     * @param g the paint graphics
     * @param x the x position of the painted border
     * @param y the y position of the painted border
     * @param width the width of the painted border
     * @param fillColor
     * @param height the height of the painted border
     */
    @Override
    public void paint(Graphics g, int x, int y, int width, int height, Color fillColor) {

        int S = getBorderSize() / 2 + 1;
        int W = getBorderSize() * 4;
        int x2 = x + width;
        int y2 = y + height;

        Polygon p = new Polygon();

        p.addPoint(x2 - W + S, y + S);//inicio da seta
        p.addPoint(x2 - W, y + S / 2);//inicio da seta
        p.addPoint(x2 - W + S, y);//inicio da seta

        p.addPoint(x2, y); //2

        p.addPoint(x2, y2 - S); // 3

        p.addPoint(x + S, y2 - S); // 4

        p.addPoint(x + S, (int) (y2 - W + 3 * S)); // 5        
        p.addPoint(x, y2 - W + 4 * S); // SETA        
        p.addPoint(x + (int) (1.5 * S), y2 - W + S); // SETA
        p.addPoint(x + 3 * S, y2 - W + 4 * S); // SETA                
        p.addPoint(x + 2 * S, (int) (y2 - W + 3 * S)); // 6

        p.addPoint(x + 2 * S, y2 - 2 * S); // 7
        p.addPoint(x2 - S, y2 - 2 * S); // 8
        p.addPoint(x2 - S, y + S); // 9

        p.addPoint(p.xpoints[0], p.ypoints[0]);  //8 fechar

        g.setColor(fillColor);
        g.fillPolygon(p);

        g.setColor(Color.BLACK);
        g.drawPolygon(p);
        String txt = "";
        if (shape.next instanceof While_Do) {
            txt = FkeyWord.get("KEYWORD.while");
        }
        if (shape.next instanceof For_Next) {
            txt = FkeyWord.get("KEYWORD.for");
        }
        Dimension dimText = UtilsFlowchart.getTextDimension(txt, getLabelFont());
        drawLabel(g, txt, x+3*S, y2 - dimText.height+5);

    }

    /**
     * Reinitialize the insets parameter with this Border's current Insets.
     *
     * @param c the component for which this border insets value applies
     * @param insets the object to be reinitialized
     */
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.set(1, 1, 1, 1);
        return insets;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 201509071215L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2015  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////
}
